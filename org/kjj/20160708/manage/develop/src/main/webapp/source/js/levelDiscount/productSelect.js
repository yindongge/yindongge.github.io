$(function () {
		//选择分类生成品牌
		//区域省下拉列表选择变更
		$("#catId").change(function(){
			if($('#catId').val() == -1){
				$('#brandId').empty();
	          	$('#brandId').append("<option value='-1'>选择品牌</option>");
			}else{
				$.ajax({
		            type: "POST",
		            dataType: "json",
		            url: "../brand/getgrandbyclass",
		            data: {'classId':$('#catId').val()},
		            success: function (data) {
		           	 $('#brandId').empty();
		           	 var html = "<option value='-1'>选择品牌</option>";
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
		// 点击选择按钮
		$(".icon12").on("click",".btn-success",function(){
			var button = $(this);
			/*
			$.ajax({
	            type: "POST",
	            dataType: "json",
	            url: "../productItem/discountSelect",
	            data: {
	            	'discountId':$('#discountId').val(),
	            	'typeId':$('#typeId').val(),
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
	        */
			parent.selectProductCallBack(button.attr("data-goods-id"),button.attr("data-goods-name"),button.attr("data-goods-url"));
			var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			parent.layer.close(index); //再执行关闭
			
		});
	});