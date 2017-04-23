$(function(){
	//类型选择
    $("#productType").change(function(){
    	var productType = $("#productType :selected").val();
    	if(productType == 0 || productType == 1){
    		$(".productTypeClass").hide();
    		$("#showProduct").hide();
    		$("#productInfo").show();
    	}else if(productType == 2){
    		$(".productTypeClass").show();
    		$("#showProduct").hide();
    		$("#productInfo").hide();
    		//获取等级列表
    	}else if(productType == 3){
    		$(".productTypeClass").hide();
    		$("#showProduct").show();
    		$("#productInfo").show();
    		layer.open({
			    type: 2,
			    title: '选择商品',
			    shadeClose: true,
			    shade: 0.8,
				maxmin: true, //开启最大化最小化按钮
			    area: ['800px', '630px'],
			    content: ['discountList?typeId=5&discountId='+$('#discountId').val(),'no']
			}); 
    	}
    });  
    
    $("#showProduct").on('click',function(){
    	$(".productTypeClass").hide();
		$("#showProduct").show();
		$("#productInfo").show();
		layer.open({
		    type: 2,
		    title: '选择商品',
		    shadeClose: true,
		    shade: 0.8,
			maxmin: true, //开启最大化最小化按钮
		    area: ['800px', '630px'],
		    content: ['discountList?typeId=5&discountId='+$('#discountId').val(),'no']
		}); 
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
});

function setGoodsIds(goodsIds){
	$('#listGoods').val(goodsIds);
}


