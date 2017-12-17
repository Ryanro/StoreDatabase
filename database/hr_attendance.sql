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

 Date: 12/14/2017 22:44:46 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `hr_attendance`
-- ----------------------------
DROP TABLE IF EXISTS `hr_attendance`;
CREATE TABLE `hr_attendance` (
  `staff_no` varchar(255) NOT NULL,
  `absence_date` date DEFAULT NULL,
  `absence_reason` varchar(255) DEFAULT NULL,
  KEY `staff_no` (`staff_no`),
  CONSTRAINT `hr_attendance_ibfk_1` FOREIGN KEY (`staff_no`) REFERENCES `hr_employee` (`staff_no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
