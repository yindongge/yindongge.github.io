<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
<title>热门推荐</title>
<%@include file="../common/common_css.jsp"%>
</head>
<body>
	<div class="page-wrapper">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li>您的位置</li>
				<li ><a href="#">商品</a></li>
				<li ><a href='#'>热门推荐</a></li>
				<li class="active">添加</li>
			</ul>

	<form id="pageform" action="${ctx }/advertisement/add" method="post">
		<input type="hidden" name="skuId"/>
		<input type="hidden" name="pageNow" value="${page.number }"/>
		<div class="row">
			<div class="col-md-6">
				<div class="form-horizontal">
					<div class="form-group">
						<label for="" class="col-md-2 control-label">一级分类：</label>
						<div class="col-md-8">
							<select class="form-control" name="classLevel1" id="classLevel1">
								<option value="-1">默认</option>
								<c:forEach items="${classLevle1List}" var="item">
									<option value="${item.classId }" <c:if test="${item.classId == advertisementQuery.classLevel1}">selected="selected"</c:if>>${item.className }</option>									
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-md-2 control-label">二级分类：</label>
						<div class="col-md-8">
							<select class="form-control" name="classLevel2" id="classLevel2">
								<option value="-1">请选择</option>
								<c:forEach items="${classLevle2List}" var="item">
									<option value="${item.classId }" <c:if test="${item.classId == advertisementQuery.classLevel2}">selected="selected"</c:if>>${item.className }</option>									
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-md-2 control-label">类型：</label>
						<div class="col-md-8">
							<select class="form-control" name="typeId" id="typeId">
								<option value="-1">请选择</option>
								<c:forEach items="${advertisementTypeList }" var="item">
									<option value="${item.advertisementTypeId }" <c:if test="${item.advertisementTypeId == advertisementQuery.typeId }">selected="selected"</c:if>>${item.advertisementTypeName }</option>										
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
			</div>
		</div>
		
<!--分割线-->
		<div class="form-inline long text-center">
			<span>商品名称：</span>
			<div class="form-group">
				<input type="text" class="form-control" name="goodsNameLike" value="${query.goodsNameLike }"/>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-sm ">
				搜索
				</button>
			</div>
		</div>
		<div class="breadcrumb breadcrumb-title">选择推荐商品</div>
		<table class="table table-bordered table-hover borded-striped table-control"  style="margin-bottom:20px">
			<thead>
				<tr class="info text-center">
					<th >商品货号</th>
					<th >商品名称</th>
					<th >品牌</th>
					<th >图片</th>
					<th >状态</th>
					<th >操作</th>
				</tr>
			</thead>
			<c:forEach items="${page.content }" var="item">
				<tr>
					<td>${item.goodsSn}</td>
					<td>${item.goodsName}</td>
					<td>${item.productBrandName}</td>
					<td><img height="40" src="${item.goodsImg50}"></img> </td>
					<td>
						<c:if test="${ item.productIsOnSale==1}">
							上架
						</c:if>
						<c:if test="${ item.productIsOnSale==0}">
							下架
						</c:if>
					</td>
					<td>
						<c:if test="${ item.productIsOnSale==1}">
							<button type="button" class="btn btn-danger btn-xs" onclick="add(${item.goodsId})">添加推荐</button>
						</c:if>
						<c:if test="${ item.productIsOnSale==0}">
							<button type="button" class="btn btn-xs" >添加推荐</button>
						</c:if>
					</td>
				</tr>
			</c:forEach>

		</table>
		<nav class="navbar navbar-default select-control" >
			<%@include file="../common/common_page.jsp" %>	
		</nav>
		<div class="breadcrumb breadcrumb-title">已选推荐商品</div>
		<table class="table table-bordered table-hover borded-striped table-control">
			<thead>
				<tr class="info text-center">
					<th >商品货号</th>
					<th >商品名称</th>
					<th >品牌</th>
					<th >图片</th>
					<th >状态</th>
					<th >操作</th>
				</tr>
			</thead>
			<tr>
			</tr>
		</table>
		</form>
	</div>	
	<div class="text-center">
			<button type="button" class="btn btn-primary " onclick="window.location.href='${ctx}/advertisement/list'">返回</button>
	</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/advertisement/add.js" type="text/javascript"></script>
</body>
</html>