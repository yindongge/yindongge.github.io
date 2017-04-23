$(function () {
		//地图初始化
		showMap("myPoint");
		
		//区域省下拉列表选择变更
		$("#provinceCode").change(function(){
			if($('#provinceCode').val() == -1){
				$('#cityCode').empty();
	          	$('#cityCode').append("<option value='-1'>请选择市</option>");
	          	//商圈选择变更
	          	changeBusinessArea('');
				//地图区域变更
				showMap("中国");
			}else{
				$.ajax({
		            type: "POST",
		            dataType: "json",
		            url: "../../area/getByParentCode",
		            data: {'parentCode':$('#provinceCode').val()},
		            success: function (data) {
		            	if(data.code==200){
		            		 $('#cityCode').empty();
				           	 $('#cityCode').append("<option value='-1'>请选择市</option>");
				                $.each(data.listArea,function(idx, obj){
				               	 $('#cityCode').append("<option value=\""+obj.code+"\">"+obj.name+"</option>");
				                }); 
		            	}
		            },
		            error: function(data) {
		            }
		        });
				//地图区域变更
				showMap($('#provinceCode option:selected').text());
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
	          	changeBusinessArea($('#provinceCode option:selected').val());
				//地图区域变更
				showMap($('#provinceCode option:selected').text());
			}else{
				$.ajax({
		            type: "POST",
		            dataType: "json",
		            url: "../../area/getByParentCode",
		            data: {'parentCode':$('#cityCode').val()},
		            success: function (data) {
		            	if(data.code==200){
		            		$('#countyCode').empty();
				           	 $('#countyCode').append("<option value='-1'>请选择区或县</option>");
				                $.each(data.listArea,function(idx, obj){
				               	 $('#countyCode').append("<option value=\""+obj.code+"\">"+obj.name+"</option>");
				                }); 
		            	}
		            },
		            error: function(data) {
		            }
		        });
	          	//商圈选择变更
	          	changeBusinessArea($('#cityCode option:selected').val());
				//地图区域变更
				showMap($('#cityCode option:selected').text());
			}
		});
		
		//区域县下拉列表选择变更
		$("#countyCode").change(function(){
			if($('#countyCode').val() == -1){
	          	//商圈选择变更
	          	changeBusinessArea($('#cityCode option:selected').val());
				//地图区域变更
				showMap($('#cityCode option:selected').text());
			}else{
	          	//商圈选择变更
	          	changeBusinessArea($('#countyCode option:selected').val());
				//地图区域变更
				showMap($('#countyCode option:selected').text());
			}
		});
		
		//24小时营业点击事件
		$("#fullTime").click(function(){
			changeFullTime();
		});
		
		//搜索按钮点击事件
		$("#search").click(function(){
			showMap();
		});
		
		//配送范围添加
		$("#sendAdd").click(function(){
			if($('#sendRange').val() != ''){
				$.ajax({
		            type: "POST",
		            dataType: "json",
		            url: "../sendRange/add",
		            data: {'shopId':$('#shopId').val(),'sendRangeName':$('#sendRange').val()},
		            success: function (data) {
		            	if(data.code==200){
		            		var sendRangeList = "";
							sendRangeList += "<li class='list-group-item'>";
							sendRangeList += "<div class='list-group-left'>";
							sendRangeList += "<input type='hidden' name='sendRangeId' value='"+data.desc+"'/>";
							sendRangeList += "<span class='list-content-span'>"+$('#sendRange').val()+"</span>";
							sendRangeList += "<input type='text' class='form-control widthme' name='sendRangeList' value='"+$('#sendRange').val()+"'/>";
							sendRangeList += "</div>";
							sendRangeList += "<div class='list-group-right'>";
							sendRangeList += "<span class='badge reversebadge bg2 btnEdit'>编辑</span>";
							sendRangeList += "<span class='badge reversebadge bg2 btnDel'>删除</span>";
							sendRangeList += "<span class='badge reversebadge bg1 btnCancel btn-danger'>取消</span>";
							sendRangeList += "<span class='badge reversebadge bg1 btnConfirm btn-danger'>确定</span>";
							sendRangeList += "</div>";
							sendRangeList += "</li>";
							$('#sendRangeList').prepend(sendRangeList);
							$('#sendRange').val("");
							//校验
					        $('#shopEdit').data('bootstrapValidator').updateStatus('sendAdd', 'NOT_VALIDATED', null).validateField('sendAdd');
		            	}
		            },
		            error: function(data) {
		            }
		        });
			}
		});
		
		//配送范围删除
		$("#sendRangeList").on("click",".btnDel",function(){
			var group = $(this).parent().parent();
			group.find(".bg2").hide();
			group.find(".bg1").show();
			//校验
	        $('#shopEdit').data('bootstrapValidator').updateStatus('sendAdd', 'NOT_VALIDATED', null).validateField('sendAdd');
		});
		
		//配送范围编辑
		$("#sendRangeList").on("click",".btnEdit",function(){
			var group = $(this).parent().parent();
			group.find(".bg2").hide();
			group.find(".bg1").show();
			group.find(".list-content-span").hide();
			group.find(".widthme").show();
			//校验
	        $('#shopEdit').data('bootstrapValidator').updateStatus('sendAdd', 'NOT_VALIDATED', null).validateField('sendAdd');
		});
		
		//配送范围确定
		$("#sendRangeList").on("click",".btnConfirm",function(){
			var group = $(this).parent().parent();
			if(group.find(".widthme").is(":visible")){
				//编辑
				//校验
				if(group.find(".widthme").val() == ''){
					return false;
				}
				$.ajax({
		            type: "POST",
		            dataType: "json",
		            url: "../sendRange/edit",
		            data: {'id':group.find("[name='sendRangeId']").val(),'sendRangeName':group.find(".widthme").val()},
		            success: function (data) {
		            	if(data.code=='200'){
			            	group.find(".list-content-span").html(group.find(".widthme").val());
							group.find(".bg1").hide();
							group.find(".bg2").show();
							group.find(".widthme").hide();
							group.find(".list-content-span").show();
		            	}
						//校验
				        $('#shopEdit').data('bootstrapValidator').updateStatus('sendAdd', 'NOT_VALIDATED', null).validateField('sendAdd');
		            },
		            error: function(data) {
		            }
		        });
			}else{
				//删除
				$.ajax({
		            type: "POST",
		            dataType: "json",
		            url: "../sendRange/del",
		            data: {'id':group.find("[name='sendRangeId']").val()},
		            success: function (data) {
		            	if(data.code=='200'){
		            		group.remove();
		            	}else{
		            		group.find(".bg1").hide();
		    				group.find(".bg2").show();
		            	}
		            	//校验
		    	        $('#shopEdit').data('bootstrapValidator').updateStatus('sendAdd', 'NOT_VALIDATED', null).validateField('sendAdd');
		            },
		            error: function(data) {
		            }
		        });
			}
		});
		
		//配送范围取消
		$("#sendRangeList").on("click",".btnCancel",function(){
			var group = $(this).parent().parent();
			if(group.find(".widthme").is(":visible")){
				//编辑
				group.find(".widthme").val(group.find(".list-content-span").html());
				group.find(".widthme").hide();
				group.find(".list-content-span").show();
				group.find(".bg1").hide();
				group.find(".bg2").show();
			}else{
				//删除
				group.find(".bg1").hide();
				group.find(".bg2").show();
			}
			//校验
	        $('#shopEdit').data('bootstrapValidator').updateStatus('sendAdd', 'NOT_VALIDATED', null).validateField('sendAdd');
		});
		
		//时间选择器
		$(".time").datetimepicker({
			format: 'HH:mm:ss',
			showClear:true
		});
		
		//校验
		$("#shopEdit").bootstrapValidator({
			message: 'This value is not valid',
	        feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	        	shopCode : {
					trigger: 'blur',
					validators : {
						remote: {
	                        message: '店铺编号重复',
	                        url: '../editShopCode',
	                        data: function(validator) {
	                            return {
	                                shopId: validator.getFieldElements('shopId').val()
	                            };
	                        }
	                    }
					}
				},
	        	restockCycle: {
	                validators: {
	                    notEmpty: {
	                        message: '送货周期为空'
	                    }
	                }
	            },
	            sendAdd : {
					validators : {
						callback: {
		                    message: '配送范围不能为空且不可为编辑状态',
		                    callback: function(value, validator) {
		                        return $("#sendRangeList li").length>0&&$("#sendRangeList .btnCancel:visible").length==0;
		                    }
		                }
					}
				},
				search : {
					validators : {
						 callback: {
	                        message: '请在地图上标记位置',
	                        callback: function(value, validator) {
	                            return $("#longitude").val()!="" && $("#latitude").val()!="";
	                        }
	                    }
					}
				}
	        }
		});
		
	});
	
	function changeBusinessArea(areaCode){
		$.ajax({
            type: "POST",
            dataType: "json",
            url: "../../businessArea/getListBusinessArea",
            data: {'areaCode':areaCode},
            success: function (data) {
            	if(data.code==200){
            		 $('#businessAreaId').empty();
                   	 $('#businessAreaId').append("<option value='-1'>请选择商圈</option>");
                        $.each(data.list,function(idx, obj){
                       	 $('#businessAreaId').append("<option value=\""+obj.id+"\">"+obj.name+"</option>");
                        }); 
            	}
            },
            error: function(data) {
            }
        });
	}
	
	//24小时时间处理
	function changeFullTime(){
		if($("#fullTime").prop("checked")){
			$("#openTimeStart").data("DateTimePicker").date("00:00:00");
			$("#openTimeEnd").data("DateTimePicker").date("23:59:59");
			$("#openTimeStart").prop("readonly",true);
			$("#openTimeEnd").prop("readonly",true);
		}else{
			$("#openTimeStart").prop("readonly",false);
			$("#openTimeEnd").prop("readonly",false);
		}
	}
	
	//百度地图
	function showMap(mapArea) {
		// 百度地图API功能
		var map = new BMap.Map("allmap");
		//设置区域
		if(mapArea == 'myPoint'){
			var myPoint= new BMap.Point($("#longitude").val(), $("#latitude").val());
			//设置区域
			map.centerAndZoom(myPoint,12);
			//添加新标记
			var marker = new BMap.Marker(myPoint);  // 创建标注
			map.addOverlay(marker);               // 将标注添加到地图中
			marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
			var circle = new BMap.Circle(myPoint,2000,{fillColor:"blue", strokeWeight: 1 ,fillOpacity: 0.3, strokeOpacity: 0.3});
		    map.addOverlay(circle);		
		}else{
			map.centerAndZoom(mapArea,12);
		}
		// 左上角，添加比例尺
		map.addControl(new BMap.ScaleControl({anchor: BMAP_ANCHOR_TOP_LEFT}));  
		//左上角，添加默认缩放平移控件
		map.addControl(new BMap.NavigationControl());   
		map.enableScrollWheelZoom();   //启用滚轮放大缩小，默认禁用
		map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用
		//map.addControl(new BMap.MapTypeControl({mapTypes: [BMAP_NORMAL_MAP,BMAP_HYBRID_MAP]}));          //2D图，卫星图
		map.addControl(new BMap.MapTypeControl({anchor: BMAP_ANCHOR_TOP_RIGHT}));         //右上角，默认地图控件
		//单击获取点击的经纬度
		map.addEventListener("click",function(e){
			//alert(e.point.lng + "," + e.point.lat);
			$("#longitude").val(e.point.lng);
			$("#latitude").val(e.point.lat);
			
			//删除原有标记
			map.clearOverlays();
			//添加新标记
			var point = new BMap.Point(e.point.lng, e.point.lat);
			var marker = new BMap.Marker(point);  // 创建标注
			map.addOverlay(marker);               // 将标注添加到地图中
			marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
			var circle = new BMap.Circle(point,2000,{fillColor:"blue", strokeWeight: 1 ,fillOpacity: 0.3, strokeOpacity: 0.3});
		    map.addOverlay(circle);
		  	//校验
	        $('#shopEdit').data('bootstrapValidator').updateStatus('search', 'NOT_VALIDATED', null).validateField('search');
		});
		//搜索
		var local = new BMap.LocalSearch(map, {
			renderOptions: {map: map}
		});
		local.search($("#searchArea").val());	
	}