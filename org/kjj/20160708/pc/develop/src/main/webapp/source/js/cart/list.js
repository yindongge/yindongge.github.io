$(function () {
	
	$(window).scroll(function(){
		var scrollH=$(window).scrollTop();
	    var windowH=$(window).height();
		var loveH=$(".youlove").offset().top;
		if(scrollH+windowH>loveH)
		{
			$('.car-footer').removeClass('fix');
		}
		else
		{
			$('.car-footer').addClass('fix');
		}
	});
	
	//优惠下拉
	$('#showInfo').on("click",".shopcar_fixed_span",function(){
		var fixC=('.fixed_content');
		$('<span class="zhegai"></span>').appendTo('.fixed_div ');
		$(this).toggleClass('hover').parent(fixC).toggleClass('on');
		if(!$(fixC).hasClass('on')){
			$('.zhegai').remove();
		}
	});
	
	//促销
	$('#showInfo').on("click",".radio_confirm .confirm",function(){
		$("div.toggle-mask").show();
		$.ajax({  
	        type: "post",  
	        dataType: "json",
	        url: "../cart/selectDiscount",
	        data: {'goodsId':$(this).parents(".list").find(":checkbox[name='goodsIds']").val(),
	        	'discountId':$(":checked[name='discount_"+$(this).parents(".list").find(":checkbox[name='goodsIds']").val()+"']").val()},
	        success: function(data) {
	        	if(data.code=200){
	        		$("#showInfo").html(data.showInfo);
	        		$("div.toggle-mask").hide();
	        	}
	        },  
	        error: function(data) {  
	        }  
	    })  ; 
	} );
	
	//促销取消
	$('#showInfo').on("click",".radio_confirm .cancel",function(){
		$(this).parents(".fixed_div").find(".oldSelect").prop("checked",true);
		$(this).parents(".fixed_content").removeClass("on").find(".shopcar_fixed_span").removeClass("hover");
		$(this).parents(".fixed_content").find('.zhegai').remove();
	} );
	
	//数量减少
	$('#showInfo').on("click","[name='amountMinus']",function(){
		var amount = $(this).parent().find(":text[name='amount']");
		
		if(amount.val() > 1){
			amount.val(parseInt(amount.val())-1);
		}
		
		if(parseInt(amount.val())>parseInt(amount.attr("data-buy-max")) && amount.attr("data-buy-max")!=amount.attr("data-inventory-num")){
			amount.parents(".list-quantity").find(".quantity-text").html("限购"+amount.attr("data-buy-max")+"件");
		}else if(parseInt(amount.val())>parseInt(amount.attr("data-inventory-num"))){
			amount.parents(".list-quantity").find(".quantity-text").html("剩余"+amount.attr("data-inventory-num")+"件");
		}else if(parseInt(amount.attr("data-inventory-num")) < 6){
			amount.parents(".list-quantity").find(".quantity-text").html("剩余"+amount.attr("data-inventory-num")+"件");
		}else{
			amount.parents(".list-quantity").find(".quantity-text").html("");
		}
		
		edit($(this).parents(".list").find(":checkbox[name='goodsIds']").val(),amount);
	});
	
	//数量增加
	$('#showInfo').on("click","[name='amountPlus']",function(){
		var amount = $(this).parent().find(":text[name='amount']");
		
		if(parseInt(amount.val())>=parseInt(amount.attr("data-buy-max")) && amount.attr("data-buy-max")!=amount.attr("data-inventory-num")){
			amount.parents(".list-quantity").find(".quantity-text").html("限购"+amount.attr("data-buy-max")+"件");
		}else if(parseInt(amount.val())>=parseInt(amount.attr("data-inventory-num"))){
			amount.parents(".list-quantity").find(".quantity-text").html("剩余"+amount.attr("data-inventory-num")+"件");
		}else if(parseInt(amount.attr("data-inventory-num")) < 6){
			amount.val(parseInt(amount.val())+1);
			amount.parents(".list-quantity").find(".quantity-text").html("剩余"+amount.attr("data-inventory-num")+"件");
			edit($(this).parents(".list").find(":checkbox[name='goodsIds']").val(),amount);
		}else{
			amount.val(parseInt(amount.val())+1);
			amount.parents(".list-quantity").find(".quantity-text").html("");
			edit($(this).parents(".list").find(":checkbox[name='goodsIds']").val(),amount);
		}
	});
	
	//数量改变
	$('#showInfo').on("focusout",":text[name='amount']",function(){
	 	if(!isPlusInteger($(this).val())){
			$(this).val($(this).attr('data-old'));
		}else if(parseInt($(this).val())>parseInt($(this).attr("data-buy-max")) && $(this).attr("data-buy-max")!=$(this).attr("data-inventory-num")){
			$(this).val($(this).attr("data-buy-max"));
			$(this).parents(".list-quantity").find(".quantity-text").html("限购"+$(this).attr("data-buy-max")+"件");
			edit($(this).parents(".list").find(":checkbox[name='goodsIds']").val(),$(this));
		}else if(parseInt($(this).val())>parseInt($(this).attr("data-inventory-num"))){
			$(this).val($(this).attr("data-inventory-num"));
			$(this).parents(".list-quantity").find(".quantity-text").html("剩余"+$(this).attr("data-inventory-num")+"件");
			edit($(this).parents(".list").find(":checkbox[name='goodsIds']").val(),$(this));
		}else if(parseInt($(this).attr("data-inventory-num")) < 6){
			$(this).parents(".list-quantity").find(".quantity-text").html("剩余"+$(this).attr("data-inventory-num")+"件");
			edit($(this).parents(".list").find(":checkbox[name='goodsIds']").val(),$(this));
		}else{
			$(this).parents(".list-quantity").find(".quantity-text").html("");
			edit($(this).parents(".list").find(":checkbox[name='goodsIds']").val(),$(this));
		}
	});
	
});

