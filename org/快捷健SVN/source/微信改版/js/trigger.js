//trigger
(function($){
	var triggerAll={
		triggerBox:function()
		{
			//出现浮动层
			$(".pa-r a").click(function(){
				$(".trigger-box").show();
				$('body').css("overflow","hidden");
			});
			//关闭浮动
			$(".control-close .close").click(function(){
				$(".trigger-box").hide();
			});
			//数字显示隐藏
			$(".xiaq_tb").click(function(){
				$(".numb_box").slideUp(500);
			});
			$(".mm_box").click(function(){
				$(".numb_box").slideDown(500);
			});

			var  i=0;
			$('.nub_ggg li a').click(function(){
				i++;
				if(i<6){
					$('.mm_box li').eq(i-1).addClass('mmdd');
				}
				else{
					$('.mm_box li:last-child').addClass('mmdd');
					setTimeout(function(){
						location.href="#";
					},500);
				}
			});
			$('.nub_ggg .del').click(function(){
				if(i>0)
				{
					i--;
					$('.mm_box li').eq(i).removeClass('mmdd');
				}
				if(i===0)
				{
					return false;
				}
			});

		},//end
	};//

 	triggerAll.triggerBox();

})(jQuery);