package com.kjj.manage.web.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.account.OrgAccountDeposit;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositConstant;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositQuery;
import com.kjj.commserver.entity.user.OrgUserLevel;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgUsersConstant;
import com.kjj.commserver.entity.user.aide.OrgUsersQuery;
import com.kjj.commserver.service.account.OrgAccountDepositService;
import com.kjj.commserver.service.shop.OrgAreaService;
import com.kjj.commserver.service.user.OrgUserLevelService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("user")
public class UserController {

	@Resource
	OrgUsersService orgUsersService;
	
	@Resource
	OrgUserLevelService orgUserLevelService;
	
	@Resource
	OrgAccountDepositService orgAccountDepositService;
	
	@Autowired
	private OrgAreaService orgAreaService;
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String desc(HttpSession session,Model model, PageReq pageReq,OrgUsersQuery query) {
		pageReq.setSort(new Sort(Direction.DESC,"t.user_id"));
		pageReq.setPageSize(20);
		//query.setNoEnterprise(true); // 过滤企业用户
		Page<OrgUsers> page = orgUsersService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		
		// 查询会员级别
		List<OrgUserLevel> levelList = orgUserLevelService.queryList(null);
		model.addAttribute("levelList", levelList);
		return "user/list";
	}
	
	@RequestMapping(value = "/select", method = { RequestMethod.GET,RequestMethod.POST })
	public String select(HttpSession session,Model model, PageReq pageReq,OrgUsersQuery query) {
		pageReq.setSort(new Sort(Direction.DESC,"t.user_id"));
		pageReq.setPageSize(20);
		//query.setNoEnterprise(true);// 过滤企业用户
		Page<OrgUsers> page = orgUsersService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		return "user/usersSelect";
	}
	
	@RequestMapping(value = "/oneSelect", method = { RequestMethod.GET,RequestMethod.POST })
	public String oneSelect(HttpSession session,Model model, PageReq pageReq,OrgUsersQuery query) {
		pageReq.setSort(new Sort(Direction.DESC,"t.user_id"));
		pageReq.setPageSize(20);
		//query.setNoEnterprise(true);// 过滤企业用户
		Page<OrgUsers> page = orgUsersService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		return "user/usersOneSelect";
	}
	
	@RequestMapping(value = "/desc/{userId}", method = { RequestMethod.GET,RequestMethod.POST })
	public String desc(Model model,@PathVariable Integer userId) {
		OrgUsers orgUsers = orgUsersService.queryVoById(userId);
		OrgAccountDepositQuery query = new OrgAccountDepositQuery();
		query.setUserId(userId);
		OrgAccountDeposit oad = orgAccountDepositService.queryOne(query);
		
		model.addAttribute("orgUsers", orgUsers);
		
		model.addAttribute("accountDeposit", oad);
		return "user/desc";
	}
	
	@ResponseBody
	@RequestMapping(value = "/lock/{userId}", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> lock(@PathVariable Integer userId) {
		Map<String, Object> result = new HashMap<String, Object>();
		orgUsersService.updateStatus(userId, OrgUsersConstant.STATUS_INVALID);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/unLock/{userId}", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> unLock(@PathVariable Integer userId) {
		Map<String, Object> result = new HashMap<String, Object>();
		orgUsersService.updateStatus(userId,  OrgUsersConstant.STATUS_VALID);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	
	@ResponseBody
	@RequestMapping(value ="/lockAccountDeposit", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> accountDepositLock(Integer userId) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		OrgAccountDeposit oad = new OrgAccountDeposit();
		oad.setUserId(userId);
		oad.setStatus(OrgAccountDepositConstant.STATUS_INVALID);// 锁定状态
		oad.setLockLevel(OrgAccountDepositConstant.LOCK_LEVEL_MANAGER); // 管理员操作锁定
		orgAccountDepositService.updateByIdSelective(oad);

		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/unLockAccountDeposit", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> accountDepositUnLock(Integer userId) {
		Map<String, Object> result = new HashMap<String, Object>();

		OrgAccountDeposit oad = new OrgAccountDeposit();
		oad.setUserId(userId);
		oad.setStatus(OrgAccountDepositConstant.STATUS_VALID);// 正常状态
		oad.setLockLevel(OrgAccountDepositConstant.LOCK_LEVEL_SYSTEM); // 改成系统自动
		oad.setErrorNum(0); // 错误次数清零
		orgAccountDepositService.updateByIdSelective(oad);
		
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
}
