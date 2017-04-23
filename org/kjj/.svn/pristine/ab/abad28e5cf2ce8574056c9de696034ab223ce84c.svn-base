<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="../common/common_meta.jsp" %>
<%@include file="../common/common_css.jsp" %>
<title>快捷健商城</title>
</head>
<body>
	<div class="box">
		<div class="box-content">
			<%@include file="../common/common_head.jsp" %>
		</div>
		<!-- 结束 头 -->
		<div class="future">
			<div class="future-left fl">
				<jsp:include page="../common/common_sidebar.jsp">
					<jsp:param name="active" value="关于我们"/>
				</jsp:include>
			</div>
			<div class="future-right  fr">
			 <c:if test="${empty article}">
				<img src="${imgBase}/about.png" alt="" />
			 </c:if>
			 <c:if test="${not empty article}">
				${article.content}
			 </c:if>
			</div>
		</div>

	</div>			

<%@include file="../common/common_js.jsp"%>
</body>
</html>
