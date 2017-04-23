function closewin(){
 	var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
	parent.layer.close(index); //执行关闭 
}

function setclass(a,b){
	var cid = $("#classIds").val();
	var str = $("#showtext").html();
	if(cid.indexOf(b) > -1 ){
		return false;
	}
	str+="<p class='delete-span' id='p_"+b+"' ><span id='s_"+b+"'>"+a+"</span><span><i class='glyphicon glyphicon-remove' onclick='deletespan(p_"+b+")'></i></span></p>";
	$("#showtext").empty();
	$("#showtext").append(str);
	//循环获取所有品品牌id
	var ids="";
	var brandstr="" ;
	$("#showtext p").each(function(){
		var pid = $(this).attr("id")+"";
		var sid = pid.substr(2);
		if(pid!="undefined"){ 
			ids +=pid;
			brandstr+=$("#s_"+sid).text()+";"; 
		} 
	});
	$("#classIds").val(ids);
	$("#brandTypeStr").val(brandstr);
	
}	

function deletespan(spid){
	$(spid).remove();
	
	var ids="";
	var brandstr="" ;
	$("#showtext p").each(function(){
		var pid = $(this).attr("id")+"";
		
		var sid = pid.substr(2);
		
		if(pid!="undefined"){ 
			ids +=pid;
			brandstr+=$("#s_"+sid).text()+";"; 
		} 
		
	});
	

	$("#classIds").val(ids);
	$("#brandTypeStr").val(brandstr);
	
}

function uploadfile(){
	if(checkPic()){
		$.ajaxFileUpload
	    (
	        {
	            url:'uploadPicture',//用于文件上传的服务器端请求地址
	            secureuri:false,//一般设置为false
	            fileElementId:'file',//文件上传空间的id属性  <input type="file" id="file" name="file" />
	            dataType: 'json',//返回值类型 一般设置为json
	            success: function (data)  //服务器成功响应处理函数
	            {    
					$("#logo").attr("src",data.visitPrictureUrl);
					$("#productBrandLogoimage").val(data.visitPrictureUrlForSave);
					
	            },
	            error: function (data, status, e)//服务器响应失败处理函数
	            {
	                alert(e);
	            }
	        }
	    );
	}
	
}
function checkPic() {
    var picPath = document.getElementById("file").value;
    var type = picPath.substring(picPath.lastIndexOf(".") + 1, picPath.length).toLowerCase();
    if (type != "jpg" && type != "bmp" && type != "gif" && type != "png") {
        alert("请上传正确的图片格式");
        return false;
    }
    return true;
}


function savedata(){
	
	var path=$("#productBrandLogoimage").val();
	if(path==""){
		alert("请选择logo 图片！"); return false;
	}
	

	var name=$("#product_brand_name").val();
	if(name==""){
		alert("请填写品牌名称！"); return false;
	}
	
	var brand_order=$("#brand_order").val();
	if(brand_order==""){
		alert("请填写品牌排序！"); return false;
	}
	
	var cid = $("#classIds").val(); 
	if(cid==''){
		alert("请选择分类！");return ;
	}
	
	  $.ajax({
		  url: "save",
          type: "POST",
          dataType: "json",
          data: $('#brand_add').serialize(),
          success: function (data) {
        	 alert(data.message);
             if(data.code==200){
            	 parent.location.reload();
            	 closewin();
             }
             
          },
          error: function(data) {
              alert("error:"+data.responseText);
           }
      });
	
}
function deletebutton(a){
	$(a).remove();
}

$(function(){
	$('.btn2-click').click(function(){
		//iframe层
		layer.open({
		    type: 2,
		    title: '选择分类',
		    shadeClose: true,
		    shade: 0.8,
			maxmin: true, //开启最大化最小化按钮
		    area: ['800px', '450px'],
		    content: 'selectClass' //iframe的url
		}); 
	});
	$('#brand_add').bootstrapValidator();
});