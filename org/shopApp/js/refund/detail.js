 
	$(function () {
		//完成
		$("#btnFinish").click(function(){
			$.ajax({  
       	        type: "post",  
       	        dataType: "json",
       	        url: "../finish",
       	        data: {'refundOrderId':$("#refundOrderId").val(),'remark':$('#remark').val()},
       	        success: function(data) {
       	        	if(data.code==200){
       	        		location.reload();
       	        	}else{
       	        		alert(data.desc);
       	        	}
       	        },  
       	        error: function(data) {  
       	        	alert("系统错误");   
       	        }  
       	    })  ; 
		});
	});