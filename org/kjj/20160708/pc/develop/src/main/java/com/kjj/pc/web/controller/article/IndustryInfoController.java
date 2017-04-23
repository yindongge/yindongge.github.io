package com.kjj.pc.web.controller.article;

import java.io.UnsupportedEncodingException;
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
@RequestMapping("/industryInfo")
public class IndustryInfoController {

	@Resource
	OrgArticleService orgArticleService;
	
	@Resource
	OrgArticleClassService orgArticleClassService;
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String list(HttpSession session,Model model,OrgArticleQuery query){
		OrgUsersSession user  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		//行业资讯
		OrgArticleClass articleClassIndustryInfo = orgArticleClassService.queryClassByClassName(PcPropertiesUtil.getProperty("industryInfo"));
		//显示项文章列表
		List<OrgArticle> listArticle = orgArticleService.queryListByClassidAndShopId(articleClassIndustryInfo.getId().shortValue(),user.getOrgShop().getShopId());
		model.addAttribute("listArticle",listArticle);
		model.addAttribute("query",query);
		return "industryInfo/list";
	}
	
	@RequestMapping(value = "/desc", method = { RequestMethod.GET,RequestMethod.POST })
	public String desc(HttpSession session, OrgArticleQuery query,Model model) throws UnsupportedEncodingException{
		//文章
		OrgArticle article = orgArticleService.queryVoById(query.getId());
		model.addAttribute("article",article);
		return "industryInfo/desc";
	}
}
