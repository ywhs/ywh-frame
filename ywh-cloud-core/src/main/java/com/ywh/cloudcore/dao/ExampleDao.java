package com.ywh.cloudcore.dao;


import com.ywh.cloudcommon.entity.example.ExampleEntity;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CreateTime: 2018-12-18 19:46
 * ClassName: ExampleDao
 * Package: com.ywh.core.entity
 * Describe:
 * 测试Dao
 *
 * @author YWH
 */
@Repository
public interface ExampleDao{

    /**
     * 查询所有用户
     * @return 返回用户集合
     */
    @Select("select * from user")
    List<ExampleEntity> findAll();

}
