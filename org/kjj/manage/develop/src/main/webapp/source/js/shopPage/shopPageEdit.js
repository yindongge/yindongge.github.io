$(function () {
	moveBanner();
	//区域省下拉列表选择变更
	$("#provinceCode").change(function(){
		if($('#provinceCode').val() == -1){
			$('#cityCode').empty();
          	$('#cityCode').append("<option value='-1'>请选择市</option>");
		}else{
			$.ajax({
	            type: "POST",
	            dataType: "json",
	            url: "../area/getByParentCode",
	            data: {'parentCode':$('#provinceCode').val()},
	            success: function (data) {
	           	 $('#cityCode').empty();
	           	 $('#cityCode').append("<option value='-1'>请选择市</option>");
	                $.each(data.listArea,function(idx, obj){
	               	 $('#cityCode').append("<option value=\""+obj.code+"\">"+obj.name+"</option>");
	                }); 
	            },
	            error: function(data) {
	            }
	        });
		}
		$('#countyCode').empty();
      	$('#countyCode').append("<option value='-1'>请选择区或县</option>");
      	$('#shop_id').empty();
      	$('#shop_id').append("<option value='-1'>请选择门店</option>");
	});
	
	//区域市下拉列表选择变更
	$("#cityCode").change(function(){
		if($('#cityCode').val() == -1){
          	$('#countyCode').empty();
          	$('#countyCode').append("<option value='-1'>请选择区或县</option>");
		}else{
			$.ajax({
	            type: "POST",
	            dataType: "json",
	            url: "../area/getByParentCode",
	            data: {'parentCode':$('#cityCode').val()},
	            success: function (data) {
	            	$('#countyCode').empty();
	           	 	$('#countyCode').append("<option value='-1'>请选择区或县</option>");
	           	 	$.each(data.listArea,function(idx, obj){
                	$('#countyCode').append("<option value=\""+obj.code+"\">"+obj.name+"</option>");
                 }); 
	            },
	            error: function(data) {
	            }
	        });
		}
		$('#shop_id').empty();
      	$('#shop_id').append("<option value='-1'>请选择门店</option>");
	});
	
	//区域县下拉列表选择变更
	$("#countyCode").change(function(){
		if($('#countyCode').val() == -1){
			$('#shop_id').empty();
	      	$('#shop_id').append("<option value='-1'>请选择门店</option>");
		}else{
			getshoplist($('#countyCode').val(),'');
		}
	});
	addFloorPic();
});
/*
 * 店铺门店Ajax加载
 */
function getshoplist(areaCode,curShop){
	$.ajax({
        type: "POST",
        dataType: "json",
        url: "../shop/shopSelect",
        data: {'areaCode':areaCode},
        success: function (data) {
        	$('#shop_id').empty();
          	$('#shop_id').append("<option value='-1'>请选择门店</option>");
            $.each(data.listShop,function(idx, obj){
            	if(curShop==obj.shopId){
            		$('#shop_id').append("<option value=\""+obj.shopId+"\" selected>"+obj.shopName+"</option>");
            	} else {
            		$('#shop_id').append("<option value=\""+obj.shopId+"\">"+obj.shopName+"</option>");
            	}
            }); 
        },
        error: function(data) {
        }
    });
}
var bannerArray = []; // banner数组
var bannerIndex = 0; // banner索引



