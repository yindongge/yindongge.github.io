<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
	HttpSession s= request.getSession();
%>
<div class="select-city">
	<strong class="strong" id="shopname">${kjjuser.orgShop.shopName}</strong>
	<span class="small area-select" id="switchshop">切换 <i class="glyphicon glyphicon glyphicon-menu-down"></i></span>
	<div class="area" id="area" style="display:none;">
		<div class="area-title">
			<input type="hidden" id="shopId" name="shopId" value="${kjjuser.orgShop.shopId}"/>
				<div class="area-first fl">
					<p id = "shopaddress">本店地址：${kjjuser.orgShop.address}</p>
					<p id="shopmobile">电话：${kjjuser.orgShop.firstPhoneAreaCode}-${kjjuser.orgShop.firstPhoneNo}</p>
				</div>
				<div class="area-second fl">
					<p>详细配送范围</p>
				</div>					
				<div class="close-mask" onclick="closeshop()"></div>
		</div>
		<div class="area-body">
			<ul id="shopselect">
			</ul>
		</div>
	</div>
</div>
<script type="text/javascript">
$(function(){
	//初始化选择店铺
	initShop();
	
	var canHide = false; //标记是否可隐藏层
	function doHide(){   //是否隐藏层中这里处理
	  if(canHide)
	  $("#area").hide();
	}
   
	$("#switchshop").hover(function(){//鼠标进入
		$("#area").show(); //显示
		canHide = false; //标记不可隐藏
	},function(){
		canHide = true; //鼠标移出可隐藏
		window.clearTimeout(s); //将上次的定时器清除,重新设置
		var s = window.setTimeout(doHide,400); //在间隔1000毫秒后执行是否隐藏处理
	});
	//主要依靠定时器来将两者关联起来
	$("#area").hover(function(){ //鼠标进入
		canHide = false;    //不可隐藏
	},function(){
		canHide = true;     //鼠标移出可隐藏
		window.clearTimeout(s2);
		var s2 = window.setTimeout(doHide,400);
	});
});
function initShop(){
	//获取所有门店信息
	$.ajax({  
	    type: "post",  
	    dataType:"json",
	    url: "${ctx}/shop/list",  
	    success: function(data) {  
	       if(data.code == 200){
	    	   var cityname = "";
	    	   var htmlStr = "";
	    	   $.each(data.listShop,function(index,item){
	    		   if(cityname == ""){
	    			   cityname = item.area[1];
	    			   htmlStr += "<li><div class=\"area-left\">";
	    			   htmlStr += cityname+"</div><div class=\"area-right\">";
	    		   }else if(item.area[1] != cityname){   
    				   cityname = item.area[1];
    				   htmlStr += "</div></li><li><div class=\"area-left\">";
    				   htmlStr += cityname+"</div><div class=\"area-right\">";
	    		   }
	    		   htmlStr += "<a href=\"javascript:setShop("+item.shopId+");\">";
	    		   htmlStr += item.shopName+"</a>";
    		   });
	    	   htmlStr+="</div></li>";
	    	   $("#shopselect").html(htmlStr);
	       }
	    },  
	    error: function(data) {  
	    }  
	})  ;
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
</script>