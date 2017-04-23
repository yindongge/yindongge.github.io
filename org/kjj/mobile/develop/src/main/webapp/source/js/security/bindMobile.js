//验证码计时器
var waitTime = 0;

$(function () {
	$("#aIdentifyCode").click(function(){
		if(waitTime == 0){
			var mobilePhone = $("#mobilePhone").val();
		    if (mobilePhone=='') {
		        $(".acount-tips").text("手机号不能为空");
		        return false;
		    }
		    if (!isMobile(mobilePhone)) {
		    	$(".acount-tips").text("手机号格式错误");
		    	return false;
		    }
		    waitTime = 60;
    	    waitIdentifyCode();
		    $.ajax({
			    type: "post",  
			    dataType:"json",
			    url: "../security/sendIdentityCode",  
			    data: {"mobilePhone":mobilePhone},
			    success: function(data) {  
			    	if(data!=200){
			    		$(".acount-tips").text("验证码发送错误");
			    		waitTime = 0;
		        	    waitIdentifyCode();
		            }
			    },  
			    error: function(data) {  
			    }  
			})  ;
	    }
	});
	
	$("#btnBind").click(function(){
		var mobilePhone = $("#mobilePhone").val();
	    if (mobilePhone=='') {
	        $(".acount-tips").text("手机号不能为空");
	        return false;
	    }
	    if (!isMobile(mobilePhone)) {
	    	$(".acount-tips").text("手机号格式错误");
	    	return false;
	    }
	    
	    var verifycode = $("#verifycode").val();
	    if (verifycode=='') {
	    	$(".acount-tips").text("验证码不能为空");
	    	return false;
	    }
	    if (verifycode.length!=4) {
	    	$(".acount-tips").text("验证码错误");
	    	return false;
	    }
	    
	    //绑定
	    $.ajax({
		    type: "post",  
		    dataType:"json",
		    url: "../security/bindMobile",  
		    data: $('#formBind').serialize(),
		    success: function(data) {  
		       if(data.code==200){
	    		   location.href="../security/center";
		       }else{
		    	   if(data.code!=200){
		    		   $(".acount-tips").text(data.desc);
		    	   }
		       }
		    },  
		    error: function(data) {  
		    }  
		})  ;
	    
	});
});

function waitIdentifyCode() {
    if (waitTime == 0) {
    	$("#aIdentifyCode").attr("disabled",false);
        $("#aIdentifyCode").text("获取验证码");
    } else {
    	$("#aIdentifyCode").attr("disabled",true);
        $("#aIdentifyCode").text("重新发送  (" + waitTime + ")");
        waitTime--;
        setTimeout(function() {
        	waitIdentifyCode();
        },
        1000);
    }
}