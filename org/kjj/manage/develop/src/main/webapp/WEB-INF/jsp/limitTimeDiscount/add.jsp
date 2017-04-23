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
<title>添加限时折扣</title>
</head>
<body>
<form class="form-horizontal media-control" id="limitTimeDiscount_add" action="${ctx}/limitTimeDiscount/add" method="post">
<div class="page-wrapper">
<div class="container-fluid">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">运营</a></li>
		<li ><a href="${ctx}/limitTimeDiscount/list">限时折扣管理</a></li>
		<li class="active">添加限时折扣</li>
	</ul>
	
	<div class="panel panel-default">
		<div class="panel-heading">添加限时折扣</div>
		<div class="panel-body">
			<div class="form-group">
				<label class="col-sm-2 control-label" ><span class="red bigred">*</span>名称：</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="name" name="name"
						required data-bv-notempty-message="名称不能为空"
						maxlength="30" data-bv-stringlength-message="名称长度不能大于30"/>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label" ><span class="red bigred">*</span>显示标题：</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="title" name="title"
						required data-bv-notempty-message="标题不能为空"
						maxlength="16" data-bv-stringlength-message="名称长度不能大于16"/>
				</div>
				<div class="col-sm-5"><span class="gray g1">显示标题不能超过16个字符 例：<a class="yellowbc">5折大促</a></span></div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label" ><span class="red bigred">*</span>日期设置：</label>
				<div class="col-sm-3">
					<input type="text" class="form-control date" id="startDate" name="startDate" value="<fmt:formatDate type='date' value='${now}'/>"
						required data-bv-notempty-message="开始日期不能为空"/>
				</div>
				<div class="col-sm-1">~</div>
				<div class="col-sm-3">
					<input type="text" class="form-control date" id="endDate" name="endDate" value="<fmt:formatDate type='date' value='${now}'/>"
						required data-bv-notempty-message="结束日期不能为空"/>
				</div>
				<div class="col-sm-3"><span class="gray g1">开始日期不能早于当前日期，结束日期不能早于开始日期</span></div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label" ><span class="red bigred">*</span>时刻设置：</label>
				<div class="col-sm-3">
					<input type="text" class="form-control time" id="startTime" name="startTime" value="00:00:00"
						required data-bv-notempty-message="开始时刻不能为空"/>
				</div>
				<div class="col-sm-1">~</div>
				<div class="col-sm-3">
					<input type="text" class="form-control time" id="endTime" name="endTime" value="23:59:59"
						required data-bv-notempty-message="结束时刻不能为空"/>
				</div>
				<div class="col-sm-3"><span class="gray g1">结束时刻不能早于开始时刻</span></div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label" >同时优惠：</label>
				<div class="col-sm-6">
					<p>
						<label class="checkbox-inline">
							<input type="checkbox" name="listAllow" value="2" checked="checked"/>优惠券
						</label>	
						<label class="checkbox-inline">
							<input type="checkbox" name="listAllow" value="3" checked="checked"/>红包
						</label>
						<label class="checkbox-inline">
							<input type="checkbox" name="listAllow" value="4" checked="checked"/>组合销售
						</label>
						<label class="checkbox-inline">
							<input type="checkbox" name="listAllow" value="5" checked="checked"/>满减满送	
						</label>
					</p>
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
				
				<div class="col-sm-3 shop_type_city" style="display:none">
					<select class="form-control" id="listCity" name="listCity">
						<option value="110100">北京</option>
					</select>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label" >秒杀：</label>
				<div class="col-sm-6">
					<p>
						<label class="checkbox-inline">
							<input type="checkbox" id="seckill" name="seckill" value="1"/>是
						</label>
						<span class="gray g1">选择秒杀，商品不能加入购物车，前台显示【立即抢购】按钮。</span>
					</p>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label" >付款时长：</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="seckillTimeLength" name="seckillTimeLength"
						min="1" max="99999"/>
				</div>
				<div class="col-sm-5"><span class="gray g1">分钟。限时抢购时的付款时间，超过付款时间订单自动关闭</span></div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label" >判断手机：</label>
				<div class="col-sm-9">
					<p>
						<label class="checkbox-inline">
							<input type="checkbox" id="checkPhone" name="checkPhone" value="1" checked="checked"/>是				
						</label>	
						<span class="gray g1">选择是时，会员绑定手机才可以参加限时折扣活动</span>
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
			
		</div>
	</div>
	<div class="text-center">
		<a type="button" class="btn btn-primary" role="button" href="${ctx}/limitTimeDiscount/list" style="margin-right:30px">返回</a>
		<button type="submit" class="btn btn-primary " >确定</button>
	</div>
</div>
</div>
</form>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/limitTimeDiscount/add.js" type="text/javascript"></script>
</body>
</html>