package com.kjj.manage.web.controller.user;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kjj.commserver.constant.ImageConstant;
import com.kjj.commserver.entity.shop.OrgArea;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.entity.user.OrgEnterprise;
import com.kjj.commserver.entity.user.OrgEnterpriseEasyInvitation;
import com.kjj.commserver.entity.user.OrgUserLevel;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgEnterpriseCheckForm;
import com.kjj.commserver.entity.user.aide.OrgEnterpriseCheckQuery;
import com.kjj.commserver.entity.user.aide.OrgEnterpriseCheckVo;
import com.kjj.commserver.entity.user.aide.OrgEnterpriseConstant;
import com.kjj.commserver.entity.user.aide.OrgEnterpriseEasyInvitationQuery;
import com.kjj.commserver.entity.user.aide.OrgEnterpriseForm;
import com.kjj.commserver.entity.user.aide.OrgEnterpriseQuery;
import com.kjj.commserver.entity.user.aide.OrgEnterpriseVo;
import com.kjj.commserver.entity.user.aide.OrgUserLevelConstant;
import com.kjj.commserver.entity.user.aide.OrgUsersQuery;
import com.kjj.commserver.entity.user.aide.OrgUsersVo;
import com.kjj.commserver.service.shop.OrgAreaService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.service.user.OrgEnterpriseCheckService;
import com.kjj.commserver.service.user.OrgEnterpriseEasyInvitationService;
import com.kjj.commserver.service.user.OrgEnterpriseInvitationService;
import com.kjj.commserver.service.user.OrgEnterpriseService;
import com.kjj.commserver.service.user.OrgEnterpriseUserService;
import com.kjj.commserver.service.user.OrgUserLevelService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.commserver.util.UUIDUtils;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.constant.SessionConstant;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("enterprise")
public class EnterpriseController {
	@Resource
	private OrgEnterpriseService orgEnterpriseService;
	
	@Resource
	private OrgAreaService orgAreaService;
	
	@Resource
	private OrgUsersService orgUsersService;
	
	@Resource
	private OrgEnterpriseUserService orgEnterpriseUserService;
	
	@Resource
	private OrgUserLevelService orgUserLevelService;
	
	@Resource
	private OrgEnterpriseCheckService orgEnterpriseCheckService;
	
	@Resource
	private OrgEnterpriseInvitationService orgEnterpriseInvitationService;
	
	@Resource
	private OrgEnterpriseEasyInvitationService orgEnterpriseEasyInvitationService;
	
	@Resource
	private OrgShopService orgShopService;
	
