<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
<title>商品分类</title>
<%@include file="../common/common_css.jsp"%>

</head>
<body>	
<div class="page-wrapper goods-control">
<div class="container-fluid">
<form action="${ctx}/article/save" method="post" id="form" name="form" enctype="multipart/form-data">
	<input type="hidden" id="shops" name="shops" value=""></input>
	<ul class="breadcrumb">
	
		<li>您的位置</li>
		<li ><a >文章</a></li>
		<li ><a >文章管理</a></li>
		<li class="active">添加文章</li>
	</ul>
	
	</br>
		<button type="button" class="btn btn-danger">添加文章</button>
	<button type="button" class="btn btn-default" disabled="true" style="font-weight:600">文章内容</button>

	<table class="table table-hover table-bordered ">
<!-- 		<thead>
			<tr>
				<th>  用户名</th>
				<th>角色</th>
				<th>邮箱</th>
				<th>加入时间</th>
				<th>最后登录时间</th>
				<th width="300px;">操作</th>
			</tr>
			
		</thead> -->
		<tbody>
			<tr>
				<td class="c-length1"><span class="red">*</span>文章标题：</td>
				<td class="c-length2">
					<input type="text" id="title" name="title" placeholder="2-10 长度字符！" />
					<!-- <a class="color-kuai"></a> -->
				</td>		
			</tr>
			<tr>
				<td class="c-length1">文章副标题：</td>
				<td class="c-length2">
					<input type="text" id="subtitle" name="subtitle" placeholder="支付流程" />
					<!-- <a class="color-kuai"></a> -->
				</td>		
			</tr>
			<tr>
				<td class="c-length1">文章头图：</td>
				<td class="c-length2">
							<span class="glyphicon glyphicon-folder-open" onclick ="document.getElementById('file').click()"></span>	

							<div id="div_1">
										<img  id="showimg_1" name="showimg_1" height="30"></img>
							</div>		
									
							<input type="file" name="file" id="file" style="position:absolute; top:0; right:0; height:24px; filter:alpha(opacity:0);opacity: 0;width:20px" />			
				</td>		
			</tr>
			<tr>
				<td class="c-length1"><span class="red">*</span>文章分类：</td>
				<td class="c-length2">
					
				<select  id="articleClass" name="classid">
					<c:forEach items="${classList}" var ="class0" varStatus="status0">
						<c:if test="${! empty class0}">      	
      						<option value="${class0.id}">${status0.index+1} ${class0.className}</option>
      						<c:forEach items="${class0.listSubClass}" var ="class1" varStatus="status1">
	      						<c:if test="${! empty class1}">      	
	      							<option value="${class1.id}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${status0.index+1} .${status1.index+1} ${class1.className}</option>
	      							 <c:forEach items="${class1.listSubClass}" var ="class2" varStatus="status2">
			      						<c:if test="${! empty class2}">      	
			      							<option value="${class2.id}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${status0.index+1} .${status1.index+1} .${status2.index+1} ${class2.className}</option>
			      						</c:if>
		      						</c:forEach>
	      						</c:if>
      						</c:forEach>
				      	</c:if>
					</c:forEach>
				</select>	
				
				<button type="button" class="btn btn-danger" style="float:left" onclick="showWin()">选择店铺</button>
					<span style="float:left;padding-left:30px;line-height:30px;display:block" id="show"></span>
				</td>		
			</tr>
			<tr>
				<td class="c-length1">文章链接：</td>
				<td class="c-length2">
					<input type="text" id="url" name="url" placeholder="http" />
			</tr>
			<tr>
				<td class="c-length1">优先级：</td>
				<td class="c-length2">
					<input type="text" id="order" name="order" placeholder="请填写1-255正整数" />
				</td>		
			</tr>
		</tbody>
	</table>
	<div class="panel ">
		<div class="panel-body" style="padding-left:0px;">
			<textarea style="width:80%" rows="10" id="content" name="content">			
			</textarea>

		</div>
	</div>
	<p class="text-center">
		<button type="button" class="btn btn-danger" onclick="savearticle()">确定</button>
		<button type="button" class="btn btn-info" onclick="reset()">重置</button>
	</p>
	</form>
</div>

</div>
<div class="maskme" style="display:none"></div>
<div class="alertme" style="display:none">
	<div class="title">
		选择店铺 <span class="close2 glyphicon glyphicon-remove-circle" onclick="cancle()"></span>
	</div>
	<div class="content">
		
	</div>
	
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/common/kindeditor/kindeditor.js" type="text/javascript"></script>
<script src="${jsBase}/common/kindeditor/lang/zh_CN.js" type="text/javascript"></script>
<script src="${jsBase}/article/add.js" type="text/javascript"></script>
</body>