<%@page import="org.springframework.context.annotation.Import"%>
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
<title>编辑优惠券</title>
</head>
<body>
<form class="form-horizontal media-control" id="couponEdit" action="${ctx}/coupon/edit" method="post">
<div class="page-wrapper">
<div class="container-fluid">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">运营</a></li>
		<li class="active"><a href="${ctx}/coupon/list">优惠券管理</a></li>
		<li class="active">编辑优惠券</li>
	</ul>
	
	<div class="panel panel-default">
		<div class="panel-heading">编辑优惠券</div>
		<div class="panel-body">
			<input type="hidden" name="couponId" value="${coupon.couponId}"/>
			<input type="hidden" name="status" value="${coupon.status}"/>
			<div class="form-group">
				<label class="col-sm-2 control-label" ><span class="red bigred">*</span>名称：</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="couponName" name="couponName" value="${coupon.couponName}"
						required data-bv-notempty-message="名称不能为空"
						maxlength="30" data-bv-stringlength-message="名称长度不能大于30"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" ><span class="red bigred">*</span>有效期:</label>	
				<div class="col-sm-3">
					<select class='form-control' id="timeType" name="timeType">
						<c:if test="${empty coupon.limitDays}"><option class="span21" value="0">指定日期</option></c:if>
						<c:if test="${!empty coupon.limitDays}"><option class="span22" value="1">有效时常</option></c:if>
					</select>
				</div>
				<c:if test="${empty coupon.limitDays}">
				<div class="col-sm-3 time_type_start_end ">
					<input type="text" class="form-control date" id="startTime" name="startTime" value="<fmt:formatDate type='both' value='${coupon.startTime}' pattern="yyyy-MM-dd HH:mm:ss"/>"/>
				</div>
				<div class="col-sm-1 time_type_start_end" style="text-align:center">至</div>
				<div class="col-sm-3 time_type_start_end">
					<input type="text" class="form-control date" id="endTime" name="endTime" value="<fmt:formatDate type='both' value='${coupon.endTime}' pattern="yyyy-MM-dd HH:mm:ss"/>"/>
				</div>
				</c:if>
				<c:if test="${!empty coupon.limitDays}">
				<!-- 如果是有效时常的话，隐藏中 -->
				<div class="col-sm-2 time_type_limit_days">
					<input type="text" class="form-control" name="limitDays" value="${coupon.limitDays}"
						pattern="^[1-9][0-9]*$" data-bv-regexp-message="有效时长应为数字"
						type="range" min="1" max="999"/>
				</div>
				<div class="com-sm-5 span23 time_type_limit_days">天，自注册日起 X 天内有效</div>
				</c:if>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" ><span class="red bigred">*</span>面额:</label>	
				<div class="col-sm-3">
					<input type="text" class="form-control" placeholder="元" id="discountMoney" name="discountMoney" value="${coupon.discountMoney}" readonly="readonly"
						required data-bv-notempty-message="面额不能为空"
						type="range" min="0.01" max="999999.99"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" ><span class="red bigred">*</span>消费金额:</label>	
				<div class="col-sm-3">
					<input type="text" class="form-control" placeholder="元" id="conditionMoney" name="conditionMoney" value="${coupon.conditionMoney}" readonly="readonly"
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
					<input type="text" class="form-control" id="amount" name="amount" value="${coupon.amount}" readonly="readonly"
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
					<input type="text" class="form-control" id="userLimit" name="userLimit" value="${coupon.userLimit}" readonly="readonly"
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
						maxlength="200" onkeyup="checkTextAreaLength(this,200)" onblur="checkTextAreaLength(this,200)">${coupon.couponDesc}</textarea>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" ><span class="red bigred">*</span>适用范围:</label>
				<div class="col-sm-3">
					<select class="form-control" id="shopType" name="shopType">
						<!-- <option value="0">选择范围</option> -->
						<c:if test="${coupon.shopType==1}"><option value="1">全部区域</option></c:if>
						<c:if test="${coupon.shopType==2}"><option value="2">单区域</option></c:if>
						<c:if test="${coupon.shopType==3}"><option value="3">单区域门店</option></c:if>
					</select>
					<input type="hidden" name="listShop" id="listShop" value="${listShop}"/>		
				</div>
				<c:if test="${coupon.shopType==2}">
				<div class="col-sm-3 shop_type_city">
					<select class="form-control" id="listCity" name="listCity">
						<option value="110100">北京</option>
					</select>
				</div>
				</c:if>
			</div>
		
			<div class="form-group">
				<label class="col-sm-2 control-label" ><span class="red bigred">*</span>类型：</label>	
				<div class="col-sm-9" >
					<div class="row margin-left">
						<div class="col-sm-3" style="padding-left:0px;">
							<select class="form-control" id="productType" name="productType">
								<!-- <option value="0">选择类型</option> -->
								<c:if test="${coupon.productType==1}"><option value="1">全场通用</option></c:if>
								<c:if test="${coupon.productType==2}"><option value="2">指定类别</option></c:if>
								<c:if test="${coupon.productType==3}"><option value="3">指定商品</option></c:if>
							</select>
						</div>
						<c:if test="${coupon.productType==2}">
						<div class="col-sm-3 product_type_class">
							<div class="form-group">
								<select class="form-control" id="listClass">
								<c:forEach var="clazz" items="${listClass}">
									<option value="${clazz.classId}" data-name="${clazz.className}" data-parent="${clazz.classParent}" <c:if test="${mapDiscountProduct[clazz.classId]!=null or mapDiscountProduct[clazz.classParent]!=null}">disabled="disabled"</c:if>><c:if test="${clazz.classLevel==2}">&nbsp;&nbsp;&nbsp;&nbsp;</c:if>${clazz.className}</option>
								</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-sm-3 product_type_class">
							<button type="button" class="btn btn-info" id="classAdd">添加</button>
						</div>
						</c:if>
					</div>
					<c:if test="${coupon.productType==2}">
					<div class="row margin-left product_type_class">
						<div class="col-sm-11" style="padding-left:0px;" id="divClass">
							已选择分类：
							<c:forEach var="discountProduct" items="${mapDiscountProduct}">
							<span class='s9'>
    						<input type='hidden' name='listClass' data-parent='${discountProduct.value.classParent}' value='${discountProduct.value.classId}'/>
    						${discountProduct.value.className}<i class='glyphicon glyphicon-remove-sign red'></i>
    						</span>
    						</c:forEach>
						</div>
					</div>
					</c:if>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" >判断手机：</label>
				<div class="col-sm-9">
					<p>
						<label class="checkbox-inline">
							<input type="checkbox" id="checkPhone" name="checkPhone" value="1" <c:if test="${coupon.checkPhone==1}">checked="checked"</c:if>/>是				
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
							<input type="checkbox" name="listScope" value="1" <c:if test="${scopePc}">checked="checked"</c:if>/>PC端		
						</label>	
						<label class="checkbox-inline">
							<input type="checkbox" name="listScope" value="2" <c:if test="${scopeMobile}">checked="checked"</c:if>/>触屏版				
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
<script src="${jsBase}/coupon/edit.js" type="text/javascript"></script>
</body>
</html>