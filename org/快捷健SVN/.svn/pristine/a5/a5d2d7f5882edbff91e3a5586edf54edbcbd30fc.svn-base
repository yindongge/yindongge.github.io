function move() {
	h = $(window).height() / 50;
	t = $(document).scrollTop();
	if (t > h) {
		$('.gotop').show();
	} else {
		$('.gotop').hide();
	}
};

$(window).scroll(function(e) {
	move();

	$('.gotop').click(function(e) {
		$(document).scrollTop(0);
	});
});

function autoAlert(str) {
	$('body').append("<div class=' shakeme'>" + str + "</div>");
	$('.shakeme').animate({
		top : "40%",
		opacity : 1
	}, 800);
	setTimeout(function() {
		$('.shakeme').remove();
	}, 1500);
};