//添加推荐
function add(goodsId){
	if($('#typeId').val() == -1){
		alert("类型不能为空");
		return false;
	}
	$(':hidden[name="skuId"]').val(goodsId);
	$.ajax({
		url : 'save',
		type : 'post',
		data : $('form').serialize(),
		success : function(data){
			if(data.code == '400'){
				alert(data.message);
			}
			if(data.code=='200'){
				window.location.href = 'edit?advertisementId=' + data.id + '&goodsNameLike=' + $(':input[name="goodsNameLike"]').val() + '&pageNumber=' + $(':hidden[name="pageNow"]').val();
			};
		},
		error : function(data){
			
		}
	});
};

$(function(){
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