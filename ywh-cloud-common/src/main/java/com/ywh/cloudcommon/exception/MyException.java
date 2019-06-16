package com.ywh.cloudcommon.exception;

/**
 * CreateTime: 2019-06-16 22:15
 * ClassName: MyException
 * Package: com.ywh.cloudcommon.exception
 * Describe:
 * 自定义异常，可以throws的时候用自己的异常类
 *
 * @author YWH
 */
public class MyException extends RuntimeException {

    public MyException(String msg) {
        super(msg);
    }

    public MyException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public MyException(Throwable throwable) {
        super(throwable);
    }

}
