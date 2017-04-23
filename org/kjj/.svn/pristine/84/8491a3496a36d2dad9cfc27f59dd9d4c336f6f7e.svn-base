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
<form id ="pageform" name ="pageform" class="form-inline" action="${ctx}/coupon/triggerList" method="post">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">运营</a></li>
		<li ><a href="${ctx}/coupon/list">优惠券管理</a></li>
		<li class="active">触发券管理</li>
	</ul>
	<div class="well" style="padding:5px;">
		<div class="form-group">
			<label>优惠劵名称：</label>
			<input type="text" class="form-control" id="couponNameLike" name="couponNameLike" value="${query.couponNameLike}"/>			
		</div>
		<div class="form-group">
			<label>状态：</label>
			<select class="form-control" name="status">
				<option value="" <c:if test="${empty query.status}">selected</c:if>>全部</option>
				<option value="0" <c:if test="${ query.status=='0' }">selected</c:if>>有效</option>
				<option value="1" <c:if test="${ query.status=='1' }">selected</c:if>>无效</option>
			</select>	
		</div>
		<button type="submit" class="btn btn-danger">搜索</button>
		</div>
	<br/>
	
	<div class="group-button">
		<a role="button" class="btn btn-default" href="${ctx}/coupon/list">优惠劵</a>
		<a role="button" class="btn btn-default" href="${ctx}/coupon/listRecord">发放领取记录</a>
		<a role="button" class="btn btn-primary" href="${ctx}/coupon/triggerList">触发券管理</a>
		
	</div>
	<table class="table table-hover table-bordered table-4">
		<thead>
			<tr class="info">
				<th style="width:30%">优惠劵</th>
				<th>触发条件</th>
				<th>每人发放张数</th>
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
							<fmt:formatNumber type="currency" pattern="0.00" value="${item.orgCoupon.discountMoney}"/>
						</div>
					</div>
				</a>
				<span>${item.orgCoupon.couponName}</span>
				<span>满<fmt:formatNumber type="currency" pattern="0.00" value="${item.orgCoupon.conditionMoney}"/>减<fmt:formatNumber type="currency" pattern="0.00" value="${item.orgCoupon.discountMoney}"/></span>
				<span>
					<c:if test="${item.orgCoupon.productType==1}">全场商品</c:if>
					<c:if test="${item.orgCoupon.productType==2}">指定分类</c:if>
					<c:if test="${item.orgCoupon.productType==3}">指定商品</c:if>
					<c:if test="${item.orgCoupon.shopType==1}">全部区域</c:if>
					<c:if test="${item.orgCoupon.shopType==2}">单区域</c:if>
					<c:if test="${item.orgCoupon.shopType==3}">部分门店</c:if>
				</span>
				<span>
					<fmt:formatDate value="${item.orgCoupon.startTime}" type="both"/>~
					<fmt:formatDate value="${item.orgCoupon.endTime}" type="both"/>
				</span>
				</td>
				<td class="blockspan2">
					<c:if test="${item.triggerType==1}">
						<span>限时注册</span>
						<span> <fmt:formatDate value="${item.orgCoupon.startTime}" type="both"/>~<fmt:formatDate value="${item.orgCoupon.endTime}" type="both"/></span>
					</c:if>
				</td>
				<td class="blockspan2">
					<span>${item.triggerAmount}</span>
				</td>
				<td>
					<c:if test="${item.status==0}"><span>有效</span></c:if>
					<c:if test="${item.status==1}"><span>无效</span></c:if>
				</td>
				<td>
					<button type="button" class="btn btn-danger btn-xs pause" data-id="${item.id}"><c:if test="${item.status==0}">暂停</c:if><c:if test="${item.status==1}">恢复</c:if></button>
					<button type="button" class="btn btn-danger btn-xs delete" data-id="${item.id}">删除</button>
					<button type="button" class="btn btn-danger btn-xs edit" data-id="${item.id}">编辑</button>
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
<script src="${jsBase}/coupon/triggerList.js" type="text/javascript"></script>
</body>
</html>
