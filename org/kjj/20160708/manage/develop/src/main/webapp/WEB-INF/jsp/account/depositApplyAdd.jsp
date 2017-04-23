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
<title>新增预付款申请</title>
<style>

</style>
</head>

<body>	
	<form class="form-horizontal media-control"  id="applyform" name ="applyform" action="../depositApply/applySave" method="post">
	<input type="hidden" name="pageId" id="pageId" value="${pageId}"/>
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
						<label class="col-sm-3 control-label" ><span class="red bigred">*</span>会员名：</label>
						<div class="col-sm-3">
						    <input type="hidden" class="form-control" name="userId" id="userId" />
							<input type="text" class="form-control" name="userName" id="userName" readOnly="readOnly" style=""/>
							
						</div>
						<div class="col-sm-1">
							<input type="button" class="form-control" value="选择会员" onclick="selectSingleUser()" style="width:75px;"/>
						</div>
						<div class="col-sm-5" style="margin-top:5px">
							<span id="validateUserNameSpan" style="font-size:10px;"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" ><span class="red bigred">*</span>预存款类型：</label>
						<div class="col-sm-3">
						    <select class="form-control" name="depositType" id="depositType">
								<option value="">请选择</option>
								<c:forEach items="${depositTypeMap}" var="dt">
									<option value="${dt.key}">${dt.value}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-sm-4">
							<span id="validateDepositTypeSpan"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" ><span class="red bigred">*</span>增加类型：</label>
						<div class="col-sm-3" id="businessTypeDiv">
						    <input type="radio" id="type_5" name="type" value="5"/>增加&nbsp;&nbsp;&nbsp;
						    <input type="radio" id="type_6" name="type" value="6"/>减少&nbsp;&nbsp;&nbsp;
						    <input type="radio" id="type_7" name="type" value="7"/>解冻&nbsp;&nbsp;&nbsp;
						    <input type="radio" id="type_8" name="type" value="8"/>冻结
						</div>
						<div class="col-sm-4">
							<span id="validateBusinessTypeSpan"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" ><span class="red bigred">*</span>金额(保留两位小数)：</label>
						<div class="col-sm-3">
						    <input type="text" class="form-control" name="amount" id="amount" title="保留两位小数" value="0.00" onkeyup="if(isNaN(value))execCommand('undo')" onafterpaste="if(isNaN(value))execCommand('undo')" maxlength="10"/>
						</div>
						<div class="col-sm-4">
							<span id="validateAmountSpan" style="color:red"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" ><span class="red bigred">*</span>选择原因：</label>
						<div class="col-sm-3">
						    <select class="form-control" name="reason" id="reason">
								<option value="">请选择</option>
								<c:forEach items="${reasonMap}" var="reason">
									<option value="${reason.key}">${reason.value}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-sm-4">
							<span id="validateReasonSpan"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" ><span class="red bigred">*</span>备注：</label>
						<div class="col-sm-3">
						    <textarea class="color-control form-control" rows="6" cols="50" id="applyComment" name="applyComment" style="width:100%;margin-left:0px"></textarea>
						</div>
						<div class="col-sm-4">
							<span id="validateCommentSpan"></span>
						</div>
					</div>
				</div>
			</div>
			<div class="text-center">
				<button type="button" class="btn btn-default modal-button" data-dismiss="modal" onclick="cancle()">返回列表</button>
				<button type="button" id="mySubmit" class="btn btn-danger" onclick="savedata()">提交</button>
			</div>
			<br/><br/>
		</div>
	</div>
	</form>
	<%@include file="../common/common_js.jsp" %>
	<script src="${jsBase}/account/depositApplyAdd.js" type="text/javascript"></script>
</body>
</html>
