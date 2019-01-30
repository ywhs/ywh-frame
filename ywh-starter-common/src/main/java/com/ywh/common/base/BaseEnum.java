package com.ywh.common.base;

/**
 * CreateTime: 2018-12-18 20:36
 * ClassName: BaseEnum
 * Package: com.ywh.common.base
 * Describe:
 * 基础枚举类
 *
 * @author YWH
 */
public enum  BaseEnum {

    /**
     *后台处理成功
     */
    SUCCESS("后台处理成功！",200),
    /**
     *后台处理失败
     */
    FAIL("后台处理失败！",100),
    /**
     *资源没有找到
     */
    RESOURCE_NOT_FOUND("资源没有找到",101),
    /**
     * 数组越界了！
     */
    INDEX_OUT_BOUNDS("数组越界了！",102),
    /**
     * 系统错误，未知的错误
     */
    SYSTEM_ERROR("系统错误，未知的错误!",103),
    /**
     * 空指针错误
     */
    NULL_POINTER("空指针异常！",104),
    /**
     * IO异常
     */
    IO_EXCEPTION("IO异常！",105),
    /**
     * 未知的方法
     */
    NO_SUCH_METHOD("找不到方法，未知的方法",106),
    /**
     * 类型转换错误
     */
    CLASS_CAST("类型转换出错，请检查",107),
    /**
     * 文件未找到错误
     */
    FILE_NOT_FOUND("文件没有找到，请确认文件位置！",108),
    /**
     * 字符串转换数字异常
     */
    NUMBER_FORMAT("字符串转换数字出错了!",109),
    /**
     * 操作数据库错误
     */
    SQL_EXCEPTION("操作数据库出错了!",110),
    /**
     * 传递的参数出错了
     */
    ILLEGAL_ARGUMENT("传递的参数出错了！",111),
    /**
     * 堆栈溢出错误
     */
    STACK_OVERFLOW("栈溢出了！",112),
    /**
     * 用户未注册
     */
    USER_UNREGISTERED("用户未注册",113),
    /**
     * 用户已注册
     */
    USER_REGISTERED("用户已注册",114),
    /**
     * 用户名或密码错误
     */
    PASSWORD_ERROR("用户名或密码错误！",115),
    /**
     * 验证码发送失败
     */
    SEND_FAIL("验证码发送失败",116),
    /**
     * 缺少参数或值为空
     */
    PARAMETER_IS_NULL("缺少参数或值为空",117),
    /**
     * 参数不合法
     */
    PARAMETER_IS_WRONGFUL("参数不合法",118),
    /**
     * 无效的Token
     */
    INVALID_TOKEN("无效的Token",119),
    /**
     * 无操作权限
     */
    NO_OPERATION_AUTHORITY("无操作权限",120),
    /**
     * 自定义异常
     */
    CUSTOMIZE_EXCEPTION("自定义异常，请检查",121),
    /**
     * token过期了，请重新登录!
     */
    LOGIN_AGIN("token过期了，请重新登录!",122),
    /**
     * 400错误
     */
    BAD_REQUEST("Bad Request!",400),
    /**
     * 405错误
     */
    METHOD_NOT_ALLOWED("Method Not Allowed! 有可能是接口类型错误！",405),
    /**
     * 500错误
     */
    INTERNAL_SERVER_ERROR("Internal Server Error",500),
    /**
     * 404错误拦截
     */
    NO_HANDLER("这个页面石沉大海了！接口没找到",404);

    private String msg;

    private int index;

    BaseEnum(String msg, int index) {
        this.msg = msg;
        this.index = index;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
