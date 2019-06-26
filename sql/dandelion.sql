/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50726
Source Host           : 100.100.200.90:3306
Source Database       : dandelion

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-06-26 11:39:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` varchar(32) NOT NULL,
  `is_deleted` bit(1) NOT NULL DEFAULT b'0',
  `creator` varchar(32) NOT NULL,
  `create_time` datetime(3) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '帐户名',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `last_login_time` datetime(3) DEFAULT NULL COMMENT '最近登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户帐户表';

-- ----------------------------
-- Records of account
-- ----------------------------

-- ----------------------------
-- Table structure for api_log
-- ----------------------------
DROP TABLE IF EXISTS `api_log`;
CREATE TABLE `api_log` (
  `id` varchar(32) NOT NULL,
  `url` varchar(255) DEFAULT NULL COMMENT '请求地址',
  `http_method` varchar(255) DEFAULT NULL COMMENT '请求类型',
  `class_method` varchar(255) DEFAULT NULL COMMENT '响应类名',
  `ip` varchar(255) DEFAULT NULL COMMENT '请求发起地址',
  `param` text COMMENT '请求参数',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户id',
  `from_client` varchar(255) DEFAULT NULL COMMENT '用户类型/请求来源(微信/后台)',
  `request_time` datetime(3) DEFAULT NULL COMMENT '请求发起时间',
  `response_time` datetime(3) DEFAULT NULL COMMENT '响应时间',
  `result` text COMMENT '返回',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='接口请求日志';

-- ----------------------------
-- Records of api_log
-- ----------------------------

-- ----------------------------
-- Table structure for notes
-- ----------------------------
DROP TABLE IF EXISTS `notes`;
CREATE TABLE `notes` (
  `id` varchar(32) NOT NULL,
  `is_deleted` bit(1) NOT NULL DEFAULT b'0',
  `creator` varchar(32) NOT NULL,
  `create_time` datetime(3) NOT NULL,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `last_edit_time` datetime(3) DEFAULT NULL COMMENT '最近修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='笔记表';

-- ----------------------------
-- Records of notes
-- ----------------------------

-- ----------------------------
-- View structure for database_structure
-- ----------------------------
DROP VIEW IF EXISTS `database_structure`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `database_structure` AS select `information_schema`.`columns`.`TABLE_NAME` AS `表/视图名`,`information_schema`.`tables`.`TABLE_COMMENT` AS `表注释`,`information_schema`.`columns`.`COLUMN_NAME` AS `字段名`,`information_schema`.`columns`.`COLUMN_DEFAULT` AS `默认值`,`information_schema`.`columns`.`IS_NULLABLE` AS `是否可以为空`,`information_schema`.`columns`.`COLUMN_TYPE` AS `字段类型`,(case when (`information_schema`.`columns`.`COLUMN_NAME` = 'id') then 'uuid' when (`information_schema`.`columns`.`COLUMN_NAME` = 'fid') then '父id' when (`information_schema`.`columns`.`COLUMN_NAME` = 'gid') then '' when (`information_schema`.`columns`.`COLUMN_NAME` = 'is_deleted') then '删除标识' when (`information_schema`.`columns`.`COLUMN_NAME` = 'sort') then '排序' when (`information_schema`.`columns`.`COLUMN_NAME` = 'create_time') then '创建时间' when (`information_schema`.`columns`.`COLUMN_NAME` = 'creator') then '创建人' else `information_schema`.`columns`.`COLUMN_COMMENT` end) AS `说明` from (`information_schema`.`columns` left join `information_schema`.`tables` on(((`information_schema`.`tables`.`TABLE_SCHEMA` = 'dandelion') and (`information_schema`.`tables`.`TABLE_NAME` = `information_schema`.`columns`.`TABLE_NAME`)))) where ((`information_schema`.`columns`.`TABLE_SCHEMA` = 'dandelion') and (`information_schema`.`columns`.`TABLE_NAME` <> 'database_structure')) ;
