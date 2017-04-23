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
<div class="all memberall">
	<%@include file="../common/common_head2.jsp" %>
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
		<div class="container container-width">
			<jsp:include page="../common/common_left.jsp">
				<jsp:param name="active" value="我的订单"/>
			</jsp:include>
			<!-- member-left -->
			<div class="member-right">
				<div class=" mlist m-list1">
					<h5>订单详情</h5>
					<div class="m-bg">
						<div class="m-lead">
							当前状态:
							<span>
								<c:if test="${order.status==0}">待付款</c:if>
								<c:if test="${order.status==1}">待确认</c:if>
								<c:if test="${order.status==2}">
									<c:if test="${order.sendStyle==0}">待发货</c:if>
									<c:if test="${order.sendStyle==1}">备货中</c:if>
								</c:if>
								<c:if test="${order.status==3}">
									<c:if test="${order.sendStyle==0}">待收货</c:if>
									<c:if test="${order.sendStyle==1}">待自提</c:if>
								</c:if>
								<c:if test="${order.status==4}">已完成</c:if>
								<c:if test="${order.status==5}">已取消</c:if>
								<c:if test="${order.status==6}">已关闭</c:if>
							</span>
						</div>
					</div>
				</div>
				<c:if test="${order.status<=4}">
				<div class=" mlist m-list2 ">
					<div class="point1 addcolor">
						<div class="point-hide">
							<span>提交订单</span>
							<span class="font-small"><fmt:formatDate value="${order.createTime}" type="date"/><br/><fmt:formatDate value="${order.createTime}" type="time"/></span>
						</div>
					</div>
					<c:forEach var="chain" items="${mapChain}" varStatus="status">
						<c:if test="${chain.value != null}">
							<div class="line addline"></div>
							<div class="point1 addcolor">
								<div class="point-hide">
									<span>${chain.key.name}</span>
									<span class="font-small"><fmt:formatDate value="${chain.value}" type="date"/><br/><fmt:formatDate value="${chain.value}" type="time"/></span>
								</div>
							</div>
						</c:if>
						<c:if test="${chain.value == null}">
							<div class="line"></div>
							<div class="point1">
								<div class="point-hide">
									<span>${chain.key.name}</span>
									<span class="font-small"><br/></span>
								</div>
							</div>
						</c:if>
					</c:forEach>
				</div>
				</c:if>
			<div class="m-table-list m-list3">
				<h4>订单跟踪</h4>
				<table class="table table-same">
					<thead>
						<tr>
							<th class="th1">处理时间</th>
							<th class="th2">处理信息</th>
							<th class="th3">操作人</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="log" items="${listLog}" varStatus="status">
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
			<div class="m-table-list m-list3">
				<h4>订单信息<a class="pull-right" href="${ctx}/order/list">返回订单列表</a></h4>
				<table class="table table-same">
					<tbody>
						<tr>
							<td><strong>订单编号：</strong>${order.orderId}</td>
							<td> <strong>下单时间：</strong><fmt:formatDate value="${order.createTime}" type="both"/></td>
						</tr>
						<tr>
							<td><strong>付款方式： </strong>
								<c:if test="${order.payStyle==0}">在线支付</c:if>
								<c:if test="${order.payStyle==1}">货到付款</c:if>
							</td>
							<td><strong>付款时间：</strong><fmt:formatDate value="${order.payTime}" type="both"/></td>
						</tr>
						<tr>
							<td><strong>送货方式：</strong>
								<c:if test="${order.sendStyle==0}">送货上门</c:if>
								<c:if test="${order.sendStyle==1}">到店自取 </c:if>
							</td>
							<td> <strong>订单来源： </strong>
								<c:if test="${order.source==1}">PC订单</c:if>
								<c:if test="${order.source==2}">触屏版订单</c:if>
							</td>
						</tr>
						<tr>
							<c:if test="${order.sendStyle==0}">
								<td><strong>配送时间：</strong><fmt:formatDate value="${order.sendDate}" type="date"/> <fmt:formatDate value="${order.sendTimeStart}" type="time"/>-<fmt:formatDate value="${order.sendTimeEnd}" type="time"/></td>
								<td></td>
							</c:if>
							<c:if test="${order.sendStyle==1}">
								<td><strong>自提时间：</strong><fmt:formatDate value="${order.takeDate}" type="date"/></td>
								<td><strong>取货码：</strong>${order.takeCode}</td>
							</c:if>
						</tr>
						<c:if test="${cancelLog!=null}">
							<tr>
								<td><strong>取消时间：</strong><fmt:formatDate value="${cancelLog.logTime}" type="both"/></td>
								<td><strong>取消原因：</strong>
									<c:if test="${cancelLog.logType==10}">${cancelLog.logDetail}</c:if>
									<c:if test="${cancelLog.logType!=10}">${cancelLog.typeName}</c:if>
								</td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</div>
			<c:if test="${order.sendStyle == 0}">
				<div class="m-table-list m-list3">
					<h4>收货信息</h4>
					<table class="table table-same">
						<tbody>
							<tr>
								<td><strong>收货人：</strong>${order.consignee}</td>
								<td><strong>联系方式： </strong>${order.consigneeMobile} ${order.consigneeTel}</td>
							</tr>
							<tr>
								<td colspan="2"><strong>收货地址：</strong>${order.consigneeAddress}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</c:if>
			<c:if test="${order.sendStyle == 1}">
				<div class="m-table-list m-list3">
					<h4>提货信息</h4>
					<table class="table table-same">
						<tbody>
							<tr>
								<td colspan="2"><strong>联系方式： </strong>${order.consigneeMobile} ${order.consigneeTel}</td>
							</tr>
							<tr>
								<td colspan="2"><strong>提货地址：</strong>(${shop.shopName})${shop.orgArea.show}${shop.address}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</c:if>
			<div class="m-table-list m-list3">
				<h4>发票信息</h4>
				<table class="table table-same">
					<tbody>
						<c:if test="${order.invoice!=null}">
							<tr>
								<td><strong>发票类型：</strong>普通（纸质）发票</td>
								<td><strong>发票抬头：</strong>${order.invoice}</td>
							</tr>
							<tr>
								<td colspan="2"><strong>发票内容：</strong>明细</td>
							</tr>
						</c:if>
						<c:if test="${order.invoice==null}">
							<tr>
								<td><strong>无</strong></td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</div>
			<div class="m-table-list m-list3">
				<h4>订单备注</h4>
				<table class="table table-same">
					<tbody>
						<tr>
							<td colspan="2"><strong>备注内容：</strong>${order.remark}</td>
						</tr>				
					</tbody>
				</table>
			</div>
			<div class="mlist m-list1">
					<h5>商品信息</h5>
					<table class="table table-same table-bordered">
						<thead>
							<tr class="bluem">
								<th class="th2">商品名称</th>
								<th>单价(元)</th>
								<th>数量</th>
								<th>小计</th>
							</tr>
						</thead>
					
					<tbody>
						<c:forEach var="orderGoods" items="${order.listOrderGoods}" varStatus="status">
						<c:if test="${orderGoods.unitAccounts > 0}">
						<tr class="bluem2">
							<td>
								<div class="mlist-img"><a href="${ctx}/item/${orderGoods.goodsId}" target="_blank"><img src="${orderGoods.orgProductItem.goodsImg180}" title="${orderGoods.orgProductItem.goodsName}"/></a></div>
								<div class="mlist-text"><a href="${ctx}/item/${orderGoods.goodsId}" target="_blank">${orderGoods.orgProductItem.goodsName}</a></div>
							</td>
							<td><fmt:formatNumber type="currency" pattern="￥0.00" value="${orderGoods.unitPrice}"/></td>
							<td>×${orderGoods.amount}</td>
							<td class="yellow-sm"><fmt:formatNumber type="currency" pattern="￥0.00" value="${orderGoods.unitPrice*orderGoods.amount}"/></td>
						</tr>
						</c:if>
						<c:if test="${orderGoods.unitAccounts.unscaledValue() == 0}">
						<tr>
							<td colspan="4">
								<div class="zengpin"><span><a href="${ctx}/item/${orderGoods.goodsId}" style="color:#666;" target="_blank">赠品：${orderGoods.orgProductItem.goodsName}</a></span><span>X${orderGoods.amount}</span></div>
							</td>
						</tr>
						</c:if>
						</c:forEach>
						<tr class="bluem2 big1" >
							<td colspan="4" style="text-align:right">
								订单金额：<span class="yellow-sm"><fmt:formatNumber type="currency" pattern="￥0.00" value="${order.orderMoney}"/></span>
							</td>
						</tr>
					</tbody>
					</table>
			</div>
			<!--  -->
			<div class="m-table-list m-list3">
				<h4>付款信息</h4>
				<table class="table table-same">
					<tbody>
						<tr>
							<td colspan="2"><strong >订单金额：</strong> <span class="red"><fmt:formatNumber type="currency" pattern="￥0.00" value="${order.orderMoney}"/></span>  </td>
						</tr>
						<tr>
							<td colspan="2"><strong>使用余额：</strong> <span class="red"><fmt:formatNumber type="currency" pattern="￥0.00" value="${order.depositMoney}"/></span></td>
						</tr>
						<tr>
							<td colspan="2"><strong>支付金额：</strong> <span class="red"><fmt:formatNumber type="currency" pattern="￥0.00" value="${order.payMoney}"/></span></td>
						</tr>

					</tbody>
				</table>
			</div>
			<!-- first right1 -->
			</div>
			<!-- end memberright -->
		</div>
	</div>

<!-- footer -->
<%@include file="../common/common_foot.jsp" %>
</div>
<%@include file="../common/common_js.jsp" %>
</body>
</html>