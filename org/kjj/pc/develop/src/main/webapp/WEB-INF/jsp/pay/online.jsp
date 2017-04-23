<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<%-- <jsp:useBean id="MD5" scope="request" class="com.kjj.commserver.util.MD5"/> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<%@include file="../common/common_css.jsp" %>
<title>快捷健商城</title>
</head>
<body>
<form id="gatewayForm" action="https://tmapi.jdpay.com/PayGate" method="post" target="_blank">
	<input type="hidden" name="v_md5info"    value="" size="100"/>
	<input type="hidden" name="v_mid"        value=""/>
	<input type="hidden" name="v_oid"        value=""/>
	<input type="hidden" name="v_amount"     value=""/>
	<input type="hidden" name="v_moneytype"  value=""/>
	<input type="hidden" name="v_url"        value=""/> 
	<!--以下几项项为网上支付完成后，随支付反馈信息一同传给信息接收页 -->

	<input type="hidden"  name="remark1" value=""/>
	<input type="hidden"  name="remark2" value=""/>

	<input type="hidden"  name="pmode_id" value=""/>
</form>
<form id="payForm" action="${ctx}/alipay/pay" method="post" target="_blank">
	<input type="hidden" name="orderId" value="${order.orderId}"/>
</form>
<div class="all">
	<%@include file="../common/common_head.jsp" %>
	<!-- end top -->
	<div class="header">
		<div class="container container-width">
			<div class="logo fl">
				<a href="${ctx}"><img src="${imgBase}/logo.jpg"/></a>
				<div class="text-position">
					<strong >收银台</strong>				
				</div>
			</div>
			<div class="search fr search-special1">
				<%@include file="../common/common_search.jsp" %>
			</div>

		</div>
	</div>
		<div class="payment">
			<h4>订单提交成功，请您尽快付款！ 订单号：${order.orderId}<span class="pull-right">应付金额：<strong class="yellow"><fmt:formatNumber type="currency" pattern="0.00" value="${order.payMoney}"/>元</strong></span>
			</h4>
			<h5>请您在提交订单后<c:if test="${order.limitPayTime==null}">24小时</c:if><c:if test="${order.limitPayTime!=null}">${order.limitPayTime}分钟</c:if>内完成支付，否则订单会自动取消。
				<a id="orderDesc" class="paymenbt-detial pull-right">订单详情 <b class="glyphicon glyphicon-menu-down"></b></a>
			</h5>
			<div class="detail-list" style="display:none;">
				<c:if test="${order.sendStyle==0}">
					<p>收货地址：${kjjuser.orgShop.orgArea.show}${order.consigneeAddress} 收货人：${order.consignee} 
						<c:if test="${order.consigneeMobile!=''}">${order.consigneeMobile}</c:if>
						<c:if test="${order.consigneeMobile==''}">${order.consigneeTel}</c:if>
					</p>
				</c:if>
				<c:if test="${order.sendStyle==1}">
					<p>取货地址：${kjjuser.orgShop.orgArea.show}${kjjuser.orgShop.address} 取货人手机号：
						<c:if test="${order.consigneeMobile!=''}">${order.consigneeMobile}</c:if>
					</p>
				</c:if>
				<c:forEach var="item" items="${order.listOrderGoods}" varStatus="status">
					<c:if test="${status.first}"><p>商品名称：${item.orgProductItem.goodsName}×${item.amount}；</p></c:if>
					<c:if test="${!status.first}"><p class="p-indent">${item.orgProductItem.goodsName}×${item.amount}；</p></c:if>
				</c:forEach>
			</div>
			<!--  -->
			<div class="slideTxtBox">

						<div class="hd">			
							<ul><li>平台支付</li> <li>网银支付</li></ul>
							<span>选择支付方式</span>
						</div>
						<div class="bd">
							<div class="bd-1">	
								<ul class="bd-ul">
									<li class="b1 active"></li>
									
									<li class="b2"></li>
									<!-- 
									<li class="b3"></li>
									<li class="b4"></li>
									 -->
								</ul>
								<div class="bd-img" style="display:none;">
								</div>
							</div>
							<div class="bd-2">
								<ul class="bd-ul special">
									<li>
									<div class="bottom_bank">
											<a href="" data-code="1025">储蓄卡</a>
											<a href="" data-code="1027" class="blue">信用卡</a>
										</div>
										<span class="same-bank bk1"></span>
									</li>
									<li>
									<div class="bottom_bank">
											<a href="" data-code="1051">储蓄卡</a>
											<a href="" data-code="1054" class="blue">信用卡</a>
										</div>
										<span class="same-bank bk2"></span>
									</li>
									<li>
									<div class="bottom_bank">
											<a href="" data-code="3080">储蓄卡</a>
											<a href="" data-code="308" class="blue">信用卡</a>
										</div>
										<span class="same-bank bk3"></span>
									</li>
									<li>
									<div class="bottom_bank">
											<a href="" data-code="103">储蓄卡</a>
											<a href="" data-code="1031" class="blue">信用卡</a>
										</div>
										<span class="same-bank bk4"></span>
									</li>
									<li>
									<div class="bottom_bank">
											<a href="" data-code="3407">储蓄卡</a>
											<a href="" data-code="3011" class="blue">信用卡</a>
										</div>
										<span class="same-bank bk5"></span>
									</li>
									<li>
									<div class="bottom_bank">
											<a href="" data-code="3061">储蓄卡</a>
											<a href="" data-code="306" class="blue">信用卡</a>
										</div>
										<span class="same-bank bk6"></span>
									</li>
									<li>
									<div class="bottom_bank">
											<a href="" data-code="104">储蓄卡</a>
											<a href="" data-code="106" class="blue">信用卡</a>
										</div>
										<span class="same-bank bk7"></span>
									</li>
									<li>
									<div class="bottom_bank">
											<a href="" data-code="305">储蓄卡</a>
											<a href="" data-code="3051" class="blue">信用卡</a>
										</div>
										<span class="same-bank bk8"></span>
									</li>
									<li>
									<div class="bottom_bank">
											<a href="" data-code="316">储蓄卡</a>
											<a href="" data-code="" class="gray">信用卡</a>
										</div>
										<span class="same-bank bk9"></span>
									</li>
									<li>
									<div class="bottom_bank">
											<a href="" data-code="311">储蓄卡</a>
											<a href="" data-code="3112" class="blue">信用卡</a>
										</div>
										<span class="same-bank bk10"></span>
									</li>
									<li>
									<div class="bottom_bank">
											<a href="" data-code="309">储蓄卡</a>
											<a href="" data-code="3091" class="blue">信用卡</a>
										</div>
										<span class="same-bank bk11"></span>
									</li>
									<li class="text" id="more_bank"><span class="same-bank" >更多银行</span></li>
									<li>
									<div class="bottom_bank">
											<a href="" data-code="312">储蓄卡</a>
											<a href="" data-code="3121" class="blue">信用卡</a>
										</div>
										<span class="same-bank bk12"></span>
									</li>
									<li>
									<div class="bottom_bank">
											<a href="" data-code="3230">储蓄卡</a>
											<a href="" data-code="3231" class="blue">信用卡</a>
										</div>
										<span class="same-bank bk13"></span>
									</li>
									<li>
									<div class="bottom_bank">
											<a href="" data-code="313">储蓄卡</a>
											<a href="" data-code="3131" class="blue">信用卡</a>
										</div>
										<span class="same-bank bk14"></span>
									</li>
									<li>
									<div class="bottom_bank">
											<a href="" data-code="326">储蓄卡</a>
											<a href="" data-code="3261" class="blue">信用卡</a>
										</div>
										<span class="same-bank bk15"></span>
									</li>
									<li>
									<div class="bottom_bank">
											<a href="" data-code="314">储蓄卡</a>
											<a href="" data-code="3141" class="blue">信用卡</a>
										</div>
										<span class="same-bank bk16"></span>
									</li>
									<li>
									<div class="bottom_bank">
											<a href="" data-code="310">储蓄卡</a>
											<a href="" data-code="3101" class="blue">信用卡</a>
										</div>
										<span class="same-bank bk17"></span>
									</li>
									<li>
									<div class="bottom_bank">
											<a href="" data-code="307">储蓄卡</a>
											<a href="" data-code="3071" class="blue">信用卡</a>
										</div>
										<span class="same-bank bk18"></span>
									</li>
									<li>
									<div class="bottom_bank">
											<a href="" data-code="324">储蓄卡</a>
											<a href="" data-code="3241" class="blue">信用卡</a>
										</div>
										<span class="same-bank bk19"></span>
									</li>
									<li>
									<div class="bottom_bank">
											<a href="" data-code="343">储蓄卡</a>
											<a href="" data-code="" class="gray">信用卡</a>
										</div>
										<span class="same-bank bk20"></span>
									</li>
									<li>
									<div class="bottom_bank">
											<a href="" data-code="336">储蓄卡</a>
											<a href="" data-code="" class="gray">信用卡</a>
										</div>
										<span class="same-bank bk21"></span>
									</li>
									<li>
									<div class="bottom_bank">
											<a href="" data-code="335">储蓄卡</a>
											<a href="" data-code="" class="gray">信用卡</a>
										</div>
										<span class="same-bank bk22"></span>
									</li>
									<li>
									<div class="bottom_bank">
											<a href="" data-code="344">储蓄卡</a>
											<a href="" data-code="" class="gray">信用卡</a>
										</div>
										<span class="same-bank bk23"></span>
									</li>
									<li>
									<div class="bottom_bank">
											<a href="" data-code="302">储蓄卡</a>
											<a href="" data-code="303" class="blue">信用卡</a>
										</div>
										<span class="same-bank bk24"></span>
									</li>
									<li>
									<div class="bottom_bank">
											<a href="" data-code="3341">储蓄卡</a>
											<a href="" data-code="334" class="blue">信用卡</a>
										</div>
										<span class="same-bank bk25"></span>
									</li>
									<li>
									<div class="bottom_bank">
											<a href="" data-code="317">储蓄卡</a>
											<a href="" data-code="" class="gray">信用卡</a>
										</div>
										<span class="same-bank bk26"></span>
									</li>
									<li>
									<div class="bottom_bank">
											<a href="" data-code="342">储蓄卡</a>
											<a href="" data-code="" class="gray">信用卡</a>
										</div>
										<span class="same-bank bk27"></span>
									</li>
								</ul>
							</div>
						</div>
						
			</div>
		</div>
<div class="pop-up-box" style="display:none">
	<input type="hidden" id="locurl" value=""/>
	<div class="pop-title">登录网上银行支付<span class="close-pop">╳</span></div>
	<div class="pop-content">
		<div class="pop-tip">请您在新打开的网上银行页面进行支付，支付完成前请不要关闭该窗口</div>
		<div class="pop-button">
			<a href="${ctx}/order/detail/" class="y">已完成支付</a>
			<a href="${ctx}/usualProblem/desc?id=8" class="g">支付遇到问题</a>
		</div>
	</div>
	<div class="pop-fooot">
		<a href="">选择其他支付方式>></a>
	</div>
</div>
<div class="mask-index"></div>		
<!-- footer -->
<%@include file="../common/common_foot.jsp" %>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/pay/online.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		var locurl = '${ctx}'+"/pay/payInit?orderId="+$("input[name='orderId']").val();
		$("#locurl").val(locurl);
	});
</script>
</body>
</html>