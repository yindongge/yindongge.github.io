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
<title>活动专题图</title>
</head>
<body>
	<div class="container" style="width:100%">
        <div class="modal show modal-control" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="margin:10px auto">
				<div class="modal-content">
					<div class="modal-body">
						<div class="row">
							<form  action="${ctx}/special/savePic" method="post" enctype="multipart/form-data" >
								<input type="hidden" name="specialId" value="${orgSpecialLink.specialId}"/>	
								<input type="hidden" name="id" value="${orgSpecialLink.id}"/>	
								<div class="form-group alert_control">
									<label>文字标题</label>
									<input id="title" required type="text" name="title" class="form-control w260" value="${orgSpecialLink.title}" />
									<span class="gray">图片标题文字将作为图片Alt形式显示</span>
								</div>
								<div class="form-group alert_control">
									<label>链接类型：</label>
									<div class="check_all_radio">
										<label class="radio-inline">
											<input type="radio" name="type" value="1" <c:if test="${empty orgSpecialLink.type or orgSpecialLink.type eq 1 }">checked</c:if>  />纯链接
										</label>
										<label class="radio-inline">
											<input type="radio" name="type" value="2" <c:if test="${orgSpecialLink.type eq 2}">checked</c:if> /> 商品
										</label>
									</div>
									<span class="gray">商品SKU需判断有货无货</span>
								</div>
								<div class="form-group alert_control">
									<label>专题图片上传</label>
									<div id="imgdiv" style="margin-bottom:5px">
									<img id="imgShow"  width="50" height="50" src="${orgSpecialLink.imagePath}"/>
									</div>
									<input type="file" id="file" name="file" class="form-control w260" id="up_img" value="${orgSpecialLink.imagePath}"/>
									<input id="picUrl" type="hidden" name="imagePath" value="${orgSpecialLink.imagePath}" />
									<span class="gray">建议宽1200px</span>
								</div>
								<div id="showLink" class="form-group alert_control">
									<label>图片跳转链接</label>
									<input type="text"  validate="url" name="url" class="form-control w260" value="${orgSpecialLink.url}" />
									<span class="gray">输入图片要跳转的URL地址，正确格式应以"http://"开头，点击后将以"_blank"形式另打开页面。</span>
								</div>
								<div id="showProduct" class="form-group alert_control">
									<label>分组商品</label>
									<div class="edit_wrapper">
										<div title="${orgProductItem.goodsName}" class="edit_list">
											<img src="${orgProductItem.goodsImg180}" alt="${orgProductItem.goodsName}" />
											<a style="overflow:hidden">${orgProductItem.goodsName}</a>
											<span class="glyphicon glyphicon-remove-circle closeme"></span>
										</div>
										<input id="goodsId" type='hidden'  name='goodsId' value='${orgProductItem.goodsId}'/>
									</div>
								</div>
								<iframe id="getProduct" src="${ctx}/special/searchProduct" width="100%" height="380" 
						scrolling='no' frameborder='no' border='0' marginwidth='0' marginheight='0'  allowtransparency='yes' ></iframe>
								<div class="form-group">
									<button id="saveForm" type="button" class="btn btn-success">保存</button>
								</div>
							</form>
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/common/kindeditor/kindeditor.js" type="text/javascript"></script>
<script src="${jsBase}/common/kindeditor/lang/zh_CN.js" type="text/javascript"></script>
<script src="${jsBase}/special/editPic.js" type="text/javascript"></script>
</body>
</html>
