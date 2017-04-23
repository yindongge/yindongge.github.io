$(function(){
	$("#password").focus(function(){
		$("#passwordshow").empty();
		$("#pass1div").removeClass("form-active1");
		$("#passwordshow").attr("class","white");
		$("#passwordshow").text("请填写6-20字符由字母和数字符号组成!");	
	});
	
	$("#verifycode").focus(function(){
		$("#showvcode").empty();
		$("#codediv").removeClass("form-active1");
		
	});
	
	$("#password").blur(function(){
		if($(this).val().length<6||$(this).val().length>20){
			$("#pass1div").addClass("form-active1");
			$("#passwordshow").attr("class","red");
			$("#passwordshow").text("密码长度必须在6-20位之间!");	
		
		}else{
			$("#passwordshow").attr("class","white");
			$("#passwordshow").empty();
			$("#pass1div").addClass("form-active2");
			
		}
		
	});
	
	$("#confirmpassword").focus(function(){
		$("#password2show").attr("class","white");
		$("#password2show").text("请填写6-20字符由字母和数字符号组成!");	
	});
	
	$("#confirmpassword").blur(function(){
		if($(this).val()!=$("#password").val()){
			$("#pass2div").addClass("form-active1");
			$("#password2show").attr("class","red");
			$("#password2show").text("两次输入密码不一致!");	
		}else{
			$("#password2show").empty();
			$("#pass2div").removeClass("form-active1");
			$("#password2show").attr("class","white");
			$("#pass2div").addClass("form-active2");
		}
	});
	
	$("#mobilePhone").focus(function(){
		$("#userdiv").removeClass("form-active1");
		$("#phoneShow").attr("class","white");
		$("#phoneShow").text("请填写手机号!");
    });
	
	$("#mobilePhone").blur(function(){
		if ($("#mobilePhone").val() == "") { 
				$("#userdiv").addClass("form-active1");
				$("#phoneShow").attr("class","red");
				$("#phoneShow").text("请填写手机号!");
				return false; 
			} 
			if (!isMobile($("#mobilePhone").val())) { 
				//if (!$("#mobilePhone").val().match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)&&!$("#mobilePhone").val().match(/^0?1[3|4|5|7|8][0-9]\d{8}$/)) { 
				$("#userdiv").addClass("form-active1");
				$("#phoneShow").attr("class","red");
				$("#phoneShow").text("请填写正确的手机号!");	
			return false; 
			} 

			checkUser();
			//$("#phoneShow").append("<p class='true'><span class='glyphicon glyphicon-ok'></span></p>");	
	});	
});

function check(){
	$("#phoneShow").text("");
	if(isMobile($("#mobilePhone").val())){
		checkUser();
	}
}

function checkUser(){
	$.ajax({  
        type: "post",  
        dataType:"json",
        url: "../register/checkUser",
        data: $('#form').serialize(),
        success: function(data) {  
           if(data!=200){
	   		   $("#userdiv").addClass("form-active1");
	   		   $("#phoneShow").attr("class","red");
	   		   $("#phoneShow").text("该手机号已经被注册!");
	   		   $("#bsend").attr("disabled",true);
	   		   return false;
           }else{
        	   $("#phoneShow").text('');
	   		   $("#userdiv").removeClass("form-active1");
	   		   $("#userdiv").addClass("form-active2");
	   		   $("#bsend").attr("disabled",false);
           }
        },  
        error: function(data) {  
//            alert(data);  
        }  
    }) ;
}

