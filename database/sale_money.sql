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

 Date: 12/14/2017 22:45:09 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `sale_money`
-- ----------------------------
DROP TABLE IF EXISTS `sale_money`;
CREATE TABLE `sale_money` (
  `sale_no` varchar(255) NOT NULL,
  `receivable` varchar(10) DEFAULT NULL,
  `receipts` varchar(10) DEFAULT NULL,
  KEY `sale_no` (`sale_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
