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
<title>企业会员审批</title>
<style>
    body{font-size:12px;}
</style>
</head>

<body>	
	<form class="form-horizontal media-control"  id="enterpriseform" name ="enterpriseform" action="../enterprise/check" method="post" enctype="multipart/form-data">
	<input type="hidden" name="enterpriseId" id="enterpriseId" value="${enterprise.enterpriseId}"/>
	<input type="hidden" name="checkStatus" id="checkStatus"/>
	<input type="hidden" name="enterpriseName" id="enterpriseName" value="${enterprise.enterpriseName}"/>
	<div class="class="page-wrapper">
		<div class="container-fluid">
			<ul class="breadcrumb" style="margin-bottom:10px; margin-top:5px;">
				<li>您的位置</li>
				<li ><a href="#">会员</a></li>
				<li ><a href="#">企业会员管理</a></li>
				<li class="active">企业会员审批</li>
			</ul>
	
			<div class="panel panel-default"> 
				<div class="panel-heading">企业会员审批</div> 
				<div class="panel-body">
				    <div class="form-group">
						<label class="col-sm-3 control-label" >用户名：</label>
						<div class="col-sm-4" style="margin-top:6px">
							${enterprise.userName}
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" >公司名称：</label>
						<div class="col-sm-4" style="margin-top:6px">
							${enterprise.enterpriseName}
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" >公司所在区域：</label>
						<div class="col-sm-3" style="margin-top:6px" id="quyuDiv">
						    
						</div>
						<div style="display:none">
						    <select class="form-control" name="provinceCode" id="provinceCode">
								<c:forEach items="${listProvince}" var="province">
									<option value="${province.code }" <c:if test="${province.code==enterprise.provinceCode}">selected</c:if>>${province.name }</option>
								</c:forEach>
							</select>
							<select class="form-control" name="cityCode" id="cityCode">
								<c:forEach items="${listCity}" var="city">
									<option value="${city.code }" <c:if test="${city.code==enterprise.cityCode}">selected</c:if>>${city.name }</option>
								</c:forEach>
							</select>
							<select class="form-control" name="countyCode" id="countyCode">
								<c:forEach items="${listCounty}" var="county">
									<option value="${county.code }" <c:if test="${county.code==enterprise.countyCode}">selected</c:if>>${county.name }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" >公司详细地址：</label>
						<div class="col-sm-4" style="margin-top:6px">
							${enterprise.address}
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" >推荐人手机：</label>
						<div class="col-sm-4" style="margin-top:6px">
							${enterprise.referenceTel}
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" >企业人数：</label>
						<div class="col-sm-4" style="margin-top:6px" id="employeesDiv">
							
						</div>
						<div style="display:none">
						    <select class="form-control" name="employees" id="employees">
								<c:forEach items="${employees}" var="item">
									<option value="${item.key}" <c:if test="${item.key==enterprise.employees}">selected</c:if>>${item.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" >公司行业：</label>
						<div class="col-sm-4" style="margin-top:6px" id="industryDiv">
							
						</div>
						<div style="display:none">
						    <select class="form-control" name="industry" id="industry">
								<c:forEach items="${industry}" var="item">
									<option value="${item.key}" <c:if test="${item.key==enterprise.industry}">selected</c:if>>${item.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" >公司性质：</label>
						<div class="col-sm-4" style="margin-top:6px" id="natureDiv">
							
						</div>
						<div style="display:none">
						    <select class="form-control" name="nature" id="nature">
								<c:forEach items="${nature}" var="item">
									<option value="${item.key}" <c:if test="${item.key==enterprise.nature}">selected</c:if>>${item.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" >联系人姓名：</label>
						<div class="col-sm-4" style="margin-top:6px">
							${enterprise.contactName}
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" >所在部门：</label>
						<div class="col-sm-4" style="margin-top:6px" id="departmentDiv">
							
						</div>
						<div style="display:none">
						    <select class="form-control" name="department" id="department">

								<c:forEach items="${department}" var="item">
									<option value="${item.key}" <c:if test="${item.key==enterprise.department}">selected</c:if>>${item.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" >固定电话：</label>
						<div class="col-sm-4" style="margin-top:6px">
							${enterprise.landlines}
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" >联系人邮箱：</label>
						<div class="col-sm-4" style="margin-top:6px">
							${enterprise.contactEmail}
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" >验证手机：</label>
						<div class="col-sm-4" style="margin-top:6px">
							${enterprise.mobile}
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" >组织机构代码证：</label>
						<div class="col-sm-3" id="div_organizationCodeImg" style="margin-top:6px">
							<c:if test="${null != enterprise.organizationCodeImg}">
								<img src="${ImageBaseUrl}${enterprise.organizationCodeImg}" onclick="changePicSize('showimg_organizationCodeImg','80')" title="单击放大或缩小" style="height:50px;width:80px" id="showimg_organizationCodeImg" alt="请先选择文件"/>
							</c:if>
							<c:if test="${null == enterprise.organizationCodeImg}">
								未上传
							</c:if>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" >营业执照：</label>
						<div class="col-sm-3" id="div_businessLicenImg" style="margin-top:6px">
							<c:if test="${null != enterprise.businessLicenImg}">
								<img src="${ImageBaseUrl}${enterprise.businessLicenImg}" onclick="changePicSize('showimg_businessLicenImg','80')" title="单击放大或缩小" style="height:50px;width:80px" id="showimg_businessLicenImg" alt="请先选择文件"/>
							</c:if>
							<c:if test="${null == enterprise.businessLicenImg}">
								未上传
							</c:if>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" >备注(最多50个字)：</label>
						<div class="col-sm-1"  style="margin-top:6px">
							<textarea class="color-control form-control" rows="6" cols="40" id="remark" name="remark" style="margin-left:0px"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" >短信内容(最多150个字)：</label>
						<div class="col-sm-1"  style="margin-top:6px">
							<textarea class="color-control form-control" rows="6" cols="40" id="message" name="message" style="margin-left:0px"></textarea>
						</div>
					</div>
			</div>
			<div class="text-center">
				<button type="button"  class="btn btn-danger" onclick="doCheck('${enterprise.enterpriseId}','1')">审核通过</button>
				<button type="button"  class="btn btn-danger" onclick="doCheck('${enterprise.enterpriseId}','2')">审核不通过</button>
				<button type="button" class="btn btn-default modal-button" data-dismiss="modal" onclick="cancle()">返回</button>
			</div>
			<br/><br/>
		</div>
		<div class="breadcrumb breadcrumb-title">审批历史</div>
		<table class="table table-hover table-bordered table-striped table-4" style="margin-top:-20px">
			<thead>
				<tr class="info">
					<th>审核人</th>
					<th>审核时间</th>
					<th>审批结果</th>
					<th>备注</th>
				</tr>
			</thead> 
			<tbody>
				<c:forEach var="item" items="${checkList}" varStatus="status">
				<tr  class="icon11 zhekoutext">
					<td>${item.userName}</td>
					<td><fmt:formatDate value="${item.checkTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>
					    <c:if test="${ item.checkStatus=='1'}">审核通过</c:if>
					    <c:if test="${ item.checkStatus=='2'}">审核不通过</c:if>
					
					</td>
					<td>${item.remark}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</form>
	<%@include file="../common/common_js.jsp" %>
	<script src="${jsBase}/user/enterpriseCheck.js" type="text/javascript"></script>
	<script type="text/javascript">
	    $("#quyuDiv").append($("#provinceCode").find("option:selected").text()+$("#cityCode").find("option:selected").text()+$("#countyCode").find("option:selected").text());
	    $("#employeesDiv").append($("#employees").find("option:selected").text());
	    $("#industryDiv").append($("#industry").find("option:selected").text());
	    $("#natureDiv").append($("#nature").find("option:selected").text());
	    $("#departmentDiv").append($("#department").find("option:selected").text()); 
	</script>
</body>
</html>
