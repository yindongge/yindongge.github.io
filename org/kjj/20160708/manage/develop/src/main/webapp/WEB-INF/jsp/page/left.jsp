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
		<ul class="nav nav-pills nav-stacked side-nav" id="ul_">
		<c:forEach var="item" items="${menu}" varStatus="status">
			<c:if test="${status.index eq 0}">
			<li  class="active"  ><a href="${ctx}${item.url}" target="main"><i class="glyphicon glyphicon-folder-close"></i>${item.modelname}</a></li>
			</c:if>
			
			<c:if test="${status.index ne 0}">
			<li  ><a href="${ctx}${item.url}" target="main"><i class="glyphicon glyphicon-adjust"></i>${item.modelname}</a></li>
			</c:if>
		</c:forEach> 
		</ul>
	</div>
<%@include file="../common/common_js.jsp" %>
</body>
<script language="javascript"> 
$(document).ready(function() {
	$('#ul_ li a').click(function(){
        $('#ul_ li').removeClass('active');
        $(this).parent().addClass('active');

   });
	
	$('#ul_ li i')[0].click();
});
	
</script>
</html>
