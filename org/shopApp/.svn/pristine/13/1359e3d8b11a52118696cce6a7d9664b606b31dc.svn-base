	$(function () {
		//时间选择器
		$(".date").datetimepicker({
			format: 'YYYY-MM-DD HH:mm:ss',
			showClear:true,
			locale:'zh-cn'
		});
		$("#regTimeStart").on("dp.change", function (e) {
		    $('#regTimeEnd').data("DateTimePicker").minDate(e.date);
		});
		$("#regTimeEnd").on("dp.change", function (e) {
		    $('#regTimeStart').data("DateTimePicker").maxDate(e.date);
		});
		$("#selectAll").click(function() { 
			$("input[name='userIds']").prop("checked",$("#selectAll").prop("checked"));
		});
	});
	
	function desc(userId){
		location.href="../user/desc/"+userId;
	}
	
	function lock(userId){
		$.ajax({  
	        type: "post",  
	        url: "../user/lock/"+userId,  
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
	
	function unLock(userId){
		$.ajax({  
	        type: "post",  
	        url: "../user/unLock/"+userId,  
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
	
	function doSelect(){
		var ids = [];
		$("input[name='userIds']").each(function(){
			if(true == $(this).prop("checked")){
				ids.push($(this).prop('value'));
			}
		});
		if(ids.length < 1){
			alert('请选择用户!');
			return;
		}
		parent.selectUserCallBack(ids.join(","));
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭
	}
	function doSingleSelect(userId,userName){
		parent.selectUserOneCallBack(userId,userName);
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭
	}