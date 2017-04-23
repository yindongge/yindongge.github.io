<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/common_java.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<meta name="apple-touch-fullscreen" content="yes" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />
<%@ include file="../common/common_css.jsp"%>

<title>满减满送-添加优惠设置</title>
</head>
<body>
<div class="page-wrapper ">
<div class="container-fluid">
	<div class="page-wrapper">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li>您的位置</li>
				<li><a href="#">运营</a></li>
				<li><a href="#">促销管理</a></li>
				<li class="active">满减满送</li>
			</ul>
			<div  class="bg-warning " style="padding:10px;">
				<p><strong>备注：</strong></p>
				<p>• 可选择多件赠品（数量、种类），用户购买达到条件时将会被一起送出；可选择多种优惠券，每种优惠券只能选1张.</p>
			</div>
			<!-- 切换 -->
			<div class="btn-group btn-group-justified" role="group" aria-label="Justified button group" style="width:30%;">
				<c:if test="${not empty param.id}">
				   <a href="${ctx}/reach/editInfo/${param.id}" class="btn btn-info " role="button">基本信息</a>
				</c:if>
				<c:if test="${empty param.id}">
				   <a href="${ctx}/reach/addInfo" class="btn btn-info " role="button">基本信息</a>
				</c:if>
			
				<c:if test="${not empty param.id}">
				   <a href="${ctx}/reach/editItem?id=${param.id}" class="btn btn-info" role="button">活动商品</a>
				</c:if>
				<c:if test="${empty param.id}">
				   <a href="${ctx}/reach/editItem" class="btn btn-info" role="button">活动商品</a>
				</c:if>
			
			
			   <a href="javascript:void(0);" class="btn btn-primary" role="button">优惠设置</a>
		    </div>
			<!-- 切换 -->
			<div class="table-wrapper">
				<input type="hidden" id="reachId" name="id" value="${param.id}">
				<c:if test="${not empty orgReach}">
					<input type="hidden" id="reachStyle"  value="${orgReach.reachStyle}">
				</c:if>
				<table class="table table-bordered table-hover table_center">
					<thead>
						<tr>
							<th class="w100">层级</th>
							<th style="width:300px">优惠门槛</th>
							<th style="width:400px">优惠方式(可多选)</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="reachRow">
						<c:forEach items="${orgReachConditionList}" var="item" varStatus="status">
						    <c:set var="discountTypeStr" />  
						    <c:set var="discountIsloopStr" />  
						    <c:forEach items="${item.orgReachDiscountList}" var="discountItem" varStatus="ds">
							     	 <c:set var="discountTypeStr" value="${discountTypeStr},${discountItem.typeId}" />  
							      <c:if test="${discountItem.typeId eq 1 and discountItem.isloop eq 1}">
								     <c:set var="discountIsloopStr" value="${discountIsloopStr},1" />  
							      </c:if>
							      <c:if test="${discountItem.typeId eq 2 and discountItem.isloop eq 1}">
								     <c:set var="discountIsloopStr" value="${discountIsloopStr},2" /> 
								     <c:set var="d_couponId" value="${discountItem.id}"/> 
							      </c:if>
							      <c:if test="${discountItem.typeId eq 3 and discountItem.isloop eq 1}">
								     <c:set var="discountIsloopStr" value="${discountIsloopStr},3" />  
								     <c:set var="d_productId" value="${discountItem.id}"/>
							      </c:if>
							      <c:if test="${discountItem.typeId eq 1}">
								     <c:set var="d_moneyId" value="${discountItem.id}"/>
							      </c:if>
							      <c:if test="${discountItem.typeId eq 2 }">
								     <c:set var="d_couponId" value="${discountItem.id}"/> 
							      </c:if>
							      <c:if test="${discountItem.typeId eq 3 }">
								     <c:set var="d_productId" value="${discountItem.id}"/>
							      </c:if>
						    </c:forEach>
							<tr>
								<td>${status.index+1}</td>
								<td data-id="${item.id}">满<input type="text" class="special_form" value="${item.reachCondition}"/>
								<%-- 
								 <c:if test="${orgReach.reachStyle eq 0}">元</c:if>
								 <c:if test="${orgReach.reachStyle eq 1}">件</c:if>
								  --%>
								 </td>
								 
								<td  class="pos_left">
									<div class="checkbox">
									  	<div class="checkbox-title">
										  <label style="float:left">
										    <input type="checkbox" class="checkbox1 money" <c:if test="${fn:contains(discountTypeStr,'1')}">checked</c:if> >
										    减现金
										  </label>
										 </div>
										<div class="checkbox-content">
											<div class="form-group reduceMoney" style='display: <c:if test="${not fn:contains(discountTypeStr,'1')}">none</c:if>'>减<input  data-id="${d_moneyId}" type="text" class="w100" value="${item.orgReachDiscountList[0].common}"/>元</div>
											<div class="form-group"><label for=""><input class="moneyLoop" type="checkbox" <c:if test="${fn:contains(discountIsloopStr,'1')}">checked</c:if> />是否叠加</label></div>
										</div>
									</div>
									
									
									<div class="checkbox">
									  	<div class="checkbox-title">
										  <label style="float:left">
										    <input type="checkbox" value="" class="checkbox1 coupon" <c:if test="${fn:contains(discountTypeStr,'2')}">checked</c:if> >
										    送优惠券
										  </label>
										 </div>
										<div class="checkbox-content">
											<div class="form-group">
												<button data-id="${d_couponId}" style='display: <c:if test="${not fn:contains(discountTypeStr,'2')}">none</c:if> ' class="btn btn-success coupon">选择优惠券</button>
												<input type="hidden" name="coupon">
											</div>
											<div class="form-group"><label for=""><input class="couponLoop"  type="checkbox" <c:if test="${fn:contains(discountIsloopStr,'2')}">checked</c:if> />是否叠加</label></div>
										</div>
									</div>
									
									
									<div class="checkbox">
									  	<div class="checkbox-title">
										  <label style="float:left">
										    <input type="checkbox" value="" class="checkbox1 product" <c:if test="${fn:contains(discountTypeStr,'3')}">checked</c:if>  >
										    送赠品
										  </label>
										 </div>
										<div class="checkbox-content">
											<div class="form-group">
												<button data-id="${d_productId}" style='display: <c:if test="${not fn:contains(discountTypeStr,'3')}">none</c:if>' class="btn btn-success product">选择赠品</button>
												<input type="hidden" name="product">
											</div>
											<div class="form-group"><label for=""><input class="productLoop" type="checkbox" <c:if test="${fn:contains(discountIsloopStr,'3')}">checked</c:if> />是否叠加</label></div>
										</div>
									</div>
								</td>
								<td>
									<button class="btn btn-info btn-xs" >保存</button>
									<button class="btn btn-danger btn-xs" >删除</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
					<tbody  id="reachTemple" style="display:none">
						<tr>
							<td>1</td>
							<td data-id="0">满<input type="text" class="special_form" /></td>
							<td  class="pos_left">
								<div class="checkbox">
								  	<div class="checkbox-title">
									  <label style="float:left">
									    <input type="checkbox" class="checkbox1 money">
									    减现金
									  </label>
									 </div>
									<div class="checkbox-content">
										<div class="form-group reduceMoney" style='display: none'>减<input type="text" class="w100" />元</div>
										<div class="form-group"><label for=""><input class="moneyLoop" type="checkbox" />是否叠加</label></div>
									</div>
								</div>
								<div class="checkbox">
								  	<div class="checkbox-title">
									  <label style="float:left">
									    <input type="checkbox" value="" class="checkbox1 coupon">
									    送优惠券
									  </label>
									 </div>
									<div class="checkbox-content">
										<div class="form-group">
											<button style='display: none' class="btn btn-success coupon">选择优惠券</button>
											<input type="hidden" name="coupon">
										</div>
										<div class="form-group"><label for=""><input class="couponLoop"  type="checkbox" />是否叠加</label></div>
									</div>
								</div>
								<div class="checkbox">
								  	<div class="checkbox-title">
									  <label style="float:left">
									    <input type="checkbox" value="" class="checkbox1 product">
									    送赠品
									  </label>
									 </div>
									<div class="checkbox-content">
										<div class="form-group">
											<button style='display: none' class="btn btn-success product">选择赠品</button>
											<input type="hidden" name="product">
										</div>
										<div class="form-group"><label for=""><input class="productLoop" type="checkbox" />是否叠加</label></div>
									</div>
								</div>
							</td>
							<td>
								<button class="btn btn-info btn-xs" >保存</button>
								<button class="btn btn-danger btn-xs" >删除</button>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="add_new_table"><a href="javascript:void(0)" id="addReachBtn"><span class="glyphicon glyphicon-plus"></span>新增一级优惠</a></div>
				<p class="text-center margin5">
					<a type="button" href="${ctx}/reach/list" class="btn btn-default">返回</a>
					<!-- <button type="button" id="saveSetBtn"  class="btn btn-info">保存</button> -->
				</p>
			</div>
		</div>
	</div>
</div>
<%@ include file="../common/common_js.jsp"%>
<script type="text/javascript" src="${jsBase}/reach/editSet.js"></script>
</body>
</html>