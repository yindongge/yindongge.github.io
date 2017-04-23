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
<title>退换货管理</title>
</head>

<body>

<div class="page-wrapper goods-control">
<div class="container-fluid">
<form id ="pageform" id="pageform" name="pageform" class="form-inline" action="${ctx}/refund/list" method="post">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">交易</a></li>
		<li class="active"><a href="{ctx}/refund/list">退款管理</a></li>
	</ul>
	<div style="padding:5px;height:100px;background:#f5f5f5;">
		<div class="col-sm-12">
			<div class="form-group">
				<label>退款单号：</label>
				<input type="text" class="form-control" id="refundOrderLike" name="refundOrderLike" value="${query.refundOrderLike}"/>			
			</div>
			<div class="form-group">
				<label>订单号：</label>
				<input type="text" class="form-control" id="orderLike" name="orderLike" value="${query.orderLike}"/>			
			</div>
			<div class="form-group">
				<label>申请时间：</label>
				<input type="text" class="form-control date" id="createTimeStart" name="createTimeStart" value="<fmt:formatDate value="${query.createTimeStart}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>"/>-
				<input type="text" class="form-control date" id="createTimeEnd" name="createTimeEnd" value="<fmt:formatDate value="${query.createTimeEnd}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>"/>			
			</div>
		</div>
		<div class="col-sm-12">
			<div class="form-group">
				<label>用户：</label>
				<input type="text" class="form-control" id="userNameLike" name="userNameLike" value="${query.userNameLike}"/>			
			</div>
			<div class="form-group">
				<label>店铺：</label>
				<input type="text" class="form-control btn-click"/>
				<input type="hidden" name="shopSelect" id="shopSelect" 
					value="<c:forEach var="item" items="${query.shopSelect}" varStatus="status">${item}<c:if test="${!status.last}">,</c:if></c:forEach>"/>					</div>	
			<div class="form-group pull-right">
				<button type="submit" class="btn btn-info btn-sm">搜索</button>
			</div>
		</div>
	</div>
	<br/>
	<table class="table table-hover table-bordered ">
		<thead>
			<tr>
				<th>退款单号</th>
				<th>订单号</th>
				<th>用户</th>
				<th>交易金额</th>
				<th>退款金额</th>
				<th>申请时间</th>
				<th>店铺</th>
				<th>状态</th>
				<th >操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${page.content}" varStatus="status">
			<tr>
				<td>${item.refundOrderId}</td>
				<td>${item.orderId}</td>
				<td>${item.userName}</td>
				<td><fmt:formatNumber type="currency" pattern="￥0.00" value="${item.goodsPayMoney}"/></td>
				<td><fmt:formatNumber type="currency" pattern="￥0.00" value="${item.refundMoney}"/></td>
				<td><fmt:formatDate value="${item.createTime}" type="both"/></td>
				<td>${item.shopName}</td>
				<td>
					<c:if test="${item.refundStatus == 0}">退款中</c:if>
					<c:if test="${item.refundStatus == 1}">已退款</c:if>
				</td>
				<td>	
					<a href="${ctx}/refund/detail/${item.refundOrderId}" type="button" class="btn btn-danger btn-xs">操作</a>
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
<script src="${jsBase}/refund/list.js" type="text/javascript"></script>
</body>
</html>
