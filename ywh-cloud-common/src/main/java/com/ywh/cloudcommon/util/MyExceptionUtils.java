package com.ywh.cloudcommon.util;

import com.ywh.cloudcommon.exception.MyException;

/**
 * CreateTime: 2019-06-16 22:16
 * ClassName: MyExceptionUtils
 * Package: com.ywh.cloudcommon.util
 * Describe:
 * 快速构建异常工具类
 *
 * @author YWH
 */
public class MyExceptionUtils {


    public MyExceptionUtils() {
    }

    /**
     * 异常方法
     * @param msg 信息
     * @param t 异常类
     * @param params 可变参数，可传可不传
     * @return 返回自定义异常类
     */
    public static MyException mxe(String msg, Throwable t, Object... params){
        return new MyException(StringUtils.format(msg, params),t);
    }

    /**
     * 异常方法
     * @param msg 信息
     * @param params 可变参数，可传可不传
     * @return 返回自定义异常类
     */
    public static MyException mxe(String msg, Object... params){
        return new MyException(StringUtils.format(msg, params));
    }

    /**
     * 异常方法
     * @param t 异常类
     * @return 返回自定义异常类
     */
    public static MyException mxe(Throwable t){
        return new MyException(t);
    }

}
