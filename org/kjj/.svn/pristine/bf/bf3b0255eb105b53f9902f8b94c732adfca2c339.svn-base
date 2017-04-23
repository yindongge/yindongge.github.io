$(function(){
	
	//修改配送地址
	$("#divSend").click(function(){
    	location.href="address/list";
    });
	
	//修改自提店铺
	$("#divTake").click(function(){
		location.href="shop/list";
	});

	new Swiper ('.swiper-container', {
	    direction: 'horizontal',
	    loop: true,
	    autoplay:2000,
	    
	    autoplayDisableOnInteraction : false,
	    observeParents:true,
	    observer:true,
	    // 如果需要分页器
	    pagination: '.swiper-pagination',
	    
	    // 如果需要前进后退按钮
	    nextButton: '.swiper-button-next',
	    prevButton: '.swiper-button-prev',

	  });
	//初始化检查loading页面
	loading();
	$(window).scroll(function(){
		loading();
	});
	function loading(){
		var scrollTop = $(this).scrollTop();   
		var scrollHeight = $(document).height();
		var windowHeight = $(this).height(); 
		if (scrollTop + windowHeight == scrollHeight) {
			addMoreList();
		}
	}
	
	//加载中
	var isAddLoading = false;
	function addMoreList(){
		if($(".procuct_control").length >0){
		//不是最后一页
		if($("#loadMore").attr("data-page-next") != -1){
			$("#loadMore").css({opacity:1});
			//搜索框获取焦点时不加载
			$(":text").bind('focus',function(){
				isAddLoading = true;
			}).bind('blur',function(){
				isAddLoading = false;
			});
		//加载中不能再次加载
		if(!isAddLoading){
			isAddLoading = true;
			var divLoading = $("[data-loading='1']");
			$.ajax({
				type:'post',
				url:'moduleGoods',
				dataType:'json',
				data:{'pageNumber':$("#loadMore").attr("data-page-next"),
					'moduleId':divLoading.attr("data-module-id")},
				success:function(data){
					if(data.code == 200){
						var divLoading = $("[data-loading='1']");
						if(data.page.firstPage && data.page.content.length>0){
							//有数据
							divLoading.show();
						}
						if(!data.page.lastPage){//不是最后一页
							$("#loadMore").attr("data-page-next",data.page.number+1);
						}else{//是最后一页
							//下一项
							var divNext = divLoading.next(".procuct_control");
							if(divNext.length>0){
								divNext.attr("data-loading","1");
								$("#loadMore").attr("data-page-next",0);
								//本项没有数据加载下一项
								if(data.page.firstPage && data.page.content.length == 0){
									divLoading.attr("data-loading","0");
									$("#loadMore").css({capacity:0});
									isAddLoading = false;
									addMoreList();
								}
							}else{//没有下一项了
								$("#loadMore").attr("data-page-next",-1);
							}
							 divLoading.attr("data-loading","0");
						}
						var divHtml = "";
						$.each(data.page.content,function(idx,obj){
							 divHtml += "<div class='product_item'>";
				    		   divHtml += "<a href='item/"+obj.orgProductItemAide.goodsId+"'>";
				    		   divHtml += "<div class='pic_box'><img src='"+obj.orgProductItem.goodsImg180+"'></div>";
				    		   divHtml += "<div class='title_box'>";
				    		   divHtml += "<span>"+obj.orgProductItem.goodsName+"</span>";
				    		   divHtml += "</div>";
				    		   divHtml += "<div class='price_box'>";
				    		   if(obj.orgProductItemAide.realPrice == null){
				    			   divHtml += "<span class='yellow price'>暂无报价</span>";
				    		   }else{
				    			   divHtml += "<span class='yellow price'>￥"+obj.orgProductItemAide.realPrice.toFixed(2)+"</span>";
				    		   }
				    		   if(obj.orgProductItemAide.canSale){
				    			   divHtml += "<a class=\"addcar-wrapper\" href=\"javascript:void(0);\" onclick=\"javascript:addCart('"+obj.orgProductItemAide.goodsId+"','"+obj.orgProductItemAide.goodsSn+"',$(this).parents('.product_item').find('img'));\"><span class=\"addcar\"></span></a>";
				    		   }else{
				    			   divHtml += "<a class=\"addcar-wrapper\" href=\"javascript:void(0);\"><span class=\"addnocar\">无货</span></a>";
				    		   }
				    		   divHtml += "</div>";
				    		   divHtml += "</a>";
				    		   divHtml += "</div>";
						});
						divLoading.find(".product_wrap").append(divHtml);
						 if($("#loadMore").attr("data-page-next") == -1){
				    		   $("#loadMore").html("<span class=\"bounce-text\">已经看到最后啦~</span>");
				    		   $("#loadMore").css({opacity:1});
				    	   }else{
				    		   $("#loadMore").css({opacity:0});
				    	   }
				    	   isAddLoading = false;
					}
				},
				 error:function(data) {
				    	$("#loadMore").css({opacity:0});
				    	isAddLoading = false;
				    }  
			});
			}
		}
	}else{
		$("#loadMore").html("<span class=\"bounce-text\">已经看到最后啦~</span>");
  		$("#loadMore").css({opacity:1});
	 }
  }
});
function addCart(goodsId,goodsSn,obj){
	$.ajax({  
        type: "post",  
        dataType: "json",
        url: "cart/add",
        data: {'goodsId':goodsId,'goodsSn':goodsSn},
        success: function(data) {
        	if(data.code==200){
        		//autoAlert("添加成功");
        		animateAddCart(obj,$('.foot3'));
        		$(".foot3 .redcount").html(data.cartCount);
        	}
        },  
        error: function(data) {  
        }  
    })  ;  
}