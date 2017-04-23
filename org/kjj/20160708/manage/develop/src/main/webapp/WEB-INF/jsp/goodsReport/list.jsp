<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<%@include file="../common/common_css.jsp" %>
<title>销售统计</title>
</head>

<body>
<div class="page-wrapper goods-control">
<div class="container-fluid">
	<form id="pageform"  class="form-inline" name="pageform" action="${ctx }/goodsReport/list" method="post">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">数据</a></li>
		<li class="active">销售统计</li>
	</ul>
	<div class="well" style="padding:5px;">
			<div class="form-group">
				<label>商品名称</label>
				<input type="text" class="form-control" name="goodsNameLike" value="${query.goodsNameLike }"/>			
			</div>
			<div class="form-group">
				<label>商品货号：</label>
				<input type="text" class="form-control" name="goodsSnLike" value="${query.goodsSnLike }"/>			
			</div>
			<div class="form-group">
				<label>门店：</label>
				<select name="shopId" class="form-control">
					<option value="">所有</option>
					<c:forEach items="${shopList }" var="shop">
					<c:choose>
						<c:when test="${query.shopId eq shop.shopId }">
						<option value="${shop.shopId }" selected="selected">${shop.shopName }</option>
						</c:when>
						<c:otherwise>
						<option value="${shop.shopId }">${shop.shopName }</option>
						</c:otherwise>
					</c:choose>					
					</c:forEach>
				</select>		
			</div>
			<br />
			<div class="col-sm-6">
				<div class="">
					<label>时间：</label>
					<input type="text" class="form-control date" value="<fmt:formatDate value="${query.createTimeStart}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>" name="createTimeStart"/>	
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label>到：</label>
					<input type="text" class="form-control date" value="<fmt:formatDate value="${query.createTimeEnd}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>" name="createTimeEnd"/>		
				</div>
			</div>
			<div class="form-group radio-special2">
				<label>按门店统计</label>
				<c:choose>
					<c:when test="${query.isAsShop == true }">
						<input type="radio" name="isAsShop" value="true" checked="checked"/>是
						<input type="radio" name="isAsShop" value="false"/>否
					</c:when>
					<c:when test="${query.isAsShop == false }">
						<input type="radio" name="isAsShop" value="true" />是
						<input type="radio" name="isAsShop" value="false" checked="checked"/>否
					</c:when>
				</c:choose>
				
			</div>
			<button type="submit" class="btn btn-danger">查询</button>

		</div>
	
	</br>
	
	<a href="javascript:void(0);" type="button" class="btn btn-danger" id="exportBtn" onclick="exportExcel();">生成销售报表</a>
	<table class="table table-hover table-bordered ">
		<thead>
			<tr>
				<th><input type="checkbox" /></th>
				<th> 商品货号</th>
				<th>商品名称</th>
				<c:if test="${query.isAsShop == true }">
				<th>店铺</th>
				</c:if>				
				<th>销量</th>
				<th>平均价格（元）</th>
				<th>总金额（元）</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.content}" var="item">
			<tr>
				<td><input type="checkbox" /></td>
				<td>${item.goodsSn }</td>
				<td>${item.goodsName }</td>
				<c:if test="${query.isAsShop == true }">
				<td>${item.shopName }</td>
				</c:if>
				<td>${item.amountGoods }</td>
				<td >${item.avgPrice }</td>
				<td>${item.totalMoney }</td>
			</tr>
			</c:forEach>
			<tr class="icon8">
				<td colspan="7" >
				<div class="checkbox-inline">
						<label>
						<input type="checkbox" style="margin-top:2px;"/>全选
						</label>
				</div>
				</td>
			</tr>
		</tbody>
	</table>
	<nav class="navbar navbar-default select-control" >
		<%@include file="../common/common_page.jsp" %>
	</nav>
	</form>
</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/goodsReport/goodsReport.js" type="text/javascript"></script>
</body>
</html>
