package com.kjj.commserver.service.user;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")

public class OrgEnterpriseInvitationServiceTest {
	@Resource
	OrgEnterpriseInvitationService invitationService;
	
	@Test
	public void testAddInvitationOfEnterprise(){
		invitationService.addInvitationOfEnterprise(15);
	}
}