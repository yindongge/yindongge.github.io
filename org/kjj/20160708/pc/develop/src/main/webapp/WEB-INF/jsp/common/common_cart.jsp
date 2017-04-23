<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<div class="shopcar fr">
	<div class="shop">					
		<i  class="glyphicon icon2 icon"></i>
		<i  class="glyphicon glyphicon-menu-down icon3 icon"></i>
		<i  class="glyphicon icon4 icon"><c:if test="${kjjcartcount==null}">0</c:if><c:if test="${kjjcartcount!=null}">${kjjcartcount}</c:if></i>
		<a href="${ctx}/cart/list">去购物车结算</a>
	</div>
	<div class="space" style="display: none;"></div>
	<div class="sale" style="display: none;">
		<div class="nogoods">
			<p class="spepcial3"><a href="${ctx}">购物车中还没有商品，赶紧选购吧</a></p>
		</div>
		<ul class="havegoods">
		</ul>
	</div>
</div>
<script type="text/javascript">
$(function () {
	$('.shop').mouseenter(function(){
		if($('.sale').is(":hidden")){
			$('.sale').show();
			$('.space').show();
			showCart();
		}
	});
	$('.shopcar').mouseleave(function(){
		$('.sale').hide();
		$('.space').hide();
	});
	
});

function showCart(){
	$.ajax({  
        type: "post",  
        dataType: "json",
        url: "${ctx}/cart/ajaxList",
        success: function(data) {
        	if(data.code == 200){
	       		if(data.listCart.length == 0){
	       			$("i.icon4").text("0");
	       			$("div.nogoods").show();
	       			$("ul.havegoods").hide();
	       		}else{
	       			var count = 0;
	       			var money = 0;
	       			var divHtml = "";
	        		$.each(data.listCart,function(idx, obj){
	        			count += obj.orgProductItemAll.orgProductItemAide.userBuy;
	        			if(obj.orgProductItemAll.orgProductItemAide.realPrice != null){
	        				money += obj.orgProductItemAll.orgProductItemAide.userBuy*obj.orgProductItemAll.orgProductItemAide.realPrice;
	        			}
	        			divHtml += "<li>";
	        			divHtml += "<div class='goods-left'>";
	        			divHtml += "<a href='${ctx}/item/"+obj.orgProductItemAll.orgProductItemAide.goodsId+"' target='_blank'><img src='"+obj.orgProductItemAll.orgProductItem.goodsImg180+"'/></a>";	
	        			divHtml += "</div>";
	        			divHtml += "<div class='goods-center'>";
	        			divHtml += "<p>"+obj.orgProductItemAll.orgProductItem.goodsName+"</p>";	
	        			divHtml += "</div>";
	        			divHtml += "<div class='goods-right'>";
	        			if(obj.orgProductItemAll.orgProductItemAide.realPrice == null){
		        			divHtml += "<span>暂无报价</span>";
	        			}else{
		        			divHtml += "<span>￥"+obj.orgProductItemAll.orgProductItemAide.realPrice.toFixed(2)+"*"+obj.orgProductItemAll.orgProductItemAide.userBuy+"</span>";
	        			}
	        			divHtml += "<br/>";	
	        			divHtml += "<a href='javascript:delCart("+obj.orgProductItemAll.orgProductItemAide.goodsId+");' class='delete'>删除</a>";	
	        			divHtml += "</div>";
	        			divHtml += "</li>";
		            }); 
	        		divHtml += "<li>";
	        		divHtml += "<div class='goods-foot'>";
	        		divHtml += "<p>共计<i class='blue'>"+count+"</i>件商品共计￥<i class='blue'>"+money.toFixed(2)+"元</i></p>";
	        		divHtml += "<p><a href='${ctx}/cart/list' class='btn btn-warning pull-right'>去购物车结算</a></p>";
					divHtml += "</div>";
					divHtml += "</li>";
					$("i.icon4").text(count);
	        		$("ul.havegoods").html(divHtml);
	        		$("ul.havegoods").show();
	        		$("div.nogoods").hide();
	       		}
        	}
        },  
        error: function(data) {  
        }  
    })  ;
}

function delCart(goodsId){
	$.ajax({  
        type: "post",  
        dataType: "json",
        url: "${ctx}/cart/del",
        data: {'goodsIds':goodsId},
        success: function(data) {
        	if(data.code==200){
        		showCart();
        	}
        },  
        error: function(data) {  
        }  
    })  ;
}
</script>