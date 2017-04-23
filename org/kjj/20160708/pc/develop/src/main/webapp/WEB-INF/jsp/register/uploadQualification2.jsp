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
<div class="all">
    
	<div class="container container-width">
	    <div class="header">
			<div class="container container-width margin-control">
				<div class="logo fl">
					<a href="${ctx}"><img src="${imgBase}/logo.jpg"/></a>
					<span class="logo-title">欢迎注册</span>
				</div>
			</div>
		</div>
		<div class="container container-width  company-regin-box">
			<form action="" id="form1" name="form1">
				<input type="hidden" name="enterpriseId" id="enterpriseId" value="${enterprise.enterpriseId}"/>
				<input type="hidden" name="security" id="security" value="${security}"/>
				
				<div class="copmanyfloor">
			        <h4 style="margin:25px 0px 30px 10px;font-weight: bold;font-size: 16px;">企业用户注册</h4>
			    	<div class="company-content">
						<div class="company-tip" style="border:0px">服务须知：我们的审核时限为24小时(工作日)，遇法定节假日顺延。如有疑问，请拨打企业专享热线：4000-306-603或留言咨询  。<a target="_blank" href="${ctx}/article/dispatcher/55">更多》</a></div>
					</div>
			    </div>
			    <div class="copmanyfloor">
					<div class="copmany-title">企业、事业单位资质信息</div>
					<div class="company-content">
		     			<div class="graytip-box">
		     				<p>1、单位是企业的用户须使用营业执照进行注册审核；</p>
		     				<p>2、民办非企业单位须使用组织机构代码证进行注册审核</p>
		     				<p>3、若无法提供相关证照，请联系电话：4000-306-603。</p>
		     			</div>
					</div>
				</div>
				<div class="copmanyfloor">
					<div class="copmany-title">证件照片</div>
					<div class="company-content">
						<div class="switch-wrapper" style="width:875px;">
							<div class="switch-button">
								<a  class="active lefta1">电脑文件上传<span></span></a> 
								<!-- <a  class="lefta2">二维码拍摄上传<span></span></a> -->
							</div>
							<div class="switch-content" style="width:875px;">
								<div class="switch-item" style="display:block">
									<div class="s-item2" style="width:875px;">
										<p class="switch-title"><span class="glyphicon glyphicon-exclamation-sign"></span>您提供的证照信息快捷健将予以严格的加密保护，保证此证照信息仅用于注册审核。</p>
										<div class="switch-step clearfix">
											<div class="second-same-step">
											    <c:if test="${null != enterprise.organizationCodeImg}">
											    	<a ><img src="${ImageBaseUrl}${enterprise.organizationCodeImg}" id="organizationCodeImg_show" onclick="fireUpload1()" alt="点击选择图片文件" title="点击选择图片文件" style="cursor:pointer"/></a>
											        <input type="hidden" name="organizationCodeImg" id="organizationCodeImg" value="${enterprise.organizationCodeImg}"/>
											    </c:if>
											    <c:if test="${null == enterprise.organizationCodeImg}">
											    	<a ><img src="${imgBase}/80.png" id="organizationCodeImg_show" onclick="fireUpload1()" alt="点击选择图片文件" title="点击选择图片文件" style="cursor:pointer"/></a>
											   		<input type="hidden" name="organizationCodeImg" id="organizationCodeImg" value=""/>
											    </c:if>
											    <input type="file" name="file" id="file" style=" position:absolute; top:0; right:0; height:24px; filter:alpha(opacity:0);opacity: 0;width:260px" onchange="uploadImage()"/>
												<div class="red" style="margin-top:5px" id="bImg1">sasadsadsad</div>
											</div>
											<div class=" second-same-step">
		
											</div>
											<div class="step-right second-same-step" >
											    <c:if test="${null != enterprise.businessLicenImg}">
											        <a ><img src="${ImageBaseUrl}${enterprise.businessLicenImg}" id="businessLicenImg_show" onclick="fireUpload2()"  alt="点击选择图片文件" title="点击选择图片文件" style="cursor:pointer"/></a>
											    	<input type="hidden" name="businessLicenImg" id="businessLicenImg" value="${enterprise.businessLicenImg}"/>
											    </c:if>
											    <c:if test="${null == enterprise.businessLicenImg}">
											        <a ><img src="${imgBase}/81.png" id="businessLicenImg_show" onclick="fireUpload2()"  alt="点击选择图片文件" title="点击选择图片文件" style="cursor:pointer"/></a>
											    	<input type="hidden" name="businessLicenImg" id="businessLicenImg" value=""/>
											    </c:if>
												
												<div class="red" style="margin-top:5px" id="bImg2"></div>
											</div>
										</div>
										<div class="switch-step clearfix margin-top ">
											<div class=" second-same-step special-step">
												<a ><img src="${imgBase}/card2.png"/></a>
											</div>
		
											<div class="step-right second-same-step special-step">
												<a ><img src="${imgBase}/card3.png"/></a>
											</div>
										</div>
										<div class="switch-tips">
											<span class="red" id="nodeTip">图片尺寸最大不超过5M，照片支持jpg/jpeg/bmp/png格式。</span>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="switch-backbtn">
							<button type="button" style="background: #0175b9;color: #fff;font-size: 14px;width: 160px;height: 36px;height: 36px;border-radius: 2px;-webkit-border-radius:2px;" id="mySubmit" onclick="saveData()">完成</button>
						</div>
					</div>
				</div>
				</form>
		</div>
	</div>
</div>
<!--  -->
<%@include file="../common/common_foot.jsp" %>
<%@include file="../common/common_js.jsp" %>
<script type="text/javascript" src="${jsBase}/common/ajaxfileupload.js"></script>
<script src="${jsBase}/register/uploadQualification.js" type="text/javascript"></script>
</div>
</body>
</html>