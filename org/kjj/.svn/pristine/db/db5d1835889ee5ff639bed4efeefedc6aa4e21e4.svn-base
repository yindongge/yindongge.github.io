<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<%@include file="../common/common_css.jsp" %>
<title>修改用户级别</title>
<style>
#userlevelform .col-sm-2{width:100px; text-align:right;}
</style>
</head>

<body>	
<form class="form-horizontal media-control"  id="userlevelform" name ="userlevelform" action="${ctx}/userlevel/save" method="post">
<div class="class="page-wrapper"">
<div class="container-fluid">
	<ul class="breadcrumb" style="margin-bottom:10px; margin-top:5px;">
		<li>您的位置</li>
		<li ><a href="#">会员</a></li>
		<li ><a href="#">级别管理</a></li>
		<li class="active">修改会员级别</li>
	</ul>
		<div class="panel panel-default"> 
			<div class="panel-heading">修改会员级别</div> 
			<div class="panel-body">
				<div class="form-group">
					<label class="col-sm-2 control-label" style="float:left;">标识编码：</label>
					<div class="col-sm-3 " style="float:left;font-size:12px;margin-top:5px">
					    ${userLevel.levelId}
					    <input type="hidden" id="levelId" name="levelId" value="${userLevel.levelId}"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" style="float:left;">级别名称：</label>
					<div class="col-sm-3 " style="float:left;font-size:12px;margin-top:5px">
					    ${userLevel.levelName}
					</div>
				</div>
				<div class="form-group">
					<label  class="col-sm-2 control-label" style="float:left;" ><span class="red bigred">*</span>类型：</label>
					<div class="col-sm-3 " style="float:left;">
					    <select class="form-control" id="levelType" name="levelType">
							<option value="1" <c:if test="${userLevel.levelType==1}">selected</c:if>>个人</option>
							<option value="2" <c:if test="${userLevel.levelType==2}">selected</c:if>>企业</option>
							<option value="3" <c:if test="${userLevel.levelType==3}">selected</c:if>>关联企业</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label  class="col-sm-2 control-label" style="float:left;"><span class="red bigred">*</span>消费下限：</label>
					<div class="col-sm-3 " style="float:left;">
					    <input type="text" class="form-control" id="consumeDown" name="consumeDown" value="${userLevel.consumeDown}"  onkeypress="if(!this.value.match(/^\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?\d+(?:\.\d+)?)?$/))this.o_value=this.value;" onkeyup="if(!this.value.match(/^\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?\d+(?:\.\d+)?)?$/))this.o_value=this.value" onblur="if(!this.value.match(/^(?\d+(?:\.\d+)?|\.\d*?)?$/))this.value=this.o_value;else{if(this.value.match(/^\.\d+$/))this.value=0+this.value;if(this.value.match(/^\.$/))this.value=0;this.o_value=this.value}" maxlength="10"/>
					</div>
				</div>
				<div class="form-group">
					<label  class="col-sm-2 control-label" style="float:left;"><span class="red bigred">*</span>消费上限：</label>
					<div class="col-sm-3 " style="float:left;">
					    <input type="text"  class="form-control" id="consumeTop" name="consumeTop" value="${userLevel.consumeTop}" onkeypress="if(!this.value.match(/^\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?\d+(?:\.\d+)?)?$/))this.o_value=this.value;" onkeyup="if(!this.value.match(/^\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?\d+(?:\.\d+)?)?$/))this.o_value=this.value" onblur="if(!this.value.match(/^(?\d+(?:\.\d+)?|\.\d*?)?$/))this.value=this.o_value;else{if(this.value.match(/^\.\d+$/))this.value=0+this.value;if(this.value.match(/^\.$/))this.value=0;this.o_value=this.value}" maxlength="10"/>
					</div>
				</div>
				<div class="form-group">
					<label  class="col-sm-2 control-label" style="float:left;"><span class="red bigred">*</span>折扣：</label>
					<div class="col-sm-3 " style="float:left;">
					    <input type="text"  class="form-control" id="discount" name="discount" value="${userLevel.discount}" onkeypress="if(!this.value.match(/^\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?\d+(?:\.\d+)?)?$/))this.o_value=this.value;" onkeyup="if(!this.value.match(/^\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?\d+(?:\.\d+)?)?$/))this.o_value=this.value" onblur="if(!this.value.match(/^(?\d+(?:\.\d+)?|\.\d*?)?$/))this.value=this.o_value;else{if(this.value.match(/^\.\d+$/))this.value=0+this.value;if(this.value.match(/^\.$/))this.value=0;this.o_value=this.value}" maxlength="10"/>
					</div>
				</div>		
				<div class="form-group">
					<label  class="col-sm-2 control-label" style="float:left;">排序：</label>
					<div class="col-sm-3 " style="float:left;">
					    <select class="form-control" id="levelOrder" name="levelOrder">
							<option value="1" <c:if test="${userLevel.levelOrder==1}">selected</c:if>>1</option>
							<option value="2" <c:if test="${userLevel.levelOrder==2}">selected</c:if>>2</option>
							<option value="3" <c:if test="${userLevel.levelOrder==3}">selected</c:if>>3</option>
							<option value="4" <c:if test="${userLevel.levelOrder==4}">selected</c:if>>4</option>
							<option value="5" <c:if test="${userLevel.levelOrder==5}">selected</c:if>>5</option>
							<option value="6" <c:if test="${userLevel.levelOrder==6}">selected</c:if>>6</option>
							<option value="7" <c:if test="${userLevel.levelOrder==7}">selected</c:if>>7</option>
							<option value="8" <c:if test="${userLevel.levelOrder==8}">selected</c:if>>8</option>
							<option value="9" <c:if test="${userLevel.levelOrder==9}">selected</c:if>>9</option>
							<option value="10" <c:if test="${userLevel.levelOrder==10}">selected</c:if>>10</option>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="text-center">
			<button type="button" class="btn btn-default modal-button" data-dismiss="modal" onclick="cancle()">返回</button>
			<button type="button" class="btn btn-danger" onclick="update()">保存</button>
		</div>
	</form>
</div>
</div>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/user/levelEdit.js" type="text/javascript"></script>
</body>
</html>
