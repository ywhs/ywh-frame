package com.ywh.core.service.impl;

import com.ywh.common.base.BaseServiceImpl;
import com.ywh.common.utils.MyExceptionUtil;
import com.ywh.core.dao.ExampleDao;
import com.ywh.core.entity.ExampleEntity;
import com.ywh.core.service.ExampleService;
import org.springframework.stereotype.Service;

/**
 * CreateTime: 2018-12-18 19:48
 * ClassName: ExampleServiceImpl
 * Package: com.ywh.core.service.impl
 * Describe:
 * 测试Service接口的实现类
 *
 * @author YWH
 */
@Service
public class ExampleServiceImpl extends BaseServiceImpl<ExampleDao,ExampleEntity> implements ExampleService{

    @Override
    public String myException() {
        int i = 0;
        int a = 10;
        if( i > a){
            System.out.println("测试！！！");
        }else{
            throw MyExceptionUtil.mxe("出错了，比他小啊！！");
        }
        return "没有进行拦截，失败了";
    }
}
