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
<title>退换货详情</title>
</head>
<body>
<div class="page-wrapper goods-control">
<div class="container-fluid">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">交易</a></li>
		<li class="active"><a href="${ctx}/return/list">退换货管理</a></li>	
		<li class="active">退货详情</li>
	</ul>
	<br/>
	<table class="table table-hover table-bordered ">
		<thead>
			<tr class="info">				
				<th width="150px">基本信息</th>
				<th></th>
				<th width="150px"></th>
				<th></th>
				<th width="150px"></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="strong-b">退换货单号：</td>
				<td><span class="text-info" >${orgReturnOrder.returnOrderId}</span></td>
				<td class="strong-b">退换货类型：</td>
				<td>
					<c:if test="${orgReturnOrder.returnStyle==0}">退货</c:if>
					<c:if test="${orgReturnOrder.returnStyle==1}">换货</c:if>
				</td>
				<td  class="strong-b">SKU编码：</td>
				<td>${orderGoods.goodsSn}</td>
			</tr>
			<tr>
				<td class="strong-b">订单编号：</td>
				<td><span class="text-info">${order.orderId}</span></td>
				<td class="strong-b">商品返回方式：</td>
				<td>
					<c:if test="${orgReturnOrder.takeStyle==0}">上门退换</c:if>
					<c:if test="${orgReturnOrder.takeStyle==1}">到店退换</c:if>
				</td>
				<td  class="strong-b">退款方式：</td>
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
				<td class="strong-b">配送费：</td>
				<td><fmt:formatNumber type="currency" pattern="￥0.00" value="${order.sendMoney}"/></td>
				<td class="strong-b">申请时间：</td>
				<td><fmt:formatDate value="${orgReturnOrder.createTime}" type="both"/></td>
				<td  class="strong-b">状态：</td>
				<td>
					<c:if test="${orgReturnOrder.returnStatus==0}">未审核</c:if>
					<c:if test="${orgReturnOrder.returnStatus==1}">拒绝</c:if>
					<c:if test="${orgReturnOrder.returnStatus==2}">退货中</c:if>
					<c:if test="${orgReturnOrder.returnStatus==3}">已退货</c:if>
				</td>
			</tr>
		</tbody>
		<thead>
			<tr class="info">				
				<th>取货信息</th>
				<th></th>
				<th width="150px"></th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="strong-b">联系人：</td>
				<td>${orgReturnOrder.returnContact}</td>
				<td class="strong-b">手机/电话：</td>
				<td>${orgReturnOrder.returnTel}</td>
				<td  class="strong-b"></td>
				<td></td>
			</tr>
			<tr>
				<td class="strong-b">地址：</td>
				<td colspan="5" style="text-align:left">${orgReturnOrder.returnAddress}</td>
				
			</tr>
			<tr class="success">
				<td class="strong-b">商品信息：</td>
				<td></td>
				<td class="strong-b"></td>
				<td></td>
				<td  class="strong-b"></td>
				<td></td>
			</tr>
			<tr>
				<td class="strong-b">商品货号:</td>
				<td colspan="2">商品名称</td>
				<td >属性</td>
				<td colspan="2">数量</td>
				
			</tr>
			<tr>
				<td class="strong-b">${orderGoods.goodsSn}</td>
				<td colspan="2">${orderGoods.orgProductItem.goodsName}</td>
				<td></td>
				<td colspan="2">×${orderGoods.amount}</td>
			</tr>
		</tbody>	
		<thead>
			<tr class="info">				
				<th>退换货商品信息</th>
				<th colspan="2"></th>
				<th width="150px"></th>
			
				<th colspan="2"></th>
			</tr>
			<tr class="active">				
				<th>商品货号</th>
				<th colspan="2">商品名称</th>
				<th width="150px">属性</th>
				<th>应退款金额</th>
				<th>数量</th>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td>${orderGoods.goodsSn}</td>
					<td colspan="2">${orderGoods.orgProductItem.goodsName}</td>
					<td></td>
					<td><fmt:formatNumber type="currency" pattern="￥0.00" value="${orderGoods.unitPrice}"/></td>
					<td>×${orgReturnOrder.amount}</td>
				</tr>
				<tr>
					<td></td>
					<td colspan="2"></td>
					<td></td>
					<td colspan="2">小计：<fmt:formatNumber type="currency" pattern="￥0.00" value="${orderGoods.unitPrice*orgReturnOrder.amount}"/></td>
					
				</tr>
		</tbody>	
		<thead>
			<tr style="height:100px;">
				<td class="strong-b">原因说明：</td>			
				<td colspan="5" style="text-align:left">
					<textarea rows="6" style="width:500px;resize:none;" readonly="readonly" id="reason" maxlength="200" onkeyup="checkTextAreaLength(this,200)" onblur="checkTextAreaLength(this,200)">${orgReturnOrder.reason}</textarea>
				</td>		
			</tr>
			<tr style="height:100px;">
				<td class="strong-b">图片说明:</td>			
				<td colspan="5" style="text-align:left">
					<c:forEach var="img" items="${listReturnorderimg}" varStatus="status">
						<a href="${img.imgUrl}" target="_blank"><img src="${img.imgUrl}" width="130px;" height="130px;" title="图片"/></a>
					</c:forEach>
				</td>		
			</tr>
			<tr class="info">				
				<th>操作信息</th>
				<th></th>
				<th width="150px"></th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
			<tr class="tr11">
				<td class="strong-b">操作：
					<input type="hidden" id="returnOrderId" name="returnOrderId" value="${orgReturnOrder.returnOrderId}"/>
				</td>
				<td colspan="3" style="text-align:left;">
					<c:if test="${orgReturnOrder.returnStatus==0}"><button id="divApprove">同意</button></c:if>
					<c:if test="${orgReturnOrder.returnStatus==2}"><button id="divFinish">完成</button></c:if>
					<c:if test="${orgReturnOrder.returnStatus==0}"><button id="divRefuse">拒绝</button></c:if>
					<c:if test="${orgReturnOrder.returnStatus==2}"><button id="divFail">拒绝</button></c:if>
					<button id="divRemark">备注</button>
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
		<tbody>
			<c:forEach var="log" items="${listReturnOrderLog}" varStatus="status">
			<tr>
				<td class="strong-b">${log.adminName}</td>
				<td><fmt:formatDate value="${log.logTime}" type="both"/></td>
				<td>${log.typeName}</td>
				<td colspan="3">${log.logDetail}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div class="text-center">
		<a role="button" class="btn btn-info" href="${ctx}/return/list">返回</a>
	</div>
	
