$(function(){
	//区域省下拉列表选择变更
	$("#provinceCode").change(function(){
		if($('#provinceCode').val() == -1){
			$('#cityCode').empty();
          	$('#cityCode').append("<option value='-1'>请选择市</option>");
		}else{
			$.ajax({
	            type: "POST",
	            dataType: "json",
	            url: "../area/getByParentCode",
	            data: {'parentCode':$('#provinceCode').val()},
	            success: function (data) {
	           	 $('#cityCode').empty();
	           	 $('#cityCode').append("<option value='-1'>请选择市</option>");
	                $.each(data.listArea,function(idx, obj){
	               	 $('#cityCode').append("<option value=\""+obj.code+"\">"+obj.name+"</option>");
	                }); 
	            },
	            error: function(data) {
	            }
	        });
		}
		$('#countyCode').empty();
      	$('#countyCode').append("<option value='-1'>请选择区或县</option>");
	});
	
	//区域市下拉列表选择变更
	$("#cityCode").change(function(){
		if($('#cityCode').val() == -1){
          	$('#countyCode').empty();
          	$('#countyCode').append("<option value='-1'>请选择区或县</option>");
		}else{
			$.ajax({
	            type: "POST",
	            dataType: "json",
	            url: "../area/getByParentCode",
	            data: {'parentCode':$('#cityCode').val()},
	            success: function (data) {
	            	$('#countyCode').empty();
	           	 	$('#countyCode').append("<option value='-1'>请选择区或县</option>");
	           	 	$.each(data.listArea,function(idx, obj){
                	$('#countyCode').append("<option value=\""+obj.code+"\">"+obj.name+"</option>");
                 }); 
	            },
	            error: function(data) {
	            }
	        });
		}
	});
	// 公司名称
	$("#enterpriseName").focus(function(){
		$("#enterpriseNameTip").empty();
		$("#enterpriseNamediv").removeClass("form-active1");
		$("#enterpriseNamediv").removeClass("form-active2");
		$("#enterpriseNameTip").removeClass("false");
    });
	$("#enterpriseName").blur(function(){
		if($("#enterpriseName").val() == "") { 
			$("#enterpriseNameTip").empty();
			$("#enterpriseNameTip").addClass("false");
			$("#enterpriseNamediv").addClass("form-active1");
			$("#enterpriseNameTip").append("请填写公司名称！");
			failNum++;
			return false; 
		}
		
		if($("#enterpriseName").val().length < 4){
			$("#enterpriseNameTip").empty();
			$("#enterpriseNameTip").addClass("false");
			$("#enterpriseNamediv").addClass("form-active1");
			$("#enterpriseNameTip").append("公司名称长度只能在4-40位字符之间！");
			failNum++;
			return false;
		}

		$("#enterpriseNameTip").empty();
		$("#enterpriseNamediv").removeClass("form-active1");
		$("#enterpriseNameTip").removeClass("false");
		
		$("#enterpriseNamediv").addClass("form-active2");
		$.ajax({  
	        type: "post",  
	        dataType:"json",
	        url: "../register/checkEnterpriseName",
	        data: {'enterpriseName':$('#enterpriseName').val(),'enterpriseId':$('#enterpriseId').val()},
	        success: function(data) {  
	           if(data!=200){
	        	   $("#enterpriseNameTip").empty();
	   			   $("#enterpriseNameTip").addClass("false");
	   			   $("#enterpriseNamediv").removeClass("form-active2");
	   			   $("#enterpriseNamediv").addClass("form-active1");
		   		   $("#enterpriseNameTip").append("该企业名称已被使用，请重新输入！");
		   		   failNum++;
	           }else{
	        	   $("#enterpriseNameTip").empty();
	           }
	        },  
	        error: function(data) {  
	            alert(data);  
	        }
	    });
	});	
	// 区域
	$("#provinceCode").focus(function(){
		$("#countyTip").empty();
		$("#countydiv").removeClass("form-active1");
		$("#countydiv").removeClass("form-active2");
		$("#countyTip").removeClass("false");
    });
	$("#provinceCode").blur(function(){
		if($("#provinceCode").val() == "-1") { 
			$("#countyTip").empty();
			$("#countyTip").addClass("false");
			$("#countydiv").addClass("form-active1");
			$("#countyTip").append("请选择省或者市！");
			failNum++;
			return false; 
		}

		$("#countyTip").empty();
		$("#countydiv").removeClass("form-active1");
		$("#countyTip").removeClass("false");
	});
	$("#cityCode").focus(function(){
		$("#countyTip").empty();
		$("#countydiv").removeClass("form-active1");
		$("#countydiv").removeClass("form-active2");
		$("#countyTip").removeClass("false");
    });
	$("#cityCode").blur(function(){
		if($("#cityCode").val() == "-1") { 
			$("#countyTip").empty();
			$("#countyTip").addClass("false");
			$("#countydiv").addClass("form-active1");
			$("#countyTip").append("请选择省或者市！");
			failNum++;
			return false; 
		}

		$("#countyTip").empty();
		$("#countydiv").removeClass("form-active1");
		$("#countyTip").removeClass("false");
	});
	$("#countyCode").focus(function(){
		$("#countyTip").empty();
		$("#countydiv").removeClass("form-active1");
		$("#countydiv").removeClass("form-active2");
		$("#countyTip").removeClass("false");
    });
	$("#countyCode").blur(function(){
		if($("#countyCode").val() == "-1") { 
			$("#countyTip").empty();
			$("#countyTip").addClass("false");
			$("#countydiv").addClass("form-active1");
			$("#countyTip").append("请选择省或者市！");
			failNum++;
			return false; 
		}

		$("#countyTip").empty();
		$("#countydiv").removeClass("form-active1");
		$("#countyTip").removeClass("false");
	});
	// 公司地址
	$("#address").focus(function(){
		$("#addressTip").empty();
		$("#addressdiv").removeClass("form-active1");
		$("#addressdiv").removeClass("form-active2");
		$("#addressTip").removeClass("false");
    });
	$("#address").blur(function(){
		if($("#address").val() == "") { 
			$("#addressTip").empty();
			$("#addressTip").addClass("false");
			$("#addressdiv").addClass("form-active1");
			$("#addressTip").append("请填写公司详细地址！");
			failNum++;
			return false; 
		}
		
		if($("#address").val().length < 4){
			$("#addressTip").empty();
			$("#addressTip").addClass("false");
			$("#addressdiv").addClass("form-active1");
			$("#addressTip").append("公司详细地址长度只能在4-50位字符之间！");
			failNum++;
			return false;
		}

		$("#addressTip").empty();
		$("#addressdiv").removeClass("form-active1");
		$("#addressTip").removeClass("false");
		
		$("#addressdiv").addClass("form-active2");
	});	
	// 联系人姓名
	$("#contactName").focus(function(){
		$("#contactNameTip").empty();
		$("#contactNamediv").removeClass("form-active1");
		$("#contactNamediv").removeClass("form-active2");
		$("#contactNameTip").removeClass("false");
    });
	$("#contactName").blur(function(){
		if($("#contactName").val() == "") { 
			$("#contactNameTip").empty();
			$("#contactNameTip").addClass("false");
			$("#contactNamediv").addClass("form-active1");
			$("#contactNameTip").append("请填写联系人姓名！");
			failNum++;
			return false; 
		}
		
		if($("#contactName").val().length < 2){
			$("#contactNameTip").empty();
			$("#contactNameTip").addClass("false");
			$("#contactNamediv").addClass("form-active1");
			$("#contactNameTip").append("联系人姓名长度只能在2-20位字符之间！");
			failNum++;
			return false;
		}

		$("#contactNameTip").empty();
		$("#contactNamediv").removeClass("form-active1");
		$("#contactNameTip").removeClass("false");
		
		$("#contactNamediv").addClass("form-active2");
	});	
	// 所在部门
	$("#department").focus(function(){
		$("#departmentTip").empty();
		$("#departmentdiv").removeClass("form-active1");
		$("#departmentdiv").removeClass("form-active2");
		$("#departmentTip").removeClass("false");
    });
	$("#department").blur(function(){
		if($("#department").val() == "-1") { 
			$("#departmentTip").empty();
			$("#departmentTip").addClass("false");
			$("#departmentdiv").addClass("form-active1");
			$("#departmentTip").append("请选择所在部门！");
			failNum++;
			return false; 
		}

		$("#departmentTip").empty();
		$("#departmentdiv").removeClass("form-active1");
		$("#departmentTip").removeClass("false");
	});
	// 固定电话
	$("#landlines").focus(function(){
		$("#landlinesTip").empty();
		$("#landlinesdiv").removeClass("form-active1");
		$("#landlinesdiv").removeClass("form-active2");
		$("#landlinesTip").removeClass("false");
    });
	$("#landlines").blur(function(){
		if($("#landlines").val() == "") { 
			$("#landlinesTip").empty();
			$("#landlinesTip").addClass("false");
			$("#landlinesdiv").addClass("form-active1");
			$("#landlinesTip").append("请填写固定电话！");
			failNum++;
			return false; 
		}
		
		if(!fixPhone($("#landlines").val())){
			$("#landlinesTip").empty();
			$("#landlinesTip").addClass("false");
			$("#landlinesdiv").addClass("form-active1");
			$("#landlinesTip").append("固定电话格式错误,例如 “010-67788656”");
			failNum++;
			return false;
		}

		$("#landlinesTip").empty();
		$("#landlinesdiv").removeClass("form-active1");
		$("#landlinesTip").removeClass("false");
		
		$("#landlinesdiv").addClass("form-active2");
	});	
	// 联系人邮箱
	$("#contactEmail").focus(function(){
		$("#contactEmailTip").empty();
		$("#contactEmaildiv").removeClass("form-active1");
		$("#contactEmaildiv").removeClass("form-active2");
		$("#contactEmailTip").removeClass("false");
    });
	$("#contactEmail").blur(function(){
		if($("#contactEmail").val() == "") { 
			$("#contactEmailTip").empty();
			$("#contactEmailTip").addClass("false");
			$("#contactEmaildiv").addClass("form-active1");
			$("#contactEmailTip").append("请填写联系人邮箱！");
			failNum++;
			return false; 
		}
		
		if(!isEmail($("#contactEmail").val())){
			$("#contactEmailTip").empty();
			$("#contactEmailTip").addClass("false");
			$("#contactEmaildiv").addClass("form-active1");
			$("#contactEmailTip").append("联系人邮箱格式错误！");
			failNum++;
			return false;
		}

		$("#contactEmailTip").empty();
		$("#contactEmaildiv").removeClass("form-active1");
		$("#contactEmailTip").removeClass("false");
		
		$("#contactEmaildiv").addClass("form-active2");
	});	
});
var failNum = 0;
function regist(){
	failNum = 0;
	validate();
	
	if(failNum > 0){
		return;
	}
	$("#mySubmit").attr("disabled",true);
	$.ajax({  
        type: "post",  
        dataType:"json",
        url: "../register/updateEnterprise",
        data: $('#enterpriseEditForm').serialize(),
        success: function(data) {  
        	if(data.code != 200){
        		
            }else {
        	  alert("信息提交成功！");
        	  location.href="../security/desc";
            }
        	$("#mySubmit").attr("disabled",false);
        },  
        error: function(data) {  
            alert(data);  
        }  
    });
}
function validate(){
	$("#userName").blur();
	$("#enterpriseName").blur();
	$("#provinceCode").blur();
	$("#cityCode").blur();
	$("#countyCode").blur();
	$("#address").blur();
	$("#contactName").blur();
	$("#department").blur();
	$("#landlines").blur();
	$("#contactEmail").blur();
}
// 固定电话验证
function fixPhone(value){
	var isFixPhone =/^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/;
	return isFixPhone.test(value);
}