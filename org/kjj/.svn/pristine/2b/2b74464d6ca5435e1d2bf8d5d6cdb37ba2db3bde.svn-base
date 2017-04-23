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
								<li id="tag1">退货记录</li>
								<li id="tag2"><a href="${ctx}/refund/list<c:if test='${query.reOrderId!=null}'>?reOrderId=${query.reOrderId}</c:if>">退款明细</a></li>
								<c:if test="${query.reOrderId!=null}">
									<li id="tag3"><a href="${ctx}/return/show/${query.reOrderId}">搜索结果</a></li>
								</c:if>
							</ul>
							<a href="javascript:void(0);" class="contactme" id="consultBtn">联系客服</a>
						</div>
						<div class="bd paddingtop">
							<div class="bd-1">
								<table class="table">
										<thead>
											<tr class="blue2">
												<th>退货编号</th>
												<th>订单编号</th>
												<th style="width:300px;overflow:hidden">商品明细</th>
												<th>申请时间</th>
												<th>状态</th>
												<th>操作</th>
											</tr>
										</thead>
									<tbody>
										<c:forEach var="item" items="${page.content}" varStatus="status">
										<tr class="bottomline" >
											<td>${item.returnOrderId}</td>
											<td>${item.orderId}</td>
											<td>
												<div class="mg-img">
													<a href="${ctx}/item/${item.goodsId}" target="_blank"><img src="${item.orgProductItem.goodsImg50}" title="${item.orgProductItem.goodsName}"/></a>
												</div>
											</td>
											<td><fmt:formatDate value="${item.createTime}" type="both"/></td>
											<td>
												<c:if test="${item.returnStatus == 0}">申请退货</c:if>
												<c:if test="${item.returnStatus == 1}">拒绝退货</c:if>
												<c:if test="${item.returnStatus == 2}">退货中</c:if>
												<c:if test="${item.returnStatus == 3}">已退货</c:if>
											</td>
											<td><a href="${ctx}/return/detail/${item.returnOrderId}">查看</a></td>
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