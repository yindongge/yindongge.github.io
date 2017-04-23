<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../common/common_java.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<meta name="apple-touch-fullscreen" content="yes" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />
<%@ include file="../common/common_css.jsp"%>
<link href="${cssBase}/jquery.raty.css" type="text/css" rel="stylesheet" />
<link href="${cssBase}/labs.css" type="text/css" rel="stylesheet" />
<title>${orgProductItem.goodsName}-快捷健商城</title>
</head>
<body>
	<div class="box box-gray">
		<header class="header">
			<div class="head-content">商品介绍</div>
			<div class="head-left"><a href="javascript:history.go(-1)" class="link"></a></div>
		</header>
		<!-- end top -->
		<div class="goodsintroduce">
			<div class="area third">
				<a href="${ctx}/item/introduce/${query.goodsId}" class='a'>商品详情<span class="linebottom"></span></a>
				<a href="${ctx}/item/comment/${query.goodsId}" class='a'>商品评价<span class="linebottom"></span></a>
				<a href="javascript:void(0);" class='a on'>商品咨询<span class="linebottom"></span></a>
			</div>
			<c:if test="${orgConsultProblemList!=null && orgConsultProblemList.size()!=0}">
				<div class="assess zixun">
					<h5>有<span class="red">${orgConsultProblemList.size()}</span>条咨询</h5>
					<c:forEach var="problem" items="${orgConsultProblemList}">
						<c:if test="${problem!=null}">
							<div class="assess-list">
								<dl class="item-detail no-border">
									<dt>咨询内容：</dt><dd>${problem.consultProblem}</dd>
									<c:forEach var="answer" items="${problem.listOrgConsultAnswer}">
										<c:if test="${answer!=null}">
											<dt class="bluedt">阿健回复：</dt><dd>${answer.consultAnswer}</dd>
										</c:if>
									</c:forEach>
								</dl>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</c:if>
			<c:if test="${orgConsultProblemList==null || orgConsultProblemList.size()==0}">
				<div class="nolist">暂无商品咨询信息</div>
			</c:if>
		</div>
	</div>
	<footer class="footer">
		<p>客户服务热线：4000-306-603</p>
		<p>KJJHOME.COM 快捷健商城</p>
	</footer>
	<!-- end box -->
	
<%@ include file="../common/common_js.jsp"%>
</body>
</html>