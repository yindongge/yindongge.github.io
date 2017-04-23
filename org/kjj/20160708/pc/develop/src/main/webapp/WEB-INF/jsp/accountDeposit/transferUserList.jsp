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
		<form  class="form-inline" id ="pageform" name ="pageform" action="${ctx}/accountDeposit/transferUserlist" method="post">
		    <input type="hidden" id="allowanceAmount" value="${accountDeposit.allowanceAmount}"/>
		    <input type="hidden" id="errorNum" value="${accountDeposit.errorNum}"/>
			<div class="container">
				<jsp:include page="../common/common_left.jsp">
					<jsp:param name="active" value="预存款"/>
				</jsp:include>
				<div class="member-right">
					<div class="pay-table">
					    <div class="ready_pay_tip">
							<p>此页面可批量充值，请务必核对每条人员信息和金额后进行充值操作，只能向本企业所关联会员账号转账。</p>
						</div>
						<div class="a-group">
							<div class="a-group-first">
								<a class="first_a">预付款可用余额（￥${accountDeposit.allowanceAmount} )</a>
							</div>
						</div>
						<table class="table table-hover table-striped table-bordered">
							<thead>
								<tr class="info">
								    <th><!-- <input type="checkbox" id="selectAll"/>全选 -->选择</th>
									<th>序号</th>
									<th>手机号</th>
									<th>会员名</th>
									<th>姓名(备注)</th>
									<th>转账金额(元,<font style="color:red">必须保留两位小数</font>)</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${page.content}" varStatus="status">
								<tr>
								    <td><input type="checkbox" name="userIds"  id="userIds" style="margin-top:2px; " value="${item.userId}" onclick="doShowPrice('${item.userId}',this)"/></td>
								    <td>${status.index+1}</td>
									<td>${item.mobilePhone}</td>
									<td style="text-align: center;">${item.userName}</td>
									<td style="text-align: center;">${item.realName}</td>
									<td nowrap="nowrap">
										<input class="form-control" disabled="disabled" onblur="checkPrice('${item.userId}')" title="编辑内容之前请先选中'选择框',内容必须保留两位小数" type="text" id="${item.userId}" oldvalue="" value="" style="width:100px" onkeyup="if(isNaN(value))execCommand('undo')" onafterpaste="if(isNaN(value))execCommand('undo')" maxlength="10"/>
										<span id="${item.userId}Span" style="color:red;width:100px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
									</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
						<%@include file="../common/common_page_select.jsp"%>
					</div>
					<div class="ready_pay_tip">
						<div class="text_right">请输入支付密码(6位数字)：<input type="password" id="payPassword" name="payPassword" maxlength="6" style="font-size:14px;"/><a style="cursor:pointer" onclick="confirmTransfer()">确认转账</a><span style="color:red" id="payPasswordSpan"><c:if test="${accountDeposit.errorNum==3}">支付账户被锁定！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if><c:if test="${accountDeposit.errorNum!=3}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if></span></div>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>	
<%@include file="../common/common_foot.jsp" %>
<%@include file="../common/common_js.jsp"%>
<script src="${jsBase}/accountDeposit/transferUserList.js" type="text/javascript"></script>
</body>
</html>