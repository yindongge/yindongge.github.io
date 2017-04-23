package com.kjj.commserver.service.goods;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kjj.commserver.entity.goods.OrgProductLinkSalespec;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OrgProductLinkSalespecServiceTest {

	@Resource
	OrgProductLinkSalespecService orgProductLinkSalespecService;
	
	@Test
	public void testGetSpecGroupBySpecId() {
		List<OrgProductLinkSalespec> specList = orgProductLinkSalespecService.getSpecGroupByGoodsId(200);
		for (OrgProductLinkSalespec orgProductLinkSalespec : specList) {
			System.out.println(orgProductLinkSalespec.getSpecValue());
		}
	}

}
