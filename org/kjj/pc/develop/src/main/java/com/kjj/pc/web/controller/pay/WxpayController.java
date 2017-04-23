package com.kjj.pc.web.controller.pay;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.aide.OrgOrderConstant;
import com.kjj.commserver.entity.order.aide.OrgOrderLogConstant;
import com.kjj.commserver.entity.order.aide.OrgOrderVo;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.order.OrgOrderGoodsService;
import com.kjj.commserver.service.order.OrgOrderLogService;
import com.kjj.commserver.service.order.OrgOrderService;
import com.kjj.pc.constant.HttpStatusCode;
import com.kjj.pc.constant.SessionConstant;
import com.kjj.pc.pay.wxpay.data.NotifyReqData;
import com.kjj.pc.pay.wxpay.data.NotifyRespData;
import com.kjj.pc.pay.wxpay.data.UnifiedorderRespData;
import com.kjj.pc.pay.wxpay.service.NotifyService;
import com.kjj.pc.pay.wxpay.service.UnifiedorderService;
import com.kjj.pc.util.PathUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

@Controller
@RequestMapping("wxpay")
public class WxpayController {
	
	protected static final Log logger = LogFactory.getLog(WxpayController.class);
	
	@Resource
	private OrgOrderService orgOrderService;
	@Resource
	private OrgOrderLogService orgOrderLogService;
	@Resource
	private OrgOrderGoodsService orgOrderGoodsService;
	
	@RequestMapping(value = "/pay", method = { RequestMethod.GET,RequestMethod.POST })
	public String pay(HttpSession session, Model model,Integer orderId) {
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		//后台校验
		if (orderId == null ) {
			return "error/error";
		}
		
		OrgOrderVo order = (OrgOrderVo)orgOrderService.queryVoById(orderId);
		
		//后台校验支付
		if (order.getStatus() != OrgOrderConstant.STATUS_CREATE || order.getPayStatus()!= OrgOrderConstant.PAY_STATUS_UNPAID ) {
			return "error/error";
		}
		if(!order.getUserId().equals(orgUsersSession.getOrgUsers().getUserId())){
			return "error/error";
		}
		
		//订单商品
		order.setListOrderGoods(orgOrderGoodsService.queryByOrderId(orderId));
		
		model.addAttribute("order",order);
		return "pay/wxpay";
	}
	
	@RequestMapping(value = "/code/{orderId}", method = { RequestMethod.GET,RequestMethod.POST })
	public void code(HttpServletRequest request,HttpServletResponse response,@PathVariable Integer orderId) {
		
		String basePath = PathUtil.getBasePath(request);
		
		OrgOrder order = orgOrderService.queryById(orderId);
		
		//支付日志
		orgOrderLogService.addByUser(order.getOrderId(), order.getUserId(), OrgOrderLogConstant.TYPE_USER_ONLINE_PAY, "用户选择微信支付进行支付");
		
		UnifiedorderRespData data = null;
		try {
			//data = new UnifiedorderService().pay("快捷健测试订单："+orderId+"金额"+order.getPayMoney(), String.valueOf(orderId),"1",basePath);
			data = new UnifiedorderService().pay("快捷健订单:"+orderId, String.valueOf(orderId), UnifiedorderService.getTotalFee(order.getPayMoney()),basePath);
		} catch (ClassNotFoundException e) {
		} catch (IllegalAccessException e) {
		} catch (InstantiationException e) {
		} catch (Exception e) {
		}
		if( data != null && "SUCCESS".equals(data.getReturn_code())&&"SUCCESS".equals(data.getResult_code())){
			UnifiedorderService.encodeQrcode(data.getCode_url(), response);
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/check/{orderId}", method = { RequestMethod.GET,RequestMethod.POST })
	public int check(HttpSession session, HttpServletResponse response,@PathVariable Integer orderId) {
		int result = HttpStatusCode.CODE_ERROR;
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		//后台校验
		if (orderId != null) {
			OrgOrder order = orgOrderService.queryById(orderId);
			
			if(!order.getUserId().equals(orgUsersSession.getOrgUsers().getUserId())){
			}else{
				if(order.getPayStatus() == OrgOrderConstant.PAY_STATUS_PAID){
					result = HttpStatusCode.CODE_SUCCESS;
				}
			}
		}
		return result;
	}
	
	@RequestMapping(value = "/notifyUrl", method = { RequestMethod.POST })
	public void notifyUrl(HttpServletRequest request,PrintWriter out,Model model) {
		NotifyReqData notifyReqData = NotifyService.getNotifyReqData(request);
		NotifyRespData notifyRespData = new NotifyRespData();
		if(notifyReqData.isCheck()){
			//验证成功
			if("SUCCESS".equals(notifyReqData.getResult_code())){
				//支付成功
				logger.info("WXPAY PAY SUCCESS ORDER_ID="+notifyReqData.getOut_trade_no());
				orgOrderService.updatePayOnline(Integer.parseInt(notifyReqData.getOut_trade_no()),OrgOrderConstant.ONLINE_PAY_STYLE_WXPAY);
				notifyRespData.setReturn_code("SUCCESS");
			}else{
				//支付失败
				logger.info("WXPAY PAY FAIL ORDER_ID="+notifyReqData.getOut_trade_no());
				notifyRespData.setReturn_code("FAIL");
				notifyRespData.setReturn_msg("接收到失败的支付通知");
			}
		}else{
			//验证失败
			logger.info("WXPAY CHECK FAIL ORDER_ID="+notifyReqData.getOut_trade_no());
			notifyRespData.setReturn_code("FAIL");
			notifyRespData.setReturn_msg("签名失败");
		}
	    
		//解决XStream对出现双下划线的bug
        XStream xStreamForRequestPostData = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
        //将要提交给API的数据对象转换成XML格式数据Post给API
        String responseXML = xStreamForRequestPostData.toXML(notifyRespData);
        logger.info("WXPAY PAY RETURN ORDER_ID=" + notifyReqData.getOut_trade_no() + " responseXML=" + responseXML);
		out.println(responseXML);
	}
}
