package com.ywh.security.service.impl;

import com.ywh.common.exception.MyException;
import com.ywh.security.dao.SysUserDao;
import com.ywh.security.entity.SecurityUserDetails;
import com.ywh.security.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * CreateTime: 2019-01-25 16:39
 * ClassName: SecurityUserDetailsServiceImpl
 * Package: com.ywh.security.service.impl
 * Describe:
 * UserDetailService的实现类
 *
 * @author YWH
 */
@Service
public class SecurityUserDetailsServiceImpl implements UserDetailsService {


    private SysUserDao sysUserDao;

    @Autowired
    public SecurityUserDetailsServiceImpl(SysUserDao sysUserDao) {
        this.sysUserDao = sysUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserEntity sysUserEntity = sysUserDao.selectByUserName(username);
        if(sysUserEntity != null){
            return new SecurityUserDetails(sysUserEntity.getSysUserPassword(),sysUserEntity.getSysUserName(),sysUserEntity.getSysUserState(),null);
        }
        throw new MyException("查无此人！！");
    }
}
