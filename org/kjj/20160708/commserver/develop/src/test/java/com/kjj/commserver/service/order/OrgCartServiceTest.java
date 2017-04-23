package com.kjj.commserver.service.order;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kjj.commserver.entity.order.aide.OrgCartAll;
import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgUsersConstant;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.service.user.OrgUsersService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OrgCartServiceTest {
	
	@Resource
	private OrgCartService orgCartService;
	@Resource
	private OrgUsersService orgUsersService;
	@Resource
	private OrgShopService orgShopService;

	@Test
	public void testQueryList4Buy() {
		OrgUsers user = orgUsersService.queryById(76);
		OrgShop shop = orgShopService.queryById(3);
		OrgUsersSession orgUsersSession = new OrgUsersSession(OrgUsersConstant.SOURCE_MOBILE);
		orgUsersSession.setOrgUsers(user);
		orgUsersSession.setOrgShop(shop);
		orgUsersSession.setLogin(true);
		List<OrgCartAll> list = orgCartService.queryList4View(orgUsersSession);
		System.out.println(list);
	}

}
