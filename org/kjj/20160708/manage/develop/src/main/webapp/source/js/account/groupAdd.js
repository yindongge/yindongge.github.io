function cancle(){
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.close(index);
}

function savedata(){
	if($("#groupName").val()==""){
		alert("请填写用户组名称!");
		return;
	}
	$.ajax({
        type: "POST",
        dataType: "json",
        url: "../accountGroup/groupSave",
        data: {'groupId':$("#groupId").val(),'groupName':$("#groupName").val()},
        success: function (data) {
       	 	if (data.code == 200) {
       	 		alert('保存成功!');
       	 		parent.window.location.href='../accountGroup/groupList';
			} else {
				alert('用户组名称重复，请修改并重新提交!');
			}
        },
        error: function(data) {
        	alert('操作失败!');
        }
    });
	
}