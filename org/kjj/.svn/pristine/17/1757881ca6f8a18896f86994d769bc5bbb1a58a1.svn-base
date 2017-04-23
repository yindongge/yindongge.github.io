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
	<title>运营管理</title>
</head>

<body>
<div class="page-wrapper">
<div class="container-fluid">
	<form  class="form-inline" id ="pageform" name ="pageform" action="${ctx}/levelprice/levelcoupon" method="post">
		<ul class="breadcrumb">
			<li>您的位置</li>
			<li ><a href="#">运营</a></li>
			<li ><a href="#">价格体系</a></li>
			<li class="active">电商会员价格</li>
		</ul>
		<div class="well well-price" style="padding:5px;">
			<p class="fontweight">备注：</p>
			<p>【一体化价格】由瑞星系统设置，线上可设定是否有效，如无效则线上不执行该会员价格；</p>
			<p>【电商价格】是为线上独立设置的会员价格体系，线下不做同步；</p>
			<p>&nbsp;电商会员价格权重高于一体化价格。</p>
			<p>&nbsp;商品权重规则：分类>所有，单品>分类；地域权重规则：单店>地区。</p>
		</div>
		<br/>
		<div style="padding:10px;height:50px;background:#f5f5f5;">
			<div class="col-sm-12">
				<div class="form-group">
					<label>商品名称：</label>
					<input type="text" class="form-control" name="goodsName" value="${query.goodsName}" style="width:120px"/>			
				</div>
				<div class="form-group">
					<label>商品货号：</label>
					<input type="text" class="form-control" name="goodsSn" value="${query.goodsSn}"  style="width:120px"/>			
				</div>
				<div class="form-group">
					<label>区域：</label>
					<select class="form-control" id="cityCode" name="cityCode">
					    <option value="" >请选择</option>
						<option value="110100" <c:if test="${query.cityCode==110100}">selected</c:if>>北京</option>
					</select>		
				</div>
				<div class="form-group">
					<label>店铺：</label>
					<select class="form-control" id="cityShopId" name="cityShopId">
					    <option value="" >请选择</option>
					    <c:forEach var="shop" items="${shopList}" varStatus="status">
							<option value="${shop.shopCode}" <c:if test="${query.cityShopId==shop.shopCode}">selected</c:if>>${shop.shopName}</option>
						</c:forEach>
					</select>	
				</div>
				<div class="form-group">
					<label>状态：</label>
					<select class="form-control" name="status">
						<option value="">全部</option>
						<option value="1" <c:if test="${ query.status=='1' }">selected</c:if>>有效</option>
						<option value="0" <c:if test="${ query.status=='0' }">selected</c:if>>无效</option>
					</select>	
				</div>
				<button type="submit" class="btn btn-danger">搜索</button>
			</div>
		</div>
		<div class="breadcrumb breadcrumb-title">电商会员价格<button type="button" class="btn btn-danger pull-right" onclick="addLevelCoupon()">增加折扣</button></div>
		<table class="table table-hover table-bordered table-striped table-4">
			<thead>
				<tr class="info">
					<th class="w200">商品/分类</th>
					<th >区域/门店</th>
					<c:forEach var="level" items="${userLevels}" varStatus="status">
					<th>${level.levelName}[折扣/金额]</th>
					</c:forEach>
					<th>状态</th>
					<th style="width:100px;">操作</th>
				</tr>
			</thead> 
			<tbody>
				<c:forEach var="item" items="${page.content}" varStatus="status">
				<tr class="icon11 zhekoutext">
					<td>
					    <c:if test="${item.productType==1}">
					    	全部商品
					    </c:if>
					    <c:if test="${item.productType==2}">
					    	${item.className}
					    </c:if>
					    <c:if test="${item.productType==3}">
					        <a><img src="${item.goodsImg50}"></a>
					        <span class="blockspan">货号：${item.goodsSn}</span>
					        <span class="blockspan">${item.goodsName}</span>
					    </c:if>
					</td>
					<td align="left">
					
					    <c:if test="${item.shopType==1}">
					    	全部区域
					    </c:if>
					    <c:if test="${item.shopType==2}">
					    	${item.cityName}
					    </c:if>
					    <c:if test="${item.shopType==3}">
					    	${item.shopName}
					    </c:if>
					</td>
					<c:forEach var="discount" items="${item.discountList}" varStatus="statuss">
					<td>
					    ${discount.discount}${discount.price}
					    <c:if test="${discount.discount!=null}">
					    [折扣]
					    </c:if>
					    <c:if test="${discount.price!=null}">
					    [金额]
					    </c:if>
					    <c:if test="${discount.price==null && discount.discount==null}">
					              未设置
					    </c:if>
					</td>
					</c:forEach>
					<td>
						<c:if test="${item.status==0}">
							<span class="spanuse" onclick="setActive('${item.levelCouponId}')" title="点击设置价格有效">有效</span><span class="spanuse noleft-border on">无效</span>
						</c:if>
						<c:if test="${item.status==1}">
							<span class="spanuse on">有效</span><span class="spanuse noleft-border" onclick="setNoActive('${item.levelCouponId}')"  title="点击设置价格无效">无效</span>
						</c:if>
					</td>
					<td>
						<button type="button" onclick="updateLevelCoupon('${item.levelCouponId}')" class="btn btn-danger btn-xs">修改</button>
						<button type="button" onclick="deleteLevelCoupon('${item.levelCouponId}')" class="btn btn-danger btn-xs">删除</button>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<nav class="navbar navbar-default select-control" >
			<%@include file="../common/common_page.jsp" %>	
		</nav>
	</form>
</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/levelDiscount/levelCoupon.js" type="text/javascript"></script>
</body>
</html>
