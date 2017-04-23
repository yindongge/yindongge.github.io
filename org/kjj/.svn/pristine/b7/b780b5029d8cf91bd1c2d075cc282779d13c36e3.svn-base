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
<title>评价管理</title>
</head>
<body>
<div class="page-wrapper goods-control">
<div class="container-fluid">
	<ul class="breadcrumb">
		<li>您的位置</li>
		<li ><a href="#">交易</a></li>
		<li ><a href="${ctx}/comment/list">评价管理</a></li>
		<li class="active">评价详情</li>
	</ul>
	<div class="panel panel-default">
	<div class="panel-heading panel-control">
	<input type="hidden" id="goodsCommentId" value="${orgGoodsComment.id}"/>
	<p style="display:inline-block">用户 <span class="text-danger">${orgGoodsComment.userName}</span>于<fmt:formatDate value="${orgGoodsComment.createTime}" type="both"/> 对 <a class="text-info">${orgGoodsComment.goodsName} </a>发表评论</p><span>[${orgGoodsComment.starScore}星]</span>
		<button type="button" class="btn btn-default" id="btnDisplay" <c:if test="${orgGoodsComment.status=='1'}">style="display:none"</c:if>>禁止显示</button>
		<button type="button" class="btn btn-default" id="btnShow" <c:if test="${orgGoodsComment.status=='0'}">style="display:none"</c:if>>恢复显示</button>
	</div>
	<div class="panel-body">
		<textarea style="width:80%;resize: none;" rows="4" readonly="readonly">${fn:escapeXml(orgGoodsComment.goodsComment)}</textarea>	
	</div>
	</div>
	<br/>
	<c:if test="${orgGoodsComment.replyStatus=='0'}">
		<div class="panel panel-primary">
			<div class="panel-heading panel-primary">
				回复评论
			</div>
			<div class="panel-body text-right">
				<textarea style="width:80%;resize: none;" rows="4" id="reply" maxlength="500" onkeyup="checkTextAreaLength(this,500)" onblur="checkTextAreaLength(this,500)"></textarea>
				<div id="divReply">
					<button type="button" class="btn btn-danger" id="btnReply">回复</button>
					<button type="button" class="btn btn-default" id="btnCancel">重置</button>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${orgGoodsComment.replyStatus=='1'}">
		<div class="panel panel-primary">
			<div class="panel-heading panel-primary">
				<p style="display:inline-block">管理员 <span class="text-danger">${orgGoodsComment.userName}</span>于<fmt:formatDate value="${orgGoodsComment.replyTime}" type="both"/>回复评论</p>
			</div>
			<div class="panel-body text-right">
				<textarea style="width:80%;resize: none;" rows="4" readonly="readonly">${orgGoodsComment.reply}</textarea>
			</div>
		</div>
	</c:if>
	
	<div class="text-center">
		<a role="button" class="btn btn-info" href="${ctx}/comment/list">返回</a>
	</div>
	
</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/comment/detail.js" type="text/javascript"></script>
</body>
</html>
