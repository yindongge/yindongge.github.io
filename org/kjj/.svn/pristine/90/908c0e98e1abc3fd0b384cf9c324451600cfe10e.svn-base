<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>品牌管理</title>
<%@include file="../common/common_css.jsp" %>
</head>
<body >
<div class="page-wrapper">
	<div class="container-fluid">
		<ul class="breadcrumb">
			<li>您的位置</li>
			<li ><a href="${ctx }/product/offSaleList">商品</a></li>
			<li ><a href="#">添加商品</a></li>
			<li class="active">其他信息</li>
		</ul>
		<div class="btn-group btn-group-justified" role="group" aria-label="Justified button group">
		   	<a href="${ctx }/product/edit/${product.goodsId }" class="btn btn-info " role="button">基本信息</a>
		  	<a href="${ctx }/product/skuInfo/${product.goodsId }" class="btn btn-info" role="button">SKU信息</a>
			<!-- <a href="javascript:void(0);" class="btn btn-info" role="button">相关商品</a> -->
			<a href="${ctx }/product/otherInfo/${product.goodsId }" class="btn btn-primary" role="button">其他信息</a>
	    </div>
		<form class="form-horizontal media-control" id="addForm" action="${ctx }/product/saveOtherInfo" method="post">
		<input type="hidden" name="goodsId" value="${product.goodsId }"/>
		<div class="panel panel-default">
			<div class="panel-heading">
				其他信息
			</div>
			<div class="panel-body">
				<div class="form-group">
					<label class="col-sm-2 control-label" >关键词</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" name="keywords" value="${product.keywords }" placeholder="多个关键词请用“空格”隔开"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" >描述</label>
					<div class="col-sm-5">
						<textarea rows='10' class="form-control" name="spec">${product.spec }</textarea>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" >后台备注：</label>
					<div class="col-sm-5">
						<textarea rows='10' class="form-control" name="sellerNote" placeholder="仅管理员可见">${product.sellerNote }</textarea>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" >完成状态</label>
					<div class="col-sm-3">
						<select class="form-control" name="isShipping">
							<option value="0" <c:if test="${product.isShipping==0}">selected</c:if> >未完成</option>
							<option value="1" <c:if test="${product.isShipping==1}">selected</c:if> >完成</option>
							<option value="2" <c:if test="${product.isShipping==2}">selected</c:if> >待补充</option>
							<option value="3" <c:if test="${product.isShipping==3}">selected</c:if> >待修改</option>
						</select>
					</div>
					<div class="col-sm-7">
						<p style="margin-top:8px;">此商品的添加状态，是否需要补充或修正</p>
					</div>
				</div>
				<div class="form-group">
						<label class="col-sm-2 control-label" >商品展现形式：</label>
					<div class="col-sm-8">
						<p class="switch-control">
							<input type="hidden" name="showType" value="${product.showType == null ?0:product.showType}"/>
							<c:choose>
							<c:when test="${product.showType == 0 || product.showType == null}">
							<button type="button" class="btn btn-primary btn-nocircle" id="showTypeBtn1">合并</button>
							<button type="button" class="btn btn-default btn-nocircle" id="showTypeBtn2">展开</button>
							</c:when>
							<c:when test="${product.showType == 1}">
							<button type="button" class="btn btn-default btn-nocircle" id="showTypeBtn1">合并</button>
							<button type="button" class="btn btn-primary btn-nocircle" id="showTypeBtn2">展开</button>
							</c:when>							
							</c:choose>

							<span> 展示形态默认合并形式，3层级及以上销售属性选择时建议展开形式。</span>
						</p>
						<div class="clearboth" id="showTypeDiv1">
							<div class="color-title">颜色：</div>
							<div class="colorspan-wrapper">
								<span class="span-content"><i>主图</i>红色/150</span>
								<span class="span-content"><i>主图</i>红色/160</span>
								<span class="span-content"><i>主图</i>蓝色/150</span>
								<span class="span-content"><i>主图</i>蓝色/160</span>
							</div>
						</div>
						<div class="clearboth" id="showTypeDiv2">
							<div class="color-title">颜色：</div>
							<div class="colorspan-wrapper">
								<span class="span-content"><i>主图</i>红色</span>
								<span class="span-content"><i>主图</i>蓝色</span>
							</div>
						</div>
						<div class="clearboth" id="showTypeDiv3">
							<div class="color-title">尺寸：</div>
							<div class="colorspan-wrapper">
								<span class="span-content">150</span>
								<span class="span-content">160</span>
								<span class="span-content">170</span>
								<span class="span-content">180</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</br>
		<div class="text-center">
			<button type="submit" class="btn btn-primary " >保存</button>
			<!-- <button type="button" class="btn btn-primary " >保存后继续添加</button> -->
		</div>
		</form>
	</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/product/otherInfo.js" type="text/javascript"></script>
</body>
</html>
