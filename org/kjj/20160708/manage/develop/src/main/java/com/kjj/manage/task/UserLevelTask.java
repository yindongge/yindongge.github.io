package com.kjj.manage.task;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kjj.commserver.service.user.OrgUsersService;


@Component
public class UserLevelTask {
	private Logger logger = LoggerFactory.getLogger(UserLevelTask.class);
	
	@Resource
	private OrgUsersService orgUsersService;
	
	/**
	 * 每天晚上11点执行，要保证Mysql事件event_change_user_level在10时执行
	 */
	@Scheduled(cron = "0 0 23 * * ?")
	public void syncUserLevelToRuiXing() {
		logger.info("***********************RuiXing user level sync start*****************************");
		orgUsersService.syncUserLevelToRuiXing();
		logger.info("***********************RuiXing user level sync end*****************************");
	}
	
}
