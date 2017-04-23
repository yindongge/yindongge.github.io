//验证码计时器
var waitTime = 0;

$(function(){
	//获取验证码
	$('#identifyCodeBtn').on('click',function(){
		if(waitTime == 0){
			if($('#phoneNo').val()==''){
				$('.acount-tips').text('手机号不能为空');
				return false;
			}
			if(!isMobile($('#phoneNo').val())){
				 $('.acount-tips').text('手机号格式不正确!');
				return false;
			}
		    waitTime = 60;
    	    waitIdentifyCode();
		    $.ajax({
			    type: "post",  
			    dataType:"json",
			    url: "../register/sendRegisterCode",  
			    data: {"mobilePhone":$('#phoneNo').val()},
			    success: function(data) {  
			    	if(data!=200){
			    		$('.acount-tips').text('验证码发送失败!');
			    		waitTime = 0;
		        	    waitIdentifyCode();
		            }
			    },  
			    error: function(data) {  
			    }  
			});
	    }
	});
	
	
	
	//确认手机号及验证码
	$('#nextBtn').on('click',function(){
		if($('#phoneNo').val()==''){
			$('.acount-tips').text('手机号不能为空!');
			return false;
		}
		if(!isMobile($('#phoneNo').val())){
			$('.acount-tips').text('手机号格式不正确!');
			return false;
		}
		if($('#identifyCode').val()==''){
			$('.acount-tips').text('验证码不能为空!');
			return false;
		}
		
		 $.ajax({
		    type: "post",  
		    url: "../security/verifyPhone",  
		    data:{'phoneNo':$('#phoneNo').val(),'identifyCode':$('#identifyCode').val()},
		    success: function(d,s,r) {  
		       if(r.status==200){
		    	   if(d.code==200){
		    		   $('#acountDiv').hide();
		    		   $('#pwdDiv').show();
		    		   nextStep($('#nextBtn'));			    		   
		    	   }else{
		    		   $('.acount-tips').text(d.desc);	
		    	   }
		       }
		    },  
		    error: function(d,s,r) {  
		    }  
		 });
		
		
	});
	
	
	//确认密码
	$('#confirmBtn').on('click',function(){
		if($('#pwd1').val()==''){
			$('.acount-tips').text('密码不能为空!');
			return false;
		}
		if(!isPassword($('#pwd1').val())){
			$('.acount-tips').text('密码长度为6~20位！');
			return false;
		}
		if($('#pwd2').val()==''){
			$('.acount-tips').text('确认密码不能为空!');
			return false;
		}
		if($('#pwd1').val()!=$('#pwd2').val()){
			$('.acount-tips').text('两次密码不一致!');
			return false;
		}
		//保存密码
		 $.ajax({
		    type: "post",  
		    url: "../security/updatePwd",  
		    data:{'phoneNo':$('#phoneNo').val(),'password':$('#pwd1').val()},
		    success: function(d,s,r) {  
		       if(r.status==200){
		    	   if(d.code==200){
		    		   $('#pwdDiv').hide();
		   				nextStep($('#confirmBtn'));		    		   
		    	   }
		       }
		    },  
		    error: function(d,s,r) {  
		    }  
		 });
	});
	
});

function nextStep(obj){
	obj.parent().hide();
	obj.parent().next().show();
	$('.acount-progress a.on').removeClass('on').next().addClass('on');
	$('.acount-tips').text('');
}


function waitIdentifyCode() {
    if (waitTime == 0) {
        $("#identifyCodeBtn").text("获取验证码");
    } else {
        $("#identifyCodeBtn").text("重新发送  (" + waitTime + ")");
        waitTime--;
        setTimeout(function() {
        	waitIdentifyCode();
        },
        1000);
    }
}