function addBanner(){
	bannerIndex++;
	bannerArray.push(bannerIndex);
	var bannerStr = "";
	//bannerStr = "<div class=\"row\" id=\"bannerIndex_" + bannerIndex + "\"><div class=\"col-sm-3\"><div class=\"form-group\"><input type=\"file\" name=\"file_"+ bannerIndex + "\" id=\"file_"+ bannerIndex + "\" class=\"color-control form-control\" /></div></div><div class=\"col-sm-2\" style=\"margin-left:70px\"><div class=\"form-group\" id=\"div_"+ bannerIndex + "\"><img src=\"\" alt=\"图片预览\" id=\"showimg_"+ bannerIndex + "\" name=\"showimg_" + bannerIndex + "\" height=\"40\" width=\"65\" ></img></div></div><div class=\"col-sm-1\" ><div class=\"form-group\"><input type=\"text\" id=\"url_"+ bannerIndex + "\"  name =\"url_" + bannerIndex + "\" value=\"\" title=\"输入链接地址,例如http://www.kjjhome.com/\"/></div></div><div class=\"col-sm-2\" style=\"margin-left:120px\"><button type=\"button\" title=\"点击删除banner\" class=\"btn \" onclick=\"removeItem(\'"+ bannerIndex + "\');\" style=\"background:none;\"><i class=\"glyphicon glyphicon-remove-circle\"></i></button></div></div>";
	bannerStr = "<div class=\"row\" id=\"bannerIndex_" + bannerIndex + "\"><div class=\"col-sm-3\"><div class=\"form-group\"><input type=\"file\" name=\"file_"+ bannerIndex + "\" id=\"file_"+ bannerIndex + "\" class=\"color-control form-control\" /></div></div><div class=\"col-sm-2\" style=\"margin-left:70px\"><div class=\"form-group\" id=\"div_"+ bannerIndex + "\"><img src=\"\" alt=\"图片预览\" id=\"showimg_"+ bannerIndex + "\" name=\"showimg_" + bannerIndex + "\" height=\"40\" width=\"65\" ></img><input type=\"hidden\" id = \"showimg_" + bannerIndex + "_\" name=\"showimg_" + bannerIndex + "_\" value=\"\"/></div></div><div class=\"col-sm-1\" ><div class=\"form-group\"><input type=\"text\" id=\"url_"+ bannerIndex + "\"  name =\"url_" + bannerIndex + "\" value=\"\" title=\"输入链接地址,例如http://www.kjjhome.com/\"/></div></div><div class=\"col-sm-3\" style=\"margin-left:120px\"><button type=\"button\" title=\"点击删除banner\" class=\"btn \" onclick=\"removeItem(\'"+ bannerIndex + "\');\" style=\"background:none;\"><i class=\"glyphicon glyphicon-remove-circle\"></i></button><span class=\"glyphicon glyphicon-arrow-up control\"></span><span class=\"glyphicon glyphicon-arrow-down control\"></span></div></div>";
	$("#bannerArea").append(bannerStr);
	moveBanner();
	new uploadPreview({ UpBtn: "file_"+bannerIndex, DivShow: "div_"+bannerIndex, ImgShow: "showimg_"+bannerIndex });
}
function removeItem(index){
	if(!confirm("该删除为数据库删除，无法恢复，确定要删除？")){
		return;
	}
	for(var i = 0; i < bannerArray.length;i++){
		if(bannerArray[i]==index){
			bannerArray.splice(i,1);
			break;
		}
	}
	var imgPath = $("#showimg_"+index+"_").val();
	var baseUrl = $('#ImageBasePath').val();
	if(imgPath.indexOf(baseUrl) != -1){
		 imgPath = imgPath.substr(baseUrl.length);
	}
	// 数据库删除banner
	$.ajax({
        type: "POST",
        dataType: "json",
        url: "../shopPage/deleteBanner?imgPath="+imgPath,
        async:false, 
        success: function (data) {
        	$("#bannerIndex_" + index).remove();
        },
        error: function(data) {
        	
        }
    });
	
	
}

var showProductArray = []; // 宣传产品数组
var showProductIndex = 0; // 宣传产品索引

