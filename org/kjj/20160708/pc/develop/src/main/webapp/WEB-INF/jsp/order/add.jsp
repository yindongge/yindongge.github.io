<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<%@include file="../common/common_css.jsp" %>
<title>确认订单信息-快捷健商城</title>
</head>
<body>
<div class="all">
	<%@include file="../common/common_head2.jsp" %>
	<!-- end top -->
	<div class="header">
		<div class="container container-width">
			<div class="logo fl">
				<a href="${ctx}"><img src="${imgBase}/logo.jpg"/></a>
				<div class="text-position">
					<strong>填写订单</strong>				
				</div>
			</div>
			<div class="search fr search-special1">
				<%@include file="../common/common_search.jsp" %>
			</div>

		</div>
	</div>
	<form id="orderForm" action="${ctx}/order/add" method="post">
		<div class="container container-width">
			<div class="pay pay-first">
				<h4>填写并核对订单信息</h4>
				<h5 class="h5">收货人信息</h5>
			</div>
			<div class="pay pay-method pay-reverse">
				<div class="slideTxtBox">
					<input type="hidden" id="sendStyle" name="sendStyle" value="0"/>
					<div class="hd">			
						<ul>
							<li id="sendStyleSend" class="on">配送
								<span class="icon6"></span>
								<div class="pop" style="display:none;">
								由快捷健公司配送，速度快，接受上门刷卡付款服务
								</div>
							</li>
							<c:if test="${canTake}">
							<li id="sendStyleTake">自提 
								<span class="icon6"></span>
								<div class="pop" style="display:none;">
								自提时付款，支持现金<!-- POS刷卡 -->，查看自提流程
								</div>
							</li>
							</c:if>
						</ul>
					</div>
				<div class="bd">
				<div class="bd-1">	
					<h4 class="reverseh4"><span class="glyphicon glyphicon-info-sign"></span>提示：各门店商品品类、库存各有不同</h4>
					<h5 class="h5"><span class="pull-left" id="addAddress2">新增收货地址</span><b id="addressAlert" style="display:none;">收货地址已达到上限！</b></h5>
					<input type="hidden" id="addressId" name="addressId" value="${listThisVaildAddress[0].addressId}"/>
					<input type="hidden" id="shopId" value="${kjjuser.orgShop.shopId}"/>
					<ul class="message">
					<c:if test="${listThisVaildAddress != null and fn:length(listThisVaildAddress) > 0 }">
						<c:forEach var="item" items="${listThisVaildAddress}" varStatus="status">
							<li <c:if test="${status.first}">class='active'</c:if>>
								<input type="hidden" name="userAddressId" value="${item.addressId}"/>
								<div class="add-nameall a-l">
									<span>${item.addressName}</span>
								</div>
								<div class="add-name a-l">
									<span>${item.consignee}</span>
								</div>
								<div class="add-phone a-l">
									<span>
									<c:if test="${item.mobile!=''}">
										${item.mobile}
									</c:if>
									<c:if test="${item.mobile==''}">
										${item.telAreaCode}-${item.tel}
									</c:if>	
									</span>
								</div>
								<div class="add-detail a-l">
									<span style="text-overflow:ellipsis">${item.areaShow} ${item.sendRangeName}${item.address}</span>
								</div>
								<div class="add-right a-r">
									<!-- <a>设为默认地址   </a> -->
									<a href="javascript:void(0);" name="delAddress">删除</a>
									<a href="javascript:void(0);" name="editAddress">编辑</a>
								</div>
							</li>
						</c:forEach>
						<!-- <li class="pay-special"><a href="">展开所有地址<span class="glyphicon glyphicon-menu-down"></span></a></li> -->
					</c:if>
					<c:if test="${listThisInvaildAddress != null and fn:length(listThisInvaildAddress) > 0 }">
						<c:forEach var="item" items="${listThisInvaildAddress}" varStatus="status">
							<li class="disabled-me">
								<input type="hidden" name="userAddressId" value="${item.addressId}"/>
								<div class="add-nameall a-l">
									<span>${item.addressName}</span>
								</div>
								<div class="add-name a-l">
									<span>${item.consignee}</span>
								</div>
								<div class="add-phone a-l">
									<span>
									<c:if test="${item.mobile!=''}">
										${item.mobile}
									</c:if>
									<c:if test="${item.mobile==''}">
										${item.telAreaCode}-${item.tel}
									</c:if>	
									</span>
								</div>
								<div class="add-detail a-l">
									<span style="text-overflow:ellipsis">${item.areaShow} ${item.sendRangeName}${item.address}</span>
								</div>
								<div class="add-right a-r">
									<!-- <a>设为默认地址   </a> -->
									<a href="javascript:void(0);" name="delAddress">删除</a>
									<a href="javascript:void(0);" name="editAddress">编辑</a>
								</div>
							</li>
							<div class="pop red">
								抱歉，由于配送范围发生改变导致地址已失效，请重新编辑或删除
							</div>
						</c:forEach>
						<!-- <li class="pay-special"><a href="">展开所有地址<span class="glyphicon glyphicon-menu-down"></span></a></li> -->
					</c:if>
					<c:if test="${listOtherAddress != null and fn:length(listOtherAddress) > 0 }">
						<c:forEach var="item" items="${listOtherAddress}" varStatus="status">
							<li class="disabled-me">
								<input type="hidden" name="userAddressId" value="${item.addressId}"/>
								<div class="add-nameall a-l">
									<span>${item.addressName}</span>
								</div>
								<div class="add-name a-l">
									<span>${item.consignee}</span>
								</div>
								<div class="add-phone a-l">
									<span>
									<c:if test="${item.mobile!=''}">
										${item.mobile}
									</c:if>
									<c:if test="${item.mobile==''}">
										${item.telAreaCode}-${item.tel}
									</c:if>	
									</span>
								</div>
								<div class="add-detail a-l">
									<span style="text-overflow:ellipsis">${item.areaShow} ${item.sendRangeName}${item.address}</span>
								</div>
								<div class="add-right a-r">
									<!-- <a>设为默认地址   </a> -->
									<a href="javascript:void(0);" name="delAddress">删除</a>
									<a href="javascript:void(0);" name="editAddress">编辑</a>
								</div>
								<b></b>
							</li>
						</c:forEach>
						</c:if>
					</ul>	
					<!--  -->
					<input type="hidden" id="sendDate" name="sendDate" value="${orgOrderSend.defaultSendDate}"/>
					<input type="hidden" id="sendTimeStart" name="sendTimeStart" value="${orgOrderSend.defaultSendTime[0]}"/>
					<input type="hidden" id="sendTimeEnd" name="sendTimeEnd" value="${orgOrderSend.defaultSendTime[1]}"/>
					<c:if test="${empty orgOrderSend.defaultSendDate}">
					<div class="pay-time m-same">
						<p class="blue-special">配送时间：<i class="red">已超出配送时间</i></p>
					</div>
					</c:if>
					<c:if test="${!empty orgOrderSend.defaultSendDate}">
					<div class="pay-time m-same">
						<p class="blue-special">配送时间：预计  ${fn:substring(orgOrderSend.defaultSendDate, 5, 10)}[${orgOrderSend.defaultSendWeek}] 
						${fn:substring(orgOrderSend.defaultSendTime[0], 0, 5)}-${fn:substring(orgOrderSend.defaultSendTime[1], 0, 5)} 送达</p>
						<p class="blue blue-special" id="sendModify">修改</p>
					</div>	
					<div class="m-same no-border">
						<p>免运费</p>
					</div>
					</c:if>		
				</div>
				<c:if test="${canTake}">
				<div class="bd-2" style="display: none;">
					<input type="hidden" id="takeDate" name="takeDate" value="${orgOrderSend.defaultTakeDate}"/>
					<input type="hidden" id="openTime" value="${orgOrderSend.openTime}"/>
					<div class="method4 m-same">
						<p><i class='red'>*</i>手机号：<input type="text" name="consigneeMobile" value="${kjjuser.orgUsers.mobilePhone}"/><span class="gray">此手机号将用于接收取货码，请认真填写！</span></p>
						<b id="consigneeMobileAlert" style="display:none;"></b>
					</div>
					<div class="method5 m-same">
						<p>自提地址：${kjjuser.orgShop.orgArea.show}${kjjuser.orgShop.address}</p>
					</div>
					<div class="method5 m-same" id="divTakeInfo">
						<p class="blue-special">自提时间： ${fn:substring(orgOrderSend.defaultTakeDate, 5, 10)}[${orgOrderSend.defaultTakeWeek}] ${orgOrderSend.openTime}</p>
						<p class="blue blue-special " id="takeModify">修改</p>
					</div>
				</div>
				</c:if>
				</div>
			</div>
			<h5 class="h5">支付方式</h5>
			<div class="method">
				<input type="hidden" id="payStyle" name="payStyle" value="0"/>
				<a class="method1 active" >在线支付<span class="icon6"></span>
					<div class="pop" style="display:none;">
						即时到帐，支持绝大数银行借记卡及部分银行信用卡 查看银行及限额
					</div>
				</a>
				<a class="method2">货到付款 <span class="icon6"></span>
					<div class="pop" style="display:none;">
						送货上门在收款，支持现金<!-- ，POS机刷卡 -->
					</div>
				</a>
				<span id="divLocalPay" class="togglespan" style="display: none;">付款方式：
					<select id="localPayStyle" name="localPayStyle">
						<option value="1">现金</option>
						<!-- <option value="2">POS刷卡</option> -->
					</select>
				</span>
			</div>
			</div>
			
			<hr/>
			<!-- 发票 -->
			<div class="pay">
				<h5 class="h5">发票信息</h5>
				<div class="tit">
					<div class="tit-left">
						<span>普通（纸制）发票</span>
						<span class="revise2"><span id="textInvoice">个人</span><a id="updateInvoice" href="javascript:void(0);">修改</a></span>
						<div class="revisepaper" style="display:none;">
							<input type="text" id="invoice" name="invoice" value="个人"/>
							<a id="confirmInvoice" href="javascript:void(0);">确定</a>
							<a id="cancelInvoice" href="javascript:void(0);">取消</a>
						</div>
						<span>发票内容：明细</span>
					</div>
					<div class="tit-special">
						<input type="checkbox" name="takeInvoice"/>
						<label>要发票</label>
					</div>
				</div>
			</div>

			<!-- 清单 -->
			<div class="pay">
					<h5 class="h5">商品清单 <a href="${ctx}/cart/list"><span class="pull-right">返回购物车修改</span></a></h5>
					<table class="table pay-list">
						<thead >
								<tr class="bigwaring" >
									<th class="th1">商品</th>
									<th style="width:208px;">单价(元)</th>
									<th style="width:70px;">数量</th>
									<th>小计</th>
								</tr>
						</thead>
					</table>
					<c:forEach var="reach" items="${mapReach}" varStatus="statusDiscount">
					<table class="table pay-list">
						<tbody style="border:1px solid #ccc">
							<tr>
								<td colspan="4">
									<div class="manjian_box">
										<div class="manjian_left">
											<a href="javascript:void(0);" class="yellow_a">满减</a>
											<span class="inline_span">${reach.value.title}</span>
										</div>
										<div class="manjian_right">已满
											<c:if test="${reach.value.reachStyle == 0}">${reach.value.sumMoney}元</c:if>
											<c:if test="${reach.value.reachStyle == 1}">${reach.value.sumAmount}件</c:if>
											<c:if test="${!empty reach.value.orgReachCondition.mapReachDiscount[1]}">
											（<span class="yellow">已减${reach.value.orgReachCondition.mapReachDiscount[1].discountMultiple*reach.value.orgReachCondition.mapReachDiscount[1].common}</span>）
											</c:if>
										</div>
									</div>
								</td>
							</tr>
							<c:forEach var="item" items="${listCart}" varStatus="status">
							<c:if test="${item.orgCart.discountId == reach.key}">
							<input type="hidden" name="goodsIds" value="${item.orgProductItemAll.orgProductItemAide.goodsId}"/>
							<tr class="warning">
								<td style="width:600px;">
									<div class="w-img">
										<a href="${ctx}/item/${item.orgProductItemAll.orgProductItemAide.goodsId}" target="_blank"><img src="${item.orgProductItemAll.orgProductItem.goodsImg180}"/></a>
									</div>
									<div class="w-text">${item.orgProductItemAll.orgProductItem.goodsName}
										<span class="yellow"></span>
									</div>
								</td>
								<td style="width:208px;"><span class="yellow-sm"><fmt:formatNumber type="currency" pattern="￥0.00" value="${item.orgProductItemAll.orgProductItemAide.showPrice}"/></span></td>
								<td>×${item.orgProductItemAll.orgProductItemAide.userBuy}</td>
								<td><span class="yellow-sm"><fmt:formatNumber type="currency" pattern="￥0.00" value="${item.orgProductItemAll.orgProductItemAide.showPrice*item.orgProductItemAll.orgProductItemAide.userBuy}"/></span></td>
							</tr>
							</c:if>
							</c:forEach>
							<c:if test="${!empty reach.value.orgReachCondition.mapReachDiscount[3]}">
							<c:forEach var="item" items="${reach.value.orgReachCondition.mapReachDiscount[3].listReachGive}">
								<tr class="warning warning_h">
									<td colspan="5">赠品：${item.goodsName}<span class="price_me"></span><span class="conunt_me">X${item.giveAmount}</span></td>
								</tr>
							</c:forEach>
							</c:if>
						</tbody>
					</table>
					</c:forEach>
					<table class="table pay-list">
						<tbody>
							<c:forEach var="item" items="${listCart}" varStatus="status">
							<c:if test="${empty item.orgCart.discountId or item.orgCart.discountId == 0 or !mapReach.containsKey(item.orgCart.discountId)}">
							<input type="hidden" name="goodsIds" value="${item.orgProductItemAll.orgProductItemAide.goodsId}"/>
							<tr class="warning">
								<td style="width:600px;">
									<div class="w-img">
										<a href="${ctx}/item/${item.orgProductItemAll.orgProductItemAide.goodsId}" target="_blank"><img src="${item.orgProductItemAll.orgProductItem.goodsImg180}"/></a>
									</div>
									<div class="w-text">${item.orgProductItemAll.orgProductItem.goodsName}
										<span class="yellow"></span>
									</div>
								</td>
								<td style="width:208px;"><span class="yellow-sm"><fmt:formatNumber type="currency" pattern="￥0.00" value="${item.orgProductItemAll.orgProductItemAide.showPrice}"/></span></td>
								<td>×${item.orgProductItemAll.orgProductItemAide.userBuy}</td>
								<td><span class="yellow-sm"><fmt:formatNumber type="currency" pattern="￥0.00" value="${item.orgProductItemAll.orgProductItemAide.showPrice*item.orgProductItemAll.orgProductItemAide.userBuy}"/></span></td>
							</tr>
							</c:if>
							</c:forEach>
						</tbody>
					</table>
					<table class="table pay-list">
						<tbody>
							<tr>
								<td colspan="5">订单备注：<input type="text" id="remark" name="remark" class="beizhu-tip" placeholder="限45个字（请将购买需求在备注中做详细说明）" maxlength="45"/></td>
							</tr>
						</tbody>
					</table>
					<div class="pay">
						<h5 class="h5">优惠券</h5>
						<div class="addpay">
							<input type="hidden" id="orderMoney" value="${orderMoney}"/>
							<c:if test="${!empty listCouponRecord}">
							<div class="addpay-content">您可以查看
								<a href="${ctx}/coupon/list" target="_blank">我的优惠券</a>了解使用限制。
								<a href="${ctx}/article/dispatcher/34" target="_blank">[了解优惠券规则]</a>
								<select name="couponRecordId" id="couponRecordId" autocomplete="off">
									<c:forEach var="item" items="${listCouponRecord}" varStatus="status">
										<option value="${item.recordId}"  data-condition-money="${item.orgCoupon.conditionMoney}" data-end-time="<fmt:formatDate value="${item.endTime}" type="date"/>" data-discount-money="${item.orgCoupon.discountMoney}" data-product-type="${item.orgCoupon.productType}">${item.orgCoupon.couponName}</option>
									</c:forEach>
									<option value="0" data-discount-money="0.00">不使用优惠券</option>
								</select>
								<span class="addpay-price" ><em class="yellow" id="emCoupon"><fmt:formatNumber type="currency" pattern="￥-0.00" value="${listCouponRecord[0].orgCoupon.discountMoney}"/></em></span>
							</div>
							</c:if>
							<c:if test="${empty listCouponRecord}">
							<div class="addpay-content">此订单暂无可用的优惠券。 您可以查看
								<a href="${ctx}/coupon/list">我的优惠券</a>了解使用限制。
								<a href="${ctx}/article/dispatcher/34" target="_blank">[了解优惠券规则]</a>
								<select name="couponRecordId" id="couponRecordId" autocomplete="off">
									<option value="0" data-discount-money="0.00">暂无可用优惠券</option>
								</select>
								<span class="addpay-price" ><em class="yellow" id="emCoupon"><fmt:formatNumber type="currency" pattern="￥-0.00" value="0"/></em></span>
							</div>
							</c:if>
							<div class="addpay-gray">
								<c:if test="${listCouponRecord != null and fn:length(listCouponRecord) > 0 }">
								满${listCouponRecord[0].orgCoupon.conditionMoney}元减${listCouponRecord[0].orgCoupon.discountMoney}元有效期至<fmt:formatDate value="${listCouponRecord[0].endTime}" type="date"/>
								<c:if test="${listCouponRecord[0].orgCoupon.productType == 1}">可购买全场商品</c:if>
								<c:if test="${listCouponRecord[0].orgCoupon.productType == 2}">可购买指定分类</c:if>
								<c:if test="${listCouponRecord[0].orgCoupon.productType == 3}">可购买指定商品</c:if>
								</c:if>
							</div>
						</div>
						<c:if test="${!empty accountDeposit.canUseAmount}">
							<c:if test="${!empty listCouponRecord}">
								<input type="hidden" id="depositMoney" name="depositMoney" value="${accountDeposit.canUseAmount>(orderMoney-listCouponRecord[0].orgCoupon.discountMoney)?(orderMoney-listCouponRecord[0].orgCoupon.discountMoney):accountDeposit.canUseAmount}"/>
							</c:if>
							<c:if test="${empty listCouponRecord}">
								<input type="hidden" id="depositMoney" name="depositMoney" value="${accountDeposit.canUseAmount>orderMoney?orderMoney:accountDeposit.canUseAmount}"/>
							</c:if>
							<input type="hidden" id="canUseAmount" value="${accountDeposit.canUseAmount}"/>
							<div class="ready-pay-box" id="divDepositMoney">
								<div class="ready-pay-absloute"><span>余额：<fmt:formatNumber type="currency" pattern="0.00" value="${accountDeposit.canUseAmount}"/></span></div>
								<div class="ready-pay-item">
									<input type="checkbox" id="useDeposit" name="useDeposit" autocomplete="off" <c:if test="${accountDeposit.status == 1}">disabled="disabled"</c:if>/>
									<img src="${imgBase}/yufu.png" alt="" />
									<c:if test="${accountDeposit.status == 0}">
									<label for="text" id="labelDepositMoney">
									<c:if test="${!empty listCouponRecord}">
										使用余额支付<fmt:formatNumber type="currency" pattern="0.00" value="${accountDeposit.canUseAmount>(orderMoney-listCouponRecord[0].orgCoupon.discountMoney)?(orderMoney-listCouponRecord[0].orgCoupon.discountMoney):accountDeposit.canUseAmount}"/>元
									</c:if>
									<c:if test="${empty listCouponRecord}">
										使用余额支付<fmt:formatNumber type="currency" pattern="0.00" value="${accountDeposit.canUseAmount>orderMoney?orderMoney:accountDeposit.canUseAmount}"/>元
									</c:if>
									</label>
									</c:if>
									<span class="tip-r1 red"><c:if test="${accountDeposit.status == 1}">您的余额账户已被锁定，第二日0点自动恢复或联系客服：4000-306-603</c:if></span>
								</div>
								<div class="ready-pay-sumbit" style="display:none;">
									<input type="password" id="depositPassword" name="depositPassword" maxlength="6" class="text-r1" placeholder="请输入支付密码(6位数字)" style="font-size:14px;"/>
									<span id="infoPassword" class="tip-r1 red"></span>
									<p class="forget-a"><a href="${ctx}/accountDeposit/findPasswordInit" target="_blank">忘记支付密码</a></p>
								</div>
							</div>
						</c:if>
						<h5 class="addlistprice">
							商品总计：<span><fmt:formatNumber type="currency" pattern="￥0.00" value="${orderMoney}"/></span>
							＋运费：<span><fmt:formatNumber type="currency" pattern="￥0.00" value="0"/></span>
							－优惠券：<span id="spCoupon">
								<c:if test="${!empty listCouponRecord}">
									<fmt:formatNumber type="currency" pattern="￥0.00" value="${listCouponRecord[0].orgCoupon.discountMoney}"/>
								</c:if>
								<c:if test="${empty listCouponRecord}">
									<fmt:formatNumber type="currency" pattern="￥0.00" value="0"/>
								</c:if>
							</span>
							-余额支付：<span id="spDepositMoney">￥0.00</span>
						</h5>
					</div>
					<div class="paysum pull-right">
						<button id="btnAddOrder" type="button" class="btn btn-disabled" disabled="disabled">提交订单</button>
						<div  class="sumall">应付款<span class="yellow" id="spPay">
						<c:if test="${listCouponRecord != null and fn:length(listCouponRecord) > 0 }">
							<fmt:formatNumber type="currency" pattern="￥0.00" value="${orderMoney-listCouponRecord[0].orgCoupon.discountMoney}"/>
						</c:if>
						<c:if test="${listCouponRecord == null or fn:length(listCouponRecord) == 0 }">
							<fmt:formatNumber type="currency" pattern="￥0.00" value="${orderMoney}"/>
						</c:if>
						</span></div>
					</div>
			</div>

		</div>
		</form>

