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
</head>
<body>	
<div class="page-wrapper goods-control">
<div class="container-fluid">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">文章</a></li>
		<li class="active"><a href="#">文章管理</a></li>
	</ul>
	<div class="well well-control">
		<p class="bg-warning">
			<span>内容状态提醒</span>
			<span>未审核文章<i class="badge">${approveNoCount}</i></span>
			<span>已审核文章<i class="badge">${approveYesCount}</i></span>
			<span>全部文章<i class="badge">${approveYesCount+approveNoCount}</i></span>
		</p>
	</div>
	<form  class="form-inline" action="${ctx}/article/list" method="post" id="pageform" name="pageform">
	<div class="well" style="padding:5px;">
		<div class="form-group">
			<label>文章分类：</label>
			<select  class="form-control" id="classid" name="classid" >
					<option value="-1">选择分类</option>
					<c:forEach items="${classList}" var ="class0" varStatus="status0">
						<c:if test="${! empty class0}">      	
      						<option value="${class0.id}" <c:if test="${query.classid==class0.id }"> selected </c:if>>${status0.index+1} ${class0.className}</option>
      						<c:forEach items="${class0.listSubClass}" var ="class1" varStatus="status1">
	      						<c:if test="${! empty class1}">      	
	      							<option value="${class1.id}" <c:if test="${query.classid==class1.id }"> selected </c:if>>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${status0.index+1} .${status1.index+1} ${class1.className}</option>
	      							 <c:forEach items="${class1.listSubClass}" var ="class2" varStatus="status2">
			      						<c:if test="${! empty class2}">      	
			      							<option value="${class2.id}"<c:if test="${query.classid==class2.id }"> selected </c:if>>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${status0.index+1} .${status1.index+1} .${status2.index+1} ${class2.className}</option>
			      						</c:if>
		      						</c:forEach>
	      						</c:if>
      						</c:forEach>
				      	</c:if>
					</c:forEach>
				</select>
		</div>
		<div class="form-group">
			<label>文章标题：</label>
			<input type="text" class="form-control" id="title" name="title" value="${query.title}"/>	
			<button type="submit" class="btn btn-info btn-sm " >搜索</button>		
		</div>
		</div>
	
	<br/>
	<button type="button" class="btn btn-default" disabled="true" style="font-weight:600">未审核内容</button>
	<button type="button" class="btn btn-danger" onclick="publish()">发布</button>
	<table class="table table-hover table-bordered ">
		<thead>
			<tr>
				<th>标题</th>
				<th>连接</th>
				<th>点击数</th>
				<th>状态</th>
				<th>类型</th>
				<th>显示</th>
				<th>发布时间</th>
				<th>发布人</th>
				<th width="300px;">操作</th>
			</tr>
		
		</thead>
		<tbody>
			 <c:forEach var="item" items="${page.content}" varStatus="status">
			 	
			 	<tr>
				<td>${item.title}</td>
				<td>
					<c:choose>
						<c:when test="${item.url == null || item.url eq '' }">							
							<a href="${frontPath}/article/dispatcher/${item.id}" target="_blank">${frontPath}/article/dispatcher/${item.id}</a>
						</c:when>
						<c:otherwise>
							<a href="${item.url}" target="_blank">${item.url}</a>
						</c:otherwise>
					</c:choose>	
				</td>	
				<td>${item.count}</td>
				<td>
					<c:if test="${item.status == 1}">未审核</c:if>
					<c:if test="${item.status == 2}">已审核</c:if>
				</td>
				<td>${item.className}</td>
				<td>
					<c:if test="${item.status == 1}">不显示</c:if>
					<c:if test="${item.status == 2}">显示</c:if>
				</td>
				<td><fmt:formatDate  value="${item.createtime}"  pattern="yyyy-MM-dd  HH:mm:ss"/></td>
				<td >${item.userName}</td>
				<td>
					<button type="button" onclick="updatestatus('${item.id}','2')" class="btn btn-danger btn-xs">审核</button>
					<button type="button" onclick="updatestatus('${item.id}','1')" class="btn btn-danger btn-xs">取消审核</button>
					<!-- <button type="button" class="btn btn-danger btn-xs btn-click">显示</button> -->
					<!-- <button type="button" class="btn btn-danger btn-xs">隐藏</button> -->
					
					<button type="button" class="btn btn-danger btn-xs" onclick="updateData('${item.id}')">修改</button>
					<button type="button" onclick = "deleteArticle('${item.id}','${item.shopId}')" class="btn btn-danger btn-xs btn-click">删除</button>
					<%-- <button type="button" class="btn btn-danger btn-xs" onclick="window.open('${frontPath }/page/articleDispatcher/${item.id}')">查看</button> --%>
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
<script src="${jsBase}/article/list.js" type="text/javascript"></script>
</body>
</html>
