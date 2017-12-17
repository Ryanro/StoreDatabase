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

 Date: 12/14/2017 22:45:04 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `sale_information`
-- ----------------------------
DROP TABLE IF EXISTS `sale_information`;
CREATE TABLE `sale_information` (
  `sale_no` varchar(255) NOT NULL,
  `staff_no` varchar(255) DEFAULT NULL,
  `sale_date` date DEFAULT NULL,
  PRIMARY KEY (`sale_no`),
  KEY `staff_no` (`staff_no`),
  KEY `sale_no` (`sale_no`,`sale_date`),
  CONSTRAINT `sale_information_ibfk_1` FOREIGN KEY (`staff_no`) REFERENCES `hr_employee` (`staff_no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
