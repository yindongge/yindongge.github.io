$(function () {
	//创建Map实例,设置地图允许的最小/大级别
	var map = new BMap.Map("allmap",{minZoom:11});
	//添加默认缩放平移控件
	map.addControl(new BMap.NavigationControl());
	//拖拽点
	var mkCenter;
	//定位当前位置
	var longitude = $("#longitude").val();
	var latitude = $("#latitude").val();
	if(longitude == '' || latitude == '' ){
		$("#loadingPosition").show();
		var geolocation = new BMap.Geolocation();
		geolocation.getCurrentPosition(function(r){
			if(this.getStatus() == BMAP_STATUS_SUCCESS){
				//定位成功
				showMap(r.point);
			}
			else {
				//定位失败
				var pointBJ = new BMap.Point(116.404, 39.915);
				showMap(pointBJ);
			}        
		},{enableHighAccuracy: true});
	}else{
		//使用默认地址
		var pointDefault = new BMap.Point(longitude, latitude);
		showMap(pointDefault);
	}
	//搜索
	//建立一个自动完成的对象
	var ac = new BMap.Autocomplete(
		{"input" : "suggestId"
		,"location" : map
	});
	//鼠标放在下拉列表上的事件
	ac.addEventListener("onhighlight", function(e) {
		var str = "";
			var _value = e.fromitem.value;
			var value = "";
			if (e.fromitem.index > -1) {
				value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
			}    
			str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
			
			value = "";
			if (e.toitem.index > -1) {
				_value = e.toitem.value;
				value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
			}    
			str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
			document.getElementById("searchResultPanel").innerHTML = str;
	});
	
	//选择的值
	var myValue;
	//鼠标点击下拉列表后的事件
	ac.addEventListener("onconfirm", function(e) {
		var _value = e.item.value;
		myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		document.getElementById("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
		setPlace();
	});
	
    $(window).scroll(function () {
        var scrollTop = $(this).scrollTop();
        var scrollHeight = $(document).height();
        var windowHeight = $(this).height();
        if (scrollTop + windowHeight == scrollHeight) {
        	addSendRangeList();
        }else{
        	$("#loadMore").css({opacity:0});
        }
    });
	
	function showMap(point){
		//设置区域
		map.centerAndZoom(point, 16);
		//初始化
		initSendRangeList(point);
		
		//定位位置
		var iconLocal = new BMap.Icon($("#imgBase").val()+"/map2.png", new BMap.Size(14,14));
		var mkLocal = new BMap.Marker(point,{icon:iconLocal});
		map.addOverlay(mkLocal);
		
		//拖拽点
		var iconCenter = new BMap.Icon($("#imgBase").val()+"/map1.png", new BMap.Size(18,25));
		mkCenter = new BMap.Marker(point,{icon:iconCenter,raiseOnDrag:true});
		map.addOverlay(mkCenter);
		mkCenter.enableDragging();
		mkCenter.addEventListener("dragend",function(){
			initSendRangeList(mkCenter.getPosition());
		});
		//删除定位中
		$("#loadingPosition").remove();
	}
	
	function initSendRangeList(point){
		$("#longitude").val(point.lng);
		$("#latitude").val(point.lat);
		$("div.padding").html("");
		$("#loadMore").attr("data-page-next",0);
		addSendRangeList();
	}

	//加载中
	var isAddLoading = false;
	function addSendRangeList(){
		//不是最后一页
		if($("#loadMore").attr("data-page-next") != -1){
			$("#loadMore").css({opacity:1});
			//加载中不能再次加载
			if(!isAddLoading){
				isAddLoading = true;
				$.ajax({
				    type: "post",  
				    dataType:"json",
				    url: "../sendRange/load",  
				    data: {'longitude':$("#longitude").val(),'latitude':$("#latitude").val(),'pageNumber':$("#loadMore").attr("data-page-next")},
				    success: function(data) {  
				       if(data.code==200){
				    	   if(!data.pageSendRange.lastPage){
				    		   $("#loadMore").attr("data-page-next",data.pageSendRange.number+1);
				    	   }else{
				    		   //没有数据
				    		   if(data.pageSendRange.firstPage && data.pageSendRange.content.length == 0){
				    			   $("div.padding").append("<div class=\"yichu\">超出配送范围</div>");
					    	   }
				    		   $("#loadMore").attr("data-page-next","-1");
				    	   }
				    	   
				    	   var divHtml = "";
				    	   $.each(data.pageSendRange.content,function(idx, obj){
				    		   divHtml += "<div class='villagelist' onClick=\"selectSendRange(";
				    		   divHtml += obj.id;
				    		   divHtml += ",'";
				    		   divHtml += obj.sendRangeName;
				    		   divHtml += "');\">";
				    		   divHtml += "<h5><span class='smallicon'></span>";
				    		   divHtml += obj.sendRangeName;
				    		   divHtml += "</h5><p>";
				    		   divHtml += obj.area[2];
				    		   divHtml += "</p></div>";
				    	   });
				    	   $("div.padding").append(divHtml);
				    	   isAddLoading = false;
				    	   $("#loadMore").css({opacity:0});
				       }
				    },  
				    error: function(data) {  
				    }  
				})  ;
			}
		}
	}

	function setPlace(){
		function myFun(){
			//获取第一个智能搜索的结果
			var pp = local.getResults().getPoi(0).point;    
			mkCenter.setPosition(pp);
			map.centerAndZoom(pp, 16);
			initSendRangeList(pp);
		}
		var local = new BMap.LocalSearch(map, { 
			//智能搜索
			onSearchComplete: myFun
		});
		local.search(myValue);
	}
});

function selectSendRange(id,name){
	$("[name='sendRangeId']").val(id);
	$("[name='sendRangeName']").val(name);
	$("#sendRangeform").submit();
}