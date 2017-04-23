$(function(){
	$(".jian").on("click",function(){
		var num=0;
		var curNum=$(this).siblings(".num").text();
		if(curNum != null && curNum != undefined && curNum !=''){
			num=parseInt(curNum);
		}
		if(num == 1){
			$(this).hide();
			$(this).siblings(".num").hide();
		}
		num--;
		$(this).siblings(".num").text(num);
		if(num == 0){
			delMealCart($(this).parent().attr("data-goodsid"),$(this).parent().attr("data-goodssn"));
		}else{
			editCart($(this).parent().attr("data-goodsid"),num);
		}
	});
	
	$(".jia").on("click",function(){
		var num=0;
		var curNum=$(this).siblings(".num").text();
		if(curNum != null && curNum != undefined && curNum != ''){
			num=parseInt(curNum);
		}
		if(num==0){
			$(this).siblings(".jian").show();
			$(this).siblings(".num").show();
		}
		var userBuyMax = $(this).parents(".foods-item").attr("data-buy-max");
		var inventoryNum = $(this).parents(".foods-item").attr("data-inventory-num");
		if(num > userBuyMax){
			alert("限购"+userBuyMax+"件");//提示效果再做修改
		}else if(num>=inventoryNum){
			alert("库存不足,剩余"+inventoryNum+"件");	
		}else{
			num++;			
			$(this).siblings(".num").text(num);
			if(num==1){
				addCart($(this).parent().attr("data-goodsid"),$(this).parent().attr("data-goodssn")); 
			}else{
				editCart($(this).parent().attr("data-goodsid"),num);			
			}
		}
	});
	
	
});

//加入购物车
function addCart(goodsId,goodsSn){
	$.ajax({  
        type: "post",  
        dataType: "json",
        url: "../cart/add",
        data: {'goodsId':goodsId,'goodsSn':goodsSn},
        success: function(data) {alert(data);
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
//        	if(data==200){        	}
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
        },  
        error: function(data) {  
        }  
    })  ;
}

