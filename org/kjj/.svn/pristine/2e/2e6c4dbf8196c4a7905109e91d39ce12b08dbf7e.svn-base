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
	<form class="form-horizontal media-control"  id="shopPageform" name ="shopPageform" action="../shopPage/updatePage" method="post" enctype="multipart/form-data">
	<input type="hidden" id="floorNumbers" name="floorNumbers" value=""/>
	<input type="hidden" id="id" name="id" value="${pageobj.id}"/>
	<input type="hidden" id="type" name="type" value="${pageobj.type}"/>
	<input type="hidden" id="shopId" name="shopId" value="${pageobj.shopId}"/>
	<input type="hidden" id="bannerIndexs" name="bannerIndexs" value=""/>
	<input type="hidden" id="recommandIndexs" name="recommandIndexs" value=""/>
	<input type="hidden" id="ImageBasePath" name="ImageBasePath" value="${ImageBasePath}"/>
	<div class="page-wrapper">
		<div class="container-fluid">
			<ul class="breadcrumb" style="margin-bottom:10px; margin-top:5px;">
				<li>您的位置</li>
				<li ><a href="#">店铺</a></li>
				<li ><a href="#">店铺管理</a></li>
				<li class="active">修改店铺首页</li>
			</ul>
	
			<div class="panel panel-default"> 
				<div class="panel-heading">修改店铺首页</div> 
				<div class="panel-body">
					<div class="form-group">
						<label class="col-sm-2 control-label" >所在区域:</label>
						<div class="col-sm-3">
							<select class="form-control" name="provinceCode" id="provinceCode"
								min="0" data-bv-greaterthan-message="请选择区域">
								<option value="-1">选择省或者市</option>
								<c:forEach items="${listProvince}" var="province">
									<option value="${province.code }" <c:if test="${province.code==provinceCode}">selected</c:if>>${province.name }</option>
								</c:forEach>
							</select>
							
						</div>
						<div class="col-sm-3">
							<select class="form-control" name="cityCode" id="cityCode">
								<option value="-1">请选择市</option>
								<c:forEach items="${listCity}" var="city">
									<option value="${city.code }" <c:if test="${city.code==cityCode}">selected</c:if>>${city.name }</option>
								</c:forEach>
							</select>
							
						</div>
						<div class="col-sm-3">
							<select class="form-control" name="countyCode" id="countyCode">
								<option value="-1">请选择区或县</option>
								<c:forEach items="${listCounty}" var="county">
									<option value="${county.code }" <c:if test="${county.code==countyCode}">selected</c:if>>${county.name }</option>
								</c:forEach>
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
								<option value="1" <c:if test="${pageobj.isactive==1}">selected</c:if>>是</option>
								<option value="0" <c:if test="${pageobj.isactive==0}">selected</c:if>>否</option>
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
											maxlength="100" title="搜索词之间以逗号隔开" value="${pageobj.shopSearch}">
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
							<c:forEach var="obj" items="${pf}" varStatus="status">
							    <div id="floor_${status.index+1}"><div class="row"><label class="col-sm-1" >分类:</label><div class="col-sm-2">
							    <select class="form-control" name="class_${status.index+1}" id="class_${status.index+1}" style="width:100px">
									<option value="-1">选择分类</option>
										<c:forEach var="mc" items="${mclass}" varStatus="ind">
											<option <c:if test="${mc.classId==obj.pageCategory}">selected</c:if> value="${mc.classId}">${mc.className}</option>
										</c:forEach>
								</select></div>
								
								<label class="col-sm-1" style="margin-left:20px">名称：</label>
								<div class="col-sm-2"><input type="text" class="form-control" id="name_${status.index+1}"  name="name_${status.index+1}" value="${obj.floorname}"/></div>
								<label class="col-sm-1" >url：</label>
								<div class="col-sm-2"><input type="text" value="${obj.floorNameUrl}" class="form-control" id="nameurl_${status.index+1}"  name="nameurl_${status.index+1}" title="点击名称后跳转的链接地址"/></div>
								<label class="col-sm-2" >是否启用：</label>
								<div class="col-sm-1"><select class="form-control" id="isActive_${status.index+1}" name="isActive_${status.index+1}" style="width:65px">
										<option value="1"  <c:if test="${obj.isactive==1}">selected</c:if> >是</option>
										<option value="0" <c:if test="${obj.isactive==0}">selected</c:if> >否</option>
								</select></div>
								</div>
								
								<div class="row" id="product_${status.index+1}" style="margin-top:5px;">
										<c:forEach var="product" items="${obj.productList}" varStatus="pindex">
											<div class="col-sm-2"  style="margin-left:15px"><img src="${product.goodsImg180}" id="product_${status.index+1}_img_${pindex.index+1}"  onclick="addProduct2('${status.index+1}','${pindex.index+1}')" width="80"  height="80" alt="${product.goodsName}" title="${product.goodsName}"></img><input style="margin-left:20px" type="button" onclick="removeProduct('${status.index+1}','${pindex.index+1}');" value="删除"/><input value="${product.productid}" type="hidden" id="product_${status.index+1}_${pindex.index+1}" name="product_${status.index+1}_${pindex.index+1}"></input></div>
										</c:forEach>
										<button class="btn btn-info product" style="margin-left:10px;">再来一批</button><input type="hidden" name="product_${status.index+1}_Num" value="${fn:length(obj.productList)+1}"></input>
								</div><br/>
								
								<div class="row"><label class="col-sm-1" >分类标题图片：</label>
								<div class="col-sm-1" id="classdiv_${status.index+1}" ><img src="${obj.page1}"  alt="图片预览" id="showtitle_${status.index+1}" name="showtitle_${status.index+1}" width="80" height="50" style="margin-bottom:5px;margin-left:5px"/><input type="hidden" id="showtitleimg_${status.index+1}" name="showtitleimg_${status.index+1}" value="${obj.page1}" /></div>
								<div class="col-sm-3" style="margin-left:10px"><input type="file" class="color-control form-control" name="classtitle_${status.index+1}" id="classtitle_${status.index+1}"/></div>
								<label class="col-sm-1" style="margin-left:25px">url：</label>
								<input class="col-sm-2 " style="width:200px" type="text" id="titleurl_${status.index+1}" name="titleurl_${status.index+1}" value="${obj.pageImgUrl}"/>
								<br/>
								</div>
								
								
								<div class="row" id="recommand_${status.index+1}">
									<c:forEach var="product" items="${obj.recommandList}" varStatus="pindex">
										<div class="col-sm-2" style="margin-left:15px"><img src="${product.goodsImg180}" id="recommand_${status.index+1}_img_${pindex.index+1}" onclick="addRecommend2('${status.index+1}','${pindex.index+1}')" width="80" height="80" alt="${product.goodsName}" title="${product.goodsName}"></img>
										<input class="form-control" style="width:80px;margin-top:5px;" type="text" value="${product.nickname}" id="nickname_${status.index+1}_${pindex.index+1}" name="nickname_${status.index+1}_${pindex.index+1}" placeholder="显示文字"></input>
										<input type="button" style="margin-left:20px"  onclick="removeRecommd('${status.index+1}','${pindex.index+1}');" value="删除"/><input value="${product.productid}" type="hidden" id="recommand_${status.index+1}_${pindex.index+1}" name="recommand_${status.index+1}_${pindex.index+1}"></input></div>
									</c:forEach>
									<button class="btn btn-info recommand" style="margin-left:10px;">再来一批</button><input type="hidden" name="recommand_${status.index+1}_Num" value="${fn:length(obj.recommandList)+1}"></input>
	
								</div><br/>
								
								<input type="button" value="删除楼层" onclick="removeFloor('${status.index+1}')"/>
								<hr style="height:3px;border:none;border-top:3px double red;"/></div>
								
							</c:forEach>
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
	<script src="${jsBase}/shopPage/shopPageEdit.js" type="text/javascript"></script>
