var saleSpecValueMap = null;//key：销售规格值id ,value：销售规格值obj
var saleSpecArray = null;//销售规格数组
var newImgNum = 1; //新增图片id

//给销售规格值input绑定事件
function bindEventForSpecValueInput(){
	$(':input[name="specValueInput"]').bind('input oninput', function(){
		var specValueId = $(this).prev().val();
		var specValue = $(this).val();
		$('.valueStr_'+ specValueId).text(specValue);
		saleSpecValueMap[specValueId].specValue = specValue;
		//generateSpecValueHidden();
	});
}

//选择分类后，初始化品牌、显示主图的销售规格、销售规格、属性列表
function setclass(className, classId){
	$.ajax({
		url: '../getBrandAndSpecAndPropertyByClassId/'+classId,
		type: 'get',
		dataType: 'json',
		success : function(result){
			if(null == result.productType){
				alert('此分类商品类型为空，请重新选择分类');
				return;
			}
			$('#classId').val(classId);
			$('#catStr').val(className);
			$('#className').text(className);
			
			saleSpecValueMap = new Map();
			saleSpecArray = new Array();
			//初始化品牌
			var brankHtmlStr = '<option value="">请选择品牌</option>'; 
			$.each(result.brandList,function(index,item){
				brankHtmlStr += '<option value="'+item.productBrandId+'">'+item.productBrandName+'</option>';
			});
			$('#brandId').empty();
			$('#brandId').append(brankHtmlStr);

			//初始化显示主图的销售规格
			var showImgSpecHtmlStr = '<option value="-1">不显示</option>';
			$.each(result.productType.saleSpecList, function(index,item){
				showImgSpecHtmlStr += '<option value="'+item.specId+'">'+item.specName+'</option>';
			});
			$('#specid').empty();
			$('#specid').append(showImgSpecHtmlStr);
			//初始化销售规格
			var specHtmlStr = '';
			$.each(result.productType.saleSpecList, function(index,item){
				specHtmlStr += '<div class="form-group"><label class="col-sm-2 control-label" >'+item.specName+'：</label><div class="col-sm-9"><p>';
				var saleSpec = new Object();
				saleSpec.specId = item.specId;
				saleSpec.specName = item.specName;
				saleSpec.specTypeId = item.specTypeId;
				saleSpecArray.push(saleSpec);
				$.each(item.values, function(index, value){
					specHtmlStr += '<lable class="checkbox-inline"><input type="checkbox" name="'+item.specId+'" value="'+value.specValueId+'"></input><input type="text" class="input2-control" name="specValueInput" value="'+value.specValue+'" /></lable>';
					//put销售规格值到map
					var saleSpecValue = new Object();
					saleSpecValue.specValue = value.specValue;
					saleSpecValue.specId = value.specId;
					saleSpecValue.specValueId = value.specValueId;
					saleSpecValueMap[value.specValueId] = saleSpecValue;
				});
				//specHtmlStr += '<label class="checkbox-inline"><button type="button" class="btn btn-danger btn-xs ">添加规格值</button></label>';
				specHtmlStr += '</p></div></div>';
			});
			$('#saleSpecDiv').empty();
			$('#saleSpecDiv').append(specHtmlStr);
			//销售规格值input绑定事件
			bindEventForSpecValueInput();
			//初始化skuTable表头
			createHeadForSkuTable();
			//初始化属性
			var productPropertyHtmlStr = '<label class="col-sm-2 control-label" >商品属性：</label><div class="col-sm-9" ><table class="table table-bordered table-firsttd"><tbody>';
			$.each(result.productType.productProperty, function(index,item){
				productPropertyHtmlStr += '<tr><td>'+item.propertyName+'：</td><td>';
				//属性录入方式：1手动输入2单选组3列表单选4复选框
				var propertyInputType = item.propertyInputType;
				if(propertyInputType == 1){
					productPropertyHtmlStr += '<input type="text" name="prop_'+item.propertyValues[0].propertyId+'" value="'+item.propertyValues[0].propertyValue+'"/>';
				}else if(propertyInputType == 2){
					$.each(item.propertyValues, function(index, value){
						productPropertyHtmlStr += '<label><input type="radio" name="prop_'+value.propertyId+'" value="'+value.propertyValueId+'"/>'+value.propertyValue+'</label>';
					});
				}else if(propertyInputType == 3){
					productPropertyHtmlStr += '<select name="prop_'+item.propertyId+'">';
					$.each(item.propertyValues, function(index, value){
						productPropertyHtmlStr += '<option value="'+value.propertyValueId+'">'+value.propertyValue+'</option>';
					});
					productPropertyHtmlStr += '</select>';
				}else if(propertyInputType == 4){
					$.each(item.propertyValues, function(index, value){
						productPropertyHtmlStr += '<label><input type="checkbox" name="prop_'+value.propertyId+'" value="'+value.propertyValueId+'"/>'+value.propertyValue+'</label>';
					});
				}
				productPropertyHtmlStr +='</td></tr>';
			});
			productPropertyHtmlStr += '</tbody></table></div>';
			$('#productPropertyDiv').empty();
			$('#productPropertyDiv').append(productPropertyHtmlStr);
			addClickForSaleSpecCheckbox();
			
			//如果切换分类，刷新相册
			if($('#addImgFromAlbumBtn').hasClass('active')){
				initAlbum(1);
			}
		}
	});
}

