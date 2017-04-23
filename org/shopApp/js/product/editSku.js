var newImgNum = 1; //新增图片id

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
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: '名称不能为空'
                    },
                    digits: {
                    	message: '必须为数字'
                    } 
                }
            },
            specOrder:{
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: '不能为空'
                    },
                    digits: {
                    	message: '必须为数字'
                    }                    
                }
            }
        }
    }).on('success.form.bv', function(e) {
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
        	}else{
        		alert("添加失败！！");	
        	}
        
        }, 'json');
    });	
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

$(function(){
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
	//显示按钮
	$('#showBtn1').bind('click',function(){
		$('#showBtn1').removeClass('btn-default').addClass('btn-primary');
		$('#showBtn2').removeClass('btn-primary').addClass('btn-default');
		$('#showBtn1').parent().find(':hidden').val('1');
	});
	$('#showBtn2').bind('click',function(){
		$('#showBtn1').removeClass('btn-primary').addClass('btn-default');
		$('#showBtn2').removeClass('btn-default').addClass('btn-primary');
		$('#showBtn1').parent().find(':hidden').val('0');
	});
	
	$('#showBtn3').bind('click',function(){
		$('#showBtn3').removeClass('btn-default').addClass('btn-primary');
		$('#showBtn4').removeClass('btn-primary').addClass('btn-default');
		$('#showBtn3').parent().find(':hidden').val('1');
	});
	$('#showBtn4').bind('click',function(){
		$('#showBtn3').removeClass('btn-primary').addClass('btn-default');
		$('#showBtn4').removeClass('btn-default').addClass('btn-primary');
		$('#showBtn3').parent().find(':hidden').val('0');
	});
	
	$('#showBtn5').bind('click',function(){
		$('#showBtn5').removeClass('btn-default').addClass('btn-primary');
		$('#showBtn6').removeClass('btn-primary').addClass('btn-default');
		$('#showBtn5').parent().find(':hidden').val('0');
	});
	$('#showBtn6').bind('click',function(){
		$('#showBtn5').removeClass('btn-primary').addClass('btn-default');
		$('#showBtn6').removeClass('btn-default').addClass('btn-primary');
		$('#showBtn5').parent().find(':hidden').val('1');
	});
	validate();
	
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
});