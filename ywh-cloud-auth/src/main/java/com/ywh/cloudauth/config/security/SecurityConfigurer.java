package com.ywh.cloudauth.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * CreateTime: 2019-06-30 16:55
 * ClassName: SecurityConfigurer
 * Package: com.ywh.cloudcommon.config.security
 * Describe:
 * Security配置类
 * @author YWH
 */
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;


    @Autowired
    public SecurityConfigurer(UserDetailsService userDetailsServicer) {
        this.userDetailsService = userDetailsServicer;
    }

    /**
     *  这必须手动注入spring管理，否则之后使用的时候找不到，
     *  报错信息：Field authenticate in com.ywh.security.service.impl.SysUserServiceImpl required a bean of type
     *          'org.springframework.security.authentication.AuthenticationManager' that could not be found.
     * @return AuthenticationManager
     * @throws Exception 异常信息
     */
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 用户信息配置
     * @param auth 用户信息管理器
     * @throws Exception 异常信息
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(passwordEncoder());

    }

    /**
     * 配置如何通过拦截器保护我们的请求，哪些能通过哪些不能通过,允许对特定的http请求基于安全考虑进行配置
     * @param httpSecurity http
     * @throws Exception 异常
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                // 暂时禁用csrc否则无法提交
                .csrf().disable()
                // session管理
                .sessionManagement()
                // 我们使用SessionCreationPolicy.STATELESS无状态的Session机制（即Spring不使用HTTPSession），对于所有的请求都做权限校验，
                // 这样Spring Security的拦截器会判断所有请求的Header上有没有”X-Auth-Token”。
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                // 设置最多一个用户登录，如果第二个用户登陆则第一用户被踢出，并跳转到登陆页面
                .maximumSessions(1).expiredUrl("/login.html");
        httpSecurity
                // 开始认证
                .authorizeRequests()
                // 对静态文件和登陆页面放行
                .antMatchers("/static/**").permitAll()
                .antMatchers("/auth/**").permitAll()
                .antMatchers("/login.html").permitAll()
                // 其他请求需要认证登陆
                .anyRequest().authenticated();

        // 这块是配置跨域请求的
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = httpSecurity.authorizeRequests();
        // 让Spring security放行所有preflight request
        registry.requestMatchers(CorsUtils::isPreFlightRequest).permitAll();
    }


    /**
     * 这块是配置跨域请求的
     * @return Cors过滤器
     */
    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration cors = new CorsConfiguration();
        cors.setAllowCredentials(true);
        cors.addAllowedOrigin("*");
        cors.addAllowedHeader("*");
        cors.addAllowedMethod("*");
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", cors);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }


    /**
     * 密码加密
     * @return 返回加密后的密码
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
