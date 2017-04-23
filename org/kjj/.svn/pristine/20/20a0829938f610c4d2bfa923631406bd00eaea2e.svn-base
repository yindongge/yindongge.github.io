<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<%@include file="../common/common_css.jsp" %>
<title>修改移动首页</title>
<style>
</style>
</head>
<body>
<div class="page-wrapper ">
<div class="container-fluid">
	<div class="page-wrapper">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li>您的位置</li>
				<li><a href="#">店铺</a></li>
				<li><a href="#">首页管理</a></li>
				<li class="active">修改模块区</li>
			</ul>
			<!-- 切换 -->
			<div class="btn-group btn-group-justified" role="group" aria-label="Justified button group">
			    <a href="../mobilePage/editPage?pageId=${page.id}" class="btn btn-info " role="button">基本信息</a>
			   <a href="../mobilePage/bannerList?pageId=${page.id}" class="btn btn-info" role="button">轮播图</a>
			   <a href="#" class="btn btn-primary" role="button">板块区</a>
			    <a href="../mobilePage/customize?pageId=${page.id}" class="btn btn-info" role="button">自定义</a>
		    </div>
			<!-- 切换 -->
			<form class="form-inline" id="mobilePageform" name ="mobilePageform"  method="post" enctype="multipart/form-data">
			<input type="hidden" id="pageId" name="pageId" value="${page.id}"/>
			<div class="panel panel-info panel_control" id="moduleout">
			<c:forEach items="${moduleList}"  begin="0" end="${size}"  var="module" varStatus="status">
			<div class="table-list">
				<table class="table  new-table">
					<tbody>
						<tr>
							<td  class="td_control100 " ><span class="red">*</span>选择区域：</td>
							<td class="center_left">
								<div class="form-group ">
										<img src="${module.moduleImg}" id="img${status.index}" alt=""  width="375" height="40" />
										<input type="hidden" id="hid${status.index}" value="${module.moduleImg}"/>
										<input type="hidden" id="id${status.index}" value="${module.id}"/>
										<input type="hidden" id="order${status.index}" value="${module.moduleOrder}"/>
										<span class="gray" id="tip">建议图片宽高尺寸为750*80</span>
										<input type="file" id="file${status.index}" name="file" class="form-control w260" style="display:none"  onchange='uploadImage("img${status.index}")'/>
								</div>
							</td>
						</tr>
						<tr>
							<td  class="td_control100 " ><span class="red">*</span>分组商品：</td>
							<td class="center_left">
								<div class="form-group">
									<button type="button" class="btn btn-danger" id="${module.id}">选择</button>
									<span class="gray">已选<font color="red">${module.count}</font>件商品</span>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="close_table">
					<span class="glyphicon glyphicon-remove-circle" id="down${status.index}"></span>
					<span class="glyphicon glyphicon-arrow-up up_me"></span>
					<span class="glyphicon glyphicon-arrow-down down_me"></span>
				</div>
			</div>
			</c:forEach>
			<div class="table_bottom" id="continueAdd">
					<button type="button" class="btn btn-default w260" id="continueAddBtn">继续添加一组商品</button>
			</div>
			</div>
			</form>
		</div>
	</div>
</div>
	<%@include file="../common/common_js.jsp" %>
	<script src="${jsBase}/mobilePage/modulePage.js" type="text/javascript"></script>
	<script type="text/javascript" src="${jsBase}/common/ajaxfileupload.js"></script>
</body>
</html>
