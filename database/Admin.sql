/*
 Navicat Premium Data Transfer

 Source Server         : MySQLdemo
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost
 Source Database       : store

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : utf-8

 Date: 12/14/2017 22:44:34 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `Admin`
-- ----------------------------
DROP TABLE IF EXISTS `Admin`;
CREATE TABLE `Admin` (
  `Admname` varchar(255) DEFAULT NULL,
  `Admpassword` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `Admin`
-- ----------------------------
BEGIN;
INSERT INTO `Admin` VALUES ('lizechen1', '123456'), ('lizechen2', '123456');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
