function delAdmin(a){
	$.ajax({  
        type: "post",  
        url: "../admin/del/"+a,  
        success: function(data) {  
           if(data.code==200){
        	   location.reload();
           }
        },  
        error: function(data) {  
            alert("系统错误");  
        }  
    })  ;
}

