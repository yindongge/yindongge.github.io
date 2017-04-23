<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<%@include file="../common/common_css.jsp" %>
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
			<div class="search fr">
					<%@include file="../common/common_search.jsp" %>		
			</div>
			</div>
		</div>
	</div>
	<!-- end header -->
	
	<div class="center-content">
		<div class="container container-width">
			<jsp:include page="../common/common_left.jsp">
				<jsp:param name="active" value="留言咨询"/>
			</jsp:include>
			<!-- member-left -->
			<div class="member-right">
				<div class="mlist information ">
					<h5 >咨询回复</h5>
					<div class="bottomcontent control">
						<p class="padding-right"><span class="black">我的咨询：</span>${orgConsultProblem.consultProblem }&nbsp;
							<span class="pull-right"><fmt:formatDate value="${orgConsultProblem.createTime}"  pattern="yyyy-MM-dd HH:mm:ss"/></span>            
						</p>
						<c:forEach items="${orgConsultProblem.listOrgConsultAnswer }" var="item" varStatus="state">
						<%-- 
							<p class="feeda padding-right">
								<span class="blue">快捷健回复:</span>
								${item.consultAnswer }
								<span class="pull-right"><fmt:formatDate value="${item.createTime}"  pattern="yyyy-MM-dd HH:mm:ss"/></span>
							</p>
						 --%>		
								
							<c:if test="${item.createUserType == 0 }">
								<p class="padding-right"><span class="black">我的咨询：</span>${item.consultAnswer }&nbsp;
									<span class="pull-right"><fmt:formatDate value="${item.createTime}"  pattern="yyyy-MM-dd HH:mm:ss"/></span>    
								</p>
									      
							</c:if>
							<c:if test="${item.createUserType == 1 }">
								<p class="feeda padding-right"> <span class="blue">快捷健回复:</span> ${item.consultAnswer}
									<c:if test="${orgConsultProblem.solveState != 5 && orgConsultProblem.replyState==2}"><a href="javascript:void(0);" name="reply">【回复】</a></c:if>
									<input  type="hidden" value="${item.fromUser}"/>									
									<span class="pull-right"><fmt:formatDate value="${item.createTime}"  pattern="yyyy-MM-dd HH:mm:ss"/></span>
								</p>
							</c:if>
								
						</c:forEach>
					</div>
				</div>
			</div>
			<!-- end memberright -->
				
		</div>
	</div>
	
<!--  -->
<%@include file="../common/common_foot.jsp" %>
<!-- show -->
<form action="${ctx}/order/cancel" method="post">
<div class="togglemoadl togglemodal2" style="display:none;">
	<input type="hidden" id="cancel_order_id" name="order_id"/>
	<h5>取消订单<button type="button" class="close" name="buttonClose">x</button></h5>
	<div class="tolggle-content">
		<div class="toggleall">	
			<p class="warning">您确定要取消该订单吗？取消订单后，不能恢复！</p>
		</div>
		<div class="toggleall">	
			<div class="select">
				<span>请选择取消订单的理由：</span>
				<select name="log_detail">
					<option value="我不想买了">我不想买了</option>
					<option value="信息填写错误，重新拍">信息填写错误，重新拍</option>
					<option value="店铺缺货">店铺缺货</option>
					<option value="见面交易">见面交易</option>
					<option value="付款遇到问题（如余额不足、不知道怎么付款等）">付款遇到问题（如余额不足、不知道怎么付款等）</option>
					<option value="拍错了">拍错了</option>
					<option value="其他原因">其他原因</option>
				</select>
			</div>
		</div>
		<p class="text-center"><button type="button" name="buttonClose" class=" a-same a14" name="buttonClose">取消</button><button type="submit" id="confirmCancel" class="a-same a13">确定</button></p>
	</div>
</div>
</form>
<div class="toggle-mask" style="display:none;"></div>
</div>

<form id="replyForm" action="${ctx }/consultation/personalReply">
	<input type="hidden" name="consultProblemId" value="${orgConsultProblem.consultProblemId }"/>
	<input type="hidden" name="toUser" />
	<div id="replyDiv" class="kjj width" style="display:none;">
		<div class="title">回复<span class="close pull-right" onclick="$('#replyDiv').hide();">X</span></div>
		<p><textarea rows="7" name="consultAnswer"></textarea></p>
		<p><button type="submit" class="closekjj" >回复</button></p>
	</div>
</form>
<%@include file="../common/common_js.jsp"%>
<script type="text/javascript" src="${jsBase}/consult/personalConsult.js"></script>
</body>
</html>