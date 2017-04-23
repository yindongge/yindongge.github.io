$(function () {
		//时间选择器
		$(".date").datetimepicker({
			format: 'YYYY-MM-DD HH:mm:ss',
			sideBySide:true,
			locale:'zh-cn'
		});
		
	    $("#startTime").on("dp.change", function (e) {
	        $('#endTime').data("DateTimePicker").minDate(e.date);
	    });
	    $("#endTime").on("dp.change", function (e) {
	        $('#startTime').data("DateTimePicker").maxDate(e.date);
	    });
	    
	    //有效期选择
	    $("#timeType").change(function(){
	    	var timeType = $("#timeType :selected").val();
	    	if(timeType == 0){
	    		$(".timeTypeLimitDays").hide();
	    		$(".timeTypeStartEnd").show();
	    	}else if(timeType == 1){
	    		$(".timeTypeStartEnd").hide();
	    		$(".timeTypeLimitDays").show();
	    	}
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
	    
	    //类型选择
	    $("#productType").change(function(){
	    	var productType = $("#productType :selected").val();
	    	if(productType == 0 || productType == 1){
	    		$(".productTypeClass").hide();
	    	}else if(productType == 2){
	    		$(".productTypeClass").show();
	    		//获取等级列表
	    	}else if(productType == 3){
	    		$(".productTypeClass").hide();
	    	}
	    });
	    
	    //添加分类
	    $("#classAdd").click(function(){
	    	var clazz = $("#listClass :selected");
	    	if(!clazz.prop("disabled")){
		    	var html = "<span class='s9'>";
		    	html += "<input type='hidden' name='listClass' data-parent='"+clazz.attr("data-parent")+"' value='"+clazz.val()+"'/>";
		    	html += clazz.attr("data-name");
		    	html += "<i class='glyphicon glyphicon-remove-sign red'></i></span>";
		    	$("#divClass").append(html);
		    	//下级分类已经选择的删除
		    	$("#divClass [data-parent='"+clazz.val()+"']").parents("span").remove();
		    	//分类禁用
		    	clazz.prop("disabled",true);
		    	//下级分类禁用
		    	$("#listClass [data-parent='"+clazz.val()+"']").prop("disabled",true);
	    	}
	    });
	    
	    //删除分类
	    $("#divClass").on("click","span",function(){
	    	var clazz = $(this).find(":input");
	    	//分类恢复使用
	    	$("#listClass [value='"+clazz.val()+"']").prop("disabled",false);
	    	//下级分类恢复使用
	    	$("#listClass [data-parent='"+clazz.val()+"']").prop("disabled",false);
	    	//删除
	    	$(this).remove();
	    });
	    
	  	//校验
		$("#couponAdd").bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			}
		});
	});
	
