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
<title>修改电商会员折扣</title>
<style type="text/css">
.couponSelectText {
         color: #333;
     font-size: 12px;
   font-family: inherit;
vertical-align: baseline;
padding-top:5px;
}
</style>
</head>
<body>
<form class="form-horizontal media-control" id="couponAdd" name="couponAdd" action="${ctx}/levelprice/saveLevelCoupon" method="post">
<input type="hidden" name="levelCouponId" id="levelCouponId" value="${levelCoupon.levelCouponId}"/>
<input type="hidden" name="preProductType" id="preProductType" value="${levelCoupon.productType}"/>
<input type="hidden" name="goodsId" id="goodsId" value="${levelCoupon.goodsId}"/>
<input type="hidden" name="goodsName" id="goodsName" value="${levelCoupon.goodsName}"/>
<input type="hidden" name="status" id="status" value="${levelCoupon.status}"/>
<input type="hidden" name="classId" id="classId" value="${levelCoupon.classId}"/>
<input type="hidden" name="className" id="className" value="${levelCoupon.className}"/>
<input type="hidden" name="cityShopId" id="cityShopId" value="${levelCoupon.cityShopId}"/>
<input type="hidden" name="discountAll" id="discountAll" value=""/>
<div class="page-wrapper">
<div class="container-fluid">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">运营</a></li>
			<li ><a href="#">价格体系</a></li>
			<li class="active">电商会员价格</li>
	</ul>
	
	<div class="panel panel-default">
		<div class="panel-heading">修改电商会员折扣</div>
		<div class="panel-body">
					<div class="form-group">
						<label class="col-sm-3 control-label" ><span class="red bigred">*</span>适用范围：</label>
						<div class="col-sm-3">
							<select class="form-control" id="shopType" name="shopType">
								<!-- <option value="0">选择范围</option> -->
								<option value="1" <c:if test="${levelCoupon.shopType==1}">selected</c:if>>全部区域</option>
								<option value="2" <c:if test="${levelCoupon.shopType==2}">selected</c:if>>单区域</option>
								<option value="3" <c:if test="${levelCoupon.shopType==3}">selected</c:if>>单区域门店</option>
							</select>	
						</div>
						
						<div class="col-sm-3 shopTypeCity" style="display:none">
							<select class="form-control" id="cityCode" name="cityCode">
								<option value="110100">北京</option>
							</select>
						</div>
						<div class="col-sm-6 couponSelectText shopsName" style="display:none">
							已经选择的店铺：${shopName}
						</div>
					</div>
				
					<div class="form-group">
						<label class="col-sm-3 control-label" ><span class="red bigred">*</span>类型：</label>	
						<div class="col-sm-9" >
							<div class="row margin-left">
								<div class="col-sm-3" style="padding-left:0px;">
									<select class="form-control" id="productType" name="productType">
										<!-- <option value="0">选择类型</option> -->
										<option value="1" <c:if test="${levelCoupon.productType==1}">selected</c:if>>所有商品</option>
										<option value="2" <c:if test="${levelCoupon.productType==2}">selected</c:if>>指定类别</option>
										<option value="3" <c:if test="${levelCoupon.productType==3}">selected</c:if>>指定商品</option>
									</select>
								</div>
								<div class="col-sm-3 productTypeClass" style="display: none;">
									<div class="form-group">
										<select class="form-control" id="listClass">
										<c:forEach var="clazz" items="${listClass}">
											<option value="${clazz.classId}" data-name="${clazz.className}" data-parent="${clazz.classParent}" <c:if test="${levelCoupon.classId==clazz.classId}">selected</c:if>><c:if test="${clazz.classLevel==2}">&nbsp;&nbsp;&nbsp;&nbsp;</c:if>${clazz.className}</option>
										</c:forEach>
										</select>
									</div>
								</div>
							</div>
							<div class="row margin-left productTypeClass" style="display: none;">
								<div class="col-sm-6 divClass couponSelectText" style="padding-left:0px;">
									已选择分类：${levelCoupon.className}
								</div>
							</div>
							
							<div class="col-sm-6 couponSelectText productName" style="display:none">
									已经选择的商品:${levelCoupon.goodsName}
							</div>
						</div>
					</div>
					<c:forEach var="level" items="${userLevels}" varStatus="status">
					<div class="form-group discountrow">
						<label class="col-sm-3 control-label" >${level.levelName}价格折扣：</label>
						<div class="col-sm-2">
						   <input type="text"	class="form-control level-discount"  name="discount"  value="${level.discount}"  data-level-id="${level.levelId}" data-level-name="${level.levelName}" onkeypress="if(!this.value.match(/^\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?\d+(?:\.\d+)?)?$/))this.o_value=this.value;" onkeyup="if(!this.value.match(/^\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?\d+(?:\.\d+)?)?$/))this.o_value=this.value" onblur="if(!this.value.match(/^(?\d+(?:\.\d+)?|\.\d*?)?$/))this.value=this.o_value;else{if(this.value.match(/^\.\d+$/))this.value=0+this.value;if(this.value.match(/^\.$/))this.value=0;this.o_value=this.value}" maxlength="10"/>
						</div>
					</div>
					<div class="form-group pricerow" style="display: none;">
						<label class="col-sm-3 control-label" >${level.levelName}价格金额：</label>
						<div class="col-sm-2">
						   <input type="text"	class="form-control level-price" name="price" value="${level.price}"  data-level-id="${level.levelId}" data-level-name="${level.levelName}"  onkeypress="if(!this.value.match(/^\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?\d+(?:\.\d+)?)?$/))this.o_value=this.value;" onkeyup="if(!this.value.match(/^\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?\d+(?:\.\d+)?)?$/))this.o_value=this.value" onblur="if(!this.value.match(/^(?\d+(?:\.\d+)?|\.\d*?)?$/))this.value=this.o_value;else{if(this.value.match(/^\.\d+$/))this.value=0+this.value;if(this.value.match(/^\.$/))this.value=0;this.o_value=this.value}" maxlength="10"/>
						</div>
					</div>
					</c:forEach>
					<input type="hidden" id="couponDiscount" name="couponDiscount" />
				
					<!-- 分割线 -->
		</div>
	</div>
	<br/>
	<div class="text-center">
		<a type="button" class="btn btn-primary" role="button"  href="${ctx}/levelprice/levelcoupon" style="margin-right:30px">返回</a>
		<button type="button"  class="btn btn-danger">保存</button>
	</div>
	<br/>
</div>
</div>
</form>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/levelDiscount/couponEdit.js" type="text/javascript"></script>
</body>
</html>