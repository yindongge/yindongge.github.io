package com.kjj.mobile.web.controller.user;

import java.util.LinkedHashMap;
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

import com.kjj.commserver.entity.system.aide.OrgLocation;
import com.kjj.commserver.entity.user.aide.OrgUsersConstant;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.mobile.constant.CookieConstant;
import com.kjj.mobile.constant.SessionConstant;
import com.kjj.mobile.util.CookieUTF8Util;

@Controller
@RequestMapping("/position")
public class PositionController {
	
	@Resource
	private OrgUsersService orgUsersService;
	
	@RequestMapping(value = "/init", method = {RequestMethod.GET,RequestMethod.POST })
	public String positionInit(Model model,HttpSession session) {
		return "login/position";
	}
	
	@RequestMapping(value = "/editInit", method = {RequestMethod.GET,RequestMethod.POST })
	public String editInit(Model model,HttpSession session, HttpServletRequest request, OrgLocation orgLocation, boolean selectRequired) {
		String localHistory = CookieUTF8Util.getCookieValue(request, CookieConstant.COOKIE_LOCAL_HISTORY);
		model.addAttribute("listLocal", orgUsersService.getListLocalHistory(localHistory));
		model.addAttribute("selectRequired", selectRequired);
		return "login/editPosition";
	}
	
	@RequestMapping(value = "/edit", method = {RequestMethod.GET,RequestMethod.POST })
	public String edit(Model model,HttpSession session, HttpServletRequest request, HttpServletResponse response, OrgLocation orgLocation,boolean selectRequired) {
		session.setAttribute(SessionConstant.SESSION_LOCATION,orgLocation);
		setLocalHistoryCookie(request,response,orgLocation);
		OrgUsersSession userSession = (OrgUsersSession)request.getSession().getAttribute(SessionConstant.SESSION_USER);
		if(userSession != null && userSession.getOrgUsers() != null && userSession.getOrgUsers().getLastSendStyle() != null 
				&& userSession.getOrgUsers().getLastSendStyle() == OrgUsersConstant.LAST_SEND_STYLE_SEND){
			//送货上门
			return "redirect:/address/list";
		}else{
			//自提
			return "redirect:/shop/list";
		}
	}
	
	private void setLocalHistoryCookie(HttpServletRequest request, HttpServletResponse response, OrgLocation orgLocation){
		//选择的地址
		String selectLocation = orgLocation.getLongitude()+"&"+orgLocation.getLatitude()+"&"+orgLocation.getName()+",";
		//历史地址
		String localHistory = CookieUTF8Util.getCookieValue(request, CookieConstant.COOKIE_LOCAL_HISTORY);
		String strLocalHistory = "" ;
		if(StringUtils.isNotBlank(localHistory)){
			String[] arrayHistory = localHistory.split(",");
			Map<String,String> mapHistory = new LinkedHashMap<String,String>();
			for (String strHistoryOne : arrayHistory) {
				if(StringUtils.isNoneBlank(strHistoryOne)){
					mapHistory.put(strHistoryOne.split("&")[2]+",", strHistoryOne+",");
				}
			}
			if(mapHistory.containsKey(selectLocation.split("&")[2])){
				mapHistory.remove(selectLocation.split("&")[2]);
			}
			for (String strHistoryOne : mapHistory.values()) {
				strLocalHistory += strHistoryOne;
			}
		}
		strLocalHistory = selectLocation + strLocalHistory;
		CookieUTF8Util.addCookieDefaultAge(response, CookieConstant.COOKIE_LOCAL_HISTORY, strLocalHistory);
	}
}
