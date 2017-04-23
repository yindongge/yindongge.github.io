$(function () {
	//初始化
	init();
	
	//城市选择
    $("li").click(function(){
    	$("#ulCounty .on").removeClass("on");
    	$(this).addClass("on");
    	var countyName = $(this).text();
    	$(".switch-right .switch-address").hide();
    	$("#div"+countyName).show();
    });
    
    //城市选择
    $("span.tanhao").click(function(){
    	location.href="../shop/detail?shopId="+$(this).attr("data-shop-id")+"&distance="+$(this).attr("data-shop-distance");
    });
    
    //定位
    $("#divPositionEdit").click(function(){
    	location.href="../position/editInit";
    });
});

//初始化
function init(){
	//如果没有默认的区域 显示第一个
	if($("#ulCounty .on").length == 0){
		$("#ulCounty li:first-child").addClass("on");
		$(".switch-right .switch-address:first-child").show();
	}
}