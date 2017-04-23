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
					<strong>资讯订阅</strong>				
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
		<div class="newsall">
		<div class="news-left">
			<c:forEach items="${listArticle}" var="article">
			<div class="news-item">
				<div class="nitem-img"><a href="javascript:void(0);" onclick="jump(${article.id});"><img src="${article.image}"/></a></div>
				<div class="nitem-text">
					<h5>
						<a href="javascript:void(0);" onclick="jump(${article.id});">
						${article.title}
						</a>
					</h5>
					<p>${article.subtitle}</p>
				</div>
			</div>
			</c:forEach>
		</div>
		<div class="news-right">
			<div class="fixbigimg"><a href="javascript:void(0);"><img src="${imgBase}/n1.jpg" alt="" /></a></div>
			<div class="fixsmallimg">
				<a href="javascript:void(0);"><img src="${imgBase}/3.jpg"/></a>
				<a href="javascript:void(0);"><img src="${imgBase}/5.png" alt="" /></a>
				<a href="javascript:void(0);"><img src="${imgBase}/6.png"/></a>
				<a href="javascript:void(0);"><img src="${imgBase}/7.png" alt="" /></a>
			</div>
			<div class="fixbigimg"><a href="#"><img src="${imgBase}/n2.jpg" alt="" /></a></div>
		</div>
	</div>
<!--footer  -->
<%@include file="../common/common_foot.jsp" %>

</div>
<div class="kjj" style="display:none;" id="tooltip">
	<div class="title">温馨提示</div>
	<p>需要订阅后才能阅读，5秒后将自动<a href="${ctx }/loginInit">跳转</a></p>
</div>
<%@include file="../common/common_js.jsp"%>
<script type="text/javascript">
function jump(id){
	var url = '${ctx }/industryInfo/desc?id='+id;
	var isLogin = ${kjjuser.login};
	if(isLogin){
		window.open(url,'_blank');
	}else{
		$('#tooltip').show();
		setTimeout(function(){
			location.href = '${ctx}/loginInit';
		},5000);
	};
};
</script>
</body>
</html>