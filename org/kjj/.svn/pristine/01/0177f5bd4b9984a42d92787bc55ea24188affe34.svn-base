<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<%@include file="../common/common_css.jsp" %>
<title>修改触摸屏首页</title>
<style>

</style>
</head>

<body>
<div class="page-wrapper ">
<div class="container-fluid">
	<div class="page-wrapper">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li>您的位置</li>
				<li><a href="#">店铺</a></li>
				<li><a href="#">首页管理</a></li>
				<li class="active">修改触摸屏首页</li>
			</ul>
			<!-- 切换 -->
			<div class="btn-group btn-group-justified" role="group" aria-label="Justified button group">
			   <a href="#" class="btn btn-primary " role="button">基本信息</a>
			   <a href="${ctx}/touchPage/bannerList?pageId=${page.id}" class="btn btn-info" role="button">轮播图</a>
		    </div>
			<!-- 切换 -->
			<form class="form-inline" id="touchPageform" name ="touchPageform" action="../touchPage/updateTouchPage" method="post" enctype="multipart/form-data">
			<input type="hidden" name="areaCode" id="areaCode"/>
			<input type="hidden" id="id" name="id" value="${page.id}"/>
			<table class="table table-bordered new-table">
				<tbody>
					<tr>
						<td  class="td_control100 " ><span class="red"></span>选择区域：</td>
						<td class="center_left">
							<div class="form-group ">
								<select class="form-control w180" name="provinceCode" id="provinceCode"
								min="0" data-bv-greaterthan-message="请选择区域">
									<option value="">选择省份</option>
									<c:forEach items="${listProvince}" var="province">
										<option value="${province.code}" <c:if test="${province.code==provinceCode}">selected</c:if>>${province.name}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<select class="form-control w180" name="cityCode" id="cityCode">
									<option value="">选择城市</option>
									<c:forEach items="${listCity}" var="city">
									<option value="${city.code}" <c:if test="${city.code==cityCode}">selected</c:if>>${city.name}</option>
								</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<select class="form-control w180" name="countryCode" id="countryCode">
									<option value="">选择区县</option>
									<c:forEach items="${listCountry}" var="country">
									<option value="${country.code}" <c:if test="${country.code==countryCode}">selected</c:if>>${country.name}</option>
								</c:forEach>
								</select>
							</div>
						</td>
					</tr>
					<tr>
						<td  class="td_control100 " ><span class="red"></span>门店选择：</td>
						<td class="center_left">
							<div class="form-group ">
								<select class="form-control w180" name="shopId" id="shopId">
									<option value="">选择门店</option>
								</select>
							</div>
						</td>
					</tr>
					<tr>
						<td  class="td_control100 " ><span class="red"></span>是否启用：</td>
						<td class="center_left">
							<div class="form-group ">
								<select class="form-control w180" name="status" id="status">
									<option value="1" <c:if test="${page.status == 1}">selected</c:if>>是</option>
									<option value="0" <c:if test="${page.status == 0}">selected</c:if>>否</option>
								</select>
							</div>
						</td>
					</tr>
					<tr>
						<td  class="td_control100 " ></td>
						<td class="center_left">
							<div class="form-group ">
								<button type="button" class="btn btn-default w100" onclick="saveData()">保存</button>
								<button type="button" class="btn btn-default w100" data-dismiss="modal" onclick="cancle()">返回</button>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			</form>
		</div>
	</div>
</div>
	<%@include file="../common/common_js.jsp" %>
	<script src="${jsBase}/touchPage/touchPageEdit.js" type="text/javascript"></script>
</div>
</body>
<script type="text/javascript">
function pageInit(){
	// 店铺select初始化
	var countryCode = "${countryCode}";
	var shopCode = "${page.shopId}";
	if(countryCode != "" && countryCode !="null"){
		getshoplist(countryCode,shopCode);
	}
}
	pageInit();
</script>
</html>
