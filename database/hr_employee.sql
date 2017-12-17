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

 Date: 12/14/2017 22:44:51 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `hr_employee`
-- ----------------------------
DROP TABLE IF EXISTS `hr_employee`;
CREATE TABLE `hr_employee` (
  `staff_no` varchar(255) NOT NULL,
  `staff_name` varchar(255) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `age` varchar(5) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `staff_ps` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`staff_no`),
  KEY `hr-employe_ibfk_1` (`job`) USING BTREE,
  CONSTRAINT `hr-employee_ibfk_1` FOREIGN KEY (`job`) REFERENCES `hr_job` (`job`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
