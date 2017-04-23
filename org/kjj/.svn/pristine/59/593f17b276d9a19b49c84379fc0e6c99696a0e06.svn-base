package com.kjj.commserver.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SmsUtil {

	/** 日志记录 */
	protected static final Log logger = LogFactory.getLog(SmsUtil.class);

	public static String SMS(String postData, String postUrl) {
		try {
			// 发送POST请求
			URL url = new URL(postUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setUseCaches(false);
			conn.setDoOutput(true);

			conn.setRequestProperty("Content-Length", "" + postData.length());
			OutputStreamWriter out = new OutputStreamWriter(
					conn.getOutputStream(), "UTF-8");
			out.write(postData);
			out.flush();
			out.close();

			// 获取响应状态
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				//System.out.println("connect failed!");
				return "";
			}
			// 获取响应内容体
			String line, result = "";
			BufferedReader in = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "utf-8"));
			while ((line = in.readLine()) != null) {
				result += line + "\n";
			}
			in.close();
			return result;
		} catch (IOException e) {
			//e.printStackTrace(System.out);
		}
		return "";
	}

	public static void sendMobileMessage(String mobilePhone, String message) {
		try {
			String PostData = "sname="
					+ CommServerPropertiesUtil.getProperty("mobile.name")
					+ "&spwd="
					+ CommServerPropertiesUtil.getProperty("mobile.password")
					+ "&scorpid=&sprdid="
					+ CommServerPropertiesUtil.getProperty("mobile.productId")
					+ "&sdst=" + mobilePhone + "&smsg="
					+ java.net.URLEncoder.encode(message, "utf-8");
			String result = SMS(PostData,CommServerPropertiesUtil.getProperty("mobile.url"));
			//记录日志
			logger.info(result);
		} catch (Exception e) {
			//记录日志
			logger.error("短信发送失败!mobileNum=" + mobilePhone + "message="+ message);
		}

	}
	
	public static void sendVerificationMessage(String mobilePhone,String verificationCode) {
		String smsMessage = CommServerPropertiesUtil.getProperty("template.verification");
		smsMessage = smsMessage.replace("{code}", verificationCode);
		smsMessage = smsMessage.replace("{mark}",CommServerPropertiesUtil.getProperty("template.mark"));
		sendMobileMessage(mobilePhone, smsMessage);

	}

	public static void sendTakeCodeMessage(String mobilePhone, String takeCode,String orderId) {
		String smsMessage = CommServerPropertiesUtil.getProperty("template.takeCode");
		smsMessage = smsMessage.replace("{takeCode}", takeCode);
		smsMessage = smsMessage.replace("{order_id}", orderId);
		smsMessage = smsMessage.replace("{mark}",CommServerPropertiesUtil.getProperty("template.mark"));
		sendMobileMessage(mobilePhone, smsMessage);
	}
	
	public static void sendEnterpriseCheck(String mobilePhone, String messageContent){
		String smsMessage = CommServerPropertiesUtil.getProperty("template.enterpriseCheck");
		smsMessage = smsMessage.replace("{messageContent}", messageContent);
		smsMessage = smsMessage.replace("{mark}",CommServerPropertiesUtil.getProperty("template.mark"));
		sendMobileMessage(mobilePhone, smsMessage);
	}
	
	public static void sendCancelMessage(String mobilePhone, String reason ,String orderId ,String createTime){
    	String smsMessage = CommServerPropertiesUtil.getProperty("template.cancel."+reason);
    	if(StringUtils.isBlank(smsMessage)){
    		smsMessage = CommServerPropertiesUtil.getProperty("template.cancel.other");
    	}
    	smsMessage = smsMessage.replace("{orderId}", orderId);
    	smsMessage = smsMessage.replace("{createTime}", createTime);
    	smsMessage = smsMessage.replace("{reason}", reason);
    	smsMessage = smsMessage.replace("{mark}", CommServerPropertiesUtil.getProperty("template.mark"));
    	sendMobileMessage(mobilePhone,smsMessage);
    }
	
	// 企业预付款转账使用
	public static void sendAllowanceTransfer(String type, String mobilePhone, BigDecimal amount, BigDecimal currentAmont){
		// 您的账户收入人民币{amount}元，当前可用余额为{currentAmont},来自预付款转账业务。
		String smsMessage = CommServerPropertiesUtil.getProperty("template.allowanceTransfer.in");
		if("out".equalsIgnoreCase(type)){
			smsMessage = CommServerPropertiesUtil.getProperty("template.allowanceTransfer.out");
		}
		smsMessage = smsMessage.replace("{amount}", amount.toString());
		smsMessage = smsMessage.replace("{currentAmont}", currentAmont.toString());
		smsMessage = smsMessage.replace("{mark}",CommServerPropertiesUtil.getProperty("template.mark"));
		sendMobileMessage(mobilePhone, smsMessage);
	}

}
