<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="../common/common_meta.jsp" %>
<%@include file="../common/common_css.jsp" %>
<%
	String totalPages = (String)request.getAttribute("totalPages");
	request.setAttribute("totalPages", totalPages);
%>
<title>快捷健商城</title>
</head>
<body>
	<div class="box">
		<div class="box-content">
			<%@include file="../common/common_head.jsp" %>
		</div>
		<!-- 结束 头 --> 
		<div class="future">
			<div class="future-left fl">
				<jsp:include page="../common/common_sidebar.jsp">
					<jsp:param name="active" value="精品购物"/>
				</jsp:include>
			</div>
			<div class="future-right  noborder fr">
					<input type="hidden" id="catId" value="${query.catId}"/>
					<input type="hidden" id="keyword" value="${query.keyword}"/>
			 		<div class="future_title">
					<a href="${ctx}/search/result?catId=31" data-catId="31">
						<span class="ic1 n1"></span>
						<span >零食</span>
						<i></i>
					</a>
					<a href="${ctx}/search/result?catId=38" data-catId="38">
						<span class="ic1 n2"></span>
						<span >食品</span>
						<i></i>
					</a>
					<a href="${ctx}/search/result?catId=17" data-catId="17">
						<span class="ic1 n3"></span>
						<span >酒水饮料</span>
						<i></i>
					</a>
					<a href="${ctx}/search/result?catId=30" data-catId="30">
						<span class="ic1 n4"></span>
						<span >粮油调味</span>
						<i></i>
					</a>
					<a href="${ctx}/search/result?catId=52" data-catId="52">
						<span class="ic1 n5"></span>
						<span >个性化妆</span>
						<i></i>
					</a>
					<a href="${ctx}/search/result?catId=56" data-catId="56">
						<span class="ic1 n6"></span>
						<span >办公日用</span>
						<i></i>
					</a>

				</div>
				<div class="listall fl">
					<div class="swiper-container">
						    <div class="swiper-wrapper">
						        <div class="swiper-slide">
						        	<div class="list-jingpin">
						        	<c:forEach items="${page.content}" var="item">
						        		<a onclick="javascript:productTail(${item.orgProductItem.goodsId})">
							        		<div class="jinpin-img"><img src="${item.orgProductItem.goodsImg180}"></div>
							        		<div class="jinpin-text">
							        			<dl>
							        				<dt>商品名称 </dt>
							        				<dd>${item.orgProductItem.goodsName}</dd>
							        			</dl>
							        			<!-- <span class="price yellow"></span> -->
							        			<dl class="specialheight">
							        				<dt class="price yellow">￥<fmt:formatNumber type="currency" pattern="0.00" value="${item.orgProductItemAide.realPrice}"/></dt>
							        				<dd><c:if test="${item.orgProductItemAide.markLimitTimeDiscount}"><span class="bluezhekou">限时折扣</span></c:if></dd>
							        			</dl>
							        		</div>
						        		</a>
						        		</c:forEach>
						        	</div>
						        </div>
						        <c:if test="${requestScope.totalPages > 0}">
						        <c:forEach  step="1" begin="1" varStatus="status" end="${requestScope.totalPages}">
						        <div class="swiper-slide pageuse"  data-page="${status.index}"></div>
						        </c:forEach>
						        </c:if>
						    </div>
						    <div class="swiper-button-prev same-btn" id="prev"></div>
						    <div class="swiper-button-next same-btn" id="next"></div>
						</div>
				</div>
			</div>
		</div>

	</div>			

<%@include file="../common/common_js.jsp"%>
<script src="${jsBase}/search/result.js" type="text/javascript"></script>
</body>
</html>
