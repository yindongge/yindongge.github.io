$(function () {
	//时间选择器
	$(".date").datetimepicker({
		format: 'YYYY-MM-DD HH:mm:ss',
		showClear:true,
		locale:'zh-cn'
	});

	$("#createTimeStart").on("dp.change", function (e) {
	    $('#createTimeEnd').data("DateTimePicker").minDate(e.date);
	});
	$("#createTimeEnd").on("dp.change", function (e) {
	    $('#createTimeStart').data("DateTimePicker").maxDate(e.date);
	});
	
})

function doAdd(){
	window.location.href = "../enterprise/add";
}

function doDelete(id){
	if(!confirm("确定删除当前用户？")){
		return;
	}
	$.ajax({
		type : "POST",
		dataType : "json",
		url : "../enterprise/delete",
		data: {'enterpriseId':id},
		success : function(data) {
			if (data.code == 200) {
				alert("删除成功!");
				window.location.href="../enterprise/list";
			} else {
				alert("删除失败!");
			}
		},
		error : function(data) {
			alert("操作失败，请联系管理员或技术人员!");  
		}
	});
}

function doLock(id){
	if(!confirm("确定锁定当前用户？")){
		return;
	}
	$.ajax({
		type : "POST",
		dataType : "json",
		url : "../enterprise/lock",
		data: {'enterpriseId':id},
		success : function(data) {
			if (data.code == 200) {
				alert("锁定成功!");
				window.location.href="../enterprise/list";
			} else {
				alert("锁定失败!");
			}
		},
		error : function(data) {
			alert("操作失败，请联系管理员或技术人员!");  
		}
	});
}

function doDisLock(id){
	if(!confirm("确定解除锁定当前用户？")){
		return;
	}
	$.ajax({
		type : "POST",
		dataType : "json",
		url : "../enterprise/disLock",
		data: {'enterpriseId':id},
		success : function(data) {
			if (data.code == 200) {
				alert("解除锁定成功!");
				window.location.href="../enterprise/list";
			} else {
				alert("解除锁定失败!");
			}
		},
		error : function(data) {
			alert("操作失败，请联系管理员或技术人员!");  
		}
	});
}

function doEdit(id){
	window.location.href="../enterprise/edit?enterpriseId="+id;
}

function doDetail(id){
	window.location.href="../enterprise/detail?enterpriseId="+id;
}

function doPreCheck(id){
	window.location.href="../enterprise/preCheck?enterpriseId="+id;
}
function doSelect(id){
	parent.selectEnterpriseUserCallBack(id);
	var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	parent.layer.close(index); //再执行关闭
}
function doChangeShop(id){
	var shopId = $("#shop" + id).val();
	if(shopId==""){
		alert("请选择店铺!");
		return;
	}
	$.ajax({
		type : "POST",
		dataType : "json",
		url : "../enterprise/changeShop",
		data: {'enterpriseId':id, 'shopId':shopId},
		success : function(data) {
			if (data.code == 200) {
				alert("修改成功!");
				window.location.href="../enterprise/list";
			} else {
				alert("修改失败!");
			}
		},
		error : function(data) {
			alert("操作失败，请联系管理员或技术人员!");  
		}
	});
}
function doChangeContact(id){
	var shopContact = $("#contact" + id).val();
	if(shopContact==""){
		alert("请填写负责人!");
		return;
	}
	$.ajax({
		type : "POST",
		dataType : "json",
		url : "../enterprise/changeShop",
		data: {'enterpriseId':id, 'shopContact':shopContact},
		success : function(data) {
			if (data.code == 200) {
				alert("修改成功!");
				window.location.href="../enterprise/list";
			} else {
				alert("修改失败!");
			}
		},
		error : function(data) {
			alert("操作失败，请联系管理员或技术人员!");  
		}
	});
}
