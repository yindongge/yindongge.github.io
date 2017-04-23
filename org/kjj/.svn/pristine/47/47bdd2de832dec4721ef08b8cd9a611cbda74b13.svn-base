<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<%@include file="../common/common_css.jsp" %>

<title>修改密码-账户安全-快捷健</title>
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
					<strong>个人中心</strong>				
				</div>		
			</div>
			<%@include file="../common/common_cart.jsp" %>
			<div class="search fr search-special1">
				<%@include file="../common/common_search.jsp" %>	
			</div>
			</div>
		</div>
	</div>
	<!-- end header -->
	<div class="center-content">
		<form  class="form-inline" id ="pageform" name ="pageform" action="${ctx}/security/enterpriseUserList" method="post">
		<input type="hidden" id="enterpriseId" value="${enterpriseId}"/>
		<div class="container container-width  ">
			<jsp:include page="../common/common_left.jsp">
				<jsp:param name="active" value="账户安全"/>
			</jsp:include>
			<!-- member-left -->
			<div class="member-right">
				<div class="pay-table">
				    <div class="a-group">
						<div class="a-group-first">
							<a class="first_a">管理关联用户</a>
						</div>
					</div>
					<table class="table table-hover table-striped table-bordered">
						<thead>
							<tr class="info">
								<th>手机号</th>
								<th>会员名</th>
								<th>姓名(备注)</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${page.content}" varStatus="status">
							<tr>
								<td>${item.mobilePhone}</td>
								<td style="text-align: center;">${item.userName}</td>
								<td style="text-align: center;">
									<input type="text" value="${item.realName}" onblur="realNameBlur('realName${status.index+1}')" maxlength="20" id="realName${status.index+1}"/>
									<span id="realName${status.index+1}Span" style="color:red;width:100px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
								</td>
								<td style="text-align: center;">
									<a href="javascript:void(0);" name="btnCancel" onclick="doChangeName('${item.id}','realName${status.index+1}');">修改姓名</a>
									<a href="javascript:void(0);" name="btnCancel" onclick="doDelUser(${item.id});">解除关联</a>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
					<%@include file="../common/common_page_select.jsp"%>
				</div>
			</div>
		</div>
		</form>
<!--  -->
<%@include file="../common/common_foot.jsp" %>
<div class="mask"></div>
<%@include file="../common/common_js.jsp"%>
<script src="${jsBase}/security/enterpriseUserList.js" type="text/javascript"></script>
</div>
</body>
</html>