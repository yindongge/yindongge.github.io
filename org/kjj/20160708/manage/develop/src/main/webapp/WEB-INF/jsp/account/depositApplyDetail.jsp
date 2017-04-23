<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<%@include file="../common/common_css.jsp" %>
<title>新增预付款审核</title>
<style type="text/css">
 .col-sm-3{margin-top:4px;}
</style>
<style>

</style>
</head>

<body>	
	<form class="form-horizontal media-control"  id="applyform" name ="applyform" action="" method="post">
	<input type="hidden" id="pageId" name="pageId" value="${pageId}"/>
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">会员</a></li>
		<li class="active">预存款管理</li>
	</ul>
	<div class="class="page-wrapper">
		<div class="container-fluid">
			<div class="panel panel-default"> 
				<div class="panel-body">
				    <div class="form-group">
						<label class="col-sm-2 control-label" >会员名：</label>
						<div class="col-sm-3">
						    ${depositApply.userName}
						</div>
						<div class="col-sm-1">
							
						</div>
						<div class="col-sm-4">
							
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" >预存款类型：</label>
						<div class="col-sm-3">
							<c:if test="${depositApply.fundAmount!='0.00'}">
								可用可提现金额
							</c:if>
							<c:if test="${depositApply.allowanceAmount!='0.00'}">
								可用不可提现金额
							</c:if>
							<c:if test="${depositApply.frozenAmount!='0.00'}">
								冻结金额
							</c:if>
						</div>
						<div class="col-sm-4">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" >增加类型：</label>
						<div class="col-sm-3" id="businessTypeDiv">
							<c:forEach items="${typeMap}" var="itemMap">
								<c:if test="${itemMap.key==depositApply.type}">${itemMap.value}</c:if>
							</c:forEach>
						</div>
						<div class="col-sm-4">
							<span id="validateBusinessTypeSpan"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" >金额：</label>
						<div class="col-sm-3">
						    <c:if test="${depositApply.fundAmount!='0.00'}">
								${depositApply.fundAmount}
							</c:if>
							<c:if test="${depositApply.allowanceAmount!='0.00'}">
								${depositApply.allowanceAmount}
							</c:if>
							<c:if test="${ depositApply.frozenAmount!='0.00'}">
								${depositApply.frozenAmount}
							</c:if>元
						</div>
						<div class="col-sm-4">
							<span id="validateAmountSpan" style="color:red"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" >原因：</label>
						<div class="col-sm-3">
						    <c:forEach items="${reasonMap}" var="itemMap">
								<c:if test="${itemMap.key==depositApply.reason}">${itemMap.value}</c:if>
							</c:forEach>
						</div>
						<div class="col-sm-4">
							<span id="validateReasonSpan"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" >申请时间：</label>
						<div class="col-sm-3">
						    <fmt:formatDate value="${depositApply.createTime}" type="both"/>
						</div>
						<div class="col-sm-4">

						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" >申请备注：</label>
						<div class="col-sm-3">
						    ${depositApply.applyComment}
						</div>
						<div class="col-sm-4">

						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" >状态：</label>
						<div class="col-sm-3">
						    <c:forEach items="${statusMap}" var="itemMap">
								<c:if test="${itemMap.key==depositApply.status}">${itemMap.value}</c:if>
							</c:forEach>
						</div>
						<div class="col-sm-4">

						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" >审核时间：</label>
						<div class="col-sm-3">
						    <fmt:formatDate value="${depositApply.checkTime}" type="both"/>
						</div>
						<div class="col-sm-4">

						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" >审核人：</label>
						<div class="col-sm-3">
						    ${depositApply.checkName}
						</div>
						<div class="col-sm-4">

						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" >审核备注：</label>
						<div class="col-sm-3">
						    ${depositApply.checkComment}
						</div>
						<div class="col-sm-4">
							<span id="validateCommentSpan"></span>
						</div>
					</div>
				</div>
			</div>
			<div class="text-center">
				<button type="button" class="btn btn-default modal-button" data-dismiss="modal" onclick="cancle()">返回列表</button>
			</div>
			<br/><br/>
		</div>
	</div>
	</form>
	<%@include file="../common/common_js.jsp" %>
	<script src="${jsBase}/account/depositApplyDetail.js" type="text/javascript"></script>
</body>
</html>
