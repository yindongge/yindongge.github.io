$(document).ready(function() {
	$("#selectAll").click(function() { 
			$("input[name='userIds']").prop("checked",$("#selectAll").prop("checked"));
	});
})


function doDeletes(){
	var ids = [];
	$("input[name='userIds']").each(function(){
		if(true == $(this).prop("checked")){
			ids.push($(this).prop('value'));
		}
	});
	if(ids.length < 1){
		alert('请选择要删除的用户!');
		return;
	}
	$.ajax({
        type: "POST",
        dataType: "json",
        url: "../accountGroup/groupUserDel",
        data: $('#pageform').serialize(),
        success: function (data) {  
           if(data.code==200){
          	 	alert("删除成功!");
          	 	//location.href="../accountGroup/groupUserList?groupId=" + $("#groupId").val();
          	 	window.location.reload();
           }else{
        	   alert("删除失败!");
           }
        },
        error: function(data) {
        	alert("删除失败!");	
        }
    });
	
}

function importEnterpriseUser(){
	layer.open({
	    type: 2,
	    title: '选择与企业关联的用户',
	    shadeClose: true,
	    shade: 0.8,
	    shift:-1,
		maxmin: true, //开启最大化最小化按钮
	    area: ['900px', '550px'],
	    content: '../enterprise/select'
	});
}

function doCancel(){
	location.href="../accountGroup/groupList";
}

function importUser(){
	layer.open({
	    type: 2,
	    title: '选择用户',
	    shadeClose: true,
	    shade: 0.8,
	    shift:-1,
		maxmin: true, //开启最大化最小化按钮
	    area: ['900px', '550px'],
	    content: '../user/select'
	});
	
}

function selectEnterpriseUserCallBack(enterpriseId){
	$.ajax({
        type: "POST",
        dataType: "json",
        url: "../accountGroup/groupEnterpriseUserAdd",
        data: {'groupId':$("#groupId").val(),'enterpriseId':enterpriseId},
        success: function (data) {
       	 	if (data.code == 200) {
       	 		alert('成功添加' + data.addnum + '个用户,已经存在的用户不会重复添加。');
       	 		window.location.reload();
			} else {
				alert('添加用户出错!');
			}
        },
        error: function(data) {
        	alert('操作失败!');
        }
    });
}
function selectUserCallBack(userIds){
	$.ajax({
        type: "POST",
        dataType: "json",
        url: "../accountGroup/groupUserAdd",
        data: {'groupId':$("#groupId").val(),'userIds':userIds},
        success: function (data) {
       	 	if (data.code == 200) {
       	 		alert('成功添加' + data.addnum + '个用户,已经存在的用户不会重复添加。');
       	 		window.location.reload();
			} else {
				alert('添加用户出错!');
			}
        },
        error: function(data) {
        	alert('操作失败!');
        }
    });
}