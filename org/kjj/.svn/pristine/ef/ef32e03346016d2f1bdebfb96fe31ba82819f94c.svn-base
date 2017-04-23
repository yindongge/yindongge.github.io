$(function(){
// 	var myCity = new BMap.LocalCity();
// 	myCity.get(myFun);//定位所在城市用ip
	
	//*************************************************************新做
	handleThreeCookie();
	
	$("#icon_sear").on('click','i',function(){
		if($("#SearchLayer").is(":hidden")){
			var region = $(".first_list_city").find("a.active").text();
			$("#city").text(region);
			$.each($(".select_first li"),function(i,obj){
				if(obj.innerHTML == region){
					$(this).click();
				}
			});
			$("#SearchLayer").show();
			$("#changeLayer").hide();
			$("#icon_sear").hide();
			$("#icon_back").show();
		}else{
			$("#changeLayer").hide();
		}
	});
	
	
	$(".first_list_city").on('click','a',function(){
		$(this).addClass("active").siblings().removeClass("active");
		var provinceCode = $(this).attr("data-code");
		$.ajax({
			type:'post',
			data:{"provinceCode":provinceCode},
			dataType:'json',
			url:'${ctx}/shop/getZone',
			success:function(data){
				if(data.code == 200){
					if(Object.keys(data.zone).length != 0){
						var html="<span class=\"strong\">区域</span>";
						$.each(data.zone,function(index,obj){
							html+="<a data-code="+index+">"+obj+"</a>";
						});
						$(".second_list_area").html(html);
						$(".second_list_area").find("a:first").addClass("on");
						$(".second_list_area").off("click","a");//先取消绑定的事件
						bindMethod();
					}else{
						$(".change_new_content").html("");
						//$(".second_list_area").html("");
					}
				}
			}
		});
	});
	$(".first_list_city").find("a:first").click();
	//*************************************************************
	
	
	
	handleCookie();

	var shopId = $("#shopId").val();
	if(shopId != ""){
	$("#switchshop").click(function(){
		$(".mask-index").show();//遮罩
		if($(".ul_first").find("li").length > 0){
			$(".change_shop_left").find("h5:eq(0)").show();
		}
		var shopName = '${kjjuser.orgShop.shopName}';
 		if(shopName != ""){
 			var name = '${kjjuser.orgShop.address}';
 			var longitude = '${kjjuser.orgShop.longitude}';
 			var latitude = '${kjjuser.orgShop.latitude}';
 			selectLocal(name,longitude,latitude);
 			$(".change_shop_list").find(".change_shop_item:eq(0)").addClass("on");
 			$("#area_list").html("");
 			$(".select_input").val("");
 			var shopId = '${kjjuser.orgShop.shopId}';
 			sendRange(shopId);
 		}
		$("#area").show(); //显示
	});
}
	
	$(".change_shop_list").on("mouseover",".change_shop_item",function(){
		$(".change_shop_left").find("h5:eq(0)").attr("style","display:block");
		$(this).addClass("on").siblings().removeClass("on");
		var shopId = $(this).attr("data-shopId");
		sendRange(shopId);
	});
	
	$(".change_shop_list").on("click",".change_shop_item",function(){
		var shopId = $(this).attr("data-shopId");
		setShop(shopId);
	});
	
	$(".change_new_content").on("click",".change_item",function(){
		var shopId = $(this).attr("data-shopId");
		setShop(shopId);
	});
	
	$(window).scroll(function(){
	if($(window).scrollTop()>800){
		$(" .go-top").fadeIn();
	}
	else{
		$(".go-top").hide();
	}
	});
	$(".go-top").click(function(){
		$('html,body').animate({'scrollTop':0},900);
	});
	
	$('.select_top').click(function(){
		$(this).toggleClass('on').next('.select_content').toggleClass('active');
	});
	$('.select_input').focus(function(){
		$(this).parents('.select_second ').find('.select_content').addClass('active');
	});
	
	$(".select_first li").click(function(){
		$("#city").text($(this).text());
		$(this).addClass("active");
		$(this).siblings().removeClass("active");
		$("#city_select").removeClass("active");
		$(this).parents(".select_first").find(".select_top").removeClass("on");
	});
	
	$(".select_top_second input").bind('input',function(){
		var region = $("#city").text();
		var query = $(this).val(); 
		$.ajax({
			type:'get',
			dataType:'jsonp',
			url:"http://api.map.baidu.com/place/v2/suggestion?query="+query+"&region="+region+"&output=json&ak=D1DhyuyKwUtxW0r52g0gzxtFFviKv0tk",
			success:function(data){
				if(data.status == 0){
					var html = "";
					$.each(data.result,function(index,obj){
						if(typeof(obj.location) != "undefined"){
							html+="<li data-longitude='"+obj.location.lng+"' data-latitude='"+obj.location.lat+"' data-name='"+obj.name+"'>";
							html+=obj.city+obj.district+" ("+obj.name+")</li>";
						}
					});
					$("#area_list").html(html);
				}
			},
			error:function(data){
			}
		});
	});
	
	$("#area_list").on("click","li",function(){
		$(this).parents(".select_second").find("input").val($(this).text());
		$("#location_select").removeClass("active");
		selectLocal($(this).attr("data-name"),$(this).attr("data-longitude"),$(this).attr("data-latitude"));
	});
	
});
	
	//********************************************新做
	function goback(){
		if($("#SearchLayer").is(":hidden")){
			$("#changeLayer").show();
		}else{
			$("#SearchLayer").hide();
			$("#changeLayer").show();
			$("#icon_sear").show();
			$("#icon_back").hide();
		}
	}

	function bindMethod(){
		$(".second_list_area").on('click','a',function(){
			$(this).addClass("on").siblings().removeClass("on");
			var areaCode = $(this).attr("data-code");
			$.ajax({
				type:'post',
				url:'${ctx}/shop/getZoneShop',
				data:{"areaCode":areaCode},
				dataType:'json',
				success:function(data){
					if(data.code == 200){
						var html = "";
						if(data.shopList.length>0){
							$.each(data.shopList,function(index,obj){
									html+="<div class=\"change_item\" data-shopId="+obj.shopId+"><div class=\"change_word\">";
									html+="<h5>"+obj.shopName+"</h5><p>"+obj.address+"</p></div>";
									html+="<img src="+obj.imgUrl+" alt=\"\" />";
									html+="<span class=\"icon_position\" onclick='getPosition("+obj.longitude+","+obj.latitude+","+obj.shopId+",event)'></span>";
									html+="<span class=\"line_through\"></span>";
									html+="<div class=\"change_hover\">";
									html+="<span><i class=\"icon_t\"></i>"+obj.firstPhoneAreaCode+"-"+obj.firstPhoneNo+"</span>";
									html+="<span><i class=\"icon_s\"></i>"+new Date(obj.openTimeStart).toTimeString().substring(0,5)+"-"+new Date(obj.openTimeEnd).toTimeString().substring(0, 5)+"</span></div></div>";
							});
							$(".change_new_content").html(html);
						}else{
							$(".change_new_content").html("");
							//$(".second_list_area").html("");
						}
					}
				},
				error:function(data){}
			});
		})
		$(".second_list_area").find("a:first").click();
	}
	
	function getPosition(longitude,latitude,shopId,e){
		e.stopPropagation();
		window.open("../shop/getMap/"+longitude+"/"+latitude+"/"+shopId,"_blank");
	}
	
	function handleThreeCookie(){
		//最多显示三个最近访问的门店
		var shopIdStr = $.cookie('usershophistory');
		if(shopIdStr != null){
			if(shopIdStr.split(":").length>1){
				var shopIds = [];
				shopIds = shopIdStr.split(":").reverse();
				var html="<span class=\"strong\">历史</span>";
				for(var i=0;i<shopIds.length-1;i++){
					html+="<a onclick='setShop("+shopIds[i].split("-")[0]+")'>"+shopIds[i].split("-")[1]+"</a>"
					if(i == 2){
						break;
					}
				}
				html+="<span class=\"right_span\">仅显示最近所选择的3家门店</span>";
				$(".change_new_title").show();
				$(".change_new_title").html(html);
			}
		}else{
			$(".change_new_title").hide();
		}
	}
	//********************************************

	function selectLocal(name,longitude,latitude){
		$.ajax({
			type:'post',
			dataType:'json',
			url:'${ctx}/shop/location',
			data:{"name":name,"longitude":longitude,"latitude":latitude},
			success:function(data){
				if(data.code == 200){
					var html="";
					$.each(data.listShop,function(index,obj){
						html+="<div class=\"change_shop_item\" data-shopId="+obj.shopId+">";
 						html+="<img src="+obj.imgUrl+" alt='' />";
 						if(obj.isNew){
 							html+="<a class=\"newshopicon\"></a>";
 						}
						html+="<h5>快捷健超市（"+obj.shopName+"） <span>距离约<i>"+(obj.distance/1000).toFixed(2)+"km</i></span></h5>";
						html+="<p title='"+obj.address+"'>"+obj.address+"</p>";
						html+="<p>"+obj.firstPhoneAreaCode+"-"+obj.firstPhoneNo;
						html+="<span>"+new Date(obj.openTimeStart).toTimeString().substring(0,5)+"-"+new Date(obj.openTimeEnd).toTimeString().substring(0, 5)+"</span></p></div>";
					});
					$(".change_shop_list").html(html);
					var shopId = '${kjjuser.orgShop.shopId}';
					var shopItemId = $(".change_shop_list").find(".change_shop_item:eq(0)").attr("data-shopId");
			 		if(shopId != "" && shopId == shopItemId){
			 			$(".change_shop_list").find(".change_shop_item:eq(0)").addClass("on");
			 			sendRange(shopItemId);
			 		}
			 		handleCookie();
				}
			},
			error:function(data){}
		});
	}
	
	function setShop(shopId){
		$.ajax({  
		    type: "post",  
		    dataType:"json",
		    url: "${ctx}/shop/select/"+shopId,  
		    success: function(data) {  
		       if(data.code == 200){
			      if(backurl != null && backurl != ""  && backurl != "null"){
				    location.href=backurl;
			      }else{
			        location.reload();	      	
			      }
		       }
		    },  
		    error: function(data) {  
		    }  
		})  ;
	}
	
	function sendRange(shopId){
		$(".change_shop_left").find("h5:eq(0)").attr("style","display:block");
		$.ajax({
			type:'post',
			dataType:'json',
			url:'${ctx}/shop/sendRange',
			data:{"shopId":shopId},
			success:function(data){
				if(data.code == 200){
					var html = "";
					$.each(data.sendRangeList,function(index,obj){
						html+="<li>"+obj.sendRangeName+"<li>";
					});
					$(".ul_first").html(html);
				}
			},
			error:function(data){}
		});
	}
	
	function closeShop(){
		$("#area").attr("style","display:none");
		$(".mask-index").hide();
	}
	
	function handleCookie(){
		//历史记录店铺的处理
		var shopIdStr = $.cookie('usershophistory');
		if(shopIdStr != null){
			if(shopIdStr.split(":").length>1){
				var shopIds = [];
				shopIds = shopIdStr.split(":").reverse();
				var html="";
				for(var i=0;i<shopIds.length-1;i++){
					html+="<li onclick='setShop("+shopIds[i].split("-")[0]+")'>"+shopIds[i].split("-")[1]+"</li>"
				}
				$(".ul_second").html(html);
			}
		}else{
			$(".ul_second").html("<li>没有选择过的门店哦~</li>");
		}
	}
	
	function myFun(result){
		var cityName = result.name;
		$.cookie('city',cityName);
	}