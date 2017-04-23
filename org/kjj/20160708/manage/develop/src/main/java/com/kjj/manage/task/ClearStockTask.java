package com.kjj.manage.task;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kjj.commserver.entity.goods.aide.OrgClassConstant;
import com.kjj.commserver.service.goods.OrgProductInventoryClearService;
import com.kjj.commserver.service.goods.OrgProductInventoryService;

@Component
public class ClearStockTask {
	private Logger logger = LoggerFactory.getLogger(ClearStockTask.class);
	
	
	@Resource
	private OrgProductInventoryService orgProductInventoryService;
	
	@Resource
	private OrgProductInventoryClearService orgProductInventoryClearService;
	
	@Scheduled(cron = "0 0 11 * * ?")
	public void clearStockByTimeType_1() {
		String timeType = "1";
		logger.info("***********************Clear Stock 11:00 start*****************************");
		orgProductInventoryClearService.updateMealInventoryZero(timeType, OrgClassConstant.MEAL_CLASS_ID);
		logger.info("***********************Clear Stock 11:00 end*******************************");
	}
	
	@Scheduled(cron = "0 10 11 * * ?")
	public void clearStockByTimeType_2() {
		String timeType = "2";
		logger.info("***********************Clear Stock 11:10 start*****************************");
		orgProductInventoryClearService.updateMealInventoryZero(timeType, OrgClassConstant.MEAL_CLASS_ID);
		logger.info("***********************Clear Stock 11:10 end*******************************");
	}
	
	@Scheduled(cron = "0 20 11 * * ?")
	public void clearStockByTimeType_3() {
		String timeType = "3";
		
		logger.info("***********************Clear Stock 11:20 start*****************************");
		orgProductInventoryClearService.updateMealInventoryZero(timeType, OrgClassConstant.MEAL_CLASS_ID);
		logger.info("***********************Clear Stock 11:20 end*******************************");
	}
	
	@Scheduled(cron = "0 30 11 * * ?")
	public void clearStockByTimeType_4() {
		String timeType = "4";
		logger.info("***********************Clear Stock 11:30 start*****************************");
		orgProductInventoryClearService.updateMealInventoryZero(timeType, OrgClassConstant.MEAL_CLASS_ID);
		logger.info("***********************Clear Stock 11:30 end*******************************");
	}
	
	@Scheduled(cron = "0 40 11 * * ?")
	public void clearStockByTimeType_5() {
		String timeType = "5";
		logger.info("***********************Clear Stock 11:40 start*****************************");
		orgProductInventoryClearService.updateMealInventoryZero(timeType, OrgClassConstant.MEAL_CLASS_ID);
		logger.info("***********************Clear Stock 11:40 end*******************************");
	}
	
	@Scheduled(cron = "0 50 11 * * ?")
	public void clearStockByTimeType_6() {
		String timeType = "6";
		logger.info("***********************Clear Stock 11:50 start*****************************");
		orgProductInventoryClearService.updateMealInventoryZero(timeType, OrgClassConstant.MEAL_CLASS_ID);
		logger.info("***********************Clear Stock 11:50 end*******************************");
	}
	
	@Scheduled(cron = "0 0 12 * * ?")
	public void clearStockByTimeType_7() {
		String timeType = "7";
		logger.info("***********************Clear Stock 12:00 start*****************************");
		orgProductInventoryClearService.updateMealInventoryZero(timeType, OrgClassConstant.MEAL_CLASS_ID);
		logger.info("***********************Clear Stock 12:00 end*******************************");
	}
	
	@Scheduled(cron = "0 10 12 * * ?")
	public void clearStockByTimeType_8() {
		String timeType = "8";
		logger.info("***********************Clear Stock 12:10 start*****************************");
		orgProductInventoryClearService.updateMealInventoryZero(timeType, OrgClassConstant.MEAL_CLASS_ID);
		logger.info("***********************Clear Stock 12:10 end*******************************");
	}
	
	@Scheduled(cron = "0 20 12 * * ?")
	public void clearStockByTimeType_9() {
		String timeType = "9";
		logger.info("***********************Clear Stock 12:20 start*****************************");
		orgProductInventoryClearService.updateMealInventoryZero(timeType, OrgClassConstant.MEAL_CLASS_ID);
		logger.info("***********************Clear Stock 12:20 end*******************************");
	}
	
	@Scheduled(cron = "0 30 12 * * ?")
	public void clearStockByTimeType_10() {
		String timeType = "10";
		logger.info("***********************Clear Stock 12:30 start*****************************");
		orgProductInventoryClearService.updateMealInventoryZero(timeType, OrgClassConstant.MEAL_CLASS_ID);
		logger.info("***********************Clear Stock 12:30 end*******************************");
	}
	
	@Scheduled(cron = "0 40 12 * * ?")
	public void clearStockByTimeType_11() {
		String timeType = "11";
		logger.info("***********************Clear Stock 12:40 start*****************************");
		orgProductInventoryClearService.updateMealInventoryZero(timeType, OrgClassConstant.MEAL_CLASS_ID);
		logger.info("***********************Clear Stock 12:40 end*******************************");
	}
	
	@Scheduled(cron = "0 50 12 * * ?")
	public void clearStockByTimeType_12() {
		String timeType = "12";
		logger.info("***********************Clear Stock 12:50 start*****************************");
		orgProductInventoryClearService.updateMealInventoryZero(timeType, OrgClassConstant.MEAL_CLASS_ID);
		logger.info("***********************Clear Stock 12:50 end*******************************");
	}
	
	@Scheduled(cron = "0 0 13 * * ?")
	public void clearStockByTimeType_13() {
		String timeType = "13";
		logger.info("***********************Clear Stock 13:00 start*****************************");
		orgProductInventoryClearService.updateMealInventoryZero(timeType, OrgClassConstant.MEAL_CLASS_ID);
		logger.info("***********************Clear Stock 13:00 end*******************************");
	}
}
