	$(function () {
		
	    //城市选择
	    $("#city").click(function(){
	    	var cityName = $(this).val();
	    	$(".overflow5").hide();
	    	$(".overflow5 :checkbox").prop("checked",false);
	    	$("#divCity"+cityName+" :checkbox").prop("checked",true);
	    	$("#divCity"+cityName).show();
	    });
	    
		//确定
		$("#btnConfirm").click(function(){
			var chk_value =[];//定义一个数组    
            $("[name='shopIds']:checked").each(function(){    
            	chk_value.push($(this).val());
            });
			$("#listShop",window.parent.document).val(chk_value);
			//当你在iframe页面关闭自身时
			var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			parent.layer.close(index); //再执行关闭    
		});
		
		//取消
		$("#btnCancel").click(function(){
			//当你在iframe页面关闭自身时
			var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			parent.layer.close(index); //再执行关闭    
		});
	    
	});