/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/1/30 15:41:08                           */
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
   sys_role_name        varchar(50) not null default '' comment '系统角色名字',
   sys_role_describe    varchar(50) not null default '' comment '系统角色描述',
   sys_role_state       tinyint unsigned not null default 1 comment '系统角色状态 0：代表无效用户 1：代表无效用户',
   sys_add_time         timestamp not null default CURRENT_TIMESTAMP comment '系统角色添加时间',
   sys_up_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '系统角色修改时间',
   primary key (sys_role_id)
);

INSERT INTO `sys_role`(`sys_role_id`, `sys_role_name`, `sys_role_describe`, `sys_role_state`, `sys_add_time`, `sys_up_time`) VALUES (1, 'ROLE_ROOT', '超级管理员', 1, '2019-01-30 11:11:11', '2019-01-30 11:11:11');
INSERT INTO `sys_role`(`sys_role_id`, `sys_role_name`, `sys_role_describe`, `sys_role_state`, `sys_add_time`, `sys_up_time`) VALUES (2, 'ROLE_ADMIN', '管理员', 1, '2019-01-30 11:11:25', '2019-01-30 11:11:25');
INSERT INTO `sys_role`(`sys_role_id`, `sys_role_name`, `sys_role_describe`, `sys_role_state`, `sys_add_time`, `sys_up_time`) VALUES (3, 'ROLE_EDIT', '编辑', 1, '2019-01-30 11:11:38', '2019-01-30 11:11:38');
INSERT INTO `sys_role`(`sys_role_id`, `sys_role_name`, `sys_role_describe`, `sys_role_state`, `sys_add_time`, `sys_up_time`) VALUES (4, 'ROLE_USER', '测试用户', 1, '2019-01-30 11:11:57', '2019-01-30 11:11:57');

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
   sys_user_avatar      varchar(255) not null default '' comment '系统用户头像',
   sys_user_account     varchar(128) not null default '' comment '系统用户账户',
   sys_user_password    varchar(255) not null default '' comment '系统用户密码',
   sys_user_name        varchar(128) not null default '' comment '系统用户名字',
   sys_user_phone       varchar(20) not null default '' comment '系统用户手机号',
   sys_user_email       varchar(50) not null default '' comment '系统用户的邮箱',
   sys_user_state       tinyint unsigned not null default 1 comment '系统用户的状态 0：代表无效用户    1 ：代表有效用户',
   sys_add_time         timestamp not null default CURRENT_TIMESTAMP comment '系统用户的添加时间',
   sys_up_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '系统用户的更新时间',
   primary key (sys_user_id)
);

INSERT INTO `sys_user`(`sys_user_id`, `sys_user_avatar`, `sys_user_account`, `sys_user_password`, `sys_user_name`, `sys_user_phone`, `sys_user_email`, `sys_user_state`, `sys_add_time`, `sys_up_time`) VALUES ('715037a78f4545c5b89ee858141f3aa9', 'https://ifsaid-blog.oss-cn-shenzhen.aliyuncs.com/images/2018/9/28/3BDDD3B7B3AF4BA2A8FA0EFEB585597B.jpg', 'lry', '$2a$10$eizOrUVVJfER7XfU0wF3w.eG2oOg154EcY70G7np80be64sgKOYve', 'lry', '1954856826', '58994625@qq.com', 1, '2019-01-25 09:33:05', '2019-01-25 09:33:05');
INSERT INTO `sys_user`(`sys_user_id`, `sys_user_avatar`, `sys_user_account`, `sys_user_password`, `sys_user_name`, `sys_user_phone`, `sys_user_email`, `sys_user_state`, `sys_add_time`, `sys_up_time`) VALUES ('b10a36c74f604c3aac83d0d955751cd4', 'https://ifsaid-blog.oss-cn-shenzhen.aliyuncs.com/images/2018/9/28/3BDDD3B7B3AF4BA2A8FA0EFEB585597B.jpg', 'jon', '$2a$10$A08T4ZpSFBjX69R8YupZ8.gmfhhG9k50wHWhwmPf4xpCkh8/VnRyu', 'jon', '1686156823', '52586852@qq.com', 1, '2019-01-25 09:38:24', '2019-01-25 09:38:40');
INSERT INTO `sys_user`(`sys_user_id`, `sys_user_avatar`, `sys_user_account`, `sys_user_password`, `sys_user_name`, `sys_user_phone`, `sys_user_email`, `sys_user_state`, `sys_add_time`, `sys_up_time`) VALUES ('b6be6ead7cc94e46a6547406abce1aa1', 'https://ifsaid-blog.oss-cn-shenzhen.aliyuncs.com/images/2018/9/28/3BDDD3B7B3AF4BA2A8FA0EFEB585597B.jpg', 'zyd', '$2a$10$YqAxjoZP9TbrmNUNz4HaoOJJnxas5MfzuS552MxLc/dJQhh1svQxu', 'zyd', '1656975556', '59466823@qq.com', 1, '2019-01-25 09:33:38', '2019-01-25 09:33:38');
INSERT INTO `sys_user`(`sys_user_id`, `sys_user_avatar`, `sys_user_account`, `sys_user_password`, `sys_user_name`, `sys_user_phone`, `sys_user_email`, `sys_user_state`, `sys_add_time`, `sys_up_time`) VALUES ('ca6c5272c4654f09acc165aaa17e8c27', 'https://ifsaid-blog.oss-cn-shenzhen.aliyuncs.com/images/2018/9/28/3BDDD3B7B3AF4BA2A8FA0EFEB585597B.jpg', 'ywh', '$2a$10$A08T4ZpSFBjX69R8YupZ8.gmfhhG9k50wHWhwmPf4xpCkh8/VnRyu', 'ywh', '1549952464', '15665828@qq.com', 1, '2019-01-25 09:32:16', '2019-01-25 09:32:16');

/*==============================================================*/
/* Table: sys_user_role                                         */
/*==============================================================*/
create table sys_user_role
(
   sys_user_id          varchar(36) not null default '' comment '系统用户id',
   sys_role_id          int unsigned not null default 0 comment '系统角色id'
);

INSERT INTO `sys_user_role`(`sys_user_id`, `sys_role_id`) VALUES ('715037a78f4545c5b89ee858141f3aa9', 1);
INSERT INTO `sys_user_role`(`sys_user_id`, `sys_role_id`) VALUES ('b6be6ead7cc94e46a6547406abce1aa1', 2);
INSERT INTO `sys_user_role`(`sys_user_id`, `sys_role_id`) VALUES ('ca6c5272c4654f09acc165aaa17e8c27', 2);
INSERT INTO `sys_user_role`(`sys_user_id`, `sys_role_id`) VALUES ('b10a36c74f604c3aac83d0d955751cd4', 4);

