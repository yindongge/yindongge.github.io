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
<title>会员管理</title>
</head>

<body>
<div class="page-wrapper goods-control">
<div class="container-fluid">
	<form  class="form-inline" id ="pageform" name ="pageform" action="${ctx}/meal/updateStockClear" method="post">
	    <input type="hidden" id="shopCode" name="shopCode" value="${shopCode}"/>
		<input type="hidden" id="timeTypeStr" name="timeTypeStr" />
		<div class="text-center" style="margin-top:20px">
		    <h4 style="color:red">*系统时间到您设置的时间点时，自动将本店的所有菜品库存设置为0</h4>
		</div>
		<div style="padding:10px;background:#FFFFFF;" style="">
			<c:forEach var="item" items="${timeList}" varStatus="status">
			    <div style="margin:20px 20px 20px 50px;width:100px;height:30px;display:inline-block;bordr:1px solid red">
			    	<input type="checkbox" name="timeTypeItem" id="timeTypeItem" value="${item.id}" <c:if test="${item.isCheck!=null}">checked</c:if>/>${item.name}
			    </div>
				
				<c:if test="${(status.index + 1)%3==0}"><br/></c:if>
			</c:forEach>
		</div>
		<div class="text-center">
			<button type="button" class="btn btn-default modal-button" data-dismiss="modal" onclick="cancle()">关闭</button>
			<button type="button" class="btn btn-danger" onclick="savedata()" id="mySubmit">保存</button>
		</div>
	</form>
</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/meal/stockClear.js" type="text/javascript"></script>
</body>
</html>
