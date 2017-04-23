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
	<form class="form-horizontal media-control" id="addForm" action="${ctx }/product/save" method="post">
	<div class="container-fluid">
		<ul class="breadcrumb">
			<li>您的位置</li>
			<li ><a href="${ctx }/product/offSaleList">商品</a></li>
			<li class="active">添加商品</li>
		</ul>
		<div class="btn-group btn-group-justified" role="group" aria-label="Justified button group">
		   	<a href="${ctx }/product/add" class="btn btn-primary " role="button">基本信息</a>
		  	<a href="javascript:void(0);" class="btn btn-info" role="button">SKU信息</a>
			<!-- <a href="javascript:void(0);" class="btn btn-info" role="button">相关商品</a> -->
			<a href="javascript:void(0);" class="btn btn-info" role="button">其他信息</a>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">基本信息</div>
				<div class="panel-body">
					<div class="form-group">
						<label class="col-sm-2 control-label" for="field-1"><span class="red">*</span>商品分类：</label>
						<div class="col-sm-2">
							<button type="button" id="selectClassBtn" class="btn btn-danger btn2-click ">点击选择<i class='caret'></i></button>
						</div>
						<p class="col-sm-4 yellow-span" >您选择的是:<span id="className"></span></p>
						<input type="hidden" id="classId" name="catId"/>
						<input type="hidden" id="catStr" name="catStr"/>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="field-1"><span class="red"></span>副分类：</label>
						<div class="col-sm-2">
							<button type="button" class="btn btn-danger btn2-click " id="selectSubClassBtn">点击选择<i class='caret'></i></button>
						</div>
						<p class="col-sm-4 yellow-span" id="subClassDiv">
							您选择的是：
						</p>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" ><span class="red">*</span>商品货号：</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="goodsSn"></input>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" ><span class="red">*</span>商品名称：</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="goodsName"></input>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label" >副标题：</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="goodsBrief"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" ><span class="red">*</span>市场价：</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="marketPrice"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" ><span class="red">*</span>商品品牌：</label>
						<div class="col-sm-4">
							<select name="brandId" id="brandId" class="form-control">
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" >显示主图的销售规格：</label>
						<div class="col-sm-4">
							<select name="specid" id="specid" class="form-control">
							</select>
						</div>
					</div>
					<div class="mm">
						<div id="saleSpecDiv">

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
										<div class="img_show stop_move" style="display: none;">
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
					</div>	
					<div class="form-group">
						<label class="col-sm-2 control-label" ><span class="red"></span>商品描述：</label>
						<div class="col-sm-9" >
								<div class="change-area">
									<a class="changebutton togglebtn ">PC端</a>
									<a class="changebutton togglebtn">移动端</a>
								</div>
								<div class=" bianji">
									<textarea id="goodsDesc" name="goodsDesc" class="form-control textarea-control"></textarea>
								</div>
								<div class=" bianji">
									<textarea id="mobileGoodsDesc" name="mobileGoodsDesc" class="form-control textarea-control"></textarea>
								</div>
						</div>
					</div>
			</div>
		</div>
		<br/>
		<div class="text-center">
			<button type="button" class="btn btn-primary " name="addBtn">下一步</button>
		</div>
	</div>
	</form>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/common/ajaxfileupload.js" type="text/javascript"></script>
<script src="${jsBase}/common/kindeditor/kindeditor.js" type="text/javascript"></script>
<script src="${jsBase}/common/kindeditor/lang/zh_CN.js" type="text/javascript"></script>
<script src="${jsBase}/product/add.js" type="text/javascript"></script>
</body>
</html>
