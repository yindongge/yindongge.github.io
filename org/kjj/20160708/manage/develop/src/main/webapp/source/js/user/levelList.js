$(function () {
	
})
function del(levelId){
	if(!confirm("确定要删除会员级别？")){
		return;
	}
	$.ajax({  
        type: "post",  
        url: "../userlevel/delete?levelId=" + levelId,
        success: function(data) {  
        	if(data.code==200){
        		 alert("删除成功!");
        		 window.location.href="../userlevel/list";
        	}
        	if(data.code==300){
        		 alert('该会员级别已经被使用，暂时无法删除!');
        	}
        },  
        error: function(data) {  
            alert("操作失败，请联系管理员或技术人员!");  
        }  
    });
}
function edit(levelId) {
	/*
	layer.open({
	    type: 2,
	    title: '修改会员级别',
	    shadeClose: true,
	    shade: 0.8,
	    shift:-1,
		maxmin: true, //开启最大化最小化按钮
	    area: ['600px', '650px'],
	    content: '../userlevel/findLevel?levelId=' + levelId
	}); */
	window.location.href='../userlevel/findLevel?levelId=' + levelId;
}
function doSyncUserLevel() {
	if(!confirm("确定要同步会员级别？")){
		return;
	}
	$.ajax({  
        type: "post",  
        url: "../userlevel/offlineSync",
        success: function(data) {  
        	if(data.code==200){
        		 alert("同步成功!");
        		 window.location.href="../userlevel/list";
        	}
        	if(data.code==501){
        		 alert("瑞星数据库中没有配置会员等级信息!");
        	}
        },  
        error: function(data) {  
            alert("操作失败，请联系管理员或技术人员!");  
        }  
    });
}
function showAdd(){
	window.location.href='../userlevel/preAdd';
}