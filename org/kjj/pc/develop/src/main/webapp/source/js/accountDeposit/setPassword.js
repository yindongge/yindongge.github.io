var wait=0;
$(function(){
	$("#mobileOrEmail").on("blur",function(){
		var str = $("#mobileOrEmail").val().trim();
		var phone = $("#phone").val();
		var email = $("#email").val();
		if(!/^1\d{10}$/.test(str) && !/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/.test(str)){
			$("#mobEmail").empty();
			$("#mobEmail").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> 手机号或邮箱格式不正确！</p>");
		}else if('' == phone && /^1\d{10}$/.test(str)){
			$("#mobEmail").empty();
			$("#mobEmail").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> 该手机尚未绑定，<a href='../security/bindPhone'>立即绑定！</a></p>");
		}else if('' == email && /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/.test(str)){
			$("#mobEmail").empty();
			$("#mobEmail").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> 该邮箱尚未绑定，<a href='../security/bindEmail'>立即绑定！</a></p>");
		}else if(str != email && str != phone){
			$("#mobEmail").empty();
			$("#mobEmail").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> 请输入已绑定的手机号或邮箱</p>");
		}else{
			$("#mobEmail").empty();
		}
	});
	
	$("#mobileOrEmail").focus(function(){
		$("#mobEmail").html("<p class='normal'> 请输入已绑定的手机号或邮箱！</p>");
	});
	
	$("#password").focus(function(){
		$("#passwordshow").html("<p class='normal'> 请输入6位字符，全为数字</p>");
	});
	
	$("#password").on('blur',function(){
		var password = $("#password").val();
		if(password == ''){
			$("#passwordshow").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> 请输入支付密码</p>");
		}else if(!/^\d{6}$/.test(password)){
			$("#passwordshow").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> 支付密码格式不正确，请重新输入</p>");
		}else{
			$("#passwordshow").html("");
		}
	});
	
	$("#confirmpassword").focus(function(){
		$("#password2show").html("<p class='normal'> 请再次输入支付密码</p>");
	});
	
	$("#confirmpassword").on('blur',function(){
		var password = $("#password").val();
		var confirmpass = $("#confirmpassword").val();
		if(confirmpass == ''){
			$("#password2show").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> 请输入确认支付密码</p>");
		}else if(password != confirmpass){
			$("#password2show").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> 两次输入密码不一致</p>");
		}else{
			$("#password2show").html("");
		}
	});
	
	$("#bsend").on("click",function(){
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
			$("#mobEmail").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> 手机号或邮箱格式不正确！</p>");
		}
	});
});

function check(){
	var str = $("#mobileOrEmail").val().trim();
	var phone = $("#phone").val();
	var email = $("#email").val();
	if(isMobile(str) && str == phone){
		$("#bsend").attr("disabled",false);
	}else if(/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/.test(str) && str == email){
		$("#bsend").attr("disabled",false);
	}else if(isMobile(str) || (/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/.test(str))){
		$("#bsend").attr("disabled",true);
	}
}

function commit(){
	$("#mobEmail").html("");
	$("#showvcode").html("");
	$("#passwordshow").html("");
	$("#password2show").html("");
	if($("#mobileOrEmail").val()==""){
		$("#mobEmail").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> 请输入已绑定的手机号或邮箱！</p>");
		return false;
	}
	if($("#verifycode").val()==""){
		$("#showvcode").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> 请填写验证码！</p>");
		return false;
	}
	if($("#verifycode").val().length!=4 && $("#verifycode").val().length!=6){
		$("#showvcode").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> 验证码错误！</p>");
		return false;
	}
	var pass1=$("#password").val().trim();
	var pass2=$("#confirmpassword").val().trim();
	
	if(pass1=="" || !/^\d{6}$/.test(pass1)){
		$("#pass1div").addClass("form-active1");
		$("#passwordshow").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> 请填写6位数字密码！</p>");	
		return false;
	}
	if(pass1.length<6||pass1.length>6){
		$("#passwords").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> 密码长度为6的数字！</p>");
		return false;
	}
	
	if(pass2 == ''){
		$("#password2show").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> 请输入确认支付密码！</p>");	
		return false;
	}
	
	if(pass1!=pass2){
		$("#password2show").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> 两次输入密码不一致！</p>");	
		return false;
	}
	
    $.ajax({  
        type: "post",  
        dataType:"json",
        url: "../accountDeposit/findAccountPassword",  
        data: $('#form').serialize(),
        success: function(data) {  
           if(data.code != 200 && data.code==401){
        		$("#showvcode").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> "+data.desc+"</p>");
        	   
           }else{
        	  location.href="../security/desc";
           }
        },  
        error: function(data) {
        }  
      })  ;
	
}

function time(o) {
    if (wait == 0) {
    	$("#bsend").attr("disabled",false);
        $("#bsend").text("免费获取验证码");
    } else {
        $("#bsend").attr("disabled",true);
        $("#bsend").text("重新发送  (" + wait + ")");
        wait--;
        setTimeout(function() {
            time(o);
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