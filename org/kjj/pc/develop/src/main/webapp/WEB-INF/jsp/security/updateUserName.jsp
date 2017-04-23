<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<%@include file="../common/common_css.jsp" %>


<style type="text/css">
.error {
 padding-left: 16px;
} 
</style>

<title>修改用户名-账户安全-快捷健</title>
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
		<div class="container container-width  ">
			<jsp:include page="../common/common_left.jsp">
				<jsp:param name="active" value="账户安全"/>
			</jsp:include>
			<!-- member-left -->
			<div class="member-right">
			<!-- start memberright -->
				<!-- nine -->
				<div class="mlist information " >
					<h5 >修改用户名</h5>
					<div class="safeset">
						<form method="post" id="defaultForm" action="${ctx}/security/updateUserNameData" >
							<input type="hidden" id="userId" name="userId" value="${kjjuser.orgUsers.userId}"></input>
							<div class="form-list">
								<div class="form-left">用户名： </div>
								<div class="form-center">
									<input id="userName" name="userName"  placeholder="4-20字符 字母数字下划线组成" />
								</div>
								<div class="form-right"></div>
							</div>
							<div class="form-list">
								<div class="form-left">							 
								</div>
								<div class="form-center">
									<button type="submit" class="btn btn-warning">确定</button>
								</div>
							</div>
						</form>
					</div>
				</div>	
			<!-- end memberright -->
		</div>
	</div>

<!--  -->
<%@include file="../common/common_foot.jsp" %>
<div class="mask"></div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/security/jquery.validate.js" type="text/javascript"></script>
<script src="${jsBase}/security/updateUserName.js" type="text/javascript"></script>
</div>
</body>
</html>