<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
	<%@include file="../common/common_css.jsp"%>
	<title>用户管理</title>
</head>
 
<body>
<div class="box">
	<div class="container-fluid">
		<form action="${ctx}/qrcodeuser/userlist" class="form-inline" id="pageform_select" name="pageform_select" method="post">
			<div class="well form-well">
				<div class="form-group">
					<label for="">用户名：</label>
					<input type="text" class="form-control" name="username"  value="${query.username}"/>
				</div>
				<div class="form-group">
					<label for="">姓名：</label>
					<input type="text" class="form-control" name="userrealname" value="${query.userrealname}"/>
				</div>
				<div class="form-group">
					<button class="btn btn-info">查询</button>
				</div>
			</div>
		</form>
		<div class="head-tip">
			<ul class="breadcrumb">
			  <li>您的位置</li>
			  <li class="active">用户管理</li>
			</ul>
		</div>
		<div class="btn-group">
			<button type="button" class="btn btn-info" onclick="toadduser()">新增</button> 
			<button class="btn btn-primary" onclick="deletebyid()">删除</button>
		</div>
		<div class="table table-control">
		 <form action="" class="form-inline" id="pageform_table" name="pageform_table">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th style="width:50px;"><input type="checkbox" id="qx"  ></th>
						<th>序号</th>
						<th>用户名</th>
						<th>姓名</th>
						<th>角色</th>
						<th>手机号码</th>
						<th>创建时间</th>
						<th style="width:150px;">操作</th>
					</tr>
				</thead>
				<tbody>
					  <c:forEach items="${page.content}" var="item" varStatus="var">
						<tr>
							<td class="text_center"><input type="checkbox" name="check" value="${item.userid}" ></td>
							<td class="text_center">${var.index+1}</td>
							<td>${item.username}</td>
							<td>${item.userrealname}</td>
							<td> </td>
							<td>${item.mobile}</td>
							<td class="text_center"><fmt:formatDate value="${item.addtime}" pattern="yyyy-MM-dd"/>  </td>
							<td> 
								<button type="button" class="btn btn-success btn-xs"    onclick="toDetail('${item.userid}')">查看</button>
							    <button  type="button" class="btn btn-info btn-xs"  onclick="toEditDetail('${item.userid}')" >修改</button>
							    <button type="button" class="btn btn-danger btn-xs" onclick="deleteone('${item.userid}')">删除</button>
							</td>
						</tr>
					
					</c:forEach>  
				</tbody>
			</table>
			
			<%-- <nav class="navbar navbar-default select-control" >
			<%@include file="../common/common_page.jsp" %>	
		    </nav> --%> 
		    
		 	</form>
		</div>
	   
	   <div class="pageselect">
			<div class="navbar-form navbar-right" role="search">
				<div class="form-group">
					<select  class="form-control">
						<option value="">1</option>
					</select>
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="到第几页">
				</div>

				<button type="submit" class="btn btn-sm btn-info">确定</button>
			</div>
			<ul class="pagination pull-right pagination-sm">
				<li>
				  <a href="#" aria-label="Previous">
					<span aria-hidden="true">«</span>
				  </a>
				</li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">.....</a></li>
				<li><a href="#">15</a></li>
				<li>
				  <a href="#" aria-label="Next">
					<span aria-hidden="true">»</span>
				  </a>
				</li>
			 </ul>
		 	<span class=" pull-right">共有200条记录 每页50条<i class="glyphicon glyphicon-repeat"></i></span>
		</div>
	</div>
  
 <%@include file="../common/common_js.jsp"%> 
<script src="${jsBase}/user/user.js" type="text/javascript"></script> 

</body>
</html>
