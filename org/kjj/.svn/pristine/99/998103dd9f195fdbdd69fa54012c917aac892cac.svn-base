<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<%@include file="../common/common_css.jsp" %>
<title>活动页面-快捷健商城</title>
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
			<div class="nav-side-reverse slideme ">
				<div class="a-control ">
					<a href="javascript:void(0);">全部商品分类 <i class="glyphicon glyphicon-menu-down"></i></a>
				</div>
				<!--所有分类 Start-->
				<div class="wrap">
					<div class="all-sort-list" id="classdiv">
						<c:forEach items="${listClass}" var="classLevelOne" varStatus="status">
						<div class="item ">
							<h3>
								<a href="${ctx}/search/result?classId=${classLevelOne.classId}" class="special">${classLevelOne.className}</a>
								<c:forEach items="${classLevelOne.childrenList}" var="classLevelTwo">
									<c:if test="${classLevelTwo.classShowmenu == 1}">
									<a href="${ctx}/search/result?classId=${classLevelTwo.classId}">${classLevelTwo.className}</a>
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
												<a href="${ctx}/search/result?classId=${classLevelTwo.classId}">${classLevelTwo.className}</a>
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
					<li><a href="${ctx}">首页</a></li>
					<c:if test="${kjjuser.orgShop.hasMealService}">
						<li><a href="${ctx}/meal/show" class="blue">送餐</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
	<!-- end nav-index -->
 </div>	
<!-- 活动页面开始 -->
<jsp:include page="${htmlPage}"/>
<!-- 活动页面结束 -->
<!-- footer -->
<%@include file="../common/common_foot.jsp" %>
<%@include file="../common/common_js.jsp" %>
</body>
</html>