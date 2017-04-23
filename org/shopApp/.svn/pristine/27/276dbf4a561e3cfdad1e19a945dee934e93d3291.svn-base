
function closewin(){
	var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
	parent.location.reload();
	 parent.layer.close(index); //执行关闭
	
	
}

$(document).ready(function() {
    $('#formAdd').bootstrapValidator({
        message: 'This value is not valid',
        excluded: ':disabled',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	className: {
                message: '类型名称无效',
                validators: {
                    notEmpty: {
                        message: '请填写类型名称'
                    },
                    stringLength: {
                        min: 2,
                        max: 20,
                        message: '类型名称长度为2-20字符'
                    }
                }
            }
        ,
        className: {
            message: '类型名称无效',
            validators: {
                notEmpty: {
                    message: '请填写类型名称'
                },
                stringLength: {
                    min: 2,
                    max: 20,
                    message: '类型名称长度为2-20字符'
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
        		alert("类型添加失败！！");
        	}else{
        		closewin();		
        	}
        
        }, 'json');
    });
    
    new uploadPreview({ UpBtn: "file_1", DivShow: "div_1", ImgShow: "showimg_1" });
    
});