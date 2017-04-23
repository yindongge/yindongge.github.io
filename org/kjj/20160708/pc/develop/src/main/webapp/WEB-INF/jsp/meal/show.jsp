<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<%@include file="../common/common_css.jsp" %>
<title>快捷健商城</title>
</head>
<body>
<div class="all memberall">
	<%@include file="../common/common_head.jsp" %>
	<!-- end top -->
	<div class="center-content">
	<!-- end top -->
	<div class="header">
		<div class="container">
			<div class="logo fl">
				<a href="${ctx}"><img src="${imgBase}/logo.jpg"/></a>
				<%@include file="../common/common_shop.jsp" %>
			</div>
			<div class="search fl">
				<%@include file="../common/common_search.jsp" %>
			    <div class="hotword">
			    	<a href="javascript:void(0)">热门搜索:</a>
			    	<c:if test="${!empty kjjuser.orgShop.shopSearch}"></c:if>
			    	<c:forEach items="${fn:split(kjjuser.orgShop.shopSearch, ',')}" var="keyword">
			    		<a href="${ctx}/search/result?keyword=${keyword}">${keyword}</a>
			    	</c:forEach>
			    </div>
			</div>
			<%@include file="../common/common_cart.jsp" %>
		</div>
	</div>
	<!-- end header -->
	
			<div class="nav-index">
			<div class="container ">
				<div class="nav-side-reverse slideme ">
					<div class="a-control ">
						<a href="#">全部商品分类 <i class="glyphicon glyphicon-menu-down"></i></a>
					</div>
					<!--所有分类 Start-->
					<div class="wrap">
						<div class="all-sort-list" id="classdiv">
							<c:forEach items="${listClass}" var="classLevelOne" varStatus="status">
							<div class="item ">
								<h3>
									<a href="${ctx}/search/result?catId=${classLevelOne.classId}" class="special">${classLevelOne.className}</a>
									<c:forEach items="${classLevelOne.childrenList}" var="classLevelTwo">
										<c:if test="${classLevelTwo.classShowmenu == 1}">
										<a href="${ctx}/search/result?catId=${classLevelTwo.classId}">${classLevelTwo.className}</a>
										</c:if>
									</c:forEach>
									<span class="glyphicon glyphicon-menu-right pull-right"></span>
									<!-- <b></b> -->
								</h3>					
								<div class="item-list clearfix" >
									<div class="subitem">
										<dl class="fore1">
											<dd>
												<c:forEach items="${classLevelOne.childrenList}" var="classLevelTwo">
													<a href="${ctx}/search/result?catId=${classLevelTwo.classId}">${classLevelTwo.className}</a>
												</c:forEach>
											</dd>
										</dl>
										<div class="line2 l1">
											<img src="${imgBase}/classImg${classLevelOne.classId}.jpg"/>
										</div>
									</div>
									
								</div>
							</div>
							</c:forEach>
						</div>
					</div>
					<!--所有分类 End-->

				</div>
				<div class="nav-sideright">
					<ul>
						<li><a href="${ctx}" class="blue">首页</a></li>
						<c:if test="${kjjuser.orgShop.hasMealService}">
						<li><a href="${ctx}/meal/show" class="blue">送餐</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	
	<!-- start foods -->
	<div class="container">
		<div class="take-out-wrapper">
			<div class="take-out-shop">
				<div class="take-out-shop-leftitem">
					<img src="${imgBase}/1.png" alt="" />
					<h5>快捷健超市(${kjjuser.orgShop.shopName})</h5>
					<p>门店地址:${kjjuser.orgShop.address}    ${kjjuser.orgShop.firstPhoneAreaCode}-${kjjuser.orgShop.firstPhoneNo}</p>
					<p>0元起送 免费配送 由快捷健直送 10.00-11.30下单-11.30-12.30送达</p>
				</div>
				<div class="take-out-shop-rightitem">
					<div class="div-block">
						<span class="red">￥0</span>
						<span class="gray">起送</span>
					</div>
					<div class="div-block">
						<span class="red">￥0</span>
						<span class="gray">配送费</span>
					</div>
					<div class="div-block">
						<span class="red">30分钟</span>
						<span class="gray">平均送达时间</span>
					</div>
				</div>
			</div>
			<div class="take-out-content">
				<div class="take-out-firstitem">
					<div class="t-o-title">
						<a href="" class="active">菜品<span></span></a>
					</div>
					<div class="t-o-list">
					<c:forEach items="${productItemAllList}" var="item">
						<a href="${ctx}/item/${item.orgProductItem.goodsId}" target="_blank" title="${item.orgProductItem.goodsName}">${item.orgProductItem.goodsName}</a>
					</c:forEach>
					</div>
				</div>
				<div class="take-out-lastitem">
					<div class="t-o-left-wrapper">
						<div class="t-o-left">
							<h4>精选午餐</h4>
							<div class="food-classfiy">
							<c:forEach items="${productItemAllList}" var="item">
								<div class="foods-item" data-buy-max="${item.orgProductItemAide.userBuyMax}" data-inventory-num="${item.orgProductInventory.shopAmount}">
									<a href="${ctx}/item/${item.orgProductItem.goodsId}" target="_blank"><img src="${item.orgProductItem.goodsImg180}" alt=""  class="foodsimg" /></a>
									<h3>${item.orgProductItem.goodsName}</h3>
									<p>${item.orgProductItem.goodsBrief}</p>
									<p>已售<c:if test="${empty item.orgProductItem.saleNum}">0</c:if><c:if test="${not empty item.orgProductItem.saleNum}">${item.orgProductItem.saleNum}</c:if>份</p>
									<div class="lastp">
										<span class="red">
										<c:if test="${empty item.orgProductItemAide.realPrice}">暂无报价</c:if>
										<c:if test="${!empty item.orgProductItemAide.realPrice}"><span class="rmb">￥</span><fmt:formatNumber type="currency" pattern="0.00" value="${item.orgProductItemAide.realPrice}"/></c:if>
										</span>
										<c:choose>
										<c:when test="${!item.orgProductItemAide.canSale}">
											 <div class="as">
											 	<span class="guige"><font color="red">无货</font></span>
											 </div>
										</c:when>	
										<c:when test="${item.orgProductItem.amount>0}">
										<div class="as" data-goodsid="${item.orgProductItem.goodsId}" data-goodssn="${item.orgProductItem.goodsSn}">
											<span class="jian"></span>
											<span class="num">${item.orgProductItem.amount}</span>
											<span class="jia"></span>
										</div>
										</c:when>
										<c:otherwise>
											<div class="as" data-goodsid="${item.orgProductItem.goodsId}" data-goodssn="${item.orgProductItem.goodsSn}">
											<span class="jian" style="display:none"></span>
											<span style="display:none" class="num"></span>
											<span class="jia"></span>
											</div>
										</c:otherwise>
										</c:choose>
									</div>
								</div>
							</c:forEach>
							</div>
						</div>
					</div>
					<div class="t-o-right">
						<h4>订餐必读&门店公告</h4>
						<ul>
							<li>一、由快捷健直送 10.00-11.30下单，11.30-12.30送达，为保证您的菜品品质，请亲们耐心等待，我们会尽快送达。谢谢您的配合！</li>
							<li>二、请确保您的电话畅通，以便送餐员能及时联系上您。</li>
							<li>三、任何订餐问题随时联系客服，欢迎致电，客服热线4000-306-603。</li>
							<li>四、可使用支付宝、微信、进行在线支付。</li>
							<li>五、支持发票开具，如需发票请联系客服。</li>
						</ul>

					</div>
				</div>
			</div>
		</div>
	</div>
 <!-- end  foods -->

