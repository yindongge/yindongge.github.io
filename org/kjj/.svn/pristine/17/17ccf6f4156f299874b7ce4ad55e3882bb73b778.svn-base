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
<title>专题活动列表页面</title>
</head>
<body>
	<div class="page-wrapper">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li class="active">您的位置</li>
				<li class="active">专题活动</li>
				<li class="active">列表页面</li>
			</ul>
		<form class="form-inline clear-control" id ="pageform"  action="${ctx}/special/list" method="post">
		<!--搜索-->	
		<div style="padding:10px;height:50px;background:#f5f5f5;">
			<div class="form-group">
				<label>活动名称：</label>
				<input name="specialNameLike" value ="${query.specialNameLike}" type="text"  class="form-control"/>
			</div>
			<%-- 
			<div class="form-group">
				<label for="">活动状态:</label>
				<select name="status"  class="form-control">
					<option value="">全部</option>
					<option value="1" <c:if test="${query.status==1}">selected</c:if>>已启用</option>
					<option value="0" <c:if test="${query.status==0}">selected</c:if>>已停用</option>
				</select>
			</div>
			 --%>
			<button type="submit" class="btn btn-info">搜索</button>
		</div>
		<!--列表-->	
		<div class="breadcrumb breadcrumb-title">列表管理
			<a type="button" class="btn btn-danger pull-right" href="${ctx}/special/add">添加活动专题</a>
		</div>
		<table class="table table-bordered table-hover borded-striped table-control">
		    <thead>
				<tr class="info text-center">
					<th>编号</th>
					<th>专题名称</th>
					<th>星期循环</th>
					<th>时刻设置</th>
					<th>有效日期</th>
					<th>预览</th>
					<!-- <th>是否启用</th> -->
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach var="item" items="${page.content}" varStatus="status">
				<tr>
					<td>${page.number*page.size+status.index+1}</td>
					<td>${item.specialName}</td>
					<td>
						<c:set var="weeks" value="${item.weeks}"/>
						<c:if test="${fn:contains(weeks, '2')}">一</c:if>
						<c:if test="${fn:contains(weeks, '3')}">二</c:if>
						<c:if test="${fn:contains(weeks, '4')}">三</c:if>
						<c:if test="${fn:contains(weeks, '5')}">四</c:if>
						<c:if test="${fn:contains(weeks, '6')}">五</c:if>
						<c:if test="${fn:contains(weeks, '7')}">六</c:if>
						<c:if test="${fn:contains(weeks, '1')}">日</c:if>
					</td>
					<td><fmt:formatDate value="${item.orgSpecialTime.timeStart}" pattern="HH:mm:ss"/> 至 <fmt:formatDate value="${item.orgSpecialTime.timeEnd}" pattern="HH:mm:ss"/></td>
					<td><fmt:formatDate value="${item.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/> 至 <fmt:formatDate value="${item.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>
						<c:if test="${item.scope==1}">
							<a href="${frontPath}/special/show/${item.specialId}" target="_blank">点击预览</a>
						</c:if>
						<c:if test="${item.scope==2}">
							<a href="${wxPath}/special/show/${item.specialId}" target="_blank">点击预览</a>
						</c:if>
					</td>
					<!-- 
						<td>
							<c:if test="${item.status eq 1}">已启用</c:if>
							<c:if test="${item.status ne 1}">已停用</c:if>
						</td>
					 -->
					<td data-id="${item.specialId}">
						<!-- 
							<c:if test="${item.status ne 1}">
								<a class="btn btn-success btn-xs" >启用</a>
								<a class="btn btn-danger btn-xs" style="display:none;">停用</a>
							</c:if>
							<c:if test="${item.status eq 1}">
								<a class="btn btn-success btn-xs" style="display:none;">启用</a>
								<a class="btn btn-danger btn-xs">停用</a>
							</c:if>
						 -->
						<a class="btn btn-info btn-xs" href="${ctx}/special/edit/${item.specialId}" >编辑</a>
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
<script src="${jsBase}/special/list.js" type="text/javascript"></script>
</body>
</html>