//笛卡尔积
function descartes(list)
{
    //parent上一级索引;count指针计数
    var point  = {};
    var result = [];
    var pIndex = null;
    var tempCount = 0;
    var temp   = [];
    //根据参数列生成指针对象
    for(var index in list)
    {
        if(typeof list[index] == 'object')
        {
            point[index] = {'parent':pIndex,'count':0};
            pIndex = index;
        }
    }
    //单维度数据结构直接返回
    if(pIndex == null)
    {
        return list;
    }
    //动态生成笛卡尔积
    while(true)
    {
        for(var index in list)
        {
            tempCount = point[index]['count'];
            temp.push(list[index][tempCount]);
        }
        //压入结果数组
        result.push(temp);
        temp = [];
        //检查指针最大值问题
        while(true)
        {
            if(point[index]['count']+1 >= list[index].length)
            {
                point[index]['count'] = 0;
                pIndex = point[index]['parent'];
                if(pIndex == null)
                {
                    return result;
                }
                //赋值parent进行再次检查
                index = pIndex;
            }
            else
            {
                point[index]['count']++;
                break;
            }
        }
    }
}

function addClickForSaleSpecCheckbox(){
	$('#saleSpecDiv :checkbox').on('click', function(){
		createSkuTable();
	});
}

function createHeadForSkuTable(){
	var skuTableHtmlStr = '<label class="col-sm-2 control-label" ><span class="red"></span>SKU配置：</label><div class="col-sm-9"><table class="table table-bordered table-hover table-striped">';
	skuTableHtmlStr += '<thead><tr>';
	$.each(saleSpecArray, function(index, item){
		skuTableHtmlStr += '<th>'+item.specName+'</th>';
	});
	skuTableHtmlStr +='<th>商品货号</th><th>市场价</th>';
	skuTableHtmlStr += '</tr></thead>';
	skuTableHtmlStr += '<tbody></tbody></table></div>';
	$('#skuTableDiv').empty();
	$('#skuTableDiv').append(skuTableHtmlStr);
}

