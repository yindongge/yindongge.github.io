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
	
	<div class="center-content">
		<form id="pageform" name="pageform" action="${ctx}/coupon/list" method="post">
		<input type="hidden" name="status" value="${query.status}"/>
		<div class="container">
			<jsp:include page="../common/common_left.jsp">
				<jsp:param name="active" value="优惠券"/>
			</jsp:include>
			<!-- member-left -->
			<div class="member-right">
					<div class="youhui-title">
						<a class="l1 <c:if test="${query.status==2}">no-borderder active</c:if>" href="${ctx}/coupon/list?status=2">未使用</a>
						<a class="l1 <c:if test="${query.status==3}">no-borderder active</c:if>" href="${ctx}/coupon/list?status=3">已使用</a>
						<a class="l1 <c:if test="${query.status==4}">no-borderder active</c:if>" href="${ctx}/coupon/list?status=4">已过期</a>
						<a class="tip2" href="${ctx}/article/dispatcher/34" target="_blank">优惠券使用规则</a>
					</div>
					<table class="table ">
						<thead>
							<tr class="inforevise">
								<th class="r1">优惠券</th>
								<th class="r2">说明</th>
								<th class="r3">类型</th>
								<th>适用范围</th>
								<th class="r5">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${page.content}" varStatus="status">
								<tr class="whitespace">
									<td  colspan="6" ></td>
								</tr>
								<tr class="gray-bc">
									<td>
										<div class="youhui-pri <c:if test="${query.status!=2}">gary</c:if>">
											<h4>${item.orgCoupon.couponName}</h4>
											<p class="leftright"><span class="left2"><fmt:formatNumber type="currency" pattern="￥0.00" value="${item.orgCoupon.discountMoney}"/></span><span class="left3 pull-right">满<fmt:formatNumber type="currency" pattern="￥0.00" value="${item.orgCoupon.conditionMoney}"/>可用</span></p>
											<p>编号：${item.recordId}</p>
											<p class="tiaojian">使用条件：
												<a>
													<c:if test="${item.orgCoupon.productType==1}">全场商品</c:if>
													<c:if test="${item.orgCoupon.productType==2}">指定分类</c:if>
													<c:if test="${item.orgCoupon.productType==3}">指定商品</c:if>
												</a>
												<a>
													<c:if test="${item.orgCoupon.shopType==1}">全部门店</c:if>
													<c:if test="${item.orgCoupon.shopType==2}">指定区域</c:if>
													<c:if test="${item.orgCoupon.shopType==3}">指定门店</c:if>
												</a>
											</p>
											<p>有效时间：<fmt:formatDate value="${item.startTime}" type="date"/>~<fmt:formatDate value="${item.endTime}" type="date"/></p>
										</div>
									</td>
									<td class="td-specialyouhui">
										<p>
											<c:if test="${item.orgCoupon.productType==1}">全场商品</c:if>
											<c:if test="${item.orgCoupon.productType==2}">指定分类</c:if>
											<c:if test="${item.orgCoupon.productType==3}">指定商品</c:if>
											优惠券，
											<c:if test="${item.orgCoupon.shopType==1}">全部门店</c:if>
											<c:if test="${item.orgCoupon.shopType==2}">北京区域门店</c:if>
											<c:if test="${item.orgCoupon.shopType==3}">指定门店</c:if>
											可用，
											满<fmt:formatNumber type="currency" pattern="0.00" value="${item.orgCoupon.conditionMoney}"/>减<fmt:formatNumber type="currency" pattern="0.00" value="${item.orgCoupon.discountMoney}"/>
										</p>
										<!-- <p class="red">限移动端使用</p> -->
									</td>
									<td>
										<c:if test="${item.orgCoupon.productType==1}">全场商品</c:if>
										<c:if test="${item.orgCoupon.productType==2}">指定分类</c:if>
										<c:if test="${item.orgCoupon.productType==3}">指定商品</c:if>
									</td>
									<td>
										<c:if test="${item.orgCoupon.shopType==1}">全部门店</c:if>
										<c:if test="${item.orgCoupon.shopType==2}">北京区域门店</c:if>
										<c:if test="${item.orgCoupon.shopType==3}">指定门店</c:if>
									</td>
									<td>
										<p>
										<c:if test="${query.status==2}">未使用</c:if>
										<c:if test="${query.status==3}">已使用</c:if>
										<c:if test="${query.status==4}">已过期</c:if>
										</p>
										<c:if test="${query.status==2 or query.status==4}">
											<!-- <a href="javascript:void();" class="blue">查看可购商品</a> -->
										</c:if>
										<c:if test="${query.status==3}">
											<p>订单编号：${item.orderId}</p>
											<p>使用时间：<fmt:formatDate value="${item.useTime}" type="date"/></p>
										</c:if>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<%@include file="../common/common_page.jsp"%>
				</div>
				<!-- end mg-content -->
				</div>
				</form>
			</div>
			<!-- end memberright -->
		</div>
	</div>
	
<!--  -->
<%@include file="../common/common_foot.jsp" %>
<%@include file="../common/common_js.jsp"%>
<div class="toggle-mask" style="display:none;"></div>
</body>
</html>