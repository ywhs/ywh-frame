package com.ywh.common.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * CreateTime: 2018-12-18 20:43
 * ClassName: BaseServiceImpl
 * Package: com.ywh.common.base
 * Describe:
 * 基础service的实现类   如果有什么通用的方法，可自行扩展
 *
 * @author YWH
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M,T> implements BaseService<T>{
}