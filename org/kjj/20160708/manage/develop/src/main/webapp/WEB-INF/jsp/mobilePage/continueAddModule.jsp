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
<title>修改移动首页</title>
<style>
</style>
</head>
<body>
<div class="page-wrapper ">
<div class="container-fluid">
	<div class="page-wrapper">
		<div class="container-fluid">
			<form class="form-inline" id="mobilePageform" name ="mobilePageform"  method="post" enctype="multipart/form-data">
			<input type="hidden" id="pageId" name="pageId" value="${page.id}"/>
			<div class="panel panel-info panel_control" id="moduleout">
			<div class="table-list">
				<table class="table  new-table">
					<tbody>
						<tr>
							<td  class="td_control100 " ><span class="red">*</span>选择区域：</td>
							<td class="center_left">
								<div class="form-group ">
										<img src="" id="img" alt="点击此处上传图片"  width="375" height="40" >
										<input type="hidden" id="hid" name="moduleImg" value=""/>
										<span class="gray" id="tip">建议图片宽高尺寸为750*80</span>
										<input type="file" id="file" name="file" class="form-control w260" style="display:none" onchange='uploadImage()'/>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="form-group">
					<button type="button" id="saveBtn" class="btn btn-success" onclick="saveModule()">保存</button>
			</div>
			</div>
			</form>
		</div>
	</div>
</div>
	<%@include file="../common/common_js.jsp" %>
	<script src="${jsBase}/mobilePage/continueAddModule.js" type="text/javascript"></script>
	<script type="text/javascript" src="${jsBase}/common/ajaxfileupload.js"></script>
</body>
</html>
