$(function () {
	$(':text,:password').bind('focus',function(){
        $('.footerbar').hide();
     }).bind('blur',function(){
         $('.footerbar').css({'position':'fixed','bottom':'0'});
         $('.footerbar').show();
     });
});