<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<%@include file="../common/common_css.jsp" %>
<title>网站咨询-反馈留言</title>
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
			<form id="addconsult" action="${ctx}/consultation/add" method="post">
				<div class="member-right">
					<div class="mlist information ">
						<h5 class="paddingleft" >反馈留言</h5>
						<dl class="feedlist">
							<dt>反馈类型：</dt>
							<dd style="width:900px">
								<input checked="checked" type="radio" value="2"/>
								<label>网站咨询</label>
							</dd>
						</dl>
						<dl class="feedlist">
							<dt>留言类型：</dt>
							<dd style="width:900px">
								<c:forEach items="${orgConsultTypeList}" var="orgConsultType">
					 				<input type="radio" name="TypeIds" data-type-id='${orgConsultType.consultTypeId}' /><label>${orgConsultType.consultTypeName}</label>
								</c:forEach>
							</dd>
						</dl>
						<div class="textarea8">
							<textarea name="consultProblem" rows="15" style="width:100%;"></textarea>
						</div>
						<input type="hidden" name="consultClassId" value="2" />
						<input type="hidden" name="goodsId" value="0"/>
	 					<input type="hidden" name="consultTypeId" />
	 					<input type="hidden" name="consultTypeName" />
						<p class="margintop"><a href="javascript:void(0);" class="samebtn">提交</a></p>
					</div>
				</div>
				<!-- end memberright -->
			</form>
		</div>
	</div>
	
<%@include file="../common/common_foot.jsp" %>
<%@include file="../common/common_js.jsp"%>
<script type="text/javascript" src="${jsBase}/consult/consult.js"></script>
</div>
</body>
</html>
