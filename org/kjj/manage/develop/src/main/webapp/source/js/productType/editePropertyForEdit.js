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


function addItem(){
	$("#addItemArea").append(
			"<tr>"+
				"<td>"+
					"<div class='form-group'>"+	
						"<input type='hidden' name='propertyValueIds' value='-1'/>"+
						"<input type='hidden' name='isDeletes' value='false'/>"+
						"<input type='text' class='form-control' name='propertyValues'></input>"+		
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
			};
		});
	});
};

function closewin(){
 	var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
	parent.layer.close(index); //执行关闭 
};

function validate(){
	$('#addForm').bootstrapValidator().on('success.form.bv', function(e) {
        // Prevent form submission
        e.preventDefault();

        // Get the form instance
        var $form = $(e.target);

        // Get the BootstrapValidator instance
        var bv = $form.data('bootstrapValidator');

        // Use Ajax to submit form data
        $.post($form.attr('action'), $form.serialize(), function(result) {
        	if(result.code==200){
        		alert("添加成功！！");
        		parent.reloadProperty();
        		closewin();	        		
        	}else{        		
        		closewin();	        		
        	}
        
        }, 'json');
    });
};

function initValue(){
	var propertySelect = $('#propertySelect').val();
	var propertyInputType = $('#propertyInputType').val();
	if(propertySelect == 0){
		$("#selectRadio2").prop("checked",true);
	}else{
		$("#selectRadio1").prop("checked",true);
	};
	
	$("#typeRadio"+propertyInputType).prop("checked",true);
	$(".form-group .col-md-9 .radio-inline :radio").each(function(index){
		if(!this.checked){
			$(this).prop("disabled","disabled");
		};
	});
	//$('input[name="propertyInputType"]').prop("disabled","disabled");
};

function deleteItem(element){
	var valueId = $(element).parent().parent().find(':input[name="propertyValueIds"]').val();
	if(valueId != '' && valueId !='-1'){
		$(element).parent().parent().find(':input[name="isDeletes"]').val('true');
		$(element).parent().parent().hide();
	}else{
		$(element).parent().parent().remove();
	}
};
$(function(){
	initValue();
	validate();
});
	