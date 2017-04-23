<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8" import="java.util.Date"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<%@include file="../common/common_css.jsp" %>
<link href="${cssBase}/pick-a-color-1.2.2.min.css" type="text/css" rel="stylesheet"/>
<title>新增</title>
</head>
<body>
<form class="form-horizontal  media-control" action="${ctx}/special/save" method="post">	
	<div class="page-wrapper ">
		<div class="container-fluid">
			<div class="page-wrapper">
				<div class="container-fluid">
					<ul class="breadcrumb">
						<li>您的位置</li>
						<li class="active">专题活动</li>
						<li class="active">新增</li>
					</ul>
					<!-- 切换 -->
					<div class="btn-group btn-group-justified" role="group" aria-label="Justified button group" >
					   <a href="javascript:void(0)"  class="btn btn-primary " role="button">基本信息</a>
					   <a href="javascript:void(0)"  class="btn btn-info disabled" role="button">自定义HTML</a>
					   <a href="javascript:void(0)"  class="btn btn-info disabled" role="button">活动专题图</a>
					   <a href="javascript:void(0)"  class="btn btn-info disabled" role="button">分组商品</a>
					   <a href="javascript:void(0)"  class="btn btn-info disabled" role="button">锚点链接</a>
				    </div>
					<!-- 切换 -->
					<div class="table-wrapper">
						<div class="horizontal_wrapper">
							<div class="form-group">
								<label class="col-sm-2 control-label"><span class="red">*</span>专题名称：</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" name="specialName" maxlength="100" required/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" ><span class="red">*</span>适用终端：</label>	
								<div class="col-sm-4">
									<p>
										<label class="checkbox-inline">
											<input type="radio" name="scope" value="1" required />PC端		
										</label>	
										<label class="checkbox-inline">
											<input type="radio" name="scope" value="2" required />触屏版				
										</label>
									</p>
								</div>	
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label"><span class="red">*</span>页面背景：</label>
								<div class="col-sm-4">
									<div  style="width: 200px;">
										<input required type="text" value="ccc" name="backColor" class="pick-a-color form-control" style="height:29px"/>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label"><span class="red">*</span>生效时间：</label>
								<div class="con-sm-6">
									<label>从</label>
									<input type="text" name="startTime" class="special_form datetime" required/>
									<label>到</label>
									<input type="text" name="endTime" class="special_form datetime" required />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label"><span class="red">*</span>星期循环：</label>
								<div class="col-sm-10">
									<label class="checkbox-inline">
									  <input type="checkbox" checked name="weeks" value="2"/> 星期一
									</label>
									<label class="checkbox-inline">
									  <input type="checkbox" checked name="weeks" value="3"/> 星期二
									</label>
									<label class="checkbox-inline">
									  <input type="checkbox" checked name="weeks"  value="4"/> 星期三
									</label>
									<label class="checkbox-inline">
									  <input type="checkbox" checked name="weeks"  value="5"/> 星期四
									</label>
									<label class="checkbox-inline">
									  <input type="checkbox" checked name="weeks" value="6"/> 星期五
									</label>
									<label class="checkbox-inline">
									  <input type="checkbox" checked name="weeks"  value="7"/> 星期六
									</label>
									<label class="checkbox-inline">
									  <input type="checkbox" checked name="weeks"  value="1"/> 星期日
									</label>
									<span class="gray">&nbsp;默认不根据星期过滤生效时间</span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label"><span class="red">*</span>时刻设置：</label>
								<div class="con-sm-6">
									<label>从</label>
									<input id="timeStart" name="orgSpecialTime.timeStart" class="time special_form " required/>
									<label>到</label>
									<input id="timeEnd" name="orgSpecialTime.timeEnd" class="time special_form "  required/>
								</div>
							</div>
							<%-- 
							<div class="form-group">
								<label class="col-sm-2 control-label"><span class="red">*</span>是否启用：</label>
								<div class="col-sm-2">
									<select name="status" class="form-control">
										<option value="1" >是</option>
										<option value="0" selected >否</option>
									</select>
								</div>
							</div>
							 --%>
							<div class="form-group">
								<label class="col-sm-2 control-label"><span class="red">*</span>活动规则：</label>
								<div class="col-sm-9">
									<textarea  name="orgSpecialRule.ruleContent" rows="10" class="form-control" id="content" ></textarea>
								</div>
							</div>
						</div>
					</div>
					<br/>
					<div class="text-center margin5">
						<a type="button" class="btn btn-default" href="${ctx}/special/list">返回</a>
						<button  id="addBtn"  type="submit" class="btn btn-info">保存</button> 
					</div>
				</div>
			</div>
		</div>
	</div>
</form>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/common/pick-a-color-1.2.2.min.js" type="text/javascript"></script>
<script src="${jsBase}/common/tinycolor-0.9.15.min.js" type="text/javascript"></script>
<script src="${jsBase}/common/kindeditor/kindeditor.js" type="text/javascript"></script>
<script src="${jsBase}/common/kindeditor/lang/zh_CN.js" type="text/javascript"></script>
<script src="${jsBase}/special/add.js" type="text/javascript"></script>
</body>
</html>
