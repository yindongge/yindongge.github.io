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
<title>查看商品及折扣信息</title>
</head>

<body>	
<div class="page-wrapper goods-control">
<div class="container-fluid">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">运营</a></li>
			<li ><a href="#">价格体系</a></li>
			<li ><a href="#">一体化价格</a></li>
			<li class="active">查看商品及折扣信息</li>
	</ul>
	<br/>
	<form id="userlevelform" name ="userlevelform" action="" method="post">
		<table class="table table-hover table-bordered table-special10 ">
			<tbody>
				<tr>
					<td width="300px">商品名称：</td>
					<td colspan="6">${productItem.goodsName} </td>
				</tr>
				<tr>
					<td width="300px">商品货号：</td>
					<td colspan="6">${productItem.goodsSn} </td>
				</tr>
				<tr>
					<td width="300px">商品图片：</td>
					<td colspan="6"><img height="60px" width="60px" src="${productItem.goodsImg50}"></img> </td>
				</tr>
				<c:forEach var="level" items="${userLevels}" varStatus="status">
				    <tr>
						<td width="300px">${level.levelName}折扣：</td>
						<td colspan="6">${level.discount}</td>
					</tr>
				</c:forEach>
				<tr>
					<td width="300px">线上是否有效：</td>
					<td colspan="6"> 
						<c:if test="${productItem.id==null}">
							无效
						</c:if>
						<c:if test="${productItem.id!=null}">
							有效
						</c:if>
					</td>
				</tr>
				
			</tbody>
		</table>
		<div class="modal-footer">
			<button type="button" class="btn btn-default modal-button" data-dismiss="modal" onclick="cancle()">关闭</button>
		</div>
	</form>
</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/levelDiscount/goodsLevel.js" type="text/javascript"></script>
</body>
</html>
