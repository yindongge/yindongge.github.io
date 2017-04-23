<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<%@include file="../common/common_css.jsp" %>
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
			<div class="search fr search-special1">
					<%@include file="../common/common_search.jsp" %>	
			</div>
			</div>
		</div>
	</div>
	<!-- end header -->
	<div class="center-content">
		<div class="container container-width  ">
			<jsp:include page="../common/common_left.jsp">
				<jsp:param name="active" value="收货地址"/>
			</jsp:include>
			
			<!-- member-left -->
			<div class="member-right">
				<div class="mlist information receiving ">
					<h5 >收货地址</h5>
					<div class="add-address">
						<a <c:if test="${fn:length(listUserAddress)<15}">href="javascript:addAddress()"</c:if>  <c:if test="${fn:length(listUserAddress)>=15}">href="javascript:void(0)" onclick="javascript:alert('最多可保存15条地址')" style="color:#ccc"</c:if>>添加收货地址</a><span>已保存了${fn:length(listUserAddress)}条地址，最多可保存15条地址</span>
					</div>
					
					<c:forEach var="item" items="${listUserAddress}" varStatus="status">
						
						<div class="address-list <c:if test="${(status.index+1)%2==0}">a-r</c:if>">
						<div class="a-title">${item.addressName}</div>
						<dl>
							<dt>收货人：</dt>
							<dd>${item.consignee}</dd>
						</dl>
						<dl>
							<dt>所在地区：</dt>
							<dd>${item.areaShow}</dd>
						</dl>
						<dl>
							<dt>详细地址：</dt>
							<dd>${item.sendRangeName}${item.address}</dd>
						</dl>
						<dl>
							<dt>手机：</dt>
							<dd>${item.mobile}</dd>
						</dl>
						<dl>
							<dt>固定电话：</dt>
							<dd>${item.telAreaCode}-${item.tel}</dd>
						</dl>
						<dl>
							<dt>email：</dt>
							<dd>${item.email}</dd>
						</dl>
						<div class="makeover">
							<a href="javascript:del(${item.addressId})">删除</a>
							<a href="javascript:edit(${item.addressId})">编辑</a>
						</div>
					</div>
					
					</c:forEach>

				</div>

			</div></div>
</div>

<!--  -->
<%@include file="../common/common_foot.jsp" %>
<div class="modify modify2 " id="addwin" style="display:none">
		<h5>收货地址 <button type="button" class="close">x</button></h5>
		<form id="addform" name="addform">
		<input type="hidden" name="addressId" id="addressId" value="-1"></input>
		<input type="hidden"  id="saveOrUpdate" value="0"></input>
		<div class="date-select">
			<div class="address-select">
				<div class="address-left">
					<i class="red">*</i>收货人：
				</div>
				<div class="address-right">
					<input type="text" class="input1" id="consignee" name = "consignee"/>
				</div>
			</div>
			<div class="address-select">
				<div class="address-left">
					您的区域：
				</div>
				<div class="address-right">
				<select disabled="disabled" class="nouse" >
						<option id="s1">${kjjuser.orgShop.area[0]}</option>
					</select>
					<select disabled="disabled" class="nouse" >
						<option id="s2" >${kjjuser.orgShop.area[1]}</option>
					</select>
					<select disabled="disabled" class="nouse" >
						<option id="s3" >${kjjuser.orgShop.area[2]}</option>
					</select>
					<select disabled="disabled" class="nouse" >
						<option id="s4">${kjjuser.orgShop.shopName}</option>
					</select>
				</div>
			</div>
			<div class="address-select">
				<div class="address-left">
					<i class="red">*</i>详细地址：
				</div>
				<div class="address-right">
					<select name="sendRangeId" id="sendRangeId">
						<option value="-1">请选择</option>
						<c:forEach items="${listSendRange}" var="sendRange" varStatus="status" >
							<option value="${sendRange.id}">${sendRange.sendRangeName}</option>
						</c:forEach>
					</select>
					<input type="text" class="input4" id="address" name="address"  placeholder="如楼号、楼层、门牌号"/>
					<b>不需要重复填写所在区域</b>
				</div>
			</div>
			<div class="address-select">
				<div class="address-left">
					<i class="red">*</i>手机：
				</div>
				<div class="address-special">
					<input type="text" class="input3" id="mobile" name="mobile"/>
				</div>
				<div class="address-special2">
					<label>电话：</label>
					<input type="text" class="addresstext-1"  id="telAreaCode" name="telAreaCode"/>
					<input type="text" class="addresstext-2" id="tel" name="tel"/>
				
				</div>
			</div>
			<div class="address-select">
				<div class="address-left">
					邮箱：
				</div>
				<div class="address-right">
					<input type="text" class="input2" id="email" name="email"/>
				</div>
			</div>
		</div>
		<div class="modify-button">
			<button type="button" class="btn btn-default" onclick="cancel()">取消</button>
			<button type="button" id="btn" class="btn btn-warning" onclick="save()">确定</button>
		</div>
		</form>
</div>
<div class="mask"></div>
</div>
<div class="kjj" style="display:none">
	<div class="title">标题</div>
	<p >操作成功！</p>
	<p><a href="javascript:closeBox()" class="closekjj">关闭</a></p>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/address/list.js"  type="text/javascript"></script>
</body>
</html>