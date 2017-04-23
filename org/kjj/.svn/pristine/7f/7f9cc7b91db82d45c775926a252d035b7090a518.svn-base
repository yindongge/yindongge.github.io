<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<%@include file="../common/common_css.jsp" %>
<title></title>


</head>
<body>	
<div class="wrapper">
		<!--结束登录-->
		<nav class="navbar navbar-inverse navbar-fixed-top"  >
			<div class="navbar-header">				
					<img src="${ctx}/source/img/logo.jpg"/>

			</div>
			<ul id="head_" class="nav navbar-nav navbar-control">
				<c:forEach var="item" items="${kjjadminmodel}" varStatus="status">
					<li <c:if test="${status.index eq 0}"> class="active" </c:if>><a href="${ctx}/page/left?modelid=${item.value.modelid}" target="leftFrame">${item.value.modelname}</a></li>
		 		</c:forEach> 
			</ul>
			<ul class="nav navbar-nav pull-right  header-control">
				<li ><a href="javascript:void(0);"><p>欢迎${kjjadmin.orgAdminUser.userName}</p></a></li>
				<li><a href="${ctx}/logout">安全退出</a></li>
				<li><a href="${ctx}/admin/editPasswordInit" target="main">账号管理</a></li>
				<li><a href="http://www.kjjhome.com" target="_blank">前台首页</a></li>
			</ul>
		</nav>
		<!--结束导航条-->
	<!--结束头部-->
	</div>
<%@include file="../common/common_js.jsp" %>
<script language="javascript"> 
$(document).ready(function() {
	$('#head_ li a').click(function(){
        $('#head_ li').removeClass('active');
        $(this).parent().addClass('active');
        $(this).blur();

   });
});
</script>
</body>
</html>