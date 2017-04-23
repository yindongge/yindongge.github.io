<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<%@include file="../common/common_css.jsp" %>
<title>页面无法访问-快捷健商城</title>
</head>
<body>
<div class="all">
	<%@include file="../common/common_head.jsp" %>
	<!-- end top -->
	<div class="header">
		<div class="container container-width">
			<div class="logo fl">
				<a href="${ctx}"><img src="${imgBase}/logo.jpg"/></a>
			</div>
		</div>
	</div>
	<div class=" container container-width">
		<div class="floor floor-special1">
			<dl  class="floor-list">
				<dt><img src="${imgBase}/pic7.jpg"/></dt>
				<dd class="dd-mis">
					<h3>抱歉！页面无法访问……</h3>
					<p>可能因为：</p>
					<p>网址有错误>请检查地址是否完整或存在多余字符</p>
					<p>网址已失效>可能页面已删除，活动已下线等</p>
					<p><a href="${ctx}">返回首页</a></p>
				</dd>
			</dl>
		</div>
	</div>
	<%@include file="../common/common_popularItems.jsp" %>
</div>
<!-- footer -->
<%@include file="../common/common_foot.jsp" %>
<%@include file="../common/common_js.jsp" %>
</body>
</html>