//验证码计时器
var wait = 0;
$(function(){
	$("#defaultForm").validate({
		 rules:{
			 email:{
				 required:true,
				 email:true,
				 remote: {
				  	type: "post",  
				  	async: true,
				    dataType:"json",
				    url: "../security/verifyEmail",  //验证邮箱号是否被绑定,输入即被验证，相当于onblur事件
				  },
			 },
//			 verifycode:{
//				 required:true,
//				 remote: {
//				  	type: "post",  
//				  	async: true,
//				    dataType:"json",
//				    url: "../security/verifyEmailCode", //验证输入的验证码是否正确和是否过期（是否和收到的一致）
//				    data:{
//				    	email:function(){return $("#email").val();}
//				    }
//				  },
//			 }
		 },
		 messages:{
			 email:{
				 validateEmail:"请输入正确的电子邮件地址",
				 remote:"该邮箱已被绑定",
			 }
//		 ,
//			 verifycode:{
//				 remote:"验证码错误",
//			 }
		 },
		 errorClass:"false",
		 errorElement:"p",
		 errorPlacement: function(error,element) {   
			  element.parents(".form-list").find(".form-right").empty();
			  error.appendTo(element.parents(".form-list").find(".form-right"));
		  },
		  highlight: function(element) {
			  if(!$(element).parent().hasClass("form-active1")){
				  $(element).parent().removeClass("form-active2").addClass("form-active");				  
			  }
		  },
		  unhighlight: function( element) {
			  if(!$(element).parent().hasClass("form-active2")){
				  $(element).parent().removeClass("form-active1").addClass("form-active2");
			  }
		  }
	});
	
	  $.validator.addMethod("validateEmail", function(value, element) {
		  return isEmail(value);
	  });
	  
	  
	  $("#verifycodeBtn").on("click",function(){
		  noDbClick();//禁止双击，以免一次发送两次验证码
		  if(!isEmail($("#email").val())){
			  $("#email").parent().addClass("form-active1");	
			  return false;
		  }
		  wait = 60;
  	      time();//先倒计时再发送
		  $.ajax({  
		        type: "post",  
		        dataType:"json",
		        url: "../security/sendEmailCode",
		        data: {email:$("#email").val()}, 
		        success: function(data) { 
		           if(data!=200){
		        	   wait = 0;
		        	   time();
		           }
		        },  
		        error: function(data) {  
		        }  
		    });
		  
	  });
	  
	  $("#submitBtn").on("click",function(){
		  var verifycode = $("#verifycode").val().trim();
		  if("" == verifycode){
			  $("#form-right").empty();
			  $("#form-right").html("<p class='false'>验证码不能为空</p>");
			   return false;
		       }
		  $.ajax({  
		        type: "post",  
		        dataType:"json",
		        url: "../security/bindEmailData",
		        data: $("#defaultForm").serialize(), 
		        success: function(data) {  
		           if(data.code != 200){
		        	   if(data.code == 400){
			        	   $("#form-right").empty();
			        	   $("#form-right").html("<p class='false'>"+data.desc+"</p>");
		        	   }else{
		        		   $("#emailShow").empty();
			        	   $("#emailShow").html("<p class='false'>"+data.desc+"</p>");
		        	   }
		           }else{
		        	   window.location='../security/desc';
		           }
		        },  
		        error: function(data) {  
		        }  
		    });
		  
	  });
	  
  function time() {
      if (wait == 0) {
      	  $("#verifycodeBtn").attr("disabled",false);
          $("#verifycodeBtn").text("免费获取验证码");
      } else {
          $("#verifycodeBtn").attr("disabled",true);
          $("#verifycodeBtn").text("重新发送  (" + wait + ")");
          wait--;
          setTimeout(function() {
              time();
          },1000);
      }
  }
  
  function noDbClick(){
	  if($("#email").val() != ''){
		  setTimeout(function(){
			  $("#verifycodeBtn").attr("disabled",true);
		  },100);
	  }
  }
	  
});