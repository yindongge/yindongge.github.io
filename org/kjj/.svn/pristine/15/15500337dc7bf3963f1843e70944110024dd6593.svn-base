<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="../common/common_meta.jsp" %>
<%@include file="../common/common_css.jsp" %>
<title>快捷健</title>
</head>
<body >
	<div class="box">
		<div class="box-content">
			<%@include file="../common/common_head.jsp" %>
		</div>
		<div class="article">
			<div class="out">
				<ul class="img_box">
				<c:if test="${not empty  bannerList}">
					<c:forEach items="${bannerList}" var="item" varStatus="i">
						<c:if test="${i.index == 0}"><li style="display:block"></c:if><c:if test="${i.index != 0}"><li></c:if><c:if test="${empty item.bannerUrl}"><a href="javascript:void(0);" target="_blank"></c:if><c:if test="${!empty item.bannerUrl}"><a href="${item.bannerUrl}" target="_blank"></c:if><img src="${item.bannerImg}" alt="${item.title}"></a></li>
					</c:forEach>
				</c:if>
				<c:if test="${empty bannerList}">
					<li style="display:block"><a href="#"><img alt="" src="${imgBase}/1.jpg"></a></li>
				</c:if>
				</ul>
				<div class="mod"></div>
			</div>
		</div>
			<!-- 结束图片滚动 -->
			<div class="box-content">
				<section class="section">
					<a href="${ctx}/search/result?catId=31">
						<div class="at-img img1"></div>
						<div class="at-text">精品购物</div>
					</a>
					<a href="javascript:void(0);">
						<div class="at-img img2"></div>
						<div class="at-text">防伪溯源</div>
					</a>
					<a href="${ctx}/member">
						<div class="at-img img4"></div>
						<div class="at-text">会员服务</div>
					</a>
					<a href="javascript:void(0);">
						<div class="at-img img5"></div>
						<div class="at-text">优惠活动</div>
					</a>
					<a href="${ctx}/aboutUs/desc?id=19">
						<div class="at-img img6"></div>
						<div class="at-text">关于我们</div>
					</a>
				</section>
			</div>
			<!-- 结束列表 -->
			<div class="box-content">
				<footer class="footer">
					    <div class="swiper-container">
					        <div class="swiper-wrapper">
					        	<c:forEach items="${floorList}" var="item">
					        	<div class="swiper-slide">
					            	<h5>${item.floorname }</h5>
					            	<div class="floor">
					            		<div class="floor-left fl">
					            			<a href="javascript:void(0);"><img src="${item.page1}"/></a>
					            		</div>
					            		<div class="floor-right fr">
					            			<c:forEach items="${item.productList}" var="product" begin="0" end="5">
					            			<a href="${ctx }/item/${product.productid}/0" class="f-all">
					            				<div class="f-img">
					            					<img src="${fn:replace(product.goodsImg180, '_.', '_180x180.') }"/>
					            				</div>
					            				<span>售价：<i class="yellow"><fmt:formatNumber type="currency" pattern="0.00" value="${product.shopPrice}"/></i></span>
					            			</a>
					            			</c:forEach>
					            		</div>
					            	</div> 
					            </div>
					        	</c:forEach>
					        </div>
					        <div class="swiper-button-next same-btn"></div>
					        <div class="swiper-button-prev same-btn"></div>
					    </div>	
				</footer>
			</div>
	</div>
<input id="kjjbackurl" type="hidden" value="<%=basePath%>${sessionScope.kjjbackurl}"/>
<%@include file="../common/common_js.jsp"%>
<script src="${jsBase}/home/index.js" type="text/javascript"></script>
</body>
</html>