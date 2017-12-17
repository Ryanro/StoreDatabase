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

 Date: 12/14/2017 22:44:41 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `finance_wage`
-- ----------------------------
DROP TABLE IF EXISTS `finance_wage`;
CREATE TABLE `finance_wage` (
  `staff_no` varchar(255) NOT NULL,
  `absent_num` varchar(10) DEFAULT NULL,
  `wage_date` date DEFAULT NULL,
  `pay_wage` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`staff_no`),
  KEY `staff_no` (`staff_no`),
  CONSTRAINT `finance_wage_ibfk_1` FOREIGN KEY (`staff_no`) REFERENCES `hr_employee` (`staff_no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
