// JavaScript Document

$(function(){
	$('.but li').eq(0).addClass('hover');
	$('.but li').hover(function(){
		$(this).addClass('hover').siblings().removeClass('hover')	;
		var index=$('.but li').index(this);
		$('.slect').eq(index).show().siblings('.slect').hide();//这里后期修改的，注意，是在siblings添加的选择器
		
	})
})

$(function(){
	$('.tab li').eq(0).addClass('focus');
	$('.tab li').click(function(){
		$(this).addClass('focus').siblings().removeClass('focus')	;
		var index=$('.tab li').index(this);
		$('.on').eq(index).show().siblings('.on').hide();//这里后期修改的，注意，是在siblings添加的选择器
		
	})
})

$(function(){
	$('.member-l li').eq(0).addClass('focus');
	$('.member-l li').click(function(){
		$(this).addClass('focus').siblings().removeClass('focus')	;
		var index=$('.member-l li').index(this);
		$('.scroll').eq(index).show().siblings('.scroll').hide();//这里后期修改的，注意，是在siblings添加的选择器
		
	})
})




	window.onload=function(){

	$('.nav-sec li').hover(function(){

		$(this).find('.hide').show();
	},function(){
		$(this).find('.hide').hide();
			
	
		
	})	
	}


/*icon*/
$(function(){
	$(window).scroll(function(){
			var top=$(window).scrollTop();
			var menu=$('#menu');
			var item=$('#listall').find('.list')
			var currentId=''//当前所在楼层的ID
			item.each(function(){
				//var $this=$(this);
				var itemTop=$(this).offset().top;
			if(top > itemTop -300 )
			{
				currentId='#'+$(this).attr('id');
			}
			else
			{
				return false//跳出each这个事件	
			}
			})
			
			var currentlink=menu.find('.current');
			if(currentId && currentlink.attr('href') !=currentId)
			{
				currentlink.removeClass('current')
				menu.find("[href="+ currentId + "]").addClass('current');
			}
	 	
	})
})


$(function(){
	$('#menu li').hover(function(){
		$(this).find('.icon2').show();
	},function(){
		$(this).find('.icon2').hide();	
	})	
})

$(function(){
	$('.same-ul li').hover(function(){
		$(this).stop().find('.back').show();	
	},function(){
		$(this).stop().find('.back').hide();		
	})	
})