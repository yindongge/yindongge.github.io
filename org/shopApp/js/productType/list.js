function addType(){
	window.location.href="add";
};
function deleteType(type_id){
    $.ajax({  
        type: 'GET',  
        url: 'delete/'+type_id,  
        dataType: 'json',
        success: function(data) {  
				alert(data.message);
				location.reload();
        },  
        error: function(data) {  
            alert(data);  
        }
    });	
};
function editView(type_id){
	window.location.href='edit/'+type_id;
};
function viewType(type_id){
	window.location.href="view/"+type_id;
};