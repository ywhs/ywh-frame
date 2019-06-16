package com.ywh.cloudcommon.entity.example;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * CreateTime: 2018-06-16 19:46
 * ClassName: ExampleEntity
 * Package: com.ywh.core.entity
 * Describe:
 * 测试Pojo实体类
 *
 * @author YWH
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ExampleEntity {

    private Integer id;

    private String name;

    private String age;

    private String gender;

}
