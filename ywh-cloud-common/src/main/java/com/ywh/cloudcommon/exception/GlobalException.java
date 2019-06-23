package com.ywh.cloudcommon.exception;

import com.sun.corba.se.impl.io.TypeMismatchException;
import com.ywh.cloudcommon.enums.BaseEnum;
import com.ywh.cloudcommon.enums.SystemCodeEnum;
import com.ywh.cloudcommon.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * CreateTime: 2019-06-23 22:16
 * ClassName: GlobalException
 * Package: com.ywh.cloudcommon.exception
 * Describe:
 * 全局异常类
 *
 * @author YWH
 */
@RestControllerAdvice
public class GlobalException {

    /**
     *
     * 全局异常类中定义的异常都可以被拦截，只是触发条件不一样，如IO异常这种必须抛出异常到
     * controller中才可以被拦截，或者在类中用try..catch自己处理
     * 绝大部分不需要向上抛出异常即可被拦截，返回前端json数据，如数组下标越界，404 500 400等错误
     * 如果自己想要写，按着以下格式增加异常即可
     *HttpMessageNotReadableException
     */

    private static final Logger log = LoggerFactory.getLogger(GlobalException.class);

    /**
     *   启动应用后，被 @ExceptionHandler、@InitBinder、@ModelAttribute 注解的方法，
     *   都会作用在 被 @RequestMapping 注解的方法上。
     * @param binder 参数
     */
    @InitBinder
    public void initWebBinder(WebDataBinder binder){

    }

    /**
     * 系统错误，未知的错误   已测试
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler({Exception.class})
    public Result exception(Exception ex){
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.errorJson(SystemCodeEnum.SYSTEM_ERROR.getMsg(),SystemCodeEnum.SYSTEM_ERROR.getCode());
    }

    /**
     * 文件没有找到错误拦截   **要把错误信息抛出到controller层  已测试
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(FileNotFoundException.class)
    public Result fileNotFound(FileNotFoundException ex){
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.errorJson(SystemCodeEnum.FILE_NOT_FOUND.getMsg(),SystemCodeEnum.FILE_NOT_FOUND.getCode());
    }

    /**
     * 字符串转换为数字异常   已测试  不需要抛出到ccontroller即可被拦截
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(NumberFormatException.class)
    public Result numberFormatEx(NumberFormatException ex){
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.errorJson(SystemCodeEnum.NUMBER_FORMAT.getMsg(),SystemCodeEnum.NUMBER_FORMAT.getCode());
    }

    /**
     * sql操作数据库出错了
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(SQLException.class)
    public Result sqlException(SQLException ex){
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.errorJson(SystemCodeEnum.SQL_EXCEPTION.getMsg(),SystemCodeEnum.SQL_EXCEPTION.getCode());
    }

    /**
     * 参数传递出错了
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result sqlException(IllegalArgumentException ex){
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.errorJson(SystemCodeEnum.ILLEGAL_ARGUMENT.getMsg(),SystemCodeEnum.ILLEGAL_ARGUMENT.getCode());
    }

    /**
     * 栈溢出错误
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(StackOverflowError.class)
    public Result stackOverflow(StackOverflowError ex){
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.errorJson(SystemCodeEnum.STACK_OVERFLOW.getMsg(),SystemCodeEnum.STACK_OVERFLOW.getCode());
    }

    /**
     * 404错误拦截   已测试
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result noHandlerNotFound(NoHandlerFoundException ex){
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.errorJson(SystemCodeEnum.NO_HANDLER.getMsg(),SystemCodeEnum.NO_HANDLER.getCode());
    }

    /**
     * 400错误拦截
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(TypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result request400(TypeMismatchException ex){
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.errorJson(SystemCodeEnum.BAD_REQUEST.getMsg(),SystemCodeEnum.BAD_REQUEST.getCode());
    }

    /**
     * 400错误拦截
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result request400(MissingServletRequestParameterException ex){
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.errorJson(SystemCodeEnum.BAD_REQUEST.getMsg() + "   找不到传入的参数",SystemCodeEnum.BAD_REQUEST.getCode());
    }

    /**
     * 400错误拦截
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result request400(HttpMessageNotReadableException ex){
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.errorJson(SystemCodeEnum.BAD_REQUEST.getMsg() + "    可能缺少参数",SystemCodeEnum.BAD_REQUEST.getCode());
    }

    /**
     * 405错误拦截
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public Result request405(HttpRequestMethodNotSupportedException ex){
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.errorJson(SystemCodeEnum.METHOD_NOT_ALLOWED.getMsg(),SystemCodeEnum.METHOD_NOT_ALLOWED.getCode());
    }

    /**
     * 500错误拦截
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result request500(RuntimeException ex){
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.errorJson(SystemCodeEnum.INTERNAL_SERVER_ERROR.getMsg(),SystemCodeEnum.INTERNAL_SERVER_ERROR.getCode());
    }

    /**
     * 类型转换异常   已经测试 可以拦截
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(ClassCastException.class)
    public Result classCastExceptionHandler(ClassCastException ex) {
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.errorJson(SystemCodeEnum.CLASS_CAST.getMsg(),SystemCodeEnum.CLASS_CAST.getCode());
    }

    /**
     * 未知方法异常
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(NoSuchMethodException.class)
    public Result noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.errorJson(SystemCodeEnum.NO_SUCH_METHOD.getMsg(),SystemCodeEnum.NO_SUCH_METHOD.getCode());
    }

    /**
     * IO异常 需要抛出到Controller层可捕获到
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(IOException.class)
    public Result iOExceptionHandler(IOException ex) {
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.errorJson(SystemCodeEnum.IO_EXCEPTION.getMsg(),SystemCodeEnum.IO_EXCEPTION.getCode());
    }

    /**
     * 空指针异常  已测试  可以拦截
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(NullPointerException.class)
    public Result nullPointerExceptionHandler(NullPointerException ex) {
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.errorJson(SystemCodeEnum.NULL_POINTER.getMsg(), SystemCodeEnum.NULL_POINTER.getCode());
    }

    /**
     * 数组越界异常拦截   已测试
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public Result indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex){
        log.warn("错误详情：" + ex.getMessage(),ex);
        return Result.errorJson(SystemCodeEnum.INDEX_OUT_BOUNDS.getMsg(),SystemCodeEnum.INDEX_OUT_BOUNDS.getCode());
    }

    /**
     * 自定义异常信息拦截
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(MyException.class)
    public Result myCustomizeException(MyException ex){
        log.warn("错误详情：" + ex);
        return Result.errorJson(SystemCodeEnum.CUSTOMIZE_EXCEPTION.getMsg(),SystemCodeEnum.CUSTOMIZE_EXCEPTION.getCode());
    }


}