function createSkuTable(){
	var allSaleSpecArray = new Array();
	var allSaleSpecArrayMap = new Map();
	//创建销售规格项数组,放入map
	$.each(saleSpecArray, function(index,item){
		allSaleSpecArrayMap[item.specId] = new Array();
	});
	//已选中销售规格放入对应销售规格项数组
	$('#saleSpecDiv input:checked').each(function(){
		allSaleSpecArrayMap[this.name].push(this.value);
	});
	//销售规格项数组长度大于0的放入销售规格数组
	$.each(saleSpecArray, function(index,item){
		if(allSaleSpecArrayMap[item.specId].length > 0){
			allSaleSpecArray.push(allSaleSpecArrayMap[item.specId]);
		}
	});
	//当所有销售规格项数组长度都大于0时，笛卡尔积创建sku
	if(allSaleSpecArray.length == saleSpecArray.length){
		var descartesResult = descartes(allSaleSpecArray);
		var skuTableHtmlStr = '';
		$.each(descartesResult, function(index,item){
			skuTableHtmlStr += '<tr>';
			$.each(item, function(index,specValueId){
				skuTableHtmlStr +='<td class="valueStr_'+specValueId+'">'+saleSpecValueMap[specValueId].specValue+'</td>';
			});
			skuTableHtmlStr += '<td><input type="text" name="goodsSns"></input></td><td><input type="text" name="marketPrices"></input></td>';
			var specValueIdsStr = item.join('&');
			skuTableHtmlStr += '<input type="hidden" name="specValueIds" value="'+specValueIdsStr+'"/><input type="hidden" name="specValues" value=""/><input type="hidden" name="skuIds" value="-1"/>';
			skuTableHtmlStr += '</tr>';
		});
		$('#skuTableDiv tbody').empty();
		$('#skuTableDiv tbody').append(skuTableHtmlStr);
	}else{
		$('#skuTableDiv tbody').empty();
	}
	initProductInfoForSkuTable();
}

//给隐藏域属性值赋值
function generateSpecValueHidden(){
	$(':input[name="specValueIds"]').each(function(){
		var specValueIdsArray = $(this).val().split('&');
		var specValuesStrArray = new Array();
		for(var i=0; i<specValueIdsArray.length; i++){
			specValuesStrArray.push(saleSpecValueMap[specValueIdsArray[i]].specValue);
		}
		var specValuesStr = specValuesStrArray.join('&');
		$(this).parent().find(':input[name="specValues"]').val(specValuesStr);
	});
}

//给file标签添加上传事件,删除事件,移除事件
function addUploadFileEvent(){
	$(':file').unbind('change');
	$(':file').bind('change', function(){
		var fileId = this.id;
		if(checkPic(fileId)){
			$.ajaxFileUpload
		    (
		        {
		            url:'../uploadPicture',//用于文件上传的服务器端请求地址
		            secureuri:false,//一般设置为false
		            fileElementId:fileId,//文件上传空间的id属性  <input type="file" id="file" name="file" />
		            dataType: 'json',//返回值类型 一般设置为json
		            success: function (data)  //服务器成功响应处理函数
		            {    
		            	$('#'+fileId).prev().attr('src',data.visitPrictureUrl);
		            	$('#'+fileId).next().val(data.visitPrictureUrlForSave);
		            },
		            error: function (data, status, e)//服务器响应失败处理函数
		            {
		                alert(e);
		            }
		        }
		    );
		}
	});
	$('a[name="leftImgBtn"]').unbind('click');
	$('a[name="leftImgBtn"]').bind('click',function(){
		if(!$(this).parent().parent().parent().prev().hasClass('stop_move')){
			var htmlStr = '<div class="img_show">' + $(this).parent().parent().parent().html() + '</div>';
			var prevElement = $(this).parent().parent().parent().prev();
			$(this).parent().parent().parent().remove();
			$(prevElement).before(htmlStr);
			addUploadFileEvent();
		}
	});
	$('a[name="rightImgBtn"]').unbind('click');
	$('a[name="rightImgBtn"]').bind('click',function(){
		if(!$(this).parent().parent().parent().next().hasClass('stop_move')){
			var htmlStr = '<div class="img_show">' + $(this).parent().parent().parent().html() + '</div>';
			var nextElement = $(this).parent().parent().parent().next();
			$(this).parent().parent().parent().remove();
			$(nextElement).after(htmlStr);
			addUploadFileEvent();
		}
	});
	$('a[name="deleteImgBtn"]').unbind('click');
	$('a[name="deleteImgBtn"]').bind('click',function(){
		$(this).parent().parent().parent().remove();
	});
}

