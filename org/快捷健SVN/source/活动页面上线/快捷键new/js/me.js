// add


$(document).ready(function(){
    $(document).off('click.bs.dropdown.data-api');
    initslide();
    addon();
    zhedie();
    huadong1();
    dropdownOpen();
    indexslide();
    mask();
    yema();
    togglealert();
    //调用
  
});
/**
 * 鼠标划过就展开子菜单，免得需要点击才能展开
 */
 function huadong1(){
	$('.but li').eq(0).addClass('hover');
		$('.but li').click(function(){
			$(this).addClass('hover').siblings().removeClass('hover')	;
			var index=$('.but li').index(this);
			$('.slect').eq(index).show().siblings('.slect').hide();//这里后期修改的，注意，是在siblings添加的选择器
			
		})
 }
function indexslide(){
$(".item").hover(function(){
			$(this).addClass('hover');
			$(this).find(".item-list").show();
		},function(){
			$(this).removeClass('hover');
			$(this).find(".item-list").hide();
		})
}
 function addon(){
 	$('.spec-scroll .items img').hover(function(){
			$(this).addClass('on');
			$(this).parent('li').siblings().find('img').removeClass('on')
		})
 }

function dropdownOpen() {

    var $dropdownLi = $('li.dropdown');

    $dropdownLi.mouseover(function() {
        $(this).addClass('open');
    }).mouseout(function() {
        $(this).removeClass('open');
    });
}

function initslide(){
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


}
function zhedie(){
	$('.main li').hover(function(){
			$(this).addClass('on').siblings().removeClass('on');
		
		})
}
function mask(){
	$('.deleteme').click(function(){
		$('.mask').show();
		$('.into').show();
	})
}
function yema(){
	$(".morea").hover(function(){
		$(this).parent('.panel-heading').toggleClass('on');
	})
}
function togglealert(){
		$('.area-second ').click(function(){
			$('.areabody2').toggle();
		})
}