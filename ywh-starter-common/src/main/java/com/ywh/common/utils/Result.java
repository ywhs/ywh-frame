package com.ywh.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.ywh.common.base.BaseEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * CreateTime: 2018-12-18 20:38
 * ClassName: Result
 * Package: com.ywh.common.utils
 * Describe:
 * 前端返回json格式封装类
 *
 * @author YWH
 */
public class Result {

    private static final long serialVersionUID = 1348172152215944560L;

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
        results.setCode(BaseEnum.SUCCESS.getIndex());
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
        results.setCode(BaseEnum.FAIL.getIndex());
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
        results.setCode(BaseEnum.FAIL.getIndex());
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

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }

}
