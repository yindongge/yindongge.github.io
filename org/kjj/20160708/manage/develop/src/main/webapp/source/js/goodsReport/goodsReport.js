function exportExcel(){
	$('#exportBtn').removeAttr("onclick");
	$('#exportBtn').empty();
	$('#exportBtn').html('报表生成中...');
	$.ajax({		
		url : '../goodsReport/exportExcel',
		type : 'post',
		dataType : 'json',
		data : $("#pageform").serialize(),
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
		
	     $("#createTimeStart").on("dp.change", function (e) {
	         $('#createTimeEnd').data("DateTimePicker").minDate(e.date);
	     });
	     $("#createTimeEnd").on("dp.change", function (e) {
	         $('#createTimeStart').data("DateTimePicker").maxDate(e.date);
	     });
	});