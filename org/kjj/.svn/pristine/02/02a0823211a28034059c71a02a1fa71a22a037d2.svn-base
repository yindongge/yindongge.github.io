--2016-8-25 触摸屏首页表
CREATE TABLE `org_touch_page` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area_code` varchar(6) DEFAULT NULL COMMENT '区域编码  关联表org_area的code关联',
  `shop_id` int(11) DEFAULT NULL COMMENT '店铺id 关联表org_shop的shop_id关联',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '店铺首页是否启用  0 未启用  1 启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--2016-8-25 触摸屏首页轮播图表
CREATE TABLE `org_touch_page_banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT, 
  `page_id` int(11) NOT NULL COMMENT '页面ID  对应org_touch_page表id字段',
  `banner_img` varchar(100) NOT NULL COMMENT '图片',
  `banner_url` varchar(200) DEFAULT NULL COMMENT '跳转链接',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `image_order` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_touchpagebanner_pageid` (`page_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 20160825 媒体机关于我们
INSERT INTO `org_article_class`(class_name,order_,parentId,createtime,level,isvalide) 
 VALUES ('媒体机关于我们', NULL, -1, '2016-8-24 18:03:40', NULL, 1);
INSERT INTO `org_article_class`(class_name,order_,parentId,createtime,level,isvalide) 
VALUES ( '关于我们', NULL, 99, '2016-8-24 18:04:36', NULL, 1);
update `org_article_class` a ,org_article_class b
set a.parentId=b.id
where b.class_name='媒体机关于我们' and a.parentId=99


-- 20160905 活动
/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : orgstorecms_test

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2016-09-05 10:06:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for org_activity
-- ----------------------------
DROP TABLE IF EXISTS `org_activity`;
CREATE TABLE `org_activity` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(50) NOT NULL COMMENT '活动标题',
  `type_id` tinyint(4) unsigned NOT NULL COMMENT '活动类型 1大转盘2砸金蛋3老虎机4刮刮卡',
  `start_time` datetime NOT NULL COMMENT '开始时间',
  `end_time` datetime NOT NULL COMMENT '结束时间',
  `award_timeout` bigint(20) NOT NULL COMMENT '失效时限，当前时间减中奖时间大于失效时限，不许领奖',
  `tip_win` varchar(50) NOT NULL COMMENT '中奖提示',
  `tip_lose` varchar(50) NOT NULL COMMENT '未中奖提示',
  `limit_money` decimal(10,0) NOT NULL COMMENT '满额开始抽奖',
  `limit_repeat` tinyint(4) unsigned DEFAULT '0' COMMENT '是否允许累加抽奖（1允许；0不允许）',
  `limit_count` tinyint(4) unsigned DEFAULT NULL COMMENT '最多抽奖次数（默认不限制）',
  `status` tinyint(4) unsigned DEFAULT '1' COMMENT '活动状态(1未开启;2运行中;3已暂停;4已停用)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='活动表';

-- ----------------------------
-- Table structure for org_activity_award
-- ----------------------------
DROP TABLE IF EXISTS `org_activity_award`;
CREATE TABLE `org_activity_award` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `activity_id` int(10) NOT NULL COMMENT '活动Id',
  `shop_id` int(10) NOT NULL COMMENT '门店id',
  `ticket_id` int(10) NOT NULL COMMENT '购物小票Id',
  `ticket_number` int(10) NOT NULL COMMENT '小票抽奖号码',
  `award_type` tinyint(4) NOT NULL COMMENT '类型（1线上，2线下）',
  `prize_type` tinyint(4) NOT NULL COMMENT '奖品类型:1商品,2优惠券',
  `prize_id` int(10) NOT NULL COMMENT '奖品id(商品id或优惠券id)',
  `prize_name` varchar(30) NOT NULL COMMENT '奖品id(商品名或优惠券名)',
  `mobile_phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `draw_time` datetime NOT NULL COMMENT '获奖时间',
  `get_time` datetime DEFAULT NULL COMMENT '领奖时间',
  `status` tinyint(4) DEFAULT NULL COMMENT '领奖状态（1未领取，2已领取，3已过期，4已放弃）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖品领取表';

-- ----------------------------
-- Table structure for org_activity_detail
-- ----------------------------
DROP TABLE IF EXISTS `org_activity_detail`;
CREATE TABLE `org_activity_detail` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `activity_id` int(10) NOT NULL COMMENT '活动Id',
  `activity_detail` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for org_activity_dialitem
-- ----------------------------
DROP TABLE IF EXISTS `org_activity_dialitem`;
CREATE TABLE `org_activity_dialitem` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `activity_id` int(10) NOT NULL COMMENT '活动Id',
  `item_name` varchar(30) NOT NULL COMMENT '奖项名称',
  `item_type` tinyint(4) NOT NULL COMMENT '奖项类型：1无奖提示2商品3优惠券',
  `item_prize_id` int(10) NOT NULL COMMENT '奖品Id',
  `item_prize_name` varchar(30) NOT NULL COMMENT '奖品名',
  `thumb` varchar(255) DEFAULT NULL COMMENT '缩略图',
  `item_num` smallint(6) NOT NULL COMMENT '奖品数量',
  `remain_num` smallint(6) NOT NULL COMMENT '剩余数量',
  `lock_num` smallint(6) DEFAULT NULL COMMENT '锁定数量',
  `item_order` smallint(6) NOT NULL COMMENT '奖项顺序',
  `item_rate` bigint(20) NOT NULL COMMENT '中奖概率',
  `status` tinyint(4) NOT NULL COMMENT '奖项状态（1有效，0已失效）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='转盘奖项表';

-- ----------------------------
-- Table structure for org_activity_shop
-- ----------------------------
DROP TABLE IF EXISTS `org_activity_shop`;
CREATE TABLE `org_activity_shop` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `activity_id` int(10) NOT NULL COMMENT '活动表主键',
  `activity_type_id` tinyint(4) NOT NULL COMMENT '活动类型 1大转盘2砸金蛋3老虎机4刮刮卡',
  `shop_id` int(10) NOT NULL COMMENT '店铺Id',
  `start_time` datetime NOT NULL COMMENT '开始时间',
  `end_time` datetime NOT NULL COMMENT '结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='活动店铺表';

-- ----------------------------
-- Table structure for org_activity_ticket
-- ----------------------------
DROP TABLE IF EXISTS `org_activity_ticket`;
CREATE TABLE `org_activity_ticket` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `activity_id` int(10) NOT NULL,
  `shop_id` int(10) NOT NULL COMMENT '门店id',
  `shop_code` varchar(10) NOT NULL COMMENT '店铺编号',
  `ticket_number` int(10) NOT NULL COMMENT '小票抽奖号码',
  `ticket_create_time` datetime NOT NULL COMMENT '票据打印时间',
  `ticket_price` decimal(8,2) NOT NULL COMMENT '小票金额',
  `attend_num` tinyint(4) unsigned NOT NULL COMMENT '已参与次数',
  `gain_num` tinyint(4) unsigned NOT NULL COMMENT '可参与次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


