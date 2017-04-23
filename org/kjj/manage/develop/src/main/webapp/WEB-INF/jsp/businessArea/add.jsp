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
<title>添加商圈</title>
</head>
<body>
	<form class="form-horizontal" id="businessAreaAdd" action="${ctx}/businessArea/add" method="post">
	<div class="page-wrapper">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li>您的位置</li>
				<li ><a href="#">店铺</a></li>
				<li ><a href="${ctx}/businessArea/list">商圈管理</a></li>
				<li class="active">添加商圈</li>
			</ul>
			<div class="panel panel-default">
				<div class="panel-heading">添加商圈</div>
				<div class="panel-body">
					<div class="form-group">
						<label class="col-sm-2 control-label" >商圈名称：</label>	
						<div class="col-sm-9">
							<input type="text" class="form-control" placeholder="商圈名称" name="name" id="name"
								required data-bv-notempty-message="商圈名称不能为空"
								maxlength="30" data-bv-stringlength-message="商圈名称长度不能大于30">
							</input>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label" >所在区域:</label>
						<div class="col-sm-3">
							<select class="form-control" name="provinceCode" id="provinceCode"
								min="0" data-bv-greaterthan-message="请选择区域">
								<option value="-1">选择省或者市</option>
								<c:forEach items="${listProvince}" var="province">
									<option value="${province.code }">${province.name }</option>
								</c:forEach>
							</select>
							
						</div>
						<div class="col-sm-3">
							<select class="form-control" name="cityCode" id="cityCode">
								<option value="-1">请选择市</option>
							</select>
							
						</div>
						<div class="col-sm-3">
							<select class="form-control" name="countyCode" id="countyCode">
								<option value="-1">请选择区或县</option>
							</select>
							
						</div>
					</div>
					
					<div class="form-group">
						<label  class="col-sm-2 control-label">排序：</label>
						<div class="col-sm-5">
						  <input type="text" class="form-control" id="businessAreaOrder" name="businessAreaOrder"  placeholder="排序" value="255"
						   required data-bv-notempty-message="排序不能为空"
			               min="0" data-bv-greaterthan-message="排序值不能小于1"
			               max="256" data-bv-lessthan-message="排序值不能大于255"
						  />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label" >范围说明:</label>	
							<div class="col-sm-6">
								<textarea class="form-control" rows="8" placeholder="范围说明" id="rangeExplain" name="rangeExplain"
									maxlength="1000" data-bv-stringlength-message="配送范围说明长度不能大于1000"></textarea>
							</div>
					</div>
			    </div>
			</div>
			</br>
			<div class="text-center">
				<a type="button" class="btn btn-primary "  role="button" href="${ctx}/businessArea/list">返回</a>
				<button type="submit" class="btn btn-primary " >确定</button>
			</div>
		</div>
	</div>
	</form>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/businessArea/add.js" type="text/javascript"></script>
</body>
</html>