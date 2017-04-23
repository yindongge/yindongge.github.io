package com.kjj.manage.web.controller.order;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
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

import com.kjj.commserver.entity.order.OrgRefundOrder;
import com.kjj.commserver.entity.order.aide.OrgRefundOrderQuery;
import com.kjj.commserver.entity.order.aide.OrgRefundOrderVo;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.service.order.OrgOrderService;
import com.kjj.commserver.service.order.OrgRefundOrderService;
import com.kjj.commserver.service.system.OrgAdminUserService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.constant.SessionConstant;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("/refund")
public class RefundController {
	@Resource
	private OrgRefundOrderService orgRefundOrderService;
	@Resource
	private OrgOrderService orgOrderService;
	@Resource
	private OrgAdminUserService orgAdminUserService;
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String list(Model model,HttpSession session,OrgRefundOrderQuery query,PageReq pageReq) {
		
		OrgAdminUserSession admin = (OrgAdminUserSession) session.getAttribute(SessionConstant.SESSION_ADMIN);
		pageReq.setPageSize(10);
		pageReq.setSort(new Sort(Direction.DESC,"t.refund_order_id"));
		Page<OrgRefundOrder> page = orgRefundOrderService.queryPageList4Admin(admin, query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		
		return "refund/list";
	}
	
	@RequestMapping(value = "/detail/{refundOrderId}", method = { RequestMethod.GET })
	public String detail(HttpSession session,Model model,@PathVariable Integer refundOrderId){
		
		OrgRefundOrderVo refundOrder = (OrgRefundOrderVo)orgRefundOrderService.queryVoById(refundOrderId);
		if (refundOrder.getRefundAdminId() != null) {
			refundOrder.setAdminName(orgAdminUserService.queryById(refundOrder.getRefundAdminId()).getUserName());
		}
		model.addAttribute("refundOrder", refundOrder);
		
		return "refund/detail";
	}
	
	@ResponseBody
	@RequestMapping(value = "/finish", method = { RequestMethod.POST })
	public Map<String, Object> finish(OrgRefundOrder orgRefundOrder,String logDetail,HttpSession session) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		OrgAdminUserSession admin = (OrgAdminUserSession) session.getAttribute(SessionConstant.SESSION_ADMIN);
		orgRefundOrder.setRefundAdminId((short)admin.getOrgAdminUser().getUserId());
		if(orgRefundOrderService.updateFinish(orgRefundOrder)){
				result.put("code", HttpStatusCode.CODE_SUCCESS);
			}else{
				result.put("desc", "非法操作！退货单状态已改变，请刷新");
			}
			return result;
	}
}
