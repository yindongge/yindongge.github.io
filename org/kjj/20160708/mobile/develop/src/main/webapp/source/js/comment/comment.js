
/**
 * 商品评价
 */

$.fn.raty.defaults.path=$("#imgBase").val();
$(function(){
	
	//展开评分
	$('.toggleup').click(function() {
		$(this).parent('.buff').siblings(".toggledown").toggle();
	});
	
	//商品评价提交
	$(".toggle_btn .yellow-submit").on("click",function(){		
		var starScore = "";
		var goodsComment = "";
		var starScoreText =$(this).parent().parent().find(".raty :hidden").val();
		var orderGoodsId = $(this).parent().parent().find("[name='orderGoodsId']").val(); 
		var goodsCommentText = $(this).parent().parent().find("[name='goodsComment']").val();
		//评分验证
		if(starScoreText==''||starScoreText==undefined){
			alert("请点击评分");
			return false;
		}else{
			starScore=starScoreText;
		}
		//评价验证，去掉评价空格回车换行
		var goodsCommentTextReg=goodsCommentText.replace(/\ +/g,"").replace(/[\r\n]/g,""); 
		if(goodsCommentTextReg == ""){
			alert("请填写商品评价");
			return false;
		}else{
			goodsComment = goodsCommentText;
		}
		location.href="../comment/add?orderGoodsId="+orderGoodsId+"&starScore="+starScore+"&goodsComment="+goodsComment;	
		
	});
	
	//商品评分
	$(".raty").raty({   
	  score: function() {
		    return $(this).attr('data-score');
		  },
	  readOnly: function() {
			  if($("[name='commentStatus']").val()==1){
				  return 'true';			  
			  }
		  }  
	});
	
});