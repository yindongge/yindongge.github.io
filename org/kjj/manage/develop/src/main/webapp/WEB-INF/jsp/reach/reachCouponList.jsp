<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<%@include file="../common/common_css.jsp" %>
<title>优惠券管理</title>
</head>
<body>
<div class="page-wrapper goods-control">
<div class="container-fluid">
<form id ="pageform" name ="pageform" class="form-inline" action="${ctx}/reach/reachCouponList" method="post">
	<input type="hidden" id="reachDiscountId" name="reachDiscountId" value="${query.reachDiscountId}"/>
	<div class="well" style="padding:5px;">
		<div class="form-group">
			<label>优惠劵名称：</label>
			<input type="text" class="form-control" id="couponNameLike" name="couponNameLike" value="${query.couponNameLike}"/>			
		</div>

		<button type="submit" class="btn btn-danger">搜索</button>
		</div>
	<br/>

	<table class="table table-hover table-bordered table-4">
		<thead>
			<tr class="info">
				<th style="width:25%">优惠劵</th>
				<th>面额（元）</th>
				<th>使用条件</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${page.content}" varStatus="status">
			<tr class="icon11">
				<td class="icon11-td blockspan2">
					<a>
						<div class="photopin">
							<div class="pin-left">
								<span>快捷健</span>
								<span>优惠劵</span>
							</div>
							<div class="pin-right">
								<fmt:formatNumber type="currency" pattern="0.00" value="${item.discountMoney}"/>
							</div>
						</div>
					</a>
					<span>${item.couponName}</span>
					<span>满<fmt:formatNumber type="currency" pattern="0.00" value="${item.conditionMoney}"/>减<fmt:formatNumber type="currency" pattern="0.00" value="${item.discountMoney}"/></span>
				</td>
				<td><fmt:formatNumber type="currency" pattern="0.00" value="${item.discountMoney}"/></td>
				<td>满<fmt:formatNumber type="currency" pattern="0.00" value="${item.conditionMoney}"/></td>
				<td>
					<c:if test="${item.status==1}"><span>有效</span></c:if>
					<c:if test="${item.status==0}"><span>无效</span></c:if>
				</td>
				<td>
					<c:if test="${empty item.orgReachCoupon.id }">
						<button type="button" class="btn btn-success" data-coupon-id="${item.couponId}">添加</button>
					</c:if>
					<c:if test="${not empty item.orgReachCoupon.id }">
						<button type="button" class="btn btn-danger" data-coupon-id="${item.couponId}">取消</button>
					</c:if>
					
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<nav class="navbar navbar-default select-control" >
		<%@include file="../common/common_page.jsp" %>
	</nav>
	</form>
</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/reach/reachCouponList.js" type="text/javascript"></script>
</body>
</html>