function addShowProduct(){
	showProductIndex++;
	showProductArray.push(showProductIndex);
	var showProductStr = "";
	showProductStr = "<div class=\"row\" id=\"showProductIndex_" + showProductIndex + "\"><input type=\"hidden\" id=\"rec_"+ showProductIndex +"\" name=\"rec_"+ showProductIndex +"\" value=\"\"></input><div class=\"col-sm-3\"> <div class=\"form-group\"> <input type=\"file\" name=\"f_" + showProductIndex + "\" id=\"f_" + showProductIndex + "\" class=\"color-control form-control\" /> </div> </div> <div class=\"col-sm-1\" style=\"margin-left:60px\"> <div class=\"form-group\" id=\"d_" + showProductIndex + "\"> <img src=\"\" alt=\"图片预览\" id=\"show_" + showProductIndex + "\" name=\"show_" + showProductIndex + "\" height=\"40\" width=\"65\"></img><input type=\"hidden\" id=\"image_" + showProductIndex + "\" name=\"image_" + showProductIndex + "\" value=\"\"/></div></div><div class=\"col-sm-3\"> <div class=\"form-group\"> <input type=\"file\" name=\"f_" + showProductIndex + "_\" id=\"f_" + showProductIndex + "_\" class=\"color-control form-control\" /> </div> </div> <div class=\"col-sm-1\" style=\"margin-left:60px\"> <div class=\"form-group\" id=\"d_1_\"> <img src=\"\" alt=\"图片预览\" id=\"show_" + showProductIndex + "_\" name=\"show_" + showProductIndex + "_\" height=\"40\" width=\"65\"></img><input type=\"hidden\" id=\"image_" + showProductIndex + "_\" name=\"image_" + showProductIndex + "_\" value=\"\"/></div></div><div class=\"col-sm-1\"> <div class=\"form-group\"> <input type=\"text\" id=\"u_" + showProductIndex + "\" style=\"width:90px;\" name =\"u_" + showProductIndex + "\" value=\"\" title=\"输入链接地址,例如http://www.kjjhome.com/\"/> </div></div><div class=\"col-sm-1\"> <button type=\"button\"  title=\"点击删除宣传商品\"  class=\"btn\" onclick=\"removeShowProduct(\'" + showProductIndex + "\');\" style=\"background:none;\"><i class=\"glyphicon glyphicon-remove-circle\"></i></button> </div> </div>";
	$("#showProductArea").append(showProductStr);
	new uploadPreview({ UpBtn: "f_" + showProductIndex, DivShow: "d_" + showProductIndex, ImgShow: "show_" + showProductIndex });
	new uploadPreview({ UpBtn: "f_" + showProductIndex+"_", DivShow: "d_" + showProductIndex+"_", ImgShow: "show_" + showProductIndex+"_" });
}
function removeShowProduct(index){
	if(!confirm("该删除为数据库删除，无法恢复，确定要删除？")){
		return;
	}
	for(var i = 0; i < showProductArray.length;i++){
		if(showProductArray[i]==index){
			showProductArray.splice(i,1);
			break;
		}
	}
	var imgPath = $("#image_"+index).val();
	var baseUrl = $('#ImageBasePath').val();
	if(imgPath.indexOf(baseUrl) != -1){
		 imgPath = imgPath.substr(baseUrl.length);
	}
	// 数据库删除宣传商品
	$.ajax({
        type: "POST",
        dataType: "json",
        url: "../shopPage/deleteRecommand?imgPath="+imgPath,
        async:false, 
        success: function (data) {
        	$("#showProductIndex_" + index).remove();
        },
        error: function(data) {
        	
        }
    });
}

var floorArray = []; // 楼层数组
var floorIndex = 0;  // 楼层索引

