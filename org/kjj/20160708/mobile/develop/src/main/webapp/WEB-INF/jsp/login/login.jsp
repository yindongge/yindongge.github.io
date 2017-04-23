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
			<div class="head-content">登录</div>
			<div class="head-left"><a href="${ctx}" class="link"></a></div>
		</header>
		<!-- end top -->
		<div class="wrapper padding">
			<div class="reginlist reginlist-tips">
			</div>
			<form action="${ctx}/login" id="formLogin">
			<div class="reginlist reginlist-telephone">
				<input type="text" class="form-control" placeholder="手机号/邮箱/用户名" autofocus="autofocus" required="" name="loginName" id="loginName">
				<a href="javascript:$('#loginName').val('');" class="chazi"></a>
			</div>
			<div class="reginlist reginlist-passwords">
				<input type="password" class="form-control" placeholder="请输入密码" autocomplete="off" required="" name="password" id="password">
				<a href="javascript:$('#password').val('');" class="chazi"></a>
			</div>
			<div class="reginlist reginlist-check">
				<input type="text" class="form-control form-control2" placeholder="请输入验证码" maxlength="6" required="" name="identifyCode" id="identifyCode">
				<a href="javascript:void(0);" class="recive" id="aIdentifyCode"><img id="imgIdentifyCode" src="${ctx}/identifyCode" alt="点击刷新"/></a>
			</div>
			<div class="reginlist  reginlist-text">
			</div>
			<div class="reginlist reginlist-btn reginlist-active ">
				<a type="button" class="btna" id="btnLogin">立即登录</a>
				<!-- 上边有激活状态 -->
			</div>
			</form>
			<%-- 
				<div class="reginlist reginlist-op">
					<a href="${ctx}/register/init">注册新账号</a>
				</div> 
			--%>
			<div class="regin-tip">
				<a href="${ctx}/register/init" class="fast-regina">注册新账号</a>
				<a href="${ctx}/security/findPwdInit" class="forget-password" style="float:right;text-align:right">忘记登录密码？</a>
			</div>
		</div>
	</div>
	<!-- end box -->
<%@ include file="../common/common_js.jsp" %>
<script src="${jsBase}/login/login.js" type="text/javascript"></script>
</body>
</html>