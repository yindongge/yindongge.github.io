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
<title>新增企业会员</title>
<style>

</style>
</head>

<body>	
	<form class="form-horizontal media-control"  id="enterpriseform" name ="enterpriseform" action="../enterprise/save" method="post" enctype="multipart/form-data">
	<input type="hidden" name="enterpriseId" id="enterpriseId" value="${enterprise.enterpriseId}"/>
	<div class="class="page-wrapper">
		<div class="container-fluid">
			<ul class="breadcrumb" style="margin-bottom:10px; margin-top:5px;">
				<li>您的位置</li>
				<li ><a href="#">会员</a></li>
				<li ><a href="#">企业会员管理</a></li>
				<li class="active">新增企业会员</li>
			</ul>
	
			<div class="panel panel-default"> 
				<div class="panel-heading">新增企业会员</div> 
				<div class="panel-body">
				    <div class="form-group">
						<label class="col-sm-3 control-label" ><span class="red bigred">*</span>用户名：</label>
						<div class="col-sm-4">
							${enterprise.userName}
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" ><span class="red bigred">*</span>公司名称：</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="enterpriseName" id="enterpriseName" maxlength="40" value="${enterprise.enterpriseName}"/>
						</div>
						<div class="col-sm-1">
							<input type="button" class="form-control" value="是否存在" onclick="validateEnterpriseName()" style="width:85px;" />
						</div>
						<div class="col-sm-4">
							<span id="validateEnterpriseNameSpan"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" ><span class="red bigred">*</span>公司所在区域：</label>
						<div class="col-sm-3">
							<select class="form-control" name="provinceCode" id="provinceCode"
								min="0" data-bv-greaterthan-message="请选择区域">
								<option value="-1">选择省或者市</option>
								<c:forEach items="${listProvince}" var="province">
									<option value="${province.code }" <c:if test="${province.code==enterprise.provinceCode}">selected</c:if>>${province.name }</option>
								</c:forEach>
							</select>
							
						</div>
						<div class="col-sm-3">
							<select class="form-control" name="cityCode" id="cityCode">
								<option value="-1">请选择市</option>
								<c:forEach items="${listCity}" var="city">
									<option value="${city.code }" <c:if test="${city.code==enterprise.cityCode}">selected</c:if>>${city.name }</option>
								</c:forEach>
							</select>
							
						</div>
						<div class="col-sm-3">
							<select class="form-control" name="countyCode" id="countyCode">
								<option value="-1">请选择区或县</option>
								<c:forEach items="${listCounty}" var="county">
									<option value="${county.code }" <c:if test="${county.code==enterprise.countyCode}">selected</c:if>>${county.name }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" ><span class="red bigred">*</span>公司详细地址：</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="address" id="address" maxlength="50" value="${enterprise.address}"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" >推荐人手机：</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="referenceTel" id="referenceTel" value="${enterprise.referenceTel}" maxlength="11" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" >企业人数：</label>
						<div class="col-sm-4">
							<select class="form-control" name="employees" id="employees">
								<option value="">请选择</option>
								<c:forEach items="${employees}" var="item">
									<option value="${item.key}" <c:if test="${item.key==enterprise.employees}">selected</c:if>>${item.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" >公司行业：</label>
						<div class="col-sm-4">
							<select class="form-control" name="industry" id="industry">
								<option value="">请选择</option>
								<c:forEach items="${industry}" var="item">
									<option value="${item.key}" <c:if test="${item.key==enterprise.industry}">selected</c:if>>${item.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" >公司性质：</label>
						<div class="col-sm-4">
							<select class="form-control" name="nature" id="nature">
								<option value="">请选择</option>
								<c:forEach items="${nature}" var="item">
									<option value="${item.key}" <c:if test="${item.key==enterprise.nature}">selected</c:if>>${item.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" ><span class="red bigred">*</span>联系人姓名：</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="contactName" id="contactName" maxlength="10" value="${enterprise.contactName}"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" ><span class="red bigred">*</span>联系人邮箱：</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="contactEmail" id="contactEmail"  value="${enterprise.contactEmail}"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" ><span class="red bigred">*</span>验证手机：</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="mobile" id="mobile"  value="${enterprise.mobile}"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" ><span class="red bigred">*</span>所在部门：</label>
						<div class="col-sm-4">
							<select class="form-control" name="department" id="department">
								<option value="-1">请选择</option>
								<c:forEach items="${department}" var="item">
									<option value="${item.key}" <c:if test="${item.key==enterprise.department}">selected</c:if>>${item.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" ><span class="red bigred">*</span>固定电话：</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="landlines" id="landlines" maxlength="15"  value="${enterprise.landlines}"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" >组织机构代码证：</label>
						<div class="col-sm-3">
							<input type="file" style="margin-left:0px" class="color-control form-control" name="file_organizationCodeImg" id="file_organizationCodeImg"/>
						</div>
						<div class="col-sm-1" id="div_organizationCodeImg">
						    <c:if test="${null != enterprise.organizationCodeImg}">
								<img src="${ImageBaseUrl}${enterprise.organizationCodeImg}" onclick="changePicSize('showimg_organizationCodeImg','80')" title="单击放大或缩小" style="height:50px;width:80px" id="showimg_organizationCodeImg" alt="请先选择文件"/>
							</c:if>
							<c:if test="${null == enterprise.organizationCodeImg}">
								<img src="" style="height:40px;width:65px" id="showimg_organizationCodeImg" alt="请先选择文件"/>
							</c:if>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" >营业执照：</label>
						<div class="col-sm-3">
							<input type="file" style="margin-left:0px" class="color-control form-control" name="file_businessLicenImg" id="file_businessLicenImg"/>
						</div>
						<div class="col-sm-1" id="div_businessLicenImg">
						    <c:if test="${null != enterprise.businessLicenImg}">
								<img src="${ImageBaseUrl}${enterprise.businessLicenImg}" onclick="changePicSize('showimg_businessLicenImg','80')" title="单击放大或缩小" style="height:50px;width:80px" id="showimg_businessLicenImg" alt="请先选择文件"/>
							</c:if>
							<c:if test="${null == enterprise.businessLicenImg}">
								<img src="" style="height:40px;width:65px" id="showimg_businessLicenImg" alt="请先选择文件"/>
							</c:if>
						</div>
					</div>
					
			</div>
			<div class="text-center">
				<button type="button" class="btn btn-default modal-button" data-dismiss="modal" onclick="cancle()">返回</button>
				<button type="button"  class="btn btn-danger" onclick="savedata()">保存</button>
			</div>
			<br/><br/>
		</div>
	</div>
	</form>
	<%@include file="../common/common_js.jsp" %>
	<script src="${jsBase}/user/enterpriseEdit.js" type="text/javascript"></script>
	<script type="text/javascript">
	</script>
</body>
</html>
