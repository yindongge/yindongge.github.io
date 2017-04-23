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
<title>店铺管理</title>
</head>
<body >
	<!--弹出框分割线-->
        <div class="modal show modal-control " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="margin-top:0px">
				<div class="modal-content">
			<div class="modal-body">
				<form class="form-horizontal ">
					
					<div class="form-group">
						<label class="col-sm-2 control-label"><i class="glyphicon glyphicon-star"></i> 所在地区:</label>
						<input type="hidden" name="areaCode" id="areaCode"/>
						<div class="col-sm-9">
							<div class="row">
								<div class="col-sm-4">
									<select class="form-control" name="provinceCode" id="provinceCode">
										<option value="-1">选择省或者市</option>
										<c:forEach items="${listProvince}" var="province">
											<option value="${province.code }" <c:if test="${provinceCode==province.code }">selected</c:if>>${province.name }</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-sm-4">
									<select class="form-control" name="cityCode" id="cityCode">
										<option value="-1">请选择市</option>
										<c:forEach items="${listCity}" var="city">
											<option value="${city.code }" <c:if test="${cityCode==city.code }">selected</c:if>>${city.name }</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-sm-4">
									<select class="form-control" name="countyCode" id="countyCode">
										<option value="-1">请选择区或县</option>
										<c:forEach items="${listCounty}" var="county">
											<option value="${county.code }" <c:if test="${countyCode==county.code }">selected</c:if>>${county.name }</option>
										</c:forEach>
									</select>
								</div>
								</div>	
																							
					
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label"><i class="glyphicon glyphicon-star"></i> 商圈：</label>
						<div class="col-sm-3">
							<select class="form-control" name="businessAreaId" id="businessAreaId">
								<option value=''>商圈</option>
								<c:forEach var="item" items="${listBusinessArea}" varStatus="status">
									<option value="${item.id}">${item.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
						<div class="form-group">
						<label class="col-sm-2 control-label"><i class="glyphicon glyphicon-star"></i> 选择店铺：</label>
						<div class="col-sm-9">
							<select multiple="multiple" class="form-control" style="height:150px;" id="shopSelect">
								<c:forEach var="item" items="${listShop}" varStatus="status">
								  <option value="${item.shopId}">${item.shopName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</form>
			</div>
			  <div class="modal-footer">
				<button type="button" class="btn btn-default modal-button" data-dismiss="modal" id="btnCancel">取消</button>
				<button type="button" class="btn btn-primary modal-button" id="btnConfirm">确定</button>
			  </div>
    </div>
  </div>
</div>
<!--结束弹出框分割线-->
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/shop/shopSelect.js" type="text/javascript"></script>
</body>
</html>
