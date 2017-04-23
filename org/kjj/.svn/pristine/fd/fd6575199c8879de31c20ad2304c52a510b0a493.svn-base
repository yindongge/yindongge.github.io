$(function(){
	
	//增加图片楼层
	$("#addFloorBtn").on('click',function(){
		layer.open({
			 type: 2,
			    title: '轮播图片',
			    shadeClose: true,
			    shade: 0.8,
				maxmin: true, 
			    area: ['900px', '400px'],
			    content:'../touchPage/bannerDetail/'+$("[name='pageId']").val()+"/"+0,
		});
	});
	
	//点击编辑打开弹窗
	$("#picFloor").on('click','.btn.btn-success.btn-click',function(){
		layer.open({
		    type: 2,
		    title: '轮播图片',
		    shadeClose: true,
		    shade: 0.8,
			maxmin: true, 
		    area: ['900px', '400px'],
		    content: '../touchPage/bannerDetail/'+$('[name="pageId"]').val()+'/'+ $(this).data('id'),
		});
	});
	
	//删除楼层
	$('#picFloor').on('click','.glyphicon.glyphicon-remove-circle.closeme',function(){
		var delBtn=$(this);
		if(confirm('确定删除吗 ？')){
			$.ajax({
			    type: "post",  
			    dataType:"json", 
			    url: "../touchPage/deleteBanner/"+$(this).next().data('id'),  
			    success: function(data) {
			    	delBtn.parents('.panle_img').remove();
			    }
			});
		}
	});
	
	//拖曳排序
	 $('#picFloor').droppable({
		  drop:function( event, ui ) {
	        $('#notice').removeClass('alert-warning').addClass('alert-danger');
	        $('#notice div').text('请点击保存按钮保存排序！');
	        $('#picFloor').css({"border-color":"#f27777"});
	      }
	  }).sortable({
	    items: '.panle_img',
	  });
	 
	 $("#saveImageOrder").on('click',function(){
		 var ids='';
		 $("#picFloor a").each(function(i){
			 ids = ids+$(this).data("id")+",";
			 $(this).data("data-order-id",i+1);
		 });
		 ids=ids.substring(0, ids.length-1);
		 $.ajax({
			 type:'post',
			 url:'../touchPage/saveImageOrder',
			 data:{'pageId':$('[name="pageId"]').val(),'ids':ids},
			 dataType:'json',
			 success:function(data){
				 $('#notice').removeClass('alert-danger').addClass('alert-info');
			     $('#notice div').text('已保存排序！');
			     $('#picFloor').css({"border-color":"#bce8f1"});
			     location.reload();
			 }
		 });
	 });
});