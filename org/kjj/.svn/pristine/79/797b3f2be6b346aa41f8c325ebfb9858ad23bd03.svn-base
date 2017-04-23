<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/common_java.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<meta name="apple-touch-fullscreen" content="yes" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />
<meta name="keywords" content="网上购物,网上商城,零食,食品,酒水饮料,粮油调味,个护化妆,办公日用,快捷健商城"/>
<meta name="description" content="快捷健商城m.kjjhome.com-销售国内外各大品牌食品、零食、酒水饮料、粮油调味、个人化妆、办公日用.快乐、便捷、健康，让快捷健商城的生活更健康!"/>
<%@ include file="../common/common_css.jsp"%>
<title>快捷健商城 – 1小时送达,0元配送,随时取货!</title>
<%
	request.setCharacterEncoding("UTF-8");
	String htmlData = request.getAttribute("customize") != null ? (String)request.getAttribute("customize") : "";//放在请求域避免了jstl取值特殊字符报错，如&
	String data = htmlDecode(htmlData);
	String nullHtml = "";
	String scriptHtml = "";
	String html = "";
	 if(data.contains("<script")){
		 scriptHtml = data;
	}else if(data != ""){
		 html = data;
	}
%>
<script type="text/javascript">
function setCookie(c_name,value,expiredays){
	var exdate=new Date();
	exdate.setDate(exdate.getDate()+expiredays);
	document.cookie= c_name+ "=" +escape(value)+((expiredays==null) ? "" : ";expires="+exdate.toGMTString());
}
</script>
</head>
<body>
<div class="box box-control box-gray padding-top">
		<header class="header fixed">
			<div class="indexhead">
				<c:if test="${kjjuser.orgUsers.lastSendStyle == 0}">
				<div class="indexhead_content " id="divSend">
					<span class="po"></span>
					<span>
					<c:if test="${empty kjjlocation.name}">定位失败</c:if>
					<c:if test="${!empty kjjlocation.name}">${kjjlocation.name}</c:if>
					</span>
					<span class="down"></span>
				</div>
				</c:if>
				<c:if test="${kjjuser.orgUsers.lastSendStyle == 1}">
				<div class="indexhead_content " id="divTake">
					<span class="po"></span>
					<span>
					<c:if test="${empty kjjlocation.name}">定位失败</c:if>
					<c:if test="${!empty kjjlocation.name}">${kjjlocation.name}</c:if>
					</span>
					<span class="down"></span>
				</div>
				</c:if>
				
				<a class="searchicon" href="${ctx}/search/search"></a>
			</div>
		</header>
		<!-- end header -->
		<div class="swiper-container swipecontrol">
		    <div class="swiper-wrapper">
		    <c:forEach items="${bannerList}" var="item">
		    	<div class="swiper-slide"><c:if test="${empty item.bannerUrl}"><a href="javascript:void(0);" target="_blank"></c:if><c:if test="${!empty item.bannerUrl}"><a href="${item.bannerUrl}" target="_blank"></c:if><img src="${item.bannerImg}"></a></div>
		    </c:forEach>
		    <c:if test="${empty bannerList}">
		    	<div class="swiper-slide"><a href="javascript:void(0);" ><img src="${imgBase}/p17.jpg"></a></div>
		    </c:if>
		    </div>
		    <!-- 如果需要分页器 -->
		    <div class="swiper-pagination"></div>
		</div>
		<!-- end 滑动 -->
		<div class="navcontrol">
			<div class="navall">
				<a href="${ctx}/fastBuy/list?curParentCatId=38&curCatId=82" >
					<div class="indexnav flex1 "></div>
					<div class="indexnavtext">午餐</div>
				</a>
				<a href="${ctx}/order/list" >
					<div class="indexnav flex2"></div>
					<div class="indexnavtext">全部订单</div>
				</a>
				<a href="${ctx}/coupon/list"  >
					<div class="indexnav flex3"></div>
					<div class="indexnavtext">优惠券</div>
				</a>
				<a href="${ctx}/user/center" >
					<div class="indexnav flex4"></div>
					<div class="indexnavtext">会员中心</div>
				</a>
			</div>
		</div>
		<!--end nav  -->
		<div class="redact"><%=html %></div>
		<div class="viewport">
			<div class="bignav">
				<div class="bignav_left">
					<%-- <a href="${ctx}/search/result?superClassId=31"><img src="${imgBase}/b1.jpg" alt=""></a> --%>
					<a href="${ctx}/fastBuy/list?curParentCatId=31&curCatId=31"><img src="${imgBase}/b1.jpg" alt=""></a>
				</div>
				<div class="bignav_right">
					<a href="${ctx}/fastBuy/list?curParentCatId=17&curCatId=17"><img src="${imgBase}/b2.jpg" alt=""></a>
					<a href="${ctx}/fastBuy/list?curParentCatId=38&curCatId=38"><img src="${imgBase}/b3.jpg" alt=""></a>
				</div>
			</div>
			<div class="bignav b_special">
				<div class="bignav_right">
					<a href="${ctx}/fastBuy/list?curParentCatId=56&curCatId=56"><img src="${imgBase}/b4.jpg" alt=""></a>
					<a href="${ctx}/fastBuy/list?curParentCatId=30&curCatId=30"><img src="${imgBase}/b5.jpg" alt=""></a>
				</div>
				<div class="bignav_left">
					<a href="${ctx}/fastBuy/list?curParentCatId=52&curCatId=52"><img src="${imgBase}/b6.jpg" alt=""></a>
				</div>
			</div>
		</div>
		<c:forEach items="${moduleList}" var="item" varStatus="status">
		<div class="procuct_control" style="display:none;" data-module-id="${item.id}" data-loading=<c:if test="${status.index == 0}">"1"</c:if><c:if test="${status.index != 0}">"0"</c:if>>
			<div class="produce_title"><img src="${item.moduleImg}"></div>
			<div class="product_wrap">		
			</div>
		</div>
		</c:forEach>
		<!-- end product -->
		<div class="loadcircle gray" id="loadMore" style="opacity:0;" data-page-next="0">
			<span class="bounce-text">正在加载</span>
			<span class="bounce bounce1"></span>
			<span class="bounce bounce2"></span>
			<span class="bounce bounce3"></span>
		</div>
	</div>
	<!-- end box -->
	<jsp:include page="../common/common_footerbar.jsp">
		<jsp:param name="active" value="首页"/>
		<jsp:param name="cartCount" value="${kjjcartcount}"/>
	</jsp:include>
	<!-- end fixedbar -->
	<div class="gotop" onclick="move()"></div>
	<%-- <c:if test="${leadme ne 'no'}">
		<div class="leadme" onclick="javascript:setCookie('leadme','no',30);this.parentNode.removeChild(this);"><img src="${imgBase}/addmask.png"></div>
	</c:if> --%>
<%@ include file="../common/common_js.jsp"%>
<%=scriptHtml %>
<script type="text/javascript" src="${jsBase}/home/index.js"></script>
<script src="${jsBase}/common/common_footerbar.js" type="text/javascript"></script>
<script src="${jsBase}/common/addcart.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		if($(".redact").text() == ""){
			$(".redact").attr("style","display:none");
		}
	});
</script>
</body>
<%!
private  String htmlDecode(String str)        
{            
	str = str.replaceAll("&rdquo;", "”");            
	str = str.replaceAll("&ldquo;", "“");            
	str = str.replaceAll("<br/>", "\n");  
	str = str.replaceAll("<br />", "\n");
	str = str.replaceAll("&gt;", ">");            
	str = str.replaceAll("&lt;", "<");            
	str = str.replaceAll("&quot;", "\"");            
	str = str.replaceAll("''", "'"); 
	str = str.replaceAll("&nbsp;", " "); 
	return str;        
}
%>
</html>