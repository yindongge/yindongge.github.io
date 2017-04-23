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
		<li ><a >设置</a></li>
		<li ><a href="${ctx}/admin/list">用户管理</a></li>
		<li class="active">编辑用户</li>
	</ul>
	<br/>
	
	<form id="adminForm" method="post">
		<input type="hidden" name="modelIds" id="modelIds"></input>
		<input type="hidden" name="shopIds" id="shopIds"></input>
		<input type="hidden" name="roleIds" id="roleIds"></input>
		<input type="hidden" name="userId" id="userId" value="${obj.userId}"></input>
		<input type="hidden" name="emailOld" id="emailOld" value="${obj.email}"></input>
			
		<table class="table table-hover table-bordered ">
			<tbody>
				<tr>
					<td>*用户名</td>
					<td style="text-align:left; "> <input type="text" name="userName" id="userName" value="${obj.userName}"/></td>
				</tr>
				<tr>
					<td>*密码</td>
					<td style="text-align:left;  "> 	
						<input rows="5" style="width:35%" name="password" id="password" value="${obj.password}"/>
					</td>
				</tr>
				
				<tr>
					<td>*手机号</td>
					<td style="text-align:left;  "> 	
						<input rows="5" style="width:35%" name="email" id="email" value="${obj.email}"/>
					</td>
				</tr>
				
				<tr>
					<td>状态</td>
					<td style="text-align:left;  "> 	
						<select class="form-control" name="status" style="width:20%">
							<option <c:if test="${obj.status==0}">selected="selected"</c:if> value="0" >正常</option>
							<option <c:if test="${obj.status==1}">selected='selected'</c:if> value="1">锁定</option>
						</select>
					</td>
				</tr>
				
				<tr>
				<td>角色</td>
					<td  style="text-align:left; padding-left:20px;"> 	
						<div class="zTreeDemoBackground left">
							<ul id="roletree" class="ztree"></ul>
						</div>
					</td>
				</tr>
				
				<tr>
					<td>店铺</td>
					<td  style="text-align:left; padding-left:20px;"> 	
						<div class="zTreeDemoBackground left">
							<ul id="shoptree" class="ztree"></ul>
						</div>
					</td>
				</tr>
				
				<tr>
					<td>分配权限:</td>
					<td  style="text-align:left; padding-left:20px;"> 
						<div class="zTreeDemoBackground left">
							<ul id="treeDemo" class="ztree"></ul>
						</div>
					
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<p class="text-center buttonme"><button class="btn btn-danger" onclick="saveRole();">保存</button><button onclick="javascript:history.go(-1)" type="button" class="btn btn-default">返回</button></p>
</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/admin/edit.js" type="text/javascript"></script>
</body>
</html>
