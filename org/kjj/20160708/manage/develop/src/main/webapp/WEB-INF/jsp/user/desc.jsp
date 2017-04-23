<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<%@include file="../common/common_css.jsp" %>
<title>会员详情</title>
<script type="text/javascript">
	function doLock(userId){
		$.ajax({
			type : "POST",
			dataType : "json",
			url : "../lockAccountDeposit",
			data: {'userId':userId},
			success : function(data) {
				if (data.code == 200) {
					alert("账户锁定成功!");
				} else {
					alert("账户锁定失败!");
				}
				window.location.href="../desc/" + userId;
			},
			error : function(data) {
				alert("操作失败，请联系管理员或技术人员!");  
			}
		});
	}
	function doUnLock(userId){
		$.ajax({
			type : "POST",
			dataType : "json",
			url : "../unLockAccountDeposit",
			data: {'userId':userId},
			success : function(data) {
				if (data.code == 200) {
					alert("账户解锁成功!");
				} else {
					alert("账户解锁失败!");
				}
				window.location.href="../desc/" + userId;
			},
			error : function(data) {
				alert("操作失败，请联系管理员或技术人员!");  
			}
		});
	}
</script>
</head>
<body>	
<div class="page-wrapper goods-control">
<div class="container-fluid">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">会员</a></li>
		<li ><a href="${ctx}/user/list">会员管理</a></li>
		<li >会员详情</li>
	</ul>
	</br>

	<table class="table table-hover table-bordered strong-td ">
		<thead>
			<tr class="info">
				<th>基本信息</th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>用户名：</td>
				<td>${orgUsers.userName}</td>
				<td class="strong-b">手机：</td>
				<td>${orgUsers.mobilePhone}</td>
				<td class="strong-b" >性别</td>
				<td><c:if test="${orgUsers.sex==0}">保密</c:if><c:if test="${orgUsers.sex==1}">男</c:if><c:if test="${orgUsers.sex==2}">女</c:if></td>
			</tr>
			<tr>
				<td>真实姓名:</td>
				<td>${orgUsers.realname}</td>
				<td class="strong-b" >邮箱：</td>
				<td>${orgUsers.email}</td>
				<td class="strong-b" >注册时间：</td>
				<td><fmt:formatDate value="${orgUsers.regTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			</tr>
			<tr>
				<td>状态：</td>
				<td><c:if test="${orgUsers.status==0}">正常</c:if><c:if test="${orgUsers.status==1}">锁定</c:if></td>
				<td class="strong-b">生日：</td>
				<td>${orgUsers.birthday}</td>
				<td class="strong-b" >上次登录时间：</td>
				<td><fmt:formatDate value="${orgUsers.lastLogin}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			</tr>
			<tr>
				<td>兴趣爱好：</td>
				<td>${orgUsers.hobbies}</td>
				<td class="strong-b">会员类型：</td>
				<td>
					<c:if test="${orgUsers.levelType==1}">个人用户</c:if>
					<c:if test="${orgUsers.levelType==2}">企业用户</c:if>
					<c:if test="${orgUsers.levelType==3}">关联企业用户</c:if>
				</td>
				<td class="strong-b" >会员级别：</td>
				<td>${orgUsers.levelName}</td>
			</tr>
		</tbody>
		<!-- <thead>
			<tr class="info">
				<th >  地址信息</th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>居住地</td>
				<td colspan="5"></td>
			</tr>
			<tr>
				<td>所在区域：</td>
				<td colspan="5"></td>
			</tr>
			<tr>
				<td>详细地址：</td>
				<td colspan="5"></td>
			</tr>
			<tr>
				<td>家乡</td>
				<td colspan="5"></td>
			</tr>
				<tr>
				<td>所在区域：</td>
				<td colspan="5"></td>
			</tr>
		</tbody> -->
		<thead>
			<tr class="info">
				<th>账户信息</th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>可用可提现金额：</td>
				<td>${accountDeposit.fundAmount}</td>
				<td class="strong-b">可用不可提现金额：</td>
				<td>${accountDeposit.allowanceAmount}</td>
				<td class="strong-b" >冻结金额</td>
				<td>${accountDeposit.frozenAmount}</td>
			</tr>
			<tr>
				<td>账户状态：</td>
				<td>
					<c:if test="${accountDeposit.status==0}">
						正常 &nbsp;&nbsp;
						<button type="button" onclick="doLock('${orgUsers.userId}')" class="btn btn-danger btn-xs">锁定账户</button>
					</c:if>
					<c:if test="${accountDeposit.status==1}">
						锁定&nbsp;&nbsp;
						<button type="button" onclick="doUnLock('${orgUsers.userId}')" class="btn btn-danger btn-xs">解除锁定</button>
					</c:if>
				</td>
				<td class="strong-b"></td>
				<td></td>
				<td class="strong-b" ></td>
				<td></td>
			</tr>
		</tbody>
	</table>
	<p class="text-center"><a type="button" class="btn btn-default" href="javascript:history.go(-1)">返回</a></p>
</div>
</div>
<%@include file="../common/common_js.jsp" %>

</body>
</html>
