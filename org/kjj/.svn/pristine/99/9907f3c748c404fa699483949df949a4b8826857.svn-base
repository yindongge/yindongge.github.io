<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>
${orgProductItemAll.orgProductItem.goodsName}-快捷健商城
</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="keywords" content='${orgProductItemAll.orgProductItem.goodsName},<c:forEach var="skuSpec" items="${orgProductDetailAll.orgProductItem.orgProductItemLinkSalespecList}"><c:forEach var="allSpec" items="${orgProductDetailAll.orgProductItem.specTypeList}"><c:if test="${skuSpec.specId==allSpec.specId}">${allSpec.specValue},</c:if></c:forEach></c:forEach> 快捷健,快捷健网上商城,连锁便利店,kjj,kjjhome,O2O便利店,网上便利店,掌上便利店,1小时送达,货到付款,当日送达,免费送货上门,CBD便利店,酒水饮料,办公日用,进口食品,糖果零食,个护化妆,日常用品' />
<meta name="description" content='${orgProductItemAll.orgProductItem.goodsName},<c:forEach var="skuSpec" items="${orgProductDetailAll.orgProductItem.orgProductItemLinkSalespecList}"><c:forEach var="allSpec" items="${orgProductDetailAll.orgProductItem.specTypeList}"><c:if test="${skuSpec.specId==allSpec.specId}">${allSpec.specValue},</c:if></c:forEach></c:forEach>高品质O2O便利店，在线下单，全场0元起，免费配送，1小时极速送达，货到付款。kjjhome是快捷健电子商务有限公司打造的线上购物O2O平台' />
<%@include file="../common/common_css.jsp"%>
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
					<form action="${ctx}/search/result" method="post" target="_blank">
					<div class="input-group">
						<input type="text" class="form-control" name="keyword" placeholder="商品名称" /> <i
							class="icon1 glyphicon glyphicon-search"></i> <span
							class="input-group-btn">
							<button class="btn btn-me" type="submit">搜索</button>
						</span>
					</div>
					</form>
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
		<!-- end nav-index -->

		<div class="b">
			<div class="right-extra">
				<!--产品参数开始-->
				<div>
					<div id="preview" class="spec-preview">
						<span class="jqzoom"><img jqimg="${orgProductItemAll.orgProductItem.goodsImg350}" src="${orgProductItemAll.orgProductItem.goodsImg350}" /></span>
					</div>
					<!--缩图开始-->
					<div class="spec-scroll">
						<c:if test="${orgProductDetailAll.orgProductImgList.size()>5}">
							<a class="prev"><span class="glyphicon glyphicon-menu-left"></span></a>
						    <a class="next"><span class="glyphicon glyphicon-menu-right"> </span></a>
						</c:if>
						<div class="items">
							<ul>
								<c:forEach var="itemImg" items="${orgProductDetailAll.orgProductImgList}">
									<c:if test="${itemImg.imgUrl !=''}">
										<li><img alt="#" bimg="${itemImg.imgUrl}" src="${fn:replace(itemImg.imgUrl, '_.', '_350x350.')}" onmousemove="preview(this);"/></li>
									</c:if>
								</c:forEach>
								<%-- 
								<li>
									<button type="button" class="btn btn-warning">收藏</button>
									<button id="shareBtn" type="button" class="btn btn-warning">分享</button>
								</li>
								 --%>
							</ul>
						</div>
					</div>
					<!--缩图结束-->
				</div>
			</div>
			
			<!--商品详情-->
			<div class="goods-detail">
				<div class="detail-center">
					<div class="detail-name">
						<input id="relativeCartId" type="hidden" value="${orgProductItemAll.orgProductItem.catId}"/>
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
									${orgProductItemAll.orgProductItem.goodsSn}</p>
							</div>
						</div>
						<input type="hidden" id="goodsId" value="${orgProductItemAll.orgProductItem.goodsId}"/>
						<input type="hidden" id="goodsSn" value="${orgProductItemAll.orgProductItem.goodsSn}"/>
					</div>
					
					<!-- 价格折扣  -->
					<c:if test="${orgProductItemAll.orgProductItemAide.markLimitTimeDiscount==false}">
						<c:if test="${countDown eq null }">
							<div class="choose-taste choose-special nomargin">
								<div class="dt dt-special">价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格：</div>
								<div class="dd ">
									<span class="money">￥</span><span class="yellow">
										<c:if test="${orgProductItemAll.orgProductItemAide.realPrice eq null}">暂无报价</c:if>
										<c:if test="${orgProductItemAll.orgProductItemAide.realPrice ne null}">
											<fmt:formatNumber type="currency" pattern="0.00" value="${orgProductItemAll.orgProductItemAide.realPrice}"/>
										</c:if>
									</span>
								</div>
							</div>
						</c:if>
						<c:if test="${countDown ne null and LimitTimeGood ne null and LimitTimeGood.price le orgProductItemAll.orgProductItemAide.realPrice}">
							<div class="price pricerevise">
								<div class="choose-taste choose-special nomargin">
									<div class="dt dt-special">价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格 ：</div>
									<div class="dd">
										<p class="p2">
											<span class="money">￥</span>
											<span class="yellow">
												<c:if test="${orgProductItemAll.orgProductItemAide.sourcePrice eq null}">暂无报价</c:if>
												<c:if test="${orgProductItemAll.orgProductItemAide.sourcePrice ne null}">
													<fmt:formatNumber type="currency" pattern="0.00" value="${orgProductItemAll.orgProductItemAide.sourcePrice}"/>
												</c:if>
											</span>
										</p>
									</div>
								</div>
								<div class="choose-taste choose-special nomargin height-control">
									<div class="dt" style="padding-top:3px;">参加促销：</div>
									 <div class="dd">
										<p class="p2 line-through">
											<span class="price1 gray">限时折扣</span>
											<span class="yellow">
												<c:if test="${LimitTimeGood eq null}">暂无报价</c:if>
												<c:if test="${LimitTimeGood ne null}">
													<fmt:formatNumber type="currency" pattern="0.00" value="${LimitTimeGood.price}"/>
												</c:if>
											</span>
											<span class="daoshu"> 活动已结束，下次活动时间： <i id="countDownEnd" class="reddaoshu"></i></span>
											<input id="countDown" type="hidden" value="${countDown}"/>
										</p>
									</div>
								</div>
				 			</div>
						</c:if>
						
						<c:if test="${countDown ne null and LimitTimeGood ne null and LimitTimeGood.price ge orgProductItemAll.orgProductItemAide.realPrice}">
							<div class="price pricerevise">
								<div class="choose-taste choose-special nomargin">
									<div class="dt dt-special">价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格 ：</div>
									<div class="dd">
										<p class="p2">
											<span class="money">￥</span>
											<span class="yellow">
												<c:if test="${orgProductItemAll.orgProductItemAide.realPrice eq null}">暂无报价</c:if>
												<c:if test="${orgProductItemAll.orgProductItemAide.realPrice ne null}">
													<fmt:formatNumber type="currency" pattern="0.00" value="${orgProductItemAll.orgProductItemAide.realPrice}"/>
												</c:if>
											</span>
										</p>
									</div>
								</div>
				 			</div>
						</c:if>
						
					</c:if>
					
					<c:if test="${orgProductItemAll.orgProductItemAide.markLimitTimeDiscount==true}">
						<div class="price pricerevise">
							<div class="choose-taste choose-special nomargin">
								<div class="dt">价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格：</div>
								<div class="dd">
									<p class="price-delete">￥
										<c:if test="${orgProductItemAll.orgProductItemAide.sourcePrice eq null}">暂无报价</c:if>
										<c:if test="${orgProductItemAll.orgProductItemAide.sourcePrice ne null}">
											<fmt:formatNumber type="currency" pattern="0.00" value="${orgProductItemAll.orgProductItemAide.sourcePrice}"/>
										</c:if>
									</p>
								</div>
							</div>
							<div class="choose-taste choose-special nomargin height-control">
								<div class="dt" style="padding-top:3px;">参加促销：</div>
								<div class="dd">
									<p class="p2">
										<span class="price1">${orgProductItemAll.orgLimitTimeGoods.goodsTitle}</span>
										<span class="money">￥</span> <span class="yellow">
											<c:if test="${orgProductItemAll.orgProductItemAide.realPrice eq null}">暂无报价</c:if>
											<c:if test="${orgProductItemAll.orgProductItemAide.realPrice ne null}">
												<fmt:formatNumber type="currency" pattern="0.00" value="${orgProductItemAll.orgProductItemAide.realPrice}"/>
											</c:if>
										</span>
										<span class="daoshu"><i id="limitTimeEnd" class="reddaoshu"></i>后结束，请尽快购买！</span>
										<input id="limitTimeEndiInterval" type="hidden" value="${limitTimeEndiInterval}"/>
									</p>
								</div>
							</div>
						</div>
					</c:if>

					<!-- 其他活动 -->
					<c:if test="${fn:length(orgReachList)>0}">
						<div class="other_event">
							<div class="other_content">
								<div class="ohter_l">
									<span class="other_title">其他活动：</span>
								</div>
								<div class="ohter_r">
									<c:if test="${fn:length(orgReachList)>1}">
										<p>	 以下促销可在购物车任选其一 </p>
									</c:if>
									<c:forEach items="${orgReachList}" var="orgReach">
										<p title="${orgReach.title}"><span class="other_span">满减</span>
											${orgReach.title}
										</p>
									</c:forEach>
								</div>
							</div>
						</div>
					</c:if>
					<!-- 其他活动 -->



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
					
					
					
					<div class="peisong">
						<div class="choose-taste choose-special">
							<div class="dt ">配送范围：</div>
							<div class="dd ">
								<div style="cursor:pointer" class="range">
									<p>
										<strong>详细信息</strong><span class="map"><img src="${imgBase}/map1.jpg"/></span>
									</p>
								</div>
							</div>
						</div>
						<div class="choose-taste choose-special nomargin marginbottom">
							<div class="dt">配送时间：</div>
							<div class="dd ">
								<div class="choose-clock">
									<p>
			 							<c:if test="${kjjuser.orgShop.sendTimeAmStart != null && kjjuser.orgShop.sendTimeAmEnd != null}">
			 								上午<fmt:formatDate value="${kjjuser.orgShop.sendTimeAmStart}" type="time" pattern="HH:mm"/>—<fmt:formatDate value="${kjjuser.orgShop.sendTimeAmEnd}" type="time" pattern="HH:mm"/>
			 							</c:if>
			 							<c:if test="${kjjuser.orgShop.sendTimePmStart != null && kjjuser.orgShop.sendTimePmEnd != null}">
			 								下午<fmt:formatDate value="${kjjuser.orgShop.sendTimePmStart}" type="time" pattern="HH:mm"/>—<fmt:formatDate value="${kjjuser.orgShop.sendTimePmEnd}" type="time" pattern="HH:mm"/>
			 							</c:if>
			 							<c:if test="${kjjuser.orgShop.sendTimeNightStart != null && kjjuser.orgShop.sendTimeNightEnd != null}">
			 								晚上<fmt:formatDate value="${kjjuser.orgShop.sendTimeNightStart}" type="time" pattern="HH:mm"/>—<fmt:formatDate value="${kjjuser.orgShop.sendTimeNightEnd}" type="time" pattern="HH:mm"/>
			 							</c:if>
			 						</p>
									<p>
										<span class="bluespan"><fmt:formatDate value="${kjjuser.orgShop.latestSendTime}" type="time" pattern="HH:mm"/>前完成下单，可预约今天送达</span>
									</p>
								</div>
							</div>
						</div>
					</div>
					
					<!-- 加入购物车 -->
					<div class="choose-group clearfix " style="/*height:72px*/">
						<div class="choose-amount">
							<input type="text" name="amount" value="1" data-old="0"/>
							<a class="reduceme <c:if test="${orgProductItemAll.orgProductItemAide.userBuy == 1}">remove</c:if>" href="javascript:void(0);" name="amountMinus">-</a>
							<a class="addme" href="javascript:void(0);" name="amountPlus">+</a>
							<%-- 
							<c:choose>
								<c:when test="${orgProductItemAll.orgProductItemAide.userBuy > orgProductItemAll.orgProductInventory.shopAmount}">
									<b>您所填写的商品超过库存,剩余${orgProductItemAll.orgProductInventory.shopAmount} 件</b>
								</c:when>
								<c:when test="${orgProductItemAll.orgProductItemAide.userBuy > orgProductItemAll.orgProductItemAide.userBuyMax}">
									<b>您填写的商品数量超过限购数量,限购${orgProductItemAll.orgProductItemAide.userBuyMax} 件</b>
								</c:when>
								<c:when test="${orgProductItemAll.orgProductItem.productIsDelete == 1}"><b>对不起，此商品已移除</b></c:when>
								<c:when test="${orgProductItemAll.orgProductItem.productIsOnSale == 0}"><b>对不起，此商品已下架</b></c:when>
								<c:when test="${orgProductItemAll.orgProductInventory.shopAmount == 0}"><b>对不起，此商品已无货</b></c:when>
								<c:when test="${orgProductItemAll.orgProductItemAide.userBuyMax == 0}"><b>达到上限</b></c:when>
							</c:choose>	
							 --%>											
						</div>
						
						<c:choose>
							<c:when test="${orgProductItemAll.orgProductItemAide.canSale == false}"><div class="choose-add3">无货</div></c:when>
							<c:when test="${orgProductItemAll.orgProductItem.productIsOnSale == 0}"><div class="choose-add3">已下架</div></c:when>
							<c:otherwise><div class="choose-add3">现货</div></c:otherwise>
						</c:choose>
						<div class="btn-1 fl">
							<c:choose>
								<c:when test="${orgProductItemAll.orgProductItemAide.canSale == false}"><div class="btn3">加入购物车</div></c:when>
								<c:otherwise><button id="addCartBtn" type="button" class="btn btn-warning">加入购物车</button></c:otherwise>
							</c:choose>
						</div>
					</div>
					<%-- 
					<div class="bdsharebuttonbox" >
					   <a href="#" class="bds_more" data-cmd="more"></a>
					   <a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
					   <a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
					   <a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a>
					   <a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a>
					   <a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
					 </div> 
					  --%>
				</div>
				
				<div class="detail-right">
					<div class="carousel-modal">
						<div class="contact-btn">
							<a href="javascript:void(0)" target="_blank" class="btn2" id="consultBtn">在线客服</a>
							<a href="${ctx}/consultation/addView" target="_blank" class="btn3">留言咨询</a>
							<p class="yellow">
								<span class="reverse2">客服热线：</span>4000-306-603
							</p>
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
						<div class="newtime-add">
							<p>营业时间： <c:if test="${kjjuser.orgShop.openDay==0}">节假日不休</c:if><c:if test="${kjjuser.orgShop.openDay==1}">周一至周五</c:if>
							<fmt:formatDate value="${kjjuser.orgShop.openTimeStart}" type="time" pattern="HH:mm"/>—<fmt:formatDate value="${kjjuser.orgShop.openTimeEnd}" type="time" pattern="HH:mm"/></p>
							<p>店内电话：${kjjuser.orgShop.firstPhoneAreaCode}-${kjjuser.orgShop.firstPhoneNo}</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- end gooddetail -->
