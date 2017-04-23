function openlayer(){
	layer.open({
		type: 2,
		title: '添加菜单 ',
		shadeClose: true,
		shade: 0.8,
		maxmin: true, //开启最大化最小化按钮
		area: ['800px', '500px'],
	    content: '../menu/addInit'
	});
} 

function editMenu(modelid){
	layer.open({
		type: 2,
		title: '编辑菜单',
		shadeClose: true,
		shade: 0.8,
		maxmin: true, //开启最大化最小化按钮
		area: ['800px', '500px'],
	    content: '../menu/editInit?modelid='+modelid
	});
} 

function deleteMenu(modelid){
	if(confirm("确定要删除么？")){
		$.ajax({
	        url:"../menu/delete",
	        type:'POST',
	        data:{'modelid':modelid},
	        cache:false,
	        dataType:"json",
	        success:function(data){
	            if(data == 200){
	              location.reload(); 
	            }
	        }
	    });
	}
} 