<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<%@include file="../common/common_css.jsp" %>
<title>活动专题图</title>
</head>
<body>
	<div class="row row-border bluerow" style="margin-bottom:10px;margin-left:0px;margin-right:0px">
		<div class="form-group ">
			<label>选择活动商品：</label>
		</div>
		<form id="pageform" class="form-inline form_special2" action="${ctx}/special/searchProduct" method="post">
			<div class="form-group select_special2">
				<label>选择分类：</label>
				<select class="form-control" id="levelOne" name="parentCatId">
					<option value="-1">请选择分类</option>
					<c:forEach items="${listClassLevelOne}" var="levelOne">
						<option value="${levelOne.classId}" <c:if test="${levelOne.classId == query.parentCatId }">selected</c:if>>${levelOne.className}</option>
					</c:forEach>
				</select>
				<select class="form-control" id="levelTwo" name="catId" >
					<option value="-1">请选择分类</option>
					<c:forEach items="${listClassLevelTwo}" var="levelTwo">
						<option value="${levelTwo.classId}" <c:if test="${levelTwo.classId == query.catId }">selected</c:if> >${levelTwo.className}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group select_special2">
				<label>商品名称：</label>
				<input type="text" name="keyword" value="${query.keyword}" class="form-control"  placeholder="请输入商品名称" />
				<button class="btn btn-info">搜索</button>
			</div>
			<div class="toggle_content">
				<div class="form-group select_special2">
					<div class="edit_wrapper">
						<c:forEach items="${page.content}" var="item">
							<div title="${item.goodsName}" class="edit_list" data-id="${item.goodsId}">
								<img src="${item.goodsImg180}" alt="${item.goodsName}" />
								<a  style="overflow:hidden">${item.goodsName}</a>
								<span class="glyphicon glyphicon-plus-sign closeme"></span>
							</div>
						</c:forEach>	
					</div>
				</div>
				<nav class="navbar navbar-default select-control" >
					<%@include file="../common/common_page.jsp" %>
				</nav>
			</div>
		</form>
	</div>	
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/special/searchProduct.js" type="text/javascript"></script>
</body>
</html>
