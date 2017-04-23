$(function () {
	$("#shopSelect",window.parent.document).val($("#shopSelect").val());
	//区域省下拉列表选择变更
	$("#provinceCode").change(function(){
		if($('#provinceCode').val() == -1){
			$('#cityCode').empty();
          	$('#cityCode').append("<option value='-1'>请选择市</option>");
          	//选择的区域
			$('#areaCode').val("-1");
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
			//选择的区域
			$('#areaCode').val($('#provinceCode').val());
		}
		$('#countyCode').empty();
      	$('#countyCode').append("<option value='-1'>请选择区或县</option>");
      	loadBusinessAreaList();
      	loadShopList();
	});
	
	//区域市下拉列表选择变更
	$("#cityCode").change(function(){
		if($('#cityCode').val() == -1){
          	$('#countyCode').empty();
          	$('#countyCode').append("<option value='-1'>请选择区或县</option>");
          	//选择的区域
			$('#areaCode').val($('#provinceCode').val());
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
			//选择的区域
			$('#areaCode').val($('#cityCode').val());
		}
		loadBusinessAreaList();
		loadShopList();
	});
	
	//区域县下拉列表选择变更
	$("#countyCode").change(function(){
		if($('#countyCode').val() == -1){
			//选择的区域
			$('#areaCode').val($('#cityCode').val());
		}else{
			//选择的区域
			$('#areaCode').val($('#countyCode').val());
		}
		loadBusinessAreaList();
		loadShopList();
	});
	
	//商圈下拉列表选择变更
	$("#businessAreaId").change(function(){
		loadShopList();
	});
	
	//确定
	$("#btnConfirm").click(function(){
		$("#shopSelect",window.parent.document).val($("#shopSelect").val());
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

function loadBusinessAreaList(){
	  $.ajax({
	      type: "POST",
	      dataType: "json",
	      url: "../businessArea/getListBusinessArea",
	      data: {'areaCodeLike':$('#areaCode').val()},
	      success: function (data) {
	      	if(data.code==200){
			   	 $('#businessAreaId').empty();
			   	 var shopHtml = "<option value=''>商圈</option>";
	             $.each(data.list,function(idx, obj){
	            	 shopHtml+="<option value=\""+obj.id+"\">"+obj.name+"</option>";
	             }); 
	             $('#businessAreaId').append(shopHtml);
	       	}
	      },
	      error: function(data) {
	      }
	  });
	}

function loadShopList(){
  $.ajax({
      type: "POST",
      dataType: "json",
      url: "../shop/shopSelect",
      data: {'areaCodeLike':$('#areaCode').val(),'businessAreaId':$('#businessAreaId').val()},
      success: function (data) {
      	if(data.code==200){
		   	 $('#shopSelect').empty();
		   	 var shopHtml = '';
             $.each(data.listShop,function(idx, obj){
            	 shopHtml+="<option value=\""+obj.shopId+"\">"+obj.shopName+"</option>";
             }); 
             $('#shopSelect').append(shopHtml);
       	}
      },
      error: function(data) {
      }
  });
}