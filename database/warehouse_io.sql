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

 Date: 12/14/2017 22:45:19 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `warehouse_io`
-- ----------------------------
DROP TABLE IF EXISTS `warehouse_io`;
CREATE TABLE `warehouse_io` (
  `item_no` char(10) NOT NULL,
  `supplier` char(255) DEFAULT NULL,
  `io_num` int(6) DEFAULT NULL,
  `io_date` date DEFAULT NULL,
  `pro_date` date DEFAULT NULL,
  `best_before` date DEFAULT NULL,
  `remain_num` int(6) DEFAULT NULL,
  PRIMARY KEY (`item_no`),
  KEY `item_no` (`item_no`),
  CONSTRAINT `warehouse_io_ibfk_1` FOREIGN KEY (`item_no`) REFERENCES `warehouse_iteminfo` (`item_no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
