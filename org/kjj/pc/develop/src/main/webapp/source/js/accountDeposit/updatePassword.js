$(function(){
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
	
	$("#confirmpass").focus(function(){
		$("#password2show").html("<p class='normal'> 请再次输入支付密码</p>");
	});
	
	$("#confirmpass").on('blur',function(){
		var password = $("#password").val();
		var confirmpass = $("#confirmpass").val();
		if(confirmpass == ''){
			$("#password2show").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> 请输入确认支付密码</p>");
		}else if(password != confirmpass){
			$("#password2show").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> 两次输入密码不一致</p>");
		}else{
			$("#password2show").html("");
		}
	});
})

function commit(){
	var pass1 = $('#password').val().trim();
	var pass2 = $('#confirmpass').val().trim();
	if(pass1=="" ){
		$("#passwordshow").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> 请输入支付密码！</p>");	
		return false;
	}
	if(!/^\d{6}$/.test(pass1)){
		$("#passwordshow").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> 支付密码格式不正确，请重新输入</p>");	
		return false;
	}
	if(pass2=="" ){
		$("#password2show").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> 请输入确认支付密码</p>");	
		return false;
	}
	
	if(pass1!=pass2){
		$("#passwordshow").html('');
		$("#password2show").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> 两次输入密码不一致！</p>");	
		return false;
	}
	$.ajax({
		type: "post",  
	    dataType:"json",
		url:"../accountDeposit/updatePassword",
		data: $('#form').serialize(),
		success:function(data){
			if(data.code!=200 && data.code == 400){
				$("#password2show").html('');
				$("#oldpasswordshow").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span>"+data.desc+"</p>");
			}else{
				location.href="../security/desc";
			}
		},
		error:function(data){
		}
	});
	
}