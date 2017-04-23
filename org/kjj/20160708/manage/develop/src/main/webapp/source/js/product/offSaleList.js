$(function(){
	$(':button[name="editBtn"]').on('click', function(){
		location.href = 'edit/' + $(this).parent().find(':input[name="spuId"]').val();
	});
	
	$(':button[name="onSaleBtn"]').on('click', function(){
		if(confirm('确认上架？')){
			$.ajax({
				url : 'onSale/' + $(this).parent().find(':input[name="spuId"]').val(),
				type : 'get',
				dataType : 'json',
				success : function(result){
					if(result.code == 200){
						alert('已上架');
						location.reload();
					}else{
						alert('上架失败');
					}
				}
			});
		}
	});
	
	$(':button[name="deleteBtn"]').on('click', function(){
		if(confirm('确认删除？')){
			$.ajax({
				url : 'delete/' + $(this).parent().find(':input[name="spuId"]').val(),
				type : 'get',
				dataType : 'json',
				success : function(result){
					if(result.code == 200){
						alert('已删除');
						location.reload();
					}else{
						alert('删除失败');
					}
				}
			});
		}
	});
	
	$(':input[name="checkAll"]').on('click', function(){
		if($(this).prop('checked')){
			$(':input[name="goodsIds"]').prop('checked', 'checked');
		}else{
			$(':input[name="goodsIds"]').removeProp('checked');
		}
	});
	
	$(':button[name="batchOnSaleBtn"]').on('click', function(){
		if($(':checked[name="goodsIds"]').length == 0){
			alert('请选择商品');
		}
		if($(':checked[name="goodsIds"]').length > 0){
			$.ajax({
				url : 'batchOnSale',
				type : 'post',
				dataType : 'json',
				data : $(':checked[name="goodsIds"]').serialize(),
				traditional: true,
				success : function(data){
					location.reload();
				}
			});
		}
	});
	
	$(':button[name="batchDeleteBtn"]').on('click', function(){
		if($(':checked[name="goodsIds"]').length == 0){
			alert('请选择商品');
		}
		if($(':checked[name="goodsIds"]').length > 0){
			$.ajax({
				url : 'batchDelete',
				type : 'post',
				dataType : 'json',
				data : $(':checked[name="goodsIds"]').serialize(),
				traditional: true,
				success : function(data){
					location.reload();
				}
			});
		}
	});
	
	$('#classLevel1').on('change', function(){
		var classId = this.value;
		if(classId != '-1'){
		    $.ajax({  
		        type: 'post',  
		        url: '../class/getClassesByParent/'+classId,   
		        dataType:'json',
		        success: function(data) {
		       		var str = '<option value="-1">请选择分类</option>';
		            $.each(data, function(index, item){
		            	str += '<option value="'+item.classId+'">'+item.className+'</option>';
		            });
		            $('#classLevel2').empty();
		            $('#classLevel2').append(str);
		        },  
		        error: function(data) {  
		            alert(data);  
		        }  
		    });
		}else{
			$('#classLevel2').empty();
		}
	});
});