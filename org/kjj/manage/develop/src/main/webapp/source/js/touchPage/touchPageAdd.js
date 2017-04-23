$(function(){
	//省下拉列表改变时
	$("#provinceCode").change(function(){
		if($("#provinceCode").val() == ""){
			$("#cityCode").empty();
			$('#cityCode').append("<option value=''>请选择市</option>");
		}else{
			$.ajax({
				type:'post',
				dataType:'json',
				url:'../area/getByParentCode',
				data:{'parentCode':$('#provinceCode').val()},
				success:function(data){
		           	 $('#cityCode').empty();
		           	 $('#cityCode').append("<option value=''>请选择市</option>");
		             $.each(data.listArea,function(idx, obj){
		               	 $('#cityCode').append("<option value=\""+obj.code+"\">"+obj.name+"</option>");
		               }); 
				},
				error:function(data){}
			});
		}
		$('#countryCode').empty();
      	$('#countryCode').append("<option value=''>请选择区或县</option>");
      	$('#shopId').empty();
      	$('#shopId').append("<option value=''>请选择门店</option>");
	});
	
	//区域市下拉列表选择变更
	$("#cityCode").change(function(){
		if($('#cityCode').val() == ""){
          	$('#countryCode').empty();
          	$('#countryCode').append("<option value=''>请选择区或县</option>");
		}else{
			$.ajax({
	            type: "post",
	            dataType: "json",
	            url: "../area/getByParentCode",
	            data: {'parentCode':$('#cityCode').val()},
	            success: function (data) {
	            	$('#countryCode').empty();
	           	 	$('#countryCode').append("<option value=''>请选择区或县</option>");
	           	 	$.each(data.listArea,function(idx, obj){
                	$('#countryCode').append("<option value=\""+obj.code+"\">"+obj.name+"</option>");
                 }); 
	            },
	            error: function(data) {
	            }
	        });
		}
		$('#shopId').empty();
      	$('#shopId').append("<option value=''>请选择门店</option>");
	});
	
	//区域县下拉列表选择变更
	$("#countryCode").change(function(){
		if($('#countryCode').val() == ""){
			$('#shopId').empty();
	      	$('#shopId').append("<option value=''>请选择门店</option>");
		}else{
			getshoplist($('#countryCode').val(),'');
		}
	});
});

/*
 * 店铺门店Ajax加载
 */
function getshoplist(areaCode,curShop){
	$.ajax({
        type: "POST",
        dataType: "json",
        url: "../shop/shopSelect",
        data: {'areaCode':areaCode},
        success: function (data) {
        	$('#shopId').empty();
          	$('#shopId').append("<option value=''>请选择门店</option>");
            $.each(data.listShop,function(idx, obj){
            	if(curShop==obj.shopId){
            		$('#shopId').append("<option value=\""+obj.shopId+"\" selected>"+obj.shopName+"</option>");
            	} else {
            		$('#shopId').append("<option value=\""+obj.shopId+"\">"+obj.shopName+"</option>");
            	}
            }); 
        },
        error: function(data) {
        }
    });
}

function saveData(){
	var shopId=$("#shopId").val();
	var provinceCode=$("#provinceCode").val();
	var cityCode=$('#cityCode').val();
	var countryCode=$('#countryCode').val();
	if($("#countryCode").val()!=""){
		areaCode = $("#countryCode").val();
		validateForm(shopId,areaCode);
	} else {
		if($("#cityCode").val()!=""){
			areaCode = $("#cityCode").val();
			validateForm(shopId,areaCode);
		} else {
			if($("#provinceCode").val()!=""){
				areaCode = $("#provinceCode").val();
				validateForm(shopId,areaCode);
			} else {
				validateForm(shopId,"");
			}
		}
	}
}

function validateForm(shopId,areaCode){
	$("#areaCode").val(areaCode);
	$.ajax({
		type:'post',
		dataType:'json',
		url:'../touchPage/pageIsOnly?shopId='+shopId+'&&areaCode='+areaCode,
		data:'',
		success:function(data){
			if(data.code == 200){
				$("#touchPageform").submit();
			}else{
				alert("相同的区域或移动店铺首页已经存在，请确认后再添加!");
				return;
			}
		},
		error:function(data){
			alert("操作失败，请联系管理员或技术人员!");  
		}
	});
}

function cancle(){
	window.location.href="../touchPage/list";
}