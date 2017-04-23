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
<title>菜品管理</title>
</head>

<body>
<div class="page-wrapper goods-control">
<div class="container-fluid">
	<form  class="form-inline" id ="pageform" name ="pageform" action="${ctx}/meal/list" method="post">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">外卖</a></li>
		<li class="active">菜品管理</li>
	</ul>
	<div class="well well-price" style="margin:10px 0px 10px 0px">
		<p class="fontweight">在编辑菜品的库存和价格前，请先将门店列切换到您所在的门店</p>
	</div>
	<div style="padding:10px;background:#f5f5f5;" style="">
		<div class="form-group" style="margin-top:10px">
			<label>菜品编码：</label>
			<input class="form-control"  type="text" name="goodsSn" id="goodsSn" value="${query.goodsSn}" style="margin-left:15px;width:150px"/>
		</div>
		<div class="form-group" style="margin-top:10px">
			<label>菜品名称：</label>
			<input class="form-control"  type="text" name="goodsName" value="${query.goodsName}" style="margin-left:15px;width:150px"/>
		</div>
		<div class="form-group" style="margin-left:20px">
			<label>菜品分类：</label>
			<select class="form-control" name="classId" style="margin-left:32px;width:150px">
				<c:forEach items="${classList}" var="item">
					<option value="${item.classId}" <c:if test="${query.classId==item.classId}">selected</c:if>>${item.className}</option>
				</c:forEach>
			</select>
		</div>
		<button type="submit"  class="btn btn-info btn-sm" style="margin-left:80px">搜索</button>
	</div>
	
	<div class="breadcrumb breadcrumb-title">菜品管理<button type="button" class="btn btn-danger pull-right" onclick="editStockClearConfig()">设置自动清库存</button></div>
	
	<table  class="table table-hover table-bordered table-striped table-4">
		<thead>
			<tr class="info">
				<th>序号</th>
				<th>菜品(SKU)编码</th>
				<th width="200px">菜品名称</th>
				<th>菜品分类</th>
				<th>
				    <select class="form-control" name="shopCode" id="shopCode">
						<c:forEach items="${shopList}" var="item">
							<option value="${item.shopCode}" <c:if test="${query.shopCode==item.shopCode}">selected</c:if>>${item.shopName}</option>
						</c:forEach>
					</select>
				</th>
				<th>库存</th>
				<th>价格</th>
				<th>本店状态</th>
				<th style="width:50px;">操作</th>
			</tr>
		</thead> 
		<tbody>
			<c:forEach var="item" items="${inventoryList}" varStatus="status">
			<tr>
			    <td>${status.index + 1}</td>
				<td>${item.goodsSn}</td>
				<td>${item.goodsName}</td>
				<td>${item.className}</td>
				<td>${item.shopName}</td>
				<td>
					<input class="form-control" title="内容必须为整数" type="text" id="stockNum${status.index + 1}" oldvalue="${item.shopAmount}" value="${item.shopAmount}" style="width:100px" onkeyup="if(isNaN(value))execCommand('undo')" onafterpaste="if(isNaN(value))execCommand('undo')" maxlength="10"/><button type="button" itemid="${item.id}" onclick="editStockOrPrice('${item.id}','${status.index + 1}','1','stockNum${status.index + 1}')" class="btn btn-danger btn-xs">修改</button>
				</td>
				<td>
					<input class="form-control" title="内容必须保留两位小数" type="text" id="price${status.index + 1}" oldvalue="${item.sellPrice}" value="${item.sellPrice}" style="width:100px" onkeyup="if(isNaN(value))execCommand('undo')" onafterpaste="if(isNaN(value))execCommand('undo')" maxlength="10"/><button type="button" itemid="${item.id}" onclick="editStockOrPrice('${item.id}','${status.index + 1}','2','stockNum${status.index + 1}')" class="btn btn-danger btn-xs">修改</button> 
				</td>
				<td>
					 <!-- 默认可以销售，0为可以销售  -->
					<c:if test="${empty item.status or item.status eq 0}">
						销售中
					</c:if>
					<c:if test="${item.status eq 1}">
						已禁售
					</c:if>
				</td>
				<td width="150px" data-id="${item.opssId}" data-inventoryId="${item.id}">
				    <!-- 默认可以销售，0为可以销售  -->
					<button style='display:<c:if test="${empty item.status or item.status eq 0}">inline</c:if> <c:if test="${item.status eq 1}">none</c:if>' type="button"  class="btn btn-danger btn-xs offsale">禁售</button>
					<button style='display:<c:if test="${empty item.status or item.status eq 0}">none</c:if> <c:if test="${item.status eq 1}">inline</c:if>' type="button"  class="btn btn-success btn-xs onsale">启售</button>
					<button type="button" onclick="editZero(${item.id})" class="btn btn-danger btn-xs">卖光了</button>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</form>
</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/meal/mealList.js" type="text/javascript"></script>
</body>
</html>
