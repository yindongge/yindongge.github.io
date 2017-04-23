var ti=null;
var ti2=null;
$(function(){
	
	 new Swiper ('.swiper-container', {
		    direction: 'horizontal',
		    loop: true,
		    autoplay:2000,
		    // 如果需要分页器
		    pagination: '.swiper-pagination',
		    // 如果需要前进后退按钮
		    nextButton: '.swiper-button-next',
		    prevButton: '.swiper-button-prev',

		  }); 
	 
	$(".grayspan a").not(".grayspan.active a").on("click",function(){
		var arr = new Array();
		$(this).parent().siblings().removeClass("active");
		$(this).parent().addClass("active");
		$(".grayspan.active input").each(function(){
			arr.push($(this).val());
		});		
		var pageInfo=$("#itemJson").val();
		var jsonObj=eval("("+pageInfo+")");	
		$.each(jsonObj,function(i,n){
			var arrTmp=new Array();
			$.each(n.skuSpecList,function(j,m){
				var unionId=m.specId+"_"+m.specTypeId;
				arrTmp.push(unionId);
			});
			if(arrTmp.sort().toString()==arr.sort().toString()){
				window.location.href=n.itemId; 
			}
		});
	});
	//刷新计数器
	var limitTimeEndiInterval = $("#limitTimeEndiInterval").val();	
	if(limitTimeEndiInterval != undefined && limitTimeEndiInterval>0){
		ti=setInterval(transferTime, 1000);
	}else{
		clearInterval(ti);		
	}
	//活动开始倒计时
	var countDown = $("#countDown").val();	
	if(countDown != undefined && countDown !="" && Number(countDown)>0){
		ti2=setInterval(transferTime2, 1000);
	}else{
		clearInterval(ti2);		
	}
 
});


function transferTime() 
{ 	
		var endTime=$("#limitTimeEndiInterval").val();	
		var leftTime = endTime - 1000; 
		if(leftTime < 1000){
			clearInterval(ti);	
			location.reload();
		}
		var leftsecond = parseInt(leftTime/1000); 
		var day=Math.floor(leftsecond/(60*60*24)); 
		var hour=Math.floor((leftsecond-day*24*60*60)/3600); 
		var minute=Math.floor((leftsecond-day*24*60*60-hour*3600)/60); 
		var second=Math.floor(leftsecond-day*24*60*60-hour*3600-minute*60); 
		$("#timeLimit").text(hour+"时"+minute+"分"+second+"秒");
		$("#limitTimeEndiInterval").val(leftTime);	
} 

function transferTime2() {
	var endTime=$("#countDown").val();	
	var leftTime = endTime - 1000; 
	if(leftTime < 1000){
		clearInterval(ti2);		
		location.reload();
	}
	var leftsecond = parseInt(leftTime/1000); 
	var day=Math.floor(leftsecond/(60*60*24)); 
	var hour=Math.floor((leftsecond-day*24*60*60)/3600); 
	var minute=Math.floor((leftsecond-day*24*60*60-hour*3600)/60); 
	var second=Math.floor(leftsecond-day*24*60*60-hour*3600-minute*60); 
	var timeText=hour+"时"+minute+"分"+second+"秒";
	if(day>0){
		timeText=day+"天"+timeText;
	}
	$("#countDownEnd").text(timeText);
	$("#countDown").val(leftTime);	
} 


function addCart(goodsId,goodsSn){
	$.ajax({
		type:"post",
		dataType:"json",
		url:"../cart/add",
		data:{"goodsId":goodsId,"goodsSn":goodsSn},
		success: function(data){
			if(data.code==200){
				$("#cartCount").html(data.cartCount);
				autoAlert("添加成功");
			}
		},
		error:function(data){
		}	
	});
}