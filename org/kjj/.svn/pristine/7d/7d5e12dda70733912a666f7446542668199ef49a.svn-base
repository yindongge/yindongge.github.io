<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<%@include file="../common/common_css.jsp" %>
<title>订单管理</title>
</head>

<body>
<div class="page-wrapper goods-control">
<div class="container-fluid">
	<form class="form-inline" id ="pageform" name ="pageform" action="${ctx}/order/list" method="post">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">交易</a></li>
		<li class="active">订单管理</li>
	</ul>
	<div style="padding:5px;height:100px;background:#f5f5f5;">
		<div class="col-sm-12">
			<div class="form-group">
				<label>订单号：</label>
				<input type="text" class="form-control" name="orderIdLike" value="${query.orderIdLike}"/>			
			</div>
			<div class="form-group">
				<label>收货人：</label>
				<input type="text" class="form-control" name="consigneeLike" value="${query.consigneeLike}"/>			
			</div>
			<div class="form-group">
				<label>下单时间：</label>
				<input type="text" class="form-control date" id="createTimeStart" name="createTimeStart" value="<fmt:formatDate value="${query.createTimeStart}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>"/>-
				<input type="text" class="form-control date" id="createTimeEnd" name="createTimeEnd" value="<fmt:formatDate value="${query.createTimeEnd}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
			</div>
			
		</div>
		<div class="col-sm-12">
			<div class="form-group">
				<label>店铺：</label>
				<input type="text" class="form-control btn-click"/>
				<input type="hidden" name="shopSelect" id="shopSelect" 
					value="<c:forEach var="item" items="${query.shopSelect}" varStatus="status">${item}<c:if test="${!status.last}">,</c:if></c:forEach>"/>			
			</div>
			<div class="form-group">
				<label>提货码：</label>
				<input type="text" class="form-control" name="takeCodeLike" value="${query.takeCodeLike}"/>			
			</div>
			<div class="form-group radio-special2">
				<label>订单状态：</label>
				<select name="queryStatus">
					<option value="-1" <c:if test="${ query.queryStatus=='-1' }">selected</c:if>>请选择</option>
					<option value="0" <c:if test="${ query.queryStatus=='0' }">selected</c:if>>待付款</option>
					<option value="1" <c:if test="${ query.queryStatus=='1' }">selected</c:if>>待确认</option>
					<option value="12" <c:if test="${ query.queryStatus=='12' }">selected</c:if>>待发货</option>
					<option value="22" <c:if test="${ query.queryStatus=='22' }">selected</c:if>>备货中</option>
					<option value="13" <c:if test="${ query.queryStatus=='13' }">selected</c:if>>待收货</option>
					<option value="23" <c:if test="${ query.queryStatus=='23' }">selected</c:if>>待自提</option>
					<option value="4" <c:if test="${ query.queryStatus=='4' }">selected</c:if>>已完成</option>
					<option value="5" <c:if test="${ query.queryStatus=='5' }">selected</c:if>>已取消</option>
					<option value="6" <c:if test="${ query.queryStatus=='6' }">selected</c:if>>已关闭</option>
				</select>
			</div>
			<div class="form-group pull-right">
				<button type="submit" class="btn btn-info">搜索</button>	
			</div>
		</div>
	</div>
	<br/>
	<table class="table table-hover table-bordered ">
		<thead>
			<tr class="info">
				<th></th>
				<th>订单号</th>
				<th>用户名</th>
				<th>收货人</th>
				<th>店铺</th>
				<th>下单时间</th>
				<th>付款时间</th>
				<th>订单金额</th>
				<th>支付方式</th>
				<th>订单来源</th>
				<th>配送方式</th>
				<th>订单状态</th>
				<th style="width:100px;">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${page.content}" varStatus="status">
			<tr <c:if test="${item.waitSolveCount > 0}">style="opacity:0.2;filter:alpha(opacity=20);"</c:if>>
				<td>
					<input type="checkbox" name="orderIds" value="${item.orderId}" <c:if test="${item.waitSolveCount > 0}">disabled="disabled"</c:if>/>
				</td>
				<td>
					<c:if test="${item.finishSolveCount > 0 and item.waitSolveCount == 0}"><span style="color:red;">${item.orderId}</span></c:if>
					<c:if test="${item.finishSolveCount == 0 or item.waitSolveCount > 0}">${item.orderId}</c:if>
					<span class="yulan pull-right" data-toggle="dropdown">[预览]</span>
					<c:if test="${item.waitSolveCount == 0}">
					<div class="dropdown-menu yulan-hide" role="menu">
						<div class="table-content">
							<div class="table-left">
								<table class="table table-hover table-bordered ">
									<thead>
										<tr class="info ">
											<th colspan="6">预览详情</th>
										</tr>
									</thead>
									<tr class="active">
										<th width="100px;">商品货号</th>
										<th>商品</th>
										<th width="100px">单价（元）</th>
										<th width="50px;">数量</th>
										<th width="100px;">优惠（元）</th>
										<th width="100px;">小计（元）</th>
									</tr>
									<c:forEach var="orderGoods" items="${item.listOrderGoods}" varStatus="status1">
									<tr>
									<c:if test="${orderGoods.unitAccounts > 0}">
										<td>${orderGoods.goodsSn}</td>
										<td><span class="text-info">${orderGoods.orgProductItem.goodsName}</span></td>
										<td><span style="text-decoration: line-through">￥<fmt:formatNumber type="currency" pattern="0.00" value="${orderGoods.unitAccounts}"/></span>
											<br/><span class="text-danger">￥<fmt:formatNumber type="currency" pattern="0.00" value="${orderGoods.unitPrice}"/></span></td>
										<td>×${orderGoods.amount}</td>
										<td><span style="background: #3DD998; padding: 1px 5px;">省￥<fmt:formatNumber type="currency" pattern="0.00" value="${orderGoods.unitDiscount*orderGoods.amount}"/></span></td>
										<td><span class="text-danger">￥<fmt:formatNumber type="currency" pattern="0.00" value="${orderGoods.unitPrice*orderGoods.amount}"/></span></td>
									</c:if>
									<c:if test="${orderGoods.unitAccounts.unscaledValue() == 0}">
										<td colspan="6" style="text-align:left;padding-left:30px;">赠品：${orderGoods.orgProductItem.goodsName} X${orderGoods.amount}</td>
									</c:if>
									</tr>
									</c:forEach>
								</table>
							</div>
							<div class="table-right">
								<table class="table table-bordered">
									<thead>
										<tr class="success">
											<th colspan="3">收货人信息</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td><strong>收货人</strong></td>
											<td>${item.consignee}</td>
										</tr>
										<tr>
											<td><strong>电话</strong></td>
											<td>${item.consigneeMobile} ${item.consigneeTel}</td>
										</tr>
										<tr>
											<td><strong>收货地址：</strong></td>
											<td>${item.consigneeAddress}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="table-footer text-center">
							<p>
								<c:if test="${item.payStyle==1}">
									<strong>货到付款 应付款：<span class="text-danger">￥<fmt:formatNumber type="currency" pattern="0.00" value="${item.payMoney}"/></span></strong>
								</c:if>
							</p>
						</div>
					</div>
					</c:if>
				</td>
				<td>${item.userName}</td>
				<td>${item.consignee}</td>
				<td>${item.orgShop.shopName}</td>
				<td><fmt:formatDate value="${item.createTime}" type="both"/></td>
				<td><fmt:formatDate value="${item.payTime}" type="both"/></td>
				<td>￥<fmt:formatNumber type="currency" pattern="0.00" value="${item.orderMoney}"/></td>
				<td>
					<c:if test="${item.depositMoney>0}">预
						<c:if test="${item.onlinePayStyle > 0 or item.localPayStyle > 0}">+</c:if>
					</c:if>
					<c:if test="${item.depositMoney.unscaledValue()==0 and (item.onlinePayStyle==0 or item.localPayStyle==0)}">无需付款</c:if>
					<c:if test="${item.payStyle==0}">
						<c:if test="${item.onlinePayStyle==1}">支</c:if>
						<c:if test="${item.onlinePayStyle==2}">微</c:if>
						<c:if test="${item.onlinePayStyle==3}">财</c:if>
						<c:if test="${item.onlinePayStyle==4}">银联</c:if>
						<c:if test="${item.onlinePayStyle==5}">微</c:if>
						<c:if test="${item.onlinePayStyle==6}">支</c:if>
					</c:if>
					<c:if test="${item.payStyle==1}">
						<c:if test="${item.localPayStyle==1}">现金</c:if>
						<c:if test="${item.localPayStyle==2}">pos</c:if>
					</c:if>
				</td>
				<td>
					<c:if test="${item.source==1}">PC</c:if>
					<c:if test="${item.source==2}">触屏版</c:if>
				</td>
				<td>
					<c:if test="${item.sendStyle==0}">送货</c:if>
					<c:if test="${item.sendStyle==1}">自提</c:if>
				</td>
				<td>
					<c:if test="${item.status==0}">待付款</c:if>
					<c:if test="${item.status==1}">待确认</c:if>
					<c:if test="${item.status==2}">
						<c:if test="${item.sendStyle==0}">待发货</c:if>
						<c:if test="${item.sendStyle==1}">备货中</c:if>
					</c:if>
					<c:if test="${item.status==3}">
						<c:if test="${item.sendStyle==0}">待收货</c:if>
						<c:if test="${item.sendStyle==1}">待自提</c:if>
					</c:if>
					<c:if test="${item.status==4}">已完成</c:if>
					<c:if test="${item.status==5}">已取消</c:if>
					<c:if test="${item.status==6}">已关闭</c:if>
				</td>
				<td>
				<c:if test="${item.waitSolveCount == 0}">
					<button type="button" class="btn btn-warning btn-xs" name="btnDetail">查看</button>
					<c:if test="${item.status==1}">
						<button type="button" class="btn btn-danger btn-xs" name="btnConfirm">确认</button>
					</c:if>
					<c:if test="${item.status==2}">
						<c:if test="${item.sendStyle==0}"><button type="button" class="btn btn-danger btn-xs" name="btnSend">发货</button></c:if>
						<c:if test="${item.sendStyle==1}"><button type="button" class="btn btn-danger btn-xs" name="btnTake">待自提</button></c:if>
					</c:if>
					<c:if test="${item.status==3}">
						<button type="button" class="btn btn-danger btn-xs" name="btnFinish">完成</button>
						<c:if test="${item.sendStyle==1}">
							<br/>
							<div class="alerttip" style="display: none;">
								<span class="red"></span>
								<input type="text" placeholder="请输入提货码" name="takeCodeFinish"/>
								<p class="text-center">
									<button name="btnTakeCancel" type="button" class="btn btn-default btn-xs">取消</button>
									<button name="btnTakeFinish" type="button" class="btn btn-info btn-xs">确认</button>
								</p>
							</div>
						</c:if>
					</c:if>
					</c:if>
					<c:if test="${item.waitSolveCount > 0}">
						<span style="color:red;">客服处理中</span>
					</c:if>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<nav class="navbar navbar-default select-control" >
		<%@include file="../common/common_page.jsp" %>		
	</nav>
	</form>
</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/order/list.js" type="text/javascript"></script>
</body>
</html>
