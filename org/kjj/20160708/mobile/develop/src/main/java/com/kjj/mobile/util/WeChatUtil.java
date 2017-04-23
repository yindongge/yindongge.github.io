package com.kjj.mobile.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 检验授权凭证
 * 
 */
public class WeChatUtil {

	public static Logger log = LoggerFactory.getLogger(WeChatUtil.class);

	/** 获取OpenId URL */
	public final static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	
	/** 重定向 URL */
	public final static String AUTHORIZE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";

	/**
	 * 获取微信openId
	 * @param code
	 * @return
	 */
	public static String getOpenid(String code) {
		String appid = MobilePropertiesUtil.getProperty("appid");
		String appsecret = MobilePropertiesUtil.getProperty("appsecret");
		String requestUrl = ACCESS_TOKEN_URL.replace("APPID", appid).replace("SECRET", appsecret).replace("CODE", code);
		Map<String, Object> mapResult = httpsRequest(requestUrl, "GET", null);
		String openId = null;
		// 如果请求成功
		if (null != mapResult) {
			openId = (String) mapResult.get("openid");
			log.info("wechat getOpenId success openId = " + openId);
		}else{
			log.error("wechat getOpenId fail code = " + code);
		}
		return openId;
	}
	
	/**
	 * 获取微信重定向URL
	 * @return
	 */
	public static String getRedirectUrl(String basePath, String sourceUrl) {
		String appid = MobilePropertiesUtil.getProperty("appid");
		//微信跳转必须去掉:80
		basePath = basePath.replace(":80", "");
		String redirectUrl = AUTHORIZE_URL.replace("APPID", appid).replace("REDIRECT_URI", basePath+"/getOpenId"+sourceUrl);
		return redirectUrl;
	}

	/**
	 * 发起https请求并获取结果
	 * @param requestUrl 请求地址
	 * @param requestMethod 请求方式（GET、POST）
	 * @param outputStr  提交的数据
	 * @return Map
	 */
	private static Map<String, Object> httpsRequest(String requestUrl,String requestMethod, String outputStr) {
		Map<String, Object> mapResult = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
					.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod)) {
				httpUrlConn.connect();
			}

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			Gson gson = new Gson();
			mapResult = gson.fromJson(buffer.toString(),
					new TypeToken<HashMap<String, Object>>() {
					}.getType());
		} catch (ConnectException ce) {
			log.error("server connection timed out.");
		} catch (Exception e) {
			log.error("https request error:", e);
		}
		return mapResult;
	}

}