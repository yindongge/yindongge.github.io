<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
<%@include file="../common/common_css.jsp" %>
<title>留言咨询</title>
</head>
<body>	
<div class="page-wrapper goods-control">
<div class="container-fluid">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">咨询留言管理</a></li>
		<li class="active">网站咨询</li>
	</ul>
	<form  class="form-inline" id="pageform" action="${ctx}/consultation/webConsultationList" method="post">
	<div class="well" style="padding:5px;">
		<div class="form-group">
			<label>会员名：</label>
			<input type="text" class="form-control aa" name="userNameLike" value="${query.userNameLike }"/>			
		</div>
		<div class="form-group">
			<label>咨询内容：</label>
			<input type="text" class="form-control aa" name="consultProblemLike" value="${query.consultProblemLike }"/>			
		</div>
		<div class="form-group">
			<label>服务编号</label>
			<input type="text" class="form-control aa" name="consultProblemIdLike" value="${query.consultProblemIdLike }"/>			
		</div>
		
	
		<input type="submit" class="btn btn-danger" value="确认"/>
		</div>
	
	</br>

	<div class="group-button">
		<a role="button" class="btn btn-default " href="${ctx }/consultation/productConsultationList">商品咨询</a>
		<a role="button" class="btn btn-default btn-success" href="${ctx }/consultation/webConsultationList">网站咨询</a>
	</div>
	<table class="table table-hover table-bordered ">
		<thead>
			<tr class="info">
				<th width="10%">服务编号</th>
				<th width="10%">会员名</th>
				<th width="30%">咨询内容</th>
				<th width="10%">
					<select name="consultTypeId" onchange="submitForm();">
						<option value="-1">问题类型</option>
						<c:forEach items="${consultTypeList }" var="item">
							<c:if test="${item.consultTypeId==query.consultTypeId }">
								<option value="${item.consultTypeId }" selected="selected">${item.consultTypeName }</option>
							</c:if>
							<c:if test="${item.consultTypeId!=query.consultTypeId }">
								<option value="${item.consultTypeId }">${item.consultTypeName }</option>
							</c:if>
						</c:forEach>
					</select>
					
				</th>
				<th width="10%">咨询时间</th>
				<th width="10%">
					<select name="replyState" onchange="submitForm();">
						<option value="-1">回复状态</option>
						<c:forEach items="${consultStateList }" var="item">
							<c:if test="${item.consultStateId==query.replyState }">
								<option value="${item.consultStateId }" selected="selected">${item.consultStateName }</option>
							</c:if>
							<c:if test="${item.consultStateId!=query.replyState }">
								<option value="${item.consultStateId }">${item.consultStateName }</option>
							</c:if>
						</c:forEach>
					</select>
				</th>
				<th width="10%">
					<select name="solveState" onchange="submitForm();">
						<option value="-1">处理状态</option>
						<c:forEach items="${resolveStateList }" var="item">
							<c:if test="${item.consultStateId==query.solveState }">
								<option value="${item.consultStateId }" selected="selected">${item.consultStateName }</option>
							</c:if>
							<c:if test="${item.consultStateId!=query.solveState }">
								<option value="${item.consultStateId }">${item.consultStateName }</option>
							</c:if>
						</c:forEach>
					</select>
				</th>
				<th width="10%">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.content}" var="item">
				<tr>
					<td>${item.consultProblemId }</td>
					<td>${item.userName }</td>
					<td>${item.consultProblem }</td>
					<td>${item.consultTypeName}</td>
					<td><fmt:formatDate value="${item.createTime}"  pattern="yyyy-MM-dd hh:mm:ss"/></td>
					<td>${item.consultStateName}</td>
					<td>${item.consultSolveStateName}</td>
					<td><a href="javascript:void(0);" onclick="detailView(${item.consultProblemId });">查看详情</a></td>
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
<script src="${jsBase}/consutation/webConsultationList.js"type="text/javascript"></script>
</body>
</html>