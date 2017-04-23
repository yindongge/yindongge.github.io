package com.kjj.manage.task;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kjj.commserver.service.goods.OrgProductInventoryService;


@Component
public class InventoryTask {
	private Logger logger = LoggerFactory.getLogger(InventoryTask.class);
	
	@Resource
	private OrgProductInventoryService orgProductInventoryService;
	
	/**
	 * 与瑞星系统库存同步
	 */
	@Scheduled(cron = "0 5/10 * * * ?")
	public void syncUserLevelToRuiXing() {
		logger.info("***********************RuiXing Inventory sync start*****************************");
		orgProductInventoryService.syncInventoryFromRuiXing();
		logger.info("**********************RuiXing Inventory sync end*****************************");
	}
	
}
