$(function(){
	var mySwiper = new Swiper('.swiper-container',{
		prevButton:'.swiper-button-prev',
		nextButton:'.swiper-button-next',
		onSlideChangeStart: function(swiper){
			var catId = $("#catId").val();
			var keyword = $("#keyword").val();
			var pageNo = $(".swiper-slide-active").attr("data-page");
			productList(catId,keyword,pageNo);
		    }
		});
	
	var catIdHid = $("#catId").val();
	$(".future_title a").each(function(){
		catId = $(this).attr("data-catId");
		if(catIdHid == catId){
			$(this).addClass("on");
		}
	});
	
	$(".same-btn").on('click',function(){
		var catId = $("#catId").val();
		var keyword = $("#keyword").val();
//		var btId = $(this).attr("id");
		var pageNo = "";
//		if(btId == "prev"){
			pageNo = $(".swiper-slide-active").attr("data-page");
//		}else if(btId == "next"){
//			pageNo = $(".swiper-slide-active").attr("data-page");
//		}
		productList(catId,keyword,pageNo);
	});
});

function productList(catId,keyword,pageNo){
	if( "" != pageNo){
		$.ajax({
			type:'post',
			dataType:'json',
			url:'../search/resultAjax',
			data:{"pageNumber":pageNo,"catId":catId,"keyword":keyword},
			success:function(data){
				var html="<div class=\"list-jingpin\">";
				$.each(data.page.content,function(idx,obj){
					html+="<a onclick=\"productTail('"+obj.orgProductItem.goodsId+"')\"><div class=\"jinpin-img\"><img src='"+obj.orgProductItem.goodsImg180+"'></div>";
					html+="<div class=\"jinpin-text\">";
					html+="<dl><dt>商品名称 </dt><dd>"+obj.orgProductItem.goodsName+"</dd></dl>";
					html+="<dl class=\"specialheight\"><dt class=\"price yellow\">";
					if(null == obj.orgProductItemAide.realPrice){
						html+="暂无报价</dt>";
					}
					if(null != obj.orgProductItemAide.realPrice){
						html+="￥"+(obj.orgProductItemAide.realPrice).toFixed(2)+"</dt>";
					}
					if(obj.orgProductItemAide.markLimitTimeDiscount){
						html+="<dd><span class=\"bluezhekou\">限时折扣</span></dd>";
					}
					html+="</dl></div></a>";
				});
				html+="</div>";
				$(".swiper-slide-active").html(html);
			},
			error:function(data){}
		});
	}
}

function productTail(goodsId){
	window.open('../item/'+goodsId+'/1', '_blank');
//	location.href='../item/'+goodsId;
}