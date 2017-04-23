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
	<!-- end header -->
	<div class="center-content">
		<div class="container container-width  ">
			<jsp:include page="../common/common_left.jsp">
				<jsp:param name="active" value="账户安全"/>
			</jsp:include>
			<!-- member-left -->
			<form action="" id="form1" name="form1">
			<div class="member-right">
				<div class="mlist information " id="basic" >
					<h5 >激活企业邀请码</h5>
					<div class="safeset-tip2">
							温馨提示：激活成功后，您将成为<strong class="red">企业会员</strong>，享受<strong class="red">更优惠的价格</strong>。 <a target="_blank" href="${ctx}/article/dispatcher/57"> 详情》</a>
					</div>
					<br/>
					<div class="form-list">
						<div class="form-left">
							姓名：
						</div>
						<div class="form-center" id="realNamediv">
							<input type="text" name="realName" id="realName" maxlength="16"/>
						</div>
						<div class="form-right">
							<p id="realNameTip" class="normal">4-16位字符，支持汉字、字母组合</p>
						</div>
					</div>
					<div class="form-list">
						<div class="form-left">
							<span class="red-star">*</span>邀请码：
						</div>
						<div class="form-center" id="invitationCodediv">
							<input type="text" name="invitationCode" id="invitationCode" maxlength="9"/>
						</div>
						<div class="form-right">
							<p id="invitationCodeTip" class="normal">9位数字</p>
						</div>
					</div>
					<div class="form-list">
						<div class="form-left">
						</div>
						<div class="form-center">
							<button type="button" class="btn btn-warning" onclick="doUseInvitation()">确定</button>
						</div>
						<div class="form-right">
						</div>
					</div>
				</div>
			</div>
			</form>
			<!-- end memberright -->
		</div>
	</div>

<!--  -->
<%@include file="../common/common_foot.jsp" %>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/security/useInvitation.js" type="text/javascript"></script>
</div>
</body>
</html>