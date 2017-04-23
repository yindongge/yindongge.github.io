$(function () {
	//时间选择器
	$(".date").datetimepicker({
		format: 'YYYY-MM-DD HH:mm:ss',
		showClear:true,
		locale:'zh-cn'
	});

	$("#createTimeStart").on("dp.change", function (e) {
	    $('#createTimeEnd').data("DateTimePicker").minDate(e.date);
	});
	$("#createTimeEnd").on("dp.change", function (e) {
	    $('#createTimeStart').data("DateTimePicker").maxDate(e.date);
	});
	
})

function doExpExcel(){
	alert('导出!');
}