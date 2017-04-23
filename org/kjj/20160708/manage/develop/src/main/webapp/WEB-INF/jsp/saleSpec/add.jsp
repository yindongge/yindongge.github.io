<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
<%@include file="../common/common_css.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>添加</title>
</head>
<body>
	<!--弹出框分割线-->
	<div class="container">
		<div class="modal show modal-control" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<form class="form-horizontal" id="addForm" action="${ctx}/saleSpec/save" method="post">
					<div class="modal-content">
						<div class="modal-body">
							<div class="row">
								<div class="col-md-10 col-md-offset-1">
									<div class="form-group">
										<label class="col-md-3 control-label"><i
											class="glyphicon glyphicon-star"></i>规格名称：</label>
										<div class="col-md-7">
											<input type="text" class="form-control" name="specName"	placeholder="名称" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">排序：</label>
										<div class="col-md-7">
											<input type="text" class="form-control" name="specOrder"
												placeholder="排序" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">
											<i class="glyphicon glyphicon-star"></i>类型：</label>
										<div class="col-md-8">
											<label class="radio-inline"> 
												<input type="radio"	name="specTypeId" value="1" checked="checked" /> 文字
											</label> 
											<label class="radio-inline"> 
												<input type="radio"	name="specTypeId" value="2" /> 颜色
											</label>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">添加规格值：</label>
										<div class="col-md-8" id="specValueArea">
											<div class="row">
												<div class="col-sm-4">
													<div class="form-group">
														<input type="text" class="color-control form-control" name="specValue" placeholder="规格值" />
													</div>
												</div>
												<div class="col-sm-4 color_area" style="display: none;">
													<div class="form-group">
														<input type="text" class="color-control form-control"
															name="colour" id="value-color1" readonly="readonly"
															placeholder="颜色值" />
													</div>
												</div>
												<div class="col-sm-1 color_area" style="display: none;">
													<div class="kuai icon2 dropdown-toggle color-div"
														role="button" id="color1" onclick="openColorPiker(this);"></div>
												</div>
												<div class="col-sm-1">
													<button type="button" class="btn "
														onclick="removeItem(this);" style="background: none;">
														<i class="glyphicon glyphicon-remove-circle"></i>
													</button>
												</div>
											</div>
										</div>
										<div class="form-group" style="padding-left: 30px;">
											<button type="button" class="btn btn-danger" id="addItemBtn">添加一条</button>
										</div>
									</div>

								</div>

							</div>


						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default modal-button"
								data-dismiss="modal" onclick="closewin();">取消</button>
							<button type="submit" class="btn btn-primary modal-button">确定</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>	
	<!--结束弹出框分割线-->
	<input type="hidden" id="colorDivId" value="" />
<%@include file="../common/common_js.jsp"%>
<script src="${jsBase}/common/colorpicker/colorpicker.min.js" type="text/javascript"></script>
<script src="${jsBase}/saleSpec/add.js" type="text/javascript"></script>
</body>
</html>