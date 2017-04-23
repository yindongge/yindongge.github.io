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
	<form action="${ctx}/return/list" id="pageform" name="pageform" method="post">	
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
								<li id="tag1"><a href="${ctx}/return/list?reOrderId=${order.orderId}">退货记录</a></li>
								<li id="tag2"><a href="${ctx}/refund/list?reOrderId=${order.orderId}">退款明细</a></li>
								<li id="tag3">搜索结果</li>
							</ul>
							<a href="javascript:void(0);" class="contactme" id="consultBtn">联系客服</a>
						</div>
						<div class="bd paddingtop">
							<div class="bd-3">	
								<table class="table">
										<thead>
											<tr class="blue2">
												<th>订单编号</th>
												<th style="width:625px;">订单商品</th>
												<th>下单时间</th>
											</tr>
										</thead>
									<tbody>
										<tr class="bottomline" >
											<td>${order.orderId}</td>
											<td>
												<c:forEach var="orderGoods" items="${listOrderGoods}" varStatus="status">
												<c:if test="${orderGoods.amount>orderGoods.returnAmount}">
												<div class="bd-imglist">
													<a href="${ctx}/item/${orderGoods.goodsId}" target="_blank" class="a1"><img src="${orderGoods.orgProductItem.goodsImg50}" title="${orderGoods.orgProductItem.goodsName}"/></a>
													<a href="${ctx}/return/addInit/${orderGoods.id}" class="a2">申请</a>
												</div>
												</c:if>
												</c:forEach>
											</td>
											<td><fmt:formatDate value="${order.createTime}" type="both"/></td>
										</tr>
									</tbody>
								</table>	
							</div>
						</div>
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