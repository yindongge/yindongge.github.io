
;(function($){
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
			this.htmlTop();
			this.helpClassfiy();
		},
		htmlTop:function(){
			$('.side_5').click(function(){
			$('body,html').animate({
				scrollTop:0
			},500);
		});
		},
		helpClassfiy:function(){
				var loadMore=$('span.loadmore');
		var clearClass=$('.remove_control_addclass');
		var hoverClass=$('.classfiy_second ');
		var proItemHover=$('.pro_list_item');
		var proItemHoverNone=$('.pro_list_item.none');
		loadMore.click(function(){
			$(this).parents(".pro_c_floor").toggleClass('all_floor_control');
			$('.floor_center_block').scrollTop(0);
		});
		$(".floor_center_inline a").click(function(){
			return false;
		});
		clearClass.click(function(e){
			$(this).parents('.pro_c_floor').removeClass('all_floor_control');
			e.preventDefault();
		});
		var clickSlecta=$(".floor_center_inline a i");
		clickSlecta.click(function(e){
			 $(this).toggleClass('duigou');
			e.preventDefault();
		});
		hoverClass.hover(function(){
			$(this).toggleClass('active');
		});
		// proItemHover.hover(function(){
		// 	$(this).addClass('on');
		// 	$(this).find(".toggle_div_pro").stop().animate({
		// 		bottom:0,
		// 	}, "fast");
		// },function(){
		// 	$(this).find(".toggle_div_pro").animate({
		// 		bottom:"-91px",
		// 	}, "fast");
		// 	$(this).removeClass('on');
		// });
		proItemHoverNone.hover(function(){
			$(this).addClass('no');
			$('.none_mask').show();
		},function(){
			$('.none_mask').hide();
			$(this).removeClass('no');
		});
		$('.pro_c_sort a').click(function(e){
			$(this).addClass('cur').siblings("a").removeClass('cur');
			// e.stopPropagation();
		});
		$('.pro_c_sort').on("click","a.cur",function(e){
			if(!$('.pro_c_sort em').hasClass('turnup'))
			{
				$(this).find("em").addClass('turnup').removeClass('turndown');
			}
			else{
				$(this).find("em").removeClass('turnup').addClass('turndown');
			}
			e.stopPropagation();
		});
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
			$('.all').on("mouseover",".change_item",function(){
				$(this).find(".change_hover").addClass('on');
			});
			$('.all').on("mouseenter",".change_item",function(){
				$(this).find('.change_hover').addClass('on');
			});

			$('.all').on("mouseleave",".change_item",function(){
				$(this).find(".change_hover").removeClass('on');
			});
			// $('.change_item').hover(function(){
			// 	$(this).find('.change_hover').toggleClass('on');
			// });

			$('.all').on("mouseleave",".change_item",function(){
				$(this).find('.change_hover').removeClass('on');
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
		},
		};
	_allClick.init();
})(jQuery);