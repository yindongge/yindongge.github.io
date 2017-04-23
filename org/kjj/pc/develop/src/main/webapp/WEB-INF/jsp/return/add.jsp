<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<%@include file="../common/common_css.jsp"%>
<title>快捷健商城</title>
</head>
<body>
<div class="all memberall">
	<%@include file="../common/common_head2.jsp" %>
	<!-- end top -->
	<div class="header header-member">
		<div class="container container-width">
			<div class="severce-head">
			<div class="logo fl">
				<a href="${ctx}"><img src="${imgBase}/icon/member-logo.png"/></a>
				<div class="text-position">
					<strong>个人中心</strong>				
				</div>		
			</div>
			<%@include file="../common/common_cart.jsp" %>
			<div class="search fr">
				<%@include file="../common/common_search.jsp" %>
			</div>
			</div>
		</div>
	</div>
	<!-- end header -->
	
	<form id="formReturn" action="${ctx}/return/add" method="post">
	<input type="hidden" name="orderGoodsId" value="${orderGoods.id}"/>
	<div class="center-content">
		<div class="container container-width">
			<jsp:include page="../common/common_left.jsp">
				<jsp:param name="active" value="退货记录"/>
			</jsp:include>
			<!-- member-left -->
			<div class="member-right">
			<div class="mlist m-list6">
					<h5>退换货<a href="javascript:void(0);" class="btn btn-warning pull-right" id="consultBtn">联系客服</a> </h5>
					<table class="table table-same  table-bordered">
						<thead>
							<tr class="bluem">
								<th class="th7">商品名称</th>
								<th>赠送清单</th>
								<th>购买数量</th>
							</tr>
						</thead>	
					<tbody>
						<tr class="bluem2">
							<td>
								<div class="mlist-img"><a href="${ctx}/item/${orderGoods.goodsId}" target="_blank"><img src="${orderGoods.orgProductItem.goodsImg50}" title="${orderGoods.orgProductItem.goodsName}"/></a></div>
								<div class="mlist-text"><a href="${ctx}/item/${orderGoods.goodsId}" target="_blank">${orderGoods.orgProductItem.goodsName}</a></div>
							</td>
							<td>-</td>
							<td>${orderGoods.amount}<c:if test="order_goods.return_amount>0">(已退${orderGoods.returnAmount}件)</c:if></td>
						</tr>
					</tbody>
					</table>
			</div>
			<div class="mlist m-list7">
				<h5>服务明细<a class="pull-right" href="${ctx}/order/list">返回订单列表</a></h5>
				<div class="return-list">
					<div class="r-left"><span >＊</span>服务类型:</div>
					<div class="r-right"><input type="radio" name="returnStyle" class="raido-r" checked="checked" value="0"/><label for="radio-r">退货</label></div>
				</div>
				<div class="return-list">
					<div class="r-left"><span >＊</span>提交数量:</div>
					<div class="r-right">
						<div class="qu-form">
							<a class="a1 remove" href="javascript:void(0);" id="amountMinus">-</a>
							<input type="text" id="amount" name="amount" value="1" data-last-amount="${orderGoods.amount-orderGoods.returnAmount}" data-old="1"/>
							<a class="a2" href="javascript:void(0);" id="amountPlus">+</a>
						</div>
					</div>
				</div>
					<div class="return-list">
					<div class="r-left"><span >＊</span>问题描述:</div>
					<div class="r-right">
						<textarea rows="7" style="width:500px;resize: none;" placeholder="描述" id="reason" name="reason" maxlength="200" onkeyup="checkTextAreaLength(this,200)" onblur="checkTextAreaLength(this,200)"></textarea>
						<br/>
						<b style="display:none;"></b>
					</div>
				</div>
					<div class="return-list">
					<div class="r-left">图片信息：</div>
					<div class="r-right">
						<a class="r-righta" id="btnUpload" href="javascript:void(0);">上传图片</a><span>为了帮助我们更好的解决问题，请您上传图片</span>
						<input type="file" name="file" id="file" style=" position:absolute; top:0; right:0; height:24px; filter:alpha(opacity:0);opacity: 0;width:260px" onchange="uploadImage('file')"/>
						<div class="imggroup">
						</div>
						<br/>
						<b id="bImg" style="display:none;"></b>
						<p class="p2">最多可上传5张图片，每张图片大小不超过5M，支持<i>bmp、gif、jpg、png、jpeg</i>格式文件</p>
					</div>
				</div>
				<div class="return-list">
					<div class="r-left">商品返回方式：</div>
					<div class="r-right">
						<c:if test="${order.sendStyle==0}">
							<input type="radio" name="takeStyle" class="raido-r" checked="checked" value="0"/><label for="radio-r">上门取件</label>
							<span class="span-r1">快捷健将在1-3天内为您上门取回商品</span>
						</c:if>
						<c:if test="${order.sendStyle==1}">
							<input type="radio" name="takeStyle" class="raido-r" checked="checked" value="1"/><label for="radio-r">到店退货</label>
							<span class="span-r1">请将商品送回快捷健店铺 </span>
						</c:if>
						
					</div>
				</div>
				<c:if test="${order.sendStyle==0}">
					<div class="return-list">
						<div class="r-left">取货地址：</div>
						<div class="r-right">
							<select disabled="disabled">
								<option>${shop.area[0]}</option>
							</select>
							<select disabled="disabled">
								<option>${shop.area[1]}</option>
							</select>
							<select disabled="disabled">
								<option>${shop.area[2]}</option>
							</select>
							<select disabled="disabled">
								<option>${shop.shopName}</option>
							</select>
							<p class="p2"><input type="text" name="returnAddress" value="${order.consigneeAddress}" readonly="readonly"/></p>
							<p><span class="red">重要提示：</span>您好，如果您的地址有变动，请到店退货，给您带来的不变敬请谅解。</p>
						</div>
					</div>
				</c:if>
				<c:if test="${order.sendStyle==1}">
					<div class="return-list">
						<div class="r-left">店铺地址：</div>
						<div class="r-right">
							<select disabled="disabled">
								<option>${shop.area[0]}</option>
							</select>
							<select disabled="disabled">
								<option>${shop.area[1]}</option>
							</select>
							<select disabled="disabled">
								<option>${shop.area[2]}</option>
							</select>
							<select disabled="disabled">
								<option>${shop.shopName}</option>
							</select>
							<p class="p2">${shop.address}</p>
							<p><span class="red">重要提示：</span>您好，请您尽快到店退货。</p>
						</div>
					</div>
				</c:if>
				<div class="return-list">
					<div class="r-left">退款方式:</div>
					<div class="r-right">
						<p>原支付方式返回， 如为现金支付，<span class="red">将会退款至您的账户余额或银行卡；如为信用卡支付，仅支持原路返回.</span></p>
						<p>请您在 <a href="#"><strong class="blue">退款说明 </strong></a>中查看退款时效</p>
					</div>
				</div>
				<div class="return-list">
					<div class="r-left"><span >＊</span>联系人姓名：</div>
					<div class="r-right"><input type="text" class="input2" id="returnContact" name="returnContact" value="${order.consignee}"/><b style="display:none;"></b></div>
				</div>
				<div class="return-list">
					<div class="r-left"><span >＊</span>联系方式：</div>
					<div class="r-right">
						<input type="text" class="input2" id="returnTel" name="returnTel" value="${returnTel}" disabled="disabled"/>
						<input type="hidden" id="orderTel" value="${returnTel}"/>
						<input type="checkbox" id="mobileDefault" class="raido-r" checked="checked"/><label for="radio-r">与订单中手机号相同</label>
					</div>
				</div>
				<div class="return-list">
					<div class="r-left"></div>
					<div class="r-right"><button type="submit" class="btn btn-warning">提交</button></div>
				</div>
			</div>
			<!-- first right1 -->
			</div>
			<!-- end memberright -->
		</div>
	</div>
</form>
<!-- footer -->
<%@include file="../common/common_foot.jsp" %>
</div>
<%@include file="../common/common_js.jsp"%>
<script type="text/javascript" src="${jsBase}/common/ajaxfileupload.js"></script>
<script type="text/javascript" src="${jsBase}/return/add.js"></script>
<script type="text/javascript" src="http://wpa.b.qq.com/cgi/wpa.php"></script>
<script type="text/javascript">
	//企业qq
	BizQQWPA.addCustom({
		aty : '0',
		nameAccount: '4000306603',
		selector : 'consultBtn'
	});
</script>
</body>
</html>