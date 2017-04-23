package com.kjj.manage.web.controller.order;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.order.OrgGoodsComment;
import com.kjj.commserver.entity.order.aide.OrgGoodsCommentQuery;
import com.kjj.commserver.service.order.OrgGoodsCommentService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@Resource
	private OrgGoodsCommentService orgGoodsCommentService;
	
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String list(Model model, PageReq pageReq,OrgGoodsCommentQuery query){
		
		model.addAttribute("query", query);
		Sort sort = new Sort(Direction.DESC,"t.id");
		pageReq.setSort(sort);
		Page<OrgGoodsComment> page = orgGoodsCommentService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		
		return "comment/list";
	}
	
	@RequestMapping(value = "/detail/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public String detail(@PathVariable Integer id,Model model){
		OrgGoodsComment orgGoodsComment = orgGoodsCommentService.queryVoById(id);
		model.addAttribute("orgGoodsComment", orgGoodsComment);
		
		return "comment/detail";
	}
	
	@ResponseBody
	@RequestMapping(value = "/hidden/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> delete(@PathVariable Integer id) {
		Map<String, Object> result = new HashMap<String, Object>();
		orgGoodsCommentService.updateHide(id);
		result.put("code", HttpStatusCode.CODE_SUCCESS);

		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/show/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> show(@PathVariable Integer id) {
		Map<String, Object> result = new HashMap<String, Object>();
		orgGoodsCommentService.updateShow(id);
		result.put("code", HttpStatusCode.CODE_SUCCESS);

		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/reply", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> reply(OrgGoodsComment orgGoodsComment) {
		Map<String, Object> result = new HashMap<String, Object>();
		orgGoodsCommentService.updateReply(orgGoodsComment);
		result.put("code", HttpStatusCode.CODE_SUCCESS);

		return result;
	}

}
