package com.ywh.security.config;

import com.ywh.security.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * CreateTime: 2019-01-24 10:21
 * ClassName: SecurityConfigurer
 * Package: com.ywh.security.config
 * Describe:
 * Security的核心配置类
 *
 * @author YWH
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {


    private UserDetailsService userDetailsService;
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;


    @Autowired
    public SecurityConfigurer(UserDetailsService userDetailsService, JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter) {
        this.jwtAuthenticationTokenFilter = jwtAuthenticationTokenFilter;
        this.userDetailsService = userDetailsService;
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

        // 注入我们刚才写好的 jwt过滤器,添加在UsernamePasswordAuthenticationFilter过滤器之前
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        // 这块是配置跨域请求的
         ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = httpSecurity.authorizeRequests();
        // 让Spring security放行所有preflight request
        registry.requestMatchers(CorsUtils::isPreFlightRequest).permitAll();

        /**
         * 以下注释内容有需要可以解开,再整合vue后以下注释解开也没什么用
         */


        // 开启缓存控制头，不缓存任何内容是安全的，但是也是视情况而定，配置disable是关闭缓存控制头
//        httpSecurity
//                .headers()
//                .cacheControl()
//                .disable();
//        httpSecurity
//                // 表单登陆
//                .formLogin()
//                // 设置跳转的登陆页面
//                .loginPage("/login.html")
//                //.failureUrl("/auth/login?error") 设置如果登陆失败跳转到哪个页面
////                .successHandler((request, response, authentication) -> {
////                    System.out.println("登陆成功");
////                })
//                // security默认使用的就是login路径认证，如果想使用自定义自行修改就可以了
//                .loginProcessingUrl("/login")
//                // 如果直接访问登录页面，则登录成功后重定向到这个页面，否则跳转到之前想要访问的页面
//                .defaultSuccessUrl("/index.html");
//        httpSecurity
//                // 登出
//                .logout()
//                // 登出处理，使用security默认的logout，也可以自定义路径，实现即可
//                .logoutUrl("/logout")
//                // 登出成功后跳转到哪个页面
//                .logoutSuccessUrl("/login.html")
//                .logoutSuccessHandler((request, response, authentication) -> {
//                    //登出成功处理函数
//                    System.out.println("logout success");
//                    response.sendRedirect("/core/login.html");
//                })
//                .addLogoutHandler((request, response, authentication) ->{
//                    //登出处理函数
//                    System.out.println("logout------");
//                })
//                // 清理Session
//                .invalidateHttpSession(true);
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

    /**
     * 自定义的纯文本编码内部类
     */
    public static class CharEncoder implements PasswordEncoder {

        static CharEncoder INSTANCE = new CharEncoder();

        static CharEncoder getINSTANCE(){
            return INSTANCE;
        }

        @Override
        public String encode(CharSequence rawPassword) {
            return rawPassword.toString();
        }

        @Override
        public boolean matches(CharSequence rawPassword, String encodedPassword) {
            return rawPassword.toString().equals(encodedPassword);
        }
    }


}
