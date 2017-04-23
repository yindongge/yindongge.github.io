<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/common_java.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<meta name="apple-touch-fullscreen" content="yes" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />
<%@ include file="../common/common_css.jsp"%>

<title>修改支付密码</title>
</head>
<body>
<div class="box box-gray">
		<header class="header">
			<div class="head-content">修改支付密码</div>
			<div class="head-left"><a href="javascript:history.go(-1);" class="link"></a></div>
		</header>
		<!-- end top -->
		<div class="acount-control no-margin">
			<form>
				<div class="acount-tips"></div> 
				<div class="acount-progress">
					<a href="javascript:void(0);" class="on">
						<span class="line-acount"><i class="i-circle"></i></span>
						<span class="acount-text">验证身份</span>
					</a>
					<a href="javascript:void(0);">
						<span class="line-acount"><i class="i-circle"></i></span>
						<span class="acount-text">设置新密码</span>
					</a>
					<a href="javascript:void(0);">
						<span class="line-acount"><i class="i-circle"></i></span>
						<span class="acount-text">设置成功</span>
					</a>
				</div>
				
				<div id="acountDiv">
					<div class="acount-form">
						<input id="pwd" type="password" autofocus="autofocus" placeholder="请输入原密码">
					</div>
				</div>
				
				<div id="pwdDiv" style="display:none">
					<div class="acount-form" >
						<input id="pwd1" type="password" placeholder="请输入新密码" >
					</div>
					<div class="acount-form no-border">
						<input id="pwd2" type="password" placeholder="请再次输入新密码">
					</div>
				</div>
				
				
			</form>
		</div>
		<div  class="acount-button">
			<a id="nextBtn" href="javascript:void(0);">下一步</a>
		</div>
		<div  class="acount-button" style="display:none">
			<p class="red" style="margin-bottom:10px;">*6位字符，只能是数字</p>
			<a id="confirmBtn" href="javascript:void(0);">确认</a>
		</div>
		<div class="acount-button" style="display:none">
			<a  href="${ctx}/user/center">完成</a>
		</div>
	</div>
	
<%@ include file="../common/common_js.jsp"%>
<script type="text/javascript" src="${jsBase}/accountDeposit/updatePwd.js"></script>
</body>
</html>