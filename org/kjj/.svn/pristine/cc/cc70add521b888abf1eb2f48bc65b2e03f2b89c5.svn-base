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
import com.kjj.commserver.entity.article.aide.OrgArticleClassVo;
import com.kjj.commserver.entity.article.aide.OrgArticleQuery;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.article.OrgArticleClassService;
import com.kjj.commserver.service.article.OrgArticleService;
import com.kjj.pc.constant.SessionConstant;
import com.kjj.pc.util.PcPropertiesUtil;

@Controller
@RequestMapping("/usualProblem")
public class UsualProblemController {

	@Resource
	OrgArticleService orgArticleService;
	
	@Resource
	OrgArticleClassService orgArticleClassService;
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String list(HttpSession session,Model model,OrgArticleQuery query){
		
		OrgUsersSession user  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		
		//常见问题
		OrgArticleClass articleClassUsualproblem = orgArticleClassService.queryClassByClassName(PcPropertiesUtil.getProperty("usualProblem"));
		//菜单
		List<OrgArticleClass> listArticleClass = orgArticleClassService.queryListByParentidWithSubList(articleClassUsualproblem.getId());
		if(query.getClassid() == null){
			//默认显示第一项
			outer:
			for(OrgArticleClass articleClassOne: listArticleClass){
				for(OrgArticleClass articleClassTwo : ((OrgArticleClassVo)articleClassOne).getListSubClass()){
					query.setClassid(articleClassTwo.getId().shortValue());
					break outer;
				}
			}
		}
		//显示项
		OrgArticleClass articleClass = orgArticleClassService.queryById(query.getClassid().intValue());
		//显示项文章列表
		List<OrgArticle> listArticle = orgArticleService.queryListByClassidAndShopId(query.getClassid(),user.getOrgShop().getShopId());
		model.addAttribute("listArticleClass",listArticleClass);
		model.addAttribute("listArticle",listArticle);
		model.addAttribute("articleClass",articleClass);
		model.addAttribute("query",query);
		return "usualProblem/list";
	}
	
	
	@RequestMapping(value = "/desc", method = { RequestMethod.GET,RequestMethod.POST })
	public String desc(HttpSession session, OrgArticleQuery query,Model model) throws UnsupportedEncodingException{
		OrgUsersSession user  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		//常见问题
		OrgArticleClass articleClassUsualproblem = orgArticleClassService.queryClassByClassName(PcPropertiesUtil.getProperty("usualProblem"));
		//菜单
		List<OrgArticleClass> listArticleClass = orgArticleClassService.queryListByParentidWithSubList(articleClassUsualproblem.getId());
		//文章
		OrgArticle article = orgArticleService.queryVoById(query.getId());
		//显示项
		OrgArticleClass articleClass = orgArticleClassService.queryById(article.getClassid().intValue());
		//显示项文章列表
		List<OrgArticle> listArticle = orgArticleService.queryListByClassidAndShopId(article.getClassid(),user.getOrgShop().getShopId());
		model.addAttribute("listArticleClass",listArticleClass);
		model.addAttribute("listArticle",listArticle);
		model.addAttribute("articleClass",articleClass);
		model.addAttribute("article",article);
		return "usualProblem/desc";
	}
}
