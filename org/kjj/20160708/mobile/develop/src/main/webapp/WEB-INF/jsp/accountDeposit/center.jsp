<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/common_java.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<meta name="apple-touch-fullscreen" content="yes" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />
<%@ include file="../common/common_css.jsp"%>

<title>预存款</title>
</head>
<body>
<div class="box box-gray">
	<header class="header">
		<div class="head-content">预存款</div>
		<div class="head-left"><a href="javascript:history.go(-1);" class="link"></a></div>
	</header>
	<!-- end top -->
	<div class="ready-pay-wrapper">
		<c:if test="${flg==0}">
			<div class="ready-pay-tip">
				<p>您还未开通余额支付，开通后，可在购物时使用余额进行支付</p>
				<p><a href="${ctx}/accountDeposit/setPwd">立即开通</a></p>
			</div>
		</c:if>
		<div class="ready-pay-price">
			<div class="r-p-left">
				<span class="red">${orgAccountDeposit.fundAmount+orgAccountDeposit.allowanceAmount}</span>
				<span>可用余额</span>
			</div>
			<div class="r-p-right">
				<span class="gray">${orgAccountDeposit.frozenAmount}</span>
				<span>冻结余额</span>
			</div>
		</div>
	</div>
	<div class="ready-pay-tishi">
		<div class="qiye-floor2">
			<div class="qiye-floor-item">
				<span class="check1">温馨提示</span>
				<p>1、可用余额是您在快捷健商城的一个账户，如账户内有可用余额，下单时可以直接勾选使用，抵消部分总额。可用余额在购物时充当现金使用。</p>
				<p>2、冻结余额，此部分余额无法进行购物和提现等。</p>
			</div>
		</div>
	</div>
	<c:if test="${flg==1}">
		<div class="new-reverse">
			<div id="updatePayPassword" class="pay_list no-margin">
				<div class="h50 givepadding">
					<span class="paper_news">修改支付密码：</span>
					<span class="pull-right"></span>
				</div>
			</div>
			<div id="findPayPassword" class="pay_list no-margin">
				<div class="h50 givepadding">
					<span class="paper_news">找回支付密码：</span>
					<span class="pull-right"></span>
				</div>
			</div>
		</div>
	</c:if>
</div>
	
<%@ include file="../common/common_js.jsp"%>
<script type="text/javascript" src='${jsBase}/accountDeposit/center.js'></script>
</body>
</html>