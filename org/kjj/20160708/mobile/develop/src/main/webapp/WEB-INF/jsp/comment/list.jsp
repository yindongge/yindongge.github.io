<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/common_java.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<meta name="apple-touch-fullscreen" content="yes" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />
<link href="${cssBase}/jquery.raty.css" type="text/css" rel="stylesheet" />
<link href="${cssBase}/labs.css" type="text/css" rel="stylesheet" />
<%@ include file="../common/common_css.jsp"%>

<title>快捷健商城</title>
</head>
<body>
	<div class="box box-gray">
		<header class="header">
			<div class="head-content">商品评价</div>
			<div class="head-left">
				<a href="${ctx}/user/center" class="link"></a>
			</div>
		</header>
		<!-- end top -->
		<form id="form" name="form" action="${ctx}/comment/list" method="post">
			<nav class="nav">
				<a href="${ctx}/comment/list?commentStatus=0" class='<c:if test="${query.commentStatus==0}">on</c:if>'>
					待评价(${countCanComment})
					<span></span> 
				</a> 
				<a href="${ctx}/comment/list?commentStatus=1" class='<c:if test="${query.commentStatus==1}">on</c:if>'>
					已评价(${countCanNotComment})
					<span></span>
				</a>
			</nav>
			<!-- end nav -->
			<div class="comment">
				<c:if test="${list.size()!=0}">
					<c:forEach var="list" items="${list}" varStatus="status">
						<div class=" commetntlist" style="margin-bottom:10px">
							<div>
								<a class="listone"
									href="${ctx}/item/${list.goodsId}" >
									<div class="leftimg">
										<img src="${list.orgProductItem.goodsImg180}"
											title="${list.orgProductItem.goodsName}" />
									</div>
									<div class="lefttext">${list.orgProductItem.goodsName}</div>
								</a>
							</div>
							<div class="buff">
								<div class="buff-right toggleup">
									<a class="gopay"> <c:if test="${list.commentStatus==0}">去评价</c:if>
										<c:if test="${list.commentStatus==1}">查看评价</c:if>
									</a>
								</div>
							</div>
							<div class="toggledown">
								<dl class="togglelist">
									<dt>评分:</dt>
									<dd>
										<div class="raty"
											data-score='<c:if test="${list.orgGoodsComment!=null}">${list.orgGoodsComment.starScore}</c:if>'></div>
									</dd>
								</dl>
								<dl class="togglelist">
									<dt>评价:</dt>
									<dd>
										<c:if test="${list.commentStatus==1}">${list.orgGoodsComment.goodsComment}</c:if>
										<c:if test="${list.commentStatus==0}"><textarea  name="goodsComment" cols="30" rows="10"></textarea></c:if>
									</dd>
								</dl>
								<input type="hidden" value="${list.commentStatus}" name="commentStatus" /> 
								<input type="hidden" value="${list.id}"	name="orderGoodsId" /> 
								<div
									style='display: <c:if test="${list.commentStatus==1}">none</c:if>'
									class="toggle_btn">
									<a href="javascript:void(0);" class="yellow-submit" >提交评价</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${list.size()==0}">
					<div class="nolist">无待评价的商品</div>
				</c:if>
			</div>
		</form>
		<input type="hidden" value="${imgBase}"	id="imgBase" />
	</div>
	<!-- end box -->
	<%@ include file="../common/common_js.jsp"%>
	<script src="${jsBase}/common/jquery.raty.js" type="text/javascript"></script>
	<script src="${jsBase}/common/labs.js" type="text/javascript"></script>
	<script src="${jsBase}/comment/comment.js" type="text/javascript"></script>
</body>
</html>