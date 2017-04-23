$(function(){
	//new uploadPreview({ UpBtn: "up_img", DivShow: "imgdiv", ImgShow: "imgShow" });
	
	$(':file').on('change', function(){
		var uploadBtn=$(this);
		var id=uploadBtn.prop('id');
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
	            	}
	            },
	            error: function (data, status, e){
	            	alert(111);
	            }
	        });
		}
	});
	
	$('#saveForm').on('click',function(){	
		if($('[name="title"]').val()==""){
			alert('文字标题不能为空');
			return false;
		}else if($('#picUrl').val()==""){
			alert('请上传专题图');
			return false;			
		}else if($('[name="type"]:checked').val()==1 && $('[name="url"]').val()==""){
			alert('请输入图片跳转链接');
			return false;	
		}else if($('[name="type"]:checked').val()==2 && $('#showProduct').find(':hidden').val()==""){
			alert('请选择商品');
			return false;	
		}
		
		else{
			$(this).attr('disabled','disabled');
			$.ajax({
				type:'post',
				url:'../../savePic',
				dataType:'json',
				data:$("form").serialize(),
				success:function(data){
					if(data== 200){
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
	 
	$('.check_all_radio').find('input').each(function(){
		if($(this).prop('checked')){
			changeType($(this));
		}
	});
	
	$('.check_all_radio').find('input').on('click',function(){
		changeType($(this));
	});
		
	
	$('[validate="url"]').on('blur',function(){
		if(!isURL($(this).val())){
			$(this).val('');
			alert('请输入正确的url，以"http://"开头');
		}
	});
	
});

function changeType(curType){
	if(curType.val()==1){
		$('#showLink').show();
		$('#showProduct').hide();
		$('#getProduct').hide();
	}
	if(curType.val()==2){
		$('#showLink').hide();
		$('#showProduct').show();
		$('#getProduct').show();
	}
}

function setProductInfo(imgPath,titlePath,goodsId){
	var item=$('#showProduct').find('.edit_list');
	item.find('img').prop('src',imgPath);
	item.find('img').prop('alt',titlePath);
	item.find('a').text(titlePath);
	$('#goodsId').val(goodsId);
}
