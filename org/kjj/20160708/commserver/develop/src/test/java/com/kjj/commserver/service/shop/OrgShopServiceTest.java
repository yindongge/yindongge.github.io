package com.kjj.commserver.service.shop;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.system.aide.OrgLocation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OrgShopServiceTest {
	
	@Resource
	private OrgShopService orgShopService;

	@Test
	public void testQueryNearbyShopList() {
		OrgLocation orgLocation = new OrgLocation(116.464983,39.911353);
		List<OrgShop> list = orgShopService.queryNearbyShopList(orgLocation);
		System.out.println(list.size());
	}

	@Test
	public void testQueryNearbyShop() {
		OrgLocation orgLocation = new OrgLocation(116.464983,39.911353);
		OrgShop shop = orgShopService.queryNearbyShop(orgLocation);
		System.out.println(shop);
	}

}
