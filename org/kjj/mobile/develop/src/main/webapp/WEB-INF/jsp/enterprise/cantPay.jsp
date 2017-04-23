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
	<div class="box ">
		<header class="header">
			<div class="head-content">企业用户购买提示</div>
			<div class="head-left"><a href="${ctx}" class="link"></a></div>
		</header>
		<!-- end top -->
		<div class="qiye-check">
			<div class="qiye-floor1">
				<img src="${imgBase}/redtanhao.png" alt="">
				<p>您的企业账号未审核通过，审核通过后才可购买！</p>
			</div>
			<div class="qiye-floor2">
				<div class="qiye-floor-item">
					<span class="check1">温馨提示</span>
					<p>1、请登录PC网站：http://www.kjjhome.com，打开“个人中心-账户安全”，查看具体信息</p>
					<p>2、如有疑问请联系客服：4000-306-603</p>
				</div>
			</div>
		</div>
	</div>
	<!-- end box -->
<%@ include file="../common/common_js.jsp" %>
</body>
</html>