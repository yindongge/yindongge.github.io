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
<title>企业会员管理</title>
</head>
<body>	
<div class="page-wrapper goods-control">
<div class="container-fluid">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">会员</a></li>
		<li class="active"><a href="#">企业会员管理</a></li>
	</ul>
	<form id="pageform" name="pageform"  class="form-inline" method="post" action="${ctx}/user/list">
	<div class="breadcrumb breadcrumb-title">关联企业的个人用户</div>
	<table class="table table-hover table-bordered ">
		<thead>
			<tr>
				<th>用户名</th>
				<th>手机号</th>
				<th>邮箱</th>
				<th>状态</th>
				<th>会员类型</th>
				<th>注册时间</th>
				<th>登录时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${page}" varStatus="status">
			<tr>
				<td>${item.userName}</td>
				<td>${item.mobilePhone}</td>
				<td>${item.email}</td>
				<td><c:if test="${item.status==0}">正常</c:if><c:if test="${item.status==1}">锁定</c:if></td>
				<td>
					关联企业
				</td>
				<td><fmt:formatDate value="${item.regTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td><fmt:formatDate value="${item.lastLogin}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		</form>
	</div>
</div>

<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/user/enterpriseUserlist.js" type="text/javascript"></script>
</body>
</html>
