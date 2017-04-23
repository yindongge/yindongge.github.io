
function doEdit(a){
	location.href="../mobilePage/editPage?pageId="+a;
}
function doDelete(a){
	if(!confirm("确定要删除该记录？")){
		return;
	}
	$.ajax({  
        type: "post",  
        url: "../mobilePage/delete?pageId="+a,  
        success: function(data) {  
           alert("删除成功！");
           window.location.href="../mobilePage/list";
        },  
        error: function(data) {  
            alert(data);  
        }  
    });

}
function doAdd(){
	window.location.href="../mobilePage/add";
}