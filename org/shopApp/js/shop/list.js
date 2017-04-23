$(function () {
	
	//区域省下拉列表选择变更
	$("#provinceCode").change(function(){
		if($('#provinceCode').val() == -1){
			$('#cityCode').empty();
          	$('#cityCode').append("<option value='-1'>请选择市</option>");
		}else{
			$.ajax({
	            type: "POST",
	            dataType: "json",
	            url: "../area/getByParentCode",
	            data: {'parentCode':$('#provinceCode').val()},
	            success: function (data) {
	           	 $('#cityCode').empty();
	           	 $('#cityCode').append("<option value='-1'>请选择市</option>");
	                $.each(data.listArea,function(idx, obj){
	               	 $('#cityCode').append("<option value=\""+obj.code+"\">"+obj.name+"</option>");
	                }); 
	            },
	            error: function(data) {
	            }
	        });
		}
		$('#countyCode').empty();
      	$('#countyCode').append("<option value='-1'>请选择区或县</option>");
	});
	
	//区域市下拉列表选择变更
	$("#cityCode").change(function(){
		if($('#cityCode').val() == -1){
          	$('#countyCode').empty();
          	$('#countyCode').append("<option value='-1'>请选择区或县</option>");
		}else{
			$.ajax({
	            type: "POST",
	            dataType: "json",
	            url: "../area/getByParentCode",
	            data: {'parentCode':$('#cityCode').val()},
	            success: function (data) {
	           	 $('#countyCode').empty();
	           	 $('#countyCode').append("<option value='-1'>请选择区或县</option>");
	                $.each(data.listArea,function(idx, obj){
	               	 $('#countyCode').append("<option value=\""+obj.code+"\">"+obj.name+"</option>");
	                }); 
	            },
	            error: function(data) {
	            }
	        });
		}
	});
});

function edit(shopId){
	location.href="../shop/editInit/"+shopId;
}
function hide(shopId){
	$.ajax({  
        type: "post",  
        url: "../shop/hide/"+shopId, 
        success: function(data) {
        	if(data==200){
        		location.reload();
        	}
        },  
        error: function(data) {  
        }  
    })  ;

}
function show(shopId){
	$.ajax({  
        type: "post",  
        url: "../shop/show/"+shopId,  
        success: function(data) { 
        	if(data==200){
        		location.reload();
        	}
        },  
        error: function(data) {  
        }  
    })  ;
}