<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
<%@include file="../common/common_css.jsp"%>
<title>类型分组</title>
</head>
<body >	
	<div class="page-wrapper">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li>您的位置</li>
				<li ><a href="#">商品</a></li>
				<li ><a href='#'>类型管理</a></li>
				<li class="active">类型分组</li>
			</ul>
			<div class="icon1"> 
				<button type="button" class="btn btn-danger btn2-click" id="addBtn">添加分组</button>
			</div>

			<table class="table table-bordered table-hover borded-striped table-control">
				<thead>  
    				<tr class="info text-center">  
  						<th>分组名称</th>  
  						<th>排序</th>  
               			<th>状态</th>  
  						<th>操作</th>  
					</tr>
				</thead>  
			 	<c:forEach items="${page.content }" var="item">
				<tr>  
  					<td>${item.orgproductTypeGroupName}</td>  
  					<td>${item.groupOrder}</td>  
            		<td>启用</td>  
  					<td>
  						<input type="hidden" name="groupId" value="${item.groupId }"/>
						<button type="button" class="btn btn-danger btn-go " name="deleteBtn">删除</button> 
						<button type="button" class="btn btn-danger btn-go " name="editBtn">修改</button> 
  					</td>  
				</tr>  
				</c:forEach>
			</table>  
  

			<form id ="pageform" name ="pageform" action="${ctx }/productTypeGroup/list" method="post">
				<nav class="navbar navbar-default select-control" >
					<%@include file="../common/common_page.jsp" %>		
				</nav>
			</form>
		</div>	
	</div>
<%@include file="../common/common_js.jsp"%>
<script src="${jsBase}/productTypeGroup/list.js" type="text/javascript"></script>	
</body>
</html>