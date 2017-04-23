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
//	var confirmpass = $('#confirmpassword').val().trim();
//	if(password != confirmpass){
//		$("#password2show").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span>两次输入密码不一致！</p>");
//	}else{
//		$("#password2show").empty();
//	}
//}

function commit(){
	if($("#verifycode").val()==""){
		$("#showvcode").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> 请填写验证码！</p>");
		return false;
	}
	if($("#verifycode").val().length!=4){
		$("#showvcode").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> 验证码错误！</p>");
		return false;
	}
	var pass1=$("#password").val().trim();
	var pass2=$("#confirmpassword").val().trim();
	
	if(pass1=="" || !/^\d{6}$/.test(pass1)){
		$("#pass1div").addClass("form-active1");
		$("#passwordshow").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span>请填写6位数字密码！</p>");	
		return false;
	}
	if(pass1.length<6||pass1.length>6){
		$("#passwords").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> 密码长度为6的数字！</p>");
		return false;
	}
	
	if(pass1!=pass2){
		$("#passwordshow").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span> 两次输入密码不一致！</p>");	
		return false;
	}
	
	var val =true;
    $.ajax({  
        type: "post",  
        dataType:"json",
        url: "../accountDeposit/findAccountPassword",  
        data: $('#form').serialize(),
        success: function(data) {  
           if(data.code != 200 && data.code==401){
        		$("#showvcode").html("<p class='false'><span class='glyphicon glyphicon-remove-sign'></span>"+data.desc+"</p>");
        	   
           }else{
        	  location.href="../security/desc";
           }
        },  
        error: function(data) {
        }  
      })  ;
	
}

function sendMessage(o){
	$.ajax({  
        type: "post",  
        dataType:"json",
        url: "../register/sendRegisterCode",
        data: $('#form').serialize(),
        success: function(data) {  
           if(data!=200){
           }else{
        	   time(o);
           }
        },  
        error: function(data) {  
        }  
    })  ;
}
var wait=60;
function time(o) {
    if (wait == 0) {
    	$("#bsend").attr("disabled",false);
        $("#bsend").text("免费获取验证码");
        wait = 60;
    } else {
        $("#bsend").attr("disabled",true);
        $("#bsend").text("重新发送  (" + wait + ")");
        wait--;
        setTimeout(function() {
            time(o);
        },
        1000);
    }
}