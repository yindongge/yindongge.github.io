$(function() {
	$('.tab1 .tdfirst').click(function() {
		$(this).parent('.tab1').nextUntil('.tab1').toggle();
	});
	$('.taball .tdfirst').click(function() {
		$(this).parent('.taball').nextUntil('.taball').toggle();
		$(this).parent('.taball').siblings('.tab2').hide();

	});
});
function AutoAlert(str) {
	$('body').append("<div class='fixed'>" + str + "</div>");
	$(".fixed").fadeIn();
	setTimeout(function() {
		$('.fixed').remove();
	}, 1500);
};