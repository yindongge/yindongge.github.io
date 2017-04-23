$(function(){
//	$("#bImg").hide();
	$(".imggroup").on("click","i",function(){$(this).parents("a").next(":hidden").remove();$(this).parents("a").remove()})});
function uploadImage(){
	$(".imggroup").empty();
$.ajaxFileUpload({
	url:"../mobilePage/uploadImage",
	secureuri:false,
	fileElementId:"file",
	dataType:"json",
	success:function(data){
		if(data.code == 200){
			$(".imggroup").append("<a><img src='"+data.url+"'><i>删除</i></a><input type='hidden' name='bannerImg' value='"+data.returnImgUrl+"'/>");
		}
	},
	error:function(data){
		if(data.code == 400){
			$("#bImg").html("图片上传失败！").show();
		}
	}
});
}