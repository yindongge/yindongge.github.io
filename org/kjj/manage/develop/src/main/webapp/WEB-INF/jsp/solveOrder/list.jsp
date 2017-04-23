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
<title>订单管理</title>
</head>

<body>
<div class="page-wrapper goods-control">
<div class="container-fluid">
	<form  class="form-inline" id ="pageform" name ="pageform" action="${ctx}/solveOrder/list" method="post">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">交易</a></li>
		<li class="active">问题订单管理</li>
	</ul>
	<div style="padding:5px;height:50px;background:#f5f5f5;">
		<div class="col-sm-12">
			<div class="form-group">
				<label>订单号：</label>
				<input type="text" class="form-control" id="orderIdLike" name="orderIdLike" value="${query.orderIdLike}"/>			
			</div>
			<div class="form-group">
				<label>状态：</label>
				<select name="status">
					<option value="" <c:if test="${empty query.status }">selected</c:if>>全部</option>
					<option value="0" <c:if test="${ query.status=='0' }">selected</c:if>>待解决</option>
					<option value="1" <c:if test="${ query.status=='1' }">selected</c:if>>已解决</option>
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
			<tr class="info">
				<th>订单号</th>
				<th>收货人</th>
				<th>联系方式</th>
				<th>店铺</th>
				<th>下单时间</th>
				<th style="width:200px;">原因</th>
				<th style="width:200px;">门店备注</th>
				<th>订单来源</th>
				<th>配送方式</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${page.content}" varStatus="status">
			<tr>
				<td>${item.orderId}</td>
				<td>${item.orgOrder.consignee}</td>
				<td>${item.orgOrder.consigneeMobile}${item.orgOrder.consigneeTel}</td>
				<td>${item.shopName}</td>
				<td><fmt:formatDate value="${item.orgOrder.createTime}" type="both"/></td>
				<td style="width:200px;">${item.reason}</td>
				<td style="width:200px;">${item.remark}</td>
				<td>
					<c:if test="${item.orgOrder.source==1}">PC</c:if>
					<c:if test="${item.orgOrder.source==2}">触屏版</c:if>
				</td>
				<td>
					<c:if test="${item.orgOrder.sendStyle==0}">送货</c:if>
					<c:if test="${item.orgOrder.sendStyle==1}">自提</c:if>
				</td>
				<td>
					<c:if test="${item.status==0}">待解决</c:if>
					<c:if test="${item.status==1}">已解决</c:if>
				</td>
				<td>
					<a href="${ctx}/solveOrder/detail/${item.id}" type="button" class="btn btn-danger btn-xs">操作</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 
	<div class="button-display">
		<div class="button-left-input">
			<input type="checkbox" name="checkAll"/><label for="checkAll">全选</label>
		</div>
		<div class="button-left-button">
			<button type="button" class="btn btn-default" name="btnBatchConfirm">批量确认</button>
			<button type="button" class="btn btn-default" name="btnBatchPrint">批量打印送货单</button>
		</div>
	</div>
	 -->
	 <nav class="navbar navbar-default select-control" >
		<%@include file="../common/common_page.jsp" %>	
	</nav>
	</form>
</div>
</div>
<%@include file="../common/common_js.jsp" %>
</body>
</html>
