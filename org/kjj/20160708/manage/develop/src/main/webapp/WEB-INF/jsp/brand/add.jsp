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
<title>品牌添加</title>
</head>
<body>	
<div class="page-wrapper">
	<div class="container-fluid">
		<ul class="breadcrumb">
			<li>您的位置</li>
			<li ><a href="#">商品</a></li>
			<li ><a href="#">品牌管理</a></li>
			<li class="active">添加品牌</li>
		</ul>
		<form class="form-horizontal" id="brand_add" name="brand_add" method="post" action="" >
		<div class="form-group">
			<label  class="col-sm-2 control-label">品牌名称：</label>
			<div class="col-sm-5">
			  <input type="text" class="form-control" id="productBrandName" name="productBrandName" data-bv-trigger="keyup" required data-bv-notempty-message="品牌名称不能为空！"  placeholder="品牌名称"/>
			</div>
		</div>
		
		<div class="form-group">
			<label  class="col-sm-2 control-label">选择分类：</label>
			<div class="col-sm-1">
				<button type="button" class="btn btn-danger btn2-click">点击选择<i class='caret'></i></button>
			</div>
			<div class="col-sm-6" style="width:auto">
			<input type="hidden" id="classIds" name="classIds" value=""/>
			<input type="hidden" id="brandTypeStr" name="brandTypeStr" value=""/>
			<div class="control-delete" id="showtext">
		
			<p class="delete-span"><span >您选择了：</span></p>
			</div>
			
			</div>
		</div>
		<div class="form-group">
			<label  class="col-sm-2 control-label">排序：</label>
			<div class="col-sm-5">
			  <input type="text" class="form-control" id="brandOrder" name="brandOrder"  placeholder="text" required
                                   min="1" data-bv-greaterthan-inclusive="false" data-bv-greaterthan-message="排序值不能小于1"
                                   max="255" data-bv-lessthan-inclusive="true" data-bv-lessthan-message="排序值不能大约255"
			  
			  />
			</div>
		</div>
		<div class="form-group">
			<label  class="col-sm-2 control-label">品牌logo：</label>
			<div class="col-sm-2">
				<input type="file" style="width:70px;overflow:hidden;" id="file" name="file"  onchange="uploadfile();"/>
				<input type="hidden" id="productBrandLogoimage" name = "productBrandLogoimage"></input>
			</div>
			<div class="col-sm-1" id="div_logo">
				<img id="logo" name="logo" height="30"></img>
			</div>
			<div class="col-sm-4">
				<p>支持格式gif、jpg、jpeg、png，上传宽高比例为5：3，建议上传尺寸：300px*180px</p>
			</div>
		</div>
		<div class="form-group">
			<label  class="col-sm-2 control-label">品牌简介：</label>
			<div class="col-sm-5">
				<textarea class="form-control" rows="7" name="productBrandIntro"  id="productBrandIntro"></textarea>
			</div>
		</div>			
		</form>	
		<div class="text-center">
			<button  class="btn btn-primary "  role="button" href="javascript:void(0);" onclick="closewin();">取消</button>
			<button type="button" class="btn btn-primary " onclick ="savedata()">确定</button>
		</div>
	</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/common/ajaxfileupload.js" type="text/javascript"></script>
<script src="${jsBase}/brand/add.js" type="text/javascript"></script>

</body>
</html>