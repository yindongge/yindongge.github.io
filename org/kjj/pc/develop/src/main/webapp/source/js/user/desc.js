$(function () {
	$('#birthday').datetimepicker({
		timepicker:false,
		format: "Y-m-d", //选择日期后，文本框显示的日期格式 
		lang: 'ch', //汉化 
	});
	
	$('#edit').click(function(){
		edit();
	});
});

function sethobbies(a){

	if (typeof($("#"+a).attr("class")) == "undefined"||$("#"+a).attr("class")=="")
	{
		$("#"+a).addClass("active");
	}else{
		$("#"+a).removeClass("active");
	}
	//循环获取 用户感兴趣的分类id
	var hobbies="";
	$(".fenlei a").each(function(index){
		if($(this).attr("class")=="active"){
			hobbies+=$(this).attr("value")+",";
		}
	});
	if(hobbies.length>0){
		$("#hobbies").val(hobbies.substring(0, hobbies.length-1));
	}else{
		$("#hobbies").val("");
	}
}
function changearea(a){
	$.ajax({  
	    type: "post",  
	    dataType:"json",
	    url: "../area/getByParentCode?parentCode="+$("#"+a).val(),  
	    success: function(data) {  
	       if(data.code==200){
	    	   $("#"+a+"1").empty();
	    	   var htmlstr="";
	    	   $.each(data.listArea,function(index,d){
	    		   htmlstr+="<option value=\""+d.code+"\" >"+d.name+"</option>";
	    		});
	    	   $("#"+a+"1").append(htmlstr);
	    	   if(a.length==3){
	    		   $.ajax({  
	    			    type: "post",  
	    			    dataType:"json",
	    			    url: "../area/getByParentCode?parentCode="+$("#"+a+"1").val(),  
	    			    success: function(data) {  
	    			       if(data.code==200){
	    			    	   $("#"+a+"11").empty();
	    			    	   var htmlstr="";
	    			    	   $.each(data.listArea,function(index,d){
	    			    		   htmlstr+="<option value=\""+d.code+"\" >"+d.name+"</option>";
	    			    		   });
	    			    	   $("#"+a+"11").append(htmlstr);
	    			       }else{
	    			       }
	    			    },  
	    			    error: function(data) {}  
	    			});
	    	   }
	       }else{
	    	   
	       }
	    },  
	    error: function(data) { }  
	});
}

function edit(){
	$('#userValidate').html("");
	$('#addressValidate').html("");
	var userName = $("#userName").val();
	if(userName == ""){
		$('#userValidate').html("用户名不能为空");
   		$('#userValidate').show();
		return false;
	}
	if(isNumber(userName)){
		$('#userValidate').html("用户名格式错误，不可为全部为数字");
   		$('#userValidate').show();
		return false;
	}
	if(isEmail(userName)){
		$('#userValidate').html("用户名格式错误，不可为邮箱");
   		$('#userValidate').show();
		return false;
	}
	if(!isUserName(userName)){
		$('#userValidate').html("用户名格式错误，应为4-20位数字、汉字、“-”、“_”组成");
   		$('#userValidate').show();
		return false;
	}
	var addressdesc = $("#addressdesc").val();
	if(addressdesc == ""){
		$('#addressValidate').html("用户地址不能为空！");
   		$('#addressValidate').show();
		return false;
	}
	if(addressdesc.length > 100){
		$('#addressValidate').html("用户地址长度不超过100字符长度！");
		$('#addressValidate').show();
		return false;
	}
	$('#edit').attr('disabled',"true");
	 $.ajax({
         type: "POST",
         dataType: "json",
         url: "../user/edit",
         data: $('#form').serialize(),
         success: function (data) {  
            if(data.code==200){
            	$("#userValidate").hide();
            	showBox();
           		$('#edit').removeAttr("disabled"); 
            }
            if(data.code==400){
           		$('#userValidate').html(data.desc);
           		$('#userValidate').show();
           		$('#edit').removeAttr("disabled"); 
            }
            if(data.code==402){
            	$('#addressValidate').html(data.desc);
           		$('#addressValidate').show();
           		$('#edit').removeAttr("disabled"); 
            }
         },
         error: function(data) {
        	 $('#edit').removeAttr("disabled");
          }
     });
}


function showBox(){
	$(".kjj").show();
	setTimeout(function () {
        $(".kjj").hide();
    }, 1000);
}

function closeBox(){
	$(".kjj").hide();
}