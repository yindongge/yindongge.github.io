<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/common_java.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<meta name="apple-touch-fullscreen" content="yes" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />
<%@ include file="../common/common_css.jsp" %>
<title>快捷健商城</title>
</head>
<body>
	<div class="box">
		<header class="header">
			<div class="head-content">个人中心</div>
			<div class="head-left"><a href="${ctx}/order/addReInit" class="link"></a></div>
		</header>
		<!-- end top -->
		<div class="paper <c:if test="${!kjjorderform.takeInvoice}">gray</c:if>">
			<div class="paper_list h75">
				<a href="javascript:void(0);" class="<c:if test="${kjjorderform.takeInvoice}">on</c:if>" id="invoiceYes">要发票</a>
				<a href="javascript:void(0);" class="<c:if test="${!kjjorderform.takeInvoice}">on</c:if>"id="invoiceNo">不要发票</a>
			</div>
			<div class="paper_list h90">
				<h2 class="paper-title">
					发票类型：
				</h2>
				<div class="paper-select">
					<a class="select-a"><span class="circle on"></span>普通发票</a>
					<!-- <a class="select-a"><span class="circle"></span>电子发票</a> -->
				</div>
			</div>
			<div class="paper_list h140">
				<h2 class="paper-title">
					发票抬头：
				</h2>
				<div class="paper-select paperspecial">
					<div class="writepaper">
						<span id="spanPerson" class="circle <c:if test="${!kjjorderform.takeInvoice or kjjorderform.invoice == '个人'}">on</c:if>"></span>
						<span class="circle-lable">个人</span>
					</div>
				</div>
				<div class="paper-select paperspecial">
					<div class="writepaper noborder">
						<input type="text" placeholder="公司名称" class="write" id="textCompany" value="<c:if test="${kjjorderform.takeInvoice and kjjorderform.invoice != '个人'}">${kjjorderform.invoice}</c:if>">
						<span id="spanCompany" class="circle <c:if test="${kjjorderform.takeInvoice and kjjorderform.invoice != '个人'}">on</c:if>"></span>
						<span class="circle-lable">公司</span>
					</div>
				</div>
			</div>
			<div class="paper_list h140">
				<h2 class="paper-title">
					普通商品发票内容：
				</h2>
				<div class="paper-select paperspecial">
					<div class="writepaper noborder">
						<span class="circle on"></span>
						<span class="circle-lable">明细</span>
					</div>
				</div>
				<!-- 
				<div class="paper-select paperspecial  ">
					<div class="writepaper noborder">
						<span class="circle on"></span>
						<span class="circle-lable">办公用品</span>
					</div>
				</div>
				 -->
			</div>
			<!--  -->
			<div class="buttonsure">
				<a href="javascript:void(0);" class="surea" id="btnConfirm">确定</a>
			</div>
		</div>
	
	</div>
	<!-- end box -->
<%@ include file="../common/common_js.jsp" %>
<script src="${jsBase}/order/invoice.js" type="text/javascript"></script>
</body>
</html>