function checkPic(fileId) {
    var picPath = document.getElementById(fileId).value;
    var type = picPath.substring(picPath.lastIndexOf(".") + 1, picPath.length).toLowerCase();
    if (type != "jpg" && type != "bmp" && type != "gif" && type != "png") {
        alert("请上传正确的图片格式");
        return false;
    }
    return true;
}

function validateGoodsSn(){
	var result = true;
	$.ajax({
		url : '../isSpuGoodsSnExist',
		type : 'post',
		dataType : 'json',
		async : false,
		data : {
			'spuGoodsSn' : $(':input[name="goodsSn"]').val(),
			'spuGoodsId' : $(':input[name="goodsId"]').val()
		},
		success : function(data){
			if(data.code == '200'){
				result = false;
				alert(data.message);
			}
		}
	});
	
	if(!result){
		return result;
	}
	var skuGoodsSnArr = new Array();
	$(':input[name="goodsSns"]').each(function(){
		if(null != $(this).val() && $(this).val() != ''){
			skuGoodsSnArr.push($(this).val());
		};	
	});
	var skuGoodsSnsStr = skuGoodsSnArr.join('&');
	$.ajax({
		url : '../isSkuGoodsSnExist',
		type : 'post',
		dataType : 'json',
		async : false,
		data : {
			'skuGoodsSns' : skuGoodsSnsStr,
			'spuGoodsId' : $(':input[name="goodsId"]').val()
		},
		success : function(data){
			if(data.code == '200'){
				result = false;
				alert(data.message);
			}
		}
	});
	
	var marketPriceValidate = true;
	$(':input[name="marketPrices"]').each(function(){
		var goodsSn = $(this).parent().parent().find(':input[name="goodsSns"]').val();
		if(null != goodsSn && goodsSn.trim() != ''){
			var marketPrice = $(this).val();
			if(null == marketPrice  || marketPrice.trim() == ''){
				marketPriceValidate = false;
			};
		};
	});
	if(marketPriceValidate == false){
		result = false;
		alert('市场价不能为空');
	}
	return result;
}

function validate(){
    $('#addForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	goodsSn: {
                validators: {
                    notEmpty: {
                        message: '不能为空'
                    },
                    digits: {
                    	message: '必须为数字'
                    }
                }
            },
            goodsName:{
                validators: {
                    notEmpty: {
                        message: '不能为空'
                    },
                    stringLength: {
                        max: 30,
                        message: '长度不能大于30'
                    }                   
                }
            },
            goodsBrief:{
                validators: {
                    stringLength: {
                        max: 45,
                        message: '长度不能大于45'
                    }                   
                }
            },
            marketPrice:{
                validators: {
                    notEmpty: {
                        message: '不能为空'
                    },
                    regexp: {
                        regexp: '^[0-9]+\.{0,1}[0-9]{0,2}$',
                        message: '必须为数字'
                    }                  
                }
            },
            brandId:{
                validators: {
                    notEmpty: {
                        message: '不能为空'
                    }                  
                }
            }
        }
    }).on('success.form.bv', function(e) {
    	var validate = validateGoodsSn();
    	if(!validate){
    		return false;
    	}
    	generateSpecValueHidden();
        // Prevent form submission
        e.preventDefault();
        // Get the form instance
        var $form = $(e.target);
        // Get the BootstrapValidator instance
        var bv = $form.data('bootstrapValidator');
        // Use Ajax to submit form data
        $.post($form.attr('action'), $form.serialize(), function(result) {
        	if(result.code==200){
        		alert("添加成功！！");
        		location.href = '../skuInfo/'+result.spuId;
        	}else{
        		alert("添加失败！！");	
        	}
        
        }, 'json');
    });	
}



