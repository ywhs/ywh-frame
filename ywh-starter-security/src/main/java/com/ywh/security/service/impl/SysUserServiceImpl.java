package com.ywh.security.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ywh.security.entity.SysUserEntity;
import com.ywh.security.dao.SysUserDao;
import com.ywh.security.service.SysUserService;
import com.ywh.common.base.BaseServiceImpl;
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

}
