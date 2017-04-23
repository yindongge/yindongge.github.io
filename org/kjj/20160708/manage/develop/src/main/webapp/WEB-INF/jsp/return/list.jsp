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
<form id ="pageform" name ="pageform" class="form-inline" action="${ctx}/return/list" method="post">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">交易</a></li>
		<li class="active"><a href="${ctx}/return/list">退换货管理</a></li>
	</ul>
	<div style="padding:5px;height:100px;background:#f5f5f5;">
		<div class="col-sm-12">
			<div class="form-group">
				<label>退换货单号：</label>
				<input type="text" class="form-control" id="returnOrderLike" name="returnOrderLike" value="${query.returnOrderLike}"/>			
			</div>
			<div class="form-group">
				<label>订单号：</label>
				<input type="text" class="form-control" id="orderIdLike" name="orderIdLike" value="${query.orderIdLike}"/>			
			</div>
			<div class="form-group">
				<label>提交时间：</label>
				<input type="text" class="form-control date" id="createTimeStart" name="createTimeStart" value="<fmt:formatDate value="${query.createTimeStart}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>"/>-
				<input type="text" class="form-control date" id="createTimeEnd" name="createTimeEnd" value="<fmt:formatDate value="${query.createTimeEnd}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>"/>			
			</div>
		</div>
		<div class="col-sm-12">
			<div class="form-group">
				<label>SKU：</label>
				<input type="text" class="form-control" id="goodsSnLike" name="goodsSnLike" value="${query.goodsSnLike}"/>			
			</div>
			<div class="form-group">
				<label>商品名称：</label>
				<input type="text" class="form-control" id="goodsNameLike" name="goodsNameLike" value="${query.goodsNameLike}"/>			
			</div>
			<div class="form-group">
				<label>类型：</label>
				<select name="returnStyle">
					<option value="-1" <c:if test="${ query.returnStyle=='-1' }">selected</c:if>>全部</option>
					<option value="0" <c:if test="${ query.returnStyle=='0' }">selected</c:if>>退货</option>
					<option value="1" <c:if test="${ query.returnStyle=='1' }">selected</c:if>>换货</option>
				</select>
				<label>状态：</label>
				<select name="returnStatus">
					<option value="-1" <c:if test="${ query.returnStatus=='-1' }">selected</c:if>>全部</option>
					<option value="0" <c:if test="${ query.returnStatus=='0' }">selected</c:if>>申请退货</option>
					<option value="1" <c:if test="${ query.returnStatus=='1' }">selected</c:if>>拒绝退货</option>
					<option value="2" <c:if test="${ query.returnStatus=='2' }">selected</c:if>>退货中</option>
					<option value="3" <c:if test="${ query.returnStatus=='3' }">selected</c:if>>已退货</option>
				</select>
			</div>	
			<div class="form-group pull-right">
				<button type="submit" class="btn btn-info btn-sm">搜索</button>
			</div>
		</div>
	</div>
	<br/>
	<table class="table table-hover table-bordered ">
		<thead>
			<tr>
				<th>退货单号</th>
				<th>订单号</th>
				<th>申请时间</th>
				<th>退货金额</th>
				<th>实际退款金额</th>
				<th>退货数量</th>
				<th>管理员回复</th>
				<th>处理状态</th>
				<th >操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${page.content}" varStatus="status">
			<tr>
				<td>${item.returnOrderId}</td>
				<td>${item.orderId}</td>
				<td><fmt:formatDate value="${item.createTime}" type="both"/></td>
				<td><fmt:formatNumber type="currency" pattern="￥0.00" value="${item.returnUnitPrice*item.amount}"/></td>
				<td><fmt:formatNumber type="currency" pattern="￥0.00" value="${item.returnMoney}"/></td>
				<td>${item.amount}</td>
				<td>${item.reply}</td>
				<td>
					<c:if test="${item.returnStatus == 0}">申请退货</c:if>
					<c:if test="${item.returnStatus == 1}">拒绝退货</c:if>
					<c:if test="${item.returnStatus == 2}">退货中</c:if>
					<c:if test="${item.returnStatus == 3}">已退货</c:if>
				</td>
				<td>	
					<a href="${ctx}/return/detail/${item.returnOrderId}" type="button" class="btn btn-danger btn-xs">操作</a>
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
<script src="${jsBase}/return/list.js" type="text/javascript"></script>
</body>
</html>
