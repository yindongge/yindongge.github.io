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
function showEnterpriseUsers(id){
	layer.open({
	    type: 2,
	    title: '查看关联企业的用户',
	    shadeClose: true,
	    shade: 0.8,
	    shift:-1,
		maxmin: true, //开启最大化最小化按钮
	    area: ['800px', '600px'],
	    content: '../enterprise/userList?enterpriseId=' + id
	});
}
function doCheck(id,checkValue){
	if(!confirm("确定提交审核结果？")){
		return;
	}
	if($("#remark").val().length > 50){
		alert('备注内容最多50个字!');
		$("#remark").focus();
		return;
	}
	if(checkValue=='2' && $("#remark").val().trim()==""){
		alert('请填写备注!');
		$("#remark").focus();
		return;
	}
	if($("#message").val().trim()==""){
		alert('短信内容必须填写!');
		$("#message").focus();
		return;
	}
	
	if($("#message").val().length > 150){
		alert('短信内容最多150个字!');
		$("#message").focus();
		return;
	}
	$("#checkStatus").val(checkValue);
	$.ajax({
		type : "POST",
		dataType : "json",
		url : "../enterprise/check",
		data : $('#enterpriseform').serialize(),
		success : function(data) {
			if (data.code == 200) {
				alert("审核完成！");
				window.location.href="../enterprise/list";
			} else if(data.code == 400){
				alert("审核失败！已经有相同名称的企业通过审核。");
			}else {
				alert("审核未完成！");
			}
		},
		error : function(data) {
			alert("操作失败，请联系管理员或技术人员!");  
		}
	});
}
/**
 * 简单放大缩小图片
 * @param id
 */
function changePicSize(id,minWidth){
	if($("#"+id).attr("src") == ''){
		return;
	}
	var img = $("#"+id);  
	
	var oWidth=img.width(); //取得图片的实际宽度  
	var oHeight=img.height(); //取得图片的实际高度  
	if(oWidth+''==minWidth){
		img.width(oWidth + 400);  
        img.height(oHeight + 400);
	} else {
		img.width(oWidth - 400);  
        img.height(oHeight - 400);
	}
}