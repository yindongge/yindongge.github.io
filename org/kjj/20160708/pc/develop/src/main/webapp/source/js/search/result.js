$(function(){
	
	//返回筛选样式
	$(".panel-heading.ph3").find("button").each(function(index,element){
		if(index==$("[name='orderType']").val()-2){
			$(element).addClass("btn-color");
			$(element).siblings().removeClass("btn-color");
			if($("[name='orderDirection']").val()=="desc"){
				$(element).addClass("downme");
			}else{
				$(element).removeClass("downme");
			}
		}
	});
	
	var order="desc";
	$(".panel-heading.ph3").find("button").on("click",function(){
		if(!$("this").hasClass("btn-color")){
			$(this).addClass("btn-color");
			$(this).siblings().removeClass("btn-color");
		}
		if($(this).hasClass("downme")){
			$(this).removeClass("downme");
			order="asc";
		}else{
			$(this).addClass("downme");
			order="desc";
		}
		$("[name='orderType']").val($(this).attr("data-type"));
		$("[name='orderDirection']").val(order);
		formSubmit();
	});
	
	$("#searchBtn").on("click",function(){
		var fa=$("#pageform").attr("action");//获取表单action
		window.location.href=fa+"?keyword="+$("[name='keyword']").val();
	});
	
	$(".price-search").find("[type='button']").on("click",function(){
		formSubmit();
	});
	
	//更多
	$(".s-more").on("click",function(){
		if($(this).parents(".s-list").hasClass("s-selctor")){
			$(this).parents(".s-list").removeClass("s-selctor");
		}else{
			$(this).parents(".s-list").addClass("s-selctor");			
		}
	});
	
	//多选
	$(".s-more1").on("click",function(){
		$(this).parents(".s-ext").hide();
		var sValue=$(this).parents(".s-ext").siblings(".s-value");
		sValue.find(".btns").show();
		sValue.find(".clear-list").show();
		//添加复选框
		sValue.find("a").prepend("<input type='checkbox'>");
		if(!$(this).parents(".s-list").hasClass("s-selctor")){
			$(this).parents(".s-list").addClass("s-selctor");			
		}
		sValue.find(":checkbox").on("change",function(){
			var i=0;
			sValue.find(":checkbox").each(function(){
				if(this.checked){
					i++;
				};
			});
			if(i){
				sValue.find(".btns .btn1").removeClass("disabled");
				sValue.find(".clear-list").css("color","black");
			}else{
				sValue.find(".btns .btn1").addClass("disabled");
				sValue.find(".clear-list").css("color","gray");
			}
		});
		sValue.find("a").off("click");
	
		//复选框勾选后，点击确定
		$(".btns").find(".btn1").on("click",function(){
			if(!$(this).hasClass("disabled")){
				var keySpan=$(this).parents(".s-list").find(".s-key").find("span");
				var valueIds=[];
				var valueNames=[];
				var li="";
				sValue.find(":checkbox").each(function(){
					if(this.checked==true){
						valueIds.push($(this).parent().attr("data-value-id"));
						valueNames.push($(this).parent().text());
						li="<li><a data-key-id=\""+keySpan.attr("data-key-id")+"\" data-value-id=\""+valueIds+"\" href=\"javascript:void(0)\">"+keySpan.text()+"<strong>"+valueNames+"</strong><span >x</span></a></li>";
					}
				});
				$(".panel-heading.ph4").show();
				$(".panel-heading.ph4").find("ul").append(li);
				formSubmit();
			};	
		});
		
	});
	
	//清空
	$(".clear-list").on("click",function(){
		$(this).parents(".s-list").find(":checkbox").removeAttr("checked");
		$(this).css("color","gray");
		$(this).siblings(".btns").find(".btn1").addClass("disabled");
	});
	
	//取消多选
	$(".btns .btn2").on("click",function(){
		$(this).parents(".btns").hide();
		$(this).parents(".btns").siblings(".clear-list").hide();
		if($(this).parents(".s-list").hasClass("s-selctor")){
			$(this).parents(".s-list").removeClass("s-selctor");			
		}
		//移除复选框
		$(this).parents(".s-value").find(":checkbox").remove();
		//显示多选按钮
		$(this).parents(".s-value").siblings(".s-ext").show();
	});
	
	
	//每一项的点击方法
	$(".s-value").find("a").on("click",function(){
		var keySpan=$(this).parents(".s-list").find(".s-key").find("span");
		var li="<li><a data-key-id=\""+keySpan.attr("data-key-id")+"\" data-value-id=\""+$(this).attr("data-value-id")+"\" href=\"javascript:void(0)\">"+keySpan.text()+"<strong>"+$(this).text()+"</strong><span >x</span></a></li>";
		$(".panel-heading.ph4").show();
		$(".panel-heading.ph4").find("ul").append(li);
		formSubmit();
	});
	
	//全部撤销
	$(".panel-heading.ph4").find(".back-me").find("a").on("click",function(){
		$(".panel-heading.ph4").find("ul").empty();
		$(".panel-heading.ph4").hide();
		$(".s-list").show();
		formSubmit();
	});
	
	//从url中获取参数，用获取到的参数来设置筛选
	 var all_url =  window.location.href;
	 var s1=[];
     s1 = all_url.split("?");
     if (s1.length > 1) 
     {
    	 var s2=[];
    	 s2 = s1[1].split("&");
    	 var key=[];
    	 for(var i=0;i<s2.length;i++){
    		 key=s2[i].split("=");
    		 if(key[0].indexOf("fid")>-1){
    			 var keyId=key[0].substr(3);
    			 if(keyId=="brand"){
    				 $("[name='brandList']").hide();
    				 var text=[];
    				 $("[name='brandList']").find("li").find("a").each(function(){
    					 var keys=key[1].split(",");
    					 for(var j=0; j<keys.length;j++){
    						 if($(this).attr("data-value-id")==keys[j]){
    							 text.push($(this).text());
    						 }    						 
    					 }  					 
    				 });
    				 var li="<li><a data-key-id=\""+keyId+"\" data-value-id=\""+key[1]+"\" href=\"javascript:void(0)\">品牌：<strong>"+text+"</strong><span >x</span></a></li>";
    				$(".panel-heading.ph4").show();
    				$(".panel-heading.ph4").find("ul").append(li);
    				 
    			 }else{
    				 $("[name='propList']").each(function(){
    					 if($(this).find(".s-key").find("span").attr("data-key-id")==keyId){
    						 $(this).hide();
    						 var text=[];
    						 var keyName="";
    	    				 $(this).find("li").find("a").each(function(){
    	    					 var keys=key[1].split(",");
    	    					 for(var j=0; j<keys.length;j++){
    	    						 if($(this).attr("data-value-id")==keys[j]){
    	    							 text.push($(this).text());
    	    						 }    						 
    	    					 } 
    	    					 keyName=$(this).parents(".s-list").find(".s-key").find("span").text();
    	    				 });
    	    				var li="<li><a data-key-id=\""+keyId+"\" data-value-id=\""+key[1]+"\" href=\"javascript:void(0)\">"+keyName+"<strong>"+text+"</strong><span >x</span></a></li>";
    	    				$(".panel-heading.ph4").show();
    	    				$(".panel-heading.ph4").find("ul").append(li);
    	    				
    					 }
    				 });
    			 }
    		 }
    	 }
     };
     
    //点击删除每一个筛选条件
     $(".panel-heading.ph4").find("ul").find("li").on("click",function(){
    	 $(this).remove();
    	 formSubmit();
     });
     
     //查询结果，商品列表点击
     $(".list-f").find(".f-img").on("click",function(){
//    	 window.location.href="../item/"+ $(this).find("input:hidden").val(); 
    	 window.open("../item/"+ $(this).find("input:hidden").val()); 
     });
     

});

