package com.ywh.cloudcore.service.impl;


import com.ywh.cloudcommon.entity.example.ExampleEntity;
import com.ywh.cloudcommon.util.MyExceptionUtils;
import com.ywh.cloudcore.dao.ExampleDao;
import com.ywh.cloudcore.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CreateTime: 2019-06-16 19:48
 * ClassName: ExampleServiceImpl
 * Package: com.ywh.core.service.impl
 * Describe:
 * 测试Service接口的实现类
 *
 * @author YWH
 */
@Service
public class ExampleServiceImpl implements ExampleService {

    private ExampleDao exampleDao;

    public ExampleServiceImpl(){}

    @Autowired
    public ExampleServiceImpl(ExampleDao exampleDao){
        this.exampleDao = exampleDao;
    }

    @Override
    public String myException() {
        int i;
        try{
            i = 10 /0;
        }catch (Exception ex){
            throw MyExceptionUtils.mxe("出错了",ex);
        }
        return "没有进行拦截，失败了" + i;
    }

    @Override
    public List<ExampleEntity> findAllUser() {
        return exampleDao.findAll();
    }
}
