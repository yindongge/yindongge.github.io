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
<title>修改用户级别</title>
<style>
#userlevelform .col-sm-2{width:100px; text-align:right;}
</style>
</head>

<body>	
<form class="form-horizontal media-control"  id="invitationform" name ="invitationform" action="${ctx}/enterprise/addEasyInvitation" method="post">
<input type="hidden" name="enterpriseId" id="enterpriseId" value="${enterpriseId}"/>
<div class="class="page-wrapper"">
<div class="container-fluid">
		<div class="panel panel-default"> 
			<div class="panel-heading">企业统一邀请码</div> 
			<div class="panel-body">
			    <div class="form-group">
					<label class="col-sm-3 control-label" style="float:left;"><span class="red bigred">*</span>公司名称：</label>
					<div class="col-sm-3 " style="float:left;font-size:12px;margin-top:8px">
					    ${enterprise.enterpriseName}
					</div>
				</div>
			    <div class="form-group">
					<label class="col-sm-3 control-label" style="float:left;"><span class="red bigred">*</span>统一邀请码：</label>
					<div class="col-sm-3 " style="float:left;font-size:12px;margin-top:5px">
					    <input type="text" class="form-control" id="code" name="code" value="${invitationCode}" readOnly="readOnly"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" style="float:left;"><span class="red bigred">*</span>有效期限：</label>
					<div class="col-sm-3 timeTypeStartEnd ">
						<input type="text" class="form-control date" id="startTime" name="startTime" value="<fmt:formatDate type='date' value='${now}'/> 00:00:00"/>
					</div>
					<div class="col-sm-1 timeTypeStartEnd" style="text-align:center">至</div>
					<div class="col-sm-3 timeTypeStartEnd">
						<input type="text" class="form-control date" id="endTime" name="endTime" value="<fmt:formatDate type='date' value='${now}'/> 23:59:59"/>
					</div>
					<div class="col-sm-2">有效期最长为七天</div>
				</div>
				<div class="form-group">
					<label  class="col-sm-3 control-label" style="float:left;" ><span class="red bigred">*</span>可激活数：</label>
					<div class="col-sm-3 " style="float:left;">
					    <input type="text" class="form-control" id="ceiling" name="ceiling" value="" onkeyup="if(isNaN(value))execCommand('undo')" onafterpaste="if(isNaN(value))execCommand('undo')"/>
					</div>
					<div class="col-sm-4">设置邀请码最多可激活的数量</div>
				</div>
			</div>
		</div>
		<div class="text-center">
		    <a type="button" class="btn btn-default" href="javascript:history.go(-1)">返回</a>
			<button type="button" class="btn btn-danger" onclick="save()">保存</button>
		</div>
	</form>
</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/user/easyInvitation.js" type="text/javascript"></script>
</body>
</html>
