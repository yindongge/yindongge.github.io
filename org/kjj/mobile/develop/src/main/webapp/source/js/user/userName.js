$(function () {
    //定位
    $("#aSubmit").click(function(){
    	var userName = $("#userName").val();
    	if(userName == ""){
    		autoAlert("用户名不能为空");
    		return false;
    	}
    	if(isNumber(userName)){
    		autoAlert("用户名格式错误，不可为全部为数字");
    		return false;
    	}
    	if(isEmail(userName)){
    		autoAlert("用户名格式错误，不可为邮箱");
    		return false;
    	}
    	if(!isUserName(userName)){
    		autoAlert("用户名格式错误，应为4-20位数字、汉字、“-”、“_”组成");
    		return false;
    	}
    	$.ajax({  
	        type: "post",  
	        dataType: "json",
	        url: "../user/userName",
	        data: {"userName":userName},
	        success: function(data) {
	        	if(data == 200){
	        		location.href="../user/detail";
	        	}else{
	        		autoAlert("该用户名已被使用");
	        	}
	        },  
	        error: function(data) {  
	        }  
	    }); 
    });
});