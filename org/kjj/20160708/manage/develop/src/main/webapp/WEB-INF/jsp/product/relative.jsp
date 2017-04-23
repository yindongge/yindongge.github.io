<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>品牌管理</title>
<%@include file="../common/common_css.jsp" %>
</head>
<body >
<div class="page-wrapper">
	<div class="container-fluid">
		<ul class="breadcrumb">
			<li>您的位置</li>
			<li ><a href="${ctx }/product/offSaleList">商品</a></li>
			<li ><a href="#">品牌管理</a></li>
			<li class="active">添加品牌</li>
		</ul>
		<div class="btn-group btn-group-justified" role="group" aria-label="Justified button group">
		   	<a href="添加商品.html" class="btn btn-info " role="button">基本信息</a>
		  	<a href="详情描述.html" class="btn btn-info" role="button">SKU信息</a>
			<a href="相关商品.html" class="btn btn-primary" role="button">相关商品</a>
			<a href="其他信息.html" class="btn btn-info" role="button">其他信息</a>
    	</div>
		<hr>
		<form class="form-inline long text-center" >
		<div class="form-group">
			分类级别
			<select class="form-control" onchange="changeSelect()" id="classLevel">
				<option value="0">所有级别</option>
						<c:forEach var="item" items="${level}" varStatus="status">
							<option value="${item.class_level_id }">${item.class_levelName}</option>
						</c:forEach>
			</select>
		</div>
		<div class="form-group">
			分类
			<select class="form-control" id="classlist" name="classlist">
				<option value="0">所有分类</option>
			</select>
		</div>
		<div class="form-group">
			<select class="form-control" id="brand" name="brand">
				<option value="0">所有品牌</option>
				<c:forEach var="o" items="${ob}" varStatus="status">
					<option value="${o.product_brand_id }">${o.product_brand_name}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<input type="text" class="form-control" id="s_text" name="s_text" placeholder="请输入货号或商品名称"></input>
		</div>
		<button type="button" onclick="search()" class="btn btn-info">搜索</button>
		
		<p class="form-group" ><i class="glyphicon glyphicon-pushpin"></i> 一品多款的关联销售，关联后将出现在商品详情主图的右侧，做为款式规格选择</p>
		</form>
		<div class="row option2-control">
			<div class="col-sm-5 ">
				<select multiple class="form-control " id="leftselect" name="leftselect">
					 
				</select>
			</div>
			<div class="col-sm-2">
				<button type="button" id="add" class="btn btn-success btn-block">添加关联 <i class="glyphicon glyphicon-arrow-right"></i></button>
				<button type="button" id="remove"  class="btn btn-danger btn-block"><i class="glyphicon glyphicon-arrow-left"></i> 删除关联</button>
			</div>
			<div class="col-sm-5">
				<select multiple class="form-control " id="rightselect" name="rightselect">
					 <c:forEach items="${orgProductList }" var="orgProduct">
					 	<option value="${orgProduct.goods_id }">[${orgProduct.goods_sn }]${orgProduct.goods_name }</option>
					 </c:forEach>
				</select>
			</div>
		</div>
		</hr>
		<div class="text-center">
			<button type="button" class="btn btn-primary " onclick ="save()">保存</button>
		</div>
	</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/common/ajaxfileupload.js" type="text/javascript"></script>
<script src="${jsBase}/product/relative.js" type="text/javascript"></script>
</body>
</html>
