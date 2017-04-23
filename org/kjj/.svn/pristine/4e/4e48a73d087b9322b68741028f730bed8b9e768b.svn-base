<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<%@include file="../common/common_css.jsp" %>
<title>商品分类</title>
</head>
<body >	
<!--开始内容-->
	<div class="page-wrapper" >
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li>您的位置</li>
				<li ><a href="#">设置</a></li>
				<li class="active">菜单管理</li>
			</ul>
       <div class="icon1"> 
		   <button type="button" class="btn btn-danger btn-click" onclick="openlayer()">
				添加菜单
			</button>
		</div>

 	<table class="table table-striped table-bordered table-hover table-control ">
      <thead>
        <tr class="info text-center">
          <th class="tdfirst">菜单名称</th>
          <th>url</th>
            <th>编号</th>
          <th>是否启用</th>
          <th class="tdlast">操作</th>
        </tr>
      </thead>
      
      <c:forEach var="item" items="${list}" varStatus="status">
      		<tbody class="tabbody">
      			<tr class="taball">
      				<td class="tdfirst"><i class="<c:if test="${fn:length(item.modelList)>0 }">glyphicon glyphicon-plus-sign</c:if> "></i> ${item.modelname}</td>      				  
			          <td>${item.url}</td>
			          <td>${item.modelcode}</td>
			          <td>
			       		<c:if test="${item.isactive eq '1' }">启用</c:if>
			       		<c:if test="${item.isactive eq '0' }">停用</c:if>
			       		</td>
			          <td>
			          	<button type="button" onclick="editMenu(${item.modelid})" class="btn btn-danger btn-go">编辑</button>
			          	<c:if test="${empty item.modelList}">
			          	<button type="button" onclick="deleteMenu(${item.modelid})"  class="btn btn-danger btn-go ">删除</button>
			          	</c:if>
			          </td>
      			</tr>
      			<c:forEach var="item_1" items="${item.modelList}" varStatus="status">
	      			<tr class=" tab1" style="display: none" >
			          <td class="tdfirst tdcontrol1" ><i class="<c:if test="${fn:length(item_1.modelList)>0 }">glyphicon glyphicon-plus-sign</c:if>"></i>  ${item_1.modelname}</td>
			          <td>${item_1.url}</td>
			          <td>${item_1.modelcode}</td>
			       		<td>
			       		<c:if test="${item_1.isactive eq '1' }">启用</c:if>
			       		<c:if test="${item_1.isactive eq '0' }">停用</c:if>
			       		</td>
			          <td>
			          	<button type="button" onclick="editMenu(${item_1.modelid})" class="btn btn-danger btn-go">编辑</button>
			          	<button type="button" onclick="deleteMenu(${item_1.modelid})"  class="btn btn-danger btn-go ">删除</button>
			          </td>
			        </tr>
      			</c:forEach>
            </tbody>
		</c:forEach>
      <!--结束第一个tabbody-->
    </table>
     <!--分割线----结束第一个table--> 
</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/menu/list.js" type="text/javascript"></script>
</body>
</html>
