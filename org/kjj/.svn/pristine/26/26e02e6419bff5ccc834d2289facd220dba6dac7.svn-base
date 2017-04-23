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
		<div class="head-content">我的优惠券</div>
		<div class="head-left"><a href="${ctx}/user/center" class="link"></a></div>
	</header>
	<!-- end top -->
	
	<form id="form" name="form" action="${ctx}/coupon/list" method="post">
		<nav class="nav">			
				<a class=" <c:if test="${query.statusCanUse}"> on no-borderder active </c:if>" href="${ctx}/coupon/list?statusCanUse=true">可用(${countCanUse})</a>
				<span></span>
			</a>
			<a class=" <c:if test="${query.statusCanUse=='false'}"> on no-borderder active </c:if>" href="${ctx}/coupon/list?statusCanUse=false">不可用(${countCanNotUse})</a>
				<span></span>
			</a>
		</nav>
		<!-- end nav -->
		
		<c:forEach var="item" items="${list}" varStatus="status">
		<div class="youhui ">
				<div class="youhuilist" data-coupon-id="${item.couponId}">
					<div class="youhui_top <c:if test="${!query.statusCanUse}">gray</c:if>">
						<div class="youhuicontent">
							<p> 满<fmt:formatNumber type="currency" pattern="￥0.00" value="${item.orgCoupon.conditionMoney}"/>可用</p>
							<p>适用范围：
								<c:if test="${item.orgCoupon.shopType==1}">全部门店</c:if>
								<c:if test="${item.orgCoupon.shopType==2}">北京区域门店</c:if>
								<c:if test="${item.orgCoupon.shopType==3}"><c:forEach var="shopName" items="${item.orgCoupon.shopNames}">${shopName},</c:forEach></c:if>
							</p>
						</div>
						<div class="price-youhui">
							<span class="rmb">￥</span>
							<span><fmt:formatNumber type="currency" pattern="0.00" value="${item.orgCoupon.discountMoney}"/></span>
							
						</div>
					</div>
					<div class="youhui_bottom">
						<span class="pull-right"><p>有效时间：<fmt:formatDate value="${item.startTime}" type="date" pattern="yyyy-MM-dd"/>~<fmt:formatDate value="${item.endTime}" type="date" pattern="yyyy-MM-dd"/></p></span>
					</div>
				</div>
		</div>
		</c:forEach>
		
	</form>
</div>
<%@ include file="../common/common_js.jsp" %>
<script src="${jsBase}/coupon/coupon.js" type="text/javascript"></script>
</body>
</html>