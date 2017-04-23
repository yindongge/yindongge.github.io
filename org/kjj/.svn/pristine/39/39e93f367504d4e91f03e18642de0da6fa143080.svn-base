<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
<%@include file="../common/common_css.jsp" %>
<title>修改菜单</title>
<script type="text/javascript">
</script>
</head>
<body >	
	<!--弹出框分割线-->
        <div class="modal show modal-control " tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="margin-top:0px">
				<div class="modal-content">
			<div class="modal-body">
				<form class="form-horizontal " id="menuForm" name ="menuForm">
					<input type="hidden" name="modelid" id="modelid" value="${obj.modelid}"/>
					
					<div class="form-group">
						<label class="col-sm-2 control-label">菜单名称：</label>
						<div class="col-sm-8">
							<input type="text" id="modelname" name="modelname" class="form-control" value="${obj.modelname}"></input>
						</div>
					</div>
					<div class="form-group">
					<label class="col-sm-2 control-label">上级菜单：</label>
						<div class="col-sm-8">
							<div class="col-sm-6" style="padding-left:0px;">
								<select class="form-control" id="modelparent" name="modelparent">
									<option value ="0">请选择菜单</option>
									<c:forEach items="${list}" var ="item">
											<c:if test="${item.modelparent eq 0}">      	
					      						<option value="${item.modelid}" <c:if test="${obj.modelparent eq item.modelid}">selected</c:if>  >${item.modelname}</option>
									      	</c:if>
									      	<c:if test="${item.modelparent ne 0}">
									      			<option value="${item.modelid}"  <c:if test="${obj.modelparent eq item.modelid}">selected</c:if>  >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${item.modelname}</option>
									      	</c:if>
									</c:forEach>
								</select>
							</div>
							<div class="col-sm-6">
								不选择为一级菜单
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">菜单编号：</label>
						<div class="col-sm-8">
							<input type="text" id="modelcode" name="modelcode" value="${obj.modelcode}" class="form-control"></input>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">url地址：</label>
						<div class="col-sm-8">
							<input type="text" id="url" name="url" value="${obj.url}" class="form-control"></input>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">是否启用：</label>
						<div class="col-sm-8">
							<select class="form-control" name="isactive">
								<option <c:if test="${obj.isactive=='0'}">selected="selected"</c:if> value="0" >停用</option>
								<option <c:if test="${obj.isactive=='1'}">selected='selected'</c:if> value="1">启用</option>
							</select>
						</div>
					</div>
					 <div class="modal-footer">
				<button type="button" class="btn btn-default modal-button" data-dismiss="modal" onclick="cancle()">取消</button>
				<button type="submit" class="btn btn-primary modal-button">确定</button>
			  </div>
				</form>
			</div>
			 
    </div>
  </div>
</div>
<!--结束弹出框分割线-->
	
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/menu/edit.js" type="text/javascript"></script>	
</body>
</html>
