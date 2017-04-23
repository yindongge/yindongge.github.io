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
<title>自定义HTML</title>
</head>
<body>
	<form class="form-horizontal  media-control" action="${ctx}/special/saveHtml" method="post">
		<input type="hidden" name="specialId" value="${orgSpecialRule.specialId}"/>	
		<div class="page-wrapper ">
			<div class="container-fluid">
				<div class="page-wrapper">
					<div class="container-fluid">
						<ul class="breadcrumb">
							<li>您的位置</li>
							<li class="active">专题页配置</li>
							<li class="active">自定义HTML</li>
						</ul>
						<!-- 切换 -->
						<div class="btn-group btn-group-justified" role="group" aria-label="Justified button group" >
						   <a href="${ctx}/special/edit/${orgSpecialRule.specialId}"  class="btn btn-info " role="button">基本信息</a>
						   <a href="javascript:void(0)"  class="btn btn-primary " role="button">自定义HTML</a>
						   <a href="${ctx}/special/picList/${orgSpecialRule.specialId}"  class="btn btn-info " role="button">活动专题图</a>
						   <a href="${ctx}/special/productList/${orgSpecialRule.specialId}"  class="btn btn-info " role="button">分组商品</a>
						   <a href="${ctx}/special/editAnchor/${orgSpecialRule.specialId}"  class="btn btn-info " role="button">锚点链接</a>
					    </div>
						<!-- 切换 -->
						<div class="table-wrapper">
							<textarea style="width:100%" rows="20" name="ruleHtml" >${orgSpecialRule.ruleHtml}</textarea>
						</div>
						<br/>
						<div class="text-center margin5">
							<a type="button" class="btn btn-default" href="${ctx}/special/list">返回</a>
							<button type="submit" class="btn btn-info">保存</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/common/kindeditor/kindeditor.js" type="text/javascript"></script>
<script src="${jsBase}/common/kindeditor/lang/zh_CN.js" type="text/javascript"></script>
<script src="${jsBase}/special/add.js" type="text/javascript"></script>
</body>
</html>
