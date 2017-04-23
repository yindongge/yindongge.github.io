package com.kjj.manage.web.controller.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.system.OrgAdminAuthority;
import com.kjj.commserver.entity.system.OrgAdminLinkRole;
import com.kjj.commserver.entity.system.OrgAdminRole;
import com.kjj.commserver.entity.system.OrgAdminShop;
import com.kjj.commserver.entity.system.OrgAdminUser;
import com.kjj.commserver.entity.system.OrgModel;
import com.kjj.commserver.entity.system.aide.OrgAdminUserForm;
import com.kjj.commserver.entity.system.aide.OrgAdminUserQuery;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.entity.system.aide.TreeNode;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.service.system.OrgAdminAuthorityService;
import com.kjj.commserver.service.system.OrgAdminLinkRoleService;
import com.kjj.commserver.service.system.OrgAdminRoleService;
import com.kjj.commserver.service.system.OrgAdminShopService;
import com.kjj.commserver.service.system.OrgAdminUserService;
import com.kjj.commserver.service.system.OrgModelService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.constant.SessionConstant;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Resource
	private OrgAdminUserService orgAdminUserService;
	
	@Resource
	private OrgModelService orgModelService;
	
	@Resource
	private OrgAdminAuthorityService orgAdminAuthorityService;
	
	@Resource
	private OrgAdminShopService orgAdminShopService;
	
	@Resource
	private OrgAdminLinkRoleService orgAdminLinkRoleService;
	
	@Resource
	private OrgAdminRoleService orgAdminRoleService;
	
	@Resource
	private OrgShopService orgShopService;
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String list(Model model, PageReq pageReq,OrgAdminUserQuery query){
		
		pageReq.setSort(new Sort(Direction.DESC,"t.user_id"));
		Page<OrgAdminUser> page = orgAdminUserService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		
		return "admin/list";
	}
	
	@RequestMapping(value = "/addInit", method = { RequestMethod.GET,RequestMethod.POST })
	public String addInit(Model model, HttpServletRequest request,HttpServletResponse response) {
		return "admin/add";
	}
	
	@ResponseBody
	@RequestMapping(value = "/add", method = { RequestMethod.POST })
	public Map<String,Object> add(OrgAdminUserForm orgAdminUserForm) {
		Map<String,Object>	result = new HashMap<String, Object>();
		long queryAdminUserByEmail = orgAdminUserService.queryCountByEmail(orgAdminUserForm.getEmail());
		if (queryAdminUserByEmail > 0) {
			result.put("code", HttpStatusCode.CODE_ERROR);
		}else{
			orgAdminUserService.add(orgAdminUserForm);
			result.put("code", HttpStatusCode.CODE_SUCCESS);
		}
		return result;
	}
	
	@RequestMapping(value = "/editInit/{userId}", method = { RequestMethod.GET,RequestMethod.POST })
	public String editInit(@PathVariable Short userId, Model model) {
		model.addAttribute("obj", orgAdminUserService.queryById(userId));
		return "admin/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit", method = { RequestMethod.POST })
	public Map<String,Object> edit(OrgAdminUserForm orgAdminUserForm) {
		Map<String,Object>	result = new HashMap<String, Object>();
		if(!orgAdminUserForm.getEmail().equals(orgAdminUserForm.getEmailOld()) && orgAdminUserService.queryCountByEmail(orgAdminUserForm.getEmail()) > 0){
			result.put("code", HttpStatusCode.CODE_ERROR);
		}else{
			orgAdminUserService.update(orgAdminUserForm);
			result.put("code", HttpStatusCode.CODE_SUCCESS);
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getAllRole", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> getAllRole(Integer userId) {
		Map<String,Object>	result = new HashMap<String, Object>();

		List<OrgAdminRole> listRole = orgAdminRoleService.queryList(null);
		List<TreeNode> list = new ArrayList<TreeNode>();
		
		TreeNode treeNode = null;
		if(userId == null){
			for(OrgAdminRole orgAdminRole : listRole){
				treeNode = new TreeNode();
				treeNode.setId(orgAdminRole.getRoleId());
				treeNode.setpId(0);
				treeNode.setName(orgAdminRole.getRoleName());
				list.add(treeNode);
			}
			
		}else{
			List<OrgAdminLinkRole> listAdminLinkRole = orgAdminLinkRoleService.queryByUserId(userId);
			for(OrgAdminRole orgAdminRole : listRole){
				treeNode = new TreeNode();
				for(OrgAdminLinkRole orgAdminLinkRole : listAdminLinkRole){
					if(orgAdminLinkRole.getRoleid() == orgAdminRole.getRoleId()){
						treeNode.setChecked(true);
						break;
					}
				}
				treeNode.setId(orgAdminRole.getRoleId());
				treeNode.setpId(0);
				treeNode.setName(orgAdminRole.getRoleName());
				list.add(treeNode);
			}
		}
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		result.put("list", list);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getAllMenu", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String,Object> getAllMenu(Integer userId){	
		Map<String,Object>	result = new HashMap<String, Object>();
		
		List<TreeNode> listTreeNode = new ArrayList<TreeNode>();
		List<OrgModel> listModel = orgModelService.queryList(null);
		
		TreeNode treeNode = null;
		if(userId == null){
			for(OrgModel orgModel : listModel){
				treeNode = new TreeNode();
				treeNode.setId(orgModel.getModelid());
				treeNode.setpId(orgModel.getModelparent());
				treeNode.setName(orgModel.getModelname());
				listTreeNode.add(treeNode);
			}
		}else{
			List<OrgAdminAuthority> listAdminAuthority  = orgAdminAuthorityService.queryByUserId(userId);
			for(OrgModel orgModel : listModel){
				treeNode = new TreeNode();
				for(OrgAdminAuthority adminAuthority : listAdminAuthority){
					if(adminAuthority.getAuthorityid() == orgModel.getModelid()){
						treeNode.setChecked(true);
						break;
					}
				}
				treeNode.setId(orgModel.getModelid());
				treeNode.setpId(orgModel.getModelparent());
				treeNode.setName(orgModel.getModelname());
				listTreeNode.add(treeNode);
			}
		}
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		result.put("list", listTreeNode);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getAllShop", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> getAllShop(Integer userId) {
		Map<String,Object>	result = new HashMap<String, Object>();
		
		List<OrgShop> listShop = orgShopService.queryListAll();
		List<TreeNode> listTreeNode = new ArrayList<TreeNode>();
		
		TreeNode treeNode = null;
		if(userId == null){
			for(OrgShop orgShop : listShop){
				treeNode = new TreeNode();
				treeNode.setId(orgShop.getShopId());
				treeNode.setpId(0);
				treeNode.setName(orgShop.getShopName());
				listTreeNode.add(treeNode);
			}
		}else{
			List<OrgAdminShop> listAdminShop = orgAdminShopService.queryByUserId(userId);
			for(OrgShop orgShop : listShop){
				treeNode = new TreeNode();
				for(OrgAdminShop orgAdminShop : listAdminShop){
					if(orgAdminShop.getShopid() == orgShop.getShopId()){
						treeNode.setChecked(true);
						break;
					}
				}
				treeNode.setId(orgShop.getShopId());
				treeNode.setpId(0);
				treeNode.setName(orgShop.getShopName());
				listTreeNode.add(treeNode);
			}
		}
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		result.put("list", listTreeNode);
		return result;
	}
	
	@RequestMapping(value = "/editPasswordInit", method = { RequestMethod.GET,RequestMethod.POST })
	public String editPasswordInit(Model model, HttpSession session,HttpServletRequest request) {
		OrgAdminUserSession   userSession = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		model.addAttribute("userId", userSession.getOrgAdminUser().getUserId());
		return "admin/editPassword";
	}
	@ResponseBody
	@RequestMapping(value = "/editPassword", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> editPassword(Model model,OrgAdminUser orgAdminUser,String password,String oldPassword) {
		Map<String,Object>	result = new HashMap<String, Object>();
		OrgAdminUser adminUser = orgAdminUserService.queryById(orgAdminUser.getUserId());
		if(adminUser == null || !oldPassword.equals(adminUser.getPassword())){
			result.put("code", HttpStatusCode.CODE_ERROR);
			return result;
		}else{
			adminUser.setPassword(orgAdminUser.getPassword());
			orgAdminUserService.updateByIdSelective(adminUser);
			result.put("code", HttpStatusCode.CODE_SUCCESS);
		}
		return result;
	}
}
