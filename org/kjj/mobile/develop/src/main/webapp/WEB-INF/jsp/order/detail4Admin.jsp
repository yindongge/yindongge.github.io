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

<title>快捷健商城</title>
</head>
<body>
<div class="box box-gray">
		<header class="header">
			<div class="head-content">订单处理</div>
		</header>
		<!-- end top -->
	<div class="dingdan-wrapper">
		<div class="list-detail">
			<h5>您的订单已生成</h5> 
			<c:if test="${order.status==0 && order.payStatus==0}">
				<dl class="item-dingdan">商品订单24小时内未成功支付将自动取消，请尽快支付</dl>
			</c:if>
			<dl class="item-dingdan">
				<dt>订单状态：</dt>
				<dd ><span class="blue">
						<c:if test="${order.status==0}">待付款</c:if>
						<c:if test="${order.status==1}">待确认</c:if>
						<c:if test="${order.status==2}">
							<c:if test="${order.sendStyle==0}">待发货</c:if>
							<c:if test="${order.sendStyle==1}">备货中</c:if>
						</c:if>
						<c:if test="${order.status==3}">
							<c:if test="${order.sendStyle==0}">待收货</c:if>
							<c:if test="${order.sendStyle==1}">待自提</c:if>
						</c:if>
						<c:if test="${order.status==4}">已完成</c:if>
						<c:if test="${order.status==5}">已取消</c:if>
						<c:if test="${order.status==6}">已关闭</c:if>
					</span>
				</dd>
			</dl>
			<dl class="item-dingdan">
				<dt>订单编号：</dt>
				<dd id="orderId">${order.orderId}</dd>
			</dl>
			<dl class="item-dingdan">
				<dt>下单时间：</dt>
				<dd><fmt:formatDate value="${order.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></dd>
			</dl>
			<c:choose>
			    <c:when test="${order.status==1}">
					<a name="btnConfirm" href="javascript:void(0);" class="btnsure">确认</a>
			    </c:when>
			    <c:when test="${order.status==2}">
			    	<c:if test="${order.sendStyle==0}">
			    		<a name="btnSend" href="javascript:void(0);" class="btnsure">发货</a>
			    	</c:if>
					<c:if test="${order.sendStyle==1}">
						<a name="btnTake" href="javascript:void(0);" class="btnsure">待自提</a>
					</c:if>
			    </c:when>
			    <c:when test="${order.status==3}">
					<a name="btnFinish" href="javascript:void(0);" class="btnsure">完成</a>
					<input type="hidden" value="${order.sendStyle}"/>
			    </c:when>
			</c:choose>
		</div>
		<div class="list-detail ">
			<dl class="item-dingdan">
				<dt>订单金额：</dt>
				<dd><span class="red"><i class="rmb">￥</i><fmt:formatNumber type="currency" pattern="0.00" value="${order.orderMoney}"/></span><c:if test="${order.payStyle==0}">(在线支付)</c:if><c:if test="${order.payStyle==1}">(货到付款)</c:if></dd>
			</dl>
			<c:if test="${order.sendStyle==0}">
				<dl class="item-dingdan">
					<dt>收货地址：</dt>
					<dd>${order.consigneeAddress}</dd>
				</dl>
					<dl class="item-dingdan">
					<dt>收货人：</dt>
					<dd>${order.consignee}</dd>
				</dl>
				<dl class="item-dingdan">
					<dt>送货时间：</dt>
					<dd>
						<fmt:formatDate value="${order.sendDate}" pattern="yyyy-MM-dd" />
						<fmt:formatDate value="${order.sendTimeStart}" pattern="HH:mm" />-<fmt:formatDate value="${order.sendTimeEnd}" pattern="HH:mm" />
					</dd>
				</dl>
			</c:if>
			<c:if test="${order.sendStyle==1}">
				<dl class="item-dingdan">
					<dt>取货码：</dt>
					<dd>${order.takeCode}</dd>
				</dl>
				<dl class="item-dingdan">
					<dt>自提日期：</dt>
					<dd>
						<fmt:formatDate value="${order.takeDate}" pattern="yyyy-MM-dd" />
					</dd>
				</dl>
				<dl class="item-dingdan">
					<dt>取货地址：</dt>
					<dd>
						${order.orgShop.address}
					</dd>
				</dl>
			</c:if>
			
			<dl class="item-dingdan">
				<dt>发票信息：</dt>
				<c:if test="${empty order.invoice}"><dd>无</dd></c:if>
				<c:if test="${!empty order.invoice}"><dd>${order.invoice}</dd></c:if>
			</dl>
			<dl class="item-dingdan">
				<dt>留言：</dt>
				<c:if test="${empty order.remark}"><dd>无</dd></c:if>
				<c:if test="${!empty order.remark}"><dd>${order.remark}</dd></c:if>
			</dl>
		</div>
		<div class="list-detail ">
			<div class="list-panel">
				<c:set value="0" var="sum" />
				<c:forEach var="orderGoods" items="${order.listOrderGoods}" varStatus="goodsStatus">
			        <c:set value="${sum + orderGoods.amount}" var="sum" />
				</c:forEach>
				<span class="glyphicon glyphicon-star-empty"></span>商品信息<span class="pull-right">总计${sum}件商品</span>
			</div>
			<c:forEach var="orderGoods" items="${order.listOrderGoods}" varStatus="goodsStatus">
				<c:if test="${orderGoods.unitAccounts > 0}">
				<a class="listone" href="${ctx}/item/${orderGoods.goodsId}">
					<div class="leftimg">
						<img src="${orderGoods.orgProductItem.goodsImg180}">
					</div>
					<div class="lefttext">
						<p class="first-title">${orderGoods.orgProductItem.goodsName}</p>
						<p class="red"><i class="rmb">￥</i><fmt:formatNumber type="currency" pattern="0.00" value="${orderGoods.unitPrice}"/></p>
						<p><span >数量:${orderGoods.amount}件</span></p>
					</div>
				</a>
				</c:if>
				<c:if test="${orderGoods.unitAccounts.unscaledValue() == 0}">
				<tr>
					<div class="gray_bg_zeng" style="padding-left:0px;">
						<span><a href="${ctx}/item/${orderGoods.goodsId}" style="color:#666;" target="_blank">赠品：${orderGoods.orgProductItem.goodsName}</a></span>
						<span class="pull-right">X${orderGoods.amount}</span>
					</div>
				</tr>
				</c:if>
			</c:forEach>
			<div class="detail-price">
				<p>配送费：+<span class="red"><i class="rmb">￥</i><fmt:formatNumber type="currency" pattern="0.00" value="${order.sendMoney}"/></span></p>
				<p>使用余额：-<span class="red"><i class="rmb">￥</i><fmt:formatNumber type="currency" pattern="0.00" value="${order.depositMoney}"/></span></p>
				<p>实付：<span class="red"><i class="rmb">￥</i><fmt:formatNumber type="currency" pattern="0.00" value="${order.payMoney}"/></span></p>
			</div>
		</div>
	</div>
	<!-- 结束订单详情 -->
	<footer class="footer">
		<p>客户服务热线：4000-306-603</p>
		<p>KJJHOME.COM 快捷健商城</p>
	</footer>
	</div>
	<!-- end box -->
	<!-- start 请输入提货码 -->
		<div class="trigger-box" style="display: none;">
			<div class="trigger-showbox">
				<div class="info-confrim text-cneter ">
					<p class="info-c-title control-close">请输入提货码<span class="close"></span></p>
					<p class="new_trigger"><input type="text" maxlength="6" name="takeCodeFinish"></p>
					<p class="redtip">请输入提货码</p>
					<div class="forget-box newforget_btn">
					<a href="javascript:void(0);" name="btnTakeFinish" class="forget-password">确认</a></div>
				</div>
			</div>
			<div class="trigger-cover"></div>
		</div>
	<!-- end 请输入提货码 -->
	
<%@ include file="../common/common_js.jsp"%>
<script src="${jsBase}/order/detail4Admin.js" type="text/javascript"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
</body>
</html>