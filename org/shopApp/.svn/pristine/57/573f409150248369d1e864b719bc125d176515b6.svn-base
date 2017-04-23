$(function(){
	$('#addBtn').on('click',function(){
		//iframe层
		layer.open({
		type: 2,
		title: '添加',
		shadeClose: true,
		shade: 0.8,
		maxmin: true, //开启最大化最小化按钮
		area: ['600px', '450px'],
		content: 'add' //iframe的url
		}); 
	});
	
	$(':button[name="editBtn"]').on('click',function(){
		//iframe层
		layer.open({
		type: 2,
		title: '添加',
		shadeClose: true,
		shade: 0.8,
		maxmin: true, //开启最大化最小化按钮
		area: ['600px', '450px'],
		content: 'edit/'+$(this).parent().find(':hidden').val() //iframe的url
		}); 
	});
	

	$(':button[name="deleteBtn"]').on('click',function(){
		$.ajax({
			url : 'delete/' + $(this).parent().find(':hidden').val(),
			type : 'post',
			dataType : 'json',
			success : function(data){
				alert(data.message);
				location.reload();
			}
		});
	});
});	