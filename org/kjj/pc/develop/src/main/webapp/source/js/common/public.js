$(function(){
	$('[name="keyword"]').on('keypress',function(event){
        if(event.keyCode == "13"){
        	$(this).parent().find(':button').click();
        }
    });
});