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
<div class="all">
	<%@include file="../common/common_head2.jsp" %>
	<!-- end top -->
	<div class="header">
		<div class="container">
			<div class="logo fl">
				<a href="${ctx}"><img src="${imgBase}/logo.jpg"/></a>
			</div>
		</div>
	</div>

	<!-- end header -->
	<form id="form" >
	<div class="future">
		<div class="container">
			<div class="feed-floor">
				<p>尊敬的用户：</p>
				<p>您好！为了给您提供更好的服务，我们希望收集您使用<a href="${ctx}" class="red">快捷健首页</a>时的看法或建议。对您的配合和支持表示衷心感谢！</p>
			</div>
			<div class="feed-panel">
				<h5 class="feed-p-title">如果您在使用<a href="${ctx}" class="red">快捷健首页</a>时，有什么好或不好的地方，请大声说出来！我们会关注您的反馈，不断优化产品，为您提供更好的服务！</h5>
				<div class="feed-p-content">
					<textarea rows="10" name="feedback" id="feedback" maxlength="500" onkeyup="checkTextAreaLength(this,500)" onblur="checkTextAreaLength(this,500)"></textarea>
				</div>
			</div>
			<div class="feed-panel" id="firstAnchor">

				<h5 class="feed-p-title"><span class="red">*</span>您对<a href="${ctx}" class="red">快捷健首页</a>的整体满意度如何？</h5>
				<div class="feed-p-content radiop">
				<p class="red" id="valmessage1" style="display:none;"><strong>本题必答. 请完成所有部分.</strong></p>
					<p><input type="radio" name="problem1" value="1"/>非常满意</p>
					<p><input type="radio" name="problem1" value="2"/>满意</p>
					<p><input type="radio" name="problem1" value="3"/>一般</p>
					<p><input type="radio" name="problem1" value="4"/>不满意</p>
					<p><input type="radio" name="problem1" value="5"/>非常不满意</p>
				</div>
			</div>
			<div class="feed-panel">
				<h5 class="feed-p-title"  id="secondAnchor"><span class="red">*</span>请您根据自己使用<a href="${ctx}" class="red">快捷健首页</a>的情况，评价下列描述</h5>
				<div class="feed-p-content">
					<p class="red" id="valmessage" style="display:none;"><strong>本题必答. 请完成所有部分.</strong></p>
					<table class="table table-bordered table-hover table-striped">
						<thead>
							<tr>
								<th style="width:300px"></th>
								<th>非常同意</th>
								<th>同意</th>
								<th>一般</th>
								<th>反对</th>
								<th>强烈反对</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>我觉得首页打开速度快</td>
								<td><input type="radio" name="problem2" value="1"/></td>
								<td><input type="radio" name="problem2" value="2"/></td>
								<td><input type="radio" name="problem2" value="3"/></td>
								<td><input type="radio" name="problem2" value="4"/></td>
								<td><input type="radio" name="problem2" value="5"/></td>
							</tr>
							<tr>
								<td>总体来说，首页的推荐对我有吸引力</td>
								<td><input type="radio" name="problem3" value="1"/></td>
								<td><input type="radio" name="problem3" value="2"/></td>
								<td><input type="radio" name="problem3" value="3"/></td>
								<td><input type="radio" name="problem3" value="4"/></td>
								<td><input type="radio" name="problem3" value="5"/></td>
							</tr>
								<tr>
								<td>浏览首页时，我觉得首页内容清晰</td>
								<td><input type="radio" name="problem4" value="1"/></td>
								<td><input type="radio" name="problem4" value="2"/></td>
								<td><input type="radio" name="problem4" value="3"/></td>
								<td><input type="radio" name="problem4" value="4"/></td>
								<td><input type="radio" name="problem4" value="5"/></td>
							</tr>
							<tr>
								<td>在首页上我可以方便地找到所需的信息</td>
								<td><input type="radio" name="problem5" value="1"/></td>
								<td><input type="radio" name="problem5" value="2"/></td>
								<td><input type="radio" name="problem5" value="3"/></td>
								<td><input type="radio" name="problem5" value="4"/></td>
								<td><input type="radio" name="problem5" value="5"/></td>
							</tr>
								<tr>
								<td>整体来看，我喜欢首页现在的外观样式</td>
								<td><input type="radio" name="problem6" value="1"/></td>
								<td><input type="radio" name="problem6" value="2"/></td>
								<td><input type="radio" name="problem6" value="3"/></td>
								<td><input type="radio" name="problem6" value="4"/></td>
								<td><input type="radio" name="problem6" value="5"/></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="feed-panel" style="margin-top:30px;">
				<h5 class="feed-p-title special"><span>我们会不定期电访用户。如果您有意参与，请填写如下信息，方便我们与您联系，谢谢！（信息仅作为内部资料绝不外泄）</span>
   				<span>如果您对快捷健的使用体验有任何想法，也欢迎加入我们的快捷健体验交流QQ群（431997966），输入验证码 kjj 即可成为群内一员！我们也会在群内发布访谈邀请的信息哦！</span></h5>
				<div class="feed-p-content">
					<p class="red" id="phoneNumMessage" style="display:none;"><strong>请正确填写姓名和手机号</strong></p>
					<dl>
						<dt>姓名</dt>
						<dd><input type="text" name="name"/></dd>
					</dl>
					<dl>
						<dt>手机号</dt>
						<dd><input type="text" name="phoneNum"/></dd>
					</dl>
				</div>
			</div>
			<div class="feed-panel" >
				<p>
					<a href="javascript:void(0);" class="feed-p-a" onclick="submit();">提交</a>
				</p>
			</div>
		</div>
	</div>
	</form>
<%@include file="../common/common_foot.jsp" %>
</div>
<div class="kjj" style="display:none;" id="tooltip">
	<div class="title">用户反馈</div>
	<p >提交成功，感谢您的参与</p>
	<p><a href="${ctx}" class="closekjj">确认</a></p>
</div>
<%@include file="../common/common_js.jsp"%>
<script src="${jsBase}/feedback/feedback.js" type="text/javascript"></script>
</body>
</html>