<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<%@include file="../common/common_css.jsp" %>
<title>快捷健商城</title>
</head>
<body>
<div class="all">
	<!-- end top -->
	<div class="header">
		<div class="container   margin-control">
			<div class="logo fl">
				<a href="${ctx}"><img src="${imgBase}/logo.jpg"></a>
			</div>
		</div>
	</div>
	<div class="login_wrapper">
		<div class="login" id="cc">
			<div class="login-form">
				<form id="form" method="post">
					<div class="login-title">
						<h2>登录</h2>
					</div>
					<div class="login-fault" style="display:none">
						<p class="red" id="showmessage"></p>
					</div>
					<div id="nameshow" class="login-item login-item1 ">
						<label for="loginname"></label>
						<input  type="text" id="username" name="username" class="login-text" placeholder="手机号/邮箱/用户名"/>
						<span class="close">x</span>
					</div>
					<div id="passshow" class="login-item login-item2">
						<label for="password"></label>
						<input type="password" id="password" name="password" class="login-text" placeholder="密码"/>
						<span class="close">x</span>
					</div>
					<div class="check" id ="divIdentifyCode" style="display:none">
						<div class="check-code">
							<input type="text" id="identifyCode" name ="identifyCode"  class="check-text"/>
							<span onclick="changeIdentifyCode()">看不清</span>
							<a><img id="imgIdentifyCode"></img></a>
						</div>
					</div>
					<div class="login-item no-border">
						<div class="login-auto">
							<span>
								<input type="checkbox" id="rememberMe" name="rememberMe" checked />
								<a>自动登录</a>
							</span>
						</div>
					</div>
					<p class="sure"><button type="button" class="btn btn-warning" id="loginsubmit">登录</button></p>
					<div class="login-auto">
							<a href="${ctx}/register/init" class="bluea">快速注册</a>
							<a href="${ctx}/security/findPasswordInit" class="pull-right bluea">忘记登录密码?</a>
					</div>
				</form>
			</div>
		</div>
	</div>

<!-- footer -->
<%@include file="../common/common_foot.jsp" %>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/login/login.js" type="text/javascript"></script>
</body>
</html>