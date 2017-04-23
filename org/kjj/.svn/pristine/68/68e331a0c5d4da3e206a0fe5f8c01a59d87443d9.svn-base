//验证码计时器
var wait = 0;

$(function(){
	$("#defaultForm").validate({
		 rules:{
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
	
	  $("#verifycodeBtn").on("click",function(){
		  noDbClick();
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
		        url: "../security/verifyPhoneCode",
		        data: $("#defaultForm").serialize(), 
		        success: function(data) {
		           if(data.code!=200){
		        	   $("#form-right").empty();
		        	   $("#form-right").html("<p class='false'>"+data.desc+"</p>");
		           }else{
		        	   window.location='../security/bindNewMobilePhone';
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