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
<title>修改触摸屏首页</title>
</head>
<body>
	<form class="form-horizontal  media-control" >
		<input type="hidden" name="pageId" value="${page.id}"/>	
		<div class="page-wrapper ">
			<div class="container-fluid">
				<div class="page-wrapper">
					<div class="container-fluid">
						<ul class="breadcrumb">
							<li>您的位置</li>
							<li class="active">首页管理</li>
							<li class="active">修改触摸屏轮播图</li>
						</ul>
						<!-- 切换 -->
						<div class="btn-group btn-group-justified" role="group" aria-label="Justified button group" >
						   <a href="${ctx}/touchPage/editPage?pageId=${page.id}"  class="btn btn-info " role="button">基本信息</a>
						   <a href="javascript:void(0)"  class="btn btn-primary " role="button">轮播图</a>
					    </div>
						<!-- 切换 -->
						<br/>
						<div id="picFloor" class="panel panel-info ">
							<c:forEach items="${blist}" var="item" varStatus="status">
								<div class="panle_img">
									<img src="${item.bannerImg}" alt="${item.title}" />
									<span class="glyphicon glyphicon-remove-circle closeme"></span>
									<a class="btn btn-success btn-click" data-id="${item.id}" data-order-id="${status.index+1}"><span class="glyphicon glyphicon-pencil"></span>编辑</a>
								</div>
							</c:forEach>
							
							<div class="continute">
							    <br/>
								<button id="addFloorBtn" type="button" class="btn btn-info">添加</button>
							</div>
						</div>
						<div id="notice" class="alert alert-info">
							<button type="button" class="close" data-dismiss="alert" aria-hidden="true">
						      &times;
						   </button>
						   <div>拖曳图片实现排序。</div>
						</div>
						<br/>
						<div class="text-center margin5">
							<a type="button" class="btn btn-default" href="${ctx}/touchPage/list">返回</a>
							<button id="saveImageOrder" type="button" class="btn btn-info">保存</button>
						</div>
						<div id="picFloorTmp">
							<div  class="panle_img" style="display:none">
								<img src="" alt=""/>
								<span class="glyphicon glyphicon-remove-circle closeme"></span>
								<a class="btn btn-success btn-click" data-id="0" order ><span class="glyphicon glyphicon-pencil"></span>编辑</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/common/kindeditor/kindeditor.js" type="text/javascript"></script>
<script src="${jsBase}/common/kindeditor/lang/zh_CN.js" type="text/javascript"></script>
<script src="${jsBase}/common/jquery-ui.min.js" type="text/javascript"></script>
<script src="${jsBase}/touchPage/bannerPage.js" type="text/javascript"></script>
</body>
</html>
