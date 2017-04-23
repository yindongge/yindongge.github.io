function closewin(){
 	var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
	parent.layer.close(index); //执行关闭 
	
}

function openColorPiker(element){
	$("#colorDivId").val(element.id);
	layer.open({
		type: 2,
		title: '颜色选择',
		shadeClose: true,
		shade: 0.1,
		//maxmin: true, //开启最大化最小化按钮
		area: ['300px', '300px'],
		content: 'colorpicker' //iframe的url
	}); 
}

function removeItem(element){
	$(element).parent().parent().remove();
}

function addItem(index){
	$("#specValueArea").append(
			"<div class='row'>"+
				"<div class='col-sm-4'>"+
					"<div class='form-group'>"+
						"<input type='text' class='color-control form-control' name='specValue'  placeholder='规格值'/>"+
					"</div>"+
				"</div>"+
				"<div class='col-sm-4 color_area'>"+				
					"<div class='form-group'>"+
						"<input type='text' class='color-control form-control' name='colour' id='value-color"+index+"' readonly='readonly' placeholder='颜色值'/>"+
					"</div>"+
				"</div>"+
				"<div class='col-sm-1 color_area'>"+
					"<div class='kuai icon2 dropdown-toggle color-div' role='button'  id='color"+index+"' onclick='openColorPiker(this);''></div>"+ 
				"</div>"+
				"<div class='col-sm-1 delete-btn'>"+
					"<button type='button' class='btn ' onclick='removeItem(this);' style='background:none;'><i class='glyphicon glyphicon-remove-circle'></i></button>"+
				"</div>"+
			"</div>"
			);
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
        	specName: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: '名称不能为空'
                    }
                }
            },
            specOrder:{
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: '不能为空'
                    },
                    digits: {
                    	message: '必须为数字'
                    }                    
                }
            }
        }
    }).on('success.form.bv', function(e) {
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
        		parent.location.reload();
        		closewin();		
        		 
        	}else{
        		alert("添加失败！！");
        		closewin();		
        		
        	}
        
        }, 'json');
    });	
}

function hiddenColorArea(){
	$(".col-sm-4.color_area").each(function(){
		$(this).attr("style","display:none;");
	});
	$(".col-sm-1.color_area").each(function(){
		$(this).attr("style","display:none;");
	});
}
function blockColorArea(){
	$(".col-sm-4.color_area").each(function(){
		$(this).attr("style","display:block;");
	});
	$(".col-sm-1.color_area").each(function(){
		$(this).attr("style","display:block;");
	});
}
$(function(){	
	$(":radio").click(function(){
		var radioValue = $(this).val();
		if(radioValue==1){
			hiddenColorArea();
		}
		if(radioValue==2){
			blockColorArea();
		}
	});
	
	var index = 1;
	$("#addItemBtn").click(function(){
		index = index+1;
		addItem(index);
		var radioValue = $('input[name="specTypeId"]:checked').val();
		if(radioValue==1){
			hiddenColorArea();
		}
		if(radioValue==2){
			blockColorArea();
		}
	});
	validate();

});