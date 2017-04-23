$(function() {  
    $('#add').click(function() {
        // select this once into a variable to minimize re-selecting
        var $menus = $('#rightselect');

        // clone all selected items
        var $items = $.grep($('#leftselect option:selected').clone(), function(v){
            // if the item does not exist return true which includes it in the new array
            return $menus.find("option[value='" + $(v).val() + "']").length == 0;

        });

        // append the collection to the destination list
        $menus.append($items);
         
        //part II sort.
        var $options = $menus.find('option'); // get all options
        $options = $options.sort(function(a,b){ // sort by value of options
            return a.value - b.value;
        });
        $menus.html($options); // add new sorted options to select
         
        return false;
    });
     
    $('#remove').click(function() {  
        return !$('#rightselect option:selected').remove();  
    });
     
    //automatically select all the menus in right side when submit form.
    $('#inputForm').submit(function(){
        $('#rightselect option').each(function(i) {  
                 $(this).attr("selected", "selected");  
           });  
    });
});


function changeSelect(){
	var selectid = $("#classLevel").val();
	
	if(selectid==0){
		$("#classlist").empty();
		$("#classlist").append("<option value='0'>所有分类</option>");
		return;
	}
	
	    $.ajax({  
	        type: "post",  
	        url: "${ctx}/product/classify/get/"+selectid,  
	        success: function(data) {  
	            var list =eval(data);
	    		var ls = list[0]["list"];
	       		$("#classlist").empty();
	            for(var i=0; i< ls.length;i++){
	            	$("#classlist").append('<option value="'+ls[i].class_id+'">'+ls[i].class_name+'</option>');
	            }
	        },  
	        error: function(data) {  
	            alert(data);  
	        }  
	    })  ;

	
}
function editbrand(a){
	layer.open({
		type: 2,
		title: '编辑品牌',
		shadeClose: true,
		shade: 0.8,
		maxmin: true, //开启最大化最小化按钮
		area: ['800px', '650px'],
	    content: '${ctx}/product/brand/edit/'+a
	});
}
function delbrand(a){
	$.ajax({  
        type: "post",  
        url: "${ctx}/product/brand/del/"+a,  
        success: function(data) {  
           location.reload();
        },  
        error: function(data) {  
            alert(data);  
        }  
    })  ;

}

function search(){

	var classdata = $("#classlist").val();
	var brand=$("#brand").val();
	var name=$("#s_text").val();
	
	$.ajax({  
        type: "post",  
        url: "${ctx}/product/search",  
        data:"class="+classdata+"&brand="+brand+"&name="+name,
        dataType:'json',
        success: function(data) {  
        	if(data[0].code==200){
           		$("#leftselect").empty();
        		var list = data[0].list;
        		
        		var htmlstr="";
        		
        		 $(list).each(function(index) {
                     var val = list[index];
                     htmlstr+="<option value='"+val.goods_id+"'>["+val.goods_sn+"] "+val.goods_name+" " ;
/*                      if (typeof (val.ls) == "object") {
                    	 
                    	var ls_ = val.ls;
                         $(ls_).each(function(ind) {
                         var val_=ls_[ind];
                         htmlstr+=val_.spec_value+ " ";
                         });
                     }  */
                     
                     htmlstr+="</option>";
                 });
        		 $("#leftselect").append(htmlstr);
            }else{
            	alert("服务器错误！");
            }
        },  
        error: function(data) {  
            alert(data);  
        }  
    })  ;
}

function save(){
	//获取所有关联id
	var ids=[];
	 $("#rightselect option").each(function() { 
		 ids.push($(this).val());
	 }); 
	 
	 $.ajax({  
	        type: "post",  
	        url: "${ctx}/product/saverelative",
	        data:{idsArr : ids},
	        dataType:"json",
	        success: function(data) {  
	           if(data.code==200){
	        	   alert("保存成功！");
	           }
	       		
	        },  
	        error: function(data) {  
	            alert(data);  
	        }  
	    })  ;
	 
}