$(function(){
	
	//企业qq
	BizQQWPA.addCustom({
		aty : '0',
		nameAccount: '4000306603',
		selector : 'consultBtn'
	});
	
	//初始化选择店铺
	var shopId = $("#shopId").val();
	if(shopId == ""){
		initNoShop();
	}else{
		//加载楼层
		$(window).scroll(function() { 
	        var scrollTop = $(this).scrollTop();
			var windowHeight = $(this).height();
			//var scrollHeight = $(document).height();
			//if (scrollTop + windowHeight == scrollHeight) {
			if (scrollTop + windowHeight > $(".well").offset().top) {
				loadFloor();
			}
		});
	}
});
function initNoShop(){
	//获取所有门店信息
	$.ajax({  
	    type: "post",  
	    dataType:"json",
	    url: "./shop/list",  
	    success: function(data) {  
	       if(data.code == 200){
	    	   var htmlStr="";
	    	   $.each(data.listShop,function(index,item){
	    		   htmlStr += "<a href=\"javascript:setShop("+item.shopId+");\">";
	    		   htmlStr += item.shopName+"</a>";
    		   });
	    	   $("#shopcontent").html(htmlStr);
	    	   $(".mask-modal").show();
	    	   $(".mask-index").show();
	       }
	    },  
	    error: function(data) {  
	    }  
	})  ;
}

//加载中
var isAddLoading = false;
function loadFloor() {
	if(!isAddLoading){
		isAddLoading = true;
		var floorid = $("div[data-loading='1']").attr("id");
		if(floorid != undefined){
			$.ajax({
				type : "post",
				dataType : "json",
				url : "./loadFloor?floorid=" + floorid,
				success : function(data) {
					if (data.code == 200) {
						var strHtml = "";
						strHtml += "";
						strHtml += "<div class=\"container\">";
						strHtml += "<div class=\"title clearfix\">";
						if (data.pageFloor.floorname != null) {
							if (data.pageFloor.floorNameUrl != null && data.pageFloor.floorNameUrl != '') {
								strHtml += "<a target=\"_blank\" href=\"" + data.pageFloor.floorNameUrl + "\">";
							}else{
								strHtml += "<a href=\"javascript:void(0);\">";
							}
							strHtml += "<span>" + data.pageFloor.floorname + "</span></a>";
						}
						strHtml += "<ul>";
						//楼层推荐商品
						$.each(data.listRecommand, function(idx, obj) {
							strHtml += "<li><a target=\"_blank\" href=\"./item/";
							strHtml += obj.productid + "\"";
							if (idx == 0) {
								strHtml += "class=\"active\"";
							}
							strHtml += ">" + obj.nickname;
							strHtml += "</a></li>";
						});
		
						strHtml += "</ul></div>";
						strHtml += "<div class=\"content\">";
						strHtml += "<div class=\"content-left\">";
						
						if (data.pageFloor.pageImgUrl != null && data.pageFloor.pageImgUrl != '') {
							strHtml += "<a target=\"_blank\" href=\""+ data.pageFloor.pageImgUrl + "\">";
						}else{
							strHtml += "<a href=\"javascript:void(0);\">";
						}
						
						if (data.pageFloor.page1 != null && data.pageFloor.page1 != '') {
							strHtml += "<img src=\"" + data.pageFloor.page1 + "\"/>";
						}else{
							strHtml += "<img src=\"\"/>";
						}
						strHtml += "</a>";
						strHtml += "</div>";
						strHtml += "<div class=\"content-right\">";
						strHtml += "<div class=\"row\">";
		
						//楼层普通商品
						$.each(data.listItemCommon, function(idx, obj) {
							if( obj != null){
								strHtml += "<div class=\"col-sm-3\">";
								strHtml += "<div class=\"thumbnail\">";
								strHtml += "<a target=\"_blank\" href=\"./item/";
								strHtml += obj.orgProductItemAide.goodsId + "\" target=\"_blank\">";
								strHtml += "<img src=\"";
								strHtml += obj.orgProductItem.goodsImg180 + "\"";
								strHtml += " alt=\"" + obj.orgProductItem.goodsName + "\"/>";
								strHtml += "</a>";
								strHtml += "<div class=\"caption\">";
								strHtml += "<p class=\"c-t-title\">" + obj.orgProductItem.goodsName;
								strHtml += "</p>";
								if(obj.orgProductItemAide.realPrice == null){
									strHtml += "<p><span class='yellow'>暂无报价</span></p>";
				    		    }else{
				    		    	strHtml += "<p><span class='yellow'>￥"+obj.orgProductItemAide.realPrice.toFixed(2)+"</span></p>";
				    		    }
								strHtml += "</div></div></div>";
							}
						});
						strHtml += "</div>";
						strHtml += "</div></div>";
						
						strHtml += "</div>";
						$("#"+floorid).html(strHtml);
						//下一项
			    		var divNext = $("#"+floorid).next(".future");
			    		if(divNext.length > 0){
		    			   divNext.attr("data-loading","1");
		    		    }
			    		$("#"+floorid).attr("data-loading","0");
						isAddLoading = false;
					}
				},
				error : function(data) {
					isAddLoading = false;
				}
			});
		}
	}
}