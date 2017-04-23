package com.kjj.pc.web.controller.consult;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kjj.commserver.entity.consult.OrgConsultAnswer;
import com.kjj.commserver.entity.consult.OrgConsultProblem;
import com.kjj.commserver.entity.consult.OrgConsultType;
import com.kjj.commserver.entity.consult.aide.OrgConsultAnswerQuery;
import com.kjj.commserver.entity.consult.aide.OrgConsultClassConstant;
import com.kjj.commserver.entity.consult.aide.OrgConsultProblemConstant;
import com.kjj.commserver.entity.consult.aide.OrgConsultProblemQuery;
import com.kjj.commserver.entity.consult.aide.OrgConsultProblemVo;
import com.kjj.commserver.entity.consult.aide.OrgConsultTypeQuery;
import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAll;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.consult.OrgConsultAnswerService;
import com.kjj.commserver.service.consult.OrgConsultProblemService;
import com.kjj.commserver.service.consult.OrgConsultTypeService;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.pc.constant.SessionConstant;
import com.kjj.pc.util.PageReq;


@Controller
@RequestMapping("/consultation")
public class ConsultationController {
	
	@Resource
	private OrgShopService orgShopService;
	
	@Resource
	private OrgConsultProblemService orgConsultProblemService;
	
	@Resource
	OrgClassService orgClassService;
	
	@Resource
	OrgUsersService orgUsersService;
	
	@Resource
	OrgConsultAnswerService orgConsultAnswerService;

	@Resource
	OrgConsultTypeService orgConsultTypeService;
	
	@Resource
	OrgProductItemService orgProductItemService;
	
