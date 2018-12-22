package com.ywh.common.entity;

import lombok.Data;

/**
 * CreateTime: 2018-12-18 20:39
 * ClassName: BasePage
 * Package: com.ywh.common.entity
 * Describe:
 * 分页实体类
 *
 * @author YWH
 */
@Data
public class BasePage {

    /**
     * 当前每页显示数
     */
    private Integer size;

    /**
     * 当前页数
     */
    private Integer current;

    /**
     * 总条数
     */
    private long total;

}
