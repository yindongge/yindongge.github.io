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
<style type="text/css">
 .col-sm-3{margin-top:4px;}
</style>
</head>

<body>	
<div class="page-wrapper">
<div class="container-fluid">
	<form class="form-horizontal media-control"  id="applyform" name ="applyform" action="../depositApply/applySave" method="post">
	<input type="hidden" id="pageId" name="pageId" value="${pageId}"/>
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">会员</a></li>
		<li class="active">预存款管理</li>
	</ul>
	<div class="class="page-wrapper" style="margin-left:-15px">
		<div class="container-fluid">
			<div class="panel panel-default"> 
				<div class="panel-body">
				    <div class="form-group">
						<label class="col-sm-2 control-label" > 批次号：</label>
						<div class="col-sm-3" style="margin-top:10px">
						    ${depositApply.batchCode}
							
						</div>
						<div class="col-sm-1">
						</div>
						<div class="col-sm-4">

						</div>
					</div>
				    <div class="form-group">
						<label class="col-sm-2 control-label" > 会员列表：</label>
						<div class="col-sm-3">
						    <div style="width:260px;height:200px;float:left;border:1px solid #000000;overflow-y:scroll; overflow-x:scroll;">
						        <c:forEach var="item" items="${batchList}" varStatus="status">
						            <c:if test="${item.mobilePhone == null}">
						            	<label style="width:30px">${status.index + 1}</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;手机号为空&nbsp;|&nbsp;<span>${item.userName}</span>
						            </c:if>
						            <c:if test="${item.mobilePhone != null}">
						            	<label style="width:30px">${status.index + 1}</label><span>${item.mobilePhone}</span>&nbsp;|&nbsp;<span>${item.userName}</span>
						            </c:if>
						        	<br/>
						        </c:forEach>
						    </div>
						</div>
						<div class="col-sm-1">

						</div>
						<div class="col-sm-4">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" > 预存款类型：</label>
						<div class="col-sm-3">
								<c:forEach items="${depositTypeMap}" var="dt">
									${dt.value}
								</c:forEach>
						</div>
						<div class="col-sm-4">
							<span id="validateDepositTypeSpan"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" > 增加类型：</label>
						<div class="col-sm-3" id="businessTypeDiv">
						    <input type="radio" id="type_5" name="type" value="5" checked="checked"/>增加&nbsp;&nbsp;&nbsp;
						</div>
						<div class="col-sm-4">
							<span id="validateBusinessTypeSpan"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" > 金额：</label>
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
						<label class="col-sm-2 control-label" >支付方式：</label>
						<div class="col-sm-3">
						    <c:forEach items="${payStyleMap}" var="itemMap">
								<c:if test="${itemMap.key==depositApply.payStyle}">${itemMap.value}</c:if>
							</c:forEach>
						</div>
						<div class="col-sm-4">
							<span id="validatePayStyleSpan" style="color:red"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" >付款方银行：</label>
						<div class="col-sm-3">
						    ${depositApply.bankName}
						</div>
						<div class="col-sm-4">
							<span id="validateBankNameSpan" style="color:red"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" >账号：</label>
						<div class="col-sm-3">
						    ${depositApply.paymentCode}
						</div>
						<div class="col-sm-4">
							<div class="panelCard"></div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" > 备注：</label>
						<div class="col-sm-3">
						    ${depositApply.applyComment}
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
	</div>
	</div>
	<%@include file="../common/common_js.jsp" %>
	<script src="${jsBase}/account/depositBatchApplyDetail.js" type="text/javascript"></script>
</body>
</html>
