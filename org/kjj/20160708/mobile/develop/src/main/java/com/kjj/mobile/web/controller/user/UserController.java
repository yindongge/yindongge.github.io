package com.kjj.mobile.web.controller.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.kjj.commserver.entity.account.OrgAccountDeposit;
import com.kjj.commserver.entity.order.aide.OrgOrderUserCount;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.account.OrgAccountDepositService;
import com.kjj.commserver.service.order.OrgOrderService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.mobile.constant.HttpStatusCode;
import com.kjj.mobile.constant.SessionConstant;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private OrgUsersService orgUsersService;
	
	@Resource
	private OrgOrderService orgOrderService;
	
	@Resource
	private OrgAccountDepositService orgAccountDepositService;
	
	
	@RequestMapping(value = "/center", method = {RequestMethod.GET,RequestMethod.POST })
	public String center(Model model,HttpSession session) {
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		OrgOrderUserCount userCount = null;
		float amount=0l;
		if(orgUsersSession != null && orgUsersSession.isLogin()){
			userCount = orgOrderService.queryUserCount(orgUsersSession.getOrgUsers().getUserId());
			OrgAccountDeposit orgAccountDeposit = orgAccountDepositService.queryVoById(orgUsersSession.getOrgUsers().getUserId());
			amount = orgAccountDeposit.getAllowanceAmount().floatValue()+orgAccountDeposit.getFundAmount().floatValue();
		}else{
			userCount = OrgOrderUserCount.ORDER_COUNT_NULL;
		}
		
		model.addAttribute("amount",amount);
		model.addAttribute("userCount",userCount);
		return "user/center";
	}
	
	@RequestMapping(value = "/detail", method = {RequestMethod.GET,RequestMethod.POST })
	public String detail() {
		return "user/detail";
	}
	
	@RequestMapping(value = "/userNameInit", method = {RequestMethod.GET,RequestMethod.POST })
	public String userNameInit() {
		return "user/userName";
	}
	
	@ResponseBody
	@RequestMapping(value = "/userName", method = {RequestMethod.GET,RequestMethod.POST })
	public int userName(HttpSession session,String userName) {
		OrgUsersSession oldUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		
		//用户名唯一性验证
		if(StringUtils.isBlank(userName)){
			return HttpStatusCode.CODE_ERROR;
		}
		//和原用户名一致
		if(userName.equals(oldUsersSession.getOrgUsers().getUserName())){
			return HttpStatusCode.CODE_SUCCESS;
		}
		
		OrgUsers orgUser = orgUsersService.queryByLoginName(userName);
		
		if( oldUsersSession == null || oldUsersSession.getOrgUsers() == null || orgUser != null){
			return HttpStatusCode.CODE_ERROR;
		}else{
			//修改用户名
			OrgUsers user = new OrgUsers();
			user.setUserId(oldUsersSession.getOrgUsers().getUserId());
			user.setUserName(userName);
			orgUsersService.updateByIdSelective(user);
			//SESSION
			oldUsersSession.getOrgUsers().setUserName(userName);
			session.setAttribute(SessionConstant.SESSION_USER, oldUsersSession);
			return HttpStatusCode.CODE_SUCCESS;
		}
	}
	
	@RequestMapping(value = {"/code","/weCode"}, method = {RequestMethod.GET,RequestMethod.POST })
	public String code() {
		return "user/code";
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/codeImage", method = {RequestMethod.GET,RequestMethod.POST })
	public void codeImage(HttpSession session, HttpServletResponse response) {
		OrgUsersSession usersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		Map hints = new HashMap();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8"); // 设置字符集编码类型
		BitMatrix bitMatrix;
		try {
			// 生成矩阵
			bitMatrix = new MultiFormatWriter().encode(usersSession.getOrgUsers().getUserCode(),BarcodeFormat.CODE_128, 350, 60, hints);
			// 输出图像 
	        MatrixToImageWriter.writeToStream(bitMatrix, "png", response.getOutputStream()); 
		} catch (WriterException e) {
		} catch (IOException e) {
		}
	}
}
