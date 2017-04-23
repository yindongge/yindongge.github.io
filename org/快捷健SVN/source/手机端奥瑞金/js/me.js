// 
$(function(){


		move();
		togglelist();
		togglelist2();
		togglelist3();

})
				

	function move(){
	h = $(window).height()/50;
	t = $(document).scrollTop();
	if(t > h)
		{
			$('.gotop').show();
		}
	else
		{
			$('.gotop').hide();
		}
	}

	$(window).scroll(function(e){
		move();	
	
	$('.gotop').click(function(e){
		$(document).scrollTop(0);	
	})
});
	function togglelist(){
		$('.toggleup').click(function(){
			$(this).parent('.buff').siblings(".toggledown").toggle();
		})
	}
	function togglelist2(){
		$('.t1').click(function(){
			$(".t2").toggle();
			$(this).toggleClass('transform')
		})
	}

	function togglelist3(){
		$(".z-title").click(function(){
			$(this).next('.zhedie').toggle();
		})
	}