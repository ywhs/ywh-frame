package com.ywh.cloudcommon.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

/**
 * CreateTime: 2019-06-30 18:04
 * ClassName: SysRoleEntity
 * Package: com.ywh.cloudcommon.entity
 * Describe:
 * 角色实体类
 *
 * @author YWH
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysRoleEntity {

    /**
     * 系统角色id
     */
    private Integer sysRoleId;

    /**
     * 系统角色名字
     */
    private String sysRoleName;

    /**
     * 系统角色描述
     */
    private String sysRoleDescribe;

    /**
     * 系统角色状态 0：代表无效用户 1：代表无效用户
     */
    private Integer sysRoleState;

    /**
     * 系统角色添加时间
     */
    private LocalDateTime sysAddTime;

    /**
     * 系统角色修改时间
     */
    private LocalDateTime sysUpTime;

    /**
     * 用户列表
     */
    private List<SysUserEntity> users;

}
