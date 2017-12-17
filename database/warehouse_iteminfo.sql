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

 Date: 12/14/2017 22:45:23 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `warehouse_iteminfo`
-- ----------------------------
DROP TABLE IF EXISTS `warehouse_iteminfo`;
CREATE TABLE `warehouse_iteminfo` (
  `item_no` char(10) NOT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `goods_type` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `sale_price` decimal(10,2) DEFAULT NULL,
  `buying_price` decimal(10,2) DEFAULT NULL,
  `item_ps` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`item_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
