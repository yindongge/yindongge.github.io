<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<c:set var="now" value="<%=new java.util.Date()%>" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<%@include file="../common/common_css.jsp" %>
<title>添加优惠券</title>
</head>
<body>
<form class="form-horizontal media-control" id="couponAdd" action="${ctx}/coupon/add" method="post">
<div class="page-wrapper">
<div class="container-fluid">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">运营</a></li>
		<li class="active"><a href="${ctx}/coupon/list">优惠券管理</a></li>
		<li class="active">添加优惠券</li>
	</ul>
	
	<div class="panel panel-default">
		<div class="panel-heading">添加优惠券</div>
		<div class="panel-body">
			<div class="form-group">
				<label class="col-sm-2 control-label" ><span class="red bigred">*</span>名称：</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="couponName" name="couponName"
						required data-bv-notempty-message="名称不能为空"
						maxlength="30" data-bv-stringlength-message="名称长度不能大于30"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" ><span class="red bigred">*</span>有效期:</label>	
				<div class="col-sm-3">
					<select class='form-control' id="timeType" name="timeType">
						<option class="span21" value="0">指定日期</option>
						<option class="span22" value="1">有效时常</option>
					</select>
				</div>
				<div class="col-sm-3 timeTypeStartEnd ">
					<input type="text" class="form-control date" id="startTime" name="startTime" value="<fmt:formatDate type='date' value='${now}'/> 00:00:00"/>
				</div>
				<div class="col-sm-1 timeTypeStartEnd" style="text-align:center">至</div>
				<div class="col-sm-3 timeTypeStartEnd">
					<input type="text" class="form-control date" id="endTime" name="endTime" value="<fmt:formatDate type='date' value='${now}'/> 23:59:59"/>
				</div>
				<!-- 如果是有效时常的话，隐藏中 -->
				<div class="col-sm-2 timeTypeLimitDays" style="display:none">
					<input type="text" class="form-control" name="limitDays"
						pattern="^[1-9][0-9]*$" data-bv-regexp-message="有效时长应为数字"
						type="range" min="1" max="999"/>
				</div>
				<div class="com-sm-5 span23 timeTypeLimitDays" style="display:none">天，自注册日起 X 天内有效</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" ><span class="red bigred">*</span>面额:</label>	
				<div class="col-sm-3">
					<input type="text" class="form-control" placeholder="元" id="discountMoney" name="discountMoney"
						required data-bv-notempty-message="面额不能为空"
						type="range" min="0.01" max="999999.99"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" ><span class="red bigred">*</span>消费金额:</label>	
				<div class="col-sm-3">
					<input type="text" class="form-control" placeholder="元" id="conditionMoney" name="conditionMoney"
						required data-bv-notempty-message="消费金额不能为空"
						type="range" min="0.01" max="999999.99"/>
				</div>
				<div class="col-sm-4">
					<span class="gray">满足消费金额才能使用优惠券</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" ><span class="red bigred">*</span>生成数量:</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="amount" name="amount" value="0"
						required data-bv-notempty-message="生成数量 不能为空"
						pattern="^[0-9]*$" data-bv-regexp-message="生成数量应为数字"
						type="range" min="0" max="9999999999"/>
				</div>
				<div class="col-sm-4">
					<span class="gray">0为无限制，单次不能大于1,000,000</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" >每人限领:</label>	
				<div class="col-sm-3">
					<input type="text" class="form-control" id="userLimit" name="userLimit" value="0"
						required data-bv-notempty-message="每人限领 不能为空"
						pattern="^[0-9]*$" data-bv-regexp-message="每人限领应为数字"
						type="range" min="0" max="127"/>
				</div>
				<div class="col-sm-4">
					<span class="gray">0为无限制</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">代金券描述：</label>
				<div class="col-sm-6">
					<textarea rows="5" style="width:100%;resize: none;" id="couponDesc" name="couponDesc"
						maxlength="200" onkeyup="checkTextAreaLength(this,200)" onblur="checkTextAreaLength(this,200)"></textarea>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" ><span class="red bigred">*</span>适用范围:</label>
				<div class="col-sm-3">
					<select class="form-control" id="shopType" name="shopType">
						<!-- <option value="0">选择范围</option> -->
						<option value="1">全部区域</option>
						<option value="2">单区域</option>
						<option value="3">单区域门店</option>
					</select>
					<input type="hidden" name="listShop" id="listShop"/>		
				</div>
				
				<div class="col-sm-3 shopTypeCity" style="display:none">
					<select class="form-control" id="listCity" name="listCity">
						<option value="110100">北京</option>
					</select>
				</div>
			</div>
		
			<div class="form-group">
				<label class="col-sm-2 control-label" ><span class="red bigred">*</span>类型：</label>	
				<div class="col-sm-9" >
					<div class="row margin-left">
						<div class="col-sm-3" style="padding-left:0px;">
							<select class="form-control" id="productType" name="productType">
								<!-- <option value="0">选择类型</option> -->
								<option value="1">全场通用</option>
								<option value="2">指定类别</option>
								<option value="3">指定商品</option>
							</select>
						</div>
						<div class="col-sm-3 productTypeClass" style="display: none;">
							<div class="form-group">
								<select class="form-control" id="listClass">
								<c:forEach var="clazz" items="${listClass}">
									<option value="${clazz.classId}" data-name="${clazz.className}" data-parent="${clazz.classParent}"><c:if test="${clazz.classLevel==2}">&nbsp;&nbsp;&nbsp;&nbsp;</c:if>${clazz.className}</option>
								</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-sm-3 productTypeClass" style="display: none;">
							<button type="button" class="btn btn-info" id="classAdd">添加</button>
						</div>
					</div>
					<div class="row margin-left productTypeClass" style="display: none;">
						<div class="col-sm-11" style="padding-left:0px;" id="divClass">
							已选择分类：
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" >判断手机：</label>
				<div class="col-sm-9">
					<p>
						<label class="checkbox-inline">
							<input type="checkbox" id="checkPhone" name="checkPhone" value="1" checked="checked"/>是				
						</label>	
						<span class="gray g1">选择是时，会员绑定手机才能获取此优惠券</span>
					</p>
				</div>	
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" >适用终端：</label>	
				<div class="col-sm-9">
					<p>
						<label class="checkbox-inline">
							<input type="checkbox" name="listScope" value="1" checked="checked"/>PC端		
						</label>	
						<label class="checkbox-inline">
							<input type="checkbox" name="listScope" value="2" checked="checked"/>触屏版			
						</label>
					</p>
				</div>	
			</div>
			<!-- 分割线 -->
		</div>
	</div>
	<br/>
	<div class="text-center">
		<a type="button" class="btn btn-primary" role="button" href="${ctx}/coupon/list" style="margin-right:30px">返回</a>
		<button type="submit" class="btn btn-primary " >确定</button>
	</div>
	<br/>
</div>
</div>
</form>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/coupon/add.js" type="text/javascript"></script>
</body>
</html>