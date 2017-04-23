function cancle(){
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.close(index);
}
function savedata(){
	// 验证
	var check_item =[];
	$("[name='timeTypeItem']:checked").each(function(){    
		check_item.push($(this).val());
    });
	if(check_item.length == 0){
		if(!confirm("确定一个都不设置?")){
			return;
		}
	}
	$("#timeTypeStr").val(check_item.join(","));
	//$("#pageform").submit();
	$("#mySubmit").attr("disabled",true);
	$.ajax({
        type: "POST",
        dataType: "json",
        url: "../meal/updateStockClear",
        data: {'shopCode':$("#shopCode").val(),'timeTypeStr':$("#timeTypeStr").val()},
        success: function (data) {
       	 	alert('设置成功!');
       	 	$("#mySubmit").attr("disabled",false);
        },
        error: function(data) {
        	alert('设置失败!');
        }
    });
	
}