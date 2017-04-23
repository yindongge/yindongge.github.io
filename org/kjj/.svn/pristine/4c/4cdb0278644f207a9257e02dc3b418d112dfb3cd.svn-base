package com.kjj.commserver.service.order;

import static org.junit.Assert.assertFalse;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.aide.OrgOrderQuery;
import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgUsersConstant;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.service.user.OrgUsersService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OrgOrderServiceTest {
	
	@Resource
	private OrgOrderService orgOrderService;
	@Resource
	private OrgUsersService orgUsersService;
	@Resource
	private OrgShopService orgShopService;

	@Test
	public void testInsert() {
		
	}

	@Test
	public void testInsertInBatch() {
		
	}

	@Test
	public void testDelete() {
		
	}

	@Test
	public void testDeleteById() {
		
	}

	@Test
	public void testDeleteByIdInBatch() {
		
	}

	@Test
	public void testUpdateById() {
		
	}

	@Test
	public void testUpdateByIdSelective() {
		
	}

	@Test
	public void testUpdateInBatch() {
		
	}

	@Test
	public void testQueryById() {
		OrgOrder order = orgOrderService.queryById(110000000);
		assertFalse("testQueryById="+order,order == null);
	}

	@Test
	public void testQueryVoById() {
		OrgOrder order = orgOrderService.queryVoById(110000000);
		assertFalse("testQueryById="+order,order == null);
	}

	@Test
	public void testQueryOne() {
		
	}

	@Test
	public void testQueryCount() {
		
	}

	@Test
	public void testQueryListT() {
		OrgOrder query = new OrgOrderQuery();
		List<OrgOrder> list = orgOrderService.queryList(query);
		for(OrgOrder vo : list){
			System.out.println(vo.toString());
		}
		assertFalse("list="+list,list.size() == 0);
	}

	@Test
	public void testQueryListTSort() {
		OrgOrder query = new OrgOrderQuery();
		List<OrgOrder> list = orgOrderService.queryList(query);
		for(OrgOrder vo : list){
			System.out.println(vo.toString());
		}
		assertFalse("listSort="+list,list.size() == 0);
	}

	@Test
	public void testQueryPageList() {
		OrgOrder query = new OrgOrderQuery();
		Sort sort = new Sort(Direction.DESC,"create_time");
		Pageable pageable = new PageRequest(0,5,sort);
		Page<OrgOrder> page = orgOrderService.queryPageList(query,pageable);
		for(OrgOrder vo : page.getContent()){
			System.out.println(vo.toString());
		}
		assertFalse("PageList="+page,page.getContent().size() == 0);
	}

	@Test
	public void testQueryMapTString() {
		OrgOrder query = new OrgOrderQuery();
		Map<Integer, OrgOrder> map = orgOrderService.queryMap(query, "orderId");
		for (Map.Entry<Integer, OrgOrder> entry : map.entrySet()) {
			System.out.println("key=" + entry.getKey()+" "+ "value="+ entry.getValue());
		}
		assertFalse("list="+map,map.size() == 0);
	}

	@Test
	public void testQueryMapTStringPageable() {
		
	}
	
	@Test
	public void testQueryPageList4User() {
		
		OrgUsers user = orgUsersService.queryById(76);
		OrgShop shop = orgShopService.queryById(3);
		OrgUsersSession orgUsersSession = new OrgUsersSession(OrgUsersConstant.SOURCE_MOBILE);
		orgUsersSession.setOrgUsers(user);
		orgUsersSession.setOrgShop(shop);
		orgUsersSession.setLogin(true);
		
		OrgOrderQuery query = new OrgOrderQuery();
		Sort sort = new Sort(Direction.DESC,"create_time");
		Pageable pageable = new PageRequest(0,5,sort);
		Page<OrgOrder> page = orgOrderService.queryPageList4User(orgUsersSession, query, pageable);
		for(OrgOrder vo : page.getContent()){
			System.out.println(vo.toString());
		}
	}
	
	@Test
	public void testUpdatePayOnline(){
		orgOrderService.updatePayOnline(110033178, (byte)1);
	}

}
