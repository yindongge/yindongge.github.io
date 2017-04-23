<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<%@include file="../common/common_css.jsp"%>
<title>商品分类</title>
</head>
<body>	
<div class="page-wrapper">
<div class="container-fluid">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a >设置</a></li>
		<li class="active">管理员设置</li>
	</ul>
	<form  class="form-inline" id ="pageform" name ="pageform" action="${ctx}/admin/list"  method="post">
		<div class="well" style="padding:5px;">
				<div class="form-group">
					<label>用户名：</label>
					<input type="text" class="form-control" id="userNameLike" name="userNameLike" value="${query.userNameLike}"/>
					<label>手机号码：</label>
					<input type="text" class="form-control" id="mobileLike" name="mobileLike" value="${query.mobileLike}"/>			
				</div>
				<button type="submit" class="btn btn-danger">搜索</button>
		</div>
		<div class="breadcrumb breadcrumb-title">管理员列表<button type="button" class="btn btn-danger" onclick="window.location.href='${ctx}/admin/addInit' ">添加管理员</button></div>
		<table class="table table-hover table-bordered ">
			<thead>
				<tr>
					<th>用户名</th>
					<th>手机号</th>
					<th>加入时间</th>
					<th>最后登录时间</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				
			</thead>
			<tbody>
			<c:forEach var="item" items="${page.content}" varStatus="status">
			 	<tr>
					<td>${item.userName}</td>
					<td>${item.email}</td>
					<td><fmt:formatDate value="${item.addTime}" type="both"/> </td>
					<td><fmt:formatDate value="${item.lastLogin}" type="both"/> </td>
					<td>
						<c:if test="${item.status == 0}">正常</c:if>
						<c:if test="${item.status == 1}">锁定</c:if>
					</td>
					<td>
						<a type="button" href="${ctx}/admin/editInit/${item.userId}" class="btn btn-danger btn-go btn2-click" >编辑</a>
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
</body>
</html>
