function save() {
	if($("#levelId").val().trim().length == 0){
		alert("标识编码必须填写");
		$("#levelId").focus();
		return false;
	}
	if($("#levelName").val().trim().length == 0){
		alert("级别名称必须填写");
		$("#levelName").focus();
		return false;
	}
	if($("#consumeDown").val().trim().length == 0){
		alert("消费下限必须填写！");
		$("#consumeDown").focus();
		return false;
	}
	if($("#consumeTop").val().trim().length == 0){
		alert("消费上限必须填写！");
		$("#consumeTop").focus();
		return false;
	}
	if($("#consumeDown").val().indexOf(".") != -1){
		if($("#consumeDown").val().length - ($("#consumeDown").val().indexOf(".")+1) !=  2){
			alert("消费下限小数点后面只保留两位有效数字！");
			$("#consumeDown").focus();
			return false;
		}
	}
	if($("#consumeTop").val().indexOf(".") != -1){
		if($("#consumeTop").val().length - ($("#consumeTop").val().indexOf(".")+1) !=  2){
			alert("消费上限小数点后面只保留两位有效数字！");
			$("#consumeTop").focus();
			return false;
		}
	}
	if(parseFloat($("#consumeTop").val()) <= parseFloat($("#consumeDown").val())){
		alert("消费上限要大于消费下限！");
		$("#consumeTop").focus();
		return false;
	}
	if($("#discount").val().trim().length == 0){
		alert("折扣必须填写！");
		$("#discount").focus();
		return false;
	}
	if($("#discount").val().indexOf(".") != -1){
		if($("#discount").val().length - ($("#discount").val().indexOf(".")+1) !=  2){
			alert("折扣小数点后面只保留两位有效数字！");
			$("#discount").focus();
			return false;
		}
	}
	$.ajax({
		type : "POST",
		dataType : "json",
		url : "../userlevel/add",
		data : $('#userlevelform').serialize(),
		success : function(data) {
			if (data.code == 200) {
				alert("添加成功！");
				window.location.href="../userlevel/list";
			} else {
				
				if(data.code == 300){
					alert("标识编码已经存在，请重新填写！");
					$('#levelId').focus();
				}
				if(data.code == 400){
					alert("级别名称已经存在，请重新填写！");
					$('#levelName').focus();
				}
				if(data.code == 600){
					alert("该类型下已经存在相同排序的会员级别，请重新选择！");
				}
			}
		},
		error : function(data) {
			alert("操作失败，请联系管理员或技术人员!");  
		}
	});
}
function cancle() {
	window.location.href="../userlevel/list";
}