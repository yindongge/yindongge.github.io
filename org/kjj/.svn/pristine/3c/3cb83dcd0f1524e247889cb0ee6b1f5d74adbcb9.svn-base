$(function(){
	moveBanner();
	$('#continueAdd').click(function(){
		//iframe层
		layer.open({
		type: 2,
		title: '新增轮播图',
		shadeClose: true,
		shade: 0.8,
		maxmin: true, //开启最大化最小化按钮
		area: ['800px', '450px'],
		content:'../mobilePage/AddNewBanner?pageId='+$("#pageId").val()+'&flag='+$("#flag").val()
		});
	})
})

function editBanner(id){
	//iframe层
	layer.open({
	type: 2,
	title: '编辑轮播图',
	shadeClose: true,
	shade: 0.8,
	maxmin: true, //开启最大化最小化按钮
	area: ['800px', '450px'],
	content: '../mobilePage/editBanner?id='+id
	});
}

function doDelete(id){
	if(!confirm("确定要删除该轮播图？")){
		return;
	}
	$.ajax({
		type:'post',
		url:'../mobilePage/deleteBanner?id='+id,
		success:function(data){
			alert("删除成功");
			window.location.href='../mobilePage/bannerList?pageId='+$("#pageId").val();
		},
		error:function(data){
			alert(data);
		}
	});
}

function moveBanner(){
	$('.up_me').off('click');
	$('.down_me').off('click');
	$('.up_me').on('click',function(){
		if($(this).parent().prev().hasClass('panle_img')){
		var clickId = $(this).parent().find("input").attr("value");
		var id = $(this).parent().prev().find("input").attr("value");
		$(this).parent().insertBefore($(this).parent().prev());
		$.ajax({
			type:'post',
			url:'../mobilePage/bannerOrder',
			data:{'clickId':clickId,'id':id},
			dataType:'json',
			success:function(data){
			 if(data.code == 200){
				window.location.href='../mobilePage/bannerList?pageId='+$("#pageId").val();
			  }
			},
			error:function(data){}
		});
		}
	});
	$('.down_me').on('click',function(){
		if(!$(this).parent().next().hasClass('continute')){
			var clickId = $(this).parent().find("input").attr("value");
			var id = $(this).parent().next().find("input").attr("value");
			$(this).parent().insertAfter($(this).parent().next());
			$.ajax({
				type:'post',
				url:'../mobilePage/bannerOrder',
				data:{'clickId':clickId,'id':id},
				dataType:'json',
				success:function(data){
					if(data.code == 200){
						window.location.href='../mobilePage/bannerList?pageId='+$("#pageId").val();
					}
				},
				error:function(data){}
			});
		}
	});
}

//function cancel(){
//	window.location.href="../mobilePage/list";
//}