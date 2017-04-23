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

function edit(id){
	location.href="../businessArea/editInit/"+id;
}