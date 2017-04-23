$(function(){
	$("#aIdentifyCode").click(function(){
		noDbClick();
		var mobilePhone = $("#mobile").val();
		$.ajax({
			type:"post",
			dataType:"json",
			url:"../security/sendIdentityCode",
			data:{"mobilePhone":mobilePhone},
		    success: function(data) {  
		    	if(data!=200){
		    		$(".acount-tips").text("验证码发送错误");
		    		waitTime = 0;
	        	    waitIdentifyCode();
	            }else{
	        		waitIdentifyCode();
	            }
		    },  
		    error: function(data) {  
		    } 
		});
	});
	
	$("#btnFinish").click(function(){
		var mobilePhone = $("#mobile").val();
		var verifycode = $("#verifycode").val();
		if("" == verifycode){
			$(".acount-tips").text("验证码不能为空");
			return false;
		}
		if (verifycode.length!=4) {
	    	$(".acount-tips").text("验证码错误");
	    	return false;
	    }
		$.ajax({
			type:"post",
			dataType:"json",
			url:"../security/verifyPhone",
			data:{"phoneNo":mobilePhone,"identifyCode":verifycode},
			success:function(data){
				if(data.code == 200){
					window.location='../security/bindNewPhone';
				}else{
					if(data.code != 200){
						$(".acount-tips").text(data.desc);
					}
				}
			},
			error:function(data){
				
			}
		});
	});
	
});

var waitTime = 60;
function waitIdentifyCode(){
	if(waitTime == 0){
		$("#aIdentifyCode").attr("disabled",false);
		$("#aIdentifyCode").text("获取验证码");
		waitTime=60;
	}else{
		$("#aIdentifyCode").attr("disabled",true);
		$("#aIdentifyCode").text("重新发送  (" +waitTime + ")");
		waitTime--;
		setTimeout(function(){
			waitIdentifyCode();
		},1000);
	}
}

function noDbClick(){
	setTimeout(function(){
		$("#aIdentifyCode").attr("disabled",true);
	},100);
}

