// JavaScript Document
$(function(){
	$('.zhuce').click(function(){
			$('#loading-mask').show()
		$('.mask').slideDown();
		$('.zhezhao').show();
		/*$('body').addClass('hidebody')*/
	})
	$('.mask a').click(function(e){
		e.stopPropagation();//阻止冒泡
		$('.mask').slideUp();
		$('.zhezhao').hide();
		/*$('body').removeClass('hidebody')*/
	})
})

$(function(){
	$('.denglu').click(function(){
		$('.login').slideDown();
		$('.zhezhao').show();
		
	})
	$('.login a').click(function(e){
		e.stopPropagation();//阻止冒泡
		$('.login').slideUp();
		$('.zhezhao').hide();
	
	})
})
//slect
$(function(){
	var x=$(' .tab_menu ul li')
	$('.tab-1').eq(0).css({display:'block'})
  x.click(function(){
	 	  $(this).addClass('selected').siblings().removeClass();
		  var index=x.index(this);
		  $('.tab_box > div').eq(index).show().siblings().hide()  

	  })//
	  x.hover(function(){
			$(this).addClass("hover");
		},function(){
			$(this).removeClass("hover");
		})
	})
/*$(function(){
	$(' .more-youhui a').click(function(){
		$('.all-jifen').slideDown();
		$('.zhezhao').show();
		
		
	})
	$('.all-jifen a').click(function(e){
		e.stopPropagation();//阻止冒泡
		$('.all-jifen').slideUp();
		$('.zhezhao').hide();
	})
})

$(function(){
	$(' .more-youhui2 a').click(function(){
		$('.all-jifen2').slideDown();
		$('.zhezhao').show();
		
	})
	$('.all-jifen2 a').click(function(e){
		e.stopPropagation();//阻止冒泡
		$('.all-jifen2').slideUp();
		$('.zhezhao').hide();
	})
})*/

//放大
