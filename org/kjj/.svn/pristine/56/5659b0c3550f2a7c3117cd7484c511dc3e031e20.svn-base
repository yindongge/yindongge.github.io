<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="../common/common_meta.jsp" %>
<%@include file="../common/common_css.jsp" %>
<title>转盘抽奖-快捷键商城</title>


</head>
<body>
<div class=" box">
	<div class="box-content">
		<%@include file="../common/common_head.jsp" %>
	</div>
	<div class="future">
		<div class="future-left fl">
			<jsp:include page="../common/common_sidebar.jsp">
				<jsp:param name="active" value="优惠活动"/>
			</jsp:include>
		</div>
		<div class="future-right  fr">
			<div class="rotateall text-center fl">
						<div class="choujiang_text">
							<h5>活动描述</h5>
							<div class="p_text">
								<p>本次“幸福到家”活动，共分为五大板块：</p>
								<p>1.幸福向前冲：参与游戏，感受幸福人生，获得幸福指数，赢取超值大奖</p>
								<p>2.幸福大挑战：参与风险测试，了解自身风险类型，根据结论确定调整您的投资理念和方式</p>
								<p>3.幸福接力赛：活动期间，发送五个以上有效链接，即有机会得到幸运奖品！</p>
								<p>4.幸福摩天轮：积累幸福指数，参与抽奖，每抽一次奖需要幸福指数15积分，每个用户每天有四次抽奖的机会。</p>
							</div>
						</div>
						<img src="${imgBase}/1.png" id="shan-img" style="display:none;" />
					    <img src="${imgBase}/2.png" id="sorry-img" style="display:none;" />
						<div class="banner">
							<div class="turnplate" >
								<canvas class="item" id="wheelcanvas" width="422px" height="422px"></canvas>
							</div>
							<div class="po_outimg"></div>
							<div class="click_img">
								<img class="pointer" src="${imgBase}/pointer.png"/>
							</div>
						</div>
				</div>

		</div>
	</div>
</div>		

<%@include file="../common/common_js.jsp"%>
<script type="text/javascript" src="${jsBase}/activity/awardRotate.js"></script>
<script type="text/javascript">
	var orgActivityJson=${orgActivityJson};
</script>
<script type="text/javascript" src="${jsBase}/activity/dial.js"></script>
</body>
</html>
