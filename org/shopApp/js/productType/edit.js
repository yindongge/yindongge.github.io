function modifyProperty(propertyId){
	layer.open({
		type : 2,
		title : '编辑',
		shadeClose : true,
		shade : 0.2,
		area : [ '600px', '450px' ],
		maxmin : true, //开启最大化最小化按钮
		content : '../eidtPropertyForEdit/'+propertyId //iframe的url
	});
}

function addProperty(){
	layer.open({
		type : 2,
		title : '编辑',
		shadeClose : true,
		shade : 0.2,
		area : [ '600px', '450px' ],
		maxmin : true, //开启最大化最小化按钮
		content : '../addPropertyForEdit/'+$('#typeId').val() //iframe的url
	});
}

function validate(){
    $('#addForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	typeName: {
                validators: {
                    notEmpty: {
                        message: '名称不能为空'
                    }
                }
            },
            typeOrder: {
                validators: {
                    notEmpty: {
                        message: '排序不能为空'
                    },
                    digits: {
                    	message: '必须为数字'
                    }
                }
            },
            groupId: {
                validators: {
                    notEmpty: {
                        message: '不能为空'
                    }
                }
            }
        }
    });
};

function reloadProperty(){
    $.ajax({  
        type: 'GET',  
        url: '../getPropertyByTypeId/' + $('#typeId').val(),
        dataType: 'json',
        success: function(data) {  
        	$("#propertyTable .rowItem").remove();
			$.each(data.productPropertyList,function(){
				var propertyId = this.propertyId;
				var propertyOrder = this.propertyOrder;
				var propertyName = this.propertyName;
				var propertyInputType = this.propertyInputType;
				var propertySelect = this.propertySelect;
				var propertyValuesStr = this.propertyValuesStr;
				//alert(propertyId+propertyOrder+propertyName+propertyInputType+propertySelect+propertyValue);
				var html = 	'<tr class="rowItem">'+
								'<td><input type="checkbox" id="itemCheckBox1" name="propertyCheckbox"></input></td>'+
								'<td>'+propertyOrder+'</td>'+
								'<td>'+propertyName+'</td>';
				if(propertyInputType == '1'){					
					html = html + '<td>'+'手动输入'+'</td>';
				}
				if(propertyInputType == '2'){					
					html = html + '<td>'+'单选组'+'</td>';
				}
				if(propertyInputType == '3'){					
					html = html + '<td>'+'列表单选'+'</td>';
				}
				if(propertyInputType == '4'){					
					html = html + '<td>'+'复选组'+'</td>';
				}
								
				if(propertySelect == '1'){
					html = html + '<td>'+'是'+'</td>';
				}
				if(propertySelect == '0'){
					html = html + '<td>'+'否'+'</td>';
				}
				html = html + '<td>'+propertyValuesStr+'</td>'+
								'<td>'+
									'<button type="button" 	class="btn btn-danger btn-go btn2-click" onclick="modifyProperty('+propertyId+');">编辑</button>'+
									'<button type="button"  class="btn btn-danger btn-go " onclick="deleteProperty('+propertyId+');">删除</button>'+
								'</td>'+
							'</tr>';				
				$("#propertyTable").append(html);
			});

        },  
        error: function(data) {  
            alert(data);  
        }  
    });
};

function deleteProperty(propertyId){
	var c = confirm("确认删除！");
	if(c==true){
		$.ajax({
			url:'../deletePropertyById?propertyId='+propertyId+'&typeId='+$("#typeId").val(),
			type: 'GET',
			dataType: 'json',
			success:function(result){
				if(result.code=='200'){
					alert('删除成功');
					reloadProperty();
				}
			}
		});
	};
};

$(function() {
	//给规格赋值
	var specs = $("#typeValueHidden").val();
	var specArr = specs.split(",");
	for(var i=0;i<specArr.length;i++){
		$("#specCheckBox"+specArr[i]).attr("checked","checked");
	};
});