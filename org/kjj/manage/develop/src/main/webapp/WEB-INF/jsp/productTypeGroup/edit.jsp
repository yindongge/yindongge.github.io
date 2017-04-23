<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
<%@include file="../common/common_css.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>添加</title>
</head>
<body >	
	<div class="container">
        <div class="modal show modal-control" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<form class="form-horizontal" id="addForm" action="${ctx}/productTypeGroup/update" method="post">
				<input type="hidden" name="groupId" value="${productTypeGroup.groupId  }"/>
				<div class="modal-content">				
					<div class="modal-body">
						<div class="row">
							<div class="col-md-10 col-md-offset-1">
								<div class="form-group">
									<label  class="col-md-3 control-label"><i class="glyphicon glyphicon-star"></i>规格名称：</label>
									<div class="col-md-8">
										<input type="text" class="form-control"  placeholder="名称" name="orgproductTypeGroupName" value="${productTypeGroup.orgproductTypeGroupName }"/>
									</div>
								</div>
								<div class="form-group">
									<label  class="col-md-3 control-label">排序：</label>
									<div class="col-md-8">
										<input type="text" class="form-control"  placeholder="排序" name="groupOrder" value="${productTypeGroup.groupOrder }"/>
									</div>
								</div>	   																					
							</div>					
						</div>              	
					</div>
			 	 <div class="modal-footer">
			  		<button type="button" class="btn btn-default modal-button" data-dismiss="modal" onclick="closewin();">取消</button>
					<input type="submit" class="btn btn-primary modal-button" value="确定"/>
			  	</div>
   	 			</div>
    			</form>
  			</div>
		</div>
<!--结束弹出框分割线-->
	</div>
<%@include file="../common/common_js.jsp"%>
<script src="${jsBase}/productTypeGroup/edit.js" type="text/javascript"></script>	
</body>
</html>