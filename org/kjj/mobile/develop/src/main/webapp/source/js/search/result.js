$(function(){
	
	//查询条件下拉菜单
	$('.nav.thirdnav a').click(function(e){
		var T=$(this);
		var $next=T.next('.slidedown-box');
		if(	$next.is(":visible"))
		{
			$next.hide();
		}
		else{
				$next.slideDown('slow').siblings('.slidedown-box').hide();
				$('.box').addClass('noscroll');
			}
		if(	T.hasClass('active'))
		{
			T.removeClass('active');
			$('.mask').hide();
			$('.box').removeClass('noscroll');
		}
		else{
			T.addClass('active').siblings('.nav.thirdnav a').removeClass('active');
			$('.mask').fadeIn("slow").addClass('mask-top');
		}
		e.preventDefault();
	});

	$('.mask').on('click',function(){
		$('.slidedown-box').hide();
		$(this).hide();
		$('.box').removeClass('noscroll');
		$('.nav.thirdnav a').removeClass('active');
	});
	
	
	$(window).scroll(function () {
		var scrollTop = $(this).scrollTop();
		var scrollHeight = $(document).height();
		var windowHeight = $(this).height();
		if (scrollTop + windowHeight == scrollHeight) {
			addMoreList();
		}else{
			$("#loadMore").css({opacity:0});
		}
	});
	//加载中
	var isAddLoading = false;
	function addMoreList(){
		//不是最后一页
		if($("#loadMore").attr("data-page-next") != -1){
			$("#loadMore").css({opacity:1});
			 $("#pageNumber").val($("#loadMore").attr("data-page-next")); 
			//搜索框获取焦点时不加载
				$('#keyword').focus(function(){
					isAddLoading = true;
			     }).blur(function(){
			    	 isAddLoading = false;
			     });
			//加载中不能再次加载
			if(!isAddLoading){
				isAddLoading = true;
				$.ajax({
				    type: "post",  
				    dataType:"json", 
				    url: "resultAjax",  
				    data:  $("#searchForm").serialize(),
				    success: function(data) {
				       if(data.code==200){
				    	   if(!data.page.lastPage){
				    		   $("#loadMore").attr("data-page-next",data.page.number+1);
				    	   }else{
				    		   $("#loadMore").attr("data-page-next","-1");
				    	   }
				    	   var divHtml = "";
				    	   $.each(data.page.content,function(idx, obj){
				    		   divHtml += "<div class='product_item'>";
				    		   divHtml += "<a href='../item/"+obj.orgProductItem.goodsId+"'>";
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
				    	   $("div.product_wrap").append(divHtml);
				    	   isAddLoading = false;
				    	   $("#loadMore").css({opacity:0});
				       }
				    },  
				    error: function(data) {
				    	$("#loadMore").css({opacity:0});
				    	isAddLoading = false;
				    }  
				});
			}
		}
	}
	

	
	//展开二级分类
	$('.main-option').on('click',function(){
		var link=$(this);
		changeStyle(link);
		if(link.attr('data-id')==0){
			//全部商品
			location.href="../search/result";
			return false;
		}
		$.ajax({
			type:'post',
			url:'getClassByParentId',
			async:false,
			data:{parentId:link.attr('data-id'),},
			success:function(data,status,xhr){
				if(xhr.status=200){
					$("#parentId").val(link.attr('data-id'));
					var liHtml="";
					liHtml+='<li data-id='+link.attr("data-id")+'>全部</li>';					
					$.each(data.listClassLevelTwo,function(index,obj){
						liHtml+='<li data-id='+obj.classId+'>'+obj.className+'</li>';
					});
					link.parents('.slidedown-box').find('.chooseul').empty().append(liHtml);
					onClickLevelTwo();
				};
			},
			error:function(data,status,xhr){
			},
		});
	});
	
	
	//初始化分类点击状态
	if($("#parentId").val()!=""){
		var parentId=$("#parentId").val();
		$('.main-option[data-id='+parentId+']').trigger("click");//模拟点击事件 
		var catId=$('#catId').val();
		$('.chooseul').find('li[data-id='+catId+']').addClass('on');
	}
	
	//排序
	$('#orderBox').find('li').on('click',function(){
		changeStyle($(this));
		$('#orderType').val($(this).attr('data-id'));
		submitForm();
	});
	
	//价格区间
	$('#priceBox').find('li').on('click',function(){
		changeStyle($(this));
		$('#realPriceId').val($(this).attr('data-id'));
		submitForm();
	});
	
	$.each($('#orderBox').find('li'),function(){
		if($(this).attr('data-id')==$('#orderType').val()){
			changeStyle($(this));
		}
	});
	
	$.each($('#priceBox').find('li'),function(){
		if($(this).attr('data-id')==$('#realPriceId').val()){
			changeStyle($(this));
		}
	});
	
	$('.searchicon').on('click',function(){
		$('#couponId').val('');
		$('#superClassId').val('');
		$('#catId').val('');
		$('#orderType').val('');
		$('#realPriceId').val('');
		submitForm();
	});
	
	
});

//点击二级分类
function onClickLevelTwo(){
	$('.slide-d-right').find('li').on('click',function(){
		changeStyle($(this));
		$('#couponId').val('');
		$('#superClassId').val('');
		$('#keyword').val('');
		$('#catId').val($(this).attr('data-id'));
		$('#orderType').val('');
		$('#realPriceId').val('');
		submitForm();
	});
}

//改变列表样式
function changeStyle(element){
	element.siblings().removeClass('on');
	element.addClass('on');	
}


//提交表单
function submitForm(){
	$("#pageNumber").val('0');
	$("#searchForm").submit();
}


//加入购物车
function addCart(goodsId,goodsSn,obj){
	$.ajax({  
        type: "post",  
        dataType: "json",
        url: "../cart/add",
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
