package com.ywh.cloudcommon.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

/**
 * CreateTime: 2019-06-30 17:52
 * ClassName: SysUserEntity
 * Package: com.ywh.cloudcommon.entity.sysuser
 * Describe:
 * 用户实体类
 *
 * @author YWH
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserEntity {

    /**
     * 主键id
     */
    private String sysUserId;

    /**
     * 用户头像
     */
    private String sysUserAvatar;

    /**
     * 系统用户账户
     */
    private String sysUserAccount;

    /**
     * 系统用户密码
     */
    private String sysUserPassword;

    /**
     * 系统用户名字
     */
    private String sysUserName;

    /**
     * 系统用户手机号
     */
    private String sysUserPhone;

    /**
     * 系统用户的邮箱
     */
    private String sysUserEmail;

    /**
     * 系统用户的状态 0：代表无效用户    1 ：代表有效用户
     */
    private Integer sysUserState;

    /**
     * 系统用户的添加时间
     */
    private LocalDateTime sysAddTime;

    /**
     * 系统用户的更新时间
     */
    private LocalDateTime sysUpTime;

    /**
     * 角色列表
     */
    private List<SysRoleEntity> roles;

}
