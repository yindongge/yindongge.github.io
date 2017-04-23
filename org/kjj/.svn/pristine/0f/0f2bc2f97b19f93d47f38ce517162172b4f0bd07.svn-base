function removeItem(element){
	$(element).parent().parent().remove();
};
function addItem(index){
	var checkAllState = $("#checkAll").is(':checked');
	if(checkAllState){
		$("#propertyTable").append(
				"<tr id='rowItem"+index+"'>"+
					"<td><input type='checkbox' id='itemCheckBox"+index+"' name='propertyCheckbox' checked='checked'></input><span></span></td>"+
					"<td><input type='hidden'  name='propertyOrder'/><span></span></td>"+
					"<td><input type='hidden'  name='propertyName'/><span></span></td>"+
					"<td><input type='hidden'  name='propertyInputType' value='1'/><span></span></td>"+
					"<td><input type='hidden'  name='propertySelect' value='1'/><span></span></td>"+
					"<td><input type='hidden'  name='propertyValue'/><span></span></td>"+
					"<td>"+
						"<button type='button' href='#'	class='btn btn-danger btn-go btn2-click' onclick='modify(this);'>编辑</button>"+
						"<button type='button' href='#' class='btn btn-danger btn-go ' onclick='removeItem(this);'>删除</button>"+
					"</td>"+
				"</tr>"	
		);
	}else{
		$("#propertyTable").append(
				"<tr id='rowItem"+index+"'>"+
					"<td><input type='checkbox' id='itemCheckBox"+index+"' name='propertyCheckbox'></input><span></span></td>"+
					"<td><input type='hidden'  name='propertyOrder'/><span></span></td>"+
					"<td><input type='hidden'  name='propertyName'/><span></span></td>"+
					"<td><input type='hidden'  name='propertyInputType' value='1'/><span></span></td>"+
					"<td><input type='hidden'  name='propertySelect' value='1'/><span></span></td>"+
					"<td><input type='hidden'  name='propertyValue'/><span></span></td>"+
					"<td>"+
						"<button type='button' href='#'	class='btn btn-danger btn-go btn2-click' onclick='modify(this);'>编辑</button>"+
						"<button type='button' href='#' class='btn btn-danger btn-go ' onclick='removeItem(this);'>删除</button>"+
					"</td>"+
				"</tr>"	
		);
	}

};
function modify(element){
	var itemId = $(element).parent().parent().attr("id");
	$("#rowItemId").attr("value",itemId);
	layer.open({
		type : 2,
		title : '编辑',
		shadeClose : true,
		shade : 0.2,
		area : [ '600px', '450px' ],
		maxmin : true, //开启最大化最小化按钮
		content : 'addProperty' //iframe的url
	});
};

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

function propertyTableCheckbox(){
	$("#checkAll").click(function(){
		var checkAllState = $("#checkAll").is(':checked');
		if(checkAllState){
			$(":input[name='propertyCheckbox']").each(function(){
				this.checked=true;
			});
		}else{
			$(":input[name='propertyCheckbox']").each(function(){
				this.checked=false;
			});
		}
	});
};

function deleteItemByCheckbox(){
	$("#deleteItem").click(function(){
		$(":input[name='propertyCheckbox']").each(function(){
			if(this.checked){
				$(this).parent().parent().remove();
			}
		});
	});
};

function validatePropertyTable(){
	var result = true;
	$("#propertyTable").find(':input[type="hidden"]').each(function(index){
		if(this.value==''){
			$(this).next().addClass("spanred");
			result = false;
			return false;
		}
	});
	return result;
};
$(function() {
	var index = 1;	
	$("#addItemBotton").click(function(){
		index = index + 1;
		addItem(index);
	});
	validate();
	propertyTableCheckbox();
	deleteItemByCheckbox();
});
