package com.kjj.manage.web.controller.account;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.account.OrgAccountDeposit;
import com.kjj.commserver.entity.account.OrgAccountDepositApply;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositApplyConstant;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositApplyForm;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositApplyQuery;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositApplyVo;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.service.account.OrgAccountDepositApplyService;
import com.kjj.commserver.service.account.OrgAccountDepositRecordsService;
import com.kjj.commserver.service.account.OrgAccountDepositService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.constant.SessionConstant;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("depositApply")
public class DepositApplyController {
	
	@Resource
	private OrgAccountDepositApplyService orgAccountDepositApplyService;
	
	@Resource
	private OrgAccountDepositService orgAccountDepositService;
	
	@Resource
	private OrgAccountDepositRecordsService orgAccountDepositRecordsService;
	
	
	/**
	 * 预存款申请分页查询-财务人员使用
	 * @param session
	 * @param model
	 * @param pageReq
	 * @param query
	 * @return
	 */
	@RequestMapping(value ="/applyList", method = { RequestMethod.GET, RequestMethod.POST })
	public String applyList(Model model, PageReq pageReq, OrgAccountDepositApplyQuery query){
		
		pageReq.setSort(new Sort(Direction.DESC,"t.create_time"));
		pageReq.setPageSize(20);
		
		Page<OrgAccountDepositApplyVo> page = orgAccountDepositApplyService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		model.addAttribute("statusMap", OrgAccountDepositApplyConstant.statusMap);
		model.addAttribute("typeMap", OrgAccountDepositApplyConstant.typeMap);
		model.addAttribute("payStyleMap", OrgAccountDepositApplyConstant.payStyleMap);
		model.addAttribute("sourceMap", OrgAccountDepositApplyConstant.sourceMap);
		model.addAttribute("reasonMap", OrgAccountDepositApplyConstant.reasonMap);
		
		return "account/depositApplyList";
	}
	
	/**
	 * 预存款申请分页查询-管理人员使用
	 * @param session
	 * @param model
	 * @param pageReq
	 * @param query
	 * @return
	 */
	@RequestMapping(value ="/applySimpleList", method = { RequestMethod.GET, RequestMethod.POST })
	public String applySimpleList(Model model, PageReq pageReq, OrgAccountDepositApplyQuery query){
		
		pageReq.setSort(new Sort(Direction.DESC,"t.create_time"));
		pageReq.setPageSize(20);
		
		Page<OrgAccountDepositApplyVo> page = orgAccountDepositApplyService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		model.addAttribute("statusMap", OrgAccountDepositApplyConstant.statusMap);
		model.addAttribute("typeMap", OrgAccountDepositApplyConstant.typeMap);
		model.addAttribute("payStyleMap", OrgAccountDepositApplyConstant.payStyleMap);
		model.addAttribute("sourceMap", OrgAccountDepositApplyConstant.sourceMap);
		model.addAttribute("reasonMap", OrgAccountDepositApplyConstant.reasonMap);
		
		return "account/depositApplySimpleList";
	}
	
	/**
	 * 
	 * @param model
	 * @param pageId 页面来源标识
	 * @return
	 */
	@RequestMapping(value ="/applyAdd", method = { RequestMethod.GET, RequestMethod.POST })
	public String applyAdd(Model model,String pageId){
		Map<String,String> depositTypeMap = new LinkedHashMap<String,String>();    // 预存款类型
		depositTypeMap.put("1", "可用可提现金额");
		depositTypeMap.put("2", "可用不可提现金额");
		depositTypeMap.put("3", "冻结金额");
		
		model.addAttribute("depositTypeMap", depositTypeMap);
		
		model.addAttribute("reasonMap", OrgAccountDepositApplyConstant.reasonMap); // 原因
		
		model.addAttribute("pageId", pageId);
		
		
		return "account/depositApplyAdd";
	}
	
	@RequestMapping(value ="/applyBatchAdd", method = { RequestMethod.GET, RequestMethod.POST })
	public String applyBatchAdd(Model model){
		Map<String,String> depositTypeMap = new LinkedHashMap<String,String>();    // 预存款类型
		depositTypeMap.put("2", "可用不可提现金额");
		model.addAttribute("depositTypeMap", depositTypeMap);
		
		model.addAttribute("payStyleMap", OrgAccountDepositApplyConstant.payStyleMap);
		
		
		
		return "account/depositBatchApplyAdd";
	}
	
	
	/**
	 * 查询会员账户信息
	 * @param groupUser
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/queryUserAccountDeposit", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> queryUserAccountDeposit(Integer userId){
		Map<String, Object> result=new HashMap<String, Object>();
		
		OrgAccountDeposit query = new OrgAccountDeposit();
		query.setUserId(userId);
		
		OrgAccountDeposit deposit = orgAccountDepositService.queryOne(query);
		
		if(null == deposit) {
			result.put("code", "300"); // 会员没有账户信息
		} else {
			result.put("foundAmount", deposit.getFundAmount());
			result.put("allowanceAmount", deposit.getAllowanceAmount());
			result.put("frozenAmount", deposit.getFrozenAmount());
		}
		
		return result;
	}
	
	/**
	 * 保存申请
	 * @param groupUser
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/applySave", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> applySave(HttpSession session,OrgAccountDepositApplyForm depositApply){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		depositApply.setCreateId(admin.getOrgAdminUser().getUserId().intValue());
		depositApply.setCreateName(admin.getOrgAdminUser().getUserName());
		
		orgAccountDepositApplyService.addOneApply(depositApply);
		
		resultMap.put("code", HttpStatusCode.CODE_SUCCESS);
		
		return resultMap;
	}
	
	/**
	 * 保存批量申请
	 * @param groupUser
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/applyBatchSave", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> applyBatchSave(HttpSession session,OrgAccountDepositApplyForm depositApply){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		depositApply.setCreateId(admin.getOrgAdminUser().getUserId().intValue());
		depositApply.setCreateName(admin.getOrgAdminUser().getUserName());
		
		orgAccountDepositApplyService.addBatchApply(depositApply);
		
		resultMap.put("code", HttpStatusCode.CODE_SUCCESS);
		
		return resultMap;
	}
	
	/**
	 * 审核预付款申请
	 * @param model
	 * @return
	 */
	@RequestMapping(value ="/applyCheck", method = { RequestMethod.GET, RequestMethod.POST })
	public String applyCheck(Model model,Integer id){
		OrgAccountDepositApplyVo oada = orgAccountDepositApplyService.queryVoById(id);
		model.addAttribute("depositApply", oada);
		
		model.addAttribute("reasonMap", OrgAccountDepositApplyConstant.reasonMap);
		model.addAttribute("typeMap", OrgAccountDepositApplyConstant.typeMap);
		return "account/depositApplyCheck";
	}
	
