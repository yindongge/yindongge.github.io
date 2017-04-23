//验证码计时器
var waitTime = 0;

$(function () {
	$("#aIdentifyCode").click(function(){
		if(waitTime == 0){
			var mobilePhone = $("#mobilePhone").val();
		    if (mobilePhone=='') {
		        $(".reginlist-tips").text("手机号不能为空");
		        return false;
		    }
		    if (!isMobile(mobilePhone)) {
		    	$(".reginlist-tips").text("手机号格式错误");
		    	return false;
		    }
		    waitTime = 60;
    	    waitIdentifyCode();
		    $.ajax({
			    type: "post",  
			    dataType:"json",
			    url: "../register/sendRegisterCode",  
			    data: {"mobilePhone":mobilePhone},
			    success: function(data) {  
			    	if(data!=200){
			    		$(".reginlist-tips").text("验证码发送错误");
			    		waitTime = 0;
		        	    waitIdentifyCode();
		            }
			    },  
			    error: function(data) {  
			    }  
			})  ;
	    }
	});
	
	$("#btnRegister").click(function(){
		
		var mobilePhone = $("#mobilePhone").val();
	    if (mobilePhone=='') {
	        $(".reginlist-tips").text("手机号不能为空");
	        return false;
	    }
	    if (!isMobile(mobilePhone)) {
	    	$(".reginlist-tips").text("手机号格式错误");
	    	return false;
	    }
	    
	    var password = $("#password").val();
	    var confirmpassword = $("#confirmpassword").val();
	    if (password=='') {
	        $(".reginlist-tips").text("密码不能为空");
	        return false;
	    }
	    if (!isPassword(password)) {
	    	$(".reginlist-tips").text("密码应为6-20位");
	    	return false;
	    }
	    if (confirmpassword=='') {
	    	$(".reginlist-tips").text("确认密码不能为空");
	    	return false;
	    }
	    if (!isPassword(confirmpassword)) {
	    	$(".reginlist-tips").text("确认密码应为6-20位");
	    	return false;
	    }
	    if (confirmpassword!=password) {
	    	$(".reginlist-tips").text("两次密码输入不一致");
	    	return false;
	    }
	    var verifycode = $("#verifycode").val();
	    if (verifycode=='') {
	    	$(".reginlist-tips").text("验证码不能为空");
	    	return false;
	    }
	    if (verifycode.length!=4) {
	    	$(".reginlist-tips").text("验证码错误");
	    	return false;
	    }
	    
	    var registering = $(".reginlist-btn").is(".reginlist-active");
		if(registering){    
			$(".reginlist-btn").removeClass("reginlist-active");
		    //注册
		    $.ajax({
			    type: "post",  
			    dataType:"json",
			    url: "../register/register",  
			    data: $('#formRegister').serialize(),
			    success: function(data) {  
			       if(data.code==200){
			    	   if(data.url!=null&&data.url!=''){
			    		   //跳转地址
			    		   location.href=".."+data.url;
			    	   }else{
			    		   location.href="../user/center";
			    	   }
			       }else{
			    	   if(data.code!=200){
			    		   $(".reginlist-tips").text(data.desc);
			    		   $(".reginlist-btn").addClass("reginlist-active");
			    	   }
			       }
			    },  
			    error: function(data) {  
			    }  
			})  ;
		}
	});
});

function waitIdentifyCode() {
    if (waitTime == 0) {
        $("#aIdentifyCode").text("获取验证码");
    } else {
        $("#aIdentifyCode").text("重新发送  (" + waitTime + ")");
        waitTime--;
        setTimeout(function() {
        	waitIdentifyCode();
        },
        1000);
    }
}