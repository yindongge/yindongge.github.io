<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<%@include file="../common/common_css.jsp" %>
<link href="${cssBase}/special.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	var startTime = "${startTime}";
	var endTime = "${endTime}";
</script>
<title>${special.specialName}-快捷健商城</title>
<% response.setHeader("Pragma","No-cache"); 
   response.setHeader("Cache-Control","No-cache"); 
   response.setDateHeader("Expires", -1);
   response.setHeader("Cache-Control", "No-store"); %>
</head>
<body>
<div class="all memberall">
	<%@include file="../common/common_head.jsp" %>

	<div class="center-content">
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
	</div>
</div>

<div class="actAll" style="background-color:#${special.backColor}">
	<div class="center-content " style="margin-top:0px">
	    <!-- html内容 -->
	    ${rule.ruleHtml}
	    <!-- 图片链接 -->
	    <c:forEach items="${linkList}" var="linkObject">
			<div class="same-title">
			    <c:if test="${linkObject.type=='1'}">
			    	<a href="${linkObject.url}" target="_blank"><img src="${linkObject.imagePath}" alt="${linkObject.title}"/></a>
			    </c:if>
			    <c:if test="${linkObject.type=='2'}">
			        <a href="${ctx}/item/${linkObject.goodsId}" target="_blank"><img src="${linkObject.imagePath}" alt="${linkObject.title}"/></a>
			    </c:if>
			</div>
		</c:forEach>
		<!-- 楼层 -->
		<c:forEach items="${floorList}" var="floor">
			<div class="same-title">
				<img src="${floor.imgPath}" alt=""/>
			</div>
			<div class="redbox" id="link2" style="background:#${special.backColor}">
				<div class="container" style="width: 1000px;">
				<c:forEach items="${floor.productList}" var="product">
				    <c:if test="${product.type=='1'}">
				    	<div class="hotitem">
				    		<div class="hot-list">
				    			<a class="hot-a" >
									<div class="hot-img" onclick="window.open('${ctx}/item/${product.goodsId}')" title="点击查看商品详细">
										<img src="${product.orgProductItemAll.orgProductItem.goodsImg350 }">
									</div>
									<div class="hot-text">
										<h4>${product.orgProductItemAll.orgProductItem.goodsName }</h4>
										<div class="hot-price" data-goodsid="${product.orgProductItemAll.orgProductItem.goodsId}" data-goodssn="${product.orgProductItemAll.orgProductItem.goodsSn}">
											<span class="hot-delete">¥<fmt:formatNumber type="currency" pattern="0.00" value="${product.orgProductItemAll.orgProductInventory.sourcePrice}"/></span> <span class="hot-normal"><i>¥
											</i><fmt:formatNumber type="currency" pattern="0.00" value="${product.orgProductItemAll.orgProductItemAide.realPrice}"/></span> <span class="hot-icon <c:if test="${product.orgProductItemAll.orgProductInventory.shopAmount < 1}">gray</c:if>" title="点击加入购物车"></span>
										</div>
									</div>
								</a> <span class="lowprice"></span>
							</div>
							<c:if test="${product.orgProductItemAll.orgProductInventory.shopAmount > 0}">
								<div class="black_mask"></div>
							</c:if>
							<c:if test="${product.orgProductItemAll.orgProductInventory.shopAmount < 1}">
								<div class="white_mask"></div>
								<div class="no_circle" onclick="window.open('${ctx}/item/${product.goodsId}')" title="点击查看商品详细">
									<img src="${imgBase}/no_circle.png" alt="">
								</div>
							</c:if>
						</div>
				    </c:if>
				    <c:if test="${product.type=='2'}">
				    	<div class="hotitem">
				    		<div class="hot-list">
				    			<a href="${product.url}" target="_blank"><img src="${product.imagePath}" alt="" class="zhuaunti_lead_img"></a>
							</div>
							<div class="black_mask"></div>
						</div>
				    </c:if>
				</c:forEach>
				</div>
			</div>
		</c:forEach>
		
		<div class="redbox" id="link2">
			<div class="container" style="width: 1000px;">
				<div class="same-tip">
					${rule.ruleContent}
				</div>
				<div class="show-erweima">
					<img src="${imgBase}/day1.png" alt="">
				</div>
			</div>
		</div>
	</div>
</div>

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
				<img src="${imgBase}/erweima3.png" alt="" />
				<span>扫描二维码</span>
			</div>
		</div>
		<div class="side_item side_7" id="feedback">
		<em></em>
		</div>
	</div>
</div>
<%@include file="../common/common_foot.jsp" %>
<%@include file="../common/common_js.jsp"%>
<script src="${jsBase}/common/addcart.js"  type="text/javascript"></script>
<script src="${jsBase}/special/show.js"    type="text/javascript"></script>
<script src="${jsBase}/special/ui.js"      type="text/javascript"></script>

</body>
</html>