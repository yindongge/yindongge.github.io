<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>
	<c:if test="${query.keyword ne null && query.keyword ne ''}">${query.keyword}--商品搜索</c:if>
	<c:if test="${query.keyword eq null || query.keyword eq '' }">快捷健商城</c:if>
</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="keywords"
	content="${query.keyword},快捷健,快捷健网上商城,连锁便利店,kjj,kjjhome,O2O便利店,网上便利店,掌上便利店,1小时送达,货到付款,当日送达,免费送货上门,CBD便利店,酒水饮料,办公日用,进口食品,糖果零食,个护化妆,日常用品" />
<meta name="description"
	content="高品质O2O便利店，在线下单，全场0元起，免费配送，1小时极速送达，货到付款。kjjhome是快捷健电子商务有限公司打造的线上购物O2O平台" />
<%@include file="../common/common_css.jsp"%>
</head>
<body>
<div class="all">
		<%@  include file="../common/common_head.jsp" %>
		<!-- end top -->
		<div class="header">
			<div class="container">
				<div class="logo fl">
					<a href="${ctx}"><img src="${imgBase}/logo.jpg" /></a>
					<%@include file="../common/common_shop.jsp" %>
				</div>
				<div class="search fl">
					<div class="input-group">
						<input name="keyword" value="${query.keyword}"
							type="text" class="form-control" placeholder="搜索商品" />
							 <i class="icon1 glyphicon glyphicon-search"></i>
							  <span class="input-group-btn">
							<button id="searchBtn" class="btn btn-me" type="button">搜索</button>
						</span>
					</div>
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
										<a
											href="${ctx}/search/result?catId=${classLevelOne.classId}"
											class="special">${classLevelOne.className}</a>
										<c:forEach items="${classLevelOne.childrenList}" var="classLevelTwo">
											<c:if test="${classLevelTwo.classShowmenu == 1}">
												<a
													href="${ctx}/search/result?catId=${classLevelTwo.classId}">${classLevelTwo.className}</a>
											</c:if>
										</c:forEach>
										<span class="glyphicon glyphicon-menu-right pull-right"></span>
										<!-- <b></b> -->
									</h3>
									<div class="item-list clearfix">
										<div class="subitem">
											<dl class="fore1">
												<dd>
													<c:forEach items="${classLevelOne.childrenList}"
														var="classLevelTwo">
														<a
															href="${ctx}/search/result?catId=${classLevelTwo.classId}">${classLevelTwo.className}</a>
													</c:forEach>
												</dd>
											</dl>
											<div class="line2 l1">
												<img src="${imgBase}/classImg${classLevelOne.classId}.jpg" />
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
		<!-- 热卖推荐 -->
		<%@include file="../common/common_popularItems.jsp" %>


		<!-- end  taball -->
		<div class="box clearfix">
			<div class="container">
			<c:if test="${orgClass.classLevel==1}">
				<h2><strong>${orgClass.className}</strong></h2>
			</c:if>
			<c:if test="${orgClass.classLevel==2}">
				<h2><strong>${classParent.className}</strong> <span class="small"><span class="glyphicon glyphicon-menu-right"></span>${orgClass.className}</span></h2>
			</c:if>
				<div class="box-left">
					<!-- 相关商品 -->
					<%@include file="../common/common_relativeItems.jsp" %>
					<!-- 浏览过的商品 -->
					<%@include file="../common/common_recentItems.jsp" %>

				</div>
				<div class="box-right">
			<form id="pageform" action="result" method="get">
			<input name="keyword" value="${query.keyword}" type="hidden" />
				<!-- shaixuan -->
				<div class="panel panel-default">
					<c:if test="${orgClass.classLevel==1}">
						<div class="panel-heading ph2">
							<span class="span-title">分类：</span>
							<c:forEach items="${listClass}" var="classLevelOne" varStatus="status">
								<c:if test="${classLevelOne.classId==orgClass.classId}">
									<button type="button" onclick="window.location.href='${ctx}/search/result?catId=${classLevelOne.childrenList[0].classId}'">${classLevelOne.childrenList[0].className}</button>
								</c:if>
							</c:forEach>
							<div  class="morea ">更多<i class="glyphicon glyphicon-menu-down"></i>
							<div class="morea-toggle">
								<span class="zhexia"></span>
								<c:forEach items="${listClass}" var="classLevelOne" varStatus="status">
									<c:if test="${classLevelOne.classId==orgClass.classId}">
										<c:forEach var="classLevelTwo" items="${classLevelOne.childrenList}">
											<a href="${ctx}/search/result?catId=${classLevelTwo.classId}">${classLevelTwo.className}</a>
										</c:forEach>
									</c:if>
								</c:forEach>
							</div>
							</div>
							<div class="pull-right">
								<span class="yellow">${orgClass.className}</span>
								<span>商品筛选</span>
								<span>共${page.totalElements}个商品</span>
							</div>
						</div>
					</c:if>
					<c:if test="${orgClass.classLevel==2}">
						<div class="panel-heading ph1">
							<span class="yellow">${orgClass.className}</span>
							<span>商品筛选</span>
							<span>共${page.totalElements}个商品</span>
						</div>
					</c:if>
					<div class="panel-heading ph4" style="display:none" >
						<div class="fl">已选条件：</div>
						<div class="value">
							<ul> </ul>
						</div>
						<div class="back-me">
							<a href="javascript:void(0);">全部撤销</a>
						</div>
					</div>
					<div class="panel-body  ">
						<c:if test="${orgBrandList ne null && orgBrandList.size()!=0}">
							<div name="brandList" class="s-list s-ul-height">
								<div class="s-key">
									<span data-key-id="brand">品牌:</span>
								</div>
								<div class="s-value">
									<div class="s-listall">
										<ul class="s-ul ">
											<c:forEach items="${orgBrandList}" var="brand" >
												<li><a href="JavaScript:void(0);" data-value-id="${brand.productBrandId}">${brand.productBrandName}</a></li>
											</c:forEach>
										</ul>
										<div class="clear-list" style="display:none;">清空</div>
										<div class="btns" style="display:none;">
											<button type="button" class="btn1 disabled ">确定</button>
											<button type="button" class="btn2">取消</button>
										</div>
									</div>
								</div>
								<div class="s-ext">
									<a class="s-more">更多 
										<span class="glyphicon glyphicon-menu-down"></span>
										<i class="glyphicon glyphicon-menu-up"></i>
									 </a>
									<a class="s-more1">多选</a>
								</div>
							</div>
						</c:if>	
						
						<c:if test="${propertyList ne null && propertyList.size()!=0}">
							<c:forEach items="${propertyList}" var="property" >
								<div name="propList" class="s-list ">
									<div class="s-key">
										<c:forEach items="${property.key}" var="PropKey" >
											<span data-key-id="${PropKey.propertyId}">${PropKey.propertyName}:</span>
										</c:forEach>
									</div>
									<div class="s-value">
										<div class="s-listall">
											<ul class="s-ul ">
												<c:forEach items="${property.value}" var="Propvalue" >
													<li><a href="JavaScript:void(0);" data-value-id="${Propvalue.propertyValueId}">${Propvalue.propertyValue}</a></li>
												</c:forEach>
											</ul>
											<div class="clear-list" style="display:none;">清空</div>
											<div class="btns" style="display:none;">
												<button type="button" class="btn1 disabled ">确定</button>
												<button type="button" class="btn2">取消</button>
											</div>
										</div>
									</div>
									<div class="s-ext">
										<a class="s-more">更多 
											<span class="glyphicon glyphicon-menu-down"></span>
											<i class="glyphicon glyphicon-menu-up"></i>
										 </a>
										<a class="s-more1">多选</a>
									</div>
								</div>
							</c:forEach>
						</c:if>	
					</div>
				</div>
