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
<title>购物车-快捷健商城</title>
</head>
<body >
	<div class="box box-control">
		<header class="header readyfixed-header">
			<div class="head-content">购物车</div>
			<div class="head-left"><a href="${ctx}" class="link"></a></div>
		</header>
		<!-- end top -->
		<div class="shopwrapper readyfixed">
			<div class="floor h40 same-floor">
				<c:if test="${kjjuser.orgUsers.lastSendStyle == 0}">
				<a href="${ctx}/address/list" class="blockgo">
					<span>送至：${kjjuser.orgUserAddress.sendRangeName}</span>
					<span class="pull-right">更换配送方式</span>
					<span class="icon-right"></span>
				</a>
				</c:if>
				<c:if test="${kjjuser.orgUsers.lastSendStyle == 1}">
				<a href="${ctx}/shop/list" class="blockgo">
					<span>提货点：${kjjuser.orgShop.shopName}</span>
					<span class="pull-right">更换配送方式</span>
					<span class="icon-right"></span>
				</a>
				</c:if>
			</div>
			
		</div>
		<!--end  tip -->

		<div class="shopwrapper" >
			<div class="floor h50 same-floor">
				商品信息
				<div class="head_delete" id="btnEdit">编辑</div>
			</div>
			<div id="showInfo">
				${showInfo}
			</div>
		</div>
		
		
	</div>
	<!-- end box -->
	<div class="fixed-bottom" id="bottomInfo">
		${bottomInfo}
	</div>
	<div class="mask"></div>
<%@ include file="../common/common_js.jsp" %>
<script src="${jsBase}/cart/list.js" type="text/javascript"></script>
</body>
</html>