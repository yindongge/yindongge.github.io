<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<div class="top">
	<nav class="navbar navbar-default">
		<div class="container container-width">
			<ul class="nav navbar-nav fl">
				<li class="showmenu">
					<a href="javascript:void(0);" class="yellow"><i class="glyphicon point"></i> 北京 </a>
					<div class="hidemenu" style="display: none;">
						<p>请选择收货区域</p>
						<p><a href="javascript:void(0);">北京</a></p>
					</div>
				</li>
            	<c:if test="${kjjuser.login}">
				<li><a href="${ctx}/security/desc">${kjjuser.orgUsers.userName}，欢迎来到快捷健</a></li>
				<li><a href="${ctx}/logout">退出</a></li>
				</c:if>
				<c:if test="${!kjjuser.login}">
				<li><a href="javascript:void(0);">您好，欢迎来到快捷健</a></li>
				<li><a href="${ctx}/loginInit">[登录]</a></li>
            	<li><a href="${ctx}/register/init">[免费成为会员]</a></li>
				</c:if>
			</ul>
			<ul class="nav navbar-nav fr">	
				<li class="backindex"><a href="${ctx}">快捷健首页</a></li>				
				<li class="showmenu special2">
					<a href="${ctx}/order/list"> 我的快捷健  <i class="glyphicon glyphicon-menu-down"></i></a>
					<ul class="hidemenu" style="display: none;">
						<li><a href="${ctx}/order/list">我的订单</a></li>							
						<li><a href="${ctx}/consultation/personalList">留言咨询</a></li>							
						<li><a href="${ctx}/security/desc">账户安全</a></li>						
					</ul>
				</li>
				
				
				<li class="showmenu special3">
					<a href="javascript:void(0);"> 关注快捷健 <i class="glyphicon glyphicon-menu-down"></i></a>
					<div class="hidemenu" style="display: none;">
						<img src="${imgBase}/erweima.jpg" class="erweima" />
						<p class="guanzhu">关注快捷健微店</p>
					</div>
				</li>		
				<li class="showmenu special2">
					<a href="javascript:void(0);"> 客户服务  <i class="glyphicon glyphicon-menu-down"></i></a>
					<ul class="hidemenu" style="display: none;">
						<li><a href="${ctx}/usualProblem/list">常见问题</a></li>
						<li><a href="${ctx}/article/dispatcher/13">售后服务</a></li>
					</ul>
				</li>
				<li><a href="${ctx}/industryInfo/list">资讯订阅</a></li>
			</ul>
		</div>
	</nav>
</div>
