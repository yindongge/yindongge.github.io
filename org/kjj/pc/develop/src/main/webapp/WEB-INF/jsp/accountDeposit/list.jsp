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

	<div class="center-content">
		<form  class="form-inline" id ="pageform" name ="pageform" action="${ctx}/accountDeposit/list" method="post">
			<div class="container">
			<jsp:include page="../common/common_left.jsp">
				<jsp:param name="active" value="预存款"/>
			</jsp:include>
				<div class="member-right">
				<div class="pay-table">
					<div class="a-group">
						<div class="a-group-first">
							<a class="first_a">可用余额（￥${accountDeposit.fundAmount+accountDeposit.allowanceAmount} )</a>
							<a class="second_a">冻结余额（￥${accountDeposit.frozenAmount} )</a>
						</div>
						
						<div class="a-group-second">
							<c:if test="${! empty accountDeposit.payPassword}">
								<c:if test="${levelType == 2}">
							    	<a class="ready_counttwo" href="${ctx}/accountDeposit/transferUserlist">预存款转账</a>
							    </c:if>
							</c:if>
							<c:if test="${empty accountDeposit.payPassword}">
								<a class="ready_countone" href="${ctx}/accountDeposit/setPasswordInit" title="使用余额支付时须用支付密码">设置支付密码<span class="glyphicon glyphicon-info-sign"></span></a>
							</c:if>
						</div>
						<div class="a-group-third">
							<a href="${ctx}/article/dispatcher/61" target="_blank">余额使用规则</a>
						</div>
					</div>
					<table class="table table-hover table-striped table-bordered">
						<thead>
							<tr class="info">
								<th>场景</th>
								<th>金额（元）</th>
								<th>操作类型</th>
								<th>单据编号</th>
								<c:if test="${levelType == 2}">
								<th>交易人会员名</th>
								<th>交易人手机号</th>
								</c:if>
								<th>时间</th>
								<!-- <th>操作</th> -->
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${page.content}" varStatus="status">
							<tr>
								<td>
									<c:forEach items="${originMap}" var="itemMap">
									    <c:if test="${itemMap.key==item.origin}">${itemMap.value}</c:if>
									</c:forEach>
								</td>
								<td>${item.amountShow}</td>
								<td>${item.typeShow}</td>
								<td style="text-align: center;">${item.serviceCode}</td>
								<c:if test="${levelType == 2}">
								<td>${item.traderName}</td>
								<td>${item.mobilePhone}</td>
								</c:if>
								<td><fmt:formatDate value="${item.createTime}" type="both" /></td>
								<!-- <td>详情</td> -->
							</tr>
							</c:forEach>
						</tbody>
					</table>
					<%@include file="../common/common_page.jsp"%>
					</div>
					</div>
				</div>
			</form>
		</div>
</div>	
<%@include file="../common/common_foot.jsp" %>
<%@include file="../common/common_js.jsp"%>
<div class="toggle-mask" style="display:none;"></div>
</body>
</html>