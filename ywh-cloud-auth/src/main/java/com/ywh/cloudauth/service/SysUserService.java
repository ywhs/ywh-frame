package com.ywh.cloudauth.service;

import com.ywh.cloudcommon.entity.SysUserEntity;
import org.springframework.security.core.AuthenticationException;

/**
 * CreateTime: 2019-06-30 18:33
 * ClassName: SysUserService
 * Package: com.ywh.cloudauth.service
 * Describe:
 * 用户逻辑层
 *
 * @author YWH
 */
public interface SysUserService {

    /**
     * 获取用户详细信息
     * @param username 用户名
     * @return 实体类
     */
    SysUserEntity findUserInfo(String username);

    /**
     *
     * @param username 用户名
     * @param password 密码
     * @return 登陆成功
     */
    String login(String username, String password) throws AuthenticationException;

}
