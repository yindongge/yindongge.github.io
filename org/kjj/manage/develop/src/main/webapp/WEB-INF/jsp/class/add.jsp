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
				<form id="form_add" name="form_add" class="horizontal" method="post" action="${ctx }/class/save">
					<div class="form-group">
						<label  class=" control-label">分类名称：</label>
						<input type="text" id="className" name="className" class="form-control"  placeholder="分类名称"/>						
					</div>
					<div class="form-group">
	                	<label class=" control-label">分类级别：</label>				
						<select class="form-control"  id="classLevel" name="classLevel">
							<c:forEach var="item" items="${classLevelList}" varStatus="status">
							<option value="${item.classLevelId }">${item.classLevelname}</option>
							</c:forEach>
						</select>						
					</div>
					<div class="form-group">
						<label  class="control-label" >上级分类：</label>
						<select class="form-control" id="classParent" name="classParent">
						</select>  			
                	</div>
					<div class="form-group">
						 <label  class=" control-label">数量单位：</label>					
						 <input type="text" class="form-control" id="classQuantity" name="classQuantity"  placeholder="数量单位"/>					
					</div>
					<div class="form-group">
						 <label  class=" control-label">排序：</label>						
						 <input type="text" class="form-control" name="classOrder" id="classOrder"  placeholder="0~255"/>				
					</div>
				   <div class="form-group">
						 <label  class=" control-label">菜单显示：</label>						
						 <input type="checkbox" class="checkbox-control" id="classShowmenuMark" name = "classShowmenuMark" />					
					</div> 
					<div class="form-group">
						 <label  class=" control-label">高亮显示：</label>						 
						 <input type="checkbox" class="checkbox-control" id="classShowHighlightMark"  name="classShowhighlightMark"   />						
					</div>            
                  	<div class="form-group">
                	  	<label  class=" control-label">类型：</label>   				
     				 	<select class="form-control" id="classType" name="classType">
							<option value="">选择类型</option>	
							<c:forEach var="item" items="${productTypeList}" varStatus="status">
							<option value="${item.typeId }">${item.typeName}</option>
							</c:forEach>
						</select>   				
                	</div>                
					<div class="form-group">
						<label  class=" control-label">分类关键字：</label>							
						<input type="text" class="form-control" id="classKeyword" name="classKeyword"  placeholder="分类关键字"/>				
                	</div>
	                <div class="form-group">
						<label  class=" control-label">描述：</label>						
						<textarea class="form-control" rows="5"  id="classDesc" name="classDesc"></textarea>
	                </div>
	                <div class="modal-footer">
				        <button type="button" class="btn btn-default modal-button" onclick="closewin();" data-dismiss="modal">取消</button>
				        <button type="submit" class="btn btn-primary modal-button" >确定</button>
				    </div>                
	            </form>   
      		</div>
    	</div>
  	</div>
</div>
<!--结束弹出框分割线-->
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/class/add.js" type="text/javascript"></script>
</body>
</html>