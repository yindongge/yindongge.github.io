$(function(){
	$("#invitation").click(function(){
		
		$(".acount-tips").empty();
		
		if($('#realName').val() != ""){
			if(!validRealName($('#realName').val())){
				$(".acount-tips").html("姓名格式错误！");
				return false;
			}
		}
		var invitationCode = $("#invitationCode").val();
		if(invitationCode == "") { 
			$(".acount-tips").html("请填写邀请码！");
			return false;
		}
		if(invitationCode.length != 9) { 
			$(".acount-tips").html("验证码格式不正确！");
			return false;
		}

		if(!isNumber(invitationCode)){
			$(".acount-tips").html("验证码格式不正确！");
			return false;
		}
		var ajaxing = $(".acount-button").is(".gray");
		if(!ajaxing){
			$(".acount-button").addClass("gray");
			$.ajax({  
		        type: "post",  
		        dataType:"json",
		        url: "../enterprise/useInvitation",
		        data: $('#form').serialize(),
		        success: function(data) {  
		            if(data.code != 200){
						$(".acount-tips").html("邀请码不存在或已经被使用！");
						$(".acount-button").removeClass("gray");
		            }else {
		        	   alert('您已经成功激活企业邀请码！');
		        	   location.href="../user/detail";
		            }
		        },  
		        error: function(data) {  
		        	$(".acount-button").removeClass("gray");  
		        }  
		    });
		}
    });
});

function validRealName(s){
	return /^[a-z\u4E00-\u9FA5]+$/gi.test(s);
}