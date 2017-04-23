$(function () {
	$(window).scroll(function () {
	    var scrollTop = $(this).scrollTop();
	    var scrollHeight = $(document).height();
	    var windowHeight = $(this).height();
	    if (scrollTop + windowHeight == scrollHeight) {
	    	addOrderList();
	    }else{
	    	$("#loadMore").hide();
	    }
	});
	
	//加载中
	var isAddLoading = false;
	function addOrderList(){
		//不是最后一页
		if($("#loadMore").attr("data-page-next") != -1){
			$("#loadMore").show();
			//加载中不能再次加载
			if(!isAddLoading){
				isAddLoading = true;
				$.ajax({
				    type: "post",  
				    dataType:"json",
				    url: "../order/listLoad",  
				    data: {'waitPaid':$("#waitPaid").val(),'waitSend':$("#waitSend").val(),'waitTake':$("#waitTake").val(),'pageNumber':$("#loadMore").attr("data-page-next")},
				    success: function(data) {  
				       if(data.code==200){
				    	   if(!data.pageOrder.lastPage){
				    		   $("#loadMore").attr("data-page-next",data.pageOrder.number+1);
				    	   }else{
				    		   $("#loadMore").attr("data-page-next","-1");
				    	   }
				    	   var divHtml = "";
				    	   $.each(data.pageOrder.content,function(idx, item){
				    		   divHtml += "<div class=\"havelist gray\" style=\"margin-bottom:0px\"><div class=\"goodslist\"><div class=\"buff\"><div class=\"buff-left\">";
				    		   divHtml += "<p>状态:<span>";
				    		   if(item.status == 0 && item.payStatus == 0){
				    			   divHtml += "待付款";
				    		   }else if(item.status == 1){
				    			   divHtml += "未确认";
				    		   }else if(item.status == 2 && item.sendStyle == 0){
				    			   divHtml += "待发货";
				    		   }else if(item.status == 2 && item.sendStyle == 1){
				    			   divHtml += "备货中";
				    		   }else if(item.status == 3 && item.sendStyle == 0){
				    			   divHtml += "待收货";
				    		   }else if(item.status == 3 && item.sendStyle == 1){
				    			   divHtml += "待自提";
				    		   }else if(item.status==4){
				    			   divHtml += "已完成";
				    		   }else if(item.status==5){
				    			   divHtml += "已取消";
				    		   }else if(item.status==6){
				    			   divHtml += "已关闭";
				    		   } 
				    		   divHtml += "</span></p><p>";
				    		   divHtml += "总计:<span><i class=\"rmb\">￥</i>";
				    		   divHtml += item.orderMoney.toFixed(2);
				    		   divHtml += "</span></p></div>";
				    		   divHtml += "<div class=\"buff-right\">";
				    		   if(item.status == 0 && item.payStatus == 0){
				    			   divHtml += "<a href=\"javascript:void(0);\" class=\"gopay\" onclick=\"wxpay(";
				    			   divHtml += item.orderId;
				    			   divHtml += ");\">去支付</a>";
				    		   }
				    		   divHtml += "<a href=\"../order/detail?orderId=";
				    		   divHtml += item.orderId;
				    		   divHtml += "\"class=\"gopay\">订单详情</a>";
				    		   divHtml += "</div></div>";
				    		   $.each(item.listOrderGoods,function(idxGoods, orderGoods){
				    			   divHtml += "<a class=\"listone\" href=\"";
				    			   divHtml += "../order/detail?orderId=";
				    			   divHtml += item.orderId;
				    			   divHtml += "\"><div class=\"leftimg\">";
				    			   divHtml += "<img src=\"";
				    			   divHtml += orderGoods.orgProductItem.goodsThumb;
				    			   divHtml += "\"></div><div class=\"lefttext\"><p class=\"first-title\">";
				    			   divHtml += orderGoods.orgProductItem.goodsName;
				    			   divHtml += "</p><p class=\"red\">";
				    			   divHtml += "<i class=\"rmb\">￥</i>";
				    			   divHtml += orderGoods.unitPrice.toFixed(2);
				    			   divHtml += "</p><p><span>数量:";
				    			   divHtml += orderGoods.amount;
				    			   divHtml += "件</span></p></div></a>";
				    		   });
				    		   divHtml += "</div></div>";
				    	   });
				    	   $("div.dingdan-wrapper").append(divHtml);
				    	   isAddLoading = false;
				    	   $("#loadMore").hide();
				       }
				    },  
				    error: function(data) {  
				    }  
				})  ;
			}
		}
	}
});
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
        		location.reload(true);
        	}
        }
    });
}