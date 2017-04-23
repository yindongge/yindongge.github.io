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
<form id ="pageform" name ="pageform" class="form-inline" action="${ctx}/coupon/listRecord" method="post">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">运营</a></li>
		<li class="active">优惠券管理</li>
	</ul>
	<div class="well" style="padding:5px;">
		<div class="form-group">
			<label>会员：</label>
			<input type="text" class="form-control" placeholder="输入手机号/邮箱/会员名" name="userNameLike" value="${query.userNameLike}"/>			
		</div>
		<div class="form-group">
			<label>优惠券：</label>
			<input type="text" class="form-control" placeholder="输入券名或券号" name="couponNameLike" value="${query.couponNameLike}"/>			
		</div>
		<div class="form-group">
			<select class="form-control" name="status">
				<option value="" <c:if test="${ empty query.status }">selected</c:if>>全部</option>
				<option value="0" <c:if test="${ query.status=='0' }">selected</c:if>>待领取</option>
				<option value="1"<c:if test="${ query.status=='1' }">selected</c:if>>待绑定</option>
				<option value="2"<c:if test="${ query.status=='2' }">selected</c:if>>未使用</option>
				<option value="3"<c:if test="${ query.status=='3' }">selected</c:if>>已使用</option>
				<option value="4"<c:if test="${ query.status=='4' }">selected</c:if>>已过期</option>
				<option value="5"<c:if test="${ query.status=='5' }">selected</c:if>>已作废</option>
			</select>		
		</div>
	
		<button type="submit" class="btn btn-danger">搜索</button>
		</div>
	<br/>
	
	<div class="group-button">
		<a role="button" class="btn  btn-default " href="${ctx}/coupon/list">优惠劵</a>
		<a role="button" class="btn btn-primary" href="${ctx}/coupon/listRecord">发放领取记录</a>
		<a role="button" class="btn btn-default" href="${ctx}/coupon/triggerList">触发券管理</a>
	</div>
	<table class="table table-hover table-bordered table-4">
		<thead>
			<tr class="info">
				<th>会员</th>
				<th>红包/优惠券</th>
				<th>优惠券编号</th>
				<th>状态</th>
				<th>订单编号</th>
				<th>获取时间</th>
				<th>获取方式</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="nowDate" value="<%=System.currentTimeMillis()%>"></c:set>
			<c:forEach var="item" items="${page.content}" varStatus="status">
			<tr class="icon11">
				<td class="icon11-td blockspan2">
					<span class="blue">${item.userPhone}</span>
					<span class="blue">${item.userName}</span>
				</td>
				<td class="icon11-td blockspan2">
					<span class="blue bigblue">${item.orgCoupon.couponName}</span>
					<span>说明：
						<c:if test="${item.orgCoupon.productType==1}">全场商品</c:if>
						<c:if test="${item.orgCoupon.productType==2}">指定分类</c:if>
						<c:if test="${item.orgCoupon.productType==3}">指定商品</c:if>
						，满<fmt:formatNumber type="currency" pattern="0.00" value="${item.orgCoupon.conditionMoney}"/>减<fmt:formatNumber type="currency" pattern="0.00" value="${item.orgCoupon.discountMoney}"/></span>
				</td>
				<td class="blockspan2">
					${item.recordId}
				</td>
				<td class="blockspan2">
					<c:if test="${item.status==0}">待领取</c:if>
					<c:if test="${item.status==1}">待绑定</c:if>
					<c:if test="${item.status==2 and (nowDate-item.endTime.time <= 0)}">未使用</c:if>
					<c:if test="${item.status==3}">已使用</c:if>
					<c:if test="${item.status==2 and (nowDate-item.endTime.time > 0)}">已过期</c:if>
					<c:if test="${item.status==5}">已作废</c:if>
				</td>
				<td class="blockspan2">
					${item.orderId}
				</td>
				<td><fmt:formatDate value="${item.bindingTime}" type="both"/></td>
				<td>
					<c:if test="${item.source==1}">领取</c:if>
					<c:if test="${item.source==2}">发放</c:if>
					<c:if test="${item.source==3}">触发</c:if>
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
<%-- <script src="${jsBase}/coupon/recordList.js" type="text/javascript"></script> --%>
</body>
</html>
