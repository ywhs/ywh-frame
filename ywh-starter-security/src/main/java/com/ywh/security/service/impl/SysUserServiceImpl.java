package com.ywh.security.service.impl;

import com.ywh.security.entity.SecurityUserDetails;
import com.ywh.security.utils.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ywh.security.entity.SysUserEntity;
import com.ywh.security.dao.SysUserDao;
import com.ywh.security.service.SysUserService;
import com.ywh.common.base.BaseServiceImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * CreateTime: 2019-01-25
 * ClassName: SysUserServiceImpl
 * Package: com.ywh.security.service.impl
 * Describe:
 *  业务逻辑接口的实现类
 * @author YWH
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysUserDao dao;

    @Autowired
    private AuthenticationManager authenticate;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * 获取用户详细信息
     * @param username 用户名
     * @return 实体类
     */
    @Override
    public SysUserEntity findUserInfo(String username) {
        return dao.selectByUserName(username);
    }

    /**
     * 用户登陆
     * @param username 用户名
     * @param password 密码
     * @return 登陆成功 返回token
     */
    @Override
    public String login(String username, String password) throws AuthenticationException {
        // 内部登录请求
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
        // 验证是否有权限
        Authentication auth = authenticate.authenticate(authRequest);
        log.debug("===============权限============" + auth);
        SecurityContextHolder.getContext().setAuthentication(auth);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        return jwtTokenUtil.generateToken(userDetails);
    }
}
