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

<title>快捷健商城</title>
</head>
<body>
	<form id="searchForm" action="${ctx}/search/result" method="post">
		<div class="box box-gray">
			<header class="header ">
				<div class="head-content classify">
					<input id="keyword" type="text" name="keyword" placeholder="搜索商品">
					<a class="searchicon"  onclick="searchForm.submit();" href="javascript:void(0)" ></a>
				</div>
				<div class="head-left"><a href="javascript:history.go(-1);" class="link"></a></div>
			</header>
			<div class="search-wrapper">
				<div class="search-list">
					<p class="search-title">最近搜索<span id="clearCookies" class="clear">清除</span></p>
					<div class="search-item">
						<c:forEach var="searchKey" items="${searchKey}">
						<a href="javascript:void(0)">${searchKey}</a>
						</c:forEach>
					</div>
				</div>
				
			</div>
		</div>
	</form>
<%@ include file="../common/common_js.jsp"%>
<script src="${jsBase}/common/jquery.cookie.js" type="text/javascript" ></script>
<script type="text/javascript" src="${jsBase}/search/search.js"></script>
</body>
</html>