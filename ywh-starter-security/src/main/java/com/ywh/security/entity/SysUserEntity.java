package com.ywh.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("sys_user")
public class SysUserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "sys_user_id", type = IdType.AUTO)
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
