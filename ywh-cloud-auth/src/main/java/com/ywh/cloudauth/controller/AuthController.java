package com.ywh.cloudauth.controller;

import com.ywh.cloudauth.service.SysUserService;
import com.ywh.cloudcommon.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * CreateTime: 2019-06-30 19:02
 * ClassName: AuthController
 * Package: com.ywh.cloudauth.controller
 * Describe:
 * 系统登录接口Controller
 *
 * @author YWH
 */
@RestController
@RequestMapping("auth")
public class AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);
    private SysUserService sysUserService;

    public AuthController(){}

    @Autowired
    public AuthController(SysUserService sysUserService){
        this.sysUserService = sysUserService;
    }

    /**
     * 根据用户名查询用户信息
     * @param username  用户名
     * @return 用户信息
     */
    @GetMapping("selectUserByName")
    public Result selectUserByName(@RequestParam String username){
        return Result.successJson(sysUserService.findUserInfo(username));
    }





}
