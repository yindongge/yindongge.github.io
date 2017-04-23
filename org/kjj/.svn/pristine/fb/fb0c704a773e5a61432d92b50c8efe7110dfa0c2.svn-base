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
<title>确认订单信息-快捷健商城</title>
<script type="text/javascript">
function setCookie(c_name,value,expiredays){
	var exdate=new Date();
	exdate.setDate(exdate.getDate()+expiredays);
	document.cookie= c_name+ "=" +escape(value)+((expiredays==null) ? "" : ";expires="+exdate.toGMTString());
}
</script>
</head>
<body>
	<form id="orderForm" method="post">
	<div class="box control-padding">
		<input type="hidden" id="takeDate" name="takeDate" value="<fmt:formatDate value="${kjjorderform.takeDate}" type="date" pattern="yyyy-MM-dd"/>"/>
		<input type="hidden" id="sendDate" name="sendDate" value="<fmt:formatDate value="${kjjorderform.sendDate}" type="date" pattern="yyyy-MM-dd"/>"/>
		<input type="hidden" id="sendTimeStart" name="sendTimeStart" value="<fmt:formatDate value="${kjjorderform.sendTimeStart}" type="time" pattern="HH:mm:ss"/>"/>
		<input type="hidden" id="sendTimeEnd" name="sendTimeEnd" value="<fmt:formatDate value="${kjjorderform.sendTimeEnd}" type="time" pattern="HH:mm:ss"/>"/>
		<input type="hidden" id="payStyle" name="payStyle" value="${kjjorderform.payStyle}"/>
		<input type="hidden" id="sendStyle" value="${kjjuser.orgUsers.lastSendStyle}"/>
		<input type="hidden" id="useDeposit" name="useDeposit" value="${kjjorderform.useDeposit}"/>
		<input type="hidden" id="depositMoney" name="depositMoney" value="${kjjorderform.depositMoney}"/>
		<input type="hidden" id="orderMoney" value="${kjjorderform.orderMoney}"/>
		<c:forEach items="${kjjorderform.orgOrderSend.time}" var="item" varStatus="status">
        <input type="hidden" id="hiddrenTime${status.index}"
           	data-time-start="${kjjorderform.orgOrderSend.time[status.index][0]}" 
           	data-time-end="${kjjorderform.orgOrderSend.time[status.index][1]}"
           	<c:forEach items="${kjjorderform.orgOrderSend.date}" var="item" varStatus="statusDate">
           	<c:if test="${kjjorderform.orgOrderSend.isSend[status.index][statusDate.index]==true}">
           	data-${item}="true"
           	</c:if>
           	<c:if test="${kjjorderform.orgOrderSend.isSend[status.index][statusDate.index]==false}">
           	data-${item}="false"
           	</c:if>
           	</c:forEach>/>
       	</c:forEach>
		<header class="header">
			<div class="head-content">结算</div>
			<div class="head-left"><a href="${ctx}/cart/list" class="link"></a></div>
		</header>
		<!-- end top -->
		<div class="paper">
			<c:if test="${alertAccountDeposit}">
			<div class="ready-pay-tip">
				<p>您还未开通余额支付，开通后，可在购物时使用余额进行支付</p>
				<p><a href="${ctx}/accountDeposit/setPwd">立即开通</a></p>
			</div>
			</c:if>
			<c:if test="${kjjuser.orgUsers.lastSendStyle == 1 and !kjjorderform.canTake}">
			<!-- 新修改 -->
			<div class="new-reverse">
				<div class="pay_list no-margin" id="divNoTake">
					<div class="h50 givepadding">
						<span class="paper_news">送至：</span>
						<span class="pull-right"><i class="red">仅配送，请选择收货地址</i></span>
					</div>
				</div>
			</div>
			</c:if>
			<c:if test="${kjjuser.orgUsers.lastSendStyle == 1 and kjjorderform.canTake}">
			<!-- 新修改 -->
			<div class="new-reverse">
				<div class="pay_list no-margin" id="divTake">
					<div class="h50 givepadding">
						<span class="paper_news">提货点：</span>
						<span class="pull-right">${kjjuser.orgShop.shopName}提货点</span>
					</div>
				</div>
				<div class="pay_list no-margin" id="showSelectTake">
					<div class="h50 givepadding">
						<span class="paper_news">提货时间：</span>
						<span class="pull-right" id="spanTake"><fmt:formatDate value="${kjjorderform.takeDate}" type="date" pattern="yyyy-MM-dd"/></span>
					</div>
				</div>
				<div class="pay_list no-margin">
					<div class="h50 givepadding" >
						<span class="paper_news">提货手机：</span>
						<span class="pull-right" >
								<input type="text" class="mobile-input" name="consigneeMobile" value="<c:if test="${empty kjjorderform.consigneeMobile}">${kjjuser.orgUsers.mobilePhone}</c:if><c:if test="${!empty kjjorderform.consigneeMobile}">${kjjorderform.consigneeMobile}</c:if>"></span>
					</div>
				</div>
			</div>
			<div class="new-reverse reverse-paymethod">
				<c:if test="${!empty kjjorderform.accountDeposit}">
				<div id="divUseDeposit" class="pay_list no-margin">
					<div class="h50 givepadding">
						<span class="paper_news">余额：<i class="gray">可用余额：<em class="rmb">￥</em><fmt:formatNumber type="currency" pattern="0.00" value="${kjjorderform.accountDeposit.canUseAmount}"/></i></span>
						<span id="spanUseDeposit" class="pull-right" style="color:red;<c:if test="${!kjjorderform.useDeposit}">display:none;</c:if>">-<i class="rmb">￥</i><fmt:formatNumber type="currency" pattern="0.00" value="${kjjorderform.depositMoney}"/></span>
						<c:if test="${kjjorderform.accountDeposit.status == 1}"><span class="pull-right" style="color:red;">已锁定，不可用</span></c:if>
					</div>
					<div class="checkbox-single <c:if test="${empty kjjorderform.depositMoney or kjjorderform.payStyle == 1}">disabled</c:if><c:if test="${kjjorderform.useDeposit}">on</c:if>" data-can-use="<c:if test="${empty kjjorderform.depositMoney}">false</c:if>"></div>
				</div>
				</c:if>
				<div class="pay_list no-margin">
					<div class="h50 givepadding">
						<span class="paper_news">在线支付：</span>
						<span class="pull-right"></span>
					</div>
					<div class="checkselect on"></div>
				</div>
			</div>
			</c:if>
			<c:if test="${kjjuser.orgUsers.lastSendStyle == 0}">
			<!-- 新修改 -->
			<!-- 新修改地址 -->
			<div class="reverse_address" id="divSend">
				<div class="reverse_a_title">配送地址</div>
				<div class="pay_list h90">
					<div class="new-built">
						<p class="builtitem"><span class="builtname">${kjjuser.orgUserAddress.addressName}</span><span class="builtphone">${kjjuser.orgUserAddress.mobile}</span></p>
						<p class="built-address"><span></span>${kjjuser.orgUserAddress.area[1]}${kjjuser.orgUserAddress.area[2]}${kjjuser.orgUserAddress.sendRangeName}${kjjuser.orgUserAddress.address}</p>
					</div>
				</div>
			</div>
			<c:if test="${empty kjjorderform.sendDate}">
				<div class="pay_list">
					<div class="h50">
						<span class="paper_news">送达时间：</span>
						<span class="pull-right"><i class="red">已超出配送时间</i></span>
					</div>
				</div>
			</c:if>
			<c:if test="${!empty kjjorderform.sendDate}">
				<div class="pay_list " id="showSelectSend">
					<div class="h50 givepadding">
						<span class="paper_news">送达时间：</span>
						<span class="singleblue">修改</span>
						<span id="spanSend"><fmt:formatDate value="${kjjorderform.sendDate}" type="date" pattern="yyyy-MM-dd"/> <fmt:formatDate value="${kjjorderform.sendTimeStart}" type="time" pattern="HH:mm"/>-<fmt:formatDate value="${kjjorderform.sendTimeEnd}" type="time" pattern="HH:mm"/></span>
						
					</div>
				</div>
			</c:if>
			<div class="new-reverse reverse-paymethod">
				<c:if test="${!empty kjjorderform.accountDeposit}">
				<div id="divUseDeposit" class="pay_list no-margin">
					<div class="h50 givepadding">
						<span class="paper_news">余额：<i class="gray">可用余额：<em class="rmb">￥</em><fmt:formatNumber type="currency" pattern="0.00" value="${kjjorderform.accountDeposit.canUseAmount}"/></i></span>
						<span id="spanUseDeposit" class="pull-right" style="color:red;<c:if test="${!kjjorderform.useDeposit}">display:none;</c:if>">-<i class="rmb">￥</i><fmt:formatNumber type="currency" pattern="0.00" value="${kjjorderform.depositMoney}"/></span>
						<c:if test="${kjjorderform.accountDeposit.status == 1}"><span class="pull-right" style="color:red;">已锁定，不可用</span></c:if>
					</div>
					<div class="checkbox-single <c:if test="${empty kjjorderform.depositMoney or kjjorderform.payStyle == 1}">disabled</c:if><c:if test="${kjjorderform.useDeposit}">on</c:if>" data-can-use="<c:if test="${empty kjjorderform.depositMoney}">false</c:if>"></div>
				</div>
				</c:if>
				<div id="divPayStyleOnline" class="pay_list no-margin">
					<div class="h50 givepadding">
						<span class="paper_news">在线支付：</span>
						<span class="pull-right"></span>
					</div>
					<div class="checkselect <c:if test="${kjjorderform.payStyle == 0}">on</c:if>"></div>
				</div>
				<div id="divPayStyleLocal" class="pay_list no-margin">
					<div class="h50 givepadding">
						<span class="paper_news">货到付款：</span>
						<span class="pull-right"></span>
					</div>
					<div class="checkselect <c:if test="${kjjorderform.payStyle == 1}">on</c:if>"></div>
				</div>
			</div>
			</c:if>
			<!-- goodslist -->
			<div class="goodslist">
				<div class="carlist-top">商品信息</div>
				<c:forEach var="reach" items="${kjjorderform.mapReach}" varStatus="statusDiscount">
				<div class="cut_item">
					<div class="manjian_left">
						<a href="javascript:void(0);" class="yellow_a">${reach.value.label}</a>
						<span class="inline_span">${reach.value.title}</span>
						<span class="yellow">已满
						<c:if test="${reach.value.reachStyle == 0}">${reach.value.sumMoney}元</c:if>
						<c:if test="${reach.value.reachStyle == 1}">${reach.value.sumAmount}件</c:if>
						<c:if test="${!empty reach.value.orgReachCondition.mapReachDiscount[1]}">
						(已减${reach.value.orgReachCondition.mapReachDiscount[1].discountMultiple*reach.value.orgReachCondition.mapReachDiscount[1].common})
						</c:if>
						</span>
					</div>
				<c:forEach items="${kjjorderform.listCartAll}" var="item" varStatus="status">
				<c:if test="${item.orgCart.discountId == reach.key}">
				<div class="car-list margin-top">
					<div class="car-item">
						<div class="car-content">
							<div class="carlist-a">
								<div class="carlist-body">
									<div class="carlist-img">
										<a href="${ctx}/item/${item.orgProductItemAll.orgProductItemAide.goodsId}">
										<img src="${item.orgProductItemAll.orgProductItem.goodsImg180}"></a>
									</div>
									<div class="carlist-text">
										<a href="${ctx}/item/${item.orgProductItemAll.orgProductItemAide.goodsId}"><span class="title">${item.orgProductItemAll.orgProductItem.goodsName}</span></a>
										<div class="price-list">
											<span class="yellow">价格：<fmt:formatNumber type="currency" pattern="0.00" value="${item.orgProductItemAll.orgProductItemAide.showPrice}"/></span>
										</div>
										<div class="price-list">
										 	<span class="blackquanity">数量：${item.orgProductItemAll.orgProductItemAide.userBuy}件</span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				</c:if>
				</c:forEach>
				<c:if test="${!empty reach.value.orgReachCondition.mapReachDiscount[3]}">
					<c:forEach var="item" items="${reach.value.orgReachCondition.mapReachDiscount[3].listReachGive}">
						<div class="gray_bg_zeng" style="padding-left:30px">
							<span>赠品：${item.goodsName}</span>
							<span class="pull-right">X${item.giveAmount}</span>
						</div>
					</c:forEach>
				</c:if>
				</div>
				</c:forEach>
				<div class="cut_item">
				<c:forEach items="${kjjorderform.listCartAll}" var="item" varStatus="status">
				<c:if test="${empty item.orgCart.discountId or item.orgCart.discountId == 0 or !kjjorderform.mapReach.containsKey(item.orgCart.discountId)}">
				<div class="car-list margin-top">
					<div class="car-item">
						<div class="car-content">
							<div class="carlist-a">
								<div class="carlist-body">
									<div class="carlist-img">
										<a href="${ctx}/item/${item.orgProductItemAll.orgProductItemAide.goodsId}">
										<img src="${item.orgProductItemAll.orgProductItem.goodsImg180}"></a>
									</div>
									<div class="carlist-text">
										<a href="${ctx}/item/${item.orgProductItemAll.orgProductItemAide.goodsId}"><span class="title">${item.orgProductItemAll.orgProductItem.goodsName}</span></a>
										<div class="price-list">
											<span class="yellow">价格：<fmt:formatNumber type="currency" pattern="0.00" value="${item.orgProductItemAll.orgProductItemAide.showPrice}"/></span>
										</div>
										<div class="price-list">
										 	<span class="blackquanity">数量：${item.orgProductItemAll.orgProductItemAide.userBuy}件</span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				</c:if>
				</c:forEach>
				</div>
			</div>
			<!--  goodlist-->
			<div class="pay_detail">
				<div class="pay_list no-margin" id="divInvoice">
					<div class="h50 givepadding">
						<span class="paper_news">发票信息：</span>
						<span class="pull-right">
						<c:if test="${!kjjorderform.takeInvoice}">
						不要发票
						</c:if>
						<c:if test="${kjjorderform.takeInvoice}">
						${kjjorderform.invoice}
						</c:if>
						</span>
					</div>
					
				</div>
				<div class="pay_list" id="divCoupon">
					<div class="h50 givepadding">
						<span class="paper_news">优惠券：</span>
						<c:if test="${fn:length(kjjorderform.listCouponRecord) == 0}">
						<a href="javascript:void(0);" class="haveuse">无可用优惠券</a>
						</c:if>
						<c:if test="${fn:length(kjjorderform.listCouponRecord) > 0}">
							<c:if test="${empty kjjorderform.couponRecordId}">
							<span>未使用</span>
							<span class="tag1">有${fn:length(kjjorderform.listCouponRecord)}张可用</span>
							</c:if>
							<c:if test="${!empty kjjorderform.couponRecordId}">
							<span>已优惠<i class="rmb">￥</i><i class="english red"><fmt:formatNumber type="currency" pattern="0.00" value="${kjjorderform.couponRecordSelect.orgCoupon.discountMoney}"/></i></span>
							<span>已使用1张</span>
							</c:if>
						</c:if>
					</div>
				</div>
			</div>
			
			<!--新加提示  -->
			<div class="new-reverse reverse-paymethod">
				<div class="pay_list no-margin">
					<div class="h50 givepadding">
						<span class="paper_news" style="color: #ccc">留言：</span>
						<input type="text" id="remark" name="remark" class="mobile-input" placeholder="限45个字，可不填" value="${kjjorderform.remark}" maxlength="45">
					</div>
				</div>
			</div>
			<div class="new-reverse reverse-paymethod no-p-right">
				<div class="pay_list no-margin">
					<div class="h50 givepadding">
						<span class="paper_news "><strong>商品总额：</strong></span>
						<span class="pull-right red"><strong><i class="rmb">￥</i><fmt:formatNumber type="currency" pattern="0.00" value="${kjjorderform.accounts}"/></strong></span>
					</div>
				</div>
				<div class="pay_list no-margin">
					<div class="h50 givepadding">
						<span class="paper_news">商品优惠：</span>
						<span class="pull-right red">-<i class="rmb">￥</i><fmt:formatNumber type="currency" pattern="0.00" value="${kjjorderform.discount}"/></span>
					</div>
				</div>
				<c:if test="${!empty kjjorderform.couponRecordId}">
				<div class="pay_list no-margin">
					<div class="h50 givepadding">
						<span class="paper_news">优惠券：</span>
						<span class="pull-right red">-<i class="rmb">￥</i><fmt:formatNumber type="currency" pattern="0.00" value="${kjjorderform.couponRecordSelect.orgCoupon.discountMoney}"/></span>
					</div>
				</div>
				</c:if>
				<div id="showUseDeposit" class="pay_list no-margin" <c:if test="${!kjjorderform.useDeposit}">style="display:none;"</c:if>>
					<div class="h50 givepadding">
						<span class="paper_news">使用余额：</span>
						<span class="pull-right red">-<i class="rmb">￥</i><fmt:formatNumber type="currency" pattern="0.00" value="${kjjorderform.depositMoney}"/></span>
					</div>
				</div>
				<div class="pay_list no-margin">
					<div class="h50 givepadding">
						<span class="paper_news"></span>
						<span class="pull-right" style="font-size: 14px;"><strong>实付款：<i class="rmb red">￥</i><i class="red payMoney"><c:if test="${kjjorderform.useDeposit}"><fmt:formatNumber type="currency" pattern="0.00" value="${kjjorderform.orderMoney - kjjorderform.depositMoney}"/></c:if><c:if test="${!kjjorderform.useDeposit}"><fmt:formatNumber type="currency" pattern="0.00" value="${kjjorderform.orderMoney}"/></c:if></i></strong></span>
					</div>
				</div>
			</div>
			<footer class="footer">
				<p>客户服务热线：4000-306-603</p>
				<p>KJJHOME.COM 快捷健商城</p>
			</footer>
			<!-- end paper -->
			<div class="cover special-pay-cover"></div>
		</div>
		<!-- bottom fixed -->
		<c:if test="${kjjuser.orgUsers.lastSendStyle == 1 and !kjjorderform.canTake}">
			<div class="fixed-bottom-tip">
				<span class="red">仅配送，请选择收货地址</span>
			</div>
		</c:if>
		<c:if test="${kjjuser.orgUsers.lastSendStyle == 0 and empty kjjorderform.sendDate}">
			<div class="fixed-bottom-tip">
				<span class="red">已超出配送时间</span>
			</div>
		</c:if>
		<div class="fixed-bottom">
			<div class="priceall">
				<c:if test="${empty kjjorderform.couponRecordId}">
					<div class="pa-left">
						<a>已优惠：<span class="rmb">￥</span><fmt:formatNumber type="currency" pattern="0.00" value="${kjjorderform.discount}"/></a>
					</div>
					<div class="pa-center">
						<a>还需付：<strong class="red"><span class="rmb">￥</span><span class="payMoney"><c:if test="${kjjorderform.useDeposit}"><fmt:formatNumber type="currency" pattern="0.00" value="${kjjorderform.orderMoney - kjjorderform.depositMoney}"/></c:if><c:if test="${!kjjorderform.useDeposit}"><fmt:formatNumber type="currency" pattern="0.00" value="${kjjorderform.orderMoney}"/></c:if></span></strong></a>
					</div>
				</c:if>
				<c:if test="${!empty kjjorderform.couponRecordId}">
					<div class="pa-left">
						<a>已优惠：<span class="rmb">￥</span><fmt:formatNumber type="currency" pattern="0.00" value="${kjjorderform.discount+kjjorderform.couponRecordSelect.orgCoupon.discountMoney}"/></a>
					</div>
					<div class="pa-center">
						<a>还需付：<strong class="red"><span class="rmb">￥</span><span class="payMoney"><c:if test="${kjjorderform.useDeposit}"><fmt:formatNumber type="currency" pattern="0.00" value="${kjjorderform.orderMoney - kjjorderform.depositMoney}"/></c:if><c:if test="${!kjjorderform.useDeposit}"><fmt:formatNumber type="currency" pattern="0.00" value="${kjjorderform.orderMoney}"/></c:if></span></strong></a>
					</div>
				</c:if>
				<c:if test="${(kjjuser.orgUsers.lastSendStyle == 1 and !kjjorderform.canTake) or (kjjuser.orgUsers.lastSendStyle == 0 and empty kjjorderform.sendDate)}">
					<div class="pa-r">
						<a href="javascript:void(0);">提交订单</a>
					</div>
				</c:if>
				<c:if test="${!(kjjuser.orgUsers.lastSendStyle == 1 and !kjjorderform.canTake) and !(kjjuser.orgUsers.lastSendStyle == 0 and empty kjjorderform.sendDate)}">
					<div class="pa-r deletep">
						<a id="addOrder" href="javascript:void(0);">提交订单</a>
					</div>
				</c:if>
			</div>
		</div>
		<!-- bottom fixed -->
	</div>
	
	<div id="divDepositPassword" class="trigger-box" style="display:none;">
		<div class="trigger-showbox">
				<div class="info-confrim text-cneter ">
					<p class="info-c-title control-close">请输入支付密码<span class="close"></span></p>
					<input type="hidden" id="depositPassword" name="depositPassword">
					<div class="input-pass-a">
						<ul class="mm_box">
					      <li><span></span></li>
					      <li><span></span></li>
					      <li><span></span></li>
					      <li><span></span></li>
					      <li><span></span></li>
					      <li><span></span></li>
					    </ul>
					</div>
					<p class="redtip"></p>
					<div class="forget-box"><a href="${ctx}/accountDeposit/findPwd" class="forget-password">忘记支付密码</a></div>
				</div>
			</div>
			<div class="trigger-numbox">
				 <div class="numb_box">
				    <ul class="nub_ggg">
				      <li><a href="javascript:void(0);">1</a></li>
				      <li><a href="javascript:void(0);" class="zj_x">2</a></li>
				      <li><a href="javascript:void(0);">3</a></li>
				      <li><a href="javascript:void(0);">4</a></li>
				      <li><a href="javascript:void(0);" class="zj_x">5</a></li>
				      <li><a href="javascript:void(0);">6</a></li>
				      <li><a href="javascript:void(0);">7</a></li>
				      <li><a href="javascript:void(0);" class="zj_x">8</a></li>
				      <li><a href="javascript:void(0);">9</a></li>
				      <li><span></span></li>
				      <li><a href="javascript:void(0);" class="zj_x">0</a></li>
				      <li><span  class="del"> <img src="${imgBase}/closebig.jpg"></span></li>
				    </ul>
				  </div>
			</div>
	</div>
	</form>
	
	<!-- showinfo -->
	<div class="aletall">
		<div class="showinfo h_220" id="selectSend">
			<div class="week-select">
				<div class="swiper-container swiper-send-date">
			    	<div class="swiper-wrapper" id="divSendDate">
			    		<c:forEach items="${kjjorderform.orgOrderSend.date}" var="item" varStatus="status">
			    		<c:if test="${kjjorderform.orgOrderSend.isSend[fn:length(kjjorderform.orgOrderSend.isSend)-1][status.index]==true}">
			            <div class="swiper-slide <c:if test="${item==kjjorderform.takeDate}">swiper-slide-active</c:if>" data-date="${item}" data-week="${kjjorderform.orgOrderSend.week[status.index]}"><span>${item}(${kjjorderform.orgOrderSend.week[status.index]})</span></div>
			        	</c:if>
			        	</c:forEach>
			        </div>
			    </div>
			</div>
			<div class="time-select">
				<div class="swiper-container swiper-send-time">
			    	<div class="swiper-wrapper" id="divSendTime">
			        </div>
			    </div>
			</div>
			<div class="swiper_title">
				<span class="span-center">选择配送时间</span>
				<span class="s_t_left" id="hideSelectSend">取消</span>
				<span class="s_t_right" id="confirmSelectSend">确定</span>
			</div>
			<div class="swiper_line"></div>
		</div>
	</div>
	
	<!--showinfo  --><script src="${jsBase}/common/fastclick.js" type="text/javascript"></script>
	<div class="aletall ">
		<div class="showinfo h_220" id="selectTake">
			<div class="swiper-container swiper-take">
		    	<div class="swiper-wrapper">
		    		<c:forEach items="${kjjorderform.orgOrderSend.date}" var="item" varStatus="status">
		    		<c:if test="${kjjorderform.orgOrderSend.isTake[status.index]==true}">
		            <div class="swiper-slide" data-date="${item}" data-week="${kjjorderform.orgOrderSend.week[status.index]}"><span>${item}(${kjjorderform.orgOrderSend.week[status.index]})</span></div>
		            </c:if>
		            </c:forEach>
		        </div>
		    </div>
			<div class="swiper_title">
				<span class="span-center">选择自提时间</span>
				<span class="s_t_left" id="hideSelectTake">取消</span>
				<span class="s_t_right" id="confirmSelectTake">确定</span>
			</div>
			<div class="swiper_line"></div>
		</div>
	</div>
	
	<c:if test="${leadme ne 'no'}">
		<c:if test="${kjjuser.orgUsers.lastSendStyle == 0}">
		<div class="leadme" onclick="javascript:setCookie('leadmeorder','no',30);this.parentNode.removeChild(this);"><img src="${imgBase}/addmask3.png"></div>
		</c:if>
		<c:if test="${kjjuser.orgUsers.lastSendStyle == 1}">
		<div class="leadme" onclick="javascript:setCookie('leadmeorder','no',30);this.parentNode.removeChild(this);"><img src="${imgBase}/addmask2.png"></div>
		</c:if>
	</c:if>
<%@ include file="../common/common_js.jsp" %>
<script src="${jsBase}/order/add.js" type="text/javascript"></script>
<script src="${jsBase}/common/fastclick.js" type="text/javascript"></script>
</body>
</html>