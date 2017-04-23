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
	<title>会员管理</title>
</head>

<body>
<div class="page-wrapper">
<div class="container-fluid">
	<form  class="form-inline" id ="pageform" name ="pageform" action="${ctx}/accountGroup/groupList" method="post">
		<ul class="breadcrumb">
			<li>您的位置</li>
			<li ><a href="#">会员</a></li>
			<li class="active">充值用户组</li>
		</ul>
		<div style="padding:10px;background:#f5f5f5;" style="">
			<div class="form-group">
				<label>创建时间：</label>
				<input class="form-control date" id="createTimeStart" name="createTimeStart" type="text" value='<fmt:formatDate value="${query.createTimeStart}" pattern="yyyy-MM-dd HH:mm:ss"/>' style="width:150px"/>
				至
				<input class="form-control date" id="createTimeEnd" name="createTimeEnd" type="text" value='<fmt:formatDate value="${query.createTimeEnd}" pattern="yyyy-MM-dd HH:mm:ss"/>' style="width:150px"/>				
			</div>
			<div class="form-group" style="margin-left:20px">
				<label>用户组名称：</label>
				<input class="form-control" name="groupNameLike" type="text" value="${query.groupNameLike}"/>	
				<button type="button"  class="btn btn-info btn-sm" style="margin-left:80px" onclick="doQuery()">搜索</button>		
			</div>
		</div>
		<div class="breadcrumb breadcrumb-title">用户组列表<button type="button" class="btn btn-danger"  onclick="doAdd()">新增组</button></div>
		<table class="table table-hover table-bordered table-striped table-4">
			<thead>
				<tr class="info">
					<th>用户组名称</th>
					<th>创建时间</th>
					<th style="width:240px;">操作</th>
				</tr>
			</thead> 
			<tbody>
				<c:forEach var="item" items="${page.content}" varStatus="status">
				<tr  class="icon11 zhekoutext">
					<td>${item.groupName}</td>
					<td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>
					    <button type="button" onclick="doManage('${item.groupId}')" class="btn btn-danger btn-xs">管理用户</button>
						<button type="button" onclick="doEdit('${item.groupId}','${item.groupName}')" class="btn btn-danger btn-xs">修改</button>
					    <button type="button" onclick="doDelete('${item.groupId}')" class="btn btn-danger btn-xs">删除</button>
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
<script src="${jsBase}/account/groupList.js" type="text/javascript"></script>
</body>
</html>
