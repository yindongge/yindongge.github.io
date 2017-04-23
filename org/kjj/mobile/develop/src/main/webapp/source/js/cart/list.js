var editFlg=1;

$(function () {

	//数量减少
	$('#showInfo').on("click","[name='amountMinus']",function(){
		var amount = $(this).parent().find(":text[name='amount']");
		if(parseInt(amount.val()) > 1){
			amount.val(parseInt(amount.val())-1);
			edit($(this).parents(".car-item").find(".goodsSelect").attr("data-goods-id"),amount);
		}
	});
	
	//数量增加
	$('#showInfo').on("click","[name='amountPlus']",function(){
		var amount = $(this).parent().find(":text[name='amount']");
		if(parseInt(amount.val())>=parseInt(amount.attr("data-buy-max")) && amount.attr("data-buy-max")!=amount.attr("data-inventory-num")){
			autoAlert("限购"+amount.attr("data-buy-max")+"件");
		}else if(parseInt(amount.val())>=parseInt(amount.attr("data-inventory-num"))){
			autoAlert("库存不足,剩余"+amount.attr("data-inventory-num")+"件");
		}else{
			amount.val(parseInt(amount.val())+1);
			edit($(this).parents(".car-item").find(".goodsSelect").attr("data-goods-id"),amount);
		}
	});
	
	//数量改变
	$('#showInfo').on("focusout",":text[name='amount']",function(){
	 	if(!isPlusInteger($(this).val())){
			$(this).val($(this).attr('data-old'));
		}if(parseInt($(this).val())>parseInt($(this).attr("data-buy-max")) && $(this).attr("data-buy-max")!=$(this).attr("data-inventory-num")){
			$(this).val($(this).attr("data-buy-max"));
			autoAlert("限购"+$(this).attr("data-buy-max")+"件");
			edit($(this).parents(".car-item").find(".goodsSelect").attr("data-goods-id"),$(this));
		}else if(parseInt($(this).val())>parseInt($(this).attr("data-inventory-num"))){
			$(this).val($(this).attr("data-inventory-num"));
			autoAlert("库存不足,剩余"+$(this).attr("data-inventory-num")+"件");
			edit($(this).parents(".car-item").find(".goodsSelect").attr("data-goods-id"),$(this));
		}else{
			edit($(this).parents(".car-item").find(".goodsSelect").attr("data-goods-id"),$(this));
		}
	});
	
	//全选
	$('#bottomInfo').on("click","#selectAllDiv",function(){					
		if($("#selectAll").is(".checked")){
			selectAllOff();
		}else{
			selectAllOn();
		}
	});
	
	//单选
	$('#showInfo').on("click",".goodsSelect",function(){
		
		if($(this).is(".checked")){
			selectOff($(this).attr("data-goods-id"));
		}else{
			selectOn($(this).attr("data-goods-id"));
		}
		
	});
	
	//编辑
	$("#btnEdit").on("click",function(){
		if($(this).html()=='编辑'){
			editFlg=0;
			finishShow();
		}else{
			editFlg=1;
			editShow();
		}
	});
	
	//删除
	$('#bottomInfo').on("click","#btnDelete",function(){
		$(".mask").show();
		var goodsIds = "";
		$(".goodsSelect.checked").each(function(index){
			if(index!=0){
				goodsIds += ",";
			}
			goodsIds += $(this).attr("data-goods-id");
		});
		if(goodsIds==""){
			autoAlert("请选择要删除的商品！");
			$(".mask").hide();
		}else{
			$.ajax({  
				type: "post",  
				dataType: "json",
				url: "../cart/del",
				data: {'goodsIds':goodsIds},
				success: function(data) {
					if(data.code==200){
						$(".goodsSelect.checked").each(function(){
							$(this).parents(".car-list").remove();
						});
						jumpEmpty();
					}
					$(".mask").hide();
//					autoAlert("删除成功！");
				},  
				error: function(data) {  
					$(".mask").hide();
				}  
			});
		}
 		
	});
	
	//失效删除
	$("#showInfo").on('click',"#delInvalid",function(){
		var goodsIds = "";
		$(".car-list.gray-bg").each(function(index){
			if(index!=0){
				goodsIds += ",";
			}
			goodsIds += $(this).find('.car-item').attr("data-goods-id");
		});
		if(goodsIds!=""){
			$.ajax({  
				type: "post",  
				dataType: "json",
				url: "../cart/del",
				data: {'goodsIds':goodsIds},
				success: function(data) {
					if(data.code==200){
						$(".gray_span").each(function(){
							$(this).parents(".car-list").remove();
						});
						jumpEmpty();
					}
				},  
				error: function(data) {  
				}  
			})  ; 
		}
		$("#delInvalid").parent().hide();
	});
	
	//结算
	$('#bottomInfo').on("click","#btnPay",function(){
		var goodsIds = "";
		var length=$(".goodsSelect.checked").length;
		if(length==0){
			autoAlert('请选择要结算的商品！');
			return false;
		}else{
			$(".goodsSelect.checked").each(function(index){
				if(index!=0){
					goodsIds += ",";
				}
				goodsIds += $(this).attr("data-goods-id");
			});
			location.href="../order/addInit?goodsIds="+goodsIds;
		}
		
	});
	
	
	//显示促销
	$('#showInfo').on("click",".fixed_span",function(){
//		$('body').css({"overflow":'hidden'});
		$('body,html').css({"overflow":'hidden','position':'fixed','top':0,'bottom':0});
		$('.fixed_div').fadeOut("10");
		$(this).next().fadeIn("400");
	});
	
	//促销切换
	$('#showInfo').on("click",".checkselect",function(){
		$(".mask").show();
		$.ajax({  
	        type: "post",  
	        dataType: "json",
	        url: "../cart/selectDiscount",
	        data: {'goodsId':$(this).parents(".car-list").find(".goodsSelect").attr('data-goods-id'),
	        	'discountId':$(this).parent().attr('data-discountId')},
	        success: function(data) {
	        	if(data.code=200){
	        		afterRefreshPage(data);
	        	}
	        },  
	        error: function(data) {  
	        }  
	    })  ; 
	} );
	
	//关闭促销
	$('#showInfo').on("click",".fixed_div_title",function(){
		$(this).parents('.fixed_div').fadeOut("400");
		$('body,html').removeAttr("style");
	});
	
});


