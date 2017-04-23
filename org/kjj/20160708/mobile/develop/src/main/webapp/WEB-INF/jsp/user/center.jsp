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
	<div class="box box-control">
		<header class="header">
			<div class="head-content">个人中心</div>
		<%-- 	<div class="head-left"><a href="${ctx}" class="link"></a></div> --%>
		</header>
		<!-- end top -->
		<div class="content">
			<c:if test="${kjjuser.login}">
			<a class="floorfirst reverse-member" href="${ctx}/user/detail">
				<div class="floor_h70">
					<div class="floorname">
						<div class="floorname-left">
							<p><img src="${imgBase}/p14.jpg" alt=""></p>
						</div>
						<div class="floorname-right">
							<h4>${kjjuser.orgUsers.userName}</h4>
							<h5>${kjjuser.orgUsers.levelName}</h5>
						</div>
						<div class="member-center-link">
						账户管理>>
						</div>
					</div>
				</div>
			</a>
			</c:if>
			<c:if test="${!kjjuser.login}">
			<div class="go-center">
				<a href="${ctx}/loginInit">点击登录</a>
			</div>
			</c:if>
			<div class="floorbox reversefloobox">
				<div class="reverse-floor-item">
					<div class="floor">
						<a href="${ctx}/user/code" class="go">我的会员名片</a>
					</div>
				</div>
			</div>
			<!--  -->
			<div class="floordingdan">	
				<div class="floor">	
					<a href="${ctx}/order/list" class="go">我的订单<span class="rightspan1">查看全部订单</span></a>
				</div>
				<div class="floor_h60">
					<div class="iconlist">
						<a href="${ctx}/order/list?waitPaid=true">
							<span class="iconcenter f-icon1"><i class="on">${userCount.waitPaidCount}</i></span>
							<span>待付款</span>
						</a>
						<a href="${ctx}/order/list?waitSend=true">
							<span class="iconcenter f-icon2"><i>${userCount.waitSendCount}</i></span>
							<span>待收货</span>
						</a>
						<a href="${ctx}/order/list?waitTake=true">
							<span class="iconcenter f-icon3"><i class="on">${userCount.waitTakeCount}</i></span>
							<span>待自提</span>
						</a>
						<%-- 
						<a href="${ctx}/comment/list??waitComment=true">
							<span class="iconcenter f-icon4"><i>${userCount.waitCommentCount}</i></span>
							<span>待评价</span>
						</a>
						 --%>
					</div>
				</div>
			</div>
			<!--  -->
			
			<div class="floorbox reversefloobox">
				<div class="reverse-floor-item">
					<div class="floor">
						<a href="${ctx}/accountDeposit/center" class="go">预存款<span class="rightspan1">可用余额：<fmt:formatNumber type="currency" pattern="0.00" value="${amount}"/></span></a>
					</div>
					<div class="floor">
						<a href="${ctx}/coupon/list" class="go">优惠券</a>
					</div>
				</div>
				<div class="reverse-floor-item">
					<div class="floor">
						<a href="${ctx}/cart/list" class="go">购物车</a>
					</div>
					<div class="floor">
						<a href="${ctx}/comment/list" class="go">我的评价</a>
					</div>
				</div>
				<div class="reverse-floor-item">
					<div class="floor">
						<a href="${ctx}/feedback/init" class="go">问题反馈</a>
					</div>
				</div>
				<%-- <div class="reverse-floor-item">
					<div class="floor">
						<a href="${ctx}/address/list" class="go">收货地址</a>
					</div>
					<div class="floor">
						<a href="#" class="go">帮助中心</a>
					</div>
				</div> --%>
			</div>
		</div>
		<!-- end center -->
		<footer class="footer">
			<p>客户服务热线：4000-306-603</p>
			<p>KJJHOME.COM 快捷健商城</p>
		</footer>
	</div>
	<!-- end box -->
	<jsp:include page="../common/common_footerbar.jsp">
		<jsp:param name="active" value="我的"/>
		<jsp:param name="cartCount" value="${kjjcartcount}"/>
	</jsp:include>
	<!-- end fixedbar -->
<%@ include file="../common/common_js.jsp" %>
<script src="${jsBase}/common/common_footerbar.js" type="text/javascript"></script>
</body>
</html>