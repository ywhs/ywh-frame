package com.ywh.cloudcommon.util;

/**
 * CreateTime: 2019-06-23 20:22
 * ClassName: StringUtils
 * Package: com.ywh.cloudcommon.util
 * Describe:
 * 字符工具类
 *
 * @author YWH
 */
public class StringUtils {

    private StringUtils() {
    }

    /**
     *  格式话字符串
     * @param target 目标
     * @param params 参数
     * @return 格式话后的字符串 但是字符串中要有%s占位符
     */
    public static String format(String target, Object... params) {
        return target.contains("%s") && ArrayUtils.isNotEmpty(params) ? String.format(target, params) : target;
    }
}
