//默认不加载数据
var isAddLoading = false;
$(function(){
	
	//修改配送地址
	$("#divSend").click(function(){
    	location.href="../address/list";
    });
	
	//修改自提店铺
	$("#divTake").click(function(){
		location.href="../shop/list";
	});
	
	//设置左侧最小高度
	var h=window.innerHeight-90;
	$('.buy_left').css({"minHeight":h});
	
	//初始化检查loaing页面
	 window.addEventListener("load",loaded,false);	

	 function loaded(){
		 	setTimeout(function() {
			myscroll = new iScroll("wrapper", {
				hScrollbar : false,
				vScrollbar : false,
				y : 0,
				hScroll : false,
				checkDOMChanges : true,
				onScrollEnd:function(){
					if(this.maxScrollY+$(window).height()>=this.y){
						addMoreList();
					}
				}			
			});
		}, 100);

		setTimeout(function() {
			myscroll1 = new iScroll("wrapper1", {
				hScrollbar : false,
				vScrollbar : false,
				y : 0,
				hScroll : false,
				checkDOMChanges : true
			});
		}, 100);
	  }
	
	//展开二级分类
	$('.a-classfiy-buy').find('a').on('click',function(){
		//保存一级分类
		$('#curParentCatId').val($(this).attr('data-id'));
		var link=$(this);
		$.ajax({
			type:'post',
			async: false,
			url:'getClassByParentId',
			data:{parentId:link.attr('data-id')},
			success:function(data,status,xhr){
				if(xhr.status=200){
					var liHtml="";
					liHtml+='<li data-id='+link.attr("data-id")+'>全部</li>';					
					$.each(data.listClassLevelTwo,function(index,obj){
						liHtml+='<li data-id='+obj.classId+'>'+obj.className+'</li>';
					});
					link.siblings('ul').empty().append(liHtml);
					//根据保存的二级分类回显
					var curCatId=$('#curCatId').val();
					if(curCatId!=null && curCatId!=''){
						$('li[data-id='+curCatId+']').addClass('on');						
					}
					//点击二级分类
					onClickLevelTwo();
				}
			},
			error:function(d,s,r){
			},
		});
	});
	
	addMoreList();
	
	//根据保存的一级分类回显
	var curParentCatId=$('#curParentCatId').val();
	var curCatId=$('#curCatId').val();
	if(curParentCatId!=null && curParentCatId!=''){
		$('#allItem').removeAttr("style");
		$('a[data-id='+curParentCatId+']').trigger('click',function(){
			$('li[data-id='+curCatId+']').trigger('click');			
		});
	}
	
});

//点击二级分类,加载二级分类第一页
function onClickLevelTwo(){
	$('.a-classfiy-buy').find('ul').find('li').on('click',function(){
		$("#loadMore").attr("data-page-next",'0');
		//保存二级分类
		$('#curCatId').val($(this).attr('data-id'));
		$('#allItem').removeAttr("style");
		$(this).siblings().removeClass('on');
		$(this).addClass('on');
		$.ajax({
			type:'post',
			async: false,
			url:'ajaxList',
			data:{catId:$(this).attr('data-id')},
			success:function(data,status,xhr){
				if(xhr.status=200){
					appendHtml(data,1);
					$("#loadMore").attr("data-page-next",'1');
					$("#loadMore").html("<span class=\"bounce-text\">正在加载</span><span class=\"bounce bounce1\"></span><span class=\"bounce bounce2\"></span><span class=\"bounce bounce3\"></span>");
				}
			},
			error:function(d,s,r){
			},
		});
	});
}