</div>
</div>
<div class="maskme" style="display: none;"></div>
<div class="alertme approve" style="display: none;">
	<div class="title">
		同意 <span  class="close2 glyphicon glyphicon-remove-circle"></span>
	</div>
	<div class="content">
		<dl class="floor">
			<dt>备注:</dt>
			<dd><textarea rows="5" style="width:100%;resize: none;" name="logDetail" maxlength="200" onkeyup="checkTextAreaLength(this,200)" onblur="checkTextAreaLength(this,200)"></textarea></dd>
		</dl>
		<p class="text-center buttonme"><button type="button" class="btn btn-default btnClose">取消</button><button id="btnApprove" class="btn btn-danger">确定</button></p>
	</div>
</div>
<div class="alertme finish" style="display: none;">
	<div class="title">
		完成<span  class="close2 glyphicon glyphicon-remove-circle"></span>
	</div>
	<div class="content">
		<dl class="floor">
			<dt>备注:</dt>
			<dd><textarea rows="5" style="width:100%;resize: none;" name="logDetail" maxlength="200" onkeyup="checkTextAreaLength(this,200)" onblur="checkTextAreaLength(this,200)"></textarea></dd>
		</dl>
		<dl class="floor">
			<dt><i class="red">*</i>退款</dt>
			<dd>
				<span>金额:</span><input type="text" class="f-text" name="returnMoney" value="<fmt:formatNumber type="currency" pattern="0.00" value="${orderGoods.unitPrice*orgReturnOrder.amount}"/>"/>
				<span>运费:</span><input type="text" class="f-text" value="<fmt:formatNumber type="currency" pattern="0.00" value="${order.sendMoney}"/>" readonly="readonly"/>
				<input type="radio" name="refundSendMoney" checked="checked" value="0"/><label>不退运费</label>
				<input type="radio" name="refundSendMoney" value="1"/><label>退运费</label>
				<input type="hidden" id="returnSendMoney" name="returnSendMoney" value="0"/>
			</dd>
			<dd id="finish1" style="display: none;"><b></b></dd>
		</dl>
		<dl class="floor">
			<dt><i class="red">*</i>原因:</dt>
			<dd><textarea rows="5" style="width:100%;;resize: none;" name="reply" maxlength="200" onkeyup="checkTextAreaLength(this,200)" onblur="checkTextAreaLength(this,200)"></textarea></dd>
			<dd id="finish2" style="display: none;"><b></b></dd>
		</dl>
		<p class="text-center buttonme"><button type="button" class="btn btn-default btnClose">取消</button><button id="btnFinish" class="btn btn-danger">确定</button></p>
	</div>
