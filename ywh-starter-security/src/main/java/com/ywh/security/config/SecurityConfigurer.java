package com.ywh.security.config;

import com.ywh.security.service.impl.SecurityUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
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
//        auth
//                .inMemoryAuthentication()
//                .withUser("root")
//                .password("root")
//                .roles("user")
//                .and()
//                .passwordEncoder(CharEncoder.getINSTANCE());
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
                .authorizeRequests()
                .antMatchers("/example/securityTest").permitAll()
                .antMatchers(HttpMethod.POST,"/example/findAll").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin();
    }


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
