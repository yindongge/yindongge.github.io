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
			<div class="head-content">我的订单</div>
			<div class="head-left">
				<a href="${ctx}" class="link"></a>
			</div>
		</header>  
		<!-- end top -->
		<form id="form" name="form" action="${ctx}/order/list" method="post">
			<div class="dingdan-wrapper">
				<div class="area mylistnav ">
					<input type="hidden" id="waitPaid" value="${query.waitPaid}">
					<input type="hidden" id="waitSend" value="${query.waitSend}">
					<input type="hidden" id="waitTake" value="${query.waitTake}">
					<a href="${ctx}/order/list" class='a <c:if test="${query.waitPaid==false and query.waitSend==false and query.waitTake==false and query.waitComment==false}">on</c:if>'>全部(${orderCount})<span class="linebottom"></span></a> 
					<a href="${ctx}/order/list?waitPaid=true" class='a <c:if test="${query.waitPaid==true}">on</c:if>'>待付款(${userCount.waitPaidCount})<span class="linebottom"></span></a>
					<a href="${ctx}/order/list?waitSend=true" class='a <c:if test="${query.waitSend==true}">on</c:if>'>待收货(${userCount.waitSendCount})<span class="linebottom"></span></a>
					<a href="${ctx}/order/list?waitTake=true" class='a <c:if test="${query.waitTake==true}">on</c:if>'>待自提(${userCount.waitTakeCount})<span class="linebottom"></span></a>
				</div>
				<c:if test="${!empty page.content}">
					<c:forEach var="item" items="${page.content}" varStatus="status">
						<div class="havelist gray" style="margin-bottom:0px">
							<div class="goodslist">
								<div class="buff">
									<div class="buff-left">
										<p> 
											状态:
											<span>
												<c:if test="${item.status==0}">待付款</c:if>
												<c:if test="${item.status==1}">待确认</c:if>
												<c:if test="${item.status==2}">
													<c:if test="${item.sendStyle==0}">待发货</c:if>
													<c:if test="${item.sendStyle==1}">备货中</c:if>
												</c:if>
												<c:if test="${item.status==3}">
													<c:if test="${item.sendStyle==0}">待收货</c:if>
													<c:if test="${item.sendStyle==1}">待自提</c:if>
												</c:if>
												<c:if test="${item.status==4}">已完成</c:if>
												<c:if test="${item.status==5}">已取消</c:if>
												<c:if test="${item.status==6}">已关闭</c:if>
											</span>
										</p>
										<p>
											总计:<span><i class="rmb">￥</i><fmt:formatNumber type="currency" pattern="0.00" value="${item.orderMoney}"/></span>
										</p>
									</div>   
									<div class="buff-right">
										<c:if test="${item.status==0&&item.payStatus==0}">
											<c:if test="${!empty kjjopenid}">
												<a href="javascript:void(0);" class="gopay" onclick="wxpay(${item.orderId});">去支付</a>
											</c:if>
											<c:if test="${empty kjjopenid}">
												<a href="${ctx}/alipay/pay?orderId=${item.orderId}" class="gopay">去支付</a>
											</c:if>
										</c:if>
										<c:if test="${item.status==4&&item.commentStatus==0}">
											<a href="${ctx}/comment/list" class="gopay">去评价</a>
										</c:if>
											<a href="${ctx}/order/detail?orderId=${item.orderId}"  class="gopay">订单详情</a>
									</div>
										
								</div>
								<c:forEach var="orderGoods" items="${item.listOrderGoods}" varStatus="goodsStatus">
									<c:if test="${orderGoods.unitAccounts > 0}">
									<a class="listone" href="${ctx}/order/detail?orderId=${item.orderId}">
										<div class="leftimg">
											<img src="${orderGoods.orgProductItem.goodsImg180}">
										</div>
										<div class="lefttext">
											<p class="first-title">
											${orderGoods.orgProductItem.goodsName}
											</p>
											<p class="red">
												<i class="rmb">￥</i><fmt:formatNumber type="currency" pattern="0.00" value="${orderGoods.unitPrice}"/>
											</p>
											<p>
												<span>数量:${orderGoods.amount}件</span>
											</p>
										</div>
									</a>
									</c:if>
								</c:forEach>
							</div>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${empty page.content}">
					<div class="nolist">
					<p class="reverse-list-p">
					您暂时还没有<c:if test="${query.waitPaid==true}">待付款</c:if><c:if test="${query.waitSend==true}">待收货</c:if><c:if test="${query.waitTake==true}">待自提</c:if>订单
					</p>
					</div>
				</c:if>

			</div>
			<!-- loading -->
			<div class="loadcircle gray" id="loadMore" style="display: none;" data-page-next="<c:if test="${page.lastPage}">1</c:if><c:if test="${!page.lastPage}">1</c:if>">
				<span class="bounce-text">正在加载</span>
				<span class="bounce bounce1"></span>
				<span class="bounce bounce2"></span>
				<span class="bounce bounce3"></span>
			</div>
			<!-- 结束订单详情 -->
			<footer class="footer">
				<p>客户服务热线：4000-306-603</p>
				<p>KJJHOME.COM 快捷健商城</p>
			</footer>

		</form>
	</div>
	<div class="cover"></div>
	<!-- end box -->
	<%@ include file="../common/common_js.jsp"%>
	<script src="${jsBase}/order/list.js" type="text/javascript"></script>
	<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
</body>
</html>