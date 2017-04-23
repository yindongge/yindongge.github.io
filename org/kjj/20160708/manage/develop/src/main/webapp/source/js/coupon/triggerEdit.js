var startTime=$('#couponStartTime').val();
var endTime=$('#couponEndTime').val();
$(function () {
	
	if(startTime!='' && endTime !=''){
		//时间选择器
		$(".date").datetimepicker({
			widgetPositioning: {
	            horizontal: 'left',
	            vertical: 'auto'
	         },
	        minDate: startTime,
	        maxDate: endTime,
			format: 'YYYY-MM-DD HH:mm:ss',
			sideBySide:true,
			locale:'zh-cn'
		});
	}
	
	if(startTime=='' || endTime==''){
		//时间选择器
		$(".date").datetimepicker({
			widgetPositioning: {
	            horizontal: 'left',
	            vertical: 'auto'
	         },
			format: 'YYYY-MM-DD HH:mm:ss',
			sideBySide:true,
			locale:'zh-cn'
		});
	}
	
    $("#startTime").on("dp.change", function (e) {
        $('#endTime').data("DateTimePicker").minDate(e.date);
    });
    $("#endTime").on("dp.change", function (e) {
        $('#startTime').data("DateTimePicker").maxDate(e.date);
    });
    
    //校验
	$("#triggerEdit").bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		}
	});
    
});