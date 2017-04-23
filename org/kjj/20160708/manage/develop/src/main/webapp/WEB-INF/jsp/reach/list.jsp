<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/common_java.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<meta name="apple-touch-fullscreen" content="yes" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />
<%@ include file="../common/common_css.jsp"%>

<title>满减满送-活动列表</title>
</head>
<body>
<div class="page-wrapper ">
<div class="container-fluid">
	<div class="page-wrapper">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li>您的位置</li>
				<li><a href="#">运营</a></li>
				<li><a href="#">促销管理</a></li>
				<li class="active">满减满送</li>
			</ul>
			<div  class="bg-warning " style="padding:10px;">
				<p><strong>备注：</strong></p>
				<p>• 【一体化满减满送】由瑞星系统设置，线上可设定是否已启用，如已停用则线上不执行该满减活动；</p>
				<p>• 【电商满减满送】是为线上独立设置的满减满送，线下不做同步；</p>
				<p>•  电商满减满送权重高于一体化满减满送。</p>
			</div>
			<form class="form-inline" id="pageform" action="${ctx}/reach/list" method="post">
				<div class="well new_margin">
					<div class="form-group">
						<label>活动时间：</label>
						<label>从</label>
						<input id="startDateTime" name="startTime" value ="<fmt:formatDate type='both' value='${query.startTime}' />" type="text" class="form-control datetime">
						<label>到</label>
						<input id="endDateTime" name="endTime" value ="<fmt:formatDate type='both' value='${query.endTime}' />" type="text" class="form-control datetime">
					</div>
					<div class="form-group" style="margin-right:0px">
						<label>活动名称：</label>
						<input name="name" value ="${query.name}" type="text"  class="form-control">
					</div>
					<div class="form-group">
						<label for="">活动状态</label>
						<select name="status"  class="form-control">
							<option value="">全部</option>
							
							<option value="1" <c:if test="${query.status==1}">selected</c:if>>已启用</option>
							<option value="0" <c:if test="${query.status==0}">selected</c:if>>已停用</option>
						</select>
					</div>

					<div class="form-group">
						<button class="btn btn-success" onclick="submit()" >搜索</button>
					</div>
				</div>
			<!-- 切换 -->
			<!-- 
				<div class="btn-group btn-group-justified" role="group" aria-label="Justified button group" style="width:30%;">
				   <a href="#" class="btn btn-primary " role="button">一体化满减满送</a>
				   <a href="#" class="btn btn-info" role="button">电商满减满送</a>
			    </div>
			 -->
			<!-- 切换 -->
				<div class="table-wrapper">
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>活动名称</th>
								<th>活动时间</th>
								<th>适用范围</th>
								<th>活动状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${page.content}" var="item">
								<tr>
									<td>${item.name}</td>
									<td>
									<fmt:formatDate type='both' value='${item.startTime}'/> 至 <fmt:formatDate type='both' value='${item.endTime}'/>
									</td>
									<td>
										<c:if test="${item.shopType==1}"><span>全部区域</span></c:if>
										<c:if test="${item.shopType==2}"><span>单区域</span></c:if>
										<c:if test="${item.shopType==3}"><span>单区域门店</span></c:if>
									</td>
									<td>
										<c:if test="${item.status eq 1}">已启用</c:if>
										<c:if test="${item.status ne 1}">已停用</c:if>
									</td>
									<td data-id="${item.id}">
										<c:if test="${item.status ne 1}">
											<a class="btn btn-success btn-xs" >启用</a>
											<a class="btn btn-danger btn-xs" style="display:none;">停用</a>
										</c:if>
										<c:if test="${item.status eq 1}">
											<a class="btn btn-success btn-xs" style="display:none;">启用</a>
											<a class="btn btn-danger btn-xs">停用</a>
										</c:if>
										
										<a class="btn btn-info btn-xs" href="${ctx}/reach/editInfo/${item.id}" >编辑</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<!-- 分页 -->
					<nav class="navbar navbar-default select-control" >
						<%@include file="../common/common_page.jsp" %>	
					</nav>
				</div>
			</form>
		</div>
	</div>
</div>
<%@ include file="../common/common_js.jsp"%>
<script type="text/javascript" src="${jsBase}/reach/list.js"></script>
</body>
</html>