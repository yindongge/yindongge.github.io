$(function(){
	$("#mobileDefault").click(function(){
		if($(this).prop("checked")){
			$("#returnTel").val($("#orderTel").val());
			$("#returnTel").prop("disabled",true);
		}else{
			$("#returnTel").prop("disabled",false);
		}
	});
	
	//数量减少
	$("#amountMinus").click(function(){
		var amount = $("#amount");
		
		if(amount.val() > 1){
			amount.val(parseInt(amount.val())-1);
		}
		
		editAmount(amount);
	});
	
	//数量增加
	$("#amountPlus").click(function(){	
		var amount = $("#amount");
		amount.val(parseInt(amount.val())+1);
		editAmount(amount);
	});
	
	//数量改变
	$("#amount").on("focusout",function(){
	 	if(!isPlusInteger($(this).val())){
			$(this).val($(this).attr('data-old'));
		} 
	 	editAmount($(this));
	});
	
	//校验
	$("#formReturn").submit(function(){
		
		//校验提示
		$("b").hide();
		
		//问题描述
		if($("#reason").val() == ''){
			$("#reason").next().next().html("问题描述不能为空！").show();
			$("#reason").focus();
			return false;
		}
		//联系人
		if($("#returnContact").val() == ''){
			$("#returnContact").next().html("联系人不能为空！").show();
			$("#returnContact").focus();
			return false;
		}
		//联系人
		if($("#returnContact").val().length>60){
			$("#returnContact").next().html("联系人字数超出限制！").show();
			$("#returnContact").focus();
			return false;
		}
		//联系方式
		if($("#returnTel").val() == ''){
			$("#returnTel").next().html("联系方式不能为空！").show();
			$("#returnTel").focus();
			return false;
		}
		if(isTelAreaCode($("#returnTel").val())){
			$("#returnTel").next().html("联系方式格式错误！").show();
			$("#returnTel").focus();
			return false;
		}
		return true;
	});
	
	//上传图片
	$("#btnUpload").click(function(){
		$("#bImg").hide();
		if($(".imggroup a").length >= 5){
			$("#bImg").html("最多可上传5张图片").show();
			return false;
		}
		$("#file").click();
	});
	
	//删除图片
	$(".imggroup").on("click","i",function(){
		$(this).parents("a").next(":hidden").remove();
		$(this).parents("a").remove();
	});
});

//修改商品库存
function editAmount(amount){
	
	if(parseInt(amount.val())>parseInt(amount.attr("data-last-amount"))){
		amount.val(amount.attr('data-old'));
	}
	
	amount.attr('data-old',amount.val());
	
	//修改减少数量按钮是否可用
	if($("#amount").val() == 1){
		$("#amountMinus").addClass('remove');
	}else{
		$("#amountMinus").removeClass('remove');
	}
}

function uploadImage(){
	
	var picPath = $("#file").val();
    var type = picPath.substring(picPath.lastIndexOf(".") + 1, picPath.length).toLowerCase();
    if (type != "jpg" && type != "bmp" && type != "gif" && type != "png" && type != "jpeg") {
    	$("#bImg").html("请上传正确的图片格式").show();
        return false;
    }
    if (findSize("file")> 5*1024*1024) {
    	$("#bImg").html("图片大小不超过5M").show();
        return false;
    }

	$.ajaxFileUpload
    (
        {
            url:'../uploadImage',//用于文件上传的服务器端请求地址
            secureuri:false,//一般设置为false
            fileElementId:'file',//文件上传空间的id属性  <input type="file" id="file" name="file" />
            dataType: 'json',//返回值类型 一般设置为json
            success: function (data)  //服务器成功响应处理函数
            {    
				$(".imggroup").append("<a><img src='"+data.url+"'><i>删除</i></a><input type='hidden' name='returnImgUrl' value='"+data.returnImgUrl+"'/>");
            },
            error: function (data, status, e)//服务器响应失败处理函数
            {
            	$("#bImg").html("图片上传失败！").show();
            }
        }
    );
}

 function findSize(field_id){
 	var fileInput = $("#"+field_id)[0];
 	return byteSize  = fileInput.files[0].size;
 }