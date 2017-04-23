$.fn.raty.defaults.path=$("#imgBase").val();
var ti=null;
var ti2=null;
//var imgs="||";  //百度分享图片组
$(function(){	
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
	
	$(".slideBox").slide({
		mainCell : ".bd ul",
		effect : "top",
		trigger : "click",
		pnLoop : false
	});

	$(".slideTxtBox").slide({
		trigger : "click"
	});

	$(document).scroll(function() {
		var divh = $(".slideTxtBox").offset().top;
		var divl = $("#scrollEnd").offset().top - 100;
		var wsh = $(window).scrollTop();
		if (wsh >= divh && wsh <= divl) {
			$('#fixedtop').addClass('fix');
		} else {
			$('#fixedtop').removeClass('fix');
		}
	});
	
	
	//企业qq
//	BizQQWPA.addCustom({
//		aty : '0',
//		nameAccount: '4000306603',
//		selector : 'consultBtn'
//	});
	
	$(".ch").find("a").not(".active").on("click",function(){
		var arr = new Array();
		$(this).siblings().removeClass("active");
		$(this).addClass("active");
		$(".ch").find(".active").each(function(){
			arr.push($(this).next().val());
		});		
		var jsonObj=pageInfo;	
		var len=jsonObj.length;
		var k=0;
//		var jsonObj=eval("("+pageInfo+")");	
		$.each(jsonObj,function(i,n){
			var arrTmp=new Array();
			$.each(n.skuSpecList,function(j,m){   // 各种规格信息
				var unionId=m.specId+"_"+m.specTypeId;
				arrTmp.push(unionId);
			});
			if(arrTmp.sort().toString()==arr.sort().toString()){
				window.location.href=n.itemId; 
			}else{
				k=k+1;
			}
		});
		if(k==len){
			alert("暂无该规格的商品！");
		}
	});
	//活动倒计时
	var limitTimeEndiInterval = $("#limitTimeEndiInterval").val();	
	if(limitTimeEndiInterval != undefined && limitTimeEndiInterval !="" && Number(limitTimeEndiInterval)>0){
		ti=setInterval(transferTime, 1000);
		$("#limitTimeEnd").after('后结束，请尽快购买！');
	}else{
		clearInterval(ti);		
	}
	//活动开始倒计时
	var countDown = $("#countDown").val();	
	if(countDown != undefined && countDown !="" && Number(countDown)>0){
		ti2=setInterval(transferTime2, 1000);
		$("#countDownEnd").before('活动已结束，下次活动时间：');
	}else{
		clearInterval(ti2);		
	}
	
	//数量减少
	$("[name='amountMinus']").click(function(){
		var amount = $(this).parent().find(":text[name='amount']");
		if(parseInt(amount.val()) > 1){
			amount.val(parseInt(amount.val())-1);
			amount.attr('data-old',amount.val());
		}
	});
	
	//数量增加
	$("[name='amountPlus']").click(function(){
		var amount = $(this).parent().find(":text[name='amount']");
		amount.val(parseInt(amount.val())+1);
		amount.attr('data-old',amount.val());
	});
	
	//数量改变
	$(":text[name='amount']").on("focusout",function(){;
	 	if(!isPlusInteger($(this).val()) || parseInt($(this).val()) < 1){
			$(this).val($(this).attr('data-old'));
		}else{
			$(this).attr('data-old',$(this).val());
		} 
	});
	
	//商品评分
	$(".raty").raty({   
	  score: function() {
		    return $(this).attr('data-score');
		  },
	  readOnly: 'true'			  
	});
	
	//满意度
	$("#satisifyLevel").css({
		right:444-84*$("#satisifyLevel i").text(),
		});
	
	
	$("#itemDetail").on("click",function(){
		$("#itemDetailInfo").show();
		$("#itemCommentInfo").show();
		location.hash = 'anchorDetail';
	});
	$("#itemComment").on("click",function(){
		$("#itemDetailInfo").hide();
		$("#itemCommentInfo").show();
		location.hash = 'itemCommentInfo';
	});
	$("#itemConsult").on("click",function(){
		$("#itemDetailInfo").hide();
		$("#itemCommentInfo").hide();
		location.hash = 'anchorConsult';
	});
	
	//加入购物车按钮
	$("#addCartBtn").on("click",function(e){
		addCart($("#goodsId").val(),$("#goodsSn").val()+"",$(":text[name='amount']").val());
		animateAddCart($('.side_item.side_2'),$(this).parents('.b').find('.spec-preview img'));
		e.preventDefault();
	});
	
	
	//分页点击
	pageClick();
	
	//输入页面确定
	$("#changePageBtn").on("click",function(){
		if(isPlusInteger(parseInt($("#changePage").val()))){
			ajaxFun(parseInt($("#changePage").val()-1));
		}else{
			alert("请输入正整数");
			$("#changePage").val("");
		}
	
	});
	
	
	/* 百度分享
	$(".items img").each(function(){
		imgs+=$(this).attr("src")+"||";
	});
	window._bd_share_config = {
		"common": {
			"bdSnsKey": {},
			"bdText": $("meta[name=description]").attr('content'),
			"bdMini": "2",
			"bdPic": imgs,
			"bdStyle": "0",
			"bdSize": "16"
		},
		"share": {}
		};
	with(document) 0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion=' + ~ ( - new Date() / 36e5)];
	*/
});



