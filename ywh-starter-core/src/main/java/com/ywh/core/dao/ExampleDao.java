package com.ywh.core.dao;

import com.ywh.core.entity.ExampleEntity;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CreateTime: 2018-12-18 19:46
 * ClassName: ExampleDao
 * Package: com.ywh.core.dao
 * Describe:
 * 测试Dao
 *
 * @author YWH
 */
@Repository
public interface ExampleDao {

    @Select("select * from user")
    List<ExampleEntity> findAll();

}
