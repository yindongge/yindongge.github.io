$(function(){
	moveModule();
	$('#continueAddBtn').click(function(){
		//iframe层
		layer.open({
		type: 2,
		title: '新增模块区',
		shadeClose: true,
		shade: 0.8,
		maxmin: true, //开启最大化最小化按钮
		area: ['900px', '450px'],
		content:'../mobilePage/AddNewModule?pageId='+$("#pageId").val()
		});
	})
	
	$(".glyphicon-remove-circle").on('click',function(){
		var downid = $(this).attr("id");
		var id= downid.replace('down','id');
		id = $("#"+id).val();
		if(!confirm("确定要删除该记录吗")){
			return;
		}
		$.ajax({
			type:'post',
			url:'../mobilePage/deleteModule?id='+id,
			success:function(data){
				alert("删除成功！");
		        window.location.href="../mobilePage/modulePage?pageId="+$("#pageId").val();
			}
		});
	});
	
	$("img").on('click',function(){
		var id = $(this).parent().find("input:eq(3)").attr("id");
		$("#"+id).click();
	});
	
	$(".btn.btn-danger").on('click',function(){
		var id = $(this).attr("id");
		layer.open({
		    type: 2,
		    title: '选择商品',
		    shadeClose: true,
		    shade: 0.8,
			maxmin: true, //开启最大化最小化按钮
		    area: ['900px', '450px'],
		    content: '../mobilePage/itemList?moduleId='+id,
		    end: function () {
                location.reload();
            }

		}); 
	})
})

function uploadImage(imgId){
 	var id = imgId.replace('img','');
$.ajaxFileUpload({
	url:"../mobilePage/uploadImage",
	secureuri:false,
	fileElementId:"file"+id,
	dataType:"json",
	success:function(data){
		if(data.code == 200){
			$("#"+imgId).attr("src",data.url);
			$("#hid"+id).attr("value",data.returnImgUrl);
			editModuel($("#id"+id).val(),data.returnImgUrl);
		}
	},
	error:function(data){}
});
}

function editModuel(id,moduleImg){
	$.ajax({
		type:'post',
		url:'../mobilePage/updateModel',
		dataType:'json',
		data:{"id":id,"moduleImg":moduleImg},
		success:function(data){
			
		},
		error:function(data){}
	});
}

function moveModule(){
	$(".up_me").off('click');
	$(".down_me").off('click');
	$(".up_me").on('click',function(){
		if($(this).parent().parent().prev().hasClass("table-list")){
			var clickId = $(this).parent().parent().find("input:eq(1)").attr("value");
			var clickOrderId = $(this).parent().parent().find("input:eq(2)").attr("value");
			
			var id=$(this).parent().parent().prev().find("input:eq(1)").attr("value");
			var orderId=$(this).parent().parent().prev().find("input:eq(2)").attr("value");
			
			$(this).parent().parent().insertBefore($(this).parent().parent().prev());
			$.ajax({
				type:'post',
				url:'../mobilePage/moduleOrder',
				data:{"clickId":clickId,"clickOrderId":clickOrderId,"id":id,"orderId":orderId},
				dataType:'json',
				success:function(data){
					if(data.code == 200){
						window.location.href='../mobilePage/modulePage?pageId='+$("#pageId").val();
					}
				}
			});
		}
	});
	$(".down_me").on('click',function(){
		if($(this).parent().parent().next().hasClass("table-list")){
			var clickId = $(this).parent().parent().find("input:eq(1)").attr("value");
			var clickOrderId = $(this).parent().parent().find("input:eq(2)").attr("value");
			
			var id=$(this).parent().parent().next().find("input:eq(1)").attr("value");
			var orderId=$(this).parent().parent().next().find("input:eq(2)").attr("value");
			
			$(this).parent().parent().insertAfter($(this).parent().parent().next());
			$.ajax({
				type:'post',
				url:'../mobilePage/moduleOrder',
				data:{"clickId":clickId,"clickOrderId":clickOrderId,"id":id,"orderId":orderId},
				dataType:'json',
				success:function(data){
					if(data.code == 200){
						window.location.href='../mobilePage/modulePage?pageId='+$("#pageId").val();
					}
				}
			});
		}
	});
}
