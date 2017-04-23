<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>商品添加</title>
<%@include file="../common/common_css.jsp" %>
<link rel="stylesheet" href="${jsBase}/common/kindeditor/themes/default/default.css" />
</head>
<body>
<div class="page-wrapper">
	<form class="form-horizontal media-control" id="addForm" action="${ctx }/product/update" method="post">
	<span id="hiddenSku"></span>
	<input type="hidden" name="goodsId" value="${product.goodsId }"/>
	<div class="container-fluid">
		<ul class="breadcrumb">
			<li>您的位置</li>
			<li ><a href="${ctx }/product/offSaleList">商品</a></li>
			<li class="active">添加商品</li>
		</ul>
		<div class="btn-group btn-group-justified" role="group" aria-label="Justified button group">
		   	<a href="${ctx }/product/edit/${product.goodsId }" class="btn btn-primary " role="button">基本信息</a>
		   	<c:choose>
		   	<c:when test="${productItemList.size() == 1 && productItemList[0].orgProductItemLinkSalespecList.size() == 0 }">
		   	<a href="javascript:void(0);" class="btn btn-info" role="button">SKU信息</a>
		   	</c:when>
		   	<c:otherwise>
		   	<a href="${ctx }/product/skuInfo/${product.goodsId }" class="btn btn-info" role="button">SKU信息</a>
		   	</c:otherwise>
		   	</c:choose>
		  	
			<!-- <a href="javascript:void(0);" class="btn btn-info" role="button">相关商品</a> -->
			<a href="${ctx }/product/otherInfo/${product.goodsId }" class="btn btn-info" role="button">其他信息</a>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">基本信息</div>
				<div class="panel-body">
					<div class="form-group">
						<label class="col-sm-2 control-label" for="field-1"><span class="red">*</span>商品分类：</label>
						<div class="col-sm-2">
							<button type="button" id="selectClassBtn" class="btn btn-danger btn2-click ">点击选择<i class='caret'></i></button>
						</div>
						<p class="col-sm-4 yellow-span" >您选择的是:<span id="className">${product.catStr }</span></p>
						<input type="hidden" id="classId" name="catId" value="${product.catId }"/>
						<input type="hidden" id="catStr" name="catStr" value="${product.catStr }"/>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="field-1"><span class="red"></span>副分类：</label>
						<div class="col-sm-2">
							<button type="button" class="btn btn-danger btn2-click " id="selectSubClassBtn">点击选择<i class='caret'></i></button>
						</div>
						<p class="col-sm-4 yellow-span" id="subClassDiv">
							您选择的是：
							<c:forEach items="${productLinkSubclassList }" var="item">
							<span>${item.className }<input type="hidden" name="subClassIds" value="${item.subClassid }"/><i onclick="removeSubClass(this);">X</i></span>
							</c:forEach>
						</p>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" ><span class="red">*</span>商品货号：</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="goodsSn" value="${product.goodsSn }"></input>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" >商品名称：</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="goodsName" value="${product.goodsName }"></input>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label" >副标题：</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="goodsBrief" value="${product.goodsBrief }"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" ><span class="red">*</span>市场价：</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="marketPrice" value="${product.marketPrice }"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" >商品品牌：</label>
						<div class="col-sm-4">
							<select name="brandId" id="brandId" class="form-control">
								<c:forEach items="${brandList }" var="item">
								<option value="${item.productBrandId }" <c:if test="${item.productBrandId == product.brandId}">selected</c:if>>${item.productBrandName }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" >显示主图的销售规格：</label>
						<div class="col-sm-4">
							<select name="specid" id="specid" class="form-control">
								<option value="-1">不显示</option>
								<c:forEach items="${productType.saleSpecList }" var="item">
								<option value="${item.specId }" <c:if test="${product.specid == item.specId}">selected</c:if>>${item.specName }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="mm">
						<div id="saleSpecDiv">
							<c:forEach items="${productType.saleSpecList }" var="item">
							<div class="form-group">
								<label class="col-sm-2 control-label" >${item.specName }：</label>
								<div class="col-sm-9">
									<p>
										<c:forEach items="${item.values }" var="value">
										<lable class="checkbox-inline">
											<input type="checkbox" <c:if test="${value.isSelect }">checked</c:if> name="${value.specId }" value="${value.specValueId }"/>
											<input type="text" class="input2-control" name="specValueInput" value="${value.specValue }"/>
										</lable>
										</c:forEach>
										<%--  
											<label class="checkbox-inline">
													<button type="button" class="btn btn-danger btn-xs ">添加规格值</button>
											</label>
										--%>
									</p>
								</div>
							</div>								
							</c:forEach>
						</div>
						<div class="form-group" id="skuTableDiv">
						</div>
					</div>
		
					<div class="form-group">
						<label class="col-sm-2 control-label" >商品图片：</label>
						<div class="col-sm-9" >
							<div class="row row-control">
								<div class="change-area">
									<a class="changebutton active" id="uploadNewImgBtn">上传新图片</a>
									<a class="changebutton" id="addImgFromAlbumBtn">从相册中选择</a>
								</div>
								<div class="change-select1">
									<!-- 相册开始 -->
									<div id="albumDiv"></div>
									<!-- 相册结束 -->
									<div class="change-img" style="overflow:hidden">
										<div class="img_show stop_move" style="display:none;">
												<div class="thumbnail">
													<div style="text-align:center;position:relative">
														<img src="" class="img-col-md-2"/>
													</div>
													<div class="caption " style="padding:0px; margin-top:10px;">
														<div class="row caption-control">
														  <div class="col-md-2 col-md-offset-1 ">
																<a class="thumbnail active">
																 	 <img src=""/>
																</a>
															 </div>
															<div class="col-md-2 ">
																<a class="thumbnail">
																  <img src=""/>
																</a>
															 </div>
																<div class="col-md-2 ">
																<a class="thumbnail">
																  <img src=""/>
																</a>
															 </div>
															<div class="col-md-2 ">
																<a class="thumbnail">
																  <img src=""/>
																</a>
															 </div>
															 <div class="col-md-2 ">
																<a class="thumbnail">
																  <img src=""/>
																</a>
															 </div>
														</div>
													</div>
												</div>
										</div>
 										<c:forEach items="${productImgList}" var="item">
										<div class="img_show">
											<div class="thumbnail">
												<div style="position: relative;text-align: center;">
													<img src="${item.imgUrl180 }" class="img-col-md-2"/>
													<input type="file" name="file" id="img_${item.imgId }" style="position: absolute;top: 0;right: 20px;height: 24px;filter: alpha(opacity:0);opacity: 0;bottom: 0px;left: 0px;height: 100%;width: 100%;"/>
													<input type="hidden" name="goodsImgs" value="${item.imgUrl }"/>
												</div>	
												<p class="thumbnail-photo text-center">
														<a href="javascript:void(0);" name="leftImgBtn" class="btn btn-default btn-sm" role="button"><i class="glyphicon glyphicon-arrow-left"></i></a>
														<a href="javascript:void(0);" name="rightImgBtn" class="btn btn-default btn-sm" role="button"><i class="glyphicon glyphicon-arrow-right"></i></a>
														<a href="javascript:void(0);" name="deleteImgBtn" class="btn btn-danger btn-sm" role="button"><i class="glyphicon glyphicon-remove"></i></a>
												</p>
											</div>
										</div>
										</c:forEach>
										<div class="img_show stop_move" id="addImgBtn">
											<div class="thumbnail addplus">
												<p class="img-col-md-2"></p>
											</div>
										</div>
									</div>
								</div>
							</div>
							<p>上传商品默认轮播图，如多销售规格值时将默认使用该组图片或上传各销售规格轮播图；支持jpg、gif、png格式上传或从图片空间中选择，建议使用尺寸800x800像素以上、大小不超过500K的正方形图片为宜，上传后的图片将会自动保存在图片空间的所属商品分类中。</p>
						</div>
					</div>
					<div class="form-group" id="productPropertyDiv">
						<label class="col-sm-2 control-label" >商品属性：</label>
						<div class="col-sm-9" >
							<table class="table table-bordered table-firsttd">
								<tbody>
									<c:forEach items="${productType.productProperty }" var="item">
									<tr>
									<td>${item.propertyName }：</td>
									<c:choose>
									<c:when test="${item.propertyInputType == 1 }">
									<td>
										<div class="form-group">
											<div class="col-sm-4">
												<input type="text" class="form-control" name="prop_${item.propertyId }" value="${item.propertyValues[0].propertyValue }"></input>
											</div>
										</div>
									</td>
									</c:when>
									<c:when test="${item.propertyInputType == 2 }">
									<td>
										<div class="form-group">
											<div class="col-sm-4">
												<c:forEach items="${item.propertyValues }" var="propertyValue">
												<label>
													<input type="radio" name="prop_${item.propertyId }" value="${propertyValue.propertyValueId }" <c:if test="${propertyValue.isSelect}">checked</c:if>/>
													${propertyValue.propertyValue }
												</label>
												</c:forEach>
											</div>
										</div>
									</td>
									</c:when>
									<c:when test="${item.propertyInputType == 3 }">
									<td>
										<div class="form-group">
											<div class="col-sm-4">
												<select class="form-control" name="prop_${item.propertyId }">
												<c:forEach items="${item.propertyValues }" var="propertyValue">
												<option value="${propertyValue.propertyValueId }" <c:if test="${propertyValue.isSelect}">selected</c:if>>${propertyValue.propertyValue }</option>
												</c:forEach>
												</select>
											</div>
										</div>
									</td>
									</c:when>
									<c:when test="${item.propertyInputType == 4 }">
									<td>
										<div class="form-group">
											<div class="col-sm-4">
												<c:forEach items="${item.propertyValues }" var="propertyValue">
												<label>
													<input type="checkbox" name="prop_${item.propertyId }" value="${propertyValue.propertyValueId }" <c:if test="${propertyValue.isSelect}">checked</c:if>/>
													${propertyValue.propertyValue }
												</label>
												</c:forEach>
											</div>
										</div>
									</td>
									</c:when>
									</c:choose>
									</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>	
					<div class="form-group">
						<label class="col-sm-2 control-label" ><span class="red"></span>商品描述：</label>
						<div class="col-sm-9" >
								<div class="change-area">
									<a class="changebutton togglebtn ">PC端</a>
									<a class="changebutton togglebtn">移动端</a>
								</div>
								<div class=" bianji">
									<textarea id="goodsDesc" name="goodsDesc" class="form-control textarea-control">${product.goodsDesc }</textarea>
								</div>
								<div class=" bianji">
									<textarea id="mobileGoodsDesc" name="mobileGoodsDesc" class="form-control textarea-control">${product.mobileGoodsDesc }</textarea>
								</div>
						</div>
					</div>
			</div>
		</div>
		<br/>
		<div class="text-center">
			<button type="submit" class="btn btn-primary " >下一步</button>
		</div>
	</div>
	</form>
</div>
<script type="text/javascript">
var productTypeJson = '${productTypeJson}';
var productItemListJson = '${productItemListJson}';
</script>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/common/ajaxfileupload.js" type="text/javascript"></script>
<script src="${jsBase}/common/kindeditor/kindeditor.js" type="text/javascript"></script>
<script src="${jsBase}/common/kindeditor/lang/zh_CN.js" type="text/javascript"></script>
<script src="${jsBase}/product/edit.js" type="text/javascript"></script>
</body>
</html>
