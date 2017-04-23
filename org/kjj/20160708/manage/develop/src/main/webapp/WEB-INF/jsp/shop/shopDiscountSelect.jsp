<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<%@include file="../common/common_css.jsp" %>
<title>店铺选择</title>
</head>
<body >
<!--弹出框分割线-->
<div class="modal modal-control modal-control-5" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-dialog">
	<div class="modal-content">		
		<div class="modal-body">
			<div class="row  option2-control">
		<div class="col-sm-3 ">
			<select multiple="multiple" class="form-control height2 " id="city">
				<c:forEach items="${mapCity}" var="city" varStatus="status">
					<option value="${city.key}" <c:if test="${status.first}">selected="selected"</c:if>>${city.key}</option>
				</c:forEach>
			</select>
		</div>
		<div class="col-sm-9">
			<!-- <form class="form-inline margin10">
				<button class="btn btn-primary">反选</button>
				<input type="text" />
				<button class="btn btn-primary">搜店铺</button>
			</form> -->
			<c:forEach items="${mapCity}" var="city" varStatus="status">
			<div class="form-control overflow5" id="divCity${city.key}" <c:if test="${!status.first}">style="display:none;"</c:if>>
				<c:forEach items="${city.value}" var="county">
				<dl class="dl-control">
					<dt>${county.key}</dt>
					<c:forEach items="${county.value}" var="shop">
						<dd><label class="checkbox-inline"><input type="checkbox" name="shopIds" value="${shop.shopId}" <c:if test="${status.first}">checked="checked"</c:if>/>${shop.shopName}</label></dd>
					</c:forEach>
				</dl>
				</c:forEach>
			</div>
			</c:forEach>
		</div>
	</div>
	</div>
    <div class="modal-footer">
	<button type="button" class="btn btn-default modal-button" data-dismiss="modal" id="btnCancel">取消</button>
	<button type="button" class="btn btn-danger modal-button" data-dismiss="modal" id="btnConfirm">确认</button>
    </div>
    </div>
  </div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/shop/shopDiscountSelect.js" type="text/javascript"></script>
<!--结束弹出框分割线-->
</body>
</html>
