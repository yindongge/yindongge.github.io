package com.kjj.pc.web.controller.pay;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.aide.OrgOrderConstant;
import com.kjj.commserver.entity.order.aide.OrgOrderLogConstant;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.order.OrgCartService;
import com.kjj.commserver.service.order.OrgOrderLogService;
import com.kjj.commserver.service.order.OrgOrderService;
import com.kjj.pc.constant.SessionConstant;
import com.kjj.pc.pay.alipay.config.AlipayConfig;
import com.kjj.pc.pay.alipay.util.AlipayNotify;
import com.kjj.pc.pay.alipay.util.AlipaySubmit;
import com.kjj.pc.util.PathUtil;

@Controller
@RequestMapping("alipay")
public class AlipayController {
	
	protected static final Log logger = LogFactory.getLog(AlipayController.class);
	
	@Resource
	private OrgOrderService orgOrderService;
	@Resource
	private OrgOrderLogService orgOrderLogService;
	@Resource
	private OrgCartService orgCartService;
	
	@RequestMapping(value = "/pay", method = { RequestMethod.GET,RequestMethod.POST })
	public void pay(HttpSession session,HttpServletRequest request, HttpServletResponse response,PrintWriter out,Integer orderId) {
		
		OrgUsersSession orgUsersSession  = (OrgUsersSession)session.getAttribute(SessionConstant.SESSION_USER);
		
		String basePath = PathUtil.getBasePath(request);
		
		if (orderId == null ) {
			return;
		}
		
		OrgOrder order = orgOrderService.queryById(orderId);
		
		//后台校验支付
		if (order.getStatus() != OrgOrderConstant.STATUS_CREATE || order.getPayStatus()!= OrgOrderConstant.PAY_STATUS_UNPAID ) {
			return;
		}
		if(!order.getUserId().equals(orgUsersSession.getOrgUsers().getUserId())){
			return;
		}
		
		//支付日志
		orgOrderLogService.addByUser(order.getOrderId(), order.getUserId(), OrgOrderLogConstant.TYPE_USER_ONLINE_PAY, "用户选择支付宝进行支付");
		
		//支付类型
		String payment_type = "1";
		//必填，不能修改
		//服务器异步通知页面路径
		String notify_url = basePath+"/alipay/notifyUrl";
		//需http://格式的完整路径，不能加?id=123这类自定义参数

		//页面跳转同步通知页面路径
		String return_url = basePath+"/alipay/returnUrl";
		//需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/

		//商户订单号
		String out_trade_no = String.valueOf(orderId);
		//商户网站订单系统中唯一订单号，必填

		//订单名称
		//String subject = "快捷健测试订单:"+orderId;
		String subject = "快捷健订单:"+orderId;
		//必填

		//付款金额
		//String total_fee = "0.01";
		String total_fee = order.getPayMoney().toString();
		//必填

		//订单描述
		String body = "";
		//商品展示地址
		String show_url = "";
		//需以http://开头的完整路径，例如：http://www.商户网址.com/myorder.html

		//防钓鱼时间戳
		String anti_phishing_key = "";
		//若要使用请调用类文件submit中的query_timestamp函数

		//客户端的IP地址
		String exter_invoke_ip = "";
		//非局域网的外网IP地址，如：221.0.0.1
		
		
		//////////////////////////////////////////////////////////////////////////////////
		
		//把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", "create_direct_pay_by_user");
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("seller_email", AlipayConfig.seller_email);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("payment_type", payment_type);
		sParaTemp.put("notify_url", notify_url);
		sParaTemp.put("return_url", return_url);
		sParaTemp.put("out_trade_no", out_trade_no);
		sParaTemp.put("subject", subject);
		sParaTemp.put("total_fee", total_fee);
		sParaTemp.put("body", body);
		sParaTemp.put("show_url", show_url);
		sParaTemp.put("anti_phishing_key", anti_phishing_key);
		sParaTemp.put("exter_invoke_ip", exter_invoke_ip);
		
		//建立请求
		String sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"get","确认");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>支付宝即时到账交易接口</title>");
		out.println("</head>");
		
		out.println(sHtmlText);
		out.println("<body>");
		out.println("/body");
		out.println("</html>");
		out.flush();
		out.close();    
	}
	
	@SuppressWarnings({ "rawtypes", "unused" })
	@RequestMapping(value = "/returnUrl", method = { RequestMethod.GET,RequestMethod.POST })
	public String returnUrl(HttpServletRequest request,Model model) {
		//获取支付宝GET过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		//商户订单号

		String out_trade_no = request.getParameter("out_trade_no");

		//支付宝交易号

		String trade_no = request.getParameter("trade_no");

		//交易状态
		String trade_status = request.getParameter("trade_status");

		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
		
		//计算得出通知验证结果
		boolean verify_result = AlipayNotify.verify(params);
		
		if(verify_result){//验证成功
			//////////////////////////////////////////////////////////////////////////////////////////
			//请在这里加上商户的业务逻辑程序代码

			//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
			if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")){
				//判断该笔订单是否在商户网站中已经做过处理
					//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					//如果有做过处理，不执行商户的业务程序
			}
			
			//该页面可做页面美工编辑
			//out.println("验证成功<br />");
			logger.info("ALIPAY returnUrl ORDER_ID="+out_trade_no+"~"+verify_result);
			
			OrgOrder order = orgOrderService.queryById(Integer.parseInt(out_trade_no));
			model.addAttribute("order",order);
			long cartCount = orgCartService.getCountByUserId(order.getUserId());
			model.addAttribute("cartCount",cartCount);
			return "order/desc";
			//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

			//////////////////////////////////////////////////////////////////////////////////////////
		}else{
			//该页面可做页面美工编辑
			//out.println("验证失败");
			return "";
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unused" })
	@RequestMapping(value = "/notifyUrl", method = { RequestMethod.POST })
	public void notifyUrl(HttpServletRequest request,PrintWriter out,Model model) {
		//获取支付宝POST过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(name, valueStr);
		}
		
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		//商户订单号

		String out_trade_no = request.getParameter("out_trade_no");

		//支付宝交易号

		String trade_no = request.getParameter("trade_no");

		//交易状态
		String trade_status = request.getParameter("trade_status");

		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//

		if(AlipayNotify.verify(params)){//验证成功
			//////////////////////////////////////////////////////////////////////////////////////////
			//请在这里加上商户的业务逻辑程序代码

			//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
			
			if(trade_status.equals("TRADE_FINISHED")){
				//判断该笔订单是否在商户网站中已经做过处理
					//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					//如果有做过处理，不执行商户的业务程序
				logger.info("ALIPAY TRADE_FINISHED ORDER_ID="+out_trade_no);
				//注意：
				//退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
			} else if (trade_status.equals("TRADE_SUCCESS")){
				//判断该笔订单是否在商户网站中已经做过处理
					//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					//如果有做过处理，不执行商户的业务程序
				logger.info("ALIPAY TRADE_SUCCESS ORDER_ID="+out_trade_no);
				orgOrderService.updatePayOnline(Integer.parseInt(out_trade_no),OrgOrderConstant.ONLINE_PAY_STYLE_ALIPAY);
				//注意：
				//付款完成后，支付宝系统发送该交易状态通知
			}

			//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
			logger.info("ALIPAY SUCCESS ORDER_ID="+out_trade_no);
			out.println("success");	//请不要修改或删除

			//////////////////////////////////////////////////////////////////////////////////////////
		}else{//验证失败
			logger.info("ALIPAY FAIL ORDER_ID="+out_trade_no);
			out.println("fail");
		}
	}
}
