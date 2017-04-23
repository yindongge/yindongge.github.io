package com.kjj.manage.web.controller.consult;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.consult.OrgConsultAnswer;
import com.kjj.commserver.entity.consult.OrgConsultProblem;
import com.kjj.commserver.entity.consult.OrgConsultState;
import com.kjj.commserver.entity.consult.OrgConsultType;
import com.kjj.commserver.entity.consult.aide.OrgConsultAnswerConstant;
import com.kjj.commserver.entity.consult.aide.OrgConsultAnswerVo;
import com.kjj.commserver.entity.consult.aide.OrgConsultProblemGoodsVo;
import com.kjj.commserver.entity.consult.aide.OrgConsultProblemQuery;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.service.consult.OrgConsultAnswerService;
import com.kjj.commserver.service.consult.OrgConsultProblemService;
import com.kjj.commserver.service.consult.OrgConsultStateService;
import com.kjj.commserver.service.consult.OrgConsultTypeService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.constant.SessionConstant;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("/consultation")
public class ConsultationController {
	
	@Autowired
	private OrgConsultTypeService orgConsultTypeService;
	
	@Autowired
	private OrgConsultProblemService orgConsultProblemService;
	
	@Autowired
	private OrgConsultAnswerService orgConsultAnswerService;
	
	@Autowired
	private OrgConsultStateService orgConsultStateService;
	
