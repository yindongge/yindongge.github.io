$(function(){
	//地图初始化
	showMap("myPoint");
	
	$(".a1").on("click",function(e){
		var num=0;
		var curNum=$(this).next().val();
		if(curNum != null && curNum != undefined && curNum !=''){
			num=parseInt(curNum);
		}
		if(num == 1){
			$(this).parent().parent().hide();
			$(this).parent().parent().prev().show();
		}
		num--;
		$(this).next().val(num);
		if(num == 0){
			delMealCart($(this).parent().attr("data-goodsid"),$(this).parent().attr("data-goodssn"));
		}else{
			editCart($(this).parent().attr("data-goodsid"),num);
		}
	});
	
	$(".a2").on("click",function(e){
		var num=0;
		var curNum=$(this).prev().val();
		if(curNum != null && curNum != undefined && curNum != ''){
			num=parseInt(curNum);
		}
		var userBuyMax = $(this).parents(".delicious_list").attr("data-buy-max");
		var inventoryNum = $(this).parents(".delicious_list").attr("data-inventory-num");
		if(num > userBuyMax){
			alert("限购"+userBuyMax+"件");
		}else if(num>=inventoryNum){
			alert("库存不足,剩余"+inventoryNum+"件");	
		}else{
			num++;			
			$(this).prev().val(num);
			if(num==1){
				animateAddCart($('.side_item.side_2'),$(this).parents('.delicious_list').find('.deli_img_item img'));
				e.preventDefault();
				addCart($(this).parent().attr("data-goodsid"),$(this).parent().attr("data-goodssn")); 
			}else{
				animateAddCart($('.side_item.side_2'),$(this).parents('.delicious_list').find('.deli_img_item img'));
				e.preventDefault();
				editCart($(this).parent().attr("data-goodsid"),num);
			}
		}
	});
	
	$(".deli_item_join").on('click','.join_car',function(e){
		if(!$(this).is(".gray")){
		addCart($(this).parent().attr("data-goodsid"),$(this).parent().attr("data-goodssn"));
		getCartCount();
		animateAddCart($('.side_item.side_2'),$(this).parents('.delicious_list').find('.deli_img_item img'));
		e.preventDefault();
		$(this).parent().next().find(".num").val("1");
		$(this).parent().hide();
		$(this).parent().next().show();
		}
	})
	
	var shopId = $("#shopId").val();
	getSendRange(shopId);
	
	$("#self").on('click',function(){
		location.href='../security/desc';
	})
	
	$("#cart").on('click',function(){
		location.href='../cart/list';
	})
	
	$("#coupon").on('click',function(){
		location.href='../coupon/list';
	})
	
	$("#myorder").on('click',function(){
		location.href='../order/list';
	})
	
	$("#feedback").on('click',function(){
		location.href='../feedback/init';
	})
	
});


function getSendRange(shopId){
	$.ajax({
		type:'post',
		dataType:'json',
		url:'../meal/sendRange',
		data:{'shopId':shopId},
		success:function(data){
			if(data.code == 200){
			var htmlText='';
			$.each(data.sendRangeList,function(idx,obj){
				htmlText+="<span>"+obj.sendRangeName+"</span>"
			});
			$(".d_area_list").append(htmlText);
			}
		},
		error:function(data){
		}
	});
}

//加入购物车
function addCart(goodsId,goodsSn){
	$.ajax({  
        type: "post",  
        dataType: "json",
        url: "../cart/addCartAjax",
        data: {'goodsId':goodsId,'goodsSn':goodsSn},
        success: function(data) {
        	getCartCount();
        },  
        error: function(data) {  
        }  
    });  
}

function editCart(goodsId,amount){
	$.ajax({  
        type: "post", 
        async: false,
        url: "../cart/edit",
        data: {"goodsId":goodsId,"amount":amount},
        success: function(data) {
        	getCartCount();
        },  
        error: function(data) {  
        }  
    });
}

function delMealCart(goodsId){
	$.ajax({  
        type: "post",  
        dataType: "json",
        url: "../cart/del",
        data: {'goodsIds':goodsId},
        success: function(data) {
        	getCartCount();
        },  
        error: function(data) {  
        }  
    })  ;
}

function getCartCount(){
	$.ajax({  
        type: "post",  
        dataType: "json",
        url: "../cart/ajaxList",
        success: function(data) {
        	if(data.code == 200){
	       		if(data.listCart.length == 0){
	       			$(".red_count").html("0");
	       		}else{
	       			var count = 0;
	        		$.each(data.listCart,function(idx, obj){
	        			count += obj.orgProductItemAll.orgProductItemAide.userBuy;
		            }); 
					$(".red_count").html(count);
	       		}
        	}
        },  
        error: function(data) {  
        }  
    })  ;
}

function animateAddCart(cartEnd,imgtodrag){
	var imgclone = imgtodrag.clone().offset({
		top: imgtodrag.offset().top + 50,
		left: imgtodrag.offset().left + 50
	}).css({
		'opacity': '0.5',
		'position': 'absolute',
		'height': '100px',
		'width': '100px',
		'z-index': '100'
	}).appendTo($('body')).animate({
		'top': cartEnd.offset().top + 0,
		'left': cartEnd.offset().left + 0,
		'width': 40,
		'height': 40
	}, 1000, 'easeInOutExpo');
	setTimeout(function () {
		cartEnd.effect('shake', { times: 2}, 300);//购物车抖动次数
	}, 1500);//购物车抖动
	imgclone.animate({
		'width': 0,
		'height': 0
	}, function () {
		$(this).detach();
	});
}

//百度地图
function showMap(mapArea) {
	// 百度地图API功能
	var map = new BMap.Map("allmap");
	//设置区域
	if(mapArea == 'myPoint'){
		var myPoint= new BMap.Point($("#longitude").val(), $("#latitude").val());
		var marker = new BMap.Marker(myPoint);  // 创建标注
		map.addOverlay(marker); // 将标注添加到地图中
		var shopName = $("#shopName").val();
		var address = $("#address").val();
		var opts = {
				  width : 50,     // 信息窗口宽度
				  height: 30,     // 信息窗口高度
				  title : shopName, // 信息窗口标题
				}
		var infoWindow = new BMap.InfoWindow(address, opts);  // 创建信息窗口对象 
		marker.openInfoWindow(infoWindow,myPoint); //开启信息窗口
		marker.addEventListener("click", function(){          
			map.openInfoWindow(infoWindow,myPoint); //开启信息窗口
		});
		marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
		var circle = new BMap.Circle(myPoint,2000,{fillColor:"blue", strokeWeight: 1 ,fillOpacity: 0.3, strokeOpacity: 0.3});
	    map.addOverlay(circle);	
	    map.centerAndZoom(myPoint,12);
	}else{
		map.centerAndZoom(mapArea,12);
	}
	map.enableScrollWheelZoom();   //启用滚轮放大缩小，默认禁用
	map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用
	map.addControl(new BMap.MapTypeControl({mapTypes: [BMAP_NORMAL_MAP,BMAP_HYBRID_MAP]}));          //2D图，卫星图
}
