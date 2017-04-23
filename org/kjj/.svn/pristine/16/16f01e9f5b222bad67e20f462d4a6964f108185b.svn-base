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
<link href="${cssBase}/jquery.raty.css" type="text/css" rel="stylesheet" />
<link href="${cssBase}/labs.css" type="text/css" rel="stylesheet" />
<title>${orgProductItem.goodsName}-快捷健商城</title>
</head>
<body>
<!-- 开始评论 -->
	<div class="box box-gray">
		<header class="header">
			<div class="head-content">商品介绍</div>
			<div class="head-left"><a href="javascript:history.go(-1)" class="link"></a></div>
		</header>
		<div class="goodsintroduce">
			<div class="area third">
				<a href="${ctx}/item/introduce/${query.goodsId}" class='a'>商品详情<span class="linebottom"></span></a>
				<a href="javascript:void(0);" class='a on'>商品评价<span class="linebottom"></span></a>
				<a href="${ctx}/item/consult/${query.goodsId}" class='a'>商品咨询<span class="linebottom"></span></a>
			</div>
		</div>	
		<div class="assess" style="padding: 0px">
			<c:set value="0" var="sum" />
			<c:forEach var="commentScore" items="${orgGoodsCommentList}" varStatus="status">
		        <c:set value="${sum + commentScore.starScore}" var="sum" />
			</c:forEach>
			<c:if test="${orgGoodsCommentList.size()!=0}">
				<h5>有<span class="red">${orgGoodsCommentList.size()}</span>条评论</h5>
				<div class="linestar">
					<div class="item-detail no-border">
						<dt>满意度: </dt><dd class="level"></dd>
					</div>
					<a class="guide"><fmt:formatNumber value="${sum/(fn:length(orgGoodsCommentList))}" pattern="#.0"/></a> 
					
				</div>
				<input type="hidden" value="${imgBase}"	id="imgBase" />
				<c:forEach var="comment" items="${orgGoodsCommentList}">
					<div class="assess-list">
						<div class="name">
							<div class="myname">${comment.userName} </div>
							<div class="raty star control"  data-score='<c:if test="${comment.starScore!=null}">${comment.starScore}</c:if>'></div>
							<span><fmt:formatDate value="${comment.createTime}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></span>
						</div>
						<p>${comment.goodsComment} </p>
						<c:if test="${comment.replyStatus==1}">
							<p class="blue">阿健回复：${comment.reply} </p>
						</c:if>
						<p class="leibie">
							<c:forEach var="itemspec" items="${orgProductLinkItemSalespecList}">
								<span>${itemspec.specName}： ${itemspec.specValue}</span>
							</c:forEach>
						</p>
					</div>
				</c:forEach>
			</c:if>
			<c:if test="${orgGoodsCommentList.size()==0}">
				<div class="nolist" style="margin-bottom: 0px">暂无商品评价(ㄒoㄒ)</div>
			</c:if>
		</div>
	</div>
	<footer class="footer">
		<p>客户服务热线：4000-306-603</p>
		<p>KJJHOME.COM 快捷健商城</p>
	</footer>
	
<%@ include file="../common/common_js.jsp"%>
<script src="${jsBase}/common/jquery.raty.js" type="text/javascript"></script>
<script src="${jsBase}/common/labs.js" type="text/javascript"></script>
<script src="${jsBase}/item/comment.js" type="text/javascript" ></script>
</body>
</html>