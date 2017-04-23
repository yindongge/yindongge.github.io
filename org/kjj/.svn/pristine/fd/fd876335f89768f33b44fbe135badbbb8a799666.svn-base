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

<title>满减满送-添加基本信息</title>
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
			   <a href="javascript:void(0);" class="btn btn-primary " role="button">基本信息</a>
			   <a href="${ctx}/reach/editItem?id=${orgReach.id}" class="btn btn-info" role="button">活动商品</a>
			   <a href="${ctx}/reach/editSet?id=${orgReach.id}" class="btn btn-info" role="button">优惠设置</a>
		    </div>
			<!-- 切换 -->
			<div class="table-wrapper">
				<div class="horizontal_wrapper">
					<form id="addInfoForm" action="${ctx}/reach/editInfoData" method="get" class="form-horizontal  media-control">
						<div class="form-group">
							<label class="col-sm-2 control-label"><span class="red">*</span>活动名称：</label>
							<div class="col-sm-4">
								<input type="text" name="name" value="${orgReach.name}" class="form-control" required maxlength="30">
							</div>
							<div class="col-sm-3" style="margin-top:5px">
							    <span class="red">限制输入30个字符</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label"><span class="red">*</span>活动标签：</label>
							<div class="col-sm-4">
								<input type="text" name="label" value="${orgReach.label}" class="form-control" required maxlength="5">
							</div>
							<div class="col-sm-3" style="margin-top:5px">
							    <span class="red">限制输入5个字符</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label"><span class="red">*</span>显示标题：</label>
							<div class="col-sm-4">
								<input type="text" name="title" value="${orgReach.title}" class="form-control" required maxlength="50">
							</div>
							<div class="col-sm-3" style="margin-top:5px">
							    <span class="red">限制输入50个字符</span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label"><span class="red">*</span>活动时间：</label>
							<div class="con-sm-6">
								<label>从</label>
								<input type="text" id="startDateTime" value='<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${orgReach.startTime}"/>' name="startTime" class="special_form datetime" required >
								<label>到</label>
								<input type="text" id="endDateTime" value='<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${orgReach.endTime}"/>' name="endTime" class="special_form datetime" required >
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label"><span class="red">*</span>活动类型：</label>
							<div class="col-sm-4">
								<label class="radio-inline">
								  <input type="radio"  name="reachStyle" <c:if test="${orgReach.reachStyle==0}">checked</c:if>  value="0"> 金额
								</label>
								<label class="radio-inline">
								  <input type="radio" name="reachStyle" <c:if test="${orgReach.reachStyle==1}">checked</c:if> value="1"> 件数
								</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">同时优惠：</label>
							<div class="col-sm-3">
								<label class="checkbox-inline">
									<input type="checkbox" name="listAllow" <c:if test="${fn:contains(orgDiscountAllowStr,'2')}">checked</c:if> value="2" />优惠券 
								</label>	
								<label class="checkbox-inline">
									<input type="checkbox" name="listAllow" <c:if test="${fn:contains(orgDiscountAllowStr,'3')}">checked</c:if> value="3"  />红包
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" name="listAllow" <c:if test="${fn:contains(orgDiscountAllowStr,'4')}">checked</c:if> value="4"  />组合销售
								</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label"><span class="red">*</span>活动范围：</label>
							<div class="col-sm-3">
								<select id="shopType"  class="form-control" name="shopType">
									<option value="1" <c:if test="${orgReach.shopType==1}">selected</c:if> >全部区域</option>
									<option value="2" <c:if test="${orgReach.shopType==2}">selected</c:if> >单区域</option>
									<option value="3" <c:if test="${orgReach.shopType==3}">selected</c:if> >单区域门店</option>
								</select>
								<input type="hidden" name="listShop" value='<c:if test="${fn:length(orgDiscountShopMap.shopIds)>0}">${orgDiscountShopMap.shopIds}</c:if>' id="listShop"/>	
							</div>
							<div class="col-sm-3 shopTypeCity" style='display:<c:if test="${orgReach.shopType ne 2}">none</c:if><c:if test="${orgReach.shopType eq 2}">block</c:if>'>
								<select class="form-control" id="listCity" name="listCity">
									<option value="110100">北京</option>
								</select>
							</div>							
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">适用终端：</label>
							<div class="col-sm-4">
								<label class="checkbox-inline">
								  <input type="checkbox"  name="listScope" <c:if test="${fn:contains(orgDiscountScopeStr,'1')}">checked</c:if> value="1"> PC端
								</label>
								<label class="checkbox-inline">
								  <input type="checkbox"  name="listScope" <c:if test="${fn:contains(orgDiscountScopeStr,'2')}">checked</c:if> value="2"> 微信
								</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label"></label>
							<div class="col-sm-6">
								<input type="hidden" value="${orgReach.id}" name="id">
								<button type="submit"  class="btn btn-info" style="margin-right:20px">保存</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="../common/common_js.jsp"%>
<script type="text/javascript" src="${jsBase}/reach/editInfo.js"></script>
</body>
</html>