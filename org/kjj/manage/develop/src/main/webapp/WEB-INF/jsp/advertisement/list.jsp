<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
<title>热门推荐</title>
<%@include file="../common/common_css.jsp"%>
</head>
<body>	
	<div class="page-wrapper">
	<input type="hidden" name="pageNow" value="${page.number }"/>
	<form class="form-inline long" id="pageform" action="${ctx}/advertisement/list" method="post">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li>您的位置</li>	
				<li ><a href="#">商品</a></li>			
				<li class="active">热门推荐</li>
			</ul>
		 	<div class="icon1 text-center"> 
				<div class="form-group">
					<label>一级分类：</label>
					<select class="form-control" name="classLevel1" id="classLevel1">
						<option value="-1">请选择</option>
						<c:forEach items="${classLevle1List}" var="item">
							<option value="${item.classId }" <c:if test="${item.classId == query.classLevel1}">selected="selected"</c:if>>${item.className }</option>									
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label>二级分类：</label>
					<select class="form-control" name="classLevel2" id="classLevel2">
						<option value="-1">请选择</option>
						<c:forEach items="${classLevle2List}" var="item">
							<option value="${item.classId }" <c:if test="${item.classId == query.classLevel2}">selected="selected"</c:if>>${item.className }</option>									
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
				<input type="submit" class="btn btn-primary btn-sm " value="搜索"></input>
				</div>
			</div>
			<div class="icon1"> 
				<button type="button" class="btn btn-danger btn-click" onclick="window.location.href='${ctx}/advertisement/add'">
				添加推荐
				</button>
			</div>
			<table class="table table-bordered table-hover borded-striped table-control">
				<thead>
					<tr class="info text-center">
						<th class="length">分类名称</th>
						<th >类型名称</th>			
						<th>操作</th>
					</tr>
				</thead>
				<c:forEach items="${page.content }" var="item">
					<tr>
						<td>
							<c:if test="${item.productClassId == -1 }">
								默认
							</c:if>
							<c:if test="${item.productClassId != -1 }">
								${item.productClassName }
							</c:if>
						</td>
						<td>${item.advertisementTypeName }</td>
						<td>
							<input type="hidden" name="id" value="${item.advertisementId }"/>
							<button type="button" class="btn btn-danger btn-go btn-click" name="editBtn">编辑</button>
							<button type="button" class="btn btn-danger btn-go " name="deleteBtn">删除</button>
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
<script src="${jsBase}/advertisement/list.js" type="text/javascript"></script>
</body>
</html>