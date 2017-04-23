package com.kjj.manage.task;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kjj.commserver.service.goods.OrgProductItemService;


@Component
public class ProductItemTask {
	private Logger logger = LoggerFactory.getLogger(ProductItemTask.class);
	
	@Resource
	private OrgProductItemService orgProductItemService;
	
	/**
	 * SKU销售数、评论数更新程序
	 */
	@Scheduled(cron = "0 51 23 * * ?")
	public void updateSaleNumAndCommentNum() {
		logger.info("***********************sku update saleNumAndCommentNum start*****************************");
		orgProductItemService.updateSaleNumAndCommentNum();
		logger.info("***********************sku update saleNumAndCommentNum end*****************************");
	}
}
