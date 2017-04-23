<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	<div id="loveItems" class="container">
			<div class="love">
				<h4>您可能喜欢的商品</h4>
				<div class="row">
				</div>
			</div>
		</div>
<script type="text/javascript">
$(function(){
	$.ajax({
		type: "post",  
	    dataType:"json", 
	    url: "../advertisement/list",  
	    data:  {typeId:3,showNumber:6,catId:$("#relativeCartId").val()},
	    success: function(data,status,xhr) {
		    if(xhr.status==200){
			    	var divHtml="";
			    	if(data.page.content==undefined){
						$("#loveItems").empty();
					}else{
				    	$.each(data.page.content,function(index,obj){
					    	divHtml+="<div style=\"cursor:pointer\" class=\"col-md-2\">";
					    	divHtml+="<div class=\"thumbnail\">";
					    	divHtml+="<img src=\""+obj.orgProductItem.goodsImg180+"\"/>";
					    	divHtml+="<div class=\"caption\">";
					    	divHtml+="<div class=\"list-content\">";
					    	divHtml+="<p>"+obj.orgProductItem.goodsName+"</p>";
					    	if(obj.orgProductItemAide.realPrice == null){
			    			   divHtml+="<P class=\"yellow\">暂无报价</P>";
			    		    }else{
			    			   divHtml+="<P class=\"yellow\">￥"+obj.orgProductItemAide.realPrice.toFixed(2)+"</P>";
			    		    }
			    		    divHtml+="</div>";
			    		    divHtml+="</div>";
			    		    divHtml+="</div>";
			    		    divHtml+="<input type=\"hidden\" value=\""+obj.orgProductItem.goodsId+"\" />";		    		    
			    		    divHtml+="</div>";
				    	});
						$("#loveItems").find(".row").append(divHtml);
						$("#loveItems").find(".col-md-2").on("click",function(){
							window.location.href="../item/"+ $(this).find("input:hidden").val(); 
						});
						$("#loveItems").find(".col-md-2").find("img").hover(function(){
							$(this).css("border-color","#00f");
						},function(){
							$(this).css("border-color","#ccc");
						});
					}
		    }
	    },
	    error: function(data) {
	   		$("#loveItems").empty();
	    }
	});
	
	
});
</script>