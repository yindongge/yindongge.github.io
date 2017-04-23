package com.kjj.manage.web.controller.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.system.OrgAdminRole;
import com.kjj.commserver.entity.system.OrgModel;
import com.kjj.commserver.entity.system.OrgRoleRight;
import com.kjj.commserver.entity.system.aide.OrgAdminRoleQuery;
import com.kjj.commserver.entity.system.aide.TreeNode;
import com.kjj.commserver.service.system.OrgAdminLinkRoleService;
import com.kjj.commserver.service.system.OrgAdminRoleService;
import com.kjj.commserver.service.system.OrgModelService;
import com.kjj.commserver.service.system.OrgRoleRightService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Resource
	private OrgAdminRoleService orgAdminRoleService;
	
	@Resource
	private OrgAdminLinkRoleService orgAdminLinkRoleService;
	
	@Resource
	private OrgRoleRightService orgRoleRightService;
	
	@Resource
	private OrgModelService orgModelService;
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String roleList(Model model, PageReq pageReq,OrgAdminRoleQuery query) {
		pageReq.setSort(new Sort(Direction.DESC,"t.role_id"));
		Page<OrgAdminRole> page = orgAdminRoleService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		return "role/list";
	}

	@RequestMapping(value = "/addInit", method = { RequestMethod.GET,RequestMethod.POST })
	public String addInit() {
		return "role/add";
	}
	
	@ResponseBody
	@RequestMapping(value = "/add", method = { RequestMethod.POST })
	public Map<String,Object> add(OrgAdminRole orgAdminRole,String modelid) {
		Map<String,Object>	result = new HashMap<String, Object>();
		orgAdminRoleService.add(orgAdminRole,modelid);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}

	@RequestMapping(value = "/editInit/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public String editInit(@PathVariable Integer id,Model model) {
		model.addAttribute("obj", orgAdminRoleService.queryById(id));
		return "role/edit";
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit", method = { RequestMethod.POST })
	public Map<String,Object> edit(OrgAdminRole orgAdminRole,String modelid) {
		Map<String,Object>	result = new HashMap<String, Object>();
		orgAdminRoleService.update(orgAdminRole,modelid);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/del/{roleId}", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> delbrand(@PathVariable Integer roleId, HttpServletResponse response) {
		Map<String,Object>	result = new HashMap<String, Object>();
		orgAdminRoleService.deleteById(roleId);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getAllMenu", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String,Object> getAllMenu(Model model,Integer roleId){	
		Map<String,Object>	result = new HashMap<String, Object>();
		
		List<TreeNode> listTreeNode = new ArrayList<TreeNode>();
		List<OrgModel> listModel = orgModelService.queryList(null);
		
		TreeNode treeNode = null;
		if(roleId == null){
			for(OrgModel orgModel : listModel){
				treeNode = new TreeNode();
				treeNode.setId(orgModel.getModelid());
				treeNode.setpId(orgModel.getModelparent());
				treeNode.setName(orgModel.getModelname());
				listTreeNode.add(treeNode);
			}
		}else{
			List<OrgRoleRight> listRoleRight = orgRoleRightService.queryByRoleId(roleId);
			for(OrgModel orgModel : listModel){
				treeNode = new TreeNode();
				for(OrgRoleRight roleRight : listRoleRight){
					if(roleRight.getModelid() == orgModel.getModelid()){
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
}
