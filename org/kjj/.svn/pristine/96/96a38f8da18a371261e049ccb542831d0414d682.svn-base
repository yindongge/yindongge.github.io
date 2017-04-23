package com.kjj.manage.web.controller.article;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.article.OrgArticleClass;
import com.kjj.commserver.entity.article.aide.OrgArticleClassConstant;
import com.kjj.commserver.service.article.OrgArticleClassService;
import com.kjj.commserver.service.article.OrgArticleService;
import com.kjj.commserver.service.article.OrgArticleShopService;
import com.kjj.commserver.service.shop.OrgAreaService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.manage.constant.HttpStatusCode;

@Controller
@RequestMapping("/articleClass")
public class ArticleClassController {

	@Resource
	private OrgArticleClassService orgArticleClassService;

	@Resource
	private OrgArticleService orgArticleService;

	@Resource
	private OrgShopService orgShopService;

	@Resource
	private OrgArticleShopService orgArticleShopService;

	@Resource
	private OrgAreaService orgAreaService;

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(HttpSession session, HttpServletResponse response, Model model) {
		List<OrgArticleClass> list = orgArticleClassService.getArticleClassTree(OrgArticleClassConstant.PARENT_ID_ROOT);
		model.addAttribute("classList", list);
		return "article/classlist";
	}

	@RequestMapping(value = "/add", method = { RequestMethod.GET,RequestMethod.POST })
	public String add(HttpSession session, HttpServletResponse response,
			Model model) {

		// 获取分类 所有一级二级分类
		List<OrgArticleClass> lsAll = new ArrayList<OrgArticleClass>();
		List<OrgArticleClass> ls = orgArticleClassService.queryListByParentid(-1);
		for (int i = 0; i < ls.size(); i++) {
			OrgArticleClass o = ls.get(i);
			lsAll.add(o);
			List<OrgArticleClass> ls_ = orgArticleClassService.queryListByParentid(o.getId());
			if (ls_ != null) {
				lsAll.addAll(ls_);
			}
		}

		// 获取所有
		model.addAttribute("ls", lsAll);
		return "article/classadd";
	}

	@RequestMapping(value = "/edit/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public String edit(@PathVariable Integer id, Model model) {
		OrgArticleClass orgArticleClass = orgArticleClassService.queryById(id);
		model.addAttribute("obj", orgArticleClass);
		List<OrgArticleClass> listAll = new ArrayList<OrgArticleClass>();
		List<OrgArticleClass> list = orgArticleClassService.queryListByParentid(OrgArticleClassConstant.PARENT_ID_ROOT);

		for (int i = 0; i < list.size(); i++) {
			OrgArticleClass oac = list.get(i);
			listAll.add(oac);
			List<OrgArticleClass> ls_ = orgArticleClassService
					.queryListByParentid(oac.getId());
			if (ls_ != null) {
				listAll.addAll(ls_);
			}
		}

		// 获取所有
		model.addAttribute("list", listAll);
		return "article/classedit";
	}

	@ResponseBody
	@RequestMapping(value = "/save", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> save(OrgArticleClass orgArticleClass) {
		Map<String, Object> result = new HashMap<String, Object>();
		if (orgArticleClass.getId() == null) {
			orgArticleClass.setCreatetime(new Date());
			orgArticleClass.setIsvalide(Short.parseShort(String.valueOf(1)));
			orgArticleClassService.add(orgArticleClass);
		} else {
			orgArticleClassService.updateByIdSelective(orgArticleClass);
		}
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/delete/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> delete(@PathVariable Integer id) {
		Map<String, Object> result = new HashMap<String, Object>();
		orgArticleClassService.deleteById(id);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;

	}
}