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
				<li ><a href="${ctx}/shop/list">店铺</a></li>
				<li class="active">店铺管理</li>
			</ul>
		<form class="form-inline clear-control" id ="pageform" name ="pageform" action="${ctx}/shop/list" method="post">
		<a class="btn btn-danger" role="button" href="${ctx}/shop/addInit">添加店铺</a>
		
		<div class="form-group">
			<label>店铺名称或编号：</label>
			<input type="text" class="form-control" id="codeOrNameLike" name="codeOrNameLike" value="${query.codeOrNameLike}"/>
			
			<label>所在区域:</label>
			<select class="form-control" name="provinceCode" id="provinceCode">
				<option value="-1">选择省或者市</option>
				<c:forEach items="${listProvince}" var="province">
					<option value="${province.code }" <c:if test="${query.provinceCode==province.code }">selected</c:if>>${province.name }</option>
				</c:forEach>
			</select>
			<select class="form-control" name="cityCode" id="cityCode">
				<option value="-1">请选择市</option>
				<c:forEach items="${listCity}" var="city">
					<option value="${city.code }" <c:if test="${query.cityCode==city.code }">selected</c:if>>${city.name }</option>
				</c:forEach>
			</select>
			<select class="form-control" name="countyCode" id="countyCode">
				<option value="-1">请选择区或县</option>
				<c:forEach items="${listCounty}" var="county">
					<option value="${county.code }" <c:if test="${query.countyCode==county.code }">selected</c:if>>${county.name }</option>
				</c:forEach>
			</select>
		</div>
		
		<button type="submit" class="btn btn-info pull-right">搜索</button>
		
		<br/>
		<!--分割线-->	
		<div class="breadcrumb breadcrumb-title">店铺管理</div>
		<table class="table table-bordered table-hover borded-striped table-control">
		    <thead>
				<tr class="info text-center">
					<th>编号</th>
					<th>店铺名称</th>
					<th>所在区域</th>
					<th style="width:100px;">地址</th>
					<th>电话</th>
					<th>所属商圈</th>
					<th style="width:200px;">配送范围</th>
					<th style="width:100px;">提供服务</th>
					<th>操作</th>
				</tr>
			</thead>
			
			<c:forEach var="item" items="${page.content}" varStatus="status">
			<tr>
				<td>${item.shopCode}</td>
				<td>${item.shopName}</td>
				<td>${item.orgArea.show}</td>
				<td>
					<div style="width:100px;">${item.address}</div>
				</td>
				<td>
					${item.firstPhoneAreaCode}
					<c:if test="${!empty item.firstPhoneAreaCode}">-</c:if>
					${item.firstPhoneNo}
					<c:if test="${!empty item.firstPhoneExtension}">-</c:if>
					${item.firstPhoneExtension}
				</td>
				<td>${item.businessAreaName}</td>
				<td>
					<div style="width:200px;">${item.sendRangeConcat}</div>
				</td>
				<td>
					<div style="width:100px;">${item.shopBindServiceConcat}</div>
				</td>
				<td>
					<a type="button" href="javascript:edit(${item.shopId});" class="btn btn-danger btn-go btn2-click" >编辑</a>
					<c:if test="${item.status == 0}">
						<a type="button" href="javascript:hide(${item.shopId});" class="btn btn-danger btn-go ">隐藏</a>
					</c:if>
					<c:if test="${item.status == 1}">
						<a type="button" href="javascript:show(${item.shopId});" class="btn btn-danger btn-go ">显示</a>
					</c:if>
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
<script src="${jsBase}/shop/list.js" type="text/javascript"></script>
</body>
</html>
