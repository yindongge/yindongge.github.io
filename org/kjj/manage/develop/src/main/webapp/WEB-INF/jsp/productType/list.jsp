<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
<title>商品类型</title>
<%@include file="../common/common_css.jsp" %>
</head>
<body>	
	<div class="page-wrapper">
	<form class="form-inline long" id="pageform" action="${ctx}/productType/list" method="post">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li>您的位置</li>				
				<li class="active">类型管理</li>
			</ul>
			<div class="icon1 text-center"> 
				<div class="form-group">
					<button type="button" class="btn btn-danger btn-click" onclick="addType();">
					添加类型
					</button>
				</div>
				<div class="form-group">
					<button type="button" class="btn btn-danger btn-click" onclick="window.location.href='${ctx}/productTypeGroup/list'">
					添加分组
					</button>
				</div>
				<div class="form-group">
					<select class="form-control" name="groupId">
						<option value="">选择类型分组</option>
						<c:forEach items="${groupList}" var="item">						 	 
							<option value="${item.groupId }" <c:if test="${item.groupId == query.groupId }">selected</c:if>> ${item.orgproductTypeGroupName }</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<input type="text" class="form-control" name="typeName" value="${query.typeName }"></input>
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-primary btn-sm " value="搜索"></input>
				</div>
			</div>
			<table class="table table-bordered table-hover borded-striped table-control">
				<thead>
					<tr class="info text-center">
						<th class="length">类型名称</th>
						<th >类型分组</th>			
						<th>排序</th>
						<th>状态</th>
						<th>属性数量</th>
						<th>操作</th>
					</tr>
				</thead>
				<c:forEach items="${page.content}" var="item">
					<tr>
						<td>${item.typeName }</td>
						<td>${item.groupName } </td>
						<td>${item.typeOrder }</td>
						<td>${item.isActive==1?'是':'否' }</td>
						<td>${item.propertyNum}</td>
						<td>
							<button type="button" class="btn btn-danger btn-go btn-click" onclick="editView(${item.typeId});">编辑</button>
							<button type="button" class="btn btn-danger btn-go " onclick="deleteType(${item.typeId});">删除</button>
							<button type="button" class="btn btn-danger btn-go " onclick="viewType(${item.typeId});">预览</button>
						</td>
					</tr>
				</c:forEach>
			</table>
			<nav class="navbar navbar-default select-control" >
				<%@include file="../common/common_page.jsp" %>	
			</nav>
		</div>	
	</form>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/productType/list.js" type="text/javascript"></script>
</body>
</html>