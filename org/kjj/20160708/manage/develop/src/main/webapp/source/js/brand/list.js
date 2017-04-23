function openlayer(){
	
	layer.open({
		type: 2,
		title: '111',
		shadeClose: true,
		shade: 0.8,
		maxmin: true, //开启最大化最小化按钮
		area: ['600px', '450px'],
	    content: '${ctx}/product/classify/add'
	});
	
}; 
$(function(){
	$('#classLevel').on('change',function(){
		var selectid = $("#classLevel").val();		
	    $.ajax({  
	        type: "post",  
	        url: "../class/getClassesByLevel/"+selectid,  
	        success: function(data) {  
	            var list =data;
	       		var str = '';
	            for(var i=0; i< list.length;i++){
	            	str += '<option value="'+list[i].classId+'">'+list[i].className+'</option>';
	            }
	            $("#classId").empty();
	            $("#classId").append(str);
	        },  
	        error: function(data) {  
	            alert(data);  
	        }  
	    });
	});
	
	$(':input[name="deleteBtn"]').on('click', function(){
		var id = $(this).parent().find(':hidden').val();
		$.ajax({  
			url: 'delete/'+id,
	        type: 'post',  
	        dataTyp: 'json',
	        success: function(data) {  
	        	if(data.code == 200){
	        		alert('删除成功');
	        		location.reload();
	        	}
	           
	        },  
	        error: function(data) {  
	            alert(data);  
	        }  
	    });
	});
	
	$(':input[name="editBtn"]').on('click',function(){
		var id = $(this).parent().find(':hidden').val();
		layer.open({
			type: 2,
			title: '编辑品牌',
			shadeClose: true,
			shade: 0.8,
			maxmin: true, //开启最大化最小化按钮
			area: ['800px', '650px'],
		    content: 'edit/'+id
		});
	});
	
	$('#addBtn').on('click',function(){
		layer.open({
			type: 2,
			title: '添加品牌',
			shadeClose: true,
			shade: 0.8,
			maxmin: true, //开启最大化最小化按钮
			area: ['800px', '650px'],
		    content: 'add'
		});
	});
});