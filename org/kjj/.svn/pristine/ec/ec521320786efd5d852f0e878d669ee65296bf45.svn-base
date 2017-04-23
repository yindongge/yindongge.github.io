package com.kjj.commserver.service.activity;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kjj.commserver.entity.activity.OrgActivityShop;
import com.kjj.commserver.entity.activity.aide.OrgActivityShopQuery;

/**
 * @Title: OrgActivityShopServiceTest.java
 * @Package com.kjj.commserver.service.activity
 * @Description: 
 * @author ZYLORG
 * @date 2016年9月1日 下午3:37:58
 * @copyright Beijing KJJ Electronic commerce Co., LTD
 * @version V1.0   
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OrgActivityShopServiceTest {
	@Resource
	private OrgActivityShopService orgActivityShopService;

	@Test
	public void testOrgActivityServiceQuery() {
		OrgActivityShopQuery orgActivityShopQuery = new OrgActivityShopQuery();
		orgActivityShopQuery.setShopId(1);
		orgActivityShopQuery.setTimeFlg(true);
		OrgActivityShop orgActivityShop = orgActivityShopService.queryOne(orgActivityShopQuery);
		System.out.println(orgActivityShop);
	}
}

