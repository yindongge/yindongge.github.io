<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<%@include file="../common/common_css.jsp"%>
<title>商品分类</title>
</head>
<body >	
<!--开始内容-->
	<div class="page-wrapper" >
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li>您的位置</li>
				<li ><a href="#">商品</a></li>
				<li class="active">分类管理</li>
			</ul>
	       <div class="icon1"> 
			   <button type="button" class="btn btn-danger btn-click" id="addBtn">
					添加分类
				</button>
			</div>
		 	<table class="table table-striped table-bordered table-hover table-control ">
		    	<thead>
			        <tr class="info text-center">
				        <th class="tdfirst">分类名称</th>
				        <th>排序</th>
				        <th>商品类型</th>
				        <th>菜单显示</th>
				        <th>高亮显示</th>
				        <th>数量单位</th>
				        <th>商品数量</th>
				        <th class="tdlast">操作</th>
			        </tr>
		      	</thead>      
		      <c:forEach var="item" items="${classes}" varStatus="status">      	
		      		<tbody class="tabbody">
		      			<tr class="taball">
		      				<td class="tdfirst"><i class="<c:if test="${fn:length(item.childrenList)>0 }">glyphicon glyphicon-plus-sign</c:if> "></i> ${item.className}</td>
		      				  <td>${item.classOrder}</td>
					          <td>${item.classOrder}</td>
					          <td>
				          		<c:choose>
				          			<c:when test="${item.classShowmenu == 1 }">是</c:when>
				          			<c:otherwise>否</c:otherwise>
				          		</c:choose>
					          </td>
					          <td>
				          		<c:choose>
				          			<c:when test="${item.classShowhighlight == 1 }">是</c:when>
				          			<c:otherwise>否</c:otherwise>
				          		</c:choose>
					          </td>
					          <td>${item.classQuantity}</td>
					          <td>${item.skuNum}</td>
					          <td>
					          	<input type="hidden" name="id" value="${item.classId }"/>
					          	<button type="button" name="editBtn" class="btn btn-danger btn-go">编辑</button>
					          	<button type="button" name="deleteBtn" class="btn btn-danger btn-go">删除</button>
					          </td>
		      			</tr>
		      			<c:forEach var="item_1" items="${item.childrenList}" varStatus="status">		      			
			      			<tr class="tab1" style="display: none" >
					          <td class="tdfirst tdcontrol1" ><i class="<c:if test="${fn:length(item_1.childrenList)>0 }">glyphicon glyphicon-plus-sign</c:if>"></i>  ${item_1.className}</td>
					          <td>${item_1.classOrder}</td>
					          <td>${item_1.classOrder}</td>
					          <td>
				          		<c:choose>
				          			<c:when test="${item_1.classShowmenu == 1 }">是</c:when>
				          			<c:otherwise>否</c:otherwise>
				          		</c:choose>
					          </td>
					          <td>
				          		<c:choose>
				          			<c:when test="${item_1.classShowhighlight == 1 }">是</c:when>
				          			<c:otherwise>否</c:otherwise>
				          		</c:choose>
					          </td>
					          <td>${item_1.classQuantity}</td>
					          <td>${item_1.skuNum}</td>
					          <td>
					          	<input type="hidden" name="id" value="${item_1.classId }"/>
					          	<button type="button" name="editBtn" class="btn btn-danger btn-go">编辑</button>
					          	<button type="button" name="deleteBtn" class="btn btn-danger btn-go">删除</button>
					          </td>
					        </tr>
					        <c:forEach var="item_2" items="${item_1.childrenList}" varStatus="status">					        
					        	<tr class="tab2" style="display: none">
						          <td class="tdfirst tdcontrol2" ><i class="glyphicon"></i>${item_2.className}</td>
						           <td>${item_2.classOrder}</td>
							          <td>${item_2.classOrder}</td>
							          <td>
						          		<c:choose>
						          			<c:when test="${item_2.classShowmenu == 1 }">是</c:when>
						          			<c:otherwise>否</c:otherwise>
						          		</c:choose>
							          </td>
							          <td>
						          		<c:choose>
						          			<c:when test="${item_2.classShowhighlight == 1 }">是</c:when>
						          			<c:otherwise>否</c:otherwise>
						          		</c:choose>
							          </td>
							          <td>${item_2.classQuantity}</td>
							          <td>${item_2.skuNum}</td>
							          <td>
							         	<input type="hidden" name="id" value="${item_2.classId }"/>
							          	<button type="button" name="editBtn" class="btn btn-danger btn-go">编辑</button>
							          	<button type="button" name="deleteBtn" class="btn btn-danger btn-go">删除</button>
							          </td>
						        </tr>					        
					        </c:forEach>				      				
		      			</c:forEach>
		      
		            </tbody>
			</c:forEach>		 
		      <!--结束第一个tabbody-->
		    </table>
     	<!--分割线----结束第一个table-->   
		</div>
	</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/class/list.js" type="text/javascript"></script>
</body>
</html>
