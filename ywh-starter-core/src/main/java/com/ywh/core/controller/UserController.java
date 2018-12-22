package com.ywh.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.ywh.core.service.UserService;
import com.ywh.core.entity.UserEntity;
import org.springframework.web.bind.annotation.RestController;
import com.ywh.common.base.BaseController;

/**
 * CreateTime: 2018-12-18
 * ClassName: UserController
 * Package: com.ywh.core.controller
 * Describe:
 *  前端控制器
 * @author YWH
 */
@RestController
@RequestMapping("UserController")
public class UserController extends BaseController<UserService,UserEntity> {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService service;
}
