	$(function () {
		//城市选择
	    $("#city").click(function(){
	    	var cityName = $(this).val();
	    	$(".overflow5").hide();
	    	$(".overflow5 :checkbox").prop("checked",false);
	    	$("#divCity"+cityName+" :checkbox").prop("checked",false);
	    	$("#divCity"+cityName).show();
	    });
	    
		//确定
		$("#btnConfirm").click(function(){
			var chk_value =[];//定义一个数组    
			var chk_text = [];//店铺的名称
            $("[name='shopIds']:checked").each(function(){    
            	chk_value.push($(this).val());
            	chk_text.push($(this).next().text());
            });
			parent.selectShopCallBack(chk_value,chk_text);
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
	function inserseSelect(){
		$("input[name='shopIds']").each(function(){this.checked=!this.checked;});
	}
	function setHighlight(){
		var queryShop = $("#queryShop").val().trim();
		if(queryShop==""){
			$("#queryShopNote").html("<font color='red'>请输入店铺名称!<font>");
			return;
		}else{
			$("#queryShopNote").html("&nbsp;");
		}
		$("span[id='shopNameText']").each(function(){
			$(this).removeClass("highlight")
			if($(this).html().indexOf(queryShop) != -1){
				$(this).addClass('highlight');
			}
		});
	}
	