	$(function () {
		
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
		
		//取消
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
       	        url: "../../order/solveCancel",
       	        data: {'id':$("#id").val(),'orderId':$("#orderId").val(),'reason':reason},
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
       	        url: "../../order/remark",
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
		
		
		//转门店
		$("#btnShop").click(function(){
			$.ajax({  
       	        type: "post",  
       	        dataType: "json",
       	        url: "../../order/solve2Shop",
       	        data: {'id':$("#id").val(),'orderId':$("#orderId").val(),'remark':$('#logDetail').val()},
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
       	        url: "../../order/consignee",
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