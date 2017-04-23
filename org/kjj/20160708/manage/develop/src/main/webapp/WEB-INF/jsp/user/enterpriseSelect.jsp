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
	<title>会员管理</title>
</head>

<body>
<div class="page-wrapper">
<div class="container-fluid">
	<form  class="form-inline" id ="pageform" name ="pageform" action="${ctx}/enterprise/select" method="post">
		<div style="padding:10px;background:#f5f5f5;" style="">
			<div class="form-group" style="margin-left:5px">
				<label>公司名称：</label>
				<input class="form-control" name="enterpriseName" type="text" value="${query.enterpriseName}"/>			
			</div>
			<div class="form-group" style="margin-left:10px">
				<label>状态：</label>
				<select class="form-control" name="status" style="margin-left:20px;width:100px">
					<option value="">全部</option>
					<option value="0" <c:if test="${ query.status=='0' }">selected</c:if>>待审核</option>
					<option value="1" <c:if test="${ query.status=='1' }">selected</c:if>>审核通过</option>
					<option value="2" <c:if test="${ query.status=='2' }">selected</c:if>>审核不通过</option>
				</select>
			</div>
			<div class="form-group" style="margin-left:10px">
			    <label>是否锁定：</label>
				<input type="radio" name="isLocked" value="0" <c:if test="${query.isLocked==0}">checked</c:if>/>未锁定
				<input type="radio" name="isLocked" value="1" <c:if test="${query.isLocked==1}">checked</c:if> style="margin-left:20px"/>锁定
				<button type="submit"  class="btn btn-info btn-sm" style="margin-left:15px">搜索</button>
			</div>
		</div>
		<div class="breadcrumb breadcrumb-title">企业会员列表</div>
		<table class="table table-hover table-bordered table-striped table-4">
			<thead>
				<tr class="info">
					<th>用户名</th>
					<th>公司名称</th>
					<th>公司地址</th>
					<th>联系人姓名</th>
					<th>固定电话</th>
					<th>状态</th>
					<th>是否锁定</th>
					<th style="width:100px;">操作</th>
				</tr>
			</thead> 
			<tbody>
				<c:forEach var="item" items="${page.content}" varStatus="status">
				<tr  class="icon11 zhekoutext">
					<td>${item.userName}</td>
					<td>${item.enterpriseName}</td>
					<td>${item.address}</td>
					<td>${item.contactName}</td>
					<td>${item.landlines}</td>
					<td>
					    <c:if test="${ item.status=='0'}">待审核</c:if>
					    <c:if test="${ item.status=='1'}">审核通过</c:if>
					    <c:if test="${ item.status=='2'}">审核不通过</c:if>
					</td>
					<td>
						<c:if test="${item.isLocked == '0'}">未锁定</c:if>
						<c:if test="${item.isLocked == '1'}">锁定</c:if>
					</td>
					<td>
					    <button type="button" onclick="doSelect('${item.enterpriseId}')" class="btn btn-danger btn-xs">选择</button>
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
<script src="${jsBase}/user/enterpriseList.js" type="text/javascript"></script>
</body>
</html>
