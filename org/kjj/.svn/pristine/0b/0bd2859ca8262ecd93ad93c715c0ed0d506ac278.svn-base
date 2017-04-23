$(function () {
	//时间选择器
	$(".date").datetimepicker({
		format: 'YYYY-MM-DD HH:mm:ss',
		sideBySide:true,
		locale:'zh-cn'
	});
	
    $("#startTime").on("dp.change", function (e) {
        $('#endTime').data("DateTimePicker").minDate(e.date);
    });
    $("#endTime").on("dp.change", function (e) {
        $('#startTime').data("DateTimePicker").maxDate(e.date);
    });
});

function save(){

	// 验证
	// 时间不能为空，并且是差为7天
	if($("#startTime").val().trim().length == 0 || $("#endTime").val().trim().length == 0){
		alert("有效期限必须填写!");
		return;
	}
	
	if($("#startTime").val() >= $("#endTime").val()){
		alert("有效期限填写不正确!");
		return;
	}
	
	var beginTime = $("#startTime").val();
    var endTime = $("#endTime").val();
    var beginTimes = beginTime.substring(0, 10).split('-');
    var endTimes = endTime.substring(0, 10).split('-');

    beginTime = beginTimes[1] + '-' + beginTimes[2] + '-' + beginTimes[0] + ' ' + beginTime.substring(10, 19);
    endTime = endTimes[1] + '-' + endTimes[2] + '-' + endTimes[0] + ' ' + endTime.substring(10, 19);

    var a = (Date.parse(endTime) - Date.parse(beginTime)) / 3600 / 1000 / 24;
    
    if(a > 7){
    	alert("有效期不能超出7天!");
    	return;
    }
	
	// 最大激活数为整数
	if($("#ceiling").val().trim().length == 0){
		alert("可激活数必须填写!");
		return;
	}
	var r = /^[1-9][0-9]*$/;//正整数 
	if(!r.test($("#ceiling").val())){
		alert("可激活数必须为整数！");
		$("#ceiling").focus();
		return;
	}
	
	if(parseInt($("#ceiling").val()) > 5000){
		alert("可激活数不能大于5000！");
		$("#ceiling").focus();
		return;
	}
	// 提交之前验证
	$.ajax({
        type: "POST",
        dataType: "json",
        url: "../enterprise/validateEasyInvitation",
        data: {'enterpriseId': $('#enterpriseId').val()},
        success: function (data) {  
           if(data.pass=="yes"){
        	   safeSave();
           }else{
        	   alert("不能创建统一邀请码，该企业还有未使用完的统一邀请码!");
        	   window.location.href="../enterprise/detail?enterpriseId=" + $('#enterpriseId').val();
           }
           
        },
        error: function(data) {
        	alert("操作失败，请联系管理员!");
         }
    });	
}
function safeSave(){
	$.ajax({
        type: "POST",
        dataType: "json",
        url: "../enterprise/saveEasyInvitation",
        data: $('#invitationform').serialize(),
        success: function (data) {  
           if(data.code==200){
        	   alert("创建成功!");
        	   
           }else{
        	   alert("创建失败!");
           }
           window.location.href="../enterprise/detail?enterpriseId=" + $('#enterpriseId').val();
        },
        error: function(data) {
        	alert("操作失败，请联系管理员!");
        	window.location.href="../enterprise/detail?enterpriseId=" + $('#enterpriseId').val();
         }
    });
}