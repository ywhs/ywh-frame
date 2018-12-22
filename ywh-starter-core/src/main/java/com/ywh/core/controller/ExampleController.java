package com.ywh.core.controller;

import com.alibaba.fastjson.JSONObject;
import com.ywh.common.utils.Result;
import com.ywh.core.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @GetMapping("findAll")
    public JSONObject findAll(){
        return Result.successJson(exampleService.myException());
    }
}
