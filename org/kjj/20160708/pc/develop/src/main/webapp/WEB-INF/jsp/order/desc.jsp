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
<div class="all">
	<%@include file="../common/common_head2.jsp" %>
	<!-- end top -->
	<div class="header">
		<div class="container container-width">
			<div class="logo fl">
				<a href="${ctx}"><img src="${imgBase}/logo.jpg"/></a>
			</div>
			<div class="search fr search-special1">
				<%@include file="../common/common_search.jsp" %>
			</div>

		</div>
	</div>
		<div class=" container container-width">
		<form action="${ctx}/cart/list" method="get">
			<div class="pay-result2 ">
				<div class="pay-result ">
					<p><strong>感谢您的购买，我们将尽快为您发货！</strong></p>
					<p>订单号：${order.orderId}   支付金额：<span class="red2"><fmt:formatNumber type="currency" pattern="￥0.00" value="${order.orderMoney}"/></span>   
						配送方式：
						<c:if test="${order.sendStyle=='0'}">
							送货上门    送达时间：<fmt:formatDate value="${order.sendDate}" type="date"/>
						</c:if>
						<c:if test="${order.sendStyle=='1'}">
							自提    取货时间：<fmt:formatDate value="${order.takeDate}" type="date"/>
						</c:if>
					</p>
					<c:if test="${ cartCount > 0 }">
						<p>
							<button type="submit" class="btn btn-warning">回购物车继续结算</button>
							<b>您的购物车中还有未结算的商品，请去结算。</b>
						</p>
					</c:if>
				</div>
				<div class="pay-result-item2">
					<p><a href="${ctx}" class="a-specialp">继续购物</a>您还可以<a href="${ctx}/order/list" class="blue">查看订单</a></p>
				</div>
			</div>

			<div class="result-tip">
				<hr/>
				<p>友情提示：</p>
				<p>收货校验码将发送至您的手机，请妥善保管，将作为收货、提货的唯一凭证。</p>
				<p>为保证每位顾客均有公平购买的机会，在您全部完成全部金额支付前网站不提供价格、库存保护，因店铺调价、促销结束、抢购等造成的价格、库存变化以付款时为准。</p>

			</div>
			</form>
	</div>
	
<!-- footer -->
<%@include file="../common/common_foot.jsp" %>
</div>
<%@include file="../common/common_js.jsp" %>
</body>
</html>