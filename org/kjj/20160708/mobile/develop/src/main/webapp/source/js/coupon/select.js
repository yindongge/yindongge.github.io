$(function () {
	//城市选择
    $(".youhuilist").click(function(){
    	location.href="../order/addReInit?couponRecordId="+$(this).attr("data-coupon-record-id");
    });
    
});