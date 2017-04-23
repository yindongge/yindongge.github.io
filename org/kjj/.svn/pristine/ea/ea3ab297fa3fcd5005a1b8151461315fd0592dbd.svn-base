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
	<form id="addForm" action="${ctx }/product/updateSku" method="post">
	<input type="hidden" name="goodsId" value="${productItem.goodsId }"/>
	<input type="hidden" name="classId" id="classId" value="${productItem.catId }"/>
	<div class="container-fluid">
		<ul class="breadcrumb">
			<li>您的位置</li>
			<li ><a href="${ctx }/product/offSaleList">商品</a></li>
			<li class="active">添加商品</li>
		</ul>
		<div class="btn-group btn-group-justified" role="group" aria-label="Justified button group">
		   <a href="${ctx }/product/edit/${productItem.parentGoodsId }" class="btn btn-info " role="button">基本信息</a>
		   <a href="${ctx }/product/skuInfo/${productItem.parentGoodsId }" class="btn btn-primary" role="button">SKU信息</a>
		   <!-- <a href="" class="btn btn-info" role="button">相关商品</a> -->
		   <a href="${ctx }/product/otherInfo/${productItem.parentGoodsId }" class="btn btn-info" role="button">其他信息</a>
	    </div>
		<table class="table table-bordered table-hover table-firsttd">
			<tbody>
				<tr>
					<td>选择SKU：</td>
					<td>
						<c:forEach items="${productItemList }" var="item">
						<c:choose>
							<c:when test="${item.goodsId == productItem.goodsId }">
							<a class="btn btn-danger" href="${ctx }/product/editSku/${item.goodsId}">${item.saleSpecStr }</a>
							</c:when>
							<c:otherwise>
							<a class="btn btn-default" href="${ctx }/product/editSku/${item.goodsId}">${item.saleSpecStr }</a>
							</c:otherwise>
						</c:choose>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td>商品名称：</td>
					<td>
						<div class="form-group">
							<div class="col-sm-4">
								<input type="text" class="form-control" name="goodsName" value="${productItem.goodsName }"/>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td>副标题：</td>
					<td>
						<div class="form-group">
							<div class="col-sm-4">
								<input type="text" class="form-control" name="goodsBrief" value="${productItem.goodsBrief }"/>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td>*SKU图片：</td>
					<td>
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
					</td>
				</tr>
				<tr>
					<td>SKU属性：</td>
					<td>
						<table class="table table-bordered table-firsttd">
							<tbody>
								<c:forEach items="${productPropertyList }" var="item">
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
					</td>
				</tr>
				<tr>
					<td><span class="red">*</span>SKU描述：</td>
					<td>
						<div class="change-area">
							<a class="changebutton togglebtn ">PC端</a>
							<a class="changebutton togglebtn">移动端</a>
						</div>
						<div class=" bianji">
							<textarea id="goodsDesc" name="goodsDesc" class="form-control textarea-control">${productItem.goodsDesc }</textarea>
						</div>
						<div class=" bianji">
							<textarea id="mobileGoodsDesc" name="mobileGoodsDesc" class="form-control textarea-control">${productItem.mobileGoodsDesc }</textarea>
						</div>
					</td>
				</tr>
				<tr>
					<td>显示设定：</td>
					<td>
						<p class="switch-control">
							<input type="hidden" name="isShowZeroInventory" value="${productItem.isShowZeroInventory == null ?0:productItem.isShowZeroInventory }"/>
							<c:choose>
							<c:when test="${productItem.isShowZeroInventory == 1}">
							<button type="button" class="btn btn-primary btn-nocircle" id="showBtn1">显示</button>
							<button type="button" class="btn btn-default btn-nocircle" id="showBtn2">关闭</button>
							</c:when>
							<c:when test="${productItem.isShowZeroInventory == 0 || productItem.isShowZeroInventory == null}">
							<button type="button" class="btn btn-default btn-nocircle" id="showBtn1">显示</button>
							<button type="button" class="btn btn-primary btn-nocircle" id="showBtn2">关闭</button>
							</c:when>
							</c:choose>
							<span>0库存是否显示  关闭后，当商品库存为0时，前台所有页面隐藏此商品。</span>
						</p>
						<p class="switch-control">
							<input type="hidden" name="isShow" value="${productItem.isShow == null ?1:productItem.isShow }"/>
							<c:choose>
							<c:when test="${productItem.isShow == 1 || productItem.isShow == null}">
							<button type="button" class="btn btn-primary btn-nocircle" id="showBtn3">显示</button>
							<button type="button" class="btn btn-default btn-nocircle" id="showBtn4">关闭</button>
							</c:when>
							<c:when test="${productItem.isShow == 0}">
							<button type="button" class="btn btn-default btn-nocircle" id="showBtn3">显示</button>
							<button type="button" class="btn btn-primary btn-nocircle" id="showBtn4">关闭</button>
							</c:when>
							</c:choose>
							<span>前台显示  关闭后时，前台所有页面隐藏此商品。</span>
						</p>
						<p class="switch-control">
							<input type="hidden" name="isDirect" value="${productItem.isDirect }"/>
							<c:choose>
							<c:when test="${productItem.isDirect == 0}">
							<button type="button" class="btn btn-primary btn-nocircle" id="showBtn5">直营</button>
							<button type="button" class="btn btn-default btn-nocircle" id="showBtn6">联营</button>
							</c:when>
							<c:when test="${productItem.isDirect == 1}">
							<button type="button" class="btn btn-default btn-nocircle" id="showBtn5">直营</button>
							<button type="button" class="btn btn-primary btn-nocircle" id="showBtn6">联营</button>
							</c:when>
							</c:choose>
						</p>
<!-- 						<p class="switch-control">
							<select name="" id="" class="form-control" style="width:100px;float:left">
								<option value="">所有级别会员</option>
								<option value="">指定会员级别</option>
							</select>
							<span>开放会员组，默认对所有级别会员开放购买，如有限制，会员在前台登录浏览时提示：未开放购买。</span>
						</p> -->
					</td>
				</tr>
			</tbody>
		</table>
		<div class="text-center">
			<button type="submit" class="btn btn-primary ">保存</button>
		</div>
	</div>
	</form>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/common/ajaxfileupload.js" type="text/javascript"></script>
<script src="${jsBase}/common/kindeditor/kindeditor.js" type="text/javascript"></script>
<script src="${jsBase}/common/kindeditor/lang/zh_CN.js" type="text/javascript"></script>
<script src="${jsBase}/product/editSku.js" type="text/javascript"></script>
</body>
</html>
