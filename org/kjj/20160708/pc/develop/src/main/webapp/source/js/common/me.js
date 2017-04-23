
(function($){
	var _allClick={
		init:function(){
			this.zhedie();
			this.yema();
			this.togglealert();
			this.initslide();
			this.switchREgiser();
			this.huadong1();
			this.addon();
			this.dropdownOpen();
			this.mask();
			this.toggleOn();
			this.indexslide();
		},
		toggleOn:function(){
			$('.l-car-left .circle').click(function(){
				$(this).parents('.lunch-shopcar').toggleClass('on');
 			});
 			$('.fixed_span').click(function(){
 				var fixC=('.fixed_content');
 				$('<span class="zhegai"></span>').appendTo('.fixed_div ');
 				$(this).toggleClass('hover').parent(fixC).toggleClass('on');
 				if(!$(fixC).hasClass('on')){
 					$('.zhegai').remove();
 				}
 			});
		},
		zhedie:function(){
			$('.main li').hover(function(){
				$(this).addClass('on').siblings().removeClass('on');
			});
			$(".fade_toggleone").hover(function(){
				$('.fade_toggle').show();
			},function(){
				$('.fade_toggle').hide();
			});
		},
		yema:function(){
			$(".morea").hover(function(){
				$(this).parent('.panel-heading').toggleClass('on');
			});
		},
		togglealert:function(){
			$('.area-second ').click(function(){
				$('.areabody2').toggle();
			});
		},
		initslide:function(){
			$('.showmenu').hover(function(){
				$(this).find('.hidemenu').show();

			},function(){
				$(".hidemenu").hide();
			});
			$('.slideme ').hover(function(){
				$(this).find('.all-sort-list').show();
			},function(){
				$(".all-sort-list").hide();
			});
		},
		switchREgiser:function(){
			$('.switch-button a').click(function(){
				var index=$('.switch-button a').index(this);
				$(this).addClass('active').siblings().removeClass('active');
				$('.switch-item').eq(index).show().siblings().hide();
			});
		},
		huadong1:function(){
			$('.but li').eq(0).addClass('hover');
			$('.but li').click(function(){
				$(this).addClass('hover').siblings().removeClass('hover')	;
				var index=$('.but li').index(this);
				$('.slect').eq(index).show().siblings('.slect').hide();//这里后期修改的，注意，是在siblings添加的选择器
			});
		},
		addon:function(){
			$('.spec-scroll .items img').hover(function(){
				$(this).addClass('on');
				$(this).parent('li').siblings().find('img').removeClass('on');
			});
		},
		dropdownOpen:function(){
		    var $dropdownLi = $('li.dropdown');
		    $dropdownLi.mouseover(function() {
		        $(this).addClass('open');
		    }).mouseout(function() {
		        $(this).removeClass('open');
		    });
		},
		mask:function(){
			$('.deleteme').click(function(){
				$('.mask').show();
				$('.into').show();
			});
		},
		indexslide:function(){
			$(".item").hover(function(){
			$(this).addClass('hover');
			$(this).find(".item-list").show();
			},function(){
				$(this).removeClass('hover');
				$(this).find(".item-list").hide();
			});
		}
		};
	_allClick.init();
})(jQuery);
