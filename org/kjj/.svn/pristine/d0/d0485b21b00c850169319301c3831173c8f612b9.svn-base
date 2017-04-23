function doChangeName(id,realNameId){
	// 判断是否空
	if($('#'+realNameId).val()==""){
		$('#' + realNameId + 'Span').empty();
		$('#' + realNameId + 'Span').append("&nbsp;&nbsp;真实姓名不能为空！");
		$('#' + realNameId).focus();
		return;
	}
	
	// 修改失败后更新页面
	$.ajax({  
        type: "post",  
        dataType:"json",
        url: "../security/changeRealName",  
        data: {'id':id,'realName':$('#'+realNameId).val()},
        success: function(data) {  
        	if(data.code == 200){
        		alert('修改成功！');
        	} else {
        		alert('修改失败！');
        		location.href="../security/enterpriseUserList";
        	}
        },  
        error: function(data) {
        }  
      });
	
}

function doDelUser(id){
	if(!confirm('确认要解除与该用关联')){
		return;
	}
	$.ajax({  
        type: "post",  
        dataType:"json",
        url: "../security/deleteUserOfEnterprise",  
        data: {'id':id},
        success: function(data) {  
        	if(data.code == 200){
        		alert('解除关联成功！');
        		location.href="../security/enterpriseUserList?enterpriseId=" + $('#enterpriseId').val();
        	} else {
        		alert('解除关联失败！');
        	}
        },  
        error: function(data) {
        }  
      });
	
}

function realNameBlur(realNameId){
	$('#' + realNameId + 'Span').empty();
	$('#' + realNameId + 'Span').append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
}