<!-- footer -->
<%@include file="../common/common_foot.jsp" %>
<c:if test="${canTake}">
<div id="takeDiv" class="modify" style="display:none;">
		<h5>自提时间 <button type="button" class="close" name="buttonClose">x</button></h5>
		<div class="date-select">
				<ul>
					<c:forEach var="item" items="${orgOrderSend.date}" varStatus="status">
						<li <c:if test="${orgOrderSend.isTake[status.index]==false}">class="disabled"</c:if>
							<c:if test="${item==orgOrderSend.defaultTakeDate}">class="visited"</c:if>>
							<input type="hidden" name="takeDateTemp" value="${item}"/>
							${fn:substring(item, 5, 10)}
							<span class="blockme">${orgOrderSend.week[status.index]}</span>
						</li>
					</c:forEach>
				</ul>
		</div>
		<div class="modify-button">
			<button type="button" name="buttonClose" class="btn btn-default">取消</button>
			<button type="button" id="confirmTakeDate" class="btn btn-warning">确定</button>
		</div>
</div>
</c:if>
<div id="sendDiv" class="modify modify1" style="display:none;">
		<h5>配送时间 <button type="button" class="close" name="buttonClose">x</button></h5>
		<div class="date-select">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>时间段</th>
						<c:forEach var="item" items="${orgOrderSend.date}" varStatus="status">
							<th>
								${fn:substring(item, 5, 10)}
								<span class="blockme">${orgOrderSend.week[status.index]}</span>
							</th>
						</c:forEach>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item1" items="${orgOrderSend.isSend}" varStatus="status1">
						<tr>
							<td class="disabled">${fn:substring(orgOrderSend.time[status1.index][0], 0, 5)}-${fn:substring(orgOrderSend.time[status1.index][1], 0, 5)}</td>
							<c:forEach var="item2" items="${item1}" varStatus="status2">
								<c:if test="${item2==true}">
									<c:if test="${orgOrderSend.date[status2.index] == orgOrderSend.defaultSendDate and orgOrderSend.time[status1.index][0] == orgOrderSend.defaultSendTime[0]}">
										<td class="visited" data-send-date="${orgOrderSend.date[status2.index]}" data-send-week="${orgOrderSend.week[status2.index]}" 
										data-send-time-start="${orgOrderSend.time[status1.index][0]}" data-send-time-end="${orgOrderSend.time[status1.index][1]}">已选</td>
									</c:if>
									<c:if test="${orgOrderSend.date[status2.index] != orgOrderSend.defaultSendDate or orgOrderSend.time[status1.index][0] != orgOrderSend.defaultSendTime[0]}">
										<td data-send-date="${orgOrderSend.date[status2.index]}" data-send-week="${orgOrderSend.week[status2.index]}" 
										data-send-time-start="${orgOrderSend.time[status1.index][0]}" data-send-time-end="${orgOrderSend.time[status1.index][1]}">可选</td>
									</c:if>
								</c:if>
								<c:if test="${item2==false}">
									<td class="disabled"></td>
								</c:if>
							</c:forEach>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="modify-tip">
				<p>温馨提示：我们会努力按照您指定的时间配送，但因天气、交通等各类因素影响，您的订单有可能会有延误现象！</p>
			</div>
		</div>
		<div class="modify-button">
			<button type="button" name="buttonClose" class="btn btn-default">取消</button>
			<button type="button" id="confirmSendDate" class="btn btn-warning">确定</button>
		</div>
