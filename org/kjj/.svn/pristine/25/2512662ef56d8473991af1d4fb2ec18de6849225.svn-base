<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>商品管理</title>
<%@include file="../common/common_css.jsp" %>
</head>
<body>
<div class="page-wrapper goods-control">
	<div class="container-fluid">
		<ul class="breadcrumb">
			<li>您的位置</li>
			<li ><a href="${ctx }/product/offSaleList">商品</a></li>
			<li class="active">商品管理</li>
		</ul>
		<div class="well well-control">
			<p  class="bg-warning">
				<span>商品状态提醒</span>
				<span>出售中的商品<i class="badge">${onSaleNum }</i></span>
				<span>未上架的商品<i class="badge">${offSaleNum }</i></span>
				<span>促销商品<i class="badge">0</i></span>
			</p>
		</div>
		<form class="form-inline" id="pageform" action="${ctx }/product/onSaleList" method="post">
		<div class="well" style="padding:5px;">
			<div class="form-group">
				<label >商品名称：</label>
				<input type="text" class="form-control" name="goodsNameLike" value="${query.goodsNameLike }"/>
			</div>
<!-- 			<div class="form-group">
				<label>价格：</label>
				<label>从</label>
				<input type="text" class="form-control"/>
				<label>到</label>
				<input type="text" class="form-control"/>
			</div> -->
			<div class="form-group">
				<label>一级分类：</label>
				<select class="form-control" name="classLevel1" id="classLevel1">
					<option value="-1">请选择分类</option>
					<c:forEach items="${classLevel1List }" var="item">
					<option value="${item.classId }" <c:if test="${item.classId == query.classLevel1 }">selected</c:if> >${item.className }</option>
					</c:forEach>
				</select>

			</div>
			<div class="form-group">
				<label>二级分类：</label>
				<select class="form-control" name="classLevel2" id="classLevel2">
					<option value="-1">请选择分类</option>
					<c:forEach items="${classLevel2List }" var="item">
					<option value="${item.classId }" <c:if test="${item.classId == query.classLevel2 }">selected</c:if> >${item.className }</option>
					</c:forEach>
				</select>
			</div>
			<br/>
			<div class="form-group">
				<label>商品货号：</label>
				<input type="text" class="form-control" name="goodsSn" value="${query.goodsSn }" />
			</div>
			<div class="form-group">
				<label>销量：</label>
				<label>从</label>
				<input type="text" class="form-control" name="saleNumStart" value="${query.saleNumStart }"/>
				<label>到</label>
				<input type="text" class="form-control" name="saleNumEnd" value="${query.saleNumEnd }"/>
			</div>
			<div class="form-group">
				<label>商品品牌：</label>
				<select class="form-control" name="brandId">
					<option value="-1">选择品牌</option>
					<c:forEach items="${brandList }" var="item">
					<option value="${item.productBrandId }" <c:if test="${item.productBrandId == query.brandId }">selected</c:if>>${item.productBrandName }</option>
					</c:forEach>
				</select>
			</div>
			<button type="submit" class="btn btn-info btn-sm ">搜索</button>
		</div>
		<div class="reverse-goods">
			<div class="btn-group">
				<a class="btn btn-primary" href="${ctx }/product/onSaleList">出售中的商品</a>
				<a class="btn btn-info" href="${ctx }/product/offSaleList">下架商品</a>
				<a class="btn btn-info">待审核商品</a>
			</div>
			<table class="table table-bordered table-hover ">
				<thead>
					<tr>
						<th class="icon12">商品名称</th>
						<th>售价（元）</th>
						<th>总库存量</th>
						<th>总销量</th>
						<th>发布时间</th>
						<th>操作</th>
					</tr>
					<tr class="icon8">
						<td colspan="6">
							<div class="checkbox-inline">
								<label>
									<input type="checkbox"  style="margin-top:2px;" name="checkAll" value="-1"/>全选
								</label>
							</div>
							<button type="button" class="btn btn-danger btn-xs" name="batchOffSaleBtn">下架</button>
							<!-- <button type="button" class="btn btn-danger btn-xs">删除</button> -->
						</td>
					</tr>
				</thead>
				<c:forEach items="${page.content }" var="item">
				<tbody class="margin-tbody">
					<tr class="space">
						<td colspan="6" style="border:none;"></td>
					</tr>
					<tr class="icon9">
						<td colspan="6">
							<div class="checkbox-inline">
								<label>
									<input type="checkbox" name="goodsIds"  style="margin-top:2px; " value="${item.goodsId }"/>
										商品货号：${item.goodsSn }
								</label>
							</div>
						</td>
					</tr>
					<tr class="icon11">
						<td class="icon11-td"><a ><img src="${item.goodsImg50 }"/></a>${item.goodsName }<i class='glyphicon glyphicon-pencil icon10'></i></td>
						<td></td>
						<td>${item.inventory }</td>
						<td>${item.saleNum }</td>
						<td><fmt:formatDate value="${item.onsaletime}" type="both"/></td>
						<td>
							<input type="hidden" name="spuId" value="${item.goodsId }"/>
							<button type="button" name="editBtn" class="btn btn-danger btn-xs">编辑商品</button>
							<button type="button" name="offSaleBtn" class="btn btn-danger btn-xs">下架</button>
						</td>
					</tr>
				</tbody>
				</c:forEach>
				<tfoot>
					<tr class="icon8">
						<td colspan="6">
							<div class="checkbox-inline">
								<label>
									<input type="checkbox"  style="margin-top:2px;" name="checkAll" value="-1"/>全选
								</label>
							</div>
							<button type="button" class="btn btn-danger btn-xs" name="batchOffSaleBtn">下架</button>
<!-- 							<button type="button" class="btn btn-danger btn-xs">删除</button>
							<button type="button" class="btn btn-danger btn-xs">设置促销</button> -->
						</td>
	
					</tr>
				</tfoot>
			</table>
			
			<nav class="navbar navbar-default select-control" >
				<%@include file="../common/common_page.jsp" %>	
			</nav>
		</div>
		</form>
	</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/product/onSaleList.js" type="text/javascript"></script>	
</body>
</html>
