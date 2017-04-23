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
	<div class="box">
		<header class="header">
			<div class="head-content">优惠券</div>
			<div class="head-left"><a href="${ctx}/order/addReInit" class="link"></a></div>
		</header>
		<!-- end top -->
		<div class="youhui">
			<div class="youhui-tip">
				<h5>温馨提示</h5>
				<p>1、全平台优惠券可多张同时使用，限平台优惠券每次只能用一张；优惠券每笔订单只能使用一张。</p>
				<p>2、请注意时效。</p>
			</div>
			<c:forEach var="item" items="${kjjorderform.listCouponRecord}" varStatus="status">
			<div class="youhuilist" data-coupon-record-id="${item.recordId}">
				<div class="youhui_top ">
					<div class="youhuicontent">
						<p>满<fmt:formatNumber type="currency" pattern="0.00" value="${item.orgCoupon.conditionMoney}"/>元可用</p>
						<p>适用范围：
							<c:if test="${item.orgCoupon.shopType==1}">全部门店</c:if>
							<c:if test="${item.orgCoupon.shopType==2}">指定区域</c:if>
							<c:if test="${item.orgCoupon.shopType==3}">指定门店</c:if>
						</p>
					</div>
					<div class="price-youhui">
						<span>￥</span>
						<span><fmt:formatNumber type="currency" pattern="0.00" value="${item.orgCoupon.discountMoney}"/></span>
					</div>
				</div>
				<div class="youhui_bottom">
					<span class="pull-right">有效期：<fmt:formatDate value="${item.startTime}" type="date" pattern="yyyy-MM-dd"/>至<fmt:formatDate value="${item.endTime}" type="date" pattern="yyyy-MM-dd"/></span>
				</div>
			</div>
			</c:forEach>
		</div>
	</div>
<%@ include file="../common/common_js.jsp" %>
<script src="${jsBase}/coupon/select.js" type="text/javascript"></script>
</body>
</html>