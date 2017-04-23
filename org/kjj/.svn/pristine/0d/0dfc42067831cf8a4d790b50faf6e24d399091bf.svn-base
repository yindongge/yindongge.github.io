<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
	HttpSession s= request.getSession();
%>
	<div class="select-city">
					<strong class="strong">${kjjuser.orgShop.shopName}</strong>
					<span class="small area-select" id="switchshop">切换 <i class="glyphicon glyphicon glyphicon-menu-down"></i></span>
					<!-- 新做选择区域页面 -->
					<div class="change_wrapper" id="area" style="display:none;">
					<input type="hidden" id="shopId" name="shopId" value="${kjjuser.orgShop.shopId}"/>
						<div class="change_shop_title">
							<img src="${imgBase}/small_logo.png" alt="" class="small_logo" />
							<span class="change_text">快捷健商城 - 请选择离您最近的门店</span>
							<span class="close_change" onclick="closeShop()"></span>
						</div>
						<div class="change_shop_content">
							<div class="change_shop_left">
								<h5>配送范围</h5>
								<ul class="ul_first">
								</ul>
								<h5>历史记录</h5>
								<ul class="ul_second">
								</ul>
							</div>
							<div class="change_shop_right">
								<div class="change_shop_select">
									<div class="select_first ">
										<div class="select_top ">
											<span  id="city">北京</span>
											<i class="glyphicon glyphicon-menu-down"></i>
										</div>
										<div class="select_content" id="city_select">
											<ul>
												<li>北京</li>
												<li>上海</li>
											</ul>
										</div>
									</div>
									<div class="select_second ">
										<div class="select_top_second ">
											<input type="text" placeholder="请输入你的位置(小区,或写字楼)" class="select_input" />
										</div>
										<div class="select_content" id="location_select">
											<ul id="area_list">
											</ul>
										</div>
									</div>
								</div>
								<div class="change_shop_list">

								</div>
							</div>

						</div>
					</div>
					<!-- 新做选择区域页面 -->

				</div>
<script type="text/javascript">
$(function(){
	
// 	var canHide = false; //标记是否可隐藏层
// 	function doHide(){   //是否隐藏层中这里处理
// 	  if(canHide)
// 		$("#area").hide();
// 	  if(!$("#area").is(":visible")){//判断div是否可见
// 			$(".mask-index").hide();
// 		}
// 	}
	handleCookie();

	var shopId = $("#shopId").val();
	if(shopId != ""){
	$("#switchshop").click(function(){
		$(".mask-index").show();//遮罩
		if($(".ul_first").find("li").length > 0){
			$(".change_shop_left").find("h5:eq(0)").attr("style","display:block");
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
			url:"http://api.map.baidu.com/place/v2/suggestion?query="+query+"&region="+region+"&output=json&ak=A0032c548e9b59c84e63b08015bfc6cb",
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
		var backurl='<%=s.getAttribute("kjjbackurl")%>';
		<%s.setAttribute("kjjbackurl", "");%>;
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
</script>