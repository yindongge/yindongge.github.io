$(function () {
	
	//定位
	position();
	
	//搜索
	$("#suggestId").bind('input',function(){
		$(".search-wrapper").remove();
		$.ajax({
		    type: "get",  
		    dataType:"jsonp",
		    url: "http://api.map.baidu.com/place/v2/suggestion?query="+$("#suggestId").val()+"&region=北京&output=json&ak=A0032c548e9b59c84e63b08015bfc6cb",  
		    success: function(data) { 
		       if(data.status==0){
		    	   var html = "";
		    	   $.each(data.result,function(index,obj){
		    		   if(typeof(obj.location) != "undefined"){
		    			   html += "<div class=\"villagelist\" data-longitude=\""+obj.location.lng+"\" data-latitude=\""+obj.location.lat+"\" data-name=\""+obj.name+"\">";
						   html += "<h5>"+obj.name+"</h5>";
						   html += "<p>"+obj.city+obj.district+"</p>";
						   html += "</div>";
		    		   }
		    	   });
		    	   $(".village").html(html);
		       }
		    },  
		    error: function(data) {  
		    }  
		})  ;
	});
	
	$(".village").on("click",".villagelist",function(){
		selectLocal($(this).attr("data-name"),$(this).attr("data-longitude"),$(this).attr("data-latitude"));
	});
	
	$("#clearCookies").on("click",function(){
		$.cookie('localhistory', '',{path:"/"}); 
		location.reload();
	});
	
	$("#refresh").on("click",function(){
		position();
	});
});

function position(){
	$("#divPsition").html("<a>定位中，请稍后</a>");
	var geolocation = new BMap.Geolocation();
	var geoc = new BMap.Geocoder();
	geolocation.getCurrentPosition(function(r){
		if(this.getStatus() == BMAP_STATUS_SUCCESS){
			geoc.getLocation(r.point, function(rs){
			var addComp = rs.addressComponents;
				//alert('您的位置：'+r.point.lng+','+r.point.lat+addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber);
				$("#divPsition").html("<a href='javascript:selectLocal(\""+addComp.street+addComp.streetNumber+"\","+r.point.lng+","+r.point.lat+");'>"+addComp.street+addComp.streetNumber+"</a>");
			});
		}
		else {
			//alert('failed'+this.getStatus());
			$("#divPsition").html("<a>定位失败，请刷新</a>");
		}        
	},{enableHighAccuracy: true});
}
function selectLocal(name,longitude,latitude){
	location.href="edit?name="+name+"&longitude="+longitude+"&latitude="+latitude+"&selectRequired="+$("#selectRequired").val();
}