<!-- 				************** -->
						<input type="hidden" name="catId" value="${query.catId}" />
						<c:if test="${page.totalElements==0}">
							<div class="sorry">
								<h2>
									<span></span>抱歉,没有找到符合条件的商品！
								</h2>
								<h5>建议您：</h5>
								<p>1.适当减少筛选条件,可以获得更多结果</p>
								<p>2.调整价格区间</p>
								<P>3.尝试其他关键字</P>
							</div>
						</c:if>
						<c:if test="${page.totalElements!=0}">
							<div class="future c2">
								<div class="panel panel-default">
									<div class="panel-heading ph3">
										<div class="fl">
											<button type="button" data-type="2" class="btn btn-2 upme downme">销量 <b class='b2'></b></button>
											<button type="button" data-type="3" class="btn btn-2 upme downme">价格 <b class='b2'></b></button>
											<button type="button" data-type="4" class="btn btn-2 upme downme">评论 <b class='b2'></b></button>
											<button type="button" data-type="5" class="btn btn-2 upme downme">上架时间 <b class='b2'></b></button>
										</div>
										<input  type="hidden" value="${query.orderType}" name="orderType"/>
										<input  type="hidden" value="${query.orderDirection}" name="orderDirection"/>
										<div class=" price-search">
											<span>价格区间</span><input name="minPrice" value="${query.minPrice}" placeholder="0.0" type="text" /> - <input name="maxPrice" value="${query.maxPrice}" placeholder="0.0"  type="text" />
											<button type="button" >确定</button>
										</div>
									</div>
									<div class="panel-body">
										<input id="relativeCartId" type="hidden" value='<c:if test="${param.catId eq null || param.catId eq ''}">${page.content[0].orgProductItem.catId}</c:if>
										<c:if test="${param.catId ne null}">${param.catId}</c:if>'/>
										<ul class="list-f">
											<c:forEach var="item" items="${page.content}">
												<li>
													<div class="f-img">
														<input type="hidden"  value="${item.orgProductItem.goodsId}"/>
														<a href="javascript:void(0);"><img
															src="${item.orgProductItem.goodsImg180}" /></a>
													</div>
													<div class="f-name">
														<p>${item.orgProductItem.goodsName}</p>
													</div>
													<div class="f-price">
														<p>
															<span class="yellow">￥
																<c:if test="${item.orgProductItemAide.realPrice eq null}">暂无报价</c:if>
																<c:if test="${item.orgProductItemAide.realPrice ne null}">${item.orgProductItemAide.realPrice}</c:if>
															 </span>
															<span class="price1"> <c:if
																	test="${item.orgProductItemAide.markLimitTimeDiscount}">
																	<a class="a-zhekou">${item.orgLimitTimeGoods.goodsTitle}</a>
																</c:if>
															</span> <span class="f-price-right"> <c:choose>
																	<c:when
																		test="${item.orgProductItemAide.canSale == false}">无货</c:when>
																	<c:otherwise>现货</c:otherwise>
																</c:choose>
															</span>
														</p>
													</div>
													<div class="f-buy">
														<span class="buy-conment">已经有<span class="blue">
															<c:if test="${item.orgProductItem.commentNum eq null}">0</c:if>
															<c:if test="${item.orgProductItem.commentNum ne null}">${item.orgProductItem.commentNum}</c:if>
														人</span>评论
														</span>
														<c:if test="${item.orgProductItemAide.canSale}">
															<span class="buy-go"
																onclick="addCart(${item.orgProductItem.goodsId},'${item.orgProductItem.goodsSn}')"><b></b>加入购物车</span>
														</c:if>
														<c:if test="${!item.orgProductItemAide.canSale}">
															<span class="buy-go" style="background:gray"><b></b>加入购物车</span>
														</c:if>

													</div>
												</li>
											</c:forEach>
										</ul>
									</div>
									<div class="mg-footer">
										<div class="to-page">
											<p>到第<input type="text" id="textNumber" value="${page.number+1}" />页</p>
											<input type="hidden" id="pageNumber" name="pageNumber" data-total-pages="${page.totalPages}"/>
											<button type="button" class="btn btn-warning btn-sm" onclick="jumpPage();">确定</button>
										</div>
									
										<ul class="pagination page-control">
											<c:if test="${page.number ne 0}">
												<li><a href="javascript:void(0);" onclick="return pageNow('${page.number}')">上一页 </a></li>
											</c:if>
									
											<c:forEach var="key" begin="${page.number+1 - (11 - (page.totalPages - page.number) > 5 ? 11 - (page.totalPages - page.number) : 5) > 1 ? page.number+1 - (11 - (page.totalPages - page.number) > 5 ? 11 - (page.totalPages - page.number) : 5) : 1}"
												end="${(10 - page.number > 5 ? 10 - page.number : 5) + page.number+1 < page.totalPages ? (10 - page.number > 5 ? 10 - page.number : 5) + page.number+1 : page.totalPages}">
												<c:if test="${page.number==key-1}">
													<li><a class="page-click" href="javascript:void(0)">${key}</a></li>
												</c:if>
												<c:if test="${page.number!=key-1}">
													<li><a href="javascript:void(0);" onclick="pageNow('${key}')">${key}</a></li>
												</c:if>
											</c:forEach>
									
											<c:if test="${page.number ne page.totalPages-1}">
												<li><a aria-label="Next" href="javascript:void(0);" onclick="pageNow('${page.number+2}')">下一页 </a></li>
											</c:if>
										</ul>
										<p>共有${page.totalElements}条记录 每页${page.size}条</p>
									</div>
								</div>	
							</div>	
						 </c:if>
					 </form>
				 </div>
			</div>
		</div>
		<!-- 可能喜欢 -->
		<%@include file="../common/common_mayLikeItems.jsp" %>
	
</div>
<%@include file="../common/common_foot.jsp" %>
<%@include file="../common/common_js.jsp"%>
<%@include file="../common/common_sidebar.jsp" %>
<script src="${jsBase}/common/jquery.raty.js" type="text/javascript"></script>
<script src="${jsBase}/common/labs.js" type="text/javascript"></script>
<script src="${jsBase}/search/result.js" type="text/javascript"></script>
</body>
</html>
