$(function(){
	//日期选择器
	$(".datetime").datetimepicker({
		format: 'YYYY-MM-DD HH:mm:ss',
		showClear:true,
		locale:'zh-cn',
	});
	
	$("#startDateTime").on("dp.change", function (e) {
        $('#endDateTime').data("DateTimePicker").minDate(e.date);
    });
    $("#endDateTime").on("dp.change", function (e) {
        $('#startDateTime').data("DateTimePicker").maxDate(e.date);
    });
    
    $('.btn-success.btn-xs').on('click',function(){
		var btn=$(this);
		$.ajax({  
			type: "post",  
			dataType: "json",
			url: "updateStatus",
			data: {'id':btn.parent().attr('data-id'),'status':1},
			success:function(data){
				if(data=200){
					btn.parent().prev().text("已启用");
					btn.hide();
					btn.siblings('.btn-danger.btn-xs').show();
				}
			}
		});  
	});
    
	$('.btn-danger.btn-xs').on('click',function(){
		var btn=$(this);
		$.ajax({  
			type: "post",  
			dataType: "json",
			url: "updateStatus",
			data: {'id':btn.parent().attr('data-id'),'status':0},
			success:function(data){
				if(data=200){
					btn.parent().prev().text("已停用");
					btn.hide();
					btn.siblings('.btn-success.btn-xs').show();
				}
			}
		});
	});
    
    
    
//    $('.btn-info.btn-xs').on('click',function(){});
    
    
    
    
});


	

