jQuery(".slideTxtBox").slide({trigger:"click"});
$(function(){
	$("#orderDesc").click(function(){
		$("div.detail-list").toggle();
	});
	$("ul.bd-ul li").click(function(){
		$(".bd-img").hide();
		$("ul.bd-ul li.active").removeClass("active");
		$(this).addClass("active");
	});
	$("ul.bd-ul li.b1").click(function(){
		$("#payForm").attr("action","../alipay/pay");
		$("#payForm").submit();
	});
	$("ul.bd-ul li.b2").click(function(){
		$("#payForm").attr("action","../wxpay/pay");
		$("#payForm").submit();
	});
	
	$(".bd-2 ul.bd-ul.special li").on('mouseenter',function(){
		$(this).addClass("on").siblings().removeClass("on");
	});
	
	$(".bd-2 ul.bd-ul.special li div a").click(function(){
		var code = $(this).attr("data-code");
		if(code != ""){
			$(this).attr("href","javascript:sendPay("+code+")");
		}else{
			$(this).attr("href","javascript:void(0)");
		}
	});
	
	$("#more_bank").click(function(){
		$(this).parent().css({height:'auto'});
		$(this).hide();
	});
	
	$(".close-pop").click(function(){
		$(this).parents(".pop-up-box").attr("style","display:none");
		$(".mask-index").removeClass("show");
	});
});

function sendPay(code){
	$("input[name='pmode_id']").val(code);
	$.ajax({
		type:'post',
		dataType:'json',
		data:{'orderId':$("input[name='orderId']").val()},
		url:'../gateway/getParam',
		success:function(data){
			if(data.code = 200){
				$("input[name='v_md5info']").val(data.v_md5info);
				$("input[name='v_mid']").val(data.v_mid);
				$("input[name='v_oid']").val(data.v_oid);
				$("input[name='v_amount']").val(data.v_amount);
				$("input[name='v_moneytype']").val(data.v_moneytype);
				$("input[name='v_url']").val(data.v_url);
//				$("input[name='remark1']").val(data.remark1);
				$("input[name='remark2']").val(data.remark2);
				$("#gatewayForm").submit();
				$(".pop-up-box").attr("style","display:block");
				$(".mask-index").addClass("show");
				$(".pop-fooot").find("a").attr("href",$("#locurl").val());
				var backAddress = $(".pop-button").find("a:eq(0)").attr("href");
				$(".pop-button").find("a:eq(0)").attr("href",backAddress+$("input[name='orderId']").val());
			}
		},
		error:function(data){}
	});
}