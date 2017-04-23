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
			<div class="head-content">购物成功</div>
			<div class="head-left"><a href="${ctx}" class="link"></a></div>
		</header>
		<!-- end top -->
		<div class="nolist" style="margin-bottom:0px;">
			<div class="emptycar addsuccess"></div>
			<p class="strong p3" >购物成功</p>
			<p class="p3">
				<c:if test="${order.sendStyle == 0}">我们将尽快为您发货</c:if>
				<c:if test="${order.sendStyle == 1}">请及时到店提货</c:if>
			</p>
			<div class="twobtn">
				<a href="${ctx}/order/list" class="btn-shop btn-color">查看订单</a>
				<a href="${ctx}" class="btn-shop btn-gray">继续购买</a>
			</div>
		</div>
		<%-- <div class="procuct_control">
			<div class="produce_title"><span>商品推荐</span></div>
			<div class="product_wrap">
				<div class="product_item">
					<a href="#">
						<div class="pic_box"><img src="${imgBase}/1.jpg" alt=""></div>
						<div class="title_box">
							<span>两行商品名称多了出现一个省略号三个点赶紧出现吧赶紧出现吧</span>
						</div>
						<div class="price_box">
							<span class="yellow price"><i class="rmb">￥</i>15.00</span>
						</div>
					</a>
				</div>
				<div class="product_item">
					<a href="#">
						<div class="pic_box"><img src="${imgBase}/1.jpg" alt=""></div>
						<div class="title_box">
							<span>两行商品名称多了出现一个省略号三个点</span>
						</div>
						<div class="price_box">
							<span class="yellow price"><i class="rmb">￥</i>15.00</span>
						</div>
					</a>
				</div>
				<div class="product_item">
					<a href="#">
						<div class="pic_box"><img src="${imgBase}/1.jpg" alt=""></div>
						<div class="title_box">
							<span>两行商品名称多</span>
						</div>
						<div class="price_box">
							<span class="yellow price"><i class="rmb">￥</i>15.00</span>
						</div>
					</a>
				</div>
				<div class="product_item">
					<a href="#">
						<div class="pic_box"><img src="${imgBase}/1.jpg" alt=""></div>
						<div class="title_box">
							<span>两行商品名称多了出现一个省略号三个点</span>
						</div>
						<div class="price_box">
							<span class="yellow price"><i class="rmb">￥</i>15.00</span>
						</div>
					</a>
				</div>
				<div class="product_item">
					<a href="#">
						<div class="pic_box"><img src="${imgBase}/1.jpg" alt=""></div>
						<div class="title_box">
							<span>两行商品名称多了出现一个省略号三个点</span>
						</div>
						<div class="price_box">
							<span class="yellow price">￥15.00</span>
						</div>
					</a>
				</div>
				<div class="product_item">
					<a href="#">
						<div class="pic_box"><img src="${imgBase}/1.jpg" alt=""></div>
						<div class="title_box">
							<span>两行商品名称多了出现一个省略号三个点</span>
						</div>
						<div class="price_box">
							<span class="yellow price">￥15.00</span>
						</div>
					</a>
				</div>
			</div>
		</div> --%>
	</div>
	<!-- end box -->
<%@ include file="../common/common_js.jsp"%>
</body>
</html>