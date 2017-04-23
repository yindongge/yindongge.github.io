<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
<title>商品类型</title>
<%@include file="../common/common_css.jsp" %>
</head>
<body>
	<form class="form-horizontal" id="addForm" action="${ctx}/productType/update" method="post" >
	<div class="page-wrapper">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li>您的位置</li>
				<li><a href="#">商品</a></li>
				<li><a href='${ctx }/productType/list'>类型管理</a></li>
				<li class="active">编辑类型</li>
			</ul>
			<div class="row">
				<div class="col-md-6">
						<div class="form-group">
							<input type="hidden" name="typeId" id="typeId" value="${productType.typeId }"/>
							<label for="" class="col-md-2 control-label">类型名称：</label>
							<div class="col-md-8">
								<input type="text" class="form-control" placeholder="名称" name="typeName" value="${productType.typeName }"></input>
							</div>
						</div>
						<div class="form-group">
							<label for="" class="col-md-2 control-label">排序：</label>
							<div class="col-md-8">
								<input type="text" class="form-control" placeholder="排序" name="typeOrder" value="${productType.typeOrder }"></input>

							</div>
						</div>
						<div class="form-group">
							<label for="" class="col-md-2 control-label">分组：</label>
							<div class="col-md-8">
								<input type="hidden" id="typeGroupHidden" value="${productType.groupId}"/>
								<select class="form-control" name="groupId" id="groupSelect">
									<option value="-1">选择分组</option>
									<c:forEach items="${groupList}" var="item">
										<option value="${item.groupId }" <c:if test="${productType.groupId == item.groupId}">selected</c:if>>${item.orgproductTypeGroupName }</option>
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
						<td><input type="checkbox" value="${saleSpec.specId }" name="specId" id="specCheckBox${saleSpec.specId }" <c:if test="${saleSpec.checked }">checked</c:if>></input></td>
						<td>${saleSpec.specName }</td>
						<td>${saleSpec.valuesStr}</td>
					</tr>
				</c:forEach>
			</table>
			<div class="breadcrumb breadcrumb-title">添加属性</div>
			<table id="propertyTable" class="table table-bordered table-hover borded-striped table-control">
				<thead>
					<tr class="info text-center">
						<th><input type="checkbox" id="checkAll"/></th>
						<th>排序</th>
						<th>属性名称</th>
						<th>录入方式</th>
						<th>是否必选</th>
						<th class="length">属性值</th>
						<th>操作</th>
					</tr>
				</thead>
				<c:forEach items="${productPropertyList }" var="property">
					<tr id="rowItemedit${property.propertyId }" class="rowItem">
						<td><input type="checkbox" id="itemCheckBox1" name="propertyCheckbox"></input></td>
						<td><input type="hidden" name="propertyOrder" value="${property.propertyOrder }"/><span>${property.propertyOrder }</span></td>
						<td><input type="hidden" name="propertyName" value="${property.propertyName }"/><span>${property.propertyName }</span></td>
						<td><input type="hidden" name="propertyInputType" value="${property.propertyInputType }"/>
							<span>
								<c:choose>
									<c:when test="${property.propertyInputType==1 }">手动输入</c:when>
									<c:when test="${property.propertyInputType==2 }">单选组</c:when>
									<c:when test="${property.propertyInputType==3 }">列表单选</c:when>
									<c:when test="${property.propertyInputType==4 }">复选组</c:when>
								</c:choose>
							</span>
						</td>
						<td><input type="hidden" name="propertySelect" value="${property.propertySelect }"/><span>${property.propertySelect==1?'是':'否' }</span></td>
						<td><input type="hidden" name="propertyValue" value="${property.propertyValuesStr }"/><span>${property.propertyValuesStr }</span></td>
						<td>
							<button type="button" 	class="btn btn-danger btn-go btn2-click" onclick="modifyProperty(${property.propertyId });">编辑</button>
							<button type="button"  class="btn btn-danger btn-go " onclick="deleteProperty(${property.propertyId });">删除</button>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class="modal-footer pull-left">
				<button type="button" class="btn btn-primary btn-sm" id="deleteItem">删除</button>
				<button type="button" class="btn btn-primary btn-sm " id="addItemBotton" onclick="addProperty();">增加一条属性</button>
			</div>
		</div>
		<div class="text-center">
			<input type="hidden" id="rowItemId"/>
			<button type="button" class="btn btn-primary " onclick="history.go(-1);">取消</button>
			<input type="submit" class="btn btn-primary " value="确定"/>
		</div>
	</div>
	</form>
	<input type="hidden" id="typeValueHidden" value="${specs}"/>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/productType/edit.js" type="text/javascript"></script>	
</body>
</html>