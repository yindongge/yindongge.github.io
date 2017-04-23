	$(function () {
        //禁止显示
        $("#btnDisplay").click(function(){
       		$.ajax({  
       	        type: "post",  
       	        dataType: "json",
       	        url: "../hidden/"+$("#goodsCommentId").val(),
       	        success: function(data) {
       	        	if(data.code==200){
       	        		$("#btnDisplay").hide();
       	        		$("#btnShow").show();
       	        	}
       	        },  
       	        error: function(data) {  
       	        	alert("系统异常"); 
       	        }  
       	    })  ; 
		});
        //显示
        $("#btnShow").click(function(){
       		$.ajax({  
       	        type: "post",  
       	        dataType: "json",
       	        url: "../show/"+$("#goodsCommentId").val(),
       	        success: function(data) {
       	        	if(data.code==200){
       	        		$("#btnShow").hide();
       	        		$("#btnDisplay").show();
       	        	}
       	        },  
       	        error: function(data) {  
       	            alert("系统异常");  
       	        }  
       	    })  ; 
		});
        
        //评论
        $("#btnReply").click(function(){
        	if($("#reply").val()==""){
        		alert("回复不能为空！");
        		return false;
        	}
       		$.ajax({  
       	        type: "post",  
       	        dataType: "json",
       	        url: "../reply",
       	        data:{"id":$("#goodsCommentId").val(),"reply":$("#reply").val()},
       	        success: function(data) {
       	        	if(data.code==200){
       	        		$("#divReply").hide();
       	        		$("#reply").prop("readonly",true);
       	        	}
       	        },  
       	        error: function(data) {  
       	            alert("系统异常");  
       	        }  
       	    })  ; 
		});
        
        //重置
        $("#btnCancel").click(function(){
        	$("#reply").val("");
		});
        
	});