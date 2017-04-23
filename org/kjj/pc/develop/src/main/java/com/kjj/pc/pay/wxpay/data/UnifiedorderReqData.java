package com.kjj.pc.pay.wxpay.data;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.kjj.pc.pay.wxpay.config.WxpayConfig;
import com.kjj.pc.pay.wxpay.util.RandomStringGenerator;
import com.kjj.pc.pay.wxpay.util.Signature;

public class UnifiedorderReqData {
	
	//每个字段具体的意思请查看API文档
	//公众账号ID
    private String appid = WxpayConfig.appID;
    //商户号
    private String mch_id = WxpayConfig.mchID;
    //随机字符串
    private String nonce_str;
    //签名
    private String sign;
    //商品描述
    private String body;
    //商户订单号
    private String out_trade_no;
    //总金额
    private String total_fee;
    //终端IP
    private String spbill_create_ip = WxpayConfig.ip;
    //通知地址
    private String notify_url;
    //交易类型
    private String trade_type = "NATIVE";
    
    public UnifiedorderReqData(String body,String out_trade_no,String total_fee,String basePath){
    	setBody(body);
    	setOut_trade_no(out_trade_no);
    	setTotal_fee(total_fee);
    	setNotify_url(basePath);
    	//随机字符串，不长于32 位
        setNonce_str(RandomStringGenerator.getRandomStringByLength(32));

        //根据API给的签名规则进行签名
        String sign = Signature.getSign(toMap());
        setSign(sign);//把签名数据设置到Sign这个属性中
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

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String basePath) {
		this.notify_url = basePath+WxpayConfig.notify_url;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
}
