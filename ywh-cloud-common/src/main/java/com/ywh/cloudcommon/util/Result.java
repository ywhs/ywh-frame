package com.ywh.cloudcommon.util;

import com.ywh.cloudcommon.enums.BaseEnum;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * CreateTime: 2018-12-18 20:38
 * ClassName: Result
 * Package: com.ywh.common.util
 * Describe:
 * 前端返回json格式封装类
 *
 * @author YWH
 */
public class Result{


    /**
     * 返回状态码，200为正确，100为失败
     */
    private int code;

    /**
     * 返回处理信息，成功或者失败
     */
    private String msg;

    /**
     * 成功返回true，失败返回false
     */
    private Boolean success;

    /**
     * 返回给前端的数据
     */
    private Map<String, Object> extend = new HashMap<String ,Object>();

    /**
     * 成功返回的json封装体
     * @param value 原始数据
     * @return json格式
     */
    public static Result successJson(Object value){
        Result results = new Result();
        results.setCode(BaseEnum.SUCCESS.getCode());
        results.setMsg(BaseEnum.SUCCESS.getMsg());
        results.setSuccess(true);
        results.getExtend().put("data",value);
        return results;
    }

    /**
     * 失败返回的json封装体
     * @return json格式
     */
    public static Result errorJson(){
        Result results = new Result();
        results.setCode(BaseEnum.FAIL.getCode());
        results.setSuccess(false);
        results.setMsg(BaseEnum.FAIL.getMsg());
        return results;
    }

    /**
     * 失败返回的json封装体
     * @return json格式
     */
    public static Result errorJson(String msg){
        Result results = new Result();
        results.setCode(BaseEnum.FAIL.getCode());
        results.setSuccess(false);
        results.setMsg(msg);
        return results;
    }

    /**
     * 失败返回的json封装体
     * @return json格式
     */
    public static Result errorJson(String msg,Integer code){
        Result results = new Result();
        results.setCode(code);
        results.setSuccess(false);
        results.setMsg(msg);
        return results;
    }

    public int getCode() {
        return code;
    }

    private void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    private void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    private void setSuccess(Boolean success) {
        this.success = success;
    }

    private Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }

}
