$(function(){
	$("#password").focus(function(){
		$("#passwordshow").empty();
		$("#passwordshow").html(">请填写6-20位字符由字母和数字符号组成");	
	});
	
	$("#password").blur(function(){
		if($(this).val().length<6||$(this).val().length>20){
			$("#passwordshow").empty();
			$("#passwordshow").html("密码长度必须在6-20位之间");	
		}else{
			$("#passwordshow").empty();
		}
	});
	
	$("#confirmpassword").focus(function(){
		$("#password2show").empty();
		$("#password2show").html("请填写6-20位字符由字母和数字符号组成");	
	});
	
	$("#confirmpassword").blur(function(){
		if($(this).val()!=$("#password").val()){
			$("#password2show").empty();
			$("#password2show").html("两次输入密码不一致");	
		}else{
			$("#password2show").empty();
		}
	});
	
});

function updatePassword(){

	var pass1=$("#password").val().trim();
	var pass2=$("#confirmpassword").val().trim();
	
	if(pass1==""){
		$("#passwordshow").empty();
		$("#passwordshow").html("请填写密码");	
		return false;
	}
	if(pass1.length<6||pass1.length>20){
		$("#passwordshow").empty();
		$("#passwordshow").html(" 密码长度为6-20长度的字符串");
		return false;
	}
	
	if(pass1!=pass2){
		$("#password2show").empty();
		$("#password2show").html("两次输入密码不一致");	
		return false;
	}

    $.ajax({  
        type: "post",  
        dataType:"json",
        url: "../security/resetPassword",  
        data: $('#form').serialize(),
        success: function(data) {  
           if(data.code != 200){
           }else {
        	  location.href="../loginInit";
           }
        },  
        error: function(data) {
        }  
      })  ;
	
}

