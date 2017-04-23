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

function doQuery(){

	$('#pageform').submit();
	
	
}

function doManage(groupId){
	window.location.href="../accountGroup/groupUserList?groupId="+groupId;
	
}


function doAdd(){
	var groupId = "";
	var groupName = "";
	layer.open({
	    type: 2,
	    title: '修改充值用户组',
	    shadeClose: true,
	    shade: 0.8,
	    shift:-1,
		maxmin: true, //开启最大化最小化按钮
	    area: ['700px', '520px'],
	    content: '../accountGroup/groupAdd?groupId=' + groupId + '&groupName=' + groupName
	});
}

function doEdit(groupId,groupName){
	layer.open({
	    type: 2,
	    title: '修改充值用户组',
	    shadeClose: true,
	    shade: 0.8,
	    shift:-1,
		maxmin: true, //开启最大化最小化按钮
	    area: ['700px', '520px'],
	    content: '../accountGroup/groupAdd?groupId=' + groupId + '&groupName=' + groupName
	});
}

function doDelete(id){
	if(!confirm("删除用户组后，将不能使用该用户组进行充值操作，确定删除该用户组？")){
		return;
	}
	$.ajax({
		type : "POST",
		dataType : "json",
		url : "../accountGroup/groupDelete",
		data: {'id':id},
		success : function(data) {
			if (data.code == 200) {
				alert("删除成功!");
				window.location.href="../accountGroup/groupList";
			} else {
				alert("删除失败!");
			}
		},
		error : function(data) {
			alert("操作失败，请联系管理员或技术人员!");  
		}
	});
}

function doSelect(groupId,groupName){
	parent.selectGroupCallBack(groupId,groupName);
	var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	parent.layer.close(index); //再执行关闭
}
