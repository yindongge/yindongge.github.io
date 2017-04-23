$(function(){
	$('.color').iColor({'x': 10, 'y': -50});
	$('.color').iColor(function(hx) {
		$('#bgColor').val('').css('background', '#' + hx);
		$('#bgColor').val('#' + hx)
	});
});
function saveBanner(){
	if($('.imggroup:has(a)').length == 0){
		$('#tip').empty();
		$('#tip').removeAttr('class').html("<b color='red'>图片不能为空</b>");
		return false;
	}
	$.ajax({
		type:'post',
		url:'../mobilePage/saveMobileBanner',
		dataType:'json',
		data:$("#mobilePageform").serialize(),
		success:function(data){
			if(data.code == 200){
				parent.location.reload(); //刷新父页面
				var index = parent.layer.getFrameIndex(window.name); //获取当前layer窗体索引 
				parent.layer.close(index); //执行关闭
				}
		},
		error:function(data){
			
		}
	});
}