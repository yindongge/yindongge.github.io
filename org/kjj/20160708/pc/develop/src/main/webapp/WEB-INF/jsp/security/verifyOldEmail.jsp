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
	<div class="center-content">
		<div class="container container-width">
			<jsp:include page="../common/common_left.jsp">
				<jsp:param name="active" value="账户安全"/>
			</jsp:include>
			<div class="member-right">
			<div class="mlist information ">
				<h5 >验证邮箱</h5>
				<div class="safeset">
					<form id="defaultForm">
					<input type="hidden" value="${kjjuser.orgUsers.email}" id="email" name="email"/> 
					<div class="form-list">
						<div class="form-left">
						</div>
						<div class="form-center">
							<p>您当前绑定的邮箱为：<span class="red"></span></p>
						</div>
						<div class="form-right">
						</div>
					</div>
						<div class="form-list">
							<div class="form-left">
									 验证码：
							</div>
							<div class="form-center form-active2">
								<input type="text" name="verifycode" id="verifycode" maxlength="6" autocomplete="off" class="f-special1">
								<button type="button" id="verifycodeBtn" class="btn btn-primary">免费获取验证码</button>
							</div>
							<div class="form-right" id="form-right">
							</div>
						</div>
						<div class="form-list">
							<div class="form-left">
							</div>
							<div class="form-center">
								<button type="button" id="submitBtn" class="btn btn-warning">立即验证</button>
							</div>
							<div class="form-right">
							</div>
						</div>
					</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- footer -->
	<%@include file="../common/common_foot.jsp" %>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/security/jquery.validate.js" type="text/javascript"></script>
<script src="${jsBase}/security/verifyOldEmail.js" type="text/javascript"></script>
</body>
<style>
	p{
		  position:absolute;
	}
</style>
</html>