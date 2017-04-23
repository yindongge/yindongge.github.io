<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="../common/common_meta.jsp" %>
<%@include file="../common/common_css.jsp" %>
<title>快捷健商城</title>
</head>
<body>
<div class=" box">
	<div class="box-content">
		<%@include file="../common/common_head.jsp" %>
	</div>
	<div class="future">
		<div class="future-left fl">
			<jsp:include page="../common/common_sidebar.jsp">
				<jsp:param name="active" value="精品购物"/>
			</jsp:include>
		</div>
		<div class="future-right fr" style="overflow-y:auto">
			<div class="b">
				<div class="right-extra" >
				  <div>
				    <div id="preview" class="spec-preview">
				    <span class="jqzoom"><img jqimg="${orgProductItemAll.orgProductItem.goodsImg350}" src="${orgProductItemAll.orgProductItem.goodsImg350}"  /></span> </div>
				    <!--缩图开始-->
				    <div class="spec-scroll">
				      <div class="items">
				        <ul>
				          <c:forEach var="itemImg" items="${orgProductDetailAll.orgProductImgList}">
								<c:if test="${itemImg.imgUrl !=''}">
									<li><img alt="#" bimg="${itemImg.imgUrl}" src="${fn:replace(itemImg.imgUrl, '_.', '_350x350.')}" onmousemove="preview(this);"/></li>
								</c:if>
							</c:forEach>
				        </ul>
				      </div>
				    </div>
				    <!--缩图结束-->
				  </div>
				</div>
				 <div class="goods-detail">
			 		<div class="detail-center">
			 			<div class="detail-name">
				 			<h2>${orgProductItemAll.orgProductItem.goodsName}</h2>
				 			<h4>
					 			${orgProductItemAll.orgProductItem.goodsBrief}
								<span class="addredtitle">
				 					<c:if test="${orgProductItemAll.orgProductItemAide.markLimitTimeDiscount}">
										<c:if test="${!empty orgProductItemAll.orgLimitTimeGoods.shopNum}">
											每店限量${orgProductItemAll.orgLimitTimeGoods.shopNum}件
										</c:if>
										<c:if test="${!empty orgProductItemAll.orgLimitTimeGoods.userNum}">
											每用户限购${orgProductItemAll.orgLimitTimeGoods.userNum}件
										</c:if>
										<c:if test="${orgProductItemAll.orgLimitTimeGoods.orgLimitTimeDiscount.checkPhone == 1}">
											绑定手机号才能参加哦
										</c:if>
									</c:if>
								</span>
							</h4>
				 			<div class="choose-taste choose-special nomargin">
			 					<div class="dt">商品编号：</div>
			 					<div class="dd ">
				 					<p class="detail-number">
				 						${orgProductItemAll.orgProductItem.goodsSn}
				 					</p>
			 					</div>
			 				</div>
			 				<input type="hidden" id="goodsId" value="${orgProductItemAll.orgProductItem.goodsId}"/>
							<input type="hidden" id="goodsSn" value="${orgProductItemAll.orgProductItem.goodsSn}"/>
			 			</div>
			 			<!-- end  -->
			 				<div class="choose-taste choose-special nomargin">
			 					<div class="dt dt-special">价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格：</div>
			 					<div class="dd ">
				 					<span class="money">￥</span>
									<span class="yellow">
										<c:if test="${orgProductItemAll.orgProductItemAide.realPrice eq null}">暂无报价</c:if>
										<c:if test="${orgProductItemAll.orgProductItemAide.realPrice ne null}">
											<fmt:formatNumber type="currency" pattern="0.00" value="${orgProductItemAll.orgProductItemAide.realPrice}"/>
										</c:if>
									</span>
			 					</div>
			 				</div>
			 			<!-- 商品规格 -->
			 			<div class="choose">
			 				<c:forEach var="skuSpec" items="${orgProductDetailAll.orgProductItem.orgProductItemLinkSalespecList}">
								<div class="choose-taste">
									<div class="dt small-font">${skuSpec.specName}：</div>
									<div class="dd">
										<div class="ch" >
											<c:forEach var="allSpec" items="${orgProductDetailAll.orgProductItem.specTypeList}">
												<c:if test="${skuSpec.specId==allSpec.specId}">
													<a href="javascript:Void(0);" title="${allSpec.specValue}"
														class="<c:if test="${skuSpec.specTypeId==allSpec.specTypeId}"> active </c:if> ">
														<span>${allSpec.specValue}</span>
													</a>
													<input type="hidden" value='${allSpec.unionId}' />
												</c:if>
											</c:forEach>
										</div>
									</div>
								</div>
							</c:forEach>
			 			</div>
			 			<div class="add-btn">
			 				<div class="add_erweima">
			 					<img src='${ctx}/item/code/${orgProductItemAll.orgProductItem.goodsId}'/>
			 				</div>
			 				<a href="#" class="erweima_text">扫码可立即购买</a>
			 				<c:if test="${flag == 0}">
			 				<a href="javascript:history.go(-1);" class="add-abtn btn-back">返回</a>
			 				</c:if>
			 				<c:if test="${flag == 1}">
			 				<a href="javascript:void(0)" onclick="window.close();" class="add-abtn btn-back">返回</a>
			 				</c:if>
			 			</div>
			 		</div>
			 </div>
			 </div>
			 <!-- end gooddetail  b-->
			 <div class=" clearfix detail_add" >
				<div class="box-right">
				 	<div class="slideTxtBox">
						<div class="hd" id="fixedtop">
							<ul><li class="on">商品详情</li></ul>
						</div>
						<div class="bd">
							<div class="bd-1">
								<div class="bd-element">
									<h5>商品参数</h5>
									<ul>
										<c:if test="${orgProductDetailAll.orgProductLinkPropertyList.size()!=0}">
											<c:forEach var="property" items="${orgProductDetailAll.orgProductLinkPropertyList}" >
												<li>${property.propertyName}：<span>${property.propertyValue}</span></li>
											</c:forEach>
										</c:if>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			 </div>
			 <div class="show-img-box">
				${orgProductDetailAll.orgProductItem.goodsDesc}
				<img src="${imgBase}/gongyong.png" class="imggongyong"/>
			 </div>
		</div>
	</div>
	<!-- 结束列表 -->
</div>

<%@include file="../common/common_js.jsp"%>
<script type="text/javascript">
	var pageInfo=${orgProductDetailAll.itemJson};
</script>

</body>
</html>
