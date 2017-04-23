var wait=0;
$(function(){
	$("#mobileOrEmail").on("blur",function(){
		var str = $("#mobileOrEmail").val().trim();
		if(!/^1\d{10}$/.test(str) && !/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/.test(str)){
			$("#mobEmail").empty();
			$("#mobEmail").html("手机号或邮箱格式不正确");
		}else{
			$("#mobEmail").empty();
		}
	});
	
	$("#verifycodeBtn").on("click",function(){
		noDbClick();//防止双击发送两次验证码
		var str = $("#mobileOrEmail").val().trim();
		if(/^1\d{10}$/.test(str)){
			wait=60;
			time();
			$.ajax({  
		        type: "post",  
		        dataType:"json",
		        url: "../register/sendRegisterCode",
		        data: {mobilePhone:str},
		        success: function(data) {  
		           if(data!=200){
		        	   wait=0;
		        	   time();
		           }
		        },  
		        error: function(data) {  
		        }  
		    });
		}else if(/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/.test(str)){
			wait=60;
			time();
			$.ajax({  
		        type: "post",  
		        dataType:"json",
		        url: "../security/sendEmailCode",
		        data: {email:str}, 
		        success: function(data) { 
		           if(data!=200){
		        	   wait=0;
		        	   time();
		           }
		        },  
		        error: function(data) {  
		        }  
		    });
		}else{
			$("#mobEmail").empty();
			$("#mobEmail").html("手机号或邮箱格式不正确");
		}
	});
	
	$("#subButton").on("click",function(){
		var str = $("#mobileOrEmail").val().trim();
		var verifycode=$("#verifycode").val().trim();
		if("" != str){
			if(!/^1\d{10}$/.test(str) && !/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/.test(str)){
				$("#mobEmail").empty();
				$("#mobEmail").html("手机号或邮箱格式不正确");
				return false;
			}else{
				$("#mobEmail").empty();
			}
		}else{
			$("#mobEmail").empty();
			$("#mobEmail").html("手机号或邮箱不能为空");
			return false;
		}
		if("" == verifycode){
			$("#vercode").empty();
			$("#vercode").html("验证码不能为空");
			return false;
		}
		$.ajax({
			type: "post",  
	        dataType:"json",
	        url: "../security/verifyEmailOrPhone",
	        data: $("#form").serialize(), 
	        success: function(data) { 
	           if(data.code!=200){
	        	   if(data.code == 410){
	        		   $("#mobEmail").empty();
	       				$("#mobEmail").html(data.desc);
	        	   }else{
		        	   $("#vercode").empty();
		   			   $("#vercode").html(data.desc);
	        	   }
	           }else{
	        	   window.location='../security/verifySuccess';
	           }
	        },  
	        error: function(data) {  
	        }  
		});
	});
});

function time() {
    if (wait == 0) {
    	$("#verifycodeBtn").attr("disabled",false);
        $("#verifycodeBtn").text("免费获取验证码");
    } else {
        $("#verifycodeBtn").attr("disabled",true);
        $("#verifycodeBtn").text("重新发送  (" + wait + ")");
        wait--;
        setTimeout(function() {
            time();
        },
        1000);
    }
}

function noDbClick(){
	if($("#mobileOrEmail").val() != ''){
		setTimeout(function(){
			 $("#verifycodeBtn").attr("disabled",true);
		},100);
	}
}