function validate(){

	if(!$("#protocol_").is(':checked')){
		showprotocol();
		
		return false;
	}
	
	if ($("#mobilePhone").val() == "") { 
		$("#phoneShow").attr("class","red");
		$("#phoneShow").text("请填写手机号!");
		//$("#email").focus(); 
		return false; 
		} 
		if (!isMobile($("#mobilePhone").val())) { 
		$("#phoneShow").attr("class","red");
		$("#phoneShow").html("请填写正确的手机号!");	
		//$("#email").focus(); 
		return false; 
		}
		

	if($("#verifycode").val()==""){
		$("#showvcode").attr("class","red");
		$("#showvcode").text("请填写验证码!");
		return false;
	}
	
	if($("#verifycode").val().length!=4){
		$("#showvcode").attr("class","red");
		$("#showvcode").text("验证码错误!");
		return false;
	}
	
	var pass1=$("#password").val().trim();
	var pass2=$("#confirmpassword").val().trim();
	
	if(pass1==""){
		
		$("#pass1div").addClass("form-active1");
		$("#passwordshow").attr("class","red");
		$("#passwordshow").text("请填写密码!");	
		
		//$("#password").focus();
		return false;
	}
	if(pass1.length<6||pass1.length>20){
		$("#passwordshow").attr("class","red");
		$("#passwordshow").text("密码长度为6-20长度的字符串!");
		//$("#password").focus();
		return false;
	}
	
	if(pass2==""){
			
			$("#pass2div").addClass("form-active1");
			$("#password2show").attr("class","red");
			$("#password2show").text("请填写确认密码!");	
			
			//$("#password").focus();
			return false;
		}
	
	if(pass1!=pass2){
		$("#password2show").attr("class","red");
		$("#password2show").text("两次输入密码不一致!");	
		//$("#confirmpassword").focus();
		return false;
	}

	
	$("#sbt").attr("disabled",true);
	var val =true;
    $.ajax({  
        type: "post",  
        dataType:"json",
        url: "../register/register",  
        data: $('#form').serialize(),
        success: function(data) {  
           if(data.code != 200){
        	   if(data.code==400){
		   			$("#userdiv").addClass("form-active1");
		   			$("#phoneShow").attr("class","red");
		   			$("#phoneShow").text(data.desc);
		   		//	$("#sbt").attr("disabled","");
        	   }else if(data.code==401){
        		   	$("#showvcode").attr("class","red");
        			$("#showvcode").text(data.desc);
        		//	$("#sbt").attr("disabled","");
        	   }
           }else {
        	  location.href="../loginInit";
           }
           $("#sbt").attr("disabled",false);
        },  
        error: function(data) {
        //	$("#sbt").attr("disabled","");
           // alert(data);  
        }  
      })  ;
	
}

function regist(){
	validate();
}
var vcode="-1";
var runControl = false;
function sendMessage(o){
	if(runControl==true){
		return;
	}
	runControl = true;
	if ($("#mobilePhone").val() == "") { 
		//$("#confirmMsg").html("<font color='red'>邮箱地址不能为空！</font>"); 
		//$("#userdiv").removeClass("form-active2");
		$("#userdiv").addClass("form-active1");
		$("#phoneShow").attr("class","red");
		$("#phoneShow").text("请填写手机号!");
		//$("#mobilePhone").focus(); 
		runControl = false;
		return false; 
	} 
	if (!isMobile($("#mobilePhone").val())){
		
		//$("#userdiv").removeClass("form-active2");
		$("#userdiv").addClass("form-active1");
		$("#phoneShow").attr("class","red");
		$("#phoneShow").text("请填写正确的手机号!");	
		//$("#mobilePhone").focus(); 
		runControl = false;
		return false; 
	}
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
           runControl = false;
        },  
        error: function(data) {  
        }  
    })  ;
}
var wait=60;
function time(o) {
    if (wait == 0) {
    	
    	$("#bsend").attr("disabled",false);
        //o.removeAttribute("disabled");  
        $("#bsend").text("免费获取验证码");
       // o.text="免费获取验证码";
        wait = 60;
    } else {
        //o.setAttribute("disabled", true);
        $("#bsend").attr("disabled",true);
        //o.text="重新发送(" + wait + ")";
        $("#bsend").text("重新发送  (" + wait + ")");
        wait--;
        setTimeout(function() {
            time(o);
        },
        1000);
    }
}
function showprotocol(){
	$(".big").show();
	$(".login-mask").show();
}

function closeprotocol(){
	$(".big").hide();
	$(".login-mask").hide();
}

function closeprotocolagree(){
	$("input[type='checkbox']").prop("checked",true);
	//$("#protocol_").attr("checked",true);
	$(".big").hide();
	$(".login-mask").hide();
	
}