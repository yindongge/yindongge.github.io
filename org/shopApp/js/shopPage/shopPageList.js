
function doEdit(a){
	location.href="../shopPage/editPage?pageId="+a;
}
function doDelete(a){
	if(!confirm("确定要删除该记录？")){
		return;
	}
	$.ajax({  
        type: "post",  
        url: "../shopPage/delete?pageId="+a,  
        success: function(data) {  
           alert("删除成功！");
           window.location.href="../shopPage/list";
        },  
        error: function(data) {  
            alert(data);  
        }  
    });

}
function doAdd(){
	window.location.href="../shopPage/add";
}