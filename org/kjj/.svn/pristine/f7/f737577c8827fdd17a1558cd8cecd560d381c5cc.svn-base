var failNum = 0;
$(function(){
	$("#realName").focus(function(){
		$("#realNameTip").empty();
		$("#realNamediv").removeClass("form-active1");
		$("#realNamediv").removeClass("form-active2");
		$("#realNameTip").removeClass("false");
		$("#realNameTip").append("4-16位字符，支持汉字、字母组合");
    });
	$("#realName").blur(function(){
		if($('#realName').val() != ""){
			if(!validRealName($('#realName').val())){
				$("#realNameTip").empty();
				$("#realNameTip").addClass("false");
				$("#realNamediv").addClass("form-active1");
				$("#realNameTip").append("姓名格式错误！");
				failNum++;
				return;
			}
		}
		$("#realNameTip").empty();
		$("#realNameTip").append("4-16位字符，支持汉字、字母组合");
		$("#realNamediv").removeClass("form-active1");
		$("#realNameTip").removeClass("false");
		
		$("#realNamediv").addClass("form-active2");
	});	
	$("#invitationCode").focus(function(){
		$("#invitationCodeTip").empty();
		$("#invitationCodediv").removeClass("form-active1");
		$("#invitationCodediv").removeClass("form-active2");
		$("#invitationCodeTip").removeClass("false");
		$("#invitationCodeTip").append("9位数字");
    });
	$("#invitationCode").blur(function(){
		if($("#invitationCode").val() == "") { 
			$("#invitationCodeTip").empty();
			$("#invitationCodeTip").addClass("false");
			$("#invitationCodediv").addClass("form-active1");
			$("#invitationCodeTip").append("请填写邀请码！");
			failNum++;
			return;
		}
		if($("#invitationCode").val().length < 9) { 
			$("#invitationCodeTip").empty();
			$("#invitationCodeTip").addClass("false");
			$("#invitationCodediv").addClass("form-active1");
			$("#invitationCodeTip").append("验证码格式不正确！");
			failNum++;
			return;
		}

		if(!isNumber($("#invitationCode").val())){
			$("#invitationCodeTip").empty();
			$("#invitationCodeTip").addClass("false");
			$("#invitationCodediv").addClass("form-active1");
			$("#invitationCodeTip").append("验证码格式不正确！");
			failNum++;
			return;
		}
		$("#invitationCodeTip").empty();
		$("#invitationCodeTip").append("9位数字");
		$("#invitationCodediv").removeClass("form-active1");
		$("#invitationCodeTip").removeClass("false");
		
		$("#invitationCodediv").addClass("form-active2");
	});	
});
function doUseInvitation(){
	failNum = 0;
	$("#realName").blur();
	$("#invitationCode").blur();
	
	if(failNum > 0){
		return;
	}
	
	$.ajax({  
        type: "post",  
        dataType:"json",
        url: "../security/useInvitation",
        data: $('#form1').serialize(),
        success: function(data) {  
        	if(data.code != 200){
				$("#invitationCodeTip").empty();
				$("#invitationCodeTip").addClass("false");
				$("#invitationCodediv").removeClass("form-active2");
				$("#invitationCodediv").addClass("form-active1");
				$("#invitationCodeTip").append("邀请码不存在或已经被使用！");
           }else {
        	   alert('您已经成功激活企业邀请码！');
        	   location.href="../security/desc";
           }
        },  
        error: function(data) {  
            alert(data);  
        }  
    });
	
}
function validRealName(s){
	return /^[a-z\u4E00-\u9FA5]+$/gi.test(s);
}