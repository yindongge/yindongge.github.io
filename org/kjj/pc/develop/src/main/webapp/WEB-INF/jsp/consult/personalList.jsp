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
		<div class="container">
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
				<jsp:param name="active" value="留言咨询"/>
			</jsp:include>
			<!-- member-left -->
			<div class="member-right">
					<div class="payment">
						<div class="slideTxtBox">
						<div class="hd">			
							<ul>
								<li class="on">商品咨询</li>
 								<li onclick="window.location.href='${ctx}/consultation/personalWebList'">网站咨询</li>
							</ul>
							<!-- <a href="#" class="contactme">联系客服</a> -->
						</div>
						<div class="bd paddingtop">
							<div class="bd-1">	
								<table class="table table-bordered table-hover">
										<thead>
											<tr class="blue2">
												<th class="th100">商品咨询</th>
												<th class="th200">商品名称</th>
												<th>咨询内容</th>
											</tr>
										</thead>
									<tbody>
										<c:forEach items="${page.content }" var="item">
											<tr class="bottomline" >
												<td>
													<img src="${item.orgProductItem.goodsImg50}" class="imgthumbnail" onclick="window.location.href='${ctx}/item/${item.goodsId}'"/>
												</td>
												<td>${item.orgProductItem.goodsName }</td>
												<td>
													<div class="bottomcontent">
														<p>
															<span class="black">我的咨询：</span>${fn:escapeXml(item.consultProblem)}
															<span class="pull-right"><fmt:formatDate value="${item.createTime}"  pattern="yyyy-MM-dd HH:mm:ss"/></span>            
														</p>
														<c:if test="${fn:length(item.listOrgConsultAnswer)>0 }">
															<p><span class="red">快捷健回复:</span></p>
															<p>${item.listOrgConsultAnswer[0].consultAnswer}</p>
															<p><span class="pull-right"><fmt:formatDate value="${item.listOrgConsultAnswer[0].createTime}"  pattern="yyyy-MM-dd HH:mm:ss"/></span>  </p>
														</c:if>
														<c:if test="${fn:length(item.listOrgConsultAnswer)==0 }">
															<p class="black">(暂无回复)</p>
														</c:if>
													</div>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>	
								<form id="pageform" action="${ctx }/consultation/personalList" method="post" >
								<%@include file="../common/common_page.jsp"%>
								</form>
						</div>
						</div>
					</div>	
			</div>
			<!-- end memberright -->
				</div>
		</div>
	</div>
	
<!--  -->
<%@include file="../common/common_foot.jsp" %>
<!-- show -->
<form action="${ctx}/order/cancel" method="post">
<div class="togglemoadl togglemodal2" style="display:none;">
	<input type="hidden" id="cancel_order_id" name="order_id"/>
	<h5>取消订单<button type="button" class="close" name="buttonClose">x</button></h5>
	<div class="tolggle-content">
		<div class="toggleall">	
			<p class="warning">您确定要取消该订单吗？取消订单后，不能恢复！</p>
		</div>
		<div class="toggleall">	
			<div class="select">
				<span>请选择取消订单的理由：</span>
				<select name="log_detail">
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
</body>
</html>