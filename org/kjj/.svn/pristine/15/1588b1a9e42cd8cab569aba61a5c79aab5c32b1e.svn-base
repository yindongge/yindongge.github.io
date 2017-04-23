package com.kjj.manage.web.controller.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.account.OrgAccountGroup;
import com.kjj.commserver.entity.account.OrgAccountGroupUser;
import com.kjj.commserver.entity.account.aide.OrgAccountGroupQuery;
import com.kjj.commserver.entity.account.aide.OrgAccountGroupUserQuery;
import com.kjj.commserver.entity.account.aide.OrgAccountGroupUserVo;
import com.kjj.commserver.entity.account.aide.OrgAccountGroupVo;
import com.kjj.commserver.entity.user.OrgEnterpriseUser;
import com.kjj.commserver.service.account.OrgAccountGroupService;
import com.kjj.commserver.service.account.OrgAccountGroupUserService;
import com.kjj.commserver.service.user.OrgEnterpriseUserService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("accountGroup")
public class GroupController {
	@Resource
	private OrgAccountGroupService orgAccountGroupService;
	
	@Resource
	private OrgAccountGroupUserService orgAccountGroupUserService;
	
	@Resource
	private OrgEnterpriseUserService orgEnterpriseUserService;
	
	
	/**
	 * 账户-用户组查询分页
	 * @param session
	 * @param model
	 * @param pageReq
	 * @param query
	 * @return
	 */
	@RequestMapping(value ="/groupList", method = { RequestMethod.GET, RequestMethod.POST })
	public String groupList(HttpSession session,Model model, PageReq pageReq, OrgAccountGroupQuery query){
		
		pageReq.setSort(new Sort(Direction.DESC,"t.create_time"));
		pageReq.setPageSize(20);
		
		Page<OrgAccountGroupVo> page = orgAccountGroupService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		
		return "account/groupList";
	}
	
	/**
	 * 账户-用户组查询分页-选择
	 * @param session
	 * @param model
	 * @param pageReq
	 * @param query
	 * @return
	 */
	@RequestMapping(value ="/groupSelect", method = { RequestMethod.GET, RequestMethod.POST })
	public String groupSelect(HttpSession session,Model model, PageReq pageReq, OrgAccountGroupQuery query){
		
		pageReq.setSort(new Sort(Direction.DESC,"t.create_time"));
		pageReq.setPageSize(20);
		
		Page<OrgAccountGroupVo> page = orgAccountGroupService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		
		return "account/groupSelect";
	}
	
