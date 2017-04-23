<script type="text/javascript" src="${jsBase}/SoftKey/vk_loader.js?vk_layout=CN%20Chinese%20Simpl.%20Pinyin&vk_skin=flat_gray" ></script>
<!-- <script type="text/javascript" src="${jsBase}/SoftKey/virtualkeyboard.full.js" ></script> -->
<!-- <script type="text/javascript" src="${jsBase}/SoftKey/virtualkeyboard.js" ></script> -->
<script type="text/javascript">
function keyboard(){
	VirtualKeyboard.toggle('keyword', 'softkey');
	$("#kb_langselector,#kb_mappingselector,#copyrights").css("display", "none");
}
$(function(){
	$("#keyword").parent().append('<div id="softkey" style="position:absolute;top:75%;left:-60px;width:100%;z-index:2;"></div>');
	$("#keyword").attr('onfocus','keyboard();');
	$("#keyword").attr('onblur',"VirtualKeyboard.toggle('keyword','softkey');");
});
</script>