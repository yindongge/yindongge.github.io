	$(function () {
		$('.btn-click').click(function(){
			//iframe层
			layer.open({
			    type: 2,
			    title: '选择店铺',
			    shadeClose: true,
			    shade: 0.8,
			    shift:-1,
				maxmin: true, //开启最大化最小化按钮
			    area: ['800px', '450px'],
			    content: '../shop/shopSelectInit' //iframe的url
			}); 
		});
		
		//时间选择器
		$(".date").datetimepicker({
			format: 'YYYY-MM-DD HH:mm:ss',
			sideBySide:true,
			showClear:true,
			locale:'zh-cn'
		});
        $("#createTimeStart").on("dp.change", function (e) {
            $('#createTimeEnd').data("DateTimePicker").minDate(e.date);
        });
        $("#createTimeEnd").on("dp.change", function (e) {
            $('#createTimeStart').data("DateTimePicker").maxDate(e.date);
        });
        
        //查看
        $("tbody").on("click",":button[name='btnDetail']",function(){
        	location.href="../order/detail/"+$(this).parent().parent().find(":checkbox[name='orderIds']").val();
		});
        
        //确认
        $("tbody").on("click",":button[name='btnConfirm']",function(){
        	if(confirm("确定要确认订单么？")){
	        	var td = $(this).parent();
	        	$(this).attr('disabled',"true");
	     		$.ajax({  
	    	        type: "post",  
	    	        dataType: "json",
	    	        url: "../order/confirm",
	    	        data: {"orderId":$(this).parent().parent().find(":checkbox[name='orderIds']").val()},
	    	        success: function(data) {
	    	        	if(data.code==200){
	    	        		var btnHtml = "<button type='button' class='btn btn-danger btn-xs' name='";
	    	        		//改状态
	    	        		if(td.prev().prev().text().indexOf("送货")>=0){
	    	        			td.prev().text("待发货");
	    	        			btnHtml += "btnSend'>发货</button>";
	    	        		}else if(td.prev().prev().text().indexOf("自提")>=0){
	    	        			td.prev().text("备货中");
	    	        			btnHtml += "btnTake'>待自提</button>";
	    	        		}
	    	        		//改操作按钮
	    	        		td.html("<button type='button' class='btn btn-warning btn-xs' name='btnDetail'>查看</button>"+btnHtml);
	    	        	}else{
	    	        		alert(data.desc);
	    	        	}
	    	        },  
	    	        error: function(data) {  
	    	            alert("系统错误");  
	    	        }  
	    	    })  ; 
        	}
		});
        
        //发货
        $("tbody").on("click",":button[name='btnSend']",function(){
        	if(confirm("确定要发货么？")){
	        	var td = $(this).parent();
	        	$(this).attr('disabled',"true");
	     		$.ajax({  
	    	        type: "post",  
	    	        dataType: "json",
	    	        url: "../order/sendOrTake",
	    	        data: {"orderId":$(this).parent().parent().find(":checkbox[name='orderIds']").val()},
	    	        success: function(data) {
	    	        	if(data.code==200){
	    	        		//改状态
	    	        		td.prev().text("待收货");
	    	        		//改操作按钮
	    	        		td.html("<button type='button' class='btn btn-warning btn-xs' name='btnDetail'>查看</button>"+
	    	        				"<button type='button' class='btn btn-danger btn-xs' name='btnFinish'>完成</button>");
	    	        	}else{
	    	        		alert(data.desc);
	    	        	}
	    	        },  
	    	        error: function(data) {  
	    	        	alert("系统错误"); 
	    	        }  
	    	    })  ; 
        	}
        });
        
        //自提
        $("tbody").on("click",":button[name='btnTake']",function(){
        	if(confirm("确定可以自提么？")){
	        	var td = $(this).parent();
	        	$(this).attr('disabled',"true");
	     		$.ajax({  
	    	        type: "post",  
	    	        dataType: "json",
	    	        url: "../order/sendOrTake",
	    	        data: {"orderId":$(this).parent().parent().find(":checkbox[name='orderIds']").val()},
	    	        success: function(data) {
	    	        	if(data.code==200){
	    	        		//改状态
	    	        		td.prev().text("待自提");
	    	        		//改操作按钮
	    	        		td.html("<button type='button' class='btn btn-warning btn-xs' name='btnDetail'>查看</button>"+
	    	        				"<button type='button' class='btn btn-danger btn-xs' name='btnFinish'>完成</button>"+
	    	        				"<br/>"+
	    							"<div class='alerttip' style='display: none;'>"+
	    							"<span class='red'></span>"+
									"<input type='text' placeholder='请输入提货码' name='takeCodeFinish'/>"+
									"<p class='text-center'>"+
									"<button name='btnTakeCancel' type='button' class='btn btn-default btn-xs'>取消</button>"+
									"<button name='btnTakeFinish' type='button' class='btn btn-info btn-xs'>确认</button>"+
									"</p>"+
									"</div>");
	    	        	}else{
	    	        		alert(data.desc);
	    	        	}
	    	        },  
	    	        error: function(data) {  
	    	        	alert("系统错误"); 
	    	        }  
	    	    })  ;
        	}
        });
        
        //完成
        $("tbody").on("click",":button[name='btnFinish']",function(){
        	var td = $(this).parent();
        	if(td.prev().prev().text().indexOf("送货")>=0){
        		if(confirm("确定订单完成了么？")){
        			$(this).attr('disabled',"true");
    	     		$.ajax({  
    	    	        type: "post",  
    	    	        dataType: "json",
    	    	        url: "../order/finish",
    	    	        data: {"orderId":$(this).parent().parent().find(":checkbox[name='orderIds']").val()},
    	    	        success: function(data) {
    	    	        	if(data.code=="200"){
    	    	        		//改状态
    	    	        		td.prev().text("已完成");
    	    	        		//改操作按钮
    	    	        		td.html("<button type='button' class='btn btn-warning btn-xs' name='btnDetail'>查看</button>");
    	    	        	}else{
    	    	        		alert(data.desc);
    	    	        	}
    	    	        },  
    	    	        error: function(data) {  
    	    	        	alert("系统错误");  
    	    	        }  
    	    	    })  ; 
            	}
    		}else if(td.prev().prev().text().indexOf("自提")>=0){
    			td.find(".alerttip").show();
    		}
		});
        
        //自提完成
        $("tbody").on("click",":button[name='btnTakeFinish']",function(){
			var td = $(this).parents("td");
			var div = $(this).parents(".alerttip");
			var takeCodeFinish = div.find("[name='takeCodeFinish']");
			
			div.find("span").html("");
			
			if(takeCodeFinish.val() == ""){
				div.find("span").html("提货码为空！");
				takeCodeFinish.focus();
				return false;
			}
			$(this).attr('disabled',"true");
			//送货上门
			$.ajax({  
       	        type: "post",  
       	        dataType: "json",
       	        url: "../order/finish",
       	        data: {"orderId":$(this).parents("tr").find(":checkbox[name='orderIds']").val(),'takeCode':takeCodeFinish.val()},
       	        success: function(data) {
       	        	if(data.code=="200"){
       	        		div.hide();
       	        		//改状态
    	        		td.prev().text("已完成");
    	        		//改操作按钮
    	        		td.html("<button type='button' class='btn btn-warning btn-xs' name='btnDetail'>查看</button>");
       	        	}else{
       	        		div.find("span").html("提货码错误！");
       	        		takeCodeFinish.focus();
       	        	}
       	        },  
       	        error: function(data) {  
       	        	alert("系统错误"); 
       	        }  
       	    })  ; 
			
		});
        
        //自提取消
        $("tbody").on("click",":button[name='btnTakeCancel']",function(){
			$(this).parents(".alerttip").hide();
		});
        
	});