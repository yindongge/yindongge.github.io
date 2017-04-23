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

function doAdd(pageId){
	window.location.href="../depositApply/applyAdd?pageId="+pageId;
}

function doBatchAdd(){
	window.location.href="../depositApply/applyBatchAdd";
}

function doCheck(id){
	window.location.href="../depositApply/applyCheck?id=" + id;
}

function doDetail(id,pageId){
	window.location.href="../depositApply/applyDetail?id=" + id + "&pageId=" + pageId;
}

function doBatchDetail(id,pageId){
	window.location.href="../depositApply/applyBatchDetail?id=" + id + "&pageId=" + pageId;
}