//加载更多
function addMoreList(){
	//不是最后一页
	if($("#loadMore").attr("data-page-next") != -1){
		$("#loadMore").css({opacity:1});
		var catId=$('#curCatId').val();
		//加载中不能再次加载
		if(!isAddLoading){
			isAddLoading = true;
			$.ajax({
			    type: "post",  
			    url: "ajaxList",  
			    data:  {'pageNumber':$("#loadMore").attr("data-page-next"),'catId':catId},
			    success: function(data,status,xhr) {
			       if(xhr.status==200){
			    	   if(!data.page.lastPage){
			    		   $("#loadMore").attr("data-page-next",data.page.number+1);
			    	   }else{
			    		   $("#loadMore").attr("data-page-next","-1");
			    	   }
			    	   appendHtml(data,0);
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
	}else{
		 $("#loadMore").html("<span class=\"bounce-text\">已经看到最后啦~</span>");
		 $("#loadMore").css({opacity:1});
	}
};



function appendHtml(data,flg){
	var divHtml='';
	$.each(data.page.content,function(index,obj){
		var shopAmount=0;
		if(obj.orgProductInventory!=null){
			shopAmount=obj.orgProductInventory.shopAmount;
		}
		divHtml+='<div class=\"buylist\" data-buy-max=\"'+obj.orgProductItemAide.userBuyMax+'\" data-inventory-num=\"'+shopAmount+'\">';			
		divHtml+='<div class=\"buylist_img\">';
		divHtml+='<a href=\"../item/'+obj.orgProductItem.goodsId+'\"><img src=\"'+obj.orgProductItem.goodsImg180+'\" alt=\"'+obj.orgProductItem.goodsName+'\"></a>';
		if(obj.orgProductItemAide.realPrice != null && obj.orgProductItemAide.sourcePrice!=null && Number(obj.orgProductItemAide.sourcePrice)>Number(obj.orgProductItemAide.realPrice)){
			divHtml+='<span class=\"jiaobiao1\"></span>';
		}else{
			divHtml+='<span></span>';			
		}
		divHtml+='</div>';
		divHtml+='<div class=\"buylist-text\">';
		divHtml+='<div class=\"buylist-title\">'+obj.orgProductItem.goodsName+'</div>';
		if(obj.orgProductItemAide.realPrice != null && obj.orgProductItemAide.sourcePrice!=null && Number(obj.orgProductItemAide.sourcePrice)>Number(obj.orgProductItemAide.realPrice)){	
			var differPrice=Number(obj.orgProductItemAide.sourcePrice)-Number(obj.orgProductItemAide.realPrice);
			divHtml+='<div class=\"buylist-youhui\"><span>已优惠'+differPrice.toFixed(2)+'元</span></div>';
		}
		divHtml+='<div class=\"buylist-price\">';
		if(obj.orgProductItemAide.realPrice == null){
			divHtml+='<span class=\"yellow-price\"><i class=\"weiruan\">￥</i>暂无报价</span>';							
		}else{
			divHtml+='<span class=\"yellow-price\"><i class=\"weiruan\">￥</i>'+obj.orgProductItemAide.realPrice.toFixed(2)+'</span>';
		}
		divHtml+='</div>';
		divHtml+='<div class=\"add-quantity\" data-goodsid=\"'+obj.orgProductItem.goodsId+'\" data-goodssn=\"'+obj.orgProductItem.goodsSn+'\">';
		
		if(!obj.orgProductItemAide.canSale){
			divHtml+='<span class=\"no-guide\">无货</span>';
		}else if(obj.orgProductItem.amount>0){
			divHtml+='<span class=\"plus\"></span>';
			divHtml+='<span class=\"num\">'+obj.orgProductItem.amount+'</span>';
			divHtml+='<span class=\"reduce\"></span>';
		}else{
			divHtml+='<span class=\"plus\"></span>';	
			divHtml+='<span class=\"num\" style=\"display:none\"></span>';
			divHtml+='<span class=\"reduce\" style=\"display:none\"></span>';
		}
		divHtml+='</div>';
		divHtml+='</div>';
		divHtml+='</div>';
	});
	if(flg){
		$('.buyalllist').empty();		
	}
	$('.buyalllist').append(divHtml);
	$('.reduce').off("click");
	$('.plus').off("click");
	cartOper();
 }

function cartOper(){
	
	$('.plus').on("click",function(){
		var num=0;
		var curNum=$(this).siblings(".num").text();
		if(curNum!=null && curNum!=undefined && curNum!=''){
			num=parseInt(curNum);		
		}
		var userBuyMax=$(this).parents('.buylist').attr('data-buy-max');
		var inventoryNum=$(this).parents('.buylist').attr('data-inventory-num');
		if(userBuyMax>0 && inventoryNum>0 && num==0){
			$(this).siblings('.reduce').show();
			$(this).siblings(".num").show();
		}
		if(num>=inventoryNum){
			autoAlert("库存不足,剩余"+inventoryNum+"件");		
		}else if(num>=userBuyMax){
			autoAlert("限购"+userBuyMax+"件");
		}else{
			num++;			
			$(this).siblings(".num").text(num);
			if(num==1){
				addCart($(this).parent().attr("data-goodsid"),$(this).parent().attr("data-goodssn"),$(this).parents('.buylist').find('img')); 
			}else{
				editCart($(this).parent().attr("data-goodsid"),num,$(this).parents('.buylist').find('img'),true);			
			}
		}
	});
	
	$('.reduce').on("click",function(){
		var num=0;
		var curNum=$(this).siblings(".num").text();
		if(curNum!=null && curNum!=undefined && curNum!=''){
			num=parseInt(curNum);		
		}
		if(num==1){
			$(this).hide();
			$(this).siblings(".num").hide();
		}
		num--;
		$(this).siblings(".num").text(num);
		if(num==0){
			delCart($(this).parent().attr("data-goodsid"),$(this).parent().attr("data-goodssn")); 
		}else{
			editCart($(this).parent().attr("data-goodsid"),num,$(this).parents('.buylist').find('img'),false);
		}
	});
}

function editCart(goodsId,amount,obj,flg){
	$.ajax({  
        type: "post", 
        async: false,
        url: "../cart/edit",
        data: {"goodsId":goodsId,"amount":amount},
        success: function(data) {
        	if(data.code==200){
        		if(flg){
        			animateAddCart(obj,$('.foot3'));
        		}
        		$(".foot3 .redcount").html(data.cartCount);        			
        	}
        },  
        error: function(data) {  
        }  
    });
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
        		animateAddCart(obj,$('.foot3'));
        		$(".foot3 .redcount").html(data.cartCount);
        	}
        },  
        error: function(data) {  
        }  
    });  
}
//删除购物车商品
function delCart(goodsId,goodsSn){
	$.ajax({  
		type: "post",  
		url: "../cart/del",
		data: {'goodsIds':goodsId,'goodsSn':goodsSn},
		success: function(data) {
			if(data.code==200){
				$(".foot3 .redcount").html(data.cartCount);
			}
		},  
		error: function(data) {  
		}  
	}); 
}

