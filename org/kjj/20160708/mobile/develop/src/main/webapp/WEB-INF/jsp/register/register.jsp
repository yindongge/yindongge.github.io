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
	<div class="box">
		<header class="header">
			<div class="head-content">注册</div>
			<div class="head-left"><a href="${ctx}/loginInit" class="link"></a></div>
		</header>
		<!-- end top -->
		<form action="${ctx}/register/register" id="formRegister">
		<div class="wrapper padding">
			<div class="reginlist reginlist-tips">
			</div>
			<div class="reginlist reginlist-telephone">
				<input type="tel" class="form-control" placeholder="请输入手机号" autofocus="autofocus" required="" name="mobilePhone" id="mobilePhone">
				<a href="javascript:$('#mobilePhone').val('');" class="chazi"></a>
			</div>
			<div class="reginlist reginlist-check">
				<input type="text" class="form-control form-control2" placeholder="验证码" maxlength="4" required="" name="verifycode" id="verifycode">
				<a href="javascript:void(0);" class="recive recive-color" id="aIdentifyCode">获取验证码</a>
			</div>
			<div class="reginlist reginlist-passwords">
				<input type="password" class="form-control" placeholder="请输入6-20位登录密码" autocomplete="off" required="" name="password" id="password">
				<a href="javascript:$('#password').val('');" class="chazi"></a>
			</div>
			<div class="reginlist reginlist-passwords">
				<input type="password" class="form-control" placeholder="请再输入一遍登录密码" autocomplete="off" required="" id="confirmpassword" name="confirmpassword">
				<a href="javascript:$('#confirmpassword').val('');" class="chazi"></a>
			</div>
			<div class="reginlist reginlist-btn reginlist-active ">
				<a href="javascript:void(0);" class="btna" id="btnRegister">注册并登录</a>
				<!-- 上边有激活状态 -->
			</div>
			<div class="regin-tip">
				<a href="${ctx}/loginInit" class="regina">已有账号，请登录</a>
			</div>
			
		</div>
		</form>
	</div>
	<!-- end box -->
<%@ include file="../common/common_js.jsp" %>
<script src="${jsBase}/register/register.js" type="text/javascript"></script>
</body>
</html>