<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
<%@include file="../common/common_css.jsp"%>
<title>商品分类</title>
</head>
<body>
<div class="modal modal-control" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" >
			<div class="modal-content" >
			
			<div class="modal-body">
			<form id="formAdd" name="formAdd" class="horizontal" method="post" action="${ctx}/articleClass/save">
					<div class="form-group">
						<label  class=" control-label">*文章分类名称：</label>
						<input type="text" id="className" name="className" class="form-control"  placeholder="分类名称"/>						
					</div>
					<div class="form-group">
						  <label  class=" control-label">*上级分类：</label>					
						 <select id="parentid" name="parentid" class="form-control">
						  <option value="-1">请选择</option>
							 <c:forEach items="${ls}" var="i" >
							 	<option  value="${i.id}"><c:if test="${i.parentid ne -1}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>${i.className}</option>
							 </c:forEach>
						 </select>
						   <label  class=" control-label">不选为一级分类</label>						
					</div>
					<div class="form-group">
						 	<label  class=" control-label">排序：</label>					
						 <input type="text" class="form-control" id="order" name="order"  placeholder="255"/>		
					</div>
				  
            
                	<div class="form-group">
						   <div class="col-sm-12">
						   <div class="row">
						   			<div class="text-center">
									<button type="button" class="btn btn-primary "  onclick="closewin();">取消</button>
									<button type="submit" class="btn btn-primary "  >确定</button>
									</div>
								</div>
							</div>					
					</div>
            </form>
      </div>
    </div>
  </div>
</div>
<!--结束弹出框分割线-->
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/article/classadd.js" type="text/javascript"></script>
</body>
</html>