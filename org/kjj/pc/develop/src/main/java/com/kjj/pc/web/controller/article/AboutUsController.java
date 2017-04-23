package com.kjj.pc.web.controller.article;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kjj.commserver.entity.article.OrgArticle;
import com.kjj.commserver.entity.article.OrgArticleClass;
import com.kjj.commserver.entity.article.aide.OrgArticleQuery;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.article.OrgArticleClassService;
import com.kjj.commserver.service.article.OrgArticleService;
import com.kjj.pc.constant.SessionConstant;
import com.kjj.pc.util.PcPropertiesUtil;

@Controller
@RequestMapping("/aboutUs")
public class AboutUsController {
	
	@Resource
	OrgArticleClassService orgArticleClassService;
	@Resource
	OrgArticleService orgArticleService;
	
	@RequestMapping(value = "/desc", method = { RequestMethod.GET,RequestMethod.POST })
	public String desc(HttpSession session,Model model,OrgArticleQuery query){
		OrgUsersSession user  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		OrgArticleClass articleClass = orgArticleClassService.queryClassByClassName(PcPropertiesUtil.getProperty("aboutUs"));
		List<OrgArticleClass> listArticleClass = orgArticleClassService.queryListByParentidAndShopIdWithArticle(articleClass.getId(), user.getOrgShop().getShopId());
		model.addAttribute("listArticleClass",listArticleClass);
		if(query.getId() != null){
			//文章
			OrgArticle article = orgArticleService.queryVoById(query.getId());
			model.addAttribute("article",article);
		}
		return "aboutUs/desc";
	}
}
