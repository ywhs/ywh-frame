package com.ywh.core.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ywh.core.entity.UserEntity;
import com.ywh.core.dao.UserDao;
import com.ywh.core.service.UserService;
import com.ywh.common.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.ywh.core.dao.UserDao;


/**
 * CreateTime: 2018-12-18
 * ClassName: UserServiceImpl
 * Package: com.ywh.core.service.impl
 * Describe:
 *  业务逻辑接口的实现类
 * @author YWH
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao, UserEntity> implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao dao;

}
