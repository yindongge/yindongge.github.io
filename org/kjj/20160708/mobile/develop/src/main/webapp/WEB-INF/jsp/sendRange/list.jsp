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
<style>
	.tangram-suggestion-main{
		z-index:99999;
	}
</style>
</head>
<body>
	<form id="sendRangeform" action="${ctx}/address/addOrEditReinit" method="post">
		<input type="hidden" name="addressId" value="${userAddress.addressId}">
		<input type="hidden" name="consignee" value="${userAddress.consignee}">
		<input type="hidden" name="mobile" value="${userAddress.mobile}">
		<input type="hidden" name="address" value="${userAddress.address}">
		<input type="hidden" name="sendRangeId" value="${userAddress.sendRangeId}">
		<input type="hidden" name="sendRangeName" value="${userAddress.sendRangeName}">
	</form>
	<div class="box ">
		<input type="hidden" id="imgBase" value="${imgBase}">
		<input type="hidden" id="longitude" value="${kjjlocation.longitude}">
		<input type="hidden" id="latitude" value="${kjjlocation.latitude}">
		<header class="header ">
			<div class="head-content classify">
				<input type="text" class="searcharea" id="suggestId" size="20" placeholder="请输入大厦/小区">
				<span class="smallicon"></span>
			</div>
			<div class="head-left"><a href="javascript:$('#sendRangeform').submit();" class="link"></a></div>
		</header>
		<!-- end top -->
		<div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>
		<div style="height:260px;position:relative; color:#fff;" id="allmap">
		</div>
		<div class="village padding">
		</div>
		<!-- loading -->
		<div class="loading">
			<div class="loading-block map-block" id="loadingPosition" style="display: none;">
				<div class="loadcircle">
					<span class="bounce-text">定位中</span>
					<span class="bounce bounce1"></span>
					<span class="bounce bounce2"></span>
					<span class="bounce bounce3"></span>
				</div>
			</div>
		</div>
		<!-- loading -->
		<div class="loadcircle gray" id="loadMore" style="opacity:0;" data-page-next="0">
			<span class="bounce-text">正在加载</span>
			<span class="bounce bounce1"></span>
			<span class="bounce bounce2"></span>
			<span class="bounce bounce3"></span>
		</div>
	</div>
	<!-- end box -->
<%@ include file="../common/common_js.jsp" %>
<script src="http://api.map.baidu.com/api?v=2.0&ak=D1DhyuyKwUtxW0r52g0gzxtFFviKv0tk" type="text/javascript"></script>
<script src="${jsBase}/sendRange/list.js" type="text/javascript"></script>
</body>
</html>