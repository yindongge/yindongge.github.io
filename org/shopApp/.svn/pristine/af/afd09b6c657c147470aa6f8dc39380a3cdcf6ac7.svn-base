$(function () {
    
    //适用范围选择
    $("#shopType").click(function(){
    	var shopType = $("#shopType :selected").val();
    	if(shopType == 0 || shopType == 1){
    		$(".shop_type_city").hide();
    	}else if(shopType == 2){
    		$(".shop_type_city").show();
    	}else if(shopType == 3){
    		$(".shop_type_city").hide();
    		//获取店铺列表
    		//iframe层
			layer.open({
			    type: 2,
			    title: '选择店铺',
			    shadeClose: true,
			    shade: 0.8,
				maxmin: true, //开启最大化最小化按钮
			    area: ['800px', '450px'],
			    offset: [(document.body.clientHeight-450)/2, (document.body.clientWidth-800)/2],
			    content: '../../shop/shopDiscountSelectInit' //iframe的url
			}); 
    	}
    });
});