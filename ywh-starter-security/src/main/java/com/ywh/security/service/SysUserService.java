package com.ywh.security.service;

import com.ywh.security.entity.SysUserEntity;
import com.ywh.common.base.BaseService;
import org.springframework.security.core.AuthenticationException;


/**
 * CreateTime: 2019-01-25
 * ClassName: SysUserService
 * Package: com.ywh.security.service
 * Describe:
 *  业务逻辑的接口类
 * @author YWH
 */
public interface SysUserService extends BaseService<SysUserEntity> {


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
