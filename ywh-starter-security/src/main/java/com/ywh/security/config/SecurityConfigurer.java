package com.ywh.security.config;

import com.ywh.security.service.impl.SecurityUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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


    private SecurityUserDetailsServiceImpl securityUserDetailsService;


    @Autowired
    public SecurityConfigurer(SecurityUserDetailsServiceImpl securityUserDetailsService) {
        this.securityUserDetailsService = securityUserDetailsService;
    }

    /**
     * 用户信息配置
     * @param auth 用户信息管理器
     * @throws Exception 异常信息
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(this.securityUserDetailsService)
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
                // 设置最多一个用户登录，如果第二个用户登陆则第一用户被踢出，并跳转到登陆页面
                .sessionManagement().maximumSessions(1).expiredUrl("/login.html");
        httpSecurity
                // 开始认证
                .authorizeRequests()
                // 对静态文件和登陆页面放行
                .antMatchers("/static/**").permitAll()
                .antMatchers("/auth/**").permitAll()
                .antMatchers("/login.html").permitAll()
                // 其他请求需要认证登陆
                .anyRequest().authenticated();
        httpSecurity
                // 表单登陆
                .formLogin()
                // 设置跳转的登陆页面
                .loginPage("/login.html")
                //.failureUrl("/auth/login?error") 设置如果登陆失败跳转到哪个页面
//                .successHandler((request, response, authentication) -> {
//                    System.out.println("登陆成功");
//                })
                // security默认使用的就是login路径认证，如果想使用自定义自行修改就可以了
                .loginProcessingUrl("/login")
                // 如果直接访问登录页面，则登录成功后重定向到这个页面，否则跳转到之前想要访问的页面
                .defaultSuccessUrl("/index.html");
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

    /**
     * 密码加密
     * @return 返回加密后的密码
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



}
