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
<title>热卖推荐</title>
</head>

<body >
<div class="page-wrapper goods-control">
<div class="container-fluid">
<form id ="pageform" name ="pageform" class="form-inline" action="${ctx}/itemRecommend/list" method="post">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">运营</a></li>
		<li class="active">热卖推荐</li>
	</ul>
	<div class="form-inline" >
	<div class="well" style="padding:5px;">
		<div class="form-group">
			<label>类型:</label>
			<select class="form-control" id="recommendType" name="recommendType">
				<option value="1" <c:if test="${query.recommendType==1}">selected="selected"</c:if>>新品</option>
				<option value="2" <c:if test="${query.recommendType==2}">selected="selected"</c:if>>热卖</option>
				<option value="3" <c:if test="${query.recommendType==3}">selected="selected"</c:if>>促销</option>
				<option value="4" <c:if test="${query.recommendType==4}">selected="selected"</c:if>>推荐</option>
			</select>	
		</div>
		<div class="form-group">
			<label>适用范围:</label>
			<select class="form-control" id="shopType" name="shopType">
				<!-- <option value="0">选择范围</option> -->
				<option value="1"  <c:if test="${query.shopType==1}">selected="selected"</c:if>>全部区域</option>
				<option value="2" <c:if test="${query.shopType==2}">selected="selected"</c:if>>单区域</option>
				<option value="3" <c:if test="${query.shopType==3}">selected="selected"</c:if>>单区域门店</option>
			</select>
			<select class="form-control" id="cityCode" name="cityCode" <c:if test="${query.shopType!=2}">style="display: none;"</c:if>>
				<option value="110100">北京</option>
			</select>
			<select class="form-control" id="shopId" name="shopId" <c:if test="${query.shopType!=3}">style="display: none;"</c:if>>
				<c:forEach var="shop" items="${listShop}">
					<option value="${shop.shopId}" <c:if test="${query.shopId==shop.shopId}">selected="selected"</c:if>>${shop.shopName}</option>
				</c:forEach>
			</select>
		</div>
		<br />
		<div class="form-group">
			<select class="form-control" id="selectType" name="selectType">
				<option value="" <c:if test="${empty query.selectType}">selected="selected"</c:if>>全部</option>
				<option value="1" <c:if test="${query.selectType==1}">selected="selected"</c:if>>已选择</option>
				<option value="0" <c:if test="${query.selectType==0}">selected="selected"</c:if>>未选择</option>
			</select>		
		</div>
		<div class="form-group">
			<select class="form-control" id="superClassId" name="superClassId">
				<option value="">选择分类</option>
				<c:forEach var="clazz" items="${listClass}">
					<option value="${clazz.classId}" <c:if test="${query.superClassId==clazz.classId}">selected="selected"</c:if>><c:if test="${clazz.classLevel==2}">&nbsp;&nbsp;&nbsp;&nbsp;</c:if>${clazz.className}</option>
				</c:forEach>
			</select>			
		</div>
		<div class="form-group">
			<select class="form-control" id="brandId" name="brandId">
				<option value="">选择品牌</option>
				<c:forEach var="brand" items="${listBrand}">
					<option value="${brand.productBrandId}" <c:if test="${brand.productBrandId==query.brandId}">selected="selected"</c:if>>${brand.productBrandName}</option>
				</c:forEach>
			</select>		
		</div>		
		<div class="form-group">
			<input type="text" class="form-control" placeholder="商品名称或者编号" name="goodsQuery" value="${query.goodsQuery}"/>
		</div>
		<button type="submit" class="btn btn-danger">搜索</button>
	</div>
	</div>
	<table class="table table-hover table-bordered table-4">
		<thead>
			<tr>
				<!-- <th style="width:80px;"><input type="checkbox" class="check10"/><em>全选</em></th> -->
				<th style="width:330px;">商品名称</th>
				<th class="w201">货号</th>
				<!-- <th class="w52">售价</th> -->
				<th class="w89">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.content}" var="item">
			<tr class="icon11">
				<!-- <td><input type="checkbox" value="${item.goodsId}"/></td> -->
				<td class="icon11-td"><a><img src="${item.goodsImg50}"/></a>${item.goodsName}</td>
				<td>
					<!-- <p class="huohao">规格：</p> -->
					<p class="guige">货号：${item.goodsSn}</p>
				</td>
				<!-- 
				<td>
					<span class="yellow"></span>
				</td>
				 -->
				<td>
					<c:if test="${empty item.oirId}">
						<button type="button" class="btn btn-success" data-goods-id="${item.goodsId}">添加</button>
					</c:if>
					<c:if test="${!empty item.oirId}">
						<button type="button" class="btn btn-danger" data-goods-id="${item.goodsId}">取消</button>
					</c:if>
				</td>
			</tr>
			</c:forEach>
			<!-- 
			<tr class="icon11">
				<td><input type="checkbox" class="check10"/><em class="specialem">全选</em></td>
			<td >
				<button type="button" class="btn btn-danger ">确定</button>
			</td>
			
			<td colspan="3"></td>
			 -->
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
<script src="${jsBase}/itemRecommend/list.js" type="text/javascript"></script>
<!--结束弹出框分割线-->
</body>
</html>
