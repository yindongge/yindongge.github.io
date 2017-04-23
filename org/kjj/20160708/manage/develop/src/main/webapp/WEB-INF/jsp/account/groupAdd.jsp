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
<title>新增用户组</title>
<style>

</style>
</head>

<body>	
	<form class="form-horizontal media-control"  id="groupform" name ="groupform" action="../accountGroup/groupSave" method="post" enctype="multipart/form-data">
	<input type="hidden" id="groupId" name="groupId" value="${group.groupId}"/>
	<div class="class="page-wrapper">
		<div class="container-fluid">
			<div class="panel panel-default"> 
				<div class="panel-body">
				    <div class="form-group">
						<label class="col-sm-3 control-label" ><span class="red bigred">*</span>用户组名称：</label>
						<div class="col-sm-1">
							<input type="text" class="form-control" name="groupName" id="groupName" maxlength="15" value="${group.groupName}"/>
						</div>
					</div>
				</div>
			</div>
			<div class="text-center">
				<button type="button" class="btn btn-default modal-button" data-dismiss="modal" onclick="cancle()">关闭</button>
				<button type="button" class="btn btn-danger" onclick="savedata()">提交</button>
			</div>
			<br/><br/>
		</div>
	</div>
	</form>
	<%@include file="../common/common_js.jsp" %>
	<script src="${jsBase}/account/groupAdd.js" type="text/javascript"></script>
</body>
</html>