</div>
<form id="addressAddForm">
<div id="addressAddDiv" class="modify modify2" style="display:none;">
		<h5>收货地址 <button type="button" class="close" name="buttonClose">x</button></h5>
		<div class="date-select">
			<div class="address-select">
				<div class="address-left">
					<i class="red">*</i>收货人：
				</div>
				<div class="address-right">
					<input type="text" class="input1" name="consignee" placeholder="收货人"/>
					<b style="display:none;"></b>
				</div>
			</div>
			<div class="address-select">
				<div class="address-left">
					您的区域：
				</div>
				<div class="address-right">
					<select disabled="disabled" class="nouse">
						<option>${kjjuser.orgShop.area[0]}</option>
					</select>
					<select disabled="disabled" class="nouse">
						<option>${kjjuser.orgShop.area[1]}</option>
					</select>
					<select disabled="disabled" class="nouse">
						<option>${kjjuser.orgShop.area[2]}</option>
					</select>
					<select disabled="disabled" class="nouse">
						<option>${kjjuser.orgShop.shopName}</option>
					</select>
				</div>
			</div>
			<div class="address-select">
				<div class="address-left">
					<i class="red">*</i>详细地址：
				</div>
				<div class="address-right">
					<select name="sendRangeId">
						<option value="-1">请选择</option>
						<c:forEach items="${listSendRange}" var="sendRange" varStatus="status">
							<option value="${sendRange.id}">${sendRange.sendRangeName}</option>
						</c:forEach>
					</select>
					<input type="text" class="input4" name="address" placeholder="如楼号、楼层、门牌号"/>
					<b style="display:none;">不需要重复填写所在区域</b>
				</div>
			</div>
			<div class="address-select">
				<div class="address-left">
					<i class="red">*</i>手机：
				</div>
				<div class="address-special">
					<input type="text" class="input3" name="mobile" placeholder="手机号"/>
				</div>
				<div class="address-special2">
					<label>电话：</label>
					<input type="text" class="addresstext-1" name="telAreaCode" placeholder="区号"/>
					<input type="text" class="addresstext-2" name="tel" placeholder="座机号"/>
					<b style="display:none;"></b>
				</div>
			</div>
			<div class="address-select">
				<div class="address-left">
					邮箱：
				</div>
				<div class="address-right">
					<input type="text" class="input2" name="email" placeholder="电子邮箱"/>
					<b style="display:none;"></b>
				</div>
			</div>
		</div>
		<div class="modify-button">
			<button type="button" name="buttonClose" class="btn btn-default">取消</button>
			<button type="button" id="confirmAddAddress" class="btn btn-warning">确定</button>
		</div>
