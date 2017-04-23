function publish(){
		location.href="../article/add";
	}
	
	function updatestatus(a,b){
		  $.ajax({  
		        type: "post",  
		        url: "../article/updatestatus?id="+a+"&status="+b,   
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
	
	function deleteArticle(articleId,shopId){
		 $.ajax({  
		        type: "post",  
		        url: "../article/delete?articleId="+articleId+"&shopId="+shopId,   
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
	
	function updateData(a){
		location.href="../article/edit/"+a;
	}