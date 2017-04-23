function deleteclass(a){
	$.ajax({
        url:"${ctx}/product/classify/delete",
        type:'POST',
        data:{'classid':a},
        cache:false,
        dataType:"json",
        success:function(data){
        
            if(data[0].code == "200"){
              location.reload(); 
            }else{
              
            }
        }
    });
} 

function changeSelect1(){	
	var selectid = $('#class_1').val();	
    $.ajax({  
        type: 'post',  
        url: '../class/getClassesByParent/'+selectid,   
        dataType:'json',
        success: function(data) {  
            var list =data;
       		var str = '';
            for(var i=0; i< list.length;i++){
            	str += '<option value="'+list[i].classId+'">'+list[i].className+'</option>';
            }
            $('#class_2').empty();
            $('#class_2').append(str);
        },  
        error: function(data) {  
            alert(data);  
        }  
    });
}

function changeSelect2(){
	var selectid = $('#class_2').val();
    $.ajax({  
        type: 'post',  
        url: '../class/getClassesByParent/'+selectid,
        dataType: 'json',
        success: function(data) {  
            var list = data;
       		var str = '';
            for(var i=0; i< list.length;i++){
            	str += '<option value="'+list[i].classId+'">'+list[i].className+'</option>';
            }
            $('#class_3').empty();
            $('#class_3').append(str);
        },  
        error: function(data) {  
            alert(data);  
        }  
    });
}

function addtousual(){
	var selectid=$("#class_3").val();
	if(selectid==null){
	 	selectid = $("#class_2").val();
		if(selectid == null){
			return;
		}
	}
	var str = $("#showtext").text();
	    $.ajax({  
	        type: "post",  
	        url: "${ctx}/product/classify/usual/"+selectid,  
	        data:"class_1="+str,
	        success: function(data) {  
	          alert("添加成功！");
	        },  
	        error: function(data) {  
	            alert(data);  
	        }  
	    })  ;

	
}
function classonselect(){
	$("#showtext").text("");
	var str_1 =$("#class_1").find("option:selected").text(); 
	var str_2=$("#class_2").find("option:selected").text(); 
	var str_3=$("#class_3").find("option:selected").text(); 
	var str="";
	if(str_1!=""){
		str+=str_1+">";
	}
	if(str_2!=""){
		str+=str_2+">";
	}
	if(str_3!=""){
		str+=str_3+"";
	}
	$("#showtext").text(str);
}

function setclass(){
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	var class_3="";
	var class_1="";
	if($("#class_3").val()!=null){
		class_3=$("#class_3").val();
		class_1=$("#showtext").text();
	}else if($("#class_2").val()!=null){
		class_3=$("#class_2").val();
		class_1=$("#showtext").text();
	}else if($("#class_usual").val()!=""){	
		class_3=$("#class_usual").val();
		class_1=$("#class_usual").find("option:selected").text(); 
	}else{
		alert("请选择分类！");
		return false;
	}
	parent.setSubClass(class_1,class_3);
	parent.layer.close(index);
}
function changeusual(){	
	if($("#class_usual").val()!=""){
		$("#showtext").text($("#class_usual").find("option:selected").text());
	}
}

function closewin(){
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.close(index);
}
