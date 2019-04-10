/*
 Navicat Premium Data Transfer

 Source Server         : 本地Mysql
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : ywh_code

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 10/04/2019 11:16:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `sys_per_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '系统权限id',
  `sys_father_id` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '系统权限父id',
  `sys_per_title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '系统权限标题',
  `sys_per_type` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '系统权限类型 0：菜单权限 1 按钮权限',
  `sys_per_describe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '系统权限描述',
  PRIMARY KEY (`sys_per_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `sys_role_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '系统角色id',
  `sys_role_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '系统角色名字',
  `sys_role_describe` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '系统角色描述',
  `sys_role_state` tinyint(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '系统角色状态 0：代表无效用户 1：代表无效用户',
  `sys_add_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '系统角色添加时间',
  `sys_up_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '系统角色修改时间',
  PRIMARY KEY (`sys_role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'ROLE_ROOT', '超级管理员', 1, '2019-01-30 11:11:11', '2019-01-30 11:11:11');
INSERT INTO `sys_role` VALUES (2, 'ROLE_ADMIN', '管理员', 1, '2019-01-30 11:11:25', '2019-01-30 11:11:25');
INSERT INTO `sys_role` VALUES (3, 'ROLE_EDIT', '编辑', 1, '2019-01-30 11:11:38', '2019-01-30 11:11:38');
INSERT INTO `sys_role` VALUES (4, 'ROLE_USER', '测试用户', 1, '2019-01-30 11:11:57', '2019-01-30 11:11:57');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `sys_role_id` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '系统角色id',
  `sys_per_id` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '系统权限id'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `sys_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `sys_user_avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '系统用户头像',
  `sys_user_account` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '系统用户账户',
  `sys_user_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '系统用户密码',
  `sys_user_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '系统用户名字',
  `sys_user_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '系统用户手机号',
  `sys_user_email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '系统用户的邮箱',
  `sys_user_state` tinyint(3) UNSIGNED NOT NULL DEFAULT 1 COMMENT '系统用户的状态 0：代表无效用户    1 ：代表有效用户',
  `sys_add_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '系统用户的添加时间',
  `sys_up_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '系统用户的更新时间',
  PRIMARY KEY (`sys_user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('715037a78f4545c5b89ee858141f3aa9', 'https://ifsaid-blog.oss-cn-shenzhen.aliyuncs.com/images/2018/9/28/3BDDD3B7B3AF4BA2A8FA0EFEB585597B.jpg', 'lry', '$2a$10$eizOrUVVJfER7XfU0wF3w.eG2oOg154EcY70G7np80be64sgKOYve', 'lry', '1954856826', '58994625@qq.com', 1, '2019-01-25 09:33:05', '2019-01-25 09:33:05');
INSERT INTO `sys_user` VALUES ('b10a36c74f604c3aac83d0d955751cd4', 'https://ifsaid-blog.oss-cn-shenzhen.aliyuncs.com/images/2018/9/28/3BDDD3B7B3AF4BA2A8FA0EFEB585597B.jpg', 'jon', '$2a$10$A08T4ZpSFBjX69R8YupZ8.gmfhhG9k50wHWhwmPf4xpCkh8/VnRyu', 'jon', '1686156823', '52586852@qq.com', 1, '2019-01-25 09:38:24', '2019-01-25 09:38:40');
INSERT INTO `sys_user` VALUES ('b6be6ead7cc94e46a6547406abce1aa1', 'https://ifsaid-blog.oss-cn-shenzhen.aliyuncs.com/images/2018/9/28/3BDDD3B7B3AF4BA2A8FA0EFEB585597B.jpg', 'zyd', '$2a$10$YqAxjoZP9TbrmNUNz4HaoOJJnxas5MfzuS552MxLc/dJQhh1svQxu', 'zyd', '1656975556', '59466823@qq.com', 1, '2019-01-25 09:33:38', '2019-01-25 09:33:38');
INSERT INTO `sys_user` VALUES ('ca6c5272c4654f09acc165aaa17e8c27', 'https://img-blog.csdnimg.cn/20190325161813137.jpg', 'ywh', '$2a$10$A08T4ZpSFBjX69R8YupZ8.gmfhhG9k50wHWhwmPf4xpCkh8/VnRyu', 'ywh', '1549952464', '15665828@qq.com', 1, '2019-01-25 09:32:16', '2019-03-25 16:19:55');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `sys_user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '系统用户id',
  `sys_role_id` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '系统角色id'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('715037a78f4545c5b89ee858141f3aa9', 1);
INSERT INTO `sys_user_role` VALUES ('b6be6ead7cc94e46a6547406abce1aa1', 2);
INSERT INTO `sys_user_role` VALUES ('ca6c5272c4654f09acc165aaa17e8c27', 2);
INSERT INTO `sys_user_role` VALUES ('b10a36c74f604c3aac83d0d955751cd4', 4);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '用户姓名',
  `age` tinyint(3) UNSIGNED NOT NULL COMMENT '用户年龄',
  `gender` tinyint(3) UNSIGNED NOT NULL COMMENT '用户性别',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'ywh', 22, 1);
INSERT INTO `user` VALUES (2, 'lry', 22, 1);
INSERT INTO `user` VALUES (3, 'whp', 26, 0);

SET FOREIGN_KEY_CHECKS = 1;
