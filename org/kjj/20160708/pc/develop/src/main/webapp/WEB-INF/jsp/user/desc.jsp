<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<%@include file="../common/common_css.jsp" %>
<link href="${cssBase}/jquery.datetimepicker.css" rel="stylesheet" type="text/css" />
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
				<jsp:param name="active" value="个人信息"/>
			</jsp:include>
			<!-- member-left -->
			<div class="member-right">
			<form id ="form" name="form">
				<input type="hidden" id="hobbies" name="hobbies" value="${kjjuser.orgUsers.hobbies}"></input>
				<input type="hidden" id="userId" name="userId" value="${kjjuser.orgUsers.userId}"></input>
				<div class="mlist ">
					<h5 style="margin-bottom:15px;">基本信息</h5>
					<div class="info-list">
						<div class="r-left">用户名：</div>
						<div class="r-right"><input type="text" id="userName" value="${kjjuser.orgUsers.userName}" name="userName" class="input2"/>
							<p class="red" style="display:none" id="userValidate"></p>
						</div>
					</div>
					<div class="info-list">
						<div class="r-left">性别：</div>
						<div class="r-right">
							<input type="radio" name="sex" value="1" <c:if test="${kjjuser.orgUsers.sex==1}">checked</c:if> class="raido-r"/><label for="radio-r">男</label>
							<input type="radio" name="sex"  value="2"<c:if test="${kjjuser.orgUsers.sex==2}">checked</c:if> class="raido-r"/><label for="radio-r">女</label>
							<input type="radio" name="sex"  value="0"<c:if test="${kjjuser.orgUsers.sex==0}">checked</c:if> class="raido-r"/><label for="radio-r">保密</label>
						</div>
					</div>

					<div class="info-list">
						<div class="r-left">生日：</div>
						<div class="r-right"><input type="text" id="birthday" value="${kjjuser.orgUsers.birthday}" name="birthday" class="input2"/></div>
					</div>
					<div class="info-list">
						<div class="r-left">所在地：</div>
						<div class="r-right">
							<select id="now" name="now" onchange="changearea('now')">
								<option value="-1">省份</option>
								<c:forEach items="${province}" var="i" varStatus="status">
									<option <c:if test="${fn:startsWith(kjjuser.orgUsers.addressnow, fn:substring(i.code, 0, 2))}">selected</c:if> value="${i.code}">${i.name}</option>
								</c:forEach>
							</select>
							<select id="now1" name ="now1" onchange="changearea('now1')">
								<option value="-1">城市</option>
								<c:forEach items="${cityNow}" var="i" varStatus="status">
									<option <c:if test="${fn:substring(i.code, 0, 4) eq fn:substring(kjjuser.orgUsers.addressnow, 0, 4)}">selected</c:if> value="${i.code}">${i.name}</option>
								</c:forEach>
							</select>
							<select id="now11" name="now11">
								<option value="-1">区县</option>
								<c:forEach items="${areaNow}" var="i" varStatus="status">
									<option <c:if test="${i.code eq kjjuser.orgUsers.addressnow}">selected</c:if> value="${i.code}">${i.name}</option>
								</c:forEach>
							</select>
							<p class="p2"><input type="text" id="addressdesc" name="addressdesc" value="${kjjuser.orgUsers.addressdesc}" placeholder="继续补充，如街道、楼层等信息"/></p>
							<p class="red" style="display:none" id="addressValidate"></p>
						</div>
					</div>
					<div class="info-list">
						<div class="r-left">家乡：</div>
						<div class="r-right">
							<select id="hom" name="hom" onchange="changearea('hom')">
								<option value="-1">省份</option>
								<c:forEach items="${province}" var="i" varStatus="status">
										<option <c:if test="${fn:startsWith(kjjuser.orgUsers.addresshome, fn:substring(i.code, 0, 2))}">selected</c:if> value="${i.code}">${i.name}</option>
								</c:forEach>
							</select>
							<select id="hom1" name ="hom1" onchange="changearea('hom1')">
								<option value="-1">城市</option>
								<c:forEach items="${cityHome}" var="i" varStatus="status">
									<option <c:if test="${fn:substring(i.code, 0, 4) eq fn:substring(kjjuser.orgUsers.addresshome, 0, 4)}">selected</c:if> value="${i.code}">${i.name}</option>
								</c:forEach>
							</select>
							<select id="hom11" name="hom11">
								<option value="-1">区县</option>
								<c:forEach items="${areaHome}" var="i" varStatus="status">
									<option <c:if test="${i.code eq kjjuser.orgUsers.addresshome}">selected</c:if> value="${i.code}">${i.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="info-list">
						<div class="r-left">兴趣爱好：</div>
						<div class="r-right">
							<p class="colorccc">请选择您感兴趣的分类，给您最精准的推荐</p>
							<div class="fenlei">
								<c:if test="${!empty kjjuser.orgUsers.hobbies}">
									
									<c:forEach items="${classType}" var="i"  step="1" varStatus="status"> 
									   <c:set var="var2" value="0" scope="request" />
							    	   <c:forTokens items="${kjjuser.orgUsers.hobbies}" delims="," var="h" varStatus="s"> 
									  		<c:if test="${i.classId eq h }">
									  		<c:set var="var2" value="1" scope="request" />
									  		<a id="c_${status.index}" class="active" href="javascript:sethobbies('c_${status.index}');" value="${i.classId}">${i.className}</a>
									  		</c:if>
									  
									  		<c:if test="${s.last && i.classId ne h&&var2 eq 0}">
									  			<a id="c_${status.index}"  href="javascript:sethobbies('c_${status.index}');" value="${i.classId}">${i.className}</a>
									  		</c:if>
									   </c:forTokens>
								    </c:forEach>
								</c:if>
								
								<c:if test="${empty kjjuser.orgUsers.hobbies}">
									<c:forEach items="${classType}" var="i"  step="1" varStatus="status"> 
								    	<a id="c_${status.index}" href="javascript:sethobbies('c_${status.index}');" value="${i.classId}">${i.className}</a>
								    </c:forEach>
								</c:if>
							</div>
						</div>
					</div>
					<div class="info-list">
						<div class="r-left"></div>
						<div class="r-right"><a id="edit" href="javascript:void(0);" class="btn btn-warning">提交</a></div>
					</div>
			</div>
			</form>
			</div>
			<!-- end memberright -->
		</div>
	</div>
</div>
<div class="kjj" style="display:none">
	<div class="title">标题</div>
	<p >操作成功！</p>
	<p><a href="javascript:closeBox()" class="closekjj">关闭</a></p>
</div>
<%@include file="../common/common_foot.jsp" %>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/common/jquery.datetimepicker.js" type="text/javascript"></script>
<script src="${jsBase}/common/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
<script src="${jsBase}/user/desc.js" type="text/javascript"></script>
</body>
</html>