function selectAllOn(){
	$("div.toggle-mask").show();
	$.ajax({  
        type: "post",  
        dataType: "json",
        url: "../cart/selectAllOn",
        success: function(data) {
        	if(data.code=200){
        		$("#showInfo").html(data.showInfo);
        		$("div.toggle-mask").hide();
        	}
        },  
        error: function(data) {  
        }  
    })  ; 
}

function selectAllOff(){
	$("div.toggle-mask").show();
	$.ajax({  
		type: "post",  
		dataType: "json",
		url: "../cart/selectAllOff",
		success: function(data) {
			if(data.code=200){
				$("#showInfo").html(data.showInfo);
				$("div.toggle-mask").hide();
			}
		},  
		error: function(data) {  
		}  
	})  ; 
}

function selectOn(goodsId){
	$("div.toggle-mask").show();
	$.ajax({  
        type: "post",  
        dataType: "json",
        url: "../cart/selectOn",
        data: {'goodsId':goodsId},
        success: function(data) {
        	if(data.code=200){
        		$("#showInfo").html(data.showInfo);
        		$("div.toggle-mask").hide();
        	}
        },  
        error: function(data) {  
        }  
    })  ; 
}

function selectOff(goodsId){
	$("div.toggle-mask").show();
	$.ajax({  
		type: "post",  
		dataType: "json",
		url: "../cart/selectOff",
		data: {'goodsId':goodsId},
		success: function(data) {
			if(data.code=200){
				$("#showInfo").html(data.showInfo);
				$("div.toggle-mask").hide();
			}
		},  
		error: function(data) {  
		}  
	})  ; 
}
var delGoodsId;
function del(goodsId){
	delGoodsId = goodsId;
	$("#divDel").show();
	$("div.toggle-mask").show();
}

function delSelect(){
	delGoodsId = "all";
	$("#divDel").show();
	$("div.toggle-mask").show();
}

function delCancel(){
	delGoodsId = "";
	$("#divDel").hide();
	$("div.toggle-mask").hide();
}

function delConfirm(){
	if(delGoodsId=="all"){
		$.ajax({  
	        type: "post",  
	        dataType: "json",
	        url: "../cart/del",
	        data: $(":checked[name='goodsIds']").serialize(),
	        success: function(data) {
	        	if(data.code=200){
	        		$("div.into").hide();
		        	$("div.toggle-mask").hide();
	        		$("#showInfo").html(data.showInfo);
	        	}
	        },  
	        error: function(data) {  
	        }  
	    }) ;
		
	}else{
		$.ajax({  
	        type: "post",  
	        dataType: "json",
	        url: "../cart/del",
	        data: {'goodsIds':delGoodsId},
	        success: function(data) {
	        	if(data.code=200){
	        		$("div.into").hide();
		        	$("div.toggle-mask").hide();
	        		$("#showInfo").html(data.showInfo);
	        	}
	        },  
	        error: function(data) {  
	        }  
	    })  ; 
	}
}

//修改商品数量
function edit(goodsId,amount){
	$("div.toggle-mask").show();
	//修改减少数量按钮是否可用
	if(amount.val() == 1){
		amount.parent().find("[name='amountMinus']").addClass('remove');
	}else{
		amount.parent().find("[name='amountMinus']").removeClass('remove');
	}
	$.ajax({  
        type: "post",  
        async: false,
        dataType: "json",
        url: "../cart/edit",
        data: {"goodsId":goodsId,"amount":amount.val()},
        success: function(data) {
        	if(data.code=200){
        		$("#showInfo").html(data.showInfo);
        		$("div.toggle-mask").hide();
        	}
        },  
        error: function(data) {  
        }  
    })  ;
}