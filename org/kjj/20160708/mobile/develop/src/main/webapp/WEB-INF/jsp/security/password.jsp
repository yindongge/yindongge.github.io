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
			<div class="head-content">修改登录密码</div>
			<div class="head-left"><a href="${ctx}/security/center" class="link"></a></div>
		</header>
		<!-- end top -->
		<div class="acount-control no-margin">
			<form action="${ctx}/security/password" method="post" id="formPassword">
				<div class="acount-tips">${info}</div>
				<div class="acount-form">
					<input type="password" placeholder="请输入旧密码" autofocus="" id="oldPassword" name="oldPassword">
					<a href="javascript:$('#oldPassword').val('');" class="chazi"></a>
				</div>
				<div class="acount-form no-border">
					<input type="password" placeholder="请输入新密码" id="password" name="password">
					<a href="javascript:$('#password').val('');" class="chazi"></a>
				</div>
					<div class="acount-form no-border">
					<input type="password" placeholder="请输入确认密码" id="password2" name="password2">
					<a href="javascript:$('#password2').val('');" class="chazi"></a>
					<!-- 上边有倒数 -->
				</div>
			</form>
		</div>
		<div class="acount-button">
			<p class="red" style="margin-bottom:10px;">*6-20位字符，建议字母，数字和符号两种以上组合</p>
			<a href="javascript:void(0);" id="btnFinish">完成</a>
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
<script src="${jsBase}/security/password.js" type="text/javascript"></script>
<script src="${jsBase}/common/common_footerbar.js" type="text/javascript"></script>
</body>
</html>