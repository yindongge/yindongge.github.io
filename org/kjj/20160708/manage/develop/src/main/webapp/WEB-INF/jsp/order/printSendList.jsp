<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<%@include file="../common/common_css.jsp" %>
<title>送货单</title>
</head>
<body>	
<div id="printDiv">
	<div class="alertbox" >
		<div class="container-fluid ">
			<div class="row alertcontrol">
				<div class="col-sm-3">
					<img src="${ctx }/source/img/checklogo.png" class="imgadd"/>
				</div>
				<div class="col-sm-4 text-center">
					<span class="blacklist">送货单</span>
				</div>
				<div class="col-sm-5 text-center">
						<%-- <div class="yiweima"><img src="${ctx }/jsp/img/icon6.jpg"/></div> --%>
				</div>
			</div>
			<!--  -->
			<div class="row row5">
			<div class="col-md-12">
					<span>订单编号：</span>
					<span>${order.orderId}</span>
				</div>
				<div class="col-md-12">
					<span>下单时间：</span>
					<span><fmt:formatDate value="${order.createTime}" type="both"/></span>
				</div>
				<div class="col-md-12">
					<span>商品总数：</span>
					<span class="strong">${order.totalNum}</span>
				</div>
				<c:if test="${not empty order.remark}">
					<div class="col-md-12">
						<span>备注：</span>
						<span>${order.remark}</span>
					</div>
				</c:if>
			</div>
			<div class="row row6">
				<div class="col-sm-6">
					<span>客户姓名：</span>
					<span>${order.consignee}</span>
				</div>
				<div class="col-sm-6">
					<span>客户电话：</span>
					<span>${order.consigneeMobile}</span>
				</div>
				<div class="col-sm-12">
					<span>客户地址：</span>
					<span>${order.consigneeAddress}</span>
				</div>
				<div class="col-sm-6">
					<span>店铺名称：</span>
					<span>${order.orgShop.shopCode}（${order.orgShop.shopName}）</span>
				</div>
				<div class="col-sm-6">
					<span>配送时间：</span>
					<span><fmt:formatDate value="${order.sendDate}" pattern="YYYY-MM-dd"/> <fmt:formatDate value="${order.sendTimeStart}" pattern="HH:mm:ss"/>-<fmt:formatDate value="${order.sendTimeEnd}" pattern="HH:mm:ss"/></span>
				</div>
			</div>
			<table class="table  table-striped " style="margin-bottom:10px;">
				<thead>
					<tr>
						<th>商品名称</th>
						<th style="width:85px;">条形码</th>
						<th style="width:60px;">原价</th>
						<th style="width:60px;">售价</th>
						<th style="width:30px;">数量</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${order.listOrderGoods }" var="orderGoods">
						<tr>
							<td class="text-left">${orderGoods.orgProductItem.goodsName}</td>
							<td class="text-center">${orderGoods.barCode}</td>
							<td class="text-right">￥${orderGoods.unitAccounts}</td>
							<td class="text-right">￥${orderGoods.unitPrice}</td>
							<td class="text-center">×${orderGoods.amount}</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="5" class="spantop text-left">
							<span>配送费：<em>￥${order.sendMoney}</em></span>
							<span>已优惠：<em>￥${order.discount}</em></span>
							<span>使用预存款：<em>￥${order.depositMoney}</em></span>
							<c:if test="${order.payStatus==0}">
								<span>已付：<em>￥0.00</em></span>
								<span>应收：<em class="red">￥${order.payMoney}</em></span>
							</c:if>
							<c:if test="${order.payStatus==1}">
								<span>已付：<em>￥${order.payMoney}</em></span>
								<span>应收：<em class="red">￥0.00</em></span>
							</c:if>
						</td>
					</tr>
				</tbody>
			</table>
			
			<div class="qianzi">
				<span>客户签字：</span>
			</div>
		</div>
	</div>		
	<div style="page-break-after: always;"></div>
</div>
<p class="text-center">
	<a role="button" class="btn btn-info" href="javascript:void(0);" onclick="printdiv('printDiv');">打印</a>
	<a role="button" class="btn btn-info" href="javascript:history.back(-1);">返回</a>
</p>
<script type="text/javascript">
function printme() {
	document.body.innerHTML=document.getElementById('printDiv').innerHTML; 
	window.print(); 
}; 

function printdiv(printpage)
{
	var headstr = '<html><head>'
				+'<title></title></head><body>';
	var footstr = '</body><html>';
	var newstr = document.all.item(printpage).innerHTML;
	var oldstr = document.body.innerHTML;
	document.body.innerHTML = headstr+newstr+footstr;
	window.print(); 
	document.body.innerHTML = oldstr;
	return false;
}
</script>
</body>
</html>