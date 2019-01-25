package com.ywh.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
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
@TableName("sys_permission")
public class SysPermissionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 系统权限id
     */
    @TableId(value = "sys_per_id", type = IdType.AUTO)
    private Integer sysPerId;

    /**
     * 系统权限父id
     */
    private Integer sysFatherId;

    /**
     * 系统权限标题
     */
    private String sysPerTitle;

    /**
     * 系统权限类型 0：菜单权限 1 按钮权限
     */
    private Integer sysPerType;

    /**
     * 系统权限描述
     */
    private String sysPerDescribe;


}
