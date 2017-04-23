$(function () {
	$("#btnFinish").click(function(){
		var oldPassword = $("#oldPassword").val();
		if(oldPassword == ""){
			$(".acount-tips").html("原密码为空");
			return false;
		}
		var password = $("#password").val();
		if(password == ""){
			$(".acount-tips").html("新密码为空");
			return false;
		}
		if(!isPassword(password)){
			$(".acount-tips").html("新密码格式错误");
			return false;
		}
		var password2 = $("#password2").val();
		if(password2 == ""){
			$(".acount-tips").html("确认密码为空");
			return false;
		}
		if(password != password2){
			$(".acount-tips").html("新密码和确认密码不一致");
			return false;
		}
		
	    $.ajax({
		    type: "post",  
		    dataType:"json",
		    url: "../security/password",  
		    data: $("#formPassword").serialize(),
		    success: function(data) {  
		    	if(data.code==200){
		    		alert("密码修改成功");
		    		location.href="../security/center";
	            }else{
	            	$(".acount-tips").text("原密码错误");
	            }
		    },  
		    error: function(data) {  
		    }  
		})  ;
	});
});