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
<title>新增店铺首页</title>
<style>

</style>
</head>

<body>	
	<form class="form-horizontal media-control"  id="shopPageform" name ="shopPageform" action="../shopPage/savePage" method="post" enctype="multipart/form-data">
	<input type="hidden" id="floorNumbers" name="floorNumbers" value=""/>
	<input type="hidden" id="type" name="type" value=""/>
	<input type="hidden" id="shopId" name="shopId" value=""/>
	<div class="class="page-wrapper">
		<div class="container-fluid">
			<ul class="breadcrumb" style="margin-bottom:10px; margin-top:5px;">
				<li>您的位置</li>
				<li ><a href="#">店铺</a></li>
				<li ><a href="#">店铺管理</a></li>
				<li class="active">新增店铺首页</li>
			</ul>
	
			<div class="panel panel-default"> 
				<div class="panel-heading">新增店铺首页</div> 
				<div class="panel-body">
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
						<label class="col-sm-2 control-label" >门店选择:</label>
						<div class="col-sm-4">
							<select class="form-control" name="shop_id" id="shop_id">
								<option value="-1">选择门店</option>

							</select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label" >是否启用:</label>
						<div class="col-sm-4">
							<select class="form-control" name="isactive" id="isactive">
								<option value="1">是</option>
								<option value="0">否</option>
							</select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label" >banner:</label>
						<div class="col-sm-10">
							<button type="button" onclick="addBanner()"  class="btn btn-danger">增加banner</button>
						</div>	
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" ></label>
						<div class="col-sm-10" id="bannerArea">
							
						</div>	
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" >热门搜索:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="shopSearch" name="shopSearch"
											maxlength="100" title="搜索词之间以逗号隔开">
							</input>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" >宣传商品:</label>
						<div class="col-sm-10">
							<button type="button" onclick="addShowProduct()"  class="btn btn-danger">增加宣传商品</button>
						</div>	
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" ></label>
						<div class="col-sm-10" id="showProductArea">
							
						</div>	
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">楼层添加:</label>
						
						<div class="col-sm-10">
							<button type="button" onclick="addFloor()"  class="btn btn-danger">添加楼层</button>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label"></label>
						
						<div class="col-sm-10" id="floorArea">
							
						</div>
					</div>
			</div>
			<div class="text-center">
				<button type="button" class="btn btn-default modal-button" data-dismiss="modal" onclick="cancle()">返回</button>
				<button type="button"  class="btn btn-danger" onclick="savedata()">保存</button>
			</div>
			<br/><br/>
		</div>
	</div>
	</form>
	<%@include file="../common/common_js.jsp" %>
	<script src="${jsBase}/shopPage/shopPageAdd.js" type="text/javascript"></script>
</body>
</html>
