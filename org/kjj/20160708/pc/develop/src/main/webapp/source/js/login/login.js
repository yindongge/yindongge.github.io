$(function () {
	$(".close").click(function(){
		$(this).prev().val('');
		$(this).prev().focus();
	});
	
   $("#loginsubmit").click(function(){
	   $("#loginsubmit").attr("disabled", true); 
	   $("#loginsubmit").text("登录中...");
      login();
   });
   
   $("#username").focus(function(){
	   $("#nameshow").addClass("focus-normal");
		   $(".login-fault").hide();
   });
   
   $("#password").focus(function(){
	   $("#passshow").addClass("focus-normal");
		   $(".login-fault").hide();
   });
   
   $("#password").blur(function(){
	   $("#passshow").removeClass("focus-normal");
	   if ($("#password").val() == "") { 
		   	$(".login-fault").show();
			$("#showmessage").html("<span class=\"glyphicon glyphicon-minus-sign\"></span> 密码不能为空！");
			$("#passshow").addClass("login-focus");
			//$("#password").focus(); 
			return false; 
		} 
		$(".login-fault").hide();
		$("#showmessage").empty();
		$("#passshow").removeClass("login-focus");	
	});
   
	$("#username").blur(function(){
		 $("#nameshow").removeClass("focus-normal");
		if ($("#username").val() == "") {
				$(".login-fault").show();
				$("#showmessage").html("<span class=\"glyphicon glyphicon-minus-sign\"></span> 手机号/邮箱/用户名不能为空！");
				$("#nameshow").addClass("login-focus");
				//$("#username").focus(); 
				return false; 
		} 
		$(".login-fault").hide();
		$("#showmessage").empty();
		$("#nameshow").removeClass("login-focus");	
	});	
});

function login(){
	//在cookie  中查找 失败次数
	var loginfail = $.cookie('loginFailNum');
	if(loginfail != null){
		if(loginfail > 4){
			//弹出 填写注册码部分内容
			//$("#vcode").empty();
			$("#divIdentifyCode").show();
			$("#imgIdentifyCode").text("加载中...");
			$("#imgIdentifyCode").attr("src","identifyCode");
		}
	}
	
	$.ajax({  
	    type: "post",  
	    dataType:"json",
	    url: "login",  
	    data: $('#form').serialize(),
	    success: function(data) {  
	       if(data.code==200){
	    	    $.cookie('loginFailNum', 0);
    		    location.href=data.url;
	       }else{
	    	   
	    	   $("#loginsubmit").attr("disabled", false); 
			   $("#loginsubmit").text("登录");
	    	   
	    	   if(loginfail==null){
	    		   loginfail=1;
	    		   $.cookie('loginFailNum', loginfail);
	    	   }else{
	    		   loginfail =parseInt(loginfail)+1;
	    		   $.cookie('loginFailNum', loginfail);
	    	   }

	    	   $("#showmessage").empty();
	    		
	    	   if(data.code!=200){
	    		   $(".login-fault").show();
	    		   $("#showmessage").html("<span class=\"glyphicon glyphicon-minus-sign\"></span>"+data.desc);
	    	   }
	    	   
	    	   if(data.code==401){
	    		   //重新获取验证
	    		   changeIdentifyCode();
	    	   }
	       }
	    },  
	    error: function(data) {  
	    }  
	})  ;
}

function changeIdentifyCode(){
	var timestamp = (new Date()).valueOf();
	$("#imgIdentifyCode").text("加载中。。。");
	$("#imgIdentifyCode").attr("src","identifyCode?"+timestamp);
}