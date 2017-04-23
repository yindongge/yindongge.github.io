package com.kjj.commserver.service.article;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kjj.commserver.entity.article.OrgArticleClass;
import com.kjj.commserver.entity.article.aide.OrgArticleClassVo;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OrgArticleClassServiceTest {
	
	@Resource
	private OrgArticleClassService orgArticleClassService;

	@Test
	public void testQueryArticleClassList() {
		List<OrgArticleClass> aa = getTree(-1);
		System.out.println("123");
	}

	private List<OrgArticleClass> getTree(int rootId) {
		//获取分类 liangji分类
		List<OrgArticleClass> list = orgArticleClassService.queryListByParentid(rootId);
		List<OrgArticleClass> subList =null;
		if(CollectionUtils.isNotEmpty(list)){
			for(int i=0;i<list.size();i++){
				OrgArticleClassVo oacVo = (OrgArticleClassVo) list.get(i);
				if(oacVo.getId()!=null){
					subList= getTree(oacVo.getId());
					oacVo.setListSubClass(subList);
				}
			}
			return list;
		}else{
			return null;
		}
	}
}
