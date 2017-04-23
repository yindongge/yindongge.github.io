package com.kjj.manage.web.controller.account;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kjj.commserver.entity.account.aide.OrgAccountDepositApplyConstant;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositRecordsConstant;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositRecordsQuery;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositRecordsVo;
import com.kjj.commserver.service.account.OrgAccountDepositRecordsService;
import com.kjj.manage.util.PageReq;


@Controller
@RequestMapping("depositAccount")
public class DepositController {
	@Resource
	private OrgAccountDepositRecordsService orgAccountDepositRecordsService;
	
	@RequestMapping(value ="/recordsList", method = { RequestMethod.GET, RequestMethod.POST })
	public String recordsList(Model model, PageReq pageReq, OrgAccountDepositRecordsQuery query){
		
		pageReq.setSort(new Sort(Direction.DESC,"t.create_time"));
		pageReq.setPageSize(20);
		
		Page<OrgAccountDepositRecordsVo> page = orgAccountDepositRecordsService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		
		// 字典翻译
		model.addAttribute("originMap", OrgAccountDepositRecordsConstant.originMap); // 来源
		model.addAttribute("typeMap", OrgAccountDepositApplyConstant.typeMap); // 类型
		model.addAttribute("reasonMap", OrgAccountDepositApplyConstant.reasonMap); // 原因
		
		return "account/depositRecordsList";
	}
}
