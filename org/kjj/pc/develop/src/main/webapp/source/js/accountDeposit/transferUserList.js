$(document).ready(function() {
//	$("#selectAll").click(function() { 
//			$("input[name='userIds']").prop("checked",$("#selectAll").prop("checked"));
//	});
	$("#payPassword").blur(function(){
		if($("#payPassword").val() == "") { 
			$('#payPasswordSpan').empty();
			var errorNum = parseInt($('#errorNum').val());
			
			if(errorNum==3 || errorNumCallBack==3){ 
				$('#payPasswordSpan').append("&nbsp;&nbsp;支付账户被锁定！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			} else {
				$('#payPasswordSpan').append("&nbsp;&nbsp;支付密码不能为空！");
			}
			
			failNum++;
			return false; 
		}
		$('#payPasswordSpan').empty();
		$('#payPasswordSpan').append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
	});
})
var failNum = 0;
var errorNumCallBack = 0;         
function confirmTransfer(){
	var errorNum = parseInt($('#errorNum').val());
	
	if(errorNum==3 || errorNumCallBack==3){
		$('#payPasswordSpan').empty();
		$('#payPasswordSpan').append("&nbsp;&nbsp;支付账户被锁定！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		return;
	}
	// 必须选择
	if(userIdsItem.length == 0){
		alert("请选择会员!");
		return;
	}
	// 验证输入的内容是否符合规则
	validate();

	if(failNum > 0){
		return;
	}
	
	// 计算
	var amount = 0.00;
	var targetAccountItem = []; // 提交内容
	for(var i = 0; i < userIdsItem.length; i++){
		var m = parseFloat($('#'+userIdsItem[i]).val());
		targetAccountItem.push(userIdsItem[i] + "-" + m);
		amount += parseFloat(m);
	}
	
	// 验证总额不能大于当前可用不可提现总额
	var allowanceAmount = parseFloat($('#allowanceAmount').val());
	
	if(amount > allowanceAmount){
		alert('转账的总金额大于可用余额');
		return;
	}
	// 本次为转账人数：<span class="red">5</span>，转账金额合计：<span class="red">3000.00</span>元，转账后余额0.00元。
	var confirmStr = "本次为转账人数：" + userIdsItem.length + " ,转账金额合计：" + amount + "元,转账后余额 " + (allowanceAmount-amount) + " 元,是否执行转账?";
	
	if(!confirm(confirmStr)){
		return;
	}
	
	// 提示是否成功
	$.ajax({  
        type: "post",  
        dataType:"json",
        url: "../accountDeposit/enterpriseUserTransfer",  
        data: {'targetAccount':targetAccountItem.join(','),'amount':amount,'payPassword':$("#payPassword").val()},
        success: function(data) {  
        	if(data.code == 200){
        		alert('转账成功！请查看转账记录。');
        		location.href="../accountDeposit/list";
        	}
        	if(data.code == 300){
        		alert('支付密码错误，请确认支付密码是否正确!');
        		$('#payPasswordSpan').empty();
    			$('#payPasswordSpan').append("&nbsp;&nbsp;支付密码错误！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        		$("#payPassword").focus();
        		return;
        	}
        	if(data.code == 600){
        		alert('支付密码输入错误3次，支付账户被锁定!');
        		$('#payPasswordSpan').empty();
    			$('#payPasswordSpan').append("&nbsp;&nbsp;3次输入错误，支付账户锁定!");
    			errorNumCallBack = 3;
        		return;
        	}
        	if(data.code == 3001){
        		alert('转账失败！可用余额不足。');
        		location.href="../accountDeposit/transferUserlist";
        	}
        },  
        error: function(data) {
        }  
      });
}

function validate(){
	failNum = 0;
	// 验证支付是否锁定
	
	for(var i = 0; i < userIdsItem.length; i++){
		
		checkPrice(userIdsItem[i]);
	}
	$("#payPassword").blur();
	
}
var userIdsItem = [];
var blankStr = '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
function doShowPrice(userId,obj){
	if(obj.checked==true){
		userIdsItem.push(userId);
		$('#'+userId).attr("disabled",false);
		$('#'+userId).focus();
	} else {
		userIdsItem.splice($.inArray(userId,userIdsItem),1);
		//alert(userIdsItem.join(","));// 查看数组内的userId
		$('#'+userId).val('');
		$('#'+userId+'Span').empty();
		$('#'+userId+'Span').append(blankStr);
		$('#'+userId).attr("disabled",true);
	}
}
function checkPrice(userId){
	if($('#'+userId).val()==""){
		$('#'+userId+'Span').empty();
		$('#'+userId+'Span').append("请填写转账金额！");
		failNum++;
	}else{
		// 验证转账金额是否合法
		var amount = $('#'+userId).val();
		var r = /^([1-9][0-9]*)?[0-9]\.[0-9]{2}$/;
		
		// 自动补全金额格式
		var r1 = /^([1-9][0-9]*)?[0-9]$/;
		var r2 = /^([1-9][0-9]*)?[0-9]\.[0-9]{1}$/;
		var r3 = /^([1-9][0-9]*)?[0-9]\.$/;
		if(r1.test(amount)){
			$('#'+userId).val($('#'+userId).val() + ".00");
		}
		if(r3.test(amount)){
			$('#'+userId).val($('#'+userId).val() + "00");
		}
		if(r2.test(amount)){
			$('#'+userId).val($('#'+userId).val() + "0");
		}
		amount = $('#'+userId).val();
		if(!r.test(amount) || "0.00" == amount){
			$('#'+userId+'Span').empty();
			$('#'+userId+'Span').append("格式或内容错误！");
			failNum++;
			return;
		}
		$('#'+userId+'Span').empty();
		$('#'+userId+'Span').append(blankStr);
	}
	
}