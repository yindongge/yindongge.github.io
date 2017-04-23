$(function () {	
	/*
	//校验
	$("#userlevelform").bootstrapValidator({
		message : '字段内容非法',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields: {        
			consumeDown: {          
				validators: {            
					notEmpty: {              
						message: '消费下限不能为空'            
					},
					callback:{
						message: '消费下限小数点后面只保留两位有效数字,并且不能大于等于消费上限',
						callback: function(value, validator) {
							if(value!=""&&value.indexOf(".")!=-1){
								if(value.length - (value.indexOf(".")+1) >  2){
									return false;
								}
							}
							if(value!=""){
								if(parseFloat(value) >= parseFloat($("#consumeTop").val())){
									return false;
								}
							}
							return true;
						}
					}
				}        
			},
			consumeTop: {          
				validators: {            
					notEmpty: {              
						message: '消费上限不能为空'            
					},
					callback:{
						message: '消费上限小数点后面只保留两位有效数字,并且不能小于等于消费上限',
						callback: function(value, validator) {
							if(value!=""&&value.indexOf(".")!=-1){
								if(value.length - (value.indexOf(".")+1) >  2){
									return false;
								}
							}
							if(value!=""){
								if(parseFloat(value) <= parseFloat($("#consumeDown").val())){
									return false;
								}
							}
							return true;
						}
					}
				}        
			}
        }
	});*/
});
function update() {
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
		url : "../userlevel/save",
		data : $('#userlevelform').serialize(),
		success : function(data) {
			if (data.code == 200) {
				alert("修改成功！");
				window.location.href="../userlevel/list";
			} else {
				if(data.code == 600){
					alert("该类型下已经存在相同排序的会员级别，请重新选择！");
				}
			}
		},
		error : function(data) {
			alert("操作失败，请联系管理员或技术人员!");  
		}
	});
	//$("#userlevelform").submit();
}
function cancle() {
//	var index = parent.layer.getFrameIndex(window.name);
//	parent.layer.close(index);
	window.location.href="../userlevel/list";
}