var SHOP_CLASS_STR = "";
//最大楼层数为8
function addFloor(){

	
	if(floorArray.length >= 8){
		alert("楼层已经达到8个，不能增加楼层!");
	}
	floorIndex++;
	floorArray.push(floorIndex);
	var fid = floorIndex;
	var htmlstr="<div id=\"floor_"+fid+"\"><div class=\"row\"><label class=\"col-sm-1\" >分类：</label><div class=\"col-sm-2\"><select style=\"width:100px\" class=\"form-control\" name=\"class_"+fid+"\" id=\"class_"+fid+"\">";

	htmlstr+="<option value='-1'>选择分类</option>";
	
	if(SHOP_CLASS_STR==""){
		SHOP_CLASS_STR = createShopClassSelect();
	}
	
	htmlstr += SHOP_CLASS_STR;

	
	htmlstr+="</select></div>";
	htmlstr+="<label class=\"col-sm-1\" style=\"margin-left:20px\">名称：</label>";
	htmlstr+="<div class=\"col-sm-2\"><input type=\"text\" class=\"form-control\" id=\"name_"+fid+"\"  name=\"name_"+fid+"\"/></div>";
	htmlstr+="<label class=\"col-sm-1\" >url：</label>";
	htmlstr+="<div class=\"col-sm-2\"><input type=\"text\" class=\"form-control\" id=\"nameurl_"+fid+"\"  name=\"nameurl_"+fid+"\" title=\"点击名称后跳转的链接地址\"/></div>";
	htmlstr+="<label class=\"col-sm-2\" >是否启用：</label>";
	htmlstr+="<div class=\"col-sm-1\"><select class=\"form-control\"  style=\"width:65px\" id=\"isActive_"+fid+"\" name=\"isActive_"+fid+"\"><option value=\"1\">是</option><option value=\"0\">否</option></select></div>";
	htmlstr+="</div>";
	
	htmlstr+="<div class=\"row\" id=\"product_"+fid+"\" style=\"margin-top:5px;\">";
	
	htmlstr+="<div class=\"col-sm-1\" style=\"margin-left:15px\"><img src=\"\" id=\"product_" + fid + "_img_1\" onclick=\"addProduct2(\'" + fid + "\',\'1\')\" width=\"80\"  height=\"80\" alt=\"点击选择商品\"></img><input type=\"button\" style=\"margin-left:20px\" onclick=\"removeProduct(\'"+fid+"\',\'1\')\" value=\"删除\"/><input type=\"hidden\" id=\"product_"+fid+"_1\" name=\"product_"+fid+"_1\"></input></div>";
	htmlstr+="<div class=\"col-sm-1\" style=\"margin-left:15px\"><img src=\"\" id=\"product_" + fid + "_img_2\" onclick=\"addProduct2(\'" + fid + "\',\'2\')\"  width=\"80\"  height=\"80\" alt=\"点击选择商品\"></img><input type=\"button\" style=\"margin-left:20px\" onclick=\"removeProduct(\'"+fid+"\',\'2\')\" value=\"删除\"/><input type=\"hidden\" id=\"product_"+fid+"_2\" name=\"product_"+fid+"_2\"></input></div>";
	htmlstr+="<div class=\"col-sm-1\" style=\"margin-left:15px\"><img src=\"\" id=\"product_" + fid + "_img_3\" width=\"80\" onclick=\"addProduct2(\'" + fid + "\',\'3\')\"   height=\"80\" alt=\"点击选择商品\"></img><input type=\"button\" style=\"margin-left:20px\" onclick=\"removeProduct(\'"+fid+"\',\'3\')\" value=\"删除\"/><input type=\"hidden\" id=\"product_"+fid+"_3\" name=\"product_"+fid+"_3\"></input></div>";
	htmlstr+="<div class=\"col-sm-1\" style=\"margin-left:15px\"><img src=\"\" id=\"product_" + fid + "_img_4\" width=\"80\" onclick=\"addProduct2(\'" + fid + "\',\'4\')\"   height=\"80\" alt=\"点击选择商品\"></img><input type=\"button\" style=\"margin-left:20px\" onclick=\"removeProduct(\'"+fid+"\',\'4\')\" value=\"删除\"/><input type=\"hidden\" id=\"product_"+fid+"_4\" name=\"product_"+fid+"_4\"></input></div>";
	htmlstr+="<div class=\"col-sm-1\" style=\"margin-left:15px\"><img src=\"\" id=\"product_" + fid + "_img_5\" width=\"80\" onclick=\"addProduct2(\'" + fid + "\',\'5\')\"   height=\"80\" alt=\"点击选择商品\"></img><input type=\"button\" style=\"margin-left:20px\" onclick=\"removeProduct(\'"+fid+"\',\'5\')\" value=\"删除\"/><input type=\"hidden\" id=\"product_"+fid+"_5\" name=\"product_"+fid+"_5\"></input></div>";
	htmlstr+="<div class=\"col-sm-1\" style=\"margin-left:15px\"><img src=\"\" id=\"product_" + fid + "_img_6\" width=\"80\" onclick=\"addProduct2(\'" + fid + "\',\'6\')\"   height=\"80\" alt=\"点击选择商品\"></img><input type=\"button\" style=\"margin-left:20px\" onclick=\"removeProduct(\'"+fid+"\',\'6\')\" value=\"删除\"/><input type=\"hidden\" id=\"product_"+fid+"_6\" name=\"product_"+fid+"_6\"></input></div>";
	htmlstr+="<div class=\"col-sm-1\" style=\"margin-left:15px\"><img src=\"\" id=\"product_" + fid + "_img_7\" width=\"80\" onclick=\"addProduct2(\'" + fid + "\',\'7\')\"   height=\"80\" alt=\"点击选择商品\"></img><input type=\"button\" style=\"margin-left:20px\" onclick=\"removeProduct(\'"+fid+"\',\'7\')\" value=\"删除\"/><input type=\"hidden\" id=\"product_"+fid+"_7\" name=\"product_"+fid+"_7\"></input></div>";
	htmlstr+="<div class=\"col-sm-1\" style=\"margin-left:15px\"><img src=\"\" id=\"product_" + fid + "_img_8\" width=\"80\" onclick=\"addProduct2(\'" + fid + "\',\'8\')\"   height=\"80\" alt=\"点击选择商品\"></img><input type=\"button\" style=\"margin-left:20px\" onclick=\"removeProduct(\'"+fid+"\',\'8\')\" value=\"删除\"/><input type=\"hidden\" id=\"product_"+fid+"_8\" name=\"product_"+fid+"_8\"></input></div>";
	
	
	htmlstr+="<button class=\"btn btn-info product\" style=\"margin-left:10px;\">再来一批</button><input type=\"hidden\" name=\"product_"+fid+"_Num\" value=\"9\">";
	//定长 8 个产品

	htmlstr+="</div><br/>";
	
	//添加分类图片
	
	htmlstr+="<div class=\"row\"><label class=\"col-sm-1\" >分类标题图片：</label>";
	
	htmlstr+="<div class=\"col-sm-1\" id=\"classdiv_"+fid+"\" ><img src=\"\" alt=\"图片预览\" id=\"showtitle_"+fid+"\" name=\"showtitle_"+fid+"\" width=\"80\" height=\"50\" style=\"margin-bottom:5px;margin-left:5px\"></div>";
	htmlstr+="<div class=\"col-sm-3\"  style=\"margin-left:10px\"><input class=\"color-control form-control\" type=\"file\" name=\"classtitle_"+fid+"\" id=\"classtitle_"+fid+"\"/></div>";
	htmlstr+="<label class=\"col-sm-1\" style=\"margin-left:20px\">url：</label>";
	htmlstr+="<input class=\"col-sm-2\" style=\"width:200px\" type=\"text\" id=\"titleurl_"+fid+"\" name=\"titleurl_"+fid+"\"/>";
	
	htmlstr+="<br/>";
	htmlstr+="</div>";
	
	//添加推荐产品 每个楼层的
	
	htmlstr+="<div class=\"row\" id=\"recommand_"+fid+"\">";
	
	htmlstr+="<div class=\"col-sm-1\" style=\"margin-left:15px\"><img src=\"\" id=\"recommand_" + fid + "_img_1\" onclick=\"addRecommend2(\'" + fid + "\',\'1\')\" width=\"80\"  height=\"80\" alt=\"点击选择推荐商品\"></img><input class=\"form-control\" style=\"width:80px;margin-top:5px;\"  type=\"text\" id=\"nickname_"+fid+"_1\" name=\"nickname_"+fid+"_1\" placeholder=\"显示文字\"></input><input type=\"button\" style=\"margin-left:20px\" onclick=\"removeRecommd(\'"+fid+"\',\'1\')\" value=\"删除\"/><input type=\"hidden\" id=\"recommand_"+fid+"_1\" name=\"recommand_"+fid+"_1\"></input></div>";
	htmlstr+="<div class=\"col-sm-1\" style=\"margin-left:15px\"><img src=\"\" id=\"recommand_" + fid + "_img_2\" onclick=\"addRecommend2(\'" + fid + "\',\'2\')\" width=\"80\"  height=\"80\" alt=\"点击选择推荐商品\"></img><input class=\"form-control\" style=\"width:80px;margin-top:5px;\"  type=\"text\" id=\"nickname_"+fid+"_2\" name=\"nickname_"+fid+"_2\" placeholder=\"显示文字\"></input><input type=\"button\" style=\"margin-left:20px\" onclick=\"removeRecommd(\'"+fid+"\',\'2\')\" value=\"删除\"/><input type=\"hidden\" id=\"recommand_"+fid+"_2\" name=\"recommand_"+fid+"_2\"></input></div>";
	htmlstr+="<div class=\"col-sm-1\" style=\"margin-left:15px\"><img src=\"\" id=\"recommand_" + fid + "_img_3\" onclick=\"addRecommend2(\'" + fid + "\',\'3\')\" width=\"80\"  height=\"80\" alt=\"点击选择推荐商品\"></img><input class=\"form-control\" style=\"width:80px;margin-top:5px;\"  type=\"text\" id=\"nickname_"+fid+"_3\" name=\"nickname_"+fid+"_3\" placeholder=\"显示文字\"></input><input type=\"button\" style=\"margin-left:20px\" onclick=\"removeRecommd(\'"+fid+"\',\'3\')\" value=\"删除\"/><input type=\"hidden\" id=\"recommand_"+fid+"_3\" name=\"recommand_"+fid+"_3\"></input></div>";
	htmlstr+="<div class=\"col-sm-1\" style=\"margin-left:15px\"><img src=\"\" id=\"recommand_" + fid + "_img_4\" onclick=\"addRecommend2(\'" + fid + "\',\'4\')\" width=\"80\"  height=\"80\" alt=\"点击选择推荐商品\"></img><input class=\"form-control\" style=\"width:80px;margin-top:5px;\"  type=\"text\" id=\"nickname_"+fid+"_4\" name=\"nickname_"+fid+"_4\" placeholder=\"显示文字\"></input><input type=\"button\" style=\"margin-left:20px\" onclick=\"removeRecommd(\'"+fid+"\',\'4\')\" value=\"删除\"/><input type=\"hidden\" id=\"recommand_"+fid+"_4\" name=\"recommand_"+fid+"_4\"></input></div>";
	htmlstr+="<div class=\"col-sm-1\" style=\"margin-left:15px\"><img src=\"\" id=\"recommand_" + fid + "_img_5\" onclick=\"addRecommend2(\'" + fid + "\',\'5\')\" width=\"80\"  height=\"80\" alt=\"点击选择推荐商品\"></img><input class=\"form-control\" style=\"width:80px;margin-top:5px;\"  type=\"text\" id=\"nickname_"+fid+"_5\" name=\"nickname_"+fid+"_5\" placeholder=\"显示文字\"></input><input type=\"button\" style=\"margin-left:20px\" onclick=\"removeRecommd(\'"+fid+"\',\'5\')\" value=\"删除\"/><input type=\"hidden\" id=\"recommand_"+fid+"_5\" name=\"recommand_"+fid+"_5\"></input></div>";
	htmlstr+="<div class=\"col-sm-1\" style=\"margin-left:15px\"><img src=\"\" id=\"recommand_" + fid + "_img_6\" onclick=\"addRecommend2(\'" + fid + "\',\'6\')\" width=\"80\"  height=\"80\" alt=\"点击选择推荐商品\"></img><input class=\"form-control\" style=\"width:80px;margin-top:5px;\"  type=\"text\" id=\"nickname_"+fid+"_6\" name=\"nickname_"+fid+"_6\" placeholder=\"显示文字\"></input><input type=\"button\" style=\"margin-left:20px\" onclick=\"removeRecommd(\'"+fid+"\',\'6\')\" value=\"删除\"/><input type=\"hidden\" id=\"recommand_"+fid+"_6\" name=\"recommand_"+fid+"_6\"></input></div>";
	htmlstr+="<div class=\"col-sm-1\" style=\"margin-left:15px\"><img src=\"\" id=\"recommand_" + fid + "_img_7\" onclick=\"addRecommend2(\'" + fid + "\',\'7\')\" width=\"80\"  height=\"80\" alt=\"点击选择推荐商品\"></img><input class=\"form-control\" style=\"width:80px;margin-top:5px;\"  type=\"text\" id=\"nickname_"+fid+"_7\" name=\"nickname_"+fid+"_7\" placeholder=\"显示文字\"></input><input type=\"button\" style=\"margin-left:20px\" onclick=\"removeRecommd(\'"+fid+"\',\'7\')\" value=\"删除\"/><input type=\"hidden\" id=\"recommand_"+fid+"_7\" name=\"recommand_"+fid+"_7\"></input></div>";
	htmlstr+="<div class=\"col-sm-1\" style=\"margin-left:15px\"><img src=\"\" id=\"recommand_" + fid + "_img_8\" onclick=\"addRecommend2(\'" + fid + "\',\'8\')\" width=\"80\"  height=\"80\" alt=\"点击选择推荐商品\"></img><input class=\"form-control\" style=\"width:80px;margin-top:5px;\"  type=\"text\" id=\"nickname_"+fid+"_8\" name=\"nickname_"+fid+"_8\" placeholder=\"显示文字\"></input><input type=\"button\" style=\"margin-left:20px\" onclick=\"removeRecommd(\'"+fid+"\',\'8\')\" value=\"删除\"/><input type=\"hidden\" id=\"recommand_"+fid+"_8\" name=\"recommand_"+fid+"_8\"></input></div>";

	htmlstr+="<button class=\"btn btn-info recommand\" style=\"margin-left:10px;\">再来一批</button><input type=\"hidden\" name=\"recommand_"+fid+"_Num\" value=\"9\">";
	
	//定长 8 个产品

	htmlstr+="</div><br/>";
	
	
	htmlstr+="<input type=\"button\" value=\"删除楼层\" onclick=\"removeFloor('"+fid+"')\"/>";

	
	htmlstr+="<hr style=\"height:3px;border:none;border-top:3px double red;\"/></div>";
	
	$("#floorArea").append(htmlstr);
	
	new uploadPreview({ UpBtn: "classtitle_"+fid, DivShow: "classdiv_"+fid, ImgShow: "showtitle_"+fid });

	addFloorPic();
	
}

