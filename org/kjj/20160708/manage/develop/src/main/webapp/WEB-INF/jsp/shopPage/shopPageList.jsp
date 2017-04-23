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
<title>店铺管理</title>
</head>

<body >

	<div class="page-wrapper">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li>您的位置</li>
				<li ><a href="#">店铺</a></li>
				<li class="active">店铺首页管理</li>
			</ul>
		<form class="form-inline clear-control" id ="pageform" name ="pageform" action="${ctx}/shopPage/list" method="post">
		<div style="padding:10px;height:50px;background:#f5f5f5;">
			<div class="form-group">
				<label>区域/店铺名称：</label>
				<input type="text" class="form-control" id="shopNameLike" name="shopNameLike" value="${query.shopNameLike}"/>
			</div>
			
			<button type="submit" class="btn btn-info">搜索</button>
		</div>
		<!--分割线-->	
		<div class="breadcrumb breadcrumb-title">店铺首页管理<button type="button" class="btn btn-danger pull-right" onclick="doAdd()">添加首页</button></div>
		<table class="table table-bordered table-hover borded-striped table-control">
		    <thead>
				<tr class="info text-center">
					<th>编号</th>
					<th>区域/店铺名称</th>
					<th>热门搜索</th>
					<th>是否启用</th>
					<th>操作</th>
				</tr>
			</thead>
			
			<c:forEach var="item" items="${page.content}" varStatus="status">
			 	
			<tr>
				<td>${item.id}</td>
				<td>
					${item.shopname}
					<c:if test="${item.shopId == -1}">全部店铺</c:if>
				</td>
				<td>${item.shopSearch}</td>
				<td><c:if test="${item.isactive == 0}">否</c:if><c:if test="${item.isactive == 1}">是</c:if></td>
				<td>
					<a type="button" onclick="doEdit('${item.id}');" class="btn btn-danger btn-go btn2-click" >编辑</a>
					<a type="button" onclick="doDelete('${item.id}');"  class="btn btn-danger btn-go ">删除</a>
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
<script src="${jsBase}/shopPage/shopPageList.js" type="text/javascript"></script>
</body>
</html>
