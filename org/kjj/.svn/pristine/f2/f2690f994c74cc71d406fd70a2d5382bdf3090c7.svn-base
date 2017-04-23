<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<%@include file="../common/common_css.jsp" %>
<title>快捷健商城</title>
<% response.setHeader("Pragma","No-cache"); 
   response.setHeader("Cache-Control","No-cache"); 
   response.setDateHeader("Expires", -1);
   response.setHeader("Cache-Control", "No-store"); %>
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
	
	<!-- end header -->
	<!-- start foods -->
	<div class="delicious_box">
	<div class="container">
		<div class="take-out-wrapper">
			<div class="take-out-content">
				<div class="delicious_foods_l">
				<c:forEach items="${productItemAllList}" var="item">
				<div class="delicious_list" data-buy-max="${item.orgProductItemAide.userBuyMax}" data-inventory-num="${item.orgProductInventory.shopAmount}">
						<a href="${ctx}/item/${item.orgProductItem.goodsId}" target="_blank"><div class="deli_img_item"><img src="${item.orgProductItem.goodsImg180}" alt="" /></div></a>
						<div class="deli_content_item">
							<h5><a href='javascript:void(0)' title="${item.orgProductItem.goodsName}">${item.orgProductItem.goodsName}</a></h5>
							<div class="deli_item_title">${item.orgProductItem.goodsBrief}</div>
							<div class="deli_item_number"><span>已售<c:if test="${empty item.orgProductItem.saleNum}">0</c:if><c:if test="${not empty item.orgProductItem.saleNum}">${item.orgProductItem.saleNum}</c:if>份</span></div>
							<div class="deli_item_price">
								<span>
								<c:if test="${empty item.orgProductItemAide.realPrice}">暂无报价</c:if>
								<c:if test="${!empty item.orgProductItemAide.realPrice}"><span>￥<i><fmt:formatNumber type="currency" pattern="0.00" value="${item.orgProductItemAide.realPrice}"/></i></span></c:if>
								</span>
								<c:choose>
								<c:when test="${!item.orgProductItemAide.canSale}">
									<c:if test="${moonBefore == 1}">
										<div class="deli_item_join">
											<a href="#" class="join_car gray">备货中</a>
										</div>
									</c:if>
									<c:if test="${moonBefore != 1}">
										<div class="deli_item_join">
											<a href="#" class="join_car gray">加入购物车</a>
										</div>
									</c:if>
								</c:when>
								<c:when test="${item.orgProductItem.amount>0}">
										<div class="deli_item_join" data-goodsid="${item.orgProductItem.goodsId}" data-goodssn="${item.orgProductItem.goodsSn}" style="display:none">
												<a href="" class="join_car">加入购物车</a>
										</div>
										<div class="deli_item_join" >
											<div class="qu-form" data-goodsid="${item.orgProductItem.goodsId}" data-goodssn="${item.orgProductItem.goodsSn}">
												<a class="a1"></a>
												<input type="text" class="num" readonly="true" value="${item.orgProductItem.amount}">
												<a class="a2"></a>
											</div>
										</div>
								</c:when>
								<c:otherwise>
										<div class="deli_item_join" data-goodsid="${item.orgProductItem.goodsId}" data-goodssn="${item.orgProductItem.goodsSn}">
											<a href="javascript:void(0)" class="join_car">加入购物车</a>
										</div>
										<div class="deli_item_join" style="display:none">
											<div class="qu-form" data-goodsid="${item.orgProductItem.goodsId}" data-goodssn="${item.orgProductItem.goodsSn}">
												<a class="a1"></a>
												<input type="text" class="num" readonly="true" value="">
												<a class="a2"></a>
											</div>
										</div>
								</c:otherwise>
								</c:choose>
							</div>
						<c:if test="${!item.orgProductItemAide.canSale && moonBefore != 1}">
							<div class="empty_food">
							</div>
						</c:if>
						</div>
					</div>
					</c:forEach>
					</div>
					<div class="delicious_foods_r">
					<div class="d_top">
						<a>
							<span class="span_fi"><i>0</i>元</span>
							<span class="span_se">起送</span>
						</a>
						<a>
							<span class="span_fi"><i>0</i>元</span>
							<span class="span_se">配送</span>
						</a>
						<a>
							<span class="span_fi"><i>1</i>小时</span>
							<span class="span_se">内送达</span>
						</a>
					</div>
					<div class="d_first">
						<h5>订餐必读&门店公告</h5>
						<ul class="d_intro">
							<li>一、由快捷健直送 10.00-11.30下单，11.30-12.30送达，为保证您的菜品品质，请亲们耐心等待，我们会尽快送达。谢谢您的配合！</li>
							<li>二、请确保您的电话畅通，以便送餐员能及时联系上您。</li>
							<li>三、任何订餐问题随时联系客服，欢迎致电，客服热线4000-306-603。</li>
							<li>四、可使用支付宝、微信、进行在线支付。</li>
							<li>五、支持发票开具，如需发票请联系客服。</li>
						</ul>
					</div>
					<div class="d_new_right">
					<div class="d_second" id="allmap"></div>
					<input type="hidden" class="form-control" name="longitude" id="longitude" value="${kjjuser.orgShop.longitude}" required data-bv-notempty-message="经度不能为空"/>
					<input type="hidden" name="latitude" id="latitude" value="${kjjuser.orgShop.latitude}"/>
					<input type="hidden" name="shopId" id="shopId" value="${kjjuser.orgShop.shopId}"/>
					<input type="hidden" name="shopName" id="shopName" value="${kjjuser.orgShop.shopName}"/>
					<input type="hidden" name="address" id="address" value="${kjjuser.orgShop.address}"/>
					<div class="d_third">
						<h5>配送范围</h5>
						<div class="d_area_list">
						</div>
					</div>
					</div>
				</div>
				</div>
			</div>
		</div>
	</div>
	</div>
 <!-- end  foods -->

<div class="side-toolbar">
	<div class="side-fistlist">
		<div class="side_item side_1" id="self">
		<em></em>
		</div>
		<div class="side_item side_2" id="cart">
			<em></em>
			<span class="red_count"><c:if test="${kjjcartcount==null}">0</c:if><c:if test="${kjjcartcount!=null}">${kjjcartcount}</c:if></span>
		</div>
		<div class="side_item side_3" id="coupon">
		<em></em>
		</div>
		<div class="side_item side_4" id="myorder">
		<em></em>
		</div>
	</div>
	<div class="side-secondlist">
		<div class="side_item side_5" ><em></em>
		</div>
		<div class="side_item side_6">
		<em></em>
			<div class="side_erweima">
				<img src="${imgBase}/erweima3.jpg" alt="" />
				<span>扫描并关注</span>
			</div>
		</div>
		<div class="side_item side_7" id="feedback">
		<em></em>
		</div>
	</div>
	<div class="mask-index" style="display:none"></div>
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
<script src="${jsBase}/common/addcart.js" type="text/javascript"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=D1DhyuyKwUtxW0r52g0gzxtFFviKv0tk"></script>
<script src="${jsBase}/meal/show.js" type="text/javascript"></script>
</body>
</html>