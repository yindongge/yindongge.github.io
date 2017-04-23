<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div id="popularItems" class="container">
	<div class="a">
		<div class="a-left">
			<span class="hot1"><img src="${imgBase}/icon/hot1.png"/></span>
			<ul>
			</ul>
		</div>
	</div>
</div>
<script type="text/javascript">

$(function(){
	$.ajax({
		type: "post",  
	    dataType:"json", 
	    url: "../advertisement/list",  
	    data:  {typeId:1,showNumber:4,catId:$("#relativeCartId").val()},
	    success: function(data,status,xhr) {
		    if(xhr.status==200){
			    	var divHtml="";
			    	if(data.page.content==undefined){
						$("#popularItems").empty();
					}else{
				    	$.each(data.page.content,function(index,obj){
							divHtml+="<li>";
							divHtml+="<div class=\"aimg-left\"><img style=\"cursor:pointer\" onclick=\"javascript:window.location.href='../item/"+obj.orgProductItem.goodsId+"'\" src=\""+obj.orgProductItem.goodsImg180+"\"/></div>";
							divHtml+="<div class=\"atext-right\">";
							divHtml+="<P><a href=\"../item/"+obj.orgProductItem.goodsId+"\">"+obj.orgProductItem.goodsName+"</a></P>";
							if(obj.orgProductItemAide.realPrice == null){
			    			   divHtml+="<P class=\"yellow\">暂无报价</P>";
			    		    }else{
			    			   divHtml+="<P class=\"yellow\">￥"+obj.orgProductItemAide.realPrice.toFixed(2)+"</P>";
			    		    }
			    		    if(obj.orgProductItemAide.canSale){
								divHtml+="<P><button onclick=addCart("+obj.orgProductItem.goodsId+",\""+obj.orgProductItem.goodsSn+"\") type=\"button\" class=\"btn btn-warning btn-sm\">立即抢购</button></P>";
			    		    }else{
								divHtml+="<P><button type=\"button\" class=\"btn btn-warning btn-sm\" style=\"background:gray;border-color:gray\" >立即抢购</button></P>";			    		    
			    		    }
							
							divHtml+="</div>";
							divHtml+="</li>";
			    		});
						$("#popularItems").find("ul").append(divHtml);
					}
		    }
	    },
	    error: function(data) {
	   	 $("#popularItems").empty();
	    }
	});
});

function addCart(goodsId,goodsSn){
	window.location.href="../cart/add?goodsId="+goodsId+"&goodsSn="+goodsSn+"&amount=1";  
}
</script>