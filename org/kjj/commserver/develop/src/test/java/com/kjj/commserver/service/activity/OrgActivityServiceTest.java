package com.kjj.commserver.service.activity;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kjj.commserver.entity.activity.OrgActivity;
import com.kjj.commserver.entity.activity.OrgActivityDetail;
import com.kjj.commserver.entity.activity.OrgActivityDialitem;
import com.kjj.commserver.entity.activity.aide.OrgActivityVo;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OrgActivityServiceTest {
	
	@Resource
	private OrgActivityService orgActivityService;

	@Test
	public void testOrgActivityServiceQuery() {
		OrgActivity orgActivity = orgActivityService.queryVoById(1);
		OrgActivityVo orgActivityVo=(OrgActivityVo) orgActivity;
		System.out.println(orgActivityVo);
		OrgActivityDetail orgActivityDetail = orgActivityVo.getOrgActivityDetail();
		System.out.println(orgActivityDetail);
	}
	
	@Test
	public void testOrgActivityDialitem() {
		OrgActivity orgActivity = orgActivityService.queryVoById(1);
		OrgActivityVo orgActivityVo=(OrgActivityVo) orgActivity;
		System.out.println(orgActivityVo);
		List<OrgActivityDialitem> dialitemList = orgActivityVo.getDialitemList();
		for (OrgActivityDialitem orgActivityDialitem : dialitemList) {
			System.out.println(orgActivityDialitem);
		}
	}

	
}
