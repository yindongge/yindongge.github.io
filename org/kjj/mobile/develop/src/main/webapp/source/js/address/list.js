$(function () {
	//城市选择
    $(".selectAddress").click(function(){
    	location.href="../address/selectSend/"+$(this).parent().attr("data-address-id");
    });
    //修改
    $(".pencil").click(function(){
    	location.href="../address/addOrEditInit?addressId="+$(this).attr("data-address-id");
    });
    //添加
    $("#divAdd").click(function(){
    	location.href="../address/addOrEditInit";
    });
    //定位
    $("#divPositionEdit").click(function(){
    	location.href="../position/editInit";
    });
});