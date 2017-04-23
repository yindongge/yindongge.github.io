	$(function () {
		
		$('.btn-click').click(function(){
			//iframe层
			layer.open({
			    type: 2,
			    title: '选择店铺',
			    shadeClose: true,
			    shade: 0.8,
			    shift:-1,
				maxmin: true, //开启最大化最小化按钮
			    area: ['800px', '450px'],
			    content: '../shop/shopSelectInit' //iframe的url
			}); 
		});
		
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