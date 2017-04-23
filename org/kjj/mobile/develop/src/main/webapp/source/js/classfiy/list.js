$(function(){
	$('.category_left').css({"height":window.innerHeight-94});
	$('.category_right').css({"height":'auto'});
	
	$(".classOne").click(function(){
		$(".active").removeClass("active");
		$(this).addClass("active");
		$("h3").text($(this).text());
 		$.ajax({  
	        type: "post", 
	        dataType: "json",
	        url: "../classfiy/getByParentId",
	        data: {'parentId':$(".active").attr("data-class-id")},
	        success: function(data) {
	        	if(data.code==200){
	        		var strHtml = "";
	        		/*$.each(data.listClassLevelTwo,function(idx, obj){
	        			strHtml += "<div class=\"product_item col3\">";
	        			strHtml += "<a href=\"../search/result?superClassId="+obj.classId+"\">";
	        			strHtml += "<div class=\"pic_box\">";
	        			strHtml += "<img src=\"../source/images/2.jpg\" alt=\""+obj.className+"\">";
	        			strHtml += "</div><div class=\"title_box center\">";
	        			strHtml += "<h5>"+obj.className+"</h5>";
	        			strHtml += "</div></a></div>";
	                });
	        		$(".category_product").html(strHtml);*/
	        		$.each(data.listClassLevelTwo,function(idx, obj){
	        			strHtml += "<a href=\"../search/result?superClassId="+obj.classId+"\">";
	        			strHtml += obj.className;
	        			strHtml += "</a>";
	        		});
	        		$(".contentul").html(strHtml);
	        	}
	        },  
	        error: function(data) {  
	        }  
	    })  ;  
	});
});