<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="description" content="快捷健商城KJJHOME.COM-销售国内外各大品牌食品、零食、酒水饮料、粮油调味、个人化妆、办公日用.快乐、便捷、健康，让快捷健商城的生活更健康!"/>
<meta name="Keywords" content="网上购物,网上商城,零食,食品,酒水饮料,粮油调味,个护化妆,办公日用,快捷健商城"/>
<%@include file="../common/common_css.jsp" %>
<style>
.form-center input{padding-left: 10px;}
</style>
<title>快捷健商城 – 1小时送达,0元配送,随时取货!</title>
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
				<jsp:param name="active" value="账户安全"/>
			</jsp:include>
			<!-- member-left -->
			<div class="member-right">
			    <form action="" id="enterpriseEditForm" name="enterpriseEditForm">
				<input type="hidden" name="enterpriseId" id="enterpriseId" value="${enterprise.enterpriseId}"/>
				<div class="company-regin-box">
				    <div class="copmanyfloor">
						<div class="copmany-title" style="margin-top:-10px;margin-bottom:20px">公司信息</div>
						<div class="company-content">
							<div class="form-list">
								<div class="form-left">
									<span class="red-star">*</span>公司名称：
								</div>
								<div class="form-center" id="enterpriseNamediv">
									<input type="text" name="enterpriseName" id="enterpriseName" maxlength="40" value="${enterprise.enterpriseName}"/>
								</div>
								<div class="form-right">
									<p id="enterpriseNameTip"></p>
								</div>
							</div>
							<div class="form-list">
								<div class="form-left">
									<span class="red-star">*</span>公司所在区域：
								</div>
								<div class="form-center" style="margin-left:-15px" id="countydiv">
									<div class="col-sm-4" style="margin-left:0px;">
										<select name="provinceCode" id="provinceCode" style="width:102px;height:40px">
											<option value="-1">选择省或者市</option>
											<c:forEach items="${listProvince}" var="province">
												<option value="${province.code }" <c:if test="${province.code==enterprise.provinceCode}">selected</c:if>>${province.name }</option>
											</c:forEach>
										</select>
									</div>
									<div class="col-sm-4">
										<select name="cityCode" id="cityCode" style="width:102px;height:40px">
										    <option value="-1">请选择市</option>
											<c:forEach items="${listCity}" var="city">
												<option value="${city.code }" <c:if test="${city.code==enterprise.cityCode}">selected</c:if>>${city.name }</option>
											</c:forEach>
										</select>
									</div>
									<div class="col-sm-4">
										<select name="countyCode" id="countyCode" style="width:102px;height:40px">
											<option value="-1">请选择区或县</option>
											<c:forEach items="${listCounty}" var="county">
												<option value="${county.code }" <c:if test="${county.code==enterprise.countyCode}">selected</c:if>>${county.name }</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-right">
									<p id="countyTip" style="margin-left:18px;width:100%"></p>
								</div>
							</div>
							<div class="form-list">
								<div class="form-left">
									<span class="red-star">*</span>公司详细地址：
								</div>
								<div class="form-center" id="addressdiv">
									<input type="text" name="address" id="address" maxlength="50" value="${enterprise.address}"/>
								</div>
								<div class="form-right">
									<p id="addressTip"></p>
								</div>
							</div>
							<div class="form-list">
								<div class="form-left">
									推荐人手机：
								</div>
								<div class="form-center">
									<input type="text" name="referenceTel" id="referenceTel" maxlength="11" value="${enterprise.referenceTel}" onkeypress="if(!this.value.match(/^\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?\d+)?$/))this.o_value=this.value;" onkeyup="if(!this.value.match(/^\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?\d+)?$/))this.o_value=this.value" onblur="if(!this.value.match(/^(?\d+)?$/))this.value=this.o_value;else{if(this.value.match(/^\.\d+$/))this.value=0+this.value;if(this.value.match(/^\.$/))this.value=0;this.o_value=this.value}"/>
								</div>
							</div>
							<div class="form-list">
								<div class="form-left">
									企业人数：
								</div>
								<div class="form-center">
									<select name="employees" id="employees" style="height:40px;width:315px">
										<option value="">请选择</option>
										<c:forEach items="${employees}" var="item">
											<option value="${item.key}" <c:if test="${item.key==enterprise.employees}">selected</c:if>>${item.value}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-list">
								<div class="form-left">
									公司行业：
								</div>
								<div class="form-center">
									<select name="industry" id="industry" style="height:40px;width:315px">
										<option value="">请选择</option>
										<c:forEach items="${industry}" var="item">
											<option value="${item.key}" <c:if test="${item.key==enterprise.industry}">selected</c:if>>${item.value}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-list">
								<div class="form-left">
									公司性质：
								</div>
								<div class="form-center">
									<select name="nature" id="nature" style="height:40px;width:315px">
										<option value="">请选择</option>
										<c:forEach items="${nature}" var="item">
											<option value="${item.key}" <c:if test="${item.key==enterprise.nature}">selected</c:if>>${item.value}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
					</div>
				    <div class="copmanyfloor">
						<div class="copmany-title">联系人信息</div>
						<div class="company-content">
							<div class="form-list">
								<div class="form-left">
									<span class="red-star">*</span>联系人姓名：
								</div>
								<div class="form-center" id="contactNamediv">
									<input name="contactName" id="contactName" maxlength="20" value="${enterprise.contactName}"/>
								</div>
								<div class="form-right">
									<p id="contactNameTip"></p>
								</div>
							</div>
							<div class="form-list">
								<div class="form-left">
									<span class="red-star">*</span>所在部门：
								</div>
								<div class="form-center" id="departmentdiv">
									<select name="department" id="department" style="height:40px;width:315px">
										<option value="-1">请选择</option>
										<c:forEach items="${department}" var="item">
											<option value="${item.key}" <c:if test="${item.key==enterprise.department}">selected</c:if>>${item.value}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-right">
									<p id="departmentTip"></p>
								</div>
							</div>
							<div class="form-list">
								<div class="form-left">
									<span class="red-star">*</span>固定电话：
								</div>
								<div class="form-center" id="landlinesdiv">
									<input type="text" name="landlines" id="landlines" maxlength="15" value="${enterprise.landlines}"/>
								</div>
								<div class="form-right">
									<p id="landlinesTip"></p>
								</div>
							</div>
							<div class="form-list">
								<div class="form-left">
									<span class="red-star">*</span>联系人邮箱：
								</div>
								<div class="form-center" id="contactEmaildiv">
									<input type="text" name="contactEmail" id="contactEmail" maxlength="30" value="${enterprise.contactEmail}"/>
								</div>
								<div class="form-right">
									<p id="contactEmailTip"></p>
								</div>
							</div>
							<div class="form-list">
								<div class="form-left">
									验证手机：
								</div>
								<div class="form-center" id="mobilediv" style="margin-top:12px">
									${enterprise.mobile}
								</div>
								<div class="form-right">
									<p id="mobileTip"></p>
								</div>
							</div>
							<div class="form-list">
								<div class="form-left">
		
								</div>
								<div class="form-center">
									<button type="button"  class="btn btn-warning" onclick="regist()" id="mySubmit" >提交</button>
								</div>
								<div class="form-right">
								</div>
							</div>
						</div>
					</div>
				</div>
				</form>
			</div>
			
			<!-- end memberright -->
		</div>
	</div>

<!--  -->
<%@include file="../common/common_foot.jsp" %>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/register/enterpriseEdit.js" type="text/javascript"></script>
</div>
</body>
</html>