//修改商品数量
function edit(goodsId,amount){
	$('.mask').show();
	$.ajax({  
        type: "post", 
        async: false,
        dataType: "json",
        url: "../cart/edit",
        data: {"goodsId":goodsId,"amount":amount.val()},
        success: function(data) {
        	if(data.code==200){
        		afterRefreshPage(data);
        	}
        },  
        error: function(data) {  
        }  
    })  ;
	
}


//编辑可用
function editShow(){
	$("#btnEdit").html("编辑");
	selectAllOn();
}

//编辑禁用
function finishShow(){
	$("#btnEdit").html("完成");
	selectAllOff();
}


//跳转到空购物车页面
function jumpEmpty(){
	if($(".goodsSelect.checked").length==0 && $(".gray_span").length==0){
		location.href="../cart/list";
	}
}


function selectAllOn(){
	$(".mask").show();
	$.ajax({  
        type: "post",  
        dataType: "json",
        data:{editFlg:editFlg},
        url: "../cart/selectAllOn",
        success: function(data) {
        	if(data.code=200){
        		afterRefreshPage(data);
        	}
        },  
        error: function(data) {  
        }  
    })  ; 
}

function selectAllOff(){
	$(".mask").show();
	$.ajax({  
		type: "post",  
		dataType: "json",
		data:{editFlg:editFlg},
		url: "../cart/selectAllOff",
		success: function(data) {
			if(data.code=200){
				afterRefreshPage(data);
			}
		},  
		error: function(data) {  
		}  
	})  ; 
}

function selectOn(goodsId){
	$(".mask").show();
	$.ajax({  
        type: "post",  
        dataType: "json",
        url: "../cart/selectOn",
        data: {'goodsId':goodsId},
        success: function(data) {
        	if(data.code=200){
        		afterRefreshPage(data);
        	}
        },  
        error: function(data) {  
        }  
    })  ; 
}

function selectOff(goodsId){
	$(".mask").show();
	$.ajax({  
		type: "post",  
		dataType: "json",
		url: "../cart/selectOff",
		data: {'goodsId':goodsId},
		success: function(data) {
			if(data.code=200){
				afterRefreshPage(data);
			}
		},  
		error: function(data) {  
		}  
	})  ; 
}

function afterRefreshPage(data){
	$("#showInfo").html(data.showInfo);
	$("#bottomInfo").html(data.bottomInfo);
	$(".mask").hide();
	$('body,html').removeAttr("style");
}


