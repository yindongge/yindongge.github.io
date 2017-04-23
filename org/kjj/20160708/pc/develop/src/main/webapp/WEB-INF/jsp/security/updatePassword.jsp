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
		<div class="container container-width  ">
			<jsp:include page="../common/common_left.jsp">
				<jsp:param name="active" value="账户安全"/>
			</jsp:include>
			<!-- member-left -->
			<div class="member-right">
			<!-- start memberright -->
				<!-- eight -->
				<div class="mlist information "   id="updatePass">
					<h5 >修改密码</h5>
					<div class="safeset">
						<form method="post" id="defaultForm" action="${ctx}/security/updatePasswordData" >
							<input type="hidden" id="userId" name="userId" value="${kjjuser.orgUsers.userId}"></input>
							<div class="form-list">
								<div class="form-left">旧密码： </div>
								<div class="form-center">
									<input type="password" name="oldPassword" id="oldPassword" placeHolder="密码长度为6-20长度的字符串"/>
								</div>
								<div class="form-right"></div>
							</div>
							<div class="form-list">
								<div class="form-left">新密码： </div>
								<div class="form-center">
									<input type="password" name="password" id="password" placeHolder="密码长度为6-20长度的字符串"/>
								</div>
								<div class="form-right" ></div>
							</div>
							<div class="form-list">
								<div class="form-left">确认密码： </div>
								<div class="form-center">
									<input type="password" id="confirmpass" name="confirmpass" placeHolder="密码长度为6-20长度的字符串"/>
								</div>
								<div class="form-right" ></div>
							</div>
							<div class="form-list">
								<div class="form-left">							 
								</div>
								<div class="form-center">
									<button type="submit"class="btn btn-warning">确定</button>
								</div>
								<div class="form-right">					
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
<script src="${jsBase}/security/updatePassword.js" type="text/javascript"></script>
</div></div>
</body>
</html>