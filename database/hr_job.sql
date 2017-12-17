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

 Date: 12/14/2017 22:44:55 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `hr_job`
-- ----------------------------
DROP TABLE IF EXISTS `hr_job`;
CREATE TABLE `hr_job` (
  `job` varchar(255) NOT NULL,
  `partment` varchar(255) DEFAULT NULL,
  `basic_wage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`job`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
