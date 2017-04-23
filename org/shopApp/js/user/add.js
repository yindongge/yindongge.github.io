$(document).ready(function() {
		
		//时间选择器
		$(".date").datetimepicker({
			format: 'YYYY-MM-DD',
			//sideBySide:true,
			//showClear:true,
			locale:'zh-cn'
		});
		$("#birthday").on("dp.change", function (e) {
		    $('#birthday').data("DateTimePicker");
		});
	
		$("#provinceCode").change(function(){
			if($('#provinceCode').val() == -1){
				$('#cityCode').empty();
	          	$('#cityCode').append("<option value='-1'>请选择市</option>");
	          	//商圈选择变更
	          //	changeBusinessArea('');
		
			}else{
				$.ajax({
		            type: "POST",
		            dataType: "json",
		            url: "../area/getByParentCode",
		            data: {'parentCode':$('#provinceCode').val()},
		            success: function (data) {
		           	 $('#cityCode').empty();
		           	 $('#cityCode').append("<option value='-1'>请选择市</option>");
		                $.each(data.listArea,function(idx, obj){
		               	 $('#cityCode').append("<option value=\""+obj.code+"\">"+obj.name+"</option>");
		                }); 
		            },
		            error: function(data) {
		            }
		        });
				//地图区域变更
			
			}
			$('#countyCode').empty();
          	$('#countyCode').append("<option value='-1'>请选择区或县</option>");
		});
		
		//区域市下拉列表选择变更
		$("#cityCode").change(function(){
			if($('#cityCode').val() == -1){
	          	$('#countyCode').empty();
	          	$('#countyCode').append("<option value='-1'>请选择区或县</option>");
	          	//商圈选择变更
	          	//hangeBusinessArea($('#provinceCode option:selected').val());
				//地图区域变更
				
			}else{
				$.ajax({
		            type: "POST",
		            dataType: "json",
		            url: "../area/getByParentCode",
		            data: {'parentCode':$('#cityCode').val()},
		            success: function (data) {
		           	 $('#countyCode').empty();
		           	 $('#countyCode').append("<option value='-1'>请选择区或县</option>");
		                $.each(data.listArea,function(idx, obj){
		               	 $('#countyCode').append("<option value=\""+obj.code+"\">"+obj.name+"</option>");
		                }); 
		            },
		            error: function(data) {
		            }
		        });
	          	//商圈选择变更
	          	//changeBusinessArea($('#cityCode option:selected').val());
		
			}
		});
		
		$("#provinceCode_").change(function(){
			if($('#provinceCode_').val() == -1){
				$('#cityCode_').empty();
	          	$('#cityCode_').append("<option value='-1'>请选择市</option>");
	          	//商圈选择变更
	          //	changeBusinessArea('');
		
			}else{
				$.ajax({
		            type: "POST",
		            dataType: "json",
		            url: "../area/getByParentCode",
		            data: {'parentCode':$('#provinceCode_').val()},
		            success: function (data) {
		           	 $('#cityCode_').empty();
		           	 $('#cityCode_').append("<option value='-1'>请选择市</option>");
		                $.each(data.listArea,function(idx, obj){
		               	 $('#cityCode_').append("<option value=\""+obj.code+"\">"+obj.name+"</option>");
		                }); 
		            },
		            error: function(data) {
		            }
		        });
				//地图区域变更
			
			}
			$('#countyCode_').empty();
          	$('#countyCode_').append("<option value='-1'>请选择区或县</option>");
		});
		
		//区域市下拉列表选择变更
		$("#cityCode_").change(function(){
			if($('#cityCode_').val() == -1){
	          	$('#countyCode_').empty();
	          	$('#countyCode_').append("<option value='-1'>请选择区或县</option>");
			}else{
				$.ajax({
		            type: "POST",
		            dataType: "json",
		            url: "../area/getByParentCode",
		            data: {'parentCode':$('#cityCode_').val()},
		            success: function (data) {
		           	 $('#countyCode_').empty();
		           	 $('#countyCode_').append("<option value='-1'>请选择区或县</option>");
		                $.each(data.listArea,function(idx, obj){
		               	 $('#countyCode_').append("<option value=\""+obj.code+"\">"+obj.name+"</option>");
		                }); 
		            },
		            error: function(data) {
		            }
		        });
			}
		});

	});
	
	
	function save(){
		
		var username =$("#userName").val();
		
		if(username.length<2||username.length>10){
			alert("用户名 长度在 2-10 之间"); return false;
		}
		
		if(!$("#email").val().match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)){
			alert("邮箱格式不正确！"); return false;
		}
		
		if(!$("#mobilePhone").val().match(/^0?1[3|4|5|7|8][0-9]\d{8}$/)){
			alert("手机号不正确！"); return false;
		}
		
		
		  $.ajax({
              type: "POST",
              dataType: "json",
              url: "../user/save",
              data: $('#userform').serialize(),
              success: function (data) {  
                 if(data.code==200){
                	 alert("添加成功");
                	 location.href="../user/list";
                 }else{
                	if(data.code==400){
                		alert("邮箱已经被注册");
                	}
                	
                	if(data.code==401){
                		alert("此手机号已经被注册！");
                	}
                 }
              },
              error: function(data) {
                
               }
          });
	}
	