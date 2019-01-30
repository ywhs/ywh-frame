package com.ywh.security.filter;

import com.ywh.security.utils.JwtTokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CreateTime: 2019-01-29 18:15
 * ClassName: JwtAuthenticationTokenFilter
 * Package: com.ywh.security.filter
 * Describe:
 * spring的拦截器
 *
 * @author YWH
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private final static Logger log = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);

    private JwtTokenUtil jwtTokenUtil;
    private UserDetailsService userDetailsService;

    @Autowired
    public JwtAuthenticationTokenFilter(JwtTokenUtil jwtTokenUtil, UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    /**
     * 该拦截器主要的功能是，拦截请求后，判断是否携带token，如果未携带token则不予通过。
     * @param httpServletRequest http请求
     * @param httpServletResponse http响应
     * @param filterChain 拦截器
     * @throws ServletException 异常信息
     * @throws IOException 异常信息
     */
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        // 获取request中jwt token
        String authHeader = httpServletRequest.getHeader(jwtTokenUtil.getHeader());
        log.debug("authHeader:{}",authHeader);
        // 验证token是否存在
        if(authHeader != null && StringUtils.isNotEmpty(authHeader)){
            //根据token获取用户名
            String userName = jwtTokenUtil.getUsernameFromToken(authHeader);
            if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null){
                // 通过用户名 获取用户的信息
                UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
                // 验证token和用户信息是否匹配
                if(jwtTokenUtil.validateToken(authHeader,userDetails)){
                    // 然后构造UsernamePasswordAuthenticationToken对象
                    // 最后绑定到当前request中，在后面的请求中就可以获取用户信息
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }
}