function removeFloor(index){
	if(!confirm("确定要删除？")){
		return;
	}
	for(var i = 0; i < floorArray.length;i++){
		if(floorArray[i]==index){
			floorArray.splice(i,1);
			break;
		}
	}
	$("#floor_"+index).remove();
}

function createShopClassSelect(){
	var htmlstr = "";
	$.ajax({
        type: "POST",
        dataType: "json",
        url: "../shopPage/shopClass",
        async:false, 
        success: function (data) {
            $.each(data.list,function(idx, obj){
           		htmlstr+="<option value=\""+obj.classId+"\">"+obj.className+"</option>";
            });
        },
        error: function(data) {
        	
        }
    });
	return htmlstr;
}
var CURRENT_FLOOR = ""; // 当前floor
var CURRENT_USE_PRODUCT = ""; // 1：商品，2：推荐商品

var CURRENT_IMG_INDEX = ""; // 图片索引
function addProduct2(fid,index){
	//验证是否选取分类,添加产品前要选择分类
	if($("#class_"+fid).val()==-1){
		alert("请选择分类！");return false;
	}
	//iframe层
	CURRENT_FLOOR = fid;
	CURRENT_IMG_INDEX = index;
	CURRENT_USE_PRODUCT = "1"; 
	layer.open({
		    type: 2,
		    title: '选择商品',
		    shadeClose: true,
		    shade: 0.8,
			maxmin: true, //开启最大化最小化按钮
		    area: ['850px', '540px'],
		    content: '../levelprice/productSelect?catId='+$("#class_"+fid).val()+"&classLock="+$("#class_"+fid).val()
	}); 

}
/**
 * 选择商品的回调函数
 * @param goodsId
 * @param goodsName
 * @param imageUrl
 */
