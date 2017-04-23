$(function () {
	$("#shopCode").change(function(){
		$("#pageform").submit();
	});
	

    $('.onsale').on('click',function(){
		var btn=$(this);
		$.ajax({  
			type: "post",  
			dataType: "json",
			url: "updateStatus",
			data: {'id':btn.parent().attr('data-id'),
				'inventoryId':btn.parent().attr('data-inventoryId'),
				'status':0
				},
			success:function(data){
				if(data.code=200){
					btn.parent().prev().text("销售中");
					btn.hide();
					btn.parent().attr('data-id',data.id);
					btn.siblings('.offsale').show();
				}
			}
		});  
	});
    
	$('.offsale').on('click',function(){
		var btn=$(this);
		$.ajax({  
			type: "post",  
			dataType: "json",
			url: "updateStatus",
			data: {'id':btn.parent().attr('data-id'),
				'inventoryId':btn.parent().attr('data-inventoryId'),
				'status':1
				},
			success:function(data){
				if(data.code=200){
					btn.parent().prev().text("已禁售");
					btn.hide();
					btn.parent().attr('data-id',data.id);
					btn.siblings('.onsale').show();
				}
			}
		});
	});
	
	
});

function editZero(id){
	if(!confirm("确定清空库存？")){
		return;
	}
	$.ajax({
        type: "POST",
        dataType: "json",
        url: "../meal/saveMeal",
        data: {'id':id,'shopAmount':0},
        success: function (data) {
       	 	alert('清空库存设置成功!');
       	 	$("#pageform").submit();
        },
        error: function(data) {
        	alert('清空库存设置失败!');
        }
    });
	
}

function editStockClearConfig(){
	var shopCode = $("#shopCode").val();
	layer.open({
	    type: 2,
	    title: '设置自动清库存',
	    shadeClose: true,
	    shade: 0.8,
	    shift:-1,
		maxmin: true, //开启最大化最小化按钮
	    area: ['700px', '520px'],
	    content: '../meal/editStockClear?shopCode=' + shopCode
	});
}

function editStockOrPrice(itemId,index,type,buttonId){
	
	// 1:修改库存 2:修改价格
	var name = "";
	if(type=='1'){
		name = "库存";
		if(!confirm("确定修改"+name + "?")){
			return;
		}
		// 验证非空
		if($("#stockNum"+index).val().trim().length == 0){
			alert(name + "必须填写！");
			$("#stockNum"+index).val($("#stockNum"+index).attr('oldvalue'));
			$("#stockNum"+index).focus();
			return;
		}
		
		var r = /^[1-9][0-9]*$/;//正整数 
		if($("#stockNum"+index).val()!="0"){
			if(!r.test($("#stockNum"+index).val())){
				alert(name + "必须为整数！");
				$("#stockNum"+index).val($("#stockNum"+index).attr('oldvalue'));
				$("#stockNum"+index).focus();
				return;
			}
		}
		
		$.ajax({
	        type: "POST",
	        dataType: "json",
	        url: "../meal/saveMeal",
	        data: {'id':itemId,'shopAmount':$("#stockNum"+index).val()},
	        success: function (data) {
	       	 	alert('修改成功!');
	        	$('#goodsSn').focus();
	        },
	        error: function(data) {
	        	alert('修改失败!');
	        	$('#'+ buttonId).blur();
	        }
	    });
		
	}
	
	if(type=='2'){
		name = "价格";
		if(!confirm("确定修改"+name + "?")){
			return;
		}
		// 验证非空
		if($("#price"+index).val().trim().length == 0){
			alert(name + "必须填写！");
			$("#price"+index).val($("#price"+index).attr('oldvalue'));
			$("#price"+index).focus();
			return;
		}

		var r = /^([1-9][0-9]*)?[0-9]\.[0-9]{2}$/;
		if(!r.test($("#price"+index).val())){
			alert(name + "格式不正确！必须保留两位小数");
			$("#price"+index).val($("#price"+index).attr('oldvalue'));
			$("#price"+index).focus();
			return;
		}
		
		
		$.ajax({
	        type: "POST",
	        dataType: "json",
	        url: "../meal/saveMeal",
	        data: {'id':itemId,'sourcePrice':$("#price"+index).val(),'sellPrice':$("#price"+index).val()},
	        success: function (data) {
	        	alert('修改成功!');
	        	$('#goodsSn').focus();
	        },
	        error: function(data) {
	        	alert('修改失败!');
	        	$('#'+ buttonId).blur();
	        }
	    });
	}
	
}