</body>
<script type="text/javascript">
	function pageInit(){
		// 店铺select初始化
		var countyCode = "${countyCode}";
		var shopCode = "${pageobj.shopId}";
		if(countyCode != "" && countyCode !="null"){
			getshoplist(countyCode,shopCode);
		}
		// banner区域
		<c:forEach items="${blist}" var="banner">
			bannerIndex++;
		    bannerArray.push(bannerIndex);
		    var bannerStr = "";
			var bannerStr = "<div class=\"row\" id=\"bannerIndex_" + bannerIndex + "\"><div class=\"col-sm-3\"><div class=\"form-group\"><input type=\"file\" name=\"file_"+ bannerIndex + "\" id=\"file_"+ bannerIndex + "\" class=\"color-control form-control\" /></div></div><div class=\"col-sm-2\" style=\"margin-left:70px\"><div class=\"form-group\" id=\"div_"+ bannerIndex + "\"><img src=\"${banner.orgShopBanner}\" alt=\"图片预览\" id=\"showimg_"+ bannerIndex + "\" name=\"showimg_" + bannerIndex + "\" height=\"40\" width=\"65\" ></img><input type=\"hidden\" id = \"showimg_" + bannerIndex + "_\" name=\"showimg_" + bannerIndex + "_\" value=\"${banner.orgShopBanner}\"/></div></div><div class=\"col-sm-1\" ><div class=\"form-group\"><input type=\"text\" id=\"url_"+ bannerIndex + "\"  name =\"url_" + bannerIndex + "\" value=\"${banner.orgShopBannerUrl}\" title=\"输入链接地址,例如http://www.kjjhome.com/\"/></div></div><div class=\"col-sm-3\" style=\"margin-left:120px\"><button type=\"button\" title=\"点击删除banner\" class=\"btn \" onclick=\"removeItem(\'"+ bannerIndex + "\');\" style=\"background:none;\"><i class=\"glyphicon glyphicon-remove-circle\"></i></button><span class=\"glyphicon glyphicon-arrow-up control\"></span><span class=\"glyphicon glyphicon-arrow-down control\"></span></div></div>";
			$("#bannerArea").append(bannerStr);
			new uploadPreview({ UpBtn: "file_"+bannerIndex, DivShow: "div_"+bannerIndex, ImgShow: "showimg_"+bannerIndex });						
		</c:forEach>
		// 宣传商品
		<c:forEach items="${rlist}" var="recommand">
			showProductIndex++;
			showProductArray.push(showProductIndex);
			var showProductStr = "";
			showProductStr = "<div class=\"row\" id=\"showProductIndex_" + showProductIndex + "\"><input type=\"hidden\" id=\"rec_"+ showProductIndex +"\" name=\"rec_"+ showProductIndex +"\" value=\"${recommand.id}\"><div class=\"col-sm-3\"> <div class=\"form-group\"> <input type=\"file\" name=\"f_" + showProductIndex + "\" id=\"f_" + showProductIndex + "\" class=\"color-control form-control\" /> </div> </div> <div class=\"col-sm-1\" style=\"margin-left:60px\"> <div class=\"form-group\" id=\"d_" + showProductIndex + "\"> <img src=\"${recommand.recommandImg1}\" alt=\"图片预览\" id=\"show_" + showProductIndex + "\" name=\"show_" + showProductIndex + "\" height=\"40\" width=\"65\"></img><input type=\"hidden\" id=\"image_" + showProductIndex + "\" name=\"image_" + showProductIndex + "\" value=\"${recommand.recommandImg1}\"/></div></div><div class=\"col-sm-3\"> <div class=\"form-group\"> <input type=\"file\" name=\"f_" + showProductIndex + "_\" id=\"f_" + showProductIndex + "_\" class=\"color-control form-control\" /> </div> </div> <div class=\"col-sm-1\" style=\"margin-left:60px\"> <div class=\"form-group\" id=\"d_1_\"> <img src=\"${recommand.recommandImg2}\" alt=\"图片预览\" id=\"show_" + showProductIndex + "_\" name=\"show_" + showProductIndex + "_\" height=\"40\" width=\"65\"></img><input type=\"hidden\" id=\"image_" + showProductIndex + "_\" name=\"image_" + showProductIndex + "_\" value=\"${recommand.recommandImg2}\"/></div></div><div class=\"col-sm-1\"> <div class=\"form-group\"> <input type=\"text\" id=\"u_" + showProductIndex + "\" style=\"width:90px;\" name =\"u_" + showProductIndex + "\" value=\"${recommand.recommendImgUrl}\" title=\"输入链接地址,例如http://www.kjjhome.com/\"/> </div></div><div class=\"col-sm-1\"> <button type=\"button\"  title=\"点击删除宣传商品\"  class=\"btn\" onclick=\"removeShowProduct(\'" + showProductIndex + "\');\" style=\"background:none;\"><i class=\"glyphicon glyphicon-remove-circle\"></i></button> </div> </div>";
			$("#showProductArea").append(showProductStr);
			new uploadPreview({ UpBtn: "f_" + showProductIndex, DivShow: "d_" + showProductIndex, ImgShow: "show_" + showProductIndex });
			new uploadPreview({ UpBtn: "f_" + showProductIndex+"_", DivShow: "d_" + showProductIndex+"_", ImgShow: "show_" + showProductIndex+"_" });
		</c:forEach>
		// 楼层
		<c:forEach var="obj" items="${pf}" varStatus="status">
			floorIndex++;
			floorArray.push(floorIndex);
			new uploadPreview({ UpBtn: "classtitle_"+floorIndex, DivShow: "classdiv_"+floorIndex, ImgShow: "showtitle_"+floorIndex });
		</c:forEach>
	}
	pageInit();
</script>
</html>
