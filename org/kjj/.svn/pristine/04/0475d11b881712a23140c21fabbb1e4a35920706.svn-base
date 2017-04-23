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
<title>品牌管理</title>
</head>
<body >
	<div class="page-wrapper">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li>您的位置</li>
				<li ><a href="#">商品</a></li>
				<li class="active">品牌管理</li>
			</ul>
			<form class="form-inline clear-control" id ="pageform" name ="pageform" action="${ctx}/brand/list" method="post">
				<a class="btn btn-danger" role="button" href="javascript:void(0);" id="addBtn">添加品牌</a>
				<button type="submit" class="btn btn-info pull-right">搜索</button>
				<div class="form-group pull-right ">
					<label >类别：${classLevel }</label>
					<select class="form-control"  id="classLevel" name="classLevel">
						<option value="-1">请选择</option>
					   	<c:forEach var="item" items="${classLevelList}" varStatus="status">
					 	<option value="${item.classLevelId}" <c:if test="${query.classLevel==item.classLevelId }">selected</c:if> >${item.classLevelname}</option>
					 	</c:forEach>
					</select>
					<select class="form-control"  id="classId" name ="classId">
					   	<c:forEach var="item" items="${classList}" varStatus="status">
					 		<option value="${item.classId}" <c:if test="${query.classId==item.classId }">selected</c:if> >${item.className}</option>
					 	</c:forEach>
					</select>
				</div>
				<div class="form-group pull-right">
					<label  for="exampleInputEmail3">品牌名称：</label>
					<input type="text" class="form-control" id="productBrandName" name="productBrandName" value="${query.productBrandName }" placeholder="Enter "/>
				</div>		    
			</br>
		<!--分割线-->	
				<div class="breadcrumb breadcrumb-title">品牌管理</div>
				<table class="table table-bordered table-hover borded-striped table-control table-icon6-control">
					<thead>
						<tr class="info text-center">
							<th>品牌名称</th>
							<th class="length">所属分类</th>
							<th>排序</th>
							<th>状态</th>
							<th>商品数量</th>
							<th>品牌LOGO</th>
							<th>推荐</th>
							<th >操作</th>
						</tr>
					</thead>					
					<c:forEach var="item" items="${page.content}" varStatus="status">
					<tr>
						<td>${item.productBrandName}</td>
						<td>${item.brandTypeStr}</td>
						<td>${item.brandOrder}</td>
						<td>是</td>
						<td>${item.brandProductCount}</td>
						<td class="icon6"><img width="30" src="${item.productBrandLogoimage}"></img></td>
						<td>暂无</td>
						<td>
							<input type="hidden" name="id" value="${item.productBrandId }"/>
							<button type="button" href="javascript:void(0);" class="btn btn-danger btn-go btn2-click" name="editBtn">编辑</button>
							<button type="button" href="javascript:void(0);" class="btn btn-danger btn-go" name="deleteBtn">删除</button>
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
<script src="${jsBase}/brand/list.js" type="text/javascript"></script>
</body>
</html>