</div>
<div class="alertme refuse" style="display: none;">
	<div class="title">
		拒绝 <span  class="close2 glyphicon glyphicon-remove-circle"></span>
	</div>
	<div class="content">
		<dl class="floor">
			<dt>备注:</dt>
			<dd><textarea rows="5" style="width:100%;resize: none;" name="logDetail" maxlength="200" onkeyup="checkTextAreaLength(this,200)" onblur="checkTextAreaLength(this,200)"></textarea></dd>
		</dl>
		
		<dl class="floor">
			<dt><i class="red">*</i>原因:</dt>
			<dd><textarea rows="5" style="width:100%;resize: none;" name="reply" maxlength="200" onkeyup="checkTextAreaLength(this,200)" onblur="checkTextAreaLength(this,200)"></textarea></dd>
			<dd style="display: none;"><b></b></dd>
		</dl>
		<p class="text-center buttonme"><button type="button" class="btn btn-default  btnClose">取消</button><button id="btnRefuse" class="btn btn-danger">确定</button></p>
	</div>
</div>
<div class="alertme fail" style="display: none;">
	<div class="title">
		拒绝 <span  class="close2 glyphicon glyphicon-remove-circle"></span>
	</div>
	<div class="content">
		<dl class="floor">
			<dt>备注:</dt>
			<dd><textarea rows="5" style="width:100%;resize: none;" name="logDetail" maxlength="200" onkeyup="checkTextAreaLength(this,200)" onblur="checkTextAreaLength(this,200)"></textarea></dd>
		</dl>
		
		<dl class="floor">
			<dt><i class="red">*</i>原因:</dt>
			<dd><textarea rows="5" style="width:100%;resize: none;" name="reply" maxlength="200" onkeyup="checkTextAreaLength(this,200)" onblur="checkTextAreaLength(this,200)"></textarea></dd>
			<dd style="display: none;"><b></b></dd>
		</dl>
		<p class="text-center buttonme"><button type="button" class="btn btn-default  btnClose">取消</button><button id="btnFail" class="btn btn-danger">确定</button></p>
	</div>
</div>
<!--end  third -->
<div class="alertme remark" style="display: none;">
	<div class="title">
		备注 <span  class="close2 glyphicon glyphicon-remove-circle"></span>
	</div>
	<div class="content">
		<dl class="floor">
			<dt><i class="red">*</i>备注:</dt>
			<dd><textarea rows="5" style="width:100%;resize: none;" name="logDetail" maxlength="200" onkeyup="checkTextAreaLength(this,200)" onblur="checkTextAreaLength(this,200)"></textarea></dd>
			<dd style="display: none;"><b></b></dd>
		</dl>
		
		<p class="text-center buttonme"><button type="button" class="btn btn-default  btnClose">取消</button><button id="btnRemark" class="btn btn-danger">确定</button></p>
	</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/return/datail.js" type="text/javascript"></script>
</body>
</html>
