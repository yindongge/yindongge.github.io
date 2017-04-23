<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/common_java.jsp"%>

<script type="text/javascript">
	var startTime = "${startTime}";
	var endTime = "${endTime}";
</script>
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
		<link href="${cssBase}/common.css" type="text/css" rel="stylesheet"/>
		<%@ include file="../common/common_js.jsp"%>
		<title>${special.specialName}-快捷健商城</title>

	</head>
<body>
	<div class="box2" style="background-color:#${special.backColor}">
		<!-- html内容 -->
	    ${rule.ruleHtml}
	    <!-- 图片链接 -->
	    <c:forEach items="${linkList}" var="linkObject">
			<header class="box2-top">
			    <c:if test="${linkObject.type=='1'}">
			    	<a href="${linkObject.url}" target="_blank"><img src="${linkObject.imagePath}" alt="${linkObject.title}"/></a>
			    </c:if>
			    <c:if test="${linkObject.type=='2'}">
			        <a href="${ctx}/item/${linkObject.goodsId}" target="_blank"><img src="${linkObject.imagePath}" alt="${linkObject.title}"/></a>
			    </c:if>
			</header>
		</c:forEach>
		<!-- 楼层 -->
		<c:forEach items="${floorList}" var="floor">
			<div class="same-floor green-line" style="background-color:#${special.backColor}">
				<p class="title-img">
					<img src="${floor.imgPath}"  style="width:100%">
				</p>
				<div class="boxlist">
					<c:forEach items="${floor.productList}" var="product">
						<c:if test="${product.type=='1'}">
							<a> <span class="lowprice"></span>
								<div class="b-listimg" onclick="window.location.href='${ctx}/item/${product.goodsId}'">
									<img src="${product.orgProductItemAll.orgProductItem.goodsImg180 }" />
								</div>
								<div class="b-listtext">
									<h4>${product.orgProductItemAll.orgProductItem.goodsName }</h4>
									<div class="b-price">
										<span class="gray-text">¥<fmt:formatNumber type="currency" pattern="0.00" value="${product.orgProductItemAll.orgProductInventory.sourcePrice}"/></span> <span class="yellow-text">¥<fmt:formatNumber type="currency" pattern="0.00" value="${product.orgProductItemAll.orgProductItemAide.realPrice}"/></span>
										<i onclick='javascript:addCart("${product.orgProductItemAll.orgProductItem.goodsId}","${product.orgProductItemAll.orgProductItem.goodsSn}"
										,$(this).parents(".b-listtext").prev().find("img"));'></i>
									</div>
								</div>
								<c:if test="${product.orgProductItemAll.orgProductInventory.shopAmount < 1}">
									<div class="white_mask"></div>
									<div class="no_circle" onclick="window.location.href='${ctx}/item/${product.goodsId}'" >
										<img src="${imgBase}/no_circle.png" alt="">
									</div>
								</c:if>
							</a>
						</c:if>
						
						<c:if test="${product.type=='2'}">
							<a href="${product.url}"> <span class="lowprice"></span>
								<div class="b-listimg">
									<img src="${product.imagePath}" alt="" />
								</div>
								<div class="b-listtext">
									<h4></h4>
									<div class="b-price">
										<span class="gray-text"></span> <span class="yellow-text"></span>
										<i></i>
									</div>
								</div>
								<div class="zhuanti_img"><img src="${product.imagePath}" alt=""></div>
							</a>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</c:forEach>
	    <div class="same-floor green-line" style="background-color:#${special.backColor}">
			<div class="same-tip">
				${rule.ruleContent}
			</div>
		</div>
	</div>
	<div class="fixed-shopcar" onclick="javascript:location.href='${ctx}/cart/list';"></div>
	<div class="gotop" onclick="move()"></div>
	<div class="home_back">
		<a href="${ctx}"></a>
	</div>
	<script type="text/javascript" src="${jsBase}/common/addcart.js"></script>
	<script type="text/javascript" src="${jsBase}/special/show.js"></script>
</body>
</html>