$(function () {
	$("#depositType").change(function(){
		if($('#depositType').val() == "1"){
			$('#type_7').attr('checked',false);
			$('#type_7').attr('disabled',"true");
			$('#type_8').removeAttr("disabled");
			$("#validateDepositTypeSpan").empty();
		} else if($('#depositType').val() == "2"){
			$('#type_7').attr('checked',false);
			$('#type_7').attr('disabled',"true");
			$('#type_8').removeAttr("disabled");
			$("#validateDepositTypeSpan").empty();
		} else if($('#depositType').val() == "3"){
			$('#type_7').removeAttr("disabled");
			$('#type_8').attr('checked',false);
			$('#type_8').attr('disabled',"true");
			$("#validateDepositTypeSpan").empty();
		} else {
			$("#validateDepositTypeSpan").empty();
			$("#validateDepositTypeSpan").append("<font style=\'color:red\'>请选择预存款类型！</font>");
		}
	});
	
})
function selectSingleUser(){
	layer.open({
	    type: 2,
	    title: '选择会员',
	    shadeClose: true,
	    shade: 0.8,
	    shift:-1,
		maxmin: true, //开启最大化最小化按钮
	    area: ['800px', '550px'],
	    content: '../user/oneSelect'
	});
}
var global_foundAmount = 0.00;
var global_allowanceAmount = 0.00;
var global_frozenAmount = 0.00;
var global_str = "";
function selectUserOneCallBack(userId,userName){
	$('#userId').val(userId);
	$('#userName').val(userName);
	$.ajax({
        type: "POST",
        dataType: "json",
        url: "../depositApply/queryUserAccountDeposit",
        data: {'userId':userId},
        success: function (data) {
       	 	if (data.code == 300) {
	       	 	$("#validateUserNameSpan").empty();
				$("#validateUserNameSpan").addClass("false");
				$("#validateUserNameSpan").append("该会员没有账户信息,单不影响账户充值！");
			} else {
				global_foundAmount = parseFloat(data.foundAmount);
				global_allowanceAmount = parseFloat(data.allowanceAmount);
				global_frozenAmount = parseFloat(data.frozenAmount);
				var str = "可用可提现金额：" + data.foundAmount + "元;&nbsp;";
				str += "可用不可提现金额：" + data.allowanceAmount + "元;&nbsp;";
				str += "冻结金额：" + data.frozenAmount + "元;&nbsp;";
				global_str = str;
				$("#validateUserNameSpan").empty();
				$("#validateUserNameSpan").addClass("false");
				$("#validateUserNameSpan").append(str);
			}
        },
        error: function(data) {
        	alert('操作失败!');
        }
    });
}

function cancle(){
	if($('#pageId').val()=='1'){
		window.location.href="../depositApply/applyList";
	} else {
		window.location.href="../depositApply/applySimpleList";
	}
}

function savedata(){
	// 数据验证
	if($('#userId').val()==""){
		$("#validateUserNameSpan").empty();
		$("#validateUserNameSpan").append("<font style=\'color:red\'>请选择会员！</font>");
		return;
	}
	//$("#validateUserNameSpan").empty();
	
	if($('#depositType').val()==""){
		$("#validateDepositTypeSpan").empty();
		$("#validateDepositTypeSpan").append("<font style=\'color:red\'>请选择预存款类型！</font>");
		return;
	}
	$("#validateDepositTypeSpan").empty();
	
	if($('input[name="type"]:checked').val()=="" || typeof($('input[name="type"]:checked').val()) == "undefined"){
		$("#validateBusinessTypeSpan").empty();
		$("#validateBusinessTypeSpan").append("<font style=\'color:red\'>请选择增加类型！</font>");
		return;
	}
	$("#validateBusinessTypeSpan").empty();
	
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
	
	if($('#depositType').val()=="1"){
		if($('input[name="type"]:checked').val()!="5"){
			if(global_foundAmount < parseFloat($('#amount').val())){
				$("#validateAmountSpan").empty();
				$("#validateAmountSpan").append("<font style=\'color:red\'>金额[" + $('#amount').val() + "]大于当前的可用可提现金额[" + global_foundAmount + "]！</font>");
				return;
			}
		}
	}
	$("#validateAmountSpan").empty();
	
	if($('#depositType').val()=="2"){
		if($('input[name="type"]:checked').val()!="5"){
			if(global_allowanceAmount < parseFloat($('#amount').val())){
				$("#validateAmountSpan").empty();
				$("#validateAmountSpan").append("<font style=\'color:red\'>金额大于当前的可用不可提现金额[" + global_allowanceAmount + "]！</font>");
				return;
			}
		}
	}
	$("#validateAmountSpan").empty();
	
	if($('#depositType').val()=="3"){
		if($('input[name="type"]:checked').val()!="5"){
			if(global_frozenAmount < parseFloat($('#amount').val())){
				$("#validateAmountSpan").empty();
				$("#validateAmountSpan").append("<font style=\'color:red\'>金额大于当前的冻结金额[" + global_frozenAmount + "]！</font>");
				return;
			}
		}
	}
	$("#validateAmountSpan").empty();
	
	if($('#reason').val()==""){
		$("#validateReasonSpan").empty();
		$("#validateReasonSpan").append("<font style=\'color:red\'>请选择原因！</font>");
		return;
	}
	$("#validateReasonSpan").empty();
	
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
	// 失效按钮
	$("#mySubmit").attr("disabled",true);
	$.ajax({
		type : "POST",
		dataType : "json",
		url : "../depositApply/applySave",
		data : $('#applyform').serialize(),
		success : function(data) {
			if (data.code == 200) {
				alert("操作成功！");
				if($('#pageId').val()=='1'){
					window.location.href="../depositApply/applyList";
				} else {
					window.location.href="../depositApply/applySimpleList";
				}
			} else {
				alert("操作失败！");
			}
			$("#mySubmit").attr("disabled",false);
		},
		error : function(data) {
			alert("操作失败，请联系管理员或技术人员!");  
		}
	});
	
}