	@RequestMapping(value="/productConsultationList", method = {RequestMethod.GET, RequestMethod.POST})
	public String personalList(Model model, HttpSession session,PageReq pageReq,OrgConsultProblemQuery query){
		
		
		//获取咨询列表
		Sort sort=new Sort(Direction.DESC,"t.create_time");
		pageReq.setSort(sort);
		Page<OrgConsultProblem> page = orgConsultProblemService.queryPageListGoods(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		//获取咨询类型
		List<OrgConsultType> consultTypeList = orgConsultTypeService.queryByConsultType(query.getConsultClassId());
		model.addAttribute("consultTypeList", consultTypeList);
		//获取状态
		List<OrgConsultState> consultStateList = orgConsultStateService.queryByConsultState();
		model.addAttribute("consultStateList", consultStateList);
		
		return "consutation/productConsultationList";
	}
	
	@RequestMapping(value="/productConsultationReplyView", method = {RequestMethod.GET,RequestMethod.POST})
	public String productConsultationReplyView(Model model,OrgConsultProblemQuery query){
		OrgConsultProblemGoodsVo orgConsultProblem = (OrgConsultProblemGoodsVo) orgConsultProblemService.queryByGoodsId(query.getConsultProblemId());
		List<OrgConsultAnswerVo> orgConsultAnswer = orgConsultAnswerService.queryByCousultAnswer(query.getConsultProblemId());
		model.addAttribute("orgConsultProblem", orgConsultProblem);
		model.addAttribute("orgConsultAnswer", orgConsultAnswer);
		return "consutation/productConsultationReplyView";
	}
	
	@ResponseBody
	@RequestMapping(value="/productConsultationReply", method = {RequestMethod.GET,RequestMethod.POST})
	public Map<String, Object> productConsultationReply(Model model, HttpSession session,OrgConsultProblemQuery query){
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		Map<String, Object> map = new HashMap<String, Object>();
		OrgConsultProblem orgConsultProblem = orgConsultProblemService.queryById(query.getConsultProblemId());
		Byte replyState = orgConsultProblem.getReplyState();
		if(replyState!=2){
			OrgConsultAnswer orgConsultAnswer= new OrgConsultAnswer();
			orgConsultAnswer.setConsultAnswer(query.getConsultAnswer());
			orgConsultAnswer.setConsultProblemId(query.getConsultProblemId());
			orgConsultAnswer.setFromUser(admin.getOrgAdminUser().getUserId().intValue());
			orgConsultAnswer.setIsActive(OrgConsultAnswerConstant.IS_ACTIVE_START);
			orgConsultAnswer.setIsDelete(OrgConsultAnswerConstant.IS_DELETE_NO);
			orgConsultAnswer.setReplyState(OrgConsultAnswerConstant.REPLY_STATE_1);		
			orgConsultAnswer.setToUser(orgConsultProblem.getCreateUser());
			orgConsultAnswer.setCreateUserType(OrgConsultAnswerConstant.USER_TYPE_ADMIN);
			orgConsultAnswer.setCreateTime(new Date());
			orgConsultAnswerService.add(orgConsultAnswer);
			orgConsultProblem.setReplyState(OrgConsultAnswerConstant.REPLY_STATE_2);
			orgConsultProblemService.updateByIdSelective(orgConsultProblem);
			map.put("code",HttpStatusCode.CODE_SUCCESS);
		}else{
			map.put("code", HttpStatusCode.CODE_ERROR);
		}		
		return map;
	}
	
	@RequestMapping(value="/webConsultationList", method = {RequestMethod.GET,RequestMethod.POST})
	public String webConsultationList(Model model,PageReq pageReq,OrgConsultProblemQuery query){
		
		Sort sort=new Sort(Direction.DESC,"t.create_time");
		pageReq.setSort(sort);
		Page<OrgConsultProblem> page = orgConsultProblemService.queryPageListWeb(query, pageReq);
		model.addAttribute("page", page);
		//获取咨询类型
		List<OrgConsultType> consultTypeList = orgConsultTypeService.queryByConsultType(query.getConsultClassId());
		model.addAttribute("consultTypeList", consultTypeList);
		//获取回复状态
		List<OrgConsultState> consultStateList = orgConsultStateService.queryByConsultState();
		model.addAttribute("consultStateList", consultStateList);
		//获取处理状态
		List<OrgConsultState> resolveStateList = orgConsultStateService.queryByConsultStateType();
		model.addAttribute("resolveStateList", resolveStateList);
		model.addAttribute("query", query);
		return "/consutation/webConsultationList";
	}
	

	@RequestMapping(value="/webConsultationReplyView", method = {RequestMethod.GET,RequestMethod.POST})
	public String webConsultationReplyView(Model model,OrgConsultProblemQuery query){
		OrgConsultProblemGoodsVo orgConsultProblem = (OrgConsultProblemGoodsVo) orgConsultProblemService.queryByGoodsId(query.getConsultProblemId());
		List<OrgConsultAnswerVo> orgConsultAnswer = orgConsultAnswerService.queryByCousultAnswer(query.getConsultProblemId());
		model.addAttribute("orgConsultProblem", orgConsultProblem);
		model.addAttribute("consultAnswerList", orgConsultAnswer);
		return "consutation/webConsultationReplyView";
	}
	
	

	@ResponseBody
	@RequestMapping(value="/webConsultationReply", method = {RequestMethod.GET,RequestMethod.POST})
	public Map<String, Object> webConsultationReply(Model model, HttpSession session,OrgConsultProblemQuery query){
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		Map<String, Object> map = new HashMap<String, Object>();
		OrgConsultProblem orgConsultProblem = orgConsultProblemService.queryById(query.getConsultProblemId());
		Byte replyState = orgConsultProblem.getReplyState();
		if(replyState!=2){
			OrgConsultAnswer orgConsultAnswer= new OrgConsultAnswer();
			orgConsultAnswer.setConsultAnswer(query.getConsultAnswer());
			orgConsultAnswer.setConsultProblemId(query.getConsultProblemId());
			orgConsultAnswer.setFromUser(admin.getOrgAdminUser().getUserId().intValue());
			orgConsultAnswer.setIsActive(OrgConsultAnswerConstant.IS_ACTIVE_START);
			orgConsultAnswer.setIsDelete(OrgConsultAnswerConstant.IS_DELETE_NO);
			orgConsultAnswer.setReplyState(OrgConsultAnswerConstant.REPLY_STATE_1);		
			orgConsultAnswer.setToUser(orgConsultProblem.getCreateUser());
			orgConsultAnswer.setCreateUserType(OrgConsultAnswerConstant.USER_TYPE_ADMIN);
			orgConsultAnswer.setCreateTime(new Date());
			orgConsultAnswerService.add(orgConsultAnswer);
			orgConsultProblem.setReplyState(OrgConsultAnswerConstant.REPLY_STATE_2);
			orgConsultProblemService.updateByIdSelective(orgConsultProblem);
			orgConsultProblem.setSolveState(query.getSolveState());
			orgConsultProblemService.updateByIdSelective(orgConsultProblem);
			map.put("code",HttpStatusCode.CODE_SUCCESS);
		}else{
			map.put("code", HttpStatusCode.CODE_ERROR);
		}		
		return map;
	}
}
