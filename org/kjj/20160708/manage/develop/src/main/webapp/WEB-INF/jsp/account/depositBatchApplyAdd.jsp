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
</head>

<body>
<div class="page-wrapper">
<div class="container-fluid">	
	<form class="form-horizontal media-control"  id="applyform" name ="applyform" action="../depositApply/applySave" method="post">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">会员</a></li>
		<li class="active">预存款管理</li>
	</ul>
	<div class="well well-price" style="">
		<p class="fontweight">此页面为批量充值页面，请谨慎使用此功能，务必核对每条人员信息后进行充值操作。</p>
	</div>
	<div class="class="page-wrapper" style="margin-top:10px;margin-left:-15px">
		<div class="container-fluid">
			<div class="panel panel-default"> 
				<div class="panel-body">
				    <div class="form-group">
						<label class="col-sm-3 control-label" ><span class="red bigred">*</span>用户组：</label>
						<div class="col-sm-3">
						    <input type="hidden" name="groupId" id="groupId" />
							<input type="text" class="form-control" name="groupName" id="groupName" readOnly="readOnly" style=""/>
							
						</div>
						<div class="col-sm-1">
							<input type="button" class="form-control" value="选择用户组" onclick="selectGroup()" style="width:95px;"/>
						</div>
						<div class="col-sm-4">
							<span id="validateGroupNameSpan"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" ><span class="red bigred">*</span>预存款类型：</label>
						<div class="col-sm-3">
						    <select class="form-control" name="depositType" id="depositType">
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
						    <input type="radio" id="type_5" name="type" value="5" checked="checked"/>增加&nbsp;&nbsp;&nbsp;
						</div>
						<div class="col-sm-4">
							<span id="validateBusinessTypeSpan"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" ><span class="red bigred">*</span>金额(保留两位小数)：</label>
						<div class="col-sm-3">
						    <input type="text" class="form-control" name="amount"  title="保留两位小数"  id="amount" onkeyup="if(isNaN(value))execCommand('undo')" onafterpaste="if(isNaN(value))execCommand('undo')" maxlength="10"/>
						</div>
						<div class="col-sm-4">
							<span id="validateAmountSpan" style="color:red"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" >支付方式：</label>
						<div class="col-sm-3">
						    <select class="form-control" name="payStyle" id="payStyle">
								<option value="">请选择</option>
								<c:forEach items="${payStyleMap}" var="dt">
									<option value="${dt.key}">${dt.value}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-sm-4">
							<span id="validatePayStyleSpan" style="color:red"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" >付款方银行：</label>
						<div class="col-sm-3">
						    <input type="text" class="form-control" name="bankName" id="bankName" maxlength="30"/>
						</div>
						<div class="col-sm-4">
							<span id="validateBankNameSpan" style="color:red"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" >账号：</label>
						<div class="col-sm-3">
						    <input type="text" class="form-control" name="paymentCode" id="paymentCode" class="inputCard" maxlength="30"/>
						</div>
						<div class="col-sm-4">
							<div class="panelCard"></div>
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
				<button type="button" class="btn btn-danger" id="mySubmit" onclick="savedata()">提交</button>
			</div>
			<br/><br/>
		</div>
	</div>
	</form>
	</div>
	</div>
	<%@include file="../common/common_js.jsp" %>
	<script src="${jsBase}/account/depositBatchApplyAdd.js" type="text/javascript"></script>
</body>
</html>
