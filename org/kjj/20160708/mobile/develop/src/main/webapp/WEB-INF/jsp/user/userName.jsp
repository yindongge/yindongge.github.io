<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/common_java.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<meta name="apple-touch-fullscreen" content="yes" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />
<%@ include file="../common/common_css.jsp" %>
<title>快捷健商城</title>
</head>
<body>
	<div class="box box-control">
		<header class="header">
			<div class="head-content">修改用户名</div>
			<div class="head-left"><a href="${ctx}/user/detail" class="link"></a></div>
		</header>
		<!-- end top -->
		<div class="acount-control">
			<form>
				<div class="acount-form">
					<input type="hidden" id="oldName" value="${kjjuser.orgUsers.userName}">
					<input type="text" id="userName" placeholder="请输入用户名" value="${kjjuser.orgUsers.userName}">
					<a href="javascript:$('#userName').val('');" class="chazi"></a>
				</div>
			</form>
		</div>
		<div class="acount-button">
			<a href="javascript:void(0);" id="aSubmit">提交</a>
		</div>
		<!-- end center -->
		<footer class="footer">
			<p>客户服务热线：4000-306-603</p>
			<p>KJJHOME.COM 快捷健商城</p>
		</footer>
	</div>
	<!-- end box -->
	<jsp:include page="../common/common_footerbar.jsp">
		<jsp:param name="active" value="我的"/>
		<jsp:param name="cartCount" value="${kjjcartcount}"/>
	</jsp:include>
	<!-- end fixedbar -->
<%@ include file="../common/common_js.jsp" %>
<script src="${jsBase}/user/userName.js" type="text/javascript"></script>
<script src="${jsBase}/common/common_footerbar.js" type="text/javascript"></script>
</body>
</html>