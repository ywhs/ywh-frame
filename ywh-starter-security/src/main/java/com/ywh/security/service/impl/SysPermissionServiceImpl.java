package com.ywh.security.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ywh.security.entity.SysPermissionEntity;
import com.ywh.security.dao.SysPermissionDao;
import com.ywh.security.service.SysPermissionService;
import com.ywh.common.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * CreateTime: 2019-01-25
 * ClassName: SysPermissionServiceImpl
 * Package: com.ywh.security.service.impl
 * Describe:
 *  业务逻辑接口的实现类
 * @author YWH
 */
@Service
public class SysPermissionServiceImpl extends BaseServiceImpl<SysPermissionDao, SysPermissionEntity> implements SysPermissionService {

    private static final Logger log = LoggerFactory.getLogger(SysPermissionServiceImpl.class);

    @Autowired
    private SysPermissionDao dao;

}