<!-- 		<div class="taball clearfix"> -->
<!-- 			<div class="container"> -->
<!-- 				<div class="tab-list"> -->
<!-- 					<ul class="but"> -->
<!-- 						<li>组合套餐</li> -->
<!-- 						<li>满即送</li> -->
<!-- 					</ul> -->
<!-- 					<div class="tab-content"> -->
<!-- 						<div class="slect" style="display:block;"> -->
<!-- 							<div id="slideBox" class="slideBox"> -->
<!-- 								<div class="hd"> -->
									<!-- <ul><li>1</li><li>2</li><li>3</li></ul> -->
<!-- 								</div> -->
<!-- 								<div class="bd">aaa</div> -->
								<!-- 下面是前/后按钮代码，如果不需要删除即可 -->
<!-- 								<a class="prev" href="javascript:void(0)" role="button"><span -->
<!-- 									class="glyphicon glyphicon-menu-up"></span></a> <a class="next" -->
<!-- 									href="javascript:void(0)"><span -->
<!-- 									class="glyphicon glyphicon-menu-down"></span></a> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 						<div class="slect">b</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
		<!-- end  taball -->
		<div class="box clearfix">
			<div class="container">
				<div class="box-left">
					<!-- 相关商品 -->
					<%@include file="../common/common_relativeItems.jsp" %>
					<!-- 浏览过的商品 -->
					<%@include file="../common/common_recentItems.jsp" %>
				</div>
				<div class="box-right">
					<div class="slideTxtBox">
						<div class="hd" id="fixedtop">
							<ul>
								<li id="itemDetail">商品详情</li>
								<li id="itemComment">商品评论<span style="color:blue">(<c:if test="${orgGoodsCommentPage.totalElements eq null}">0</c:if><c:if test="${orgGoodsCommentPage.totalElements ne null}">${orgGoodsCommentPage.totalElements}</c:if>)</span></li>
								<li id="itemConsult">商品咨询</li>
							</ul>
						</div>
						<div class="bd">
							<div class="bd-1">
								<div id="anchorDetail" class="bd-element">
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
							<div class="bd-2">快捷健上的所有商品信息、客户评价、商品咨询、网友讨论等内容，是快捷健重要的经营资源，未经许可，禁止非法转载使用。</div>
							<div class="bd-3">
								<p>温馨提示:因厂家更改产品包装、产地或者更换随机附件等没有任何提前通知，且每位咨询者购买情况、提问时间等不同，为此以下回复仅对提问者3天内有效，其他网友
									仅供参考！若由此给您带来不便请多多谅解！</p>
							</div>
						</div>
					</div>

					<div class="bd-list conment" id="itemDetailInfo">
						${orgProductDetailAll.orgProductItem.goodsDesc}
						<img src="${imgBase}/gongyong.png" class="imggongyong"/>
					</div>
					<div  class="bd-list conment" id="itemCommentInfo">
						<h4>商品评价</h4>
						<input type="hidden" value="${imgBase}"	id="imgBase" />
						<div class="ct-content">
							<c:if test="${orgGoodsCommentPage==null||orgGoodsCommentPage.totalElements==0}">
								<div class="no-content">
									<span>还没有评论内容哦！</span>
								</div>
							</c:if>	
							<c:if test="${orgGoodsCommentPage.totalElements!=0}">
								<div class=" level-star">
									<div class="level-left">商品满意度评分：</div>
									<%-- (5-x)*84+24     444-84x  --%>
									<div class="level-right">
										<span class="l l1">非常不满</span>
										<span class="l l2">不满意</span>
 										<span class="l l3">一般</span>
										<span class="l l4">满意</span>
										<span class="l l5">非常满意</span>
										<span class="l6" id="satisifyLevel">
											<i><fmt:formatNumber value="${averageStarScore}" pattern="#.0"/></i>
										</span>
									</div>
								</div>
								<div class="have-content">
									<ul class="ct-listall">
										<c:forEach var="comment" items="${orgGoodsCommentPage.content}">
											<li>
												<div class="ct-left">
													<div class="ct-left-ask">${comment.goodsComment}</div>
													<c:if test="${comment.replyStatus==1}">
														<div class="ct-left-answer">
															<span>解释：</span>${comment.reply}
														</div>
													</c:if>
												</div>
												<div class="ct-center">
													<div class="toggle-right">
														<div class="raty star control"  data-score='<c:if test="${comment.starScore!=null}">${comment.starScore}</c:if>'></div>
													</div>
												</div>
												<div class="name-level">
													${comment.userName} <br/>[<fmt:formatDate type="date" value="${comment.createTime}" />]
												</div>
											</li>
										</c:forEach>	
									</ul>
								</div>
							</c:if>
							<c:if test="${orgGoodsCommentPage.totalElements!=0}">
								<div class="panel-footer">
									<div class="to-page">
										 	<p>到第<input id="changePage" type="text"/>页</p>
											<button id="changePageBtn" type="button" class="btn btn-warning btn-sm">确定</button> 
									 </div>
									 <ul class="pagination page-control">
									 <%-- 
								    	<li>
									      <a name="preBtn" class='<c:if test="${orgGoodsCommentPage.number==1}">disabled</c:if>'> 上一页 </a>
									    </li>
									 --%>
											    <c:forEach var="i" begin="${orgGoodsCommentPage.number-3>1 ? orgGoodsCommentPage.number-3 : 1}" end="${orgGoodsCommentPage.number+3<orgGoodsCommentPage.totalPages ? orgGoodsCommentPage.number+3 : orgGoodsCommentPage.totalPages }">
											  	  <li><a name="pageNumber" class='<c:if test="${i-1==orgGoodsCommentPage.number}">page-click</c:if>'>${i}</a></li>
											    </c:forEach>
											<li>
										       <a name="nextBtn" <c:if test="${orgGoodsCommentPage.number==orgGoodsCommentPage.totalPages-1}">style="display:none"</c:if>>下一页 </a>
									    	</li>
									 </ul>
									 <input id="totalPages" type="hidden" value="${orgGoodsCommentPage.totalPages}"/>
								</div>
							</c:if>					
						</div>
					</div>
					
					
					<div id="anchorConsult" class="bd-list answer">
						<h4>
							商品咨询<a class="moreanswer" href="${ctx}/consultation/itemList?goodsId=${orgProductItemAll.orgProductItem.goodsId}#ca">发表咨询</a>
						</h4>
						<div class="a-content">
							<c:if test="${orgConsultProblemPage==null || orgConsultProblemPage.totalElements==0}">
								<div class="no-content">
									<span>还没有咨询内容哦！</span>
								</div>
							</c:if>
							<c:if test="${orgConsultProblemPage!=null && orgConsultProblemPage.totalElements!=0}">
								<div class="have-content">
									<c:forEach var="problem" items="${orgConsultProblemPage.content}">
										<c:if test="${problem!=null}">
											<div class="a-list">
												<div class="user">
													<span class="a-name">网友：${problem.createUserName}</span>
													<span class="a-time"><fmt:formatDate value="${problem.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></span>
												</div>
												<dl class="ask">
													<dt>咨询内容：</dt>
													<dd>${problem.consultProblem}</dd>
												</dl>
												<dl class="answer">
												<c:forEach var="answer" items="${problem.listOrgConsultAnswer}">
													<c:if test="${answer!=null}">
														<dt>阿健回复：</dt>
														<dd>
															<div class="a-text">
																${answer.consultAnswer}
															</div>
														</dd>
													</c:if>
												</c:forEach>
												</dl>
											</div>
										</c:if>
									</c:forEach>
								</div>
							</c:if>
						</div>
						<div class="content-tips">
							<div class="tips-left">
								购买之前，如有问题，请<a href="${ctx}/consultation/itemList?goodsId=${orgProductItemAll.orgProductItem.goodsId}#ca">[发表咨询]</a>
							</div>
							<c:if test="${orgConsultProblemPage!=null && orgConsultProblemPage.totalElements!=0}">
								<div class="tips-right">
									共${orgConsultProblemPage.totalElements}条 <a href="${ctx}/consultation/itemList?goodsId=${orgProductItemAll.orgProductItem.goodsId}">浏览所有咨询信息&gt;&gt;</a>
								</div>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="scrollEnd"></div>
	<!-- 可能喜欢 -->
	<%@include file="../common/common_mayLikeItems.jsp" %>
	
<%@include file="../common/common_foot.jsp" %>
<%@include file="../common/common_js.jsp"%>
<%@include file="../common/common_sidebar.jsp" %>
<script src="${jsBase}/common/jquery.raty.js" type="text/javascript"></script>
<script src="${jsBase}/common/labs.js" type="text/javascript"></script>
<script type="text/javascript">
	var pageInfo=${orgProductDetailAll.itemJson};
</script>
<script type="text/javascript" src="http://wpa.b.qq.com/cgi/wpa.php"></script>
<script src="${jsBase}/item/detail.js" type="text/javascript"></script>

<script type="text/javascript">jQuery(".slideBox").slide({mainCell:".bd ul",effect:"top",trigger:"click",pnLoop:false});</script>
<script type="text/javascript">jQuery(".slideTxtBox").slide({trigger:"click"});</script>

</body>
</html>