package com.ywh.common.exception;

/**
 * CreateTime: 2018-12-18 22:31
 * ClassName: MyException
 * Package: com.ywh.common.exception
 * Describe:
 * 自定义异常，可以throws的时候用自己的异常类
 *
 * @author YWH
 */
public class MyException extends RuntimeException{

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
