<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
<title>商品类型</title>
<%@include file="../common/common_css.jsp" %>
</head>
<body>
	<form class="form-horizontal" id="addForm" action="${ctx}/productType/save" method="post" onsubmit="return validatePropertyTable();">
	<div class="page-wrapper">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li>您的位置</li>
				<li><a href="#">商品</a></li>
				<li><a href='${ctx }/productType/list'>类型管理</a></li>
				<li class="active">添加类型</li>
			</ul>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="" class="col-md-2 control-label">类型名称：</label>
						<div class="col-md-8">
							<input type="text" class="form-control" placeholder="名称" name="typeName" ></input>
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-md-2 control-label">排序：</label>
						<div class="col-md-8">
							<input type="text" class="form-control" placeholder="排序" name="typeOrder" ></input>
	
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-md-2 control-label">分组：</label>
						<div class="col-md-8">
							<select class="form-control" name="groupId" >
								<option value="">选择分组</option>
								<c:forEach items="${groupList}" var="item">
									<option value="${item.groupId }">${item.orgproductTypeGroupName }</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
			</div>
			<!--分割线-->
			<div class="breadcrumb breadcrumb-title">选择销售规格</div>			
			<table class="table table-bordered table-hover borded-striped table-control" style="margin-bottom: 20px">
				<thead>
					<tr class="info text-center">
						<th></th>
						<th class="length1">规格名称</th>
						<th>规格值</th>
					</tr>
				</thead>
				<c:forEach items="${saleSpecList }" var="saleSpec">
					<tr>
						<td><input type="checkbox" value="${saleSpec.specId }" name="specId"></input></td>
						<td>${saleSpec.specName }</td>
						<td>${saleSpec.valuesStr}</td>
					</tr>
				</c:forEach>
			</table>
			<div class="breadcrumb breadcrumb-title">添加属性</div>
			<table id="propertyTable" class="table table-bordered table-hover borded-striped table-control">
				<thead>
					<tr class="info text-center">
						<th><input type="checkbox" id="checkAll"></input></th>
						<th>排序</th>
						<th>属性名称</th>
						<th>录入方式</th>
						<th>是否必选</th>
						<th class="length">属性值</th>
						<th>操作</th>
					</tr>
				</thead>
				<tr id="rowItem1">
					<td><input type="checkbox" id="itemCheckBox1" name="propertyCheckbox"></input></td>
					<td><input type="hidden"  name="propertyOrder" value="" /><span ></span></td>
					<td><input type="hidden"  name="propertyName" value=""/><span></span></td>
					<td><input type="hidden"  name="propertyInputType" value="1"/><span></span></td>
					<td><input type="hidden"  name="propertySelect" value="1"/><span></span></td>
					<td><input type="hidden"  name="propertyValue" value=""/><span></span></td>
					<td>
						<button type="button" href="#"	class="btn btn-danger btn-go btn2-click" onclick="modify(this);">编辑</button>
						<button type="button" href="#" class="btn btn-danger btn-go " onclick="removeItem(this);">删除</button>
					</td>
				</tr>
			</table>
			<div class="modal-footer pull-left">
				<button type="button" class="btn btn-primary btn-sm" id="deleteItem">删除</button>
				<button type="button" class="btn btn-primary btn-sm " id="addItemBotton">增加一条属性</button>
			</div>

		</div>
		<div class="text-center">
			<input type="hidden" id="rowItemId"/>
			<button type="button" class="btn btn-primary " onclick="history.go(-1);">取消</button>
			<input type="submit" class="btn btn-primary " value="确定"/>
		</div>
	</div>
	</form>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/productType/add.js" type="text/javascript"></script>	
</body>
</html>