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
<meta name="keywords" content="${query.keyword},快捷健,快捷健网上商城,连锁便利店,kjj,kjjhome,O2O便利店,网上便利店,掌上便利店,1小时送达,货到付款,当日送达,免费送货上门,CBD便利店,酒水饮料,办公日用,进口食品,糖果零食,个护化妆,日常用品" />
<meta name="description" content="高品质O2O便利店，在线下单，全场0元起，免费配送，1小时极速送达，货到付款。kjjhome是快捷健电子商务有限公司打造的线上购物O2O平台" />
<%@ include file="../common/common_css.jsp"%>

<title>
	<c:if test="${query.keyword ne null && query.keyword ne ''}">${query.keyword}--商品搜索</c:if>
	<c:if test="${query.keyword eq null || query.keyword eq '' }">快捷健商城</c:if>
</title>
</head>
<body>
<div class="box box-control nofixed">
	<form id="searchForm" action="${ctx}/search/result" method="post">
		<header class="header ">
			<div class="head-content classify">
				<input type="text" name="keyword" id="keyword" value="${query.keyword}" placeholder="搜索商品">
				<span class="searchicon"></span>
			</div>
			<div class="head-left"><a href="javascript:history.go(-1);" class="link"></a></div>
			<input type="hidden" id="orderType"  name="orderType" value="${query.orderType}"> 
			<input type="hidden" id="pageNumber" name="pageNumber"> 
			<input type="hidden" id="couponId" name="couponId"  value="${query.couponId}">
			<input type="hidden" id="superClassId" name="superClassId" value="${query.superClassId}"> 
			<input type="hidden" id="catId" name="catId" value="${query.catId}"/> 
			<input type="hidden" id="realPriceId" name="realPrice" value="${query.realPrice}"/> 
		</header>
			<nav class="nav thirdnav" >
				<a href="#" >全部分类<i class="downicon-buy"></i></a>
				<div class="slidedown-box" style="height:330px">
					<div class="slide-d-left sameslide">
						<div class="scroll-controler">
							<div data-id="0" class="main-option"><span class="span1"></span>全部商品</div>
							<c:forEach items="${listClassLevelOne}" var="levelOne" varStatus="index">
								<div class="main-option
								<c:if test="${levelOne.classId eq parentId}"> on</c:if>
								" data-id="${levelOne.classId}"><span class="span${index.count+1}"></span>${levelOne.className}</div>
							</c:forEach>
							<input type="hidden" id="parentId" name="parentId" value="${parentId}"/>
						</div>
					</div>
					<div class="slide-d-right sameslide">
						<!-- 二级分类 -->
						<ul class="chooseul"></ul>
					</div>
				</div>
				<a href="#">综合排序<i class="downicon-buy"></i></a>
				<div class="slidedown-box" id="orderBox">
					<ul class="chooseul">
						<li data-id="5" class="on">默认排序</li>
						<li data-id="2" >销量最高</li>
						<li data-id="4" >评价最多</li>
						<li data-id="-3" >价格最低</li>
						<li data-id="3" >价格最高</li>
					</ul>
				</div>
				<a href="#" >价格筛选<i class="downicon-buy"></i></a>
				<div class="slidedown-box" id="priceBox">
					<ul class="chooseul">
						<li data-id='' class="on">全部</li>
						<li data-id='0-20'>0-20</li>
						<li data-id='20-40'>20-40</li>
						<li data-id='40-80'>40-80</li>
						<li data-id='80-120'>80-120</li>
						<li data-id='120-200'>120-200</li>
						<li data-id='200-99999'>200以上</li>
					</ul>
				</div>
			</nav>
		</form>
	<!-- end nav  -->
	<!-- end header -->
		<div class="procuct_control">
			<div class="product_wrap">	
					<c:if test="${totalPages!=0}">
						<c:forEach var="item" items="${page.content}">
							<div class="product_item">
								<a href="../item/${item.orgProductItem.goodsId}">
									<div class="pic_box"><img src="${item.orgProductItem.goodsImg180}" alt="${item.orgProductItem.goodsName}"></div>
									<div class="title_box">
										<span>${item.orgProductItem.goodsName}</span>
									</div>
									<div class="price_box">
										<span class="yellow price">
											<c:if test="${empty item.orgProductItemAide.realPrice}">暂无报价</c:if>
											<c:if test="${!empty item.orgProductItemAide.realPrice}"><i class="rmb">￥</i><fmt:formatNumber type="currency" pattern="0.00" value="${item.orgProductItemAide.realPrice}"/></c:if>
										</span>
											<c:if test="${item.orgProductItemAide.canSale}">
												 <a class="addcar-wrapper" href="javascript:void(0);" onclick='javascript:addCart("${item.orgProductItemAide.goodsId}","${item.orgProductItemAide.goodsSn}",$(this).parents(".product_item").find("img"));'><span class="addcar"></span></a>
											</c:if>
											<c:if test="${!item.orgProductItemAide.canSale}">
											 	 <a class="addcar-wrapper" href="javascript:void(0);"><span class="addnocar">无货</span></a>
											</c:if>									 	
									</div>
								</a>
							</div>
						</c:forEach>
					</c:if>
					<c:if test="${totalPages==0}">
						<div class="nolist">抱歉无此商品</div>
					</c:if>
				</div>
		</div>
		<!-- end wrapper -->
		<div class="loadcircle gray" id="loadMore" style="opacity:0;" data-page-next="1">
				<span class="bounce-text">正在加载</span>
				<span class="bounce bounce1"></span>
				<span class="bounce bounce2"></span>
				<span class="bounce bounce3"></span>
			</div>
		<div class="mask "></div>
	</div>
	<!-- end box -->
	<div class="fixed-shopcar" onclick="javascript:location.href='${ctx}/cart/list';"></div>
	<div class="gotop" onclick="move()"></div>
<%@ include file="../common/common_js.jsp"%>
<script type="text/javascript" src="${jsBase}/common/addcart.js"></script>
<script type="text/javascript" src="${jsBase}/search/result.js"></script>
</body>
</html>