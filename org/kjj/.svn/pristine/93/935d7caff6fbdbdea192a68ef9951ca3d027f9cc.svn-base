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
	<form  class="form-inline" id ="pageform" name ="pageform" action="${ctx}/orderGoods/list" method="post">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">交易</a></li>
		<li class="active">订单商品管理</li>
	</ul>
	<div style="padding:5px;height:100px;background:#f5f5f5;">
		<div class="col-sm-12">
			<div class="form-group">
				<label>商品名称：</label>
				<input type="text" class="form-control" name="goodsNameLike" value="${query.goodsNameLike}"/>			
			</div>
			<div class="form-group">
				<label>订单号：</label>
				<input type="text" class="form-control" name="orderIdLike" value="${query.orderIdLike}"/>				
			</div>
			<div class="form-group">
				<label>下单时间：</label>
				<input type="text" class="form-control date" id="createTimeStart" name="createTimeStart" value="<fmt:formatDate value="${query.createTimeStart}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>"/>-
				<input type="text" class="form-control date" id="createTimeEnd" name="createTimeEnd" value="<fmt:formatDate value="${query.createTimeEnd}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
			</div>
			
		</div>
		<div class="col-sm-12">
			<div class="form-group">
				<label>店铺：</label>
				<input type="text" class="form-control btn-click"/>
				<input type="hidden" name="shopSelect" id="shopSelect" 
					value="<c:forEach var="item" items="${query.shopSelect}" varStatus="status">${item}<c:if test="${!status.last}">,</c:if></c:forEach>"/>
			</div>
			<div class="form-group radio-special2">
				<label>订单状态：</label>
				<select name="queryStatus">
					<option value="-1" <c:if test="${ query.queryStatus=='-1' }">selected</c:if>>请选择</option>
					<option value="0" <c:if test="${ query.queryStatus=='0' }">selected</c:if>>待付款</option>
					<option value="1" <c:if test="${ query.queryStatus=='1' }">selected</c:if>>待确认</option>
					<option value="12" <c:if test="${ query.queryStatus=='12' }">selected</c:if>>待发货</option>
					<option value="22" <c:if test="${ query.queryStatus=='22' }">selected</c:if>>备货中</option>
					<option value="13" <c:if test="${ query.queryStatus=='13' }">selected</c:if>>待收货</option>
					<option value="23" <c:if test="${ query.queryStatus=='23' }">selected</c:if>>待自提</option>
					<option value="4" <c:if test="${ query.queryStatus=='4' }">selected</c:if>>已完成</option>
					<option value="5" <c:if test="${ query.queryStatus=='5' }">selected</c:if>>已取消</option>
					<option value="6" <c:if test="${ query.queryStatus=='6' }">selected</c:if>>已关闭</option>
				</select>
			</div>
			<div class="form-group pull-right">
				<button type="submit" class="btn btn-info">搜索</button>	
			</div>
		</div>
	</div>
	<br/>
	<table class="table table-hover table-bordered ">
		<thead>
			<tr class="info">
				<th style="width:200px;">商品名称</th>
				<th>商品编号</th>
				<th>订单号</th>
				<th>店铺</th>
				<th>下单时间</th>
				<th>付款时间</th>
				<th>金额</th>
				<th>数量</th>
				<th>支付方式</th>
				<th>订单来源</th>
				<th>配送方式</th>
				<th>订单状态</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${page.content}" varStatus="status">
			<tr>
				<td>${item.orgProductItem.goodsName}</td>
				<td>${item.goodsSn}</td>
				<td>${item.orderId}</td>
				<td>${item.shopName}</td>
				<td><fmt:formatDate value="${item.orgOrder.createTime}" type="both"/></td>
				<td><fmt:formatDate value="${item.orgOrder.payTime}" type="both"/></td>
				<td>
					<span style="text-decoration:line-through;"><fmt:formatNumber type="currency" pattern="￥0.00" value="${item.unitAccounts}"/></span>
					<span class="red"><fmt:formatNumber type="currency" pattern="￥0.00" value="${item.unitPrice}"/></span>
				</td>
				<td>${item.amount}</td>
				<td>
					<c:if test="${item.orgOrder.depositMoney>0}">预
						<c:if test="${item.orgOrder.onlinePayStyle > 0 or item.orgOrder.localPayStyle > 0}">+</c:if>
					</c:if>
					<c:if test="${item.orgOrder.depositMoney.unscaledValue()==0 and (item.orgOrder.onlinePayStyle==0 or item.orgOrder.localPayStyle==0)}">无需付款</c:if>
					<c:if test="${item.orgOrder.payStyle==0}">
						<c:if test="${item.orgOrder.onlinePayStyle==1}">支</c:if>
						<c:if test="${item.orgOrder.onlinePayStyle==2}">微</c:if>
						<c:if test="${item.orgOrder.onlinePayStyle==3}">财</c:if>
						<c:if test="${item.orgOrder.onlinePayStyle==4}">银联</c:if>
						<c:if test="${item.orgOrder.onlinePayStyle==5}">微</c:if>
						<c:if test="${item.orgOrder.onlinePayStyle==6}">支</c:if>
					</c:if>
					<c:if test="${item.orgOrder.payStyle==1}">
						<c:if test="${item.orgOrder.localPayStyle==1}">现金</c:if>
						<c:if test="${item.orgOrder.localPayStyle==2}">pos</c:if>
					</c:if>
				</td>
				<td>
					<c:if test="${item.orgOrder.source==1}">PC</c:if>
					<c:if test="${item.orgOrder.source==2}">触屏版</c:if>
				</td>
				<td>
					<c:if test="${item.orgOrder.sendStyle==0}">送货</c:if>
					<c:if test="${item.orgOrder.sendStyle==1}">自提</c:if>
				</td>
				<td>
					<c:if test="${item.orgOrder.status==0}">待付款</c:if>
					<c:if test="${item.orgOrder.status==1}">待确认</c:if>
					<c:if test="${item.orgOrder.status==2}">
						<c:if test="${item.orgOrder.sendStyle==0}">待发货</c:if>
						<c:if test="${item.orgOrder.sendStyle==1}">备货中</c:if>
					</c:if>
					<c:if test="${item.orgOrder.status==3}">
						<c:if test="${item.orgOrder.sendStyle==0}">待收货</c:if>
						<c:if test="${item.orgOrder.sendStyle==1}">待自提</c:if>
					</c:if>
					<c:if test="${item.orgOrder.status==4}">已完成</c:if>
					<c:if test="${item.orgOrder.status==5}">已取消</c:if>
					<c:if test="${item.orgOrder.status==6}">已关闭</c:if>
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
<script src="${jsBase}/orderGoods/list.js" type="text/javascript"></script>
</body>
</html>
