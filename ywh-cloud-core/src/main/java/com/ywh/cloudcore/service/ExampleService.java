package com.ywh.cloudcore.service;


import com.ywh.cloudcommon.entity.example.ExampleEntity;

import java.util.List;

/**
 * CreateTime: 2018-12-18 19:47
 * ClassName: ExampleService
 * Package: com.ywh.core.service
 * Describe:
 * 测试Service接口类
 *
 * @author YWH
 */
public interface ExampleService{

    /**
     *  测试异常
     * @return 字符串
     */
    String myException();

    /**
     * 查询所有用户
     * @return 用户集合
     */
    List<ExampleEntity> findAllUser();
}
