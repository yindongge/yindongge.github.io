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
	<div class="box box-gray">
		<header class="header">
			<div class="head-content">${shop.shopName}</div>
			<div class="head-left"><a href="${ctx}/shop/list" class="link"></a></div>
		</header>
		<!-- end top -->
		<div class="shop_detail">
			<div class="item center padding">
				<p class="item-time">营业时间：
				<c:if test="${shop.openDay==0}">周一至周日(节假日除外)</c:if>
				<c:if test="${shop.openDay==1}">周一至周五(节假日除外)</c:if>
				</p>
				<p class="item-time"><fmt:formatDate value="${shop.openTimeStart}" type="time" pattern="HH:mm"/>-
				<fmt:formatDate value="${shop.openTimeEnd}" type="time" pattern="HH:mm"/></p>
			</div>
			<div class="item no-border">
				<div class="item-floor padding-left">
					<div class="item-floor-son">
						<span class="l-f-icon gray-load"></span>
						提货地址
					</div>
					<div class="item-floor-son">
						${shop.address}
					</div>
				</div>
				<div class="item-floor padding-left">
					<div class="item-floor-son">
						<span class="l-f-icon road"></span>
						您与店面的距离
					</div>
					<div class="item-floor-son">
						<span class="blue">${distance}KM</span>
					</div>
					<div class="item-floor-son">
						<span class="l-f-icon tel"></span>
						<strong>4000-306-603</strong>
					</div>
				</div>
			</div>
		</div>
		<div class="buttonsure paper">
			<a class="surea" href="${ctx}/shop/selectTake/${shop.shopId}">进入店铺</a>
		</div>
	</div>
	<div class="cover"></div>
	<!-- end box -->
<%@ include file="../common/common_js.jsp" %>
<script src="${jsBase}/shop/list.js" type="text/javascript"></script>
</body>
</html>