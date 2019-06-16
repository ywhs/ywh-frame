package com.ywh.cloudcommon.utils;

import com.ywh.cloudcommon.exception.MyException;

/**
 * CreateTime: 2019-06-16 22:16
 * ClassName: MyExceptionUtil
 * Package: com.ywh.cloudcommon.utils
 * Describe:
 * 快速构建异常工具类
 *
 * @author YWH
 */
public class MyExceptionUtil {

    public MyExceptionUtil() {
    }

    public static MyException mxe(String msg, Throwable t, Object... params){
        return new MyException(msg,t);
    }

    public static MyException mxe(String msg, Object... params){
        return new MyException(msg);
    }

    public static MyException mxe(Throwable t){
        return new MyException(t);
    }

}
