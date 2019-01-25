package com.ywh.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author YWH
 * @since 2019-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_role")
public class SysRoleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 系统角色id
     */
    @TableId(value = "sys_role_id", type = IdType.AUTO)
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
