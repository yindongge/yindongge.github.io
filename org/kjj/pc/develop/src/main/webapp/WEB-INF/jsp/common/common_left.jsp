<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
	String active = request.getParameter("active");
%>
<div class="member-left fl">
<div class="d-group">
	<dl class="d1">
		<dt>订单中心</dt>
		<dd <%if("我的订单".equals(active)){%>class='active'<%}%>><a href="<%=basePath %>/order/list">我的订单</a></dd>
		<dd <%if("我的评价".equals(active)){%>class='active'<%}%>><a href="<%=basePath %>/comment/list">我的评价</a></dd>
	</dl>
	<dl class="d1">
		<dt>我的资产</dt>
		<dd <%if("预存款".equals(active)){%>class='active'<%}%>><a href="<%=basePath %>/accountDeposit/list">预存款</a></dd>
		<dd <%if("优惠券".equals(active)){%>class='active'<%}%>><a href="<%=basePath %>/coupon/list">优惠券</a></dd>
	</dl>
	<%-- 
	<dl class="d2">
		<dt>我的收藏</dt>
		<dd>收藏的商品</dd>
	</dl>
	 --%>
	<dl class="d3">
		<dt>客户服务</dt>
		<dd <%if("退货记录".equals(active)){%>class='active'<%}%>><a href="<%=basePath %>/return/list">退货记录</a></dd>
		<dd <%if("留言咨询".equals(active)){%>class='active'<%}%>><a href="<%=basePath %>/consultation/personalList">留言咨询</a></dd>
	</dl>
	<dl class="d4">
		<dt>设置</dt>
		<dd <%if("个人信息".equals(active)){%>class='active'<%}%>><a href="<%=basePath %>/user/desc">个人信息</a></dd>
		<dd <%if("收货地址".equals(active)){%>class='active'<%}%>><a href="<%=basePath %>/address/list">收货地址</a></dd>
		<dd <%if("账户安全".equals(active)){%>class='active'<%}%>><a href="<%=basePath %>/security/desc">账户安全</a></dd>
	</dl>
</div>
</div>