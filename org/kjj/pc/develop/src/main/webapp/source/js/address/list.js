	$(function(){
		$('.address-list').click(function(){
			$(this).addClass('borderline').siblings('.address-list').removeClass('borderline');
		});
		
		$('.close').click(function(){
			$("#saveOrUpdate").val(0);
			$("#addwin").hide();
		});
		
	});
	function addAddress(){
		//clear old  content
		$('#btn').removeAttr("disabled");
		clear();
		$("#addwin").show();
	}
	
	function cancel(){
		$("#saveOrUpdate").val(0);
		$("#addwin").hide();
		clear();
	}
	function clear(){
		$("#consignee").val("");
		$("#address").val("");
		$("#mobile").val("");
		$("#telAreaCode").val("");
		$("#tel").val("");
		$("#email").val("");
		
		$("#consignee").next("b").remove();
		$("#address").next("b").remove();
		$("#tel").next("b").remove();
		$("#email").next("b").remove();
	}
	
	function save(){
		//验证收货人名称
		if($("#consignee").val().length<1||$("#consignee").val().length>60){
			$("#consignee").next("b").remove();
			$("#consignee").after(" <b>收货人姓名长度在1-60之间！</b>");
			return;
		}else{
			$("#consignee").next("b").remove();
		}
		
		if($("#sendRangeId").val()=='-1'){
			$("#address").next("b").remove();
			$("#address").after(" <b>请选择配送地址！</b>");
			return;
		}else{
			$("#address").next("b").remove();
		}
		
		if($("#address").val().length==0||$("#address").val().length>120){
			$("#address").next("b").remove();
			$("#address").after(" <b>详细地址长度在1-120之间！</b>");
			return;
		}else{
			$("#address").next("b").remove();
		}
		
		var mobile = $.trim($("#mobile").val());  
		var isMobile = /^0?1[3|4|5|7|8][0-9]\d{8}$/;  
	    var isPhone = /^(?:(?:0\d{2,3})-)?(?:\d{7,8})(-(?:\d{3,}))?$/;;  
	        
	    if(mobile.length !=0){
	    	 if (!isMobile.test(mobile)) {  
	    		 $("#tel").next("b").remove();
	                $("#tel").after(" <b>手机号码格式不正确</b>");  
	                $("#mobile").focus();  
	                return false;  
	            }else{
	            	$("#tel").next("b").remove();
	         }
	    }else{
	    	 $("#tel").next("b").remove();
             $("#tel").after(" <b>请填写手机号</b>");
	    	return false;
	    }
	      
	    var tel_code = $.trim($("#telAreaCode").val());
	    var tel = $.trim($("#tel").val());
	    
	    if(tel_code.length!=0&&tel.length!=0){
	    	
	    	 if (!isPhone.test(tel_code+"-"+tel)) {  
	    		 $("#tel").next("b").remove();
	                $("#tel").after(" <b>电话号码格式不正确</b>");  
	                $("#tel").focus();  
	                return false;  
	            } else{
	            	$("#tel").next("b").remove(); 
	            }
	    }
	    
	    if(mobile.length==0&&(tel_code==0||tel.length==0)){
	    	$("#tel").next("b").remove();
	    	 $("#tel").after(" <b>手机或电话必须填写一项</b>");  
             $("#mobile").focus();  
             return false; 
	    }
	    
	    var email = $("#email").val();
	    if(email.length>0){
	    	
	    	if(/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(email) == false){
	    		$("#email").next("b").remove();
	    		$("#email").after(" <b>邮箱格式不正确</b>");  
	    		$("#email").focus();  
	    		
	    		return;
	    	}else{
	    		$("#email").next("b").remove();
	    	}
	    }
	    
	    $('#btn').attr('disabled',"true");
	   
	   var edit=$("#saveOrUpdate").val();
	   if(edit==0){
		   //提交代码
			$.ajax({  
			    type: "post",  
			    dataType:"json",
			    url: "../address/add",  
			    data: $('#addform').serialize(),
			    success: function(data) {  
			       if(data.code==200){
			    	   // showBox();
			    	   location.reload();
			       }
			    },  
			    error: function(data) {  
			    	location.reload();
			    }  
			})  ; 
	   }else{
		   $.ajax({  
			    type: "post",  
			    dataType:"json",
			    url: "../address/edit",  
			    data: $('#addform').serialize(),
			    success: function(data) {  
			       if(data.code==200){
			    	 // showBox();
			    	 location.reload();
			       }
			    },  
			    error: function(data) {  
			    	location.reload();
			    }  
			})  ; 
	   }
	}
	
	function edit(a){
		$('#btn').removeAttr("disabled");
		$("#saveOrUpdate").val(1);
		$.ajax({  
		    type: "post",  
		    dataType:"json",
		    url: "../address/editInit/"+a,  
		    success: function(data) {  
		       if(data.code=="200"){
		    	$("#addwin").show();
		    	$("#consignee").val(data.orgUserAddress.consignee);
		   		$("#address").val(data.orgUserAddress.address);
		   		$("#mobile").val(data.orgUserAddress.mobile);
		   		$("#telAreaCode").val(data.orgUserAddress.telAreaCode);
		   		$("#tel").val(data.orgUserAddress.tel);
		   		$("#email").val(data.orgUserAddress.email);
		    	$("#addressId").val(data.orgUserAddress.addressId);
		    	
		    	$("#s1").text(data.orgUserAddress.area[0]);
		    	$("#s2").text(data.orgUserAddress.area[1]);
		    	$("#s3").text(data.orgUserAddress.area[2]);
		    	$("#s4").text(data.orgUserAddress.shopName);
		    	
		    	$("#sendRangeId").empty();
		    	var str="<option value=\"-1\">请选择</option>";
		    	
		    	$.each(data.orgUserAddress.listSendRange,function(n,value){
		    		
		    		if(data.orgUserAddress.sendRangeId==value.id){
		    			str+="<option value=\""+value.id+"\" selected >"+value.sendRangeName+"</option>";
		    		}else{
		    			str+="<option value=\""+value.id+"\">"+value.sendRangeName+"</option>";
		    		}
		    	});
		    	$("#sendRangeId").append(str);
		    	
		       }else{
		    	   //当前地址已经被删掉
		    	   location.reload(); 
		       }
		    },  
		    error: function(data) {  
		    }  
		})  ;
	}
	
	function del(a){
		$.ajax({  
		    type: "post",  
		    dataType:"json",
		    url: "../address/delete/"+a,  
		    success: function(data) {  
		       if(data==200){
		    	   //showBox();
		    	   location.reload();
		       }
		    },  
		    error: function(data) {  
		    }  
		})  ;
	}
	function showBox(){
		$("#addwin").hide();
		$(".kjj").show();
		 setTimeout(function () {
			 showeidt();
		    }, 2000);
	}

	function showeidt(){
		$(".kjj").hide();
		location.reload();
	}
	function closeBox(){
		$(".kjj").hide();
	}
