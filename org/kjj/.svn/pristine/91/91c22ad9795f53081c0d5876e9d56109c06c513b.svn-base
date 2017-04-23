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
<!-- <link href="css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />  -->
<title>帮助分类</title>
</head>

<body >	
<!--开始内容-->
	<div class="page-wrapper" >
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li>您的位置</li>
				<li ><a href="#">帮助中心</a></li>
				<li class="active">分类</li>
			</ul>
       <div class="icon1"> 
		   <button type="button" class="btn btn-danger btn-click" onclick="openlayer()">
				添加分类
			</button>
		</div>
 <table class="table table-striped table-bordered table-hover table-control ">
      <thead>
        <tr class="info text-center">
          <th width="30%">名称</th>
          <th width="40%">排序</th>

          <th class="tdlast" width="30%">操作</th>
        </tr>
      </thead>
      <tbody class="tabbody">
   		<c:forEach items="${classList}" var ="class0">
			<c:if test="${! empty class0}">      	
				<tr class="taball">
      				<td class="tdfirst"><i class="<c:if test="${class0.listSubClass.size()>0 }">glyphicon glyphicon-plus-sign</c:if>"></i> ${class0.className}</td>
			          <td>${class0.order}</td>
			        <td><button type="button" onclick="editclass(${class0.id})" class="btn btn-danger btn-go">编辑</button><button type="button" onclick="deleteclass(${class0.id})"  class="btn btn-danger btn-go ">删除</button></td>
      			</tr>
				<c:forEach items="${class0.listSubClass}" var ="class1">
					<c:if test="${! empty class1}">      	
					  <tr class=" tab1" style="display:none" >
				          <td class="tdfirst tdcontrol1" ><i class="<c:if test="${class1.listSubClass.size()>0}">glyphicon glyphicon-plus-sign</c:if>"></i>${class1.className}</td>
				          <td>${class1.order}</td>
				          <td><button type="button" onclick="editclass(${class1.id})" class="btn btn-danger btn-go">编辑</button><button type="button" onclick="deleteclass(${class1.id})"  class="btn btn-danger btn-go ">删除</button></td>
			  	      </tr>
					  <c:forEach items="${class1.listSubClass}" var ="class2" varStatus="status2">
	 						<c:if test="${! empty class2}">      	
								<tr class="tab2" style="display: none">
						          <td class="tdfirst tdcontrol2" ><i class="glyphicon"></i>${class2.className}</td>
					          	  <td>${class2.order}</td>
						          <td><button type="button" onclick="editclass(${class2.id})" class="btn btn-danger btn-go">编辑</button><button type="button" onclick="deleteclass(${class2.id})" class="btn btn-danger btn-go ">删除</button></td>
								</tr>
	 						</c:if>
					  </c:forEach>
					</c:if>
				</c:forEach>
	      	</c:if>
		</c:forEach>
     </tbody> 
      <!--结束第一个tabbody-->
    </table>
     <!--分割线----结束第一个table--> 
</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/article/classlist.js" type="text/javascript"></script>
</body>
</html>
