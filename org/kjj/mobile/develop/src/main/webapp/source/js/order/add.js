$(function () {
	
	FastClick.attach(document.body);
	//选择器
	new Swiper('.swiper-container.swiper-send-date', {
        slidesPerView: 3,
        centeredSlides: true,
        spaceBetween: 0,direction : 'vertical',
        onSlideChangeEnd: function(swiper){
        	changeTimeItem();
		}
    });
	new Swiper('.swiper-container.swiper-take', {
		slidesPerView: 3,
		centeredSlides: true,
		spaceBetween: 0,direction : 'vertical'
	});
	
	var swiperSendTime = new Swiper('.swiper-container.swiper-send-time', {
		slidesPerView: 3,
		centeredSlides: true,
		spaceBetween: 0,direction : 'vertical'
	});
	
	//初始化时间
	changeTimeItem();
	
	//发票
	$("#divInvoice").click(function(){
		$("#orderForm").attr("action","../order/invoice");
    	$("#orderForm").submit();
	});
	//优惠券
	$("#divCoupon").click(function(){
		$("#orderForm").attr("action","../coupon/select");
    	$("#orderForm").submit();
	});
	//变更自提
	$("#divTake").click(function(){
		location.href="../shop/list";
	});
	//变更不可自提
	$("#divNoTake").click(function(){
		location.href="../address/list";
	});
	//变更配送
	$("#divSend").click(function(){
		location.href="../address/list";
	});
	
	//点击余额
	$("#divUseDeposit").click(function(){
		if(!$("#divUseDeposit .checkbox-single").is(".disabled")){
			if($("#useDeposit").val() == 'false'){
				//使用
				$("#divUseDeposit .checkbox-single").addClass("on");
				$("#spanUseDeposit").show();
				$("#showUseDeposit").show();
				$("#useDeposit").val(true);
			}else if($("#useDeposit").val() == 'true'){
				//不使用
				$("#divUseDeposit .checkbox-single").removeClass("on");
				$("#spanUseDeposit").hide();
				$("#showUseDeposit").hide();
				$("#useDeposit").val(false);
			}
			changeMoney();
		}
	});
	
	//点击网上支付
	$("#divPayStyleOnline").click(function(){
		if($("#payStyle").val() == 1){
			$("#payStyle").val("0");
			$("#divPayStyleLocal .checkselect").removeClass("on");
			$("#divPayStyleOnline .checkselect").addClass("on");
			if($("#divUseDeposit .checkbox-single").attr("data-can-use") != "false"){
				$("#divUseDeposit .checkbox-single").removeClass("disabled");
			}
		}
	});
	
	//点击货到付款
	$("#divPayStyleLocal").click(function(){
		if($("#payStyle").val() == 0){
			$("#payStyle").val("1");
			$("#divPayStyleOnline .checkselect").removeClass("on");
			$("#divPayStyleLocal .checkselect").addClass("on");
			//不使用
			$("#divUseDeposit .checkbox-single").addClass("disabled");
			$("#divUseDeposit .checkbox-single").removeClass("on");
			$("#spanUseDeposit").hide();
			$("#showUseDeposit").hide();
			$("#useDeposit").val(false);
			changeMoney();
		}
	});
	
	function changeMoney(){
		
		if($("#useDeposit").val() == 'false'){
			$(".payMoney").html(parseFloat($("#orderMoney").val()).toFixed(2));
		}else if($("#useDeposit").val() == 'true'){
			$(".payMoney").html((parseFloat($("#orderMoney").val())-parseFloat($("#depositMoney").val())).toFixed(2));
		}
	}
	
	//提交订单
	$("#addOrder").click(function(){
		if(!checkPay()){
			return false;
		}
		$(".cover").show();
		if($("#useDeposit").val() == 'true' && $("#orderMoney").val() == $("#depositMoney").val()){
			//支付密码
			$("#divDepositPassword").show();
			$('body').css("overflow","hidden");
		}else{
			addOrder();
		}
	});
	
	//关闭密码
	$("#divDepositPassword .close").click(function(){
		$("#divDepositPassword").hide();
		$(".redtip").html("");
		$('body').css("overflow","auto");
		$(".cover").hide();
	});
	

	var pwdIndex = 0;
	$(".nub_ggg li a").click(function() {
		if (pwdIndex < 6) {
			pwdIndex++;
			$(".mm_box li").eq(pwdIndex - 1).addClass("mmdd");
			$("#depositPassword").val($("#depositPassword").val()+$(this).text());
			if(pwdIndex == 6){
				//下单
				addOrder();
			}
		}
	});
	$(".nub_ggg li .del").click(function() {
		if (pwdIndex > 0) {
			pwdIndex--;
			$(".mm_box li").eq(pwdIndex).removeClass("mmdd");
			$("#depositPassword").val($("#depositPassword").val().slice(0,pwdIndex));
		}
	});
	
	function addOrder(){
		$.ajax({  
	        type: "post",  
	        dataType: "json",
	        url: "../order/add",
	        data: $("#orderForm").serialize(),
	        success: function(data) {
	        	if(data.code == 200){
	        		if(data.onlinePay == true){
	        			location.href="../pay/payInit?orderId="+data.orderId;
	        		}else{
	        			location.href="../order/desc?orderId="+data.orderId;
	        		}
	        	}else if(data.code == 500){
	        		if(data.cart==true){
	        			alert(data.desc);
	        			location.href="../cart/list";
	        		}else{
	        			$(".redtip").html(data.desc);
	        			$("#depositPassword").val("");
	        			pwdIndex = 0;
	        			$(".mm_box li").removeClass("mmdd");
	        		}
	        	}else{
	        		alert(data.desc);
	        		if(data.cart==true){
	        			location.href="../cart/list";
	        		}
	        	}
	        },  
	        error: function(data) {  
	        }  
	    }); 
	} 
	
	//显示配送时间选择
	$("#showSelectSend").click(function(){
		$("#selectSend").addClass("on");
		$("#selectSend").show();
		$(".cover").show();
		$("#selectSend").css("z-index","500");
		$("body").addClass("hidden");
	});
	
	//隐藏配送时间选择
	$("#hideSelectSend").click(function(){
		$("#selectSend").removeClass("on");
		$("#selectSend").hide();
		$(".cover").hide();
		$("body").removeClass("hidden");
	});
	
	//配送时间选择
	$("#confirmSelectSend").click(function(){
		var dataDate = $("#selectSend .week-select .swiper-slide-active");
		var dataTime = $("#selectSend .time-select .swiper-slide-active");
		$("#sendDate").val(dataDate.attr("data-date"));
		$("#sendTimeStart").val(dataTime.attr("data-time-start"));
		$("#sendTimeEnd").val(dataTime.attr("data-time-end"));
		var text = "";
		text += dataDate.attr("data-date");
		text += " ";
		text += dataTime.attr("data-time-start").substring(0,5);
		text += "-";
		text += dataTime.attr("data-time-end").substring(0,5);
		$("#spanSend").text(text);
		$("#selectSend").removeClass("on");
		$("#selectSend").hide();
		$(".cover").hide();
		$("body").removeClass("hidden");
	});
	
	//显示自提时间选择
	$("#showSelectTake").click(function(){
		$(".cover").show();
		$("#selectTake").addClass("on");
		$("#selectTake").show();
		$("#selectTake").css("z-index","500");
		$("body").addClass("hidden");
	});
	
	//隐藏自提时间选择
	$("#hideSelectTake").click(function(){
		$(".cover").hide();
		$("body").removeClass("hidden");
		$("#selectTake").removeClass("on");
		$("#selectTake").hide();
	});
	
	//自提时间选择
	$("#confirmSelectTake").click(function(){
		var data = $("#selectTake .swiper-slide-active");
		$("#takeDate").val(data.attr("data-date"));
		var text = "";
		text += data.attr("data-date");
		$("#spanTake").text(text);
		$("#selectTake").removeClass("on");
		$("#selectTake").hide();
		$(".cover").hide();
		$("body").removeClass("hidden");
	});
	
	function changeTimeItem(){
		var date = $("#divSendDate .swiper-slide-active").attr("data-date");
		var html = "";
		$("[data-"+date+"=true]").each(function(index){
			
			html += "<div class=\"swiper-slide\"";
			html += "data-time-start=\""+$(this).attr("data-time-start")+"\"";
			html += " data-time-end=\""+$(this).attr("data-time-end")+"\"";
			html += "><span>";
			html += $(this).attr("data-time-start")+"-"+$(this).attr("data-time-end");
			html += "</span></div>";
		 });
		$("#divSendTime").html(html);
		//更新时间选择
		swiperSendTime.update(true);
	}
});

function checkPay(){
	var sendStyle = $("#sendStyle").val();
	if(sendStyle == 1){
		//自提
		var consigneeMobile = $("[name=consigneeMobile]").val();
		if(!isMobile(consigneeMobile)){
			alert("手机号格式错误！");
			return false;
		}
	}
	return true;
}