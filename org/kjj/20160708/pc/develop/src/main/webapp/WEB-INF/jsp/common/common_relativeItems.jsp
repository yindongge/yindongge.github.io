<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="box-left1">
<h5>相关商品</h5>
	<ul id="relativeItems" class="left-list">
	</ul>
</div>
<script type="text/javascript">
$(function(){
	$.ajax({
		type: "post",  
	    dataType:"json", 
	    url: "../advertisement/list",  
	    data:  {typeId:2,showNumber:4,catId:$("#relativeCartId").val()},
	    success: function(data,status,xhr) {
		    if(xhr.status==200){
			    	var divHtml="";
			    	if(data.page.content==undefined){
						$("#relativeItems").parent().hide();
					}else{
				    	$.each(data.page.content,function(index,obj){
					    	divHtml+="<li>";
					    	divHtml+="<a href=\"javascript:window.location.href='../item/"+obj.orgProductItem.goodsId+"'\"><img src=\""+obj.orgProductItem.goodsImg180+"\" /></a>";
					    	divHtml+="<div class=\"list-content\">";
					    	divHtml+="<p>"+obj.orgProductItem.goodsName+"</p>";
					    	if(obj.orgProductItemAide.realPrice == null){
			    			   divHtml+="<P class=\"yellow\">暂无报价</P>";
			    		    }else{
			    			   divHtml+="<P class=\"yellow\">￥"+obj.orgProductItemAide.realPrice.toFixed(2)+"</P>";
			    		    }
					    	divHtml+="</li>";
				    	});
						$("#relativeItems").append(divHtml);
						$("#relativeItems").find("li").find("img").hover(function(){
							$(this).css("border-color","#00f");
						},function(){
							$(this).css("border-color","#ccc");
						});
					}
		    }
	    },
	    error: function(data) {
	    	$("#relativeItems").parent().hide();
	    }
	});
	
	
});
</script>