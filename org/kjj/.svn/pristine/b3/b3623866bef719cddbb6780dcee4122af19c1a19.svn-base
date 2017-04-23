package com.kjj.commserver.util;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class EmailUtil {

	/** 日志记录 */
	protected static final Log logger = LogFactory.getLog(SmsUtil.class);

	/**
	 * 发送email
	 * @param toEmail
	 * @param toName
	 * @param title
	 * @param content
	 */
	public static void sendEmail(String toEmail, String toName, String title,
			String content) {
		HtmlEmail email = new HtmlEmail();
		String fromEmail = CommServerPropertiesUtil
				.getProperty("email.fromEmail");
		String fromEmailPwd = CommServerPropertiesUtil
				.getProperty("eamil.fromEmailPwd");
		email.setHostName(CommServerPropertiesUtil.getProperty("email.server"));// 发信邮件服务器
		email.setAuthentication(fromEmail, fromEmailPwd);// smtp认证的用户名和密码
		try {
			email.addTo(toEmail, toName);// 收件人地址和收件人名字
			email.setFrom(fromEmail, "【快捷键】");// 发信者
			email.setSubject(title);// 标题
			email.setCharset("UTF-8");// 编码格式
			email.setHtmlMsg(content);// 内容
			email.send();// 发送
		} catch (EmailException e) {
			logger.error("邮件发送失败!toEmail=" + toEmail + "content=" + content);
			e.printStackTrace();
		}
	}

	/**
	 * email发送验证码
	 * @param toEmail
	 * @param code
	 * @param orgUsersName
	 */
	public static void sendEmailCode(String toEmail,String orgUsersName, String code) {
		sendEmail(toEmail, orgUsersName, "【快捷键】绑定邮箱验证",sendEmailContent(orgUsersName, code));
	}

	private static String sendEmailContent(String orgUsersName, String code) {
		StringBuffer  sb = new StringBuffer();
        sb.append("<html><div align='center'>");
        sb.append("<table style='border-bottom:2px solid #fc883b; font-size:12px' cellspacing='0' cellpadding='0' width='650' border='0' id='dang_mail_header'>"
        		+ "<tr><td width='136' height='47' align='left' valign='middle'\"><a href='http://www.kjjhome.com/' target='_blank'><img src='http://www.kjjhome.com/source/img/logo.jpg' alt='快捷键' width='125' height='100' border='0'></a></td>"
        		+ "<td width='622' align='right' valign='bottom'><a href='http://www.kjjhome.com/usualProblem/desc?id=1' target='_blank' style='color:#1a66b'>帮助中心</a></td></tr></table>");
        sb.append("<table width='650' border='0' cellspacing='0' cellpadding='0' style='font-size:12px'>");
        sb.append("<tr><td height='38' colspan='3' valign='middle'><span style=\"font:bold 14px '宋体'\">    "
        		+ "尊敬的"+orgUsersName+"用户您好！</span></td></tr>");
        sb.append("<tr><td width='30'></td><td>"
        		+ DateFormatUtil.format(new Date(),DateFormatUtil.formartDateTime)+"提交的账户安全邮箱验证，验证码为：<strong>"+code+"</strong>，请在页面填写。<br>"
        		+ "如非本人操作，请联系快捷健客服：4000-306-603<br><br>感谢您的支持，祝您购物愉快！"
        		+ "</td><td width='52'></td></tr></table>");
        sb.append("<table width='582' border='0' cellpadding='0' cellspacing='0'><tr><td rowspan='5' width='0'></td><td height='30' colspan='3'></td></tr>"
        		+ "<tr><td colspan='3'><table width='100%' border='0' align='center' cellpadding='0' cellspacing='0'><tbody><tr><td rowspan='2' height='94' width='97'>"
        		+ "<img src='http://www.kjjhome.com/source/img/erweima.jpg' alt='快捷键购物公众号' width='94' height='94'></td><td rowspan='2' width='16'></td><td height='40' colspan='2' valign='middle' style='font-family:'Microsoft Yahei';font-size:18px;font-weight:bold;color:#646464;'>快捷键购物公众号</td></tr>"
        		+ "<tr><td valign='middle' style='color:#646464;font-family:'Microsoft Yahei';font-size:14px;'>"
        		+ "扫描左侧二维码<br>手机专享价格更实惠</td></tr></tbody></table></td></tr><tr><td height='20'></td></tr></table>");
        sb.append("<br><table cellspacing='0' cellpadding='0' width='650' border='0' style='color:#878787; font-size:12px'>"
        		+ "<tr><td height='46' align='center' valign='middle' style='border-bottom:1px solid #a2a2a2'>这是一封系统邮件，请勿直接回复。</td></tr>"
        		+ "<tr><td>温馨提示：您的快捷键账户是 "+orgUsersName+"，"
        		+ "请<a target='_blank' style='color:#1a66b3' href='http://www.kjjhome.com/loginInit' style='color:#1a66b3;'>点击这里</a>登陆，如忘记密码,"
        		+ "请<a target='_blank' style='color:#1a66b3' href='http://www.kjjhome.com/security/findPasswordInit' style='color:#1a66b3;'>点击这里</a>找回。"
        		+ "</td></tr><tr><td height='38' align='center' valign='middle'>Copyright @ 2015-2016　北京快捷健电子商务有限公司Kjjhome.com 版权所有</td></tr></table>");
        sb.append("</div></html>");
        return sb.toString();
	}

}
