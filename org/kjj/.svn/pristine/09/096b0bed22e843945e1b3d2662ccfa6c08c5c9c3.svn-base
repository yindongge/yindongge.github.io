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
			<div class="head-content">填写收货地址</div>
			<div class="head-left"><a href="${ctx}/address/list" class="link"></a></div>
		</header>
		<!-- end top -->
		<form id="addressform" method="post">
		<input type="hidden" name="addressId" value="${userAddress.addressId}">
		<input type="hidden" id="sendRangeId" name="sendRangeId" value="${userAddress.sendRangeId}">
		<div class="address write">
			<dl class="item-detail">
				<dt>联系人</dt>
				<dd><input type="text" class="form-control" placeholder="您的姓名" id="consignee" name="consignee" value="${userAddress.consignee}"></dd>
			</dl>
			<dl class="item-detail">
				<dt>手机</dt>
				<dd><input type="text" class="form-control" placeholder="配送员联系您的方式" id="mobile" name="mobile" value="${userAddress.mobile}"></dd>
			</dl>
			<dl class="item-detail">
				<dt>收货地址</dt>
				<dd>
					<a class="form-control " id="toSendRange">
						<span class="smallicon"></span>
						<span class="building">
						<c:if test="${!empty userAddress.sendRangeName}">${userAddress.sendRangeName}</c:if>
						<c:if test="${empty userAddress.sendRangeName}">请选择大厦、小区</c:if>
						</span>
						<span class="icon-right"></span>
					</a>
				</dd>
			</dl>
			<dl class="item-detail">
				<dt>门牌号</dt>
				<dd><input type="text" class="form-control" placeholder="请输入门牌号等详细信息" id="address" name="address" value="${userAddress.address}"></dd>
			</dl>
		</div>
		<div class="mask"></div>
		</form>
		<!-- address -->
		<div class="btn-wrapper">
			<a href="javascript:void(0);" class="btn" id="btnSave">保存</a>
		</div>
	</div>
	<!-- end box -->
<%@ include file="../common/common_js.jsp" %>
<script src="${jsBase}/address/addOrEdit.js" type="text/javascript"></script>
</body>
</html>