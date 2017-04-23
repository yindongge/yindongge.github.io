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
<title>限时折扣管理</title>
</head>
<body>
<div class="page-wrapper goods-control">
<div class="container-fluid">
<form id ="pageform" name ="pageform" class="form-inline" action="${ctx}/limitTimeDiscount/list" method="post">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">运营</a></li>
		<li class="active">限时折扣管理</li>
	</ul>
	<div class="well" style="padding:5px;">
			<div class="form-group">
				<label>活动名称：</label>
				<input type="text" class="form-control" name="nameLike" value="${query.nameLike}"/>			
			</div>
			<div class="form-group">
				<label>所有：</label>
				<select class="form-control" name="status">
					<option value="" <c:if test="${empty query.status}">selected</c:if>>全部</option>
					<option value="1" <c:if test="${ query.status=='1' }">selected</c:if>>有效</option>
					<option value="0" <c:if test="${ query.status=='0' }">selected</c:if>>无效</option>
				</select>		
			</div>		
			<button type="submit" class="btn btn-danger">搜索</button>
	</div>
	<br/>
	
	<a role="button" class="btn btn-danger" href="${ctx}/limitTimeDiscount/addInit">添加限时折扣</a>
	
	<table class="table table-hover table-bordered ">
		<thead>
			<tr>
				<th>活动名称</th>
				<th>日期</th>
				<th>时刻</th>
				<th>适用范围</th>
				<th>状态</th>
				<th width="300px;">操作</th>
			</tr>
			
		</thead>
		<tbody>
			<c:forEach var="item" items="${page.content}" varStatus="status">
			<tr>
				<td>${item.name}</td>
				<td><fmt:formatDate value="${item.startDate}" type="date"/>~<fmt:formatDate value="${item.endDate}" type="date"/></td>
				<td><fmt:formatDate value="${item.startTime}" type="time"/>~<fmt:formatDate value="${item.endTime}" type="time"/></td>
				<td>
					<c:if test="${item.shopType==1}"><span>全部区域</span></c:if>
					<c:if test="${item.shopType==2}"><span>单区域</span></c:if>
					<c:if test="${item.shopType==3}"><span>部分门店</span></c:if>
				</td>
				<td>
					<c:if test="${item.status==1}"><span>有效</span></c:if>
					<c:if test="${item.status==0}"><span>无效</span></c:if>
				</td>
				<td>	
					<!-- <button type="button" class="btn btn-danger btn-xs detail" data-id="${item.id}">查看</button> -->
					<button type="button" class="btn btn-danger btn-xs pause" data-id="${item.id}"><c:if test="${item.status==0}">启用</c:if><c:if test="${item.status==1}">停用</c:if></button>
					<button type="button" class="btn btn-danger btn-xs edit" data-id="${item.id}">编辑</button>
					<button type="button" class="btn btn-danger btn-xs select" data-id="${item.id}">活动商品</button>
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
<script src="${jsBase}/limitTimeDiscount/list.js" type="text/javascript"></script>
</body>
</html>
