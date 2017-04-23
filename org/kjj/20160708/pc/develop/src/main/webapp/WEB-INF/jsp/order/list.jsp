<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<!-- 禁止缓存 -->
<meta http-equiv="Expires" content="0"/>
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Pragma" content="no-cache"/> 
<!-- 禁止缓存 -->
<%@include file="../common/common_css.jsp"%>
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
		<div class="container">
			<jsp:include page="../common/common_left.jsp">
				<jsp:param name="active" value="我的订单"/>
			</jsp:include>
			<!-- member-left -->
			<div class="member-right">
					<div class="member-mg">
						<h5>我的订单</h5>
						<div class="mg-iconlist">
							<ul class="u-ul">
							<li>
								<div class="u-list">
									<a>
										<i class="u-icon u-icon1"></i>
										待付款<span>${userCount.waitPaidCount}</span>
									</a>
								</div>
							</li>
							<li>
								<div class="u-list">
									<a>
										<i class="u-icon u-icon2"></i>
										待收货<span>${userCount.waitSendCount}</span>
									</a>
								</div>
							</li>
							<li>
								<div class="u-list">
									<a>
										<i class="u-icon u-icon3"></i>
										待自提<span>${userCount.waitTakeCount}</span>
									</a>
								</div>
							</li>
							<li>
								<div class="u-list">
									<a>
										<i class="u-icon u-icon4"></i>
										待评价<span>${userCount.waitCommentCount}</span>
									</a>
								</div>
							</li>

						</ul>
						</div>
					</div>
				<form id="pageform" name="pageform" action="${ctx}/order/list" method="post">
				<!-- first right1 -->
				<div  class="mg-table">
				<div class="mg-title">
					<div class="mg-t">全部订单</div>
					<div class="mg-input pull-right">
						<input type="text" placeholder="商品名称" name="goodsNameLike" value="${query.goodsNameLike}"/>
						<button class="role-btn1 btn" type="submit">搜索</button>
					</div>
				</div>
				
				<div class="mg-content">
				<table class="table table-me">
					<thead>
						<tr class="mg-tr1">
							<th class="th1">订单信息 </th>
							<th>收货人</th>
							<th>订单金额</th>
							<th>订单时间</th>
							<th class="text-center th3">
								<select name="queryStatus" id="queryStatus">
									<option value="-1" <c:if test="${ query.queryStatus==-1 }">selected</c:if>>状态请选择</option>
									<option value="0" <c:if test="${ query.queryStatus==0 }">selected</c:if>>待付款</option>
									<option value="13" <c:if test="${ query.queryStatus==13 }">selected</c:if>>待收货</option>
									<option value="23" <c:if test="${ query.queryStatus==23 }">selected</c:if>>待自提</option>
									<option value="4" <c:if test="${ query.queryStatus==4 }">selected</c:if>>已完成</option>
									<option value="5" <c:if test="${ query.queryStatus==5 }">selected</c:if>>已取消</option>
									<option value="6" <c:if test="${ query.queryStatus==6 }">selected</c:if>>已关闭</option>
								</select>
							</th>
							<th>操作</th>
						</tr>
					</thead>
					<c:forEach var="item" items="${page.content}" varStatus="status">
					<tbody>
						<tr class="mg-tr2">
							<td colspan="6">
								<span class="mg-span1 mg-span">订单编号：<a href="${ctx}/order/detail/${item.orderId}"><i>${item.orderId}</i></a></span>
								<span class="mg-span2 mg-span">店铺名称：<i>${item.orgShop.shopName}</i></span>
							</td>
						</tr>
						<tr class="mg-tr3">
							<td>
								<div class="mg-img">
									<c:forEach var="orderGoods" items="${item.listOrderGoods}" varStatus="status">
									<c:if test="${orderGoods.unitAccounts > 0}">
									<a href="${ctx}/item/${orderGoods.goodsId}" target="_blank"><img src="${orderGoods.orgProductItem.goodsImg180}" title="${orderGoods.orgProductItem.goodsName}"/></a>
									</c:if>
									</c:forEach>
								</div>
							</td>
							<td>${item.consignee}</td>
							<td>￥<fmt:formatNumber type="currency" pattern="0.00" value="${item.orderMoney}"/>
								<br/>
								<c:if test="${item.payStyle==0}">在线支付</c:if>
								<c:if test="${item.payStyle==1}">货到付款</c:if>
								<br/>
								<c:if test="${item.source==2}"><a href="javascript:void(0);" class="blueblock">触屏版订单</a></c:if>
							</td>
							<td><fmt:formatDate value="${item.createTime}" type="date"/><br/><fmt:formatDate value="${item.createTime}" type="time"/></td>
							<td>
								<c:if test="${item.status==0}">待付款</c:if>
								<c:if test="${item.status==1}">待确认</c:if>
								<c:if test="${item.status==2}">
									<c:if test="${item.sendStyle==0}">待发货</c:if>
									<c:if test="${item.sendStyle==1}">备货中</c:if>
								</c:if>
								<c:if test="${item.status==3}">
									<c:if test="${item.sendStyle==0}">待收货</c:if>
									<c:if test="${item.sendStyle==1}">待自提</c:if>
								</c:if>
								<c:if test="${item.status==4}">已完成</c:if>
								<c:if test="${item.status==5}">已取消</c:if>
								<c:if test="${item.status==6}">已关闭</c:if>
							</td>
							<td class="td4">
								<c:if test="${item.status==0 and item.payStatus==0}">
									<a href="${ctx}/pay/payInit?orderId=${item.orderId}" class="a1"><span>付款</span></a>
								</c:if>
								<a href="${ctx}/order/detail/${item.orderId}">查看</a>
								<c:if test="${item.status<3}">
									<a href="javascript:void(0);" name="btnCancel" onclick="cancel(${item.orderId});">取消订单</a>
								</c:if>
								<c:if test="${item.status==4}">
									<c:if test="${item.commentStatus==0}">
										<a href="${ctx}/comment/addInit/${item.orderId}">评价</a>
									</c:if>
									<c:if test="${item.returnStatus==0}">
										<a href="${ctx}/return/show/${item.orderId}">退货</a>
									</c:if>
								</c:if>
							</td>
						</tr>
					</tbody>
					</c:forEach>
				</table>
				</div>
				<!-- end mg-content -->
				<%@include file="../common/common_page.jsp"%>
				</div>
				</form>
				
				<!-- end mgtable -->
				<!-- 
				<div class="mg-love">
						<h5>新品热卖</h5>
						<ul>
							<li>
								<div class="mg-l-img"></div>
								<div class="mg-l-tet"></div>
							</li>
						</ul>
				</div>
				 -->
			</div>
			<!-- end memberright -->
		</div>
	</div>
	
