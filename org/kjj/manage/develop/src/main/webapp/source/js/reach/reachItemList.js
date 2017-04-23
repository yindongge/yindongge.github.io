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
	
	$(".icon11").on("blur",".form-control.amount",function(){
		if(!isPlusInteger($(this).val())){
			alert('请输入整数！');	
			$(this).val('1');
		}
	});
	
	
	$(".icon11").on("click",".btn-success",function(){
		var button = $(this);
		var inputAmount=$(this).parent().prev().find(':text');
		var amount=inputAmount.val();
		//如果没有收入赠品数量，默认为1
		if(amount==""){
			amount=1;
			inputAmount.val("1");
		}
		$.ajax({
            type: "POST",
            dataType: "json",
            url: "../reach/itemSelect",
            data: {
            	'rdId':$('#reachDiscountId').val(),
            	'amount':amount,
            	'goodsId':button.attr("data-goods-id")
            },
            success: function (data) {
          		if(data.code=200){
          			inputAmount.attr('readonly','readonly');  
          			button.removeClass("btn-success").addClass("btn-danger");
          			button.html("取消");
          		}
            }
        });
	});
	
	$(".icon11").on("click",".btn-danger",function(){
		var button = $(this);
		$.ajax({
            type: "POST",
            dataType: "json",
            url: "../reach/itemCancel",
            data: {
            	'rdId':$('#reachDiscountId').val(),
            	'goodsId':button.attr("data-goods-id"),
            },
            success: function (data) {
          		if(data.code=200){
          			button.parent().prev().find(':text').removeAttr("readonly");  
          			button.parent().prev().find(':text').val('');  
          			button.removeClass("btn-danger").addClass("btn-success");
          			button.html("选择");
          		}
            }
        });
	});
	
		
});

