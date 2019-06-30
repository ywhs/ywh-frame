package com.ywh.cloudauth.service.impl;

import com.ywh.cloudauth.dao.sysuser.SysUserDao;
import com.ywh.cloudauth.service.SysUserService;
import com.ywh.cloudcommon.entity.SysUserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * CreateTime: 2019-06-30 18:36
 * ClassName: SysUserServiceImpl
 * Package: com.ywh.cloudauth.service.impl
 * Describe:
 * 用户sevice实现类
 *
 * @author YWH
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    private static final Logger LOG = LoggerFactory.getLogger(SysUserServiceImpl.class);

    private SysUserDao sysUserDao;

    public SysUserServiceImpl(){}

    @Autowired
    public SysUserServiceImpl(SysUserDao sysUserDao,AuthenticationManager authenticate){
        this.sysUserDao = sysUserDao;
    }

    /**
     * 获取用户详细信息
     * @param username 用户名
     * @return 实体类
     */
    @Override
    public SysUserEntity findUserInfo(String username) {
        return sysUserDao.selectByUserName(username);
    }

    /**
     * 用户登陆
     * @param username 用户名
     * @param password 密码
     * @return 登陆成功 返回token
     */
    @Override
    public String login(String username, String password) throws AuthenticationException {
        return  "登录成功";
    }

}