	/**
	 * 企业会员列表
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value ="/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(HttpSession session,Model model, PageReq pageReq, OrgEnterpriseQuery query){
		
		pageReq.setSort(new Sort(Direction.DESC,"t.create_time"));
		pageReq.setPageSize(20);
		Page<OrgEnterpriseVo> page = orgEnterpriseService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		
		model.addAttribute("shopList", orgShopService.queryList(null)); // 店铺列表
		
		return "user/enterpriseList";
	}
	
	/**
	 * 企业会员列表-选择页面
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value ="/select", method = { RequestMethod.GET, RequestMethod.POST })
	public String select(HttpSession session,Model model, PageReq pageReq, OrgEnterpriseQuery query){
		
		pageReq.setSort(new Sort(Direction.DESC,"t.create_time"));
		pageReq.setPageSize(20);
		Page<OrgEnterpriseVo> page = orgEnterpriseService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		
		return "user/enterpriseSelect";
	}
	
	/**
	 * 企业会员列表
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value ="/userList", method = { RequestMethod.GET, RequestMethod.POST })
	public String userList(HttpSession session,Model model, PageReq pageReq, Integer enterpriseId){
		
		OrgUsersQuery query = new OrgUsersQuery();
		query.setUserEnterpriseId(enterpriseId);
		List<OrgUsersVo> userList = orgUsersService.queryEnterpriseUsers(enterpriseId);
		model.addAttribute("page", userList);

		return "user/enterpriseUserList";
	}
	
	/**
	 * 企业会员列表
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value ="/add", method = { RequestMethod.GET, RequestMethod.POST })
	public String add(HttpSession session,Model model, PageReq pageReq){
		
		// 省
		List<OrgArea> listProvince =  orgAreaService.queryListProvince();
		model.addAttribute("listProvince",listProvince);
		
		List<OrgArea> listArea = orgAreaService.queryListByParentCode("110000");
		model.addAttribute("listCity", listArea);
		
		List<OrgArea> listCounty = orgAreaService.queryListByParentCode("110100");
		model.addAttribute("listCounty", listCounty);
		
		// 企业人数
		model.addAttribute("employees", OrgEnterpriseConstant.employeesMap);
		// 公司行业
		model.addAttribute("industry", OrgEnterpriseConstant.industryMap);
		// 公司性质
		model.addAttribute("nature", OrgEnterpriseConstant.natureMap);
		// 所在部门
		model.addAttribute("department", OrgEnterpriseConstant.departmentMap);
		
		return "user/enterpriseAdd";
	}

	
	/**
	 * 
	 * @param model
	 * @param query
	 * @return
	 */
	@RequestMapping(value ="/edit", method = { RequestMethod.GET, RequestMethod.POST })
	public String edit(Model model,OrgEnterpriseQuery query){
		model.addAttribute("ImageBaseUrl", ImageConstant.IMAGE_BASE_URL);// 图片访问前缀url
		// 省
		List<OrgArea> listProvince =  orgAreaService.queryListProvince();
		model.addAttribute("listProvince",listProvince);
		
		// 企业人数
		model.addAttribute("employees", OrgEnterpriseConstant.employeesMap);
		// 公司行业
		model.addAttribute("industry", OrgEnterpriseConstant.industryMap);
		// 公司性质
		model.addAttribute("nature", OrgEnterpriseConstant.natureMap);
		// 所在部门
		model.addAttribute("department", OrgEnterpriseConstant.departmentMap);
		
		List<OrgEnterpriseVo> el =  orgEnterpriseService.queryList(query);
		model.addAttribute("enterprise", el.get(0));
		
		OrgArea area = orgAreaService.queryById(el.get(0).getCountyCode().toString());
		
		OrgArea city = orgAreaService.queryById(area.getParentCode());
		OrgArea province = orgAreaService.queryById(city.getParentCode());
		
		List<OrgArea> listCity =  orgAreaService.queryListByParentCode(province.getCode());
		model.addAttribute("listCity",listCity);
		
		List<OrgArea> listCounty =  orgAreaService.queryListByParentCode(city.getCode());
		model.addAttribute("listCounty",listCounty);
				
		return "user/enterpriseEdit";
	}
	
