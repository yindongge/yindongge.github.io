package com.kjj.commserver.service.order;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kjj.commserver.entity.order.OrgOrder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OrgRefundOrderServiceTest {
	
	@Resource
	private OrgOrderService orgOrderService;
	@Resource
	private OrgRefundOrderService orgRefundOrderService;

	@Test
	public void testAddByOrder() {
		OrgOrder order = orgOrderService.queryById(110013374);
		orgRefundOrderService.addByOrder(order);
	}

	@Test
	public void testAddByReturnOrder() {
		fail("Not yet implemented");
	}

}
