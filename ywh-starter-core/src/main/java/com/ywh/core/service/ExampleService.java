package com.ywh.core.service;

import com.ywh.common.base.BaseService;
import com.ywh.core.entity.ExampleEntity;

/**
 * CreateTime: 2018-12-18 19:47
 * ClassName: ExampleService
 * Package: com.ywh.core.service
 * Describe:
 * 测试Service接口类
 *
 * @author YWH
 */
public interface ExampleService extends BaseService<ExampleEntity> {

    public String myException();
}
