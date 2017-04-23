$(function () {
		
		//退货
		$("#btnReturn").click(function(){
			location.href="../../return/addInit/"+$('#orderId').val();
		});
		
		//确认
		$("#btnConfirm").click(function(){
			if(confirm("确定要确认订单么？")){
				$.ajax({  
	       	        type: "post",  
	       	        dataType: "json",
	       	        url: "../confirm",
	       	        data: {'orderId':$('#orderId').val(),'logDetail':$('#logDetail').val()},
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
			}
		});
		
		//打开取消面板
		$("#btnCancel").click(function(){
			$("div.maskme").show();
			$("#divCancel").show();
		});
		
		//关闭取消面版
		$("#btnCancelCancel").click(function(){
			$("#divCancel").hide();
			$("div.maskme").hide();
			$('#reasonCancel').val("-1");
			$("#divCancel").find("dd b").parent().hide();
			$('#reasonCancel').parent().show();
			$('#reasonCancelUser').parent().hide();
		});
		
		//自定义取消原因
		$("#reasonCancel").change(function(){
			if($("#reasonCancel :selected").val()=='自定义…'){
				$('#reasonCancel').parent().hide();
				$("#divCancel").find("dd b").parent().hide();
				$('#reasonCancelUser').parent().show();
			}
		});
		$("#btnCancelFinish").click(function(){
			var reason = '';
			if($('#reasonCancel').is(":visible")){
				reason = $('#reasonCancel').val();
				if(reason=="-1"){
					$("#divCancel dd b").html("请选择原因！").parent().show();
					$("#reasonCancel").focus();
					return false;
				}
			}else if($('#reasonCancelUser').is(":visible")){
				reason = $('#reasonCancelUser').val();
				if($("#reasonCancelUser").val()==""){
					$("#divCancel dd b").html("请填写自定义原因！").parent().show();
					$("#reasonCancelUser").focus();
					return false;
				}
			}
			$.ajax({  
       	        type: "post",  
       	        dataType: "json",
       	        url: "../cancel",
       	        data: {'orderId':$('#orderId').val(),'logDetail':reason},
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
		
		
		//发送
		$("#btnSend").click(function(){
			if(confirm("确定要发送订单么？")){
				$.ajax({  
	       	        type: "post",  
	       	        dataType: "json",
	       	        url: "../sendOrTake",
	       	        data: {'orderId':$('#orderId').val(),'logDetail':$('#logDetail').val()},
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
			}
		});
		
		//自提
		$("#btnTake").click(function(){
			if(confirm("确定可以自提么？")){
				$.ajax({  
	       	        type: "post",  
	       	        dataType: "json",
	       	        url: "../sendOrTake",
	       	        data: {'orderId':$('#orderId').val(),'logDetail':$('#logDetail').val()},
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
			}
		});
		
		//关闭完成面版
		$(".close2").click(function(){
			$("#takeCode").val("");
			$("#divTake").hide();
			$("#divTake").find("dd b").parent().hide();
			$("div.maskme").hide();
		});
		
		//完成
		$("#btnFinish").click(function(){
			if($("#sendStyle").val()==0){
				if(confirm("确定订单完成了么？")){
					//送货上门
					$.ajax({  
		       	        type: "post",  
		       	        dataType: "json",
		       	        url: "../finish",
		       	        data: {'orderId':$('#orderId').val(),'logDetail':$('#logDetail').val()},
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
				}
			}else{
				//自提
				$("div.maskme").show();
				$("#divTake").show();
			}
		});
		
		//自提完成
		$("#btnTakeFinish").click(function(){
			
			if($("#takeCode").val()==""){
				$("#divTake dd b").html("提货码不能为空！").parent().show();
				$("#takeCode").focus();
				return false;
			}
			
			//送货上门
			$.ajax({  
       	        type: "post",  
       	        dataType: "json",
       	        url: "../finish",
       	        data: {'orderId':$('#orderId').val(),'logDetail':$('#logDetail').val(),'takeCode':$('#takeCode').val()},
       	        success: function(data) {
       	        	if(data.code==200){
       	        		location.reload();
       	        	}else{
       	        		$("#divTake dd b").html("提货码错误！").parent().show();
       					$("#takeCode").focus();
       	        	}
       	        },  
       	        error: function(data) {  
       	        	alert("系统错误"); 
       	        }  
       	    })  ; 
			
		});
		
		//备注
		$("#btnRemark").click(function(){
			if($('#logDetail').val()==""){
				alert("备注为空");
				$('#logDetail').focus();
				return false;
			}
			$.ajax({  
       	        type: "post",  
       	        dataType: "json",
       	        url: "../remark",
       	        data: {'orderId':$('#orderId').val(),'logDetail':$('#logDetail').val()},
       	        success: function(data) {
       	        	if(data.code==200){
       	        		location.reload();
       	        	}
       	        },  
       	        error: function(data) {  
       	        	alert("系统错误"); 
       	        }  
       	    })  ; 
		});
		
		//修改收货地址
		$("#btnConsignee").click(function(){
			$.ajax({  
       	        type: "post",  
       	        dataType: "json",
       	        url: "../consignee",
       	        data: {'orderId':$('#orderId').val(),'consignee':$('#consignee').val(),
       	        	'consigneeMobile':$('#consigneeMobile').val(),'consigneeTel':$('#consigneeTel').val(),
       	        	'consigneeAddress':$('#consigneeAddress').val(),'consigneeEmail':$('#consigneeEmail').val(),
       	        	},
       	        success: function(data) {
       	        	if(data.code==200){
       	        		alert("修改成功");
       	        	}else{
       	        		alert(data.desc);
       	        	}
       	        },  
       	        error: function(data) {  
       	        	alert("系统错误");  
       	        }  
       	    })  ; 
		});
		
		//打开转客服面板
		$("#btnSolve").click(function(){
			$("div.maskme").show();
			$("#divSolve").show();
		});

		//关闭转客服面版
		$("#btnSolveCancel").click(function(){
			$("#divSolve").hide();
			$("div.maskme").hide();
			$("#divSolve").find("dd b").parent().hide();
		});

		//转客服
		$("#btnSolveFinish").click(function(){
			var reason = $('#reasonSolveUser').val();
			if($("#reasonSolveUser").val()==""){
				$("#divSolve dd b").html("请填写自定义原因！").parent().show();
				$("#reasonSolveUser").focus();
				return false;
			}
			$.ajax({  
			        type: "post",  
			        dataType: "json",
			        url: "../solve2Server",
			        data: {'orderId':$('#orderId').val(),'remark':$('#logDetail').val(),'reason':reason},
			        success: function(data) {
			        	if(data.code==200){
			        		location.href="../list";
			        	}
			        },  
			        error: function(data) {  
			        	alert("系统错误"); 
			        }  
			    })  ; 
		});		
		
		if($("#sendStyle").val()==0){
			//校验送货改地址
			$("#formConsignee").bootstrapValidator({
				message : 'This value is not valid',
				feedbackIcons : {
					valid : 'glyphicon glyphicon-ok',
					invalid : 'glyphicon glyphicon-remove',
					validating : 'glyphicon glyphicon-refresh'
				},
				submitButtons : '#btnConsignee',
				fields: {
					consigneeEmail: {
		                validators: {
		                    emailAddress: {
		                        message: 'E-mail格式错误'
		                    }
		                }
		            },
		            consigneeMobile: {
		                validators: {
				            callback: {
			                    message: '手机电话最少填写一个',
			                    callback: function(value, validator) {
			                    	validator.updateStatus('consigneeTel', 'NOT_VALIDATED');
			                        return $("#consigneeMobile").val()!=''|| $("#consigneeTel").val()!='';
			                    }
			                }
		                }
		            },
		            consigneeTel: {
		                validators: {
				            callback: {
			                    message: '手机电话最少填写一个',
			                    callback: function(value, validator) {
			                    	validator.updateStatus('consigneeMobile', 'NOT_VALIDATED');
			                        return $("#consigneeMobile").val()!=''|| $("#consigneeTel").val()!='';
			                    }
			                }
		                }
		            }
			   }
			});
		}
		if($("#sendStyle").val()==1){
			//校验自提改地址
			$("#formConsignee").bootstrapValidator({
				message : 'This value is not valid',
				feedbackIcons : {
					valid : 'glyphicon glyphicon-ok',
					invalid : 'glyphicon glyphicon-remove',
					validating : 'glyphicon glyphicon-refresh'
				},
				submitButtons : '#btnConsignee',
				fields: {
					consigneeEmail: {
		                validators: {
		                    emailAddress: {
		                        message: 'E-mail格式错误'
		                    }
		                }
		            }
			   }
			});
		}
});

		