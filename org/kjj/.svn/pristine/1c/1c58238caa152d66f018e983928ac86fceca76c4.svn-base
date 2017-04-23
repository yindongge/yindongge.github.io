$(function () {
	var orderId=$('#orderId').text();
    //确认
    $("body").on("click","[name='btnConfirm']",function(){
    	if(confirm("确定要确认订单么？")){
     		$.ajax({  
    	        type: "post",  
    	        dataType: "json",
    	        url: "../confirm",
    	        data: {"orderId":orderId},
    	        success: function(data) {
    	        	if(data.code==200){
    	        		location.reload();
    	        	}else{
    	        		alert(data.desc);
    	        	}
    	        },  
    	        error: function(data) {  
    	            alert("系统错误");  
    	        }  
    	    })  ; 
    	}
	});
    
    //发货
    $("body").on("click","[name='btnSend']",function(){
    	if(confirm("确定要发货么？")){
     		$.ajax({  
    	        type: "post",  
    	        dataType: "json",
    	        url: "../sendOrTake",
    	        data: {"orderId":orderId},
    	        success: function(data) {
    	        	if(data.code==200){
    	        		location.reload();
    	        	}else{
    	        		alert(data.desc);
    	        	}
    	        },  
    	        error: function(data) {  
    	        	alert("系统错误"); 
    	        }  
    	    })  ; 
    	}
    });
    
    //自提
    $("body").on("click","[name='btnTake']",function(){
    	if(confirm("确定可以自提么？")){
     		$.ajax({  
    	        type: "post",  
    	        dataType: "json",
    	        url: "../sendOrTake",
    	        data: {"orderId":orderId},
    	        success: function(data) {
    	        	if(data.code==200){
    	        		location.reload();
    	        	}else{
    	        		alert(data.desc);
    	        	}
    	        },  
    	        error: function(data) {  
    	        	alert("系统错误"); 
    	        }  
    	    })  ;
    	}
    });
    
    //完成
    $("body").on("click","[name='btnFinish']",function(){
    	//送货上门
    	if($(this).next().val()==0){
    		if(confirm("确定订单完成了么？")){
	     		$.ajax({  
	    	        type: "post",  
	    	        dataType: "json",
	    	        url: "../finish",
	    	        data: {"orderId":orderId,'logDetail':''},
	    	        success: function(data) {
	    	        	if(data.code=="200"){
	    	        		location.reload();
	    	        	}else{
	    	        		alert(data.desc);
	    	        	}
	    	        },  
	    	        error: function(data) {  
	    	        	alert("系统错误");  
	    	        }  
	    	    })  ; 
        	}
		}else if($(this).next().val()==1){
			$(".trigger-box").show();
		}
	});
    
    //自提完成
    $("body").on("click","[name='btnTakeFinish']",function(){
		var takeCodeFinish = $("[name='takeCodeFinish']");
		$(".redtip").text("");
		if(takeCodeFinish.val() == ""){
			$(".redtip").text("提货码为空！");
			takeCodeFinish.focus();
			return false;
		}
		$.ajax({  
   	        type: "post",  
   	        dataType: "json",
   	        url: "../finish",
   	        data: {"orderId":orderId,'logDetail':'','takeCode':takeCodeFinish.val()},
   	        success: function(data) {
   	        	if(data.code=="200"){
//   	        	$(".trigger-box").hide();
   	        		location.reload();
   	        	}else{
   	        		$(".redtip").text("提货码错误!");
   	        		takeCodeFinish.focus();
   	        	}
   	        },  
   	        error: function(data) {  
   	        	alert("系统错误"); 
   	        }  
   	    }); 
		
	});
    
    //自提取消
    $("body").on("click",".close",function(){
		$('.trigger-box').hide();
	});
    
});