<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="sidebar">
	<a class="go-top"></a>
	<a class="sidebar-car" href="${ctx }/cart/list">
		<em><c:if test="${kjjcartcount==null}">0</c:if><c:if test="${kjjcartcount!=null}">${kjjcartcount}</c:if></em>
	</a>
	<a href="${ctx}/feedback/init"class="sidebar-feedback"></a>
	<a class="sidebar-erweima">
		<div class="showerweima"></div>
	</a>
</div>
<script type="text/javascript">
$(function(){
		$(window).scroll(function(){
		if($(window).scrollTop()>800){
			$(" .go-top").fadeIn();	
		}
		else{
			$(".go-top").hide();
		}
	});

	$(".go-top").click(function(){
		$('html,body').animate({'scrollTop':0},900);
	});
});
</script>