package com.kjj.pc.web.controller.article;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.article.OrgArticle;
import com.kjj.commserver.entity.article.OrgArticleClass;
import com.kjj.commserver.entity.article.aide.OrgArticleQuery;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.article.OrgArticleClassService;
import com.kjj.commserver.service.article.OrgArticleService;
import com.kjj.pc.constant.HttpStatusCode;
import com.kjj.pc.constant.SessionConstant;
import com.kjj.pc.util.PcPropertiesUtil;

@Controller
public class HelpCenterController {

	@Resource
	OrgArticleService orgArticleService;
	@Resource
	OrgArticleClassService orgArticleClassService;
	
	@ResponseBody
	@RequestMapping(value="/foot")
	public Map<String,Object> loadFloor(HttpSession session) {
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		Map<String,Object> mapResult = new HashMap<String,Object>();
		if(orgUsersSession != null && orgUsersSession.getOrgShop() != null){
			OrgArticleClass articleClassHelpCenter = orgArticleClassService.queryClassByClassName(PcPropertiesUtil.getProperty("helpCenter"));
			List<OrgArticleClass> listArticleClass = orgArticleClassService.queryListByParentidAndShopIdWithArticle(articleClassHelpCenter.getId(), orgUsersSession.getOrgShop().getShopId());
			mapResult.put("code",HttpStatusCode.CODE_SUCCESS);
			mapResult.put("listArticleClass",listArticleClass);
		}else{
			mapResult.put("code",HttpStatusCode.CODE_ERROR);
		}
		return mapResult;
	}
	
	@RequestMapping(value = "/helpCenter/desc", method = { RequestMethod.GET,RequestMethod.POST })
	public String desc(HttpSession session, OrgArticleQuery query,Model model) throws UnsupportedEncodingException{
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		//常见问题
		OrgArticleClass articleClassHelpCenter = orgArticleClassService.queryClassByClassName(PcPropertiesUtil.getProperty("helpCenter"));
		//菜单
		List<OrgArticleClass> listArticleClass = orgArticleClassService.queryListByParentidAndShopIdWithArticle(articleClassHelpCenter.getId(),orgUsersSession.getOrgShop().getShopId());
		//文章
		OrgArticle article = orgArticleService.queryVoById(query.getId());
		//显示项
		OrgArticleClass articleClass = orgArticleClassService.queryById(article.getClassid().intValue());
		//显示项文章列表
		List<OrgArticle> listArticle = orgArticleService.queryListByClassidAndShopId(article.getClassid(),orgUsersSession.getOrgShop().getShopId());
		model.addAttribute("listArticleClass",listArticleClass);
		model.addAttribute("listArticle",listArticle);
		model.addAttribute("articleClass",articleClass);
		model.addAttribute("article",article);
		return "helpCenter/desc";
	}
}
