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
});