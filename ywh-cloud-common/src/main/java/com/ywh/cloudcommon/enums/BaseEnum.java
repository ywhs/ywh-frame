package com.ywh.cloudcommon.enums;

/**
 * CreateTime: 2019-06-23 19:09
 * ClassName: BaseEnum
 * Package: com.ywh.cloudcommon.enums
 * Describe:
 * 基础枚举类
 *
 * @author YWH
 */
public enum BaseEnum {


    /**
     * 基础枚举code值
     */
    SUCCESS("后台处理成功！",200),
    /**
     * 后台处理失败
     */
    FAIL("后台处理失败！",100),
    ;


    private String msg;

    private int code;

    BaseEnum(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


}
