<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<%@include file="../common/common_css.jsp" %>
<title>快捷健商城</title>
</head>
<body>
<form id="payForm" action="${ctx}/alipay/pay" method="post" target="_blank">
	<input type="hidden" name="orderId" value="${order.orderId}"/>
</form>
<div class="all">
	<%@include file="../common/common_head2.jsp" %>
	<!-- end top -->
	<div class="header">
		<div class="container container-width">
			<div class="logo fl">
				<a href="${ctx}"><img src="${imgBase}/logo.jpg"/></a>
				<div class="text-position">
					<strong >收银台</strong>				
				</div>
			</div>
			<div class="search fr search-special1">
				<%@include file="../common/common_search.jsp" %>
			</div>

		</div>
	</div>
		<div class="payment">
			<input type="hidden" id="orderId" value="${order.orderId}"/>
			<h4>订单提交成功，请您尽快付款！ 订单号：${order.orderId}<span class="pull-right">应付金额：<strong class="yellow"><fmt:formatNumber type="currency" pattern="0.00" value="${order.payMoney}"/>元</strong></span>
			</h4>
			<h5>请您在提交订单后<c:if test="${order.limitPayTime==null}">24小时</c:if><c:if test="${order.limitPayTime!=null}">${order.limitPayTime}分钟</c:if>内完成支付，否则订单会自动取消。
				<a id="orderDesc" class="paymenbt-detial pull-right">订单详情 <b class="glyphicon glyphicon-menu-down"></b></a>
			</h5>
			<div class="detail-list" style="display:none;">
				<c:if test="${order.sendStyle==0}">
					<p>收货地址：${kjjuser.orgShop.orgArea.show}${order.consigneeAddress} 收货人：${order.consignee} 
						<c:if test="${order.consigneeMobile!=''}">${order.consigneeMobile}</c:if>
						<c:if test="${order.consigneeMobile==''}">${order.consigneeTel}</c:if>
					</p>
				</c:if>
				<c:if test="${order.sendStyle==1}">
					<p>取货地址：${kjjuser.orgShop.orgArea.show}${kjjuser.orgShop.address} 取货人手机号：
						<c:if test="${order.consigneeMobile!=''}">${order.consigneeMobile}</c:if>
					</p>
				</c:if>
				<c:forEach var="item" items="${order.listOrderGoods}" varStatus="status">
					<c:if test="${status.first}"><p>商品名称：${item.orgProductItem.goodsName}×${item.amount}；</p></c:if>
					<c:if test="${!status.first}"><p class="p-indent">${item.orgProductItem.goodsName}×${item.amount}；</p></c:if>
				</c:forEach>
			</div>
			<div class="samefloor">
			<div class="pull-erweima"><img src='${ctx}/wxpay/code/${order.orderId}'/></div>
				<a href="${ctx}/pay/payInit?orderId=${order.orderId}" class="pull-a1"><span class="leftimg2"></span>选择其他支付方式</a>
			</div>
		</div>
		
<!-- footer -->
<%@include file="../common/common_foot.jsp" %>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/pay/wxpay.js" type="text/javascript"></script>

</body>
</html>