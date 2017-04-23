$(function(){
	$(':button[name="editBtn"]').on('click', function(){
		location.href = 'edit/' + $(this).parent().find(':input[name="spuId"]').val();
	});
	
	$(':button[name="offSaleBtn"]').on('click', function(){
		if(confirm('确认下架？')){
			$.ajax({
				url : 'offSale/' + $(this).parent().find(':input[name="spuId"]').val(),
				type : 'get',
				dataType : 'json',
				success : function(result){
					if(result.code == 200){
						alert('已下架');
						location.reload();
					}else{
						alert('下架失败');
					}
				}
			});
		}
	});
	
	$(':button[name="batchOffSaleBtn"]').on('click', function(){
		if($(':checked[name="goodsIds"]').length == 0){
			alert('请选择商品');
		}
		if($(':checked[name="goodsIds"]').length > 0){
			$.ajax({
				url : 'batchOffSale',
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
	$(':input[name="checkAll"]').on('click', function(){
		if($(this).prop('checked')){
			$(':input[name="goodsIds"]').prop('checked', 'checked');
		}else{
			$(':input[name="goodsIds"]').removeProp('checked');
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