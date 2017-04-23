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
			<div class="head-content">绑定新手机</div>
			<div class="head-left"><a href="${ctx}/security/center" class="link"></a></div>
		</header>
		<!-- end top -->
		<div class="acount-control">
			<form id="bindPhone">
				<input type="hidden" value="${kjjuser.orgUsers.mobilePhone}" id="mobile"/>
				<div class="acount-progress">
					<a href="javascript:void(0)" class="on">
						<span class="line-acount"><i class="i-circle"></i></span>
						<span class="acount-text">验证身份</span>
					</a>
					<a href="javascript:void(0)">
						<span class="line-acount"><i class="i-circle"></i></span>
						<span class="acount-text">绑定新手机</span>
					</a>
					<a href="javascript:void(0)">
						<span class="line-acount"><i class="i-circle"></i></span>
						<span class="acount-text">绑定成功</span>
					</a>
				</div>
				<div class="acount-tips"></div>
				<div class="acount-form">
					<input type="text" placeholder="请输入手机号" name="mobilePhone" id="mobilePhone" readOnly="true" value="已绑定手机号：${fn:substring(kjjuser.orgUsers.mobilePhone,0,3)}****${fn:substring(kjjuser.orgUsers.mobilePhone,7,11)}">
				</div>
				<div class="acount-form no-border">
					<input type="text" id="verifycode" maxlength="4" placeholder="请输入验证码">
					<button type="button" id="aIdentifyCode" class="acount-check ">获取验证码</button>
					<!-- 上边有倒数 -->
				</div>
			</form>
		</div>
		<div class="acount-button">
			<a href="javascript:void(0)" id="btnFinish">完成</a>
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
<script src="${jsBase}/security/verifyMobile.js" type="text/javascript"></script>
<script src="${jsBase}/common/common_footerbar.js" type="text/javascript"></script>
</body>
</html>