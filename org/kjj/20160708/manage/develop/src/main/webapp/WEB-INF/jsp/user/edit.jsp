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
<title>添加用户</title>
<title>店铺编辑</title>
</head>

<body>	
<div class="page-wrapper goods-control">
<div class="container-fluid">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">商品</a></li>
		<li ><a href="#">资料管理</a></li>
		<li >添加会员信息</li>
	</ul>
	<br/>
<form id="userform" name ="userform" action="${ctx}/user/update" method="post">
	<input type="hidden" id="userId" name="userId" value="${orgUsers.userId}"></input>
	<table class="table table-hover table-bordered table-special10 ">
		<tbody>
			<tr>
				<td width="300px">* 用户名：</td>
				<td colspan="6"><input type="text" id="userName" name="userName" value="${orgUsers.userName}"/> </td>
			</tr>
			<tr>
				<td width="300px">姓名：</td>
				<td colspan="6"><input type="text" id="realname" name="realname" value="${orgUsers.realname}"/>  </td>
			</tr>
			<tr>
				<td width="300px">性别：</td>
				<td colspan="6"><select id="sex" name="sex">
				<option value="0" <c:if test="${orgUsers.sex==0}">selected</c:if>>保密</option>
				<option value="1" <c:if test="${orgUsers.sex==1}">selected</c:if> >男</option>
				<option value="2" <c:if test="${orgUsers.sex==2}">selected</c:if> >女</option>
				</select></td>
			</tr>
			<tr>
				<td width="400px">生日：</td>
				<td colspan="10" >
					<input type="text" style="width:120px;" name="birthday" id="birthday" class="input2 date" value="${orgUsers.birthday}" />
				</td>
			</tr>
			<tr>
				<td width="300px">* 手机号：</td>
				<td colspan="6"><input type="text" id="mobilePhone" name="mobilePhone" value="${orgUsers.mobilePhone}"/></td>
			</tr>
			<tr>
				<td width="300px">* 邮箱：</td>
				<td colspan="6"><input type="text" id="email" name="email" value="${orgUsers.email}" /></td>
			</tr>
			<tr>
				<td width="300px">兴趣爱好：</td>
				<td colspan="6"><input type="text" id="hobbies" name ="hobbies" value="${orgUsers.hobbies}"/></td>
			</tr>
			<tr>
				<td width="300px">状态：</td>
				<td colspan="6">
					<input type="radio" class="r1" name="status" value="0" <c:if test="${orgUsers.status==0}">checked</c:if> />正常
					<input type="radio" class="r1" name="status" value="1" <c:if test="${orgUsers.status==1}">checked</c:if> />锁定
				</td>
			</tr>
			<tr>
				<td width="300px">现所在区域：</td>
				<td colspan="6">
					<select id="provinceCode_" name="provinceCode">
								<option value="-1">选择省或者市</option>
								<c:forEach items="${listProvince}" var="province">
									<option value="${province.code }"  <c:if test="${provinceCode_==province.code }">selected</c:if>>${province.name }</option>
								</c:forEach>
					</select>
					<select id="cityCode_" name="cityCode_">
						<option value="-1">请选择市</option>
								<c:forEach items="${listCity_}" var="city">
									<option value="${city.code }" <c:if test="${cityCode_==city.code }">selected</c:if>>${city.name }</option>
								</c:forEach>
					</select>
					<select id="countyCode_" name="countyCode_">
						<option value="-1">请选择区或县</option>
								<c:forEach items="${listCounty_}" var="county">
									<option value="${county.code }" <c:if test="${countyCode_==county.code }">selected</c:if>>${county.name }</option>
								</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td width="300px">详细地址：</td>
				<td colspan="6"><input type="text" id="addressdesc" name="addressdesc" value="${orgUsers.addressdesc }"/></td>
			</tr>
			<tr>
				<td width="300px">家所在区域：</td>
				<td colspan="6">
				<select id="provinceCode" name="provinceCode">
							<option value="-1">选择省或者市</option>
								<c:forEach items="${listProvince}" var="province">
									<option value="${province.code }"  <c:if test="${provinceCode==province.code }">selected</c:if>>${province.name }</option>
								</c:forEach>
						
					</select>
					<select id="cityCode" name="cityCode">
								<option value="-1">请选择市</option>
								<c:forEach items="${listCity}" var="city">
									<option value="${city.code }" <c:if test="${cityCode==city.code }">selected</c:if>>${city.name }</option>
								</c:forEach>
					</select>
					<select id="countyCode" name="countyCode">
						<option value="-1">请选择区或县</option>
								<c:forEach items="${listCounty}" var="county">
									<option value="${county.code }" <c:if test="${countyCode==county.code }">selected</c:if>>${county.name }</option>
								</c:forEach>
					</select></td>
			</tr>
		</tbody>
	</table>
	<p class="text-center"><button type="button" onclick="update();" class="btn btn-danger">保存</button></p>
	</form>
</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/user/edit.js" type="text/javascript"></script>
</body>
</html>