function selectProductCallBack(goodsId,goodsName,imageUrl){
	var floorid = CURRENT_FLOOR;
	if(CURRENT_USE_PRODUCT=="1"){
		$("#product_"+floorid+"_img_" + CURRENT_IMG_INDEX).attr("src",imageUrl);
		$("#product_"+floorid+"_"+CURRENT_IMG_INDEX).val(goodsId);
		$("#product_"+floorid+"_img_" + CURRENT_IMG_INDEX).attr("title",goodsName);
	}
	if(CURRENT_USE_PRODUCT=="2"){
		$("#recommand_"+floorid+"_img_" + CURRENT_IMG_INDEX).attr("src",imageUrl);
		$("#recommand_"+floorid+"_"+CURRENT_IMG_INDEX).val(goodsId);
		$("#recommand_"+floorid+"_img_" + CURRENT_IMG_INDEX).attr("title",goodsName);
	}
}
/**
 * 删除商品
 * @param fid
 * @param index
 */
function removeProduct(fid,index){
	if($("#product_"+fid+"_"+index).val()==""){
		alert("请先选择商品!");
		return;
	}
	if(!confirm("确定要删除？")){
		return;
	}
	$("#product_"+fid+"_img_" + index).attr("src","");
	$("#product_"+fid+"_"+index).val("");
	$("#product_"+fid+"_img_" + index).attr("alt","点击选择商品");
}
/**
 * 删除推荐商品
 * @param fid
 * @param index
 */
