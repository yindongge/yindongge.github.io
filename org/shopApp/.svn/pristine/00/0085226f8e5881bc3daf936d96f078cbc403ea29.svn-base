$(function () {
	//校验,以为验证复杂，所有去掉
	/*
	$("#couponAdd").bootstrapValidator({
		message : '字段内容非法',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields: {        
			'discount[]': {          
				validators: {            
					notEmpty: {              
						message: '折扣不能为空'            
					},
					callback:{
						message: '折扣小数点后面只保留两位有效数字',
						callback: function(value, validator) {
							if(value!=""&&value.indexOf(".")!=-1){
								if(value.length - (value.indexOf(".")+1) >  2){
									return false;
								}
							}
							return true;
						}
					}
				}        
			},
			'price[]': {          
				validators: {            
					notEmpty: {              
						message: '金额不能为空'            
					},
					callback:{
						message: '金额小数点后面只保留两位有效数字',
						callback: function(value, validator) {
							if(value!=""&&value.indexOf(".")!=-1){
								if(value.length - (value.indexOf(".")+1) >  2){
									return false;
								}
							}
							return true;
						}
					}
				}        
			}
        }
	});*/
    //适用范围选择
    $("#shopType").change(function(){
    	var shopType = $("#shopType :selected").val();
    	if(shopType == 0 || shopType == 1){
    		$(".shopTypeCity").hide();
    		$(".shopsName").hide();
    	}else if(shopType == 2){
    		$(".shopTypeCity").show();
    		$(".shopsName").hide();
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
			    content: '../levelprice/shopSelect?selectedIds='+$("#cityShopId").val() //iframe的url
			}); 
    	}
    }); 
    
    //类型选择
    $("#productType").change(function(){
    	var productType = $("#productType :selected").val();
    	if(productType == 0 || productType == 1){
    		$(".productTypeClass").hide();
    		$(".productName").hide();
    		$(".pricerow").hide();
    	}else if(productType == 2){
    		var clazz = $("#listClass :selected");
        	var count = $("#listClass option").length;
        	if( clazz.attr("data-parent")!="0"){
        		for(var i = 0; i < count; i++){
            		if($("#listClass").get(0).options[i].value == clazz.attr("data-parent")){
            			$(".divClass").html("已选择分类：" +$("#listClass").get(0).options[i].text + ">" + clazz.text().trim());
            		}
            	}
        	}else{
        		$(".divClass").html("已选择分类：" +clazz.text().trim());
        	}
    		$(".productTypeClass").show();
    		$(".productName").hide();
    		$(".pricerow").hide();
    		//获取等级列表
    	}else if(productType == 3){
    		$(".productTypeClass").hide();
    	 	//获取店铺列表
    		//iframe层
			layer.open({
			    type: 2,
			    title: '选择商品',
			    shadeClose: true,
			    shade: 0.8,
				maxmin: true, //开启最大化最小化按钮
			    area: ['800px', '450px'],
			    content: '../levelprice/productSelect' //iframe的url
			});
			$(".pricerow").show();
    	}
    });
    
    // 产品分类
    $("#listClass").change(function(){
    	var clazz = $("#listClass :selected");
    	var count = $("#listClass option").length;
    	if( clazz.attr("data-parent")!="0"){
    		for(var i = 0; i < count; i++){
        		if($("#listClass").get(0).options[i].value == clazz.attr("data-parent")){
        			$(".divClass").html("已选择分类：" +$("#listClass").get(0).options[i].text + ">" + clazz.text().trim());
        		}
        	}
    	}else{
    		$(".divClass").html("已选择分类：" +clazz.text().trim());
    	}
    });
    
    //保存
    $(".btn-danger").click(function(){
    	// 表单验证
    	if($("#shopType").val()=="3" && $("#cityShopId").val()==""){
    		alert("请选择门店!");
			return;
    	}
    	if($("#productType").val()=="3" && $("#goodsId").val()==""){
    		alert("请选择商品!");
			return;
    	}
    	var discountMsg = "";
    	$("input[name=discount]").each(function(i){
    		if($(this).val()==""){
    			$("input[name=price]").each(function(j){
    				if(i==j){
    					if($(this).val()==""){
    						discountMsg += $(this).attr("data-level-name") + "价格折扣和金额必须填写一种！\r\n";
    					}
    				}
    			});
    		} else {
    			$("input[name=price]").each(function(j){
    				if(i==j){
    					if($(this).val()!=""){
    						discountMsg += $(this).attr("data-level-name") + "价格折扣和金额只能填写一种！\r\n";
    					}
    				}
    			});
    			var value = $(this).val();
    			if(value.indexOf(".")!=-1){
	    			if(value.length - (value.indexOf(".")+1) >  2){
	    				discountMsg += $(this).attr("data-level-name") + "价格折扣小数点后面只保留两位有效数字！\r\n";
					}
    			}
    		}
    	});
    	
    	$("input[name=price]").each(function(i){
    		if($(this).val()!=""){
    			var value = $(this).val();
    			if(value.indexOf(".")!=-1){
	    			if(value.length - (value.indexOf(".")+1) >  2){
	    				discountMsg += $(this).attr("data-level-name") + "价格金额小数点后面只保留两位有效数字！\r\n";
					}
    			}
    		}
    	});
    	
    	if(discountMsg!=""){
    		alert(discountMsg);
    		return;
    	}
    	
    	// 组装数据
    	// 折扣信息
    	var discountStr = "";
    	$("input[name=discount]").each(function(i){
    		var value = $(this).val();
    		if(value!=""){
    			discountStr += $(this).attr("data-level-id") + "-1-" + value + ",";
    		}
    		
    	});
    	$("input[name=price]").each(function(i){
    		var value = $(this).val();
    		if(value!=""){
    			discountStr += $(this).attr("data-level-id") + "-2-" + value + ",";
    		}
    	});
    	
    	$("#discountAll").val(discountStr);
    	
    	if($("#productType").val()=="2"){
    		// 分类
    		var clazz = $("#listClass :selected");
        	$("#classId").val(clazz.val());
        	var count = $("#listClass option").length;
        	
        	if( clazz.attr("data-parent")!="0"){
        		for(var i = 0; i < count; i++){
            		if($("#listClass").get(0).options[i].value == clazz.attr("data-parent")){
            			$("#className").val($("#listClass").get(0).options[i].text + ">" + clazz.text().trim());
            		}
            	}
        	}else{
        		$("#className").val(clazz.text().trim());
        	}
        	$("#goodsId").val("");
        	$("#goodsName").val("");
    	}

    	if($("#productType").val()=="3"){
    		// 商品
        	$("#classId").val("");
        	$("#className").val("");
    	}
    	if($("#shopType").val()=="1"){
    		$("#cityCode").val("");
        	$("#cityShopId").val("");
    	} else if($("#shopType").val()=="2"){
    		$("#cityShopId").val("");
    	} else if($("#shopType").val()=="3"){
    		$("#cityCode").val("");
    	}
    	// 是否存在的验证
    	$.ajax({
    		type : "POST",
    		dataType : "json",
    		url : "../levelprice/validateBeforeSave",
    		data : $('#couponAdd').serialize(),
    		success : function(data) {
    			if (data.code == 200) {
    				$("#couponAdd").submit();
    			} else {
    				alert("相同的电商价格已经存在，请确认后再添加!");  
    			}
    		},
    		error : function(data) {
    			alert("操作失败，请联系管理员或技术人员!");  
    		}
    	});
    });

    updateInit();
});
/*
 * 选择商铺的回调函数
 */
function selectShopCallBack(shopIds,shopNames){
	$("#cityShopId").val(shopIds);
	$(".shopsName").html("已经选择的店铺：" + shopNames);
	$(".shopsName").show();
}
/*
 * 选择商品的回调函数
 */
function selectProductCallBack(goodsId,goodsName,imageUrl){
	$("#goodsId").val(goodsId);
	$("#goodsName").val(goodsName);
	$(".productName").html("已经选择的商品：" + goodsName);
	$(".productName").show();
}

function updateInit(){
	if($("#levelCouponId").val()!=""){
		var shopType = $("#shopType").val();
		if(shopType=="2"){
			$(".shopTypeCity").show();
		} else if(shopType=="3"){
			$(".shopsName").show();
		}

		var productType = $("#productType").val();
		if(productType=="2"){
			$(".productTypeClass").show();
		} else if(productType=="3"){
			$(".productName").show();
			$(".pricerow").show();
		}
	}
}
