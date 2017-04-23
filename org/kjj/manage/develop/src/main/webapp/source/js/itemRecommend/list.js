$(function () {
	
	//类型选择
    $("#recommendType").change(function(){
    	$("#pageform").submit();
    });
	
	//适用范围选择
    $("#shopType").change(function(){
    	var shop_type = $("#shopType :selected").val();
    	if(shop_type == 0 || shop_type == 1){
    		$("#cityCode").hide();
    		$("#shopId").hide();
    	}else if(shop_type == 2){
    		$("#cityCode").show();
    		$("#shopId").hide();
    	}else if(shop_type == 3){
    		$("#cityCode").hide();
    		$("#shopId").show();
    	}
    	$("#pageform").submit();
    });
	
  	//店铺选择
    $("#shopId").change(function(){
    	$("#pageform").submit();
    });
	//选择分类生成品牌
	//区域省下拉列表选择变更
	$("#superClassId").change(function(){
		if($('#superClassId').val() == ''){
			$('#brandId').empty();
          	$('#brandId').append("<option value=''>选择品牌</option>");
		}else{
			$.ajax({
	            type: "POST",
	            dataType: "json",
	            url: "../brand/getgrandbyclass",
	            data: {'classId':$('#superClassId').val()},
	            success: function (data) {
	           	 $('#brandId').empty();
	           	 var html = "<option value=''>选择品牌</option>";
	                $.each(data.orgBrand,function(idx, obj){
	                	html += "<option value='"+obj.productBrandId+"'>"+obj.productBrandName+"</option>";
	                }); 
	                $('#brandId').append(html);
	            },
	            error: function(data) {
	            }
	        });
		}
	});
	
	$(".icon11").on("click",".btn-success",function(){
		var button = $(this);
		$.ajax({
            type: "POST",
            dataType: "json",
            url: "../itemRecommend/select",
            data: {
            	'recommendType':$('#recommendType').val(),
            	'shopType':$('#shopType').val(),
            	'cityCode':$('#cityCode').val(),
            	'shopId':$('#shopId').val(),
            	'goodsId':button.attr("data-goods-id")
            },
            success: function (data) {
          		if(data.code=200){
          			button.removeClass("btn-success");
          			button.addClass("btn-danger");
          			button.html("取消");
          		}
            },
            error: function(data) {
            }
        });
	});
	
	$(".icon11").on("click",".btn-danger",function(){
		var button = $(this);
		$.ajax({
            type: "POST",
            dataType: "json",
            url: "../itemRecommend/cancel",
            data: {
            	'recommendType':$('#recommendType').val(),
            	'shopType':$('#shopType').val(),
            	'cityCode':$('#cityCode').val(),
            	'shopId':$('#shopId').val(),
            	'goodsId':button.attr("data-goods-id")
            },
            success: function (data) {
          		if(data.code=200){
          			button.removeClass("btn-danger");
          			button.addClass("btn-success");
          			button.html("选择");
          		}
            },
            error: function(data) {
            }
        });
	});
});