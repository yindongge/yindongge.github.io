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
			<span>回复状态：<i class="badge1" >${orgConsultProblem.consultStateName}</i></span>
			
		</p>
	</div>
	<div class="askanswer">
		<ul class="list-group">
		  <li class="list-group-item list-group-item-default">
		  	 <h4 class="list-group-item-heading">咨询内容：</h4>
		  	 <p class="list-group-item-text">${orgConsultProblem.consultProblem }</p>
		  </li>
		  <c:if test="${fn:length(orgConsultAnswer)>0}">
			  <li class="list-group-item list-group-item-info">
			  	 <h4 class="list-group-item-heading">客服回复:</h4>
			  	 <p class="list-group-item-text">
			  	 	${orgConsultAnswer[0].consultAnswer }
			  	 </p>
			  	 <p class="text-right text12">【客服：${orgConsultAnswer[0].orgAdminUser.userName }　<fmt:formatDate value="${orgConsultAnswer[0].createTime }"  pattern="yyyy-MM-dd hh:mm:ss"/>】</p>	
			  </li>
		  </c:if>

		  
		</ul>
		<c:if test="${fn:length(orgConsultAnswer)==0}">
			<textarea class="textarea12" rows="10" id="replyTextarea"></textarea>
			<p class="text-center">			
				<button class="btn btn-danger" onclick="reply();">回复</button>
				<button class="btn btn-danger" onclick="back();">返回</button>
			</p>
		</c:if>
		<c:if test="${fn:length(orgConsultAnswer)>0}">
			<p class="text-center">			
				<button class="btn btn-danger" onclick="back();">返回</button>
			</p>
		</c:if>

	</div>
</div>

</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/consutation/productConsultationReplyView.js" type="text/javascript"></script>
</body>
</html>