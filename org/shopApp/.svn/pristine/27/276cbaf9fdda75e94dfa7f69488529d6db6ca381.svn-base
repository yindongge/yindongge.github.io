function initData(){
	var rowItemId = $("#rowItemId",window.parent.document).val();
	//alert(rowItemId);
	var propertyOrder = $("#"+rowItemId,window.parent.document).find(":input[name='propertyOrder']").val();
	var propertyName = $("#"+rowItemId,window.parent.document).find(":input[name='propertyName']").val();
	var propertyInputType = $("#"+rowItemId,window.parent.document).find(":input[name='propertyInputType']").val();
	var propertySelect = $("#"+rowItemId,window.parent.document).find(":input[name='propertySelect']").val();
	var propertyValue = $("#"+rowItemId,window.parent.document).find(":input[name='propertyValue']").val();
	//alert(propertyOrder+propertyName+propertyInputType+propertySelect+propertyValue);
	
	$("#propertyOrder").attr("value",propertyOrder);
	$("#propertyName").attr("value",propertyName);
	
	if(propertySelect==0){
		$("#selectRadio2").attr("checked","checked");
	}else if(propertySelect==1){
		$("#selectRadio1").attr("checked","checked");
	}

	if(propertyInputType==1){
		$("#typeRadio1").attr("checked","checked");
		addTextArea();
		$("#textArea").text(propertyValue);
	}else if(propertyInputType==2){
		$("#typeRadio2").attr("checked","checked");
		addItemArea();
		initItem(propertyValue);
	}else if(propertyInputType==3){
		$("#typeRadio3").attr("checked","checked");
		addItemArea();
		initItem(propertyValue);
	}else if(propertyInputType==4){
		$("#typeRadio4").attr("checked","checked");
		addItemArea();
		initItem(propertyValue);
	}
};

function attrParent(){
	var propertyOrder = $("#propertyOrder").val();
	var propertyName = $("#propertyName").val();
	var propertySelect = $(":input[name='propertySelect']:checked").val();
	var propertyInputType = $(":input[name='propertyInputType']:checked").val();
	var propertyValue = "";
	if(propertyInputType=="1"){
		propertyValue = $("#textArea").val();
	}else{
		var propertyValue_arr = [];	
		$(":input[name='propertyValue']").each(function(){
			propertyValue_arr.push($(this).val());
		});
		 propertyValue = propertyValue_arr.toString().replace(new RegExp(/(,)/g),'、');
	}
	//alert(propertyOrder+propertyName+propertyInputType+propertySelect+propertyValue);
	
	var rowItemId = $("#rowItemId",window.parent.document).val();
	$("#"+rowItemId,window.parent.document).find(":input[name='propertyOrder']").attr("value",propertyOrder);
	$("#"+rowItemId,window.parent.document).find(":input[name='propertyOrder']").next().html(propertyOrder);
	
	$("#"+rowItemId,window.parent.document).find(":input[name='propertyName']").attr("value",propertyName);
	$("#"+rowItemId,window.parent.document).find(":input[name='propertyName']").next().html(propertyName);
	
	$("#"+rowItemId,window.parent.document).find(":input[name='propertySelect']").attr("value",propertySelect);
	if(propertySelect==0){
		$("#"+rowItemId,window.parent.document).find(":input[name='propertySelect']").next().html("否");
	}else if(propertySelect==1){
		$("#"+rowItemId,window.parent.document).find(":input[name='propertySelect']").next().html("是");
	}	
	
	$("#"+rowItemId,window.parent.document).find(":input[name='propertyInputType']").attr("value",propertyInputType);
	if(propertyInputType==1){
		$("#"+rowItemId,window.parent.document).find(":input[name='propertyInputType']").next().html("手动输入");
	}else if(propertyInputType==2){
		$("#"+rowItemId,window.parent.document).find(":input[name='propertyInputType']").next().html("单选组");
	}else if(propertyInputType==3){
		$("#"+rowItemId,window.parent.document).find(":input[name='propertyInputType']").next().html("列表单选");
	}else if(propertyInputType==4){
		$("#"+rowItemId,window.parent.document).find(":input[name='propertyInputType']").next().html("复选组");
	}	
	
	$("#"+rowItemId,window.parent.document).find(":input[name='propertyValue']").attr("value",propertyValue);
	$("#"+rowItemId,window.parent.document).find(":input[name='propertyValue']").next().html(propertyValue);
	
	
	//恢复父页面submit按钮
	$(":submit",window.parent.document).removeAttr("disabled");
	$("#propertyTable",window.parent.document).find(':input[type="hidden"]').next().removeClass("spanred");
	closewin();
};


function initItem(val){
	var arr = val.split("、");
	//alert(arr[1]);
	//addItemWithVal(arr[1]);
	for(var i=0;i<arr.length;i++){
		addItemWithVal(arr[i]);
	}
};

function addTextArea(){
	$("#valueArea").append(
		"<textarea class='form-control'  rows='5' id='textArea'/>"			
	);
};

function addItemArea(value){
	$("#valueArea").append(
		"<div class='special3' id='itemArea'>"+
			"<table class='table'>"+	
				"<tbody id='addItemArea'>"+		

				"</tbody>"+		
			"</table>"+	
		"</div>"+
		"<button type='button' class='btn btn-danger' onclick='addItem();' id='addItmBtn'>添加一行</button>	"	
	);
};

function addItemWithVal(val){
	$("#addItemArea").append(
			"<tr>"+
				"<td>"+
					"<div class='form-group'>"+	
						"<input type='text' class='form-control' name='propertyValue'  value="+val+" ></input>"+		
					"</div>"+	
				"</td>"+
				"<td>"+
					"<button type='button' class='btn btn-danger' onclick='removeItem(this);'><i class='glyphicon glyphicon-remove-circle'></i>	</button>"+	
				"</td>"+
			"</tr>"
	);
};

function addItem(){
	$("#addItemArea").append(
			"<tr>"+
				"<td>"+
					"<div class='form-group'>"+	
						"<input type='text' class='form-control' name='propertyValue'></input>"+		
					"</div>"+	
				"</td>"+
				"<td>"+
					"<button type='button' class='btn btn-danger' onclick='removeItem(this);'><i class='glyphicon glyphicon-remove-circle'></i>	</button>"+	
				"</td>"+
			"</tr>"
	);
};

function appendValueParentArea(){
	$("#valueParentArea").append(
			"<div id='valueArea' class='col-md-9'></div>"
	);
};

function removeItem(element){
	$(element).parent().parent().remove();
};

function TypeRadioClick(){
	$(":radio[name='propertyInputType']").each(function(){
		$(this).click(function(){
			var val = $(this).val();
			if(val==1){
				$("#valueArea").remove();
				appendValueParentArea();
				addTextArea();
			}else{
				$("#valueArea").remove();
				appendValueParentArea();
				addItemArea();
			}
		});
	});
};

function closewin(){
 	var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
	parent.layer.close(index); //执行关闭 
};

function validate(){
	$("#addForm").bootstrapValidator();
};

$(function(){
	initData();	
	TypeRadioClick();
	validate();
});