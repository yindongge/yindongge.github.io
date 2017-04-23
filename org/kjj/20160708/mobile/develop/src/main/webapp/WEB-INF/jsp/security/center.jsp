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
	<div class="box box-gray">
		<header class="header">
			<div class="head-content">账号安全</div>
			<div class="head-left"><a href="${ctx}/user/detail" class="link"></a></div>
		</header>
		<!-- end top -->
		<div class="acount-control no-margin">
			<input type="hidden" id="info" value="${info}">
			<ul class="detaillist set-acount">
				<li><a href="${ctx}/security/passwordInit">修改登录密码</a></li>
				<c:if test="${empty kjjuser.orgUsers.mobilePhone}">
				<li><a href="${ctx}/security/bindMobileInit"><span class="information" ><font color="red">未绑定</font></span>手机验证</a></li>
				</c:if>
				<c:if test="${!empty kjjuser.orgUsers.mobilePhone}">
				<li><a href="${ctx}/security/verifyOldPhone"><span class="information" ><font color="red">${fn:substring(kjjuser.orgUsers.mobilePhone,0,3)}****${fn:substring(kjjuser.orgUsers.mobilePhone,7,11)}</font></span>手机验证</a></li>
				</c:if>
			</ul>
		</div>
		<!-- 结束订单详情 -->
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
<script src="${jsBase}/common/common_footerbar.js" type="text/javascript"></script>
</body>
</html>