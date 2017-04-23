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
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=D1DhyuyKwUtxW0r52g0gzxtFFviKv0tk"></script>
<%@include file="../common/common_js.jsp" %>
<script src="${jsBase}/shop/edit.js" type="text/javascript"></script>
<title>编辑店铺</title>
<title>店铺编辑</title>
</head>
<body>
	<form class="form-horizontal" id="shopEdit" action="${ctx}/shop/edit" method="post" >
	<div class="page-wrapper">
		<div class="container-fluid">
			<ul class="breadcrumb">
				<li>您的位置</li>
				<li ><a href="#">店铺</a></li>
				<li ><a href="${ctx}/shop/list">店铺管理</a></li>
				<li class="active">编辑店铺</li>
			</ul>
			<div class="panel panel-default">
				<div class="panel-heading">编辑店铺</div>
				<div class="panel-body">
					<input type="hidden" id="shopId" name = "shopId" value="${shop.shopId }" ></input>
					<div class="form-group">
						<label class="col-sm-2 control-label" >店铺名称：</label>	
							<div class="col-sm-9">
								<input type="text" class="form-control" placeholder="店铺名称" name="shopName" id="shopName" value="${shop.shopName}"
									required data-bv-notempty-message="店铺名称不能为空"
									maxlength="30" data-bv-stringlength-message="店铺名称长度不能大于30">
								</input>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" >店铺编号：</label>	
							<div class="col-sm-9">
								<input type="text" class="form-control" placeholder="店铺编号" name="shopCode" id="shopCode" value="${shop.shopCode}"
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
										<option value="${province.code }" <c:if test="${provinceCode==province.code }">selected</c:if>>${province.name }</option>
									</c:forEach>
								</select>
								
							</div>
							<div class="col-sm-3">
								<select class="form-control" name="cityCode" id="cityCode">
									<option value="-1">请选择市</option>
									<c:forEach items="${listCity}" var="city">
										<option value="${city.code }" <c:if test="${cityCode==city.code }">selected</c:if>>${city.name }</option>
									</c:forEach>
								</select>
								
							</div>
							<div class="col-sm-3">
								<select class="form-control" name="countyCode" id="countyCode">
									<option value="-1">请选择区或县</option>
									<c:forEach items="${listCounty}" var="county">
										<option value="${county.code }" <c:if test="${countyCode==county.code }">selected</c:if>>${county.name }</option>
									</c:forEach>
								</select>
								
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label" >所在区域：</label>
							<div class="col-sm-4">
								<select class="form-control" name="businessAreaId" id="businessAreaId">
									<option value='-1'>选择商圈</option>
									<c:forEach items="${listBusinessArea}" var="businessArea">
										<option value="${businessArea.id }" <c:if test="${shop.businessAreaId==businessArea.id}">selected</c:if>>${businessArea.name }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label" >详细地址：</label>	
							<div class="col-sm-9">
								<input type="text" class="form-control" placeholder="详细地址" name="address" id="address" value="${shop.address}"
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
											<input  type="text" class="form-control" placeholder="区号" name="firstPhoneAreaCode" id="firstPhoneAreaCode" value="${shop.firstPhoneAreaCode}"
												maxlength="4" data-bv-stringlength-message="电话区号长度不能大于4"
												pattern="^0[1-9]\d{1,2}$" data-bv-regexp-message="电话区号不符合规范">
											</input>
										</div>
									</div>
									<div class="col-sm-3">
										<div class="form-group">
											<input  type="text" class="form-control" placeholder="号码" name="firstPhoneNo" id="firstPhoneNo" value="${shop.firstPhoneNo}"
												maxlength="8" data-bv-stringlength-message="电话号码长度不能大于8">
											</input>
										</div>
									</div>
									<div class="col-sm-3">
										<div class="form-group">
											<input  type="text" class="form-control" placeholder="分机" name="firstPhoneExtension" id="firstPhoneExtension" value="${shop.firstPhoneExtension}"
												maxlength="4" data-bv-stringlength-message="电话分机长度不能大于4">
											</input>
										</div>
									</div>
								</div>
								<div class="row margin-left">
									<div class="col-sm-2">
										<div class="form-group">
											<input  type="text" class="form-control" placeholder="区号" name="secondPhoneAreaCode" id="secondPhoneAreaCode" value="${shop.secondPhoneAreaCode}"
												maxlength="4" data-bv-stringlength-message="电话区号长度不能大于4"
												pattern="^0[1-9]\d{1,2}$" data-bv-regexp-message="电话区号不符合规范">
											</input>
										</div>
									</div>
									<div class="col-sm-3">
										<div class="form-group">
											<input  type="text" class="form-control" placeholder="号码" name="secondPhoneNo" id="secondPhoneNo" value="${shop.secondPhoneNo}"
												maxlength="8" data-bv-stringlength-message="电话号码长度不能大于8">
											</input>
										</div>
									</div>
									<div class="col-sm-3">
										<div class="form-group">
											<input  type="text" class="form-control" placeholder="分机" name="secondPhoneExtension" id="secondPhoneExtension" value="${shop.secondPhoneExtension}"
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
											<input type="checkbox" value="${service.serviceId}" name="shopServiceList" <c:if test="${fn:contains(shop.shopBindServiceConcat,service.serviceName) }">checked</c:if>/>${service.serviceName}
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
										<c:forEach items="${sendRangeList}" var="send">
											<li class="list-group-item">
											   	<div class="list-group-left">
											   		<input type="hidden" name="sendRangeId" value="${send.id}"/>
											   		<span class="list-content-span">${send.sendRangeName}</span>
												   	<input type="text" class="form-control widthme" value="${send.sendRangeName}"/>
												</div>
												  	
												<div class="list-group-right">
													<span class="badge reversebadge bg2 btnEdit">编辑</span>
												    <span class="badge reversebadge bg2 btnDel">删除</span>
												    <span class="badge reversebadge bg1 btnCancel btn-danger">取消</span>
												    <span class="badge reversebadge bg1 btnConfirm btn-danger">确定</span>
												</div>
										  	</li>
										</c:forEach>
										</ul>
									</div>
								</div>
							</div>
						</div>
					
						<div class="form-group">
							<label class="col-sm-2 control-label">配送说明：</label>
							
							<div class="col-sm-6">
								<textarea class="form-control" rows="5" style="width:100%;resize: none;" placeholder="配送范围说明" id="sendExplain" name="sendExplain"
											maxlength="1000" data-bv-stringlength-message="配送范围说明长度不能大于1000">${shop.sendExplain}</textarea>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-2 control-label">配送时间：</label>
							<div class="col-sm-9">
								<div class="col-sm-4">
									<label class="col-sm-4 control-label ">上午：</label>
									<div class="col-sm-8">
										<div class="form-group text-length">
											<input type="text" class="time" id="sendTimeAmStart" name="sendTimeAmStart" value="<fmt:formatDate value="${shop.sendTimeAmStart}" type="time"/>"/>
											-
											<input type="text" class="time" id="sendTimeAmEnd" name="sendTimeAmEnd" value="<fmt:formatDate value="${shop.sendTimeAmEnd}" type="time"/>"/>					
										</div>								
									</div>
								</div>
								<div class="col-sm-4">
									<label class="col-sm-4 control-label">中午：</label>
									<div class="col-sm-8">
										<div class="form-group text-length">
											<input type="text" class="time" id="sendTimeNoonStart" name="sendTimeNoonStart" value="<fmt:formatDate value="${shop.sendTimeNoonStart}" type="time"/>"/>
											-	
											<input type="text" class="time" id="sendTimeNoonEnd" name="sendTimeNoonEnd" value="<fmt:formatDate value="${shop.sendTimeNoonEnd}" type="time"/>"/>						
										</div>								
									</div>
								</div>
								<div class="col-sm-4">
									<label class="col-sm-4 control-label">下午：</label>
									<div class="col-sm-8">
										<div class="form-group text-length">
											<input type="text" class="time" id="sendTimePmStart" name="sendTimePmStart" value="<fmt:formatDate value="${shop.sendTimePmStart}" type="time"/>"/>
											-	
											<input type="text" class="time" id="sendTimePmEnd" name="sendTimePmEnd" value="<fmt:formatDate value="${shop.sendTimePmEnd}" type="time"/>"/>						
										</div>								
									</div>
								</div>
								<div class="col-sm-4">
									<label class="col-sm-4 control-label">晚上：</label>
									<div class="col-sm-8">
										<div class="form-group text-length">
											<input type="text" class="time" id="sendTimeNightStart" name="sendTimeNightStart" value="<fmt:formatDate value="${shop.sendTimeNightStart}" type="time"/>"/>	
											-
											<input type="text" class="time" id="sendTimeNightEnd" name="sendTimeNightEnd" value="<fmt:formatDate value="${shop.sendTimeNightEnd}" type="time"/>"/>						
										</div>								
									</div>
								</div>
				
																
							</div>
						</div>	
						<div class="form-group">
							<label class="col-sm-2 control-label">营业时间：</label>
							<div class="col-sm-9">
								<div class="col-sm-4">
									<select class="form-control" id="openDay" name="openDay" value="${shop.openDay}">
									<option value="0" <c:if test="${shop.openDay == 0}">selected</c:if>>全部日期</option>
									<option value="1" <c:if test="${shop.openDay == 1}">selected</c:if>>仅工作日</option>								
								</select>
								</div>
								<div class="col-sm-4">
										<label class="col-sm-4 control-label ">时间：</label>
									<div class="col-sm-8">
										<div class="form-group text-length">
											<input type="text" class="time" id="openTimeStart" name="openTimeStart" value="<fmt:formatDate value="${shop.openTimeStart}" type="time"/>"/>	
											-
											<input type="text" class="time" id="openTimeEnd" name="openTimeEnd" value="<fmt:formatDate value="${shop.openTimeEnd}" type="time"/>"/>						
										</div>								
									</div>
								</div>
								<div class="col-sm-4">
									<label class="checkbox">
										<input type="checkbox" id="fullTime" name="fullTime" <c:if test="${fullTime}">checked</c:if>/>24小时营业
									</label>
								</div>													
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" >补货周期：</label>	
							<div class="col-sm-9">
								<p>
									<label class="checkbox-inline">
										<input type="checkbox" name="restockCycle" value="1" <c:if test="${fn:contains(shop.restockCycle,'1') }">checked</c:if>/>周一			
									</label>	
									<label class="checkbox-inline">
										<input type="checkbox" name="restockCycle" value="2" <c:if test="${fn:contains(shop.restockCycle,'2') }">checked</c:if>/>周二			
									</label>	
									<label class="checkbox-inline">
										<input type="checkbox" name="restockCycle" value="3" <c:if test="${fn:contains(shop.restockCycle,'3') }">checked</c:if>/>周三				
									</label>	
									<label class="checkbox-inline">
										<input type="checkbox" name="restockCycle" value="4" <c:if test="${fn:contains(shop.restockCycle,'4') }">checked</c:if>/>周四				
									</label>	
									<label class="checkbox-inline">
										<input type="checkbox" name="restockCycle" value="5" <c:if test="${fn:contains(shop.restockCycle,'5') }">checked</c:if>/>周五				
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" name="restockCycle" value="6" <c:if test="${fn:contains(shop.restockCycle,'6') }">checked</c:if>/>周六				
									</label>
									<label class="checkbox-inline">
										<input type="checkbox" name="restockCycle" value="7" <c:if test="${fn:contains(shop.restockCycle,'7') }">checked</c:if>/>周日				
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
												<img src="${pageImgIcon.pageImg}" alt="点击上传1:1" class="send_img1" />
												<input type="file" id="send_img1" name="file" class="form-control w260" style="display:none"  onchange="uploadImage('send_img1_hid')"/>
												<input type="hidden" id="send_img1_hid" name="pageImgIcon" value="${fn:substringAfter(pageImgIcon.pageImg,'imgBase')}" />
												<input type="hidden" id="send_img1_id" name="pageImgIconId" value="${pageImgIcon.id}"/>
												<span class="close">x</span>
											</div>

										</td>
										<td>
											<div class="send_img_wrapper">
												<img src="${pageImgImgMapMobile.pageImg}" alt="移动版形象图比例：3:4尺寸建议：600*800"  class="send_img2" />
												<input type="file" id="send_img2" name="file" class="form-control w260" style="display:none"  onchange="uploadImage('send_img2_hid')"/>
												<input type="hidden" id="send_img2_hid" name="pageImgImgMapMobile" value="${fn:substringAfter(pageImgImgMapMobile.pageImg,'imgBase')}"/>
												<input type="hidden" id="send_img2_id" name="pageImgImgMapMobileId" value="${pageImgImgMapMobile.id}"/>
												<span class="close">x</span>
											</div>
											<div class="send_img_wrapper">
												<img src="${pageImgImgMapPc.pageImg}" alt="PC版形象图比例：16:9尺寸建议：1000*800" class="send_img3" />
												<input type="file" id="send_img3" name="file" class="form-control w260" style="display:none"  onchange="uploadImage('send_img3_hid')"/>
												<input type="hidden" id="send_img3_hid" name="pageImgImgMapPc" value="${fn:substringAfter(pageImgImgMapPc.pageImg,'imgBase')}"/>
												<input type="hidden" id="send_img3_id" name="pageImgImgMapPcId" value="${pageImgImgMapPc.id}"/>
												<span class="close">x</span>
											</div>
										</td>
										<td>
											<div class="send_img_wrapper">
												<img src="${pageImgOutDoor1.pageImg}" alt="外景一"  class="send_img4" />
												<input type="file" id="send_img4" name="file" class="form-control w260" style="display:none"  onchange="uploadImage('send_img4_hid')"/>
												<input type="hidden" id="send_img4_hid" name="pageImgOutDoor1" value="${fn:substringAfter(pageImgOutDoor1.pageImg,'imgBase')}"/>
												<input type="hidden" id="send_img4_id" name="pageImgOutDoor1Id" value="${pageImgOutDoor1.id}"/>
												<span class="close">x</span>
											</div>
											<div class="send_img_wrapper">
												<img src="${pageImgOutDoor2.pageImg}" alt="外景二"  class="send_img5" />
												<input type="file" id="send_img5" name="file" class="form-control w260" style="display:none"  onchange="uploadImage('send_img5_hid')"/>
												<input type="hidden" id="send_img5_hid" name="pageImgOutDoor2" value="${fn:substringAfter(pageImgOutDoor2.pageImg,'imgBase')}"/>
												<input type="hidden" id="send_img5_id" name="pageImgOutDoor2Id" value="${pageImgOutDoor2.id}"/>
												<span class="close">x</span>
											</div>
										</td>
										<td>
											<div class="send_img_wrapper">
												<img src="${pageImgInterior1.pageImg}" alt="内景一"  class="send_img6" />
												<input type="file" id="send_img6" name="file" class="form-control w260" style="display:none"  onchange="uploadImage('send_img6_hid')"/>
												<input type="hidden" id="send_img6_hid" name="pageImgInterior1" value="${fn:substringAfter(pageImgInterior1.pageImg,'imgBase')}"/>
												<input type="hidden" id="send_img6_id" name="pageImgInterior1Id" value="${pageImgInterior1.id}"/>	
												<span class="close">x</span>
											</div>
											<div class="send_img_wrapper">
												<img src="${pageImgInterior2.pageImg}" alt="内景二"  class="send_img7" />
												<input type="file" id="send_img7" name="file" class="form-control w260" style="display:none"  onchange="uploadImage('send_img7_hid')"/>
												<input type="hidden" id="send_img7_hid" name="pageImgInterior2" value="${fn:substringAfter(pageImgInterior2.pageImg,'imgBase')}"/>
												<input type="hidden" id="send_img7_id" name="pageImgInterior2Id" value="${pageImgInterior2.id}"/>
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
							  <input type="text" class="form-control" id="shopOrder" name="shopOrder"  placeholder="排序" value="${shop.shopOrder}"
							   required data-bv-notempty-message="排序不能为空"
				               min="1" data-bv-greaterthan-message="排序值不能小于1"
				               max="255" data-bv-lessthan-message="排序值不能大于255"
							  />
							</div>
						</div>
				
						<div class="form-group">
							<label class="control-label col-sm-2">地图标注：</label>
							<input type="hidden" class="form-control" name="longitude" id="longitude" value="${shop.longitude}"
								required data-bv-notempty-message="经度不能为空"/>
							<input type="hidden" name="latitude" id="latitude" value="${shop.latitude}"/>
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
				<a type="button" class="btn btn-primary "  role="button" href="javascript:history.go(-1)">返回</a>
				<button type="submit" class="btn btn-primary " >确定</button>
			</div>
		</div>
	</div>
	</form>
</body>
</html>