	@RequestMapping(value="/personalList", method = {RequestMethod.GET, RequestMethod.POST})
	public String personalList(Model model, HttpSession session,PageReq pageReq,OrgConsultProblemQuery query){
		OrgUsersSession user  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		query.setCreateUser(user.getOrgUsers().getUserId());
		//获取咨询列表
		Page<OrgConsultProblem> page = orgConsultProblemService.queryList4Goods(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		return "/consult/personalList";
	}
	
	@RequestMapping(value="/personalWebList", method = {RequestMethod.GET, RequestMethod.POST})
	public String personalWebList(Model model, HttpSession session,PageReq pageReq,OrgConsultProblemQuery query){
		OrgUsersSession user  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		query.setCreateUser(user.getOrgUsers().getUserId());
		query.setConsultClassId(OrgConsultProblemConstant.CONSULT_CLASS_WEB);
		query.setGoodsId(0);
		Sort sort=new Sort(Direction.DESC,"t.create_time");
		pageReq.setSort(sort);
		//获取咨询列表
		Page<OrgConsultProblem> page = orgConsultProblemService.queryList4Web(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		return "/consult/personalWebList";
	}
	
	@RequestMapping(value="/personalView/{consultProblemId}", method = {RequestMethod.GET, RequestMethod.POST})
	public String personalView(Model model,@PathVariable(value = "consultProblemId") Integer consultProblemId){
		OrgConsultProblemVo orgConsultProblem = orgConsultProblemService.queryVoById(consultProblemId);
		OrgConsultAnswerQuery query =new OrgConsultAnswerQuery();
		query.setConsultProblemId(orgConsultProblem.getConsultProblemId());
		List<OrgConsultAnswer> listOrgConsultAnswer = orgConsultAnswerService.queryList(query);
		orgConsultProblem.setListOrgConsultAnswer(listOrgConsultAnswer);
		model.addAttribute("orgConsultProblem", orgConsultProblem);
		return "/consult/personalView";
	}
	
	//商品咨询列表
	@RequestMapping(value="/itemList", method = {RequestMethod.GET, RequestMethod.POST})
	public String itemList(Model model, HttpSession session,PageReq pageReq,OrgConsultProblemQuery query){
		//分类信息
	    List<OrgClass> listClass = orgClassService.queryListShowAsTree();
	    model.addAttribute("listClass", listClass);
	    
	    //商品咨询类型
	    OrgConsultTypeQuery orgConsultTypeQuery=new OrgConsultTypeQuery();
	    orgConsultTypeQuery.setConsultClassId(OrgConsultProblemConstant.CONSULT_CLASS_GOODS);
	    orgConsultTypeQuery.setIsActive(OrgConsultProblemConstant.CONSULT_ACTIVE_YES);
	    orgConsultTypeQuery.setIsDelete(OrgConsultProblemConstant.CONSULT_DELETE_NO);
	    List<OrgConsultType> orgConsultTypeList = orgConsultTypeService.queryList(orgConsultTypeQuery);
	    model.addAttribute("orgConsultTypeList", orgConsultTypeList);
	    
	    //商品咨询
		Sort sort=new Sort(Direction.DESC,"t.create_time");
		pageReq.setSort(sort);
		query.setIsActive(OrgConsultProblemConstant.CONSULT_ACTIVE_YES);
		query.setIsDelete(OrgConsultProblemConstant.CONSULT_DELETE_NO);
		query.setConsultClassId(OrgConsultClassConstant.CONSULT_CLASS_ITEM);
		Page<OrgConsultProblem> orgConsultProblemPage = orgConsultProblemService.queryPageList(query, pageReq);
		 for (OrgConsultProblem orgConsultProblem : orgConsultProblemPage) {
			 OrgConsultProblemVo orgConsultProblemVo=(OrgConsultProblemVo) orgConsultProblem;
			 OrgConsultAnswerQuery orgConsultAnswerQuery=new OrgConsultAnswerQuery();
			 orgConsultAnswerQuery.setConsultProblemId(orgConsultProblem.getConsultProblemId());
			 List<OrgConsultAnswer> listOrgConsultAnswer = orgConsultAnswerService.queryList(orgConsultAnswerQuery);
			 orgConsultProblemVo.setListOrgConsultAnswer(listOrgConsultAnswer);
			 OrgUsers createUser = orgUsersService.queryById(orgConsultProblem.getCreateUser());
			 orgConsultProblemVo.setCreateUserName(createUser==null? "":createUser.getUserName());
		}
		 OrgUsersSession orgUsersSession = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		 OrgProductItemAll orgProductItemAll = orgProductItemService.query4View(orgUsersSession,query.getGoodsId());
		 model.addAttribute("query", query);
		model.addAttribute("page", orgConsultProblemPage);
		model.addAttribute("orgProductItemAll", orgProductItemAll);
		return "/consult/itemList";
	}
	
	//添加咨询
	@RequestMapping(value="/add", method = {RequestMethod.GET, RequestMethod.POST})
	public String add(Model model, HttpSession session,OrgConsultProblem orgConsultProblem){
		OrgUsersSession user  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		orgConsultProblem.setCreateUser(user.getOrgUsers().getUserId());
		orgConsultProblem.setIsActive(OrgConsultProblemConstant.CONSULT_ACTIVE_YES);
		orgConsultProblem.setIsDelete(OrgConsultProblemConstant.CONSULT_DELETE_NO);
		orgConsultProblem.setConsultClassId(orgConsultProblem.getConsultClassId());
		orgConsultProblem.setCreateTime(new Date());
		orgConsultProblem.setReplyState(OrgConsultProblemConstant.CONSULT_REPLY_STATE_NO); //未回复
		orgConsultProblem.setSolveState(OrgConsultProblemConstant.CONSULT_SOLVE_STATE_TODO); //未处理
		orgConsultProblemService.add(orgConsultProblem);
		model.addAttribute("goodsId", orgConsultProblem.getGoodsId());
		if(orgConsultProblem.getConsultClassId()==OrgConsultProblemConstant.CONSULT_CLASS_WEB){
			return "redirect:/consultation/personalWebList";
		}else{
			return "redirect:/consultation/itemList";			
		}
	}
	
	//添加网站咨询页面
	@RequestMapping(value="/addView", method = {RequestMethod.GET, RequestMethod.POST})
	public String addView(Model model, HttpSession session,OrgConsultTypeQuery query){
	    query.setConsultClassId(OrgConsultProblemConstant.CONSULT_CLASS_WEB);
	    query.setIsActive(OrgConsultProblemConstant.CONSULT_ACTIVE_YES);
	    query.setIsDelete(OrgConsultProblemConstant.CONSULT_DELETE_NO);
	    List<OrgConsultType> orgConsultTypeList = orgConsultTypeService.queryList(query);
	    model.addAttribute("orgConsultTypeList", orgConsultTypeList);
		return "/consult/addView";
	}
	//添加网站咨询页面(前台用户回复后台用户)
	@RequestMapping(value="/personalReply", method = {RequestMethod.GET, RequestMethod.POST})
	public String personalReply(Model model, HttpSession session,OrgConsultAnswer orgConsultAnswer){
		OrgUsersSession user  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		orgConsultAnswerService.syncWebReply(user.getOrgUsers().getUserId(), orgConsultAnswer);
		return "redirect:/consultation/personalWebList";
	}
	
}
