$(function(){
	  $("#defaultForm").validate({
		  rules:{
			  userName:{
				  required:true,
				  rangelength:[4,20],
				  validateNumber: true,
				  validateUserName:true,
				  remote: {
					  	type: "post",  
					  	async: true,
					    dataType:"json",
					    url: "../security/editUserName",  
					    data:{
					    	userId:$("#userId").val(),
					    }
				  },
			  }
		  },
		  messages:{
			  userName:{
				  validateNumber:"不能是纯数字",
				  validateUserName:"只能由字母、数字、汉字、\"-\"、\"_\"组成",
				  remote:"用户名已经被注册",
			  }
		  },
		  errorClass:"false",
		  errorElement:"p",
		  errorPlacement: function(error,element) {  
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
	  
	  $.validator.addMethod("validateUserName", function(value, element) {
		  return isUserName(value);
	  });
	  
	  $.validator.addMethod("validateNumber", function(value, element) {
		  return !isNumber(value);
	  });
	  
	  
	  
});