	/**
	 * 申请详细-当个
	 * @param model
	 * @param id
	 * @param pageId 页面来源标识
	 * @return
	 */
	@RequestMapping(value ="/applyDetail", method = { RequestMethod.GET, RequestMethod.POST })
	public String applyDetail(Model model,Integer id, String pageId){
		OrgAccountDepositApplyVo oada = orgAccountDepositApplyService.queryVoById(id);
		model.addAttribute("depositApply", oada);
		
		model.addAttribute("reasonMap", OrgAccountDepositApplyConstant.reasonMap);
		model.addAttribute("typeMap", OrgAccountDepositApplyConstant.typeMap);
		model.addAttribute("statusMap", OrgAccountDepositApplyConstant.statusMap);
		
		model.addAttribute("pageId", pageId);
		
		return "account/depositApplyDetail";
	}
	
	/**
	 * 
	 * @param model
	 * @param id
	 * @param pageId 页面来源标识
	 * @return
	 */
	@RequestMapping(value ="/applyBatchDetail", method = { RequestMethod.GET, RequestMethod.POST })
	public String applyBatchDetail(Model model,Integer id, String pageId){
		OrgAccountDepositApplyVo oada = orgAccountDepositApplyService.queryVoById(id);
		model.addAttribute("depositApply", oada);
		
		Map<String,String> depositTypeMap = new LinkedHashMap<String,String>();    // 预存款类型
		depositTypeMap.put("2", "可用不可提现金额");
		model.addAttribute("depositTypeMap", depositTypeMap);
		
		// 取得批次的用户列表
		OrgAccountDepositApplyQuery aquery = new OrgAccountDepositApplyQuery();
		aquery.setBatchCode(oada.getBatchCode());
		List<OrgAccountDepositApplyVo> batchList = orgAccountDepositApplyService.queryList(aquery);
		
		model.addAttribute("batchList", batchList);
		
		model.addAttribute("payStyleMap", OrgAccountDepositApplyConstant.payStyleMap);
		
		model.addAttribute("pageId", pageId);
		return "account/depositBatchApplyDetail";
	}
	
	
	/**
	 * 关闭预付款申请
	 * @param groupUser
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/applyClose", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> applyClose(HttpSession session,Integer id, String checkComment){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// 前置条件校验
		OrgAccountDepositApply old = orgAccountDepositApplyService.queryVoById(id);
		// 如果状态不是待处理
		if(!old.getStatus().equals(OrgAccountDepositApplyConstant.STATUS_DEAL_WAIT)){
			resultMap.put("code", 600); // 600代表状态已经改变
			return resultMap;
		}
		OrgAccountDepositApply oada = new OrgAccountDepositApply();
		oada.setId(id);
		oada.setStatus(OrgAccountDepositApplyConstant.STATUS_DEAL_CLOSE);
		oada.setCheckComment(checkComment);
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		
		oada.setCheckId(admin.getOrgAdminUser().getUserId().intValue());
		oada.setCheckName(admin.getOrgAdminUser().getUserName());
		oada.setCheckTime(new Date());
		
		orgAccountDepositApplyService.updateByIdSelective(oada);
		
		resultMap.put("code", HttpStatusCode.CODE_SUCCESS);
		
		return resultMap;
	}
	
	/**
	 * 执行预付款申请
	 * @param groupUser
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/applyExec", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> applyExec(HttpSession session,Integer id, String checkComment){
		Map<String, Object> resultMap = new HashMap<String, Object>();

		// 前置条件校验
		OrgAccountDepositApply apply = orgAccountDepositApplyService.queryVoById(id);
		// 如果状态不是待处理
		if(!apply.getStatus().equals(OrgAccountDepositApplyConstant.STATUS_DEAL_WAIT)){
			resultMap.put("code", 600); // 600代表状态已经改变
			return resultMap;
		}

		apply.setCheckComment(checkComment);
		OrgAdminUserSession admin = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		
		apply.setCheckId(admin.getOrgAdminUser().getUserId().intValue());
		apply.setCheckName(admin.getOrgAdminUser().getUserName());
		apply.setCheckTime(new Date());
	
		orgAccountDepositApplyService.updateStatus(apply, resultMap);
		
		return resultMap;
	}
	
	
	
}
