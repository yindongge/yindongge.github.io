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
<title>申请退换货</title>
</head>
<body>
<div class="page-wrapper goods-control">
<div class="container-fluid">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">交易</a></li>
		<li class="active"><a href="${ctx}/order/list">订单管理</a></li>	
		<li class="active">申请退货</li>
	</ul>
	
	<br/>
	
	<form id ="returnForm" name ="returnForm" action="${ctx}/return/add" method="post">
	<input type="hidden" name="amount" value="${listOrderGoods[0].amount-listOrderGoods[0].returnAmount}"/>
	<table class="table table-hover table-bordered ">
		
		<thead>
			<tr class="info">				
				<th width="150px;">商品信息</th>
				<th colspan="2"></th>
				<th ></th>
				<th></th>
			</tr>
			<tr class="active">				
				<th width="150px;">SKU</th>
				<th colspan="2">商品</th>
				<th width="150px">单价</th>
				<th>退货数量</th>
			</tr>
		</thead>
			<c:forEach var="orderGoods" items="${listOrderGoods}" varStatus="status">
			<tr>
				<td><input type="radio" class="apply-radio" name="orderGoodsId" value="${orderGoods.id}" <c:if test="${status.first}">checked="checked"</c:if>/>&nbsp;&nbsp;${orderGoods.goodsSn}</td>
				<td colspan="2"><span class="text-info">${orderGoods.orgProductItem.goodsName}</span><br/>
					<!-- <span class="text-danger">口味：巧克力味</span> -->
				</td>
				<td><span style="text-decoration:line-through"><fmt:formatNumber type="currency" pattern="￥0.00" value="${orderGoods.unitAccounts}"/></span>
					<br/>
					<span class="text-danger"><fmt:formatNumber type="currency" pattern="0.00" value="${orderGoods.unitPrice}"/></span>
				</td>
				<td style="text-align:center;">
					<div class="ma">
						<a class="mua mu-l <c:if test="${orderGoods.amount-orderGoods.returnAmount==1}">diasbled</c:if>" href="javascript:void(0);" name="amountMinus">-</a>
						<input type="text" class="text11" name="amountText" value="${orderGoods.amount-orderGoods.returnAmount}" lastAmount="${orderGoods.amount-orderGoods.returnAmount}" old="${orderGoods.amount-orderGoods.returnAmount}"/>
						<a class="mua mu-r" href="javascript:void(0);" name="amountPlus">+</a>
					</div>
				</td>
			</tr>
			</c:forEach>
		<thead>
			<tr class="info">				
				<th width="150px;">取货信息</th>
				<th></th>
				<th width="150px"></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
			<tr>				
				<td class="strong-b">返回方式</td>
				<td>
					<c:if test="${order.sendStyle==0}">上门取件</c:if>
					<c:if test="${order.sendStyle==1}">到店退货</c:if>
				</td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td class="strong-b">联系人</td>
				<td>
					<div class="form-group">
						<input type="text" class="form-control" id="returnContact" name="returnContact" value="${order.consignee}"
						required data-bv-notempty-message="联系人不能为空"
						maxlength="60" data-bv-stringlength-message="联系人长度不能大于60"/>
					</div>
				</td>
				<td class="strong-b">联系方式</td>
				<td>
					<div class="form-group">
						<input type="text" class="form-control" id="returnTel" name="returnTel" value="${returnTel}"
						required data-bv-notempty-message="联系方式不能为空"
						maxlength="20" data-bv-stringlength-message="联系方式长度不能大于20"
						pattern="^1\d{10}$|^\d{7,8}$|^0[1-9]\d{1,2}-\d{7,8}$|^0[1-9]\d{8,10}$" data-bv-regexp-message="联系方式不符合规范"/>
					</div>
				</td>
				<td class="strong-b"></td>
			</tr>
			<c:if test="${order.sendStyle==0}">
				<tr>
					<td class="strong-b">地址</td>
					<td class="strong-b" colspan="4">
						<div class="form-group">
							<input type="text" class="form-control" id="returnAddress" name="returnAddress" value="${shop.area[0]}${shop.area[1]}${shop.area[2]}${order.consigneeAddress}" readonly="readonly"/>
						</div>
					</td>
				</tr>
			</c:if>
			<thead>
				<tr class="info">
					<th>操作信息</th>
					<th colspan="4"></th>
				</tr>
			</thead>
				<tr>
					<td>问题描述:</td>
					<td colspan="3" >
						<div class="form-group">
						<textarea class="form-control" rows="6" style="width:80%;resize: none;" name="reason" onkeyup="checkTextAreaLength(this,200)" onblur="checkTextAreaLength(this,200)"
						required data-bv-notempty-message="问题描述不能为空"
						maxlength="200" data-bv-stringlength-message="问题描述长度不能大于200"></textarea>
						</div>
						<br/>
						<button type="submit" class="btn btn-default" style="margin-right:20px;">确认</button>
						<button type="button" class="btn btn-default" onclick="javascript:history.go(-1)">返回</button>
					</td>
					<td colspan="1"></td>
				</tr>
	</table>
	</form>
</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/return/add.js" type="text/javascript"></script>
</body>
</html>
