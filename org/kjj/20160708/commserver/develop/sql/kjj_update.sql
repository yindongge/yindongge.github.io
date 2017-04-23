-- 20160603 修改banner添加排序
ALTER TABLE `org_shop_banner`
CHANGE COLUMN `b_1` `org_shop_banner_order`  tinyint(100) UNSIGNED NULL DEFAULT NULL COMMENT 'banner排序' AFTER `org_shop_banner_url`;

-- 20160604 满减
DROP TABLE IF EXISTS `org_reach`;
CREATE TABLE `org_reach` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`name`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动名称' ,
`title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '页面显示标题' ,
`start_time`  datetime NOT NULL COMMENT '开始时间' ,
`end_time`  datetime NOT NULL COMMENT '结束时间' ,
`reach_style`  tinyint(4) NOT NULL COMMENT '满足条件 0:金额 1：件数' ,
`shop_type`  tinyint(4) NOT NULL COMMENT '范围店铺类型 1：全部2：区域3：店铺' ,
`product_type`  tinyint(4) DEFAULT NULL COMMENT '商品范围类型 1：全部2：类型3：商品' ,
`status`  tinyint(4) NOT NULL COMMENT '状态 0：无效1：有效' ,
`create_admin_id`  smallint(6) NOT NULL COMMENT '创建人ID 对应org_admin_user表user_id字段' ,
`create_time`  datetime NOT NULL COMMENT '创建时间' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `org_reach_condition`;
CREATE TABLE `org_reach_condition` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`reach_id`  int(11) NOT NULL COMMENT '满减优惠ID 对应org_reach表ID字段' ,
`reach_condition`  decimal(8,2) NOT NULL COMMENT '满足条件' ,
PRIMARY KEY (`id`),
KEY `idx_reachcondition_reachid` (`reach_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `org_reach_coupon`;
CREATE TABLE `org_reach_coupon` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`rd_id`  int(11) NOT NULL COMMENT '满减优惠ID 对应org_reach_discount表ID字段' ,
`coupon_id`  int(11) NOT NULL COMMENT '优惠券ID 对应org_coupon表coupon_id字段' ,
PRIMARY KEY (`id`),
KEY `idx_reachcoupon_rdid` (`rd_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1;

CREATE TABLE `org_reach_coupon_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL COMMENT '订单ID 对应org_order表order_id字段',
  `coupon_id` int(11) NOT NULL COMMENT '优惠券ID 对应org_coupon表coupon_id字段',
  `amount` int(11) NOT NULL COMMENT '数量',
  PRIMARY KEY (`id`),
  KEY `idx_reachcouponorder_orderid` (`order_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `org_reach_discount`;
CREATE TABLE `org_reach_discount` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`rc_id`  int(11) NOT NULL COMMENT '满减条件ID 对应org_reach_condition表ID字段' ,
`type_id`  tinyint(4) NOT NULL COMMENT '优惠类型 1.减钱 2.赠优惠券 3.赠送' ,
`isloop`  tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否叠加 0：否1：是' ,
`common`  decimal(8,2) NULL DEFAULT NULL COMMENT '通用值' ,
PRIMARY KEY (`id`),
KEY `idx_reachdiscount_rcid` (`rc_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1;

DROP TABLE IF EXISTS `org_reach_give`;
CREATE TABLE `org_reach_give` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`rd_id`  int(11) NOT NULL COMMENT '满减优惠ID 对应org_reach_discount表ID字段' ,
`goods_id`  int(11) NOT NULL COMMENT '商品ID 对应org_product_item表goods_id字段' ,
`amount`  int(11) NOT NULL DEFAULT 1 COMMENT '赠送数量' ,
PRIMARY KEY (`id`),
KEY `idx_reachgive_rdid` (`rd_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1;

-- 20160612
ALTER TABLE `org_cart`
ADD COLUMN `discount_id`  int NULL COMMENT '优惠活动ID 对应org_reach表id字段' AFTER `amount`,
ADD COLUMN `status`  tinyint NOT NULL DEFAULT 0 COMMENT '选择状态 0：已选择 1：未选择' AFTER `discount_id`;

-- 20160614
ALTER TABLE `org_user_level`
ADD COLUMN `level_order`  SMALLINT COMMENT '排序，值越大级别越高' AFTER `integral`;

-- 20160615
DELIMITER $$

DROP PROCEDURE IF EXISTS `proc_change_user_level`$$

CREATE PROCEDURE `proc_change_user_level`()
BEGIN

    /******************************************************************
  * 存储过程名 : proc_change_user_level
  * 建立日期: 2016-2-24
  * 作者    : 张健
  * 描述    : 根据会员级别的消费金额上下线来更新用户会员等级
  * 源表    : org_users,org_user_consume
  * 计算步骤:
  *            
  * ----------------------------------------------------------------
  * 修改历史
  * 序号    日期     修改人     修改原因
  * 1     2016-2-24  张健       创建
  * 2     2016-6-15  张健       修改(可以兼容多级别)
  *******************************************************************/
    DECLARE    ERROR_FLAG INT DEFAULT(0);
	DECLARE    V_LEVEL_ID VARCHAR(6); /*会员级别编码*/
	DECLARE    V_LEVEL_TYPE INT; /*会员级别类型*/
	DECLARE    V_CONSUME_TOP DECIMAL(10,2); /*消费上线*/
	DECLARE    V_CONSUME_DWON DECIMAL(10,2); /*消费下线*/
	DECLARE    V_LEVEL_ORDER TINYINT; /*会员级别排序*/
	DECLARE    USER_LEVEL_CUR CURSOR FOR SELECT t.level_id,t.level_type,t.consume_top,t.consume_down,t.level_order FROM org_user_level t ORDER BY t.level_type ASC, t.level_order;
	DECLARE CONTINUE HANDLER FOR SQLSTATE '02000' SET ERROR_FLAG = '91111'; /*定义异常处理*/
	
	OPEN USER_LEVEL_CUR;
	
	USE_CUR_LOOP:LOOP FETCH USER_LEVEL_CUR INTO V_LEVEL_ID,V_LEVEL_TYPE,V_CONSUME_TOP,V_CONSUME_DWON,V_LEVEL_ORDER;
		IF ERROR_FLAG = '91111' THEN 
			LEAVE USE_CUR_LOOP;
		END IF;
		
		UPDATE org_users t SET level_id = V_LEVEL_ID WHERE level_type = V_LEVEL_TYPE AND V_LEVEL_ORDER > (SELECT oul.level_order FROM org_user_level oul WHERE oul.level_id = t.level_id) AND EXISTS (SELECT t1.user_id FROM org_user_consume t1 WHERE t1.user_id = t.user_id AND t1.total >= V_CONSUME_DWON AND t1.total <= V_CONSUME_TOP);
	END LOOP USE_CUR_LOOP;
	COMMIT;
	CLOSE USER_LEVEL_CUR;
	
    END$$

DELIMITER ;

-- 20160615 生鲜管理
INSERT  INTO `org_model`(`modelName`,`modelImg`,`url`,`modelCode`,`flag`,`modelParent`,`modelLevel`,`description`,`isActive`) VALUES ('生鲜管理','','/meal/freshList','009',0,52,0,'','1');

-- 20160620 满减满送管理
INSERT INTO `org_model` ( `modelName`, `modelImg`, `url`, `modelCode`, `flag`, `modelParent`, `modelLevel`, `description`, `isActive`) VALUES ('满减满送列表', NULL, '/reach/list', '', NULL, '23', NULL, NULL, '1');
INSERT INTO `org_model` ( `modelName`, `modelImg`, `url`, `modelCode`, `flag`, `modelParent`, `modelLevel`, `description`, `isActive`) VALUES ('添加满减满送', NULL, '/reach/addInfo', '', NULL, '23', NULL, NULL, '1');



-- 2016-06-21 初始化会员级别
DELETE FROM org_user_level;

INSERT  INTO `org_user_level`(`level_id`,`level_name`,`is_integral`,`is_discount`,`discount`,`level_type`,`consume_top`,`consume_down`,`integral`,`level_order`) 
VALUES ('18','普通会员',1,1,'100.00',1,'14.99','0.00','0.00',1),
('19','VIP会员',1,1,'98.00',1,'100000.00','15.00','0.00',2),
('20','金牌会员',1,1,'98.00',3,'1000000.00','0.00','0.00',1),
('21','企业会员',1,1,'98.00',2,'1000000.00','0.00','0.00',1);
-- 2016-06-22 
ALTER TABLE `org_users`
MODIFY COLUMN `user_name`  varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户名' AFTER `email`;

-- 2016-06-27
ALTER TABLE `org_product_item`
ADD COLUMN `is_direct`  tinyint NOT NULL DEFAULT 0 COMMENT '是否直营 0：直营 1：联营' AFTER `is_show_zero_inventory`;

-- 2016-07-01
CREATE TABLE `org_mobile_page` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area_code` varchar(6) DEFAULT NULL COMMENT '区域编码  关联表org_area的code关联',
  `shop_id` int(11) DEFAULT NULL COMMENT '店铺id 关联表org_shop的shop_id关联',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '店铺首页是否启用  0 未启用  1 启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `org_mobile_page_banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `page_id` int(11) NOT NULL COMMENT '页面ID  对应org_mobile_page表id字段',
  `banner_img` varchar(80) NOT NULL COMMENT '图片',
  `banner_url` varchar(80) DEFAULT NULL COMMENT '跳转链接',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `bg_color` varchar(10) DEFAULT NULL COMMENT '背景色',
  `new_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_mobilepagebanner_pageid` (`page_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `org_mobile_page_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `page_id` int(11) NOT NULL COMMENT '动移首页id 对应org_mobile_page表id字段',
  `module_img` varchar(50) NOT NULL COMMENT '块模区图片',
  `module_order` tinyint(4) NOT NULL COMMENT '模块区排序字段',
  PRIMARY KEY (`id`),
  KEY `idx_mobilepagemodule_pageid` (`page_id`)
) ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE `org_mobile_page_module_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `module_id` int(11) NOT NULL COMMENT '对应 org_mobile_page_module表id字段',
  `goods_id` int(11) NOT NULL COMMENT '对应org_product_item表goods_id字段',
  PRIMARY KEY (`id`),
  KEY `idx_mobilepagemodulegoods_moduleid` (`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT  INTO `org_model`(`modelName`,`modelImg`,`url`,`modelCode`,`flag`,`modelParent`,`modelLevel`,`description`,`isActive`) VALUES ('生鲜管理','','/meal/freshList','002',0,22,0,'','1');

ALTER TABLE `org_account_deposit_records`
ADD COLUMN `trader_id`  INT(11) COMMENT '交易人，转账时使用' AFTER `type`;

ALTER TABLE `org_enterprise_user`
ADD COLUMN `real_name`  VARCHAR(50) COMMENT '真实姓名' AFTER `user_id`;