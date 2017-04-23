	$(function () {
		
		//关闭展示
		$(".btnClose").click(function(){
			$(this).parents(".alertme").hide();
			$(this).parents(".alertme").find("dd b").parent().hide();
			$("div.maskme").hide();
		});
		
		//关闭展示
		$(".close2").click(function(){
			$(this).parents(".alertme").hide();
			$(this).parents(".alertme").find("dd b").parent().hide();
			$("div.maskme").hide();
		});
		
		//同意展示
		$("#divApprove").click(function(){
			$("div.maskme").show();
			$("div.approve").show();
		});
		
		var returnOrderId=$("#returnOrderId").val();
		
		//同意
		$("#btnApprove").click(function(){
			$.ajax({  
       	        type: "post",  
       	        dataType: "json",
       	        url: "../approve",
       	        data: {'returnOrderId':returnOrderId,
       	        	'logDetail':$("div.approve [name='logDetail']").val()},
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
		
		//拒绝展示
		$("#divRefuse").click(function(){
			$("div.maskme").show();
			$("div.refuse").show();
		});
		
		//拒绝
		$("#btnRefuse").click(function(){
			if($("div.refuse [name='reply']").val()==""){
				$("div.refuse dd b").html("原因不能为空！").parent().show();
				$("div.refuse [name='reply']").focus();
				return false;
			}
			$.ajax({  
       	        type: "post",  
       	        dataType: "json",
       	        url: "../refuse",
       	        data: {'returnOrderId':returnOrderId,
       	        	'logDetail':$("div.refuse [name='logDetail']").val(),
       	        	'reply':$("div.refuse [name='reply']").val()},
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
		
		//失败展示
		$("#divFail").click(function(){
			$("div.maskme").show();
			$("div.fail").show();
		});
		
		//失败
		$("#btnFail").click(function(){
			if($("div.fail [name='reply']").val()==""){
				$("div.fail dd b").html("原因不能为空！").parent().show();
				$("div.fail [name='reply']").focus();
				return false;
			}
			$.ajax({  
       	        type: "post",  
       	        dataType: "json",
       	        url: "../fail",
       	        data: {'returnOrderId':returnOrderId,
       	        	'logDetail':$("div.fail [name='logDetail']").val(),
       	        	'reply':$("div.fail [name='reply']").val()},
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
		
		//完成展示
		$("#divFinish").click(function(){
			$("div.maskme").show();
			$("div.finish").show();
		});
		
		//运费
		$("[name='refundSendMoney']").change(function(){
			if($(":checked[name='refundSendMoney']").val()==0){
				$("[name='returnMoney']").val("${orderGoods.unitPrice*orgReturnOrder.amount}");
				$("#returnSendMoney").val(0);
			}else if($(":checked[name='refundSendMoney']").val()==1){
				$("[name='returnMoney']").val("${orderGoods.unitPrice*orgReturnOrder.amount+order.sendMoney}");
				$("#returnSendMoney").val("${order.sendMoney}");
			}
		});
		
		//完成
		$("#btnFinish").click(function(){
			
			$(this).parents(".alertme").find("dd b").parent().hide();
			
			if($("div.finish [name='returnMoney']").val()==""){
				alert(111);
				$("#finish1 b").html("退款金额不能为空！").parent().show();
				$("div.finish [name='returnMoney']").focus();
				return false;
			}
			
			var pattern = /^\d+.\d{2}$/;
			if(!pattern.test($("div.finish [name='returnMoney']").val())){
				$("#finish1 b").html("退款金额格式错误！").parent().show();
				$("div.finish [name='returnMoney']").focus();
				return false;
			}
			
			var maxMeney = parseFloat(0.00);
			
			if($(":checked[name='refundSendMoney']").val()==0){
				maxMeney = parseFloat("${orderGoods.unitPrice*orgReturnOrder.amount}");
			}else if($(":checked[name='refundSendMoney']").val()==1){
				maxMeney = parseFloat("${orderGoods.unitPrice*orgReturnOrder.amount+order.sendMoney}");
			}
			
			if(parseFloat($("div.finish [name='returnMoney']").val()) > maxMeney){
				
				$("#finish1 b").html("退款金额超出限制！").parent().show();
				$("div.finish [name='returnMoney']").focus();
				return false;
			}
			
			if($("div.finish [name='returnMoney']").val()==""){
				$("#finish1 dd b").html("金额不能为空！").parent().show();
				$("div.finish [name='returnMoney']").focus();
				return false;
			}
			
			if($("div.finish [name='reply']").val()==""){
				$("#finish2 b").html("原因不能为空！").parent().show();
				$("div.finish [name='reply']").focus();
				return false;
			}
			$.ajax({  
       	        type: "post",  
       	        dataType: "json",
       	        url: "../finish",
       	        data: {'returnOrderId':returnOrderId,
       	        	'logDetail':$("div.finish [name='logDetail']").val(),
       	        	'reply':$("div.finish [name='reply']").val(),
       	        	'returnSendMoney':$("#returnSendMoney").val(),
       	        	'returnMoney':$("div.finish [name='returnMoney']").val()},
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
		
		//备注展示
		$("#divRemark").click(function(){
			$("div.maskme").show();
			$("div.remark").show();
		});
		
		//备注
		$("#btnRemark").click(function(){
			if($("div.remark [name='logDetail']").val()==""){
				$("div.remark dd b").html("备注不能为空！").parent().show();
				$("div.remark [name='logDetail']").focus();
				return false;
			}
			$.ajax({  
       	        type: "post",  
       	        dataType: "json",
       	        url: "../remark",
       	        data: {'returnOrderId':returnOrderId,'logDetail':$("div.remark [name='logDetail']").val()},
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
	});
	