</div>
</form>
<form id="addressEditForm">
<div id="addressEditDiv" class="modify modify2" style="display:none;">
		<input type="hidden" id="editAddressId" name="addressId"/>
		<h5>收货地址 <button type="button" class="close" name="buttonClose">x</button></h5>
		<div class="date-select">
			<div class="address-select">
				<div class="address-left">
					<i class="red">*</i>收货人：
				</div>
				<div class="address-right">
					<input type="text" class="input1" id="consignee" name="consignee" placeholder="收货人"/>
					<b style="display:none;"></b>
				</div>
			</div>
			<div class="address-select">
				<div class="address-left">
					您的区域：
				</div>
				<div class="address-right" id="shopName">
				</div>
			</div>
			<div class="address-select">
				<div class="address-left">
					<i class="red">*</i>详细地址：
				</div>
				<div class="address-right">
					<select id="sendRangeId" name="sendRangeId">
					</select>
					<input type="text" class="input4" id="address" name="address" placeholder="如楼号、楼层、门牌号"/>
					<b style="display:none;"></b>
				</div>
			</div>
			<div class="address-select">
				<div class="address-left">
					<i class="red">*</i>手机：
				</div>
				<div class="address-special">
					<input type="text" class="input3" id="mobile" name="mobile" placeholder="手机号"/>
				</div>
				<div class="address-special2">
					<label>电话：</label>
					<input type="text" class="addresstext-1" id="telAreaCode" name="telAreaCode" placeholder="区号"/>
					<input type="text" class="addresstext-2" id="tel" name="tel" placeholder="座机号"/>
					<b style="display:none;"></b>
				</div>
			</div>
			<div class="address-select">
				<div class="address-left">
					邮箱：
				</div>
				<div class="address-right">
					<input type="text" class="input2" id="email" name="email" placeholder="电子邮箱"/>
					<b style="display:none;"></b>
				</div>
			</div>
		</div>
		<div class="modify-button">
			<button type="button" name="buttonClose" class="btn btn-default">取消</button>
			<button type="button" id="confirmEditAddress" class="btn btn-warning">修改</button>
		</div>
</div>
</form>
<div class="mask-index"></div>
</div>
<div class="into " id="errorInfo">
	<div class="into-title">
		<h5>提示</h5>
	</div>
	<div class="into-body fade2">
		<div class="into-text">
			<p class="fadep2"></p>
			<p class="into-button text-center">
				<button type="button" class="btn btn-warning" onclick="javascript:location.href='${ctx}/cart/list';">返回购物车</button>
			</p>
		</div>
	</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/order/add.js" type="text/javascript"></script>
</body>
</html>