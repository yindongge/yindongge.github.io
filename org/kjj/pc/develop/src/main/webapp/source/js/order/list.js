$(function () {
	//状态选择
	$("#queryStatus").change(function(){
		$("#pageform").submit();
	});
	
	//取消订单关闭
	$("[name='buttonClose']").click(function(){
		$(".togglemodal2").hide();
		$(".toggle-mask").hide();
	});
});

//取消订单
function cancel(orderId){
	$("#cancelOrderId").val(orderId);
	$(".togglemodal2").show();
	$(".toggle-mask").show();
}