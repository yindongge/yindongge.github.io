$(function(){
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
	$(".icon11").on('click','.btn-success',function(){
		var button = $(this);
		var goodsId = $(this).attr("data-goods-id");
		var moduleId = $("#moduleId").val();
		$.ajax({
			type:'post',
			dataType:'json',
			url:'../mobilePage/addGoods',
			data:{'goodsId':goodsId,"moduleId":moduleId},
			success:function(data){
				if(data.code == 200){
					button.removeClass("btn-success").addClass("btn-danger");
					button.html("取消");
					refreshOpener();
				}
			},
			error:function(data){
				
			}
		});
	});
	
	$(".icon11").on('click','.btn-danger',function(){
		var button = $(this);
		var goodsId = $(this).attr("data-goods-id");
		var moduleId = $("#moduleId").val();
		$.ajax({
			type:'post',
			dataType:'json',
			url:'../mobilePage/deleteGoods',
			data:{'goodsId':goodsId,"moduleId":moduleId},
			success:function(data){
				if(data.code == 200){
					button.removeClass("btn-danger").addClass("btn-success");
					button.html("选择");
				}
			},
			error:function(data){
				
			}
		});
	});
});