<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>快捷健--高品质O2O便利店,1小时配送,免费配送，健康生活倡导者</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="keywords"
	content="快捷健,快捷健网上商城,连锁便利店,kjj,kjjhome,O2O便利店,网上便利店,掌上便利店,1小时送达,货到付款,当日送达,免费送货上门,CBD便利店,酒水饮料,办公日用,进口食品,糖果零食,个护化妆,日常用品" />
<meta name="description"
	content="高品质O2O便利店，在线下单，全场0元起，免费配送，1小时极速送达，货到付款。kjjhome是快捷健电子商务有限公司打造的线上购物O2O平台" />
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
	 <!-- end  taball -->
	 <div class="box clearfix margin-top">
		 <div class="container">
		 		<div class="box-left">
		 			<div class="box-left1">
		 				<h5>商品信息</h5>
		 				<ul class="left-list">
		 					<li>
			 					<a href="${ctx}/item/${orgProductItemAll.orgProductItem.goodsId}">
			 						<img src="${orgProductItemAll.orgProductItem.goodsImg350}"/>
			 					</a>
			 					<div class="list-content">
			 						<p class="left-title">${orgProductItemAll.orgProductItem.goodsName}</p>
			 						<p class="yellow" >￥<fmt:formatNumber type="currency" pattern="0.00" value="${orgProductItemAll.orgProductItemAide.realPrice}"/></p>
			 					</div>
		 					</li>
		 				</ul>
		 			</div>
		 		</div>
		 	 <form id="pageform" action="${ctx}/consultation/itemList" method="post">
		 	 	<input type="hidden" name="goodsId" value="${param.goodsId}"/>
		 		<div class="box-right cousultadd">
					 	<div class="slideTxtBox ">
							<div class="hd">			
								<ul>
									<li data-type-id='0'>全部咨询</li>
									<c:forEach items="${orgConsultTypeList}"  var="orgConsultType">
										<li data-type-id='${orgConsultType.consultTypeId}'>${orgConsultType.consultTypeName}</li>
									</c:forEach>
								</ul>
								<input type="hidden" name="consultTypeId" value="${query.consultTypeId}" />
								<a href="${ctx}/item/${param.goodsId}" class="pull-right">&lt;&lt;返回商品页</a>
							</div>
						</div>
			 		<div class="bd-list answer">
							<div class="a-content">
								<c:if test="${page==null || page.totalElements==0}">
									<div class="no-content">
										<span>还没有咨询内容哦！</span>
									</div>
								</c:if>
								<c:if test="${page!=null && page.totalElements!=0}">
									<div class="have-content">
										<c:forEach var="problem" items="${page.content}">
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
									<%@include file="../common/common_page.jsp"%>
								</c:if>
							</div>
						</div>
					</form>	
				<form id="addconsult" action="${ctx}/consultation/add" method="post">
			 		<div  class="mlist consult-control ">
			 			<h5>发表咨询</h5>
			 			<div class="consult">
			 				<div class="consult-l">
			 					<div class="consult-radio">
			 						<span class="consultspan">发表咨询:</span>
			 						<c:forEach items="${orgConsultTypeList}" var="orgConsultType">
				 						<input type="radio" name="TypeIds" data-type-id='${orgConsultType.consultTypeId}' ><label>${orgConsultType.consultTypeName}</label>
									</c:forEach>
			 					</div>
			 					<div class="consult-text">
			 						<textarea rows="8" name="consultProblem" placeholder="请登录后咨询！"></textarea>
			 					</div>
			 					<input type="hidden" name="goodsId" value="${param.goodsId}"/>
			 					<input type="hidden" name="consultClassId" value="1" />
			 					<input type="hidden" name="consultTypeId" />
			 					<input type="hidden" name="consultTypeName" />
			 				</div>
			 				<div class="consult-r">
			 					<dl>
									<dt>声明：</dt>
									<dd>您可在购买前对产品包装、颜色、运输、库存等方面进
									          行咨询，我们有专人进行回复！因厂家随时会更改一些
									          产品的包装、颜色、产地等参数，所以该回复仅在当时
									          对提问者有效，其他网友仅供参考！
									　　   咨询回复的工作时间为：周一至周五，9:00至18:00，
									          请耐心等待工作人员回复。
									 </dd>
	          						<dd class="dd2"><a name="ca" href="javascript:void(0);">提交咨询</a></dd>
			 					</dl>
			 				</div>
			 			</div>
			 		</div>
		 		</form>
		 </div>
	 </div>
</div> 
<%@include file="../common/common_foot.jsp" %>
<%@include file="../common/common_js.jsp"%>
<script type="text/javascript" src="${jsBase}/consult/consult.js"></script>
</body>
</html>