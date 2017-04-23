$(function(){
	newBind();//每次执行完上传change事件后需要重新再绑定一次
	$('[validate="url"]').on('blur',function(){
		if(!isURL($(this).val())){
			$(this).val('');
			alert('请输入正确的url，以"http://"开头');
		}
	});
	
	$("#saveForm").on('click',function(){
		if($("[name='title']").val() == ""){
			alert('文字标题不能为空');
			return false;
		}else if($("[name='bannerImg']").val() == ""){
			alert('请上传图片');
			return false;
		}else if($("[name='bannerUrl']").val() == ""){
			alert('请填写图片跳转链接');
			return false;
		}else{
			$(this).attr('disabled','disabled');
			$.ajax({

				type:'post',
				url:'../../saveBanner',
				dataType:'json',
				data:$("form").serialize(),
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
	});
	
});

function newBind(){
	$(":file").on('change',function(){
		var uploadBtn = $(this);
		var id = uploadBtn.prop("id");
		if(checkPicType(uploadBtn.val())){
			$.ajaxFileUpload({
	            url:'../../uploadPicture',
	            type:'post',
	            secureuri:false,
	            fileElementId:id,
	            dataType: 'json',//返回值类型 一般设置为json
	            success: function (data){ 
	            	if(data.status==200){
	            		$('#'+id).prev().find('img').attr('src',data.picUrlForShow);
	            		$('#'+id).next().val(data.picUrlForSave);
	            		newBind();
	            	}
	            },
	            error: function (data, status, e){
	            }
	        });
		}
	});
}