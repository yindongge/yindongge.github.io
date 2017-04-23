<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@include file="../common/common_java.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<%@include file="../common/common_css.jsp" %>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=D1DhyuyKwUtxW0r52g0gzxtFFviKv0tk"></script>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/shop/add.js" type="text/javascript"></script>
<title>新增店铺</title>
</head>
<body>
	<form class="form-horizontal" id="shopAdd" action="${ctx}/shop/add" method="post">
	<div class="page-wrapper">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li>您的位置</li>
				<li ><a href="#">店铺</a></li>
				<li ><a href="${ctx}/shop/list">店铺管理</a></li>
				<li class="active">新增店铺</li>
			</ul>
			<div class="panel panel-default">
				<div class="panel-heading">新增店铺</div>
				<div class="panel-body">
					<div class="form-group">
						<label class="col-sm-2 control-label" >店铺名称：</label>	
						<div class="col-sm-9">
							<input type="text" class="form-control" placeholder="店铺名称" name="shopName" id="shopName"
								required data-bv-notempty-message="店铺名称不能为空"
								maxlength="30" data-bv-stringlength-message="店铺名称长度不能大于30">
							</input>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" >店铺编号：</label>	
						<div class="col-sm-9">
							<input type="text" class="form-control" placeholder="店铺编号" name="shopCode" id="shopCode"
						    	required data-bv-notempty-message="店铺编号不能为空"
								maxlength="10" data-bv-stringlength-message="店铺编号长度不能大于10">
							</input>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label" >所在区域：</label>
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
						<label class="col-sm-2 control-label" >所在区域：</label>
						<div class="col-sm-4">
							<select class="form-control" name="businessAreaId" id="businessAreaId">
								<option value='-1'>选择商圈</option>
								<c:forEach items="${listBusinessArea}" var="businessArea">
									<option value="${businessArea.id }">${businessArea.name }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label" >详细地址：</label>	
						<div class="col-sm-9">
							<input type="text" class="form-control" placeholder="详细地址" name="address" id="address"
								required data-bv-notempty-message="详细地址不能为空"
								maxlength="100" data-bv-stringlength-message="详细地址长度不能大于100">
							</input>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label" >电话：</label>	
						<div class="col-sm-9">
							<div class="row margin-left">
								<div class="col-sm-2">
									<div class="form-group">
										<input  type="text" class="form-control" placeholder="区号" name="firstPhoneAreaCode" id="firstPhoneAreaCode"
											maxlength="4" data-bv-stringlength-message="电话区号长度不能大于4"
											pattern="^0[1-9]\d{1,2}$" data-bv-regexp-message="电话区号不符合规范">
										</input>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="form-group">
										<input  type="text" class="form-control" placeholder="号码" name="firstPhoneNo" id="firstPhoneNo"
											maxlength="8" data-bv-stringlength-message="电话号码长度不能大于8">
										</input>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="form-group">
										<input  type="text" class="form-control" placeholder="分机" name="firstPhoneExtension" id="firstPhoneExtension"
											maxlength="4" data-bv-stringlength-message="电话分机长度不能大于4">
										</input>
									</div>
								</div>
							</div>
							<div class="row margin-left">
								<div class="col-sm-2">
									<div class="form-group">
										<input  type="text" class="form-control" placeholder="区号" name="secondPhoneAreaCode" id="secondPhoneAreaCode"
											maxlength="4" data-bv-stringlength-message="电话区号长度不能大于4"
											pattern="^0[1-9]\d{1,2}$" data-bv-regexp-message="电话区号不符合规范">
										</input>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="form-group">
										<input  type="text" class="form-control" placeholder="号码" name="secondPhoneNo" id="secondPhoneNo"
											maxlength="8" data-bv-stringlength-message="电话号码长度不能大于8">
										</input>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="form-group">
										<input  type="text" class="form-control" placeholder="分机" name="secondPhoneExtension" id="secondPhoneExtension"
											maxlength="4" data-bv-stringlength-message="电话分机长度不能大于4">
										</input>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label" >店内服务：</label>	
						<div class="col-sm-9">
							<p>
								<c:forEach items="${listShopService}" var="service">
									<label class="checkbox-inline">
										<input type="checkbox" value="${service.serviceId }" name="shopServiceList">${service.serviceName }</input>
									</label>
								</c:forEach>
							</p>
						</div>	
							
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label" >配送范围：</label>	
						<div class="col-sm-9">
							<div class="row margin-left">
								<div class="col-sm-4">
									<div class="form-group">
										<input type="text" class="form-control" id="sendRange"
											maxlength="100" data-bv-stringlength-message="配送范围长度不能大于100">
										</input>
									</div>									
								</div>
								<div class="col-sm-3">
									<div class="form-group">
										<button type="button" class="btn btn-default btn-black" id="sendAdd" name="sendAdd">添加</button>
									</div>
									
								</div>
							</div>
							<div class="row">
								<div class="col-sm-8">
									<ul class="list-group" id="sendRangeList">
									</ul>
								</div>
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label">配送说明：</label>
						
						<div class="col-sm-6">
							<textarea class="form-control" rows="5" style="width:100%;resize: none;" placeholder="配送范围说明" id="sendExplain" name="sendExplain"
										maxlength="1000" data-bv-stringlength-message="配送范围说明长度不能大于1000"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">配送时间：</label>
						<div class="col-sm-9">
							<div class="col-sm-4">
								<label class="col-sm-4 control-label ">上午：</label>
								<div class="col-sm-8">
									<div class="form-group text-length">
										<input type="text" class="time" value="08:00:00" id="sendTimeAmStart" name="sendTimeAmStart"/>
										-
										<input type="text" class="time" value="11:00:00" id="sendTimeAmEnd" name="sendTimeAmEnd"/>					
									</div>								
								</div>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">中午：</label>
								<div class="col-sm-8">
									<div class="form-group text-length">
										<input type="text" class="time" value="11:00:00" id="sendTimeNoonStart" name="sendTimeNoonStart"/>
										-	
										<input type="text" class="time" value="13:00:00" id="sendTimeNoonEnd" name="sendTimeNoonEnd"/>						
									</div>								
								</div>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">下午：</label>
								<div class="col-sm-8">
									<div class="form-group text-length">
										<input type="text" class="time" value="13:00:00" id="sendTimePmStart" name="sendTimePmStart"/>
										-	
										<input type="text" class="time" value="18:00:00" id="sendTimePmEnd" name="sendTimePmEnd"/>						
									</div>								
								</div>
							</div>
							<div class="col-sm-4">
								<label class="col-sm-4 control-label">晚上：</label>
								<div class="col-sm-8">
									<div class="form-group text-length">
										<input type="text" class="time" value="19:00:00" id="sendTimeNightStart" name="sendTimeNightStart"/>	
										-
										<input type="text" class="time" value="21:00:00" id="sendTimeNightEnd" name="sendTimeNightEnd"/>						
									</div>								
								</div>
							</div>
	
															
						</div>
					</div>	
					<div class="form-group">
						<label class="col-sm-2 control-label">营业时间：</label>
						<div class="col-sm-9">
							<div class="col-sm-4">
								<select class="form-control" id="openDay" name="openDay">
								<option value="0">全部日期</option>
								<option value="1">仅工作日</option>								
							</select>
							</div>
							<div class="col-sm-4">
									<label class="col-sm-4 control-label ">时间：</label>
								<div class="col-sm-8">
									<div class="form-group text-length">
										<input type="text" class="time" value="08:00:00" id="openTimeStart" name="openTimeStart"/>	
										-
										<input type="text" class="time" value="21:00:00" id="openTimeEnd" name="openTimeEnd"/>						
									</div>								
								</div>
							</div>
							<div class="col-sm-4">
								<label class="checkbox">
									<input type="checkbox" id="fullTime" name="fullTime"/>24小时营业
								</label>
							</div>													
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" >补货周期：</label>	
						<div class="col-sm-9">
							<p>
								<label class="checkbox-inline">
									<input type="checkbox" name="restockCycle" value="1"/>周一				
								</label>	
								<label class="checkbox-inline">
									<input type="checkbox" name="restockCycle" value="2"/>周二				
								</label>	
								<label class="checkbox-inline">
									<input type="checkbox" name="restockCycle" value="3"/>周三				
								</label>	
								<label class="checkbox-inline">
									<input type="checkbox" name="restockCycle" value="4"/>周四				
								</label>	
								<label class="checkbox-inline">
									<input type="checkbox" name="restockCycle" value="5"/>周五				
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" name="restockCycle" value="6"/>周六				
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" name="restockCycle" value="7"/>周日				
								</label>									
							</p>
						</div>	
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">店铺图片：</label>
						<div class="col-sm-10">
							<table class="table table-bordered table-hover">
								<thead>
									<tr>
										<th style="width:100px">图标</th>
										<th >形象图</th>
										<th >外景</th>
										<th >内景</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td style="text-align:left">
											<div class="send_img_wrapper">
												<img src="" alt="点击上传1:1" class="send_img1" />
												<input type="file" id="send_img1" name="file" class="form-control w260" style="display:none"  onchange="uploadImage('send_img1_hid')"/>
												<input type="hidden" id="send_img1_hid" name="pageImgIcon" value="" />
												<span class="close">x</span>
											</div>

										</td>
										<td>
											<div class="send_img_wrapper">
												<img src="" alt="移动版形象图比例：3:4尺寸建议：600*800"  class="send_img2" />
												<input type="file" id="send_img2" name="file" class="form-control w260" style="display:none"  onchange="uploadImage('send_img2_hid')"/>
												<input type="hidden" id="send_img2_hid" name="pageImgImgMapMobile" value=""/>
												<span class="close">x</span>
											</div>
											<div class="send_img_wrapper">
												<img src="" alt="PC版形象图比例：16:9尺寸建议：1000*800" class="send_img3" />
												<input type="file" id="send_img3" name="file" class="form-control w260" style="display:none"  onchange="uploadImage('send_img3_hid')"/>
												<input type="hidden" id="send_img3_hid" name="pageImgImgMapPc" value=""/>
												<span class="close">x</span>
											</div>
										</td>
										<td>
											<div class="send_img_wrapper">
												<img src="" alt="外景一"  class="send_img4" />
												<input type="file" id="send_img4" name="file" class="form-control w260" style="display:none"  onchange="uploadImage('send_img4_hid')"/>
												<input type="hidden" id="send_img4_hid" name="pageImgOutDoor1" value=""/>
												<span class="close">x</span>
											</div>
											<div class="send_img_wrapper">
												<img src="" alt="外景二"  class="send_img5" />
												<input type="file" id="send_img5" name="file" class="form-control w260" style="display:none"  onchange="uploadImage('send_img5_hid')"/>
												<input type="hidden" id="send_img5_hid" name="pageImgOutDoor2" value=""/>
												<span class="close">x</span>
											</div>
										</td>
										<td>
											<div class="send_img_wrapper">
												<img src="" alt="内景一"  class="send_img6" />
												<input type="file" id="send_img6" name="file" class="form-control w260" style="display:none"  onchange="uploadImage('send_img6_hid')"/>
												<input type="hidden" id="send_img6_hid" name="pageImgInterior1" value=""/>	
