function delRole(roleId){
	if(confirm("确定删除么?")){
		$.ajax({  
	        type: "post",  
	        url: "../role/del/"+roleId,  
	        success: function(data) { 
	        	if(data.code==200){
	        		location.reload();
	        	}
	        },  
	        error: function(data) {  
	            alert(data);  
	        }  
	    })  ;
	}
}