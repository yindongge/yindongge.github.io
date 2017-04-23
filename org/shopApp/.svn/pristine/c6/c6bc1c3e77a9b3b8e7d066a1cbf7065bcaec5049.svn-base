function cancle(){
	window.location.href="../depositApply/applyList";
}


function doApplyClosed(id){
	if($('#checkComment').val()==""){
		$("#validateCommentSpan").empty();
		$("#validateCommentSpan").append("<font style=\'color:red\'>请填写审核备注！</font>");
		return;
	}
	$("#validateCommentSpan").empty();
	
	if($('#checkComment').val().length > 150){
		$("#validateCommentSpan").empty();
		$("#validateCommentSpan").append("<font style=\'color:red\'>审核备注内容最多150个字！</font>");
		return;
	}
	$("#validateCommentSpan").empty();
	
	if(!confirm("确定关闭该申请吗？")){
		return;
	}
	$.ajax({
        type: "POST",
        dataType: "json",
        url: "../depositApply/applyClose",
        data: {'id':id,'checkComment':$('#checkComment').val()},
        success: function (data) {
       	 	if (data.code == 200) {
	       	 	alert("关闭操作成功！");
	       	 	window.location.href="../depositApply/applyList";
			} else {
				if(data.code==600){
					alert("该申请已经被处理，请确认！");
					window.location.href="../depositApply/applyList";
				} else {
					alert('关闭操作失败!');
				}
				
			}
        },
        error: function(data) {
        	alert('操作失败!');
        }
    });
}

function doApplyExec(id){
	if($('#checkComment').val()==""){
		$("#validateCommentSpan").empty();
		$("#validateCommentSpan").append("<font style=\'color:red\'>请填写审核备注！</font>");
		return;
	}
	$("#validateCommentSpan").empty();
	
	if($('#checkComment').val().length > 150){
		$("#validateCommentSpan").empty();
		$("#validateCommentSpan").append("<font style=\'color:red\'>审核备注内容最多150个字！</font>");
		return;
	}
	$("#validateCommentSpan").empty();
	$("#mySubmit").attr("disabled",true);
	$.ajax({
        type: "POST",
        dataType: "json",
        url: "../depositApply/applyExec",
        data: {'id':id,'checkComment':$('#checkComment').val()},
        success: function (data) {
       	 	if (data.code==200) {
	       	 	alert("执行操作成功！");
	       	 	window.location.href="../depositApply/applyList";
			} else {
				if(data.code==600){
					alert("该申请已经被处理，请确认！");
				}
				if(data.code==3001){
					alert('账户余额不足，执行操作失败!');
				}
				window.location.href="../depositApply/applyList";
			}
       	 	$("#mySubmit").attr("disabled",false);
        },
        error: function(data) {
        	alert('操作失败!');
        }
    });
}

