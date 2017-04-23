$(function(){
	$(':button[name="editBtn"]').on('click', function(){
		window.location.href = 'edit?advertisementId=' + $(this).parent().find(':hidden').val() + '&listPageNum=' + $(':hidden[name="pageNow"]').val()  + '&classLevel1=' + $('#classLevel1').val() + '&classLevel2=' + $('#classLevel2').val();
	});
	
	$(':button[name="deleteBtn"]').on('click', function(){
		$.ajax({
			url : 'delete/' + $(this).parent().find(':hidden').val(),
			type : 'get',
			success : function(data){
				if(data.code == '200'){
					alert('删除成功');
					location.reload();
				}
			}
		});
	});
	
	$("#classLevel1").change(function(){
		$.ajax({
			url : '../class/getClassesByParent/' + $("#classLevel1").val(),
			type : 'get',
			dataType : 'json',
			success : function(data){
				var html = '<option value="-1">请选择</option>';
				$.each(data, function(){
					var item = this;
					html +='<option value="'+item.classId+'">'+item.className+'</option>';
				});
				$("#classLevel2").empty();
				$("#classLevel2").append(html);
			},
			error : function(data){
				alert(data);
			}
		});
	});	
});