function transferTime() {
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
		$("#limitTimeEnd").text(hour+"小时"+minute+"分"+second+"秒");
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
	var timeText=hour+"小时"+minute+"分"+second+"秒";
	if(day>0){
		timeText=day+"天"+timeText;
	}
	$("#countDownEnd").text(timeText);
	$("#countDown").val(leftTime);	
} 

//加入购物车
function addCart(goodsId,goodsSn,amount){
	$.ajax({  
        type: "post",  
        dataType: "json",
        url: "../cart/addCartAjax",
        data: {'goodsId':goodsId,'goodsSn':goodsSn,'amount':amount},
        success: function(data) {
        	getCartCount();
        },  
        error: function(data) {  
        }  
    });  
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
//添加购物车
//function addCart(goodsId,goodsSn,amount){
//	window.location.href="../cart/add?goodsId="+goodsId+"&goodsSn="+goodsSn+"&amount="+amount;  
//}


function pageClick(){
	//点击数字
	$(".pagination.page-control").find("a[name='pageNumber']:not([class='page-click'])").off("click");
	$(".pagination.page-control").find("a[name='pageNumber']:not([class='page-click'])").on("click",function(){
		ajaxFun($(this).text()-1);
	});
	//上一页点击
	$("[name=preBtn]").off("click");
	$("[name=preBtn]").on("click",function(){
		if($(this).attr('class')=="disabled"){
			alert("已经是第一页");
		}else{
			ajaxFun(parseInt($("a[name='pageNumber'][class='page-click']").text())-2);			
		}
	});
	//下一页点击
	$("[name=nextBtn]").off("click");
	$("[name=nextBtn]").on("click",function(){
		if($(this).attr('class')=="disabled"){
			alert("已经是最后一页");
		}else{
			ajaxFun(parseInt($("a[name='pageNumber'][class='page-click']").text()));			
		}
	});
	
	//详细信息
	$(".range").on("click",function(){
		window.open("../article/dispatcher/33");
	});
}

//意见
function ajaxFun(num){
	var totalPages=parseInt($("#totalPages").val());
	if(num>totalPages){
		num=totalPages-1;
		$("#changePage").val(totalPages);
	}
	$.ajax({
		type: "post",  
	    dataType:"json", 
	    url: "commentAjax",  
	    data:  {goodsId:$("#goodsId").val(),pageNumber:num},
	    success: function(data) {
	       if(data.code==200){
	    	   $(".ct-listall").empty();
	    	   var divHtml = "";
	    	   $.each(data.page.content,function(index,obj){
	    		   var date=new Date(obj.createTime);
	    		   divHtml+="<li><div class=\"ct-left\"><div class=\"ct-left-ask\">";
	    		   divHtml+=obj.goodsComment+"</div>";
	    		   divHtml+="<div class=\"ct-left-answer\"><span>解释：</span>";
	    		   if(obj.replyStatus==1){
	    			   divHtml+=obj.reply;	    			   
	    		   }
	    		   divHtml+="</div></div>";
	    		   divHtml+"<div class=\"ct-center\"><div class=\"toggle-right\">";
	    		   divHtml+="<div class=\"raty star control\"data-score="+obj.starScore+"/></div></div>";
	    		   divHtml+="<div class=\"name-level\">"+obj.userName+"<br/>["+date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+"]</div></li>";
	    	   });
	    	   $(".ct-listall").append(divHtml);
	    	   $(".raty").raty({
    			  score: function() {
    				    return $(this).attr('data-score');
    				  }, readOnly: 'true'			  
    			});
	    	   $(".pagination.page-control").empty();
	    	   var pageHtml = ""; 
	    	   var pre="";
	    	   var next="";
	    	   if(data.page.number==0){
	    		   pre="class='disabled' style='display:none'";
	    	   }
	    	   if(data.page.number==data.page.totalPages-1){
	    		   next="class='disabled' style='display:none'";
	    	   }
	    	   pageHtml+="<li><a "+pre+" name=\"preBtn\"> 上一页 </a></li>";
	    	   var begin=data.page.number+1-3>1 ? data.page.number+1-3 : 1;
	    	   var end=data.page.number+3<data.page.totalPages ? data.page.number+3 : data.page.totalPages;
	    	   for(var i=begin;i<=end;i++){
	    		   if(i==data.page.number+1){
	    			   pageHtml+="<li><a name=\"pageNumber\" class=\"page-click\">"+i+"</a></li>";
	    		   }else{
	    			   pageHtml+="<li><a name=\"pageNumber\">"+i+"</a></li>";		    			   
	    		   }
	    	   }
	    	   pageHtml+="<li><a "+next+" name=\"nextBtn\"> 下一页 </a></li>";
	    	   $(".pagination.page-control").append(pageHtml);
	    	   pageClick();
	       }  				    	   
	    },  
	    error: function(data) {
	    }  
	});
}