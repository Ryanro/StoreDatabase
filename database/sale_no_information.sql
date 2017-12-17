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

 Date: 12/14/2017 22:45:15 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `sale_no_information`
-- ----------------------------
DROP TABLE IF EXISTS `sale_no_information`;
CREATE TABLE `sale_no_information` (
  `sale_no` varchar(255) DEFAULT NULL,
  `item_no` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  KEY `sale_no` (`sale_no`),
  KEY `item_no` (`item_no`),
  CONSTRAINT `sale_no_information_ibfk_1` FOREIGN KEY (`sale_no`) REFERENCES `sale_information` (`sale_no`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sale_no_information_ibfk_2` FOREIGN KEY (`item_no`) REFERENCES `warehouse_iteminfo` (`item_no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
