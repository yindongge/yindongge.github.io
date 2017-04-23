	$(function(){
		$('.input10').click (function(){
			$('.show-mangent').show();
		});
		
		 $('#menuForm').bootstrapValidator({
		        message: 'This value is not valid',
		        excluded: ':disabled',
		        feedbackIcons: {
		            valid: 'glyphicon glyphicon-ok',
		            invalid: 'glyphicon glyphicon-remove',
		            validating: 'glyphicon glyphicon-refresh'
		        },
		        fields: {
		            title: {
		                validators: {
		                    notEmpty: {
		                        modelname: '请填写标题！'
		                    },
		                    stringLength: {
		                        min: 2,
		                        max: 30,
		                        message: '标题长度在2-30之间'
		                    },
		                }
		            },
		            
		            modelParent: {
		                validators: {
		                    notEmpty: {
		                        message: '请填写菜单编号！'
		                    },
		                    stringLength: {
		                        min: 1,
		                        max: 100,
		                        message: '菜单标号在 1-100之间！'
		                    },
		                }
		            },
		            url: {
		                validators: {
		                    notEmpty: {
		                        message: '请填写菜单链接地址！'
		                    },
		                    stringLength: {
		                        min: 1,
		                        max: 100,
		                        message: '有效的时间'
		                    },
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
		      
		    	  $.ajax({
		              type: "POST",
		              dataType: "json",
		              url: "../menu/add",
		              data: $('#menuForm').serialize(),
		              success: function (data) {  
		                 if(data.code==200){
		                	 alert("添加成功");
		                	 parent.location.reload();
		                 }else{
		                	 alert("添加菜单失败！");
		                 }
		              },
		              error: function(data) {
		                
		               }
		          });
		    });
		
	});
	
	function cancle(){
		var index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
	}