function addCart(goodsId,goodsSn){
	window.location.href="../cart/add?goodsId="+goodsId+"&goodsSn="+goodsSn+"&amount=1";  
}

//提交表单
function formSubmit(){
	var filter="";
	$(".panel-heading.ph4").find("li").find("a").each(function(){
		filter=filter+"&fid"+$(this).attr("data-key-id")+"="+$(this).attr("data-value-id");
	});
	var fs=$("#pageform").serialize(); //序列化
	var fa=$("#pageform").attr("action");//获取表单action
	window.location.href=fa+"?"+fs+filter;
};

/** 分页 **/
function pageNow(pageJump) {
	var totalPages = parseInt($("#pageNumber").attr("data-total-pages"));
	if (pageJump <= 0) {
		alert(" 不 好 意 思 ， 已 经 是 第 一 页 啦  ！");
		return false;
	} else if (totalPages <= pageJump-1) {
		alert(" 没 有 下 一 页 啦 ！");
		return false;
	} else {
		$("#pageNumber").val(pageJump-1);
		$("#pageform").submit();
	}
}

function jumpPage() {
	var pageJump = $("#textNumber").val();
	var totalPages = parseInt($("#pageNumber").attr("data-total-pages"));
	if (!isPInt(pageJump)) {
		alert(" 请填写正整数 ！");
		return false;
	}
	if (pageJump < 1) {
		alert(" 不 好 意 思 ， 已 经 是 第 一 页 啦  ！");
		return false;
	} else if (totalPages < pageJump) {
		$("#pageNumber").val(totalPages-1);
		$("#pageform").submit();
//		alert(" 没 有 下 一 页 啦 ！");
//		return false;
	} else {
		$("#pageNumber").val(pageJump-1);
		$("#pageform").submit();
	}
}
function isPInt(str) {
	var g = /^[1-9]*[1-9][0-9]*$/;
	return g.test(str);
}
