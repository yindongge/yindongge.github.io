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
<link href="${cssBase}/iColor.css" type="text/css" rel="stylesheet"/>
<title>新增店铺首页</title>
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
			<input type="hidden" id="ImageBasePath" name="ImageBasePath" value="${ImageBasePath}"/>
						<div class="form-group alert_control">
							<label>文字标题</label>
							<input type="text" name="title" id="title"  class="form-control w260" />
							<span class="gray">图片标题文字将作为图片Alt形式显示</span>
						</div>
						<div class="form-group alert_control">
							<label>图片跳转链接</label>
							<input type="text" name="bannerUrl" id="bannerUrl"  class="form-control w260" />
							<span class="gray">输入图片要跳转的URL地址，正确格式应以"http://"开头，点击后将以"_blank"形式另打开页面。</span>
						</div>
						<div class="form-group alert_control">
							<label>轮播图片上传</label>
							<input type="file" name="file" id="file" class="form-control w260" onchange="uploadImage()"/>
							<span class="gray" id="tip">建议宽*高尺寸为：1920*402</span><div class="imggroup"></div>
							<b id="bImg" style="display:none;"></b>
						</div>
						<div class="form-group alert_control">
							<label>背景颜色</label>
							<input type="text" name="bgColor" id="bgColor" readOnly="true"  class="form-control w260"/>
							<a  class="color"></a>
							<span class="gray">为确保显示效果美观，可设置首页全屏焦点图区域整体背景填充色用于弥补图片在不同分辨率下显示区域超出图片时的问题，可根据您焦点图片的基础底色作为参照进行颜色设置。</span>
						</div>
						<div class="form-group">
							<button type="button" id="saveBtn" class="btn btn-success" onclick="saveBanner(${flag})">保存</button>
						</div>
			</form>
		</div>
	</div>
</div>
	<%@include file="../common/common_js.jsp" %>
	<script src="${jsBase}/mobilePage/continueAddBanner.js" type="text/javascript"></script>
	<script type="text/javascript" src="${jsBase}/common/ajaxfileupload.js"></script>
	<script type="text/javascript" src="${jsBase}/mobilePage/upload.js"></script>
	<script type="text/javascript" src="${jsBase}/common/iColor.js"></script>
</div>	
</body>
</html>
