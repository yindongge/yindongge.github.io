<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<%@include file="../common/common_css.jsp" %>

<title>修改余额支付密码-账户安全-快捷健</title>
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
			<div class="member-right">
				<div class="mlist information" id="updatePass">
					<h5 >修改支付密码<a href="${ctx}/accountDeposit/findPasswordInit" class="blue pull-right" style="margin-left: 5px;font-weight:400;font-size:12px;">忘记支付密码</a></h5>
					<div class="safeset">
						<form id="form" >
							<input type="hidden" id="userId" name="userId" value="${kjjuser.orgUsers.userId}"/>
							<div class="form-list">
								<div class="form-left">旧密码： </div>
								<div class="form-center">
									<input type="password" name="oldPassword" id="oldPassword" value="" maxlength="6" autocomplete="off" placeHolder="密码长度为6位数字"/>
								</div>
								<div class="form-right" id="oldpasswordshow"></div>
							</div>
							<div class="form-list">
								<div class="form-left">新密码： </div>
								<div class="form-center">
									<input type="password" name="payPassword" id="password" value="" maxlength="6" autocomplete="off"  placeHolder="密码长度为6位数字"/>
								</div>
								<div class="form-right" id="passwordshow"></div>
							</div>
							<div class="form-list"> 
								<div class="form-left">确认密码： </div>
								<div class="form-center">
									<input type="password" id="confirmpass" name="confirmpass" value="" maxlength="6" autocomplete="off"  placeHolder="密码长度为6位数字"/>
								</div>
								<div class="form-right" id="password2show"></div>
							</div>
							<div class="form-list">
								<div class="form-left">							 
								</div>
								<div class="form-center">
									<button type="button"  class="btn btn-warning"  onclick="commit()">确定</button>
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
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/accountDeposit/updatePassword.js" type="text/javascript"></script>
</div>
</body>
</html>