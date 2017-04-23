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
<title>${orgProductDetailAll.orgProductItem.goodsName}-快捷健商城</title>
</head>
<body>
	<div class="box box-gray">
		<header class="header">
			<div class="head-content">商品介绍</div>
			<div class="head-left"><a href="javascript:history.go(-1)" class="link"></a></div>
		</header>
			<!-- end top -->
		<div class="goodsintroduce">
			<div class="area third">
				<a href="javascript:void(0);" class='a on'>商品详情<span class="linebottom"></span></a>
				<a href="${ctx}/item/comment/${orgProductDetailAll.orgProductItem.goodsId}" class='a'>商品评价<span class="linebottom"></span></a>
				<a href="${ctx}/item/consult/${orgProductDetailAll.orgProductItem.goodsId}" class='a'>商品咨询<span class="linebottom"></span></a>
			</div>
			<c:if test="${orgProductDetailAll.orgProductLinkPropertyList.size()==0}">
				<div class="nolist">暂无商品参数信息</div>
			</c:if>
			<c:if test="${orgProductDetailAll.orgProductLinkPropertyList.size()!=0}">
				<div class="list-detail">
					<h5 class="line-h5"><span class="line3"></span>商品参数<span class="line4"></span></h5>
					<table class="table " border="0" cellspacing="1">
						<tbody>
							<c:forEach var="property" items="${orgProductDetailAll.orgProductLinkPropertyList}" >
								<tr>
									<td class="t-left"> ${property.propertyName}</td>
									<td class="t-right">${property.propertyValue}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>	
			</c:if>
			<div class="list-detail">
			<c:set var="item" value="${orgProductDetailAll.orgProductItem}"></c:set>
				<c:choose>
					<c:when test="${not empty item.mobileGoodsDesc }">
						${item.mobileGoodsDesc}
					</c:when>
					<c:when test="${empty item.mobileGoodsDesc  && not empty item.goodsDesc }">
						${item.goodsDesc}
					</c:when>
					<c:otherwise>
						<c:forEach var="itemImg" items="${orgProductDetailAll.orgProductImgList}">
		 					<a href="#" class="thumbnail"><img src="${itemImg.imgUrl}" alt=""></a> 
						</c:forEach> 
					</c:otherwise>
				</c:choose>
			</div>	
		</div>
	</div>
	<footer class="footer">
		<p>客户服务热线：4000-306-603</p>
		<p>KJJHOME.COM 快捷健商城</p>
	</footer>
<%@ include file="../common/common_js.jsp"%>
</body>
</html>