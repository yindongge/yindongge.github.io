function openlayer(){
	//location.href="${ctx}/article/add";
	layer.open({
		type: 2,
		title: '文章分类 ',
		shadeClose: true,
		shade: 0.8,
		maxmin: true, //开启最大化最小化按钮
		area: ['600px', '450px'],
	    content: '../articleClass/add'
	});
} 

function editclass(a){
	
	layer.open({
		type: 2,
		title: '编辑分类',
		shadeClose: true,
		shade: 0.8,
		maxmin: true, //开启最大化最小化按钮
		area: ['600px', '450px'],
	    content: '../articleClass/edit/'+a
	});
	
} 

function deleteclass(a){
	
	$.ajax({
        url:"../articleClass/delete/"+a,
        type:'POST',
        data:{'classid':a},
        cache:false,
        dataType:"json",
        success:function(data){
            if(data.code ==200){
              location.reload(); 
            }else{
              alert("系统错误");
            }
        }
    }); 
} 