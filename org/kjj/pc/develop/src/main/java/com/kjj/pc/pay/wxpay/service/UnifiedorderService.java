package com.kjj.pc.pay.wxpay.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.kjj.pc.pay.wxpay.data.UnifiedorderReqData;
import com.kjj.pc.pay.wxpay.data.UnifiedorderRespData;
import com.kjj.pc.pay.wxpay.util.Util;

public class UnifiedorderService extends BaseService{
	
	protected static final Log logger = LogFactory.getLog(UnifiedorderService.class);

	// 上报对应的接口的完整URL
	private static final String interface_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	
	public UnifiedorderService() throws ClassNotFoundException, IllegalAccessException, InstantiationException{
		super(interface_url);
	}
	
	public String request(UnifiedorderReqData unifiedorderReqData) throws Exception {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(unifiedorderReqData);

        return responseString;
    }
	
	/**
	 * 微信支付调用统一下单接口返回二维码链接
	 * @param body 说明
	 * @param out_trade_no 订单号
	 * @param total_fee 金额单位:分
	 * @return
	 */
	public UnifiedorderRespData pay(String body,String out_trade_no,String total_fee,String basePath){
		UnifiedorderRespData unifiedorderRespData = null;
		try {
			UnifiedorderReqData unifiedorderReqData = new UnifiedorderReqData(body,out_trade_no,total_fee,basePath);
			String result = request(unifiedorderReqData);
			logger.info("wexin pay result = "+result);
			unifiedorderRespData =  (UnifiedorderRespData) Util.getObjectFromXML(result, UnifiedorderRespData.class);
		} catch (UnrecoverableKeyException e) {
			//e.printStackTrace();
		} catch (KeyManagementException e) {
			//e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			//e.printStackTrace();
		} catch (KeyStoreException e) {
			//e.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return unifiedorderRespData;
	}

	/**
	 * 生成二维码图片 不存储 直接以流的形式输出到页面
	 * 
	 * @param content
	 * @param response
	 * @throws WriterException 
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void encodeQrcode(String content, HttpServletResponse response){
		Map hints = new HashMap();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8"); // 设置字符集编码类型
		BitMatrix bitMatrix;
		try {
			// 生成矩阵
			bitMatrix = new MultiFormatWriter().encode(content,BarcodeFormat.QR_CODE, 258, 258, hints);
			// 输出图像 
	        MatrixToImageWriter.writeToStream(bitMatrix, "png", response.getOutputStream()); 
		} catch (WriterException e) {
		} catch (IOException e) {
		}
	}
	
	/**
	 * 元转换成分
	 * @param money
	 * @return
	 */
	public static String getTotalFee(BigDecimal money) {
		if(money==null){
			return "";
		}
		// 金额转化为分为单位
		String currency =  money.toString();  //处理包含, ￥ 或者$的金额  
        int index = currency.indexOf(".");  
        int length = currency.length();  
        Long amLong = 0l;  
        if(index == -1){  
            amLong = Long.valueOf(currency+"00");  
        }else if(length - index >= 3){  
            amLong = Long.valueOf((currency.substring(0, index+3)).replace(".", ""));  
        }else if(length - index == 2){  
            amLong = Long.valueOf((currency.substring(0, index+2)).replace(".", "")+0);  
        }else{  
            amLong = Long.valueOf((currency.substring(0, index+1)).replace(".", "")+"00");  
        }  
        return amLong.toString(); 
	}
}
