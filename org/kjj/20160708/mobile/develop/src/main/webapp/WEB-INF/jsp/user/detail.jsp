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
			<div class="head-content">账户管理</div>
			<div class="head-left"><a href="${ctx}/user/center" class="link"></a></div>
		</header>
		<!-- end top -->
		<div class="acount-control no-margin">
			<ul class="detaillist set-acount">
				<li><a href="${ctx}/user/userNameInit"><span class="information" >${kjjuser.orgUsers.userName}</span>用户名</a></li>
				<!-- <li><span class="information" >abominable</span>性别</li>
				<li><span class="information" >2016年12月23日</span>出生日期</li> -->
			</ul>
			<c:if test="${kjjuser.orgUsers.levelType == 1}">
				<ul class="detaillist set-acount" style="margin-top:12px;">
					<li><a href="${ctx}/enterprise/invitationInit"><span class="information" >可激活邀请码</span>企业邀请码</a></li>
				</ul>
			</c:if>
			<c:if test="${kjjuser.orgUsers.levelType == 3}">
				<ul class="detaillist set-acount" style="margin-top:12px;">
					<li class="no-rightimg"><span class="information" >已激活</span>企业邀请码</li>
				</ul>
			</c:if>
			<ul class="detaillist set-acount" style="margin-top:12px;">
				<li><a href="${ctx}/security/center"><span class="information" >可修改密码</span>安全设置</a></li>
			</ul>
		</div>
		<div class="acount-button ">
			<a href="${ctx}/logout">切换账号</a>
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
<script src="${jsBase}/common/common_footerbar.js" type="text/javascript"></script>
</body>
</html>