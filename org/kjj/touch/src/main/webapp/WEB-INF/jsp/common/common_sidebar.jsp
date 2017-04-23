<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
	String active = request.getParameter("active");
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
 %>
<div class="sidebar">
	<a <%if("精品购物".equals(active)){%>class='on' style='background: #FA436A'<%}%> href="javascript:void(0)">
		<div class="s-img s1">
		</div>
		<span class="s-title">精品购物</span>
	</a>
	
	<a <%if("防伪溯源".equals(active)){%>class='on' style='background: #21D59B'<%}%> href="javascript:void(0)">
		<div class="s-img s2">
		</div>
		<span class="s-title">防伪溯源</span>
	</a>
	
	<a <%if("会员服务".equals(active)){%>class='on' style='background: #FFB441'<%}%> href="javascript:void(0)">
		<div class="s-img s3">
		</div>
		<span class="s-title">会员服务</span>
	</a>
	
	<a <%if("优惠活动".equals(active)){%>class='on' style='background: #FF5E29'<%}%> href="javascript:void(0)">
		<div class="s-img s4">
		</div>
		<span class="s-title">优惠活动</span>
	</a>
	
	<a <%if("关于我们".equals(active)){%>class='on' style='background: #30C7FF'<%}%> href="javascript:void(0)">
		<div class="s-img s5">
		</div>
		<span class="s-title">关于我们</span>
	</a>
</div>
<script type="text/javascript">
$('.sidebar').find('a').eq(4).on('click',function(){
	$.ajax({  
        type: "post",  
        dataType: "json",
        url: "../aboutUs/item",
        success: function(data) {
	        if(data.oacId!=null){
				location.href="/aboutUs/desc?id="+data.oacId;
	        }else{
	        	alert('链接不正确');
	        }
        },  
        error: function(data) {  
       	 alert('err');
        }  
    }); 


});

$('.sidebar').find('a').eq(0).on('click',function(){
	location.href='<%=basePath%>/search/result?catId=31';
});
$('.sidebar').find('a').eq(3).on('click',function(){
	location.href='<%=basePath%>/dial/draw';
});
</script>
