package com.kjj.pc.web.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.user.OrgFeedback;
import com.kjj.commserver.service.user.OrgFeedbackService;
import com.kjj.pc.constant.HttpStatusCode;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {
	
	@Resource
	private OrgFeedbackService orgFeedbackService;

	@RequestMapping(value = "/init", method = { RequestMethod.GET,RequestMethod.POST })
	public String index(){		
		return "feedback/feedback";
	}
	
	@ResponseBody
	@RequestMapping(value = "/save", method = { RequestMethod.GET,RequestMethod.POST })
	public int save(OrgFeedback orgFeedback){
		orgFeedbackService.add(orgFeedback);
		return HttpStatusCode.CODE_SUCCESS;
	}
}
