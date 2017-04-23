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
<meta name="keywords" content='${orgProductItemAll.orgProductItem.goodsName},<c:forEach var="skuSpec" items="${orgProductDetailAll.orgProductItem.orgProductItemLinkSalespecList}"><c:forEach var="allSpec" items="${orgProductDetailAll.orgProductItem.specTypeList}"><c:if test="${skuSpec.specId==allSpec.specId}">${allSpec.specValue},</c:if></c:forEach></c:forEach> 快捷健,快捷健网上商城,连锁便利店,kjj,kjjhome,O2O便利店,网上便利店,掌上便利店,1小时送达,货到付款,当日送达,免费送货上门,CBD便利店,酒水饮料,办公日用,进口食品,糖果零食,个护化妆,日常用品' />
<meta name="description" content='<c:forEach var="skuSpec" items="${orgProductDetailAll.orgProductItem.orgProductItemLinkSalespecList}"><c:forEach var="allSpec" items="${orgProductDetailAll.orgProductItem.specTypeList}"><c:if test="${skuSpec.specId==allSpec.specId}">${allSpec.specValue},</c:if></c:forEach></c:forEach>高品质O2O便利店，在线下单，全场0元起，免费配送，1小时极速送达，货到付款。kjjhome是快捷健电子商务有限公司打造的线上购物O2O平台' />

<%@ include file="../common/common_css.jsp"%>

