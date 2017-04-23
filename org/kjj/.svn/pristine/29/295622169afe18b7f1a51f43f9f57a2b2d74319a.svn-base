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
<div class="page-wrapper">
<div class="container-fluid">
	<form id="pageform" name="pageform"  class="form-inline" method="post" action="${ctx}/user/oneSelect">
	<div class="well" style="padding:5px;">
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
		<div class="form-group">
			<label>会员名称：</label>
			<input type="text" name="userNameLike" value="${query.userNameLike}"/>
			<button type="submit"  class="btn btn-info btn-sm ">搜索</button>
		</div>
		</div>
	
	<br/>
	<div class="breadcrumb breadcrumb-title">会员列表 </div>
	<table class="table table-hover table-bordered ">
		<thead>
			<tr>
			    <th></th>
				<th>用户名</th>
				<th>手机号</th>
				<th>邮箱</th>
				<th>会员类型</th>
				<th>会员级别</th>
				<th>状态</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${page.content}" varStatus="status">
			<tr>
			    <td>
			    	<button type="button" class="btn btn-danger"  onclick="doSingleSelect('${item.userId}','${item.userName}')">选择</button>
			    </td>
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
<script src="${jsBase}/user/list.js" type="text/javascript"></script>
</body>
</html>
