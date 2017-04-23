﻿;(function($){
	var _allClick=
	{
		init:function(){
			this.changeBg();
			this.addOn();
			this.slideFree();
			this.changehelpBg();
		},
		changeBg:function(){
			var bgBox=["#FA436A","#21D59B","#FFB441","#FF5E29","#30C7FF"];
			var n=0;
			$('.sidebar a').not(".sidebar.help a").click(function(e){
				//var $this=$(this);
				$(this).siblings().removeClass('on');
				n=$('.sidebar a').index(this);
				$(this).addClass('on')
				.css({
					"background":bgBox[n]
				})
				.siblings()
				.removeAttr('style');
				e.preventDefault();
			});
		},
		changehelpBg:function(){
			var bgBox=["#49c5ff","#ff5151","#2ddea2","#ff9a40"];
			var n=0;
			$('.sidebar.help a').click(function(e){
				//var $this=$(this);
				$(this).siblings().removeClass('on');
				n=$('.sidebar a').index(this);
				$(this).addClass('on')
				.css({
					"background":bgBox[n]
				})
				.siblings()
				.removeAttr('style');
				e.preventDefault();
			});
		},
		addOn:function(){
			// $('.future_title a').click(function(e){
			// 	$(this).addClass('on').siblings().removeClass('on');
			// 	e.preventDefault();
			// });
		},
		slideFree:function(){
			var timer=null;
			var index=0;
			var len=$('.img_box li').length;
			for(var i=0;i<len;i++)
			{
				var addSpan="<span></span>";
				$('.mod').append(addSpan);
			}
			// 增加
			$('.mod span').first().addClass('on');
			$('.out').hover(function(){
				clearInterval(timer);
			},function(){
				timer=setInterval(function(){
					Move(index);
					index++;
					if(index>=len)
					{
						index=0;
					}
				},3000);
			}).trigger('mouseleave');
			//hover
			$('.mod span').click(function(){
				var index=$(this).index();
				Move(index);
			});
			// $('.next').click(function(){
			// 	index++;
			// 	if(index>=len){
			// 		index=0;
			// 	}
			// 	Move(index);
			// });
			// $('.prev').click(function(){

			// 	index--;
			// 	if(index==-1)
			// 	{
			// 		index=len-1;
			// 	}
			// 	Move(index);
			// });
			function Move(index){
				$('.mod span').eq(index).addClass('on').siblings().removeClass('on');
				$('.img_box li').eq(index).fadeIn().siblings().hide();
			}//move
		},
	};//give
	_allClick.init();
})(jQuery);
