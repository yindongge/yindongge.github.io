$(function () {
	$("#aIdentifyCode").click(function(){
		var timestamp = (new Date()).valueOf();
		$("#imgIdentifyCode").attr("src","identifyCode?"+timestamp);
	});
	
	$("#btnLogin").click(function(){
	    if ($("#loginName").val()=='') {
	        $(".reginlist-tips").text("账号不能为空");
	        return false;
	    }
	    if ($("#password").val()=='') {
	        $(".reginlist-tips").text("密码不能为空");
	        return false;
	    }
	    if ($("#identifyCode").val()=='') {
	    	$(".reginlist-tips").text("验证码不能为空");
	    	return false;
	    }
	    
	    $.ajax({
		    type: "post",  
		    dataType:"json",
		    url: "login",  
		    data: $('#formLogin').serialize(),
		    success: function(data) {  
		       if(data.code==200){
		    	   if(data.url!=null&&data.url!=''){
		    		   //跳转地址
		    		   location.href=data.url.substring(1);
		    	   }else{
		    		   location.href="user/center";
		    	   }
		       }else{
		    	   if(data.code!=200){
		    		   $(".reginlist-tips").text(data.desc);
		    	   }
		    	   
		    	   if(data.code==401){
		    		   //重新获取验证
		    		   var timestamp = (new Date()).valueOf();
		    		   $("#imgIdentifyCode").attr("src","identifyCode?"+timestamp);
		    		   $("#identifyCode").val("");
		    	   }
		       }
		    },  
		    error: function(data) {  
		    }  
		})  ;
	});
});