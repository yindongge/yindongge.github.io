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
<div class="page-wrapper goods-control">
<div class="container-fluid">
	<form  class="form-inline" id ="pageform" name ="pageform" action="${ctx}/userlevel/list" method="post">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">会员</a></li>
		<li ><a href="#">级别管理</a></li>
		<li class="active">等级规则</li>
	</ul>
	
	<div class="well well-control">
		<p class="bg-warning">&nbsp;&nbsp;备注：会员类型分为个人会员和企业会员，个人会员等级间状态可以转换，消费至上限自动升级；个人类型会员和企业类型会员之间不能进行升级操作。</p>
	</div>
	
	<div class="breadcrumb breadcrumb-title">会员级别<button type="button" class="btn btn-danger pull-right" onclick="showAdd()">新增会员级别</button></div>
	<!-- <div class="breadcrumb breadcrumb-title">会员级别<button type="button" class="btn btn-danger pull-right" onclick="doSyncUserLevel()">同步会员级别</button></div> -->
	<table  class="table table-hover table-bordered table-striped table-4">
		<thead>
			<tr class="info">
			    <th>标识编码</th>
				<th>名称</th>
				<th>类型</th>
				<th>折扣</th>
				<th>消费下限(单位：元)</th>
				<th>消费上限(单位：元)</th>
				<th>排序</th>
				<th style="width:100px;">操作</th>
			</tr>
		</thead> 
		<tbody>
			<c:forEach var="item" items="${userLevels}" varStatus="status">
			<tr>
			    <td>${item.levelId}</td>
				<td>${item.levelName}</td>
				<td>
				    <c:if test="${item.levelType==null}">未填写</c:if>
					<c:if test="${item.levelType==1}">个人</c:if>
					<c:if test="${item.levelType==2}">企业</c:if>
					<c:if test="${item.levelType==3}">关联企业</c:if>
				</td>
				<td>${item.discount}</td>
				<td><c:if test="${item.consumeDown==null}">未填写</c:if>${item.consumeDown}</td>
				<td><c:if test="${item.consumeTop==null}">未填写</c:if>${item.consumeTop}</td>
				<td>${item.levelOrder}</td>
				<td>
					<button type="button" onclick="edit('${item.levelId}')" class="btn btn-danger btn-xs">修改</button>
					<button type="button" onclick="del('${item.levelId}')" class="btn btn-danger btn-xs">删除</button>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</form>
</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/user/levelList.js" type="text/javascript"></script>
</body>
</html>
