//验证码计时器
var wait = 0;

$(function(){
	$("#defaultForm").validate({
		 rules:{
			 mobilePhone:{
				 required:true,
				 validateMobilePhone:true,
				 remote: {
				  	type: "post",  
				  	async: true,
				    dataType:"json",
				    url: "../security/verifyPhone",  
				  },
			 },
//			 verifycode:{
//				 required:true,
//				 remote: {
//				  	type: "post",  
//				  	async: true,
//				    dataType:"json",
//				    url: "../security/verifyCode", 
//				    data:{
//				    	mobilePhone:function(){return $("#mobilePhone").val();}
//				    }
//				  },
//			 }
		 },
		 messages:{
			 mobilePhone:{
				 validateMobilePhone:"请填写有效的11位手机号码",
				 remote:"该号码已被绑定",
			 },
//			 verifycode:{
//				 remote:"验证码不正确",
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
				  $(element).parent().removeClass("form-active2").addClass("form-active1");				  
			  }
		  },
		  unhighlight: function( element) {
			  if(!$(element).parent().hasClass("form-active2")){
				  $(element).parent().removeClass("form-active1").addClass("form-active2");
			  }
		  }
	});
	
	  $.validator.addMethod("validateMobilePhone", function(value, element) {
		  return isMobile(value);
	  });
	  
	  
	  
	  
	  $("#verifycodeBtn").on("click",function(){
		  noDbClick();
		  if(!isMobile($("#mobilePhone").val())){
			  $("#mobilePhone").parent().addClass("form-active1");	
			  return false;
		  }
		  wait = 60;
  	      time();//先倒计时再发送
		  $.ajax({  
		        type: "post",  
		        dataType:"json",
		        url: "../register/sendRegisterCode",
		        data: {mobilePhone:$("#mobilePhone").val()}, //TODO先填手机号
		        success: function(data) {
		           if(data!=200){
		        	   wait = 0;
		        	   time();
		           }else{
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
		        url: "../security/bindPhoneData",
		        data: $("#defaultForm").serialize(), 
		        success: function(data) {
		           if(data.code!=200){
		        	   if(data.code == 400){
			        	   $("#form-right").empty();
			        	   $("#form-right").html("<p class='false'>"+data.desc+"</p>");
		        	   }else{
		        		   $("#mobileShow").empty();
			        	   $("#mobileShow").html("<p class='false'>"+data.desc+"</p>");
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
	  if($("#mobilePhone").val() != ''){
		  setTimeout(function(){
			  $("#verifycodeBtn").attr("disabled",true);
		  },100);
	  }
  }
	  
});