<!-- 												<input type="hidden" name="type" value="3"/> -->
												<span class="close">x</span>
											</div>
											<div class="send_img_wrapper">
												<img src="" alt="内景二"  class="send_img7" />
												<input type="file" id="send_img7" name="file" class="form-control w260" style="display:none"  onchange="uploadImage('send_img7_hid')"/>
												<input type="hidden" id="send_img7_hid" name="pageImgInterior2" value=""/>
												<span class="close">x</span>
											</div>
										</td>
									</tr>
									<tr>
										<td>图标用图，建议200*200px，1:1比例</td>
										<td>移动版和PC版分别上传，请注意图片尺寸。</td>
										<td>比例：16:9尺寸建议：1600*900</td>
										<td>比例：16:9尺寸建议：1600*900</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div class="form-group">
						<label  class="col-sm-2 control-label">排序：</label>
						<div class="col-sm-5">
						  <input type="text" class="form-control" id="shopOrder" name="shopOrder"  placeholder="排序" value="255"
						   required data-bv-notempty-message="排序不能为空"
			               min="1" data-bv-greaterthan-message="排序值不能小于1"
			               max="255" data-bv-lessthan-message="排序值不能大于255"
						  />
						</div>
					</div>
	
					<div class="form-group">
						<label class="control-label col-sm-2">地图标注：</label>
						<input type="hidden" name="longitude" id="longitude"/>
						<input type="hidden" name="latitude" id="latitude"/>
						<div class="col-sm-9">
							<div class="row margin-left">
								<div class="col-sm-4">
									<div class="form-group">
										<input type="text" class="form-control" placeholder="店铺位置" id="searchArea"></input>
									</div>									
								</div>
								<div class="col-sm-3">
									<div class="form-group">
										<button type="button" class="btn btn-primary" id="search" name="search">搜索</button>
									</div>
									
								</div>
							</div>
							<div class="row margin-left">
								<div class="col-sm-10" style="height:300px; border: 1px solid gray" id="allmap">
								</div>
					    	</div>
						</div>
					</div>
					
			    </div>
			</div>
			<br/>
			<div class="text-center">
				<a type="button" class="btn btn-primary "  role="button" href="${ctx}/shop/list">返回</a>
				<button type="submit" class="btn btn-primary " >确定</button>
			</div>
		</div>
	</div>
	</form>
</body>
</html>