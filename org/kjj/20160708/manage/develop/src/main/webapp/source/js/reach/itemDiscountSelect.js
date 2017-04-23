
$(function () {
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
		
		var goodsIdsArr=[];
		
		$(".icon11").on("click",".btn-success",function(){
//			var goodsId= $(this).attr("data-goods-id");
//			for(var i = 0; i < goodsIdsArr.length;i++){
//				if(goodsIdsArr[i]==goodsId){
//					break;
//				}
//			}
//			goodsIdsArr.push(goodsId);
//			parent.setGoodsIds(goodsIdsArr);
//			$(this).removeClass("btn-success");
//			$(this).addClass("btn-danger");
//			$(this).html("取消");
			var button = $(this);
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
		});
		
		$(".icon11").on("click",".btn-danger",function(){
//			var goodsId= $(this).attr("data-goods-id");
//			for(var i = 0; i < goodsIdsArr.length;i++){
//				if(goodsIdsArr[i]==goodsId){
//					goodsIdsArr.splice(i,1);
//					break;
//				}
//			}
//			parent.setGoodsIds(goodsIdsArr);
//			$(this).removeClass("btn-danger");
//			$(this).addClass("btn-success");
//			$(this).html("选择");
			var button = $(this);
			$.ajax({
	            type: "POST",
	            dataType: "json",
	            url: "../productItem/discountCancel",
	            data: {
	            	'discountId':$('#discountId').val(),
	            	'typeId':$('#typeId').val(),
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