package com.ywh.security.controller;

import com.ywh.common.base.BaseEnum;
import com.ywh.common.utils.MyExceptionUtil;
import com.ywh.common.utils.Result;
import com.ywh.security.entity.SecurityUserDetails;
import com.ywh.security.service.SysUserService;
import com.ywh.security.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
    @Autowired
    private SysUserService sysUserService;


    /**
     * 登陆
     * @param map 接收体
     * @return 返回token
     */
    @PostMapping("login")
    public Result login(@RequestBody Map<String, String> map){
        String token = sysUserService.login(map.get("username"), map.get("password"));
        return Result.successJson(token);
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


}