function removeRecommd(fid,index){
	if($("#recommand_"+fid+"_"+index).val()==""){
		alert("请先选择商品!");
		return;
	}
	if(!confirm("确定要删除？")){
		return;
	}
	$("#recommand_"+fid+"_img_" + index).attr("src","");
	$("#recommand_"+fid+"_"+index).val("");
	$("#recommand_"+fid+"_img_" + index).attr("alt","点击选择推荐商品");
	$("#nickname_"+fid+"_" + index).val("");
	
}
/**
 * 添加推荐商品
 * @param fid
 * @param index
 * @returns {Boolean}
 */
function addRecommend2(fid,index){
	//验证是否选取分类,添加产品前要选择分类
	if($("#class_"+fid).val()==-1){
		alert("请选择分类！");return false;
	}
	
	CURRENT_FLOOR = fid;
	CURRENT_IMG_INDEX = index;
	CURRENT_USE_PRODUCT = "2"; // 1：商品，2：推荐商品
	layer.open({
		    type: 2,
		    title: '选择商品',
		    shadeClose: true,
		    shade: 0.8,
			maxmin: true, //开启最大化最小化按钮
		    area: ['850px', '540px'],
		    content: '../levelprice/productSelect?catId='+$("#class_"+fid).val()+"&classLock="+$("#class_"+fid).val()
	}); 
}
var shopType = "";
function savedata(){
//	if($("#provinceCode").val()==-1){
//		alert("请选择区域！"); 
//		return;
//	}
	// 验证，一个区域或者店铺，只允许有一个店铺首页
	var shopId = "";
	if($("#shop_id").val()!=-1){
		shopId = $("#shop_id").val();
		shopType = "1";
		validateForm(shopId);
	} else {
		shopType = "0";
		if($("#countyCode").val()!=-1){
			shopId = $("#countyCode").val();
			validateForm(shopId);
		} else {
			if($("#cityCode").val()!=-1){
				shopId = $("#cityCode").val();
				validateForm(shopId);
			} else {
				if($("#provinceCode").val()!=-1){
					shopId = $("#provinceCode").val();
					validateForm(shopId);
				} else {
					shopId = "-1";
					validateForm(shopId);
				}
			}
		}
	}
}
function validateForm(shopId){
	$.ajax({
		type : "POST",
		dataType : "json",
		url : "../shopPage/pageIsOnly?shopId=" + shopId + "&id="+$("#id").val(),
		data : "",
		success : function(data) {
			if (data.code == 200) {
				// 提交表单
				/*$("#shopPageform").ajaxSubmit({
			        type:'post',
			        url:'../shopPage/savePage',
			        dataType: "json",
			        success:function(data){
			        	window.location.href="../shopPage/list";
			        },
			        error:function(XmlHttpRequest,textStatus,errorThrown){
			        	window.location.href="../shopPage/list";
			        }
			    });*/
				// 处理图片路径问题
				 $(":input[type=hidden]").each(function(){
					 var baseUrl = $('#ImageBasePath').val();
					 if(this.value!=''){
						 if(this.value != baseUrl && this.value.indexOf(baseUrl) != -1){
							 this.value = this.value.substr(baseUrl.length);
						 }
					 }
				});
				$("#shopId").val(shopId);
				$("#type").val(shopType);
				$("#floorNumbers").val(floorArray.join(","));
				$("#bannerIndexs").val(bannerArray.join(","));
				$("#recommandIndexs").val(showProductArray.join(","));
				$("#shopPageform").submit();
			} else {
				alert("相同的区域或店铺首页已经存在，请确认后再添加!");  
			}
		},
		error : function(data) {
			alert("操作失败，请联系管理员或技术人员!");  
		}
	});
}
function cancle(){
	window.location.href="../shopPage/list";
}

