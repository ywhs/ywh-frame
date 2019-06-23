package com.ywh.cloudcore.controller;


import com.ywh.cloudcommon.util.Result;
import com.ywh.cloudcore.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CreateTime: 2019-6-16 19:46
 * ClassName: ExampleController
 * Package: com.ywh.core.controller
 * Describe:
 * 测试Controller
 *
 * @author YWH
 */
@RestController
@RequestMapping("example")
public class ExampleController{

    private ExampleService exampleService;

    public ExampleController(){}

    @Autowired
    public ExampleController(ExampleService exampleService){
        this.exampleService = exampleService;
    }

    /**
     * 测试异常信息
     * @return 返回测试成功字符串
     */
    @GetMapping("test")
    public Result test(){
        return Result.successJson(exampleService.myException());
    }

    @GetMapping("test1")
    public Result test1(){
        return Result.successJson("成功了！！");
    }
}