	@ResponseBody
	@RequestMapping(value ="/groupDelete", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> groupDelete(HttpSession session, Integer id){
		Map<String, Object> result=new HashMap<String, Object>();
		
		orgAccountGroupService.deleteById(id);
		
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	/**
	 * 账户-用户组查询分页
	 * @param session
	 * @param model
	 * @param pageReq
	 * @param query
	 * @return
	 */
	@RequestMapping(value ="/groupAdd", method = { RequestMethod.GET, RequestMethod.POST })
	public String groupAdd(Model model, OrgAccountGroup query){
		
		if(null != query.getGroupId() && !"".equals(query.getGroupId())){
			query = orgAccountGroupService.queryById(query.getGroupId());
		}
		
		model.addAttribute("group", query);
		
		
		
		return "account/groupAdd";
	}
	
	/**
	 * 用户组保存
	 * @param group
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/groupSave", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> groupSave(OrgAccountGroup group){
		Map<String, Object> result=new HashMap<String, Object>();
		
		// 验证用户组名称是否存在
		if(null != group.getGroupId() && !"".equals(group.getGroupId().toString())){
			OrgAccountGroupQuery query = new OrgAccountGroupQuery();
			query.setGroupName(group.getGroupName());
			List<OrgAccountGroup> list = orgAccountGroupService.queryList(query);
			
			if(list.size() > 1){
				result.put("code", HttpStatusCode.CODE_ERROR);
				return result;
			}
			if(list.size() == 1){
				if(!list.get(0).getGroupId().equals(group.getGroupId())){
					result.put("code", HttpStatusCode.CODE_ERROR);
					return result;
				}
			}
			orgAccountGroupService.updateByIdSelective(group);
		} else {
			OrgAccountGroupQuery query = new OrgAccountGroupQuery();
			query.setGroupName(group.getGroupName());
			List<OrgAccountGroup> list = orgAccountGroupService.queryList(query);
			
			if(list.size() > 0 ){
				result.put("code", HttpStatusCode.CODE_ERROR);
				return result;
			}
			group.setCreateTime(new Date());
			orgAccountGroupService.add(group);
		}
		
		
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	/**
	 * 用户组对应的用户列表分页
	 * @param session
	 * @param model
	 * @param pageReq
	 * @param query
	 * @return
	 */
	@RequestMapping(value ="/groupUserList", method = { RequestMethod.GET, RequestMethod.POST })
	public String groupUserList(HttpSession session,Model model, PageReq pageReq, OrgAccountGroupUserQuery query){
		
		pageReq.setPageSize(20);
		
		Page<OrgAccountGroupUserVo> page = orgAccountGroupUserService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		
		OrgAccountGroup group = orgAccountGroupService.queryById(query.getGroupId());
		model.addAttribute("group", group);
		
		return "account/groupUserList";
	}
	
	/**
	 * 删除用户
	 * @param groupUser
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/groupUserDel", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> groupUserDel(OrgAccountGroupUserQuery groupUser){
		Map<String, Object> result=new HashMap<String, Object>();
		OrgAccountGroupUserQuery delUsers = new OrgAccountGroupUserQuery();
		delUsers.setUserIds(groupUser.getUserIds());
		orgAccountGroupUserService.delete(delUsers);
		
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	/**
	 * 添加用户
	 * @param groupId
	 * @param userIds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/groupUserAdd", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> groupUserAdd(Integer groupId, String userIds){
		Map<String, Object> result=new HashMap<String, Object>();
		
		List<OrgAccountGroupUser> addList = new ArrayList<OrgAccountGroupUser>();
		
		OrgAccountGroupUser query = new OrgAccountGroupUser();
		query.setGroupId(groupId);
		List<OrgAccountGroupUser> oldList = orgAccountGroupUserService.queryList(query);
		Set<Integer> existUsers = new HashSet<Integer>();
		for(OrgAccountGroupUser oagu : oldList) {
			existUsers.add(oagu.getUserId());
		}
		
		String [] userArray = userIds.split(",");
		int addNum = 0;
		for(String userId : userArray){
			if(!StringUtils.isBlank(userId) && !existUsers.contains(Integer.valueOf(userId))){
				OrgAccountGroupUser oagu = new OrgAccountGroupUser();
				oagu.setGroupId(groupId);
				oagu.setUserId(Integer.valueOf(userId));
				addList.add(oagu);
				addNum++;
			}
		}
		orgAccountGroupUserService.addInBatch(addList);
		result.put("addnum", addNum);
		
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value ="/groupEnterpriseUserAdd", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> groupEnterpriseUserAdd(Integer groupId, Integer enterpriseId){
		Map<String, Object> result=new HashMap<String, Object>();
		
		List<OrgAccountGroupUser> addList = new ArrayList<OrgAccountGroupUser>();
		
		OrgAccountGroupUser query = new OrgAccountGroupUser();
		query.setGroupId(groupId);
		List<OrgAccountGroupUser> oldList = orgAccountGroupUserService.queryList(query);
		Set<Integer> existUsers = new HashSet<Integer>();
		for(OrgAccountGroupUser oagu : oldList) {
			existUsers.add(oagu.getUserId());
		}
		
		OrgEnterpriseUser equery = new OrgEnterpriseUser();
		equery.setEnterpriseId(enterpriseId);
		List<OrgEnterpriseUser> euList = orgEnterpriseUserService.queryList(equery);
		int addNum = 0;
		for(OrgEnterpriseUser oeu : euList) {
			if(!existUsers.contains(oeu.getUserId())){
				OrgAccountGroupUser oagu = new OrgAccountGroupUser();
				oagu.setGroupId(groupId);
				oagu.setUserId(oeu.getUserId());
				addList.add(oagu);
				addNum++;
			}
		}
		orgAccountGroupUserService.addInBatch(addList);
		result.put("addnum", addNum);
		
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	
	
}
