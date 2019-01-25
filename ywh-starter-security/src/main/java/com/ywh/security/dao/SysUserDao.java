package com.ywh.security.dao;

import com.ywh.security.entity.SysUserEntity;
import com.ywh.common.base.BaseDao;
import org.springframework.stereotype.Repository;



/**
 * CreateTime: 2019-01-25
 * ClassName: SysUserDao
 * Package: com.ywh.security.dao
 * Describe:
 *  Dao 接口
 * @author YWH
 */
@Repository
public interface SysUserDao extends BaseDao<SysUserEntity> {

    SysUserEntity selectByUserName(String username);

}
