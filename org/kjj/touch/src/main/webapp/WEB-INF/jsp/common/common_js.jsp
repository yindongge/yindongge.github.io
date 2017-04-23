<script src="${jsBase}/common/awardRotate.js" type="text/javascript"></script>
<script src="${jsBase}/common/base.js" type="text/javascript"></script>
<script src="${jsBase}/common/jquery.qrcode.min.js" type="text/javascript"></script>
<script src="${jsBase}/common/swiper.min.js" type="text/javascript"></script>
<script src="${jsBase}/common/tab.js" type="text/javascript"></script>
<script src="${jsBase}/common/wap-help.js" type="text/javascript"></script>
<script src="${jsBase}/common/validate.js" type="text/javascript"></script>

<script  type="text/javascript">
$(function(){
// 	$('body').on('contextmenu',returnFun);
// 	$('body').on('dragstart',returnFun);
	$('body').on('beforecopy',returnFun);
	$('body').on('select',returnFun);
	$('body').on('copy',returnFun);
// 	$('body').on('mouseup',returnFun);
	function returnFun(){
		return false;
	};
});
</script>