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
		<div class="container container-width margin-control">
			<div class="logo fl">
				<a href="${ctx}"><img src="${imgBase}/logo.jpg"/></a><span class="p-span">| <a href="${ctx}/security/findPasswordInit">找回密码</a></span>
			</div>
			<div class="right-tip">
				<p>想起密码？现在<a href="${ctx}/loginInit">登录</a></p>
			</div>
		</div>
	</div>
	<div class="regin">
	<div class="regin-center">
			<div class="regin-center-title">找回密码</div>
			<div class="regin-line">
				<div class="active">
					<span class="firsr-span"><i>✔</i></span>
					<span class="second-span">验证身份</span>
				</div>
				<div  class="active">
					<span class="firsr-span"><i></i></span>
					<span class="second-span">设置新密码</span>
				</div>
				<div >
					<span class="firsr-span"><i></i></span>
					<span class="second-span">完成</span>
				</div>
			</div>
			<div class="regin-center-content">
				<form id="form">
				<div class="form-list">
					<div class="form-center">
						<input type="password" name="password" id="password" placeholder="新密码">
					</div>
					<div class="check-mistake"><span class="red" id="passwordshow"></span></div>
				</div>
				<div class="form-list">
					<div class="form-center">
						<input type="password" name="confirmpassword" id="confirmpassword" placeholder="新密码确认">
					</div>
					<div class="check-mistake"><span class="red" id="password2show"></span></div>
				</div>
				<div class="form-list">
					<div class="form-center">
						<button type="button" id="subButton" onclick="updatePassword()" class="next-click">完成</button>
					</div>
				</div>
				</form>
			</div>
		</div>
	</div>

	<!-- footer -->
	<%@include file="../common/common_foot.jsp" %>
	
<div class="kjj big" style="display:none">
</div></div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/password/updatePass.js" type="text/javascript"></script>
</body>
</html>