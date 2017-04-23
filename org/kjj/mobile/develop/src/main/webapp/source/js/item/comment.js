$.fn.raty.defaults.path=$("#imgBase").val();
$(function(){
	//商品评分
	$(".raty").raty({   
	  score: function() {
		    return $(this).attr('data-score');
		  },
	  readOnly: 'true'			  
	});
	
});