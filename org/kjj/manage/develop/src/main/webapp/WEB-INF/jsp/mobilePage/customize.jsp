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
<%
	request.setCharacterEncoding("UTF-8");
	String htmlData = request.getAttribute("customize") != null ? (String)request.getAttribute("customize") : "";//放在请求域避免了jstl取值特殊字符报错，如&
%>
<link rel="stylesheet" href="${jsBase}/common/kindeditor/themes/default/default.css" />
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
			   <a href="../mobilePage/bannerList?pageId=${page.id}" class="btn btn-info" role="button">轮播图</a>
			   <a href="../mobilePage/modulePage?pageId=${page.id}" class="btn btn-info" role="button">板块区</a>
			   <a href="#" class="btn btn-primary" role="button">自定义</a>
		    </div>
			<!-- 切换 -->
			<form class="form-inline"  id="form">
				<input type="hidden" id="pageId" name="pageId" value="${page.id}"/>
				<textarea id="area" name="htmlText" class="form-control textarea-control" style="width:60%" rows="10" ><%=htmlspecialchars(htmlData)%>
				</textarea>
				<span>自定义html代码，长度不超过5000</span>&nbsp;&nbsp;<span><font color="red" id="checkmsg"></font></span>
			</form>
			<div class="form-group ">
				<button type="button" id="tijiao" class="btn btn-default w100" >保存</button>
				<button type="button" class="btn btn-default w100" onclick="cancle()">返回</button>
			</div>
		</div>
	</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/common/kindeditor/kindeditor.js" type="text/javascript"></script>
<script src="${jsBase}/common/kindeditor/lang/zh_CN.js" type="text/javascript"></script>
<script src="${jsBase}/mobilePage/customize.js" type="text/javascript"></script>
<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>
</body>
</html>
