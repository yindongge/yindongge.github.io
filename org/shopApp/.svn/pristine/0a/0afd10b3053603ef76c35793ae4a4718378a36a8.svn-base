$(function(){
	$('#addBtn').click(function(){
		layer.open({
			type: 2,
			title: '添加',
			shadeClose: true,
			shade: 0.1,
			maxmin: true, //开启最大化最小化按钮
			area: ['800px', '450px'],
			content: 'add' //iframe的url
		}); 
	});
	
	$(':button[name="editBtn"]').on('click',function(){
		layer.open({
			type: 2,
			title: '添加',
			shadeClose: true,
			shade: 0.1,
			maxmin: true, //开启最大化最小化按钮
			area: ['800px', '450px'],
			content: 'edit/'+$(this).parent().find(':hidden').val() //iframe的url
		}); 
	});
	
	$(':button[name="deleteBtn"]').on('click',function(){
		if(confirm('确认删除')){
			$.ajax({
				url : 'delete/' + $(this).parent().find(':hidden').val(),
				type : 'post',
				dataType : 'json',
				success : function(data){
					alert(data.message);
					location.reload();
				}
			});
		}
	});
});