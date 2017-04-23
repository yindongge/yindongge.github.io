
$(function () {
		
		$(".icon11").on("click",".btn-success",function(){
			var button = $(this);
			$.ajax({
	            type: "POST",
	            dataType: "json",
	            url: "../reach/couponSelect",
	            data: {
	            	'rdId':$('#reachDiscountId').val(),
	            	'couponId':button.attr("data-coupon-id")
	            },
	            success: function (data) {
	          		if(data.code=200){
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
	            url: "../reach/couponCancel",
	            data: {
	            	'rdId':$('#reachDiscountId').val(),
	            	'couponId':button.attr("data-coupon-id"),
	            },
	            success: function (data) {
	          		if(data.code=200){
	          			button.removeClass("btn-danger").addClass("btn-success");
	          			button.html("选择");
	          		}
	            }
	        });
			
		});
	});

