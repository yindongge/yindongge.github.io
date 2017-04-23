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
			<div class="head-content">
			<div class="switch_method">
				<a href="${ctx}/shop/list" class="on">自提门店</a>
				<a href="javascript:void(0);">收货地址</a>
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
		<div class="ziti-wrapper">
			<div class="floor" id="divPositionEdit">
				<p class="blue ziti-title">当前位置：
				<c:if test="${empty kjjlocation.name}">定位失败</c:if>
				<c:if test="${!empty kjjlocation.name}">${kjjlocation.name}</c:if>
				<span class="redchange">手动更换</span>
				<span class="icon-right"></span></p>
			</div>
		</div>
		<div class="address border-top">
			<c:forEach items="${listAddressVaild}" var="item" varStatus="status">
			<div class="pay_list h90 padding <c:if test="${kjjuser.orgUsers.lastSendStyle == 0 and kjjuser.orgUserAddress.addressId == item.addressId}">on</c:if>">
				<div class="new-built padding-control" data-address-id="${item.addressId}">
					<p class="builtitem selectAddress"><span class="builtname">${item.addressName}</span><span class="builtphone">${item.mobile}</span></p>
					<p class="built-address selectAddress"><span></span>${item.area[1]}${item.area[2]}${item.sendRangeName}${item.address}</p>
					<span class="pencil" data-address-id="${item.addressId}"></span>
				</div>
			</div>
			</c:forEach>
			<c:forEach items="${listAddressInvaild}" var="item" varStatus="status">
			<div class="h114">
				<div class="pay_list padding no">
					<div class="new-built padding-control">
						<p class="builtitem"><span class="builtname">${item.addressName}</span><span class="builtphone">${item.mobile}</span></p>
						<p class="built-address"><span></span>${item.area[1]}${item.area[2]}${item.sendRangeName}${item.address}</p>
						<span class="pencil" data-address-id="${item.addressId}"></span>
					</div>
					<div class="nouse-icon"></div>
				</div>
				<%-- <span class="blue">${item.sendRangeName}</span> --%>
				<div class="tipred">对不起，我们已取消对该地区的配送，请重新编辑收货地址</div>
			</div>
			</c:forEach>
			<div class="pay_list h50" id="divAdd">
				<span class="paper_news">新增收货地址</span>
				<span class="addcircle pull-right"></span>
			</div>
		</div>
	</div>
	<!-- end box -->
<%@ include file="../common/common_js.jsp" %>
<script src="${jsBase}/address/list.js" type="text/javascript"></script>
</body>
</html>