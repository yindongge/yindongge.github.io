<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/common_java.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<meta name="apple-touch-fullscreen" content="yes" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />
<%@ include file="../common/common_css.jsp" %>
<title>快捷健商城</title>
</head>
<body>
	<div class="box box-height-fixed">
		<header class="header">
			<div class="head-content">
			<div class="switch_method">
				<a href="javascript:void(0);">自提门店</a>
				<a href="${ctx}/address/list" class="on">收货地址</a>
			</div>
			</div>
			<div class="head-left">
				<c:if test="${kjjbackurl ne '/address/list'}">
					<a href="${ctx}${kjjbackurl}" class="link"></a>
				</c:if>
				<c:if test="${kjjbackurl eq '/address/list'}">
					<a href="${ctx}" class="link"></a>
				</c:if>
			</div>
		</header>
		<!-- end top -->
		<div class="ziti-wrapper fullheight">
			<div class="floor" id="divPositionEdit">
				<p class="blue ziti-title">当前位置：
				<c:if test="${empty kjjlocation.name}">定位失败</c:if>
				<c:if test="${!empty kjjlocation.name}">${kjjlocation.name}</c:if>
				<span class="redchange">手动更换</span>
				<span class="icon-right"></span></p>
			</div>
		</div>
		<div class="switch">
			<div class="floor floor-fix">
				<a href="${ctx}/shop/selectTake/${nearbyShop.shopId}" style="color:#333"><p class=" ziti-title">最近门店：${nearbyShop.shopName}<span class="space10">&nbsp;<fmt:formatNumber type="currency" pattern="0.00" value="${nearbyShop.distance/1000}"/>km</span><span class="redchange">进入</span><span class="icon-right"></span></p></a>
			</div>
			<div class="switch-left">
				<ul id="ulCounty">
					<c:forEach items="${mapCounty}" var="county" varStatus="status">
					<li <c:if test="${kjjuser.orgUsers.lastSendStyle == 1 and kjjuser.orgShop.area[2] == county.key}">class="on"</c:if>>${county.key}</li>
					</c:forEach>
				</ul>
			</div>
			<div class="switch-right">
				<c:forEach items="${mapCounty}" var="county" varStatus="status">
				<div class="switch-address" id="div${county.key}" <c:if test="${kjjuser.orgUsers.lastSendStyle != 1 or kjjuser.orgShop.area[2] != county.key}">style="display:none;"</c:if>>
					<c:forEach items="${county.value}" var="shop" varStatus="statusShop">
					<div class="reverse-switch">
						<a href="${ctx}/shop/selectTake/${shop.shopId}">
							<div class="paddiingadd">
								<c:if test="${kjjuser.orgUsers.lastSendStyle == 1 and kjjuser.orgShop.shopId == shop.shopId}">
								<p class="on">${shop.shopName}(当前)</p>
								</c:if>
								<c:if test="${kjjuser.orgUsers.lastSendStyle != 1 or kjjuser.orgShop.shopId != shop.shopId}">
								<p>${shop.shopName}</p>
								</c:if>
								<p><fmt:formatNumber type="currency" pattern="0.00" value="${shop.distance/1000}"/>km</p>
							</div>
						</a>
						<span class="tanhao" data-shop-id="${shop.shopId}" data-shop-distance="<fmt:formatNumber type="currency" pattern="0.00" value="${shop.distance/1000}"/>"></span>
					</div>
					</c:forEach>
				</div>
				</c:forEach>
			</div>
			<span class="linemask"></span>
		</div>
	</div>
	<!-- end box -->
<%@ include file="../common/common_js.jsp" %>
<script src="${jsBase}/shop/list.js" type="text/javascript"></script>
</body>
</html>