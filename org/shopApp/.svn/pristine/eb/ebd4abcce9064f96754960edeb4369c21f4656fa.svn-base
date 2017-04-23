$(function () {

	//$("#paymentCode").on("keyup", formatBC);      

	
})
/**
 * 银行账号格式化
 */
function formatBC(e){
	$(this).attr("data-oral", $(this).val().replace(/\ +/g,""));      
	//$("#bankCard").attr("data-oral")获取未格式化的卡号        
	var self = $.trim(e.target.value);      
	var temp = this.value.replace(/\D/g, '').replace(/(....)(?=.)/g, '$1 ');      
	if(self.length > 22){        
		this.value = self.substr(0, 22);        
		return this.value;      
	}      
	if(temp != this.value){        
		this.value = temp;      
	}    
}
function cancle(){
	window.location.href="../depositApply/applyList";
}

function selectGroup(){
	layer.open({
	    type: 2,
	    title: '选择用户组',
	    shadeClose: true,
	    shade: 0.8,
	    shift:-1,
		maxmin: true, //开启最大化最小化按钮
	    area: ['900px', '550px'],
	    content: '../accountGroup/groupSelect'
	});
	
}

function selectGroupCallBack(groupId,groupName){
	$('#groupId').val(groupId);
	$('#groupName').val(groupName);
}

function savedata(){
	// 数据验证
	if($('#groupId').val()==""){
		$("#validateGroupNameSpan").empty();
		$("#validateGroupNameSpan").append("<font style=\'color:red;margin-left:20px\'>请选择用户组！</font>");
		return;
	}
	$("#validateGroupNameSpan").empty();
	
	if($('#amount').val()==""){
		$("#validateAmountSpan").empty();
		$("#validateAmountSpan").append("<font style=\'color:red\'>请填写金额！</font>");
		return;
	} 
	if($('#amount').val().indexOf('0') == 0 && $('#amount').val().indexOf('0.') == -1){
		$("#validateAmountSpan").empty();
		$("#validateAmountSpan").append("<font style=\'color:red\'>金额格式不正确！</font>");
		return;
	} 
	if($("#amount").val().length - ($("#amount").val().indexOf(".")+1) !=  2){
		$("#validateAmountSpan").empty();
		$("#validateAmountSpan").append("<font style=\'color:red\'>金额格式不正确,保留两位小数！</font>");
		return;
	}
	if($('#amount').val() == "0.00"){
		$("#validateAmountSpan").empty();
		$("#validateAmountSpan").append("<font style=\'color:red\'>金额不能为零！</font>");
		return;
	}
	$("#validateAmountSpan").empty();
	
	if($('#applyComment').val()==""){
		$("#validateCommentSpan").empty();
		$("#validateCommentSpan").append("<font style=\'color:red\'>请填写备注！</font>");
		return;
	}
	$("#validateCommentSpan").empty();
	
	if($('#applyComment').val().length > 150){
		$("#validateCommentSpan").empty();
		$("#validateCommentSpan").append("<font style=\'color:red\'>备注内容最多150个字！</font>");
		return;
	}
	$("#validateCommentSpan").empty();
	$("#mySubmit").attr("disabled",true);
	$.ajax({
		type : "POST",
		dataType : "json",
		url : "../depositApply/applyBatchSave",
		data : $('#applyform').serialize(),
		success : function(data) {
			if (data.code == 200) {
				alert("批量充值成功！");
				window.location.href="../depositApply/applyList";
			} else {
				alert("批量充值失败！");
			}
			$("#mySubmit").attr("disabled",false);
		},
		error : function(data) {
			alert("操作失败，请联系管理员或技术人员!");  
		}
	});
	
}