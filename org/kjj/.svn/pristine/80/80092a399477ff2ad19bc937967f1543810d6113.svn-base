$(function(){
	//初始化富文本编辑器
    KindEditor.ready(function(K) {
   	 	K.create('#area', {
   		 	width : '910px',
   		 	height : '400px',
   		 	filterMode: false,
   		    newlineTag : "br",
            uploadJson : '../kindEditor/fileUpload',  
            fileManagerJson : '../kindEditor/fileManager',  
            allowFileManager : true,
            afterCreate : function() { 
                $("#tijiao").click(function(){
                	K.sync("#area");
                	var htmlData = $("#area").val();
                	var pageId = $("#pageId").val();
                	if(htmlData.length > 5000){
                		$("#checkmsg").empty();
                		$("#checkmsg").html("html长度不能超过5000");
                		return false;
                	}
                	K.ajax('../mobilePage/saveCustomize', function(data) {
                		if(data.code == 200){
            				alert("保存html成功");
            				location.href='../mobilePage/customize?pageId='+$("#pageId").val();
            			}
	                }, 'POST', {
	                	pageId : pageId,
	                	htmlText : htmlData
	                });

                });
               }, 
         });  
    });
});

function cancle(){
	window.location.href="../mobilePage/list";
}