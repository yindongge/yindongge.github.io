$(function(){
	//增加图片楼层
	$('#addFloorBtn').on('click',function(){
		layer.open({
		    type: 2,
		    title: '专题图片',
		    shadeClose: true,
		    shade: 0.8,
			maxmin: true, 
		    area: ['900px', '400px'],
		    content: '../editProduct/'+$('[name="specialId"]').val()+'/'+ 0
		});
	});
	
	//点击编辑打开弹窗
	$('#productFloor').on('click','.btn.btn-success.btn-click',function(){
		layer.open({
		    type: 2,
		    title: '专题图片',
		    shadeClose: true,
		    shade: 0.8,
			maxmin: true, 
		    area: ['900px', '400px'],
		    content: '../editProduct/'+$('[name="specialId"]').val()+'/'+ $(this).data('id')
		});
	});
	
	//删除楼层
	$('#productFloor').on('click','.btn.btn-danger',function(){
		var delBtn=$(this);
		if(confirm('确定删除吗 ？')){
			$.ajax({
			    type: "post",  
			    dataType:"json", 
			    url: "../deleteFloor/"+$(this).prev().data('id'),  
			    success: function(data) {
			    	delBtn.parents('.fenzushangpin').remove();
			    }
			});
		}
	});
	
	//拖曳排序
	 $('#productFloor').droppable({
		  drop:function( event, ui ) {
			  $('#notice').removeClass('alert-warning').addClass('alert-danger');
		      $('#notice div').text('请点击保存按钮保存排序！');
		      $('#productFloor').css({"border-color":"#f27777"});
	      }
	  }).sortable({
	    items: '.fenzushangpin',
	  });
	 
	//保存拖曳排序
	 $('#saveProductOrder').on('click',function(){
		 var ids='';
		 $("#productFloor .btn.btn-success.btn-click").each(function(i){
			 ids=ids+$(this).data('id')+",";
			 $(this).data('data-order-id',i+1);
		 });
		 ids=ids.substring(0,ids.length-1);
		 $.ajax({
			 type: "post",  
			 dataType:"json", 
			 url: "../saveProductOrder",  
			 data: {'specialId':$('[name="specialId"]').val(),'ids':ids},
			 success: function(data) {
				 $('#notice').removeClass('alert-danger').addClass('alert-info');
			     $('#notice div').text('已保存排序！');
			     $('#productFloor').css({"border-color":"#bce8f1"});
			     var evalJs=location.href="../editAnchor/"+$('[name="specialId"]').val();
				 setTimeout(evalJs,1000);
			 }
		 });
	 });
	 
	 
});

//弹出框保存时刷新父窗口
function refreshForm(){
	location.reload();
}
