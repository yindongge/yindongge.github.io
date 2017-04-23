<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/common_java.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<meta name="apple-touch-fullscreen" content="yes" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />
<%@ include file="../common/common_css.jsp"%>

<title>满减满送-添加活动商品</title>
</head>
<body>
<div class="page-wrapper ">
<div class="container-fluid">
	<div class="page-wrapper">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li>您的位置</li>
				<li><a href="#">运营</a></li>
				<li><a href="#">促销管理</a></li>
				<li ><a href="">满减满送</a></li>
				<li class="active">添加满减满送</li>
			</ul>
			<div  class="bg-warning " style="padding:10px;">
				<p><strong>备注：</strong></p>
				<p>• 可选择多件赠品（数量、种类），用户购买达到条件时将会被一起送出；可选择多种优惠券，每种优惠券只能选1张.</p>
			</div>
			<!-- 切换 -->
			<div class="btn-group btn-group-justified" role="group" aria-label="Justified button group" style="width:30%;">
				<c:if test="${not empty param.id}">
				   <a href="${ctx}/reach/editInfo/${param.id}" class="btn btn-info " role="button">基本信息</a>
				</c:if>
				<c:if test="${empty param.id}">
				   <a href="${ctx}/reach/addInfo" class="btn btn-info " role="button">基本信息</a>
				</c:if>
			   <a href="javascript:void(0);" class="btn btn-primary" role="button">活动商品</a>
			   <c:if test="${not empty param.id}">
				   <a href="${ctx}/reach/editSet?id=${param.id}" class="btn btn-info" role="button">优惠设置</a>
			   </c:if>
			   	<c:if test="${empty param.id}">
				   <a href="${ctx}/reach/editSet" class="btn btn-info" role="button">优惠设置</a>
			   </c:if>
		    </div>
			<!-- 切换 -->
			<div class="table-wrapper">
				<form id="editItemForm" class="form-horizontal media-control" action="${ctx}/reach/editItemData" method="post">
					<div class="horizontal_wrapper">
						<input type="hidden" id="discountId"  value="${id}" name="id">
						<div class="form-group">
							<label class="col-sm-2 control-label"><span class="red bigred">*</span>活动商品：</label>
							<div class="col-sm-9">
								<!-- start -->
								<div class="row margin-left">
									<div class="col-sm-3" style="padding-left:0px;">
										<select class="form-control" id="productType" name="productType">
											<option <c:if test="${orgReach!=null and orgReach.productType==1}">selected</c:if> value="1">全场通用</option>
											<option <c:if test="${orgReach!=null and orgReach.productType==2}">selected</c:if> value="2">指定类别</option>
											<option <c:if test="${orgReach!=null and orgReach.productType==3}">selected</c:if> value="3">指定商品</option>
										</select>
									</div>
									<div id="showProduct" class="col-sm-3" style="padding-left:0px;">
									    <button  type="button" style="display: <c:if test="${orgReach.productType eq 3}">block</c:if><c:if test="${orgReach.productType ne 3}">none</c:if>" class="btn btn-info">查看指定商品</button>
									</div>
									<div id="productInfo" class="col-sm-3" style="padding-left:0px;">
									    <span class="red"  >&nbsp;默认活动商品为全场通用</span>
									</div>
									<div class="col-sm-3 productTypeClass" style="display: <c:if test='${not empty orgReach  and orgReach.productType eq 2}'>block</c:if><c:if test='${empty orgReach or orgReach.productType ne 2}'>none</c:if>;">
										<div class="form-group">
											<select class="form-control" id="listClass">
												<c:forEach var="clazz" items="${listClass}">
													<option value="${clazz.classId}" data-name="${clazz.className}" 
														<c:forEach var="classSelectedCompare" items="${listClassSelected}">
															<c:if test="${(clazz.classId eq classSelectedCompare.classId) or(clazz.classParent eq classSelectedCompare.classId)}">disabled</c:if>
														</c:forEach>
													data-parent="${clazz.classParent}"><c:if test="${clazz.classLevel==2}">&nbsp;&nbsp;&nbsp;&nbsp;</c:if>${clazz.className}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="col-sm-3 productTypeClass" style="display: <c:if test='${not empty orgReach and orgReach.productType eq 2}'>block</c:if><c:if test='${empty orgReach  or orgReach.productType ne 2}'>none</c:if>;">
										<button type="button" class="btn btn-info" id="classAdd">添加</button>
									</div>
								</div>
								<div class="row margin-left productTypeClass" style="display: <c:if test='${not empty orgReach and orgReach.productType eq 2}'>block</c:if><c:if test='${empty orgReach or orgReach.productType ne 2}'>none</c:if>;">
									<div class="col-sm-11" style="padding-left:0px;" id="divClass">
										已选择分类：
										<c:if test="${not empty orgReach and orgReach.productType eq 2}">
											<c:forEach items="${listClassSelected}" var="classSelected">
												<span class="s9">
													<input type="hidden" name="listClass" data-parent="${classSelected.classParent}" value="${classSelected.classId}">${classSelected.className}
													<i class="glyphicon glyphicon-remove-sign red"></i>
												</span>
											</c:forEach>
										</c:if>
									</div>
								</div>
								<!-- end -->
							</div>
						</div>
					</div>
				<br />
				<p class="text-center margin5">
					<input type="hidden" id="listGoods" name="listGoods">
					<a type="button" href="${ctx}/reach/list" class="btn btn-default">返回</a>
					<button type="button" onclick="submit()" class="btn btn-info">保存</button>
				</p>
			</form>
			</div>
		</div>
	</div>
</div>

<%@ include file="../common/common_js.jsp"%>
<script type="text/javascript" src="${jsBase}/reach/editItem.js"></script>
</body>
</html>