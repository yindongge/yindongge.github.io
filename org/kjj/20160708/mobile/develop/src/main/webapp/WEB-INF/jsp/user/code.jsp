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
			<div class="head-content">会员名片</div>
			<div class="head-left"><a href="${ctx}/user/center" class="link"></a></div>
		</header>
		<!-- end top -->
		<div class="content" style="background: #fff;">
			<a class="floorfirst reverse-member" >
				<div class="floor_h70">
					<div class="floorname">
						<div class="floorname-left">
							<p><img src="${imgBase}/p14.jpg" alt=""></p>
						</div>
						<div class="floorname-right">
							<h4>${kjjuser.orgUsers.userName}</h4>
							<h5>${kjjuser.orgUsers.levelName}</h5>
						</div>
					</div>
				</div>
			</a>
			<div class="erweima-myself">
				<img src="${ctx}/user/codeImage" alt="会员名片">
				<p class="text-center">${kjjuser.orgUsers.userCode}</p>
			</div>
		</div>
	</div>
</body>
</html>