function moveBanner(){
	//banner 上下移动
	$('.glyphicon.glyphicon-arrow-up.control').off('click');
	$('.glyphicon.glyphicon-arrow-down.control').off('click');
	$('.glyphicon.glyphicon-arrow-up.control').on('click',function(){
		$(this).parent().parent().insertBefore($(this).parent().parent().prev());
	});
	$('.glyphicon.glyphicon-arrow-down.control').on('click',function(){
		$(this).parent().parent().insertAfter($(this).parent().parent().next());
	});
}

function addFloorPic(){
	//再来八个产品
	$('.btn.btn-info.product').off('click');
	$('.btn.btn-info.recommand').off('click');
	$('.btn.btn-info.product').on('click',function(){
		var htmlstrNew="";
		var info=$(this).prev().find('img').attr('id').split("_");
		var fid=info[1];
		var lastItemId=info[3];
		var lastItem=parseInt(lastItemId)+1;
		for(var i=1;i<=8;i++,lastItem++){
			htmlstrNew+="<div class=\"col-sm-2\" style=\"margin-left:15px\"><img src=\"\" id=\"product_" + fid + "_img_"+lastItem+"\" width=\"80\" onclick=\"addProduct2(\'" + fid + "\',\'"+lastItem+"\')\"   height=\"80\" alt=\"点击选择商品\"></img><input type=\"button\" style=\"margin-left:20px\" onclick=\"removeProduct(\'"+fid+"\',\'"+lastItem+"\')\" value=\"删除\"/><input type=\"hidden\" id=\"product_"+fid+"_"+lastItem+"\" name=\"product_"+fid+"_"+lastItem+"\"></input></div>";			
		}
		$(this).before(htmlstrNew);
		$(this).siblings(":hidden").val(lastItem);
		return false;
	});
	$('.btn.btn-info.recommand').on('click',function(){
		var htmlstrNew="";
		var info=$(this).prev().find('img').attr('id').split("_");
		var fid=info[1];
		var lastItemId=info[3];
		var lastItem=parseInt(lastItemId)+1;
		for(var i=1;i<=8;i++,lastItem++){
			htmlstrNew+="<div class=\"col-sm-2\" style=\"margin-left:15px\"><img src=\"\" id=\"recommand_" + fid + "_img_"+lastItem+"\" onclick=\"addRecommend2(\'" + fid + "\',\'"+lastItem+"\')\" width=\"80\"  height=\"80\" alt=\"点击选择推荐商品\"></img><input class=\"form-control\" style=\"width:80px;margin-top:5px;\"  type=\"text\" id=\"nickname_"+fid+"_"+lastItem+"\" name=\"nickname_"+fid+"_"+lastItem+"\" placeholder=\"显示文字\"></input><input type=\"button\" style=\"margin-left:20px\" onclick=\"removeRecommd(\'"+fid+"\',\'"+lastItem+"\')\" value=\"删除\"/><input type=\"hidden\" id=\"recommand_"+fid+"_"+lastItem+"\" name=\"recommand_"+fid+"_"+lastItem+"\"></input></div>";			
		}
		$(this).before(htmlstrNew);
		$(this).siblings(":hidden").val(lastItem);
		return false;
	});
}