	/**
	 * 
	 * @param model
	 * @param query
	 * @return
	 */
	@RequestMapping(value ="/detail", method = { RequestMethod.GET, RequestMethod.POST })
	public String detail(Model model,OrgEnterpriseQuery query){
		model.addAttribute("ImageBaseUrl", ImageConstant.IMAGE_BASE_URL);// 图片访问前缀url
		// 省
		List<OrgArea> listProvince =  orgAreaService.queryListProvince();
		model.addAttribute("listProvince",listProvince);
		
		// 企业人数
		model.addAttribute("employees", OrgEnterpriseConstant.employeesMap);
		// 公司行业
		model.addAttribute("industry", OrgEnterpriseConstant.industryMap);
		// 公司性质
		model.addAttribute("nature", OrgEnterpriseConstant.natureMap);
		// 所在部门
		model.addAttribute("department", OrgEnterpriseConstant.departmentMap);
		
		List<OrgEnterpriseVo> el =  orgEnterpriseService.queryList(query);
		model.addAttribute("enterprise", el.get(0));
		
		// 用户信息
		OrgUsers orgUsers = orgUsersService.queryById(el.get(0).getUserId());
		if(!StringUtils.isBlank(orgUsers.getLevelId())){
			OrgUserLevel query1 = new OrgUserLevel();
			query1.setLevelId(orgUsers.getLevelId());
			List<OrgUserLevel> levelList = orgUserLevelService.queryList(query1);
			if(levelList.size() > 0){
				orgUsers.setLevelId(levelList.get(0).getLevelName());
			}
		}
		model.addAttribute("orgUsers", orgUsers);
		
		OrgArea area = orgAreaService.queryById(el.get(0).getCountyCode().toString());
		
		OrgArea city = orgAreaService.queryById(area.getParentCode());
		OrgArea province = orgAreaService.queryById(city.getParentCode());
		
		List<OrgArea> listCity =  orgAreaService.queryListByParentCode(province.getCode());
		model.addAttribute("listCity",listCity);
		
		List<OrgArea> listCounty =  orgAreaService.queryListByParentCode(city.getCode());
		model.addAttribute("listCounty",listCounty);
		
		List<OrgUsersVo> userList = orgUsersService.queryEnterpriseUsers(query.getEnterpriseId());
		model.addAttribute("userNumber", userList.size());
		
		// 历史审批    
		OrgEnterpriseCheckQuery checkQuery = new OrgEnterpriseCheckQuery();
		checkQuery.setEnterpriseId(query.getEnterpriseId());
		
		List<OrgEnterpriseCheckVo> checkList = orgEnterpriseCheckService.queryList(checkQuery);
		model.addAttribute("checkList", checkList);
		
		// 统一邀请码
		OrgEnterpriseEasyInvitationQuery easyInvitationQuery = new OrgEnterpriseEasyInvitationQuery();
		easyInvitationQuery.setEnterpriseId(el.get(0).getEnterpriseId());
		List<OrgEnterpriseEasyInvitation> easyInvitationList = orgEnterpriseEasyInvitationService.queryList(easyInvitationQuery);
		model.addAttribute("easyInvitationList", easyInvitationList);
				
		return "user/enterpriseDetail";
	}
	
