<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<%@include file="../common/common_css.jsp" %>
<link href="${cssBase}/zTreeStyle.css" type="text/css" rel="stylesheet"/>

</head>
<body>	
<div class="page-wrapper goods-control">
<div class="container-fluid">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a>设置</a></li>
		<li ><a href="${ctx}/role/list">角色管理</a></li>
		<li class="active">编辑角色</li>
	</ul>
	<br/>
	<form id="roleForm" method="post">
		<input type="hidden" name="modelid" id="modelid"/>
		<input type="hidden" name="roleId" id="roleId" value="${obj.roleId}"/>
		<table class="table table-hover table-bordered ">
			<tbody>
				<tr>
					<td>*角色名称</td>
					<td style="text-align:left; "><input type="text" id="roleName" name="roleName" value="${obj.roleName}"
					required data-bv-notempty-message="角色名称不能为空"/></td>
				</tr>
				<tr>
					<td>角色备注</td>
					<td style="text-align:left;  "> 	
						<textarea rows="5" style="width:35%" name="remarkname" >${obj.remarkname}</textarea>
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
<script src="${jsBase}/role/edit.js" type="text/javascript"></script>
</body>
</html>
