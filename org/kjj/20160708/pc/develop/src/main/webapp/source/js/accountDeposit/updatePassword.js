function commit(){
	var pass1 = $('#password').val().trim();
	var pass2 = $('#confirmpass').val().trim();
	if(pass1=="" || !/^\d{6}$/.test(pass1)){
		$("#passwordshow").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span>请填写6位数字密码！</p>");	
		return false;
	}
	if(pass1.length<6||pass1.length>6){
		$("#passwords").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> 密码长度为6位数字！</p>");
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
//function checkPassword(){
//	var str = $('#password').val().trim();
//	if(!/^\d{6}$/.test(str)){
//		$("#passwordshow").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span>密码长度必须为六位数字！</p>");
//	}else{
//		$("#passwordshow").empty();
//	}
//}
//function checkConfirmPassword(){
//	var password = $('#password').val().trim();
//	var confirmpass = $('#confirmpass').val().trim();
//	if(password != confirmpass){
//		$("#password2show").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span>两次输入密码不一致！</p>");
//	}else{
//		$("#password2show").empty();
//	}
//}