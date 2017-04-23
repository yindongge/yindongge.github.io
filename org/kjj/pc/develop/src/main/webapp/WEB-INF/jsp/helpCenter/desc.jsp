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
<div class="all memberall">
	<%@include file="../common/common_head2.jsp" %>
	<!-- end top -->
	<div class="header header-member">
		<div class="container container-width">
			<div class="severce-head">
			<div class="logo fl">
				<a href="${ctx}"><img src="${imgBase}/icon/member-logo.png"/></a>
				<div class="text-position">
					<strong>帮助中心</strong>				
				</div>		
			</div>
			<%@include file="../common/common_cart.jsp" %>
			<div class="search fr">
					<%@include file="../common/common_search.jsp" %>	
			</div>
			</div>
		</div>
	</div>

	<!-- end header -->
	<div class="center-content">
		<div class="container container-width  ">
			<div class="member-left fl">
			<div class="d-group">
				<c:forEach items="${listArticleClass}" var="item" varStatus="i">
					<dl class="d1">						
						<dt>
							${item.className}
						</dt>  
						  <c:if test="${!empty item.listArticle}">							  	
							  	<c:forEach items="${item.listArticle}" var="i">
								  	<dd>
							  			<a href="${ctx}/aboutUs/desc?id=${i.id}">${i.title}</a>
							 		</dd>
						 		</c:forEach>								
						  </c:if>
					</dl>
			   </c:forEach>
			</div>
			</div>
			<!-- member-left -->
			<div class="member-right">
				<div class="mlist ">
					<h4 class="h4-title" >${article.title}（KJJHOME.COM）</h4>
					<div class="about-cnt">
						${article.content}
					</div>
			</div>
			</div>
			<!-- end memberright -->
		</div>
	</div>
<!-- footer  -->
<%@include file="../common/common_foot.jsp" %>
</div>
<%@include file="../common/common_js.jsp"%>
</body>
</html>