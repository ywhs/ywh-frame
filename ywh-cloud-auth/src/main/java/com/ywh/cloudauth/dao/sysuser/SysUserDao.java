package com.ywh.cloudauth.dao.sysuser;

import com.ywh.cloudcommon.entity.SysUserEntity;
import org.springframework.stereotype.Repository;

/**
 * CreateTime: 2019-06-30 17:49
 * ClassName: SysUserDao
 * Package: com.ywh.cloudauth.dao.sysuser
 * Describe:
 * 用户Dao接口类
 *
 * @author YWH
 */
@Repository
public interface SysUserDao {

    /**
     *  根据用户名查询用户信息
     * @param username 用户名
     * @return 用户信息
     */
    SysUserEntity selectByUserName(String username);

}
