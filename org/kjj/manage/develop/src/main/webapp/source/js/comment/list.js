	$(function () {
        //查看
        $(":button[name='detail']").click(function(){
        	location.href="../comment/detail/"+$(this).parent().parent().find(":hidden[name='ids']").val();
		});
        
	});