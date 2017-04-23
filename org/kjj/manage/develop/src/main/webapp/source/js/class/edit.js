function closewin(){
	var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
	parent.location.reload();
	parent.layer.close(index); //执行关闭	 
}

$(function(){
	$('#classLevel').on('change',function(){
		var levelId = $("#classLevel").val();		
	    $.ajax({  
	        type: 'post',  
	        url: '../getClassesByLevel/'+(levelId-1),   
	        dataType: 'json',
	        success: function(data) {     		
	       		var htmlStr = '';
	            for(var i=0; i< data.length;i++){
	            	htmlStr += '<option value="'+data[i].classId+'">'+data[i].className+'</option>';
	            }
	            $("#classParent").empty();
	            $("#classParent").append(htmlStr);
	        },  
	        error: function(data) {  
	            alert(data);  
	        }  
	    });
	});
	
    $('#form_update').bootstrapValidator({
        message: 'This value is not valid',
        excluded: ':disabled',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {           
        	className: {
                message: '分类名称无效',
                validators: {
                    notEmpty: {
                        message: '请填写分类名称'
                    },
                    stringLength: {
                        min: 2,
                        max: 20,
                        message: '分类名称长度为2-20字符'
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
        	if(result.code!=200){
        		alert("修改失败！！");
        	}else{
        		closewin();		
        	}
        
        }, 'json');
    });
});