package com.ywh.common.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * CreateTime: 2018-12-18 20:44
 * ClassName: BaseDao
 * Package: com.ywh.common.base
 * Describe:
 * 基础的Dao接口   如果有什么通用的方法，可自行扩展
 *
 * @author YWH
 */
public interface BaseDao<Pojo> extends BaseMapper<Pojo> {
}