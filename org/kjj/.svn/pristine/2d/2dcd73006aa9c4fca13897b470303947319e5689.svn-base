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
<title>评价管理</title>
</head>

<body>
<div class="page-wrapper goods-control">
<div class="container-fluid">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">交易</a></li>
		<li class="active">评价管理</li>
	</ul>
	<form  class="form-inline" id ="pageform" name ="pageform" action="${ctx}/comment/list" method="post">
	<div class="well" style="padding:5px;">
		<div class="form-group">
			<label>评论内容：</label>
			<input type="text" class="form-control" style="width:300px;" name="goodsCommentLike" value="${ query.goodsCommentLike }"/>			
		</div>
		
		<div class="form-group">
			<label>处理状态：</label>
			<select name="status">
				<option value="-1" <c:if test="${ query.status=='-1' }">selected</c:if>>全部</option>
				<option value="0" <c:if test="${ query.status=='0' }">selected</c:if>>显示</option>
				<option value="1" <c:if test="${ query.status=='1' }">selected</c:if>>隐藏</option>
			</select>
		</div>
		
		<div class="form-group">
			<label>回复状态：</label>
			<select name="replyStatus">
				<option value="-1" <c:if test="${ query.replyStatus=='-1' }">selected</c:if>>全部</option>
				<option value="0" <c:if test="${ query.replyStatus=='0' }">selected</c:if>>未回复</option>
				<option value="1" <c:if test="${ query.replyStatus=='1' }">selected</c:if>>已回复</option>
			</select>
		</div>
	
		<button type="submit" class="btn btn-danger">搜索</button>
		</div>
	<br/>

	<table class="table table-hover table-bordered ">
		<thead>
			<tr>
				<th>用户名</th>
				<th>商品</th>
				<th style="width:300px;">商品评论</th>
				<th>评论时间</th>
				<th>处理状态</th>
				<th>回复状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${page.content}" varStatus="status">
			<tr>
				<td><input type="hidden" name="ids" value="${ item.id }"/>${ item.userName }</td>
				<td>${ item.goodsName }</td>
				<td title="${ item.goodsComment }">
					<div class="o-control">${ item.goodsComment }</div>
				</td>
				<td><fmt:formatDate value="${item.createTime}" type="both"/></td>
				<td>
					<c:if test="${ item.status == 0 }">显示</c:if>
					<c:if test="${ item.status == 1 }">隐藏</c:if>
				</td>
				<td>
					<c:if test="${ item.replyStatus == 0 }">未回复</c:if>
					<c:if test="${ item.replyStatus == 1 }">已回复</c:if>
				</td>
				<td>	
					<button type="button" class="btn btn-danger btn-xs" name="detail">查看详情</button>
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
<script src="${jsBase}/comment/list.js" type="text/javascript"></script>
</body>
</html>
