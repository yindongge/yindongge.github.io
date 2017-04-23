package com.kjj.pc.web.controller.pay;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;




import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.aide.OrgOrderConstant;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.order.OrgCartService;
import com.kjj.commserver.service.order.OrgOrderService;
import com.kjj.commserver.util.MD5;
import com.kjj.pc.constant.HttpStatusCode;
import com.kjj.pc.constant.SessionConstant;
import com.kjj.pc.util.PathUtil;
import com.kjj.pc.util.PcPropertiesUtil;

@Controller
@RequestMapping("gateway")
public class GatewayController {
	@Resource
	private OrgOrderService orgOrderService;
	@Resource
	private OrgCartService orgCartService;
	
	@ResponseBody
	@RequestMapping(value = "/getParam", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> getParam(Model model, HttpSession session, HttpServletRequest request, Integer orderId) {
		Map<String, Object> map = new HashMap<String, Object>();
		OrgUsersSession orgUsersSession = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);

		String basePath = PathUtil.getBasePath(request);

		if (orderId == null) {
			map.put("code", HttpStatusCode.CODE_ERROR);
			return map;
		}
		OrgOrder order = orgOrderService.queryById(orderId);
		if(!order.getUserId().equals(orgUsersSession.getOrgUsers().getUserId())){
			map.put("code", HttpStatusCode.CODE_ERROR);
			return map;
		}
		String v_mid = PcPropertiesUtil.getProperty("v_mid");
		String key = PcPropertiesUtil.getProperty("v_md5text");
		String v_oid=String.valueOf(orderId);
		String v_amount = order.getPayMoney().toString();
		String v_url = basePath+"/gateway/returnUrl";
		String remark2 = "[url:="+basePath+"/gateway/notifyUrl]";
		String v_moneytype  ="CNY";	
		
		String v_md5info;  //定义必须传递的参数变量
		String text = v_amount+v_moneytype+v_oid+v_mid+v_url+key;   // 拼凑加密串
		MD5 md5 = new MD5();
		v_md5info = md5.getMD5ofStr(text);                          // 网银支付平台对MD5值只认大写字符串，所以小写的MD5值得转换为大写
		
		map.put("v_mid", v_mid);//商户号
		map.put("key", key);//密钥
		map.put("v_oid", v_oid);//订单号
		map.put("v_amount", v_amount);//支付金额
		map.put("v_url", v_url);//支付成功回调地址
		map.put("remark2", remark2);//支付成功后异步到商户的地址
		map.put("v_moneytype", v_moneytype);// 币种
		map.put("v_md5info", v_md5info);
		map.put("code", HttpStatusCode.CODE_SUCCESS);
		return map;
	}
	
	@RequestMapping(value = "/returnUrl", method = { RequestMethod.GET,RequestMethod.POST })
	public String returnUrl(HttpServletRequest request, Model model) {
		String v_oid = request.getParameter("v_oid"); // 订单号
		String v_pstatus = request.getParameter("v_pstatus"); // 支付结果，20支付完成；30支付失败；
		String v_amount = request.getParameter("v_amount"); // 订单实际支付金额
		String v_moneytype = request.getParameter("v_moneytype"); // 币种
		String v_md5str = request.getParameter("v_md5str"); // MD5校验码
//		String v_pstring = request.getParameter("v_pstring"); // 对支付结果的说明，成功时（v_pstatus=20）为"支付成功"，支付失败时（v_pstatus=30）为"支付失败"
//		String v_pmode = request.getParameter("v_pmode"); // 支付方式中文说明，如"中行长城信用卡"
//		String remark1 = request.getParameter("remark1"); // 备注1
//		String remark2 = request.getParameter("remark2"); // 备注2
		
		String key = PcPropertiesUtil.getProperty("v_md5text");
		String text = v_oid + v_pstatus + v_amount + v_moneytype + key;
		MD5 md5 = new MD5();
		String v_md5text = md5.getMD5ofStr(text).toUpperCase();
		
		if(v_md5str.equals(v_md5text)){

			if ("30".equals(v_pstatus))
			{
				return "";
//				out.print("支付失败");
			}else if ("20".equals(v_pstatus)){
				// 支付成功，商户 根据自己业务做相应逻辑处理
				//此处加入商户系统的逻辑处理（例如判断金额，判断支付状态，更新订单状态等等）......
				OrgOrder order = orgOrderService.queryById(Integer.parseInt(v_oid));
				model.addAttribute("order",order);
				long cartCount = orgCartService.getCountByUserId(order.getUserId());
				model.addAttribute("cartCount",cartCount);
				return "order/desc";
			}
		}
		return "";
	}
	@RequestMapping(value = "/notifyUrl", method = { RequestMethod.POST })
	public void notifyUrl(HttpServletRequest request,PrintWriter out,Model model) {
		String v_oid = request.getParameter("v_oid"); // 订单号
		String v_pstatus = request.getParameter("v_pstatus"); // 支付结果，20支付完成；30支付失败；
		String v_amount = request.getParameter("v_amount"); // 订单实际支付金额
		String v_moneytype = request.getParameter("v_moneytype"); // 币种
		String v_md5str = request.getParameter("v_md5str"); // MD5校验码
//		String v_pmode = request.getParameter("v_pmode"); // 支付方式中文说明，如"中行长城信用卡"
//		String v_pstring = request.getParameter("v_pstring"); // 对支付结果的说明，成功时（v_pstatus=20）为"支付成功"，支付失败时（v_pstatus=30）为"支付失败"
//		String remark1 = request.getParameter("remark1"); // 备注1
//		String remark2 = request.getParameter("remark2"); // 备注2
		
		String key = PcPropertiesUtil.getProperty("v_md5text");
		String text = v_oid + v_pstatus + v_amount + v_moneytype + key;
		MD5 md5 = new MD5();
		String v_md5text = md5.getMD5ofStr(text).toUpperCase();
		
		if (v_md5str.equals(v_md5text))
		{
		   out.print("ok"); // 告诉服务器验证通过,停止发送

		   if ("20".equals(v_pstatus))
			{ 
			// 支付成功，商户 根据自己业务做相应逻辑处理
			// 此处加入商户系统的逻辑处理（例如判断金额，判断支付状态(20成功,30失败)，更新订单状态等等）......
			orgOrderService.updatePayOnline(Integer.parseInt(v_oid), OrgOrderConstant.ONLINE_PAY_STYLE_UNIONPAY);
			}
		}else{
			out.print("error");
		}
	}
}
