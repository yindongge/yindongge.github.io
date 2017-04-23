function cancelOrder(orderId){
	addConfrim("确定要取消订单么？",orderId);
}

function confrimReturn(result,data){
	if(result){
		location.href="../order/cancel?orderId="+data;
	}
}

function wxpay(orderId){
	$(".cover").show();
	$.ajax({
        type : "POST",
        dataType:"json",
        async: true,
        url : "../wxpay/pay?orderId=" + orderId,
        success : function(data){
        	if(data.code==200){
	            WeixinJSBridge.invoke("getBrandWCPayRequest", {
	               "appId": data.jsPayReqData.appId,
	               "timeStamp": data.jsPayReqData.timeStamp,
	               "nonceStr": data.jsPayReqData.nonceStr,
	               "package": data.jsPayReqData.packageStr,
	               "signType": data.jsPayReqData.signType,
	               "paySign": data.jsPayReqData.paySign
	            },
	            function(res) {
	               if (res.err_msg == "get_brand_wcpay_request:ok") {
	            	   //alert("支付成功");
	                   location.href="../order/desc?orderId="+orderId;
	               } else if(res.err_msg == "get_brand_wcpay_request:cancel"){
	            	   alert("支付取消,请重新支付");
	            	   $(".cover").hide();
	               }else{
	            	   alert("支付错误,请重新支付");
	            	   $(".cover").hide();
	               }
	            });
        	}else{
        		alert("参数错误，支付失败");
        		location.href="../order/detail?orderId="+orderId;
        	}
        }
    });
}