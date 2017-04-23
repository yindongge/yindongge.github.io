$(function(){
	$(".imggroup").on("click","i",function(){$(this).parents("a").next(":hidden").remove();$(this).parents("a").remove()});
	
	$('.color').iColor({'x': 10, 'y': -50});
	$('.color').iColor(function(hx) {
		$('#bgColor').val('').css('background', '#' + hx);
		$('#bgColor').val('#' + hx)
	});
});
function uploadImage(){
	$(".imggroup").empty();
$.ajaxFileUpload({
	url:"../mobilePage/uploadImage",
	secureuri:false,
	fileElementId:"file",
	dataType:"json",
		success:function(data){
			$(".imggroup").append("<a><img src='"+data.url+"'><i>删除</i></a><input type='hidden' name='bannerImg' value='"+data.returnImgUrl+"'/>")
			},
		error:function(data){
			$("#bImg").html("图片上传失败！").show()
		}
	});
}

function updateBanner(){
	if($('.imggroup:has(a)').length == 0){
		$('#tip').empty();
		$('#tip').removeAttr('class').html("<b color='red'>图片不能为空</b>");
		return false;
	}
	$.ajax({
		type:'post',
		url:'../mobilePage/updateMobileBanner',
		dataType:'json',
		data:$('#mobilePageBannerform').serialize(),
		success:function(data){
			if(data.code == 200){
				parent.location.reload(); //刷新父页面
				var index = parent.layer.getFrameIndex(window.name); //获取当前layer窗体索引 
				parent.layer.close(index); //执行关闭 
			}
		},
		error:function(data){}
	});
}