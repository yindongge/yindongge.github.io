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
<title>轮播图</title>
</head>
<body>
	<div class="container" style="width:100%">
        <div class="modal show modal-control" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="margin:10px auto">
				<div class="modal-content">
					<div class="modal-body">
						<div class="row">
							<form  action="${ctx}/touchPage/saveBanner" method="post" enctype="multipart/form-data" >
								<input type="hidden" name="pageId" value="${banner.pageId}"/>	
								<input type="hidden" name="id" value="${banner.id}"/>	
								<div class="form-group alert_control">
									<label>文字标题</label>
									<input id="title" required type="text" name="title" class="form-control w260" value="${banner.title}" />
									<span class="gray">图片标题文字将作为图片Alt形式显示</span>
								</div>
								<div class="form-group alert_control">
									<label>轮播图片上传</label>
									<div id="imgdiv" style="margin-bottom:5px">
									<img id="imgShow"  width="50" height="50" src="${banner.bannerImg}"/>
									</div>
									<input type="file" id="file" name="file" class="form-control w260"  value="${banner.bannerImg}" />
									<input id="bannerImg" type="hidden" name="bannerImg" value="${banner.bannerImg}" />
									<span class="gray">建议宽1200px</span>
								</div>
								<div id="showLink" class="form-group alert_control">
									<label>图片跳转链接</label>
									<input type="text"  validate="url" name="bannerUrl" class="form-control w260" value="${banner.bannerUrl}" />
									<span class="gray">输入图片要跳转的URL地址，正确格式应以"http://"开头，点击后将以"_blank"形式另打开页面。</span>
								</div>
								<div class="form-group">
									<button id="saveForm" type="button" class="btn btn-success">保存</button>
								</div>
							</form>
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/common/kindeditor/kindeditor.js" type="text/javascript"></script>
<script src="${jsBase}/common/kindeditor/lang/zh_CN.js" type="text/javascript"></script>
<script src="${jsBase}/touchPage/editBanner.js" type="text/javascript"></script>
</body>
</html>
