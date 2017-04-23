<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<%@include file="../common/common_css.jsp" %>
<title>购物车-快捷健商城</title>
</head>
<body>
<div class="all">
	<%@include file="../common/common_head2.jsp" %>
	<!-- end top -->
	<div class="header">
		<div class="container container-width">
			<div class="logo fl">
				<a href="${ctx}"><img src="${imgBase}/logo.jpg"/></a>
				<div class="text-position">
					<strong >购物车</strong>
				</div>
			</div>
			<div class="search fr search-special1">
				<%@include file="../common/common_search.jsp" %>
			</div>

		</div>
	</div>
	<form id="cart" action="${ctx}/order/addInit" method="get">
		<div class="container" id="showInfo">
		${showInfo}
		</div>
	</form>
	<div class="container" id="recommendDiv">
	</div>
<%@include file="../common/common_mayLikeItems.jsp" %>
<!-- footer -->
<%@include file="../common/common_foot.jsp" %>
<!--fade  -->
<div class="into" id="divDel" style="dispaly:none;">
	<div class="into-title">
		<h5>删除<button type="button" class="close" onclick="delCancel();">x</button></h5>
	</div>
	<div class="into-body">
		<div class="into-text">
			<p class="gray">您确定要删除该商品么？</p>
			<p class="into-button">
				<button type="button" class="btn btn-default" onclick="delCancel();">取消</button>
				<button type="button" class="btn btn-warning" onclick="delConfirm();">确定</button>
			</p>
		</div>
	</div>
</div>
<div class="toggle-mask" style="display:none;"></div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/cart/list.js" type="text/javascript"></script>
</body>
</html>