//初始化skuTable
function initSkuTable(){
	//初始化saleSpecValueMap与saleSpecArray
	var productType = JSON.parse(productTypeJson);
	if(null != productType){
		saleSpecValueMap = new Map();
		saleSpecArray = new Array();
		$.each(productType.saleSpecList, function(index,item){
			var saleSpec = new Object();
			saleSpec.specId = item.specId;
			saleSpec.specName = item.specName;
			saleSpec.specTypeId = item.specTypeId;
			saleSpecArray.push(saleSpec);
			$.each(item.values, function(index, value){
				//put销售规格值到map
				var saleSpecValue = new Object();
				saleSpecValue.specValue = value.specValue;
				saleSpecValue.specId = value.specId;
				saleSpecValue.specValueId = value.specValueId;
				saleSpecValueMap[value.specValueId] = saleSpecValue;
			});
		});
		//初始化skuTable表头
		createHeadForSkuTable();
		//创建skuTable
		createSkuTable();
		addClickForSaleSpecCheckbox();
		//销售规格值input绑定事件
		bindEventForSpecValueInput();
	}
}

//生成skuTable中的商品货号、市场价、及隐藏域相关数据
function initProductInfoForSkuTable(){
	var productItemMap = new Map();
	var productItemList = JSON.parse(productItemListJson);
	$.each(productItemList, function(index, productItem){
		saleSpecValueIdArr = new Array();
		$.each(productItem.orgProductItemLinkSalespecList, function(index, item){
			saleSpecValueIdArr.push(item.specTypeId);
		});
		saleSpecValueIdArr.sort();
		saleSpecValueIdArrStr = saleSpecValueIdArr.join('&');
		productItemMap[saleSpecValueIdArrStr] = productItem;
	});
	
	$(':input[name="specValueIds"]').each(function(){
		var specValueIds = this.value;
		var specValueIdArr = specValueIds.split('&');
		specValueIdArr.sort();
		specValueIds = specValueIdArr.join('&');
		if(productItemMap[specValueIds] != null){
			$(this).parent().find(':input[name="goodsSns"]').val(productItemMap[specValueIds].goodsSn);
			$(this).parent().find(':input[name="marketPrices"]').val(productItemMap[specValueIds].marketPrice);
			$(this).parent().find(':input[name="skuIds"]').val(productItemMap[specValueIds].goodsId);
		}
	});
	if(productItemList.length == 1 && $(':input[name="skuIds"]').length == 0){
/*		调试可以用
 		var skuHtmlStr = '<tr>';
		$.each(saleSpecArray, function(index, item){
			skuHtmlStr += '<td></td>';
		});
		skuHtmlStr += '<td><input type="text" name="goodsSns" value="' + productItemList[0].goodsSn + '"></input></td><td><input type="text" name="marketPrices" value="' + productItemList[0].marketPrice + '"></input></td>';
		skuHtmlStr += '<input type="hidden" name="skuIds" value="' + productItemList[0].goodsId + '">';*/
		var skuHtmlStr = '<input type="hidden" name="goodsSns" value="' + productItemList[0].goodsSn + '"></input>';
		skuHtmlStr += '<input type="hidden" name="marketPrices" value="' + productItemList[0].marketPrice + '"></input>';
		skuHtmlStr += '<input type="hidden" name="skuIds" value="' + productItemList[0].goodsId + '">';
		$('#skuTableDiv tbody').empty();
		$('#skuTableDiv tbody').append(skuHtmlStr);
	}
}

