package com.kjj.pc.pay.wxpay.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.kjj.pc.pay.wxpay.data.NotifyReqData;
import com.kjj.pc.pay.wxpay.util.Signature;
import com.kjj.pc.pay.wxpay.util.Util;

public class NotifyService {
	
	public static String getRequestXml(HttpServletRequest request){
		String requestXml = "";
		//示例报文
		String inputLine;
		try {
			while ((inputLine = request.getReader().readLine()) != null) {
				requestXml += inputLine;
			}
			request.getReader().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requestXml;
	}
	
	public static NotifyReqData getNotifyReqData(HttpServletRequest request){
		String requestXml = getRequestXml(request);
		NotifyReqData notifyReqData=  (NotifyReqData) Util.getObjectFromXML(requestXml, NotifyReqData.class);
		boolean check = false;
		try {
			check = Signature.checkIsSignValidFromResponseString(requestXml);
		} catch (ParserConfigurationException | IOException | SAXException e) {
		}
		notifyReqData.setCheck(check);
		return notifyReqData;
	}
}
