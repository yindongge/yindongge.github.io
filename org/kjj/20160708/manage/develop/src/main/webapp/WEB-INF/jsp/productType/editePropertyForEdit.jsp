<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-CN">
<head>
<title>编辑</title>
<%@include file="../common/common_css.jsp" %>
</head>
<body>
	<!--弹出框分割线-->
	<div class="modal show modal-control modal-controladd3 " tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<form class="form-horizontal" id="addForm"  action="${ctx}/productType/updatePropertyForEdit" method="post"
					  data-bv-message="This value is not valid"
                      data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
                      data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
                      data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
			<div class="modal-content">
				<div class="modal-body">
					<div class="row">
						<div class="col-md-10 col-md-offset-1">
								<input type="hidden" name="propertyId" value="${productProperty.propertyId }"/>					
								<div class="form-group">
									<label class="col-md-3 control-label"><i
										class="glyphicon glyphicon-star"></i>属性名称：</label>
									<div class="col-md-8">
										<input type="text" class="form-control" id="propertyName" name="propertyName" value="${productProperty.propertyName }" placeholder="名称" required data-bv-notempty-message="名称不能为空"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label">排序：</label>
									<div class="col-md-8">
										<input type="text" class="form-control" id="propertyOrder" name="propertyOrder" value="${productProperty.propertyOrder }" placeholder="排序" required data-bv-notempty-message="排序不能为空" pattern="^[0-9]*$" data-bv-regexp-message="必须为数字"/>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label"><i
										class="glyphicon glyphicon-star"></i>是否必选：</label>
									<div class="col-md-8">
										<label class="radio-inline"> 
											<input type="radio" name="propertySelect" id="selectRadio1" value="1"/>
									     是</label> 
									    <label class="radio-inline"> 
									    	<input type="radio" name="propertySelect" id="selectRadio2" value="0"/>
									    否 </label>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label">录入方式：</label>
									<div class="col-md-9">
										<label class="radio-inline"> 
											<input type="radio"	name="propertyInputType" id="typeRadio1" value="1"/>手动输入
										</label> 
										<label class="radio-inline"> 
											<input type="radio" name="propertyInputType" id="typeRadio2"	value="2"/> 单选组 
										</label> 
										<label class="radio-inline">
											<input type="radio" name="propertyInputType" id="typeRadio3" value="3"/> 列表单选 
										</label> 
										<label class="radio-inline">
											<input type="radio" name="propertyInputType" id="typeRadio4" value="4"/>复选框 
										</label>
									</div>
								</div>

								<div class="form-group" id="valueParentArea">
									<label class="col-md-3 control-label">可选值：</label>
									<div id="valueArea" class="col-md-9">
										<c:if test="${productProperty.propertyInputType != 1}">
										<div class="special3" id="itemArea">
											<table class="table">
												<tbody id="addItemArea">	
													<c:forEach items="${propertyValueList }" var="item">
														<tr>
															<td>
																<div class="form-group">	
																	<input type="hidden" name="propertyValueIds" value="${item.propertyValueId }"/>
																	<input type="hidden" name="isDeletes" value="false"/>
																	<input type="text" class="form-control" name="propertyValues" value="${item.propertyValue }"></input>
																</div>	
															</td>
															<td>
																<button type="button" class="btn btn-danger" onclick="deleteItem(this);"><i class="glyphicon glyphicon-remove-circle"></i>	</button>	
															</td>
														</tr>
													</c:forEach>
												</tbody>		
											</table>
										</div>
										<button type="button" class="btn btn-danger" onclick="addItem();" id="addItmBtn">添加一行</button>
										</c:if>
										<c:if test="${productProperty.propertyInputType == 1}">
											<c:forEach items="${propertyValueList }" var="item">
												<input type="hidden" name="propertyValueIds" value="${item.propertyValueId }"/>
												<textarea class="form-control"  rows="5" id="textArea" name="propertyValues">${item.propertyValue }</textarea>
											</c:forEach>
										</c:if>		
									</div>
								</div>							
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default modal-button"	data-dismiss="modal" onclick="closewin();">取消</button>
					<input type="submit" class="btn btn-primary modal-button"  value="确定"></input>
				</div>
			</div>
			</form>
		</div>
	</div>
	<!--结束弹出框分割线-->
	<input type="hidden" id="propertySelect" value="${productProperty.propertySelect}"/>
	<input type="hidden" id="propertyInputType" value="${productProperty.propertyInputType}"/>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/productType/editePropertyForEdit.js" type="text/javascript"></script>
</body>
</html>