//初始化相册
function initAlbum(pageNow){
	$.ajax({
		url : '../albumList',
		type : 'post',
		dataType : 'json',
		data : {
			'pageNumber' : pageNow - 1,
			'productClassId' : $('#classId').val()
		},
		success : function(data){
			//图片
			var imgDivHtmlStr = '<div class="change-photo">';
			$.each(data.page.content, function(index, item){
				imgDivHtmlStr += '<a href="javascript:void(0);"><img src="'+item.imgUrl180+'"/></a>';
			});
			imgDivHtmlStr += '</div>';
			$('#albumDiv').empty();
			$('#albumDiv').append(imgDivHtmlStr);
			//分页
			var pageDivHtmlStr = '<div class="change-page">';
			pageDivHtmlStr += '<nav>';
			pageDivHtmlStr += '<ul class="pagination">';
			//上一页
			if(pageNow -1 > 0){
				pageDivHtmlStr += '<li><a href="javascript:void(0);" aria-label="Previous" onclick="initAlbum(' + (pageNow - 1) + ')"><span aria-hidden="true">&laquo;</span></a></li>';
			}else{
				pageDivHtmlStr += '<li><a href="javascript:void(0);" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>';
			}
			//页数
			var page = data.page;
			var beginPage = page.number+1 - (11 - (page.totalPages - page.number) > 5 ? 11 - (page.totalPages - page.number) : 5) > 1 ? page.number+1 - (11 - (page.totalPages - page.number) > 5 ? 11 - (page.totalPages - page.number) : 5) : 1;
			var endPage = (10 - page.number > 5 ? 10 - page.number : 5) + page.number+1 < page.totalPages ? (10 - page.number > 5 ? 10 - page.number : 5) + page.number+1 : page.totalPages;
			for(var i = beginPage; i <= endPage; i++){
				pageDivHtmlStr += '<li><a href="javascript:void(0);" onclick="initAlbum(' + i + ')"';
				if(i == pageNow){
					pageDivHtmlStr += 'class="current"';
				}
				pageDivHtmlStr += '>' + i + '</a></li>';
			}
			//下一页
			if(pageNow + 1 <= page.totalPages){
				pageDivHtmlStr += '<li><a href="javascript:void(0);" aria-label="Next" onclick="initAlbum(' + (pageNow - 0 + 1) + ')"><span aria-hidden="true">&raquo;</span></a></li>';
			}else{
				pageDivHtmlStr += '<li><a href="javascript:void(0);" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>';
			}
			pageDivHtmlStr += '</ul></nav></div>';
			$('#albumDiv').append(pageDivHtmlStr);
			
			//绑定添加事件
			$('#albumDiv .change-photo a').on('click', function(){
				addImg($(this).find('img').attr('src').replace('180x180', ''));
			});
		}
	});
}
//从相册添加图片到商品
function addImg(imgUrl){
	var imgDivHtmlStr = '<div class="img_show">'
		+'<div class="thumbnail">'
		+'<div style="position: relative;text-align: center;">'
		+'<img src="' + imgUrl.replace('_', '_180x180') + '" class="img-col-md-2"/>'
		+'<input type="file" name="file" id="newImg'+newImgNum+'" style="position: absolute;top: 0;right: 20px;height: 24px;filter: alpha(opacity:0);opacity: 0;bottom: 0px;left: 0px;height: 100%;width: 100%;"/>'
		+'<input type="hidden" name="goodsImgs" value="' + imgUrl + '"/>'
		+'</div>'	
		+'<p class="thumbnail-photo text-center">'
		+'<a href="javascript:void(0);" name="leftImgBtn" class="btn btn-default btn-sm" role="button"><i class="glyphicon glyphicon-arrow-left"></i></a>'
		+'<a href="javascript:void(0);" name="rightImgBtn" class="btn btn-default btn-sm" role="button"><i class="glyphicon glyphicon-arrow-right"></i></a>'
		+'<a href="javascript:void(0);" name="deleteImgBtn" class="btn btn-danger btn-sm" role="button"><i class="glyphicon glyphicon-remove"></i></a>'
		+'</p>'
		+'</div>'
		+'</div>';
	newImgNum++;
	$('#addImgBtn').before(imgDivHtmlStr);
	addUploadFileEvent();
}

//设置副分类
function setSubClass(className, classId){
	//过滤已添加的副分类
	var flag = false;
	$(':hidden[name="subClassIds"]').each(function(){
		if($(this).val() == classId){
			flag = true;
		}
	});
	if(flag){
		return false;
	}
	var htmlStr = '<span>'+ className +'<input type="hidden" name="subClassIds" value="'+ classId +'"/><i onclick="removeSubClass(this);">X</i></span>';
	$('#subClassDiv').append(htmlStr);
}
//移除副分类
function removeSubClass(element){
	$(element).parent().remove();
}

