$(function(){
	$('#addBtn').on('click',function(){
		layer.open({
			type: 2,
			title: '添加分类 ',
			shadeClose: true,
			shade: 0.8,
			maxmin: true, //开启最大化最小化按钮
			area: ['600px', '450px'],
		    content: 'add'
		});
	});
	
	$(':input[name="editBtn"]').on('click',function(){
		layer.open({
			type: 2,
			title: '编辑分类',
			shadeClose: true,
			shade: 0.8,
			maxmin: true, //开启最大化最小化按钮
			area: ['600px', '450px'],
		    content: 'edit/'+$(this).parent().find(':hidden').val()
		});
	});
	
	$(':input[name="deleteBtn"]').on('click',function(){
		if(confirm('确认删除？删除后，如果此分类下有商品，则此分类下的商品将下架，商品里的sku将清空')){
			var id = $(this).parent().find(':hidden').val();
			$.ajax({
				url : 'deleteValidate/' + id,
				type : 'post',
				dataType : 'json',
				data : {},
				success : function(data){
					if(data.code == 200){
						$.ajax({
							url : 'delete/' + id,
							type : 'post',
							dataType : 'json',
							data : {},
							success : function(data){
								if(data.code == 200){
									alert('删除成功');
									location.reload();
								}else{
									alert('删除失败');
								}				
							}
						});
					}else if(data.code == 400){
						alert('此分类下有子分类，不可删除');
					}else{
						alert('删除失败');
					}				
					//location.reload();
				}
			});
		}
	});
});