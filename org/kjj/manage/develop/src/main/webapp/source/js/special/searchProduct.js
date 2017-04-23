$(function(){
	$('#levelOne').on('change', function(){
		var classId = this.value;
		var str = '<option value="-1">请选择分类</option>';
		if(classId != '-1'){
		    $.ajax({  
		        type: 'post',  
		        url: 'getClassByParentId',   
		        dataType:'json',
		        data:{'parentId':classId},
		        success: function(data) {
		            $.each(data.listClassLevelTwo, function(idx, obj){
		            	str += '<option value="'+obj.classId+'">'+obj.className+'</option>';
		            });
		            $('#levelTwo').empty();
		            $('#levelTwo').append(str);
		        },  
		        error: function(data) {  
		            alert(data);  
		        }  
		    });
		}else{
			$('#levelTwo').html(str);
		}
	});
	
	$('.edit_list').on('click',function(){
		parent.setProductInfo($(this).find('img').prop('src'),$(this).find('img').prop('alt'),$(this).data('id'));
	});
	
	$('.navbar-text.pull-right').removeClass('pull-right');
	$('.btn.btn-default.btn-info').css({top: '-7px',});
	
	
});