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
<div class="all">
	<!-- end top -->
	<div class="header">
		<div class="container container-width margin-control">
			<div class="logo fl">
				<a href="${ctx}"><img src="${imgBase}/logo.jpg"></a>
			</div>
			<div class="right-tip">
				<p>已有账号<a href="${ctx}/loginInit">请登录</a></p>
			</div>
		</div>
	</div>
		<div class="regin new">
		<div class="regin-left">
			<h4>免费注册</h4>
			<form id="form">
				<div class="form-list">
					<div class="form-center" id="userdiv">
						<input type="text" id="mobilePhone" name="mobilePhone" placeholder="手机号"/>
					</div>
					<div class="check-mistake"><span class="red" id="phoneShow"></span></div>
				</div>
				<div class="form-list" id="codediv">
					<div class="form-center">
						<input type="text"  name="verifycode" id = "verifycode" class="f-special1" placeholder="验证码"/>
						<button type="button" id="bsend" class="btn btn-primary reverse_blue" onclick="sendMessage(this)">免费获取验证码</button>
					</div>
					<div class="check-mistake"><span class="red" id="showvcode"></span></div>
				</div>
				<div class="form-list">
					<div class="form-center" id="pass1div">
						<input type="password"  id="password" name="password" placeholder="密码"/>
					</div>
					<div class="check-mistake"><span class="red" id="passwordshow"></span></div>
				</div>
				<div class="form-list">
					<div class="form-center" id="pass2div">
						<input type="password"  id="confirmpassword" name="confirmpassword" placeholder="验证密码"/>
					</div>
					<div class="check-mistake"><span class="red" id="password2show"></span></div>

				</div>
				<div class="form-list">
					<div class="form-center">
						<button type="button" onclick="regist()" id="sbt" class="btn btn-warning">注册</button>
					</div>
				</div>
				<div class="form-list form-list-special1">
					<div class="form-center">
						<input type="checkbox" checked="checked" name="protocol_" id="protocol_" class="f-special2"/>
						<p class="xieyi">阅读并接受 <a href="javascript:showprotocol()">《快捷健用户协议》</a></p>
					</div>
				</div>
			</form>
		</div>
		<div class="regin-right">
			<div class="qiye-regin">
				<a href="${ctx}/register/preEnterpriseReg">企业用户注册>></a>
			</div>
		</div>
	</div>

	<!-- footer -->
	<%@include file="../common/common_foot.jsp" %>
	
<div class="kjj big" style="display:none">
<div class="title">快捷健用户注册协议<span class="pull-right close" onclick="javascript:closeprotocol();">	X</span></div>
	<div class="contentbig">
    <c:if test="${empty content}">
	    <h5>快捷健用户注册协议</h5>
		<p>本协议是您与快捷健网站（简称"本站"，网址：www.kjjhome.com）所有者（以下简称为"快捷健"）之间就快捷健网站服务等相关事宜所订立的契约，请您仔细阅读本注册协议，您点击"同意并继续"按钮后，本协议即构成对双方有约束力的法律文件。</p>
		<h5>第1条 本站服务条款的确认和接纳</h5>
		<P>1.1本站的各项电子服务的所有权和运作权归快捷健所有。用户同意所有注册协议条款并完成注册程序，才能成为本站的正式用户。用户确认：本协议条款是处理双方权利义务的契约，始终有效，法律另有强制性规定或双方另有特别约定的，依其规定。</P>
		<p>1.2用户点击同意本协议的，即视为用户确认自己具有享受本站服务、下单购物等相应的权利能力和行为能力，能够独立承担法律责任。</p>
		<p>1.3如果您在18周岁以下，您只能在父母或监护人的监护参与下才能使用本站。</p>
		<p>1.4快捷健保留在中华人民共和国大陆地区法施行之法律允许的范围内独自决定拒绝服务、关闭用户账户、清除或编辑内容或取消订单的权利。</p>
		<h5>第2条 本站服务</h5>
		<P>2.1快捷健通过互联网依法为用户提供互联网信息等服务，用户在完全同意本协议及本站规定的情况下，方有权使用本站的相关服务。</P>
		<p>2.2用户必须自行准备如下设备和承担如下开支：（1）上网设备，包括并不限于电脑或者其他上网终端、调制解调器及其他必备的上网装置；（2）上网开支，包括并不限于网络接入费、上网设备租用费、手机流量费等。</p>
		<h5>第3条 用户信息</h5>
		<P>3.1用户应自行诚信向本站提供注册资料，用户同意其提供的注册资料真实、准确、完整、合法有效，用户注册资料如有变动的，应及时更新其注册资料。如果用户提供的注册资料不合法、不真实、不准确、不详尽的，用户需承担因此引起的相应责任及后果，并且快捷健保留终止用户使用快捷健各项服务的权利。</P>
		<P>3.2用户在本站进行浏览、下单购物等活动时，涉及用户真实姓名/名称、通信地址、联系电话、电子邮箱等隐私信息的，本站将予以严格保密，除非得到用户的授权或法律另有规定，本站不会向外界披露用户隐私信息。 </P>
    </c:if>
	<c:if test="${!empty content}">${content}</c:if>
 	</div>
 	<hr/>
	<p class="text-center"><a href="javascript:closeprotocolagree();" class="closekjj">同意并继续</a></p>
</div>
<div class="login-mask" style="display:none"></div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/register/register.js" type="text/javascript"></script>
</body>
</html>