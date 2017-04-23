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
			<div class="mlist information" id="updatePass">
			<h5 >开通余额支付</h5>
			<div class="safeset">
			<form id="form">
				<div class="form-list">
					<div class="form-left">
						手机号或邮箱：
					</div>
					<div class="form-center">
						<input type="text" name="mobileOrEmail" id="mobileOrEmail" autocomplete="off" oninput="check()" placeholder="请输入绑定的手机或邮箱">
						<input type="hidden" id="phone" name="phone" value="${kjjuser.orgUsers.mobilePhone}"/>
						<input type="hidden" id="email" name="email" value="${kjjuser.orgUsers.email}"/>
						<input type="hidden" id="userId" name="userId" value="${kjjuser.orgUsers.userId}"/>
					</div>
					<div class="form-right" id="mobEmail">
					</div>
				</div>
				<div class="form-list">
					<div class="form-left">
							 验证码：
					</div>
					<div class="form-center form-active2">
						<input type="text" name="verifycode" id="verifycode" value="" maxlength="6" autocomplete="off" class="f-special1"/>
						<button type="button" id="bsend" class="btn btn-primary">免费获取验证码</button>
					</div>
					<div class="form-right" id="showvcode">
						<p class="true hide" ><span class="glyphicon glyphicon-ok"></span></p>
					</div>
				</div>
				<div class="form-list">
					<div class="form-left">
						支付密码：
					</div>
					<div class="form-center">
						<input type="password" name="payPassword" id="password" value="" maxlength="6" autocomplete="off" placeHolder="密码长度为6位数字" onblur="checkPassword()"/>
					</div>
					<div class="form-right" id="passwordshow">
					</div>
				</div>
				<div class="form-list">
					<div class="form-left">
						确认支付密码：
					</div>
					<div class="form-center">
						<input type="password" id="confirmpassword" name="confirmpass" value="" maxlength="6" autocomplete="off" placeHolder="密码长度为6位数字" onblur="checkConfirmPassword()"/>
					</div>
					<div class="form-right" id="password2show">
					</div>
				</div>
				<div class="form-list">
					<div class="form-left">
					</div>
					<div class="form-center">
						<button type="button" class="btn btn-warning" onclick="commit()">确定</button>
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
<script src="${jsBase}/accountDeposit/setPassword.js" type="text/javascript"></script>
</body>
</html>