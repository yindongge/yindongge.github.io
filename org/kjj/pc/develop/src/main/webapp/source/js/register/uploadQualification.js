var index = '0';
function fireUpload1(){
	$("#file").click();
	index = '1';
}

function fireUpload2(){
	$("#file").click();
	index = '2';
}

function uploadImage(){	
	var picPath = $("#file").val();
    var type = picPath.substring(picPath.lastIndexOf(".") + 1, picPath.length).toLowerCase();
    if (type != "jpg" && type != "bmp" && type != "gif" && type != "png" && type != "jpeg") {
    	$("#nodeTip").html("您选择的图片不符合要求，请上传正确的图片格式！图片尺寸最大不超过5M，照片支持jpg/jpeg/bmp/png格式。").show();
        return false;
    }
    if (findSize("file") > 5*1024*1024) {
    	$("#nodeTip").html("您选择的图片不符合要求，图片尺寸最大不超过5M，照片支持jpg/jpeg/bmp/png格式。").show();
        return false;
    }
    $("#nodeTip").html("图片正在上传，请稍后...").show();

	$.ajaxFileUpload
    (
        {
            url:'../register/uploadEnterpriseQuaImg',//企业资质证照
            secureuri:false,//一般设置为false
            fileElementId:'file',//文件上传空间的id属性  <input type="file" id="file" name="file" />
            dataType: 'json',//返回值类型 一般设置为json
            success: function (data)  //服务器成功响应处理函数
            {    
            	if(index=='1'){
            		$("#organizationCodeImg_show").attr('src',data.url);
            		$("#organizationCodeImg").val(data.returnImgUrl);
            	} else if(index=='2') {
            		$("#businessLicenImg_show").attr('src',data.url);
            		$("#businessLicenImg").val(data.returnImgUrl);
            	}
            	$("#nodeTip").html("图片上传成功！").show();
            },
            error: function (data, status, e)//服务器响应失败处理函数
            {
            	$("#nodeTip").html("图片上传失败！").show();
            }
        }
    );
}

function saveData(){
	// 验证
	if($("#organizationCodeImg").val()==''){
		$("#nodeTip").html("必须上传组织机构代码证!");
		return;
	}
	$("#mySubmit").attr("disabled",true);
	$.ajax({  
        type: "post",  
        dataType:"json",
        url: "../register/saveQualification",
        data: $('#form1').serialize(),
        success: function(data) {  
        	if(data.code != 200){
        		
            }else {
            	if($('#security').val()=='true'){
            		alert('资质上传成功!');
            		location.href="../security/desc";
            	} else {
            		location.href="../loginInit";
            	}
            }
        	$("#mySubmit").attr("disabled",false);
        },  
        error: function(data) {  
            alert(data);  
        }  
    });
}
function findSize(field_id){
 	var fileInput = $("#"+field_id)[0];
 	return byteSize  = fileInput.files[0].size;
 }