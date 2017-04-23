<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
<body >
	<div class="page-wrapper">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li>您的位置</li>
				<li ><a href="${ctx}/businessArea/list">商圈管理</a></li>
			</ul>
		<form class="form-inline clear-control" id ="pageform" name ="pageform" action="${ctx}/businessArea/list" method="post">
		<a class="btn btn-danger" role="button" href="${ctx}/businessArea/addInit">添加商圈</a>
		
		<div class="form-group">
			<label>商圈名称：</label>
			<input type="text" class="form-control" id="nameLike" name="nameLike" value="${query.nameLike}"/>
			
			<label>所在区域:</label>
			<select class="form-control" name="provinceCode" id="provinceCode">
				<option value="-1">选择省或者市</option>
				<c:forEach items="${listProvince}" var="province">
					<option value="${province.code }" <c:if test="${query.getProvinceCode()==province.code }">selected</c:if>>${province.name }</option>
				</c:forEach>
			</select>
			<select class="form-control" name="cityCode" id="cityCode">
				<option value="-1">请选择市</option>
				<c:forEach items="${listCity}" var="city">
					<option value="${city.code }" <c:if test="${query.getCityCode()==city.code }">selected</c:if>>${city.name }</option>
				</c:forEach>
			</select>
			<select class="form-control" name="countyCode" id="countyCode">
				<option value="-1">请选择区或县</option>
				<c:forEach items="${listCounty}" var="county">
					<option value="${county.code }" <c:if test="${query.getCountyCode()==county.code }">selected</c:if>>${county.name }</option>
				</c:forEach>
			</select>
		</div>
		
		<button type="submit" class="btn btn-info pull-right">搜索</button>
		
		<br/>
		<!--分割线-->	
		<div class="breadcrumb breadcrumb-title">商圈管理</div>
		<table class="table table-bordered table-hover borded-striped table-control">
		    <thead>
				<tr class="info text-center">
					<th>商圈名称</th>
					<th>所在区域</th>
					<th style="width:300px;">范围说明</th>
					<th>门店数量</th>
					<th>排序</th>
					<th>操作</th>
				</tr>
			</thead>
			
			<c:forEach var="item" items="${page.content}" varStatus="status">
			<tr>
				<td>${item.name}</td>
				<td>${item.orgArea.show}</td>
				<td><div style="width:300px;">${item.rangeExplain}</div></td>
				<td>${item.shopCount}</td>
				<td>${item.businessAreaOrder}</td>
				<td>
					<a type="button" href="javascript:edit(${item.id});" class="btn btn-danger btn-go btn2-click" >编辑</a>
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
<script src="${jsBase}/businessArea/list.js" type="text/javascript"></script>
</body>
</html>
