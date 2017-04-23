function validate(){
    $('#addForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	keywords: {
                message: 'The username is not valid',
                validators: {
                	stringLength: {
                        max: 60,
                        message: '关键字长度不能超过 60 '
                    }
                }
            },
            spec:{
                message: 'The username is not valid',
                validators: {
                	stringLength: {
                        max: 60,
                        message: '描述长度不能超过 60 '
                    }                  
                }
            },
            sellerNote:{
                message: 'The username is not valid',
                validators: {
                	stringLength: {
                        max: 200,
                        message: '描述长度不能超过 200 '
                    }                  
                }
            }
        }
    }).on('success.form.bv', function(e) {
        e.preventDefault();
        var $form = $(e.target);
        var bv = $form.data('bootstrapValidator');
        $.post($form.attr('action'), $form.serialize(), function(result) {
        	if(result.code==200){
        		alert("添加成功！！");	
        		location.href = '../offSaleList';
        	}else{
        		alert("添加失败！！");	
        	}
        
        }, 'json');
    });	
}

$(function(){
	validate();
	if($(':input[name="showType"]').val()==0){
		$('#showTypeDiv1').show();
		$('#showTypeDiv2').hide();
		$('#showTypeDiv3').hide();
	}else if($(':input[name="showType"]').val()==1){
		$('#showTypeDiv1').hide();
		$('#showTypeDiv2').show();
		$('#showTypeDiv3').show();
	}
	//商品展现形式按钮
	$('#showTypeBtn1').bind('click',function(){
		$('#showTypeBtn1').removeClass('btn-default').addClass('btn-primary');
		$('#showTypeBtn2').removeClass('btn-primary').addClass('btn-default');
		$('#showTypeBtn1').parent().find(':hidden').val('0');
		$('#showTypeDiv1').show();
		$('#showTypeDiv2').hide();
		$('#showTypeDiv3').hide();
	});
	$('#showTypeBtn2').bind('click',function(){
		$('#showTypeBtn1').removeClass('btn-primary').addClass('btn-default');
		$('#showTypeBtn2').removeClass('btn-default').addClass('btn-primary');
		$('#showTypeBtn1').parent().find(':hidden').val('1');
		$('#showTypeDiv1').hide();
		$('#showTypeDiv2').show();
		$('#showTypeDiv3').show();
	});
});