<!-- 
<div class="lunch-shopcar">
	<div class="lunch-title">
		<span class="yellow">购物车</span>
		<a href=""><span class="lajiicon"></span>清空全部</a>
	</div>
	<div class="lunch-body">
		<table class="table ">
			<tbody>
				<tr>
					<td ><div class="l-name">冰咖啡</div></td>
					<td ><div class="l-price">$45.00</div></td>
					<td >
						<div class="l-add">
							<a>-</a>
							<input type="text"  value="12" />
							<a>+</a>
						</div>
					</td>
				</tr>
					<tr>
					<td ><div class="l-name">冰咖啡</div></td>
					<td ><div class="l-price">$45.00</div></td>
					<td >
						<div class="l-add">
							<a>-</a>
							<input type="text"  value="12" />
							<a>+</a>
						</div>
					</td>
				</tr>
				<tr>
					<td ><div class="l-name">冰咖啡</div></td>
					<td ><div class="l-price">$45.00</div></td>
					<td >
						<div class="l-add">
							<a>-</a>
							<input type="text"  value="12" />
							<a>+</a>
						</div>
					</td>
				</tr>
					<tr>
					<td ><div class="l-name">冰咖啡</div></td>
					<td ><div class="l-price">$45.00</div></td>
					<td >
						<div class="l-add">
							<a>-</a>
							<input type="text"  value="12" />
							<a>+</a>
						</div>
					</td>
				</tr>
					<tr>
					<td ><div class="l-name">冰咖啡</div></td>
					<td ><div class="l-price">$45.00</div></td>
					<td >
						<div class="l-add">
							<a>-</a>
							<input type="text"  value="12" />
							<a>+</a>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="lunch-bottom">
		<div class="l-car-left">
			<span class="circle"><i>12</i></span>
			<span class="last-span">还需付:￥23.00</span>
		</div>
		<div class="l-pay-right">
			<a href="">去结算</a>
		</div>
	</div>
</div>

-->
</div>
</div>
<%@include file="../common/common_foot.jsp" %>
<%@include file="../common/common_js.jsp"%>
<script src="${jsBase}/meal/show.js" type="text/javascript"></script>
</body>
</html>