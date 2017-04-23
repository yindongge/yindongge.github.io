<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<%@include file="../common/common_css.jsp" %>
<title>常见问题-快捷健商城</title>
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
					<strong>常见问题</strong>				
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
	<div class="w">
		<div class="kefu">
			<img src="${imgBase}/kefu.png" />
		</div>
		<div class="subside-box">
			<div class="subside-in">
				<h3 class="h3-title">常见问题分类</h3>
				<c:forEach items="${listArticleClass}" var="item" varStatus="i">
					<dl class="subside-mod <c:if test="${item.id==articleClass.parentid}">on</c:if>">
						<dt class="subside-title">
							${item.className}
							<b class="icons"></b>
						</dt>
						  <c:if test="${!empty item.listSubClass}">
						  	<dd class="subside-cnt">
								<ul class="sublist-list">
							  		<c:forEach items="${item.listSubClass}" var="i">
							  			<li class="sub-listitem"><a href="${ctx}/usualProblem/list?classid=${i.id}">${i.className}</a></li>
							 		</c:forEach>
						  		</ul>
							</dd>
						  </c:if>
				 </dl>
			   </c:forEach>
			</div>
		</div>
		<!--  -->
		<div class="subside-content">
				<div class="bread">
				<span>${articleClass.className}</span>
				<a href="${ctx}/usualProblem/list?classid=${articleClass.id}">${articleClass.className}</a>
				<span>${article.title}</span>
				</div>
				<div class="list-block">
				<h4>${article.title}</h4>
					<div class="subside-p">
						${article.content}
					</div>
					<ul class="sublist-ul">
						<c:forEach items="${listArticle}" var="i">
							<c:if test="${empty i.content}">
						  		<li ><a href="${i.url}">${i.title}</a></li>
					  		</c:if>
					  		<c:if test="${!empty i.content}">
								<li ><a href="${ctx}/usualProblem/desc?id=${i.id}"><b>.</b>${i.title}</a></li>
							</c:if>	 		 
				</c:forEach>
					</ul>
				</div>
		</div>
	</div>
<!-- footer  -->
<%@include file="../common/common_foot.jsp" %>
</div>
<%@include file="../common/common_js.jsp"%>
<script type="text/javascript">
	$(function(){
		$('.subside-title').click(function(){
			$(this).parent('.subside-mod').toggleClass('on');
		});
	});
</script>
</body>
</html>