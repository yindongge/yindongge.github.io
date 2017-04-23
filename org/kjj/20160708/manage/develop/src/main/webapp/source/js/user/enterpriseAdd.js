$(function () {
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
	new uploadPreview({ UpBtn: "file_organizationCodeImg", DivShow: "div_organizationCodeImg", ImgShow: "showimg_organizationCodeImg"});
	new uploadPreview({ UpBtn: "file_businessLicenImg", DivShow: "div_businessLicenImg", ImgShow: "showimg_businessLicenImg"});
});

function validateUserName(){
	var currUserName = $('#userName').val();
	if("" == currUserName){
		$('#validateUserNameSpan').html("<font style=\"font-size:12px;color:red\">请输入用户名再验证！</font>");
		$('#userName').focus();
		return;
	}
	
	$.ajax({
		type : "POST",
		dataType : "json",
		url : "../enterprise/validateUserName",
		data: {'userName':$('#userName').val()},
		success : function(data) {
			if (data.code == 200) {
				$('#validatedName').val(currUserName);
				$('#validateUserNameSpan').html("<font style=\"font-size:12px;color:red\">用户名验证通过！</font>");
			} else {
				$('#validateUserNameSpan').html("<font style=\"font-size:12px;color:red\">用户名验证失败，请重新填写并验证！</font>");
				$('#userName').focus();
			}
		},
		error : function(data) {
			alert("操作失败，请联系管理员或技术人员!");  
		}
	});
}
function validateEnterpriseName(){
	var currUserName = $('#enterpriseName').val();
	if("" == currUserName){
		$('#validateEnterpriseNameSpan').html("<font style=\"font-size:12px;color:red\">请输入企业名称再验证！</font>");
		$('#enterpriseName').focus();
		return;
	}
	
	$.ajax({
		type : "POST",
		dataType : "json",
		url : "../enterprise/validateEnterpriseName",
		data: {'enterpriseName':$('#enterpriseName').val()},
		success : function(data) {
			if (data.code == 200) {
				$('#validateEnterpriseNameSpan').html("<font style=\"font-size:12px;color:red\">目前没有同名企业</font>");
			} else {
				$('#validateEnterpriseNameSpan').html("<font style=\"font-size:12px;color:red\">同名企业已经存在，请确认企业名称是否正确！</font>");
				$('#enterpriseName').focus();
			}
		},
		error : function(data) {
			alert("操作失败，请联系管理员或技术人员!");  
		}
	});
	
}
function cancle(){
	window.location.href="../enterprise/list";
}
function savedata(){
	// 验证必填项
	if($("#validatedName").val().trim().length == 0){
		alert("用户名必须填写并验证通过！");
		$("#userName").focus();
		return false;
	}
	// 避免验证通过后修改的情况
	if($("#userName").val()!=$("#validatedName").val()){
		alert("用户名必须验证！");
		$("#userName").focus();
		return false;
	}
	if($("#password").val().trim().length == 0){
		alert("密码必须填写！");
		$("#password").focus();
		return false;
	}
	if($("#enterpriseName").val().trim().length == 0){
		alert("公司名称必须填写！");
		$("#enterpriseName").focus();
		return false;
	}
	if($('#provinceCode').val() == -1 || $('#cityCode').val() == -1 || $('#countyCode').val() == -1){
		alert("公司所在区域必须填写！");
		return false;
	}
	if($("#address").val().trim().length == 0){
		alert("公司详细地址必须填写！");
		$("#address").focus();
		return false;
	}
	if($("#contactName").val().trim().length == 0){
		alert("联系人姓名必须填写！");
		$("#contactName").focus();
		return false;
	}
	if($('#department').val() == -1){
		alert("所在部门必须填写！");
		return false;
		
	}
	if($("#landlines").val().trim().length == 0){
		alert("固定电话必须填写！");
		$("#landlines").focus();
		return false;
	}
	
	$("#enterpriseform").submit();
	
}