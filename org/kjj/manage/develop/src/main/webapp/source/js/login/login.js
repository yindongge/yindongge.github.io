//JavaScript Document
$(document).ready(function() {
	if(top.location!=self.location){
		top.location.reload();
	}
    $('#myform').bootstrapValidator({
        message: 'This value is not valid',
        excluded: ':disabled',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
           
            username: {
                message: '用户名无效',
                validators: {
                    notEmpty: {
                        message: '请填写用户名'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空！'
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
        		$("#tipscontent").text(result.desc);
				        		
        	}else{
        		location.href = "index";
        	}
        
        }, 'json');
    });
});