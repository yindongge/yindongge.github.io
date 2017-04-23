
$(function () {
    KindEditor.ready(function(K) {
   	 K.create('#content', {  
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
    
    var temp=/^\d+(\.\d+)?$/;
   
    $("#order").keyup(function(){
    	var val = $("#order").val();
		if(temp.test(val)==false){
			$("#order").val(255);
		}else{
			if(val<1){
				$("#order").val(1);
			}
			if(val>255){
				$("#order").val(255);
			}
		}
    });
    
	
	new uploadPreview({ UpBtn: "file", DivShow: "div_1", ImgShow: "showimg_1" });
	
	$.ajax({
        url:"../getshop",
        type:'POST',
        cache:false,
        dataType:"json",
        success:function(data){
            if(data.code == 200){
             	var htmlStr="";
            	 $.each(data.listArea,function(index,d){
            		 
            		 htmlStr+="<dl class=\"floor\">";
            		 htmlStr+="<dt>"+d.name+":</dt>";
            		 htmlStr+="<dd class=\"f-special3\">";
            		 $.each(d.listShop,function(i,s){
            			 htmlStr+=" <div class=\"fty\"><input type=\"checkbox\" checked value=\""+s.shopId+"\"><label>"+s.shopName+"</label></div>";
            		 });
            		 htmlStr+="</dd>";    
            		 htmlStr+="</dl>";   
            	});
            	htmlStr+="<p class=\"text-center buttonme\"><button type=\"button\" class=\"btn btn-default\" onclick=\"cancle()\">取消</button><button class=\"btn btn-danger\" onclick=\"confirmshop()\">确定</button></p>";
            	 $(".content").append(htmlStr);
            }else{
            	alert("请先创建门店");
            }
        }
    });
	
	
});

function cancle(){
	$(".maskme").hide();
	$(".alertme").hide();
}
function showWin(){
	
	if($(".content").children().length>0){
		$(".maskme").show();
		$(".alertme").show();
		
		return;
	}else{
		$(".content").empty();
		$(".maskme").show();
		$(".alertme").show();
	}
	
	
	$.ajax({
        url:"../getshop",
        type:'POST',
        cache:false,
        dataType:"json",
        success:function(data){
        
            if(data.code == 200){
            	 var ids= new Array();   
            	 ids = $("#shops").val().split(",");
             	var htmlStr="";
            	 $.each(data[0].list,function(index,d){
            		 
            		 htmlStr+="<dl class=\"floor\">";
            		 htmlStr+="<dt>"+d.name+":</dt>";
            		 htmlStr+="<dd class=\"f-special3\">";
            		   
            		 $.each(d.lsShop,function(i,s){
            			 
            			var flag= false;
            			for(var j=0;j<ids.length;j++){
            				if(ids[j]==s.shop_id){
            					flag=true;
            				}
            			}
            			 
            			if(flag){
            				 htmlStr+=" <div class=\"fty\"><input type=\"checkbox\" checked value=\""+s.shop_id+"\"><label>"+s.shop_name+"</label></div>";
            			}else{
            				 htmlStr+=" <div class=\"fty\"><input type=\"checkbox\" value=\""+s.shop_id+"\"><label>"+s.shop_name+"</label></div>";
            			}
            			
            		 });
            		 htmlStr+="</dd>";    
            		 htmlStr+="</dl>";   
            	});
            	htmlStr+="<p class=\"text-center buttonme\"><button type=\"button\" class=\"btn btn-default\" onclick=\"cancle()\">取消</button><button class=\"btn btn-danger\" onclick=\"confirmshop()\">确定</button></p>";
            	 $(".content").append(htmlStr);
            }else{
              
            	alert("请先创建门店");
            	
            }
        }
    });
	
}
function confirmshop(){
	
	var str="";
	var ids="";
	$(".content input[type=checkbox]:checked").each(function(){ 
	    str+=$(this).next().text()+",";
	    ids+=$(this).val()+",";
	});
	
	$("#show").text(str);
	$("#shops").val(ids);
	
	 cancle();
}

function savearticle(){

	var title =$("#title").val();
	if(title.length<2||title.length>10){
		alert("标题长度应该在2-10 之间"); return false;
	}
	
	//获取门店
	var shops = $("#shops").val();
	if(shops.length==0){
		alert("请选择门店"); return false;
	}
	
	
	$("#form").ajaxSubmit({
        type:'post',
        url:'../save',
        dataType: "json",
        success:function(data){
        	location.href="../list";
        },
        error:function(XmlHttpRequest,textStatus,errorThrown){
        	location.href="../list";
        }
    });
}
