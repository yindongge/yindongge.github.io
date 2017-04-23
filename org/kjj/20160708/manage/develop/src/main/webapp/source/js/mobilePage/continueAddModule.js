function uploadImage(){
$.ajaxFileUpload({
	url:"../mobilePage/uploadImage",
	secureuri:false,
	fileElementId:"file",
	dataType:"json",
	success:function(data){
		if(data.code == 200){
			$("#img").attr("src",data.url);
			$("#hid").attr("value",data.returnImgUrl);
		}
	},
	error:function(data){}
});
}

function saveModule(){
		if($("#img").attr("src") == ''){
			$('#tip').empty();
			$('#tip').removeAttr('class').html("<b color='red'>图片不能为空</b>");
			return false;
		}
		$.ajax({
			type:'post',
			url:'../mobilePage/saveMobileModel',
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

$(function(){
	$("img").on('click',function(){
		$("#file").click();
	})
});