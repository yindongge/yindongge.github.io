package com.kjj.pc.web.controller.article;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kjj.commserver.entity.article.OrgArticle;
import com.kjj.commserver.entity.article.OrgArticleClass;
import com.kjj.commserver.service.article.OrgArticleClassService;
import com.kjj.commserver.service.article.OrgArticleService;
import com.kjj.pc.util.PcPropertiesUtil;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	@Resource
	OrgArticleClassService orgArticleClassService;
	@Resource
	OrgArticleService orgArticleService;
	
	@RequestMapping(value = "/dispatcher/{articleId}", method = { RequestMethod.GET,RequestMethod.POST })
	public String dispatcher(HttpSession session,Model model,@PathVariable(value = "articleId")Integer articleId){
		
		OrgArticle article = orgArticleService.queryById(articleId);
		OrgArticleClass articleClass = orgArticleClassService.queryById(article.getClassid().intValue());
		OrgArticleClass rootClass = orgArticleClassService.getRootClass(articleClass);
		String rootClassName = rootClass.getClassName();
		String usualProblem =  PcPropertiesUtil.getProperty("usualProblem");
		String aboutUs =  PcPropertiesUtil.getProperty("aboutUs");
		String industryInfo =  PcPropertiesUtil.getProperty("industryInfo");
		if(rootClassName.equals(usualProblem)){
			return "redirect:/usualProblem/desc?id="+articleId;
		}else if(rootClassName.equals(aboutUs)){
			return "redirect:/aboutUs/desc?id="+articleId;
		}else if(rootClassName.equals(industryInfo)){
			return "redirect:/industryInfo/desc?id="+articleId;
		}else{ 
			return "redirect:/helpCenter/desc?id="+articleId;
		}
	}
}
