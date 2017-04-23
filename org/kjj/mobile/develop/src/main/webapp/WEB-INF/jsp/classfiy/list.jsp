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
		<div class="box padding-top">
			<header class="header fixed">
				<div class="indexhead">
					<div class="indexhead_content ">类目</div>
					<a class="searchicon" href="${ctx}/search/search"></a>
				</div>
				<%-- <div class="head-left"><a href="${ctx}" class="link"></a></div>	 --%>
			</header>
			<!-- end top -->
			<div class="categorybox">
				<div class="category_left fixed">
					<c:forEach var="item" items="${listClassLevelOne}" varStatus="status">
						<a href="javascript:void(0);" class="classOne <c:if test="${status.first}">active</c:if>" 
							data-class-id="${item.classId}">${item.className}</a>
					</c:forEach>
					<span class="whiteline"></span>
				</div>
				<div class="category_right">
					<h3>${listClassLevelOne[0].className}</h3>
					<%-- <div class="category_product">
						<c:forEach var="item" items="${listClassLevelTwo}" varStatus="status">
						<div class="product_item col3">
							<a href="../search/result?superClassId=${item.classId}">
								<div class="pic_box"><img src="${imgBase}/2.jpg" alt="${item.className}"></div>
								<div class=" title_box center">
									<h5>${item.className}</h5>
								</div>
							</a>
						</div>
						</c:forEach>
					</div> --%>
					<div class="contentul">
						<c:forEach var="item" items="${listClassLevelTwo}" varStatus="status">
						<a href="../search/result?superClassId=${item.classId}">${item.className}</a>
						</c:forEach>
					</div>
				</div>
			</div>
			<!-- end center -->
		</div>
	<!-- end box -->
	<jsp:include page="../common/common_footerbar.jsp">
		<jsp:param name="active" value="分类"/>
		<jsp:param name="cartCount" value="${kjjcartcount}"/>
	</jsp:include>
	<!-- end fixedbar -->
<%@ include file="../common/common_js.jsp" %>
<script src="${jsBase}/classfiy/list.js" type="text/javascript"></script>
<script src="${jsBase}/common/common_footerbar.js" type="text/javascript"></script>
</body>
</html>