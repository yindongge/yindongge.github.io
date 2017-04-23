package com.kjj.pc.web.controller.user;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kjj.commserver.constant.ImageConstant;
import com.kjj.commserver.entity.article.OrgArticle;
import com.kjj.commserver.entity.shop.OrgArea;
import com.kjj.commserver.entity.user.OrgEnterprise;
import com.kjj.commserver.entity.user.OrgUserActive;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgEnterpriseConstant;
import com.kjj.commserver.entity.user.aide.OrgEnterpriseForm;
import com.kjj.commserver.entity.user.aide.OrgEnterpriseQuery;
import com.kjj.commserver.entity.user.aide.OrgEnterpriseVo;
import com.kjj.commserver.entity.user.aide.OrgUserLevelConstant;
import com.kjj.commserver.service.article.OrgArticleService;
import com.kjj.commserver.service.shop.OrgAreaService;
import com.kjj.commserver.service.user.OrgEnterpriseService;
import com.kjj.commserver.service.user.OrgUserActiveService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.commserver.util.UUIDUtils;
import com.kjj.pc.constant.HttpStatusCode;
import com.kjj.pc.constant.SessionConstant;
import com.kjj.pc.util.PcPropertiesUtil;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Resource
	private OrgArticleService orgArticleService;
	@Resource
	private OrgUsersService orgUsersService;
	@Resource
	private OrgUserActiveService orgUserActiveService;
	
	@Resource
	private OrgAreaService orgAreaService;
	
	@Resource
	private OrgEnterpriseService orgEnterpriseService;

	@RequestMapping(value = "/init")
	public String init(Model model) {
		OrgArticle orgArticle = orgArticleService.queryOneByTitle(PcPropertiesUtil.getProperty("userProtocol"));
		if (orgArticle != null) {
			model.addAttribute("content", orgArticle.getContent());
		}
		return "register/register";
	}
	
	@ResponseBody
	@RequestMapping(value = "/register")
	public Map<String,Object> register(HttpSession session,HttpServletRequest request,OrgUsers orgUsers,String verifycode) {
		
		Map<String,Object> mapResult = new HashMap<String,Object>();
		final int CODE_ERROR_IDENTITY = 401;
		
		if (StringUtils.isBlank(verifycode) || verifycode.length() != 4) {
			mapResult.put("code",CODE_ERROR_IDENTITY);
			mapResult.put("desc", "验证码错误!");
			return mapResult;
		}else{
			
			OrgUserActive  orgUserActive =  orgUserActiveService.queryLastByMobilePhone(orgUsers.getMobilePhone());
			if( orgUserActive == null){
				mapResult.put("code",CODE_ERROR_IDENTITY);
				mapResult.put("desc", "验证码错误!");
				return mapResult;
			}else{
				if(orgUserActive.getVcode().equals(verifycode)){
					//判断是否过期 目前三十分钟过期
					if (System.currentTimeMillis() - orgUserActive.getCreatetime().getTime() > 30 * 60 * 1000){
						//验证码过期
						mapResult.put("code",CODE_ERROR_IDENTITY);
						mapResult.put("desc", "验证码过期!");
						return mapResult;
					}
				}else{
					mapResult.put("code",CODE_ERROR_IDENTITY);
					mapResult.put("desc", "验证码错误!");
					return mapResult;
				}
			}
		}
		
		if(orgUsersService.queryByLoginName(orgUsers.getMobilePhone()) != null){
			mapResult.put("code",HttpStatusCode.CODE_ERROR);
			mapResult.put("desc", "该手机已经被注册!");
			return mapResult;
		}
		//新增用户
		orgUsersService.add(orgUsers);
		//用户登录
		mapResult.put("code",HttpStatusCode.CODE_SUCCESS);
		return mapResult;
	}
	
	@ResponseBody
	@RequestMapping(value = "/checkUser")
	public int checkUser(String mobilePhone){
		OrgUsers user = orgUsersService.queryByLoginName(mobilePhone);
		if(user != null){
			return HttpStatusCode.CODE_ERROR;
		}else{
			return HttpStatusCode.CODE_SUCCESS;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/sendRegisterCode")
	public int sendRegisterCode(String mobilePhone){
		orgUserActiveService.addRegisterCodeByMobilePhone(mobilePhone);
		return HttpStatusCode.CODE_SUCCESS;
	}
	
	/**
	 * 准备新增企业会员注册
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/preEnterpriseReg")
	public String preEnterpriseReg(Model model) {
		// 快捷健协议
		OrgArticle orgArticle = orgArticleService.queryOneByTitle(PcPropertiesUtil.getProperty("userProtocol"));
		if (orgArticle != null) {
			model.addAttribute("content", orgArticle.getContent());
		}
		
		// 省
		List<OrgArea> listProvince =  orgAreaService.queryListProvince();
		model.addAttribute("listProvince",listProvince);
		
		// 将北京市的市级作为默认的市的选项 110000
		List<OrgArea> listArea = orgAreaService.queryListByParentCode("110000");
		model.addAttribute("listCity", listArea);
		
		// 取得北京市对应的所有区
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
				
		return "register/enterpriseRegister";
	}
	
	/**
	 * 验证企业名称是否存在
	 * @param enterpriseName
	 * @param enterpriseId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/checkEnterpriseName")
	public int checkUser(String enterpriseName, Integer enterpriseId){
		OrgEnterpriseQuery  query = new OrgEnterpriseQuery();
		query.setEnterpriseName(enterpriseName);
		
		List<OrgEnterpriseVo> enterpriseList = orgEnterpriseService.queryList(query);
		
		if(null == enterpriseId){
			if(enterpriseList.size() > 0){
				return HttpStatusCode.CODE_ERROR;
			}
		} else {
			if(enterpriseList.size() > 1){
				return HttpStatusCode.CODE_ERROR;
			}
			if(enterpriseList.size() == 1){
				if(!enterpriseList.get(0).getEnterpriseId().equals(enterpriseId)){
					return HttpStatusCode.CODE_ERROR;
				}
			}
		}
		
		return HttpStatusCode.CODE_SUCCESS;
	}
	
	/**
	 * 保存企业会员注册
	 * @param session
	 * @param model
	 * @param enterprise
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/enterpriseReg")
	public Map<String,Object> EnterpriseReg(HttpSession session,Model model,OrgEnterpriseForm enterprise,HttpServletRequest request) {
		Map<String,Object> mapResult = new HashMap<String,Object>();
		final int CODE_ERROR_IDENTITY = 401; // 手机验证码错误
		final int CODE_ERROR_IDENTIFYCODE = 402; // 验证码错误
		
		// 验证手机验证码
		if (StringUtils.isBlank(enterprise.getVerifycode())) {
			mapResult.put("code",CODE_ERROR_IDENTITY);
			mapResult.put("desc", "手机验证码错误!");
			return mapResult;
		}else{
			OrgUserActive  orgUserActive =  orgUserActiveService.queryLastByMobilePhone(enterprise.getMobile());
			if( orgUserActive == null){
				mapResult.put("code",CODE_ERROR_IDENTITY);
				mapResult.put("desc", "手机验证码错误!");
				return mapResult;
			}else{
				if(orgUserActive.getVcode().equals(enterprise.getVerifycode())){
					//判断是否过期 目前三十分钟过期
					if (System.currentTimeMillis() - orgUserActive.getCreatetime().getTime() > 30 * 60 * 1000){
						//验证码过期
						mapResult.put("code",CODE_ERROR_IDENTITY);
						mapResult.put("desc", "手机验证码过期!");
						return mapResult;
					}
				}else{
					mapResult.put("code",CODE_ERROR_IDENTITY);
					mapResult.put("desc", "手机验证码错误!");
					return mapResult;
				}
			}
		}
		
		// 验证验证码 长度为4
		if (StringUtils.isBlank(enterprise.getIdentifyCode()) || enterprise.getIdentifyCode().length() != 4) {
			mapResult.put("code",CODE_ERROR_IDENTIFYCODE);
			mapResult.put("desc", "验证码错误!");
			return mapResult;
		}else{
			String identifyCodeSession  = (String)session.getAttribute(SessionConstant.SESSION_ENTERPRISE_IDENTITY_CODE);
			if(identifyCodeSession != null){
				if (!identifyCodeSession.toLowerCase().equals(enterprise.getIdentifyCode().toLowerCase())) {
					mapResult.put("code",CODE_ERROR_IDENTIFYCODE);
					mapResult.put("desc", "验证码错误!");
					return mapResult;
				} else {
					session.removeAttribute(SessionConstant.SESSION_ENTERPRISE_IDENTITY_CODE);
				}
			} else {
				mapResult.put("code",CODE_ERROR_IDENTIFYCODE);
				mapResult.put("desc", "验证码错误!");
				return mapResult;
			}
		}
		
		OrgUsers orgUsers = new OrgUsers();
		orgUsers.setUserName(enterprise.getUserName());
		orgUsers.setPassword(enterprise.getPassword());
		orgUsers.setLevelType(OrgUserLevelConstant.LEVEL_TYPE_ENTERPRISE); // 代表用户类型为企业类型
		orgUsers.setLevelId(OrgUserLevelConstant.LEVEL_USER_TYPE_SENIOR_ENTERPRISE); // 用户级别为高级企业会员
		
		orgEnterpriseService.add(enterprise,orgUsers);
		
				
		//企业用户注册成功后，系统不保存新用户的会话
//		OrgUsersSession oldUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
//		orgUsersService.updateLogin(oldUsersSession,orgUsers,IpAddressUtil.getIpAddress(request));
//		session.setAttribute(SessionConstant.SESSION_USER, oldUsersSession);
		mapResult.put("code",HttpStatusCode.CODE_SUCCESS);
		mapResult.put("enterpriseId",enterprise.getEnterpriseId());
		
		return mapResult;
	}
	
	/**
	 * 准备上传企业资质
	 * @param model
	 * @param enterpriseId
	 * @param security
	 * @return
	 */
	@RequestMapping(value = "/uploadQualification")
	public String uploadQualification(Model model,Integer enterpriseId,String security) {
		OrgEnterprise query = new OrgEnterprise();
		query.setEnterpriseId(enterpriseId);
		OrgEnterprise enterprise = orgEnterpriseService.queryOne(query);
		if(null != enterprise.getBusinessLicenImg()){
			enterprise.setBusinessLicenImg(enterprise.getBusinessLicenImg());
		}
		if(null != enterprise.getOrganizationCodeImg()){
			enterprise.setOrganizationCodeImg(enterprise.getOrganizationCodeImg());
		}
		model.addAttribute("ImageBaseUrl", ImageConstant.IMAGE_BASE_URL);
		model.addAttribute("enterprise", enterprise);// 保存企业信息
		
		// 判断是否由账户安全的页面进入的
		if(null != security){
			model.addAttribute("security", security);
		}
		return "register/uploadQualification";
	}
	
	/**
	 * 准备上传企业资质,在没有登录之前使用
	 * @param model
	 * @param enterpriseId
	 * @param security
	 * @return
	 */
	@RequestMapping(value = "/uploadQualification2")
	public String uploadQualification2(Model model,Integer enterpriseId,String security) {
		OrgEnterprise query = new OrgEnterprise();
		query.setEnterpriseId(enterpriseId);
		OrgEnterprise enterprise = orgEnterpriseService.queryOne(query);
		if(null != enterprise.getBusinessLicenImg()){
			enterprise.setBusinessLicenImg(enterprise.getBusinessLicenImg());
		}
		if(null != enterprise.getOrganizationCodeImg()){
			enterprise.setOrganizationCodeImg(enterprise.getOrganizationCodeImg());
		}
		model.addAttribute("ImageBaseUrl", ImageConstant.IMAGE_BASE_URL);
		model.addAttribute("enterprise", enterprise);// 保存企业信息
		
		// 判断是否由账户安全的页面进入的
		if(null != security){
			model.addAttribute("security", security);
		}
		return "register/uploadQualification2";
	}
	

	/**
	 * 保存企业资质图片
	 * @param session
	 * @param enterprise
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveQualification", method = RequestMethod.POST)
	public Map<String,Object> saveQualification(HttpSession session,OrgEnterpriseForm enterprise,HttpServletRequest request){
		Map<String,Object> mapResult = new HashMap<String,Object>();
		
		// 只更新修改的内容
		OrgEnterprise entity = new OrgEnterprise();
		entity.setEnterpriseId(enterprise.getEnterpriseId());
		if(null != enterprise.getOrganizationCodeImg()){
			entity.setOrganizationCodeImg(enterprise.getOrganizationCodeImg());
		}
		if(null != enterprise.getBusinessLicenImg()){
			entity.setBusinessLicenImg(enterprise.getBusinessLicenImg());
		}
		
		OrgEnterprise old = orgEnterpriseService.queryById(enterprise.getEnterpriseId());
		// 当审核不通过后，如果修改信息，信息状态变成待审核
		if(old.getStatus().equals(OrgEnterpriseConstant.STATUS_FALSE)){
			entity.setStatus(OrgEnterpriseConstant.STATUS_BEGIN);
		}
		
		orgEnterpriseService.updateByIdSelective(entity);
		
		mapResult.put("code",HttpStatusCode.CODE_SUCCESS);
		return mapResult;
	}
	
	/**
	 * 上传企业资质图片
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/uploadEnterpriseQuaImg", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> uploadEnterpriseQuaImg(MultipartFile file,HttpServletRequest request, HttpServletResponse response){
		Map<String,Object> mapResult = new HashMap<String,Object>();
		if (!file.isEmpty()) {
			String filenName = UUIDUtils.create() + "_.jpg";
			File targetFile = new File(ImageConstant.IMAGE_BASE_PATH + ImageConstant.ENTERPRISE, filenName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			
			try {
				file.transferTo(targetFile);
				mapResult.put("code", HttpStatusCode.CODE_SUCCESS);
				mapResult.put("url", ImageConstant.IMAGE_BASE_URL + ImageConstant.ENTERPRISE + filenName);
				mapResult.put("returnImgUrl", ImageConstant.ENTERPRISE + filenName);
			} catch (Exception e) {
				mapResult.put("code", HttpStatusCode.CODE_ERROR);
			}
			
		} else {
			mapResult.put("code", HttpStatusCode.CODE_ERROR);
		}
		return mapResult;
	}
	
	/**
	 * 编辑企业信息
	 * @param model
	 * @param enterpriseId
	 * @param security
	 * @return
	 */
	@RequestMapping(value = "/editEnterprise")
	public String editEnterprise(Model model,Integer enterpriseId,String security) {
		OrgEnterprise query = new OrgEnterprise();
		query.setEnterpriseId(enterpriseId);
		OrgEnterprise enterprise = orgEnterpriseService.queryOne(query);
		model.addAttribute("enterprise", enterprise);// 保存企业信息
		
		// 省
		List<OrgArea> listProvince =  orgAreaService.queryListProvince();
		model.addAttribute("listProvince",listProvince);
		
		OrgArea area = orgAreaService.queryById(enterprise.getCountyCode().toString());
		
		OrgArea city = orgAreaService.queryById(area.getParentCode());
		OrgArea province = orgAreaService.queryById(city.getParentCode());
		
		List<OrgArea> listCity =  orgAreaService.queryListByParentCode(province.getCode());
		model.addAttribute("listCity",listCity);
		
		List<OrgArea> listCounty =  orgAreaService.queryListByParentCode(city.getCode());
		model.addAttribute("listCounty",listCounty);
		
		// 企业人数
		model.addAttribute("employees", OrgEnterpriseConstant.employeesMap);
		// 公司行业
		model.addAttribute("industry", OrgEnterpriseConstant.industryMap);
		// 公司性质
		model.addAttribute("nature", OrgEnterpriseConstant.natureMap);
		// 所在部门
		model.addAttribute("department", OrgEnterpriseConstant.departmentMap);
		
		return "register/enterpriseEdit";
	}
	
	/**
	 * 更新企业信息
	 * @param session
	 * @param enterprise
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateEnterprise", method = RequestMethod.POST)
	public Map<String,Object> updateEnterprise(HttpSession session,OrgEnterpriseForm enterprise,HttpServletRequest request){
		Map<String,Object> mapResult = new HashMap<String,Object>();
		
		OrgEnterprise old = orgEnterpriseService.queryById(enterprise.getEnterpriseId());
		// 当审核不通过后，如果修改信息，信息状态变成待审核
		if(old.getStatus().equals(OrgEnterpriseConstant.STATUS_FALSE)){
			enterprise.setStatus(OrgEnterpriseConstant.STATUS_BEGIN);
		}
		orgEnterpriseService.updateByIdSelective(enterprise);
		
		mapResult.put("code",HttpStatusCode.CODE_SUCCESS);
		return mapResult;
	}
}
