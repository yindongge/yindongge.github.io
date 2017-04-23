package com.kjj.commserver.service.user;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kjj.commserver.entity.user.aide.OrgUsersConstant;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OrgUsersServiceTest {
	
	@Resource
	private OrgUsersService orgUsersService;

	@Test
	public void testOrgUsersSession() {
		OrgUsersSession user = new OrgUsersSession(OrgUsersConstant.SOURCE_MOBILE);
		user.setOrgUsers(orgUsersService.queryById(76));
		System.out.println(user);
	}

}