	/**
	 * 保存会员列表
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value ="/save", method = { RequestMethod.GET, RequestMethod.POST })
	public String save(HttpSession session,Model model,MultipartHttpServletRequest request, PageReq pageReq, OrgEnterpriseForm enterprise) throws Exception {
		// 上传图片
		Iterator<String> it = request.getFileNames();
		while(it.hasNext()){
			String key = it.next();
			String filename = UUIDUtils.create() +".jpg";
			File f = new  File(ImageConstant.IMAGE_BASE_PATH + ImageConstant.ENTERPRISE +filename);
			if (!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();
			}
			
			if (request.getFile(key).getSize() != 0) {
				InputStream inputStream = request.getFile(key).getInputStream();
				FileOutputStream outputStream = new FileOutputStream(f);
				byte[] buf = new byte[1024];
				int length = 0;
				while ((length = inputStream.read(buf)) != -1) {
					outputStream.write(buf, 0, length);
				}
				outputStream.close();
				inputStream.close();

				String path = ImageConstant.ENTERPRISE + filename;
				
				// 组织机构
				if(key.contains("organizationCodeImg")){
					enterprise.setOrganizationCodeImg(path);
				}
				
				// 营业执照
				if(key.contains("businessLicenImg")){
					enterprise.setBusinessLicenImg(path);
				}
				
			}
		}
		
		if(null != enterprise.getEnterpriseId()){
			orgEnterpriseService.updateByIdSelective(enterprise);
		} else {
			OrgUsers user = new OrgUsers();
			user.setUserName(enterprise.getUserName());
			user.setPassword(enterprise.getPassword());
			user.setLevelType(OrgUserLevelConstant.LEVEL_TYPE_ENTERPRISE); // 代表用户类型为企业类型
			user.setLevelId(OrgUserLevelConstant.LEVEL_USER_TYPE_SENIOR_ENTERPRISE); // 用户级别为高级企业会员
			
			orgEnterpriseService.add(enterprise, user);
		}
		return list(session,model, pageReq, new OrgEnterpriseQuery());
	}
	
	/**
	 * 验证用户名是否存在
	 * @param session
	 * @param model
	 * @param pageReq
	 * @param enterprise
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/validateUserName", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> validateUserName(HttpSession session,Model model, PageReq pageReq, OrgEnterpriseForm enterprise){
		Map<String, Object> result=new HashMap<String, Object>();
		
		OrgUsers query = new OrgUsers();
		query.setUserName(enterprise.getUserName());

		List<OrgUsers> usersList = orgUsersService.queryList(query);
		
		if(null == enterprise.getUserId()){
			if(usersList.size() > 0){
				result.put("code", HttpStatusCode.CODE_ERROR);
				return result;
			}
		} else {
			if(usersList.size() > 1){
				result.put("code", HttpStatusCode.CODE_ERROR);
				return result;
			}
			OrgUsers u = usersList.get(0);
			if(!u.getUserId().equals(enterprise.getUserId())){
				result.put("code", HttpStatusCode.CODE_ERROR);
				return result;
			}
		}
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	/**
	 * 验证企业名称是否存在,修改时不验证
	 * @param session
	 * @param model
	 * @param pageReq
	 * @param enterprise
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/validateEnterpriseName", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> validateEnterpriseName(HttpSession session,Model model, PageReq pageReq, OrgEnterpriseForm enterprise){
		Map<String, Object> result=new HashMap<String, Object>();
		
		OrgEnterpriseQuery  query = new OrgEnterpriseQuery();
		query.setEnterpriseName(enterprise.getEnterpriseName());

		List<OrgEnterpriseVo> enterpriseList = orgEnterpriseService.queryList(query);
		
		if(enterpriseList.size() > 0){
			result.put("code", HttpStatusCode.CODE_ERROR);
			return result;
		}
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	/**
	 * 删除企业用户
	 * @param session
	 * @param model
	 * @param pageReq
	 * @param enterprise
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> delete(HttpSession session, Integer enterpriseId){
		Map<String, Object> result=new HashMap<String, Object>();
		
		OrgEnterprise oe = orgEnterpriseService.queryById(enterpriseId);
		orgEnterpriseService.deleteEnterprise(oe);
		
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	/**
	 * 锁定企业用户
	 * @param session
	 * @param model
	 * @param pageReq
	 * @param enterprise
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/lock", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> lock(HttpSession session, Integer enterpriseId){
		Map<String, Object> result=new HashMap<String, Object>();
		
		orgEnterpriseService.lock(enterpriseId);
		
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	/**
	 * 解除锁定企业用户
	 * @param session
	 * @param model
	 * @param pageReq
	 * @param enterprise
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/disLock", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> disLock(HttpSession session, Integer enterpriseId){
		Map<String, Object> result=new HashMap<String, Object>();
		
		orgEnterpriseService.updateDisLock(enterpriseId);
		
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	/**
	 * 准备审核
	 * @param model
	 * @param query
	 * @return
	 */
	@RequestMapping(value ="/preCheck", method = { RequestMethod.GET, RequestMethod.POST })
	public String preCheck(Model model,OrgEnterpriseQuery query){
		model.addAttribute("ImageBaseUrl", ImageConstant.IMAGE_BASE_URL);// 图片访问前缀url
		// 省
		List<OrgArea> listProvince =  orgAreaService.queryListProvince();
		model.addAttribute("listProvince",listProvince);
		
		// 企业人数
		model.addAttribute("employees", OrgEnterpriseConstant.employeesMap);
		// 公司行业
		model.addAttribute("industry", OrgEnterpriseConstant.industryMap);
		// 公司性质
		model.addAttribute("nature", OrgEnterpriseConstant.natureMap);
		// 所在部门
		model.addAttribute("department", OrgEnterpriseConstant.departmentMap);
		
		List<OrgEnterpriseVo> el =  orgEnterpriseService.queryList(query);
		model.addAttribute("enterprise", el.get(0));
		
		OrgArea area = orgAreaService.queryById(el.get(0).getCountyCode().toString());
		
		OrgArea city = orgAreaService.queryById(area.getParentCode());
		OrgArea province = orgAreaService.queryById(city.getParentCode());
		
		List<OrgArea> listCity =  orgAreaService.queryListByParentCode(province.getCode());
		model.addAttribute("listCity",listCity);
		
		List<OrgArea> listCounty =  orgAreaService.queryListByParentCode(city.getCode());
		model.addAttribute("listCounty",listCounty);
		
		List<OrgUsersVo> userList = orgUsersService.queryEnterpriseUsers(query.getEnterpriseId());
		model.addAttribute("userNumber", userList.size());
		
		// 历史审批    
		OrgEnterpriseCheckQuery checkQuery = new OrgEnterpriseCheckQuery();
		checkQuery.setEnterpriseId(query.getEnterpriseId());
		
		List<OrgEnterpriseCheckVo> checkList = orgEnterpriseCheckService.queryList(checkQuery);
		model.addAttribute("checkList", checkList);
		
		return "user/enterpriseCheck";
	}
	
