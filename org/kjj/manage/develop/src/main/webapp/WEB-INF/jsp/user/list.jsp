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
<body>	
<div class="page-wrapper goods-control">
<div class="container-fluid">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">会员</a></li>
		<li class="active"><a href="#">会员管理</a></li>
	</ul>
	<form id="pageform" name="pageform"  class="form-inline" method="post" action="${ctx}/user/list">
	<div class="well" style="padding:5px;">
		<div class="form-group">
			<label>开始时间：</label>
			<input class="form-control date" id="regTimeStart" name="regTimeStart" type="text" value="<fmt:formatDate value="${query.regTimeStart}" pattern="yyyy-MM-dd HH:mm:ss" />"/>			
		</div>
		<div class="form-group">
			<label>结束时间：</label>
			<input class="form-control date" id="regTimeEnd" name="regTimeEnd" type="text" value="<fmt:formatDate value="${query.regTimeEnd}" pattern="yyyy-MM-dd HH:mm:ss" />"/>			
		</div>
		<div class="form-group">
			<label>邮箱:</label>
			<input name="emailLike" type="text" class="form-control" value="${query.emailLike}"/>			
		</div>
		<div class="form-group">
			<label>手机号:</label>
			<input name="mobileLike" type="text" class="form-control" value="${query.mobileLike}"/>			
		</div>
		
		<br/>
		
		<div class="form-group radio-special2">
			<label>会员状态：</label>
			<input type="radio" name="status" value="" <c:if test="${empty query.status}">checked</c:if>/>全部
			<input type="radio" name="status" value="0" <c:if test="${query.status==0}">checked</c:if>/>正常
			<input type="radio" name="status" value="1" <c:if test="${query.status==1}">checked</c:if>/>锁定
		</div>
		<div class="form-group" style="margin-left:22px">
			<label>会员名称：</label>
			<input type="text" class="form-control" name="userNameLike" value="${query.userNameLike}"/>
		</div>
		<div class="form-group">
			<label>会员级别：</label>
			<select class="form-control" name="levelId">
				<option value="">全部</option>
				<c:forEach items="${levelList}" var="level">
					<option value="${level.levelId }" <c:if test="${query.levelId==level.levelId}">selected</c:if>>${level.levelName}</option>
				</c:forEach>
			</select>
			<button type="submit"  class="btn btn-info btn-sm ">搜索</button>
		</div>
		</div>
	
	<br/>
	<table class="table table-hover table-bordered ">
		<thead>
			<tr>
				<th>用户名</th>
				<th>手机号</th>
				<th>邮箱</th>
				<th>会员类型</th>
				<th>会员级别</th>
				<th>注册时间</th>
				<th>登录时间</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${page.content}" varStatus="status">
			<tr>
				<td>${item.userName}</td>
				<td>${item.mobilePhone}</td>
				<td>${item.email}</td>
				<td>
					<c:if test="${item.levelType==1}">个人用户</c:if>
					<c:if test="${item.levelType==2}">企业用户</c:if>
					<c:if test="${item.levelType==3}">关联企业用户</c:if>
				</td>
				<td>
					${item.levelName}
				</td>
				<td><fmt:formatDate value="${item.regTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td><fmt:formatDate value="${item.lastLogin}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td><c:if test="${item.status==0}">正常</c:if><c:if test="${item.status==1}">锁定</c:if></td>
				<td>
					<button type="button" onclick="desc(${item.userId})" class="btn btn-danger btn-xs">查看详情</button>
					<c:if test="${item.status ne 1}"><button type="button" onclick="lock(${item.userId})" class="btn btn-danger btn-xs">锁定</button></c:if>
					<c:if test="${item.status eq 1}"><button type="button" onclick="unLock(${item.userId})" class="btn btn-danger btn-xs">解锁</button></c:if>
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
<script src="${jsBase}/user/list.js" type="text/javascript"></script>
</body>
</html>
