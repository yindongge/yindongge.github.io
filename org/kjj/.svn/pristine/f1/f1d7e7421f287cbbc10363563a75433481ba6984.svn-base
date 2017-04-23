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
<title>专题锚点</title>
</head>
<body>
<div class="container-fluid">
	<div class="page-wrapper">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li>您的位置</li>
				<li class="active">专题页配置</li>
				<li class="active">锚点链接</li>
			</ul>
			<!-- 切换 -->
		    <div class="btn-group btn-group-justified" role="group" aria-label="Justified button group" >
			   <a href="${ctx}/special/edit/${specialId}"   class="btn btn-info " role="button">基本信息</a>
			   <a href="${ctx}/special/editHtml/${specialId}"  class="btn btn-info " role="button">自定义HTML</a>
			   <a href="${ctx}/special/picList/${specialId}"  class="btn btn-info " role="button">活动专题图</a>
			   <a href="${ctx}/special/productList/${specialId}" class="btn btn-info " role="button">分组商品</a>
			   <a href="javascript:void(0)" class="btn btn-primary " role="button">锚点链接</a>
		    </div>
			<!-- 切换 -->
			<form action="${ctx}/special/saveAnchor/${specialId}" method="post">
				<input type='hidden' value="${specialId}"/>
				<div class="panel panel-info" style="position:relative">
					<div class="link_url">
						<c:forEach items="${orgSpecialLinkList}" var="orgSpecialLink">
							<div class="url_list">
								<input type="text" value="${orgSpecialLink.title}" class="form-control" placeholder="锚点名称"/>
								<input type="text" value="${orgSpecialLink.url}" class="form-control" placeholder="锚点链接" validate="url"/>
								<span data-id="${orgSpecialLink.id}" class="glyphicon glyphicon-remove-circle closeme"></span>
							</div>
						</c:forEach>
					</div>
					<br/>
					<div class="continute">
						<button id="addFloorBtn" type="button" class="btn btn-info">添加</button>
						<button class="btn btn-info">保存</button>
					</div>
				</div>
			</form>
			<div id="anchorFloorTmp">
				<div class="url_list" style='display:none'>
					<input type="text" class="form-control" placeholder="锚点名称"/>
					<input type="text" class="form-control" placeholder="锚点链接" validate="url"/>
					<span data-id="0" class="glyphicon glyphicon-remove-circle closeme"></span>
				</div>
			</div>
		</div>
	</div>
</div>

<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/common/kindeditor/kindeditor.js" type="text/javascript"></script>
<script src="${jsBase}/common/kindeditor/lang/zh_CN.js" type="text/javascript"></script>
<script src="${jsBase}/special/editAnchor.js" type="text/javascript"></script>
</body>
</html>
