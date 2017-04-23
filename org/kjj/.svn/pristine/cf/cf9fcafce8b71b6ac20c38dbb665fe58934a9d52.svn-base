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
<link href="${cssBase}/jqzoom.css" type="text/css" rel="stylesheet"/>
<script src="${jsBase}/common/jquery.jqzoom.js" type="text/javascript"></script>
<title>新增企业会员</title>
<style>
    body{font-size:12px;}
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
				<li class="active">企业会员详细信息</li>
			</ul>
			<table class="table table-hover table-bordered strong-td ">
				<thead>
					<tr class="info">
						<th style="border:0px">  账户信息</th>
						<th style="border:0px"></th>
						<th style="border:0px"></th>
						<th style="border:0px"></th>
						<th style="border:0px"></th>
						<th style="border:0px"></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>用户名：</td>
						<td>${orgUsers.userName}</td>
						<td class="strong-b">手机：</td>
						<td>${orgUsers.mobilePhone}</td>
						<td class="strong-b" >邮箱：</td>
						<td>${orgUsers.email}</td>
					</tr>
					<tr>
						<td>会员类型：</td>
						<td>
							<c:if test="${orgUsers.levelType==1}">个人用户</c:if>
							<c:if test="${orgUsers.levelType==2}">企业用户</c:if>
							<c:if test="${orgUsers.levelType==3}">关联企业用户</c:if>
						</td>
						<td class="strong-b" >会员级别：</td>
						<td>${orgUsers.levelId}</td>
						<td class="strong-b" >状态：</td>
						<td><c:if test="${orgUsers.status==0}">正常</c:if><c:if test="${orgUsers.status==1}">锁定</c:if></td>
					</tr>
					<tr>
						<td>注册时间：</td>
						<td><fmt:formatDate value="${orgUsers.regTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td class="strong-b">上次登录时间：</td>
						<td><fmt:formatDate value="${orgUsers.lastLogin}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td class="strong-b" ></td>
						<td></td>
					</tr>
				<thead>
					<tr class="info">
						<th style="border:0px">  公司信息</th>
						<th style="border:0px"></th>
						<th style="border:0px"></th>
						<th style="border:0px"></th>
						<th style="border:0px"></th>
						<th style="border:0px"></th>
					</tr>
				</thead>
				<tbody>
				    <tr>
				        <td>公司名称：</td>
						<td colspan="2">${enterprise.enterpriseName}</td>
						<td><strong>公司所在区域：</strong></td>
						<td colspan="2"><div id="quyuDiv"></div></td>
				    </tr>
					<tr>
				        <td>公司详细地址：</td>
						<td colspan="2">${enterprise.address}</td>
						<td><strong>关联用户数：</strong></td>
						<td colspan="2" nowrap="nowrap">${userNumber}(人)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="查看关联用户" onclick="showEnterpriseUsers('${enterprise.enterpriseId}')" style="width:100px;"/></td>
				    </tr>
				    <tr>
				        <td>推荐人手机：</td>
						<td colspan="2">${enterprise.referenceTel}</td>
						<td><strong>企业人数：</strong></td>
						<td colspan="2" nowrap="nowrap"><div id="employeesDiv"></div></td>
				    </tr>
				    <tr>
				        <td>公司行业：</td>
						<td colspan="2"><div id="industryDiv"></div></td>
						<td><strong>公司性质：</strong></td>
						<td colspan="2" nowrap="nowrap"><div id="natureDiv"></div></td>
				    </tr>
				    <tr>
				        <td>组织机构代码证：</td>
						<td colspan="2">
							<c:if test="${null != enterprise.organizationCodeImg}">
								<img src="${ImageBaseUrl}${enterprise.organizationCodeImg}" onclick="changePicSize('showimg_organizationCodeImg','80')" title="单击放大或缩小" style="height:50px;width:80px" id="showimg_organizationCodeImg" alt="请先选择文件"/>
							</c:if>
							<c:if test="${null == enterprise.organizationCodeImg}">
								未上传
							</c:if>
						</td>
						<td><strong>营业执照：</strong></td>
						<td colspan="2" nowrap="nowrap">
							<c:if test="${null != enterprise.businessLicenImg}">
								<img src="${ImageBaseUrl}${enterprise.businessLicenImg}" onclick="changePicSize('showimg_businessLicenImg','80')" title="单击放大或缩小" style="height:50px;width:80px" id="showimg_businessLicenImg" alt="请先选择文件"/>
							</c:if>
							<c:if test="${null == enterprise.businessLicenImg}">
								未上传
							</c:if>
						</td>
				    </tr>
				</tbody>
				<thead>
					<tr class="info">
						<th style="border:0px">  联系人信息</th>
						<th style="border:0px"></th>
						<th style="border:0px"></th>
						<th style="border:0px"></th>
						<th style="border:0px"></th>
						<th style="border:0px"></th>
					</tr>
				</thead>
				<tbody>
				    <tr>
				        <td>联系人姓名：</td>
						<td colspan="2">${enterprise.contactName}</td>
						<td><strong>所在部门：</strong></td>
						<td colspan="2"><div id="departmentDiv"></div></td>
				    </tr>
				    <tr>
				        <td>固定电话：</td>
						<td colspan="2">${enterprise.landlines}</td>
						<td><strong>联系人邮箱：</strong></td>
						<td colspan="2">${enterprise.contactEmail}</td>
				    </tr>
				    <tr>
				        <td>验证手机：</td>
						<td colspan="2">${enterprise.mobile}</td>
						<td></td>
						<td colspan="2"></td>
				    </tr>
				</tbody>
			</table>
			<br/>
			<c:if test="${1 == enterprise.status}">
			<table class="table table-hover table-bordered" style="margin-top:-20px">
				<thead>
					<tr class="info">
						<th style="border:0px">统一邀请码</th>
						<th style="border:0px"></th>
						<th style="border:0px"></th>
						<th style="border:0px"></th>
					</tr>
				</thead> 
				<tbody>
				    <tr>
				    	<td><strong>邀请码</strong></td>
				    	<td><strong>有效期</strong></td>
				    	<td><strong>最多激活数</strong></td>
				    	<td><strong>剩余激活数</strong></td>
				    </tr>
					<c:forEach var="item" items="${easyInvitationList}" varStatus="status">
					<tr  class="icon11 zhekoutext">
						<td>${item.code}</td>
						<td><fmt:formatDate value="${item.startTime}" pattern="yyyy-MM-dd HH:mm:ss" />~<fmt:formatDate value="${item.endTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>${item.ceiling}</td>
						<td>${item.rest}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<input type="button" value="生成统一邀请码" onclick="doCreateEasyInvitation('${enterprise.enterpriseId}')"/>
			<br/>
			<br/>
			</c:if>
			<br/>
			<table class="table table-hover table-bordered" style="margin-top:-20px">
				<thead>
					<tr class="info">
						<th style="border:0px">审核历史</th>
						<th style="border:0px"></th>
						<th style="border:0px"></th>
						<th style="border:0px"></th>
					</tr>
				</thead> 
				<tbody>
				    <tr>
				    	<td><strong>审核人</strong></td>
				    	<td><strong>审核时间</strong></td>
				    	<td><strong>审批结果</strong></td>
				    	<td><strong>备注</strong></td>
				    </tr>
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
			<br/>
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
				<select class="form-control" name="employees" id="employees">
					<c:forEach items="${employees}" var="item">
						<option value="${item.key}" <c:if test="${item.key==enterprise.employees}">selected</c:if>>${item.value}</option>
					</c:forEach>
				</select>
				<select class="form-control" name="industry" id="industry">
					<c:forEach items="${industry}" var="item">
						<option value="${item.key}" <c:if test="${item.key==enterprise.industry}">selected</c:if>>${item.value}</option>
					</c:forEach>
				</select>
				<select class="form-control" name="nature" id="nature">
					<c:forEach items="${nature}" var="item">
						<option value="${item.key}" <c:if test="${item.key==enterprise.nature}">selected</c:if>>${item.value}</option>
					</c:forEach>
				</select>
				<select class="form-control" name="department" id="department">
					<c:forEach items="${department}" var="item">
						<option value="${item.key}" <c:if test="${item.key==enterprise.department}">selected</c:if>>${item.value}</option>
					</c:forEach>
				</select>
			</div>
			<div class="text-center">
				<button type="button" class="btn btn-default modal-button" data-dismiss="modal" onclick="cancle()">返回</button>
			</div>
			<br/>
		</div>
	</div>
	</form>
	<%@include file="../common/common_js.jsp" %>
	<script src="${jsBase}/user/enterpriseDetail.js" type="text/javascript"></script>
	<script type="text/javascript">
	    $("#quyuDiv").append($("#provinceCode").find("option:selected").text()+$("#cityCode").find("option:selected").text()+$("#countyCode").find("option:selected").text());
	    $("#employeesDiv").append($("#employees").find("option:selected").text());
	    $("#industryDiv").append($("#industry").find("option:selected").text());
	    $("#natureDiv").append($("#nature").find("option:selected").text());
	    $("#departmentDiv").append($("#department").find("option:selected").text()); 
	    function doCreateEasyInvitation(enterpriseId){
	    	$.ajax({
		        type: "POST",
		        dataType: "json",
		        url: "../enterprise/validateEasyInvitation",
		        data: {'enterpriseId':enterpriseId},
		        success: function (data) {  
		           if(data.pass=="yes"){
		        	   window.location.href='../enterprise/preAddEasyInvitation?enterpriseId=' + enterpriseId;
		        	   
		           }else{
		        	   alert("不能创建统一邀请码，该企业还有未使用完的统一邀请码!");
		           }
		        },
		        error: function(data) {
		        	alert("操作失败，请联系管理员!");
		         }
		    });		
	    	
	    	
	    }
	</script>
</body>
</html>
