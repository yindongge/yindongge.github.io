<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<%@include file="../common/common_css.jsp"%>
<title>品牌添加</title>
</head>
<body >	
	<!--弹出框分割线-->
        <div class="modal modal-control modal-control-5" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			<div class="modal-content">		
		<div class="modal-body">
			
			<div class="breadcrumb"> 您已经选择的项目：<span id="showtext"></span></div>
		
			<form class="form-inline clear-control5">
				<div class="form-group" >
					<label>您的常用类目:</label>
					<select class="form-control" style="width:600px" id="class_usual" name ="class_usual" onchange="">
						<option value="">选择常用类型</option>
						 <c:forEach var="item" items="${lsu}" varStatus="status">
						 	<option value="${item.class_id}">${item.class_1}</option>
						 </c:forEach>
					</select>
				</div>
				<div class='optionall' >
					<div class="row">
						<div class="col-sm-3">
							<select multiple class="form-control option-control" id="class_1" name ="class_1" onclick="classonselect()" onchange="changeSelect1()" >
							 <c:forEach var="item" items="${classLevelOne}" varStatus="status">
						 		<option value="${item.classId}">${item.className}</option>
						 	</c:forEach>
							</select>
						</div>
						<div class="col-sm-3">
							<select multiple class="form-control option-control" id="class_2" name ="class_2" onclick="classonselect()" onchange="changeSelect2()">
							  
							</select>
						</div>
						
						<div class="col-sm-3">
							<select multiple class="form-control option-control" id="class_3" name ="class_3" onclick="classonselect()">
							 
							</select>
						</div>
						<div class="col-sm-3">
							<select multiple class="form-control option-control">
							 
							</select>
						</div>
					</div>
				</div>
			</form>
     	
		</div>
      <div class="modal-footer">
			<button type="button" class="btn btn-default modal-button" data-dismiss="modal" onclick="closewin()">取消</button>
			<button type="button" class="btn btn-primary modal-button" onclick="setclass()" >确定</button>
			<button type="button" class="btn btn-info modal-button pull-right" onclick="addtousual() ">添加到常用项目</button>
      </div>
    </div>
  </div>
</div>
	
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/brand/selectClassForDeputy.js" type="text/javascript"></script>
</body>
</html>
