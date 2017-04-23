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
	<form  class="form-inline" id ="pageform" name ="pageform" action="${ctx}/depositApply/applySimpleList" method="post">
		<ul class="breadcrumb">
			<li>您的位置</li>
			<li ><a href="#">会员</a></li>
			<li class="active">预存款管理</li>
		</ul>
		<div style="padding:10px;background:#f5f5f5;" style="">
			<div class="form-group">
			    <label>创建时间：</label>
				<input class="form-control date" id="createTimeStart" name="createTimeStart" type="text" value='<fmt:formatDate value="${query.createTimeStart}" pattern="yyyy-MM-dd HH:mm:ss"/>' style="width:140px"/>
				至
				<input class="form-control date" id="createTimeEnd" name="createTimeEnd" type="text" value='<fmt:formatDate value="${query.createTimeEnd}" pattern="yyyy-MM-dd HH:mm:ss"/>' style="width:140px"/>
				<label>单据编号：</label>
				<input class="form-control" name="applyCode" type="text" value="${query.applyCode}"/>
				<label>会员名：</label>
				<input class="form-control" name="userName" type="text" value="${query.userName}"/>	
			</div>
			<br/>
			<div class="form-group" style="margin:10px 0px 0px 0px">
				<label>状态：</label>
				<select class="form-control" name="status" style="margin-left:28px;width:171px">
					<option value="">全部</option>
					<c:forEach items="${statusMap}" var="item">
						<option value="${item.key}" <c:if test="${item.key==query.status}">selected</c:if>>${item.value}</option>
					</c:forEach>
				</select>
				<label>类型：</label>
				<select class="form-control" name="type" style="margin-left:15px;width:171px">
					<option value="">全部</option>
					<c:forEach items="${typeMap}" var="item">
						<option value="${item.key}" <c:if test="${item.key==query.type}">selected</c:if>>${item.value}</option>
					</c:forEach>
				</select>
				<button type="submit"  class="btn btn-info btn-sm" style="margin-left:20px">搜索</button>					
			</div>
		</div>
		<div class="breadcrumb breadcrumb-title">列表<button type="button" class="btn btn-danger"  onclick="doAdd('2')">添加申请单</button></div>
		<table class="table table-hover table-bordered table-striped table-4">
			<thead>
				<tr class="info">
					<th>单据编号</th>
					<th>会员名</th>
					<th>手机号</th>
					<th>类型</th>
					<th>金额</th>
					<th>创建时间</th>
					<th>支付方式</th>
					<th>来源</th>
					<th>原因</th>
					<th>状态</th>
					<th>创建人</th>
					<th style="width:110px;">操作</th>
				</tr>
			</thead> 
			<tbody>
				<c:forEach var="item" items="${page.content}" varStatus="status">
				<tr  class="icon11 zhekoutext">
					<td>${item.applyCode}</td>
					<td>${item.userName}
					    <c:if test="${ item.batchCode!=null}">
							<span style="cursor:pointer;color:green" onclick="javascript:doBatchDetail('${item.id}','2')" title="查看批量充值记录">(批量)</span>
						</c:if>
					</td>
					<td>${item.mobilePhone}</td>
					<td>
						<c:forEach items="${typeMap}" var="itemMap">
							<c:if test="${itemMap.key==item.type}">${itemMap.value}</c:if>
						</c:forEach>
					</td>
					<td>
						<c:if test="${ item.fundAmount!='0.00'}">
							${item.fundAmount}
						</c:if>
						<c:if test="${ item.allowanceAmount!='0.00'}">
							${item.allowanceAmount}
						</c:if>
						<c:if test="${ item.frozenAmount!='0.00'}">
							${item.frozenAmount}
						</c:if>
					</td>
					<td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>
						<c:forEach items="${payStyleMap}" var="itemMap">
							<c:if test="${itemMap.key==item.payStyle}">${itemMap.value}</c:if>
						</c:forEach>
					</td>
					<td>
						<c:forEach items="${sourceMap}" var="itemMap">
							<c:if test="${itemMap.key==item.source}">${itemMap.value}</c:if>
						</c:forEach>
					</td>
					<td>
						<c:forEach items="${reasonMap}" var="itemMap">
							<c:if test="${itemMap.key==item.reason}">${itemMap.value}</c:if>
						</c:forEach>
					</td>
					<td>
						<c:forEach items="${statusMap}" var="itemMap">
							<c:if test="${itemMap.key==item.status}">${itemMap.value}</c:if>
						</c:forEach>
					</td>
					<td>
						${item.createName}
					</td>
					<td>
					    <button type="button" onclick="doDetail('${item.id}','2')" class="btn btn-danger btn-xs">查看</button>
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
<script src="${jsBase}/account/depositApplyList.js" type="text/javascript"></script>
</body>
</html>
