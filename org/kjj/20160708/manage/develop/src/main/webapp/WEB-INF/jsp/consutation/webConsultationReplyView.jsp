<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
<%@include file="../common/common_css.jsp" %>
<title>留言详情</title>
</head>
<body>	
<div class="page-wrapper goods-control">
<div class="container-fluid">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">客服</a></li>
		<li ><a href="#">咨询留言管理</a></li>
		<li class="active"><a href="#">留言详情</a></li>
	</ul>
	<div class="well well-control">
		<p  class="bg-warning">
			<input type="hidden" id="consultProblemId" value="${orgConsultProblem.consultProblemId }"/>
			<span>服务编号：${orgConsultProblem.consultProblemId }</span>
			<span>会员名：<i class="badge1" >${orgConsultProblem.userName }</i></span>
			<span>咨询类型：<i class="badge1" >${orgConsultProblem.consultTypeName}</i></span>
			<span>咨询时间：<i class="badge1" ><fmt:formatDate value="${orgConsultProblem.createTime}"  pattern="yyyy-MM-dd hh:mm:ss"/></i></span>
			<span>状态：<i class="badge1" >${orgConsultProblem.consultStateName}</i></span>
			
		</p>
	</div>
	<div class="askanswer">
		<ul class="list-group">
		  <li class="list-group-item list-group-item-default">
		  	 <h4 class="list-group-item-heading">咨询内容：</h4>
		  	 <p class="list-group-item-text">${orgConsultProblem.consultProblem }</p>
		  </li>
		  <c:forEach items="${consultAnswerList }" var="item">
		  		<c:if test="${item.createUserType == 1 }">
			  		<li class="list-group-item list-group-item-info">			  		
					  	 <h4 class="list-group-item-heading">客服回复:</h4>
					  	 <p class="list-group-item-text">
					  	 	${item.consultAnswer }
					  	 </p>
					  	 <p class="text-right text12">【客服：${item.orgAdminUser.userName }　<fmt:formatDate value="${item.createTime }"  pattern="yyyy-MM-dd HH:mm:ss"/>】</p>	
					  </li>
		  		</c:if>
				<c:if test="${item.createUserType == 0 }">
					 <li class="list-group-item list-group-item-default">
					  	 <h4 class="list-group-item-heading">咨询内容：</h4>
					  	 <p class="list-group-item-text">${item.consultAnswer }</p>
					  	  <p class="text-right text13">【用户：${orgConsultProblem.userName }　<fmt:formatDate value="${item.createTime }"  pattern="yyyy-MM-dd HH:mm:ss"/>】</p>
					  </li>
				</c:if>
		  </c:forEach>
		</ul>
		<c:if test="${orgConsultProblem.solveState != 5 }">
			<textarea class="textarea12" rows="10" id="replyTextarea"></textarea>
		</c:if>
		<p class="text-center">
			<c:if test="${orgConsultProblem.solveState != 5 }">
				<select id="solveState">
					<option value="3">选择处理状态</option>					
					<c:choose>
						<c:when test="${orgConsultProblem.solveState == 4 }">
							<option value="4" selected="selected">处理中</option>
						</c:when>
						<c:otherwise>
							<option value="4">处理中</option>
						</c:otherwise>
					</c:choose>
					<option value="5">完毕</option>
				</select>
			<button class="btn btn-danger" onclick="reply();">确定</button>
			</c:if>
			<button class="btn btn-danger" onclick="back();">返回</button>
		</p>


	</div>
</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/consutation/webConsultationReplyView.js"type="text/javascript"></script>
</body>
</html>