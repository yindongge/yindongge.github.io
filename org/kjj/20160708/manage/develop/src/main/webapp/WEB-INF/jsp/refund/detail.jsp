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
<title>退款详情</title>
</head>
<body>
<div class="page-wrapper goods-control">
<div class="container-fluid">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">交易</a></li>
		<li class="active"><a href="${ctx}/refund/list">退款管理</a></li>	
		<li class="active">退款详情</li>
	</ul>
	<br/>
	<table class="table table-hover table-bordered ">
		<thead>
			<tr class="info">				
				<th width="150px;">基本信息</th>
				<th></th>
				<th width="150px"></th>
				<th></th>
				<th width="150px;"></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td  class="strong-b">退款单号：</td>
				<td>${refundOrder.refundOrderId}</td>
				<td  class="strong-b">订单号：</td>
				<td>${refundOrder.orderId}</td>
				<td  class="strong-b">退货单号：</td>
				<td>
					<c:if test="${refundOrder.returnOrderId!=0}">${refundOrder.returnOrderId}</c:if>
				</td>
			</tr>
			<tr>
				<td class="strong-b">退款金额：</td>
				<td><fmt:formatNumber type="currency" pattern="￥0.00" value="${refundOrder.goodsPayMoney}"/></td>
				<td  class="strong-b">实际退款金额：</td>
				<td><fmt:formatNumber type="currency" pattern="￥0.00" value="${refundOrder.refundMoney}"/></td>
				<td  class="strong-b">店铺：</td>
				<td>${refundOrder.shopName}</td>
			</tr>
			<tr>
				<td class="strong-b">申请时间：</td>
				<td><fmt:formatDate value="${refundOrder.createTime}" type="both"/></td>
				<td class="strong-b">退款方式：</td>
				<td>
					<c:if test="${refundOrder.refundStyle==0}">
						<c:if test="${refundOrder.onlineRefundStyle==1}">支</c:if>
						<c:if test="${refundOrder.onlineRefundStyle==2}">微</c:if>
						<c:if test="${refundOrder.onlineRefundStyle==3}">财</c:if>
						<c:if test="${refundOrder.onlineRefundStyle==4}">银联</c:if>
						<c:if test="${refundOrder.onlineRefundStyle==5}">微</c:if>
						<c:if test="${refundOrder.onlineRefundStyle==6}">支</c:if>
					</c:if>
					<c:if test="${refundOrder.refundStyle==1}">本地
					</c:if>
					<c:if test="${refundOrder.refundStyle==2}">预
					</c:if>
				</td>
				<td  class="strong-b">处理状态：</td>
				<td>
					<c:if test="${refundOrder.refundStatus==0}">退款中</c:if>
					<c:if test="${refundOrder.refundStatus==1}">已退款</c:if>
				</td>
			</tr>
		</tbody>
		<thead>
			<tr class="info">				
				<th width="150px;">操作信息</th>
				<th></th>
				<th width="150px"></th>
				<th></th>
				<th width="150px;"></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr class="tr11">
				<td class="strong-b">备注：
					<input type="hidden" id="refundOrderId" name="refundOrderId" value="${refundOrder.refundOrderId}"/>
				</td>
				<td colspan="3" style="text-align:left;">
					<textarea rows="6" style="width:500px;;resize: none;" id="remark" maxlength="200" onkeyup="checkTextAreaLength(this,200)" onblur="checkTextAreaLength(this,200)"></textarea>
					<br/>
					<c:if test="${refundOrder.refundStatus==0}"><button id="btnFinish">完成</button></c:if>
				</td>
				<td class="strong-b"></td>
				<td></td>
			</tr>
		</tbody>
		<c:if test="${refundOrder.refundStatus==1}">
		<thead>
			<tr class="info">				
				<th width="150px;">操作员</th>
				<th>操作时间</th>
				<th width="150px">处理信息</th>
				<th>备注</th>
				<th width="150px;"></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="strong-b">
					<c:if test="${empty refundOrder.adminName}">系统</c:if>
					<c:if test="${!empty refundOrder.adminName}">${refundOrder.adminName}</c:if>
				</td>
				<td><fmt:formatDate value="${refundOrder.refundTime}" type="both"/></td>
				<td>退款完成</td>
				<td colspan="3">${refundOrder.remark}</td>
			</tr>
		</tbody>
		</c:if>
	</table>
	
	<div class="text-center">
		<a role="button" class="btn btn-info" href="${ctx}/refund/list">返回</a>
	</div>
	
</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/refund/detail.js" type="text/javascript"></script>
</body>
</html>
