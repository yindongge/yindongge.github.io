$(function(){
	$('.hotitem').hover(function(){
		$(this).find('.black_mask').stop().hide();
		$(this).find('.hot-icon').addClass('on');
	},function(){
		$(this).find('.black_mask').stop().show();
		$(this).find('.hot-icon').removeClass('on');
	});
	
	$(".hot-icon").on('click',function(e){
		addCart($(this).parent().attr("data-goodsid"),$(this).parent().attr("data-goodssn"));
		animateAddCart($('.side_item.side_2'),$(this).parents('.hot-list').find('.hot-img img'));
	})
	
	$("#self").on('click',function(){
		location.href='../../security/desc';
	})
	
	$("#cart").on('click',function(){
		location.href='../../cart/list';
	})
	
	$("#coupon").on('click',function(){
		location.href='../../coupon/list';
	})
	
	$("#myorder").on('click',function(){
		location.href='../../order/list';
	})
	
	$("#feedback").on('click',function(){
		location.href='../../feedback/init';
	})
});
//加入购物车
function addCart(goodsId,goodsSn){
	$.ajax({  
        type: "post",  
        dataType: "json",
        url: "../../cart/addCartAjax",
        data: {'goodsId':goodsId,'goodsSn':goodsSn},
        success: function(data) {
        	getCartCount();
        },  
        error: function(data) {  
        }  
    });  
}
function getCartCount(){
	$.ajax({  
        type: "post",  
        dataType: "json",
        url: "../../cart/ajaxList",
        success: function(data) {
        	if(data.code == 200){
	       		if(data.listCart.length == 0){
	       			$(".red_count").html("0");
	       		}else{
	       			var count = 0;
	        		$.each(data.listCart,function(idx, obj){
	        			count += obj.orgProductItemAll.orgProductItemAide.userBuy;
		            }); 
					$(".red_count").html(count);
	       		}
        	}
        },  
        error: function(data) {  
        }  
    })  ;
}

function animateAddCart(cartEnd,imgtodrag){
	var imgclone = imgtodrag.clone().offset({
		top: imgtodrag.offset().top + 50,
		left: imgtodrag.offset().left + 50
	}).css({
		'opacity': '0.5',
		'position': 'absolute',
		'height': '100px',
		'width': '100px',
		'z-index': '100'
	}).appendTo($('body')).animate({
		'top': cartEnd.offset().top + 0,
		'left': cartEnd.offset().left + 0,
		'width': 40,
		'height': 40
	}, 1000, 'easeInOutExpo');
	setTimeout(function () {
		cartEnd.effect('shake', { times: 2}, 300);//购物车抖动次数
	}, 1500);//购物车抖动
	imgclone.animate({
		'width': 0,
		'height': 0
	}, function () {
		$(this).detach();
	});
}