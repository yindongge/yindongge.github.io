<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="description" content="快捷健商城KJJHOME.COM-销售国内外各大品牌食品、零食、酒水饮料、粮油调味、个人化妆、办公日用.快乐、便捷、健康，让快捷健商城的生活更健康!"/>
<meta name="Keywords" content="网上购物,网上商城,零食,食品,酒水饮料,粮油调味,个护化妆,办公日用,快捷健商城"/>
<%@include file="../common/common_css.jsp" %>

<title>快捷健商城 – 1小时送达,0元配送,随时取货!</title>
</head>
<body>
	<form action="" id="enterpriseAddForm" name="enterpriseAddForm">
	<div class="all">
		<div class="header">
			<div class="container container-width margin-control">
				<div class="logo fl">
					<a href="${ctx}"><img src="${imgBase}/logo.jpg"/></a>
					<span class="logo-title">欢迎注册</span>
				</div>
			</div>
		</div>
		<div class="company-regin-box" style="margin-top:20px">
		    <div class="copmanyfloor">
		        <h4 style="margin:25px 0px 30px 10px;font-weight: bold;font-size: 16px;">企业用户注册</h4>
		    	<div class="company-content">
					<div class="company-a-wrapper" style="display:none">
						<a href=""><img src="${imgBase}/bei.png" alt="" />
							<div class="text-wrapper">
								<span class="strong">价格专享</span>
								<span>企业用户专享价格</span>
								<span>价格更优惠</span>
							</div>
						</a>
						<a href=""><img src="${imgBase}/time-regin.png" alt="" />
							<div class="text-wrapper">
								<span class="strong">72小时订单保留</span>
								<span>在线支付及货到付款的订单</span>
								<span>保留72小时</span>
							</div>
						</a>
						<a href=""><img src="${imgBase}/huangguan.png" alt="" />
							<div class="text-wrapper">
								<span class="strong">企业级VIP通道</span>
								<span>企业专属VIP客服</span>
								<span>售后无忧</span>
							</div>
						</a>
					</div>
					<div class="company-tip" style="border:0px">服务须知：我们的审核时限为24小时(工作日)，遇法定节假日顺延。如有疑问，请拨打企业专享热线：4000-306-603或留言咨询  。<a target="_blank" href="${ctx}/article/dispatcher/55">更多》</a></div>
				</div>
		    </div>
		    <div class="copmanyfloor">
				<div class="copmany-title" style="margin-bottom:20px">账户信息</div>
				<div class="company-content">
					<input type="hidden" id="mobilePhone" name="mobilePhone"/>
					<div class="form-list">
						<div class="form-left">
							<span class="red-star">*</span>用户名：
						</div>
						<div class="form-center" id="userNamediv">
							<input type="text" name="userName" id="userName" maxlength="20"/>
						</div>
						<div class="form-right">
							<p id="userNameTip" class="normal">4-20位字符，支持汉字、字母、数字及“-”、“_”组合</p>
						</div>
					</div>
					<div class="form-list">
						<div class="form-left">
							<span class="red-star">*</span>请设置密码：
						</div>
						<div class="form-center" id="passworddiv">
							<input type="password" name="password" id="password" maxlength="20"/>
						</div>
						<div class="form-right">
							<p id="passwordTip" class="normal">6-20位字符，有字母数字下划线组成！</p>
						</div>
					</div>
					<div class="form-list">
						<div class="form-left">
							<span class="red-star">*</span>请确认密码：
						</div>
						<div class="form-center" id="repassworddiv">
							<input type="password" name="repassword" id="repassword"/>
						</div>
						<div class="form-right">
							<p id="repasswordTip"></p>
						</div>
					</div>
				</div>
			</div>
		    <div class="copmanyfloor">
				<div class="copmany-title" style="margin-bottom:20px">公司信息</div>
				<div class="company-content">
					<div class="form-list">
						<div class="form-left">
							<span class="red-star">*</span>公司名称：
						</div>
						<div class="form-center" id="enterpriseNamediv">
							<input type="text" name="enterpriseName" id="enterpriseName" maxlength="40"/>
						</div>
						<div class="form-right">
							<p id="enterpriseNameTip"></p>
						</div>
					</div>
					<div class="form-list">
						<div class="form-left">
							<span class="red-star">*</span>公司所在区域：
						</div>
						<div class="form-center" style="margin-left:-15px" id="countydiv">
							<div class="col-sm-4" style="margin-left:0px;">
								<select name="provinceCode" id="provinceCode" style="width:118px;height:40px">
									<option value="-1">选择省或者市</option>
									<c:forEach items="${listProvince}" var="province">
										<option value="${province.code}" <c:if test="${'北京市'==province.name}">selected</c:if>>${province.name}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-sm-4">
								<select name="cityCode" id="cityCode" style="width:118px;height:40px">
								    <option value="-1">请选择市</option>
									<c:forEach items="${listCity}" var="city">
										<option value="${city.code}" <c:if test="${'北京市'==city.name}">selected</c:if>>${city.name}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-sm-4">
								<select name="countyCode" id="countyCode" style="width:118px;height:40px">
									<option value="-1">请选择区或县</option>
									<c:forEach items="${listCounty}" var="county">
										<option value="${county.code }">${county.name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-right">
							<p id="countyTip" style="margin-left:18px;width:100%"></p>
						</div>
					</div>
					<div class="form-list">
						<div class="form-left">
							<span class="red-star">*</span>公司详细地址：
						</div>
						<div class="form-center" id="addressdiv">
							<input type="text" name="address" id="address" maxlength="50"/>
						</div>
						<div class="form-right">
							<p id="addressTip"></p>
						</div>
					</div>
					<div class="form-list">
						<div class="form-left">
							推荐人手机：
						</div>
						<div class="form-center">
							<input type="text" name="referenceTel" id="referenceTel" maxlength="11" onkeypress="if(!this.value.match(/^\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?\d+)?$/))this.o_value=this.value;" onkeyup="if(!this.value.match(/^\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?\d+)?$/))this.o_value=this.value" onblur="if(!this.value.match(/^(?\d+)?$/))this.value=this.o_value;else{if(this.value.match(/^\.\d+$/))this.value=0+this.value;if(this.value.match(/^\.$/))this.value=0;this.o_value=this.value}"/>
						</div>
					</div>
					<div class="form-list">
						<div class="form-left">
							企业人数：
						</div>
						<div class="form-center">
							<select name="employees" id="employees" style="height:40px;width:360px">
								<option value="">请选择</option>
								<c:forEach items="${employees}" var="item">
									<option value="${item.key}">${item.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-list">
						<div class="form-left">
							公司行业：
						</div>
						<div class="form-center">
							<select name="industry" id="industry" style="height:40px;width:360px">
								<option value="">请选择</option>
								<c:forEach items="${industry}" var="item">
									<option value="${item.key}">${item.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-list">
						<div class="form-left">
							公司性质：
						</div>
						<div class="form-center">
							<select name="nature" id="nature" style="height:40px;width:360px">
								<option value="">请选择</option>
								<c:forEach items="${nature}" var="item">
									<option value="${item.key}">${item.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
			</div>
		    <div class="copmanyfloor">
				<div class="copmany-title" style="margin-bottom:20px">联系人信息</div>
				<div class="company-content">
					<div class="form-list">
						<div class="form-left">
							<span class="red-star">*</span>联系人姓名：
						</div>
						<div class="form-center" id="contactNamediv">
							<input name="contactName" id="contactName" maxlength="20"/>
						</div>
						<div class="form-right">
							<p id="contactNameTip"></p>
						</div>
					</div>
					<div class="form-list">
						<div class="form-left">
							<span class="red-star">*</span>所在部门：
						</div>
						<div class="form-center" id="departmentdiv">
							<select name="department" id="department" style="height:40px;width:360px">
								<option value="-1">请选择</option>
								<c:forEach items="${department}" var="item">
									<option value="${item.key}">${item.value}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-right">
							<p id="departmentTip"></p>
						</div>
					</div>
					<div class="form-list">
						<div class="form-left">
							<span class="red-star">*</span>固定电话：
						</div>
						<div class="form-center" id="landlinesdiv">
							<input type="text" name="landlines" id="landlines" maxlength="15"/>
						</div>
						<div class="form-right">
							<p id="landlinesTip"></p>
						</div>
					</div>
					<div class="form-list">
						<div class="form-left">
							<span class="red-star">*</span>联系人邮箱：
						</div>
						<div class="form-center" id="contactEmaildiv">
							<input type="text" name="contactEmail" id="contactEmail" maxlength="30"/>
						</div>
						<div class="form-right">
							<p id="contactEmailTip"></p>
						</div>
					</div>
					<div class="form-list">
						<div class="form-left">
							<span class="red-star">*</span>验证手机：
						</div>
						<div class="form-center" id="mobilediv">
							<input type="text" name="mobile" id="mobile" maxlength="11"/>
						</div>
						<div class="form-right">
							<p id="mobileTip"></p>
						</div>
					</div>
					<div class="form-list">
						<div class="form-left">
							<span class="red-star">*</span>短信验证码：
						</div>
						<div class="form-center" id="verifycodediv">
							<input type="text" name="verifycode" id="verifycode" class="f-special1" maxlength="6"/>
							<button type="button" id="bsend" onclick="sendMessage(this)"  class="btn btn-primary huoqu" style="margin-top:2px;padding: 6px 23px;">免费获取验证码</button>
						</div>
						<div class="form-right">
							<p id="verifycodeTip"></p>
						</div>
					</div>
					<div class="form-list">
						<div class="form-left">
							<span class="red-star">*</span>验证码：
						</div>
						<div class="form-center" id="identifyCodediv">
						    <input type="text" name="identifyCode" id="identifyCode" class="f-special1" maxlength="6" />
							<span><img style="margin-top:2px" id="imgIdentifyCode"/>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick="changeIdentifyCode()" style="cursor:pointer" title="点击更换验证码">看不清</a></span>
						</div>
						<div class="form-right">
							<p id="identifyCodeTip"></p>
						</div>
					</div>
					<div class="form-list form-list-special1">
						<div class="form-left">

						</div>
						<div class="form-center">
							<input type="checkbox" name="protocol_" id="protocol_" class="f-special2" checked="checked"  style="width:15px;"/>
							<p class="xieyi">阅读并接受 <a href="javascript:showprotocol()">《快捷健用户协议》</a></p>
						</div>
						<div class="form-right" id="protocolshow">

						</div>
					</div>
					<div class="form-list">
						<div class="form-left">

						</div>
						<div class="form-center">
							<button type="button" id="mySubmit" class="btn btn-warning" onclick="regist()" id="sbt" >注册</button>
						</div>
						<div class="form-right">
						</div>
					</div>
				</div>
			</div>
			
			
		</div>
	</div>	
	</form>
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
		<p class="text-center" style="margin-top:-15px;"><a href="javascript:closeprotocolagree();" class="closekjj">同意并继续</a></p>
	</div>
	<div class="login-mask" style="display:none"></div>
	<%@include file="../common/common_js.jsp" %>
	<script src="${jsBase}/register/enterpriseRegister.js" type="text/javascript"></script>
</body>
</html>