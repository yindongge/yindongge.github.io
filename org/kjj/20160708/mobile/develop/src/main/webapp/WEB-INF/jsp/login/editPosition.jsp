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
	<input type="hidden" id="selectRequired" value="${selectRequired}">
	<div class="box box-gray">
		<header class="header ">
			<c:if test="${!selectRequired}">
				<div class="head-content classify">
					<input type="text" class="searcharea" placeholder="输入收货地址，匹配最近门店" id="suggestId" size="20">
					<span class="smallicon"></span>
				</div>
				<div class="head-left"><a href="${ctx}" class="link"></a></div>
			</c:if>
			<c:if test="${selectRequired}">
				<div class="head-content classify newsearch">
					<input type="text" class="searcharea" placeholder="输入收货地址，匹配最近门店 " id="suggestId" size="20">
					<span class="smallicon"></span>
				</div>
			</c:if>
		</header>
		<!-- end top -->
		<div class="village">
		</div>
		<div class="search-wrapper">
			<div class="search-list">
				<p class="search-title">定位地址<span class="clear" id="refresh">重新定位</span></p>
				<div class="search-item" id="divPsition">
				</div>
			</div>
		</div>
		<c:if test="${!empty listLocal}">
		<div class="search-wrapper">
			<div class="search-list">
				<p class="search-title">当前位置</p>
				<div class="search-item">
					<a href="javascript:selectLocal('${listLocal[0].name}',${listLocal[0].longitude},${listLocal[0].latitude});">${listLocal[0].name}</a>
				</div>
			</div>
		</div>
		<div class="search-wrapper">
			<div class="search-list">
				<p class="search-title">常用位置<span class="clear" id="clearCookies">清除</span></p>
				<c:forEach var="local" items="${listLocal}">
				<div class="search-item">
					<a href="javascript:selectLocal('${local.name}',${local.longitude},${local.latitude});">${local.name}</a>
				</div>
				</c:forEach>
			</div>
		</div>
		</c:if>
		<c:if test="${empty listLocal}">
		<div class="search-wrapper">
			<div class="nolist white">输入收货地址，匹配最近门店 </div>
		</div>
		</c:if>
	</div>
<!-- end box -->
<%@ include file="../common/common_js.jsp" %>
<script src="${jsBase}/common/jquery.cookie.js" type="text/javascript" ></script>
<script src="http://api.map.baidu.com/api?v=2.0&ak=D1DhyuyKwUtxW0r52g0gzxtFFviKv0tk" type="text/javascript"></script>
<script src="${jsBase}/login/editPosition.js" type="text/javascript"></script>
</body>
</html>