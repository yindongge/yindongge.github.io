<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<%@include file="../common/common_css.jsp"%>
<link href="${cssBase}/zTreeStyle.css" type="text/css" rel="stylesheet"/>
</head>
<body>	
<div class="page-wrapper goods-control">
<div class="container-fluid">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li class="active">修改密码</li>
	</ul>
	<br/>
	
	<form id="adminForm" method="post">
		<input type="hidden" name="userId" id="userId" value="${userId}"></input>
		<table class="table table-hover table-bordered ">
			<tbody>
			<tr>
				<td width="300px">* 原密码：</td>
				<td colspan="4"><input type="password" id="oldPassword" name="oldPassword"/><span id="sppassword"></span></td>
			</tr>
			<tr>
				<td width="300px">* 新密码：</td>
				<td colspan="4"><input type="password" id="password" name="password"/><span id="newpassword"></span></td>
			</tr>
			<tr>
				<td width="300px">* 新密码确认：</td>
				<td colspan="4"><input type="password" id="password2" name="password2"/><span id="confirmPass"></span></td>
			</tr>
		</tbody>
		</table>
	</form>
	<p class="text-center buttonme"><button id="btnEdit" type="button" class="btn btn-danger">修改</button></p></br>
	<p class="text-center buttonme" id="tip"></p>
	
</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/admin/editPassword.js" type="text/javascript"></script>
</body>
<style>
	span{position:absolute;}
</style>
</html>