<!-- footer -->
<%@include file="../common/common_foot.jsp" %>
<!-- show -->
<form action="${ctx}/order/cancel" method="post">
<div class="togglemoadl togglemodal2" style="display:none;">
	<input type="hidden" id="cancelOrderId" name="orderId"/>
	<h5>取消订单<button type="button" class="close" name="buttonClose">x</button></h5>
	<div class="tolggle-content">
		<div class="toggleall">	
			<p class="warning">您确定要取消该订单吗？取消订单后，不能恢复！</p>
		</div>
		<div class="toggleall">	
			<div class="select">
				<span>请选择取消订单的理由：</span>
				<select name="logDetail">
					<option value="我不想买了">我不想买了</option>
					<option value="信息填写错误，重新拍">信息填写错误，重新拍</option>
					<option value="店铺缺货">店铺缺货</option>
					<option value="见面交易">见面交易</option>
					<option value="付款遇到问题（如余额不足、不知道怎么付款等）">付款遇到问题（如余额不足、不知道怎么付款等）</option>
					<option value="拍错了">拍错了</option>
					<option value="其他原因">其他原因</option>
				</select>
			</div>
		</div>
		<p class="text-center"><button type="button" name="buttonClose" class=" a-same a14" name="buttonClose">取消</button><button type="submit" id="confirmCancel" class="a-same a13">确定</button></p>
	</div>
</div>
</form>
<div class="toggle-mask" style="display:none;"></div>
</div>
<%@include file="../common/common_js.jsp"%>
<script src="${jsBase}/order/list.js" type="text/javascript"></script>
</body>
</html>