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
<title>发放优惠券</title>
</head>
<body>
<form class="form-horizontal media-control" id="trigger_add" action="${ctx}/coupon/triggerAdd" method="post">
<div class="page-wrapper goods-control">
<div class="container-fluid">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">运营</a></li>
		<li ><a href="${ctx}/coupon/list">优惠券管理</a></li>
		<li class="active">添加触发券</li>
	</ul>
	
	<br/>
	
	<div class="group-button">
		<a role="button" class="btn btn-default" href="${ctx}/coupon/giveInit/${orgCoupon.couponId}">普通券</a>
		<a role="button" class="btn btn-primary" href="javascript:void(0);">触发券</a>
	</div>
	
	<div class="panel panel-default">
		<div class="panel-heading">添加触发券</div>
		<div class="panel-body">
		
			<div class="form-group">
				<label class="col-sm-2 control-label" >优惠券：</label>
				<div class="col-sm-9">
					<div class="col-sm-12">
						<div class="td-item">
							<div class="td-item-right">
								<input type="hidden" name="discountId" value="${orgCoupon.couponId}"/>
								<input type="hidden" name="typeId" value="2"/>
								<p>${orgCoupon.couponName}</p>
								<p><span class="big-red"><fmt:formatNumber type="currency" pattern="0.00元" value="${orgCoupon.discountMoney}"/></span>，满<fmt:formatNumber type="currency" pattern="0.00元" value="${orgCoupon.conditionMoney}"/>可用</p>
								<p class="p-span4">
									<span>
										<c:if test="${orgCoupon.productType==1}"><span>全场商品</span></c:if>
										<c:if test="${orgCoupon.productType==2}"><span>指定分类</span></c:if>
										<c:if test="${orgCoupon.productType==3}"><span>指定商品</span></c:if>
									</span>
									<span>
										<c:if test="${orgCoupon.shopType==1}"><span>全部区域</span></c:if>
										<c:if test="${orgCoupon.shopType==2}"><span>单区域</span></c:if>
										<c:if test="${orgCoupon.shopType==3}"><span>部分门店</span></c:if>
									</span>
								</p>
								<p>有效期：	
									<c:if test="${empty orgCoupon.limitDays}">
										<span> <fmt:formatDate value="${orgCoupon.startTime}" type="both"/></span>
										<span>~</span>
										<span> <fmt:formatDate value="${orgCoupon.endTime}" type="both"/></span>
									</c:if>
									<c:if test="${!empty orgCoupon.limitDays}">
										<span>绑定时间开始${orgCoupon.limitDays}天内有效</span>
									</c:if>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
				
			<div class="form-group">
				<label class="col-sm-2 control-label">发放对象：</label>
				<div class="col-sm-9">
					<div class="col-sm-3">
						<select name="triggerType" id="triggerType">
							<!-- <option value="0">请选择</option> -->
							<option value="1">限定注册日期</option>
						</select>
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">时间设置：</label>
				<div class="col-sm-9">
					<div class="col-sm-4">
					<input type="text" class="form-control date" name="startTime" id="startTime" <c:if test="${orgCoupon.startTime!=null}">value="<fmt:formatDate type='both' value='${orgCoupon.startTime}' pattern="yyyy-MM-dd HH:mm:ss"/>"</c:if>
						required data-bv-notempty-message="开始时间不能为空"/>
					</div>
					<div class="col-sm-1">-</div>
					<div class="col-sm-4">
					<input type="text" class="form-control date" name="endTime" id="endTime" <c:if test="${orgCoupon.endTime!=null}">value="<fmt:formatDate type='both' value='${orgCoupon.endTime}' pattern="yyyy-MM-dd HH:mm:ss"/>"</c:if>
						required data-bv-notempty-message="结束时间 不能为空"/>
					</div>
					<div class="col-sm-5"><span class="gray g1">发放给在此期间注册的会员</span></div>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label" ><span class="red bigred">*</span>张数：</label>	
				<div class="col-sm-9">
					<div class="col-sm-3">
						<input type="text" class="form-control col-sm-3" name="triggerAmount" value="1"
							required data-bv-notempty-message="张数不能为空"
							pattern="^[1-9][0-9]*$" data-bv-regexp-message="张数应为数字"
							type="range" min="1" max="127"/>
					</div>
					<div class="col-sm-6"><span class="gray g1">发送张数，至少为1张</span></div>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label" ><span class="red bigred">*</span>发放原因：</label>	
				<div class="col-sm-9">
					<div class="col-sm-12">
						<textarea rows="5" style="width:50%;resize: none;" name="reason" maxlength="200" onkeyup="checkTextAreaLength(this,200)" onblur="checkTextAreaLength(this,200)"></textarea>
					</div>
				</div>
			</div>
			</div>
		</div>
	</div>
	
	<p class="text-center margin5">
		<a type="button" class="btn btn-primary" role="button" href="${ctx}/coupon/list" style="margin-right:30px">返回</a>
		<button type="submit" class="btn btn-primary">确定</button>
	</p>
</div>
</div>
</form>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/coupon/triggerAdd.js" type="text/javascript"></script>
</body>
</html>