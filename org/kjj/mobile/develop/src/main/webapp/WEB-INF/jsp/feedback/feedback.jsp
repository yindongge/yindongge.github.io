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

<title>问题反馈-快捷健商城</title>
</head>
<body>
		<div class="box box-gray">
			<header class="header">
				<div class="head-content">问题反馈</div>
				<div class="head-left"><a href="${ctx}/user/center" class="link"></a></div>
			</header>
			<div class="feed_kjj">
				<textarea id="feedback" placeholder="请填写使用产品时遇到的问题，我们会不断努力提升产品体验~" class="textarea_input" ></textarea>
				<input type="text" id="phoneNum" placeholder="请留下您的联系方式（可选填）" class="phone_text">
			</div>
			<div class="acount-button">
				<a href="javascript:void(0);" onclick="submit()">提交</a>
			</div>
		</div>
<%@ include file="../common/common_js.jsp"%>
<script type="text/javascript">
	function submit(){
		var feedback = $('#feedback').val();
		if(feedback.trim()==""){
			autoAlert("请输入反馈内容");
			return false;
		}
		var phoneNum = $('#phoneNum').val();
		$.ajax({
			url:'save',
			dataType : 'json',
			data:{"feedback":feedback,"phoneNum":phoneNum},
			type:'post',
			success:function(data){
				if(data==200){
					autoAlert("反馈成功");
					setTimeout("location.href='../user/center'",2000);
				}
			}
		});
	}
</script>
</body>
</html>