$(function(){
	$('#selectClassBtn').click(function(){
		layer.open({
		    type: 2,
		    title: '选择分类',
		    shadeClose: true,
		    shade: 0.8,
			maxmin: true, //开启最大化最小化按钮
		    area: ['800px', '450px'],
		    content: '../../brand/selectClass' //iframe的url
		}); 
	});
	$('#selectSubClassBtn').click(function(){
		layer.open({
		    type: 2,
		    title: '选择分类',
		    shadeClose: true,
		    shade: 0.8,
			maxmin: true, //开启最大化最小化按钮
		    area: ['800px', '450px'],
		    content: '../../brand/selectClassForDeputy' //iframe的url
		}); 
	});
	validate();
	//初始化富文本编辑器
    KindEditor.ready(function(K) {
   	 	K.create('#goodsDesc', {
   		 	width : '910px',
   		 	height : '400px',
            uploadJson : '../../kindEditor/fileUpload',  
            fileManagerJson : '../../kindEditor/fileManager',  
            allowFileManager : true  ,
            afterCreate : function() { 
                this.sync(); 
               }, 
               afterBlur:function(){ 
                   this.sync(); 
               }       
         });  
   	 	K.create('#mobileGoodsDesc', {
   		 	width : '640px',
   		 	height : '400px',
            uploadJson : '../../kindEditor/fileUpload',  
            fileManagerJson : '../../kindEditor/fileManager',  
            allowFileManager : true  ,
            afterCreate : function() { 
                this.sync(); 
               }, 
               afterBlur:function(){ 
                   this.sync(); 
               }       
         });
    });
	$('.togglebtn').eq(0).addClass('active');
	$('.bianji').eq(0).show();
	$('.togglebtn').click(function(){
		$(this).addClass('active').siblings().removeClass('active')	;
		var index=$('.togglebtn').index(this);
		$('.bianji').eq(index).show().siblings('.bianji').hide();//这里后期修改的，注意，是在siblings添加的选择器
	});
	
	//添加图片
	addUploadFileEvent();
	$('#addImgBtn').on('click', function(){
		var imgDivHtmlStr = '<div class="img_show">'
			+'<div class="thumbnail">'
			+'<div style="position: relative;text-align: center;">'
			+'<img src="" class="img-col-md-2"/>'
			+'<input type="file" name="file" id="newImg'+newImgNum+'" style="position: absolute;top: 0;right: 20px;height: 24px;filter: alpha(opacity:0);opacity: 0;bottom: 0px;left: 0px;height: 100%;width: 100%;"/>'
			+'<input type="hidden" name="goodsImgs" />'
			+'</div>'	
			+'<p class="thumbnail-photo text-center">'
			+'<a href="javascript:void(0);" name="leftImgBtn" class="btn btn-default btn-sm" role="button"><i class="glyphicon glyphicon-arrow-left"></i></a>'
			+'<a href="javascript:void(0);" name="rightImgBtn" class="btn btn-default btn-sm" role="button"><i class="glyphicon glyphicon-arrow-right"></i></a>'
			+'<a href="javascript:void(0);" name="deleteImgBtn" class="btn btn-danger btn-sm" role="button"><i class="glyphicon glyphicon-remove"></i></a>'
			+'</p>'
			+'</div>'
			+'</div>';
		newImgNum++;
		$('#addImgBtn').before(imgDivHtmlStr);
		addUploadFileEvent();
	});
	
	//上传新图片button
	$('#uploadNewImgBtn').on('click', function(){
		$('#uploadNewImgBtn').addClass('active');
		$('#addImgFromAlbumBtn').removeClass('active');
		$('#albumDiv').empty();
	});
	//从相册中选择button
	$('#addImgFromAlbumBtn').on('click', function(){
		$('#addImgFromAlbumBtn').addClass('active');
		$('#uploadNewImgBtn').removeClass('active');
		initAlbum(1);
	});
	
	initSkuTable();
});