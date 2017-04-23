$(function(){
	//增加图片楼层
	$('#addFloorBtn').on('click',function(){
		var anchorFloorHtml=$('#anchorFloorTmp').html().replace('display:none',"");
		$('.link_url').append(anchorFloorHtml);
		setfieldName();
	});
	
	$('.link_url').on('blur','[validate="url"]',function(){
		if(!isURL($(this).val())){
			$(this).val('');
			alert('请输入正确的url，以"http://"开头');
		}
	});
	
	$('.link_url').on('click','.glyphicon.glyphicon-remove-circle.closeme',function(){
		var delBtn=$(this);
		if(confirm('确定删除吗 ？')){
			if(delBtn.data('id')!=0){
				$.ajax({
					type: "post",  
					dataType:"json", 
					url: '../deleteAnchor/'+delBtn.data('id'),
					success: function(data) {
						delBtn.parents('.url_list').remove();
						setfieldName();
					}
				});
			}else{
				delBtn.parents('.url_list').remove();
				setfieldName();
			}
		}
	});
	
	setfieldName();
	
	
});


function setfieldName(){
	$('.link_url').find('.url_list :text:first-child').each(function(i){
		$(this).prop('name','orgSpecialLinkList['+i+'].title');
		$(this).next().prop('name','orgSpecialLinkList['+i+'].url');
	});

}





