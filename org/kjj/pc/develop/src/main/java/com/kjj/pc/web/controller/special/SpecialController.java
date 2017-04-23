package com.kjj.pc.web.controller.special;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.special.OrgSpecialService;
import com.kjj.core.exception.ServiceException;
import com.kjj.pc.constant.SessionConstant;

@Controller
@RequestMapping("/special")
public class SpecialController {
	
	@Resource
	OrgSpecialService orgSpecialService;
	
	@Resource
	private OrgClassService orgClassService;
	/**
	 * 根据专题活动的主键展现专题活动对应的所有内容
	 * @param model
	 * @param session
	 * @param orgSpecial
	 * @return
	 */
	@RequestMapping(value = "/show/{specialId}", method = { RequestMethod.GET,RequestMethod.POST })
	public String show(Model model,HttpSession session,@PathVariable Integer specialId) {
		
		OrgUsersSession orgUsersSession = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		
		if(null == specialId){
			throw new ServiceException();
		}
		
		orgSpecialService.show(model, orgUsersSession, specialId);
		
		List<OrgClass> listClass = orgClassService.queryListShowAsTree();
	    model.addAttribute("listClass", listClass);
		
		return "special/show";
	}
	
	
}
