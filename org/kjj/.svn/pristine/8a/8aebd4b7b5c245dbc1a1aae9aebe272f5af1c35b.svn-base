$(function(){
	$("#isbug").on('click',function(e){
		
		addCart($(this).parent().attr("data-goodsid"),$(this).parent().attr("data-goodssn"));
		animateAddCart($('.side_item.side_2'),$(this).parents('.hot-list').find('.hot-img img'));
	})
	
	
});


//加入购物车
function addCart(goodsId,goodsSn,obj){
	$.ajax({  
        type: "post",  
        dataType: "json",
        url: "../../cart/add",
        data: {'goodsId':goodsId,'goodsSn':goodsSn},
        success: function(data) {
        	if(data.code==200){
        		//autoAlert("添加成功");
        		animateAddCart(obj,$('.fixed-shopcar'));
        	}
        },  
        error: function(data) {  
        }
    });  
}

function move() {
	h = $(window).height() / 50;
	t = $(document).scrollTop();
	if (t > h) {
		$('.gotop').show();
	} else {
		$('.gotop').hide();
	}
};

$(window).scroll(function(e) {
	move();

	$('.gotop').click(function(e) {
		$(document).scrollTop(0);
	});
});

function autoAlert(str) {
	$('body').append("<div class=' shakeme'>" + str + "</div>");
	$('.shakeme').animate({
		top : "40%",
		opacity : 1
	}, 800);
	setTimeout(function() {
		$('.shakeme').remove();
	}, 1500);
};