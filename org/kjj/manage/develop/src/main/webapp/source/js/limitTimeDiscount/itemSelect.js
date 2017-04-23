	$(function () {
		//选择分类生成品牌
		//区域省下拉列表选择变更
		$("#superClassId").change(function(){
			if($('#superClassId').val() == ''){
				$('#brandId').empty();
	          	$('#brandId').append("<option value='-1'>选择品牌</option>");
			}else{
				$.ajax({
		            type: "POST",
		            dataType: "json",
		            url: "../brand/getgrandbyclass",
		            data: {'classId':$('#superClassId').val()},
		            success: function (data) {
		            	if(data.code==200){
		            		 $('#brandId').empty();
				           	 var html = "<option value=''>选择品牌</option>";
				                $.each(data.orgBrand,function(idx, obj){
				                	html += "<option value='"+obj.productBrandId+"'>"+obj.productBrandName+"</option>";
			                }); 
			               $('#brandId').append(html);
		            	}
		            },
		            error: function(data) {
		            }
		        });
			}
		});
		
		$(".icon11").on("click",".btn-success",function(){
			var button = $(this);
			if(!check(button)){
				return false;
			}
			$.ajax({
	            type: "POST",
	            dataType: "json",
	            url: "../limitTimeDiscount/goodsAdd",
	            data: {
	            	'ltdId':$('#ltdId').val(),
	            	'goodsId':button.attr("data-goods-id"),
	            	'goodsTitle':button.parents("tr").find("[name='goodsTitle']").val(),
	            	'discount':button.parents("tr").find("[name='discount']").val(),
	            	'price':button.parents("tr").find("[name='price']").val(),
	            	'shopNum':button.parents("tr").find("[name='shopNum']").val(),
	            	'userNum':button.parents("tr").find("[name='userNum']").val()
	            },
	            success: function (data) {
	          		if(data.code=200){
	          			button.hide();
	          			button.parents("td").find(".btn-info").show();
	          			button.parents("td").find(".btn-danger").show();
	          		}
	            },
	            error: function(data) {
	            }
	        });
		});
		
		$(".icon11").on("click",".btn-info",function(){
			var button = $(this);
			if(!check(button)){
				return false;
			}
			$.ajax({
	            type: "POST",
	            dataType: "json",
	            url: "../limitTimeDiscount/goodsUpdate",
	            data: {
	            	'ltdId':$('#ltdId').val(),
	            	'goodsId':button.attr("data-goods-id"),
	            	'goodsTitle':button.parents("tr").find("[name='goodsTitle']").val(),
	            	'discount':button.parents("tr").find("[name='discount']").val(),
	            	'price':button.parents("tr").find("[name='price']").val(),
	            	'shopNum':button.parents("tr").find("[name='shopNum']").val(),
	            	'userNum':button.parents("tr").find("[name='userNum']").val()
	            },
	            success: function (data) {
	          		if(data.code=200){
	          			alert("修改成功");
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
	            url: "../limitTimeDiscount/goodsDelete",
	            data: {
	            	'ltdId':$('#ltdId').val(),
	            	'goodsId':button.attr("data-goods-id")
	            },
	            success: function (data) {
	          		if(data.code=200){
	          			button.hide();
	          			button.parents("td").find(".btn-info").hide();
	          			button.parents("td").find(".btn-success").show();
	          		}
	            },
	            error: function(data) {
	            }
	        });
		});
	});
	
	function check(button){
		var discount = button.parents("tr").find("[name='discount']").val();
		var price = button.parents("tr").find("[name='price']").val();
		var shopNum = button.parents("tr").find("[name='shopNum']").val();
		var userNum = button.parents("tr").find("[name='userNum']").val();
		if(discount == "" && price == ""){
			alert("折扣和金额不能都为空！");
			return false;
		}else if(discount != "" && price != ""){
			alert("折扣和金额都只能填一个！");
			return false;
		}
		if(discount != ""){
			if((!/^[1-9][0-9]$/.test(discount)) && (!/^[1-9]$/.test(discount))){
				alert("折扣格式错误！");
				return false;
			}
			if(parseInt(discount) < 1){
				alert("折扣最小为1！");
				return false;
			}
			if(parseInt(discount) > 99){
				alert("折扣最大为99！");
				return false;
			}
		}
		
		if(price != ""){
			if(!/^[0-9]+\.[0-9][0-9]$/.test(price)){
				alert("限购价格格式错误！");
				return false;
			}
			if(parseFloat(price) < 0.00){
				alert("限购价格最小为0.00！");
				return false;
			}
			if(parseFloat(price) > 999999.99){
				alert("限购价格最大为999999.99！");
				return false;
			}
		}
		
		if(shopNum != ""){
			if(!/^[1-9][0-9]*$/.test(shopNum)){
				alert("限购门店格式错误！");
				return false;
			}
			if(parseInt(shopNum) < 1){
				alert("限购门店最小为1！");
				return false;
			}
			if(parseInt(shopNum) > 99999){
				alert("限购门店最大为99999！");
				return false;
			}
		}
		
		if(userNum != ""){
			if(!/^[1-9][0-9]*$/.test(userNum)){
				alert("限购单人格式错误！");
				return false;
			}
			if(parseInt(userNum) < 1){
				alert("限购单人最小为1！");
				return false;
			}
			if(parseInt(userNum) > 99999){
				alert("限购单人最大为99999！");
				return false;
			}
		}
		return true;
	}