<title>${orgProductItemAll.orgProductItem.goodsName}-快捷健商城</title>
</head>
<body>
<div class="box box-gray box-control padding-top">
	<header class="header fixed">
		<div class="head-content">商品介绍</div>
		<div class="head-left"><a href="javascript:history.go(-1);" class="link"></a></div>
	</header>
	<!-- end top -->
	<div class="swiper-container swipecontrol" style="margin-top:-15%">
	    <div class="swiper-wrapper">
			<c:forEach var="itemImg" items="${orgProductDetailAll.orgProductImgList}">
				<c:if test="${itemImg.imgUrl ne null && itemImg.imgUrl ne ''}">
	        		<div class="swiper-slide"><a><img src="${itemImg.imgUrl}"></a></div>
	        	</c:if>	
			</c:forEach>			
	    </div>
	    <!-- 如果需要分页器 -->
	    <div class="swiper-pagination"></div>
	</div>
	<!-- end 滑动 -->
	<!-- 商品详情 -->
		<div class="goods-wrapper">
			<div class=" detail" >
				<div class="d-title">
					${orgProductItemAll.orgProductItem.goodsName}
				</div>
				<div class="addredtitle">
					${orgProductItemAll.orgProductItem.goodsBrief}
					<c:if test="${orgProductItemAll.orgProductItemAide.markLimitTimeDiscount}">
						<c:if test="${!empty orgProductItemAll.orgLimitTimeGoods.shopNum}">
							每店限量${orgProductItemAll.orgLimitTimeGoods.shopNum}件
						</c:if>
						<c:if test="${!empty orgProductItemAll.orgLimitTimeGoods.userNum}">
							每用户限购${orgProductItemAll.orgLimitTimeGoods.userNum}件
						</c:if>
						<c:if test="${orgProductItemAll.orgLimitTimeGoods.orgLimitTimeDiscount.checkPhone == 1}">
							绑定手机号才能参加哦
						</c:if>
					</c:if>
				</div>
				<div class="d-zhekou">
					<div class="d-z-left">
						<span class="red ">
						<c:if test="${empty orgProductItemAll.orgProductItemAide.realPrice}">暂无报价</c:if>
						<c:if test="${!empty orgProductItemAll.orgProductItemAide.realPrice}"><span class="rmb">￥</span><span class="english"><fmt:formatNumber type="currency" pattern="0.00" value="${orgProductItemAll.orgProductItemAide.realPrice}"/></span></c:if>
						</span>
						
						<c:if test="${orgProductItemAll.orgProductItemAide.sourcePrice ne orgProductItemAll.orgProductItemAide.realPrice}">
							<span class="red line-trough">
							<c:if test="${empty orgProductItemAll.orgProductItemAide.sourcePrice}">暂无报价</c:if>
							<c:if test="${!empty orgProductItemAll.orgProductItemAide.sourcePrice}"><span class="rmb">￥</span><fmt:formatNumber type="currency" pattern="0.00" value="${orgProductItemAll.orgProductItemAide.sourcePrice}"/></c:if>
							</span>
						</c:if>
						<!-- 活动开始倒计时 -->
						<c:if test="${orgProductItemAll.orgProductItemAide.sourcePrice eq orgProductItemAll.orgProductItemAide.realPrice and !orgProductItemAll.orgProductItemAide.markLimitTimeDiscount and ! empty countDown and LimitTimeGood.price le orgProductItemAll.orgProductItemAide.realPrice}">
							<span class="red line-trough">
							<c:if test="${empty LimitTimeGood}">暂无报价</c:if>
							<c:if test="${!empty LimitTimeGood }"><span class="rmb">￥</span><fmt:formatNumber type="currency" pattern="0.00" value="${LimitTimeGood.price}"/></c:if>
							</span>
							<a class="a-zhekou">${LimitTimeGood.goodsTitle}</a>
						</c:if>
						
						<c:if test="${orgProductItemAll.orgProductItemAide.markLimitTimeDiscount}">
							<a class="a-zhekou">${orgProductItemAll.orgLimitTimeGoods.goodsTitle}</a>
						</c:if>
					</div>
					<div class="d-zhekou">
						<c:if test="${!orgProductItemAll.orgProductItemAide.markLimitTimeDiscount && ! empty countDown and LimitTimeGood.price le orgProductItemAll.orgProductItemAide.realPrice}">
							<div class="d-z-left">
								距活动开启： <span id="countDownEnd" class="red"></span>
							<input id="countDown" type="hidden" value="${countDown}">
							</div>
						</c:if>
						<c:if test="${orgProductItemAll.orgProductItemAide.markLimitTimeDiscount}">
							<div class="d-z-left">
								还有<span id="timeLimit" class="red"></span>结束
							<input id="limitTimeEndiInterval" type="hidden" value="${limitTimeEndiInterval}">
							</div>
						</c:if>
						<div class="d-z-right">
							<div class="d-person">已有${empty orgProductItemAll.orgProductItem.commentNum? 0:orgProductItemAll.orgProductItem.commentNum}	人评论</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 满减满送 -->
			<c:if test="${fn:length(orgReachList)>0}">
				<div class="detail">
					<dl class="floor-detail">
						<dt>促销：</dt>
						<c:forEach items="${orgReachList}" var="orgReach">
							<dd class="special-dd">
								<a class="yellow_a">满减</a>
								<p>${orgReach.title}</p>
							</dd>
						</c:forEach>
					</dl>
				</div>
			</c:if>
		<%-- 
			<div class="detail" >
				<dl class="floor-detail">
					<dt>服务：</dt>
					<dd>
						<span class="bluespan">货到付款</span>
						<span class="bluespan">自提</span>
					</dd>
				</dl>
			</div> 
		--%>
		<div class="detail" >
			<dl class="floor-detail">
				<dt>提示：</dt>
				<dd>
					<span class="bluespan"><fmt:formatDate value="${kjjuser.orgShop.latestSendTime}" type="time" pattern="HH:mm"/>前完成下单，可预约今天送达</span>
					<%-- <span class="bluespan">支持2天无理由退换货</span> --%>
				</dd>
			</dl>
		</div>
		<div class="detail" >
		<c:forEach var="skuSpec" items="${orgProductDetailAll.orgProductItem.orgProductItemLinkSalespecList}" >
			<dl class="floor-detail">
				<dt>${skuSpec.specName}：</dt>
				<dd>
					<c:forEach var="allSpec" items="${orgProductDetailAll.orgProductItem.specTypeList}" >
						<c:if test="${skuSpec.specId==allSpec.specId}">
							<span class="grayspan 
								<c:if test="${skuSpec.specTypeId==allSpec.specTypeId}">
									active
								</c:if>							
							">
								<a href="javascript:Void(0);">${allSpec.specValue}</a>
								<input type="hidden" value='${allSpec.unionId}'>
							</span>
						</c:if>
					</c:forEach>
				</dd>
			</dl>
			</c:forEach>
		</div>
		<input type="hidden" id="ctx" value="${ctx}">
		<input type="hidden" name="goodsId" value="${orgProductItemAll.orgProductItem.goodsId}">
		<input type="hidden" id="itemJson" value='${orgProductDetailAll.itemJson}'>
		<div class="detail " >
			<a href="${ctx}/item/introduce/${orgProductItemAll.orgProductItem.goodsId}" class="jump haveicon">商品详情</a>
		</div>
		<div class="detail " >
			<a href="${ctx}/item/comment/${orgProductItemAll.orgProductItem.goodsId}" class="jump haveicon">商品评价</a>
		</div>
	</div>
	<!-- 商品详情 -->

	<%-- <div class="procuct_control">
			<div class="produce_title"><span>相关商品</span></div>
			<div class="product_wrap">
				<c:forEach var="item" items="${orgProductDetailAll.orgProductItems}" >
					<div class="product_item">
						<a href="#">
							<div class="pic_box">
								<img src="${item.goodsImg180}" alt="">
								<div class="img-change"></div>
							</div>
							<div class="title_box">
								<span>${item.goodsName}</span>
							</div>
							<div class="price_box">
								<span class="yellow price">￥${item.shopPrice}</span>
							</div>
						</a>
					</div>
				</c:forEach>
			</div>
		</div> --%>
		<!-- end product -->
		<div class="bottom-nav">
				<a href="${ctx}/item/introduce/${orgProductItemAll.orgProductItem.goodsId}">
				商品详情
					<span></span>
				</a>
				<a href="${ctx}/item/comment/${orgProductItemAll.orgProductItem.goodsId}">
				商品评价
					<span></span>
				</a>
				<a href="${ctx}/item/consult/${orgProductItemAll.orgProductItem.goodsId}">
				商品咨询
					<span></span>
				</a>
		</div>
	<footer class="footer">
		<p>客户服务热线：4000-306-603</p>
		<p>KJJHOME.COM 快捷健商城</p>
	</footer>
	<div class="gotop" ></div>
	<div class="fixed-bottom paddinglr">
		<div class="join">
			<a id="addCart" href="javascript:void(0);" 
			<c:if test="${orgProductItemAll.orgProductItemAide.canSale}">onclick="addCart('${orgProductItemAll.orgProductItem.goodsId}','${orgProductItemAll.orgProductItem.goodsSn}')" class="samebtn bluebtn"</c:if>
			<c:if test="${!orgProductItemAll.orgProductItemAide.canSale}">class="samebtn bluebtn bggray"</c:if>
			>加入购物车</a>
		</div>   
		<%-- 
		<div class="join-car">
			<a href="${ctx}/cart/list"></a>
			<i ><div id="cartCount"><c:if test="${empty kjjcartcount}">0</c:if><c:if test="${!empty kjjcartcount}">${kjjcartcount}</c:if></div></i>
		</div>
		 --%>
		<div class="join-car">
			<a href="${ctx}/cart/list">
				<em class="em_car"><i><div id="cartCount"><c:if test="${empty kjjcartcount}">0</c:if><c:if test="${!empty kjjcartcount}">${kjjcartcount}</c:if></div></i></em>
				<span class="join-car-text">购物车</span>
			</a>
		</div>
			
	</div>
</div>
<!-- end box -->
<%@ include file="../common/common_js.jsp"%>
 <script type="text/javascript" src="${jsBase}/item/detail.js"></script>

</body>
</html>