	/**
	 * 保存审批信息
	 * @param session
	 * @param model
	 * @param pageReq
	 * @param enterprise
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/check", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> check(HttpSession session, OrgEnterpriseCheckForm enterpriseCheck){
		Map<String, Object> result = new HashMap<String, Object>();

		OrgAdminUserSession admin = (OrgAdminUserSession) session
				.getAttribute(SessionConstant.SESSION_ADMIN);
		// 验证是否有已经审批通过的相同企业名称的企业
		OrgEnterpriseQuery  query = new OrgEnterpriseQuery();
		query.setEnterpriseName(enterpriseCheck.getEnterpriseName());
		query.setStatus(OrgEnterpriseConstant.STATUS_TURE);// 审核通过

		List<OrgEnterpriseVo> enterpriseList = orgEnterpriseService.queryList(query);
		
		if(enterpriseList.size() > 0){
			result.put("code", HttpStatusCode.CODE_ERROR);
			return result;
		}

		orgEnterpriseService.updateCheck(admin, enterpriseCheck);
		
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	/**
	 * 修改分店和分店联系人
	 * @param session
	 * @param model
	 * @param pageReq
	 * @param enterprise
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/changeShop", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> changeShop(HttpSession session, OrgEnterprise enterprise){
		Map<String, Object> result=new HashMap<String, Object>();
		
		orgEnterpriseService.updateByIdSelective(enterprise);
		
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	/**
	 * 准备新增统一邀请码
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value ="/preAddEasyInvitation", method = { RequestMethod.GET, RequestMethod.POST })
	public String preAddEasyInvitation(Model model,String enterpriseId){
		
		model.addAttribute("invitationCode", orgEnterpriseEasyInvitationService.createInvitationCode());
		
		model.addAttribute("enterpriseId", enterpriseId);
		
		return "user/easyInvitationAdd";
	}
	
	/**
	 * 判断是否能创建新的统一邀请码
	 * @param session
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/validateEasyInvitation", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> validateEasyInvitation(HttpSession session, Integer enterpriseId){
		Map<String, Object> result = new HashMap<String, Object>();
		
		OrgEnterpriseEasyInvitationQuery easyInvitationQuery = new OrgEnterpriseEasyInvitationQuery();
		easyInvitationQuery.setEnterpriseId(enterpriseId);
		List<OrgEnterpriseEasyInvitation> easyInvitationList = orgEnterpriseEasyInvitationService.queryList(easyInvitationQuery);

		if(easyInvitationList.size() > 0){
			OrgEnterpriseEasyInvitation easyInvitation = easyInvitationList.get(easyInvitationList.size()-1);
			Date today = new Date();
			
			// 邀请码过期
			if( today.getTime() > easyInvitation.getEndTime().getTime()){
				result.put("pass", "yes");
				return result;
			} else {
				if(easyInvitation.getRest().intValue() < 1){
					result.put("pass", "yes");
					return result;
				} else {
					result.put("pass", "no");
					return result;
				}
			}
		} else {
			result.put("pass", "yes");
		}
		return result;
	}
	
	
	/**
	 * 保存统一邀请码
	 * @param session
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/saveEasyInvitation", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> saveEasyInvitation(HttpSession session, OrgEnterpriseEasyInvitation entity){
		Map<String, Object> result = new HashMap<String, Object>();
		
		entity.setRest(entity.getCeiling()); // 初始时剩余数量为最大激活数
		orgEnterpriseEasyInvitationService.add(entity);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
}
