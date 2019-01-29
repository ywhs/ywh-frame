package com.ywh.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * CreateTime: 2019-01-28 16:06
 * ClassName: AuthController
 * Package: com.ywh.security.controller
 * Describe:
 * 权限控制器
 *
 * @author YWH
 */
@Controller
@RequestMapping("auth")
public class AuthController {


    @GetMapping("login")
    public String login(@RequestParam(value="error", required=false) String error,
                        @RequestParam(value="logout", required=false) String logout,
                        ModelMap model){
        if (error != null) {
            model.put("error", "Username or password is not correct");
        } else if (logout != null) {
            model.put("logout", "Logout successful");
        }
        return "/login.html";
    }

}
