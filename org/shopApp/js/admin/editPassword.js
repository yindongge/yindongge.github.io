	$(function () {
		$("#btnEdit").click(function(){
			var oldPassword = $("#oldPassword").val();
			if(oldPassword==''){
				$("#sppassword").empty();
				$("#sppassword").html("<font color='red'>原密码不能为空</font>");
				return false;
			}
			var password = $("#password").val();
			if(password==''){
				$("#newpassword").empty();
				$("#newpassword").html("<font color='red'>新密码不能为空</font>");
				return false;
			}
			var password2 = $("#password2").val();
			if(password2==''){
				$("#confirmPass").empty();
				$("#confirmPass").html("<font color='red'>新密码确认不能为空</font>");
				return false;
			}
			if(password!=password2){
				$("#confirmPass").empty();
				$("#confirmPass").html("<font color='red'>新密码两次输入不一致</font>");
				return false;
			}
			$.ajax({  
       	        type: "post",  
       	        dataType: "json",
       	        url: "../admin/editPassword",
       	        data: {"userId":$("#userId").val(),
       	        	   "oldPassword":$("#oldPassword").val(),
       	        	   "password":$("#password").val()},
       	        success: function(data) { 
       	        	if(data.code==200){
       	        		$("#tip").empty();
       	        		$("#tip").html("<font color='red'>修改成功</font>");
       	        	}else{
       	        		$("#sppassword").empty();
       	        		$("#sppassword").html("<font color='red'>原密码错误</font>");
       	        	}
       	        },  
       	        error: function(data) {  
       	        	alert("系统错误"); 
       	        }  
       	    })  ; 
		});
	});