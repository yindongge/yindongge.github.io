var index=1;
var goodsIdStr=",";
$(function(){
	$('.row').on('change',':file', function(){
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
	            		$('#'+id).prev().attr('src',data.picUrlForShow);
	            		$('#'+id).next().val(data.picUrlForSave);
	            	}
	            },
	            error: function (data, status, e){
	            }
	        });
		}
	});
	
	//删除已选择
	$('.edit_wrapper').on('click','.glyphicon.glyphicon-remove-circle.closeme.product',function(){
		var goodsIdDel=$(this).next().val();
		goodsIdStr=goodsIdStr.replace(","+goodsIdDel,"");
		$(this).parents('.edit_list').remove();
		setProductFieldName();
	});
	
	//新增活动图楼层
	$('#addPicbtn').on('click',function(){
		var picHtml=$('#picTmp').html().replace('display:none',"");
		$('.continute').before(picHtml);
		setProductFieldName();
		setFieldId();
	});
	
	$('#saveForm').on('click',function(){
		if($('[name="imgPath"]').val()==""){
			alert('请上传分组图片');
			return false;
		}
		else if($('#productRow').find('.edit_list').length==0){
			alert('请选择商品');
			return false;
		}
		else if(!checkAcivityPic()){
			alert('请上传活动图片，填写链接地址');
			return false;
		}
		else{
			$(this).attr('disabled','disabled');
			$.ajax({
				type:'post',
				url:'../../saveProduct',
				dataType:'json',
				data:$("#mainForm").serialize(),
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
	
	//初始化商品Id字符串
	$('.edit_wrapper').find(':hidden').each(function(i){
		goodsIdStr=goodsIdStr+","+$(this).val();
	});
	
	$('#uploadPic').on('blur','[validate="url"]',function(){
		if(!isURL($(this).val())){
			$(this).val('');
			alert('请输入正确的url，以"http://"开头');
		}
	});
	
	//删除活动图片
	$('#uploadPic').on('click','.glyphicon.glyphicon-remove-circle.closeme.pic',function(){
		if(confirm('确定删除吗 ？')){
			var picId=$(this).data('id');
			if(picId!='0'){
				$.ajax({
					type:'post',
					url:'../../deleteProductPic/'+$(this).data('id'),
					dataType:'json',
					success:function(data){
						if(data== 200){
						}
					}
				});
			}
			$(this).parents('.form-group.alert_control').remove();
			setProductFieldName();
		}
	});
	
	//初始化name
	setProductFieldName();
	//初始化Id
	setFieldId();
	
});

function setFieldId(){
	$('.row').find(':file').each(function(i){
		$(this).attr('id',"file"+i);
	});
}



//选择商品
function setProductInfo(imgPath,titlePath,goodsId){
	if(goodsIdStr.indexOf(goodsId)==-1){
		goodsIdStr=goodsIdStr+","+goodsId;
		var item=$('#productTmp').find('.edit_list');
		item.attr('title',titlePath);
		item.find('img').prop('src',imgPath);
		item.find('img').prop('alt',titlePath);
		item.find('a').text(titlePath);
		item.find(':hidden').val(goodsId);
		var productFloorHtml=$('#productTmp').html().replace('style=\"display:none\"',"");
		$('.edit_wrapper').append(productFloorHtml);
		setProductFieldName();
	}
}

function setProductFieldName(){
	$('.edit_wrapper').find(':hidden').each(function(i){
		$(this).prop('name','productList['+i+'].goodsId');
	});
	var length=parseInt($('.edit_wrapper').find(':hidden').length);
	$('#uploadPic').find(':hidden').each(function(i){
		var newIndex=i+length;
		$(this).prop('name','productList['+newIndex+'].imagePath');
	});
	$('#uploadPic').find('.picLink').each(function(i){
		var newIndex=i+length;
		$(this).prop('name','productList['+newIndex+'].url');
	});
}


function checkAcivityPic(){
	var flg=true;
	$('#uploadPic').find('.url_list').each(function(){
		if($(this).find(':hidden').val()==""){
			 flg=false;
		}
		if($(this).find(':text').val()==""){
			flg=false;
		}
	});
	return flg;
}





