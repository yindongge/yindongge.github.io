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
<title>专题商品楼层</title>
</head>
<body>
	<div class="container" style="width:100%">
        <div class="modal show modal-control" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="margin:10px auto">
				<div class="modal-content">
					<div class="modal-body">
						<form id="mainForm" action="${ctx}/special/saveProduct" method="post" >
							<input type="hidden" name="specialId" value="${orgSpecialFloor.specialId}"/>	
							<input type="hidden" name="floorId" value="${orgSpecialFloor.floorId}"/>	
							<div class="row">
								<div class="form-group alert_control">
									<label>上传分组图片</label>
									<img src="${orgSpecialFloor.imgPath}" style="width:30px;height:30px" />
									<input  name="file" type="file" class="form-control w260" />
									<input type="hidden" name="imgPath" value="${orgSpecialFloor.imgPath}" />
									<span class="gray">图片建议宽1920px</span>
								</div>
								<div class="form-group alert_control">
									<label>分组商品</label>
									<div id="productRow" class="edit_wrapper">
										<c:if test="${not empty orgSpecialFloor.productList }">
											<c:forEach items="${orgSpecialFloor.productList}" var="product">
												<c:if test="${not empty product.goodsId}">
													<div title="${product.productItem.goodsName}" class="edit_list">
														<img src="${product.productItem.goodsImg50}" alt="${product.productItem.goodsName}" />
														<a style="overflow:hidden">${product.productItem.goodsName}</a>
														<span class="glyphicon glyphicon-remove-circle closeme product"></span>
														<input type="hidden" value="${product.goodsId}"/>
													</div>
												</c:if>
											</c:forEach>
										</c:if>
									</div>
								</div>
								<iframe id="getProduct" src="${ctx}/special/searchProduct" width="100%" height="380" 
							    scrolling='no' frameborder='no' border='0' marginwidth='0' marginheight='0'  allowtransparency='yes' ></iframe>
								<div class="form-group alert_control"  style="min-height:30px">
									<label>上传活动图片</label>
								</div>
								<div id="uploadPic" class="panel panel-info" style="position:relative">
									<c:forEach items="${orgSpecialFloor.productList}" var="product">
										<c:if test="${empty product.goodsId}">
											<div class="form-group alert_control" style="min-height:30px" >
												<div class="link_url">
													<div class="url_list">
														<img src="${product.imagePath}" style="width:30px;height:30px;margin-top:4px" />
														<input  name="file" type="file" class="form-control w260" />
														<input type="hidden" value="${product.imagePath}"/>
														<input type="text" validate="url" value="${product.url}" class="form-control w260 picLink" placeholder="活动图片链接地址"/>
														<span data-id="${product.id}" class="glyphicon glyphicon-remove-circle closeme pic"></span>
													</div>
												</div>
											</div>
										</c:if>
									</c:forEach>
									
									<div class="continute">
										<button id="addPicbtn" type="button" class="btn btn-info">添加活动图片</button>
									</div>
								</div>
							</div>
							<div class="form-group">
								<button id="saveForm" type="button" class="btn btn-info">保存</button>
							</div>
						</form>
						<div id="productTmp">
							<div class="edit_list" style="display:none">
								<img src="" alt="" />
								<a style="overflow:hidden"></a>
								<span class="glyphicon glyphicon-remove-circle closeme product"></span>
								<input type="hidden" />
							</div>
						</div>
						<div id="picTmp">
							<div class="form-group alert_control" style="display:none;min-height:30px" >
								<div class="link_url">
									<div class="url_list">
										<img src="" style="width:30px;height:30px;margin-top:4px" />
										<input  name="file" type="file" class="form-control w260" />
										<input type="hidden"  />
										<input type="text" validate="url" class="form-control w260 picLink" placeholder="活动图片链接地址"/>
										<span data-id="0" class="glyphicon glyphicon-remove-circle closeme pic"></span>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/common/kindeditor/kindeditor.js" type="text/javascript"></script>
<script src="${jsBase}/common/kindeditor/lang/zh_CN.js" type="text/javascript"></script>
<script src="${jsBase}/special/editProduct.js" type="text/javascript"></script>
</body>
</html>
