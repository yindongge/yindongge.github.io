<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/common_java.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<meta name="apple-touch-fullscreen" content="yes" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />
<%@ include file="../common/common_css.jsp"%>
<title>快捷健商城</title>
</head>
<body>
	<div class="box box-gray">
		<header class="header">
			<div class="head-content">网上支付</div>
			<div class="head-left"><a href="${ctx}/order/list" class="link"></a></div>
		</header>
		<!-- end top -->
		<input type="hidden" id="orderId" value="${order.orderId}">
		<div class="sure-pay-wrapper">
			<div class="sure-pay-title">
				<p>需付款</p>
				<p><i class="rmb">￥</i><fmt:formatNumber type="currency" pattern="0.00" value="${order.payMoney}"/></p>
			</div>
			<div class="new-reverse  reverse-paymethod ">
				<c:if test="${!empty kjjopenid}">
				<div class="pay_list no-margin">
					<div class="h50 givepadding">
						<span class="paper_news"><i class="icon-sure"><img src="${imgBase}/weixin-icon.png" alt=""></i>微信支付</span>
						<span class="pull-right"></span>
					</div>
					<div id="wepay" class="checkselect on"></div>
				</div>
				</c:if>
				<c:if test="${empty kjjopenid}">
				<div class="pay_list no-margin">
					<div class="h50 givepadding">
						<span class="paper_news"><i class="icon-sure"><img src="${imgBase}/zhifubao.jpg"" alt=""></i>支付宝</span>
						<span class="pull-right"></span>
					</div>
					<div id="alipay" class="checkselect on"></div>
				</div>
				</c:if>
			</div>
		</div>
		<div class="acount-button">
			<a id="btnPay" href="javascript:void(0);">完成</a>
		</div>
	</div>
	<!-- end box -->
<%@ include file="../common/common_js.jsp"%>
<script src="${jsBase}/pay/online.js" type="text/javascript"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
</body>
</html>