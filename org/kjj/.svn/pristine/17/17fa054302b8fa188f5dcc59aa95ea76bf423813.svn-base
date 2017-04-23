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
					<h5>退货详情<a href="javascript:void(0);" class="lianixkefu" id="consultBtn">联系客服</a></h5>
					<table class="table table-same ">
						<thead>
							<tr class="bluem">
								<th >退货编号</th>
								<th>订单编号</th>
								<th class="th6">商品名称</th>
							</tr>
						</thead>
					<tbody>
						<tr class="bluem2">

							<td>${returnOrder.returnOrderId}</td>
							<td>${returnOrder.orderId}</td>
							<td>
								<div class="mlist-img"><a href="${ctx}/item/${orderGoods.goodsId}" target="_blank"><img src="${orderGoods.orgProductItem.goodsImg50}" title="${orderGoods.orgProductItem.goodsName}"/></a></div>
								<div class="mlist-text"></div>
							</td>
						</tr>
						
					</tbody>
					</table>
			</div>

			<!--1  -->
			<div class="content3">
			<div class="m-table-list m-list3" style="margin-bottom:20px;">
				<h4>订单跟踪</h4>
				<table class="table table-same ">
					<thead>
						<tr>
							<th class="th1">处理时间</th>
							<th class="th2">处理信息</th>
							<th class="th3">操作人</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="log" items="${listReturnOrderLog}" varStatus="status">
							<tr>
								<td><fmt:formatDate value="${log.logTime}" type="both"/></td>
								<td>${log.typeShow}</td>
								<td>
									<c:if test="${log.logSource == 0}">用户</c:if>
									<c:if test="${log.logSource == 1}">系统</c:if>
									<c:if test="${log.logSource == 2}">管理员</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="tipme">重要提醒：快捷健平台不会以 <span class="red">订单异常、系统升级</span>为由，要求您点击任何网址链接进行退款操作。</div>
		</div>
			<!-- 2 -->
			<div class="mlist m-tip">
				<h5>申请服务详情</h5>
				<table class="table table-same ">
					<tbody>
						<tr>
							<td>商品返回方式 </td>
							<td>客户期望返件方式为“
								<c:if test="${returnOrder.takeStyle==0}">上门退换</c:if>
								<c:if test="${returnOrder.takeStyle==1}">到店退换</c:if>
								”
							</td>
						</tr>
						<tr>
							<td>商品处理方式 </td>
							<td>客户期望处理方式为“
								<c:if test="${returnOrder.returnStyle==0}">退货</c:if>
								<c:if test="${returnOrder.returnStyle==1}">换货</c:if>
								”
							</td>
						</tr>
						<tr>
							<td>问题描述 </td>
							<td>${returnOrder.reason}</td>
						</tr>
						<c:if test="${order.sendStyle==0}">
							<tr>
								<td>收货地址 </td>
								<td>${returnOrder.returnAddress}</td>
							</tr>
						</c:if>
						<tr>
							<td>联系信息 </td>
							<td>${returnOrder.returnContact} ${returnOrder.returnTel}</td>
						</tr>
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
<script type="text/javascript" src="${jsBase}/return/add.js"></script>
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