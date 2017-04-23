package com.kjj.manage.task;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.aide.OrgOrderQuery;
import com.kjj.commserver.service.order.OrgOrderService;
import com.kjj.commserver.util.ExceptionUtil;


@Component
public class OrderlTask {
	private Logger logger = LoggerFactory.getLogger(OrderlTask.class);
	
	@Resource
	private OrgOrderService orgOrderService;
	
	/**
	 * 超时订单作废程序
	 */
	@Scheduled(cron = "0 0/10 * * * ?")
	public void updateOrderTimeOut() {
		logger.info("***********************order time out start*****************************");
		OrgOrderQuery query = new OrgOrderQuery();
		query.setTimeOut(true);
		List<OrgOrder> listOrder = orgOrderService.queryList(query);
		
		for(OrgOrder order : listOrder){
			try {
				//错误之后继续执行
				orgOrderService.updateCancelTimeOut(order);
			} catch (Exception e) {
				logger.error(ExceptionUtil.getStackMsg(e));
			}
		}
		logger.info("***********************order time out end*****************************");
	}
}
