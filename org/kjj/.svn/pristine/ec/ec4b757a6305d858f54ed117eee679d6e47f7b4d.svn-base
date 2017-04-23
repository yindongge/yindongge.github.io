<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<%@include file="../common/common_css.jsp" %>
<title>快捷健商城</title>
</head>
<body>
<div class="all memberall">
	<%@include file="../common/common_head2.jsp" %>
	<!-- end top -->
	<div class="header header-member">
		<div class="container container-width">
			<div class="severce-head">
			<div class="logo fl">
				<a href="${ctx}"><img src="${imgBase}/icon/member-logo.png"/></a>
				<div class="text-position">
					<strong>个人中心</strong>				
				</div>		
			</div>
			<%@include file="../common/common_cart.jsp" %>
			<div class="search fr">
					<%@include file="../common/common_search.jsp" %>	
			</div>
			</div>
		</div>
	</div>
	<!-- end header -->
	<div class="center-content">
		<div class="container container-width  ">
			<jsp:include page="../common/common_left.jsp">
				<jsp:param name="active" value="我的评价"/>
			</jsp:include>
			<!-- member-left -->
			<div class="member-right">
				<div class="review-head">
					<a href="javascript:void(0);" class="re-a1">商品评价</a>
					<a href="${ctx}/comment/list" class="re-a2">更多未评价商品</a>
				</div>
				<div class="review-body">
					<table class="table table-same table-bordered">
						<thead>
							<tr class="bluem">
								<th class="th11">订单商品</th>
								<th >购买时间</th>
								<th>评价状态</th>
							</tr>
						</thead>
					<tbody>
						<c:forEach var="item" items="${listOrderGoods}" varStatus="status">
						<tr class="bluem2">
							<td>
								<div class="mlist-img"><a href="${ctx}/item/${item.goodsId}" target="_blank"><img src="${item.orgProductItem.goodsImg180}" title="${item.orgProductItem.goodsName}"/></a></div>
								<div class="mlist-text"><a href="${ctx}/item/${item.goodsId}" target="_blank">${item.orgProductItem.goodsName}</a></div>
							</td>
							<td><fmt:formatDate value="${item.orgOrder.createTime}" type="both"/></td>
							<td>
								<c:if test="${item.commentStatus==0}"><a class="togglea2" href="javascript:void(0);">发表评价</a></c:if>
								<c:if test="${item.commentStatus==1}"><a class="togglea2" href="javascript:void(0);">查看评价</a></c:if>
							</td>
						</tr>
						<tr class="toggletr <c:if test='${item.commentStatus==0}'>starScore</c:if>">
							<td colspan="3">
								<div class="togglehide">
									<div class="tolggle-content">
										<div class="toggleall">	
											<div class="toggle-left">
												<i class="red">*</i>评分：
											</div>
											<div class="toggle-right">
												<a href="javascript:void(0);" <c:if test="${item.orgGoodsComment.starScore>0}">class='yellow-icon'</c:if>></a>
												<a href="javascript:void(0);" <c:if test="${item.orgGoodsComment.starScore>1}">class='yellow-icon'</c:if>></a>
												<a href="javascript:void(0);" <c:if test="${item.orgGoodsComment.starScore>2}">class='yellow-icon'</c:if>></a>
												<a href="javascript:void(0);" <c:if test="${item.orgGoodsComment.starScore>3}">class='yellow-icon'</c:if>></a>
												<a href="javascript:void(0);" <c:if test="${item.orgGoodsComment.starScore>4}">class='yellow-icon'</c:if>></a>
												<b style="display:none;"></b>
											</div>
										</div>
										<div class="toggleall">	
											<div class="toggle-left">
												<i class="red">*</i>心得：
											</div>
											<div class="toggle-right">
												<textarea class="taClass" name="goodsComment" placeholder="商品是否给力？快分享你的购买心得吧~" rows="5" style="width:90%;resize: none;" maxlength="500" <c:if test="${item.commentStatus==1}">disabled='disabled'</c:if>>${item.orgGoodsComment.goodsComment}</textarea>
												<c:if test="${item.commentStatus==0}"><span class="span11">10-500字,您最多还可以输入<i class="red">500</i>个字</span></c:if>
												<br/>
												<b style="display:none;"></b>
											</div>
										</div>
										<input type="hidden" name="orderGoodsId" value="${item.id}"/>
										<c:if test="${item.commentStatus==0}"><p class="text-center"><button type="button" name="buttonSave" class="a13">评论并继续</button><b style="display:none;"></b></p></c:if>
										<i class="isanjiao"></i>
									</div>
								</div>
							</td>
						</tr>
						</c:forEach>
					</tbody>
					</table>
				</div>
			</div>

			<!-- end memberright -->
		</div>
	</div>

<!--  -->
<%@include file="../common/common_foot.jsp" %>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/comment/add.js" type="text/javascript"></script>
</body>
</html>