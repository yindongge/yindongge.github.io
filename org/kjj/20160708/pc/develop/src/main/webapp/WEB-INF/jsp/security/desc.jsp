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
			<div class="member-right">
				<div class="mlist information " id="basic" >
					<h5 >基本资料</h5>
					<div class="basic-info">
						<div class="basic-left">
							<p>会员等级：<strong class="red"> ${kjjuser.orgUsers.levelName}</strong></p>
						</div>
					</div>
					<div class="basic-info">
						<div class="basic-left">
							<input type="hidden" id="userId" name="userId" value="${kjjuser.orgUsers.userId}"></input>
							<p>用户名：<span>   ${kjjuser.orgUsers.userName}</span></p>
						</div>
						<div class="basic-right">
							<a href="${ctx}/security/updateUserName">修改用户名</a>
						</div>
					</div>
					<div class="basic-info">
						<div class="basic-left">
							<p>登录密码：<span>*********</span></p>
						</div>
						<div class="basic-right">
							<a href="${ctx}/security/updatePassword">修改密码</a>
						</div>
					</div>
					<div class="basic-info">
						<c:if test="${kjjuser.orgUsers.mobilePhone ne null && kjjuser.orgUsers.mobilePhone!=''}">
							<div class="basic-left">
								<p>手机号：<span>${fn:substring(kjjuser.orgUsers.mobilePhone,0,3)}****${fn:substring(kjjuser.orgUsers.mobilePhone,7,11)}</span></p>
							</div>
							<div class="basic-right">
								<a href="${ctx}/security/verifyOldPhone">绑定其他手机</a>
							</div>
						</c:if>
						<c:if test="${kjjuser.orgUsers.mobilePhone eq null || kjjuser.orgUsers.mobilePhone==''}">
							<div class="basic-left">
								<p>手机号：<strong class="red">   未绑定</strong></p>
							</div>
							<div class="basic-right">
								<a href="${ctx}/security/bindPhone">绑定手机号</a>
							</div>
						</c:if>
					</div>
					<div class="basic-info">
						<div class="basic-left">
							<c:if test="${fn:contains(kjjuser.orgUsers.email,'@')}">
								<p>邮箱：<strong>*****${fn:substring(kjjuser.orgUsers.email,fn:indexOf(kjjuser.orgUsers.email,'@'),fn:length(kjjuser.orgUsers.email))}</strong></p>
							</c:if>
							
							<c:if test="${!fn:contains(kjjuser.orgUsers.email,'@')}">
								<p>邮箱：<strong class="red">   未绑定</strong></p>
							</c:if>
						</div>
						 <div class="basic-right">
							 <c:if test="${!fn:contains(kjjuser.orgUsers.email,'@')}">
							<a href="${ctx}/security/bindEmail">马上绑定</a><span><strong>提示：</strong>绑定邮箱后，您也可以使用邮箱进行登录，找回密码等操作
							</span>
							</c:if>
							<c:if test="${fn:contains(kjjuser.orgUsers.email,'@')}">
								<a href="${ctx}/security/verifyOldEmail">绑定其他邮箱</a>
							
							</c:if>
							
						</div> 
					</div>
					<div class="basic-info">
						<div class="basic-left">
							<p>余额支付密码：
								<c:if test="${empty accountDeposit.payPassword }">
									<span>未设置</span></p>
								</c:if>
								<c:if test="${not empty accountDeposit.payPassword }">
								<span>******</span></p>
								</c:if>
						</div>
						<div class="basic-right">
							<c:if test="${empty accountDeposit.payPassword }">
								<a href="${ctx}/accountDeposit/setPasswordInit">开通余额支付</a>
							</c:if>
							<c:if test="${not empty accountDeposit.payPassword }">
								<a href="${ctx}/accountDeposit/updatePasswordInit">修改密码</a>
							</c:if>
						</div>
					</div>
					<div class="basic-info">
						<div class="basic-left">
							<p>上次登录：<span ><fmt:formatDate value="${kjjuser.orgUsers.lastLogin }" type="both"/></span></p>
						</div>
						<div class="basic-right">
							
						</div>
					</div>
				</div>
				
				<!-- second -->
				<div class="mlist information " style="display:none">
					<h5 >绑定邮箱</h5>
					<div class="safeset">
					<form>
						<div class="form-list">
							<div class="form-left">
									邮箱：
							</div>
							<div class="form-center form-active1">
								<input type="text" name="text1" placeholder="手机/邮箱"/>
							</div>
							<div class="form-right">
								<p class="false "><!-- <span class="glyphicon glyphicon-remove-sign"></span> --> 请输入您的号码/邮箱</p>
								<p class="true hide"><span class="glyphicon glyphicon-ok"></span></p>
							</div>
						</div>
						<div class="form-list">
							<div class="form-left">
									 验证码：
							</div>
							<div class="form-center form-active2">
								<input type="text" name="text1" class="f-special1"/>
								<button type="button" class="btn btn-primary">免费获取验证码</button>
							</div>
							<div class="form-right">
								<p class="normal "><!-- <span class="glyphicon glyphicon-remove-sign"></span> --> 请输入您的号码/邮箱</p>
								<p class="true hide"><span class="glyphicon glyphicon-ok"></span></p>
							</div>
						</div>
						<div class="form-list">
							<div class="form-left">							 
							</div>
							<div class="form-center">
								<button type="button" class="btn btn-warning">立即绑定</button>
							</div>
							<div class="form-right">					
							</div>
						</div>
					</form>
					
					</div>
				</div>
				<!-- third -->
				<div class="mlist information "  style="display:none">
					<h5 >绑定手机</h5>
					<div class="safeset">
					<form>
						<div class="form-list">
							<div class="form-left">
									手机号：
							</div>
							<div class="form-center form-active1">
								<input type="text" name="text1" placeholder="手机/邮箱"/>
							</div>
							<div class="form-right">
								<p class="false "><!-- <span class="glyphicon glyphicon-remove-sign"></span> --> 请输入您的号码/邮箱</p>
								<p class="true hide"><span class="glyphicon glyphicon-ok"></span></p>
							</div>
						</div>
						<div class="form-list">
							<div class="form-left">
									 验证码：
							</div>
							<div class="form-center form-active2">
								<input type="text" name="text1" class="f-special1"/>
								<button type="button" class="btn btn-primary">免费获取验证码</button>
							</div>
							<div class="form-right">
								<p class="normal "><!-- <span class="glyphicon glyphicon-remove-sign"></span> --> 请输入您的号码/邮箱</p>
								<p class="true hide"><span class="glyphicon glyphicon-ok"></span></p>
							</div>
						</div>
						<div class="form-list">
							<div class="form-left">							 
							</div>
							<div class="form-center">
								<button type="button" class="btn btn-warning">立即绑定</button>
							</div>
							<div class="form-right">					
							</div>
						</div>
					</form>
					
					</div>
				</div>
				<!-- four -->
				<div class="mlist information "  style="display:none">
					<h5 >绑定新邮箱</h5>
					<div class="safeset">
					<form>
						<div class="form-list">
							<div class="form-left">							 
							</div>
							<div class="form-center">
								<p class="text-center f-special3"><span class="icon-right"></span> 验证已通过</p>
							</div>
							<div class="form-right">					
							</div>
						</div>
						<div class="form-list">
							<div class="form-left">
									邮箱：
							</div>
							<div class="form-center form-active1">
								<input type="text" name="text1" placeholder="手机/邮箱"/>
							</div>
							<div class="form-right">
								<p class="false "><!-- <span class="glyphicon glyphicon-remove-sign"></span> --> 请输入您的号码/邮箱</p>
								<p class="true hide"><span class="glyphicon glyphicon-ok"></span></p>
							</div>
						</div>
						<div class="form-list">
							<div class="form-left">
									 验证码：
							</div>
							<div class="form-center form-active2">
								<input type="text" name="text1" class="f-special1"/>
								<button type="button" class="btn btn-primary">免费获取验证码</button>
							</div>
							<div class="form-right">
								<p class="normal "><!-- <span class="glyphicon glyphicon-remove-sign"></span> --> 请输入您的号码/邮箱</p>
								<p class="true hide"><span class="glyphicon glyphicon-ok"></span></p>
							</div>
						</div>
						<div class="form-list">
							<div class="form-left">							 
							</div>
							<div class="form-center">
								<button type="button" class="btn btn-warning">立即绑定</button>
							</div>
							<div class="form-right">					
							</div>
						</div>
					</form>
					
					</div>
				</div>
				<!-- five -->
				<div class="mlist information "  style="display:none">
					<h5 >绑定新手机</h5>
					<div class="safeset">
					<form>
						<div class="form-list">
							<div class="form-left">							 
							</div>
							<div class="form-center">
								<p class="text-center f-special3"><span class="icon-right"></span> 验证已通过</p>
							</div>
							<div class="form-right">					
							</div>
						</div>
						<div class="form-list">
							<div class="form-left">
									手机：
							</div>
							<div class="form-center form-active1">
								<input type="text" name="text1" placeholder="手机/邮箱"/>
							</div>
							<div class="form-right">
								<p class="false "><!-- <span class="glyphicon glyphicon-remove-sign"></span> --> 请输入您的号码/邮箱</p>
								<p class="true hide"><span class="glyphicon glyphicon-ok"></span></p>
							</div>
						</div>
						<div class="form-list">
							<div class="form-left">
									 验证码：
							</div>
							<div class="form-center form-active2">
								<input type="text" name="text1" class="f-special1"/>
								<button type="button" class="btn btn-primary">免费获取验证码</button>
							</div>
							<div class="form-right">
								<p class="normal "><!-- <span class="glyphicon glyphicon-remove-sign"></span> --> 请输入您的号码/邮箱</p>
								<p class="true hide"><span class="glyphicon glyphicon-ok"></span></p>
							</div>
						</div>
						<div class="form-list">
							<div class="form-left">							 
							</div>
							<div class="form-center">
								<button type="button" class="btn btn-warning">立即绑定</button>
							</div>
							<div class="form-right">					
							</div>
						</div>
					</form>
					
					</div>
				</div>
				<!-- six -->
				<div class="mlist information "  style="display:none" id="bindEmail">
				<h5 >验证邮箱</h5>
				<div class="safeset">
					<form>
					<div class="form-list">
						<div class="form-left">	
						邮箱：						 
						</div>
						<div class="form-center">
								<input type="text" name="text1" placeholder="邮箱"/>
							</div>
						<div class="form-right">					
						</div>
					</div>
				
						<div class="form-list">
							<div class="form-left">							 
							</div>
							<div class="form-center">
								<button type="button" class="btn btn-warning" onclick="">确定</button>
							</div>
							<div class="form-right">					
							</div>
						</div>
					</form>
					
					</div>
				</div>
				<!-- seven -->
				<div class="mlist information "  style="display:none" id="bindMobile">
					<h5 >验证手机</h5>
					<div class="safeset">
					<form>
					<div class="form-list">
						<div class="form-left">							 
						</div>
						<div class="form-center">
							<p>您当前绑定的手机号码为：<span class="red">51*****34</span></p>
						</div>
						<div class="form-right">					
						</div>
					</div>
						<div class="form-list">
							<div class="form-left">
									 验证码：
							</div>
							<div class="form-center form-active2">
								<input type="text" name="text1" class="f-special1"/>
								<button type="button" class="btn btn-primary">免费获取验证码</button>
							</div>
							<div class="form-right">
								<p class="normal "><!-- <span class="glyphicon glyphicon-remove-sign"></span> --> 请输入您的号码/邮箱</p>
								<p class="true hide"><span class="glyphicon glyphicon-ok"></span></p>
							</div>
						</div>
						<div class="form-list">
							<div class="form-left">							 
							</div>
							<div class="form-center">
								<button type="button" class="btn btn-warning">立即验证</button>
							</div>
							<div class="form-right">					
							</div>
						</div>
					</form>
					
					</div>
				</div>
				<!-- eight -->
				<div class="mlist information "  style="display:none" id="updatePass">
					<h5 >修改密码</h5>
					<div class="safeset">
						<div class="form-list">
							<div class="form-left">
									旧密码：
							</div>
							<div class="form-center">
								<input type="password" name="password1" id="password1"/>
							</div>
							<div class="form-right" id="div1">
								<p class="normal" id="password1show"><!-- <span class="glyphicon glyphicon-info-sign"></span>  -->密码长度为6-20长度的字符串！</p>
							</div>
						</div>
						<div class="form-list">
							<div class="form-left">
								新密码：
							</div>
							<div class="form-center">
								<input type="password" name="password2" id="password2"/>
							</div>
							<div class="form-right" id="div2">
								<p class="normal" id="password2show"><!-- <span class="glyphicon glyphicon-info-sign"></span>  -->密码长度为6-20长度的字符串！</p>
							</div>
						</div>
						<div class="form-list">
							<div class="form-left">
								 确认密码：
							</div>
							<div class="form-center">
								<input type="password" id="confirmpass" name="confirmpass"/>
							</div>
							<div class="form-right" id="div3">
								<p class="normal" id="confirmpassshow"><!-- <span class="glyphicon glyphicon-info-sign"></span>  -->密码长度为6-20长度的字符串！</p>
							</div>
						</div>
						<div class="form-list">
							<div class="form-left">							 
							</div>
							<div class="form-center">
								<button type="button" id="passwordclick" class="btn btn-warning" onclick="savePass()">确定</button>
							</div>
							<div class="form-right">					
							</div>
						</div>
					</div>

				</div>
				<!-- nine -->
				<div class="mlist information "  style="display:none" id="updateName">
					<h5 >修改用户名</h5>
					<div class="safeset">
						<div class="form-list">
							<div class="form-left">
									用户名：
							</div>
							<div class="form-center">
								<input type="text" name="userName" id="userName" />
							</div>
							<div class="form-right">
								<p class="normal" id="nameWin">4-20字符 字母数字下划线组成</p>
							</div>
						</div>
						<div class="form-list">
							<div class="form-left">							 
							</div>
							<div class="form-center">
								<button type="button" id="saveName" class="btn btn-warning" onclick="updateNameClick()">确定</button>
							</div>
							<div class="form-right">					
							</div>
						</div>
					</div>

				</div>
				<!-- ten -->
				<div class="mlist information " style="display:none">
					<h5 >基本资料</h5>
					<div class="basic-info">
						<div class="basic-left">
							<p>用户名：<span>  ${kjjuser.orgUsers.userName}</span></p>
						</div>
						<div class="basic-right">
							<a href="">修改用户名</a>
						</div>
					</div>
					<div class="basic-info">
						<div class="basic-left">
							<p>密码：<span>   *********</span></p>
						</div>
						<div class="basic-right">
							<a href="">修改密码</a>
						</div>
					</div>
					<div class="basic-info">
						<div class="basic-left">
							<p>手机号：<span>  ${fn:substring(kjjuser.orgUsers.mobilePhone,0,3)}****${fn:substring(user.mobilePhone,8,11)}</span></p>
						</div>
						<div class="basic-right">
							<a href="">绑定其他手机</a>
						</div>
					</div>
					<div class="basic-info">
						<div class="basic-left">
							<p>邮箱：<strong class="red">   96*****76@qq.com</strong></p>
						</div>
						<div class="basic-right">
							<a href="">绑定其他邮箱</a>
						</div>
					</div>
					<div class="basic-info">
						<div class="basic-left">
							<p>上次登录：<span >   ${kjjuser.orgUsers.lastLogin }</span></p>
						</div>
						<div class="basic-right">
							
						</div>
					</div>
				</div>
				<!-- Eleven -->
				<c:if test="${kjjuser.orgUsers.levelType=='2'}">
					<div class="mlist" style="height:142px;margin-top:10px;">
						<div class="basic-info">
							<div class="basic-left">
								<p>企业资料：<span>  </span><c:if test="${0==enterprise.status}">正在审核</c:if><c:if test="${1==enterprise.status}">审核已通过</c:if><c:if test="${2==enterprise.status}">审核未通过</c:if></p>
							</div>
							<div class="basic-right">
							    <c:if test="${1!=enterprise.status}">
									<a href="../register/editEnterprise?enterpriseId=${enterprise.enterpriseId}" style="cursor:pointer">完善基本资料</a>
									<a href="../register/uploadQualification?enterpriseId=${enterprise.enterpriseId}&security=true" style="cursor:pointer;margin-left:30px">上传资质</a>
								</c:if>
							</div>
						</div>
						<c:if test="${1==enterprise.status}">
							<div class="basic-info">
								<div class="basic-left">
									<p>企业邀请码：<span>   </span></p>
								</div>
								<div class="basic-right">
									<a href="javascript:showInvitationWin('${enterprise.enterpriseId}')">查看邀请码</a>
								</div>
							</div>
						</c:if>
						<c:if test="${1==enterprise.status}">
							<div class="basic-info">
								<div class="basic-left">
									<p>企业关联用户：<span>   </span></p>
								</div>
								<div class="basic-right">
									<a href="javascript:showEnterpriseUse('${enterprise.enterpriseId}')">管理关联用户</a>
								</div>
							</div>
						</c:if>
					</div>
				</c:if>
				<!-- Twelve 个人用户可以激活邀请码-->
				<c:if test="${kjjuser.orgUsers.levelType=='1'}">
					<div class="mlist" style="height:50px;margin-top:10px;">
						<div class="basic-info">
							<div class="basic-left">
								<p>企业邀请码：<span> 未激活</span></p>
							</div>
							<div class="basic-right">
								<a href="../security/preUseInvitationCode" style="cursor:pointer">激活</a>
							</div>
						</div>
					</div>
				</c:if>
				<!--  -->
			</div>
			
			<!-- end memberright -->
		</div>
	</div>

<!--  -->
<%@include file="../common/common_foot.jsp" %>
<div class="modify modify2 add-basic" id="invitationWin" style="display:none">
		<h5>邀请码 <button type="button" class="close">x</button></h5>
		<div class="add-basic-wrapper">
			<div class="add-basic-title">已使用 <span id="useNumdiv"></span>，未使用 <span id="no_useNumdiv">0</span></div>
			<div class="add-basic-content">
				<h4 >未使用邀请码</h4>
				<div class="span-item" id="invitationdiv">

				</div>
			</div>
		</div>
</div>
<div class="mask"></div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/security/desc.js" type="text/javascript"></script>
</div>
</body>
</html>