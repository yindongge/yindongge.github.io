<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
	String active = request.getParameter("active");
	String cartCount = request.getParameter("cartCount");
	if(cartCount == null || cartCount.equals("")){
		cartCount = "0";
	}
%>
<div class="footerbar precent20">
	<a <%if("首页".equals(active)){%>class='on'<%}%> href="<%=basePath %>">
		<div class="iconfoot foot1 "></div>
		<div class="iconfoottext">首页</div>
	</a>
	<a <%if("快捷购".equals(active)){%>class='on'<%}%> href="<%=basePath %>/fastBuy/list">
		<div class="iconfoot foot2"></div>
		<div class="iconfoottext">快捷购</div>
	</a> 
	<a <%if("购物车".equals(active)){%>class='on'<%}%> href="<%=basePath %>/cart/list">
		<div class="iconfoot foot3"><span  class="redcount"><%=cartCount %></span></div>
		<div class="iconfoottext">购物车</div>
	</a>
	<a <%if("分类".equals(active)){%>class='on'<%}%> href="<%=basePath %>/classfiy/list">
		<div class="iconfoot foot4"></div>
		<div class="iconfoottext">类目</div>
	</a>
	<a <%if("我的".equals(active)){%>class='on'<%}%> href="<%=basePath %>/user/center">
		<div class="iconfoot foot5"></div>
		<div class="iconfoottext">我的</div>
	</a>
</div>