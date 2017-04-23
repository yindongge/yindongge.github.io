$(function () {
		 
	    //发放对象选择
	    $("#giveType").change(function(){
	    	var giveType = $("#giveType :selected").val();
	    	if(giveType == 0){
	    		$("#giveTypePart").hide();
	    	}else if(giveType == 1){
	    		$("#giveTypePart").show();
	    	}
	    });
	    
	  	//校验
		$("#couponGive").bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			}
		});
	});