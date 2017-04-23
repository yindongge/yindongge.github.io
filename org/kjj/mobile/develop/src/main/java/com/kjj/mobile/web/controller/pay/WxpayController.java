package com.kjj.mobile.web.controller.pay;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.kjj.mobile.constant.HttpStatusCode;
import com.kjj.mobile.constant.SessionConstant;
import com.kjj.mobile.pay.wxpay.data.JsPayReqData;
import com.kjj.mobile.pay.wxpay.data.NotifyReqData;
import com.kjj.mobile.pay.wxpay.data.NotifyRespData;
import com.kjj.mobile.pay.wxpay.data.UnifiedorderRespData;
import com.kjj.mobile.pay.wxpay.service.NotifyService;
import com.kjj.mobile.pay.wxpay.service.UnifiedorderService;
import com.kjj.mobile.util.PathUtil;
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
	
	@ResponseBody
	@RequestMapping(value = "/pay", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> pay(HttpSession session, HttpServletRequest request, Model model,Integer orderId) {
		
		String basePath = PathUtil.getBasePath(request);
		
		Map<String,Object> result = new HashMap<String,Object>();
		
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		String openId = (String)session.getAttribute(SessionConstant.SESSION_OPEN_ID);
		//后台校验
		if(StringUtils.isBlank(openId)){
			result.put("code", HttpStatusCode.CODE_ERROR);
			return result;
		}
		
		if (orderId == null ) {
			result.put("code", HttpStatusCode.CODE_ERROR);
			return result;
		}
		OrgOrder order = (OrgOrderVo)orgOrderService.queryVoById(orderId);
		if(!order.getUserId().equals(orgUsersSession.getOrgUsers().getUserId())){
			result.put("code", HttpStatusCode.CODE_ERROR);
			return result;
		}
		if(order.getStatus() != OrgOrderConstant.STATUS_CREATE || order.getPayStatus() != OrgOrderConstant.PAY_STATUS_UNPAID){
			result.put("code", HttpStatusCode.CODE_ERROR);
			return result;
		}
		//支付日志
		orgOrderLogService.addByUser(order.getOrderId(), order.getUserId(), OrgOrderLogConstant.TYPE_USER_ONLINE_PAY, "用户选择触屏微信支付进行支付");
		
		//统一支付接口
		UnifiedorderRespData  unifiedorderData = null;
		try {
			//unifiedorderData = new UnifiedorderService().pay("快捷健测试订单："+orderId+"金额"+order.getPayMoney(),String.valueOf(orderId), "1",openId,basePath);
			unifiedorderData = new UnifiedorderService().pay("快捷健订单:"+orderId, String.valueOf(orderId), UnifiedorderService.getTotalFee(order.getPayMoney()),openId,basePath);
		} catch (ClassNotFoundException e) {
		} catch (IllegalAccessException e) {
		} catch (InstantiationException e) {
		} catch (Exception e) {
		}
		if(StringUtils.isBlank(unifiedorderData.getPrepay_id())){
			result.put("code", HttpStatusCode.CODE_ERROR);
			return result;
		}
		
		//JS支付
		JsPayReqData jsPayReqData = new JsPayReqData("prepay_id="+unifiedorderData.getPrepay_id());
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		result.put("jsPayReqData", jsPayReqData);
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
				orgOrderService.updatePayOnline(Integer.parseInt(notifyReqData.getOut_trade_no()),OrgOrderConstant.ONLINE_PAY_STYLE_MOBILE_WXPAY);
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
