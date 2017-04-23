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
<title>分组商品</title>
</head>
<body>
	<form class="form-horizontal  media-control" >
		<input type="hidden" name="specialId" value="${specialId}"/>	
		<div class="page-wrapper ">
			<div class="container-fluid">
				<div class="page-wrapper">
					<div class="container-fluid">
						<ul class="breadcrumb">
							<li>您的位置</li>
							<li class="active">专题页配置</li>
							<li class="active">分组商品</li>
						</ul>
						<!-- 切换 -->
						<div class="btn-group btn-group-justified" role="group" aria-label="Justified button group" >
						   <a href="${ctx}/special/edit/${specialId}"  class="btn btn-info " role="button">基本信息</a>
						   <a href="${ctx}/special/editHtml/${specialId}"  class="btn btn-info " role="button">自定义HTML</a>
						   <a href="${ctx}/special/picList/${specialId}"   class="btn btn-info " role="button">活动专题图</a>
						   <a href="javascript:void(0)"  class="btn btn-primary " role="button">分组商品</a>
						   <a href="${ctx}/special/editAnchor/${specialId}"   class="btn btn-info " role="button">锚点链接</a>
					    </div>
						<!-- 切换 -->
						<div class="panel panel-info" id="productFloor">
							<c:forEach items="${list}" var="floor" varStatus="status">
								<div class="fenzushangpin">
									<div class="panle_img">
										<img src="${floor.imgPath}" >
									</div>
									<div class="edit-box">
										<a class="btn btn-success btn-click" data-id="${floor.floorId}" data-order-id="${status.index+1}"><span class="glyphicon glyphicon-pencil"></span>编辑</a>
										<a class="btn btn-danger "><span class="glyphicon glyphicon-remove-circle closeme"></span>删除</a>
									</div>
									<div class="groupin_goods">
										<c:forEach items="${floor.productList}" var="goods">
											<c:if test="${empty goods.imagePath}">
												<a href="javascript:void(0)"><img src="${goods.productItem.goodsImg50}"></a>
											</c:if>
										</c:forEach>
									</div>
									<div class="groupin_goods juxing">
										<c:forEach items="${floor.productList}" var="image">
											<c:if test="${!empty image.imagePath}">
												<a href="javascript:void(0)"><img src="${image.imagePath}" ></a>
											</c:if>
										</c:forEach>
									</div>
								</div>
							</c:forEach>
							<br/>
							<div class="continute">
								<button id="addFloorBtn"  type="button" class="btn btn-info">添加</button>
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
							<a type="button" class="btn btn-default" href="${ctx}/special/list">返回</a>
							<button id="saveProductOrder" type="button" class="btn btn-info">保存</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/common/jquery-ui.min.js" type="text/javascript"></script>
<script src="${jsBase}/special/productList.js" type="text/javascript"></script>
</body>
</html>
