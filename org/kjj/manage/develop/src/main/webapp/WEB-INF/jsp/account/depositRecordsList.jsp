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
	<form  class="form-inline" id ="pageform" name ="pageform" action="${ctx}/depositAccount/recordsList" method="post">
		<ul class="breadcrumb">
			<li>您的位置</li>
			<li ><a href="#">会员</a></li>
			<li class="active">预存款流水记录</li>
		</ul>
		<div style="padding:10px;background:#f5f5f5;" style="">
			<div class="form-group">
			    <label>时间：</label>
				<input class="form-control date" id="createTimeStart" name="createTimeStart" type="text" value='<fmt:formatDate value="${query.createTimeStart}" pattern="yyyy-MM-dd HH:mm:ss"/>' style="width:140px"/>
				至
				<input class="form-control date" id="createTimeEnd" name="createTimeEnd" type="text" value='<fmt:formatDate value="${query.createTimeEnd}" pattern="yyyy-MM-dd HH:mm:ss"/>' style="width:140px"/>
				<label>服务编号：</label>
				<input class="form-control" name="serviceCode" type="text" value="${query.serviceCode}"/>
				<label>会员名：</label>
				<input class="form-control" name="userName" type="text" value="${query.userName}"/>			
			</div>
			<br/>
			<div class="form-group" style="margin:10px 0px 0px 0px">
				<label>来源：</label>
				<select class="form-control" name="origin" style="margin-left:0px;width:171px">
					<option value="">全部</option>
					<c:forEach items="${originMap}" var="item">
						<option value="${item.key}" <c:if test="${item.key==query.origin}">selected</c:if>>${item.value}</option>
					</c:forEach>
				</select>
				<label>类型：</label>
				<select class="form-control" name="type" style="margin-left:0px;width:171px">
					<option value="">全部</option>
					<c:forEach items="${typeMap}" var="item">
						<option value="${item.key}" <c:if test="${item.key==query.type}">selected</c:if>>${item.value}</option>
					</c:forEach>
				</select>
				<button type="submit"  class="btn btn-info btn-sm" style="margin-left:20px">搜索</button>					
			</div>
		</div>
		<div class="breadcrumb breadcrumb-title">账户流水列表<button type="button" class="btn btn-danger" style="display:none"  onclick="doExpExcel()">导出Excel</button></div>
		<table class="table table-hover table-bordered table-striped table-4">
			<thead>
				<tr class="info">
				    <th>会员名</th>
				    <th>来源</th>
					<th>可用可提现金额</th>
					<th>可用不可提现金额</th>
					<th>冻结金额</th>
					<th>类型</th>
					<th>服务编号</th>
					<th>原因</th>
					<th>时间</th>
					<th>备注</th>
				</tr>
			</thead> 
			<tbody>
				<c:forEach var="item" items="${page.content}" varStatus="status">
				<tr  class="icon11 zhekoutext">
				    <td>${item.userName}</td>
				    <td>
						<c:forEach items="${originMap}" var="itemMap">
							<c:if test="${itemMap.key==item.origin}">${itemMap.value}</c:if>
						</c:forEach>
					</td>
					<td>${item.fundAmount}</td>
					<td>${item.allowanceAmount}</td>
					<td>${item.frozenAmount}</td>
					<td>
						<c:forEach items="${typeMap}" var="itemMap">
							<c:if test="${itemMap.key==item.type}">${itemMap.value}</c:if>
						</c:forEach>
					</td>
					<td>${item.serviceCode}</td>
					<td>
						<c:forEach items="${reasonMap}" var="itemMap">
							<c:if test="${itemMap.key==item.reason}">${itemMap.value}</c:if>
						</c:forEach>
					</td>
					<td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>
					    ${item.comment}
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
<script src="${jsBase}/account/depositRecordsList.js" type="text/javascript"></script>
</body>
</html>
