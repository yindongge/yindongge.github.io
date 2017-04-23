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
	<title>会员管理</title>
</head>

<body>
<div class="page-wrapper">
<div class="container-fluid">
	<form  class="form-inline" id ="pageform" name ="pageform" action="${ctx}/enterprise/list" method="post">
		<ul class="breadcrumb">
			<li>您的位置</li>
			<li ><a href="#">会员</a></li>
			<li class="active">企业会员</li>
		</ul>
		<div style="padding:10px;background:#f5f5f5;" style="">
			<div class="form-group">
				<label>注册时间：</label>
				<input class="form-control date" id="createTimeStart" name="createTimeStart" type="text" value='<fmt:formatDate value="${query.createTimeStart}" pattern="yyyy-MM-dd HH:mm:ss"/>' style="width:150px"/>
				至
				<input class="form-control date" id="createTimeEnd" name="createTimeEnd" type="text" value='<fmt:formatDate value="${query.createTimeEnd}" pattern="yyyy-MM-dd HH:mm:ss"/>' style="width:150px"/>				
			</div>
			<div class="form-group" style="margin-left:20px">
				<label>用户名：</label>
				<input class="form-control" name="userName" type="text" value="${query.userName}"/>			
			</div>
			<div class="form-group"style="margin-left:20px">
				<label>固定电话：</label>
				<input class="form-control" name="landlines" type="text"  value="${query.landlines}"/>
			</div>
	
			<br/>
			<div class="form-group" style="margin-top:10px">
				<label>公司名称：</label>
				<input class="form-control"  type="text" name="enterpriseNameLike" value="${query.enterpriseNameLike}" style="margin-left:0px;width:150px"/>
			</div>
			<div class="form-group" style="margin-top:10px;margin-left:5px">
				<label>店铺：</label>
				<select name="shopId" class="form-control" style="width:115px">
					<option value=""></option>
					<c:forEach items="${shopList}" var="shop" >
						<option value="${shop.shopId}" <c:if test="${shop.shopId==query.shopId}">selected</c:if>>${shop.shopName}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group" style="margin-left:20px;margin-top:10px;">
				<label>状&nbsp;&nbsp;&nbsp;&nbsp;态：</label>
				<select class="form-control" name="status" style="margin-left:0px;width:171px">
					<option value="">全部</option>
					<option value="0" <c:if test="${ query.status=='0' }">selected</c:if>>待审核</option>
					<option value="1" <c:if test="${ query.status=='1' }">selected</c:if>>审核通过</option>
					<option value="2" <c:if test="${ query.status=='2' }">selected</c:if>>审核不通过</option>
				</select>
			</div>
			<div class="form-group" style="margin-left:20px;margin-top:10px;">
			    <label>是否锁定：</label>
				<input type="radio" name="isLocked" value="0" <c:if test="${query.isLocked==0}">checked</c:if>/>未锁定
				<input type="radio" name="isLocked" value="1" <c:if test="${query.isLocked==1}">checked</c:if> style="margin-left:20px"/>锁定
				<button type="submit"  class="btn btn-info btn-sm" style="margin-left:80px">搜索</button>
			</div>
		</div>
		<div class="breadcrumb breadcrumb-title">企业会员列表<button type="button" class="btn btn-danger pull-right" onclick="doAdd()">新增企业会员</button></div>
		<table class="table table-hover table-bordered table-striped table-4">
			<thead>
				<tr class="info">
					<th width="90px">用户名</th>
					<th width="150px">公司名称</th>
					<th width="120px">注册时间</th>
					<th width="160px">店铺</th>
					<th width="120px">负责人</th>
					<th width="50px">状态</th>
					<th width="50px">是否锁定</th>
					<th style="width:200px;">操作</th>
				</tr>
			</thead> 
			<tbody>
				<c:forEach var="item" items="${page.content}" varStatus="status">
				<tr  class="icon11 zhekoutext">
					<td>${item.userName}</td>
					<td>${item.enterpriseName}</td>
					<td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>
						<select id="shop${item.enterpriseId}" style="width:100px;height:27px;margin-right:10px">
								<option value=""></option>
								<c:forEach items="${shopList}" var="shop" >
									<option value="${shop.shopId}" <c:if test="${shop.shopId==item.shopId}">selected</c:if>>${shop.shopName }</option>
								</c:forEach>
						</select><input style="width:50px" type="button" value="修改" onclick="doChangeShop('${item.enterpriseId}')"/>
					</td>
					<td><input type="text" id="contact${item.enterpriseId}" value="${item.shopContact}"/><input type="button" style="width:50px" value="修改" onclick="doChangeContact('${item.enterpriseId}')"/></td>
					<td>
					    <c:if test="${ item.status=='0'}">待审核</c:if>
					    <c:if test="${ item.status=='1'}">审核通过</c:if>
					    <c:if test="${ item.status=='2'}">审核不通过</c:if>
					</td>
					<td>
						<c:if test="${item.isLocked == '0'}">未锁定</c:if>
						<c:if test="${item.isLocked == '1'}">锁定</c:if>
					</td>
					<td>
					    <c:if test="${ item.status=='0' and item.isLocked == '0'}">
					        <button type="button" onclick="doEdit('${item.enterpriseId}')" class="btn btn-danger btn-xs">修改</button>
					        <button type="button" onclick="doPreCheck('${item.enterpriseId}')" class="btn btn-danger btn-xs">审核</button>
					        <button type="button" onclick="doDetail('${item.enterpriseId}')" class="btn btn-danger btn-xs">查看详情</button>
					    </c:if>
					    <c:if test="${ item.status=='1' and item.isLocked == '0'}">
					        <button type="button" onclick="doEdit('${item.enterpriseId}')" class="btn btn-danger btn-xs">修改</button>
					        <button type="button" onclick="doDetail('${item.enterpriseId}')" class="btn btn-danger btn-xs">查看详情</button>
					        <button type="button" onclick="doLock('${item.enterpriseId}')" class="btn btn-danger btn-xs">锁定</button>
					    </c:if>
					    <c:if test="${ item.status=='2' and item.isLocked == '0'}">
					        <button type="button" onclick="doEdit('${item.enterpriseId}')" class="btn btn-danger btn-xs">修改</button>
					        <button type="button" onclick="doPreCheck('${item.enterpriseId}')" class="btn btn-danger btn-xs">审核</button>
					        <button type="button" onclick="doDetail('${item.enterpriseId}')" class="btn btn-danger btn-xs">查看详情</button>
					    </c:if>
					    <c:if test="${ item.isLocked == '1'}">
					        <button type="button" onclick="doDetail('${item.enterpriseId}')" class="btn btn-danger btn-xs">查看详细</button>
					        <button type="button" onclick="doDisLock('${item.enterpriseId}')" class="btn btn-danger btn-xs">解除锁定</button>
					    </c:if>
					    <button type="button" onclick="doDelete('${item.enterpriseId}')" class="btn btn-danger btn-xs">删除</button>
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
<script src="${jsBase}/user/enterpriseList.js" type="text/javascript"></script>
</body>
</html>
