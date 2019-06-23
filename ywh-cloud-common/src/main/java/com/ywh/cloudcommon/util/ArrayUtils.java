package com.ywh.cloudcommon.util;

/**
 * CreateTime: 2019-06-23 20:21
 * ClassName: ArrayUtils
 * Package: com.ywh.cloudcommon.util
 * Describe:
 * Array工具类
 *
 * @author YWH
 */
public final class ArrayUtils {

    private ArrayUtils() {
    }

    /**
     * 判断是否为空
     * @param array 数组
     * @return true or false
     */
    public static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断是否不为空
     * @param array 数组
     * @return true or false
     */
    public static boolean isNotEmpty(Object[] array) {
        return !isEmpty(array);
    }
}
