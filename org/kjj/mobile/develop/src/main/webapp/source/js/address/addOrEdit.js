$(function () {
	$(".mask").hide();
	//城市选择
    $("#toSendRange").click(function(){
    	$("#addressform").attr("action","../sendRange/list");
    	$("#addressform").submit();
    });
    $("#btnSave").click(function(){
    	if($("#consignee").val() == ""){
    		autoAlert("姓名不能为空");
    		return false;
    	}
    	if(!isMobile($("#mobile").val())){
    		autoAlert("手机格式错误");
    		return false;
    	}
    	if($("#sendRangeId").val() == ""){
    		autoAlert("收货地址不能为空");
    		return false;
    	}
    	if($("#address").val() == ""){
    		autoAlert("门牌号不能为空");
    		return false;
    	}
    	$("#addressform").attr("action","../address/addOrEdit");
    	$(".mask").show();
    	$("#addressform").submit();
    });
});