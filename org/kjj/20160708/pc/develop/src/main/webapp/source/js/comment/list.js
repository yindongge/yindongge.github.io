var index = -1;
	$(function(){
		
		//状态选择
		$("#commentStatus").change(function(){
			$("#pageform").submit();
		});
		
		$('.togglea2').click(function(){
			$(this).parents('.bluem2').next('.toggletr').slideToggle().siblings('.toggletr').hide("fast");
			index = $(this).parents('.bluem2').next('.toggletr').find(".yellow-icon").length - 1;
		});
		
		$("table tbody").on("click",".starScore a",function(){
			index = $(this).parent().children("a").index($(this));
			$(this).nextAll().removeClass("yellow-icon");
			$(this).prevAll().addClass("yellow-icon");
			$(this).addClass("yellow-icon");
		});
		
		$("table tbody").on("mouseover",".starScore a",function(){
			if( $(this).parent().children("a").index($(this)) > index){
				$(this).nextAll().removeClass("yellow-icon");
				$(this).prevAll().addClass("yellow-icon");
				$(this).addClass("yellow-icon");
			}
		});
		
		$("table tbody").on("mouseout",".starScore a",function(){
			$(this).siblings().removeClass("yellow-icon");
			$(this).removeClass("yellow-icon");
			$(this).parent().children("a:lt("+(index+1)+")").addClass("yellow-icon");
		});
		
		$("[name='goodsComment']").on("blur keyup",function(){
			var intro = $(this).val().replace(/^\s+|\s+$/g,"");
			if(intro.length>500){
				$(this).val(intro.substr(0,500));
			}
			$(this).next().children(".red").html(500-intro.length);
		});
		
		$(":button[name='buttonSave']").click(function(){
			var button = $(this);
			button.parents(".toggletr").find("b").hide();
			if(button.parents(".toggletr").find(".yellow-icon").length == 0){
				button.parents(".toggletr").find("b:eq(0)").html("评分不能为空！").show();
				return false;
			}
		
			if(button.parents(".toggletr").find("[name='goodsComment']").val().length < 10){
				button.parents(".toggletr").find("b:eq(1)").html("心得不能少于10！").show();
				return false;
			}
			
			//获取收货地址信息
 	 		$.ajax({  
		        type: "post",  
		        dataType: "json",
		        url: "../comment/add",
		        data:{"orderGoodsId":button.parents(".toggletr").find(":hidden[name='orderGoodsId']").val(),
		        	  "starScore":button.parents(".toggletr").find(".yellow-icon").length,
		        	  "goodsComment":button.parents(".toggletr").find("[name='goodsComment']").val()},
		        success: function(data) {
		        	if(data==200){
		        		//改状态
		        		button.parents(".toggletr").prev(".bluem2").find("a.togglea2").text("查看评价");
		        		//评分心得不可改
		        		button.parents(".starScore").removeClass("starScore");
		        		button.parents(".toggletr").find("[name='goodsComment']").prop("disabled", true);
		        		button.parents(".toggletr").find(".span11").hide();
		        		//隐藏提交按钮
		        		button.parent().hide();
		        		//打开下一个页面
		        		button.parents('.toggletr').nextAll('.starScore').first().slideToggle();
		        		button.parents('.toggletr').hide("fast");
		        		index = button.parents('.toggletr').nextAll('.starScore').first().find(".yellow-icon").length - 1;
		        	}else{
		        		button.parents(".toggletr").find("b:eq(2)").html(data).show(); 
		        	}
		        },  
		        error: function(data) {  
		            //alert(data);  
		        }  
		    })  ;  
		});
	});