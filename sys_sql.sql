/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/1/24 18:20:21                           */
/*==============================================================*/


drop table if exists sys_permission;

drop table if exists sys_role;

drop table if exists sys_role_permission;

drop table if exists sys_user;

drop table if exists sys_user_role;

/*==============================================================*/
/* Table: sys_permission                                        */
/*==============================================================*/
create table sys_permission
(
   sys_per_id           int unsigned not null auto_increment comment '系统权限id',
   sys_father_id        int unsigned not null default 0 comment '系统权限父id',
   sys_per_title        varchar(50) not null default '' comment '系统权限标题',
   sys_per_type         tinyint unsigned not null default 0 comment '系统权限类型 0：菜单权限 1 按钮权限',
   sys_per_describe     varchar(255) not null default '' comment '系统权限描述',
   primary key (sys_per_id)
);

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
   sys_role_id          int unsigned not null auto_increment comment '系统角色id',
   sys_role_name        varchar(50) not null default '‘’' comment '系统角色名字',
   sys_role_describe    varchar(50) not null default '' comment '系统角色描述',
   sys_role_state       tinyint unsigned not null default 1 comment '系统角色状态 0：代表无效用户 1：代表无效用户',
   sys_add_time         timestamp not null default CURRENT_TIMESTAMP comment '系统角色添加时间',
   sys_up_time          timestamp not null default 'TIMESTAMP ' comment '系统角色修改时间',
   primary key (sys_role_id)
);

/*==============================================================*/
/* Table: sys_role_permission                                   */
/*==============================================================*/
create table sys_role_permission
(
   sys_role_id          int unsigned not null default 0 comment '系统角色id',
   sys_per_id           int unsigned not null default 0 comment '系统权限id'
);

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
   sys_user_id          varchar(36) not null comment '主键id',
   sys_user_account     varchar(128) not null default '' comment '系统用户账户',
   sys_user_password    varchar(255) not null default '' comment '系统用户密码',
   sys_user_name        varchar(128) not null default '' comment '系统用户名字',
   sys_user_phone       varchar(20) not null default '' comment '系统用户手机号',
   sys_user_email       varchar(50) not null default '' comment '系统用户的邮箱',
   sys_user_state       tinyint unsigned not null default 1 comment '系统用户的状态 0：代表无效用户    1 ：代表有效用户',
   sys_add_time         timestamp not null default CURRENT_TIMESTAMP comment '系统用户的添加时间',
   sys_up_time          timestamp not null default 'TIMESTAMP ON UPDATE CURRENT_TIMESTAMP' comment '系统用户的更新时间',
   primary key (sys_user_id)
);

/*==============================================================*/
/* Table: sys_user_role                                         */
/*==============================================================*/
create table sys_user_role
(
   sys_user_id          varchar(36) not null default '‘’' comment '系统用户id',
   sys_role_id          int unsigned not null default 0 comment '系统角色id'
);

