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
		<div class="container">
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
	<form action="${ctx}/refund/list" id="pageform" name="pageform" method="post">	
	<div class="center-content">
		<div class="container">
			<jsp:include page="../common/common_left.jsp">
				<jsp:param name="active" value="退货记录"/>
			</jsp:include>
			<!-- member-left -->
				<div class="member-right">
					<div class="payment">
						<div class="slideTxtBox">
						<div class="hd">			
							<ul>
								<li id="tag1"><a href="${ctx}/return/list<c:if test='${query.reOrderId!=null}'>?reOrderId=${query.reOrderId}</c:if>">退货记录</a></li>
								<li id="tag2">退款明细</li>
								<c:if test="${query.reOrderId!=null}">
									<li id="tag3"><a href="${ctx}/return/show/${query.reOrderId}">搜索结果</a></li>
								</c:if>
							</ul>
							<a href="javascript:void(0);" class="contactme" id="consultBtn">联系客服</a>
						</div>
						<div class="bd paddingtop">
							<div class="bd-2">
								<table class="table">
										<thead>
											<tr class="blue2">
												<th>退款编号</th>
												<th>订单编号</th>
												<th style="width:300px;overflow:hidden">商品明细</th>
												<th>交易金额</th>
												<th>退款金额</th>
												<th>申请时间</th>
												<th>状态</th>
												<th>操作</th>
											</tr>
										</thead>
									<tbody>
										<c:forEach var="item" items="${page.content}" varStatus="status">
										<tr class="bottomline" >
											<td>${item.refundOrderId}</td>
											<td>${item.orderId}</td>
											<td>
												<div class="mg-img">
													<c:forEach var="orderGoods" items="${item.listOrderGoods}" varStatus="goods_status">
														<a href="${ctx}/item/${orderGoods.goodsId}" target="_blank"><img src="${orderGoods.orgProductItem.goodsImg50}" title="${orderGoods.orgProductItem.goodsName}"/></a>
													</c:forEach>
												</div>
											</td>
											<td class="yellow-sm"><fmt:formatNumber type="currency" pattern="￥0.00" value="${item.goodsPayMoney}"/></td>
											<td class="yellow-sm"><fmt:formatNumber type="currency" pattern="￥0.00" value="${item.refundMoney}"/></td>
											<td><fmt:formatDate value="${item.createTime}" type="both"/></td>
											<td>
												<c:if test="${item.refundStatus == 0}">退款中</c:if>
												<c:if test="${item.refundStatus == 1}">已退款</c:if>
											</td>
											<td><a href="${ctx}/refund/detail/${item.refundOrderId}">查看</a></td>
										</tr>
										</c:forEach>
									</tbody>
								</table>	
							</div>
						</div>
						<%@include file="../common/common_page.jsp"%>
					</div>	
			</div>
			</div>
			<!-- end memberright -->
			</div>
	</div>
	</form>
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