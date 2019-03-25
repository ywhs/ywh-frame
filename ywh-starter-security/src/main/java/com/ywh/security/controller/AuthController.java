package com.ywh.security.controller;

import com.ywh.common.base.BaseEnum;
import com.ywh.common.utils.MyExceptionUtil;
import com.ywh.common.utils.Result;
import com.ywh.security.entity.SecurityUserDetails;
import com.ywh.security.service.SysUserService;
import com.ywh.security.utils.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * CreateTime: 2019-01-28 16:06
 * ClassName: AuthController
 * Package: com.ywh.security.controller
 * Describe:
 * 权限控制器
 *
 * @author YWH
 */
@RestController
@RequestMapping("auth")
public class AuthController {


    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);


    @Autowired
    private SysUserService sysUserService;


    /**
     * 登陆
     * @param map 接收体
     * @return 返回token
     */
    @PostMapping("login")
    public Result login(@RequestBody Map<String, String> map){
        try {
            String token = sysUserService.login(map.get("username"), map.get("password"));
            return Result.successJson(token);
        }catch (AuthenticationException ex){
            LOG.error("登陆失败",ex);
            return Result.errorJson(BaseEnum.PASSWORD_ERROR.getMsg(),BaseEnum.PASSWORD_ERROR.getIndex());
        }

    }

    /**
     * 用户详情
     * @return 用户详细信息
     */
    @GetMapping("userInfo")
    public Result userInfo(){
        Object authentication = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(authentication instanceof SecurityUserDetails){
            return Result.successJson(sysUserService.findUserInfo(((SecurityUserDetails) authentication).getUsername()));
        }
        return Result.errorJson(BaseEnum.LOGIN_AGIN.getMsg(),BaseEnum.LOGIN_AGIN.getIndex());
    }

    @PostMapping("logOut")
    public Result logOut(){
        return Result.successJson("退出成功，因为token本身是无状态，如果通过redis来控制token的生存周期，则变成了有状态，所以暂时没有好的解决办法。");
    }

}
