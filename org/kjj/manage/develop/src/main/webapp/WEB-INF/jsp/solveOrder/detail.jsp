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
<title>订单管理</title>
</head>

<body>
<div class="page-wrapper goods-control">
<div class="container-fluid">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">交易</a></li>
		<li class="active"><a href="${ctx}/solveOrder/list">问题订单管理</a></li>	
		<li class="active">问题订单详情</li>
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
				<td class="strong-b">订单号:</td>
				<td><span class="text-info">${order.orderId}</span></td>
				<td class="strong-b">订单状态：</td>
				<td>
					<c:if test="${order.status==0}">待付款</c:if>
					<c:if test="${order.status==1}">待确认</c:if>
					<c:if test="${order.status==2}">
						<c:if test="${order.sendStyle==0}">待发货</c:if>
						<c:if test="${order.sendStyle==1}">备货中</c:if>
					</c:if>
					<c:if test="${order.status==3}">
						<c:if test="${order.sendStyle==0}">待收货</c:if>
						<c:if test="${order.sendStyle==1}">待自提</c:if>
					</c:if>
					<c:if test="${order.status==4}">已完成</c:if>
					<c:if test="${order.status==5}">已取消</c:if>
					<c:if test="${order.status==6}">已关闭</c:if>
				</td>
				<td  class="strong-b">付款状态：</td>
				<td>
					<c:if test="${order.payStatus==0}">未付款</c:if>
					<c:if test="${order.payStatus==1}">已付款</c:if>
				</td>
			</tr>
			<tr>
				<td class="strong-b">用户名：</td>
				<td><span class="text-info">${order.userName}</span></td>
				<td class="strong-b">下单时间：</td>
				<td><fmt:formatDate value="${order.createTime}" type="both"/></td>
				<td  class="strong-b">支付方式：</td>
				<td>
					<c:if test="${order.depositMoney>0}">预
						<c:if test="${order.onlinePayStyle > 0 or order.localPayStyle > 0}">+</c:if>
					</c:if>
					<c:if test="${order.depositMoney.unscaledValue()==0 and (order.onlinePayStyle==0 or order.localPayStyle==0)}">无需付款</c:if>
					<c:if test="${order.payStyle==0}">
						<c:if test="${order.onlinePayStyle==1}">支</c:if>
						<c:if test="${order.onlinePayStyle==2}">微</c:if>
						<c:if test="${order.onlinePayStyle==3}">财</c:if>
						<c:if test="${order.onlinePayStyle==4}">银联</c:if>
						<c:if test="${order.onlinePayStyle==5}">微</c:if>
						<c:if test="${order.onlinePayStyle==6}">支</c:if>
					</c:if>
					<c:if test="${order.payStyle==1}">
						<c:if test="${order.localPayStyle==1}">现金</c:if>
						<c:if test="${order.localPayStyle==2}">pos</c:if>
					</c:if>
				</td>
			</tr>
			<tr>
				<td class="strong-b">店铺：</td>
				<td>${order.orgShop.shopCode}（${order.orgShop.shopName}）</td>
				<td class="strong-b">发货时间：</td>
				<td><fmt:formatDate value="${sendLog.logTime}" type="both"/></td>
				<td  class="strong-b">确认时间：</td>
				<td><fmt:formatDate value="${confirmLog.logTime}" type="both"/></td>
			</tr>
			<tr>
				<td class="strong-b">配送方式：</td>
				<td>
					<c:if test="${order.sendStyle==0}">送货</c:if>
					<c:if test="${order.sendStyle==1}">自提</c:if>
				</td>
				<td class="strong-b">支付时间：</td>
				<td><fmt:formatDate value="${order.payTime}" type="both"/></td>
				<td  class="strong-b">订单来源：</td>
				<td>
					<c:if test="${order.source==1}">PC</c:if>
					<c:if test="${order.source==2}">触屏版</c:if>
				</td>
			</tr>
			<tr>
				<c:if test="${order.sendStyle==0}">
					<td class="strong-b">配送时间：</td>
					<td>
						<fmt:formatDate value="${order.sendDate}" type="date"/>~<fmt:formatDate value="${order.sendTimeStart}" type="time"/>~<fmt:formatDate value="${order.sendTimeEnd}" type="time"/>
					</td>
				</c:if>
				<c:if test="${order.sendStyle==1}">
					<td class="strong-b">自提时间：</td>
					<td>
						${order.takeDate}
					</td>
				</c:if>
				<td class="strong-b"></td>
				<td class="strong-b"></td>
			</tr>
		</tbody>
		</table>
		<form id="formConsignee">
			<input type="hidden"  id="sendStyle" name="sendStyle" value="${order.sendStyle}"/>
			<input type="hidden"  id="orderId" name="orderId" value="${order.orderId}"/>
			<input type="hidden"  id="id" name="id" value="${orgSolveOrder.id}"/>
		<table class="table table-hover table-bordered ">
			<thead>
			<tr class="info">				
				<th width="150px;">收货信息</th>
				<th></th>
				<th width="150px"></th>
				<th></th>
				<th width="150px;"></th>
				<th></th>
			</tr>
			</thead>
			
			<tr>
				<td class="strong-b">收货人：</td>
				<td>
					<div class="form-group">
						<input type="text" class="form-control" id="consignee" name="consignee" value="${order.consignee}" 
						<c:if test="${order.sendStyle==0}">required data-bv-notempty-message="收货人不能为空"</c:if>
						maxlength="60" data-bv-stringlength-message="收货人长度不能大于60"/>
					</div>
				</td>
				<td class="strong-b">手机：</td>
				<td>
					<div class="form-group">
						<input type="text" class="form-control" id="consigneeMobile"  name="consigneeMobile" value="${order.consigneeMobile}"
						maxlength="20" data-bv-stringlength-message="手机号码长度不能大于20"
						pattern="^1\d{10}$" data-bv-regexp-message="手机号码不符合规范"/>
					</div>
				</td>
				<td class="strong-b">电话：</td>
				<td>
					<div class="form-group">
						<input type="text" class="form-control" id="consigneeTel"  name="consigneeTel" value="${order.consigneeTel}"
						maxlength="20" data-bv-stringlength-message="电话号码长度不能大于20"
						pattern="^0[1-9]\d{1,2}-\d{7,8}$" data-bv-regexp-message="电话号码不符合规范,样例：“010-88888888”"/>
					</div>
				</td>
			</tr>
			<tr>
				<td class="strong-b">地址：</td>
				<td colspan="3">
					<div class="form-group">
						<input type="text" class="form-control" id="consigneeAddress"  name="consigneeAddress" value="${order.consigneeAddress}"
						<c:if test="${order.sendStyle==0}">required data-bv-notempty-message="地址不能为空"</c:if>
						maxlength="200" data-bv-stringlength-message="地址长度不能大于200"/>
					</div>
				</td>
				<td  class="strong-b">E-mail:</td>
				<td>
					<div class="form-group">
						<input type="text" class="form-control" id="consigneeEmail"  name="consigneeEmail" value="${order.consigneeEmail}"
						maxlength="60" data-bv-stringlength-message="E-mail长度不能大于60"/>
					</div>
				</td>
			</tr>
			<tr>				
				<th colspan="6"><button type="button" id="btnConsignee" class="btn btn-warning">修改收货信息</button></th>
			</tr>
		</table>
		</form>
		<table class="table table-hover table-bordered ">
		<thead>
			<tr class="info">				
				<th width="150px;">商品信息</th>
				<th></th>
				<th width="150px"></th>
				<th></th>
				<th width="150px;"></th>
				<th></th>
			</tr>
			<tr class="active">				
				<th width="150px;">商品货号</th>
				<th>商品</th>
				<th width="150px">单价（元）</th>
				<th>数量</th>
				<th width="150px;">优惠</th>
				<th>小计（元）</th>
			</tr>
		</thead>
			<c:forEach var="orderGoods" items="${order.listOrderGoods}" varStatus="status">
			<tr>
			<c:if test="${orderGoods.unitAccounts > 0}">
				<td >${orderGoods.goodsSn}</td>
				<td><span class="text-info">${orderGoods.orgProductItem.goodsName}</span>
				</td>
				<td ><span style="text-decoration:line-through">￥<fmt:formatNumber type="currency" pattern="0.00" value="${orderGoods.unitAccounts}"/></span>
					<br/><span class="text-danger" >￥<fmt:formatNumber type="currency" pattern="0.00" value="${orderGoods.unitPrice}"/></span>
				</td>
				<td>×${orderGoods.amount}</td>
				<td ><span style="background:#3DD998; padding:1px 5px;">省￥<fmt:formatNumber type="currency" pattern="0.00" value="${orderGoods.unitDiscount*orderGoods.amount}"/></span></td>
				<td><span class="text-danger" >￥<fmt:formatNumber type="currency" pattern="0.00" value="${orderGoods.unitPrice*orderGoods.amount}"/></span></td>
			</c:if>
			<c:if test="${orderGoods.unitAccounts.unscaledValue() == 0}">
				<td colspan="6" style="text-align:left;padding-left:30px;">赠品：${orderGoods.orgProductItem.goodsName} X${orderGoods.amount}</td>
			</c:if>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="6"  style="text-align:right; padding-right:50px;">
				-优惠券:
				<c:if test="${couponRecord == null}">无</c:if>
				<c:if test="${couponRecord != null}">
					[No.${couponRecord.recordId}]满${couponRecord.conditionMoney}减${couponRecord.discountMoney}
				</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="4" style="text-align:left" >发票：<c:if test="${order.invoice!=null}">有 抬头：${order.invoice}</c:if><c:if test="${order.invoice==null}">无</c:if></td>
				<td class="strong-b">合计：</td>
				<td ><strong class="text-danger">￥<fmt:formatNumber type="currency" pattern="0.00" value="${order.orderMoney}"/></strong></td>
			</tr>
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
			<tr class="tr11">
				<td class="strong-b">备注：</td>
				<td colspan="3" style="text-align:left;">
					<textarea rows="6" style="width:500px;resize: none;" id="logDetail" maxlength="200" onkeyup="checkTextAreaLength(this,200)" onblur="checkTextAreaLength(this,200)"></textarea>
					<br/>
					<c:if test="${order.status<4}"><button id="btnCancel">取消</button></c:if>
					<button id="btnRemark">备注</button>
					<c:if test="${orgSolveOrder.status==0}"><button id="btnShop">转门店</button></c:if>
				</td>
				<td class="strong-b"></td>
				<td></td>
			</tr>
			
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
			<c:forEach var="log" items="${listOrderLog}" varStatus="status">
				<tr>
					<td class="strong-b">${log.adminName}</td>
					<td><fmt:formatDate value="${log.logTime}" type="both"/></td>
					<td>${log.typeName}</td>
					<td colspan="3" >${log.logDetail}</td>
				</tr>
			</c:forEach>
	</table>
	
	<div class="text-center">
		<a role="button" class="btn btn-info" href="${ctx}/order/list">返回</a>
	</div>
</div>
</div>
<div class="maskme" style="display: none;"></div>
<div class="alertme" id="divCancel" style="display: none;">
	<div class="content">
		<dl class="floor">
			<dt>取消原因:</dt>
			<dd>
			<select id="reasonCancel">
				<option value="-1">请选择原因</option>
				<option value="超出配送范围">超出配送范围</option>
				<option value="自提订单超时未取">自提订单超时未取</option>
				<option value="联系不到收货人">联系不到收货人</option>
				<option value="用户拒收">用户拒收</option>
				<option value="商品缺货">商品缺货</option>
				<option value="自定义…" onclick="cancelUser();">自定义…</option>			
			</select>
			</dd>
			<dd style="display: none;">
				<input type="text" class="form-control" style="width:90%;" id="reasonCancelUser"/>
			</dd>
			<dd style="display: none;"><b></b></dd>
		</dl>
		<p class="text-center buttonme"><button type="button" class="btn btn-default" id="btnCancelCancel">取消</button><button id="btnCancelFinish" class="btn btn-danger">确定</button></p>
	</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/solveOrder/detail.js" type="text/javascript"></script>
</body>
</html>
