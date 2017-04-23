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
	<form  class="form-inline" id ="pageform" name ="pageform" action="${ctx}/accountGroup/groupUserList" method="post">
	    <input type="hidden" id="groupId" name="groupId" value="${group.groupId}"/>
		<ul class="breadcrumb">
			<li>您的位置</li>
			<li ><a href="#">会员</a></li>
			<li class="active">充值用户组</li>
		</ul>
		<div style="padding:10px;background:#f5f5f5;" style="">
			<div class="form-group">
				<label>用户名：</label>
				<input type="text" name="userName" value="${query.userName}"/>				
			</div>
			<div class="form-group" style="margin-left:20px">
				<label>手机号：</label>
				<input class="form-control" name="mobilePhone" type="text" value="${query.mobilePhone}"/>
				<button type="submit"  class="btn btn-info btn-sm" style="margin-left:80px">搜索</button>		
			</div>
		</div>
		<div class="breadcrumb breadcrumb-title">${group.groupName}-用户列表 
		    <button type="button" class="btn btn-danger" style="margin-right:390px" onclick="doDeletes()">删除</button>
			<button type="button" class="btn btn-danger"  style="margin-right:296px"  onclick="importUser()">添加用户</button>
			<button type="button" class="btn btn-danger"  style="margin-right:135px"  onclick="importEnterpriseUser()">从企业关联用户添加</button>
			<button type="button" class="btn btn-danger"   onclick="doCancel()">返回用户组列表</button></div>
		<table class="table table-hover table-bordered table-striped table-4">
			<thead>
				<tr class="info">
				    <th><input type="checkbox" id="selectAll"/>全选</th>
					<th>用户名</th>
					<th>手机号</th>
					<th>邮箱</th>
					<th>会员类型</th>
					<th>注册时间</th>
					<th>状态</th>
				</tr>
			</thead> 
			<tbody>
				<c:forEach var="item" items="${page.content}" varStatus="status">
				<tr class="icon11 zhekoutext">
				    <td><input type="checkbox" name="userIds"  id="userIds" style="margin-top:2px; " value="${item.userId}"/></td>
					<td>${item.userName}</td>
					<td>${item.mobilePhone}</td>
					<td>${item.email}</td>
					<td>
						<c:if test="${item.levelType==1}">个人用户</c:if>
						<c:if test="${item.levelType==2}">企业用户</c:if>
						<c:if test="${item.levelType==3}">关联企业用户</c:if>
					</td>
					<td><fmt:formatDate value="${item.regTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td><c:if test="${item.status==0}">正常</c:if><c:if test="${item.status==1}">锁定</c:if></td>
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
<script src="${jsBase}/account/groupUserList.js" type="text/javascript"></script>
</body>
</html>
