$(function(){
	// 关闭邀请码窗口
	$('.close').click(function(){
		$("#invitationWin").hide();
	});
		
});

function updatePasswordWin(){
	$('#passwordclick').removeAttr("disabled"); 
	hiddenAll();
	$("#updatePass").show();
}

function updateNameWin(){
	$('#saveName').removeAttr("disabled"); 
	hiddenAll();
	$("#updateName").show();
}
function bindMobileWin(){
	hiddenAll();
	$("#bindMobile").show();
}
function bindEmailWin(){
	hiddenAll();
	$("#bindEmail").show();
}

function hiddenAll(){
	//bindMobile 
	$("#basic").hide();
	$("#passwordShow").hide();
	$("#updateName").hide();
	$("#bindMobile").hide();
	$("#bindEmail").hide();
}


function savePass(){
	
	var pass1 = $("#password1").val();
	var pass2 = $("#password2").val();
	var confirm = $("#confirmpass").val();
	
	if(pass1.trim()==""){
		$("#password1show").attr("class","false");
		$("#password1show").text("密码不能为空！");
		return false;
	}else{
		//$("#div1").empty();
		$("#password1show").text("");
		$('#password1show').removeAttr("class"); 
	}
	
	if(pass2.trim()==""){
		$("#password2show").attr("class","false");
		$("#password2show").text("密码不能为空！");
		return false;
	}else if(!isPassword(pass2)){
		$("#password2show").attr("class","false");
		$("#password2show").text("请输入6~20位字符！");
		return false;
	}else{
		//$("#div2").empty();
		$("#password2show").text("");
		$('#password2show').removeAttr("class"); 
	}
	if(confirm.trim()==""){
		$("#confirmpassshow").attr("class","false");
		$("#confirmpassshow").text("确认密码不能为空！");
		return false;
	}else if(!isPassword(confirm)){
		$("#confirmpassshow").attr("class","false");
		$("#confirmpassshow").text("请输入6~20位字符！");
		return false;
	}else if(confirm.trim() != pass2.trim()){
		$("#confirmpassshow").attr("class","false");
		$("#confirmpassshow").text("确认密码与新密码不符！");
		return false;
	}else{
		//$("#div3").empty();
		$("#confirmpassshow").text("");
		$('#confirmpassshow').removeAttr("class"); 
	}
	$('#passwordclick').attr('disabled',"true");
	$.ajax({  
	    type: "post",  
	    dataType:"json",
	    url: "../user/editPassword",
	    data:{userId:$('#userId').val(),password:pass2,oldPassword:pass1},
	    success: function(data) {  	
	       if(data.code!=200){
		       $("#password1show").attr("class","false");
		   	   $("#password1show").text("旧密码不正确！");
		   	   $('#passwordclick').removeAttr("disabled"); 
	       }else{
	    	  window.location.reload();
	       }
	    },  
	    error: function(data) {  
	    	$('#passwordclick').removeAttr("disabled"); 
	    }  
	})  ;
	
}

function updateNameClick(){
	$('#nameWin').html("");
	var userName = $("#userName").val();
	if(userName == ""){
		$('#nameWin').html("用户名不能为空");
		return false;
	}
	if(isNumber(userName)){
		$('#nameWin').html("用户名格式错误，不可为全部为数字");
		return false;
	}
	if(isEmail(userName)){
		$('#nameWin').html("用户名格式错误，不可为邮箱");
		return false;
	}
	if(!isUserName(userName)){
		$('#nameWin').html("用户名格式错误，应为4-20位数字、汉字、“-”、“_”组成");
		return false;
	}
	$('#saveName').attr('disabled',"true");
	$.ajax({  
	    type: "post",  
	    dataType:"json",
	    url: "../user/editUserName",  
	    data:{userId:$('#userId').val(),userName:$("#userName").val()},
	    success: function(data) {  
	       if(data.code!=200){
	    	   $("#nameWin").empty();
	   		   $("#nameWin").append("<p class=\"false\"><span class=\"glyphicon glyphicon-info-sign\"></span>该名称不可用，请更改！</p>");
	   		
	   		$('#saveName').removeAttr("disabled"); 
	       }else{
	    	  window.location.reload();
	       }
	    },  
	    error: function(data) {  
	    	$('#saveName').removeAttr("disabled"); 
	    }  
	});
}

function showInvitationWin(enterpriseId){
	$.ajax({  
	    type: "post",  
	    dataType:"json",
	    url: "../security/showInvitation",  
	    data:{enterpriseId:enterpriseId},
	    success: function(data) {  
	       var codeItems = data.codeItems; // 未使用激活码
	       var useNums = data.useNums; // 已使用数量
	       var no_useNums = data.no_useNums; // 未使用数量
	       
	       $('#invitationdiv').empty();
	       var arr = codeItems.split(",");
	       var codeStr = "";

	       if(parseInt(no_useNums) > 0){
		       for(var i = 0; i < arr.length; i++){
		    	   codeStr += "<span>" + arr[i] + "</span>&nbsp;&nbsp;";
		       }
		       $('#invitationdiv').append(codeStr);
	       } else {
	    	   $('#invitationdiv').append("<a href=\"javascript:createInvitation(\'" + enterpriseId + "\')\">再次邀请500个验证码</a>");
	       }
	       $('#useNumdiv').empty();
	       $('#useNumdiv').append(useNums);
	       $('#no_useNumdiv').empty();
	       $('#no_useNumdiv').append(no_useNums);
	       
	    },  
	    error: function(data) {   
	    }  
	});
	$('#invitationWin').show();
}
function createInvitation(enterpriseId){
	$.ajax({  
	    type: "post",  
	    dataType:"json",
	    url: "../security/createInvitation",  
	    data:{enterpriseId:enterpriseId},
	    success: function(data) { 
	    	if(data.code==200){
	    	   alert('邀请码生成完成!');
	    	   $("#invitationWin").hide();
	    	   showInvitationWin(enterpriseId);
	       }
	    },  
	    error: function(data) {  
	    	
	    }  
	});
}
function showEnterpriseUse(enterpriseId){
	window.location.href="../security/enterpriseUserList?enterpriseId=" + enterpriseId;
}