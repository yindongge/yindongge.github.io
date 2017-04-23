$(function(){
	//日期选择器
	$(".datetime").datetimepicker({
		format: 'YYYY-MM-DD HH:mm:ss',
		showClear:true,
		locale:'zh-cn',
	});
	
	$("#startDateTime").on("dp.change", function (e) {
        $('#endDateTime').data("DateTimePicker").minDate(e.date);
    });
    $("#endDateTime").on("dp.change", function (e) {
        $('#startDateTime').data("DateTimePicker").maxDate(e.date);
    });
    
    //适用范围选择
    $("#shopType").change(function(){
    	var shopType = $("#shopType :selected").val();
    	if(shopType == 0 || shopType == 1){
    		$(".shopTypeCity").hide();
    	}else if(shopType == 2){
    		$(".shopTypeCity").show();
    	}else if(shopType == 3){
    		$(".shopTypeCity").hide();
    		//获取店铺列表
    		//iframe层
			layer.open({
			    type: 2,
			    title: '选择店铺',
			    shadeClose: true,
			    shade: 0.8,
				maxmin: true, //开启最大化最小化按钮
			    area: ['800px', '450px'],
			    content: '../shop/shopDiscountSelectInit' //iframe的url
			}); 
    	}
    });
    
});