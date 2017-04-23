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
	<form  class="form-inline" id ="pageform" name ="pageform" action="${ctx}/levelprice/commlevel" method="post">
		<ul class="breadcrumb">
			<li>您的位置</li>
			<li ><a href="#">运营</a></li>
			<li ><a href="#">价格体系</a></li>
			<li class="active">一体化价格</li>
		</ul>
		<div class="well well-price" style="padding:5px;">
			<p class="fontweight">备注：</p>
			<p>【一体化价格】由瑞星系统设置，线上可设定是否有效，如无效则线上不执行该会员价格；</p>
			<p>【电商价格】是为线上独立设置的会员价格体系，线下不做同步；</p>
			<p>&nbsp;电商会员价格权重高于一体化价格。</p>
		</div>
		<br/>
		<div style="padding:10px;height:50px;background:#f5f5f5;">
			<div class="col-sm-12">
				<div class="form-group">
					<label>商品名称：</label>
					<input type="text" class="form-control" name="goodsName" value="${query.goodsName}"/>			
				</div>
				<div class="form-group">
					<label>商品货号：</label>
					<input type="text" class="form-control" name="goodsSn" value="${query.goodsSn}"/>			
				</div>
				<button type="submit" class="btn btn-danger">搜索</button>
			</div>
		</div>
		<div class="breadcrumb breadcrumb-title">一体化会员价格</div>
		<table class="table table-hover table-bordered table-striped table-4">
			<thead>
				<tr class="info">
					<th class="w200">商品货号</th>
					<th >商品名称</th>
					<c:forEach var="level" items="${userLevels}" varStatus="status">
					<th>${level.levelName}折扣</th>
					</c:forEach>
					<th>线上是否有效</th>
					<th style="width:100px;">操作</th>
				</tr>
			</thead> 
			<tbody>
				<c:forEach var="item" items="${page.content}" varStatus="status">
				<tr  class="icon11 zhekoutext">
					<td>${item.goodsSn}</td>
					<td align="left"><img src="${item.goodsImg50}" id="autoBigImg"></img>${item.goodsName}</td>
					<c:forEach var="level" items="${userLevels}" varStatus="status">
					<th>${level.discount}</th>
					</c:forEach>
					<td>
						<c:if test="${item.id==null}">
							<span class="spanuse" onclick="setActive('${item.goodsId}')" title="点击设置价格有效">有效</span><span class="spanuse noleft-border on">无效</span>
						</c:if>
						<c:if test="${item.id!=null}">
							<span class="spanuse on">有效</span><span class="spanuse noleft-border" onclick="setNoActive('${item.id}')"  title="点击设置价格无效">无效</span>
						</c:if>
					</td>
					<td>
						<button type="button" onclick="queryGoodsLevel('${item.goodsSn}')" class="btn btn-danger btn-xs">查看</button>
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
<script src="${jsBase}/levelDiscount/commLevel.js" type="text/javascript"></script>
</body>
</html>
