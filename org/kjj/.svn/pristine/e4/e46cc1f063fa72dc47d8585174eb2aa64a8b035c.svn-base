<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="keywords" content="网上购物,网上商城,零食,食品,酒水饮料,粮油调味,个护化妆,办公日用,快捷健商城"/>
<meta name="description" content="快捷健商城KJJHOME.COM-销售国内外各大品牌食品、零食、酒水饮料、粮油调味、个人化妆、办公日用.快乐、便捷、健康，让快捷健商城的生活更健康!"/>
<%@include file="../common/common_css.jsp" %>
<title>快捷健商城 – 1小时送达,0元配送,随时取货!</title>
</head>
<body>
<div class="all">
	<%@include file="../common/common_head.jsp" %>
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
			<div class="nav-side-reverse ">
				<div class="a-control">
					<a href="javascript:void(0);">全部商品分类</a>
				</div>
			</div>
			<div class="nav-sideright">
				<ul>
					<li><a href="${ctx}" >首页</a></li>
					<c:if test="${kjjuser.orgShop.hasMealService}">
					<li><a href="${ctx}/meal/show">送餐</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
	<!-- end nav-index -->

	<div class="container-fluid">
		<div class="container">
			<!-- start right float -->
			<div class="carousel-modal">
		<h5>快捷服务</h5>
			<br/>
				<div class="contact-btn">
 					<a href="javascript:void(0);" target="_blank" class="btn2" id="consultBtn" >在线客服</a> 
 					<a href="${ctx}/consultation/addView" target="_blank" class="btn3">留言咨询</a>
 					<p class="yellow">客服热线：4000-306-603</p>
 				</div>
			
				<h4>店内服务</h4>
				<div class="row">
					<c:forEach items="${listShopService}" var="service">
						<div class="col-sm-4">
					    	<a href="javascript:void(0);" class="thumbnail">
					    		<img src="${imgBase}/icon/service${service.serviceId}.png" alt="${service.serviceName}"/>
					    	</a>
					  </div>
					</c:forEach>					  
				</div>
				<p style="color:#ff8a00;padding-left:10px;">配送时间范围内，1小时配送</p>
			</div>
			<!-- end right float -->

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
		<div class="carousel slide" id="allslide" data-ride="carousel">
			<c:if test="${empty shopPage.listShopBanner}">
				<ol class="carousel-indicators" >
					<li data-target='#allslide' data-slide-to="0" class="active"></li>
				</ol>
				<div class='carousel-inner'>
					<div class='item active'>
						<a><img src="${imgBase}/index1.png"/></a>
					</div>
				</div>
			</c:if>
			<c:if test="${!empty shopPage.listShopBanner}">	
				<ol class="carousel-indicators" >	
				<c:forEach items="${shopPage.listShopBanner}" var="banner" varStatus="status">
					<li data-target='#allslide' data-slide-to="${status.index}" <c:if test="${status.first}">class="active"</c:if>></li>
				</c:forEach>
				</ol>
				<div class='carousel-inner'>	
					<c:forEach items="${shopPage.listShopBanner}" var="banner" varStatus="status">
						<div class='item<c:if test="${status.index==0}"> active</c:if>' style="background: url(${banner.orgShopBanner}) no-repeat center;">
							<a class="blocka" href="${banner.orgShopBannerUrl }" target="_blank"></a>
						</div>
					</c:forEach>
				</div>
			</c:if>
		</div>	
	</div>
  <!-- end carsouel -->
  <!-- strat zhedie -->
  <c:if test="${!empty shopPage.listShopRecommand}">	
	<div class="container">
		<div class="main">
		<div class="fourcolor">
		</div>
		<ul class="clearfix ">
			<c:forEach items="${shopPage.listShopRecommand}" var="recommand" varStatus="status">
				<li class="item${status.index}<c:if test="${status.index==0}"> on</c:if>" >

					<a href="${recommand.recommendImgUrl}" target="_blank">
					<img class="small "  src="${recommand.recommandImg1}"/>
					<img class="big "  src="${recommand.recommandImg2}"/>
					</a>
				</li>	
			</c:forEach>
		</ul>
		</div>
	</div>
  </c:if>
  <!-- end zhedie -->
<!-- start future -->
<div  id="floors">
<c:if test="${!empty shopPage.listShopPageFloor}">	
	<c:forEach items="${shopPage.listShopPageFloor}" var="floor" varStatus="status">
		<div class="future " id="${floor.floorid}" <c:if test="${status.first}">data-loading="1"</c:if>></div>
	</c:forEach>
</c:if>
</div>

<!-- end start -->
<c:if test="${!empty kjjuser.orgShop.shopId}">
<%@include file="../common/common_foot.jsp" %>
</c:if>

<div class="mask-modal" style="display:none">

	<div class="mask-title">
		<!-- <div class="close-mask"></div> -->
		<div class=" zhe">
			<a href="javascript:void(0)"><img src="${imgBase}/logo.png" /></a>
		</div>
	</div>

	<div class="mask-body">
		<dl class="dtone">
			<dt >热门城市：</dt>
			<dd class="blue">北京</dd>
		</dl>
		<dl class="dianpulist">
			<i></i>
			<dt>所有店铺：</dt>
			<dd id="shopcontent">
			</dd>
		</dl>
		<p class="red red-control">温馨提示：在店铺1公里范围内可享受阿健免费配送服务
		</p>
	</div>
	
</div>
<div class="mask-index" style="display:none"></div>
</div>
<div class="sidebar">
	<a class="go-top" href="javascript:scrollTo(0,0);"></a>
 	<a class="sidebar-car" href="${ctx }/cart/list">
		<em><c:if test="${empty kjjcartcount}">0</c:if><c:if test="${!empty kjjcartcount}">${kjjcartcount}</c:if></em>
	</a>
	<a class="sidebar-feedback" href="${ctx }/feedback/init"></a>
	<a class="sidebar-erweima" href="javascript:void(0);">
		<div class="showerweima"></div>
	</a>
</div>
<%@include file="../common/common_js.jsp" %>
<script type="text/javascript" src="http://wpa.b.qq.com/cgi/wpa.php"></script>
<script src="${jsBase}/home/index.js" type="text/javascript"></script>
</body>
</html>