<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<%@include file="../common/common_css.jsp"%>
<title>快捷健商城</title>
</head>
<body>
<div class="all memberall">
	<%@include file="../common/common_head2.jsp" %>
	<!-- end top -->
	<div class="header header-member">
		<div class="container container-width">
			<div class="severce-head">
			<div class="logo fl">
				<a href="${ctx}"><img src="${imgBase}/icon/member-logo.png"/></a>
				<div class="text-position">
					<strong>个人中心</strong>				
				</div>		
			</div>
			<%@include file="../common/common_cart.jsp" %>
			<div class="search fr">
				<%@include file="../common/common_search.jsp" %>
			</div>
			</div>
		</div>
	</div>
	<!-- end header -->
	<div class="center-content">
		<div class="container container-width  container-border">
			<jsp:include page="../common/common_left.jsp">
				<jsp:param name="active" value="退货记录"/>
			</jsp:include>
			<!-- member-left -->
			<div class="member-right">
				<div class="mlist m-list1">
					<h5>退款详情<a href="javascript:void(0);" class="lianixkefu" id="consultBtn">联系客服</a></h5>
					<table class="table table-same ">
						<thead>
							<tr class="bluem">
								<th>退款编号</th>
								<th>订单编号</th>
								<th class="th6">商品名称</th>
								<th>退款金额</th>
								<th>退款原因</th>
							</tr>
						</thead>
					<tbody>
						<tr class="bluem2">

							<td>${refundOrder.refundOrderId}</td>
							<td>${refundOrder.orderId}</td>
							<td>
								<div class="mg-img">
									<c:forEach var="orderGoods" items="${refundOrder.listOrderGoods}">
										<a href="${ctx}/item/${orderGoods.goodsId}" target="_blank"><img src="${orderGoods.orgProductItem.goodsImg50}" title="${orderGoods.orgProductItem.goodsName}"/></a>
									</c:forEach>
								</div>
							</td>
							<td class="yellow-sm"><fmt:formatNumber type="currency" pattern="￥0.00" value="${refundOrder.refundMoney}"/></td>
							<td>
								<c:if test="${!empty refundOrder.returnOrderId and refundOrder.returnOrderId > 0}">
									${refundOrder.orgReturnOrder.reason}
								</c:if>
								<c:if test="${empty refundOrder.returnOrderId or refundOrder.returnOrderId == 0}">
									取消订单
								</c:if>
							</td>
						</tr>
						
					</tbody>
					</table>
			</div>

			<!-- 2 -->
			<div class="mlist m-tip">
				<h5>服务单信息</h5>
				<table class="table table-same ">
					<tbody>
						<tr>
							<td>退款返回方式 </td>
							<td>
								<c:if test="${refundOrder.refundStyle==0}">在线退款</c:if>
								<c:if test="${refundOrder.refundStyle==1}">本地退款</c:if>
								<c:if test="${refundOrder.refundStyle==2}">余额退款</c:if>
							</td>
						</tr>
					
						<tr>
							<td>退款原因 </td>
							<td>
								<c:if test="${!empty refundOrder.returnOrderId and refundOrder.returnOrderId > 0}">
									${refundOrder.orgReturnOrder.reason}
								</c:if>
								<c:if test="${empty refundOrder.returnOrderId or refundOrder.returnOrderId == 0}">
									取消订单
								</c:if>
							</td>
						</tr>
						<tr>
							<td>退款时间 </td>
							<td><fmt:formatDate value="${refundOrder.refundTime}" type="both"/></td>
						</tr>
						<c:if test="${!empty refundOrder.returnOrderId and refundOrder.returnOrderId > 0}">
							<tr>
								<td>收货地址 </td>
								<td>${refundOrder.orgReturnOrder.returnAddress}</td>
							</tr>
							<tr>
								<td>联系信息 </td>
								<td>${refundOrder.orgReturnOrder.returnTel}</td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</div>
			</div>

			<!-- end memberright -->
		</div>
	</div>

<!-- footer -->
<%@include file="../common/common_foot.jsp" %>
</div>
<%@include file="../common/common_js.jsp"%>
<script type="text/javascript" src="http://wpa.b.qq.com/cgi/wpa.php"></script>
<script type="text/javascript">
	//企业qq
	BizQQWPA.addCustom({
		aty : '0',
		nameAccount: '4000306603',
		selector : 'consultBtn'
	});
</script>
</body>
</html>