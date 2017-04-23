<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div id="recentItems" class="box-left2">
	<h5>浏览过的商品</h5>
</div>
<script type="text/javascript">
$(function(){
	$.ajax({
		type: "post",  
	    dataType:"json", 
	    url: "../advertisement/list",  
	    data:  {typeId:0,showNumber:6},
	    success: function(data,status,xhr) {
		    if(xhr.status==200){
			    	var divHtml="";
			    	if(data.itemList==undefined){
						$("#recentItems").hide();
					}else{
				    	$.each(data.itemList,function(index,obj){
					    	if(obj==null){
					    		return;
					    	}
					    	divHtml+="<div style=\"cursor:pointer\" class=\"left2-main special4\">";
					    	divHtml+="<div class=\"left2-img\">";
					    	divHtml+="<img src=\""+obj.orgProductItem.goodsImg50+"\"/>";
					    	divHtml+="</div>";
					    	divHtml+="<div class=\"left2-text\">";
					    	divHtml+="<p class=\"overcontrol\">"+obj.orgProductItem.goodsName+"</p>";
					    	if(obj.orgProductItemAide.realPrice == null){
			    			   divHtml+="<P class=\"yellow\">暂无报价</P>";
			    		    }else{
			    			   divHtml+="<P class=\"yellow\">￥"+obj.orgProductItemAide.realPrice.toFixed(2)+"</P>";
			    		    }
					    	divHtml+="</div>";
					    	divHtml+="<input type=\"hidden\" value=\""+obj.orgProductItem.goodsId+"\" />";	
					    	divHtml+="</div>";
				    	});
						$("#recentItems").append(divHtml);
						$("#recentItems").find(".left2-main").on("click",function(){
							window.location.href="../item/"+ $(this).find("input:hidden").val(); 
						});
					}

		    }
	    },
	    error: function(data) {
	 	   $("#recentItems").hide();
	    }
	});
	
	
});
</script>