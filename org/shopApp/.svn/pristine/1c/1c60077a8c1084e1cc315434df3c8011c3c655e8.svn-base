$(function(){
	 $('.btn-success.btn-xs').on('click',function(){
			var btn=$(this);
			$.ajax({  
				type: "post",  
				dataType: "json",
				url: "updateStatus",
				data: {'specialId':btn.parent().attr('data-id'),'status':1},
				success:function(data){
					if(data=200){
						btn.parent().prev().text("已启用");
						btn.hide();
						btn.siblings('.btn-danger.btn-xs').show();
					}
				}
			});  
		});
	    
		$('.btn-danger.btn-xs').on('click',function(){
			var btn=$(this);
			$.ajax({  
				type: "post",  
				dataType: "json",
				url: "updateStatus",
				data: {'specialId':btn.parent().attr('data-id'),'status':0},
				success:function(data){
					if(data=200){
						btn.parent().prev().text("已停用");
						btn.hide();
						btn.siblings('.btn-success.btn-xs').show();
					}
				}
			});
		});
});

function doDelete(id){
	if(!confirm("确定要删除该记录？")){
		return;
	}
	$.ajax({  
        type: "post",  
        url: "delete/"+id,  
        success: function(data) {  
           alert("删除成功！");
           window.location.href="list";
        },  
        error: function(data) {  
            alert(data);  
        }  
    });

}

function doEdit(id){
	var pageNumber=$('li a.current').text();
	location.href="edit/"+id+"/"+pageNumber;
}