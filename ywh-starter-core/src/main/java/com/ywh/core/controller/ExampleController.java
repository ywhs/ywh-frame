package com.ywh.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.ywh.common.utils.Result;
import com.ywh.core.service.ExampleService;
import com.ywh.security.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * CreateTime: 2018-12-18 19:46
 * ClassName: ExampleController
 * Package: com.ywh.core.controller
 * Describe:
 * 测试Controller
 *
 * @author YWH
 */
@RestController
@RequestMapping("example")
public class ExampleController {

    @Autowired
    private ExampleService exampleService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @GetMapping("findAll")
    public Result findAll(){
        return Result.successJson(exampleService.myException());
    }

    @GetMapping("securityTest1")
    public Result securityTest1(){
        return Result.successJson("成功了！！！");
    }

    @GetMapping("securityTest2")
    public Result securityTest2(HttpServletRequest httpServletRequest){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            String name =  ((UserDetails) principal).getUsername();
            return Result.successJson("登陆的用户是：" + name);
        }else {
            String name = principal.toString();
            return Result.successJson("登陆的用户是：" + name);
        }
    }
}
