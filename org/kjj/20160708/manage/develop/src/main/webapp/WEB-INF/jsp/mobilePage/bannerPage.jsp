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
			<ul class="breadcrumb">
				<li>您的位置</li>
				<li><a href="#">店铺</a></li>
				<li><a href="#">首页管理</a></li>
				<li class="active">修改轮播图</li>
			</ul>
			<!-- 切换 -->
			<div class="btn-group btn-group-justified" role="group" aria-label="Justified button group">
			    <a href="../mobilePage/editPage?pageId=${page.id}" class="btn btn-info " role="button">基本信息</a>
			   <a href="#" class="btn btn-primary" role="button">轮播图</a>
			   <a href="#" class="btn btn-info" role="button">焦点区</a>
			   <a href="#" class="btn btn-info" role="button">促销区</a>
			   <a href="../mobilePage/modulePage?pageId=${page.id}" class="btn btn-info" role="button">板块区</a>
		    </div>
			<!-- 切换 -->
			<form class="form-inline" id="mobilePageform" name ="mobilePageform" action="../mobilePage/updateMobileBanner" method="post" enctype="multipart/form-data">
			<input type="hidden" id="pageId" name="pageId" value="${page.id}"/>
			<input type="hidden" id="ImageBasePath" name="ImageBasePath" value="${ImageBasePath}"/>
			<table class="table table-bordered new-table">
				<tbody>
				<div class="panel panel-info">
				<c:forEach items="${blist}" var="banner">
				<div class="panle_img">
					<img src="${banner.bannerImg}" alt="" />
					<input type="hidden" id="id" name="id" value="${banner.id}"/>
					<span class="glyphicon glyphicon-remove-circle closeme" onclick="doDelete(${banner.id});"></span>
					<span class="glyphicon glyphicon-arrow-up up_me"></span>
					<span class="glyphicon glyphicon-arrow-down down_me"></span>
					<a  class="btn btn-success btn-click" onclick="editBanner(${banner.id})"><span class="glyphicon glyphicon-pencil"></span>编辑</a>
				</div>
				</c:forEach>
				<div class="continute">
					<a  class="btn btn-info" id="continueAdd">继续添加轮播图</a>
				</div>
			</div>
				</tbody>
			</table>
			</form>
		</div>
	</div>
</div>
	<%@include file="../common/common_js.jsp" %>
	<script src="${jsBase}/mobilePage/bannerPage.js" type="text/javascript"></script>
</body>
</html>
