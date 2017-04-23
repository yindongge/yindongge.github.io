package com.kjj.mobile.pay.wxpay.data;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.kjj.mobile.pay.wxpay.config.WxpayConfig;
import com.kjj.mobile.pay.wxpay.util.RandomStringGenerator;
import com.kjj.mobile.pay.wxpay.util.Signature;

public class JsPayReqData {
	
	//每个字段具体的意思请查看API文档
	//公众账号ID
    private String appId = WxpayConfig.appID;
    //商户号
    private String timeStamp = String.valueOf(System.currentTimeMillis()).substring(0, 10);
    //随机字符串
    private String nonceStr;
    //订单详情扩展字符串 package保留字改为packageStr
    private String packageStr;
    //签名方式
    private String signType = "MD5";
    //签名
    private String paySign;
    
    public JsPayReqData(String packageStr){
    	setPackageStr(packageStr);
    	//随机字符串，不长于32 位
        setNonceStr(RandomStringGenerator.getRandomStringByLength(32));
        //根据API给的签名规则进行签名
        String sign = Signature.getSign(toMap());
        setPaySign(sign);//把签名数据设置到Sign这个属性中
    }

    public Map<String,Object> toMap(){
        Map<String,Object> map = new HashMap<String, Object>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Object obj;
            try {
                obj = field.get(this);
                if(obj!=null){
                    map.put(field.getName(), obj);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getPackageStr() {
		return packageStr;
	}

	public void setPackageStr(String packageStr) {
		this.packageStr = packageStr;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getPaySign() {
		return paySign;
	}

	public void setPaySign(String paySign) {
		this.paySign = paySign;
	}

	@Override
	public String toString() {
		return "JsPayReqData [appId=" + appId + ", timeStamp=" + timeStamp
				+ ", nonceStr=" + nonceStr + ", packageStr=" + packageStr
				+ ", signType=" + signType + ", paySign=" + paySign + "]";
	}

}
