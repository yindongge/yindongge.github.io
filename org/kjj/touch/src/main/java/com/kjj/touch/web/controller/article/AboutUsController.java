package com.kjj.touch.web.controller.article;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.article.OrgArticle;
import com.kjj.commserver.entity.article.OrgArticleClass;
import com.kjj.commserver.entity.article.aide.OrgArticleQuery;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.article.OrgArticleClassService;
import com.kjj.commserver.service.article.OrgArticleService;
import com.kjj.touch.constant.SessionConstant;
import com.kjj.touch.util.TouchPropertiesUtil;

@Controller
@RequestMapping("/aboutUs")
public class AboutUsController {
	
	@Resource
	OrgArticleClassService orgArticleClassService;
	@Resource
	OrgArticleService orgArticleService;
	
	@RequestMapping(value = "/desc", method = { RequestMethod.GET,RequestMethod.POST })
	public String desc(HttpSession session,Model model, @RequestParam(value="id")Integer id){
		if(id != null){
			//文章
			OrgArticleQuery orgArticleQuery = new OrgArticleQuery();
			orgArticleQuery.setClassid(id.shortValue());
			 List<OrgArticle> list = orgArticleService.queryList(orgArticleQuery);
			 if(CollectionUtils.isNotEmpty(list)){
				 model.addAttribute("article",list.get(0));
			 }else{
				 model.addAttribute("article",null);
			 }
		}
		return "aboutUs/desc";
	}
	
	@ResponseBody
	@RequestMapping(value = "/item", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String, Integer> item(HttpSession session){
		Map<String, Integer> map = new HashMap<String, Integer>();
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		OrgArticleClass articleClass = orgArticleClassService.queryClassByClassName(TouchPropertiesUtil.getProperty("aboutUs"));
		List<OrgArticleClass> listArticleClass = orgArticleClassService.queryListByParentidAndShopIdWithArticle(articleClass.getId(), orgUsersSession.getOrgShop().getShopId());
		OrgArticleClass orgArticleClass=null;
		Integer oacId =null;
		if(CollectionUtils.isNotEmpty(listArticleClass)){
			orgArticleClass = listArticleClass.get(0);
		}
		if(orgArticleClass!=null){
			oacId = orgArticleClass.getId();
			map.put("oacId", oacId);
		}
		
		return map;
	}
	
	
	
}
