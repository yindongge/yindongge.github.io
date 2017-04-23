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
<title>角色管理</title>
</head>

<body >

	<div class="page-wrapper">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li>您的位置</li>
				<li ><a href="#">设置</a></li>
				<li class="active">角色管理</li>
			</ul>
	<form class="form-inline clear-control" id ="pageform" name ="pageform" action="${ctx}/role/list" method="post">
	<a class="btn btn-danger" role="button" href="${ctx}/role/addInit">添加角色</a>
		
	<br/>
<!--分割线-->	
		<div class="breadcrumb breadcrumb-title">角色管理</div>
		<table class="table table-bordered table-hover borded-striped table-control table-icon6-control">
			<thead>
				<tr class="info text-center">
					<th>角色名称</th>
					<th >角色备注</th>
					<th>创建时间</th>
					<th >操作</th>
				</tr>
			</thead>
			
			 <c:forEach var="item" items="${page.content}" varStatus="status">
			 	<tr>
				<td>${item.roleName}</td>
				<td>${item.remarkname}</td>
				<td><fmt:formatDate value="${item.creattime}" type="both"/> </td>
				<td>
					<a type="button" href="${ctx}/role/editInit/${item.roleId}" class="btn btn-danger btn-go btn2-click" >编辑</a>
					<a type="button" href="javascript:delRole(${item.roleId});" class="btn btn-danger btn-go ">删除</a>
				</td>
			</tr>
			 </c:forEach>
		</table>
		<nav class="navbar navbar-default select-control" >
			<%@include file="../common/common_page.jsp" %>		
		</nav>
</form>
</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/role/list.js" type="text/javascript"></script>
</body>
</html>
