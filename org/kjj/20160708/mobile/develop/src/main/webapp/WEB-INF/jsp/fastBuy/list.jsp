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
<%@ include file="../common/common_css.jsp"%>
<title>快捷购-快捷健商城</title>
</head>
<body>

<div class="box padding-top  box-height-fixed box-gray">
		<header class="header fixed">
			<div class="indexhead">
				<c:if test="${kjjuser.orgUsers.lastSendStyle == 0}">
				<div class="indexhead_content " id="divSend">
					<span class="po"></span>
					<span>
					<c:if test="${empty kjjlocation.name}">定位失败</c:if>
					<c:if test="${!empty kjjlocation.name}">${kjjlocation.name}</c:if>
					</span>
					<span class="down"></span>
				</div>
				</c:if>
				<c:if test="${kjjuser.orgUsers.lastSendStyle == 1}">
				<div class="indexhead_content " id="divTake">
					<span class="po"></span>
					<span>
					<c:if test="${empty kjjlocation.name}">定位失败</c:if>
					<c:if test="${!empty kjjlocation.name}">${kjjlocation.name}</c:if>
					</span>
					<span class="down"></span>
				</div>
				</c:if>
				
				<%-- <a class="searchicon" href="${ctx}/search/search"></a> --%>
<!-- 				<div class="head-left"><a href="javascript:history.go(-1);" class="link"></a></div> -->
			</div>
			
		</header>
		<!-- end header -->
	
<!-- buy nav -->
	<div class="fastbuy">
		<div id="wrapper1">
			<div class="buy_left category_left">
				<div class="scroll-controler">
					<input type="hidden" id="curParentCatId"  value="${param.curParentCatId}">
					<input type="hidden" id="curCatId"    value="${param.curCatId}">
					<a id="allItem" href="${ctx}/fastBuy/list" style="background-color:#fff; color:#ff8a00"><span class="span1"></span>全部商品</a>
					<c:forEach items="${listClassLevelOne}" var="levelOne" varStatus="index">
						<div class="a-classfiy-buy">
							<a data-id="${levelOne.classId}"><span class="span${index.count+1}"></span>${levelOne.className}</a>
							<ul class="a-classfiy-list"></ul>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	<!-- wrapper -->
	<div id="wrapper" style="z-index:185">
		<div class="buy_right" >
			<!-- 商品列表 -->
			<div class="buyalllist" style="padding-bottom:0px;"></div>
			<div class="loadcircle gray" id="loadMore" style="opacity:0;" data-page-next="0">
				<span class="bounce-text">正在加载</span>
				<span class="bounce bounce1"></span>
				<span class="bounce bounce2"></span>
				<span class="bounce bounce3"></span>
			</div>
		</div>
	</div>
	<!-- wrapper -->
	</div>
	</div>
	<!-- end box -->
<jsp:include page="../common/common_footerbar.jsp">
	<jsp:param name="active" value="快捷购"/>
	<jsp:param name="cartCount" value="${kjjcartcount}"/>
</jsp:include>
<!-- end fixedbar -->
<div class="gotop" onclick="move()"></div>
<%@ include file="../common/common_js.jsp"%>
<script src="${jsBase}/fastBuy/iscroll.js" type="text/javascript"></script>
<script src="${jsBase}/common/addcart.js" type="text/javascript"></script>
<script src="${jsBase}/fastBuy/list.js" type="text/javascript"></script>
</body>
</html>