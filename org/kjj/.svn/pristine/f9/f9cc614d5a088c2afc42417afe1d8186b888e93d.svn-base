$(function(){
	$("#defaultForm").validate({
		 rules:{
			 oldPassword:{
				 required:true, 
				 remote: {
					  	type: "post",  
					  	async: true,
					    dataType:"json",
					    url: "../security/editPassword",  
					    data:{
					    	userId:$("#userId").val(),
					    }
				  }
			 },
			 password:{
				 required:true,
				 rangelength:[6,20],
			 },
			 confirmpass:{
				 required:true,
				 rangelength:[6,20],
				 equalTo:"#password",
			 },
		 },
		 messages:{
			 oldPassword:{
				 remote:"原密码不正确",
			 },
			 confirmpass:{
				 equalTo:"两次密码不一致",
			 },
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
	
});