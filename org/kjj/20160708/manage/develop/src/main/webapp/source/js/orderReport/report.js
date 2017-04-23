function exportExcel(){
	$('#exportBtn').removeAttr("onclick");
	$('#exportBtn').empty();
	$('#exportBtn').html('报表生成中...');
	$.ajax({		
		url : '../orderReport/export',
		type : 'post',
		dataType : 'json',
		data : {
			'createTimeStart' : $("#create_time_start").val(),
			'createTimeEnd' : $("#create_time_end").val()
		},
		success : function(data){
			$('#exportBtn').empty();
			$('#exportBtn').html('下载当前报表');
			$('#exportBtn').attr('href',data.downloadUrl);
		}
	});
}
$(function(){
	//时间选择器
	$(".date").datetimepicker({
		format: 'YYYY-MM-DD HH:mm:ss',
		sideBySide:true,
		showClear:true,
		locale:'zh-cn'
	});
	
     $("#create_time_start").on("dp.change", function (e) {
    	 if(typeof($("#exportBtn").attr("onclick"))=="undefined"){//判断按钮是否有onclick属性
    		 $('#exportBtn').removeAttr('href');
    		 $('#exportBtn').attr("onclick","exportExcel()");
    		 $('#exportBtn').empty();
    		 $('#exportBtn').html('生成订单报表');
    	 }
    		 $('#create_time_end').data("DateTimePicker").minDate(e.date);
    });
     
    $("#create_time_end").on("dp.change", function (e) {
    	if(typeof($("#exportBtn").attr("onclick"))=="undefined"){
    		$('#exportBtn').removeAttr('href');
    		$('#exportBtn').attr("onclick","exportExcel()");
    		$('#exportBtn').empty();
    		$('#exportBtn').html('生成订单报表');
    	}
    		$('#create_time_start').data("DateTimePicker").maxDate(e.date);
    });
    
    //为backspace按键绑定按下弹起事件
    $(document).keyup(function(event){ 
    	if(event.keyCode==8){ 
    		if( $("#create_time_start").val() == ""){
	    		$('#exportBtn').removeAttr('href');
		        $('#exportBtn').attr("onclick","exportExcel()");
		        $('#exportBtn').empty();
		        $('#exportBtn').html('生成订单报表');
    		}
    		if( $("#create_time_end").val() == ""){
	    		$('#exportBtn').removeAttr('href');
		        $('#exportBtn').attr("onclick","exportExcel()");
		        $('#exportBtn').empty();
		        $('#exportBtn').html('生成订单报表');
    		}
    	} 
    	}); 
});